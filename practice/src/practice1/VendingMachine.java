package practice1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VendingMachine {
    List<Slot>  slots = new ArrayList<>();
    int capacity = 6;
    int revenue;

    public int freePlace(){
        int sum = 0;
        for(Slot s: slots){
            sum++;
        }
        return capacity-sum;
    }

    public int restock(Product p,int count){
        if(p == null || count < 0){
            System.out.println("信息输入不合适");
            return -1;
        }
        int remaining = count;
        for(Slot slot : slots){
            if(slot.getProduct().getName().equals(p.getName())){
                int add = Math.min(remaining,slot.getProduct().getMaxPerSlot()-slot.getQuantity());
                remaining -= add;
                slot.setQuantity(slot.getQuantity()+add);
            }
        }
        while(remaining > 0 && freePlace() > 0){
            int add = Math.min(remaining,p.getMaxPerSlot());
            Slot newSlot = new Slot(p,add);
            slots.add(newSlot);
            remaining -= add;
        }
        return remaining;
    }

    public int buy(String name, int count){
        if(count < 0 || name == null){
            System.out.println("信息输入不合适");
            return -1;
        }
        if(count > getStock(name)){
            System.out.println("货品不足");
            return -1;
        }
        int bought = 0;
        int price = 0;
        Iterator<Slot> it = slots.iterator();
        while(it.hasNext() && bought < count){
            Slot slot = it.next();
            if(!slot.getProduct().getName().equals(name)){
                continue;
            }
            int buy = Math.min(slot.getQuantity(),count-bought);
            slot.setQuantity(slot.getQuantity()-buy);
            bought += buy;
            if(slot.getQuantity() == 0){
                it.remove();
            }
            price += slot.getProduct().getPrice()*buy;
        }
        revenue += price;
        return price;
    }

    public int getStock(String name){
        int sum = 0;
        for(Slot slot : slots){
            if(slot.getProduct().getName().equals(name)){
                sum+=slot.getQuantity();
            }
        }
        return sum;
    }

    public int getRevenue(){
        System.out.println("累计收入为:"+revenue);
        return revenue;
    }

    public void display(){
        for(int i = 0; i < slots.size(); i++){
            Slot slot1 = slots.get(i);
            System.out.println("货道["+(i+1)+"] "+slot1.getProduct().getName()+" x "+slot1.getQuantity());
            }
        }

}
