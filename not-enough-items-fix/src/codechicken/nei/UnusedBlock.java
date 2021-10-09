/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import java.util.List;
/*    */ import pb;
/*    */ 
/*    */ public class UnusedBlock
/*    */   implements ItemPanel.ItemPanelObject
/*    */ {
/*    */   int blockID;
/*    */   
/*    */   public UnusedBlock(int id) {
/* 13 */     this.blockID = id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(GuiManager gui, int x, int y) {
/* 21 */     gui.drawItem(x, y, new aan(pb.bu));
/* 22 */     gui.drawTextCentered(x, y, 16, 16, this.blockID, 16777215);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClick(int button) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public List handleTooltip(List<String> tooltip) {
/* 33 */     tooltip.add("Unused BlockID: " + this.blockID);
/* 34 */     return tooltip;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\UnusedBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */