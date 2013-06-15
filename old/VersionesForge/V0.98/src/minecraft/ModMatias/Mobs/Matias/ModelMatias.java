package ModMatias.Mobs.Matias;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelMatias extends ModelBase
{
	 //fields
	
    ModelRenderer body;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer head;
    ModelRenderer torch;
    ModelRenderer head1;
    ModelRenderer arm;
    ModelRenderer head3;
    ModelRenderer arm2;
    ModelRenderer head5;
    ModelRenderer head6;
    ModelRenderer Piece1;
    ModelRenderer Piece2;
    ModelRenderer Piece3;
    ModelRenderer Piece4;
    ModelRenderer Piece21;
    ModelRenderer Piece22;
    ModelRenderer Piece23;
    ModelRenderer Piece24;

  public ModelMatias()
  {
    textureWidth = 300;
    textureHeight = 300;
    
      body = new ModelRenderer(this, 0, 32);
      body.addBox(0F, 0F, 0F, 16, 16, 16);
      body.setRotationPoint(-8F, 0F, -8F);
      body.setTextureSize(300, 300);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      
      body1 = new ModelRenderer(this, 0, 32);
      body1.addBox(0F, 0F, 0F, 16, 16, 16);
      body1.setRotationPoint(-8F, -16F, -8F);
      body1.setTextureSize(300, 300);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      
    body2 = new ModelRenderer(this, "body2");
    body2.setRotationPoint(0F, 43F, 0F);
    setRotation(body2, 0F, 0F, 0F);
    body2.mirror = true;
    
    Piece1 = new ModelRenderer(this, 36,0);
    Piece1.setRotationPoint(-15F, -37F, -3.5F);
    setRotation(Piece1, 0F, 0F, 0F);
    Piece1.mirror = true;
      Piece1.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece1.addBox( 3F, -2F, 2.5F, 2, 2, 2).setTextureOffset(0, 0);
      Piece1.addBox( 5F, -4F, 2.5F, 2, 2, 2).setTextureOffset(8, 0);
      Piece1.addBox( 4F, -4F, 2.5F, 2, 2, 2).setTextureOffset(0, 4);
      Piece1.addBox( 4F, -3F, 2.5F, 2, 2, 2).setTextureOffset(8, 4);
      body2.addChild(Piece1);
      
    Piece2 = new ModelRenderer(this, 36,0);
    Piece2.setRotationPoint(8F, -37F, -3.5F);
    setRotation(Piece2, 0F, 0F, 0F);
    Piece2.mirror = true;
      Piece2.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece2.addBox( 2F, -2F, 2.5F, 2, 2, 2).setTextureOffset(0, 0);
      Piece2.addBox( 0F, -4F, 2.5F, 2, 2, 2).setTextureOffset(8, 0);
      Piece2.addBox( 1F, -4F, 2.5F, 2, 2, 2).setTextureOffset(0, 4);
      Piece2.addBox( 1F, -3F, 2.5F, 2, 2, 2).setTextureOffset(8, 4);
      body2.addChild(Piece2);
      
      Piece3 = new ModelRenderer(this, 36,0);
      Piece3.setRotationPoint(-3.5F, -37F, 8F);
      setRotation(Piece3, 0F, 0F, 0F);
      Piece3.mirror = true;
        Piece3.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
        Piece3.addBox( 2.5F, -2F, 1.966667F, 2, 2, 2).setTextureOffset(0, 0);
        Piece3.addBox( 2.5F, -4F, 0F, 2, 2, 2).setTextureOffset(8, 0);
        Piece3.addBox( 2.5F, -4F, 1F, 2, 2, 2).setTextureOffset(0, 4);
        Piece3.addBox( 2.5F, -3F, 1F, 2, 2, 2).setTextureOffset(8, 4);
        body2.addChild(Piece3);

      /*
    Piece4 = new ModelRenderer(this, "Piece4");
    Piece4.setRotationPoint(-3.5F, -37F, -15F);
    setRotation(Piece4, 0F, 0F, 0F);
    Piece4.mirror = true;
      Piece4.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece4.addBox( 2.5F, -2F, 2.966667F, 2, 2, 2).setTextureOffset(0, 0);
      Piece4.addBox( 2.5F, -4F, 5F, 2, 2, 2).setTextureOffset(0, 0);
      Piece4.addBox( 2.5F, -4F, 4F, 2, 2, 2).setTextureOffset(0, 0);
      Piece4.addBox( 2.5F, -2F, 4F, 2, 2, 2).setTextureOffset(0, 0);
      
      body2.addChild(Piece4);
      */
      //body.addChild(body2);
      
      
    body3 = new ModelRenderer(this, 36,0);
    body3.setRotationPoint(0F, 29F, 0F);
    setRotation(body3, 0F, 0F, 0F);
    body3.mirror = true;
    
    Piece21 = new ModelRenderer(this, 36,0);
    Piece21.setRotationPoint(-15F, -37F, -3.5F);
    setRotation(Piece21, 0F, 0F, 0F);
    Piece21.mirror = true;
      Piece21.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece21.addBox( 3F, -2F, 2.5F, 2, 2, 2).setTextureOffset(0, 0);
      Piece21.addBox( 5F, -4F, 2.5F, 2, 2, 2).setTextureOffset(8, 0);
      Piece21.addBox( 4F, -4F, 2.5F, 2, 2, 2).setTextureOffset(0, 4);
      Piece21.addBox( 4F, -3F, 2.5F, 2, 2, 2).setTextureOffset(8, 4);
      body3.addChild(Piece21);
      
    Piece22 = new ModelRenderer(this, 36,0);
    Piece22.setRotationPoint(8F, -37F, -3.5F);
    setRotation(Piece22, 0F, 0F, 0F);
    Piece22.mirror = true;
      Piece22.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece22.addBox( 2F, -2F, 2.5F, 2, 2, 2).setTextureOffset(0, 0);
      Piece22.addBox( 0F, -4F, 2.5F, 2, 2, 2).setTextureOffset(8, 0);
      Piece22.addBox( 1F, -4F, 2.5F, 2, 2, 2).setTextureOffset(0, 4);
      Piece22.addBox( 1F, -3F, 2.5F, 2, 2, 2).setTextureOffset(8, 4);
      body3.addChild(Piece22);
      
    Piece23 = new ModelRenderer(this, 36,0);
    Piece23.setRotationPoint(-3.5F, -37F, 8F);
    setRotation(Piece23, 0F, 0F, 0F);
    Piece23.mirror = true;
      Piece23.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece23.addBox( 2.5F, -2F, 1.966667F, 2, 2, 2).setTextureOffset(0, 0);
      Piece23.addBox( 2.5F, -4F, 0F, 2, 2, 2).setTextureOffset(8, 0);
      Piece23.addBox( 2.5F, -4F, 1F, 2, 2, 2).setTextureOffset(0, 4);
      Piece23.addBox( 2.5F, -3F, 1F, 2, 2, 2).setTextureOffset(8, 4);
      body3.addChild(Piece23);
      
    Piece24 = new ModelRenderer(this, 36,0);
    Piece24.setRotationPoint(-3.5F, -37F, -15F);
    setRotation(Piece24, 0F, 0F, 0F);
    Piece24.mirror = true;
      Piece24.addBox( 0F, 0F, 0F, 7, 7, 7).setTextureOffset(8, 4);
      Piece24.addBox( 2.5F, -2F, 2.966667F, 2, 2, 2).setTextureOffset(0, 0);
      Piece24.addBox( 2.5F, -4F, 5F, 2, 2, 2).setTextureOffset(8, 0);
      Piece24.addBox( 2.5F, -4F, 4F, 2, 2, 2).setTextureOffset(0, 4);
      Piece24.addBox( 2.5F, -2F, 4F, 2, 2, 2).setTextureOffset(8, 4);
      body3.addChild(Piece24);
  
      //body.addChild(body3);
      
      //fire
      head = new ModelRenderer(this, 68, 64);
      head.addBox(0F, 0F, 0F, 16, 16, 16);
      
      
      head.setRotationPoint(-8F, -48F, -8F);

      //head.addBox(0F, 0F, 0F, 14, 14, 14).setTextureOffset(-150,-250);


      head.setTextureSize(300, 300);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      
      torch = new ModelRenderer(this, 21, 0);
      torch.addBox(0F, 17F, 13F, 2, 11, 2);
      torch.setRotationPoint(-0.5F, 10F, 15F);
      torch.setTextureSize(300, 300);
      torch.mirror = true;
      setRotation(torch, -2.221732F, 0F, 0F);
      
      /*
      torch = new ModelRenderer(this, 21, 0);
      torch.addBox(0F, 17F, 13F, 2, 11, 2);
      torch.setRotationPoint(-0.5F, 33F, 6F);
      torch.setTextureSize(300, 300);
      torch.mirror = true;
      setRotation(torch, 2.395439F, 0F, 0F);
      */
      head1 = new ModelRenderer(this, 0, 12);
      head1.addBox(0F, 0F, 0F, 2, 12, 2);
      head1.setRotationPoint(9.666667F, -29.9F, 1.066667F);
      head1.setTextureSize(300, 300);
      head1.mirror = true;
      setRotation(head1, 0F, 3.141593F, 0F);
      
      
      
      head3 = new ModelRenderer(this, 70, 0);
      head3.addBox(0F, 0F, 0F, 8, 8, 8);
      head3.setRotationPoint(-4F, -29F, -15F);
      head3.setTextureSize(300, 300);
      head3.mirror = true;
      setRotation(head3, 0F, 0F, 0F);
      
      /*
      head3 = new ModelRenderer(this, 70, 0);
      head3.addBox(0F, 0F, 0F, 8, 8, 8);
      head3.setRotationPoint(4.5F, -29.9F, 16F);
      head3.setTextureSize(300, 300);
      head3.mirror = true;
      setRotation(head3, 0F, 3.141593F, 0F);
      */
      
      
      
      head5 = new ModelRenderer(this, 0, 64);
      head5.addBox(0F, 0F, 0F, 16, 16, 16);
      head5.setRotationPoint(-8F, -32.06667F, -8F);
      head5.setTextureSize(300, 300);
      head5.mirror = true;
      setRotation(head5, 0F, 0F, 0F);
      
      head6 = new ModelRenderer(this, 0, 12);
      head6.addBox(0F, 0F, 0F, 2, 12, 2);
      head6.setRotationPoint(-10F, -29.93333F, -1F);
      head6.setTextureSize(300, 300);
      head6.mirror = true;
      setRotation(head6, 0F, 0F, 0F);
      
      
      arm = new ModelRenderer(this, 9, 14);
      arm.addBox(0F, 0F, 0F, 2, 8, 2);
      arm.setRotationPoint(8F, -25.93333F, -1F);
      arm.setTextureSize(300, 300);
      arm.mirror = true;
      setRotation(arm, 0F, 0F, 0.8F);
      
      
      arm2 = new ModelRenderer(this, 9, 14);
      arm2.addBox(0F, 0F, 0F, 2, 8, 2);
      arm2.setRotationPoint(-8F, -25.93333F, -1F);
      arm2.setTextureSize(300, 300);
      arm2.mirror = true;
      setRotation(arm2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    body1.render(f5);
    body2.render(f5);
    body3.render(f5);
    head.render(f5);
    torch.render(f5);
    head1.render(f5);
    head3.render(f5);
    arm2.render(f5);
    head5.render(f5);
    head6.render(f5);
    arm.render(f5);

  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,null);
    //animaciones
    arm.rotateAngleZ = -1.7F+MathHelper.cos(f * 0.6662F) * 3.4F * f1 ;
    arm2.rotateAngleZ = 1.7F+MathHelper.cos(f * 0.6662F) * 3.4F * f1 ;
  }

}
