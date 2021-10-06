/*    */ public class vx
/*    */ {
/*  3 */   public static final vx[] a = new vx[16];
/*  4 */   public static final vx b = (new vx(0, "default", 1)).f();
/*  5 */   public static final vx c = new vx(1, "flat");
/*  6 */   public static final vx d = (new vx(8, "default_1_1", 0)).a(false);
/*    */   private final String e;
/*    */   private final int f;
/*    */   private boolean g;
/*    */   private boolean h;
/*    */   
/*    */   public vx(int var1, String var2) {
/* 13 */     this(var1, var2, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   private vx(int var1, String var2, int var3) {
/* 18 */     this.e = var2;
/* 19 */     this.f = var3;
/* 20 */     this.g = true;
/* 21 */     a[var1] = this;
/*    */   }
/*    */   
/*    */   public String a() {
/* 25 */     return this.e;
/*    */   }
/*    */   
/*    */   public String b() {
/* 29 */     return "generator." + this.e;
/*    */   }
/*    */   
/*    */   public int c() {
/* 33 */     return this.f;
/*    */   }
/*    */   
/*    */   public vx a(int var1) {
/* 37 */     return (this == b && var1 == 0) ? d : this;
/*    */   }
/*    */   
/*    */   private vx a(boolean var1) {
/* 41 */     this.g = var1;
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public boolean d() {
/* 46 */     return this.g;
/*    */   }
/*    */   
/*    */   private vx f() {
/* 50 */     this.h = true;
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public boolean e() {
/* 55 */     return this.h;
/*    */   }
/*    */   
/*    */   public static vx a(String var0) {
/* 59 */     for (int var1 = 0; var1 < a.length; var1++) {
/* 60 */       if (a[var1] != null && (a[var1]).e.equalsIgnoreCase(var0)) {
/* 61 */         return a[var1];
/*    */       }
/*    */     } 
/*    */     
/* 65 */     return null;
/*    */   }
/*    */   
/*    */   public rs getChunkManager(xd world) {
/* 69 */     if (this == c) {
/* 70 */       return (rs)new fm(abn.c, 0.5F, 0.5F);
/*    */     }
/* 72 */     return new rs(world);
/*    */   }
/*    */ 
/*    */   
/*    */   public ca getChunkGenerator(xd world) {
/* 77 */     if (this == c) {
/* 78 */       return (ca)new yh(world, world.v(), world.B().r());
/*    */     }
/* 80 */     return (ca)new aly(world, world.v(), world.B().r());
/*    */   }
/*    */   
/*    */   public int getSeaLevel(xd world) {
/* 84 */     if (this == c)
/* 85 */       return 4; 
/* 86 */     return 64;
/*    */   }
/*    */   
/*    */   public boolean hasVoidParticles(boolean var0) {
/* 90 */     return (this != c && !var0);
/*    */   }
/*    */   
/*    */   public double voidFadeMagnitude() {
/* 94 */     return (this == c) ? 1.0D : 0.03125D;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\vx.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */