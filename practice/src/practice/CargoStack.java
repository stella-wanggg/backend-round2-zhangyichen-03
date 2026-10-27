package practice;

public class CargoStack {
    Goods goods;
    int quantity;

    public CargoStack() {
    }

    public CargoStack(Goods goods, int quantity) {
        this.goods = goods;
        this.quantity = quantity;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
