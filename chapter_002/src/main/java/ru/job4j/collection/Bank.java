package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Account> accs = bank.get(new User(passport));
        accs.add(account);
    }
    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accs = bank.get(new User(passport));
        accs.remove(accs.indexOf(account));
    }
    // получить список счетов для пользователя.
     public List<Account> getUserAccounts(String passport) {
         List<Account> accs = new ArrayList<Account>();
         for (Account acc : bank.get(new User(passport))) {
             accs.add(acc);
         }
        return accs;
     }
    // метод для перечисления денег с одного счёта на другой счёт:
    // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
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
        }
        return  result;
    }
}
