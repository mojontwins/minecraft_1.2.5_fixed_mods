/*     */ public class ahg extends kw implements io {
/*   2 */   private aan[] d = new aan[3];
/*   3 */   public int a = 0;
/*   4 */   public int b = 0;
/*   5 */   public int c = 0;
/*     */   
/*     */   public int a() {
/*   8 */     return this.d.length;
/*     */   }
/*     */   
/*     */   public aan k_(int paramInt) {
/*  12 */     return this.d[paramInt];
/*     */   }
/*     */   
/*     */   public aan a(int paramInt1, int paramInt2) {
/*  16 */     if (this.d[paramInt1] != null) {
/*  17 */       if ((this.d[paramInt1]).a <= paramInt2) {
/*  18 */         aan aan1 = this.d[paramInt1];
/*  19 */         this.d[paramInt1] = null;
/*  20 */         return aan1;
/*     */       } 
/*  22 */       aan localaan = this.d[paramInt1].a(paramInt2);
/*  23 */       if ((this.d[paramInt1]).a == 0)
/*  24 */         this.d[paramInt1] = null; 
/*  25 */       return localaan;
/*     */     } 
/*     */     
/*  28 */     return null;
/*     */   }
/*     */   
/*     */   public aan b(int paramInt) {
/*  32 */     if (this.d[paramInt] != null) {
/*  33 */       aan localaan = this.d[paramInt];
/*  34 */       this.d[paramInt] = null;
/*  35 */       return localaan;
/*     */     } 
/*  37 */     return null;
/*     */   }
/*     */   
/*     */   public void a(int paramInt, aan paramaan) {
/*  41 */     this.d[paramInt] = paramaan;
/*  42 */     if (paramaan != null && paramaan.a > d())
/*  43 */       paramaan.a = d(); 
/*     */   }
/*     */   
/*     */   public String c() {
/*  47 */     return "container.furnace";
/*     */   }
/*     */   
/*     */   public void a(ady paramady) {
/*  51 */     super.a(paramady);
/*  52 */     no localno = paramady.n("Items");
/*  53 */     this.d = new aan[a()];
/*  54 */     for (int i = 0; i < localno.d(); i++) {
/*  55 */       ady localady = (ady)localno.a(i);
/*  56 */       int j = localady.d("Slot");
/*  57 */       if (j >= 0 && j < this.d.length)
/*     */       {
/*  59 */         this.d[j] = aan.a(localady);
/*     */       }
/*     */     } 
/*  62 */     this.a = paramady.e("BurnTime");
/*  63 */     this.c = paramady.e("CookTime");
/*  64 */     this.b = a(this.d[1]);
/*     */   }
/*     */   
/*     */   public void b(ady paramady) {
/*  68 */     super.b(paramady);
/*  69 */     paramady.a("BurnTime", (short)this.a);
/*  70 */     paramady.a("CookTime", (short)this.c);
/*  71 */     no localno = new no();
/*     */     
/*  73 */     for (int i = 0; i < this.d.length; i++) {
/*  74 */       if (this.d[i] != null) {
/*  75 */         ady localady = new ady();
/*  76 */         localady.a("Slot", (byte)i);
/*  77 */         this.d[i].b(localady);
/*  78 */         localno.a((gh)localady);
/*     */       } 
/*     */     } 
/*  81 */     paramady.a("Items", (gh)localno);
/*     */   }
/*     */   
/*     */   public int d() {
/*  85 */     return 64;
/*     */   }
/*     */   
/*     */   public int c(int paramInt) {
/*  89 */     return this.c * paramInt / 200;
/*     */   }
/*     */   
/*     */   public int d(int paramInt) {
/*  93 */     if (this.b == 0)
/*  94 */       this.b = 200; 
/*  95 */     return this.a * paramInt / this.b;
/*     */   }
/*     */   
/*     */   public boolean g() {
/*  99 */     return (this.a > 0);
/*     */   }
/*     */   
/*     */   public void n_() {
/* 103 */     int i = (this.a > 0) ? 1 : 0;
/* 104 */     int j = 0;
/* 105 */     if (this.a > 0) {
/* 106 */       this.a--;
/*     */     }
/*     */     
/* 109 */     if (!this.i.F) {
/* 110 */       if (this.a == 0 && o()) {
/* 111 */         this.b = this.a = a(this.d[1]);
/* 112 */         if (this.a > 0) {
/* 113 */           j = 1;
/* 114 */           if (this.d[1] != null) {
/* 115 */             if (this.d[1].a().k()) { this.d[1] = new aan(this.d[1].a().j()); }
/* 116 */             else { (this.d[1]).a--; }
/* 117 */              if ((this.d[1]).a == 0) {
/* 118 */               this.d[1] = null;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 123 */       if (g() && o()) {
/* 124 */         this.c++;
/* 125 */         if (this.c == 200) {
/* 126 */           this.c = 0;
/* 127 */           n();
/* 128 */           j = 1;
/*     */         } 
/*     */       } else {
/* 131 */         this.c = 0;
/*     */       } 
/*     */       
/* 134 */       if (i != ((this.a > 0) ? 1 : 0)) {
/* 135 */         j = 1;
/* 136 */         aho.a((this.a > 0), this.i, this.j, this.k, this.l);
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     if (j != 0)
/* 141 */       j(); 
/*     */   }
/*     */   
/*     */   private boolean o() {
/* 145 */     if (this.d[0] == null)
/* 146 */       return false; 
/* 147 */     aan localaan = dy.a().a((this.d[0].a()).bQ);
/* 148 */     if (localaan == null)
/* 149 */       return false; 
/* 150 */     if (this.d[2] == null)
/* 151 */       return true; 
/* 152 */     if (!this.d[2].a(localaan))
/* 153 */       return false; 
/* 154 */     if ((this.d[2]).a < d() && (this.d[2]).a < this.d[2].c())
/* 155 */       return true; 
/* 156 */     return ((this.d[2]).a < localaan.c());
/*     */   }
/*     */   
/*     */   public void n() {
/* 160 */     if (!o()) {
/*     */       return;
/*     */     }
/* 163 */     aan localaan = dy.a().a((this.d[0].a()).bQ);
/* 164 */     if (this.d[2] == null) { this.d[2] = localaan.k(); }
/* 165 */     else if ((this.d[2]).c == localaan.c)
/* 166 */     { (this.d[2]).a += localaan.a; }
/*     */     
/* 168 */     if (this.d[0].a().k()) { this.d[0] = new aan(this.d[0].a().j()); }
/* 169 */     else { (this.d[0]).a--; }
/* 170 */      if ((this.d[0]).a <= 0)
/* 171 */       this.d[0] = null; 
/*     */   }
/*     */   
/*     */   public static int a(aan paramaan) {
/* 175 */     if (paramaan == null)
/* 176 */       return 0; 
/* 177 */     int i = (paramaan.a()).bQ;
/*     */     
/* 179 */     if (i < 256 && (pb.m[i]).cd == acn.d) {
/* 180 */       return 300;
/*     */     }
/*     */     
/* 183 */     if (i == yr.D.bQ) {
/* 184 */       return 100;
/*     */     }
/*     */     
/* 187 */     if (i == yr.m.bQ) {
/* 188 */       return 1600;
/*     */     }
/* 190 */     if (i == yr.ay.bQ) {
/* 191 */       return 20000;
/*     */     }
/* 193 */     if (i == pb.y.bO) {
/* 194 */       return 100;
/*     */     }
/* 196 */     if (i == yr.bo.bQ) {
/* 197 */       return 2400;
/*     */     }
/* 199 */     return ModLoader.addAllFuel(paramaan.c, paramaan.i());
/*     */   }
/*     */   
/*     */   public static boolean b(aan paramaan) {
/* 203 */     return (a(paramaan) > 0);
/*     */   }
/*     */   
/*     */   public boolean a_(yw paramyw) {
/* 207 */     if (this.i.b(this.j, this.k, this.l) != this)
/* 208 */       return false; 
/* 209 */     return (paramyw.f(this.j + 0.5D, this.k + 0.5D, this.l + 0.5D) <= 64.0D);
/*     */   }
/*     */   
/*     */   public void e() {}
/*     */   
/*     */   public void f() {}
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ahg.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */