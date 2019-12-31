package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        //List<Account> accs = bank.entrySet().stream().filter(u -> u.getKey().equals(new User(passport))).map(Map.Entry::getValue);
        List<Account> accs = bank.get(new User(passport));
        accs.add(account);
    }
    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
       // List<Account> accs = bank.entrySet().stream().filter(u -> u.getKey().equals(new User(passport))).map(a -> a.getValue()).flatMap(a -> a.stream()).collect(Collectors.toList());
        List<Account> accs = bank.get(new User(passport));
        accs.remove(accs.indexOf(account));
    }
    // получить список счетов для пользователя.
     public List<Account> getUserAccounts(String passport) {
        /* List<Account> accs = new ArrayList<Account>();
         for (Account acc : bank.get(new User(passport))) {
             accs.add(acc);
         }*/
         List<Account> accs = bank.entrySet().stream().filter(u -> u.getKey().equals(new User(passport))).map(a -> a.getValue()).flatMap(a -> a.stream()).collect(Collectors.toList());

        return accs;
     }
    // метод для перечисления денег с одного счёта на другой счёт:
    // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        AtomicBoolean result = new AtomicBoolean(false);
        bank.entrySet().stream().filter(u -> u.getKey().equals(new User(srcPassport))).map(a -> a.getValue()).flatMap(l -> l.stream()).filter(srcAcc -> srcAcc.getRequisites().equals(srcRequisite) && Double.compare(srcAcc.getValue(), amount) != -1).forEach(a -> {
            bank.entrySet().stream().filter(u -> u.getKey().equals(new User(destPassport))).map(b -> b.getValue()).flatMap(l -> l.stream()).filter(dstAcc -> dstAcc.getRequisites().equals(dstRequisite)).forEach(b -> {
                a.setValue(a.getValue() - amount);
                b.setValue(b.getValue() + amount);
                result.set(true);
            });
        });

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
        return result.get();
    }
}
