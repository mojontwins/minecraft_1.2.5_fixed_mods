/*     */ package codechicken.nei;
/*     */ 
/*     */ import ady;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
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
/*     */ public class ItemRange
/*     */ {
/*     */   public int firstID;
/*     */   public int firstDamage;
/*     */   public int lastID;
/*     */   public int lastDamage;
/*     */   public byte state;
/*     */   public HashSet encompassedhash;
/*     */   public ArrayList encompasseditems;
/*     */   
/*     */   public ItemRange(int itemID) {
/* 226 */     this.firstDamage = -1;
/*     */     
/* 228 */     this.lastDamage = -1;
/* 229 */     this.state = 0;
/*     */     
/* 231 */     this.encompassedhash = new HashSet();
/* 232 */     this.encompasseditems = new ArrayList(); this.firstID = itemID; this.firstDamage = -1; this.lastID = itemID; this.lastDamage = -1; } public ItemRange(int itemID, int damageStart, int damageEnd) { this.firstDamage = -1; this.lastDamage = -1; this.state = 0; this.encompassedhash = new HashSet(); this.encompasseditems = new ArrayList(); this.firstID = itemID; this.firstDamage = damageStart; this.lastID = itemID; this.lastDamage = damageEnd; } public ItemRange(int itemIDFirst, int itemIDLast) { this.firstDamage = -1; this.lastDamage = -1; this.state = 0; this.encompassedhash = new HashSet(); this.encompasseditems = new ArrayList(); this.firstID = itemIDFirst; this.firstDamage = -1; this.lastID = itemIDLast; this.lastDamage = -1; } public ItemRange(String rangestring) { this.firstDamage = -1; this.lastDamage = -1; this.state = 0; this.encompassedhash = new HashSet(); this.encompasseditems = new ArrayList();
/*     */     rangestring = rangestring.replace(" ", "");
/*     */     rangestring = rangestring.replace("\t", "");
/*     */     rangestring = rangestring.substring(1, rangestring.length() - 1);
/*     */     String[] damagesplit = rangestring.split(":");
/*     */     if (damagesplit.length == 2) {
/*     */       String[] rangesplit = damagesplit[1].split("-");
/*     */       this.firstID = Integer.parseInt(damagesplit[0]);
/*     */       this.lastID = this.firstID;
/*     */       this.firstDamage = Integer.parseInt(rangesplit[0]);
/*     */       if (rangesplit.length == 2) {
/*     */         this.lastDamage = Integer.parseInt(rangesplit[1]);
/*     */       } else {
/*     */         this.lastDamage = this.firstDamage;
/*     */       } 
/*     */     } else {
/*     */       String[] rangesplit = damagesplit[0].split("-");
/*     */       this.firstID = Integer.parseInt(rangesplit[0]);
/*     */       if (rangesplit.length == 2) {
/*     */         this.lastID = Integer.parseInt(rangesplit[1]);
/*     */       } else {
/*     */         this.lastID = this.firstID;
/*     */       } 
/*     */     }  }
/*     */ 
/*     */   
/*     */   public boolean isItemInRange(int id, int damage) {
/*     */     if (id >= this.firstID && id <= this.lastID && (this.firstDamage == -1 || (damage >= this.firstDamage && damage <= this.lastDamage)))
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     if (this.firstID == this.lastID) {
/*     */       if (this.firstDamage == -1)
/*     */         return "[" + this.firstID + "]"; 
/*     */       if (this.firstDamage == this.lastDamage)
/*     */         return "[" + this.firstID + ":" + this.firstDamage + "]"; 
/*     */       return "[" + this.firstID + ":" + this.firstDamage + "-" + this.lastDamage + "]";
/*     */     } 
/*     */     return "[" + this.firstID + "-" + this.lastID + "]";
/*     */   }
/*     */   
/*     */   public void updateState(ItemVisibilityHash vis) {
/*     */     boolean allhidden = false;
/*     */     boolean allshown = false;
/*     */     for (ItemHash item : this.encompasseditems) {
/*     */       if (vis.isItemHidden(item)) {
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
/*     */   public void resetHashes() {
/*     */     this.encompassedhash.clear();
/*     */     this.encompasseditems.clear();
/*     */   }
/*     */   
/*     */   public boolean addItemIfInRange(int item, int damage, ady compound) {
/*     */     if (isItemInRange(item, damage)) {
/*     */       ItemHash hash = new ItemHash(item, damage, compound);
/*     */       if (this.encompassedhash.add(hash)) {
/*     */         this.encompasseditems.add(hash);
/*     */         return true;
/*     */       } 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void onClick(int itemno, int button, boolean doubleclick) {
/*     */     ItemVisibilityHash vis = NEIConfig.vishash;
/*     */     ItemHash item = this.encompasseditems.get(itemno);
/*     */     if (NEIUtils.controlKey()) {
/*     */       NEIUtils.cheatItem(item.toStack(), button, 0);
/*     */       return;
/*     */     } 
/*     */     if (button == 0) {
/*     */       if (doubleclick)
/*     */         DropDownFile.dropDownInstance.hideAllItems(); 
/*     */       vis.unhideItem(item);
/*     */     } else if (button == 1) {
/*     */       vis.hideItem(item);
/*     */     } 
/*     */     DropDownFile.dropDownInstance.updateState();
/*     */     NEIUtils.loadItems();
/*     */     NEIConfig.vishash.save();
/*     */   }
/*     */   
/*     */   public void hideAllItems() {
/*     */     ItemVisibilityHash vis = NEIConfig.vishash;
/*     */     for (ItemHash item : this.encompasseditems)
/*     */       vis.hideItem(item); 
/*     */   }
/*     */   
/*     */   public void showAllItems() {
/*     */     ItemVisibilityHash vis = NEIConfig.vishash;
/*     */     for (ItemHash item : this.encompasseditems)
/*     */       vis.unhideItem(item); 
/*     */   }
/*     */   
/*     */   public ArrayList toIDList() {
/*     */     ArrayList<Integer> list = new ArrayList();
/*     */     for (int i = this.firstID; i <= this.lastID; i++)
/*     */       list.add(Integer.valueOf(i)); 
/*     */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */