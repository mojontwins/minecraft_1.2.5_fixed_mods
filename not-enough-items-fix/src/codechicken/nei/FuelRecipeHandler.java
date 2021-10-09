/*     */ package codechicken.nei;
/*     */ 
/*     */ import ModLoader;
/*     */ import aan;
/*     */ import dy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class FuelRecipeHandler
/*     */   extends FurnaceRecipeHandler {
/*     */   public static ArrayList mfurnace;
/*     */   
/*     */   public class CachedFuelRecipe
/*     */     extends TemplateRecipeHandler.CachedRecipe {
/*     */     public FurnaceRecipeHandler.FuelPair fuel;
/*     */     
/*     */     public CachedFuelRecipe(FurnaceRecipeHandler.FuelPair fuel) {
/*  20 */       this.fuel = fuel;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getIngredient() {
/*  26 */       return ((FurnaceRecipeHandler.SmeltingPair)FuelRecipeHandler.mfurnace.get(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).ingred;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getResult() {
/*  32 */       return ((FurnaceRecipeHandler.SmeltingPair)FuelRecipeHandler.mfurnace.get(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).result;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getOtherStack() {
/*  38 */       return this.fuel.stack;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FuelRecipeHandler() {
/*  45 */     loadAllSmelting();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/*  50 */     return "Fuel";
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAllSmelting() {
/*     */     HashMap recipes;
/*  56 */     if (mfurnace != null) {
/*     */       return;
/*     */     }
/*  59 */     mfurnace = new ArrayList();
/*     */ 
/*     */     
/*  62 */     HashMap metarecipes = null;
/*     */     
/*     */     try {
/*  65 */       recipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 1);
/*     */       
/*     */       try {
/*  68 */         metarecipes = (HashMap)ModLoader.getPrivateValue(dy.class, dy.a(), 2);
/*     */       }
/*  70 */       catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
/*     */     
/*     */     }
/*  73 */     catch (Exception e) {
/*     */       
/*  75 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/*  78 */     for (Map.Entry recipe : recipes.entrySet()) {
/*     */       
/*  80 */       aan item = (aan)recipe.getValue();
/*  81 */       int ingred = ((Integer)recipe.getKey()).intValue();
/*  82 */       mfurnace.add(new FurnaceRecipeHandler.SmeltingPair(this, new aan(ingred, 1, 0), item));
/*  83 */       for (int i = 1; i < 16; i++) {
/*     */         
/*  85 */         aan stack = new aan(ingred, 1, i);
/*  86 */         if (!NEIUtils.isValidItem(stack)) {
/*     */           break;
/*     */         }
/*     */         
/*  90 */         mfurnace.add(new FurnaceRecipeHandler.SmeltingPair(this, stack, item));
/*     */       } 
/*     */     } 
/*  93 */     if (metarecipes == null)
/*  94 */       return;  for (Map.Entry recipe : metarecipes.entrySet()) {
/*     */       
/*  96 */       aan item = (aan)recipe.getValue();
/*  97 */       mfurnace.add(new FurnaceRecipeHandler.SmeltingPair(this, new aan(((Integer)((List<Integer>)recipe.getKey()).get(0)).intValue(), 1, ((Integer)((List<Integer>)recipe.getKey()).get(1)).intValue()), item));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/* 104 */     if (outputId.equals("fuel") && getClass() == FuelRecipeHandler.class)
/*     */     {
/* 106 */       for (FurnaceRecipeHandler.FuelPair fuel : afuels)
/*     */       {
/* 108 */         this.arecipes.add(new CachedFuelRecipe(fuel));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {
/* 115 */     for (FurnaceRecipeHandler.FuelPair fuel : afuels) {
/*     */       
/* 117 */       if (NEIUtils.areStacksSameTypeCrafting(ingredient, fuel.stack.item))
/*     */       {
/* 119 */         this.arecipes.add(new CachedFuelRecipe(fuel));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOverlayIdentifier() {
/* 126 */     return "fuel";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List handleTooltip(GuiRecipe guiRecipe, List<String> currenttip, int recipe) {
/* 132 */     CachedFuelRecipe crecipe = this.arecipes.get(recipe);
/* 133 */     FurnaceRecipeHandler.FuelPair fuel = crecipe.fuel;
/* 134 */     float burnTime = fuel.burnTime / 200.0F;
/*     */     
/* 136 */     if (guiRecipe.isMouseOver(fuel.stack, recipe) && burnTime <= 1.0F) {
/*     */       
/* 138 */       burnTime = 1.0F / burnTime;
/* 139 */       String burnString = Float.toString(burnTime);
/* 140 */       if (burnTime == Math.round(burnTime)) {
/* 141 */         burnString = Integer.toString((int)burnTime);
/*     */       }
/* 143 */       burnString = String.valueOf(burnString) + " required";
/*     */       
/* 145 */       currenttip.add(burnString);
/*     */     }
/* 147 */     else if (guiRecipe.isMouseOver(crecipe.getResult(), recipe) && burnTime >= 1.0F) {
/*     */       
/* 149 */       String burnString = Float.toString(burnTime);
/* 150 */       if (burnTime == Math.round(burnTime)) {
/* 151 */         burnString = Integer.toString((int)burnTime);
/*     */       }
/* 153 */       burnString = String.valueOf(burnString) + " produced";
/*     */       
/* 155 */       currenttip.add(burnString);
/*     */     } 
/* 157 */     return currenttip;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FuelRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */