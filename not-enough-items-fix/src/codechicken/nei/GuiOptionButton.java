/*    */ package codechicken.nei;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import z;
/*    */ 
/*    */ public class GuiOptionButton
/*    */   extends z
/*    */ {
/*    */   public GuiOptionButton(int i, int j, int k, String s) {
/* 10 */     super(i, j, k, s);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean c(Minecraft minecraft, int i, int j) {
/* 16 */     return (this.i && i >= this.c && j >= this.d && i < this.c + this.a && j < this.d + this.b);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiOptionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */