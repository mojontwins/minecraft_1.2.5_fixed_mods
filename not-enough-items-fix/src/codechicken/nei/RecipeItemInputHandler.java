/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import gb;
/*    */ 
/*    */ 
/*    */ public class RecipeItemInputHandler
/*    */   implements IHandleInput
/*    */ {
/*    */   public boolean canHandle(Class guiClass) {
/* 11 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean keyTyped(gb gui, char keyChar, int keyCode) {
/* 17 */     aan stackover = gui.getStackMouseOver();
/* 18 */     if (stackover == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     if (keyCode == NEIConfig.getKeyBinding("usage") || (keyCode == NEIConfig.getKeyBinding("recipe") && NEIUtils.shiftKey())) {
/* 22 */       return GuiUsageRecipe.openRecipeGui("item", new Object[] { stackover });
/*    */     }
/* 24 */     if (keyCode == NEIConfig.getKeyBinding("recipe")) {
/* 25 */       return GuiCraftingRecipe.openRecipeGui("item", new Object[] { stackover });
/*    */     }
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean mouseClicked(gb gui, int mousex, int mousey, int button) {
/* 33 */     aan stackover = gui.getStackMouseOver();
/* 34 */     if (stackover == null || !(gui instanceof GuiRecipe)) {
/* 35 */       return false;
/*    */     }
/* 37 */     if (button == 0) {
/* 38 */       return GuiCraftingRecipe.openRecipeGui("item", new Object[] { stackover });
/*    */     }
/* 40 */     if (button == 1) {
/* 41 */       return GuiUsageRecipe.openRecipeGui("item", new Object[] { stackover });
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\RecipeItemInputHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */