/*     */ package codechicken.nei;
/*     */ 
/*     */ import aak;
/*     */ import aan;
/*     */ import gm;
/*     */ import io;
/*     */ import java.util.ArrayList;
/*     */ import jt;
/*     */ import oo;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import xd;
/*     */ import yr;
/*     */ import yw;
/*     */ 
/*     */ public class ContainerEnchantmentModifier extends gm {
/*     */   public static class EnchantmentHash {
/*     */     jt enchantment;
/*     */     int state;
/*     */     int level;
/*     */     
/*     */     public EnchantmentHash(jt e, int i, int l) {
/*  22 */       this.enchantment = e;
/*  23 */       this.state = i;
/*  24 */       this.level = l;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public ArrayList slotEnchantment = new ArrayList();
/*  33 */   int level = 5;
/*     */   
/*  35 */   public int scrollclicky = -1;
/*     */   public float scrollpercent;
/*     */   public int scrollmousey;
/*     */   public float percentscrolled;
/*  39 */   public int relx = 60;
/*  40 */   public int rely = 14;
/*  41 */   public int height = 57;
/*  42 */   public int cwidth = 101;
/*  43 */   public int slotheight = 19;
/*     */   
/*     */   public GuiEnchantmentModifier parentscreen;
/*     */   
/*     */   public ContainerEnchantmentModifier(aak inventoryplayer, xd world, int i, int j, int k) {
/*  48 */     super(inventoryplayer, world, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumSlots() {
/*  53 */     return this.slotEnchantment.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScrollBarHeight() {
/*  58 */     int sbarh = (int)(this.height / getContentHeight() * this.height);
/*  59 */     if (sbarh > this.height)
/*     */     {
/*  61 */       return this.height;
/*     */     }
/*  63 */     if (sbarh < this.height / 15)
/*     */     {
/*  65 */       return this.height / 15;
/*     */     }
/*     */ 
/*     */     
/*  69 */     return sbarh;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScrollBarWidth() {
/*  75 */     return 7;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getContentHeight() {
/*  80 */     return this.slotheight * getNumSlots();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScrolledSlots() {
/*  85 */     int slots = getNumSlots();
/*  86 */     int shownslots = this.height / this.slotheight;
/*  87 */     return (int)(this.percentscrolled * (slots - shownslots) + 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   private int getClickedSlot(int mousey) {
/*  92 */     return (mousey - this.rely) / this.slotheight + getScrolledSlots();
/*     */   }
/*     */ 
/*     */   
/*     */   public void calculatePercentScrolled() {
/*  97 */     int barempty = this.height - getScrollBarHeight();
/*  98 */     if (this.scrollclicky >= 0) {
/*     */       
/* 100 */       int scrolldiff = this.scrollmousey - this.scrollclicky;
/* 101 */       this.percentscrolled = scrolldiff / barempty + this.scrollpercent;
/*     */     } 
/* 103 */     if (this.percentscrolled < 0.0F)
/*     */     {
/* 105 */       this.percentscrolled = 0.0F;
/*     */     }
/* 107 */     if (this.percentscrolled > 1.0F)
/*     */     {
/* 109 */       this.percentscrolled = 1.0F;
/*     */     }
/* 111 */     int sbary = this.rely + (int)((barempty * this.percentscrolled) + 0.5D);
/* 112 */     this.percentscrolled = (sbary - this.rely) / barempty;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean clickScrollBar(int mousex, int mousey, int button) {
/* 117 */     mousex -= this.parentscreen.e;
/* 118 */     mousey -= this.parentscreen.f;
/*     */     
/* 120 */     int barempty = this.height - getScrollBarHeight();
/* 121 */     int sbary = this.rely + (int)((barempty * this.percentscrolled) + 0.5D);
/*     */     
/* 123 */     if (button == 0 && 
/* 124 */       getScrollBarHeight() < this.height && 
/* 125 */       mousex >= this.relx + this.cwidth && mousex < this.relx + this.cwidth + getScrollBarWidth() && 
/* 126 */       mousey >= this.rely && mousey < this.rely + this.height) {
/*     */       
/* 128 */       if (mousey < sbary) {
/*     */         
/* 130 */         this.percentscrolled = (mousey - this.rely) / barempty;
/* 131 */         calculatePercentScrolled();
/*     */       }
/* 133 */       else if (mousey > sbary + getScrollBarHeight()) {
/*     */         
/* 135 */         this.percentscrolled = (mousey - this.rely - getScrollBarHeight() + 1) / barempty;
/* 136 */         calculatePercentScrolled();
/*     */       }
/*     */       else {
/*     */         
/* 140 */         this.scrollclicky = mousey;
/* 141 */         this.scrollpercent = this.percentscrolled;
/* 142 */         this.scrollmousey = mousey;
/*     */       } 
/* 144 */       return true;
/*     */     } 
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseUp(int mousex, int mousey, int button) {
/* 151 */     if (this.scrollclicky >= 0 && button == 0)
/*     */     {
/* 153 */       this.scrollclicky = -1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean clickButton(int mousex, int mousey, int button) {
/* 159 */     mousex -= this.parentscreen.e;
/* 160 */     mousey -= this.parentscreen.f;
/* 161 */     if (mousex >= this.relx && mousex < this.relx + this.cwidth && 
/* 162 */       mousey >= this.rely && mousey <= this.rely + this.height) {
/*     */       
/* 164 */       int slot = getClickedSlot(mousey);
/* 165 */       if (slot >= getNumSlots()) return false; 
/* 166 */       toggleSlotEnchantment(slot);
/* 167 */       return true;
/*     */     } 
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void toggleSlotEnchantment(int slot) {
/* 174 */     EnchantmentHash e = this.slotEnchantment.get(slot);
/* 175 */     if (e.state == 2) {
/*     */       
/* 177 */       if (NEIConfig.isMultiplayer()) {
/*     */         
/* 179 */         NEIPacketHandler.sendModifyEnchantment(e.enchantment.w, 0, false);
/*     */       }
/*     */       else {
/*     */         
/* 183 */         NEIUtils.removeEnchantment(b(0).b(), e.enchantment.w);
/*     */       } 
/* 185 */       e.state = 0;
/*     */     } else {
/* 187 */       if (e.state == 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 193 */       if (NEIConfig.isMultiplayer()) {
/*     */         
/* 195 */         NEIPacketHandler.sendModifyEnchantment(e.enchantment.w, this.level, true);
/*     */       }
/*     */       else {
/*     */         
/* 199 */         NEIUtils.addEnchantment(b(0).b(), e.enchantment.w, this.level);
/*     */       } 
/* 201 */       e.state = 2;
/*     */     } 
/* 203 */     updateEnchantmentOptions();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(yw entityplayer) {
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(io iinventory) {
/* 213 */     updateEnchantmentOptions();
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateEnchantmentOptions() {
/* 218 */     int numoptions = this.slotEnchantment.size();
/* 219 */     this.slotEnchantment.clear();
/*     */     
/* 221 */     aan toolstack = b(0).b();
/* 222 */     if (toolstack == null) {
/*     */       
/* 224 */       this.percentscrolled = 0.0F;
/*     */       return;
/*     */     } 
/* 227 */     yr item = toolstack.a();
/* 228 */     int enchantablity = item.b();
/* 229 */     if (enchantablity == 0) {
/*     */       
/* 231 */       this.percentscrolled = 0.0F; return;
/*     */     }  byte b;
/*     */     int i;
/*     */     jt[] arrayOfJt;
/* 235 */     for (i = (arrayOfJt = jt.a).length, b = 0; b < i; ) { jt e = arrayOfJt[b];
/*     */       
/* 237 */       if (e != null && e.x.a(item)) {
/*     */ 
/*     */ 
/*     */         
/* 241 */         int state = 0;
/* 242 */         int level = -1;
/* 243 */         if (NEIUtils.stackHasEnchantment(toolstack, e.w)) {
/*     */           
/* 245 */           state = 2;
/* 246 */           level = NEIUtils.getEnchantmentLevel(toolstack, e.w);
/*     */         }
/* 248 */         else if (NEIUtils.doesEnchantmentConflict(NEIUtils.getEnchantments(toolstack), e)) {
/*     */           
/* 250 */           state = 1;
/*     */         } 
/* 252 */         this.slotEnchantment.add(new EnchantmentHash(e, state, level));
/*     */       }  b++; }
/* 254 */      if (numoptions != this.slotEnchantment.size())
/*     */     {
/* 256 */       this.percentscrolled = 0.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawSlots(GuiEnchantmentModifier gui) {
/* 262 */     int texe = (gui.mc()).p.b("/gui/enchant.png");
/* 263 */     for (int slot = 0; slot < 3; slot++) {
/*     */       
/* 265 */       int shade = 0;
/* 266 */       String text = "";
/*     */       
/* 268 */       int containerslot = slot + getScrolledSlots();
/* 269 */       if (containerslot + 1 > this.slotEnchantment.size()) {
/*     */         
/* 271 */         shade = 1;
/*     */       }
/*     */       else {
/*     */         
/* 275 */         EnchantmentHash e = this.slotEnchantment.get(containerslot);
/* 276 */         shade = e.state;
/* 277 */         text = e.enchantment.c((e.level == -1) ? this.level : e.level);
/* 278 */         if ((gui.mc()).q.a(text) > 95 && text.contains("Projectile"))
/*     */         {
/* 280 */           text = text.replace("Projectile", "Proj");
/*     */         }
/* 282 */         if ((gui.mc()).q.a(text) > 95 && text.contains("Protection"))
/*     */         {
/* 284 */           text = text.replace("Protection", "Protect");
/*     */         }
/* 286 */         if ((gui.mc()).q.a(text) > 95 && text.contains("Bane of"))
/*     */         {
/* 288 */           text = text.replace("Bane of ", "");
/*     */         }
/*     */       } 
/*     */       
/* 292 */       (gui.mc()).p.b(texe);
/* 293 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 294 */       if (hasScrollBar()) {
/*     */         
/* 296 */         gui.b(this.relx, this.rely + slot * this.slotheight, 0, gui.c + this.slotheight * shade, this.cwidth - 30, this.slotheight);
/* 297 */         gui.b(this.relx + this.cwidth - 30, this.rely + slot * this.slotheight, this.cwidth - 23, gui.c + this.slotheight * shade, 30, this.slotheight);
/*     */       }
/*     */       else {
/*     */         
/* 301 */         gui.b(this.relx, this.rely + slot * this.slotheight, 0, gui.c + this.slotheight * shade, this.cwidth + 7, this.slotheight);
/*     */       } 
/*     */       
/* 304 */       (gui.mc()).q.b(text, this.relx + 4, this.rely + slot * this.slotheight + 5, textColourFromState(shade));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean hasScrollBar() {
/* 310 */     return (getNumSlots() > 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScrollBar(GuiEnchantmentModifier gui) {
/* 315 */     if (!hasScrollBar())
/*     */       return; 
/* 317 */     int sbary = this.rely + (int)(((this.height - getScrollBarHeight()) * this.percentscrolled) + 0.5D);
/* 318 */     int sbarx = this.relx + this.cwidth;
/*     */     
/* 320 */     oo.a(sbarx, this.rely, sbarx + getScrollBarWidth(), this.rely + this.height, -14671840);
/* 321 */     oo.a(sbarx, sbary, sbarx + getScrollBarWidth(), sbary + getScrollBarHeight(), -7631989);
/* 322 */     oo.a(sbarx, sbary, sbarx + getScrollBarWidth() - 1, sbary + getScrollBarHeight() - 1, -986896);
/* 323 */     oo.a(sbarx + 1, sbary + 1, sbarx + getScrollBarWidth() - 1, sbary + getScrollBarHeight() - 1, -11184811);
/* 324 */     oo.a(sbarx + 1, sbary + 1, sbarx + getScrollBarWidth() - 2, sbary + getScrollBarHeight() - 2, -3750202);
/*     */   }
/*     */ 
/*     */   
/*     */   private int textColourFromState(int shade) {
/* 329 */     if (shade == 0)
/*     */     {
/* 331 */       return 6839882;
/*     */     }
/* 333 */     if (shade == 1)
/*     */     {
/* 335 */       return 4226832;
/*     */     }
/*     */ 
/*     */     
/* 339 */     return 16777088;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(int mousex, int mousey) {
/* 345 */     processScrollMouse(mousex, mousey);
/*     */   }
/*     */ 
/*     */   
/*     */   public void processScrollMouse(int mousex, int mousey) {
/* 350 */     mousex -= this.parentscreen.e;
/* 351 */     mousey -= this.parentscreen.f;
/*     */     
/* 353 */     if (this.scrollclicky >= 0) {
/*     */       
/* 355 */       int scrolldiff = mousey - this.scrollclicky;
/* 356 */       int barupallowed = (int)(((this.height - getScrollBarHeight()) * this.scrollpercent) + 0.5D);
/* 357 */       int bardownallowed = this.height - getScrollBarHeight() - barupallowed;
/*     */       
/* 359 */       if (-scrolldiff > barupallowed) {
/*     */         
/* 361 */         this.scrollmousey = this.scrollclicky - barupallowed;
/*     */       }
/* 363 */       else if (scrolldiff > bardownallowed) {
/*     */         
/* 365 */         this.scrollmousey = this.scrollclicky + bardownallowed;
/*     */       }
/*     */       else {
/*     */         
/* 369 */         this.scrollmousey = mousey;
/*     */       } 
/*     */       
/* 372 */       calculatePercentScrolled();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ContainerEnchantmentModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */