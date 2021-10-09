/*    */ package codechicken.nei;
/*    */ 
/*    */ import ModLoader;
/*    */ import aan;
/*    */ import java.util.List;
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
/*    */ public class PositionedStack
/*    */ {
/*    */   public int relx;
/*    */   public int rely;
/*    */   public aan[] items;
/*    */   public aan item;
/*    */   
/*    */   public PositionedStack(Object object, int x, int y) {
/* 24 */     if (object instanceof aan) {
/*    */       
/* 26 */       this.items = new aan[] { (aan)object };
/*    */     }
/* 28 */     else if (object instanceof aan[]) {
/*    */       
/* 30 */       this.items = (aan[])object;
/*    */     }
/* 32 */     else if (object instanceof List) {
/*    */       
/* 34 */       this.items = (aan[])((List)object).toArray((Object[])new aan[0]);
/*    */     }
/*    */     else {
/*    */       
/* 38 */       ModLoader.throwException("NEI", new ClassCastException("not an ItemStack or ItemStack[]"));
/*    */     } 
/* 40 */     setPermutationToRender(0);
/* 41 */     this.relx = x;
/* 42 */     this.rely = y;
/*    */   } public void setMaxSize(int i) {
/*    */     byte b;
/*    */     int j;
/*    */     aan[] arrayOfAan;
/* 47 */     for (j = (arrayOfAan = this.items).length, b = 0; b < j; ) { aan item = arrayOfAan[b];
/*    */       
/* 49 */       if (item.a > i)
/*    */       {
/* 51 */         item.a = i;
/*    */       }
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/*    */   public PositionedStack copy() {
/* 58 */     return new PositionedStack(this.items, this.relx, this.rely);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPermutationToRender(int index) {
/* 63 */     this.item = this.items[index];
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\PositionedStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */