    package net.minecraft.src;
    
    import java.util.Random;
     
    public enum EasterArmorMaterial
    {
//        TITANIUM("TITANIUM", 25, 29, new int[] {2, 7, 5, 3}, 9),
//        FIRE("FIRE", 25, 29, new int[] {2, 7, 5, 3}, 9),
        
        WHITE("WHITE",21, 25, new int[]{3, 7, 6, 3}, 10),
        MILK("MILK", 15, 29, new int[]{2, 6, 5, 2}, 9),//
        DARK("DARK", 10, 20, new int[]{2, 5, 4, 1}, 12),
        DIAMOND("DIAMOND", 38, 30, new int[]{4, 9, 7, 4}, 15);
        private int maxDamageFactor;
        private int damageReductionAmountArray[];
        private int enchantability;
       
     
        private EasterArmorMaterial(String s, int i, int j, int ai[], int k)
        {
            maxDamageFactor = j;
            damageReductionAmountArray = ai;
            enchantability = k;
        }
     
        public int func_40576_a(int i)
        {
            return ItemArmor.getMaxDamageArray()[i] * maxDamageFactor;
        }
            public int getDamageReductionAmount(int i)
        {
            return damageReductionAmountArray[i];
        }
     
        public int getEnchantability()
        {
            return enchantability;
        }
     
       
        }