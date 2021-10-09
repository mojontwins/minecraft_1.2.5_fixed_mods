/*     */ package codechicken.nei;
/*     */ import aan;
/*     */ import ady;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import pb;
/*     */ import yr;
/*     */ 
/*     */ public class ItemInfo {
/*  13 */   static final HashMap fallbackNames = new HashMap<Object, Object>();
/*  14 */   static final HashSet excludeIds = new HashSet();
/*  15 */   static final HashSet nonUnlimitedIds = new HashSet();
/*  16 */   static final HashMap damageVariants = new HashMap<Object, Object>();
/*  17 */   static final ArrayList defaultDamageRange = new ArrayList();
/*  18 */   static final HashMap itemcompounds = new HashMap<Object, Object>();
/*  19 */   static final LinkedList tooltipHandlers = new LinkedList();
/*  20 */   static final LinkedList inputHandlers = new LinkedList();
/*  21 */   static final LinkedList infiniteHandlers = new LinkedList();
/*     */ 
/*     */   
/*     */   public static boolean isHidden(int itemID) {
/*  25 */     return excludeIds.contains(Integer.valueOf(itemID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList getItemDamageVariants(int itemID) {
/*  30 */     ArrayList damages = (ArrayList)damageVariants.get(Integer.valueOf(itemID));
/*  31 */     return (damages == null) ? defaultDamageRange : damages;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getOverrideName(int itemID, int itemDamage) {
/*  36 */     ItemHash itemhash = new ItemHash(itemID, itemDamage);
/*  37 */     return (String)fallbackNames.get(itemhash);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canItemBeUnlimited(int itemID) {
/*  42 */     return !nonUnlimitedIds.contains(Integer.valueOf(itemID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList getItemCompounds(int itemID) {
/*  47 */     return (ArrayList)itemcompounds.get(Integer.valueOf(itemID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void load() {
/*  52 */     defaultDamageRange.add(new int[] { 0, 15 });
/*  53 */     addVanillaBlockProperties();
/*  54 */     addDefaultDropDowns();
/*  55 */     addRecipeHandlers();
/*  56 */     searchItems();
/*  57 */     searchCreativeMenu();
/*  58 */     addMobSpawnerItem();
/*  59 */     addSpawnEggs();
/*  60 */     (new BrewingRecipeHandler()).searchPotions();
/*  61 */     addInfiniteHandlers();
/*  62 */     addInputHandlers();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addInputHandlers() {
/*  67 */     API.addInputHandler(new RecipeItemInputHandler());
/*  68 */     API.addInputHandler(new EnchantmentInputHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addRecipeHandlers() {
/*  73 */     API.registerRecipeHandler(new ShapedRecipeHandler());
/*  74 */     API.registerUsageHandler(new ShapedRecipeHandler());
/*  75 */     API.registerRecipeHandler(new ShapelessRecipeHandler());
/*  76 */     API.registerUsageHandler(new ShapelessRecipeHandler());
/*  77 */     API.registerRecipeHandler(new FurnaceRecipeHandler());
/*  78 */     API.registerUsageHandler(new FurnaceRecipeHandler());
/*  79 */     API.registerRecipeHandler(new BrewingRecipeHandler());
/*  80 */     API.registerUsageHandler(new BrewingRecipeHandler());
/*  81 */     API.registerRecipeHandler(new FuelRecipeHandler());
/*  82 */     API.registerUsageHandler(new FuelRecipeHandler());
/*     */     
/*  84 */     API.registerGuiOverlay(aen.class, "crafting", 5, 11);
/*  85 */     API.registerGuiOverlay(ain.class, "crafting2x2", 63, 20);
/*  86 */     API.registerGuiOverlay(kv.class, "smelting", 5, 11);
/*  87 */     API.registerGuiOverlay(kv.class, "fuel", 5, 11);
/*  88 */     API.registerGuiOverlay(hg.class, "brewing", 5, 11);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addMobSpawnerItem() {
/*  93 */     yr.e[pb.as.bO] = null;
/*     */     
/*  95 */     if (NEICompatibility.hasForge)
/*     */     {
/*  97 */       weakDependancy_Forge.addMobSpawnerRenderer();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addInfiniteHandlers() {
/* 103 */     API.addInfiniteItemHandler(new InfiniteStackSizeHandler());
/* 104 */     API.addInfiniteItemHandler(new InfiniteToolHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void searchCreativeMenu() {
/* 109 */     ArrayList creativeItems = mod_NotEnoughItems.getCreativeItemList();
/* 110 */     HashSet<Integer> itemsToDamageCalc = new HashSet();
/* 111 */     for (aan item : creativeItems) {
/*     */       
/* 113 */       if (item.n()) {
/*     */         
/* 115 */         API.setMaxDamageException(item.c, -1);
/* 116 */         API.addNBTItem(item); continue;
/*     */       } 
/* 118 */       if (item.i() != 0 && item.c != yr.bs.bQ && item.c != yr.bC.bQ)
/*     */       {
/* 120 */         itemsToDamageCalc.add(Integer.valueOf(item.c));
/*     */       }
/*     */     } 
/*     */     
/* 124 */     HashMap<Object, Object> itemDamages = new HashMap<Object, Object>();
/* 125 */     for (aan item : creativeItems) {
/*     */       
/* 127 */       if (itemsToDamageCalc.contains(Integer.valueOf(item.c)) && !item.n()) {
/*     */         
/* 129 */         ArrayList<Integer> damages = (ArrayList)itemDamages.get(Integer.valueOf(item.c));
/* 130 */         if (damages == null) {
/*     */           
/* 132 */           damages = new ArrayList();
/* 133 */           itemDamages.put(Integer.valueOf(item.c), damages);
/*     */         } 
/* 135 */         damages.add(Integer.valueOf(item.i()));
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     for (Map.Entry<Object, Object> damageset : itemDamages.entrySet())
/*     */     {
/* 141 */       API.setItemDamageVariants(((Integer)damageset.getKey()).intValue(), NEIUtils.concatIntegersToRanges((List)damageset.getValue()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addVanillaBlockProperties() {
/* 147 */     API.setOverrideName(pb.A.bO, 0, "Water Source");
/* 148 */     API.setMaxDamageException(pb.A.bO, 0);
/* 149 */     API.setOverrideName(pb.B.bO, 0, "Water Still");
/* 150 */     API.setMaxDamageException(pb.B.bO, 0);
/* 151 */     API.setOverrideName(pb.C.bO, 0, "Lava Source");
/* 152 */     API.setMaxDamageException(pb.C.bO, 0);
/* 153 */     API.setOverrideName(pb.D.bO, 0, "Lava Still");
/* 154 */     API.setMaxDamageException(pb.D.bO, 0);
/* 155 */     API.setOverrideName(pb.bJ.bO, 0, "White Stone");
/* 156 */     API.setOverrideName(pb.bJ.bO, 0, "White Stone");
/* 157 */     API.setOverrideName(pb.bl.bO, 0, "Silverfish Stone");
/* 158 */     API.setOverrideName(pb.aj.bO, 0, "Double Slab");
/* 159 */     API.setOverrideName(pb.aj.bO, 1, "Double Sandstone Slab");
/* 160 */     API.setOverrideName(pb.aj.bO, 2, "Double Wooden Slab");
/* 161 */     API.setOverrideName(pb.aj.bO, 3, "Double Cobblestone Slab");
/* 162 */     API.setOverrideName(pb.aj.bO, 4, "Double Bricks Slab");
/* 163 */     API.setOverrideName(pb.aj.bO, 5, "Double Stone Bricks Slab");
/* 164 */     API.setOverrideName(pb.by.bO, 0, "Mycelium");
/* 165 */     API.setOverrideName(pb.bz.bO, 0, "Lily Pad");
/* 166 */     API.setOverrideName(pb.bH.bO, 0, "End Portal");
/* 167 */     API.setOverrideName(pb.bI.bO, 0, "End Portal Frame");
/* 168 */     API.setOverrideName(pb.bJ.bO, 0, "White Stone");
/* 169 */     API.hideItem(pb.S.bO);
/* 170 */     API.hideItem(pb.av.bO);
/* 171 */     API.hideItem(pb.az.bO);
/* 172 */     API.hideItem(pb.aD.bO);
/* 173 */     API.hideItem(pb.aE.bO);
/* 174 */     API.hideItem(pb.aI.bO);
/* 175 */     API.hideItem(pb.aL.bO);
/* 176 */     API.hideItem(pb.aO.bO);
/* 177 */     API.hideItem(pb.aP.bO);
/* 178 */     API.hideItem(pb.aX.bO);
/* 179 */     API.hideItem(pb.bh.bO);
/* 180 */     API.hideItem(pb.bi.bO);
/* 181 */     API.hideItem(pb.bG.bO);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addDefaultDropDowns() {
/* 186 */     API.addSetRange("Blocks", new MultiItemRange("[0-32000]")
/*     */         {
/*     */           
/*     */           public void addItemIfInRange(int item, int damage, ady compound)
/*     */           {
/* 191 */             if (item < pb.m.length && pb.m[item] != null)
/* 192 */               super.addItemIfInRange(item, damage, compound); 
/*     */           }
/*     */         });
/* 195 */     API.addSetRange("Items", new MultiItemRange("[0-32000]")
/*     */         {
/*     */           
/*     */           public void addItemIfInRange(int item, int damage, ady compound)
/*     */           {
/* 200 */             if (item >= pb.m.length || pb.m[item] == null)
/* 201 */               super.addItemIfInRange(item, damage, compound); 
/*     */           }
/*     */         });
/* 204 */     API.addSetRange("Vanilla.Blocks", new MultiItemRange("[1-124]"));
/* 205 */     API.addSetRange("Blocks.MobSpawners", new MultiItemRange("[52]"));
/* 206 */     API.addSetRange("Vanilla.Items", new MultiItemRange("[256-385],[2256-2266]"));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void searchItems() {
/* 211 */     MultiItemRange tools = new MultiItemRange();
/* 212 */     MultiItemRange picks = new MultiItemRange();
/* 213 */     MultiItemRange shovels = new MultiItemRange();
/* 214 */     MultiItemRange axes = new MultiItemRange();
/* 215 */     MultiItemRange hoes = new MultiItemRange();
/* 216 */     MultiItemRange swords = new MultiItemRange();
/* 217 */     MultiItemRange chest = new MultiItemRange();
/* 218 */     MultiItemRange helmets = new MultiItemRange();
/* 219 */     MultiItemRange legs = new MultiItemRange();
/* 220 */     MultiItemRange boots = new MultiItemRange();
/* 221 */     MultiItemRange other = new MultiItemRange();
/* 222 */     MultiItemRange ranged = new MultiItemRange();
/* 223 */     MultiItemRange food = new MultiItemRange();
/* 224 */     MultiItemRange potioningredients = new MultiItemRange(); byte b; int i; yr[] arrayOfYr;
/* 225 */     for (i = (arrayOfYr = yr.e).length, b = 0; b < i; ) { yr item = arrayOfYr[b];
/*     */       
/* 227 */       if (item != null) {
/* 228 */         if (item.i()) {
/*     */           
/* 230 */           tools.add(item);
/* 231 */           if (item instanceof au) {
/*     */             
/* 233 */             picks.add(item);
/*     */           }
/* 235 */           else if (item instanceof akd) {
/*     */             
/* 237 */             shovels.add(item);
/*     */           }
/* 239 */           else if (item instanceof nx) {
/*     */             
/* 241 */             axes.add(item);
/*     */           }
/* 243 */           else if (item instanceof ic) {
/*     */             
/* 245 */             hoes.add(item);
/*     */           }
/* 247 */           else if (item instanceof lx) {
/*     */             
/* 249 */             swords.add(item);
/*     */           }
/* 251 */           else if (item instanceof ql) {
/*     */             
/* 253 */             switch (((ql)item).a) {
/*     */               
/*     */               case 0:
/* 256 */                 helmets.add(item);
/*     */                 break;
/*     */               case 1:
/* 259 */                 chest.add(item);
/*     */                 break;
/*     */               case 2:
/* 262 */                 legs.add(item);
/*     */                 break;
/*     */               case 3:
/* 265 */                 boots.add(item);
/*     */                 break;
/*     */             } 
/*     */           
/* 269 */           } else if (item == yr.l || item == yr.k) {
/*     */             
/* 271 */             ranged.add(item);
/*     */           }
/* 273 */           else if (item == yr.aR || item == yr.i || item == yr.be) {
/*     */             
/* 275 */             other.add(item);
/*     */           } 
/*     */         } 
/*     */         
/* 279 */         if (item instanceof amm)
/*     */         {
/* 281 */           food.add(item);
/*     */         }
/*     */         
/* 284 */         if (item.p()) {
/*     */           
/* 286 */           BrewingRecipeHandler.ingredientIDs.add(Integer.valueOf(item.bQ));
/* 287 */           potioningredients.add(item);
/*     */         } 
/*     */       }  b++; }
/* 290 */      API.addSetRange("Items.Tools.Pickaxes", picks);
/* 291 */     API.addSetRange("Items.Tools.Shovels", shovels);
/* 292 */     API.addSetRange("Items.Tools.Axes", axes);
/* 293 */     API.addSetRange("Items.Tools.Hoes", hoes);
/* 294 */     API.addSetRange("Items.Tools.Other", other);
/* 295 */     API.addSetRange("Items.Weapons.Swords", swords);
/* 296 */     API.addSetRange("Items.Weapons.Ranged", ranged);
/* 297 */     API.addSetRange("Items.Armor.ChestPlates", chest);
/* 298 */     API.addSetRange("Items.Armor.Leggings", legs);
/* 299 */     API.addSetRange("Items.Armor.Helmets", helmets);
/* 300 */     API.addSetRange("Items.Armor.Boots", boots);
/* 301 */     API.addSetRange("Items.Food", food);
/* 302 */     API.addSetRange("Items.Potions.Ingredients", potioningredients);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addSpawnEggs() {
/* 307 */     ArrayList<Integer> damages = new ArrayList();
/*     */ 
/*     */     
/*     */     try {
/* 311 */       HashMap classToIDMapping = (HashMap)ModLoader.getPrivateValue(aao.class, null, 3);
/* 312 */       damages.add((Integer)classToIDMapping.get(of.class));
/* 313 */       damages.add((Integer)classToIDMapping.get(xr.class));
/* 314 */       damages.add((Integer)classToIDMapping.get(yd.class));
/* 315 */       damages.add((Integer)classToIDMapping.get(aja.class));
/* 316 */       damages.add((Integer)classToIDMapping.get(ajg.class));
/* 317 */       damages.add((Integer)classToIDMapping.get(cb.class));
/* 318 */       damages.add((Integer)classToIDMapping.get(rd.class));
/* 319 */       damages.add((Integer)classToIDMapping.get(fn.class));
/* 320 */       damages.add((Integer)classToIDMapping.get(un.class));
/* 321 */       damages.add((Integer)classToIDMapping.get(jg.class));
/* 322 */       damages.add((Integer)classToIDMapping.get(yo.class));
/* 323 */       damages.add((Integer)classToIDMapping.get(alt.class));
/* 324 */       damages.add((Integer)classToIDMapping.get(all.class));
/* 325 */       damages.add((Integer)classToIDMapping.get(ui.class));
/* 326 */       damages.add((Integer)classToIDMapping.get(aic.class));
/* 327 */       damages.add((Integer)classToIDMapping.get(cu.class));
/* 328 */       damages.add((Integer)classToIDMapping.get(adg.class));
/* 329 */       damages.add((Integer)classToIDMapping.get(ed.class));
/* 330 */       damages.add((Integer)classToIDMapping.get(qn.class));
/* 331 */       damages.add((Integer)classToIDMapping.get(qr.class));
/* 332 */       damages.add((Integer)classToIDMapping.get(uo.class));
/*     */       
/* 334 */       addEntityEgg(damages, (Integer)classToIDMapping.get(q.class), 15663103, 16753185);
/* 335 */       addEntityEgg(damages, (Integer)classToIDMapping.get(tl.class), 12960449, 16769484);
/*     */     }
/* 337 */     catch (Exception e) {
/*     */       
/* 339 */       e.printStackTrace();
/*     */     } 
/* 341 */     API.setItemDamageVariants(yr.bC.bQ, damages);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addEntityEgg(ArrayList<Integer> damages, Integer ID, int i, int j) {
/* 347 */     damages.add(ID);
/* 348 */     aao.a.put(ID, new hr(ID.intValue(), i, j));
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */