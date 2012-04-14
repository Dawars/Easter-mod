package net.minecraft.src;

public class ModelEasterBunny extends ModelBase
{
	//fields
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Tail;
    ModelRenderer Rigth_Feet;
    ModelRenderer Left_Feet;
    ModelRenderer Rigth_Nail;
    ModelRenderer Left_Nail;
    ModelRenderer Left_Arm;
    ModelRenderer Rigth_Ear;
    ModelRenderer Left_Ear;
    ModelRenderer Nose;
    ModelRenderer Right_Arm;
  
  public ModelEasterBunny()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 40, 0);
      Body.addBox(0F, 0F, 0F, 7, 14, 5);
      Body.setRotationPoint(-3F, 7F, -2F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 5, 7, 4);
      Head.setRotationPoint(-2F, 1F, -1F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 32, 20);
      Tail.addBox(-1F, 0F, 0F, 3, 4, 3);
      Tail.setRotationPoint(0F, 15F, 2F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      Rigth_Feet = new ModelRenderer(this, 12, 19);
      Rigth_Feet.addBox(1F, 0F, 0F, 4, 4, 9);
      Rigth_Feet.setRotationPoint(0F, 20F, -6F);
      Rigth_Feet.setTextureSize(64, 32);
      Rigth_Feet.mirror = true;
      setRotation(Rigth_Feet, 0F, 0F, 0F);
      Left_Feet = new ModelRenderer(this, 38, 19);
      Left_Feet.addBox(0F, 0F, 0F, 4, 4, 9);
      Left_Feet.setRotationPoint(-5F, 20F, -6F);
      Left_Feet.setTextureSize(64, 32);
      Left_Feet.mirror = true;
      setRotation(Left_Feet, 0F, 0F, 0F);
      Rigth_Nail = new ModelRenderer(this, 0, 22);
      Rigth_Nail.addBox(0F, 0F, 0F, 4, 3, 2);
      Rigth_Nail.setRotationPoint(1F, 21F, -7F);
      Rigth_Nail.setTextureSize(64, 32);
      Rigth_Nail.mirror = true;
      setRotation(Rigth_Nail, 0F, 0F, 0F);
      Left_Nail = new ModelRenderer(this, 0, 27);
      Left_Nail.addBox(0F, 0F, 0F, 4, 3, 2);
      Left_Nail.setRotationPoint(-5F, 21F, -7F);
      Left_Nail.setTextureSize(64, 32);
      Left_Nail.mirror = true;
      setRotation(Left_Nail, 0F, 0F, 0F);
      Left_Arm = new ModelRenderer(this, 0, 12);
      Left_Arm.addBox(0F, -2F, -1F, 3, 3, 7);
      Left_Arm.setRotationPoint(-3F, 9F, 1F);
      Left_Arm.setTextureSize(64, 32);
      Left_Arm.mirror = true;
      setRotation(Left_Arm, 1.570796F, 0F, 3.141593F);
      Rigth_Ear = new ModelRenderer(this, 28, 2);
      Rigth_Ear.addBox(0F, 0F, 0F, 1, 5, 2);
      Rigth_Ear.setRotationPoint(2F, -3F, 0F);
      Rigth_Ear.setTextureSize(64, 32);
      Rigth_Ear.mirror = true;
      setRotation(Rigth_Ear, 0F, 0F, 0.1487144F);
      Left_Ear = new ModelRenderer(this, 34, 1);
      Left_Ear.addBox(0F, 0F, 0F, 1, 6, 2);
      Left_Ear.setRotationPoint(-2F, -4F, 0F);
      Left_Ear.setTextureSize(64, 32);
      Left_Ear.mirror = true;
      setRotation(Left_Ear, 0F, 0F, 0F);
      Nose = new ModelRenderer(this, 30, 0);
      Nose.addBox(0F, 0F, 0F, 1, 1, 1);
      Nose.setRotationPoint(0F, 4F, -1.5F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      Right_Arm = new ModelRenderer(this, 0, 12);
      Right_Arm.addBox(0F, -1F, -1F, 3, 3, 7);
      Right_Arm.setRotationPoint(4F, 9F, 1F);
      Right_Arm.setTextureSize(64, 32);
      Right_Arm.mirror = true;
      setRotation(Right_Arm, 1.570796F, 3.141593F, 3.141593F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Body.render(f5);
    Head.render(f5);
    Tail.render(f5);
    Rigth_Feet.render(f5);
    Left_Feet.render(f5);
    Rigth_Nail.render(f5);
    Left_Nail.render(f5);
    Left_Arm.render(f5);
    Rigth_Ear.render(f5);
    Left_Ear.render(f5);
    Nose.render(f5);
    Right_Arm.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
  {
	  this.Left_Arm.rotateAngleX = MathHelper.cos(par2) * 1.4F * par3;
	  this.Right_Arm.rotateAngleX = MathHelper.cos(par2 + (float)Math.PI) * 1.4F * par3;
  }
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
//	  this.Right_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
//      this.Left_Arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
//      
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
