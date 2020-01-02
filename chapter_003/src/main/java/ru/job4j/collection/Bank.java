package ru.job4j.collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {
    private final Map<User, List<Account>> bank = new HashMap<User, List<Account>>();

    public void addUser(User user) {
        bank.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        bank.remove(user);
    }

    public Optional<User> getUser(String passport) {
        Optional<User>  user = bank.keySet().stream()
                                            .filter(u -> u.getPassport().equals(passport))
                                            .findFirst();
        return  user;
    }

    public void addAccountToUser(String passport, Account account) {
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            if (bank.get(user.get()) != null) {
                bank.get(user.get()).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            if (!bank.get(user.get()).isEmpty()) {
                bank.get(user.get()).remove(bank.get(user.get()).indexOf(account));
            }
        }
    }

     public List<Account> getUserAccounts(String passport) {
         List<Account> accs = null;
         Optional<User> user = getUser(passport);
         if (user.isPresent()) {
                      if (!bank.get(user.get()).isEmpty()) {
                          accs = bank.get(user.get());
                      } else {
                          accs = new ArrayList<Account>();
                      }
         }
        return accs;
     }

    public Optional<Account> getAcc(String passport, String requisite) {
        Optional<Account> acc = Optional.empty();
        Optional<User> user = getUser(passport);
        if (user.isPresent()) {
            acc =  bank.get(user.get()).stream()
                    .filter(srcAcc -> srcAcc.getRequisites().equals(requisite))
                    .findFirst();
        }
       return  acc;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * Если счёт не найден или не хватает денег на счёте (с которого переводят) должен вернуть false.
     *
     * @param srcPassport  лицо отправитель
     * @param srcRequisite счет отправитель
     * @param destPassport лицо получатель
     * @param destPassport счёта получатель
     * @return Результат выполнения операции.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> from = getAcc(srcPassport, srcRequisite);
        Optional<Account> to = getAcc(destPassport, dstRequisite);
        if (from.isPresent() && to.isPresent()) {
            if (Double.compare(from.get().getValue(), amount) != -1) {
                from.get().setValue(from.get().getValue() - amount);
                to.get().setValue(to.get().getValue() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
