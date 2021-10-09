/*    */ package codechicken.nei;
/*    */ 
/*    */ public enum InterActionMap
/*    */ {
/*  5 */   TIME(false),
/*  6 */   CREATIVE(false),
/*  7 */   RAIN(false),
/*  8 */   ITEM(false),
/*  9 */   HEAL(false),
/* 10 */   DELETE(true),
/* 11 */   MAGNET(true),
/* 12 */   ENCHANT(true);
/*    */   
/*    */   public boolean requiresSMPCounterpart;
/*    */   public static final int protocol = 4;
/*    */   
/*    */   InterActionMap(boolean requiresSMPCounterpart) {
/* 18 */     this.requiresSMPCounterpart = requiresSMPCounterpart;
/*    */   }
/*    */ 
/*    */   
/*    */   public static InterActionMap getAction(String name) {
/* 23 */     return valueOf(name.toUpperCase());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 28 */     return name().toLowerCase();
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\InterActionMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */