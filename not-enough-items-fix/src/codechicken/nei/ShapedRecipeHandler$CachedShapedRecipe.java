/*    */ package codechicken.nei;
/*    */ 
/*    */ import ModLoader;
/*    */ import aai;
/*    */ import aan;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CachedShapedRecipe
/*    */   extends TemplateRecipeHandler.CachedRecipe
/*    */ {
/*    */   public ArrayList ingredients;
/*    */   public PositionedStack result;
/*    */   
/*    */   public CachedShapedRecipe(aai recipe) {
/* 22 */     this.result = new PositionedStack(recipe.b(), 119, 24);
/* 23 */     this.ingredients = new ArrayList();
/* 24 */     setIngredients(recipe);
/*    */   }
/*    */ 
/*    */   
/*    */   public CachedShapedRecipe(int width, int height, Object[] items, aan out) {
/* 29 */     this.result = new PositionedStack(out, 119, 24);
/* 30 */     this.ingredients = new ArrayList();
/* 31 */     setIngredients(width, height, items);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIngredients(int width, int height, Object[] items) {
/* 41 */     for (int x = 0; x < width; x++) {
/*    */       
/* 43 */       for (int y = 0; y < height; y++) {
/*    */         
/* 45 */         if (items[y * width + x] != null) {
/*    */ 
/*    */ 
/*    */           
/* 49 */           PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18);
/* 50 */           stack.setMaxSize(1);
/* 51 */           this.ingredients.add(stack);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIngredients(aai recipe) {
/*    */     int width, height;
/*    */     aan[] items;
/*    */     try {
/* 63 */       width = ((Integer)ModLoader.getPrivateValue(aai.class, recipe, 0)).intValue();
/* 64 */       height = ((Integer)ModLoader.getPrivateValue(aai.class, recipe, 1)).intValue();
/* 65 */       items = (aan[])ModLoader.getPrivateValue(aai.class, recipe, 2);
/*    */     }
/* 67 */     catch (Exception e) {
/*    */       
/* 69 */       e.printStackTrace();
/*    */       
/*    */       return;
/*    */     } 
/* 73 */     setIngredients(width, height, (Object[])items);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList getIngredients() {
/* 79 */     return getCycledIngredients(ShapedRecipeHandler.this.cycleticks / 20, this.ingredients);
/*    */   }
/*    */ 
/*    */   
/*    */   public PositionedStack getResult() {
/* 84 */     return this.result;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ShapedRecipeHandler$CachedShapedRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */