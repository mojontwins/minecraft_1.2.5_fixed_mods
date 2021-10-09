/*     */ package codechicken.nei;
/*     */ 
/*     */ import ModLoader;
/*     */ import aan;
/*     */ import ahg;
/*     */ import dy;
/*     */ import java.awt.Rectangle;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import kv;
/*     */ import pb;
/*     */ import yr;
/*     */ 
/*     */ public class FurnaceRecipeHandler extends TemplateRecipeHandler {
/*     */   public static ArrayList afuels;
/*     */   public static TreeSet efuels;
/*     */   
/*     */   public class SmeltingPair extends TemplateRecipeHandler.CachedRecipe {
/*     */     PositionedStack ingred;
/*     */     PositionedStack result;
/*     */     
/*     */     public SmeltingPair(aan ingred, aan result) {
/*  27 */       ingred.a = 1;
/*  28 */       this.ingred = new PositionedStack(ingred, 51, 6);
/*  29 */       this.result = new PositionedStack(result, 111, 24);
/*     */     }
/*     */ 
/*     */     
/*     */     public PositionedStack getIngredient() {
/*  34 */       int cycle = FurnaceRecipeHandler.this.cycleticks / 48;
/*  35 */       if (this.ingred.item.i() == -1) {
/*     */         
/*  37 */         PositionedStack stack = this.ingred.copy();
/*  38 */         int maxDamage = 0;
/*     */         
/*     */         do {
/*  41 */           maxDamage++;
/*  42 */           stack.item.b(maxDamage);
/*     */         }
/*  44 */         while (NEIUtils.isValidItem(stack.item));
/*     */         
/*  46 */         stack.item.b(cycle % maxDamage);
/*  47 */         return stack;
/*     */       } 
/*  49 */       return this.ingred;
/*     */     }
/*     */ 
/*     */     
/*     */     public PositionedStack getResult() {
/*  54 */       return this.result;
/*     */     }
/*     */ 
/*     */     
/*     */     public PositionedStack getOtherStack() {
/*  59 */       return ((FurnaceRecipeHandler.FuelPair)FurnaceRecipeHandler.afuels.get(FurnaceRecipeHandler.this.cycleticks / 48 % FurnaceRecipeHandler.afuels.size())).stack;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FuelPair
/*     */   {
/*     */     public PositionedStack stack;
/*     */     public int burnTime;
/*     */     
/*     */     public FuelPair(aan ingred, int burnTime) {
/*  70 */       this.stack = new PositionedStack(ingred, 51, 42);
/*  71 */       this.burnTime = burnTime;
/*     */     }
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
/*     */   public void loadTransferRects() {
/*  84 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(50, 23, 18, 18), "fuel", new Object[0]));
/*  85 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(74, 23, 24, 18), "smelting", new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getGuiClass() {
/*  91 */     return kv.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/*  97 */     return "Smelting";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/* 104 */     if (outputId.equals("smelting") && getClass() == FurnaceRecipeHandler.class) {
/*     */ 
/*     */       
/* 107 */       HashMap recipes, metarecipes = null;
/*     */       
/*     */       try {
/* 110 */         recipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 1);
/*     */         
/*     */         try {
/* 113 */           metarecipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 2);
/*     */         }
/* 115 */         catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
/*     */       
/*     */       }
/* 118 */       catch (Exception e) {
/*     */         
/* 120 */         e.printStackTrace();
/*     */         return;
/*     */       } 
/* 123 */       for (Map.Entry recipe : recipes.entrySet()) {
/*     */         
/* 125 */         aan item = (aan)recipe.getValue();
/* 126 */         this.arecipes.add(new SmeltingPair(new aan(((Integer)recipe.getKey()).intValue(), 1, -1), item));
/*     */       } 
/* 128 */       if (metarecipes == null)
/* 129 */         return;  for (Map.Entry recipe : metarecipes.entrySet())
/*     */       {
/* 131 */         aan item = (aan)recipe.getValue();
/* 132 */         this.arecipes.add(new SmeltingPair(new aan(((Integer)((List<Integer>)recipe.getKey()).get(0)).intValue(), 1, ((Integer)((List<Integer>)recipe.getKey()).get(1)).intValue()), item));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 137 */       super.loadCraftingRecipes(outputId, results);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(aan result) {
/* 146 */     HashMap recipes, metarecipes = null;
/*     */     
/*     */     try {
/* 149 */       recipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 1);
/*     */       
/*     */       try {
/* 152 */         metarecipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 2);
/*     */       }
/* 154 */       catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
/*     */     
/*     */     }
/* 157 */     catch (Exception e) {
/*     */       
/* 159 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/* 162 */     for (Map.Entry recipe : recipes.entrySet()) {
/*     */       
/* 164 */       aan item = (aan)recipe.getValue();
/* 165 */       if (NEIUtils.areStacksSameType(item, result))
/*     */       {
/* 167 */         this.arecipes.add(new SmeltingPair(new aan(((Integer)recipe.getKey()).intValue(), 1, -1), item));
/*     */       }
/*     */     } 
/* 170 */     if (metarecipes == null)
/* 171 */       return;  for (Map.Entry recipe : metarecipes.entrySet()) {
/*     */       
/* 173 */       aan item = (aan)recipe.getValue();
/* 174 */       if (NEIUtils.areStacksSameType(item, result))
/*     */       {
/* 176 */         this.arecipes.add(new SmeltingPair(new aan(((Integer)((List<Integer>)recipe.getKey()).get(0)).intValue(), 1, ((Integer)((List<Integer>)recipe.getKey()).get(1)).intValue()), item));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(String inputId, Object... ingredients) {
/* 184 */     if (inputId.equals("fuel") && getClass() == FurnaceRecipeHandler.class) {
/*     */       
/* 186 */       loadCraftingRecipes("smelting", new Object[0]);
/*     */     }
/*     */     else {
/*     */       
/* 190 */       super.loadUsageRecipes(inputId, ingredients);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {
/* 199 */     HashMap recipes, metarecipes = null;
/*     */     
/*     */     try {
/* 202 */       recipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 1);
/*     */       
/*     */       try {
/* 205 */         metarecipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 2);
/*     */       }
/* 207 */       catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
/*     */     
/*     */     }
/* 210 */     catch (Exception e) {
/*     */       
/* 212 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/* 215 */     for (Map.Entry recipe : recipes.entrySet()) {
/*     */       
/* 217 */       aan item = (aan)recipe.getValue();
/* 218 */       if (ingredient.c == ((Integer)recipe.getKey()).intValue())
/*     */       {
/* 220 */         this.arecipes.add(new SmeltingPair(ingredient, item));
/*     */       }
/*     */     } 
/* 223 */     if (metarecipes == null)
/* 224 */       return;  for (Map.Entry recipe : metarecipes.entrySet()) {
/*     */       
/* 226 */       aan item = (aan)recipe.getValue();
/* 227 */       if (ingredient.c == ((Integer)((List<Integer>)recipe.getKey()).get(0)).intValue() && ingredient.i() == ((Integer)((List<Integer>)recipe.getKey()).get(1)).intValue())
/*     */       {
/* 229 */         this.arecipes.add(new SmeltingPair(ingredient, item));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiTexture() {
/* 237 */     return "/gui/furnace.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawExtras(GuiManager gui, int recipe) {
/* 242 */     drawProgressBar(gui, 51, 25, 176, 0, 14, 14, 48, 7);
/* 243 */     drawProgressBar(gui, 74, 23, 176, 14, 24, 16, 48, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void removeFuels() {
/* 248 */     efuels = new TreeSet();
/* 249 */     efuels.add(Integer.valueOf(pb.bn.bO));
/* 250 */     efuels.add(Integer.valueOf(pb.bo.bO));
/* 251 */     efuels.add(Integer.valueOf(pb.aD.bO));
/* 252 */     efuels.add(Integer.valueOf(pb.aI.bO));
/* 253 */     efuels.add(Integer.valueOf(pb.aE.bO));
/* 254 */     efuels.add(Integer.valueOf(pb.bj.bO));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findFuels() {
/*     */     Method getBurnTime;
/*     */     try {
/* 262 */       getBurnTime = ahg.class.getDeclaredMethod("getItemBurnTime", new Class[] { aan.class });
/* 263 */       getBurnTime.setAccessible(true);
/*     */     }
/* 265 */     catch (SecurityException e) {
/*     */       
/* 267 */       e.printStackTrace();
/*     */       
/*     */       return;
/* 270 */     } catch (NoSuchMethodException e) {
/*     */ 
/*     */       
/*     */       try {
/* 274 */         getBurnTime = ahg.class.getDeclaredMethod("a", new Class[] { aan.class });
/* 275 */         getBurnTime.setAccessible(true);
/*     */       }
/* 277 */       catch (SecurityException e1) {
/*     */         
/* 279 */         e1.printStackTrace();
/*     */         
/*     */         return;
/* 282 */       } catch (NoSuchMethodException e1) {
/*     */         
/* 284 */         e1.printStackTrace();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 289 */     ahg afurnace = new ahg();
/* 290 */     afuels = new ArrayList(); byte b; int i; yr[] arrayOfYr;
/* 291 */     for (i = (arrayOfYr = yr.e).length, b = 0; b < i; ) { yr item = arrayOfYr[b];
/*     */       
/* 293 */       if (item != null && !efuels.contains(Integer.valueOf(item.bQ))) {
/*     */         int burnTime;
/*     */ 
/*     */         
/*     */         try {
/* 298 */           burnTime = ((Integer)getBurnTime.invoke(afurnace, new Object[] { new aan(item, 1) })).intValue();
/*     */         }
/* 300 */         catch (Exception e) {
/*     */           
/* 302 */           e.printStackTrace();
/*     */         } 
/*     */         
/* 305 */         if (burnTime > 0) {
/*     */           
/* 307 */           afuels.add(new FuelPair(new aan(item, 1), burnTime));
/* 308 */           for (int j = 1; j < 16; j++) {
/*     */             
/* 310 */             aan stack = new aan(item, 1, j);
/* 311 */             if (!NEIUtils.isValidItem(stack)) {
/*     */               break;
/*     */             }
/*     */             
/* 315 */             afuels.add(new FuelPair(stack, burnTime));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOverlayIdentifier() {
/* 325 */     return "smelting";
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 330 */     removeFuels();
/* 331 */     findFuels();
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FurnaceRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */