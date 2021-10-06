/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModTextureStatic
/*     */   extends tt
/*     */ {
/*     */   private boolean oldanaglyph;
/*  12 */   private int[] pixels = null;
/*     */   
/*     */   public ModTextureStatic(int slot, int dst, BufferedImage source) {
/*  15 */     this(slot, 1, dst, source);
/*     */   }
/*     */   
/*     */   public ModTextureStatic(int slot, int size, int dst, BufferedImage source) {
/*  19 */     super(slot);
/*  20 */     this.j = size;
/*  21 */     this.k = dst;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  30 */     a((ModLoader.getMinecraftInstance()).p);
/*  31 */     int targetWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096) / 16;
/*  32 */     int targetHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097) / 16;
/*     */     
/*  34 */     int width = source.getWidth();
/*  35 */     int height = source.getHeight();
/*  36 */     this.pixels = new int[targetWidth * targetHeight];
/*  37 */     this.f = new byte[targetWidth * targetHeight * 4];
/*     */     
/*  39 */     if (width != height || width != targetWidth) {
/*  40 */       BufferedImage img = new BufferedImage(targetWidth, targetHeight, 6);
/*  41 */       Graphics2D gfx = img.createGraphics();
/*  42 */       gfx.drawImage(source, 0, 0, targetWidth, targetHeight, 0, 0, width, height, null);
/*  43 */       img.getRGB(0, 0, targetWidth, targetHeight, this.pixels, 0, targetWidth);
/*  44 */       gfx.dispose();
/*     */     } else {
/*  46 */       source.getRGB(0, 0, width, height, this.pixels, 0, width);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     update();
/*     */   }
/*     */   
/*     */   public void update() {
/*  63 */     for (int i = 0; i < this.pixels.length; i++) {
/*  64 */       int a = this.pixels[i] >> 24 & 0xFF;
/*  65 */       int r = this.pixels[i] >> 16 & 0xFF;
/*  66 */       int g = this.pixels[i] >> 8 & 0xFF;
/*  67 */       int b = this.pixels[i] >> 0 & 0xFF;
/*     */       
/*  69 */       if (this.h) {
/*  70 */         int grey = (r + g + b) / 3;
/*  71 */         r = g = b = grey;
/*     */       } 
/*     */       
/*  74 */       this.f[i * 4 + 0] = (byte)r;
/*  75 */       this.f[i * 4 + 1] = (byte)g;
/*  76 */       this.f[i * 4 + 2] = (byte)b;
/*  77 */       this.f[i * 4 + 3] = (byte)a;
/*     */     } 
/*     */     
/*  80 */     this.oldanaglyph = this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a() {
/*  85 */     if (this.oldanaglyph != this.h) {
/*  86 */       update();
/*     */     }
/*     */   }
/*     */   
/*     */   public static BufferedImage scale2x(BufferedImage in) {
/*  91 */     int width = in.getWidth();
/*  92 */     int height = in.getHeight();
/*  93 */     BufferedImage out = new BufferedImage(width * 2, height * 2, 2);
/*  94 */     for (int y = 0; y < height; y++) {
/*  95 */       for (int x = 0; x < width; x++) {
/*  96 */         int E0, E1, E2, E3, B, D, F, H, E = in.getRGB(x, y);
/*  97 */         if (y == 0) {
/*  98 */           B = E;
/*     */         } else {
/* 100 */           B = in.getRGB(x, y - 1);
/*     */         } 
/* 102 */         if (x == 0) {
/* 103 */           D = E;
/*     */         } else {
/* 105 */           D = in.getRGB(x - 1, y);
/*     */         } 
/* 107 */         if (x >= width - 1) {
/* 108 */           F = E;
/*     */         } else {
/* 110 */           F = in.getRGB(x + 1, y);
/*     */         } 
/* 112 */         if (y >= height - 1) {
/* 113 */           H = E;
/*     */         } else {
/* 115 */           H = in.getRGB(x, y + 1);
/*     */         } 
/* 117 */         if (B != H && D != F) {
/* 118 */           E0 = (D == B) ? D : E;
/* 119 */           E1 = (B == F) ? F : E;
/* 120 */           E2 = (D == H) ? D : E;
/* 121 */           E3 = (H == F) ? F : E;
/*     */         } else {
/* 123 */           E0 = E;
/* 124 */           E1 = E;
/* 125 */           E2 = E;
/* 126 */           E3 = E;
/*     */         } 
/* 128 */         out.setRGB(x * 2, y * 2, E0);
/* 129 */         out.setRGB(x * 2 + 1, y * 2, E1);
/* 130 */         out.setRGB(x * 2, y * 2 + 1, E2);
/* 131 */         out.setRGB(x * 2 + 1, y * 2 + 1, E3);
/*     */       } 
/*     */     } 
/* 134 */     return out;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ModTextureStatic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */