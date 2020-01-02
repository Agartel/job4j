package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BankTest {
    @Test
    public void addAccToUser() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "231113");
        bank.addUser(user1);
        Account acc1User1 = new Account(25.56, "67");
        bank.addAccountToUser("231113", acc1User1);
        List<Account> accList = bank.getUserAccounts("231113");
        assertThat(accList.get(0).getRequisites(), is("67"));
    }
    @Test
    public void delAccFromUser() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "231113");
        bank.addUser(user1);
        Account acc1User1 = new Account(25.56, "67");
        Account acc2User1 = new Account(13.56, "33");
        bank.addAccountToUser("231113", acc1User1);
        bank.addAccountToUser("231113", acc2User1);
        bank.deleteAccountFromUser("231113", acc1User1);
        List<Account> accList = bank.getUserAccounts("231113");
        assertThat(accList.get(0).getRequisites(), is("33"));
    }
    @Test
    public void whenAdd2AccThenGet2Acc() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "231113");
        bank.addUser(user1);
        Account acc1User1 = new Account(25.56, "67");
        Account acc2User1 = new Account(13.56, "33");
        bank.addAccountToUser("231113", acc1User1);
        bank.addAccountToUser("231113", acc2User1);
        List<Account> accList = bank.getUserAccounts("231113");
        assertThat(accList.size(), is(2));
    }

    @Test
    public void whenCorrectWriteSumToAcc1ThenCreditSumToAcc2() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "231113");
        User user2 = new User("Nadia", "789999");
        bank.addUser(user1);
        bank.addUser(user2);
        double sum1 = 25.56;
        double sum2 = 13;
        double sumTransf = 5.00;
        Account acc1User1 = new Account(sum1, "67");
        Account acc1User2 = new Account(sum2, "33");
        bank.addAccountToUser("231113", acc1User1);
        bank.addAccountToUser("789999", acc1User2);
        boolean res = bank.transferMoney("231113", "67", "789999", "33", sumTransf);
        assertTrue(res);
        assertThat(acc1User1.getValue(), is(sum1 - sumTransf));
        assertThat(acc1User2.getValue(), is(sum2 + sumTransf));
    }

    @Test
    public void whenUnCorrectWriteSumToAcc1ThenCreditSumToAcc2() {
        Bank bank = new Bank();
        User user1 = new User("Alex", "231113");
        User user2 = new User("Nadia", "789999");
        bank.addUser(user1);
        bank.addUser(user2);
        double sum1 = 25.56;
        double sum2 = 13;
        double sumTransf = 26.00;
        Account acc1User1 = new Account(sum1, "67");
        Account acc1User2 = new Account(sum2, "33");
        bank.addAccountToUser("231113", acc1User1);
        bank.addAccountToUser("789999", acc1User2);
        boolean res = bank.transferMoney("231113", "67", "789999", "33", sumTransf);
        assertFalse(res);
        assertThat(acc1User1.getValue(), is(sum1));
        assertThat(acc1User2.getValue(), is(sum2));
    }
}
