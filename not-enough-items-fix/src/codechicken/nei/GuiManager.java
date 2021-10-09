/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import gb;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import nl;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tw;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiManager
/*     */ {
/*     */   public gb window;
/*  17 */   private static tw drawItems = new tw();
/*     */ 
/*     */   
/*     */   public GuiManager(gb screen) {
/*  21 */     this.window = screen;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawIcon(int x, int y, Image image) {
/*  26 */     GL11.glBindTexture(3553, (this.window.mc()).p.b("/codechicken/nei/nei_sprites.png"));
/*  27 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  28 */     GL11.glEnable(3042);
/*  29 */     GL11.glBlendFunc(770, 771);
/*  30 */     this.window.b(x, y, image.x, image.y, image.width, image.height);
/*  31 */     GL11.glDisable(3042);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawRect(int x, int y, int w, int h, int colour) {
/*  36 */     this.window.a(x, y, x + w, y + h, colour, colour);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawGradientRect(int x, int y, int w, int h, int colour1, int colour2) {
/*  41 */     this.window.a(x, y, x + w, y + h, colour1, colour2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int x, int y, int tx, int ty, int w, int h) {
/*  46 */     this.window.b(x, y, tx, ty, w, h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawText(int x, int y, String text, int colour, boolean shadow) {
/*  51 */     if (shadow) {
/*  52 */       this.window.fontRenderer().a(text, x, y, colour);
/*     */     } else {
/*  54 */       this.window.fontRenderer().b(text, x, y, colour);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTextCentered(int x, int y, int w, int h, String text, int colour, boolean shadow) {
/*  59 */     drawText(x + (w - getTextWidth(text)) / 2, y + (h - 8) / 2, text, colour, shadow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTextCentered(String text, int x, int y, int colour, boolean shadow) {
/*  64 */     drawText(x - getTextWidth(text) / 2, y, text, colour, shadow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawText(int x, int y, String text, boolean shadow) {
/*  69 */     drawText(x, y, text, -1, shadow);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawText(int x, int y, String text, int colour) {
/*  74 */     drawText(x, y, text, colour, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTextCentered(int x, int y, int w, int h, String text, int colour) {
/*  79 */     drawText(x + (w - getTextWidth(text)) / 2, y + (h - 8) / 2, text, colour);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTextCentered(String text, int x, int y, int colour) {
/*  84 */     drawText(x - getTextWidth(text) / 2, y, text, colour);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawText(int x, int y, String text) {
/*  89 */     drawText(x, y, text, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTip(int x, int y, String text) {
/*  94 */     ArrayList<String> temp = new ArrayList();
/*  95 */     temp.add(text);
/*  96 */     drawMultilineTip(x, y, temp);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawMultilineTip(int x, int y, List<String> list) {
/* 101 */     if (list.size() > 0) {
/*     */       
/* 103 */       int maxwidth = 0;
/* 104 */       for (int line = 0; line < list.size(); line++) {
/*     */         
/* 106 */         int swidth = getStringWidthNoColours(this.window.fontRenderer(), list.get(line));
/* 107 */         if (swidth > maxwidth)
/*     */         {
/* 109 */           maxwidth = swidth;
/*     */         }
/*     */       } 
/*     */       
/* 113 */       if (x + maxwidth > this.window.q - 16)
/*     */       {
/* 115 */         x = this.window.q - maxwidth - 16;
/*     */       }
/*     */       
/* 118 */       if (y < 16)
/*     */       {
/* 120 */         y = 16;
/*     */       }
/*     */       
/* 123 */       int drawx = x - this.window.e + 12;
/* 124 */       int drawy = y - this.window.f - 12;
/*     */       
/* 126 */       int w = maxwidth;
/* 127 */       int h = 8;
/* 128 */       if (list.size() > 1)
/*     */       {
/* 130 */         h += 2 + (list.size() - 1) * 10;
/*     */       }
/* 132 */       this.window.setZLevel(300);
/* 133 */       gb.a.b = 300.0F;
/* 134 */       int i4 = -267386864;
/* 135 */       drawGradientRect(drawx - 3, drawy - 4, w + 6, 1, i4, i4);
/* 136 */       drawGradientRect(drawx - 3, drawy + h + 3, w + 6, 1, i4, i4);
/* 137 */       drawGradientRect(drawx - 3, drawy - 3, w + 6, h + 6, i4, i4);
/* 138 */       drawGradientRect(drawx - 4, drawy - 3, 1, h + 6, i4, i4);
/* 139 */       drawGradientRect(drawx + w + 3, drawy - 3, 1, h + 6, i4, i4);
/* 140 */       int colour1 = 1347420415;
/* 141 */       int colour2 = (colour1 & 0xFEFEFE) >> 1 | colour1 & 0xFF000000;
/* 142 */       drawGradientRect(drawx - 3, drawy - 2, 1, h + 4, colour1, colour2);
/* 143 */       drawGradientRect(drawx + w + 2, drawy - 2, 1, h + 4, colour1, colour2);
/* 144 */       drawGradientRect(drawx - 3, drawy - 3, w + 6, 1, colour1, colour1);
/* 145 */       drawGradientRect(drawx - 3, drawy + h + 2, w + 6, 1, colour2, colour2);
/* 146 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 148 */         String s = list.get(i);
/* 149 */         this.window.fontRenderer().a(s, drawx, drawy, -1);
/* 150 */         if (i == 0)
/*     */         {
/* 152 */           drawy += 2;
/*     */         }
/* 154 */         drawy += 10;
/*     */       } 
/*     */       
/* 157 */       this.window.setZLevel(0);
/* 158 */       gb.a.b = 0.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawItem(int i, int j, aan itemstack) {
/*     */     try {
/* 166 */       enable3DRender();
/* 167 */       drawItems.b = 100.0F;
/* 168 */       drawItems.a(this.window.fontRenderer(), (this.window.mc()).p, itemstack, i, j);
/* 169 */       drawItems.b(this.window.fontRenderer(), (this.window.mc()).p, itemstack, i, j);
/* 170 */       drawItems.b = 0.0F;
/* 171 */       enable2DRender();
/*     */     }
/* 173 */     catch (RuntimeException runtimeexception) {
/*     */       
/* 175 */       drawItems.a(this.window.fontRenderer(), (this.window.mc()).p, new aan(51, 1, 0), i, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColouredItemRender(boolean enable) {
/* 181 */     drawItems.a = !enable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void enable3DRender() {
/* 186 */     GL11.glEnable(2896);
/* 187 */     GL11.glEnable(2929);
/*     */   }
/*     */ 
/*     */   
/*     */   public void enable2DRender() {
/* 192 */     GL11.glDisable(2896);
/* 193 */     GL11.glDisable(2929);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTextWidth(String s) {
/* 198 */     if (s == null || s.equals(""))
/*     */     {
/* 200 */       return 0;
/*     */     }
/*     */     
/* 203 */     return getStringWidthNoColours(this.window.fontRenderer(), s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButtonBackground(int x, int y, int w, int h, boolean edges, int type) {
/* 209 */     int wtiles = 0;
/* 210 */     int ew = w;
/* 211 */     if (w / 2 > 100) {
/*     */       
/* 213 */       wtiles = (w - 200) / 50 + 1;
/* 214 */       ew = 200;
/*     */     } 
/*     */     
/* 217 */     int w1 = ew / 2;
/* 218 */     int h1 = h / 2;
/* 219 */     int w2 = (ew + 1) / 2;
/* 220 */     int h2 = (h + 1) / 2;
/*     */     
/* 222 */     int x2 = x + w - w2;
/* 223 */     int y2 = y + h - h2;
/*     */     
/* 225 */     int ty = 46 + type * 20;
/* 226 */     int te = edges ? 0 : 1;
/*     */     
/* 228 */     int ty1 = ty + te;
/* 229 */     int tx1 = te;
/* 230 */     int tx3 = 75;
/*     */     
/* 232 */     int ty2 = ty + 20 - h2 - te;
/* 233 */     int tx2 = 200 - w2 - te;
/*     */     
/* 235 */     GL11.glBindTexture(3553, (this.window.mc()).p.b("/gui/gui.png"));
/* 236 */     drawTexturedModalRect(x, y, tx1, ty1, w1, h1);
/* 237 */     drawTexturedModalRect(x, y2, tx1, ty2, w1, h2);
/*     */     
/* 239 */     for (int tile = 0; tile < wtiles; tile++) {
/*     */       
/* 241 */       int tilex = x + w1 + 50 * tile;
/* 242 */       drawTexturedModalRect(tilex, y, tx3, ty1, 50, h1);
/* 243 */       drawTexturedModalRect(tilex, y2, tx3, ty2, 50, h2);
/*     */     } 
/*     */     
/* 246 */     drawTexturedModalRect(x2, y, tx2, ty1, w2, h1);
/* 247 */     drawTexturedModalRect(x2, y2, tx2, ty2, w2, h2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTexture(String s) {
/* 252 */     return (this.window.mc()).p.b(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bindTexture(int texture) {
/* 257 */     (this.window.mc()).p.b(texture);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bindTextureByName(String s) {
/* 262 */     bindTexture(getTexture(s));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getStringWidthNoColours(nl fontRenderer, String s) {
/*     */     while (true) {
/* 269 */       int pos = s.indexOf('§');
/* 270 */       if (pos == -1)
/*     */         break; 
/* 272 */       s = String.valueOf(s.substring(0, pos)) + s.substring(pos + 2);
/*     */     } 
/* 274 */     return fontRenderer.a(s);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */