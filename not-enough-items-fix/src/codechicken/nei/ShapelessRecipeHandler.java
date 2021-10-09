/*     */ package codechicken.nei;
/*     */ 
/*     */ import ModLoader;
/*     */ import aan;
/*     */ import aen;
/*     */ import aif;
/*     */ import dd;
/*     */ import fr;
/*     */ import gb;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import wf;
/*     */ 
/*     */ public class ShapelessRecipeHandler
/*     */   extends TemplateRecipeHandler
/*     */ {
/*  19 */   static final int[][] stackorder = new int[][] {
/*  20 */       new int[2], {
/*  21 */         1
/*  22 */       }, { 0, 1
/*  23 */       }, { 1, 1
/*  24 */       }, { 0, 2
/*  25 */       }, { 1, 2
/*  26 */       }, { 2
/*  27 */       }, { 2, 1
/*  28 */       }, { 2, 2 } };
/*     */   
/*     */   public class CachedShapelessRecipe extends TemplateRecipeHandler.CachedRecipe {
/*     */     ArrayList ingredients;
/*     */     
/*     */     public CachedShapelessRecipe(aan output) {
/*  34 */       this.result = new PositionedStack(output, 119, 24);
/*  35 */       this.ingredients = new ArrayList();
/*     */     }
/*     */     PositionedStack result;
/*     */     
/*     */     public CachedShapelessRecipe(aif recipe) {
/*  40 */       this(recipe.b());
/*  41 */       setIngredients(recipe);
/*     */     }
/*     */ 
/*     */     
/*     */     public CachedShapelessRecipe(Object[] input, aan output) {
/*  46 */       this(Arrays.asList(input), output);
/*     */     }
/*     */ 
/*     */     
/*     */     public CachedShapelessRecipe(List input, aan output) {
/*  51 */       this(output);
/*  52 */       setIngredients(input);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setIngredients(List items) {
/*  57 */       for (int ingred = 0; ingred < items.size(); ingred++) {
/*     */         
/*  59 */         PositionedStack stack = new PositionedStack(items.get(ingred), 25 + ShapelessRecipeHandler.stackorder[ingred][0] * 18, 6 + ShapelessRecipeHandler.stackorder[ingred][1] * 18);
/*  60 */         stack.setMaxSize(1);
/*  61 */         this.ingredients.add(stack);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIngredients(aif recipe) {
/*     */       ArrayList items;
/*     */       try {
/*  71 */         items = (ArrayList)ModLoader.getPrivateValue(aif.class, recipe, 1);
/*     */       }
/*  73 */       catch (Exception e) {
/*     */         
/*  75 */         e.printStackTrace();
/*     */         
/*     */         return;
/*     */       } 
/*  79 */       setIngredients(items);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList getIngredients() {
/*  85 */       return getCycledIngredients(ShapelessRecipeHandler.this.cycleticks / 20, this.ingredients);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getResult() {
/*  91 */       return this.result;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadTransferRects() {
/* 101 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(84, 23, 24, 18), "crafting", new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getGuiClass() {
/* 107 */     return aen.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/* 112 */     return "Shapeless Crafting";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/* 118 */     if (outputId.equals("crafting") && getClass() == ShapelessRecipeHandler.class) {
/*     */ 
/*     */       
/* 121 */       List allrecipes = fr.a().b();
/* 122 */       for (wf irecipe : allrecipes) {
/*     */         CachedShapelessRecipe recipe;
/*     */         
/* 125 */         if (irecipe instanceof aif) {
/*     */           
/* 127 */           recipe = new CachedShapelessRecipe((aif)irecipe);
/*     */         }
/* 129 */         else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShapeless(irecipe)) {
/*     */           
/* 131 */           recipe = weakDependancy_Forge.getShapelessRecipe(this, irecipe);
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 137 */         this.arecipes.add(recipe);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 142 */       super.loadCraftingRecipes(outputId, results);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(aan result) {
/* 150 */     List allrecipes = fr.a().b();
/* 151 */     for (wf irecipe : allrecipes) {
/*     */       
/* 153 */       if (NEIUtils.areStacksSameTypeCrafting(irecipe.b(), result)) {
/*     */         CachedShapelessRecipe recipe;
/*     */         
/* 156 */         if (irecipe instanceof aif) {
/*     */           
/* 158 */           recipe = new CachedShapelessRecipe((aif)irecipe);
/*     */         }
/* 160 */         else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShapeless(irecipe)) {
/*     */           
/* 162 */           recipe = weakDependancy_Forge.getShapelessRecipe(this, irecipe);
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 168 */         this.arecipes.add(recipe);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {
/* 177 */     List allrecipes = fr.a().b();
/* 178 */     for (wf irecipe : allrecipes) {
/*     */       CachedShapelessRecipe recipe;
/*     */       
/* 181 */       if (irecipe instanceof aif) {
/*     */         
/* 183 */         recipe = new CachedShapelessRecipe((aif)irecipe);
/*     */       }
/* 185 */       else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShapeless(irecipe)) {
/*     */         
/* 187 */         recipe = weakDependancy_Forge.getShapelessRecipe(this, irecipe);
/*     */       } else {
/*     */         continue;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 194 */       if (recipe.contains(recipe.ingredients, ingredient)) {
/*     */         
/* 196 */         recipe.replaceMetaOnIngredients(recipe.ingredients, ingredient);
/* 197 */         this.arecipes.add(recipe);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiTexture() {
/* 205 */     return "/gui/crafting.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOverlay(gb gui, dd container, int recipe) {
/* 210 */     if (!DefaultOverlayRenderer.getOverlayIdent(gui).equals("crafting") && (
/* 211 */       !isRecipe2x2(recipe) || !DefaultOverlayRenderer.getOverlayIdent(gui).equals("crafting2x2"))) return false; 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean isRecipe2x2(int recipe) {
/* 216 */     return (getIngredientStacks(recipe).size() <= 4);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ShapelessRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */