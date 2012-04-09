package net.minecraft.src;
 
public enum EasterToolMaterial
{
    WHITE(3, 655, 7.0F, 2, 12),
    MILK(2, 250, 6.0F, 2, 14),
    DARK(2, 117, 5.0F, 1, 9),
    DIAMOND(3, 800, 9.0F, 5, 12);
    
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;
    private static final EasterToolMaterial allToolMaterials[];
   
   
   
 
    private EasterToolMaterial(int par3, int par4, float par5, int par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }
 
    public int getMaxUses()
    {
        return maxUses;
    }
 
    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }
 
    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }
 
    public int getHarvestLevel()
    {
        return harvestLevel;
    }
 
    public int getEnchantability()
    {
        return enchantability;
    }
 
    static
    {
        allToolMaterials = (new EasterToolMaterial[] {
            WHITE, MILK, DARK
        });

    }
}