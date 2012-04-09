package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;
    
    public class EasterItemArmor extends ItemArmor implements ITextureProvider
    {
     
        private static final int maxDamageArray[] = {
            11, 16, 15, 13
        };
        public final int armorType;
        public final int damageReduceAmount;
        public final int renderIndex;
        private final EasterArmorMaterial material;
     
        public EasterItemArmor(int i, EasterArmorMaterial enumarmormaterial, int j, int k)
        {
            super(i, EnumArmorMaterial.DIAMOND, j, k);
            material = enumarmormaterial;
            armorType = k;
            renderIndex = j;
            damageReduceAmount = enumarmormaterial.getDamageReductionAmount(k);
            setMaxDamage(enumarmormaterial.func_40576_a(k));
            maxStackSize = 1;
        }
        

        @Override
    	public String getTextureFile() {
    		return "/easter/EasterItems.png";
    	}
     
        public int getItemEnchantability()
        {
            return material.getEnchantability();
        }
     
        static int[] getMaxDamageArray()
        {
            return maxDamageArray;
        }
     
    }