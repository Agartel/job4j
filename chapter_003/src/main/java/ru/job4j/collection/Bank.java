package ru.job4j.collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Bank {
    private final Map<User, List<Account>> bank = new HashMap<User, List<Account>>();
    // добавление пользователя.
    public void addUser(User user) {
        bank.putIfAbsent(user, new ArrayList<Account>());
    }
    // удаление пользователя.
    public void deleteUser(User user) {
        bank.remove(user);
    }
    // добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        Optional<List<Account>> accs = bank.entrySet().stream().filter(u -> u.getKey().getPassport().equals(passport)).findFirst().map(u -> u.getValue());
        accs.get().add(account);
    }
    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        Optional<List<Account>> accs = bank.entrySet().stream().filter(u -> u.getKey().getPassport().equals(passport)).findFirst().map(u -> u.getValue());
        accs.get().remove(accs.get().indexOf(account));
    }
    // получить список счетов для пользователя.
     public List<Account> getUserAccounts(String passport) {
         List<Account> accs = bank.entrySet().stream().filter(u -> u.getKey().getPassport().equals(passport)).map(a -> a.getValue()).flatMap(a -> a.stream()).collect(Collectors.toList());
        return accs;
     }

    public Optional<Account> indexOf(String passport, String requisite) {
        return bank.entrySet().stream().filter(u -> u.getKey().getPassport().equals(passport)).map(a -> a.getValue()).flatMap(l -> l.stream()).filter(srcAcc -> srcAcc.getRequisites().equals(requisite)).findFirst();
    }
    // метод для перечисления денег с одного счёта на другой счёт:
    // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
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
        /*
        AtomicBoolean result = new AtomicBoolean(false);
        bank.entrySet().stream().filter(u -> u.getKey().equals(new User(srcPassport))).map(a -> a.getValue()).flatMap(l -> l.stream()).filter(srcAcc -> srcAcc.getRequisites().equals(srcRequisite) && Double.compare(srcAcc.getValue(), amount) != -1).forEach(a -> {
            bank.entrySet().stream().filter(u -> u.getKey().equals(new User(destPassport))).map(b -> b.getValue()).flatMap(l -> l.stream()).filter(dstAcc -> dstAcc.getRequisites().equals(dstRequisite)).forEach(b -> {
                a.setValue(a.getValue() - amount);
                b.setValue(b.getValue() + amount);
                result.set(true);
            });
        });
        return result.get();
        */
        /* without streamAPI
        for (Account srcAcc : bank.get(new User(srcPassport))) {
            if (srcAcc.getRequisites().equals(srcRequisite)) {
              if (Double.compare(srcAcc.getValue(), amount) != -1) {
                  for (Account dstAcc : bank.get(new User(destPassport))) {
                      if (dstAcc.getRequisites().equals(dstRequisite)) {
                            srcAcc.setValue(srcAcc.getValue() - amount);
                            dstAcc.setValue(dstAcc.getValue() + amount);
                            result = true;
                            break;
                      }
                  }
              }
              if (!result) {
                  break;
              }
            }
        } */
    }
}
