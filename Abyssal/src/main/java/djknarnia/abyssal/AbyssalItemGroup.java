package djknarnia.abyssal;

import lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AbyssalItemGroup extends ItemGroup {

	public AbyssalItemGroup(String label) {
		super("Abyssal");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.prismarine_and_steel);
	}
	
}
