/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import java.util.ArrayList;
/*    */ import yr;
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
/*    */ public class CachedBrewingRecipe
/*    */   extends TemplateRecipeHandler.CachedRecipe
/*    */ {
/*    */   int hashcode;
/*    */   PositionedStack precursorPotion;
/*    */   PositionedStack result;
/*    */   PositionedStack ingredient;
/*    */   
/*    */   public CachedBrewingRecipe(int ingredID, int basePotionID, int resultDamage) {
/* 26 */     this.precursorPotion = new PositionedStack(new aan(yr.bs.bQ, 1, basePotionID), 51, 35);
/* 27 */     this.ingredient = new PositionedStack(new aan(ingredID, 1, 0), 74, 6);
/* 28 */     this.result = new PositionedStack(new aan(yr.bs.bQ, 1, resultDamage), 97, 35);
/* 29 */     calculateHashcode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PositionedStack getResult() {
/* 35 */     return this.result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList getIngredients() {
/* 41 */     ArrayList<PositionedStack> recipestacks = new ArrayList();
/* 42 */     recipestacks.add(this.ingredient);
/* 43 */     recipestacks.add(this.precursorPotion);
/* 44 */     return recipestacks;
/*    */   }
/*    */ 
/*    */   
/*    */   private void calculateHashcode() {
/* 49 */     this.hashcode = this.result.item.i() << 16 + this.precursorPotion.item.i();
/* 50 */     this.hashcode = 31 * this.hashcode + (this.ingredient.item.c << 16 + this.ingredient.item.i());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 55 */     if (!(obj instanceof CachedBrewingRecipe)) return false; 
/* 56 */     CachedBrewingRecipe recipe2 = (CachedBrewingRecipe)obj;
/* 57 */     if (this.result.item.i() == recipe2.result.item.i() && 
/* 58 */       this.precursorPotion.item.i() == recipe2.precursorPotion.item.i() && 
/* 59 */       NEIUtils.areStacksSameType(this.ingredient.item, recipe2.ingredient.item)) return true; 
/*    */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     return this.hashcode;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\BrewingRecipeHandler$CachedBrewingRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */