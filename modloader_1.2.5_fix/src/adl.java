/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.URL;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ public class adl
/*     */   extends oe {
/*     */   private boolean f = false;
/*     */   private lg g;
/*     */   public String a;
/*     */   private Minecraft h;
/*     */   private je i;
/*     */   private boolean j = false;
/*  25 */   public za b = new za(null);
/*  26 */   private Map k = new HashMap<Object, Object>();
/*  27 */   public List c = new ArrayList();
/*  28 */   public int d = 20;
/*  29 */   Random e = new Random();
/*     */ 
/*     */   
/*     */   public adl(Minecraft var1, String var2, int var3) throws UnknownHostException, IOException {
/*  33 */     this.h = var1;
/*  34 */     Socket var4 = new Socket(InetAddress.getByName(var2), var3);
/*  35 */     this.g = new lg(var4, "Client", this);
/*     */   }
/*     */   
/*     */   public void b() {
/*  39 */     if (!this.f) {
/*  40 */       this.g.b();
/*     */     }
/*     */     
/*  43 */     this.g.a();
/*     */   }
/*     */   
/*     */   public void a(aec var1) {
/*  47 */     this.h.c = (ki)new rk(this.h, this);
/*  48 */     this.h.K.a(gv.i, 1);
/*  49 */     this.i = new je(this, new fj(0L, var1.d, false, false, var1.c), var1.e, var1.f);
/*  50 */     this.i.F = true;
/*  51 */     this.h.a((xd)this.i);
/*  52 */     this.h.h.aB = var1.e;
/*  53 */     this.h.a((vp)new ez(this));
/*  54 */     this.h.h.f = var1.a;
/*  55 */     this.d = var1.h;
/*  56 */     ((rk)this.h.c).a((var1.d == 1));
/*  57 */     ModLoader.serverConnect(this, var1);
/*     */   }
/*     */   
/*     */   public void a(jp var1) {
/*  61 */     double var2 = var1.b / 32.0D;
/*  62 */     double var4 = var1.c / 32.0D;
/*  63 */     double var6 = var1.d / 32.0D;
/*  64 */     fq var8 = new fq((xd)this.i, var2, var4, var6, new aan(var1.h, var1.i, var1.j));
/*  65 */     var8.r = var1.e / 128.0D;
/*  66 */     var8.s = var1.f / 128.0D;
/*  67 */     var8.t = var1.g / 128.0D;
/*  68 */     var8.ah = var1.b;
/*  69 */     var8.ai = var1.c;
/*  70 */     var8.aj = var1.d;
/*  71 */     this.i.a(var1.a, var8);
/*     */   }
/*     */   
/*     */   public void a(np var1) {
/*  75 */     double var2 = var1.b / 32.0D;
/*  76 */     double var4 = var1.c / 32.0D;
/*  77 */     double var6 = var1.d / 32.0D;
/*  78 */     Object var8 = null;
/*  79 */     if (var1.h == 10) {
/*  80 */       var8 = new ama((xd)this.i, var2, var4, var6, 0);
/*  81 */     } else if (var1.h == 11) {
/*  82 */       var8 = new ama((xd)this.i, var2, var4, var6, 1);
/*  83 */     } else if (var1.h == 12) {
/*  84 */       var8 = new ama((xd)this.i, var2, var4, var6, 2);
/*  85 */     } else if (var1.h == 90) {
/*  86 */       var8 = new act((xd)this.i, var2, var4, var6);
/*  87 */     } else if (var1.h == 60) {
/*  88 */       var8 = new nm((xd)this.i, var2, var4, var6);
/*  89 */     } else if (var1.h == 61) {
/*  90 */       var8 = new uq((xd)this.i, var2, var4, var6);
/*  91 */     } else if (var1.h == 65) {
/*  92 */       var8 = new adw((xd)this.i, var2, var4, var6);
/*  93 */     } else if (var1.h == 72) {
/*  94 */       var8 = new va((xd)this.i, var2, var4, var6);
/*  95 */     } else if (var1.h == 63) {
/*  96 */       var8 = new bt((xd)this.i, var2, var4, var6, var1.e / 8000.0D, var1.f / 8000.0D, var1.g / 8000.0D);
/*  97 */       var1.i = 0;
/*  98 */     } else if (var1.h == 64) {
/*  99 */       var8 = new qb((xd)this.i, var2, var4, var6, var1.e / 8000.0D, var1.f / 8000.0D, var1.g / 8000.0D);
/* 100 */       var1.i = 0;
/* 101 */     } else if (var1.h == 62) {
/* 102 */       var8 = new qe((xd)this.i, var2, var4, var6);
/* 103 */     } else if (var1.h == 73) {
/* 104 */       var8 = new bj((xd)this.i, var2, var4, var6, var1.i);
/* 105 */       var1.i = 0;
/* 106 */     } else if (var1.h == 75) {
/* 107 */       var8 = new hf((xd)this.i, var2, var4, var6);
/* 108 */       var1.i = 0;
/* 109 */     } else if (var1.h == 1) {
/* 110 */       var8 = new ep((xd)this.i, var2, var4, var6);
/* 111 */     } else if (var1.h == 50) {
/* 112 */       var8 = new agg((xd)this.i, var2, var4, var6);
/* 113 */     } else if (var1.h == 51) {
/* 114 */       var8 = new el((xd)this.i, var2, var4, var6);
/* 115 */     } else if (var1.h == 70) {
/* 116 */       var8 = new abf((xd)this.i, var2, var4, var6, pb.E.bO);
/* 117 */     } else if (var1.h == 71) {
/* 118 */       var8 = new abf((xd)this.i, var2, var4, var6, pb.F.bO);
/* 119 */     } else if (var1.h == 74) {
/* 120 */       var8 = new abf((xd)this.i, var2, var4, var6, pb.bK.bO);
/*     */     } 
/*     */     
/* 123 */     if (var8 != null) {
/* 124 */       ((nn)var8).ah = var1.b;
/* 125 */       ((nn)var8).ai = var1.c;
/* 126 */       ((nn)var8).aj = var1.d;
/* 127 */       ((nn)var8).u = 0.0F;
/* 128 */       ((nn)var8).v = 0.0F;
/* 129 */       nn[] var9 = ((nn)var8).Z();
/* 130 */       if (var9 != null) {
/* 131 */         int var10 = var1.a - ((nn)var8).f;
/*     */         
/* 133 */         for (int var11 = 0; var11 < var9.length; var11++) {
/* 134 */           (var9[var11]).f += var10;
/*     */         }
/*     */       } 
/*     */       
/* 138 */       ((nn)var8).f = var1.a;
/* 139 */       this.i.a(var1.a, (nn)var8);
/* 140 */       if (var1.i > 0) {
/* 141 */         if (var1.h == 60) {
/* 142 */           nn var12 = a(var1.i);
/* 143 */           if (var12 instanceof acq) {
/* 144 */             ((nm)var8).c = var12;
/*     */           }
/*     */         } 
/*     */         
/* 148 */         ((nn)var8).a(var1.e / 8000.0D, var1.f / 8000.0D, var1.g / 8000.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(lj var1) {
/* 155 */     bz var2 = new bz((xd)this.i, var1.b, var1.c, var1.d, var1.e);
/* 156 */     var2.ah = var1.b;
/* 157 */     var2.ai = var1.c;
/* 158 */     var2.aj = var1.d;
/* 159 */     var2.u = 0.0F;
/* 160 */     var2.v = 0.0F;
/* 161 */     var2.f = var1.a;
/* 162 */     this.i.a(var1.a, (nn)var2);
/*     */   }
/*     */   
/*     */   public void a(wz var1) {
/* 166 */     double var2 = var1.b / 32.0D;
/* 167 */     double var4 = var1.c / 32.0D;
/* 168 */     double var6 = var1.d / 32.0D;
/* 169 */     d var8 = null;
/* 170 */     if (var1.e == 1) {
/* 171 */       var8 = new d((xd)this.i, var2, var4, var6);
/*     */     }
/*     */     
/* 174 */     if (var8 != null) {
/* 175 */       var8.ah = var1.b;
/* 176 */       var8.ai = var1.c;
/* 177 */       var8.aj = var1.d;
/* 178 */       var8.u = 0.0F;
/* 179 */       var8.v = 0.0F;
/* 180 */       var8.f = var1.a;
/* 181 */       this.i.e((nn)var8);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(qc var1) {
/* 187 */     mk var2 = new mk((xd)this.i, var1.b, var1.c, var1.d, var1.e, var1.f);
/* 188 */     this.i.a(var1.a, (nn)var2);
/*     */   }
/*     */   
/*     */   public void a(yn var1) {
/* 192 */     nn var2 = a(var1.a);
/* 193 */     if (var2 != null) {
/* 194 */       var2.a(var1.b / 8000.0D, var1.c / 8000.0D, var1.d / 8000.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(pf var1) {
/* 199 */     nn var2 = a(var1.a);
/* 200 */     if (var2 != null && var1.b() != null) {
/* 201 */       var2.y().a(var1.b());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(iy var1) {
/* 207 */     double var2 = var1.c / 32.0D;
/* 208 */     double var4 = var1.d / 32.0D;
/* 209 */     double var6 = var1.e / 32.0D;
/* 210 */     float var8 = (var1.f * 360) / 256.0F;
/* 211 */     float var9 = (var1.g * 360) / 256.0F;
/* 212 */     rv var10 = new rv(this.h.f, var1.b);
/* 213 */     var10.l = var10.N = (var10.ah = var1.c);
/* 214 */     var10.m = var10.O = (var10.ai = var1.d);
/* 215 */     var10.n = var10.P = (var10.aj = var1.e);
/* 216 */     int var11 = var1.h;
/* 217 */     if (var11 == 0) {
/* 218 */       var10.ap.a[var10.ap.c] = null;
/*     */     } else {
/* 220 */       var10.ap.a[var10.ap.c] = new aan(var11, 1, 0);
/*     */     } 
/*     */     
/* 223 */     var10.b(var2, var4, var6, var8, var9);
/* 224 */     this.i.a(var1.a, (nn)var10);
/*     */   }
/*     */   
/*     */   public void a(mr var1) {
/* 228 */     nn var2 = a(var1.a);
/* 229 */     if (var2 != null) {
/* 230 */       var2.ah = var1.b;
/* 231 */       var2.ai = var1.c;
/* 232 */       var2.aj = var1.d;
/* 233 */       double var3 = var2.ah / 32.0D;
/* 234 */       double var5 = var2.ai / 32.0D + 0.015625D;
/* 235 */       double var7 = var2.aj / 32.0D;
/* 236 */       float var9 = (var1.e * 360) / 256.0F;
/* 237 */       float var10 = (var1.f * 360) / 256.0F;
/* 238 */       var2.a(var3, var5, var7, var9, var10, 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(aip var1) {
/* 243 */     nn var2 = a(var1.a);
/* 244 */     if (var2 != null) {
/* 245 */       var2.ah += var1.b;
/* 246 */       var2.ai += var1.c;
/* 247 */       var2.aj += var1.d;
/* 248 */       double var3 = var2.ah / 32.0D;
/* 249 */       double var5 = var2.ai / 32.0D;
/* 250 */       double var7 = var2.aj / 32.0D;
/* 251 */       float var9 = var1.g ? ((var1.e * 360) / 256.0F) : var2.u;
/* 252 */       float var10 = var1.g ? ((var1.f * 360) / 256.0F) : var2.v;
/* 253 */       var2.a(var3, var5, var7, var9, var10, 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(aji var1) {
/* 258 */     nn var2 = a(var1.a);
/* 259 */     if (var2 != null) {
/* 260 */       float var3 = (var1.b * 360) / 256.0F;
/* 261 */       var2.f(var3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(agx var1) {
/* 266 */     this.i.b(var1.a);
/*     */   }
/*     */   
/*     */   public void a(gg var1) {
/* 270 */     vq var2 = this.h.h;
/* 271 */     double var3 = var2.o;
/* 272 */     double var5 = var2.p;
/* 273 */     double var7 = var2.q;
/* 274 */     float var9 = var2.u;
/* 275 */     float var10 = var2.v;
/* 276 */     if (var1.h) {
/* 277 */       var3 = var1.a;
/* 278 */       var5 = var1.b;
/* 279 */       var7 = var1.c;
/*     */     } 
/*     */     
/* 282 */     if (var1.i) {
/* 283 */       var9 = var1.e;
/* 284 */       var10 = var1.f;
/*     */     } 
/*     */     
/* 287 */     var2.Q = 0.0F;
/* 288 */     var2.r = var2.s = var2.t = 0.0D;
/* 289 */     var2.b(var3, var5, var7, var9, var10);
/* 290 */     var1.a = var2.o;
/* 291 */     var1.b = var2.y.b;
/* 292 */     var1.c = var2.q;
/* 293 */     var1.d = var2.p;
/* 294 */     this.g.a((abs)var1);
/* 295 */     if (!this.j) {
/* 296 */       this.h.h.l = this.h.h.o;
/* 297 */       this.h.h.m = this.h.h.p;
/* 298 */       this.h.h.n = this.h.h.q;
/* 299 */       this.j = true;
/* 300 */       this.h.a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ahc var1) {
/* 306 */     this.i.a(var1.a, var1.b, var1.c);
/*     */   }
/*     */   
/*     */   public void a(akt var1) {
/* 310 */     int var2 = var1.a * 16;
/* 311 */     int var3 = var1.b * 16;
/* 312 */     if (var1.c != null) {
/* 313 */       DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var1.c));
/*     */       
/*     */       try {
/* 316 */         for (int var5 = 0; var5 < var1.d; var5++) {
/* 317 */           short var6 = var4.readShort();
/* 318 */           short var7 = var4.readShort();
/* 319 */           int var8 = (var7 & 0xFFF) >> 4;
/* 320 */           int var9 = var7 & 0xF;
/* 321 */           int var10 = var6 >> 12 & 0xF;
/* 322 */           int var11 = var6 >> 8 & 0xF;
/* 323 */           int var12 = var6 & 0xFF;
/* 324 */           this.i.c(var10 + var2, var12, var11 + var3, var8, var9);
/*     */         } 
/* 326 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(sz var1) {
/* 334 */     this.i.a(var1.a << 4, 0, var1.b << 4, (var1.a << 4) + 15, 256, (var1.b << 4) + 15);
/* 335 */     ack var2 = this.i.d(var1.a, var1.b);
/* 336 */     if (var1.f && var2 == null) {
/* 337 */       this.i.a(var1.a, var1.b, true);
/* 338 */       var2 = this.i.d(var1.a, var1.b);
/*     */     } 
/*     */     
/* 341 */     if (var2 != null) {
/* 342 */       var2.a(var1.e, var1.c, var1.d, var1.f);
/* 343 */       this.i.c(var1.a << 4, 0, var1.b << 4, (var1.a << 4) + 15, 256, (var1.b << 4) + 15);
/* 344 */       if (!var1.f || !(this.i.t instanceof ms)) {
/* 345 */         var2.n();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ol var1) {
/* 352 */     this.i.c(var1.a, var1.b, var1.c, var1.d, var1.e);
/*     */   }
/*     */   
/*     */   public void a(amg var1) {
/* 356 */     this.g.a("disconnect.kicked", new Object[0]);
/* 357 */     this.f = true;
/* 358 */     ModLoader.serverDisconnect();
/* 359 */     this.h.a(null);
/* 360 */     this.h.a((vp)new dw("disconnect.disconnected", "disconnect.genericReason", new Object[] { var1.a }));
/*     */   }
/*     */   
/*     */   public void a(String var1, Object[] var2) {
/* 364 */     if (!this.f) {
/* 365 */       this.f = true;
/* 366 */       ModLoader.serverDisconnect();
/* 367 */       this.h.a(null);
/* 368 */       this.h.a((vp)new dw("disconnect.lost", var1, var2));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(abs var1) {
/* 373 */     if (!this.f) {
/* 374 */       this.g.a(var1);
/* 375 */       this.g.c();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void c(abs var1) {
/* 380 */     if (!this.f) {
/* 381 */       this.g.a(var1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(vv var1) {
/* 386 */     nn var2 = a(var1.a);
/* 387 */     Object var3 = a(var1.b);
/* 388 */     if (var3 == null) {
/* 389 */       var3 = this.h.h;
/*     */     }
/*     */     
/* 392 */     if (var2 != null) {
/* 393 */       if (var2 instanceof bz) {
/* 394 */         this.i.a(var2, "random.orb", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*     */       } else {
/* 396 */         this.i.a(var2, "random.pop", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*     */       } 
/*     */       
/* 399 */       this.h.j.a((rt)new ws(this.h.f, var2, (nn)var3, -0.5F));
/* 400 */       this.i.b(var1.a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(afd var1) {
/* 406 */     this.h.w.a(var1.a);
/* 407 */     ModLoader.serverChat(var1.a);
/*     */   }
/*     */   
/*     */   public void a(kc var1) {
/* 411 */     nn var2 = a(var1.a);
/* 412 */     if (var2 != null)
/*     */     {
/* 414 */       if (var1.b == 1) {
/* 415 */         yw var3 = (yw)var2;
/* 416 */         var3.ax();
/* 417 */       } else if (var1.b == 2) {
/* 418 */         var2.k();
/* 419 */       } else if (var1.b == 3) {
/* 420 */         yw var3 = (yw)var2;
/* 421 */         var3.a(false, false, false);
/* 422 */       } else if (var1.b == 4) {
/* 423 */         yw var3 = (yw)var2;
/* 424 */         var3.ab();
/* 425 */       } else if (var1.b == 6) {
/* 426 */         this.h.j.a((rt)new fs(this.h.f, var2));
/* 427 */       } else if (var1.b == 7) {
/* 428 */         fs var4 = new fs(this.h.f, var2, "magicCrit");
/* 429 */         this.h.j.a((rt)var4);
/* 430 */       } else if (var1.b != 5 || var2 instanceof rv) {
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(abj var1) {
/* 438 */     nn var2 = a(var1.a);
/* 439 */     if (var2 != null && 
/* 440 */       var1.e == 0) {
/* 441 */       yw var3 = (yw)var2;
/* 442 */       var3.d(var1.b, var1.c, var1.d);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(jf var1) {
/* 449 */     boolean var2 = true;
/* 450 */     String var3 = var1.a;
/* 451 */     if (var3 != null && var3.trim().length() != 0) {
/* 452 */       if (!var3.equals("-")) {
/*     */         try {
/* 454 */           Long.parseLong(var3, 16);
/* 455 */         } catch (NumberFormatException var8) {
/* 456 */           var2 = false;
/*     */         } 
/*     */       }
/*     */     } else {
/* 460 */       var2 = false;
/*     */     } 
/*     */     
/* 463 */     if (!var2) {
/* 464 */       this.g.a("disconnect.genericReason", new Object[] { "The server responded with an invalid server key" });
/* 465 */     } else if (var1.a.equals("-")) {
/* 466 */       c((abs)new aec(this.h.k.b, 29));
/*     */     } else {
/*     */       try {
/* 469 */         URL var4 = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + this.h.k.b + "&sessionId=" + this.h.k.c + "&serverId=" + var1.a);
/* 470 */         BufferedReader var5 = new BufferedReader(new InputStreamReader(var4.openStream()));
/* 471 */         String var6 = var5.readLine();
/* 472 */         var5.close();
/* 473 */         if (var6.equalsIgnoreCase("ok")) {
/* 474 */           c((abs)new aec(this.h.k.b, 29));
/*     */         } else {
/* 476 */           this.g.a("disconnect.loginFailedInfo", new Object[] { var6 });
/*     */         } 
/* 478 */       } catch (Exception var7) {
/* 479 */         var7.printStackTrace();
/* 480 */         this.g.a("disconnect.genericReason", new Object[] { "Internal client error: " + var7.toString() });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void c() {
/* 487 */     this.f = true;
/* 488 */     ModLoader.serverDisconnect();
/* 489 */     this.g.a();
/* 490 */     this.g.a("disconnect.closed", new Object[0]);
/*     */   }
/*     */   
/*     */   public void a(aay var1) {
/* 494 */     double var2 = var1.c / 32.0D;
/* 495 */     double var4 = var1.d / 32.0D;
/* 496 */     double var6 = var1.e / 32.0D;
/* 497 */     float var8 = (var1.f * 360) / 256.0F;
/* 498 */     float var9 = (var1.g * 360) / 256.0F;
/* 499 */     acq var10 = (acq)aao.a(var1.b, this.h.f);
/* 500 */     var10.ah = var1.c;
/* 501 */     var10.ai = var1.d;
/* 502 */     var10.aj = var1.e;
/* 503 */     var10.bf = (var1.h * 360) / 256.0F;
/* 504 */     nn[] var11 = var10.Z();
/* 505 */     if (var11 != null) {
/* 506 */       int var12 = var1.a - var10.f;
/*     */       
/* 508 */       for (int var13 = 0; var13 < var11.length; var13++) {
/* 509 */         (var11[var13]).f += var12;
/*     */       }
/*     */     } 
/*     */     
/* 513 */     var10.f = var1.a;
/* 514 */     var10.b(var2, var4, var6, var8, var9);
/* 515 */     this.i.a(var1.a, (nn)var10);
/* 516 */     List var14 = var1.b();
/* 517 */     if (var14 != null) {
/* 518 */       var10.y().a(var14);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(zf var1) {
/* 524 */     this.h.f.a(var1.a);
/*     */   }
/*     */   
/*     */   public void a(agl var1) {
/* 528 */     this.h.h.a(new uh(var1.a, var1.b, var1.c));
/* 529 */     this.h.f.B().a(var1.a, var1.b, var1.c);
/*     */   }
/*     */   
/*     */   public void a(adv var1) {
/* 533 */     Object var2 = a(var1.a);
/* 534 */     nn var3 = a(var1.b);
/* 535 */     if (var1.a == this.h.h.f) {
/* 536 */       var2 = this.h.h;
/*     */     }
/*     */     
/* 539 */     if (var2 != null) {
/* 540 */       ((nn)var2).h(var3);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(gt var1) {
/* 545 */     nn var2 = a(var1.a);
/* 546 */     if (var2 != null) {
/* 547 */       var2.a(var1.b);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private nn a(int var1) {
/* 553 */     return (var1 == this.h.h.f) ? (nn)this.h.h : this.i.a(var1);
/*     */   }
/*     */   
/*     */   public void a(ds var1) {
/* 557 */     this.h.h.d(var1.a);
/* 558 */     this.h.h.aF().a(var1.b);
/* 559 */     this.h.h.aF().b(var1.c);
/*     */   }
/*     */   
/*     */   public void a(ih var1) {
/* 563 */     this.h.h.a(var1.a, var1.b, var1.c);
/*     */   }
/*     */   
/*     */   public void a(kx var1) {
/* 567 */     if (var1.a != this.h.h.aB) {
/* 568 */       this.j = false;
/* 569 */       this.i = new je(this, new fj(0L, var1.d, false, false, var1.e), var1.a, var1.b);
/* 570 */       this.i.F = true;
/* 571 */       this.h.a((xd)this.i);
/* 572 */       this.h.h.aB = var1.a;
/* 573 */       this.h.a((vp)new ez(this));
/*     */     } 
/*     */     
/* 576 */     this.h.a(true, var1.a, false);
/* 577 */     ((rk)this.h.c).a((var1.d == 1));
/*     */   }
/*     */   
/*     */   public void a(ags var1) {
/* 581 */     agh var2 = new agh(this.h.f, null, var1.a, var1.b, var1.c, var1.d);
/* 582 */     var2.g = var1.e;
/* 583 */     var2.a(true);
/*     */   }
/*     */   
/*     */   public void a(gr var1) {
/* 587 */     vq var2 = this.h.h;
/* 588 */     switch (var1.b) {
/*     */       case 0:
/* 590 */         var2.a((io)new me(var1.c, var1.d));
/* 591 */         var2.ar.f = var1.a;
/*     */         break;
/*     */       case 1:
/* 594 */         var2.a(gk.c(var2.o), gk.c(var2.p), gk.c(var2.q));
/* 595 */         var2.ar.f = var1.a;
/*     */         break;
/*     */       case 2:
/* 598 */         var2.a(new ahg());
/* 599 */         var2.ar.f = var1.a;
/*     */         break;
/*     */       case 3:
/* 602 */         var2.a(new az());
/* 603 */         var2.ar.f = var1.a;
/*     */         break;
/*     */       case 4:
/* 606 */         var2.c(gk.c(var2.o), gk.c(var2.p), gk.c(var2.q));
/* 607 */         var2.ar.f = var1.a;
/*     */         break;
/*     */       case 5:
/* 610 */         var2.a(new amc());
/* 611 */         var2.ar.f = var1.a;
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(fu var1) {
/* 617 */     vq var2 = this.h.h;
/* 618 */     if (var1.a == -1) {
/* 619 */       var2.ap.b(var1.c);
/* 620 */     } else if (var1.a == 0 && var1.b >= 36 && var1.b < 45) {
/* 621 */       aan var3 = var2.aq.b(var1.b).b();
/* 622 */       if (var1.c != null && (var3 == null || var3.a < var1.c.a)) {
/* 623 */         var1.c.b = 5;
/*     */       }
/*     */       
/* 626 */       var2.aq.a(var1.b, var1.c);
/* 627 */     } else if (var1.a == var2.ar.f) {
/* 628 */       var2.ar.a(var1.b, var1.c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(kn var1) {
/* 634 */     dd var2 = null;
/* 635 */     vq var3 = this.h.h;
/* 636 */     if (var1.a == 0) {
/* 637 */       var2 = var3.aq;
/* 638 */     } else if (var1.a == var3.ar.f) {
/* 639 */       var2 = var3.ar;
/*     */     } 
/*     */     
/* 642 */     if (var2 != null) {
/* 643 */       if (var1.c) {
/* 644 */         var2.a(var1.b);
/*     */       } else {
/* 646 */         var2.b(var1.b);
/* 647 */         c((abs)new kn(var1.a, var1.b, true));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(abl var1) {
/* 654 */     vq var2 = this.h.h;
/* 655 */     if (var1.a == 0) {
/* 656 */       var2.aq.a(var1.b);
/* 657 */     } else if (var1.a == var2.ar.f) {
/* 658 */       var2.ar.a(var1.b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(aiu var1) {
/* 664 */     if (this.h.f.j(var1.a, var1.b, var1.c)) {
/* 665 */       kw var2 = this.h.f.b(var1.a, var1.b, var1.c);
/* 666 */       if (var2 instanceof sc) {
/* 667 */         sc var3 = (sc)var2;
/* 668 */         if (var3.a()) {
/* 669 */           for (int var4 = 0; var4 < 4; var4++) {
/* 670 */             var3.a[var4] = var1.d[var4];
/*     */           }
/*     */           
/* 673 */           var3.j();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ait var1) {
/* 681 */     if (this.h.f.j(var1.a, var1.b, var1.c)) {
/* 682 */       kw var2 = this.h.f.b(var1.a, var1.b, var1.c);
/* 683 */       if (var2 != null && var1.d == 1 && var2 instanceof cj) {
/* 684 */         ((cj)var2).a(aao.a(var1.e));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(jl var1) {
/* 691 */     vq var2 = this.h.h;
/* 692 */     a((abs)var1);
/* 693 */     if (var2.ar != null && var2.ar.f == var1.a) {
/* 694 */       var2.ar.a(var1.b, var1.c);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ta var1) {
/* 700 */     nn var2 = a(var1.a);
/* 701 */     if (var2 != null) {
/* 702 */       var2.b(var1.b, var1.c, var1.d);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(add var1) {
/* 708 */     this.h.h.af();
/*     */   }
/*     */   
/*     */   public void a(qi var1) {
/* 712 */     this.h.f.f(var1.a, var1.b, var1.c, var1.d, var1.e);
/*     */   }
/*     */   
/*     */   public void a(us var1) {
/* 716 */     vq var2 = this.h.h;
/* 717 */     int var3 = var1.b;
/* 718 */     if (var3 >= 0 && var3 < us.a.length && us.a[var3] != null) {
/* 719 */       var2.b(us.a[var3]);
/*     */     }
/*     */     
/* 722 */     if (var3 == 1) {
/* 723 */       this.i.B().b(true);
/* 724 */       this.i.k(1.0F);
/* 725 */     } else if (var3 == 2) {
/* 726 */       this.i.B().b(false);
/* 727 */       this.i.k(0.0F);
/* 728 */     } else if (var3 == 3) {
/* 729 */       ((rk)this.h.c).a((var1.c == 1));
/* 730 */     } else if (var3 == 4) {
/* 731 */       this.h.a((vp)new c());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ai var1) {
/* 737 */     if (var1.a == yr.bd.bQ) {
/* 738 */       ra.a(var1.b, this.h.f).a(var1.c);
/*     */     } else {
/* 740 */       System.out.println("Unknown itemid: " + var1.b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ej var1) {
/* 746 */     this.h.f.g(var1.a, var1.c, var1.d, var1.e, var1.b);
/*     */   }
/*     */   
/*     */   public void a(kk var1) {
/* 750 */     ((ahv)this.h.h).b(gv.a(var1.a), var1.b);
/*     */   }
/*     */   
/*     */   public void a(wb var1) {
/* 754 */     nn var2 = a(var1.a);
/* 755 */     if (var2 != null && var2 instanceof acq) {
/* 756 */       ((acq)var2).b(new alg(var1.b, var1.d, var1.c));
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(ado var1) {
/* 761 */     nn var2 = a(var1.a);
/* 762 */     if (var2 != null && var2 instanceof acq) {
/* 763 */       ((acq)var2).m(var1.b);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean a() {
/* 768 */     return false;
/*     */   }
/*     */   
/*     */   public void a(wj var1) {
/* 772 */     ah var2 = (ah)this.k.get(var1.a);
/* 773 */     if (var2 == null && var1.b) {
/* 774 */       var2 = new ah(var1.a);
/* 775 */       this.k.put(var1.a, var2);
/* 776 */       this.c.add(var2);
/*     */     } 
/*     */     
/* 779 */     if (var2 != null && !var1.b) {
/* 780 */       this.k.remove(var1.a);
/* 781 */       this.c.remove(var2);
/*     */     } 
/*     */     
/* 784 */     if (var1.b && var2 != null) {
/* 785 */       var2.b = var1.c;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(acw var1) {
/* 791 */     c((abs)new acw(var1.a));
/*     */   }
/*     */   
/*     */   public void a(ym var1) {
/* 795 */     vq var2 = this.h.h;
/* 796 */     var2.aT.b = var1.b;
/* 797 */     var2.aT.d = var1.d;
/* 798 */     var2.aT.a = var1.a;
/* 799 */     var2.aT.c = var1.c;
/*     */   }
/*     */   
/*     */   public void a(ee var1) {
/* 803 */     ModLoader.receivePacket(var1);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\adl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */