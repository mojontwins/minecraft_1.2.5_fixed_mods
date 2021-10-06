/*     */ public abstract class alb
/*     */ {
/*     */   public xd a;
/*     */   public vx b;
/*     */   public rs c;
/*     */   public boolean d = false;
/*     */   public boolean e = false;
/*   8 */   public float[] f = new float[16];
/*   9 */   public int g = 0;
/*  10 */   private float[] h = new float[4];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(xd var1) {
/*  17 */     this.a = var1;
/*  18 */     this.b = var1.B().t();
/*  19 */     a();
/*  20 */     i();
/*     */   }
/*     */   
/*     */   protected void i() {
/*  24 */     float var1 = 0.0F;
/*     */     
/*  26 */     for (int var2 = 0; var2 <= 15; var2++) {
/*  27 */       float var3 = 1.0F - var2 / 15.0F;
/*  28 */       this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a() {
/*  34 */     this.c = this.b.getChunkManager(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public ca b() {
/*  39 */     return this.b.getChunkGenerator(this.a);
/*     */   }
/*     */   
/*     */   public boolean a(int var1, int var2) {
/*  43 */     int var3 = this.a.b(var1, var2);
/*  44 */     return (var3 == pb.u.bO);
/*     */   }
/*     */   
/*     */   public float a(long var1, float var3) {
/*  48 */     int var4 = (int)(var1 % 24000L);
/*  49 */     float var5 = (var4 + var3) / 24000.0F - 0.25F;
/*  50 */     if (var5 < 0.0F) {
/*  51 */       var5++;
/*     */     }
/*     */     
/*  54 */     if (var5 > 1.0F) {
/*  55 */       var5--;
/*     */     }
/*     */     
/*  58 */     float var6 = var5;
/*  59 */     var5 = 1.0F - (float)((Math.cos(var5 * Math.PI) + 1.0D) / 2.0D);
/*  60 */     var5 = var6 + (var5 - var6) / 3.0F;
/*  61 */     return var5;
/*     */   }
/*     */   
/*     */   public int b(long var1, float var3) {
/*  65 */     return (int)(var1 / 24000L) % 8;
/*     */   }
/*     */   
/*     */   public boolean e() {
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public float[] a(float var1, float var2) {
/*  73 */     float var3 = 0.4F;
/*  74 */     float var4 = gk.b(var1 * 3.1415927F * 2.0F) - 0.0F;
/*  75 */     float var5 = -0.0F;
/*  76 */     if (var4 >= var5 - var3 && var4 <= var5 + var3) {
/*  77 */       float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
/*  78 */       float var7 = 1.0F - (1.0F - gk.a(var6 * 3.1415927F)) * 0.99F;
/*  79 */       var7 *= var7;
/*  80 */       this.h[0] = var6 * 0.3F + 0.7F;
/*  81 */       this.h[1] = var6 * var6 * 0.7F + 0.2F;
/*  82 */       this.h[2] = var6 * var6 * 0.0F + 0.2F;
/*  83 */       this.h[3] = var7;
/*  84 */       return this.h;
/*     */     } 
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public bo b(float var1, float var2) {
/*  91 */     float var3 = gk.b(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/*  92 */     if (var3 < 0.0F) {
/*  93 */       var3 = 0.0F;
/*     */     }
/*     */     
/*  96 */     if (var3 > 1.0F) {
/*  97 */       var3 = 1.0F;
/*     */     }
/*     */     
/* 100 */     float var4 = 0.7529412F;
/* 101 */     float var5 = 0.84705883F;
/* 102 */     float var6 = 1.0F;
/* 103 */     var4 *= var3 * 0.94F + 0.06F;
/* 104 */     var5 *= var3 * 0.94F + 0.06F;
/* 105 */     var6 *= var3 * 0.91F + 0.09F;
/* 106 */     return bo.b(var4, var5, var6);
/*     */   }
/*     */   
/*     */   public boolean d() {
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   public static alb a(int var0) {
/* 114 */     return (var0 == -1) ? (alb)new akf() : ((var0 == 0) ? (alb)new ms() : ((var0 == 1) ? (alb)new ii() : null));
/*     */   }
/*     */   
/*     */   public float f() {
/* 118 */     return 128.0F;
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public uh g() {
/* 126 */     return null;
/*     */   }
/*     */   
/*     */   public int h() {
/* 130 */     return this.b.getSeaLevel(this.a);
/*     */   }
/*     */   
/*     */   public boolean j() {
/* 134 */     return this.b.hasVoidParticles(this.e);
/*     */   }
/*     */   
/*     */   public double k() {
/* 138 */     return this.b.voidFadeMagnitude();
/*     */   }
/*     */   
/*     */   public boolean b(int var1, int var2) {
/* 142 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\alb.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */