/*    */ import codechicken.nei.ExtendedCreativeInv;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerCreativeInv
/*    */   extends dd
/*    */ {
/*    */   public ContainerCreativeInv(yw player) {
/* 15 */     aak invPlayer = player.ap;
/* 16 */     ExtendedCreativeInv extraInv = new ExtendedCreativeInv(player); int row;
/* 17 */     for (row = 0; row < 6; row++) {
/*    */       
/* 19 */       for (int i = 0; i < 9; i++)
/*    */       {
/* 21 */         a(new yu((io)extraInv, i + row * 9, 8 + i * 18, 5 + row * 18));
/*    */       }
/*    */     } 
/*    */     
/* 25 */     for (row = 0; row < 3; row++) {
/*    */       
/* 27 */       for (int i = 0; i < 9; i++)
/*    */       {
/* 29 */         a(new yu((io)invPlayer, i + row * 9 + 9, 8 + i * 18, 118 + row * 18));
/*    */       }
/*    */     } 
/*    */     
/* 33 */     for (int col = 0; col < 9; col++)
/*    */     {
/* 35 */       a(new yu((io)invPlayer, col, 8 + col * 18, 176));
/*    */     }
/*    */     
/* 38 */     for (int armourslot = 0; armourslot < 4; armourslot++)
/*    */     {
/* 40 */       a((yu)new afq(null, (io)invPlayer, invPlayer.a() - 1 - armourslot, -15, 23 + armourslot * 18, armourslot));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public aan a(int slotIndex) {
/* 47 */     aan transferredStack = null;
/* 48 */     yu slot = this.e.get(slotIndex);
/*    */     
/* 50 */     if (slot != null && slot.c()) {
/*    */       
/* 52 */       aan stack = slot.b();
/* 53 */       transferredStack = stack.k();
/*    */       
/* 55 */       if (slotIndex < 54) {
/*    */         
/* 57 */         if (!a(stack, 54, this.e.size(), true))
/*    */         {
/* 59 */           return null;
/*    */         }
/*    */       }
/* 62 */       else if (!a(stack, 0, 54, false)) {
/*    */         
/* 64 */         return null;
/*    */       } 
/*    */       
/* 67 */       if (stack.a == 0) {
/*    */         
/* 69 */         slot.d(null);
/*    */       }
/*    */       else {
/*    */         
/* 73 */         slot.d();
/*    */       } 
/*    */     } 
/*    */     
/* 77 */     return transferredStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean b(yw var1) {
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\ContainerCreativeInv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */