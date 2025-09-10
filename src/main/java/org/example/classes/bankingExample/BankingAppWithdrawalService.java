package org.example.classes.bankingExample;

public class BankingAppWithdrawalService {

    private WithdrawableAccount withdrawableAccount;

    public BankingAppWithdrawalService(WithdrawableAccount account) {
        this.withdrawableAccount = account;
    }

    public void withdraw(Long money) {
        withdrawableAccount.withdraw(money);
    }
}
