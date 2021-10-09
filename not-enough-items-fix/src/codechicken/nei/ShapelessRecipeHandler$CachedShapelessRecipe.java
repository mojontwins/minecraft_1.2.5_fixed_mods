/*    */ package codechicken.nei;
/*    */ 
/*    */ import ModLoader;
/*    */ import aan;
/*    */ import aif;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CachedShapelessRecipe
/*    */   extends TemplateRecipeHandler.CachedRecipe
/*    */ {
/*    */   ArrayList ingredients;
/*    */   PositionedStack result;
/*    */   
/*    */   public CachedShapelessRecipe(aan output) {
/* 34 */     this.result = new PositionedStack(output, 119, 24);
/* 35 */     this.ingredients = new ArrayList();
/*    */   }
/*    */ 
/*    */   
/*    */   public CachedShapelessRecipe(aif recipe) {
/* 40 */     this(recipe.b());
/* 41 */     setIngredients(recipe);
/*    */   }
/*    */ 
/*    */   
/*    */   public CachedShapelessRecipe(Object[] input, aan output) {
/* 46 */     this(Arrays.asList(input), output);
/*    */   }
/*    */ 
/*    */   
/*    */   public CachedShapelessRecipe(List input, aan output) {
/* 51 */     this(output);
/* 52 */     setIngredients(input);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setIngredients(List items) {
/* 57 */     for (int ingred = 0; ingred < items.size(); ingred++) {
/*    */       
/* 59 */       PositionedStack stack = new PositionedStack(items.get(ingred), 25 + ShapelessRecipeHandler.stackorder[ingred][0] * 18, 6 + ShapelessRecipeHandler.stackorder[ingred][1] * 18);
/* 60 */       stack.setMaxSize(1);
/* 61 */       this.ingredients.add(stack);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIngredients(aif recipe) {
/*    */     ArrayList items;
/*    */     try {
/* 71 */       items = (ArrayList)ModLoader.getPrivateValue(aif.class, recipe, 1);
/*    */     }
/* 73 */     catch (Exception e) {
/*    */       
/* 75 */       e.printStackTrace();
/*    */       
/*    */       return;
/*    */     } 
/* 79 */     setIngredients(items);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList getIngredients() {
/* 85 */     return getCycledIngredients(ShapelessRecipeHandler.this.cycleticks / 20, this.ingredients);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PositionedStack getResult() {
/* 91 */     return this.result;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ShapelessRecipeHandler$CachedShapelessRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */