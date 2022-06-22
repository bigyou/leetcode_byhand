package in.kaixin.leetcode_byhand.other;

public class Bank {
//    https://leetcode-cn.com/problems/simple-bank-system/
    //这题目为什么是中等难度？
    long[] balance = null;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (balance == null || account1 > balance.length || account2 > balance.length) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (balance == null || account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (balance == null || account > balance.length) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
