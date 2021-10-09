/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class API
/*     */ {
/*     */   public static void registerRecipeHandler(ICraftingHandler handler) {
/*  28 */     GuiCraftingRecipe.registerRecipeHandler(handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerUsageHandler(IUsageHandler handler) {
/*  37 */     GuiUsageRecipe.registerUsageHandler(handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerGuiOverlay(Class class1, String string) {
/*  48 */     registerGuiOverlay(class1, string, 5, 11);
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
/*     */   public static void registerGuiOverlay(Class class1, String string, int x, int y) {
/*  61 */     registerGuiOverlay(class1, string, new OffsetPositioner(x, y));
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
/*     */   public static void registerGuiOverlay(Class classz, String ident, IStackPositioner positioner) {
/*  73 */     DefaultOverlayRenderer.registerGuiOverlay(classz, ident, positioner);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hideItem(int itemID) {
/*  82 */     ItemInfo.excludeIds.add(Integer.valueOf(itemID));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hideItems(Collection items) {
/*  91 */     ItemInfo.excludeIds.addAll(items);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setOverrideName(int itemID, int itemDamage, String name) {
/* 102 */     ItemInfo.fallbackNames.put(new ItemHash(itemID, itemDamage), name);
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
/*     */   public static void setItemDamageVariants(int itemID, ArrayList ranges) {
/* 115 */     ItemInfo.damageVariants.put(Integer.valueOf(itemID), ranges);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setItemDamageVariants(int itemID, Collection<?> damages) {
/* 125 */     setItemDamageVariants(itemID, NEIUtils.concatIntegersToRanges(new ArrayList(damages)));
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
/*     */   public static void setMaxDamageException(int itemID, int maxDamage) {
/* 138 */     ArrayList<int[]> damageset = new ArrayList();
/* 139 */     damageset.add(new int[] { 0, maxDamage });
/* 140 */     setItemDamageVariants(itemID, damageset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addNBTItem(aan item) {
/* 150 */     ArrayList<aan> datalist = (ArrayList)ItemInfo.itemcompounds.get(Integer.valueOf(item.c));
/* 151 */     if (datalist == null) {
/*     */       
/* 153 */       datalist = new ArrayList();
/* 154 */       ItemInfo.itemcompounds.put(Integer.valueOf(item.c), datalist);
/*     */     } 
/* 156 */     datalist.add(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addSetRange(String setname, MultiItemRange range) {
/* 166 */     SubSetRangeTag tag = DropDownFile.dropDownInstance.getTag(setname);
/* 167 */     tag.saveTag = false;
/* 168 */     tag.setRange(range);
/* 169 */     DropDownFile.dropDownInstance.updateState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SubSetRangeTag getRangeTag(String tagname) {
/* 178 */     return DropDownFile.dropDownInstance.getTag(tagname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addToRange(String setname, MultiItemRange range) {
/* 188 */     SubSetRangeTag tag = DropDownFile.dropDownInstance.getTag(setname);
/* 189 */     if (tag.validranges == null) {
/* 190 */       tag.setRange(range);
/*     */     } else {
/* 192 */       tag.validranges.add(range);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addTooltipHandler(IHandleTooltip handler) {
/* 201 */     ItemInfo.tooltipHandlers.add(handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addInputHandler(IHandleInput handler) {
/* 210 */     ItemInfo.inputHandlers.add(handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addSetting(GuiNEISettings.NEIOption o) {
/* 220 */     addSetting(GuiNEISettings.class, o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addSetting(Class<?> guiclass, GuiNEISettings.NEIOption o) {
/* 230 */     LinkedList<GuiNEISettings.NEIOption> list = (LinkedList)GuiNEISettings.optionMap.get(guiclass);
/* 231 */     if (list == null) {
/*     */       
/* 233 */       list = new LinkedList();
/* 234 */       GuiNEISettings.optionMap.put(guiclass, list);
/*     */     } 
/* 236 */     list.add(o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addKeyBind(String ident, String desc, int defaultKey) {
/* 247 */     NEIConfig.setDefaultKeyBinding(ident, defaultKey);
/* 248 */     addKeyBind(GuiNEIControls.class, new GuiNEIControls.NEIKeyBind(ident, desc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addKeyBind(Class<?> guiclass, GuiNEIControls.NEIKeyBind key) {
/* 256 */     LinkedList<GuiNEIControls.NEIKeyBind> list = (LinkedList)GuiNEIControls.keyBindMap.get(guiclass);
/* 257 */     if (list == null) {
/*     */       
/* 259 */       list = new LinkedList();
/* 260 */       GuiNEIControls.keyBindMap.put(guiclass, list);
/*     */     } 
/* 262 */     list.add(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addLayoutStyle(int styleID, LayoutStyle style) {
/* 272 */     LayoutManager.layoutStyles.put(Integer.valueOf(styleID), style);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addInfiniteItemHandler(IInfiniteItemHandler handler) {
/* 281 */     ItemInfo.infiniteHandlers.addFirst(handler);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\API.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */