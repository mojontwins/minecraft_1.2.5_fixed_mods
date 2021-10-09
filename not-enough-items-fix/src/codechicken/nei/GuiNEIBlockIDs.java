/*    */ package codechicken.nei;
/*    */ 
/*    */ import gb;
/*    */ 
/*    */ public class GuiNEIBlockIDs
/*    */   extends GuiNEISettings
/*    */ {
/*    */   public GuiNEIBlockIDs(gb parentContainer) {
/*  9 */     super(parentContainer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getBackButtonName() {
/* 15 */     return "Settings";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onBackButtonClick() {
/* 21 */     this.p.a(new GuiNEISettings(this.parentScreen));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void a() {
/* 27 */     super.a();
/*    */     
/* 29 */     if (!NEIConfig.canDump()) {
/* 30 */       NEIConfig.getSetting("ID dump.dump on load").setBooleanValue(false);
/*    */     }
/* 32 */     updateButtonNames();
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEIBlockIDs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */