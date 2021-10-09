/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import ady;
/*     */ import codechicken.core.ReflectionManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import pb;
/*     */ import yr;
/*     */ 
/*     */ 
/*     */ public class MultiItemRange
/*     */ {
/*     */   public ArrayList ranges;
/*     */   public byte state;
/*     */   protected int lastslotclicked;
/*     */   protected long lastslotclicktime;
/*     */   
/*     */   public boolean isItemInRange(int itemid, int damage) {
/*  20 */     for (ItemRange range : this.ranges) {
/*     */       
/*  22 */       if (range.isItemInRange(itemid, damage))
/*     */       {
/*  24 */         return true;
/*     */       }
/*     */     } 
/*  27 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  32 */     StringBuilder rangestring = new StringBuilder();
/*  33 */     boolean addcomma = false;
/*  34 */     for (ItemRange range : this.ranges) {
/*     */       
/*  36 */       if (addcomma) {
/*     */         
/*  38 */         rangestring.append(',');
/*     */       }
/*     */       else {
/*     */         
/*  42 */         addcomma = true;
/*     */       } 
/*  44 */       rangestring.append(range.toString());
/*     */     } 
/*  46 */     return rangestring.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultiItemRange(String rangestring) {
/* 266 */     this.lastslotclicked = -1; this.ranges = new ArrayList(); String[] separatedpairs = rangestring.split(","); byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = separatedpairs).length, b = 0; b < i; ) { String pairstring = arrayOfString1[b]; this.ranges.add(new ItemRange(pairstring)); b++; }  } public MultiItemRange() { this.lastslotclicked = -1;
/*     */     this.ranges = new ArrayList(); }
/*     */ 
/*     */   
/*     */   public MultiItemRange add(ItemRange range) {
/*     */     this.ranges.add(range);
/*     */     return this;
/*     */   }
/*     */   
/*     */   public MultiItemRange add(Collection ranges) {
/*     */     for (Object o : ranges) {
/*     */       try {
/*     */         ReflectionManager.callMethod(getClass(), this, "add", new Object[] { o });
/*     */       } catch (Exception e) {
/*     */         NEIUtils.reportException(e);
/*     */       } 
/*     */     } 
/*     */     return this;
/*     */   }
/*     */   
/*     */   public MultiItemRange add(MultiItemRange range) {
/*     */     return add(range.ranges);
/*     */   }
/*     */   
/*     */   public MultiItemRange add(int itemID) {
/*     */     return add(new ItemRange(itemID));
/*     */   }
/*     */   
/*     */   public MultiItemRange add(int itemID, int damageStart, int damageEnd) {
/*     */     return add(new ItemRange(itemID, damageStart, damageEnd));
/*     */   }
/*     */   
/*     */   public MultiItemRange add(int itemIDFirst, int itemIDLast) {
/*     */     return add(new ItemRange(itemIDFirst, itemIDLast));
/*     */   }
/*     */   
/*     */   public MultiItemRange add(yr item, int damageStart, int damageEnd) {
/*     */     return add(item.bQ, damageStart, damageEnd);
/*     */   }
/*     */   
/*     */   public MultiItemRange add(pb block, int damageStart, int damageEnd) {
/*     */     return add(block.bO, damageStart, damageEnd);
/*     */   }
/*     */   
/*     */   public MultiItemRange add(yr item) {
/*     */     return add(item.bQ);
/*     */   }
/*     */   
/*     */   public MultiItemRange add(pb block) {
/*     */     return add(block.bO);
/*     */   }
/*     */   
/*     */   public MultiItemRange add(aan item) {
/*     */     if (item.a().i())
/*     */       return add(item.c); 
/*     */     return add(item.c, item.i(), item.i());
/*     */   }
/*     */   
/*     */   public int getNumSlots() {
/*     */     int slots = 0;
/*     */     for (ItemRange range : this.ranges)
/*     */       slots += range.encompasseditems.size(); 
/*     */     return slots;
/*     */   }
/*     */   
/*     */   public void slotClicked(int slot, int button, boolean doubleclick) {
/*     */     int i = 0;
/*     */     for (ItemRange range : this.ranges) {
/*     */       if (i + range.encompasseditems.size() <= slot) {
/*     */         i += range.encompasseditems.size();
/*     */         continue;
/*     */       } 
/*     */       for (int item = 0; item < range.encompasseditems.size(); item++) {
/*     */         if (slot == i) {
/*     */           range.onClick(item, button, doubleclick);
/*     */           return;
/*     */         } 
/*     */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hideAllItems() {
/*     */     for (ItemRange range : this.ranges)
/*     */       range.hideAllItems(); 
/*     */   }
/*     */   
/*     */   public void showAllItems() {
/*     */     for (ItemRange range : this.ranges)
/*     */       range.showAllItems(); 
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*     */     return 18;
/*     */   }
/*     */   
/*     */   public void resetHashes() {
/*     */     for (ItemRange range : this.ranges)
/*     */       range.resetHashes(); 
/*     */   }
/*     */   
/*     */   public void updateState(ItemVisibilityHash vis) {
/*     */     boolean allshown = false;
/*     */     boolean allhidden = false;
/*     */     for (ItemRange range : this.ranges) {
/*     */       if (range.encompasseditems.size() == 0)
/*     */         continue; 
/*     */       range.updateState(vis);
/*     */       int rstate = range.state;
/*     */       if (rstate == 1) {
/*     */         this.state = 1;
/*     */         return;
/*     */       } 
/*     */       if (rstate == 0) {
/*     */         if (allshown) {
/*     */           this.state = 1;
/*     */           return;
/*     */         } 
/*     */         allhidden = true;
/*     */         continue;
/*     */       } 
/*     */       if (allhidden) {
/*     */         this.state = 1;
/*     */         return;
/*     */       } 
/*     */       allshown = true;
/*     */     } 
/*     */     if (allshown) {
/*     */       this.state = 2;
/*     */     } else {
/*     */       this.state = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemIfInRange(int item, int damage, ady compound) {
/*     */     for (ItemRange range : this.ranges) {
/*     */       if (range.addItemIfInRange(item, damage, compound))
/*     */         break; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\MultiItemRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */