/*     */ package codechicken.nei;
/*     */ 
/*     */ import abp;
/*     */ import gb;
/*     */ import java.awt.Point;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import vp;
/*     */ import yu;
/*     */ 
/*     */ public abstract class GuiRecipe extends gb implements IClientSideGuiContainer, IGuiContainerOverlay, IHandleTooltip {
/*     */   public int page;
/*     */   public int recipetype;
/*     */   
/*     */   protected GuiRecipe(gb prevgui) {
/*  18 */     super(new ContainerRecipe());
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
/* 313 */     this.currenthandlers = new ArrayList();
/*     */     this.slotcontainer = (ContainerRecipe)this.d;
/*     */     this.prevGui = prevgui;
/*     */     this.firstGui = prevgui;
/*     */     if (prevgui instanceof IGuiContainerOverlay)
/*     */       this.firstGui = ((IGuiContainerOverlay)prevgui).getFirstScreen(); 
/*     */   }
/*     */   
/*     */   public ContainerRecipe slotcontainer;
/*     */   public gb firstGui;
/*     */   public gb prevGui;
/*     */   public abp nextpage;
/*     */   public abp prevpage;
/*     */   public abp overlay1;
/*     */   public abp overlay2;
/*     */   public ArrayList currenthandlers;
/*     */   
/*     */   public void c() {
/*     */     super.c();
/*     */     this.currenthandlers = getCurrentRecipeHandlers();
/*     */     abp nexttype = new GuiNEIButton(0, this.q / 2 - 70, (this.r - this.c) / 2 + 3, 13, 12, "<");
/*     */     abp prevtype = new GuiNEIButton(1, this.q / 2 + 57, (this.r - this.c) / 2 + 3, 13, 12, ">");
/*     */     this.nextpage = new GuiNEIButton(2, this.q / 2 - 70, (this.r + this.c) / 2 - 18, 13, 12, "<");
/*     */     this.prevpage = new GuiNEIButton(3, this.q / 2 + 57, (this.r + this.c) / 2 - 18, 13, 12, ">");
/*     */     this.overlay1 = new GuiNEIButton(4, this.q / 2 + 65, (this.r - this.c) / 2 + 63, 13, 12, "?");
/*     */     this.overlay2 = new GuiNEIButton(5, this.q / 2 + 65, (this.r - this.c) / 2 + 128, 13, 12, "?");
/*     */     this.s.add(nexttype);
/*     */     this.s.add(prevtype);
/*     */     this.s.add(this.nextpage);
/*     */     this.s.add(this.prevpage);
/*     */     this.s.add(this.overlay1);
/*     */     this.s.add(this.overlay2);
/*     */     if (this.currenthandlers.size() == 1) {
/*     */       nexttype.i = false;
/*     */       prevtype.i = false;
/*     */     } 
/*     */     refreshPage();
/*     */   }
/*     */   
/*     */   protected void a(char c, int i) {
/*     */     if (i == 1) {
/*     */       this.firstGui.refresh();
/*     */       this.p.a((vp)this.firstGui);
/*     */       return;
/*     */     } 
/*     */     if (LayoutManager.keyPress(i, c))
/*     */       return; 
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int recipe = this.page * 2; recipe < recipehandler.getNumRecipes() && recipe < (this.page + 1) * 2; recipe++) {
/*     */       if (recipehandler.keyTyped(this, c, i, recipe))
/*     */         return; 
/*     */     } 
/*     */     if (i == this.p.A.s.d) {
/*     */       this.firstGui.refresh();
/*     */       this.p.a((vp)this.firstGui);
/*     */     } else if (i == NEIConfig.getKeyBinding("back")) {
/*     */       this.firstGui.refresh();
/*     */       this.p.a((vp)this.prevGui);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(int par1, int par2, int par3) {
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int recipe = this.page * 2; recipe < recipehandler.getNumRecipes() && recipe < (this.page + 1) * 2; recipe++) {
/*     */       if (recipehandler.mouseClicked(this, par3, recipe))
/*     */         return; 
/*     */     } 
/*     */     super.a(par1, par2, par3);
/*     */   }
/*     */   
/*     */   protected void a(abp guibutton) {
/*     */     super.a(guibutton);
/*     */     switch (guibutton.f) {
/*     */       case 0:
/*     */         prevType();
/*     */         break;
/*     */       case 1:
/*     */         nextType();
/*     */         break;
/*     */       case 2:
/*     */         prevPage();
/*     */         break;
/*     */       case 3:
/*     */         nextPage();
/*     */         break;
/*     */       case 4:
/*     */         overlayRecipe(this.page * 2);
/*     */         break;
/*     */       case 5:
/*     */         overlayRecipe(this.page * 2 + 1);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a() {
/*     */     super.a();
/*     */     ((IRecipeHandler)this.currenthandlers.get(this.recipetype)).onUpdate();
/*     */     refreshPage();
/*     */   }
/*     */   
/*     */   public void addTooltipHandlers(LinkedList<GuiRecipe> tooltipHandlers) {
/*     */     tooltipHandlers.add(this);
/*     */   }
/*     */   
/*     */   public boolean canHandle(Class guiClass) {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public List handleTooltip(gb gui, List currenttip) {
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int i = this.page * 2; i < recipehandler.getNumRecipes() && i < (this.page + 1) * 2; i++)
/*     */       currenttip = recipehandler.handleTooltip(this, currenttip, i); 
/*     */     return currenttip;
/*     */   }
/*     */   
/*     */   private void nextPage() {
/*     */     this.page++;
/*     */     if (this.page > (((IRecipeHandler)this.currenthandlers.get(this.recipetype)).getNumRecipes() - 1) / 2)
/*     */       this.page = 0; 
/*     */   }
/*     */   
/*     */   private void prevPage() {
/*     */     this.page--;
/*     */     if (this.page < 0)
/*     */       this.page = (((IRecipeHandler)this.currenthandlers.get(this.recipetype)).getNumRecipes() - 1) / 2; 
/*     */   }
/*     */   
/*     */   private void nextType() {
/*     */     this.recipetype++;
/*     */     if (this.recipetype >= this.currenthandlers.size())
/*     */       this.recipetype = 0; 
/*     */     this.page = 0;
/*     */   }
/*     */   
/*     */   private void prevType() {
/*     */     this.recipetype--;
/*     */     if (this.recipetype < 0)
/*     */       this.recipetype = this.currenthandlers.size() - 1; 
/*     */     this.page = 0;
/*     */   }
/*     */   
/*     */   private void overlayRecipe(int recipe) {
/*     */     IRecipeOverlayRenderer renderer = ((IRecipeHandler)this.currenthandlers.get(this.recipetype)).getOverlayRenderer(this.firstGui, recipe);
/*     */     if (renderer == null)
/*     */       return; 
/*     */     this.firstGui.refresh();
/*     */     this.p.a((vp)this.firstGui);
/*     */     NEIController.overlayRenderer = renderer;
/*     */   }
/*     */   
/*     */   public void refreshPage() {
/*     */     refreshSlots();
/*     */     IRecipeHandler handler = this.currenthandlers.get(this.recipetype);
/*     */     boolean multiplepages = (handler.getNumRecipes() > 2);
/*     */     this.nextpage.i = multiplepages;
/*     */     this.prevpage.i = multiplepages;
/*     */     gb mainInv = getFirstScreen();
/*     */     this.overlay1.i = handler.hasOverlay(mainInv, mainInv.d, this.page * 2);
/*     */     this.overlay2.i = (this.page * 2 + 1 < handler.getNumRecipes() && handler.hasOverlay(mainInv, mainInv.d, this.page * 2 + 1));
/*     */   }
/*     */   
/*     */   private void refreshSlots() {
/*     */     this.slotcontainer.e.clear();
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int i = this.page * 2; i < recipehandler.getNumRecipes() && i < (this.page + 1) * 2; i++) {
/*     */       Point p = getRecipePosition(i);
/*     */       ArrayList stacks = recipehandler.getIngredientStacks(i);
/*     */       for (PositionedStack stack : stacks)
/*     */         this.slotcontainer.addSlot(stack, p.x, p.y); 
/*     */       stacks = recipehandler.getOtherStacks(i);
/*     */       for (PositionedStack stack : stacks)
/*     */         this.slotcontainer.addSlot(stack, p.x, p.y); 
/*     */       PositionedStack result = recipehandler.getResultStack(i);
/*     */       if (result != null)
/*     */         this.slotcontainer.addSlot(result, p.x, p.y); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void d() {
/*     */     super.d();
/*     */     String s = ((IRecipeHandler)this.currenthandlers.get(this.recipetype)).getRecipeName();
/*     */     this.u.b(s, (this.b - this.u.a(s)) / 2, 5, 4210752);
/*     */     s = "Page " + (this.page + 1) + "/" + ((((IRecipeHandler)this.currenthandlers.get(this.recipetype)).getNumRecipes() - 1) / 2 + 1);
/*     */     this.u.b(s, (this.b - this.u.a(s)) / 2, this.c - 16, 4210752);
/*     */     GL11.glPushMatrix();
/*     */     GL11.glTranslatef(5.0F, 16.0F, 0.0F);
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int i = this.page * 2; i < recipehandler.getNumRecipes() && i < (this.page + 1) * 2; i++) {
/*     */       recipehandler.drawForeground(new GuiManager(this), i);
/*     */       GL11.glTranslatef(0.0F, 65.0F, 0.0F);
/*     */     } 
/*     */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   protected void a(float f, int mx, int my) {
/*     */     int texid = this.p.p.b("/codechicken/nei/recipebg.png");
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     this.p.p.b(texid);
/*     */     int j = (this.q - this.b) / 2;
/*     */     int k = (this.r - this.c) / 2;
/*     */     b(j, k, 0, 0, this.b, this.c);
/*     */     GL11.glPushMatrix();
/*     */     GL11.glTranslatef((j + 5), (k + 16), 0.0F);
/*     */     IRecipeHandler recipehandler = this.currenthandlers.get(this.recipetype);
/*     */     for (int i = this.page * 2; i < recipehandler.getNumRecipes() && i < (this.page + 1) * 2; i++) {
/*     */       recipehandler.drawBackground(new GuiManager(this), i);
/*     */       GL11.glTranslatef(0.0F, 65.0F, 0.0F);
/*     */     } 
/*     */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public gb getFirstScreen() {
/*     */     return this.firstGui;
/*     */   }
/*     */   
/*     */   public boolean isMouseOver(PositionedStack stack, int recipe) {
/*     */     yu stackSlot = this.slotcontainer.getSlotWithStack(stack, (getRecipePosition(recipe)).x, (getRecipePosition(recipe)).y);
/*     */     Point mousepos = NEIUtils.getMousePosition();
/*     */     yu mouseoverSlot = a(mousepos.x, mousepos.y);
/*     */     return (stackSlot == mouseoverSlot);
/*     */   }
/*     */   
/*     */   public Point getRecipePosition(int recipe) {
/*     */     return new Point(5, 16 + recipe % 2 * 65);
/*     */   }
/*     */   
/*     */   public abstract ArrayList getCurrentRecipeHandlers();
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */