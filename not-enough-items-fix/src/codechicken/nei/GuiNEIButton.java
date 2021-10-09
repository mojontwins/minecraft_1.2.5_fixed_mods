/*    */ package codechicken.nei;
/*    */ 
/*    */ import abp;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import nl;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiNEIButton
/*    */   extends abp
/*    */ {
/*    */   public GuiNEIButton(int i, int j, int k, int l, int i1, String s) {
/* 13 */     super(i, j, k, l, i1, s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(Minecraft minecraft, int i, int j) {
/* 18 */     if (!this.i) {
/*    */       return;
/*    */     }
/*    */     
/* 22 */     nl fontrenderer = minecraft.q;
/* 23 */     GL11.glBindTexture(3553, minecraft.p.b("/gui/gui.png"));
/* 24 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 25 */     boolean flag = (i >= this.c && j >= this.d && i < this.c + this.a && j < this.d + this.b);
/* 26 */     int k = a(flag);
/* 27 */     b(this.c, this.d, 0, 46 + k * 20, this.a / 2, this.b / 2);
/* 28 */     b(this.c + this.a / 2, this.d, 200 - this.a / 2, 46 + k * 20, this.a / 2, this.b / 2);
/* 29 */     b(this.c, this.d + this.b / 2, 0, 46 + k * 20 + 20 - this.b / 2, this.a / 2, this.b / 2);
/* 30 */     b(this.c + this.a / 2, this.d + this.b / 2, 200 - this.a / 2, 46 + k * 20 + 20 - this.b / 2, this.a / 2, this.b / 2);
/* 31 */     b(minecraft, i, j);
/*    */     
/* 33 */     if (!this.h) {
/*    */       
/* 35 */       a(fontrenderer, this.e, this.c + this.a / 2, this.d + (this.b - 8) / 2, -6250336);
/*    */     }
/* 37 */     else if (flag) {
/*    */       
/* 39 */       a(fontrenderer, this.e, this.c + this.a / 2, this.d + (this.b - 8) / 2, 16777120);
/*    */     } else {
/*    */       
/* 42 */       a(fontrenderer, this.e, this.c + this.a / 2, this.d + (this.b - 8) / 2, 14737632);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEIButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */