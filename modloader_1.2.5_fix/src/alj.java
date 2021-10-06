/*     */ import java.util.Random;
/*     */ 
/*     */ public class alj
/*     */   extends agy {
/*   5 */   private Random a = new Random();
/*     */   
/*     */   protected alj(int var1) {
/*   8 */     super(var1, acn.e);
/*   9 */     this.bN = 45;
/*     */   }
/*     */   
/*     */   public int e() {
/*  13 */     return 4;
/*     */   }
/*     */   
/*     */   public int a(int var1, Random var2, int var3) {
/*  17 */     return pb.P.bO;
/*     */   }
/*     */   
/*     */   public void a(xd var1, int var2, int var3, int var4) {
/*  21 */     super.a(var1, var2, var3, var4);
/*  22 */     h(var1, var2, var3, var4);
/*     */   }
/*     */   
/*     */   private void h(xd var1, int var2, int var3, int var4) {
/*  26 */     if (!var1.F) {
/*  27 */       int var5 = var1.a(var2, var3, var4 - 1);
/*  28 */       int var6 = var1.a(var2, var3, var4 + 1);
/*  29 */       int var7 = var1.a(var2 - 1, var3, var4);
/*  30 */       int var8 = var1.a(var2 + 1, var3, var4);
/*  31 */       byte var9 = 3;
/*  32 */       if (pb.n[var5] && !pb.n[var6]) {
/*  33 */         var9 = 3;
/*     */       }
/*     */       
/*  36 */       if (pb.n[var6] && !pb.n[var5]) {
/*  37 */         var9 = 2;
/*     */       }
/*     */       
/*  40 */       if (pb.n[var7] && !pb.n[var8]) {
/*  41 */         var9 = 5;
/*     */       }
/*     */       
/*  44 */       if (pb.n[var8] && !pb.n[var7]) {
/*  45 */         var9 = 4;
/*     */       }
/*     */       
/*  48 */       var1.f(var2, var3, var4, var9);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int d(ali var1, int var2, int var3, int var4, int var5) {
/*  53 */     if (var5 == 1)
/*  54 */       return this.bN + 17; 
/*  55 */     if (var5 == 0) {
/*  56 */       return this.bN + 17;
/*     */     }
/*  58 */     int var6 = var1.e(var2, var3, var4);
/*  59 */     return (var5 != var6) ? this.bN : (this.bN + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int a_(int var1) {
/*  64 */     return (var1 == 1) ? (this.bN + 17) : ((var1 == 0) ? (this.bN + 17) : ((var1 == 3) ? (this.bN + 1) : this.bN));
/*     */   }
/*     */   
/*     */   public boolean b(xd var1, int var2, int var3, int var4, yw var5) {
/*  68 */     if (var1.F) {
/*  69 */       return true;
/*     */     }
/*  71 */     az var6 = (az)var1.b(var2, var3, var4);
/*  72 */     if (var6 != null) {
/*  73 */       var5.a(var6);
/*     */     }
/*     */     
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(xd var1, int var2, int var3, int var4, Random var5) {
/*  81 */     int var6 = var1.e(var2, var3, var4);
/*  82 */     byte var9 = 0;
/*  83 */     byte var10 = 0;
/*  84 */     if (var6 == 3) {
/*  85 */       var10 = 1;
/*  86 */     } else if (var6 == 2) {
/*  87 */       var10 = -1;
/*  88 */     } else if (var6 == 5) {
/*  89 */       var9 = 1;
/*     */     } else {
/*  91 */       var9 = -1;
/*     */     } 
/*     */     
/*  94 */     az var11 = (az)var1.b(var2, var3, var4);
/*  95 */     if (var11 != null) {
/*  96 */       aan var12 = var11.m_();
/*  97 */       double var13 = var2 + var9 * 0.6D + 0.5D;
/*  98 */       double var15 = var3 + 0.5D;
/*  99 */       double var17 = var4 + var10 * 0.6D + 0.5D;
/* 100 */       if (var12 == null) {
/* 101 */         var1.g(1001, var2, var3, var4, 0);
/*     */       } else {
/* 103 */         boolean handled = ModLoader.dispenseEntity(var1, var13, var15, var17, var9, var10, var12);
/* 104 */         if (!handled) {
/* 105 */           if (var12.c == yr.l.bQ) {
/* 106 */             nm var19 = new nm(var1, var13, var15, var17);
/* 107 */             var19.a(var9, 0.10000000149011612D, var10, 1.1F, 6.0F);
/* 108 */             var19.a = true;
/* 109 */             var1.a((nn)var19);
/* 110 */             var1.g(1002, var2, var3, var4, 0);
/* 111 */           } else if (var12.c == yr.aP.bQ) {
/* 112 */             qe var22 = new qe(var1, var13, var15, var17);
/* 113 */             var22.a(var9, 0.10000000149011612D, var10, 1.1F, 6.0F);
/* 114 */             var1.a((nn)var22);
/* 115 */             var1.g(1002, var2, var3, var4, 0);
/* 116 */           } else if (var12.c == yr.aD.bQ) {
/* 117 */             uq var26 = new uq(var1, var13, var15, var17);
/* 118 */             var26.a(var9, 0.10000000149011612D, var10, 1.1F, 6.0F);
/* 119 */             var1.a((nn)var26);
/* 120 */             var1.g(1002, var2, var3, var4, 0);
/* 121 */           } else if (var12.c == yr.bs.bQ && ei.c(var12.i())) {
/* 122 */             bj var27 = new bj(var1, var13, var15, var17, var12.i());
/* 123 */             var27.a(var9, 0.10000000149011612D, var10, 1.375F, 3.0F);
/* 124 */             var1.a((nn)var27);
/* 125 */             var1.g(1002, var2, var3, var4, 0);
/* 126 */           } else if (var12.c == yr.bD.bQ) {
/* 127 */             hf var25 = new hf(var1, var13, var15, var17);
/* 128 */             var25.a(var9, 0.10000000149011612D, var10, 1.375F, 3.0F);
/* 129 */             var1.a((nn)var25);
/* 130 */             var1.g(1002, var2, var3, var4, 0);
/* 131 */           } else if (var12.c == yr.bC.bQ) {
/* 132 */             acv.a(var1, var12.i(), var13 + var9 * 0.3D, var15 - 0.3D, var17 + var10 * 0.3D);
/* 133 */             var1.g(1002, var2, var3, var4, 0);
/* 134 */           } else if (var12.c == yr.bE.bQ) {
/* 135 */             qb var24 = new qb(var1, var13 + var9 * 0.3D, var15, var17 + var10 * 0.3D, var9 + var5.nextGaussian() * 0.05D, 
/* 136 */                 var5.nextGaussian() * 0.05D, var10 + var5.nextGaussian() * 0.05D);
/* 137 */             var1.a((nn)var24);
/* 138 */             var1.g(1009, var2, var3, var4, 0);
/*     */           } else {
/* 140 */             fq var23 = new fq(var1, var13, var15 - 0.3D, var17, var12);
/* 141 */             double var20 = var5.nextDouble() * 0.1D + 0.2D;
/* 142 */             var23.r = var9 * var20;
/* 143 */             var23.s = 0.20000000298023224D;
/* 144 */             var23.t = var10 * var20;
/* 145 */             var23.r += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
/* 146 */             var23.s += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
/* 147 */             var23.t += var5.nextGaussian() * 0.007499999832361937D * 6.0D;
/* 148 */             var1.a(var23);
/* 149 */             var1.g(1000, var2, var3, var4, 0);
/*     */           } 
/*     */         }
/*     */         
/* 153 */         var1.g(2000, var2, var3, var4, var9 + 1 + (var10 + 1) * 3);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(xd var1, int var2, int var3, int var4, int var5) {
/* 160 */     if (var5 > 0 && pb.m[var5].g()) {
/* 161 */       boolean var6 = !(!var1.x(var2, var3, var4) && !var1.x(var2, var3 + 1, var4));
/* 162 */       if (var6) {
/* 163 */         var1.a(var2, var3, var4, this.bO, e());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(xd var1, int var2, int var3, int var4, Random var5) {
/* 170 */     if (!var1.F && (var1.x(var2, var3, var4) || var1.x(var2, var3 + 1, var4))) {
/* 171 */       c(var1, var2, var3, var4, var5);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public kw u_() {
/* 177 */     return (kw)new az();
/*     */   }
/*     */   
/*     */   public void a(xd var1, int var2, int var3, int var4, acq var5) {
/* 181 */     int var6 = gk.c((var5.u * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 182 */     if (var6 == 0) {
/* 183 */       var1.f(var2, var3, var4, 2);
/*     */     }
/*     */     
/* 186 */     if (var6 == 1) {
/* 187 */       var1.f(var2, var3, var4, 5);
/*     */     }
/*     */     
/* 190 */     if (var6 == 2) {
/* 191 */       var1.f(var2, var3, var4, 3);
/*     */     }
/*     */     
/* 194 */     if (var6 == 3) {
/* 195 */       var1.f(var2, var3, var4, 4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void b_(xd var1, int var2, int var3, int var4) {
/* 201 */     az var5 = (az)var1.b(var2, var3, var4);
/* 202 */     if (var5 != null) {
/* 203 */       for (int var6 = 0; var6 < var5.a(); var6++) {
/* 204 */         aan var7 = var5.k_(var6);
/* 205 */         if (var7 != null) {
/* 206 */           float var8 = this.a.nextFloat() * 0.8F + 0.1F;
/* 207 */           float var9 = this.a.nextFloat() * 0.8F + 0.1F;
/* 208 */           float var10 = this.a.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 210 */           while (var7.a > 0) {
/* 211 */             int var11 = this.a.nextInt(21) + 10;
/* 212 */             if (var11 > var7.a) {
/* 213 */               var11 = var7.a;
/*     */             }
/*     */             
/* 216 */             var7.a -= var11;
/* 217 */             fq var12 = new fq(var1, (var2 + var8), (var3 + var9), (var4 + var10), new aan(var7.c, var11, 
/* 218 */                   var7.i()));
/* 219 */             if (var7.n()) {
/* 220 */               var12.a.d((ady)var7.o().b());
/*     */             }
/*     */             
/* 223 */             float var13 = 0.05F;
/* 224 */             var12.r = ((float)this.a.nextGaussian() * var13);
/* 225 */             var12.s = ((float)this.a.nextGaussian() * var13 + 0.2F);
/* 226 */             var12.t = ((float)this.a.nextGaussian() * var13);
/* 227 */             var1.a(var12);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 233 */     super.b_(var1, var2, var3, var4);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\alj.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */