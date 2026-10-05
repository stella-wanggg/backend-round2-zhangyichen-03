public class Test {
    public static void main(String[] args) {
        Item i1 = new Item("木板", 64);
        Item i2 = new Item("石头", 64);
        Item i3 = new Item("钻石剑", 1);
        InventoryPlus inventory = new InventoryPlus();
        inventory.display();
        System.out.println("2.---------------------");
        inventory.addItem(new ItemStack(i2, 30));
        inventory.display();
        System.out.println("3.---------------------");
        inventory.addItem(new ItemStack(i2, 40));
        inventory.display();
        System.out.println("4.---------------------");
        inventory.addItem(new ItemStack(i3,1));
        inventory.display();
        System.out.println("6.---------------------");
        inventory.removeitem("石头",10);
        inventory.display();
        System.out.println("5.---------------------");
        int sum = 0;
        for(int i = 0; i < 35; i++) {
            int s = inventory.addItem(new ItemStack(i1, 64));
            if (s >= 0) {
                sum += 1;
            }
        }
        System.out.println("有"+(35-sum)+"组木板溢出了");

    }
}
