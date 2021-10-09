/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
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
/*    */ public class SmeltingPair
/*    */   extends TemplateRecipeHandler.CachedRecipe
/*    */ {
/*    */   PositionedStack ingred;
/*    */   PositionedStack result;
/*    */   
/*    */   public SmeltingPair(aan ingred, aan result) {
/* 27 */     ingred.a = 1;
/* 28 */     this.ingred = new PositionedStack(ingred, 51, 6);
/* 29 */     this.result = new PositionedStack(result, 111, 24);
/*    */   }
/*    */ 
/*    */   
/*    */   public PositionedStack getIngredient() {
/* 34 */     int cycle = FurnaceRecipeHandler.this.cycleticks / 48;
/* 35 */     if (this.ingred.item.i() == -1) {
/*    */       
/* 37 */       PositionedStack stack = this.ingred.copy();
/* 38 */       int maxDamage = 0;
/*    */       
/*    */       do {
/* 41 */         maxDamage++;
/* 42 */         stack.item.b(maxDamage);
/*    */       }
/* 44 */       while (NEIUtils.isValidItem(stack.item));
/*    */       
/* 46 */       stack.item.b(cycle % maxDamage);
/* 47 */       return stack;
/*    */     } 
/* 49 */     return this.ingred;
/*    */   }
/*    */ 
/*    */   
/*    */   public PositionedStack getResult() {
/* 54 */     return this.result;
/*    */   }
/*    */ 
/*    */   
/*    */   public PositionedStack getOtherStack() {
/* 59 */     return ((FurnaceRecipeHandler.FuelPair)FurnaceRecipeHandler.afuels.get(FurnaceRecipeHandler.this.cycleticks / 48 % FurnaceRecipeHandler.afuels.size())).stack;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FurnaceRecipeHandler$SmeltingPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */