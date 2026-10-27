package practice1;

public class Product {
    String name;
    int maxPerSlot;
    int price;

    public Product() {
    }

    public Product(String name, int maxPerSlot, int price) {
        this.name = name;
        this.maxPerSlot = maxPerSlot;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPerSlot() {
        return maxPerSlot;
    }

    public void setMaxPerSlot(int maxPerSlot) {
        this.maxPerSlot = maxPerSlot;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
