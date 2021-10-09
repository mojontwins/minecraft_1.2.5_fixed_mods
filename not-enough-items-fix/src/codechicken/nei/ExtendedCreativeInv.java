/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import io;
/*    */ import yw;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExtendedCreativeInv
/*    */   implements io
/*    */ {
/*    */   public ExtendedCreativeInv(yw player) {}
/*    */   
/*    */   public int a() {
/* 15 */     return 54;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public aan k_(int slot) {
/* 21 */     return NEIConfig.creativeInv[slot];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public aan a(int slot, int size) {
/* 27 */     aan item = k_(slot);
/*    */     
/* 29 */     if (item != null) {
/*    */       
/* 31 */       if (item.a <= size) {
/*    */         
/* 33 */         aan itemstack = item;
/* 34 */         a(slot, (aan)null);
/* 35 */         j();
/* 36 */         return itemstack;
/*    */       } 
/* 38 */       aan itemstack1 = item.a(size);
/* 39 */       if (item.a == 0)
/*    */       {
/* 41 */         a(slot, (aan)null);
/*    */       }
/* 43 */       j();
/* 44 */       return itemstack1;
/*    */     } 
/*    */     
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public aan b(int slot) {
/* 54 */     synchronized (this) {
/*    */       
/* 56 */       aan stack = k_(slot);
/* 57 */       a(slot, (aan)null);
/* 58 */       return stack;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(int slot, aan stack) {
/* 65 */     NEIConfig.creativeInv[slot] = stack;
/* 66 */     NEIConfig.saveCreativeInv();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String c() {
/* 72 */     return "Extended Creative";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int d() {
/* 78 */     return 64;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void j() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean a_(yw var1) {
/* 90 */     return true;
/*    */   }
/*    */   
/*    */   public void e() {}
/*    */   
/*    */   public void f() {}
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ExtendedCreativeInv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */