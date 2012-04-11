package net.minecraft.src;

import net.minecraft.src.forge.Configuration;

public class ConfigManager
{
    private Configuration c;
    private String f;
    private int k;
    private int i2;
    private String i3;
    private boolean i4;
    private int i5;

    public ConfigManager(Configuration var1, String var2)
    {
        this.c = var1;
        this.f = var2;
    }

    public int blockProperty(int var1)
    {
        this.c.load();
        this.i2 = Integer.parseInt(this.c.getOrCreateBlockIdProperty(this.f, var1).value);
        this.c.save();
        return this.i2;
    }

    public int itemProperty(int var1)
    {
        this.c.load();
        Configuration var10003 = this.c;
        this.i2 = Integer.parseInt(this.c.getOrCreateIntProperty(this.f, "item", var1).value);
        this.c.save();
        return this.i2;
    }

    public String generalProperty(String var1)
    {
        this.c.load();
        Configuration var10003 = this.c;
        this.i3 = this.c.getOrCreateProperty(this.f, "general", var1).value;
        this.c.save();
        return this.i3;
    }
}
