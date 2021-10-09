/*    */ package codechicken.nei;
/*    */ 
/*    */ public class Label
/*    */   extends Widget
/*    */ {
/*    */   boolean centered;
/*    */   int colour;
/*    */   String text;
/*    */   
/*    */   public Label(String s, boolean center, int color) {
/* 11 */     this.text = s;
/* 12 */     this.centered = center;
/* 13 */     this.colour = color;
/*    */   }
/*    */ 
/*    */   
/*    */   public Label(String s, boolean center) {
/* 18 */     this(s, center, -1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(GuiManager gui, int mousex, int mousey) {
/* 24 */     if (this.centered) {
/* 25 */       gui.drawTextCentered(this.text, this.x, this.y, this.colour);
/*    */     } else {
/* 27 */       gui.drawText(this.x, this.y, this.text, this.colour);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */