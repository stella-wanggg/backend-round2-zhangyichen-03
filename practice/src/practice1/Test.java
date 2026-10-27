package practice1;

public class Test {
    public static void main(String[] args) {
        Product p1 = new Product("可乐",10,3);
        Product p2 =  new Product("薯片",5,6);
        Product p3 =new Product("纯净水",8,2);
        VendingMachine vm = new VendingMachine();
        vm.restock(p1,15);
        vm.display();
        vm.buy("可乐",12);
        vm.display();
        vm.buy("可乐",5);
        vm.display();
        vm.restock(p2,12);
        vm.display();
        vm.restock(p3,100);
        vm.display();
        vm.buy("薯片",3);
        vm.display();
        vm.getRevenue();
    }
}
