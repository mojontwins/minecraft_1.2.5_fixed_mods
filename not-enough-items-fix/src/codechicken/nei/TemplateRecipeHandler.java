/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import dd;
/*     */ import gb;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public abstract class TemplateRecipeHandler
/*     */   implements ICraftingHandler, IUsageHandler
/*     */ {
/*     */   public abstract class CachedRecipe
/*     */   {
/*     */     public abstract PositionedStack getResult();
/*     */     
/*     */     public ArrayList getIngredients() {
/*  45 */       ArrayList<PositionedStack> stacks = new ArrayList();
/*  46 */       PositionedStack stack = getIngredient();
/*  47 */       if (stack != null)
/*  48 */         stacks.add(stack); 
/*  49 */       return stacks;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getIngredient() {
/*  57 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList getOtherStacks() {
/*  67 */       ArrayList<PositionedStack> stacks = new ArrayList();
/*  68 */       PositionedStack stack = getOtherStack();
/*  69 */       if (stack != null)
/*  70 */         stacks.add(stack); 
/*  71 */       return stacks;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getOtherStack() {
/*  80 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList getCycledIngredients(int cycle, ArrayList<PositionedStack> ingredients) {
/*  89 */       ArrayList<PositionedStack> cycledstacks = new ArrayList();
/*  90 */       for (int itemIndex = 0; itemIndex < ingredients.size(); itemIndex++) {
/*     */         
/*  92 */         PositionedStack stack = ((PositionedStack)ingredients.get(itemIndex)).copy();
/*  93 */         if (stack.items.length > 1) {
/*     */ 
/*     */           
/*  96 */           Random rand = new Random((cycle + itemIndex) + this.offset);
/*  97 */           stack.setPermutationToRender(Math.abs(rand.nextInt()) % stack.items.length);
/*     */ 
/*     */         
/*     */         }
/* 101 */         else if (stack.item.i() == -1) {
/*     */           
/* 103 */           int maxDamage = 0;
/*     */           
/*     */           do {
/* 106 */             maxDamage++;
/* 107 */             stack.item.b(maxDamage);
/*     */           }
/* 109 */           while (NEIUtils.isValidItem(stack.item));
/*     */           
/* 111 */           stack.item.b(cycle % maxDamage);
/*     */         } 
/*     */         
/* 114 */         cycledstacks.add(stack);
/*     */       } 
/* 116 */       return cycledstacks;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void replaceMetaOnIngredients(Collection ingredients, aan ingredient) {
/* 125 */       for (PositionedStack stack : ingredients) {
/*     */         
/* 127 */         for (int i = 0; i < stack.items.length; i++) {
/*     */           
/* 129 */           if (NEIUtils.areStacksSameTypeCrafting(ingredient, stack.items[i])) {
/*     */             
/* 131 */             stack.item = stack.items[i];
/* 132 */             stack.item.b(ingredient.i());
/* 133 */             stack.items = new aan[] { stack.item };
/* 134 */             stack.setPermutationToRender(0);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean contains(Collection ingredients, aan ingredient) {
/* 147 */       for (PositionedStack stack : ingredients) {
/*     */         byte b; int i; aan[] arrayOfAan;
/* 149 */         for (i = (arrayOfAan = stack.items).length, b = 0; b < i; ) { aan item = arrayOfAan[b];
/*     */           
/* 151 */           if (NEIUtils.areStacksSameTypeCrafting(item, ingredient))
/* 152 */             return true;  b++; }
/*     */       
/*     */       } 
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     final long offset = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public class RecipeTransferRect
/*     */   {
/*     */     Rectangle rect;
/*     */     String outputId;
/*     */     Object[] results;
/*     */     
/*     */     public RecipeTransferRect(Rectangle rectangle, String outputId, Object... results) {
/* 169 */       this.rect = rectangle;
/* 170 */       this.outputId = outputId;
/* 171 */       this.results = results;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj) {
/* 176 */       if (!(obj instanceof RecipeTransferRect)) {
/* 177 */         return false;
/*     */       }
/* 179 */       return this.rect.equals(((RecipeTransferRect)obj).rect);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 184 */       return this.rect.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RecipeTransferRectInputHandler
/*     */     implements IHandleInput
/*     */   {
/* 194 */     private static HashMap guiMap = new HashMap<Object, Object>();
/*     */ 
/*     */     
/*     */     public static void registerRectsToGuis(List classes, List rects) {
/* 198 */       if (classes == null) {
/*     */         return;
/*     */       }
/* 201 */       for (Class<?> clazz : (Iterable<Class<?>>)classes) {
/*     */         
/* 203 */         HashSet set = (HashSet)guiMap.get(clazz);
/* 204 */         if (set == null) {
/*     */           
/* 206 */           set = new HashSet();
/* 207 */           guiMap.put(clazz, set);
/*     */         } 
/* 209 */         set.addAll(rects);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canHandle(Class guiClass) {
/* 216 */       return guiMap.containsKey(guiClass);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean keyTyped(gb gui, char keyChar, int keyCode) {
/* 222 */       if (keyCode == NEIConfig.getKeyBinding("recipe"))
/* 223 */         return transferRect(gui, false); 
/* 224 */       if (keyCode == NEIConfig.getKeyBinding("usage")) {
/* 225 */         return transferRect(gui, true);
/*     */       }
/* 227 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean mouseClicked(gb gui, int mousex, int mousey, int button) {
/* 233 */       if (button == 0)
/* 234 */         return transferRect(gui, false); 
/* 235 */       if (button == 1) {
/* 236 */         return transferRect(gui, true);
/*     */       }
/* 238 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean transferRect(gb gui, boolean usage) {
/* 243 */       return TemplateRecipeHandler.transferRect(gui, (Collection)guiMap.get(gui.getClass()), 5, 11, usage);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 249 */     API.addInputHandler(new RecipeTransferRectInputHandler());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 256 */   public int cycleticks = Math.abs((int)System.currentTimeMillis());
/*     */ 
/*     */ 
/*     */   
/* 260 */   public ArrayList arecipes = new ArrayList();
/*     */ 
/*     */ 
/*     */   
/* 264 */   public LinkedList transferRects = new LinkedList();
/*     */ 
/*     */   
/*     */   public TemplateRecipeHandler() {
/* 268 */     loadTransferRects();
/* 269 */     RecipeTransferRectInputHandler.registerRectsToGuis(getRecipeTransferRectGuis(), this.transferRects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadTransferRects() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/* 289 */     if (outputId.equals("item")) {
/* 290 */       loadCraftingRecipes((aan)results[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(aan result) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(String inputId, Object... ingredients) {
/* 307 */     if (inputId.equals("item")) {
/* 308 */       loadUsageRecipes((aan)ingredients[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOverlayIdentifier() {
/* 329 */     return "";
/*     */   }
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
/*     */   public void drawExtras(GuiManager gui, int recipe) {}
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
/*     */   public void drawProgressBar(GuiManager gui, int x, int y, int tx, int ty, int w, int h, int ticks, int direction) {
/* 355 */     drawProgressBar(gui, x, y, tx, ty, w, h, (this.cycleticks % ticks) / ticks, direction);
/*     */   }
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
/*     */   public void drawProgressBar(GuiManager gui, int x, int y, int tx, int ty, int w, int h, float completion, int direction) {
/* 374 */     if (direction > 3) {
/*     */       
/* 376 */       completion = 1.0F - completion;
/* 377 */       direction %= 4;
/*     */     } 
/* 379 */     int var = (int)(completion * ((direction % 2 == 0) ? w : h));
/*     */     
/* 381 */     switch (direction) {
/*     */       
/*     */       case 0:
/* 384 */         gui.drawTexturedModalRect(x, y, tx, ty, var, h);
/*     */         break;
/*     */       case 1:
/* 387 */         gui.drawTexturedModalRect(x, y, tx, ty, w, var);
/*     */         break;
/*     */       case 2:
/* 390 */         gui.drawTexturedModalRect(x + w - var, y, tx + w - var, ty, var, h);
/*     */         break;
/*     */       case 3:
/* 393 */         gui.drawTexturedModalRect(x, y + h - var, tx, ty + h - var, w, var);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getRecipeTransferRectGuis() {
/* 403 */     Class<?> clazz = getGuiClass();
/* 404 */     if (clazz != null) {
/*     */       
/* 406 */       LinkedList<Class<?>> list = new LinkedList();
/* 407 */       list.add(clazz);
/* 408 */       return list;
/*     */     } 
/* 410 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getGuiClass() {
/* 418 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private TemplateRecipeHandler newInstance() {
/*     */     try {
/* 425 */       return (TemplateRecipeHandler)getClass().newInstance();
/*     */     }
/* 427 */     catch (Exception e) {
/*     */       
/* 429 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ICraftingHandler getRecipeHandler(String outputId, Object... results) {
/* 435 */     TemplateRecipeHandler handler = newInstance();
/* 436 */     handler.loadCraftingRecipes(outputId, results);
/* 437 */     return handler;
/*     */   }
/*     */ 
/*     */   
/*     */   public IUsageHandler getUsageHandler(String inputId, Object... ingredients) {
/* 442 */     TemplateRecipeHandler handler = newInstance();
/* 443 */     handler.loadUsageRecipes(inputId, ingredients);
/* 444 */     return handler;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumRecipes() {
/* 449 */     return this.arecipes.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBackground(GuiManager gui, int recipe) {
/* 454 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 455 */     gui.bindTextureByName(getGuiTexture());
/* 456 */     gui.drawTexturedModalRect(0, 0, 5, 11, 166, 65);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawForeground(GuiManager gui, int recipe) {
/* 461 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 462 */     gui.bindTextureByName(getGuiTexture());
/* 463 */     drawExtras(gui, recipe);
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList getIngredientStacks(int recipe) {
/* 468 */     return ((CachedRecipe)this.arecipes.get(recipe)).getIngredients();
/*     */   }
/*     */ 
/*     */   
/*     */   public PositionedStack getResultStack(int recipe) {
/* 473 */     return ((CachedRecipe)this.arecipes.get(recipe)).getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList getOtherStacks(int recipe) {
/* 478 */     return ((CachedRecipe)this.arecipes.get(recipe)).getOtherStacks();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 483 */     this.cycleticks++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOverlay(gb gui, dd container, int recipe) {
/* 488 */     return DefaultOverlayRenderer.getOverlayIdent(gui).equals(getOverlayIdentifier());
/*     */   }
/*     */ 
/*     */   
/*     */   public IRecipeOverlayRenderer getOverlayRenderer(gb gui, int recipe) {
/* 493 */     return new DefaultOverlayRenderer(getIngredientStacks(recipe), gui);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecipiesPerPage() {
/* 499 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List handleTooltip(GuiRecipe gui, List currenttip, int recipe) {
/* 505 */     return currenttip;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyTyped(GuiRecipe gui, char keyChar, int keyCode, int recipe) {
/* 511 */     if (keyCode == NEIConfig.getKeyBinding("recipe"))
/* 512 */       return transferRect(gui, recipe, false); 
/* 513 */     if (keyCode == NEIConfig.getKeyBinding("usage")) {
/* 514 */       return transferRect(gui, recipe, true);
/*     */     }
/* 516 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mouseClicked(GuiRecipe gui, int button, int recipe) {
/* 522 */     if (button == 0)
/* 523 */       return transferRect(gui, recipe, false); 
/* 524 */     if (button == 1) {
/* 525 */       return transferRect(gui, recipe, true);
/*     */     }
/* 527 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean transferRect(GuiRecipe gui, int recipe, boolean usage) {
/* 532 */     Point offset = gui.getRecipePosition(recipe);
/* 533 */     return transferRect(gui, this.transferRects, offset.x, offset.y, usage);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean transferRect(gb gui, Collection transferRects, int offsetx, int offsety, boolean usage) {
/* 538 */     Point pos = NEIUtils.getMousePosition();
/* 539 */     Point relMouse = new Point(pos.x - gui.e - offsetx, pos.y - gui.f - offsety);
/* 540 */     for (RecipeTransferRect rect : transferRects) {
/*     */       
/* 542 */       if (rect.rect.contains(relMouse) && (
/* 543 */         usage ? 
/* 544 */         GuiUsageRecipe.openRecipeGui(rect.outputId, rect.results) : 
/* 545 */         GuiCraftingRecipe.openRecipeGui(rect.outputId, rect.results))) {
/* 546 */         return true;
/*     */       }
/*     */     } 
/* 549 */     return false;
/*     */   }
/*     */   
/*     */   public abstract String getGuiTexture();
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TemplateRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */