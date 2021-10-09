/*    */ package codechicken.nei;
/*    */ 
/*    */ import aak;
/*    */ import aan;
/*    */ 
/*    */ 
/*    */ public class InfiniteStackSizeHandler
/*    */   implements IInfiniteItemHandler
/*    */ {
/*    */   public void onPickup(aan heldItem) {
/* 11 */     heldItem.a = 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlaceInfinite(aan heldItem) {
/* 17 */     heldItem.a = 111;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canHandleItem(aan stack) {
/* 23 */     return !stack.e();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isItemInfinite(aan stack) {
/* 29 */     return !(stack.a != -1 && stack.a <= 100);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void replenishInfiniteStack(aak inv, int slotNo) {
/* 35 */     aan stack = inv.k_(slotNo);
/* 36 */     stack.a = 111;
/*    */     
/* 38 */     for (int i = 0; i < inv.a(); i++) {
/*    */       
/* 40 */       if (i != slotNo)
/*    */       {
/*    */         
/* 43 */         if (NEIUtils.areStacksSameType(stack, inv.k_(i)))
/*    */         {
/* 45 */           inv.a(i, null);
/*    */         }
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public aan getInfiniteItem(aan typeStack) {
/* 53 */     return new aan(typeStack.c, -1, typeStack.i());
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\InfiniteStackSizeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */