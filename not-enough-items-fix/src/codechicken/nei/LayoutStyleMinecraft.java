/*    */ package codechicken.nei;
/*    */ 
/*    */ 
/*    */ public class LayoutStyleMinecraft
/*    */   extends LayoutStyle
/*    */ {
/*    */   int stateButtonCount;
/*    */   int clickButtonCount;
/*    */   
/*    */   public String getName() {
/* 11 */     return "Minecraft Layout";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 17 */     LayoutManager.delete.icon = new Image(144, 12, 12, 12);
/* 18 */     LayoutManager.creative.icon = new Image(132, 12, 12, 12);
/* 19 */     LayoutManager.creative.icon2 = new Image(156, 12, 12, 12);
/* 20 */     LayoutManager.rain.icon = new Image(120, 12, 12, 12);
/* 21 */     LayoutManager.magnet.icon = new Image(180, 24, 12, 12);
/* 22 */     LayoutManager.dawn.icon = new Image(132, 24, 12, 12);
/* 23 */     LayoutManager.noon.icon = new Image(120, 24, 12, 12);
/* 24 */     LayoutManager.dusk.icon = new Image(144, 24, 12, 12);
/* 25 */     LayoutManager.midnight.icon = new Image(156, 24, 12, 12);
/* 26 */     LayoutManager.heal.icon = new Image(168, 24, 12, 12);
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
/* 38 */     boolean edgeAlign = NEIConfig.getBooleanSetting("options.edge-align buttons");
/* 39 */     int offsetx = edgeAlign ? 0 : 6;
/* 40 */     int offsety = edgeAlign ? 0 : 3;
/*    */     
/* 42 */     if ((button.state & 0x4) != 0) {
/*    */       
/* 44 */       button.x = offsetx + this.stateButtonCount * 20;
/* 45 */       button.y = offsety;
/* 46 */       this.stateButtonCount++;
/*    */     }
/*    */     else {
/*    */       
/* 50 */       button.x = offsetx + this.clickButtonCount % 4 * 20;
/* 51 */       button.y = offsety + (1 + this.clickButtonCount / 4) * 18;
/* 52 */       this.clickButtonCount++;
/*    */     } 
/*    */     
/* 55 */     button.height = 17;
/* 56 */     button.setOwnWidth(gui);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\LayoutStyleMinecraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */