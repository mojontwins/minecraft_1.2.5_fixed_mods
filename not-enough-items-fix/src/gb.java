/*     */ import codechicken.core.CoreUtils;
/*     */ import codechicken.nei.GuiExtendedCreativeInv;
/*     */ import codechicken.nei.LayoutManager;
/*     */ import codechicken.nei.NEIConfig;
/*     */ import codechicken.nei.NEIController;
/*     */ import codechicken.nei.NEIPacketHandler;
/*     */ import codechicken.nei.NEIUtils;
/*     */ import java.awt.Point;
/*     */ import java.util.LinkedList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import org.lwjgl.input.Mouse;
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
/*     */ public abstract class gb
/*     */   extends vp
/*     */ {
/*  32 */   public static tw a = new tw();
/*     */   
/*  34 */   public int b = 176;
/*     */ 
/*     */   
/*  37 */   public int c = 166;
/*     */ 
/*     */   
/*     */   public dd d;
/*     */ 
/*     */   
/*     */   public int e;
/*     */ 
/*     */   
/*     */   public int f;
/*     */   
/*     */   public NEIController controller;
/*     */ 
/*     */   
/*     */   public gb(dd par1Container) {
/*  52 */     this.d = par1Container;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Minecraft mc, int i, int j) {
/*  58 */     super.a(mc, i, j);
/*  59 */     if (mc.s == this) {
/*  60 */       this.controller = new NEIController(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c() {
/*  68 */     if (checkCreativeInv()) {
/*     */       return;
/*     */     }
/*  71 */     super.c();
/*  72 */     this.p.h.ar = this.d;
/*  73 */     this.e = (this.q - this.b) / 2;
/*  74 */     this.f = (this.r - this.c) / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int par1, int par2, float par3) {
/*  82 */     if (!NEIConfig.isHidden() && NEIConfig.isEnabled()) {
/*     */       
/*  84 */       this.e = (this.q - this.b) / 2;
/*  85 */       this.f = (this.r - this.c) / 2;
/*     */     } 
/*     */     
/*  88 */     k();
/*  89 */     int var4 = this.e;
/*  90 */     int var5 = this.f;
/*  91 */     a(par3, par1, par2);
/*     */     
/*  93 */     super.a(par1, par2, par3);
/*     */     
/*  95 */     es.a(es.b);
/*  96 */     GL11.glDisable(3553);
/*  97 */     es.a(es.a);
/*     */     
/*  99 */     tf.c();
/* 100 */     GL11.glPushMatrix();
/* 101 */     GL11.glTranslatef(var4, var5, 0.0F);
/* 102 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 103 */     GL11.glEnable(32826);
/* 104 */     es.a(es.b, 240.0F, 240.0F);
/* 105 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 107 */     NEIController.drawOverlay();
/* 108 */     GL11.glEnable(2929);
/* 109 */     GL11.glEnable(2896);
/*     */ 
/*     */ 
/*     */     
/* 113 */     boolean mouseoverwidget = LayoutManager.widgetContains(par1, par2);
/* 114 */     for (int var20 = 0; var20 < this.d.e.size(); var20++) {
/*     */       
/* 116 */       yu var23 = this.d.e.get(var20);
/* 117 */       a(var23);
/*     */       
/* 119 */       if (a(var23, par1, par2) && !mouseoverwidget) {
/*     */         
/* 121 */         GL11.glDisable(2896);
/* 122 */         GL11.glDisable(2929);
/* 123 */         int var9 = var23.d;
/* 124 */         int var10 = var23.e;
/* 125 */         a(var9, var10, var9 + 16, var10 + 16, -2130706433, -2130706433);
/* 126 */         GL11.glEnable(2896);
/* 127 */         GL11.glEnable(2929);
/*     */       } 
/*     */     } 
/*     */     
/* 131 */     tf.a();
/* 132 */     GL11.glDisable(2929);
/* 133 */     d();
/* 134 */     tf.c();
/*     */     
/* 136 */     GL11.glTranslatef(-var4, -var5, 400.0F);
/* 137 */     LayoutManager.draw(par1, par2);
/* 138 */     GL11.glTranslatef(var4, var5, -400.0F);
/*     */     
/* 140 */     LayoutManager.gui.enable3DRender();
/* 141 */     aak var21 = this.p.h.ap;
/*     */     
/* 143 */     if (var21.k() != null) {
/*     */       
/* 145 */       GL11.glTranslatef(0.0F, 0.0F, 32.0F);
/* 146 */       this.g = 600.0F;
/* 147 */       a.b = 600.0F;
/* 148 */       a.a(this.u, this.p.p, var21.k(), par1 - var4 - 8, par2 - var5 - 8);
/* 149 */       a.b(this.u, this.p.p, var21.k(), par1 - var4 - 8, par2 - var5 - 8);
/* 150 */       this.g = 0.0F;
/* 151 */       a.b = 0.0F;
/*     */     } 
/*     */     
/* 154 */     LayoutManager.gui.enable2DRender();
/* 155 */     LayoutManager.showToolTip(par1, par2);
/*     */     
/* 157 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void d() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void a(float paramFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(yu par1Slot) {
/* 175 */     int var2 = par1Slot.d;
/* 176 */     int var3 = par1Slot.e;
/* 177 */     aan var4 = par1Slot.b();
/* 178 */     boolean var5 = false;
/* 179 */     this.g = 100.0F;
/* 180 */     a.b = 100.0F;
/*     */     
/* 182 */     if (var4 == null) {
/*     */       
/* 184 */       int var8 = par1Slot.e();
/*     */       
/* 186 */       if (var8 >= 0) {
/*     */         
/* 188 */         GL11.glDisable(2896);
/* 189 */         this.p.p.b(this.p.p.b("/gui/items.png"));
/* 190 */         b(var2, var3, var8 % 16 * 16, var8 / 16 * 16, 16, 16);
/* 191 */         GL11.glEnable(2896);
/* 192 */         var5 = true;
/*     */       } 
/*     */     } 
/*     */     
/* 196 */     if (!var5) {
/*     */       
/* 198 */       a.a(this.u, this.p.p, var4, var2, var3);
/* 199 */       a.b(this.u, this.p.p, var4, var2, var3);
/* 200 */       if (NEIConfig.getBooleanSetting("options.searchinventories") && ((var4 == null) ? !NEIConfig.getSearchExpression().equals("") : !NEIUtils.itemMatchesSearch(var4))) {
/*     */         
/* 202 */         GL11.glDisable(2896);
/* 203 */         GL11.glTranslatef(0.0F, 0.0F, 150.0F);
/* 204 */         a(var2, var3, var2 + 16, var3 + 16, -2147483648);
/* 205 */         GL11.glTranslatef(0.0F, 0.0F, -150.0F);
/* 206 */         GL11.glEnable(2896);
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     a.b = 0.0F;
/* 211 */     this.g = 0.0F;
/*     */     
/* 213 */     if (this == null) {
/*     */       
/* 215 */       this.g = 100.0F;
/* 216 */       a.b = 100.0F;
/*     */       
/* 218 */       if (var4 == null) {
/*     */         
/* 220 */         int var6 = par1Slot.e();
/*     */         
/* 222 */         if (var6 >= 0) {
/*     */           
/* 224 */           GL11.glDisable(2896);
/* 225 */           this.p.p.b(this.p.p.b("/gui/items.png"));
/* 226 */           b(var2, var3, var6 % 16 * 16, var6 / 16 * 16, 16, 16);
/* 227 */           GL11.glEnable(2896);
/* 228 */           var5 = true;
/*     */         } 
/*     */       } 
/*     */       
/* 232 */       if (!var5) {
/*     */         
/* 234 */         a.a(this.u, this.p.p, var4, var2, var3);
/* 235 */         a.b(this.u, this.p.p, var4, var2, var3);
/*     */       } 
/*     */       
/* 238 */       a.b = 0.0F;
/* 239 */       this.g = 0.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public yu a(int par1, int par2) {
/* 248 */     for (int var3 = 0; var3 < this.d.e.size(); var3++) {
/*     */       
/* 250 */       yu var4 = this.d.e.get(var3);
/*     */       
/* 252 */       if (a(var4, par1, par2))
/*     */       {
/* 254 */         return var4;
/*     */       }
/*     */     } 
/*     */     
/* 258 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(int par1, int par2, int par3) {
/* 266 */     super.a(par1, par2, par3);
/* 267 */     boolean mouseoverslot = (par1 >= this.e && par2 >= this.f && par1 <= this.e + this.b && par2 <= this.f + this.c);
/* 268 */     this.controller.replacementClickHandler(par1, par2, par3, mouseoverslot, a(par1, par2), this.p, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(yu par1Slot, int par2, int par3) {
/* 276 */     int var4 = this.e;
/* 277 */     int var5 = this.f;
/* 278 */     par2 -= var4;
/* 279 */     par3 -= var5;
/* 280 */     return (par2 >= par1Slot.d - 1 && par2 < par1Slot.d + 16 + 1 && par3 >= par1Slot.e - 1 && par3 < par1Slot.e + 16 + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(yu par1Slot, int par2, int par3, boolean par4) {
/* 285 */     if (par1Slot != null)
/*     */     {
/* 287 */       par2 = par1Slot.c;
/*     */     }
/* 289 */     if (par2 == -1) {
/*     */       return;
/*     */     }
/* 292 */     if (this instanceof codechicken.nei.IClientSideGuiContainer) {
/*     */       
/* 294 */       this.p.h.ar.a(par2, par3, par4, (yw)this.p.h);
/*     */     }
/*     */     else {
/*     */       
/* 298 */       this.p.c.a(this.d.f, par2, par3, par4, (yw)this.p.h);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clickSlot(yu par1Slot, int par2, int par3, boolean par4) {
/* 304 */     a(par1Slot, par2, par3, par4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void b(int i, int j, int k) {
/* 309 */     LayoutManager.mouseUp(i, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(char par1, int par2) {
/* 317 */     if (par2 == 1) {
/*     */       
/* 319 */       this.p.h.af();
/*     */       return;
/*     */     } 
/* 322 */     if (LayoutManager.keyPress(par2, par1)) {
/*     */       return;
/*     */     }
/*     */     
/* 326 */     if (par2 == this.p.A.s.d) {
/*     */       
/* 328 */       this.p.h.af();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e() {
/* 338 */     if (this.p.h != null) {
/*     */       
/* 340 */       this.d.a((yw)this.p.h);
/* 341 */       this.p.c.a(this.d.f, (yw)this.p.h);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean b() {
/* 350 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a() {
/* 358 */     super.a();
/*     */     
/* 360 */     if (!this.p.h.M() || this.p.h.G)
/*     */     {
/* 362 */       this.p.h.af();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void i() {
/* 368 */     super.i();
/*     */     
/* 370 */     if (checkCreativeInv()) {
/*     */       return;
/*     */     }
/* 373 */     LayoutManager.tick();
/*     */   }
/*     */ 
/*     */   
/*     */   public void f() {
/* 378 */     super.f();
/* 379 */     int i = Mouse.getEventDWheel();
/* 380 */     if (i != 0)
/*     */     {
/* 382 */       NEIController.onMouseWheel(-i / 120);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void refresh() {
/* 388 */     this.controller = new NEIController(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTooltipHandlers(LinkedList tooltipHandlers) {}
/*     */ 
/*     */   
/*     */   public aan getStackMouseOver() {
/* 397 */     Point mousePos = NEIUtils.getMousePosition();
/*     */     
/* 399 */     aan hoveritem = LayoutManager.getStackMouseOver(mousePos.x, mousePos.y);
/* 400 */     if (hoveritem != null) {
/* 401 */       return hoveritem;
/*     */     }
/* 403 */     yu hoverslot = a(mousePos.x, mousePos.y);
/* 404 */     if (hoverslot != null)
/* 405 */       hoveritem = hoverslot.b(); 
/* 406 */     return hoveritem;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkCreativeInv() {
/* 411 */     if (this instanceof sr && NEIConfig.invCreativeMode()) {
/*     */       
/* 413 */       if (CoreUtils.isClient()) {
/*     */         
/* 415 */         NEIPacketHandler.sendOpenCreativeInv();
/* 416 */         this.p.a(null);
/*     */       }
/*     */       else {
/*     */         
/* 420 */         this.p.a((vp)new GuiExtendedCreativeInv(new ContainerCreativeInv((yw)this.p.h)));
/*     */       } 
/* 422 */       return true;
/*     */     } 
/* 424 */     if (this instanceof GuiExtendedCreativeInv && !NEIConfig.invCreativeMode()) {
/*     */       
/* 426 */       this.p.a((vp)new sr((yw)this.p.h));
/* 427 */       return true;
/*     */     } 
/* 429 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Minecraft mc() {
/* 434 */     return this.p;
/*     */   }
/*     */ 
/*     */   
/*     */   public nl fontRenderer() {
/* 439 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(int i, int j, int k, int l, int i1, int j1) {
/* 444 */     super.a(i, j, k, l, i1, j1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setZLevel(int i) {
/* 449 */     this.g = i;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */