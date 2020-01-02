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

    public void addAccountToUser(String passport, Account account) {
        bank.entrySet().stream()
                .filter(u -> u.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .ifPresent(v -> v.add(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        bank.entrySet().stream()
                .filter(u -> u.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .ifPresent(v -> v.remove(v.indexOf(account)));
    }

     public List<Account> getUserAccounts(String passport) {
         List<Account> accs = bank.entrySet().stream()
                                    .filter(u -> u.getKey().getPassport().equals(passport))
                                    .findFirst()
                                    .map(Map.Entry::getValue)
                                    .orElse(new ArrayList<Account>());
        return accs;
     }

    public Optional<Account> indexOf(String passport, String requisite) {
        return bank.entrySet().stream()
                .filter(u -> u.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .get().stream()
                .filter(srcAcc -> srcAcc.getRequisites().equals(requisite))
                .findFirst();
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
        Optional<Account> from = indexOf(srcPassport, srcRequisite);
        Optional<Account> to = indexOf(destPassport, dstRequisite);
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
