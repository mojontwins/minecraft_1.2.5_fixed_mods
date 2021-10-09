/*    */ package codechicken.nei;
/*    */ 
/*    */ public class ItemQuantityField
/*    */   extends TextField
/*    */ {
/*    */   public ItemQuantityField(String ident) {
/*  7 */     super(ident);
/*  8 */     this.centered = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isValid(String string) {
/* 14 */     if (string.equals("")) {
/* 15 */       return true;
/*    */     }
/*    */     
/*    */     try {
/* 19 */       return (Integer.parseInt(string) >= 0);
/*    */     }
/* 21 */     catch (NumberFormatException nfe) {
/*    */       
/* 23 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int intValue() {
/*    */     try {
/* 31 */       return Integer.parseInt(this.text);
/*    */     }
/* 33 */     catch (NumberFormatException nfe) {
/*    */       
/* 35 */       return 0;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void loseFocus() {
/* 42 */     setText(Integer.toString(NEIConfig.getItemQuantity()));
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemQuantityField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */