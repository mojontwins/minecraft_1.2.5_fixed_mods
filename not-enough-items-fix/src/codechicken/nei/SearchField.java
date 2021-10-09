/*    */ package codechicken.nei;
/*    */ 
/*    */ public class SearchField extends TextField {
/*    */   long lastclicktime;
/*    */   
/*    */   public SearchField(String ident) {
/*  7 */     super(ident);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawBox(GuiManager gui) {
/* 13 */     if (NEIConfig.getBooleanSetting("options.searchinventories")) {
/* 14 */       gui.drawGradientRect(this.x, this.y, this.width, this.height, -256, -4149248);
/*    */     } else {
/* 16 */       gui.drawRect(this.x, this.y, this.width, this.height, -6250336);
/* 17 */     }  gui.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2, -16777216);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean handleClick(int mousex, int mousey, int button) {
/* 23 */     if (button == 0) {
/*    */       
/* 25 */       if (focused() && System.currentTimeMillis() - this.lastclicktime < 500L)
/*    */       {
/* 27 */         NEIConfig.toggleBooleanSetting("options.searchinventories");
/*    */       }
/* 29 */       this.lastclicktime = System.currentTimeMillis();
/*    */     } 
/* 31 */     return super.handleClick(mousex, mousey, button);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\SearchField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */