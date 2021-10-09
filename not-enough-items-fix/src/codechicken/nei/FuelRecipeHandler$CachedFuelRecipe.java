/*    */ package codechicken.nei;
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
/*    */ public class CachedFuelRecipe
/*    */   extends TemplateRecipeHandler.CachedRecipe
/*    */ {
/*    */   public FurnaceRecipeHandler.FuelPair fuel;
/*    */   
/*    */   public CachedFuelRecipe(FurnaceRecipeHandler.FuelPair fuel) {
/* 20 */     this.fuel = fuel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PositionedStack getIngredient() {
/* 26 */     return ((FurnaceRecipeHandler.SmeltingPair)FuelRecipeHandler.mfurnace.get(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).ingred;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PositionedStack getResult() {
/* 32 */     return ((FurnaceRecipeHandler.SmeltingPair)FuelRecipeHandler.mfurnace.get(FuelRecipeHandler.this.cycleticks / 48 % FuelRecipeHandler.mfurnace.size())).result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PositionedStack getOtherStack() {
/* 38 */     return this.fuel.stack;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FuelRecipeHandler$CachedFuelRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */