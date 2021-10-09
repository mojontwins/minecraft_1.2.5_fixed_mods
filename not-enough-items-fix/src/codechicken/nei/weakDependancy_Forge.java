/*    */ package codechicken.nei;
/*    */ 
/*    */ import ModLoader;
/*    */ import forge.MinecraftForgeClient;
/*    */ import forge.oredict.ShapedOreRecipe;
/*    */ import forge.oredict.ShapelessOreRecipe;
/*    */ import java.util.ArrayList;
/*    */ import pb;
/*    */ import wf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class weakDependancy_Forge
/*    */ {
/*    */   public static void addMobSpawnerRenderer() {
/* 19 */     MinecraftForgeClient.registerItemRenderer(pb.as.bO, new SpawnerRenderer());
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean recipeInstanceShaped(wf irecipe) {
/* 24 */     return irecipe instanceof ShapedOreRecipe;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean recipeInstanceShapeless(wf irecipe) {
/* 29 */     return irecipe instanceof ShapelessOreRecipe;
/*    */   }
/*    */   public static ShapedRecipeHandler.CachedShapedRecipe getShapedRecipe(ShapedRecipeHandler handler, wf irecipe) {
/*    */     int width, height;
/*    */     Object[] items;
/* 34 */     ShapedOreRecipe recipe = (ShapedOreRecipe)irecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 41 */       width = ((Integer)ModLoader.getPrivateValue(ShapedOreRecipe.class, recipe, 4)).intValue();
/* 42 */       height = ((Integer)ModLoader.getPrivateValue(ShapedOreRecipe.class, recipe, 5)).intValue();
/* 43 */       items = (Object[])ModLoader.getPrivateValue(ShapedOreRecipe.class, recipe, 3);
/*    */     }
/* 45 */     catch (Exception e) {
/*    */       
/* 47 */       e.printStackTrace();
/* 48 */       return null;
/*    */     } 
/*    */     
/* 51 */     handler.getClass(); return new ShapedRecipeHandler.CachedShapedRecipe(handler, width, height, items, recipe.b());
/*    */   }
/*    */   
/*    */   public static ShapelessRecipeHandler.CachedShapelessRecipe getShapelessRecipe(ShapelessRecipeHandler handler, wf irecipe) {
/*    */     ArrayList items;
/* 56 */     ShapelessOreRecipe recipe = (ShapelessOreRecipe)irecipe;
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 61 */       items = (ArrayList)ModLoader.getPrivateValue(ShapelessOreRecipe.class, recipe, 1);
/*    */     }
/* 63 */     catch (Exception e) {
/*    */       
/* 65 */       e.printStackTrace();
/* 66 */       return null;
/*    */     } 
/*    */     
/* 69 */     handler.getClass(); return new ShapelessRecipeHandler.CachedShapelessRecipe(handler, items, recipe.b());
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\weakDependancy_Forge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */