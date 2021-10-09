/*    */ package codechicken.nei;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public class WidgetZOrder
/*    */   implements Comparator
/*    */ {
/*    */   boolean topfirst;
/*    */   
/*    */   public WidgetZOrder(boolean topfirst) {
/* 11 */     this.topfirst = topfirst;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Widget w1, Widget w2) {
/* 16 */     return (w1.z != w2.z) ? ((this.topfirst ? (w1.z > w2.z) : (w1.z < w2.z)) ? 1 : -1) : 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\WidgetZOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */