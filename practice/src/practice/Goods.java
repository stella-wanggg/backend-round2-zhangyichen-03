package practice;

public class Goods {
    String name;
    int maxStackSize;

    public Goods(){

    }

    public Goods(String name, int maxStackSize) {
        this.name = name;
        this.maxStackSize = maxStackSize;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }
}
