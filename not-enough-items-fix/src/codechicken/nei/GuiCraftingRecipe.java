/*    */ package codechicken.nei;
/*    */ 
/*    */ import gb;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import vp;
/*    */ 
/*    */ public class GuiCraftingRecipe extends GuiRecipe {
/*    */   private ArrayList currenthandlers;
/*    */   
/*    */   private GuiCraftingRecipe(gb prevgui, ArrayList handlers) {
/* 12 */     super(prevgui);
/* 13 */     this.currenthandlers = handlers;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void registerRecipeHandler(ICraftingHandler handler) {
/* 18 */     for (ICraftingHandler handler1 : craftinghandlers) {
/*    */       
/* 20 */       if (handler1.getClass() == handler.getClass()) {
/*    */         return;
/*    */       }
/*    */     } 
/* 24 */     craftinghandlers.add(handler);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean openRecipeGui(String outputId, Object... results) {
/* 29 */     Minecraft mc = NEIUtils.getMinecraft();
/* 30 */     if (!(mc.s instanceof gb))
/* 31 */       return false; 
/* 32 */     gb prevscreen = (gb)mc.s;
/*    */     
/* 34 */     ArrayList<ICraftingHandler> handlers = new ArrayList();
/* 35 */     for (ICraftingHandler craftinghandler : craftinghandlers) {
/*    */       
/* 37 */       ICraftingHandler handler = craftinghandler.getRecipeHandler(outputId, results);
/* 38 */       if (handler.getNumRecipes() > 0)
/* 39 */         handlers.add(handler); 
/*    */     } 
/* 41 */     if (handlers.isEmpty()) {
/* 42 */       return false;
/*    */     }
/* 44 */     mc.s = null;
/* 45 */     mc.a((vp)new GuiCraftingRecipe(prevscreen, handlers));
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList getCurrentRecipeHandlers() {
/* 51 */     return this.currenthandlers;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 56 */   private static ArrayList craftinghandlers = new ArrayList();
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiCraftingRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */