package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouse {
    List<CargoStack> slots = new ArrayList<>();
    int capacity = 20;

    int remaining;
    public int addCargo(CargoStack cargo) {
        int remaining = cargo.getQuantity();
        for (CargoStack c : slots) {
            if(c.getGoods().getName().equals(cargo.getGoods().getName())) {
                int add = Math.min(remaining,c.getGoods().maxStackSize-c.getQuantity());
                remaining -= add;
                c.setQuantity(c.getQuantity()+add);
            }
            if(remaining == 0) {
                return remaining;
            }
        }
        if(remaining > 0 && remainingSlots() > 0) {
            CargoStack cargoStack = new CargoStack();
            cargoStack.setGoods(cargo.getGoods());
            cargoStack.setQuantity(remaining);
            slots.add(cargoStack);
        }
        return remaining;
    }

    public int removeCargo(String name,int amount) {


        int removed = 0;
        Iterator<CargoStack> it = slots.iterator();
        while (it.hasNext() && removed < amount) {
            CargoStack cargo = it.next();
            if(!cargo.getGoods().getName().equals(name)) {
                continue;
            }
            int removedAmount = Math.min(amount, cargo.getQuantity());
            cargo.setQuantity(cargo.getQuantity() - removedAmount);
            removed += removedAmount;
            if (cargo.getQuantity() == 0) {
                    it.remove();
            }
        }
        return removed;
    }


    public int countCargo(String name){
        int sum = 0;
        for (CargoStack c : slots) {
            if(c.getGoods().getName().equals(name)) {
                int count = c.getQuantity();
                sum += count;
            }
        }
        System.out.println(name+"总数为:");
        return sum;
    }
    public int remainingSlots(){
        int sum = 0;
        for(CargoStack c : slots) {
            sum+=1;
        }
        return capacity-sum;
    }
    public void display(){
        int num =1;
        for (CargoStack c : slots) {
            System.out.println("["+num+"] "+c.getGoods().getName()+" x "+c.getQuantity());
            num++;
        }
        System.out.println(capacity-remainingSlots());
    }

}
