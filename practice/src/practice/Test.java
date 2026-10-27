package practice;

public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Goods iron = new Goods("铁矿",64);
        Goods sword = new Goods("钻石剑",1);
        Goods stone = new Goods("原石",64);
        CargoStack stack1 = new CargoStack(iron,20);
        warehouse.addCargo(stack1);
        warehouse.display();
        CargoStack stack2 = new CargoStack(iron,50);
        warehouse.addCargo(stack2);
        warehouse.display();
        CargoStack stack3 = new CargoStack(sword,1);
        warehouse.addCargo(stack3);
        warehouse.display();

        int j =0;
        CargoStack stack4 = new CargoStack(stone,64);
        for(int i =1;i<=25;i++) {
            warehouse.addCargo(stack4);
            if(warehouse.remainingSlots() < 0){
                j+=1;
            }
        }
        warehouse.display();
        System.out.println("有"+j+"组没有成功加入");
        warehouse.removeCargo("铁矿",10);
        warehouse.display();
        warehouse.removeCargo("原石",100);
        warehouse.display();
    }
}
