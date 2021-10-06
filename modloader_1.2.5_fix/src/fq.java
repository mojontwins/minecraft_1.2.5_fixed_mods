/*     */ public class fq
/*     */   extends nn
/*     */ {
/*     */   public aan a;
/*   5 */   public int b = 0;
/*     */   public int c;
/*   7 */   private int e = 5;
/*     */   
/*   9 */   public float d = (float)(Math.random() * Math.PI * 2.0D);
/*     */   
/*     */   public fq(xd paramxd, double paramDouble1, double paramDouble2, double paramDouble3, aan paramaan) {
/*  12 */     super(paramxd);
/*  13 */     a(0.25F, 0.25F);
/*  14 */     this.H = this.J / 2.0F;
/*  15 */     d(paramDouble1, paramDouble2, paramDouble3);
/*  16 */     this.a = paramaan;
/*     */     
/*  18 */     this.u = (float)(Math.random() * 360.0D);
/*     */     
/*  20 */     this.r = (float)(Math.random() * 0.2000000029802322D - 0.1000000014901161D);
/*  21 */     this.s = 0.2000000029802322D;
/*  22 */     this.t = (float)(Math.random() * 0.2000000029802322D - 0.1000000014901161D);
/*     */   }
/*     */   
/*     */   protected boolean e_() {
/*  26 */     return false;
/*     */   }
/*     */   
/*     */   public fq(xd paramxd) {
/*  30 */     super(paramxd);
/*  31 */     a(0.25F, 0.25F);
/*  32 */     this.H = this.J / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void b() {}
/*     */   
/*     */   public void J_() {
/*  39 */     super.J_();
/*  40 */     if (this.c > 0)
/*  41 */       this.c--; 
/*  42 */     this.l = this.o;
/*  43 */     this.m = this.p;
/*  44 */     this.n = this.q;
/*     */     
/*  46 */     this.s -= 0.03999999910593033D;
/*  47 */     if (this.k.f(gk.c(this.o), gk.c(this.p), gk.c(this.q)) == acn.h) {
/*  48 */       this.s = 0.2000000029802322D;
/*  49 */       this.r = ((this.U.nextFloat() - this.U.nextFloat()) * 0.2F);
/*  50 */       this.t = ((this.U.nextFloat() - this.U.nextFloat()) * 0.2F);
/*  51 */       this.k.a(this, "random.fizz", 0.4F, 2.0F + this.U.nextFloat() * 0.4F);
/*     */     } 
/*  53 */     h(this.o, (this.y.b + this.y.e) / 2.0D, this.q);
/*  54 */     b(this.r, this.s, this.t);
/*     */     
/*  56 */     float f = 0.98F;
/*  57 */     if (this.z) {
/*  58 */       f = 0.5880001F;
/*  59 */       int i = this.k.a(gk.c(this.o), gk.c(this.y.b) - 1, gk.c(this.q));
/*  60 */       if (i > 0) {
/*  61 */         f = (pb.m[i]).ce * 0.98F;
/*     */       }
/*     */     } 
/*     */     
/*  65 */     this.r *= f;
/*  66 */     this.s *= 0.9800000190734863D;
/*  67 */     this.t *= f;
/*     */     
/*  69 */     if (this.z) {
/*  70 */       this.s *= -0.5D;
/*     */     }
/*     */     
/*  73 */     this.b++;
/*  74 */     if (this.b >= 6000)
/*  75 */       A(); 
/*     */   }
/*     */   
/*     */   public boolean g_() {
/*  79 */     return this.k.a(this.y, acn.g, this);
/*     */   }
/*     */   
/*     */   protected void a(int paramInt) {
/*  83 */     a(md.b, paramInt);
/*     */   }
/*     */   
/*     */   public boolean a(md parammd, int paramInt) {
/*  87 */     K();
/*  88 */     this.e -= paramInt;
/*  89 */     if (this.e <= 0) {
/*  90 */       A();
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public void b(ady paramady) {
/*  96 */     paramady.a("Health", (short)(byte)this.e);
/*  97 */     paramady.a("Age", (short)this.b);
/*  98 */     paramady.a("Item", this.a.b(new ady()));
/*     */   }
/*     */   
/*     */   public void a(ady paramady) {
/* 102 */     this.e = paramady.e("Health") & 0xFF;
/* 103 */     this.b = paramady.e("Age");
/* 104 */     ady localady = paramady.m("Item");
/* 105 */     this.a = aan.a(localady);
/* 106 */     if (this.a == null)
/* 107 */       A(); 
/*     */   }
/*     */   
/*     */   public void a(yw paramyw) {
/* 111 */     if (this.k.F) {
/*     */       return;
/*     */     }
/* 114 */     int i = this.a.a;
/* 115 */     if (this.c == 0 && paramyw.ap.a(this.a)) {
/* 116 */       if (this.a.c == pb.J.bO)
/* 117 */         paramyw.a((ajw)dp.g); 
/* 118 */       if (this.a.c == yr.aF.bQ)
/* 119 */         paramyw.a((ajw)dp.t); 
/* 120 */       if (this.a.c == yr.n.bQ)
/* 121 */         paramyw.a((ajw)dp.w); 
/* 122 */       if (this.a.c == yr.bo.bQ) {
/* 123 */         paramyw.a((ajw)dp.z);
/*     */       }
/* 125 */       ModLoader.onItemPickup(paramyw, this.a);
/*     */       
/* 127 */       this.k.a(this, "random.pop", 0.2F, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 128 */       paramyw.b(this, i);
/*     */       
/* 130 */       if (this.a.a <= 0)
/* 131 */         A(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean k_() {
/* 136 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\fq.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */