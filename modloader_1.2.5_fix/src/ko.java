/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class ko
/*     */   implements ca {
/*   9 */   private Set a = new HashSet();
/*     */   private ack b;
/*     */   private ca c;
/*     */   private ua d;
/*  13 */   private en e = new en();
/*  14 */   private List f = new ArrayList();
/*     */   
/*     */   private xd g;
/*     */   private int h;
/*     */   
/*     */   public ko(xd var1, ua var2, ca var3) {
/*  20 */     this.b = (ack)new ace(var1, 0, 0);
/*  21 */     this.g = var1;
/*  22 */     this.d = var2;
/*  23 */     this.c = var3;
/*     */   }
/*     */   
/*     */   public boolean a(int var1, int var2) {
/*  27 */     return this.e.b(sj.a(var1, var2));
/*     */   }
/*     */   
/*     */   public void d(int var1, int var2) {
/*  31 */     uh var3 = this.g.x();
/*  32 */     int var4 = var1 * 16 + 8 - var3.a;
/*  33 */     int var5 = var2 * 16 + 8 - var3.c;
/*  34 */     short var6 = 128;
/*  35 */     if (var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
/*  36 */       this.a.add(Long.valueOf(sj.a(var1, var2)));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ack c(int var1, int var2) {
/*  42 */     long var3 = sj.a(var1, var2);
/*  43 */     this.a.remove(Long.valueOf(var3));
/*  44 */     ack var5 = (ack)this.e.a(var3);
/*  45 */     if (var5 == null) {
/*  46 */       int var6 = 1875004;
/*  47 */       if (var1 < -var6 || var2 < -var6 || var1 >= var6 || var2 >= var6) {
/*  48 */         return this.b;
/*     */       }
/*     */       
/*  51 */       var5 = e(var1, var2);
/*  52 */       if (var5 == null) {
/*  53 */         if (this.c == null) {
/*  54 */           var5 = this.b;
/*     */         } else {
/*  56 */           var5 = this.c.b(var1, var2);
/*     */         } 
/*     */       }
/*     */       
/*  60 */       this.e.a(var3, var5);
/*  61 */       this.f.add(var5);
/*  62 */       if (var5 != null) {
/*  63 */         var5.c();
/*  64 */         var5.d();
/*     */       } 
/*     */       
/*  67 */       var5.a(this, this, var1, var2);
/*     */     } 
/*     */     
/*  70 */     return var5;
/*     */   }
/*     */   
/*     */   public ack b(int var1, int var2) {
/*  74 */     ack var3 = (ack)this.e.a(sj.a(var1, var2));
/*  75 */     return (var3 == null) ? c(var1, var2) : var3;
/*     */   }
/*     */   
/*     */   private ack e(int var1, int var2) {
/*  79 */     if (this.d == null) {
/*  80 */       return null;
/*     */     }
/*     */     try {
/*  83 */       ack var3 = this.d.a(this.g, var1, var2);
/*  84 */       if (var3 != null) {
/*  85 */         var3.n = this.g.w();
/*     */       }
/*     */       
/*  88 */       return var3;
/*  89 */     } catch (Exception var4) {
/*  90 */       var4.printStackTrace();
/*  91 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(ack var1) {
/*  97 */     if (this.d != null) {
/*     */       try {
/*  99 */         this.d.b(this.g, var1);
/* 100 */       } catch (Exception var3) {
/* 101 */         var3.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ack var1) {
/* 108 */     if (this.d != null) {
/*     */       try {
/* 110 */         var1.n = this.g.w();
/* 111 */         this.d.a(this.g, var1);
/* 112 */       } catch (IOException var3) {
/* 113 */         var3.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ca var1, int var2, int var3) {
/* 120 */     ack var4 = b(var2, var3);
/* 121 */     if (!var4.k) {
/* 122 */       var4.k = true;
/* 123 */       if (this.c != null) {
/* 124 */         this.c.a(var1, var2, var3);
/* 125 */         ModLoader.populateChunk(this.c, var2, var3, this.g);
/* 126 */         var4.f();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(boolean var1, rw var2) {
/* 133 */     int var3 = 0;
/*     */     
/* 135 */     for (int var4 = 0; var4 < this.f.size(); var4++) {
/* 136 */       ack var5 = this.f.get(var4);
/* 137 */       if (var1) {
/* 138 */         a(var5);
/*     */       }
/*     */       
/* 141 */       if (var5.a(var1)) {
/* 142 */         b(var5);
/* 143 */         var5.l = false;
/* 144 */         var3++;
/* 145 */         if (var3 == 24 && !var1) {
/* 146 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (var1) {
/* 152 */       if (this.d == null) {
/* 153 */         return true;
/*     */       }
/*     */       
/* 156 */       this.d.c();
/*     */     } 
/*     */     
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   public boolean a() {
/*     */     int var1;
/* 164 */     for (var1 = 0; var1 < 100; var1++) {
/* 165 */       if (!this.a.isEmpty()) {
/* 166 */         Long var2 = this.a.iterator().next();
/* 167 */         ack var3 = (ack)this.e.a(var2.longValue());
/* 168 */         var3.e();
/* 169 */         b(var3);
/* 170 */         a(var3);
/* 171 */         this.a.remove(var2);
/* 172 */         this.e.d(var2.longValue());
/* 173 */         this.f.remove(var3);
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     for (var1 = 0; var1 < 10; var1++) {
/* 178 */       if (this.h >= this.f.size()) {
/* 179 */         this.h = 0;
/*     */         
/*     */         break;
/*     */       } 
/* 183 */       ack var4 = this.f.get(this.h++);
/* 184 */       yw var5 = this.g.a((var4.g << 4) + 8.0D, (var4.h << 4) + 8.0D, 288.0D);
/* 185 */       if (var5 == null) {
/* 186 */         d(var4.g, var4.h);
/*     */       }
/*     */     } 
/*     */     
/* 190 */     if (this.d != null) {
/* 191 */       this.d.b();
/*     */     }
/*     */     
/* 194 */     return this.c.a();
/*     */   }
/*     */   
/*     */   public boolean b() {
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   public String c() {
/* 202 */     return "ServerChunkCache: " + this.e.a() + " Drop: " + this.a.size();
/*     */   }
/*     */   
/*     */   public List a(acf var1, int var2, int var3, int var4) {
/* 206 */     return this.c.a(var1, var2, var3, var4);
/*     */   }
/*     */   
/*     */   public qo a(xd var1, String var2, int var3, int var4, int var5) {
/* 210 */     return this.c.a(var1, var2, var3, var4, var5);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ko.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */