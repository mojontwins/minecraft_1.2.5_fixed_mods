/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPanel
/*     */   extends Widget
/*     */ {
/*     */   private int page;
/*     */   private int itemsPerPage;
/*     */   private int rows;
/*  20 */   private int numPages = 0;
/*  21 */   public ItemPanelObject hoverItem = null;
/*     */   
/*     */   private int columns;
/*     */   
/*     */   public void resize() {
/*  26 */     this.marginLeft = this.x + this.width % 18 / 2;
/*  27 */     this.marginTop = this.y + this.height % 18 / 2;
/*  28 */     this.columns = this.width / 18;
/*  29 */     this.rows = this.height / 18;
/*  30 */     this.itemsPerPage = this.rows * this.columns;
/*     */     
/*  32 */     this.numPages = (int)Math.ceil((NEIController.visibleitems.size() / this.itemsPerPage));
/*  33 */     setPage(this.page);
/*     */   }
/*     */   private int marginTop; private int marginLeft;
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/*  38 */     List<ItemPanelObject> visibleitems = NEIController.visibleitems;
/*  39 */     if (visibleitems.size() == 0)
/*     */       return; 
/*  41 */     int itemIndex = this.page * this.itemsPerPage;
/*  42 */     int lastIndex = (this.itemsPerPage * (this.page + 1) < visibleitems.size()) ? (this.itemsPerPage * (this.page + 1)) : visibleitems.size();
/*  43 */     int colIndex = 0;
/*  44 */     int rowIndex = 0;
/*  45 */     this.hoverItem = null;
/*  46 */     while (itemIndex < lastIndex) {
/*     */       
/*  48 */       ItemPanelObject item = visibleitems.get(itemIndex);
/*     */       
/*  50 */       int posX = this.marginLeft + colIndex * 18;
/*  51 */       int posY = this.marginTop + rowIndex * 18;
/*     */       
/*  53 */       if (mousex >= posX && mousex < posX + 18 && 
/*  54 */         mousey >= posY && mousey < posY + 18) {
/*     */         
/*  56 */         this.hoverItem = item;
/*  57 */         gui.drawRect(posX - 1, posY - 1, 18, 18, -296397483);
/*     */       } 
/*     */       
/*  60 */       item.draw(gui, posX, posY);
/*     */       
/*  62 */       itemIndex++;
/*  63 */       colIndex++;
/*  64 */       if (colIndex == this.columns) {
/*     */         
/*  66 */         colIndex = 0;
/*  67 */         rowIndex++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleClick(int i, int j, int k) {
/*  74 */     if (NEIUtils.getHeldItem() != null) {
/*     */       
/*  76 */       if (NEIConfig.isActionPermissable(InterActionMap.DELETE)) {
/*     */         
/*  78 */         if (k == 1)
/*     */         {
/*  80 */           NEIUtils.decreaseSlotStack(-999);
/*     */         }
/*     */         else
/*     */         {
/*  84 */           NEIUtils.deleteHeldItem();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  89 */         NEIUtils.dropHeldItem();
/*     */       } 
/*  91 */       return true;
/*     */     } 
/*     */     
/*  94 */     if (this.hoverItem != null)
/*  95 */       this.hoverItem.handleClick(k); 
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onMouseWheel(int i, int mousex, int mousey) {
/* 101 */     if (!contains(mousex, mousey)) {
/* 102 */       return false;
/*     */     }
/* 104 */     scroll(i);
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleKeyPress(int keyID, char keyChar) {
/* 111 */     if (keyID == NEIConfig.getKeyBinding("next")) {
/*     */       
/* 113 */       scroll(1);
/* 114 */       return true;
/*     */     } 
/* 116 */     if (keyID == NEIConfig.getKeyBinding("prev")) {
/*     */       
/* 118 */       scroll(-1);
/* 119 */       return true;
/*     */     } 
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public aan getStackMouseOver(int mousex, int mousey) {
/* 126 */     return (this.hoverItem instanceof ItemPanelStack) ? ((ItemPanelStack)this.hoverItem).item : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List handleTooltip(int mx, int my, List tooltip) {
/* 132 */     if (this.hoverItem == null) {
/* 133 */       return tooltip;
/*     */     }
/* 135 */     return this.hoverItem.handleTooltip(tooltip);
/*     */   }
/*     */ 
/*     */   
/*     */   public void scroll(int i) {
/* 140 */     setPage(this.page + i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPage(int i) {
/* 145 */     if (this.numPages == 0) {
/* 146 */       this.page = 0;
/*     */     } else {
/* 148 */       this.page = (i + this.numPages) % this.numPages;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPage() {
/* 153 */     return this.page;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumPages() {
/* 158 */     return this.numPages;
/*     */   }
/*     */   
/*     */   public static interface ItemPanelObject {
/*     */     void draw(GuiManager param1GuiManager, int param1Int1, int param1Int2);
/*     */     
/*     */     void handleClick(int param1Int);
/*     */     
/*     */     List handleTooltip(List param1List);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */