package net.minecraft.src;

public class BiomeGenEaster extends BiomeGenBase
{
    protected BiomeGenEaster(int par1)
    {
    	super(par1);
        spawnableCreatureList.clear();
        topBlock = (byte)Block.grass.blockID;
        fillerBlock = (byte)Block.dirt.blockID;
        biomeDecorator.treesPerChunk = 0;
        biomeDecorator.deadBushPerChunk = 0;
        biomeDecorator.reedsPerChunk = 0;
        biomeDecorator.cactiPerChunk = 0;
        
        
        this.rainfall = 0.6F;
        this.biomeDecorator = new BiomeEasterDecorator(this);
        
//        waterColorMultiplier = 0xff00c6;
        waterColorMultiplier = 0xff006c;
    }
    
    public int getBiomeGrassColor()
    {
        double var1 = (double)this.getFloatTemperature();
        double var3 = (double)this.getFloatRainfall();
//        return ((ColorizerGrass.getGrassColor(var1, var3) & 0xC2C2C2) + 0xBFFF00) / 2;
        return 0x8aff00;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double var1 = (double)this.getFloatTemperature();
        double var3 = (double)this.getFloatRainfall();
//        return ((ColorizerFoliage.getFoliageColor(var1, var3) & 0xC2C2C2) + 0xBFFF00) / 2;
        return 0x8aff00;
    }
}
