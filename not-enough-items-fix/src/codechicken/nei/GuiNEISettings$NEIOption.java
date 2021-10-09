/*    */ package codechicken.nei;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NEIOption
/*    */ {
/*    */   private String tagName;
/*    */   private boolean globalOnly = false;
/*    */   
/*    */   public NEIOption(String n) {
/* 19 */     this.tagName = n;
/*    */   }
/*    */ 
/*    */   
/*    */   public NEIOption setGlobalOnly() {
/* 24 */     this.globalOnly = true;
/* 25 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClick() {
/* 30 */     NEIConfig.toggleBooleanSetting(getIdent());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIdent() {
/* 35 */     return this.tagName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean enabled() {
/* 46 */     return NEIConfig.getBooleanSetting(getIdent());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int intValue() {
/* 55 */     return NEIConfig.getIntSetting(getIdent());
/*    */   }
/*    */   
/*    */   public abstract String updateText();
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEISettings$NEIOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */