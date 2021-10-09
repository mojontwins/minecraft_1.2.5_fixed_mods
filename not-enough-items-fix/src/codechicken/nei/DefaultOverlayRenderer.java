/*    */ package codechicken.nei;
/*    */ 
/*    */ import gb;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class DefaultOverlayRenderer
/*    */   implements IRecipeOverlayRenderer
/*    */ {
/*    */   static class struct_1 {
/*    */     IStackPositioner positioner;
/*    */     String ident;
/*    */     
/*    */     public struct_1(String s, IStackPositioner p) {
/* 16 */       this.positioner = p;
/* 17 */       this.ident = s;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   static HashMap guiMap = new HashMap<Object, Object>();
/*    */   IStackPositioner positioner;
/*    */   
/*    */   public static void registerGuiOverlay(Class<?> classz, String ident, IStackPositioner positioner) {
/* 28 */     guiMap.put(classz, new struct_1(ident, positioner));
/*    */   }
/*    */   ArrayList ingreds;
/*    */   
/*    */   public static String getOverlayIdent(gb gui) {
/* 33 */     struct_1 s = (struct_1)guiMap.get(gui.getClass());
/* 34 */     if (s == null) return ""; 
/* 35 */     return s.ident;
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultOverlayRenderer(ArrayList ai, gb container) {
/* 40 */     this.positioner = ((struct_1)guiMap.get(container.getClass())).positioner;
/* 41 */     this.ingreds = this.positioner.positionStacks(ai);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderOverlay(GuiManager gui) {
/* 46 */     GL11.glEnable(3042);
/* 47 */     GL11.glBlendFunc(770, 1);
/* 48 */     GL11.glColor4d(0.6D, 0.6D, 0.6D, 0.7D);
/*    */     
/* 50 */     gui.setColouredItemRender(true);
/* 51 */     for (PositionedStack stack : this.ingreds)
/*    */     {
/* 53 */       gui.drawItem(stack.relx, stack.rely, stack.item);
/*    */     }
/* 55 */     gui.setColouredItemRender(false);
/*    */     
/* 57 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 58 */     GL11.glDisable(3042);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\DefaultOverlayRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */