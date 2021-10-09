/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import java.util.List;
/*    */ 
/*    */ public abstract class Widget
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public int z;
/*    */   public int width;
/*    */   public int height;
/*    */   
/*    */   public abstract void draw(GuiManager paramGuiManager, int paramInt1, int paramInt2);
/*    */   
/*    */   public boolean handleClick(int mousex, int mousey, int button) {
/* 17 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onGuiClick(int mousex, int mousey) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseUp(int mousex, int mousey, int button) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean handleKeyPress(int keyID, char keyChar) {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onMouseWheel(int i, int mousex, int mousey) {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(GuiManager gui) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean contains(int posx, int posy) {
/* 46 */     return (posx >= this.x && posx < this.x + this.width && posy >= this.y && posy < this.y + this.height);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void resize() {}
/*    */ 
/*    */   
/*    */   public aan getStackMouseOver(int mousex, int mousey) {
/* 55 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List handleTooltip(int mx, int my, List tooltip) {
/* 60 */     return tooltip;
/*    */   }
/*    */   
/*    */   public void loseFocus() {}
/*    */   
/*    */   public void gainFocus() {}
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\Widget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */