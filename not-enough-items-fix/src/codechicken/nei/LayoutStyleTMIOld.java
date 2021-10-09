/*    */ package codechicken.nei;
/*    */ 
/*    */ 
/*    */ public class LayoutStyleTMIOld
/*    */   extends LayoutStyle
/*    */ {
/*    */   int stateButtonCount;
/*    */   int clickButtonCount;
/*    */   
/*    */   public String getName() {
/* 11 */     return "Old TMI Layout";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 17 */     LayoutManager.delete.icon = new Image(24, 12, 12, 12);
/* 18 */     LayoutManager.creative.icon = new Image(12, 12, 12, 12);
/* 19 */     LayoutManager.creative.icon2 = new Image(36, 12, 12, 12);
/* 20 */     LayoutManager.rain.icon = new Image(0, 12, 12, 12);
/* 21 */     LayoutManager.magnet.icon = new Image(60, 24, 12, 12);
/* 22 */     LayoutManager.dawn.icon = new Image(12, 24, 12, 12);
/* 23 */     LayoutManager.noon.icon = new Image(0, 24, 12, 12);
/* 24 */     LayoutManager.dusk.icon = new Image(24, 24, 12, 12);
/* 25 */     LayoutManager.midnight.icon = new Image(36, 24, 12, 12);
/* 26 */     LayoutManager.heal.icon = new Image(48, 24, 12, 12);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void reset() {
/* 32 */     this.stateButtonCount = this.clickButtonCount = 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void position(Button button, GuiManager gui) {
/* 38 */     int offsetx = 2;
/* 39 */     int offsety = 2;
/*    */     
/* 41 */     if ((button.state & 0x4) != 0) {
/*    */       
/* 43 */       button.x = offsetx + this.stateButtonCount * 22;
/* 44 */       button.y = offsety;
/* 45 */       this.stateButtonCount++;
/*    */     }
/*    */     else {
/*    */       
/* 49 */       button.x = offsetx + this.clickButtonCount % 4 * 22;
/* 50 */       button.y = offsety + (1 + this.clickButtonCount / 4) * 17;
/* 51 */       this.clickButtonCount++;
/*    */     } 
/*    */     
/* 54 */     button.height = 14;
/* 55 */     button.setOwnWidth(gui);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawBackground(GuiManager gui) {
/* 61 */     if (this.clickButtonCount == 0 && this.stateButtonCount == 0) {
/*    */       return;
/*    */     }
/* 64 */     int maxx = Math.max(this.stateButtonCount, this.clickButtonCount);
/* 65 */     if (maxx > 4) maxx = 4; 
/* 66 */     int maxy = (this.clickButtonCount == 0) ? 1 : (this.clickButtonCount / 4 + 2);
/*    */     
/* 68 */     gui.drawRect(0, 0, 2 + 22 * maxx, 1 + maxy * 17, -16777216);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\LayoutStyleTMIOld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */