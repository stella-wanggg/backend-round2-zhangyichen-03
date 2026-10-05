import java.util.*;

public class InventoryPlus {
    final int capacity = 36; // 定义一个常量
    List<ItemStack> items = new ArrayList<>();

    public InventoryPlus() {
    }

    public int addItem(ItemStack itemStackToAdd) { // 方法一
        if (itemStackToAdd == null || itemStackToAdd.getQuantity() <= 0) { // 先判断一下是否输入值/增加的物品的数量是不是0
            return 0; // 若是直接返回
        }
        Item item = itemStackToAdd.getItem(); // 获取增加物品的item,便于以后取用
        int max = item.getMaxStackSize(); // 获取增加一堆物品的最大数量,便于以后取用
        int remaining = itemStackToAdd.getQuantity(); // 表示要增加的物品的剩余数量
        for (ItemStack itemStack : items) { // 遍历list,获取每一个itemstack对象
                if (remaining == 0) { // 如果要增加的物品已全部放入
                    break; // 不用再看,直接break
                }
                if (!itemStack.getItem().getName().equals(item.getName())) { // 如果不是同类物品,也直接跳过
                    continue;
                }
                int space = max - itemStack.getQuantity(); // 判断一堆还能不能放下
                if (space <= 0) { // 不能放下,跳过接着找
                    continue;
                }
                // 在上面判断完,在"增加的物品还未全部放入+遍历的这一堆是同类物品+这一堆也还有空位"的基础上,看看这一堆实际收多少
                int added = Math.min(remaining, space); // 增加数量取他俩的最小值,避免超出该物品一堆的最大数量
                itemStack.setQuantity(itemStack.getQuantity() + added); // 对物品堆的数量进行修改
                remaining -= added; // 对增加物品的剩余量进行修改
            }
        while (remaining > 0 && items.size() < capacity) { // 如果遍历完所有的物品堆.要增加的物品还有剩余,且背包还有空余,一直循环直至背包满/要增加物品全部放入
            int added = Math.min(remaining, max); // 增加数量取他俩的最小值,避免直接超出该物品一堆的最大数量
            items.add(new ItemStack(item, added)); // 新建一个相应数量的物品堆
            remaining -= added; // 对增加物品的剩余量进行修改
        }
        if (remaining == 0) { // 增加物品全顺利放入
            return capacity-items.size(); // 返回背包空格数
        }else {
            return -remaining; // 增加物品溢出,返回溢出数量
        }
    }
    public void removeitem(String itemName, int amountToRemove) {
        if (amountToRemove <= 0) {
            System.out.println("删除的数量不能是0或是负数"); // 先保证要移除的数目符合实际,是正数
            return;
        }
        int remaining = amountToRemove; // 和上面增加方法一样,定义要移除物品的剩余量
        Iterator<ItemStack> iterator = items.iterator(); // 建立iterator迭代器
        if(getItemCount(itemName)!=0){ // 如果背包中有该物品
        while (iterator.hasNext()) { // 如果下一格有元素
                ItemStack itemStack = iterator.next(); // 跳到下一格
                if (!itemStack.getItem().getName().equals(itemName)) { // 这一格不是同类物
                    continue; // 跳过看下一格
                }
                int minus = Math.min(remaining, itemStack.getQuantity()); // 删除数量取他俩的最小值,避免把这堆物品堆数量删成负数
                itemStack.setQuantity(itemStack.getQuantity() - minus); // 对物品堆的数量进行修改
                remaining -= minus; // 对删除物品的剩余量进行修改
                if (itemStack.getQuantity() == 0) { // 如果这个物品堆空了
                    iterator.remove(); // 移除该物品堆
                }
            }
            if (remaining == 0) { // 全部删除了
                System.out.println("已成功删除~");
            }else{ // 到最后还有没删除的
                System.out.println("物品数量不足,你要删除"+amountToRemove+"件,最多已帮你删除了" + (amountToRemove - remaining)+"件,"+"还剩"+remaining+"件未删除成功");
            }
        }else{ // 对应上面的对背包中是否有该物品的判断
            System.out.println("删除失败，物品不存在");
        }
    }

    public int getItemCount(String itemName) {
        int sum = 0;
        for (ItemStack itemstack : items) { // 遍历list,获取每一个itemstack对象
            if (itemstack.getItem().getName().equals(itemName)) { // 是同类
                sum += itemstack.getQuantity(); // 总数加1
            }
        }
        return sum; // 返回总数,便于上面remove方法使用
    }
    public void display() {
        if(items.isEmpty()) { // 查是不是全空
            System.out.println("背包为空");
        } else {
            for(ItemStack itemstack : items){ // 遍历list,获取每一个itemstack对象,并展示名字和数目
                System.out.println(itemstack.getItem().getName()+":"+itemstack.getQuantity()+"\n");
            }
        }
    }
}


