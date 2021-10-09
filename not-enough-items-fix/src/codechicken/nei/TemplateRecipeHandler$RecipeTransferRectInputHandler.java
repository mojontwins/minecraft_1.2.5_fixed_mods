/*     */ package codechicken.nei;
/*     */ 
/*     */ import gb;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecipeTransferRectInputHandler
/*     */   implements IHandleInput
/*     */ {
/* 194 */   private static HashMap guiMap = new HashMap<Object, Object>();
/*     */ 
/*     */   
/*     */   public static void registerRectsToGuis(List classes, List rects) {
/* 198 */     if (classes == null) {
/*     */       return;
/*     */     }
/* 201 */     for (Class<?> clazz : (Iterable<Class<?>>)classes) {
/*     */       
/* 203 */       HashSet set = (HashSet)guiMap.get(clazz);
/* 204 */       if (set == null) {
/*     */         
/* 206 */         set = new HashSet();
/* 207 */         guiMap.put(clazz, set);
/*     */       } 
/* 209 */       set.addAll(rects);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canHandle(Class guiClass) {
/* 216 */     return guiMap.containsKey(guiClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyTyped(gb gui, char keyChar, int keyCode) {
/* 222 */     if (keyCode == NEIConfig.getKeyBinding("recipe"))
/* 223 */       return transferRect(gui, false); 
/* 224 */     if (keyCode == NEIConfig.getKeyBinding("usage")) {
/* 225 */       return transferRect(gui, true);
/*     */     }
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mouseClicked(gb gui, int mousex, int mousey, int button) {
/* 233 */     if (button == 0)
/* 234 */       return transferRect(gui, false); 
/* 235 */     if (button == 1) {
/* 236 */       return transferRect(gui, true);
/*     */     }
/* 238 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean transferRect(gb gui, boolean usage) {
/* 243 */     return TemplateRecipeHandler.access$0(gui, (Collection)guiMap.get(gui.getClass()), 5, 11, usage);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TemplateRecipeHandler$RecipeTransferRectInputHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */