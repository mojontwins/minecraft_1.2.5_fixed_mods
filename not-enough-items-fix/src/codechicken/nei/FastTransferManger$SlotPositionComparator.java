/*    */ package codechicken.nei;
/*    */ 
/*    */ import dd;
/*    */ import java.util.Comparator;
/*    */ import yu;
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
/*    */ public class SlotPositionComparator
/*    */   implements Comparator
/*    */ {
/*    */   dd container;
/*    */   
/*    */   public SlotPositionComparator(dd c) {
/* 27 */     this.container = c;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Integer arg0, Integer arg1) {
/* 33 */     yu slot1 = this.container.b(arg0.intValue());
/* 34 */     yu slot2 = this.container.b(arg1.intValue());
/*    */     
/* 36 */     if (slot2.e != slot1.e) return slot1.e - slot2.e; 
/* 37 */     return slot1.d - slot2.d;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FastTransferManger$SlotPositionComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */