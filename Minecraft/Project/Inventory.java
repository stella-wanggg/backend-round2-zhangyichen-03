import java.util.ArrayList;
import java.util.List;

public class Inventory {
    int capacity = 36;
    List<ItemStack> items = new ArrayList<>();

    public Inventory() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int addItem(ItemStack itemStackToAdd) {
        // 这里把常用的值定义一下
        int max = itemStackToAdd.getItem().getMaxStackSize();
        int quantity = itemStackToAdd.getQuantity();
        int orquantity = itemStackToAdd.getQuantity();
        String item = itemStackToAdd.getItem().getName();
        String oritem = itemStackToAdd.getItem().getName();
        // 先判断有没有空位
        if (capacity > 0) { //  有空位
            for (ItemStack i : items) { // 遍历items的元素
                if (item.equals(i.getItem().getName())) { // 如果找到了相同物品
                    if (orquantity == max) { // 如果这一组已经满了
                        break; // 跳过
                    } else if (quantity < max - orquantity) { // 如果这一组空位充足,可以全部装下
                        i.setQuantity(orquantity + quantity); // 改这一组quantity的值
                        return quantity; // 返回背包容量
                    } else { // 如果这一组空位不足
                        i.setQuantity(max); // 先把这一组填满
                        ItemStack s = new ItemStack(i.getItem(), quantity - (max - orquantity)); // 再新开一组,个数是前一组放不下的那一部分
                        return quantity; // 返回背包容量
                    }
                } else { // 没有找到相同物品
                    if (quantity <= max) { // 增加的数量一组装得下
                        ItemStack s = new ItemStack(i.getItem(), quantity);
                        return quantity - 1; // 返回背包容量
                    } else {
                        ItemStack s1 = new ItemStack(i.getItem(), max); // 增加的数量一组装不下
                        ItemStack s2 = new ItemStack(i.getItem(), quantity - max); // 再新建一组
                        return quantity - 2; // 返回背包容量
                    }
                }
            }
        } else { // 没有空位,直接返回
            return quantity;

        }
        return max; // 他一直报错,我先随便返回个值
    }

    public void removeitem(String itemName, int amountToRemove) {
        if (amountToRemove <= 0) {
            System.out.println("删除的数量不能是0或是负数");
            return;
        }
        int remaining = amountToRemove;
        if (getItemCount(itemName) > 0) {
            for (ItemStack itemStack : items) {
                if (remaining == 0) {
                    System.out.println("已成功删除~");
                }
                if (!itemStack.getItem().getName().equals(itemName)) {
                    continue;
                }
                int minus = Math.min(remaining, itemStack.getQuantity());
                itemStack.setQuantity(itemStack.getQuantity() - minus);
                remaining -= minus;
                if(itemStack.getQuantity() == 0) {
                    items.remove(itemStack);
                }
            }
            if (remaining != 0) {
                System.out.println("删除失败，物品数量不足");
            }
        } else {
            System.out.println("删除失败，物品不存在");
        }
    }

    public int getItemCount(String itemName) {
        int sum = 0;
        for (ItemStack itemstack : items) {
            if (itemstack.getItem().getName().equals(itemName)) {
                sum += itemstack.getQuantity();
                System.out.println(itemName + "共有" + sum + "件");

            }
            if (sum == 0) {
                System.out.println("该物品不存在");
                return -1;
            }
        }
        return sum;
    }
    public void display() {
        if(items.isEmpty()) {
            System.out.println("背包为空");
        } else {
            for(ItemStack itemstack : items){
                System.out.println(itemstack.getItem().getName()+":"+itemstack.getQuantity()+"\n");
            }
        }
    }
}

