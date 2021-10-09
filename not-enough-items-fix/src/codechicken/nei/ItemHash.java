/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import ady;
/*    */ 
/*    */ public class ItemHash implements Comparable {
/*    */   public short item;
/*    */   
/*    */   public ItemHash(int itemID, int itemDamage, ady compound) {
/* 10 */     this.item = (short)itemID;
/* 11 */     this.damage = (short)itemDamage;
/* 12 */     this.moreinfo = compound;
/*    */   }
/*    */   public short damage; public ady moreinfo;
/*    */   
/*    */   public ItemHash(aan stack) {
/* 17 */     this.item = (short)stack.c;
/* 18 */     this.damage = (short)stack.i();
/* 19 */     this.moreinfo = stack.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemHash(int itemID, int itemDamage) {
/* 24 */     this(itemID, itemDamage, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 29 */     if (obj instanceof ItemHash) {
/*    */       
/* 31 */       ItemHash hash = (ItemHash)obj;
/* 32 */       if (hash.item == this.item && hash.damage == this.damage && (
/* 33 */         this.moreinfo == hash.moreinfo || (this.moreinfo != null && this.moreinfo.equals(hash.moreinfo)))) return true; 
/*    */       return false;
/*    */     } 
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 42 */     return (this.item << 16) + this.damage;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(ItemHash o) {
/* 47 */     if (o.item != this.item) return Integer.valueOf(this.item).compareTo(Integer.valueOf(o.item)); 
/* 48 */     if (o.damage != this.damage) return Integer.valueOf(this.damage).compareTo(Integer.valueOf(o.damage)); 
/* 49 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public aan toStack() {
/* 54 */     aan stack = new aan(this.item, 1, this.damage);
/* 55 */     stack.d = this.moreinfo;
/* 56 */     return stack;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */