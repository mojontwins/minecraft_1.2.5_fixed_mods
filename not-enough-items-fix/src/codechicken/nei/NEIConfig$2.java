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
/* 62 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   public String updateText() {
/* 67 */     (new String[3])[0] = "Recipe"; (new String[3])[1] = "Utility"; (new String[3])[2] = "Cheat"; return String.valueOf((new String[3])[intValue()]) + " Mode";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onClick() {
/* 73 */     NEIConfig.cycleCheatMode();
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIConfig$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */