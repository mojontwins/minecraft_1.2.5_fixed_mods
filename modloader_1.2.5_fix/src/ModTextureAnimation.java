/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class ModTextureAnimation
/*    */   extends tt
/*    */ {
/*    */   private final int tickRate;
/*    */   private final byte[][] images;
/* 11 */   private int index = 0;
/* 12 */   private int ticks = 0;
/*    */   
/*    */   public ModTextureAnimation(int slot, int dst, BufferedImage source, int rate) {
/* 15 */     this(slot, 1, dst, source, rate);
/*    */   }
/*    */   
/*    */   public ModTextureAnimation(int slot, int size, int dst, BufferedImage source, int rate) {
/* 19 */     super(slot);
/*    */     
/* 21 */     this.j = size;
/* 22 */     this.k = dst;
/* 23 */     this.tickRate = rate;
/* 24 */     this.ticks = rate;
/*    */     
/* 26 */     a((ModLoader.getMinecraftInstance()).p);
/* 27 */     int targetWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096) / 16;
/* 28 */     int targetHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097) / 16;
/*    */     
/* 30 */     int width = source.getWidth();
/* 31 */     int height = source.getHeight();
/* 32 */     int images = (int)Math.floor((height / width));
/* 33 */     if (images <= 0) {
/* 34 */       throw new IllegalArgumentException("source has no complete images");
/*    */     }
/* 36 */     this.images = new byte[images][];
/*    */     
/* 38 */     if (width != targetWidth) {
/* 39 */       BufferedImage img = new BufferedImage(targetWidth, targetHeight * images, 6);
/* 40 */       Graphics2D gfx = img.createGraphics();
/* 41 */       gfx.drawImage(source, 0, 0, targetWidth, targetHeight * images, 0, 0, width, height, null);
/* 42 */       gfx.dispose();
/*    */       
/* 44 */       source = img;
/*    */     } 
/*    */     
/* 47 */     for (int i = 0; i < images; i++) {
/*    */       
/* 49 */       int[] temp = new int[targetWidth * targetHeight];
/*    */       
/* 51 */       source.getRGB(0, targetHeight * i, targetWidth, targetHeight, temp, 0, targetWidth);
/*    */       
/* 53 */       this.images[i] = new byte[targetWidth * targetHeight * 4];
/* 54 */       for (int j = 0; j < temp.length; j++) {
/* 55 */         int a = temp[j] >> 24 & 0xFF;
/* 56 */         int r = temp[j] >> 16 & 0xFF;
/* 57 */         int g = temp[j] >> 8 & 0xFF;
/* 58 */         int b = temp[j] >> 0 & 0xFF;
/*    */         
/* 60 */         this.images[i][j * 4 + 0] = (byte)r;
/* 61 */         this.images[i][j * 4 + 1] = (byte)g;
/* 62 */         this.images[i][j * 4 + 2] = (byte)b;
/* 63 */         this.images[i][j * 4 + 3] = (byte)a;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a() {
/* 70 */     if (this.ticks >= this.tickRate) {
/* 71 */       this.index++;
/* 72 */       if (this.index >= this.images.length)
/* 73 */         this.index = 0; 
/* 74 */       this.f = this.images[this.index];
/* 75 */       this.ticks = 0;
/*    */     } 
/* 77 */     this.ticks++;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ModTextureAnimation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */