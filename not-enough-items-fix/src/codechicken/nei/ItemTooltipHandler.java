/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import gb;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ItemTooltipHandler
/*    */   implements IHandleTooltip
/*    */ {
/*    */   public boolean canHandle(Class guiClass) {
/* 17 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List handleTooltip(gb gui, List currenttip) {
/* 23 */     aan stack = gui.getStackMouseOver();
/* 24 */     if (stack == null) {
/* 25 */       return currenttip;
/*    */     }
/* 27 */     return handleTooltip(stack, currenttip);
/*    */   }
/*    */   
/*    */   public abstract List handleTooltip(aan paramaan, List paramList);
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemTooltipHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */