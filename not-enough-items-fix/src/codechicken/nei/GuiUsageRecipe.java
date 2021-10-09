/*    */ package codechicken.nei;
/*    */ 
/*    */ import gb;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import vp;
/*    */ 
/*    */ public class GuiUsageRecipe extends GuiRecipe {
/*    */   private ArrayList currenthandlers;
/*    */   
/*    */   private GuiUsageRecipe(gb prevgui, ArrayList handlers) {
/* 12 */     super(prevgui);
/* 13 */     this.currenthandlers = handlers;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void registerUsageHandler(IUsageHandler handler) {
/* 18 */     for (IUsageHandler handler1 : usagehandlers) {
/*    */       
/* 20 */       if (handler1.getClass() == handler.getClass()) {
/*    */         return;
/*    */       }
/*    */     } 
/* 24 */     usagehandlers.add(handler);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean openRecipeGui(String inputId, Object... ingredients) {
/* 29 */     Minecraft mc = NEIUtils.getMinecraft();
/* 30 */     if (!(mc.s instanceof gb))
/* 31 */       return false; 
/* 32 */     gb prevscreen = (gb)mc.s;
/*    */     
/* 34 */     ArrayList<IUsageHandler> handlers = new ArrayList();
/* 35 */     for (IUsageHandler usagehandler : usagehandlers) {
/*    */       
/* 37 */       IUsageHandler handler = usagehandler.getUsageHandler(inputId, ingredients);
/* 38 */       if (handler.getNumRecipes() > 0)
/* 39 */         handlers.add(handler); 
/*    */     } 
/* 41 */     if (handlers.isEmpty()) {
/* 42 */       return false;
/*    */     }
/* 44 */     mc.s = null;
/* 45 */     mc.a((vp)new GuiUsageRecipe(prevscreen, handlers));
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
/* 56 */   private static ArrayList usagehandlers = new ArrayList();
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiUsageRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */