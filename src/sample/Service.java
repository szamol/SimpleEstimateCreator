package sample;

public class Service {

    private String name;
    private int amount, price;
    private int sum;

    public static int laborCost = 0;

    private String unit;

    Service(String name) {
        this.name = name;
    }

    Service(String name, int amount,String unit, int price) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.price = price;
        this.sum = price * amount;
        laborCost += sum;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public int getPrice() {
        return price;
    }

    public int getSum() {
        return sum;
    }
}
