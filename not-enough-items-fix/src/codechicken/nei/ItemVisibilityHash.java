/*     */ package codechicken.nei;
/*     */ 
/*     */ import ady;
/*     */ import gh;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import no;
/*     */ import zl;
/*     */ 
/*     */ public class ItemVisibilityHash
/*     */ {
/*     */   public static class IDInfo {
/*  16 */     public TreeSet damages = new TreeSet();
/*  17 */     public ArrayList compounds = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemVisibilityHash() {
/*     */     try {
/*  24 */       loadFromCompound(getCurrentSaveCompound());
/*     */     }
/*  26 */     catch (Exception e) {
/*     */       
/*  28 */       NEIUtils.reportException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ady getCurrentSaveCompound() {
/*  34 */     ady hashSave = NEIConfig.saveCompound.m("vis");
/*  35 */     NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */     
/*  37 */     ady currentSave = hashSave.m("current");
/*  38 */     hashSave.a("current", currentSave);
/*  39 */     return currentSave;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hideItem(int item) {
/*  44 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/*  45 */     if (info == null) {
/*     */       
/*  47 */       info = new IDInfo();
/*  48 */       this.hiddenitems.put(Integer.valueOf(item), info);
/*     */     } 
/*  50 */     info.damages.add(Short.valueOf((short)-1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hideItem(int item, int damage) {
/*  55 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/*  56 */     if (info == null) {
/*     */       
/*  58 */       info = new IDInfo();
/*  59 */       this.hiddenitems.put(Integer.valueOf(item), info);
/*     */     } 
/*  61 */     info.damages.add(Short.valueOf((short)damage));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hideItem(int item, ady stackTagCompound) {
/*  66 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/*  67 */     if (info == null) {
/*     */       
/*  69 */       info = new IDInfo();
/*  70 */       this.hiddenitems.put(Integer.valueOf(item), info);
/*     */     } 
/*  72 */     if (!info.compounds.contains(stackTagCompound))
/*     */     {
/*  74 */       info.compounds.add(stackTagCompound);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hideItem(ItemHash item) {
/*  80 */     if (item.moreinfo != null) {
/*     */       
/*  82 */       hideItem(item.item, item.moreinfo);
/*     */     }
/*     */     else {
/*     */       
/*  86 */       hideItem(item.item, item.damage);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unhideItem(int item) {
/*  92 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/*  93 */     if (info == null) {
/*     */       return;
/*     */     }
/*     */     
/*  97 */     this.hiddenitems.remove(Integer.valueOf(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unhideItem(int item, int damage) {
/* 103 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/* 104 */     if (info == null) {
/*     */       return;
/*     */     }
/*     */     
/* 108 */     if (damage == -1) {
/*     */       
/* 110 */       this.hiddenitems.remove(Integer.valueOf(item));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 115 */     info.damages.remove(Short.valueOf((short)damage));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unhideItem(int item, ady stackTagCompound) {
/* 121 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/* 122 */     if (info == null) {
/*     */       return;
/*     */     }
/*     */     
/* 126 */     info.compounds.remove(stackTagCompound);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unhideItem(ItemHash item) {
/* 131 */     if (item.moreinfo != null) {
/*     */       
/* 133 */       unhideItem(item.item, item.moreinfo);
/*     */     }
/*     */     else {
/*     */       
/* 137 */       unhideItem(item.item, item.damage);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemHidden(int itemID, int damage) {
/* 143 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(itemID));
/* 144 */     if (info == null)
/*     */     {
/* 146 */       return false;
/*     */     }
/* 148 */     return !(!info.damages.contains(Short.valueOf((short)damage)) && !info.damages.contains(Short.valueOf((short)-1)));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemHidden(int item) {
/* 153 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item));
/* 154 */     if (info == null)
/*     */     {
/* 156 */       return false;
/*     */     }
/* 158 */     return info.damages.contains(Short.valueOf((short)-1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemHidden(int itemID, ady stackTagCompound) {
/* 163 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(itemID));
/* 164 */     if (info == null)
/*     */     {
/* 166 */       return false;
/*     */     }
/* 168 */     return info.compounds.contains(stackTagCompound);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isItemHidden(ItemHash item) {
/* 173 */     IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(item.item));
/* 174 */     if (info == null)
/*     */     {
/* 176 */       return false;
/*     */     }
/* 178 */     if (info.damages.contains(Short.valueOf(item.damage)) || info.damages.contains(Short.valueOf((short)-1)))
/*     */     {
/* 180 */       return true;
/*     */     }
/* 182 */     if (item.moreinfo != null)
/*     */     {
/* 184 */       return info.compounds.contains(item.moreinfo);
/*     */     }
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void loadFromCompound(ady readTag) {
/* 191 */     this.hiddenitems = new TreeMap<Object, Object>();
/* 192 */     for (Object obj : readTag.d()) {
/*     */       
/* 194 */       if (obj instanceof no) {
/*     */         
/* 196 */         no compoundlist = (no)obj;
/*     */         
/* 198 */         int itemID = Integer.parseInt(compoundlist.c().substring(1));
/* 199 */         IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(itemID));
/* 200 */         if (info == null) {
/*     */           
/* 202 */           info = new IDInfo();
/* 203 */           this.hiddenitems.put(Integer.valueOf(itemID), info);
/*     */         } 
/*     */         
/* 206 */         for (int i = 0; i < compoundlist.d(); i++)
/*     */         {
/* 208 */           info.compounds.add((ady)compoundlist.a(i)); } 
/*     */         continue;
/*     */       } 
/* 211 */       if (obj instanceof zl) {
/*     */         
/* 213 */         zl damagearray = (zl)obj;
/*     */         
/* 215 */         int itemID = Integer.parseInt(damagearray.c().substring(1));
/* 216 */         IDInfo info = (IDInfo)this.hiddenitems.get(Integer.valueOf(itemID));
/* 217 */         if (info == null) {
/*     */           
/* 219 */           info = new IDInfo();
/* 220 */           this.hiddenitems.put(Integer.valueOf(itemID), info);
/*     */         } 
/*     */         
/* 223 */         for (int i = 0; i < damagearray.a.length / 2; i++)
/*     */         {
/* 225 */           info.damages.add(Short.valueOf((short)((damagearray.a[i * 2] << 8) + damagearray.a[i * 2 + 1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/* 235 */       ady hashSave = NEIConfig.saveCompound.m("vis");
/* 236 */       NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */       
/* 238 */       hashSave.a("current", constructSaveCompound());
/* 239 */       NEIConfig.saveConfig();
/*     */     }
/* 241 */     catch (Exception e) {
/*     */       
/* 243 */       NEIUtils.reportException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ady constructSaveCompound() {
/* 249 */     ady savecompound = new ady();
/* 250 */     for (Map.Entry itemEntry : this.hiddenitems.entrySet()) {
/*     */       
/* 252 */       int id = ((Integer)itemEntry.getKey()).intValue();
/* 253 */       IDInfo info = (IDInfo)itemEntry.getValue();
/*     */       
/* 255 */       if (info.compounds.size() > 0) {
/*     */         
/* 257 */         no compoundlist = new no();
/* 258 */         for (ady compound : info.compounds)
/*     */         {
/* 260 */           compoundlist.a((gh)compound);
/*     */         }
/* 262 */         savecompound.a("c" + id, (gh)compoundlist);
/*     */       } 
/*     */       
/* 265 */       if (info.damages.size() > 0) {
/*     */         
/* 267 */         byte[] damagearray = new byte[info.damages.size() * 2];
/* 268 */         int i = 0;
/* 269 */         for (Iterator<Short> iterator = info.damages.iterator(); iterator.hasNext(); ) { short damage = ((Short)iterator.next()).shortValue();
/*     */           
/* 271 */           damagearray[i * 2] = (byte)(damage >> 8);
/* 272 */           damagearray[i * 2 + 1] = (byte)damage;
/* 273 */           i++; }
/*     */         
/* 275 */         savecompound.a("d" + id, damagearray);
/*     */       } 
/*     */     } 
/* 278 */     return savecompound;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadStates() {
/* 283 */     ady hashSave = NEIConfig.saveCompound.m("vis");
/* 284 */     NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */     
/* 286 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 288 */       ady statesave = hashSave.m("save" + i);
/* 289 */       if (statesave.d().size() > 0)
/*     */       {
/* 291 */         statesSaved[i] = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadState(int i) {
/* 298 */     ady hashSave = NEIConfig.saveCompound.m("vis");
/* 299 */     NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */     
/* 301 */     loadFromCompound(hashSave.m("save" + i));
/*     */     
/* 303 */     DropDownFile.dropDownInstance.updateState();
/* 304 */     NEIUtils.loadItems();
/* 305 */     NEIConfig.vishash.save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveState(int i) {
/* 310 */     ady hashSave = NEIConfig.saveCompound.m("vis");
/* 311 */     NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */     
/* 313 */     ady saveCompound = getCurrentSaveCompound();
/* 314 */     saveCompound.a("saved", true);
/* 315 */     hashSave.a("save" + i, saveCompound);
/* 316 */     statesSaved[i] = true;
/* 317 */     NEIConfig.saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearState(int i) {
/* 322 */     ady hashSave = NEIConfig.saveCompound.m("vis");
/* 323 */     NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */     
/* 325 */     hashSave.a("save" + i, new ady("save" + i));
/* 326 */     statesSaved[i] = false;
/* 327 */     NEIConfig.saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isStateSaved(int i) {
/* 332 */     return statesSaved[i];
/*     */   }
/*     */   
/* 335 */   private static boolean[] statesSaved = new boolean[7];
/*     */   public TreeMap hiddenitems;
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemVisibilityHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */