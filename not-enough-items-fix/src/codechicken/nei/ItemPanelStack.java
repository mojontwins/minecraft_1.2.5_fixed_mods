/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPanelStack
/*    */   implements ItemPanel.ItemPanelObject
/*    */ {
/*    */   aan item;
/*    */   
/*    */   public ItemPanelStack(aan itemstack) {
/* 14 */     this.item = itemstack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(GuiManager gui, int x, int y) {
/* 20 */     gui.drawItem(x, y, this.item);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClick(int button) {
/* 26 */     NEIController.onItemEvent(this.item, button);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List handleTooltip(List tooltip) {
/* 32 */     return NEIUtils.itemDisplayNameMultiline(this.item, NEIConfig.showIDs());
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemPanelStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */