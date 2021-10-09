/*    */ package codechicken.nei;
/*    */ 
/*    */ import dd;
/*    */ import gb;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiExtendedCreativeInv
/*    */   extends gb
/*    */ {
/*    */   public GuiExtendedCreativeInv(dd par1Container) {
/* 12 */     super(par1Container);
/* 13 */     this.c = 198;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void a(float var1, int var2, int var3) {
/* 19 */     int texID = this.p.p.b("/codechicken/nei/inv.png");
/* 20 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 21 */     this.p.p.b(texID);
/*    */     
/* 23 */     int x = this.e;
/* 24 */     int y = this.f - 4;
/*    */     
/* 26 */     b(x - 23, y, 0, 0, 199, 204);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiExtendedCreativeInv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */