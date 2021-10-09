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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GuiNEISettings.NEIOption
/*    */ {
/*    */   null(String $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIdent() {
/* 49 */     return NEIConfig.isMultiplayer() ? "options.enablemp" : "options.enable";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String updateText() {
/* 55 */     return "NEI " + (enabled() ? "Enabled" : "Disabled");
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIConfig$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */