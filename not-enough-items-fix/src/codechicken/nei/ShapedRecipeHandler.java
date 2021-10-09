/*     */ package codechicken.nei;
/*     */ 
/*     */ import ModLoader;
/*     */ import aai;
/*     */ import aan;
/*     */ import aen;
/*     */ import dd;
/*     */ import fr;
/*     */ import gb;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import wf;
/*     */ 
/*     */ public class ShapedRecipeHandler
/*     */   extends TemplateRecipeHandler {
/*     */   public class CachedShapedRecipe extends TemplateRecipeHandler.CachedRecipe {
/*     */     public ArrayList ingredients;
/*     */     public PositionedStack result;
/*     */     
/*     */     public CachedShapedRecipe(aai recipe) {
/*  22 */       this.result = new PositionedStack(recipe.b(), 119, 24);
/*  23 */       this.ingredients = new ArrayList();
/*  24 */       setIngredients(recipe);
/*     */     }
/*     */ 
/*     */     
/*     */     public CachedShapedRecipe(int width, int height, Object[] items, aan out) {
/*  29 */       this.result = new PositionedStack(out, 119, 24);
/*  30 */       this.ingredients = new ArrayList();
/*  31 */       setIngredients(width, height, items);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIngredients(int width, int height, Object[] items) {
/*  41 */       for (int x = 0; x < width; x++) {
/*     */         
/*  43 */         for (int y = 0; y < height; y++) {
/*     */           
/*  45 */           if (items[y * width + x] != null) {
/*     */ 
/*     */ 
/*     */             
/*  49 */             PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18);
/*  50 */             stack.setMaxSize(1);
/*  51 */             this.ingredients.add(stack);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setIngredients(aai recipe) {
/*     */       int width, height;
/*     */       aan[] items;
/*     */       try {
/*  63 */         width = ((Integer)ModLoader.getPrivateValue(aai.class, recipe, 0)).intValue();
/*  64 */         height = ((Integer)ModLoader.getPrivateValue(aai.class, recipe, 1)).intValue();
/*  65 */         items = (aan[])ModLoader.getPrivateValue(aai.class, recipe, 2);
/*     */       }
/*  67 */       catch (Exception e) {
/*     */         
/*  69 */         e.printStackTrace();
/*     */         
/*     */         return;
/*     */       } 
/*  73 */       setIngredients(width, height, (Object[])items);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList getIngredients() {
/*  79 */       return getCycledIngredients(ShapedRecipeHandler.this.cycleticks / 20, this.ingredients);
/*     */     }
/*     */ 
/*     */     
/*     */     public PositionedStack getResult() {
/*  84 */       return this.result;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadTransferRects() {
/*  94 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(84, 23, 24, 18), "crafting", new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getGuiClass() {
/* 100 */     return aen.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/* 106 */     return "Shaped Crafting";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/* 112 */     if (outputId.equals("crafting") && getClass() == ShapedRecipeHandler.class) {
/*     */ 
/*     */       
/* 115 */       List allrecipes = fr.a().b();
/* 116 */       for (wf irecipe : allrecipes) {
/*     */         CachedShapedRecipe recipe;
/*     */         
/* 119 */         if (irecipe instanceof aai) {
/*     */           
/* 121 */           recipe = new CachedShapedRecipe((aai)irecipe);
/*     */         }
/* 123 */         else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShaped(irecipe)) {
/*     */           
/* 125 */           recipe = weakDependancy_Forge.getShapedRecipe(this, irecipe);
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 131 */         this.arecipes.add(recipe);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 136 */       super.loadCraftingRecipes(outputId, results);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(aan result) {
/* 144 */     List allrecipes = fr.a().b();
/* 145 */     for (wf irecipe : allrecipes) {
/*     */       
/* 147 */       if (NEIUtils.areStacksSameTypeCrafting(irecipe.b(), result)) {
/*     */         CachedShapedRecipe recipe;
/*     */         
/* 150 */         if (irecipe instanceof aai) {
/*     */           
/* 152 */           recipe = new CachedShapedRecipe((aai)irecipe);
/*     */         }
/* 154 */         else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShaped(irecipe)) {
/*     */           
/* 156 */           recipe = weakDependancy_Forge.getShapedRecipe(this, irecipe);
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 162 */         this.arecipes.add(recipe);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {
/* 171 */     List allrecipes = fr.a().b();
/* 172 */     for (wf irecipe : allrecipes) {
/*     */       CachedShapedRecipe recipe;
/*     */       
/* 175 */       if (irecipe instanceof aai) {
/*     */         
/* 177 */         recipe = new CachedShapedRecipe((aai)irecipe);
/*     */       }
/* 179 */       else if (NEICompatibility.hasForge && weakDependancy_Forge.recipeInstanceShaped(irecipe)) {
/*     */         
/* 181 */         recipe = weakDependancy_Forge.getShapedRecipe(this, irecipe);
/*     */       } else {
/*     */         continue;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 188 */       if (recipe.contains(recipe.ingredients, ingredient)) {
/*     */         
/* 190 */         recipe.replaceMetaOnIngredients(recipe.ingredients, ingredient);
/* 191 */         this.arecipes.add(recipe);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiTexture() {
/* 199 */     return "/gui/crafting.png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasOverlay(gb gui, dd container, int recipe) {
/* 205 */     if (!DefaultOverlayRenderer.getOverlayIdent(gui).equals("crafting") && (
/* 206 */       !isRecipe2x2(recipe) || !DefaultOverlayRenderer.getOverlayIdent(gui).equals("crafting2x2"))) return false; 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean isRecipe2x2(int recipe) {
/* 211 */     for (PositionedStack stack : getIngredientStacks(recipe)) {
/*     */       
/* 213 */       if (stack.relx > 43 || stack.rely > 24) return false; 
/*     */     } 
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ShapedRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */