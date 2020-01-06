package io.moonman.emergingtechnology.item.synthetics;

import java.util.List;

import io.moonman.emergingtechnology.item.ItemFoodBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookedMeatItemBase extends ItemFoodBase {

    private String _name = "";
    public String entityId = "";

    public CookedMeatItemBase(String name, String entityId, int healAmount) {
        super("synthetic" + name + "cooked", healAmount, (float) 0.6);
        this._name = name;
        this.entityId = entityId;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        tooltip.add("Cooked synthetic " + this._name + " meat.");
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return "Synthetic " + this._name + " Meat";
    }
}