/*    */ package codechicken.nei;
/*    */ 
/*    */ import aak;
/*    */ import aan;
/*    */ 
/*    */ 
/*    */ public class InfiniteToolHandler
/*    */   implements IInfiniteItemHandler
/*    */ {
/*    */   public void onPickup(aan heldItem) {
/* 11 */     heldItem.b(0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlaceInfinite(aan heldItem) {
/* 17 */     heldItem.b(-32000);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void replenishInfiniteStack(aak inv, int slotNo) {
/* 23 */     inv.k_(slotNo).b(-32000);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canHandleItem(aan stack) {
/* 29 */     return (stack.a().i() && stack.c() == 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isItemInfinite(aan stack) {
/* 35 */     return (stack.i() < -30000);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public aan getInfiniteItem(aan typeStack) {
/* 41 */     return new aan(typeStack.c, 1, -32000);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\InfiniteToolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */