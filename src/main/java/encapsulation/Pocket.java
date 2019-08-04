package encapsulation;

public class Pocket {
    private int money;

    public Pocket(int money) {
        this.money = money;
    }

    public int getMoney() {
        if (money <= 10) {
            return 0;
        }
        return money;
    }

    public void setMoney(int newMoney) {
        if (newMoney < 0) {
            System.out.println("New money shall be >= 0");
            return;
        }
        if (newMoney > 3000) {
            System.out.println("Not enough space in pocket for as much money");
            return;
        }
        money = newMoney;
    }
}
