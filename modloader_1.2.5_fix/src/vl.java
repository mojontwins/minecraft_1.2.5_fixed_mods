/*      */ import net.minecraft.client.Minecraft;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ public class vl
/*      */ {
/*      */   public ali a;
/*    7 */   public int d = -1;
/*      */   public boolean e = false;
/*      */   public boolean f = false;
/*      */   public static boolean b = true;
/*      */   public static boolean cfgGrassFix = true;
/*      */   public boolean c = true;
/*   13 */   public int g = 0;
/*   14 */   public int h = 0;
/*   15 */   public int i = 0;
/*   16 */   public int j = 0;
/*   17 */   public int k = 0;
/*   18 */   public int l = 0;
/*      */   public boolean m;
/*      */   public float n;
/*      */   public float o;
/*      */   public float p;
/*      */   public float q;
/*      */   public float r;
/*      */   public float s;
/*      */   public float t;
/*      */   public float u;
/*      */   public float v;
/*      */   public float w;
/*      */   public float x;
/*      */   public float y;
/*      */   public float z;
/*      */   public float A;
/*      */   public float B;
/*      */   public float C;
/*      */   public float D;
/*      */   public float E;
/*      */   public float F;
/*      */   public float G;
/*      */   public float H;
/*      */   public float I;
/*      */   public float J;
/*      */   public float K;
/*      */   public float L;
/*      */   public float M;
/*      */   public float N;
/*      */   public int O;
/*      */   public int P;
/*      */   public int Q;
/*      */   public int R;
/*      */   public int S;
/*      */   public int T;
/*      */   public int U;
/*      */   public int V;
/*      */   public int W;
/*      */   public int X;
/*      */   public int Y;
/*      */   public int Z;
/*      */   public int aa;
/*      */   public int ab;
/*      */   public int ac;
/*      */   public int ad;
/*      */   public int ae;
/*      */   public int af;
/*      */   public int ag;
/*      */   public int ah;
/*   67 */   public int ai = 1;
/*      */   
/*      */   public int aj;
/*      */   public int ak;
/*      */   public int al;
/*      */   public int am;
/*      */   public float an;
/*      */   public float ao;
/*      */   public float ap;
/*      */   public float aq;
/*      */   public float ar;
/*      */   public float as;
/*      */   public float at;
/*      */   public float au;
/*      */   public float av;
/*      */   public float aw;
/*      */   public float ax;
/*      */   public float ay;
/*      */   public boolean az;
/*      */   public boolean aA;
/*      */   public boolean aB;
/*      */   public boolean aC;
/*      */   public boolean aD;
/*      */   public boolean aE;
/*      */   public boolean aF;
/*      */   public boolean aG;
/*      */   public boolean aH;
/*      */   public boolean aI;
/*      */   public boolean aJ;
/*      */   public boolean aK;
/*      */   
/*      */   public vl(ali var1) {
/*   99 */     this.a = var1;
/*      */   }
/*      */ 
/*      */   
/*      */   public vl() {}
/*      */ 
/*      */   
/*      */   public void a() {
/*  107 */     this.d = -1;
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, int var3, int var4, int var5) {
/*  111 */     this.d = var5;
/*  112 */     b(var1, var2, var3, var4);
/*  113 */     this.d = -1;
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, int var3, int var4) {
/*  117 */     this.f = true;
/*  118 */     b(var1, var2, var3, var4);
/*  119 */     this.f = false;
/*      */   }
/*      */   
/*      */   public boolean b(pb var1, int var2, int var3, int var4) {
/*  123 */     int var5 = var1.d();
/*  124 */     var1.a(this.a, var2, var3, var4);
/*  125 */     return (var5 == 0) ? o(var1, var2, var3, var4) : ((var5 == 4) ? n(var1, var2, var3, var4) : ((var5 == 13) ? p(var1, var2, var3, var4) : (
/*  126 */       (var5 == 1) ? j(var1, var2, var3, var4) : ((var5 == 19) ? k(var1, var2, var3, var4) : ((var5 == 23) ? m(var1, var2, var3, var4) : (
/*  127 */       (var5 == 6) ? l(var1, var2, var3, var4) : ((var5 == 2) ? c(var1, var2, var3, var4) : ((var5 == 3) ? f(var1, var2, var3, var4) : (
/*  128 */       (var5 == 5) ? g(var1, var2, var3, var4) : ((var5 == 8) ? h(var1, var2, var3, var4) : ((var5 == 7) ? r(var1, var2, var3, var4) : (
/*  129 */       (var5 == 9) ? a((aez)var1, var2, var3, var4) : ((var5 == 10) ? q(var1, var2, var3, var4) : ((var5 == 27) ? a((de)var1, var2, 
/*  130 */         var3, var4) : ((var5 == 11) ? a((abg)var1, var2, var3, var4) : ((var5 == 12) ? e(var1, var2, var3, var4) : ((var5 == 14) ? t(
/*  131 */         var1, var2, var3, var4) : ((var5 == 15) ? u(var1, var2, var3, var4) : ((var5 == 16) ? b(var1, var2, var3, var4, false) : (
/*  132 */       (var5 == 17) ? c(var1, var2, var3, var4, true) : ((var5 == 18) ? a((akq)var1, var2, var3, var4) : ((var5 == 20) ? i(var1, 
/*  133 */         var2, var3, var4) : ((var5 == 21) ? a((ajf)var1, var2, var3, var4) : ((var5 == 24) ? a((xm)var1, var2, var3, var4) : (
/*  134 */       (var5 == 25) ? a((xc)var1, var2, var3, var4) : ((var5 == 26) ? s(var1, var2, var3, var4) : ModLoader.renderWorldBlock(
/*  135 */         this, this.a, var2, var3, var4, var1, var5)))))))))))))))))))))))))));
/*      */   }
/*      */   
/*      */   public boolean s(pb var1, int var2, int var3, int var4) {
/*  139 */     int var5 = this.a.e(var2, var3, var4);
/*  140 */     int var6 = var5 & 0x3;
/*  141 */     if (var6 == 0) {
/*  142 */       this.k = 3;
/*  143 */     } else if (var6 == 3) {
/*  144 */       this.k = 1;
/*  145 */     } else if (var6 == 1) {
/*  146 */       this.k = 2;
/*      */     } 
/*      */     
/*  149 */     if (!amj.e(var5)) {
/*  150 */       var1.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
/*  151 */       o(var1, var2, var3, var4);
/*  152 */       var1.h();
/*  153 */       this.k = 0;
/*  154 */       return true;
/*      */     } 
/*  156 */     var1.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
/*  157 */     o(var1, var2, var3, var4);
/*  158 */     this.d = 174;
/*  159 */     var1.a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
/*  160 */     o(var1, var2, var3, var4);
/*  161 */     a();
/*  162 */     var1.h();
/*  163 */     this.k = 0;
/*  164 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean t(pb var1, int var2, int var3, int var4) {
/*  169 */     adz var5 = adz.a;
/*  170 */     int var6 = this.a.e(var2, var3, var4);
/*  171 */     int var7 = pm.a(var6);
/*  172 */     boolean var8 = pm.e(var6);
/*  173 */     float var9 = 0.5F;
/*  174 */     float var10 = 1.0F;
/*  175 */     float var11 = 0.8F;
/*  176 */     float var12 = 0.6F;
/*  177 */     int var25 = var1.d(this.a, var2, var3, var4);
/*  178 */     var5.b(var25);
/*  179 */     var5.a(var9, var9, var9);
/*  180 */     int var27 = var1.d(this.a, var2, var3, var4, 0);
/*  181 */     int var28 = (var27 & 0xF) << 4;
/*  182 */     int var29 = var27 & 0xF0;
/*  183 */     double var30 = (var28 / 256.0F);
/*  184 */     double var32 = ((var28 + 16) - 0.01D) / 256.0D;
/*  185 */     double var34 = (var29 / 256.0F);
/*  186 */     double var36 = ((var29 + 16) - 0.01D) / 256.0D;
/*  187 */     double var38 = var2 + var1.bV;
/*  188 */     double var40 = var2 + var1.bY;
/*  189 */     double var42 = var3 + var1.bW + 0.1875D;
/*  190 */     double var44 = var4 + var1.bX;
/*  191 */     double var46 = var4 + var1.ca;
/*  192 */     var5.a(var38, var42, var46, var30, var36);
/*  193 */     var5.a(var38, var42, var44, var30, var34);
/*  194 */     var5.a(var40, var42, var44, var32, var34);
/*  195 */     var5.a(var40, var42, var46, var32, var36);
/*  196 */     var5.b(var1.d(this.a, var2, var3 + 1, var4));
/*  197 */     var5.a(var10, var10, var10);
/*  198 */     var27 = var1.d(this.a, var2, var3, var4, 1);
/*  199 */     var28 = (var27 & 0xF) << 4;
/*  200 */     var29 = var27 & 0xF0;
/*  201 */     var30 = (var28 / 256.0F);
/*  202 */     var32 = ((var28 + 16) - 0.01D) / 256.0D;
/*  203 */     var34 = (var29 / 256.0F);
/*  204 */     var36 = ((var29 + 16) - 0.01D) / 256.0D;
/*  205 */     var38 = var30;
/*  206 */     var40 = var32;
/*  207 */     var42 = var34;
/*  208 */     var44 = var34;
/*  209 */     var46 = var30;
/*  210 */     double var48 = var32;
/*  211 */     double var50 = var36;
/*  212 */     double var52 = var36;
/*  213 */     if (var7 == 0) {
/*  214 */       var40 = var30;
/*  215 */       var42 = var36;
/*  216 */       var46 = var32;
/*  217 */       var52 = var34;
/*  218 */     } else if (var7 == 2) {
/*  219 */       var38 = var32;
/*  220 */       var44 = var36;
/*  221 */       var48 = var30;
/*  222 */       var50 = var34;
/*  223 */     } else if (var7 == 3) {
/*  224 */       var38 = var32;
/*  225 */       var44 = var36;
/*  226 */       var48 = var30;
/*  227 */       var50 = var34;
/*  228 */       var40 = var30;
/*  229 */       var42 = var36;
/*  230 */       var46 = var32;
/*  231 */       var52 = var34;
/*      */     } 
/*      */     
/*  234 */     double var54 = var2 + var1.bV;
/*  235 */     double var56 = var2 + var1.bY;
/*  236 */     double var58 = var3 + var1.bZ;
/*  237 */     double var60 = var4 + var1.bX;
/*  238 */     double var62 = var4 + var1.ca;
/*  239 */     var5.a(var56, var58, var62, var46, var50);
/*  240 */     var5.a(var56, var58, var60, var38, var42);
/*  241 */     var5.a(var54, var58, var60, var40, var44);
/*  242 */     var5.a(var54, var58, var62, var48, var52);
/*  243 */     var27 = aav.c[var7];
/*  244 */     if (var8) {
/*  245 */       var27 = aav.c[aav.e[var7]];
/*      */     }
/*      */     
/*  248 */     byte var64 = 4;
/*  249 */     switch (var7) {
/*      */       case 0:
/*  251 */         var64 = 5;
/*      */         break;
/*      */       case 1:
/*  254 */         var64 = 3;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 3:
/*  259 */         var64 = 2;
/*      */         break;
/*      */     } 
/*  262 */     if (var27 != 2 && (this.f || var1.a(this.a, var2, var3, var4 - 1, 2))) {
/*  263 */       var5.b((var1.bX > 0.0D) ? var25 : var1.d(this.a, var2, var3, var4 - 1));
/*  264 */       var5.a(var11, var11, var11);
/*  265 */       this.e = (var64 == 2);
/*  266 */       c(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 2));
/*      */     } 
/*      */     
/*  269 */     if (var27 != 3 && (this.f || var1.a(this.a, var2, var3, var4 + 1, 3))) {
/*  270 */       var5.b((var1.ca < 1.0D) ? var25 : var1.d(this.a, var2, var3, var4 + 1));
/*  271 */       var5.a(var11, var11, var11);
/*  272 */       this.e = (var64 == 3);
/*  273 */       d(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 3));
/*      */     } 
/*      */     
/*  276 */     if (var27 != 4 && (this.f || var1.a(this.a, var2 - 1, var3, var4, 4))) {
/*  277 */       var5.b((var1.bX > 0.0D) ? var25 : var1.d(this.a, var2 - 1, var3, var4));
/*  278 */       var5.a(var12, var12, var12);
/*  279 */       this.e = (var64 == 4);
/*  280 */       e(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 4));
/*      */     } 
/*      */     
/*  283 */     if (var27 != 5 && (this.f || var1.a(this.a, var2 + 1, var3, var4, 5))) {
/*  284 */       var5.b((var1.ca < 1.0D) ? var25 : var1.d(this.a, var2 + 1, var3, var4));
/*  285 */       var5.a(var12, var12, var12);
/*  286 */       this.e = (var64 == 5);
/*  287 */       f(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 5));
/*      */     } 
/*      */     
/*  290 */     this.e = false;
/*  291 */     return true;
/*      */   }
/*      */   
/*      */   public boolean a(xc var1, int var2, int var3, int var4) {
/*  295 */     var1.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
/*  296 */     o((pb)var1, var2, var3, var4);
/*  297 */     this.d = 156;
/*  298 */     var1.a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
/*  299 */     o((pb)var1, var2, var3, var4);
/*  300 */     var1.a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
/*  301 */     o((pb)var1, var2, var3, var4);
/*  302 */     var1.a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
/*  303 */     o((pb)var1, var2, var3, var4);
/*  304 */     a();
/*  305 */     adz var5 = adz.a;
/*  306 */     var5.b(var1.d(this.a, var2, var3, var4));
/*  307 */     float var6 = 1.0F;
/*  308 */     int var7 = var1.c(this.a, var2, var3, var4);
/*  309 */     float var8 = (var7 >> 16 & 0xFF) / 255.0F;
/*  310 */     float var9 = (var7 >> 8 & 0xFF) / 255.0F;
/*  311 */     float var10 = (var7 & 0xFF) / 255.0F;
/*  312 */     if (lr.a) {
/*  313 */       float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
/*  314 */       float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
/*  315 */       float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
/*  316 */       var8 = var11;
/*  317 */       var9 = var12;
/*  318 */       var10 = var13;
/*      */     } 
/*      */     
/*  321 */     var5.a(var6 * var8, var6 * var9, var6 * var10);
/*  322 */     int var34 = var1.a(0, 0);
/*  323 */     if (this.d >= 0) {
/*  324 */       var34 = this.d;
/*      */     }
/*      */     
/*  327 */     int var35 = (var34 & 0xF) << 4;
/*  328 */     int var36 = var34 & 0xF0;
/*  329 */     double var14 = (var36 / 256.0F);
/*  330 */     double var16 = ((var36 + 15.99F) / 256.0F);
/*  331 */     int var18 = this.a.e(var2, var3, var4);
/*      */     
/*  333 */     for (int var19 = 0; var19 < 3; var19++) {
/*  334 */       double var20 = var19 * Math.PI * 2.0D / 3.0D + 1.5707963267948966D;
/*  335 */       double var22 = ((var35 + 8.0F) / 256.0F);
/*  336 */       double var24 = ((var35 + 15.99F) / 256.0F);
/*  337 */       if ((var18 & 1 << var19) != 0) {
/*  338 */         var22 = ((var35 + 7.99F) / 256.0F);
/*  339 */         var24 = ((var35 + 0.0F) / 256.0F);
/*      */       } 
/*      */       
/*  342 */       double var26 = var2 + 0.5D;
/*  343 */       double var28 = var2 + 0.5D + Math.sin(var20) * 8.0D / 16.0D;
/*  344 */       double var30 = var4 + 0.5D;
/*  345 */       double var32 = var4 + 0.5D + Math.cos(var20) * 8.0D / 16.0D;
/*  346 */       var5.a(var26, (var3 + 1), var30, var22, var14);
/*  347 */       var5.a(var26, (var3 + 0), var30, var22, var16);
/*  348 */       var5.a(var28, (var3 + 0), var32, var24, var16);
/*  349 */       var5.a(var28, (var3 + 1), var32, var24, var14);
/*  350 */       var5.a(var28, (var3 + 1), var32, var24, var14);
/*  351 */       var5.a(var28, (var3 + 0), var32, var24, var16);
/*  352 */       var5.a(var26, (var3 + 0), var30, var22, var16);
/*  353 */       var5.a(var26, (var3 + 1), var30, var22, var14);
/*      */     } 
/*      */     
/*  356 */     var1.h();
/*  357 */     return true;
/*      */   }
/*      */   
/*      */   public boolean a(xm var1, int var2, int var3, int var4) {
/*  361 */     o((pb)var1, var2, var3, var4);
/*  362 */     adz var5 = adz.a;
/*  363 */     var5.b(var1.d(this.a, var2, var3, var4));
/*  364 */     float var6 = 1.0F;
/*  365 */     int var7 = var1.c(this.a, var2, var3, var4);
/*  366 */     float var8 = (var7 >> 16 & 0xFF) / 255.0F;
/*  367 */     float var9 = (var7 >> 8 & 0xFF) / 255.0F;
/*  368 */     float var10 = (var7 & 0xFF) / 255.0F;
/*      */     
/*  370 */     if (lr.a) {
/*  371 */       float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
/*  372 */       float f1 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
/*  373 */       float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
/*  374 */       var8 = var11;
/*  375 */       var9 = f1;
/*  376 */       var10 = var13;
/*      */     } 
/*      */     
/*  379 */     var5.a(var6 * var8, var6 * var9, var6 * var10);
/*  380 */     short var16 = 154;
/*  381 */     float var12 = 0.125F;
/*  382 */     f((pb)var1, (var2 - 1.0F + var12), var3, var4, var16);
/*  383 */     e((pb)var1, (var2 + 1.0F - var12), var3, var4, var16);
/*  384 */     d((pb)var1, var2, var3, (var4 - 1.0F + var12), var16);
/*  385 */     c((pb)var1, var2, var3, (var4 + 1.0F - var12), var16);
/*  386 */     short var17 = 139;
/*  387 */     b((pb)var1, var2, (var3 - 1.0F + 0.25F), var4, var17);
/*  388 */     a((pb)var1, var2, (var3 + 1.0F - 0.75F), var4, var17);
/*  389 */     int var14 = this.a.e(var2, var3, var4);
/*  390 */     if (var14 > 0) {
/*  391 */       short var15 = 205;
/*  392 */       if (var14 > 3) {
/*  393 */         var14 = 3;
/*      */       }
/*      */       
/*  396 */       b((pb)var1, var2, (var3 - 1.0F + (6.0F + var14 * 3.0F) / 16.0F), var4, var15);
/*      */     } 
/*      */     
/*  399 */     return true;
/*      */   }
/*      */   
/*      */   public boolean c(pb var1, int var2, int var3, int var4) {
/*  403 */     int var5 = this.a.e(var2, var3, var4);
/*  404 */     adz var6 = adz.a;
/*  405 */     var6.b(var1.d(this.a, var2, var3, var4));
/*  406 */     var6.a(1.0F, 1.0F, 1.0F);
/*  407 */     double var7 = 0.4000000059604645D;
/*  408 */     double var9 = 0.5D - var7;
/*  409 */     double var11 = 0.20000000298023224D;
/*  410 */     if (var5 == 1) {
/*  411 */       a(var1, var2 - var9, var3 + var11, var4, -var7, 0.0D);
/*  412 */     } else if (var5 == 2) {
/*  413 */       a(var1, var2 + var9, var3 + var11, var4, var7, 0.0D);
/*  414 */     } else if (var5 == 3) {
/*  415 */       a(var1, var2, var3 + var11, var4 - var9, 0.0D, -var7);
/*  416 */     } else if (var5 == 4) {
/*  417 */       a(var1, var2, var3 + var11, var4 + var9, 0.0D, var7);
/*      */     } else {
/*  419 */       a(var1, var2, var3, var4, 0.0D, 0.0D);
/*      */     } 
/*      */     
/*  422 */     return true;
/*      */   }
/*      */   
/*      */   public boolean u(pb var1, int var2, int var3, int var4) {
/*  426 */     int var5 = this.a.e(var2, var3, var4);
/*  427 */     int var6 = var5 & 0x3;
/*  428 */     int var7 = (var5 & 0xC) >> 2;
/*  429 */     o(var1, var2, var3, var4);
/*  430 */     adz var8 = adz.a;
/*  431 */     var8.b(var1.d(this.a, var2, var3, var4));
/*  432 */     var8.a(1.0F, 1.0F, 1.0F);
/*  433 */     double var9 = -0.1875D;
/*  434 */     double var11 = 0.0D;
/*  435 */     double var13 = 0.0D;
/*  436 */     double var15 = 0.0D;
/*  437 */     double var17 = 0.0D;
/*  438 */     switch (var6) {
/*      */       case 0:
/*  440 */         var17 = -0.3125D;
/*  441 */         var13 = qx.a[var7];
/*      */         break;
/*      */       case 1:
/*  444 */         var15 = 0.3125D;
/*  445 */         var11 = -qx.a[var7];
/*      */         break;
/*      */       case 2:
/*  448 */         var17 = 0.3125D;
/*  449 */         var13 = -qx.a[var7];
/*      */         break;
/*      */       case 3:
/*  452 */         var15 = -0.3125D;
/*  453 */         var11 = qx.a[var7];
/*      */         break;
/*      */     } 
/*  456 */     a(var1, var2 + var11, var3 + var9, var4 + var13, 0.0D, 0.0D);
/*  457 */     a(var1, var2 + var15, var3 + var9, var4 + var17, 0.0D, 0.0D);
/*  458 */     int var19 = var1.a_(1);
/*  459 */     int var20 = (var19 & 0xF) << 4;
/*  460 */     int var21 = var19 & 0xF0;
/*  461 */     double var22 = (var20 / 256.0F);
/*  462 */     double var24 = ((var20 + 15.99F) / 256.0F);
/*  463 */     double var26 = (var21 / 256.0F);
/*  464 */     double var28 = ((var21 + 15.99F) / 256.0F);
/*  465 */     double var30 = 0.125D;
/*  466 */     double var32 = (var2 + 1);
/*  467 */     double var34 = (var2 + 1);
/*  468 */     double var36 = (var2 + 0);
/*  469 */     double var38 = (var2 + 0);
/*  470 */     double var40 = (var4 + 0);
/*  471 */     double var42 = (var4 + 1);
/*  472 */     double var44 = (var4 + 1);
/*  473 */     double var46 = (var4 + 0);
/*  474 */     double var48 = var3 + var30;
/*      */     
/*  476 */     var32 = var34 = (var2 + 0);
/*  477 */     var36 = var38 = (var2 + 1);
/*  478 */     var40 = var46 = (var4 + 1);
/*  479 */     var42 = var44 = (var4 + 0);
/*      */     
/*  481 */     var32 = var38 = (var2 + 0);
/*  482 */     var34 = var36 = (var2 + 1);
/*  483 */     var40 = var42 = (var4 + 0);
/*  484 */     var44 = var46 = (var4 + 1);
/*  485 */     if (var6 == 1) {
/*  486 */       var32 = var38 = (var2 + 1);
/*  487 */       var34 = var36 = (var2 + 0);
/*  488 */       var40 = var42 = (var4 + 1);
/*  489 */       var44 = var46 = (var4 + 0);
/*      */     } 
/*      */     
/*  492 */     var8.a(var38, var48, var46, var22, var26);
/*  493 */     var8.a(var36, var48, var44, var22, var28);
/*  494 */     var8.a(var34, var48, var42, var24, var28);
/*  495 */     var8.a(var32, var48, var40, var24, var26);
/*  496 */     return true;
/*      */   }
/*      */   
/*      */   public void d(pb var1, int var2, int var3, int var4) {
/*  500 */     this.f = true;
/*  501 */     b(var1, var2, var3, var4, true);
/*  502 */     this.f = false;
/*      */   }
/*      */   
/*      */   public boolean b(pb var1, int var2, int var3, int var4, boolean var5) {
/*  506 */     int var6 = this.a.e(var2, var3, var4);
/*  507 */     boolean var7 = !(!var5 && (var6 & 0x8) == 0);
/*  508 */     int var8 = abc.e(var6);
/*  509 */     if (var7) {
/*  510 */       switch (var8) {
/*      */         case 0:
/*  512 */           this.g = 3;
/*  513 */           this.h = 3;
/*  514 */           this.i = 3;
/*  515 */           this.j = 3;
/*  516 */           var1.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
/*      */           break;
/*      */         case 1:
/*  519 */           var1.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
/*      */           break;
/*      */         case 2:
/*  522 */           this.i = 1;
/*  523 */           this.j = 2;
/*  524 */           var1.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
/*      */           break;
/*      */         case 3:
/*  527 */           this.i = 2;
/*  528 */           this.j = 1;
/*  529 */           this.k = 3;
/*  530 */           this.l = 3;
/*  531 */           var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
/*      */           break;
/*      */         case 4:
/*  534 */           this.g = 1;
/*  535 */           this.h = 2;
/*  536 */           this.k = 2;
/*  537 */           this.l = 1;
/*  538 */           var1.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*      */           break;
/*      */         case 5:
/*  541 */           this.g = 2;
/*  542 */           this.h = 1;
/*  543 */           this.k = 1;
/*  544 */           this.l = 2;
/*  545 */           var1.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
/*      */           break;
/*      */       } 
/*  548 */       o(var1, var2, var3, var4);
/*  549 */       this.g = 0;
/*  550 */       this.h = 0;
/*  551 */       this.i = 0;
/*  552 */       this.j = 0;
/*  553 */       this.k = 0;
/*  554 */       this.l = 0;
/*  555 */       var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*      */     } else {
/*  557 */       switch (var8) {
/*      */         case 0:
/*  559 */           this.g = 3;
/*  560 */           this.h = 3;
/*  561 */           this.i = 3;
/*  562 */           this.j = 3;
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/*  567 */           this.i = 1;
/*  568 */           this.j = 2;
/*      */           break;
/*      */         case 3:
/*  571 */           this.i = 2;
/*  572 */           this.j = 1;
/*  573 */           this.k = 3;
/*  574 */           this.l = 3;
/*      */           break;
/*      */         case 4:
/*  577 */           this.g = 1;
/*  578 */           this.h = 2;
/*  579 */           this.k = 2;
/*  580 */           this.l = 1;
/*      */           break;
/*      */         case 5:
/*  583 */           this.g = 2;
/*  584 */           this.h = 1;
/*  585 */           this.k = 1;
/*  586 */           this.l = 2;
/*      */           break;
/*      */       } 
/*  589 */       o(var1, var2, var3, var4);
/*  590 */       this.g = 0;
/*  591 */       this.h = 0;
/*  592 */       this.i = 0;
/*  593 */       this.j = 0;
/*  594 */       this.k = 0;
/*  595 */       this.l = 0;
/*      */     } 
/*      */     
/*  598 */     return true;
/*      */   }
/*      */   
/*      */   public void a(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
/*  602 */     int var16 = 108;
/*  603 */     if (this.d >= 0) {
/*  604 */       var16 = this.d;
/*      */     }
/*      */     
/*  607 */     int var17 = (var16 & 0xF) << 4;
/*  608 */     int var18 = var16 & 0xF0;
/*  609 */     adz var19 = adz.a;
/*  610 */     double var20 = ((var17 + 0) / 256.0F);
/*  611 */     double var22 = ((var18 + 0) / 256.0F);
/*  612 */     double var24 = (var17 + var14 - 0.01D) / 256.0D;
/*  613 */     double var26 = ((var18 + 4.0F) - 0.01D) / 256.0D;
/*  614 */     var19.a(var13, var13, var13);
/*  615 */     var19.a(var1, var7, var9, var24, var22);
/*  616 */     var19.a(var1, var5, var9, var20, var22);
/*  617 */     var19.a(var3, var5, var11, var20, var26);
/*  618 */     var19.a(var3, var7, var11, var24, var26);
/*      */   }
/*      */   
/*      */   public void b(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
/*  622 */     int var16 = 108;
/*  623 */     if (this.d >= 0) {
/*  624 */       var16 = this.d;
/*      */     }
/*      */     
/*  627 */     int var17 = (var16 & 0xF) << 4;
/*  628 */     int var18 = var16 & 0xF0;
/*  629 */     adz var19 = adz.a;
/*  630 */     double var20 = ((var17 + 0) / 256.0F);
/*  631 */     double var22 = ((var18 + 0) / 256.0F);
/*  632 */     double var24 = (var17 + var14 - 0.01D) / 256.0D;
/*  633 */     double var26 = ((var18 + 4.0F) - 0.01D) / 256.0D;
/*  634 */     var19.a(var13, var13, var13);
/*  635 */     var19.a(var1, var5, var11, var24, var22);
/*  636 */     var19.a(var1, var5, var9, var20, var22);
/*  637 */     var19.a(var3, var7, var9, var20, var26);
/*  638 */     var19.a(var3, var7, var11, var24, var26);
/*      */   }
/*      */   
/*      */   public void c(double var1, double var3, double var5, double var7, double var9, double var11, float var13, double var14) {
/*  642 */     int var16 = 108;
/*  643 */     if (this.d >= 0) {
/*  644 */       var16 = this.d;
/*      */     }
/*      */     
/*  647 */     int var17 = (var16 & 0xF) << 4;
/*  648 */     int var18 = var16 & 0xF0;
/*  649 */     adz var19 = adz.a;
/*  650 */     double var20 = ((var17 + 0) / 256.0F);
/*  651 */     double var22 = ((var18 + 0) / 256.0F);
/*  652 */     double var24 = (var17 + var14 - 0.01D) / 256.0D;
/*  653 */     double var26 = ((var18 + 4.0F) - 0.01D) / 256.0D;
/*  654 */     var19.a(var13, var13, var13);
/*  655 */     var19.a(var3, var5, var9, var24, var22);
/*  656 */     var19.a(var1, var5, var9, var20, var22);
/*  657 */     var19.a(var1, var7, var11, var20, var26);
/*  658 */     var19.a(var3, var7, var11, var24, var26);
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, int var3, int var4, boolean var5) {
/*  662 */     this.f = true;
/*  663 */     c(var1, var2, var3, var4, var5);
/*  664 */     this.f = false;
/*      */   }
/*      */   
/*      */   public boolean c(pb var1, int var2, int var3, int var4, boolean var5) {
/*  668 */     int var6 = this.a.e(var2, var3, var4);
/*  669 */     int var7 = sq.h(var6);
/*  670 */     float var11 = var1.e(this.a, var2, var3, var4);
/*  671 */     float var12 = var5 ? 1.0F : 0.5F;
/*  672 */     double var13 = var5 ? 16.0D : 8.0D;
/*  673 */     switch (var7) {
/*      */       case 0:
/*  675 */         this.g = 3;
/*  676 */         this.h = 3;
/*  677 */         this.i = 3;
/*  678 */         this.j = 3;
/*  679 */         var1.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
/*  680 */         o(var1, var2, var3, var4);
/*  681 */         a((var2 + 0.375F), (var2 + 0.625F), (var3 + 0.25F), (var3 + 0.25F + var12), (
/*  682 */             var4 + 0.625F), (var4 + 0.625F), var11 * 0.8F, var13);
/*  683 */         a((var2 + 0.625F), (var2 + 0.375F), (var3 + 0.25F), (var3 + 0.25F + var12), (
/*  684 */             var4 + 0.375F), (var4 + 0.375F), var11 * 0.8F, var13);
/*  685 */         a((var2 + 0.375F), (var2 + 0.375F), (var3 + 0.25F), (var3 + 0.25F + var12), (
/*  686 */             var4 + 0.375F), (var4 + 0.625F), var11 * 0.6F, var13);
/*  687 */         a((var2 + 0.625F), (var2 + 0.625F), (var3 + 0.25F), (var3 + 0.25F + var12), (
/*  688 */             var4 + 0.625F), (var4 + 0.375F), var11 * 0.6F, var13);
/*      */         break;
/*      */       case 1:
/*  691 */         var1.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  692 */         o(var1, var2, var3, var4);
/*  693 */         a((var2 + 0.375F), (var2 + 0.625F), (var3 - 0.25F + 1.0F - var12), (
/*  694 */             var3 - 0.25F + 1.0F), (var4 + 0.625F), (var4 + 0.625F), var11 * 0.8F, var13);
/*  695 */         a((var2 + 0.625F), (var2 + 0.375F), (var3 - 0.25F + 1.0F - var12), (
/*  696 */             var3 - 0.25F + 1.0F), (var4 + 0.375F), (var4 + 0.375F), var11 * 0.8F, var13);
/*  697 */         a((var2 + 0.375F), (var2 + 0.375F), (var3 - 0.25F + 1.0F - var12), (
/*  698 */             var3 - 0.25F + 1.0F), (var4 + 0.375F), (var4 + 0.625F), var11 * 0.6F, var13);
/*  699 */         a((var2 + 0.625F), (var2 + 0.625F), (var3 - 0.25F + 1.0F - var12), (
/*  700 */             var3 - 0.25F + 1.0F), (var4 + 0.625F), (var4 + 0.375F), var11 * 0.6F, var13);
/*      */         break;
/*      */       case 2:
/*  703 */         this.i = 1;
/*  704 */         this.j = 2;
/*  705 */         var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
/*  706 */         o(var1, var2, var3, var4);
/*  707 */         b((var2 + 0.375F), (var2 + 0.375F), (var3 + 0.625F), (var3 + 0.375F), (
/*  708 */             var4 + 0.25F), (var4 + 0.25F + var12), var11 * 0.6F, var13);
/*  709 */         b((var2 + 0.625F), (var2 + 0.625F), (var3 + 0.375F), (var3 + 0.625F), (
/*  710 */             var4 + 0.25F), (var4 + 0.25F + var12), var11 * 0.6F, var13);
/*  711 */         b((var2 + 0.375F), (var2 + 0.625F), (var3 + 0.375F), (var3 + 0.375F), (
/*  712 */             var4 + 0.25F), (var4 + 0.25F + var12), var11 * 0.5F, var13);
/*  713 */         b((var2 + 0.625F), (var2 + 0.375F), (var3 + 0.625F), (var3 + 0.625F), (
/*  714 */             var4 + 0.25F), (var4 + 0.25F + var12), var11, var13);
/*      */         break;
/*      */       case 3:
/*  717 */         this.i = 2;
/*  718 */         this.j = 1;
/*  719 */         this.k = 3;
/*  720 */         this.l = 3;
/*  721 */         var1.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
/*  722 */         o(var1, var2, var3, var4);
/*  723 */         b((var2 + 0.375F), (var2 + 0.375F), (var3 + 0.625F), (var3 + 0.375F), (
/*  724 */             var4 - 0.25F + 1.0F - var12), (var4 - 0.25F + 1.0F), var11 * 0.6F, var13);
/*  725 */         b((var2 + 0.625F), (var2 + 0.625F), (var3 + 0.375F), (var3 + 0.625F), (
/*  726 */             var4 - 0.25F + 1.0F - var12), (var4 - 0.25F + 1.0F), var11 * 0.6F, var13);
/*  727 */         b((var2 + 0.375F), (var2 + 0.625F), (var3 + 0.375F), (var3 + 0.375F), (
/*  728 */             var4 - 0.25F + 1.0F - var12), (var4 - 0.25F + 1.0F), var11 * 0.5F, var13);
/*  729 */         b((var2 + 0.625F), (var2 + 0.375F), (var3 + 0.625F), (var3 + 0.625F), (
/*  730 */             var4 - 0.25F + 1.0F - var12), (var4 - 0.25F + 1.0F), var11, var13);
/*      */         break;
/*      */       case 4:
/*  733 */         this.g = 1;
/*  734 */         this.h = 2;
/*  735 */         this.k = 2;
/*  736 */         this.l = 1;
/*  737 */         var1.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
/*  738 */         o(var1, var2, var3, var4);
/*  739 */         c((var2 + 0.25F), (var2 + 0.25F + var12), (var3 + 0.375F), (var3 + 0.375F), (
/*  740 */             var4 + 0.625F), (var4 + 0.375F), var11 * 0.5F, var13);
/*  741 */         c((var2 + 0.25F), (var2 + 0.25F + var12), (var3 + 0.625F), (var3 + 0.625F), (
/*  742 */             var4 + 0.375F), (var4 + 0.625F), var11, var13);
/*  743 */         c((var2 + 0.25F), (var2 + 0.25F + var12), (var3 + 0.375F), (var3 + 0.625F), (
/*  744 */             var4 + 0.375F), (var4 + 0.375F), var11 * 0.6F, var13);
/*  745 */         c((var2 + 0.25F), (var2 + 0.25F + var12), (var3 + 0.625F), (var3 + 0.375F), (
/*  746 */             var4 + 0.625F), (var4 + 0.625F), var11 * 0.6F, var13);
/*      */         break;
/*      */       case 5:
/*  749 */         this.g = 2;
/*  750 */         this.h = 1;
/*  751 */         this.k = 1;
/*  752 */         this.l = 2;
/*  753 */         var1.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  754 */         o(var1, var2, var3, var4);
/*  755 */         c((var2 - 0.25F + 1.0F - var12), (var2 - 0.25F + 1.0F), (var3 + 0.375F), (
/*  756 */             var3 + 0.375F), (var4 + 0.625F), (var4 + 0.375F), var11 * 0.5F, var13);
/*  757 */         c((var2 - 0.25F + 1.0F - var12), (var2 - 0.25F + 1.0F), (var3 + 0.625F), (
/*  758 */             var3 + 0.625F), (var4 + 0.375F), (var4 + 0.625F), var11, var13);
/*  759 */         c((var2 - 0.25F + 1.0F - var12), (var2 - 0.25F + 1.0F), (var3 + 0.375F), (
/*  760 */             var3 + 0.625F), (var4 + 0.375F), (var4 + 0.375F), var11 * 0.6F, var13);
/*  761 */         c((var2 - 0.25F + 1.0F - var12), (var2 - 0.25F + 1.0F), (var3 + 0.625F), (
/*  762 */             var3 + 0.375F), (var4 + 0.625F), (var4 + 0.625F), var11 * 0.6F, var13);
/*      */         break;
/*      */     } 
/*  765 */     this.g = 0;
/*  766 */     this.h = 0;
/*  767 */     this.i = 0;
/*  768 */     this.j = 0;
/*  769 */     this.k = 0;
/*  770 */     this.l = 0;
/*  771 */     var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  772 */     return true;
/*      */   }
/*      */   
/*      */   public boolean e(pb var1, int var2, int var3, int var4) {
/*  776 */     int var5 = this.a.e(var2, var3, var4);
/*  777 */     int var6 = var5 & 0x7;
/*  778 */     boolean var7 = ((var5 & 0x8) > 0);
/*  779 */     adz var8 = adz.a;
/*  780 */     boolean var9 = (this.d >= 0);
/*  781 */     if (!var9) {
/*  782 */       this.d = pb.w.bN;
/*      */     }
/*      */     
/*  785 */     float var10 = 0.25F;
/*  786 */     float var11 = 0.1875F;
/*  787 */     float var12 = 0.1875F;
/*  788 */     if (var6 == 5) {
/*  789 */       var1.a(0.5F - var11, 0.0F, 0.5F - var10, 0.5F + var11, var12, 0.5F + var10);
/*  790 */     } else if (var6 == 6) {
/*  791 */       var1.a(0.5F - var10, 0.0F, 0.5F - var11, 0.5F + var10, var12, 0.5F + var11);
/*  792 */     } else if (var6 == 4) {
/*  793 */       var1.a(0.5F - var11, 0.5F - var10, 1.0F - var12, 0.5F + var11, 0.5F + var10, 1.0F);
/*  794 */     } else if (var6 == 3) {
/*  795 */       var1.a(0.5F - var11, 0.5F - var10, 0.0F, 0.5F + var11, 0.5F + var10, var12);
/*  796 */     } else if (var6 == 2) {
/*  797 */       var1.a(1.0F - var12, 0.5F - var10, 0.5F - var11, 1.0F, 0.5F + var10, 0.5F + var11);
/*  798 */     } else if (var6 == 1) {
/*  799 */       var1.a(0.0F, 0.5F - var10, 0.5F - var11, var12, 0.5F + var10, 0.5F + var11);
/*      */     } 
/*      */     
/*  802 */     o(var1, var2, var3, var4);
/*  803 */     if (!var9) {
/*  804 */       this.d = -1;
/*      */     }
/*      */     
/*  807 */     var8.b(var1.d(this.a, var2, var3, var4));
/*  808 */     float var13 = 1.0F;
/*  809 */     if (pb.q[var1.bO] > 0) {
/*  810 */       var13 = 1.0F;
/*      */     }
/*      */     
/*  813 */     var8.a(var13, var13, var13);
/*  814 */     int var14 = var1.a_(0);
/*  815 */     if (this.d >= 0) {
/*  816 */       var14 = this.d;
/*      */     }
/*      */     
/*  819 */     int var15 = (var14 & 0xF) << 4;
/*  820 */     int var16 = var14 & 0xF0;
/*  821 */     float var17 = var15 / 256.0F;
/*  822 */     float var18 = (var15 + 15.99F) / 256.0F;
/*  823 */     float var19 = var16 / 256.0F;
/*  824 */     float var20 = (var16 + 15.99F) / 256.0F;
/*  825 */     bo[] var21 = new bo[8];
/*  826 */     float var22 = 0.0625F;
/*  827 */     float var23 = 0.0625F;
/*  828 */     float var24 = 0.625F;
/*  829 */     var21[0] = bo.b(-var22, 0.0D, -var23);
/*  830 */     var21[1] = bo.b(var22, 0.0D, -var23);
/*  831 */     var21[2] = bo.b(var22, 0.0D, var23);
/*  832 */     var21[3] = bo.b(-var22, 0.0D, var23);
/*  833 */     var21[4] = bo.b(-var22, var24, -var23);
/*  834 */     var21[5] = bo.b(var22, var24, -var23);
/*  835 */     var21[6] = bo.b(var22, var24, var23);
/*  836 */     var21[7] = bo.b(-var22, var24, var23);
/*      */     
/*  838 */     for (int var25 = 0; var25 < 8; var25++) {
/*  839 */       if (var7) {
/*  840 */         (var21[var25]).c -= 0.0625D;
/*  841 */         var21[var25].a(0.69813174F);
/*      */       } else {
/*  843 */         (var21[var25]).c += 0.0625D;
/*  844 */         var21[var25].a(-0.69813174F);
/*      */       } 
/*      */       
/*  847 */       if (var6 == 6) {
/*  848 */         var21[var25].b(1.5707964F);
/*      */       }
/*      */       
/*  851 */       if (var6 < 5) {
/*  852 */         (var21[var25]).b -= 0.375D;
/*  853 */         var21[var25].a(1.5707964F);
/*  854 */         if (var6 == 4) {
/*  855 */           var21[var25].b(0.0F);
/*      */         }
/*      */         
/*  858 */         if (var6 == 3) {
/*  859 */           var21[var25].b(3.1415927F);
/*      */         }
/*      */         
/*  862 */         if (var6 == 2) {
/*  863 */           var21[var25].b(1.5707964F);
/*      */         }
/*      */         
/*  866 */         if (var6 == 1) {
/*  867 */           var21[var25].b(-1.5707964F);
/*      */         }
/*      */         
/*  870 */         (var21[var25]).a += var2 + 0.5D;
/*  871 */         (var21[var25]).b += (var3 + 0.5F);
/*  872 */         (var21[var25]).c += var4 + 0.5D;
/*      */       } else {
/*  874 */         (var21[var25]).a += var2 + 0.5D;
/*  875 */         (var21[var25]).b += (var3 + 0.125F);
/*  876 */         (var21[var25]).c += var4 + 0.5D;
/*      */       } 
/*      */     } 
/*      */     
/*  880 */     bo var30 = null;
/*  881 */     bo var26 = null;
/*  882 */     bo var27 = null;
/*  883 */     bo var28 = null;
/*      */     
/*  885 */     for (int var29 = 0; var29 < 6; var29++) {
/*  886 */       if (var29 == 0) {
/*  887 */         var17 = (var15 + 7) / 256.0F;
/*  888 */         var18 = ((var15 + 9) - 0.01F) / 256.0F;
/*  889 */         var19 = (var16 + 6) / 256.0F;
/*  890 */         var20 = ((var16 + 8) - 0.01F) / 256.0F;
/*  891 */       } else if (var29 == 2) {
/*  892 */         var17 = (var15 + 7) / 256.0F;
/*  893 */         var18 = ((var15 + 9) - 0.01F) / 256.0F;
/*  894 */         var19 = (var16 + 6) / 256.0F;
/*  895 */         var20 = ((var16 + 16) - 0.01F) / 256.0F;
/*      */       } 
/*      */       
/*  898 */       if (var29 == 0) {
/*  899 */         var30 = var21[0];
/*  900 */         var26 = var21[1];
/*  901 */         var27 = var21[2];
/*  902 */         var28 = var21[3];
/*  903 */       } else if (var29 == 1) {
/*  904 */         var30 = var21[7];
/*  905 */         var26 = var21[6];
/*  906 */         var27 = var21[5];
/*  907 */         var28 = var21[4];
/*  908 */       } else if (var29 == 2) {
/*  909 */         var30 = var21[1];
/*  910 */         var26 = var21[0];
/*  911 */         var27 = var21[4];
/*  912 */         var28 = var21[5];
/*  913 */       } else if (var29 == 3) {
/*  914 */         var30 = var21[2];
/*  915 */         var26 = var21[1];
/*  916 */         var27 = var21[5];
/*  917 */         var28 = var21[6];
/*  918 */       } else if (var29 == 4) {
/*  919 */         var30 = var21[3];
/*  920 */         var26 = var21[2];
/*  921 */         var27 = var21[6];
/*  922 */         var28 = var21[7];
/*  923 */       } else if (var29 == 5) {
/*  924 */         var30 = var21[0];
/*  925 */         var26 = var21[3];
/*  926 */         var27 = var21[7];
/*  927 */         var28 = var21[4];
/*      */       } 
/*      */       
/*  930 */       var8.a(var30.a, var30.b, var30.c, var17, var20);
/*  931 */       var8.a(var26.a, var26.b, var26.c, var18, var20);
/*  932 */       var8.a(var27.a, var27.b, var27.c, var18, var19);
/*  933 */       var8.a(var28.a, var28.b, var28.c, var17, var19);
/*      */     } 
/*      */     
/*  936 */     return true;
/*      */   }
/*      */   
/*      */   public boolean f(pb var1, int var2, int var3, int var4) {
/*  940 */     adz var5 = adz.a;
/*  941 */     int var6 = var1.a_(0);
/*  942 */     if (this.d >= 0) {
/*  943 */       var6 = this.d;
/*      */     }
/*      */     
/*  946 */     var5.a(1.0F, 1.0F, 1.0F);
/*  947 */     var5.b(var1.d(this.a, var2, var3, var4));
/*  948 */     int var7 = (var6 & 0xF) << 4;
/*  949 */     int var8 = var6 & 0xF0;
/*  950 */     double var9 = (var7 / 256.0F);
/*  951 */     double var11 = ((var7 + 15.99F) / 256.0F);
/*  952 */     double var13 = (var8 / 256.0F);
/*  953 */     double var15 = ((var8 + 15.99F) / 256.0F);
/*  954 */     float var17 = 1.4F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  962 */     if (!this.a.h(var2, var3 - 1, var4) && !pb.ar.g(this.a, var2, var3 - 1, var4)) {
/*  963 */       float var36 = 0.2F;
/*  964 */       float var19 = 0.0625F;
/*  965 */       if ((var2 + var3 + var4 & 0x1) == 1) {
/*  966 */         var9 = (var7 / 256.0F);
/*  967 */         var11 = ((var7 + 15.99F) / 256.0F);
/*  968 */         var13 = ((var8 + 16) / 256.0F);
/*  969 */         var15 = ((var8 + 15.99F + 16.0F) / 256.0F);
/*      */       } 
/*      */       
/*  972 */       if ((var2 / 2 + var3 / 2 + var4 / 2 & 0x1) == 1) {
/*  973 */         double var20 = var11;
/*  974 */         var11 = var9;
/*  975 */         var9 = var20;
/*      */       } 
/*      */       
/*  978 */       if (pb.ar.g(this.a, var2 - 1, var3, var4)) {
/*  979 */         var5.a((var2 + var36), (var3 + var17 + var19), (var4 + 1), var11, var13);
/*  980 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 1), var11, var15);
/*  981 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/*  982 */         var5.a((var2 + var36), (var3 + var17 + var19), (var4 + 0), var9, var13);
/*  983 */         var5.a((var2 + var36), (var3 + var17 + var19), (var4 + 0), var9, var13);
/*  984 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/*  985 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 1), var11, var15);
/*  986 */         var5.a((var2 + var36), (var3 + var17 + var19), (var4 + 1), var11, var13);
/*      */       } 
/*      */       
/*  989 */       if (pb.ar.g(this.a, var2 + 1, var3, var4)) {
/*  990 */         var5.a(((var2 + 1) - var36), (var3 + var17 + var19), (var4 + 0), var9, var13);
/*  991 */         var5.a((var2 + 1 - 0), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/*  992 */         var5.a((var2 + 1 - 0), ((var3 + 0) + var19), (var4 + 1), var11, var15);
/*  993 */         var5.a(((var2 + 1) - var36), (var3 + var17 + var19), (var4 + 1), var11, var13);
/*  994 */         var5.a(((var2 + 1) - var36), (var3 + var17 + var19), (var4 + 1), var11, var13);
/*  995 */         var5.a((var2 + 1 - 0), ((var3 + 0) + var19), (var4 + 1), var11, var15);
/*  996 */         var5.a((var2 + 1 - 0), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/*  997 */         var5.a(((var2 + 1) - var36), (var3 + var17 + var19), (var4 + 0), var9, var13);
/*      */       } 
/*      */       
/* 1000 */       if (pb.ar.g(this.a, var2, var3, var4 - 1)) {
/* 1001 */         var5.a((var2 + 0), (var3 + var17 + var19), (var4 + var36), var11, var13);
/* 1002 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 0), var11, var15);
/* 1003 */         var5.a((var2 + 1), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/* 1004 */         var5.a((var2 + 1), (var3 + var17 + var19), (var4 + var36), var9, var13);
/* 1005 */         var5.a((var2 + 1), (var3 + var17 + var19), (var4 + var36), var9, var13);
/* 1006 */         var5.a((var2 + 1), ((var3 + 0) + var19), (var4 + 0), var9, var15);
/* 1007 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 0), var11, var15);
/* 1008 */         var5.a((var2 + 0), (var3 + var17 + var19), (var4 + var36), var11, var13);
/*      */       } 
/*      */       
/* 1011 */       if (pb.ar.g(this.a, var2, var3, var4 + 1)) {
/* 1012 */         var5.a((var2 + 1), (var3 + var17 + var19), ((var4 + 1) - var36), var9, var13);
/* 1013 */         var5.a((var2 + 1), ((var3 + 0) + var19), (var4 + 1 - 0), var9, var15);
/* 1014 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 1 - 0), var11, var15);
/* 1015 */         var5.a((var2 + 0), (var3 + var17 + var19), ((var4 + 1) - var36), var11, var13);
/* 1016 */         var5.a((var2 + 0), (var3 + var17 + var19), ((var4 + 1) - var36), var11, var13);
/* 1017 */         var5.a((var2 + 0), ((var3 + 0) + var19), (var4 + 1 - 0), var11, var15);
/* 1018 */         var5.a((var2 + 1), ((var3 + 0) + var19), (var4 + 1 - 0), var9, var15);
/* 1019 */         var5.a((var2 + 1), (var3 + var17 + var19), ((var4 + 1) - var36), var9, var13);
/*      */       } 
/*      */       
/* 1022 */       if (pb.ar.g(this.a, var2, var3 + 1, var4)) {
/* 1023 */         double var20 = var2 + 0.5D + 0.5D;
/* 1024 */         double var22 = var2 + 0.5D - 0.5D;
/* 1025 */         double var24 = var4 + 0.5D + 0.5D;
/* 1026 */         double var26 = var4 + 0.5D - 0.5D;
/* 1027 */         double var28 = var2 + 0.5D - 0.5D;
/* 1028 */         double var30 = var2 + 0.5D + 0.5D;
/* 1029 */         double var32 = var4 + 0.5D - 0.5D;
/* 1030 */         double var34 = var4 + 0.5D + 0.5D;
/* 1031 */         var9 = (var7 / 256.0F);
/* 1032 */         var11 = ((var7 + 15.99F) / 256.0F);
/* 1033 */         var13 = (var8 / 256.0F);
/* 1034 */         var15 = ((var8 + 15.99F) / 256.0F);
/* 1035 */         var3++;
/* 1036 */         var17 = -0.2F;
/* 1037 */         if ((var2 + var3 + var4 & 0x1) == 0) {
/* 1038 */           var5.a(var28, (var3 + var17), (var4 + 0), var11, var13);
/* 1039 */           var5.a(var20, (var3 + 0), (var4 + 0), var11, var15);
/* 1040 */           var5.a(var20, (var3 + 0), (var4 + 1), var9, var15);
/* 1041 */           var5.a(var28, (var3 + var17), (var4 + 1), var9, var13);
/* 1042 */           var9 = (var7 / 256.0F);
/* 1043 */           var11 = ((var7 + 15.99F) / 256.0F);
/* 1044 */           var13 = ((var8 + 16) / 256.0F);
/* 1045 */           var15 = ((var8 + 15.99F + 16.0F) / 256.0F);
/* 1046 */           var5.a(var30, (var3 + var17), (var4 + 1), var11, var13);
/* 1047 */           var5.a(var22, (var3 + 0), (var4 + 1), var11, var15);
/* 1048 */           var5.a(var22, (var3 + 0), (var4 + 0), var9, var15);
/* 1049 */           var5.a(var30, (var3 + var17), (var4 + 0), var9, var13);
/*      */         } else {
/* 1051 */           var5.a((var2 + 0), (var3 + var17), var34, var11, var13);
/* 1052 */           var5.a((var2 + 0), (var3 + 0), var26, var11, var15);
/* 1053 */           var5.a((var2 + 1), (var3 + 0), var26, var9, var15);
/* 1054 */           var5.a((var2 + 1), (var3 + var17), var34, var9, var13);
/* 1055 */           var9 = (var7 / 256.0F);
/* 1056 */           var11 = ((var7 + 15.99F) / 256.0F);
/* 1057 */           var13 = ((var8 + 16) / 256.0F);
/* 1058 */           var15 = ((var8 + 15.99F + 16.0F) / 256.0F);
/* 1059 */           var5.a((var2 + 1), (var3 + var17), var32, var11, var13);
/* 1060 */           var5.a((var2 + 1), (var3 + 0), var24, var11, var15);
/* 1061 */           var5.a((var2 + 0), (var3 + 0), var24, var9, var15);
/* 1062 */           var5.a((var2 + 0), (var3 + var17), var32, var9, var13);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1066 */       double var18 = var2 + 0.5D + 0.2D;
/* 1067 */       double var20 = var2 + 0.5D - 0.2D;
/* 1068 */       double var22 = var4 + 0.5D + 0.2D;
/* 1069 */       double var24 = var4 + 0.5D - 0.2D;
/* 1070 */       double var26 = var2 + 0.5D - 0.3D;
/* 1071 */       double var28 = var2 + 0.5D + 0.3D;
/* 1072 */       double var30 = var4 + 0.5D - 0.3D;
/* 1073 */       double var32 = var4 + 0.5D + 0.3D;
/* 1074 */       var5.a(var26, (var3 + var17), (var4 + 1), var11, var13);
/* 1075 */       var5.a(var18, (var3 + 0), (var4 + 1), var11, var15);
/* 1076 */       var5.a(var18, (var3 + 0), (var4 + 0), var9, var15);
/* 1077 */       var5.a(var26, (var3 + var17), (var4 + 0), var9, var13);
/* 1078 */       var5.a(var28, (var3 + var17), (var4 + 0), var11, var13);
/* 1079 */       var5.a(var20, (var3 + 0), (var4 + 0), var11, var15);
/* 1080 */       var5.a(var20, (var3 + 0), (var4 + 1), var9, var15);
/* 1081 */       var5.a(var28, (var3 + var17), (var4 + 1), var9, var13);
/* 1082 */       var9 = (var7 / 256.0F);
/* 1083 */       var11 = ((var7 + 15.99F) / 256.0F);
/* 1084 */       var13 = ((var8 + 16) / 256.0F);
/* 1085 */       var15 = ((var8 + 15.99F + 16.0F) / 256.0F);
/* 1086 */       var5.a((var2 + 1), (var3 + var17), var32, var11, var13);
/* 1087 */       var5.a((var2 + 1), (var3 + 0), var24, var11, var15);
/* 1088 */       var5.a((var2 + 0), (var3 + 0), var24, var9, var15);
/* 1089 */       var5.a((var2 + 0), (var3 + var17), var32, var9, var13);
/* 1090 */       var5.a((var2 + 0), (var3 + var17), var30, var11, var13);
/* 1091 */       var5.a((var2 + 0), (var3 + 0), var22, var11, var15);
/* 1092 */       var5.a((var2 + 1), (var3 + 0), var22, var9, var15);
/* 1093 */       var5.a((var2 + 1), (var3 + var17), var30, var9, var13);
/* 1094 */       var18 = var2 + 0.5D - 0.5D;
/* 1095 */       var20 = var2 + 0.5D + 0.5D;
/* 1096 */       var22 = var4 + 0.5D - 0.5D;
/* 1097 */       var24 = var4 + 0.5D + 0.5D;
/* 1098 */       var26 = var2 + 0.5D - 0.4D;
/* 1099 */       var28 = var2 + 0.5D + 0.4D;
/* 1100 */       var30 = var4 + 0.5D - 0.4D;
/* 1101 */       var32 = var4 + 0.5D + 0.4D;
/* 1102 */       var5.a(var26, (var3 + var17), (var4 + 0), var9, var13);
/* 1103 */       var5.a(var18, (var3 + 0), (var4 + 0), var9, var15);
/* 1104 */       var5.a(var18, (var3 + 0), (var4 + 1), var11, var15);
/* 1105 */       var5.a(var26, (var3 + var17), (var4 + 1), var11, var13);
/* 1106 */       var5.a(var28, (var3 + var17), (var4 + 1), var9, var13);
/* 1107 */       var5.a(var20, (var3 + 0), (var4 + 1), var9, var15);
/* 1108 */       var5.a(var20, (var3 + 0), (var4 + 0), var11, var15);
/* 1109 */       var5.a(var28, (var3 + var17), (var4 + 0), var11, var13);
/* 1110 */       var9 = (var7 / 256.0F);
/* 1111 */       var11 = ((var7 + 15.99F) / 256.0F);
/* 1112 */       var13 = (var8 / 256.0F);
/* 1113 */       var15 = ((var8 + 15.99F) / 256.0F);
/* 1114 */       var5.a((var2 + 0), (var3 + var17), var32, var9, var13);
/* 1115 */       var5.a((var2 + 0), (var3 + 0), var24, var9, var15);
/* 1116 */       var5.a((var2 + 1), (var3 + 0), var24, var11, var15);
/* 1117 */       var5.a((var2 + 1), (var3 + var17), var32, var11, var13);
/* 1118 */       var5.a((var2 + 1), (var3 + var17), var30, var9, var13);
/* 1119 */       var5.a((var2 + 1), (var3 + 0), var22, var9, var15);
/* 1120 */       var5.a((var2 + 0), (var3 + 0), var22, var11, var15);
/* 1121 */       var5.a((var2 + 0), (var3 + var17), var30, var11, var13);
/*      */     } 
/*      */     
/* 1124 */     return true;
/*      */   }
/*      */   
/*      */   public boolean g(pb var1, int var2, int var3, int var4) {
/* 1128 */     adz var5 = adz.a;
/* 1129 */     int var6 = this.a.e(var2, var3, var4);
/* 1130 */     int var7 = var1.a(1, var6);
/* 1131 */     if (this.d >= 0) {
/* 1132 */       var7 = this.d;
/*      */     }
/*      */     
/* 1135 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1136 */     float var8 = 1.0F;
/* 1137 */     float var9 = var6 / 15.0F;
/* 1138 */     float var10 = var9 * 0.6F + 0.4F;
/* 1139 */     if (var6 == 0) {
/* 1140 */       var10 = 0.3F;
/*      */     }
/*      */     
/* 1143 */     float var11 = var9 * var9 * 0.7F - 0.5F;
/* 1144 */     float var12 = var9 * var9 * 0.6F - 0.7F;
/* 1145 */     if (var11 < 0.0F) {
/* 1146 */       var11 = 0.0F;
/*      */     }
/*      */     
/* 1149 */     if (var12 < 0.0F) {
/* 1150 */       var12 = 0.0F;
/*      */     }
/*      */     
/* 1153 */     var5.a(var10, var11, var12);
/* 1154 */     int var13 = (var7 & 0xF) << 4;
/* 1155 */     int var14 = var7 & 0xF0;
/* 1156 */     double var15 = (var13 / 256.0F);
/* 1157 */     double var17 = ((var13 + 15.99F) / 256.0F);
/* 1158 */     double var19 = (var14 / 256.0F);
/* 1159 */     double var21 = ((var14 + 15.99F) / 256.0F);
/* 1160 */     boolean var29 = !(!ahi.e(this.a, var2 - 1, var3, var4, 1) && (this.a.h(var2 - 1, var3, var4) || !ahi.e(this.a, var2 - 1, var3 - 1, var4, -1)));
/* 1161 */     boolean var30 = !(!ahi.e(this.a, var2 + 1, var3, var4, 3) && (this.a.h(var2 + 1, var3, var4) || !ahi.e(this.a, var2 + 1, var3 - 1, var4, -1)));
/* 1162 */     boolean var31 = !(!ahi.e(this.a, var2, var3, var4 - 1, 2) && (this.a.h(var2, var3, var4 - 1) || !ahi.e(this.a, var2, var3 - 1, var4 - 1, -1)));
/* 1163 */     boolean var32 = !(!ahi.e(this.a, var2, var3, var4 + 1, 0) && (this.a.h(var2, var3, var4 + 1) || !ahi.e(this.a, var2, var3 - 1, var4 + 1, -1)));
/* 1164 */     if (!this.a.h(var2, var3 + 1, var4)) {
/* 1165 */       if (this.a.h(var2 - 1, var3, var4) && ahi.e(this.a, var2 - 1, var3 + 1, var4, -1)) {
/* 1166 */         var29 = true;
/*      */       }
/*      */       
/* 1169 */       if (this.a.h(var2 + 1, var3, var4) && ahi.e(this.a, var2 + 1, var3 + 1, var4, -1)) {
/* 1170 */         var30 = true;
/*      */       }
/*      */       
/* 1173 */       if (this.a.h(var2, var3, var4 - 1) && ahi.e(this.a, var2, var3 + 1, var4 - 1, -1)) {
/* 1174 */         var31 = true;
/*      */       }
/*      */       
/* 1177 */       if (this.a.h(var2, var3, var4 + 1) && ahi.e(this.a, var2, var3 + 1, var4 + 1, -1)) {
/* 1178 */         var32 = true;
/*      */       }
/*      */     } 
/*      */     
/* 1182 */     float var34 = (var2 + 0);
/* 1183 */     float var35 = (var2 + 1);
/* 1184 */     float var36 = (var4 + 0);
/* 1185 */     float var37 = (var4 + 1);
/* 1186 */     byte var38 = 0;
/* 1187 */     if ((var29 || var30) && !var31 && !var32) {
/* 1188 */       var38 = 1;
/*      */     }
/*      */     
/* 1191 */     if ((var31 || var32) && !var30 && !var29) {
/* 1192 */       var38 = 2;
/*      */     }
/*      */     
/* 1195 */     if (var38 != 0) {
/* 1196 */       var15 = ((var13 + 16) / 256.0F);
/* 1197 */       var17 = (((var13 + 16) + 15.99F) / 256.0F);
/* 1198 */       var19 = (var14 / 256.0F);
/* 1199 */       var21 = ((var14 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 1202 */     if (var38 == 0) {
/* 1203 */       if (!var29) {
/* 1204 */         var34 += 0.3125F;
/*      */       }
/*      */       
/* 1207 */       if (!var29) {
/* 1208 */         var15 += 0.01953125D;
/*      */       }
/*      */       
/* 1211 */       if (!var30) {
/* 1212 */         var35 -= 0.3125F;
/*      */       }
/*      */       
/* 1215 */       if (!var30) {
/* 1216 */         var17 -= 0.01953125D;
/*      */       }
/*      */       
/* 1219 */       if (!var31) {
/* 1220 */         var36 += 0.3125F;
/*      */       }
/*      */       
/* 1223 */       if (!var31) {
/* 1224 */         var19 += 0.01953125D;
/*      */       }
/*      */       
/* 1227 */       if (!var32) {
/* 1228 */         var37 -= 0.3125F;
/*      */       }
/*      */       
/* 1231 */       if (!var32) {
/* 1232 */         var21 -= 0.01953125D;
/*      */       }
/*      */       
/* 1235 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21);
/* 1236 */       var5.a(var35, var3 + 0.015625D, var36, var17, var19);
/* 1237 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19);
/* 1238 */       var5.a(var34, var3 + 0.015625D, var37, var15, var21);
/* 1239 */       var5.a(var8, var8, var8);
/* 1240 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21 + 0.0625D);
/* 1241 */       var5.a(var35, var3 + 0.015625D, var36, var17, var19 + 0.0625D);
/* 1242 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19 + 0.0625D);
/* 1243 */       var5.a(var34, var3 + 0.015625D, var37, var15, var21 + 0.0625D);
/* 1244 */     } else if (var38 == 1) {
/* 1245 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21);
/* 1246 */       var5.a(var35, var3 + 0.015625D, var36, var17, var19);
/* 1247 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19);
/* 1248 */       var5.a(var34, var3 + 0.015625D, var37, var15, var21);
/* 1249 */       var5.a(var8, var8, var8);
/* 1250 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21 + 0.0625D);
/* 1251 */       var5.a(var35, var3 + 0.015625D, var36, var17, var19 + 0.0625D);
/* 1252 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19 + 0.0625D);
/* 1253 */       var5.a(var34, var3 + 0.015625D, var37, var15, var21 + 0.0625D);
/* 1254 */     } else if (var38 == 2) {
/* 1255 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21);
/* 1256 */       var5.a(var35, var3 + 0.015625D, var36, var15, var21);
/* 1257 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19);
/* 1258 */       var5.a(var34, var3 + 0.015625D, var37, var17, var19);
/* 1259 */       var5.a(var8, var8, var8);
/* 1260 */       var5.a(var35, var3 + 0.015625D, var37, var17, var21 + 0.0625D);
/* 1261 */       var5.a(var35, var3 + 0.015625D, var36, var15, var21 + 0.0625D);
/* 1262 */       var5.a(var34, var3 + 0.015625D, var36, var15, var19 + 0.0625D);
/* 1263 */       var5.a(var34, var3 + 0.015625D, var37, var17, var19 + 0.0625D);
/*      */     } 
/*      */     
/* 1266 */     if (!this.a.h(var2, var3 + 1, var4)) {
/* 1267 */       var15 = ((var13 + 16) / 256.0F);
/* 1268 */       var17 = (((var13 + 16) + 15.99F) / 256.0F);
/* 1269 */       var19 = (var14 / 256.0F);
/* 1270 */       var21 = ((var14 + 15.99F) / 256.0F);
/* 1271 */       if (this.a.h(var2 - 1, var3, var4) && this.a.a(var2 - 1, var3 + 1, var4) == pb.av.bO) {
/* 1272 */         var5.a(var8 * var10, var8 * var11, var8 * var12);
/* 1273 */         var5.a(var2 + 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 1), var17, var19);
/* 1274 */         var5.a(var2 + 0.015625D, (var3 + 0), (var4 + 1), var15, var19);
/* 1275 */         var5.a(var2 + 0.015625D, (var3 + 0), (var4 + 0), var15, var21);
/* 1276 */         var5.a(var2 + 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 0), var17, var21);
/* 1277 */         var5.a(var8, var8, var8);
/* 1278 */         var5.a(var2 + 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 1), var17, var19 + 0.0625D);
/* 1279 */         var5.a(var2 + 0.015625D, (var3 + 0), (var4 + 1), var15, var19 + 0.0625D);
/* 1280 */         var5.a(var2 + 0.015625D, (var3 + 0), (var4 + 0), var15, var21 + 0.0625D);
/* 1281 */         var5.a(var2 + 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 0), var17, var21 + 0.0625D);
/*      */       } 
/*      */       
/* 1284 */       if (this.a.h(var2 + 1, var3, var4) && this.a.a(var2 + 1, var3 + 1, var4) == pb.av.bO) {
/* 1285 */         var5.a(var8 * var10, var8 * var11, var8 * var12);
/* 1286 */         var5.a((var2 + 1) - 0.015625D, (var3 + 0), (var4 + 1), var15, var21);
/* 1287 */         var5.a((var2 + 1) - 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 1), var17, var21);
/* 1288 */         var5.a((var2 + 1) - 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 0), var17, var19);
/* 1289 */         var5.a((var2 + 1) - 0.015625D, (var3 + 0), (var4 + 0), var15, var19);
/* 1290 */         var5.a(var8, var8, var8);
/* 1291 */         var5.a((var2 + 1) - 0.015625D, (var3 + 0), (var4 + 1), var15, var21 + 0.0625D);
/* 1292 */         var5.a((var2 + 1) - 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 1), var17, var21 + 0.0625D);
/* 1293 */         var5.a((var2 + 1) - 0.015625D, ((var3 + 1) + 0.021875F), (var4 + 0), var17, var19 + 0.0625D);
/* 1294 */         var5.a((var2 + 1) - 0.015625D, (var3 + 0), (var4 + 0), var15, var19 + 0.0625D);
/*      */       } 
/*      */       
/* 1297 */       if (this.a.h(var2, var3, var4 - 1) && this.a.a(var2, var3 + 1, var4 - 1) == pb.av.bO) {
/* 1298 */         var5.a(var8 * var10, var8 * var11, var8 * var12);
/* 1299 */         var5.a((var2 + 1), (var3 + 0), var4 + 0.015625D, var15, var21);
/* 1300 */         var5.a((var2 + 1), ((var3 + 1) + 0.021875F), var4 + 0.015625D, var17, var21);
/* 1301 */         var5.a((var2 + 0), ((var3 + 1) + 0.021875F), var4 + 0.015625D, var17, var19);
/* 1302 */         var5.a((var2 + 0), (var3 + 0), var4 + 0.015625D, var15, var19);
/* 1303 */         var5.a(var8, var8, var8);
/* 1304 */         var5.a((var2 + 1), (var3 + 0), var4 + 0.015625D, var15, var21 + 0.0625D);
/* 1305 */         var5.a((var2 + 1), ((var3 + 1) + 0.021875F), var4 + 0.015625D, var17, var21 + 0.0625D);
/* 1306 */         var5.a((var2 + 0), ((var3 + 1) + 0.021875F), var4 + 0.015625D, var17, var19 + 0.0625D);
/* 1307 */         var5.a((var2 + 0), (var3 + 0), var4 + 0.015625D, var15, var19 + 0.0625D);
/*      */       } 
/*      */       
/* 1310 */       if (this.a.h(var2, var3, var4 + 1) && this.a.a(var2, var3 + 1, var4 + 1) == pb.av.bO) {
/* 1311 */         var5.a(var8 * var10, var8 * var11, var8 * var12);
/* 1312 */         var5.a((var2 + 1), ((var3 + 1) + 0.021875F), (var4 + 1) - 0.015625D, var17, var19);
/* 1313 */         var5.a((var2 + 1), (var3 + 0), (var4 + 1) - 0.015625D, var15, var19);
/* 1314 */         var5.a((var2 + 0), (var3 + 0), (var4 + 1) - 0.015625D, var15, var21);
/* 1315 */         var5.a((var2 + 0), ((var3 + 1) + 0.021875F), (var4 + 1) - 0.015625D, var17, var21);
/* 1316 */         var5.a(var8, var8, var8);
/* 1317 */         var5.a((var2 + 1), ((var3 + 1) + 0.021875F), (var4 + 1) - 0.015625D, var17, var19 + 0.0625D);
/* 1318 */         var5.a((var2 + 1), (var3 + 0), (var4 + 1) - 0.015625D, var15, var19 + 0.0625D);
/* 1319 */         var5.a((var2 + 0), (var3 + 0), (var4 + 1) - 0.015625D, var15, var21 + 0.0625D);
/* 1320 */         var5.a((var2 + 0), ((var3 + 1) + 0.021875F), (var4 + 1) - 0.015625D, var17, var21 + 0.0625D);
/*      */       } 
/*      */     } 
/*      */     
/* 1324 */     return true;
/*      */   }
/*      */   
/*      */   public boolean a(aez var1, int var2, int var3, int var4) {
/* 1328 */     adz var5 = adz.a;
/* 1329 */     int var6 = this.a.e(var2, var3, var4);
/* 1330 */     int var7 = var1.a(0, var6);
/* 1331 */     if (this.d >= 0) {
/* 1332 */       var7 = this.d;
/*      */     }
/*      */     
/* 1335 */     if (var1.v()) {
/* 1336 */       var6 &= 0x7;
/*      */     }
/*      */     
/* 1339 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1340 */     var5.a(1.0F, 1.0F, 1.0F);
/* 1341 */     int var8 = (var7 & 0xF) << 4;
/* 1342 */     int var9 = var7 & 0xF0;
/* 1343 */     double var10 = (var8 / 256.0F);
/* 1344 */     double var12 = ((var8 + 15.99F) / 256.0F);
/* 1345 */     double var14 = (var9 / 256.0F);
/* 1346 */     double var16 = ((var9 + 15.99F) / 256.0F);
/* 1347 */     double var18 = 0.0625D;
/* 1348 */     double var20 = (var2 + 1);
/* 1349 */     double var22 = (var2 + 1);
/* 1350 */     double var24 = (var2 + 0);
/* 1351 */     double var26 = (var2 + 0);
/* 1352 */     double var28 = (var4 + 0);
/* 1353 */     double var30 = (var4 + 1);
/* 1354 */     double var32 = (var4 + 1);
/* 1355 */     double var34 = (var4 + 0);
/* 1356 */     double var36 = var3 + var18;
/* 1357 */     double var38 = var3 + var18;
/* 1358 */     double var40 = var3 + var18;
/* 1359 */     double var42 = var3 + var18;
/*      */ 
/*      */     
/* 1362 */     var20 = var22 = (var2 + 0);
/* 1363 */     var24 = var26 = (var2 + 1);
/* 1364 */     var28 = var34 = (var4 + 1);
/* 1365 */     var30 = var32 = (var4 + 0);
/* 1366 */     if (var6 == 9) {
/* 1367 */       var20 = var26 = (var2 + 0);
/* 1368 */       var22 = var24 = (var2 + 1);
/* 1369 */       var28 = var30 = (var4 + 0);
/* 1370 */       var32 = var34 = (var4 + 1);
/*      */     } 
/*      */     
/* 1373 */     var20 = var26 = (var2 + 1);
/* 1374 */     var22 = var24 = (var2 + 0);
/* 1375 */     var28 = var30 = (var4 + 1);
/* 1376 */     var32 = var34 = (var4 + 0);
/*      */ 
/*      */     
/* 1379 */     if (var6 != 2 && var6 != 4) {
/* 1380 */       if (var6 == 3 || var6 == 5) {
/* 1381 */         var38++;
/* 1382 */         var40++;
/*      */       } 
/*      */     } else {
/* 1385 */       var36++;
/* 1386 */       var42++;
/*      */     } 
/*      */     
/* 1389 */     var5.a(var20, var36, var28, var12, var14);
/* 1390 */     var5.a(var22, var38, var30, var12, var16);
/* 1391 */     var5.a(var24, var40, var32, var10, var16);
/* 1392 */     var5.a(var26, var42, var34, var10, var14);
/* 1393 */     var5.a(var26, var42, var34, var10, var14);
/* 1394 */     var5.a(var24, var40, var32, var10, var16);
/* 1395 */     var5.a(var22, var38, var30, var12, var16);
/* 1396 */     var5.a(var20, var36, var28, var12, var14);
/* 1397 */     return true;
/*      */   }
/*      */   
/*      */   public boolean h(pb var1, int var2, int var3, int var4) {
/* 1401 */     adz var5 = adz.a;
/* 1402 */     int var6 = var1.a_(0);
/* 1403 */     if (this.d >= 0) {
/* 1404 */       var6 = this.d;
/*      */     }
/*      */     
/* 1407 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1408 */     float var7 = 1.0F;
/* 1409 */     var5.a(var7, var7, var7);
/* 1410 */     int var22 = (var6 & 0xF) << 4;
/* 1411 */     int var8 = var6 & 0xF0;
/* 1412 */     double var9 = (var22 / 256.0F);
/* 1413 */     double var11 = ((var22 + 15.99F) / 256.0F);
/* 1414 */     double var13 = (var8 / 256.0F);
/* 1415 */     double var15 = ((var8 + 15.99F) / 256.0F);
/* 1416 */     int var17 = this.a.e(var2, var3, var4);
/* 1417 */     double var18 = 0.0D;
/* 1418 */     double var20 = 0.05000000074505806D;
/* 1419 */     if (var17 == 5) {
/* 1420 */       var5.a(var2 + var20, (var3 + 1) + var18, (var4 + 1) + var18, var9, var13);
/* 1421 */       var5.a(var2 + var20, (var3 + 0) - var18, (var4 + 1) + var18, var9, var15);
/* 1422 */       var5.a(var2 + var20, (var3 + 0) - var18, (var4 + 0) - var18, var11, var15);
/* 1423 */       var5.a(var2 + var20, (var3 + 1) + var18, (var4 + 0) - var18, var11, var13);
/*      */     } 
/*      */     
/* 1426 */     if (var17 == 4) {
/* 1427 */       var5.a((var2 + 1) - var20, (var3 + 0) - var18, (var4 + 1) + var18, var11, var15);
/* 1428 */       var5.a((var2 + 1) - var20, (var3 + 1) + var18, (var4 + 1) + var18, var11, var13);
/* 1429 */       var5.a((var2 + 1) - var20, (var3 + 1) + var18, (var4 + 0) - var18, var9, var13);
/* 1430 */       var5.a((var2 + 1) - var20, (var3 + 0) - var18, (var4 + 0) - var18, var9, var15);
/*      */     } 
/*      */     
/* 1433 */     if (var17 == 3) {
/* 1434 */       var5.a((var2 + 1) + var18, (var3 + 0) - var18, var4 + var20, var11, var15);
/* 1435 */       var5.a((var2 + 1) + var18, (var3 + 1) + var18, var4 + var20, var11, var13);
/* 1436 */       var5.a((var2 + 0) - var18, (var3 + 1) + var18, var4 + var20, var9, var13);
/* 1437 */       var5.a((var2 + 0) - var18, (var3 + 0) - var18, var4 + var20, var9, var15);
/*      */     } 
/*      */     
/* 1440 */     if (var17 == 2) {
/* 1441 */       var5.a((var2 + 1) + var18, (var3 + 1) + var18, (var4 + 1) - var20, var9, var13);
/* 1442 */       var5.a((var2 + 1) + var18, (var3 + 0) - var18, (var4 + 1) - var20, var9, var15);
/* 1443 */       var5.a((var2 + 0) - var18, (var3 + 0) - var18, (var4 + 1) - var20, var11, var15);
/* 1444 */       var5.a((var2 + 0) - var18, (var3 + 1) + var18, (var4 + 1) - var20, var11, var13);
/*      */     } 
/*      */     
/* 1447 */     return true;
/*      */   }
/*      */   
/*      */   public boolean i(pb var1, int var2, int var3, int var4) {
/* 1451 */     adz var5 = adz.a;
/* 1452 */     int var6 = var1.a_(0);
/* 1453 */     if (this.d >= 0) {
/* 1454 */       var6 = this.d;
/*      */     }
/*      */     
/* 1457 */     float var7 = 1.0F;
/* 1458 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1459 */     int var8 = var1.c(this.a, var2, var3, var4);
/* 1460 */     float var9 = (var8 >> 16 & 0xFF) / 255.0F;
/* 1461 */     float var10 = (var8 >> 8 & 0xFF) / 255.0F;
/* 1462 */     float var11 = (var8 & 0xFF) / 255.0F;
/* 1463 */     var5.a(var7 * var9, var7 * var10, var7 * var11);
/* 1464 */     var8 = (var6 & 0xF) << 4;
/* 1465 */     int var21 = var6 & 0xF0;
/* 1466 */     double var22 = (var8 / 256.0F);
/* 1467 */     double var12 = ((var8 + 15.99F) / 256.0F);
/* 1468 */     double var14 = (var21 / 256.0F);
/* 1469 */     double var16 = ((var21 + 15.99F) / 256.0F);
/* 1470 */     double var18 = 0.05000000074505806D;
/* 1471 */     int var20 = this.a.e(var2, var3, var4);
/* 1472 */     if ((var20 & 0x2) != 0) {
/* 1473 */       var5.a(var2 + var18, (var3 + 1), (var4 + 1), var22, var14);
/* 1474 */       var5.a(var2 + var18, (var3 + 0), (var4 + 1), var22, var16);
/* 1475 */       var5.a(var2 + var18, (var3 + 0), (var4 + 0), var12, var16);
/* 1476 */       var5.a(var2 + var18, (var3 + 1), (var4 + 0), var12, var14);
/* 1477 */       var5.a(var2 + var18, (var3 + 1), (var4 + 0), var12, var14);
/* 1478 */       var5.a(var2 + var18, (var3 + 0), (var4 + 0), var12, var16);
/* 1479 */       var5.a(var2 + var18, (var3 + 0), (var4 + 1), var22, var16);
/* 1480 */       var5.a(var2 + var18, (var3 + 1), (var4 + 1), var22, var14);
/*      */     } 
/*      */     
/* 1483 */     if ((var20 & 0x8) != 0) {
/* 1484 */       var5.a((var2 + 1) - var18, (var3 + 0), (var4 + 1), var12, var16);
/* 1485 */       var5.a((var2 + 1) - var18, (var3 + 1), (var4 + 1), var12, var14);
/* 1486 */       var5.a((var2 + 1) - var18, (var3 + 1), (var4 + 0), var22, var14);
/* 1487 */       var5.a((var2 + 1) - var18, (var3 + 0), (var4 + 0), var22, var16);
/* 1488 */       var5.a((var2 + 1) - var18, (var3 + 0), (var4 + 0), var22, var16);
/* 1489 */       var5.a((var2 + 1) - var18, (var3 + 1), (var4 + 0), var22, var14);
/* 1490 */       var5.a((var2 + 1) - var18, (var3 + 1), (var4 + 1), var12, var14);
/* 1491 */       var5.a((var2 + 1) - var18, (var3 + 0), (var4 + 1), var12, var16);
/*      */     } 
/*      */     
/* 1494 */     if ((var20 & 0x4) != 0) {
/* 1495 */       var5.a((var2 + 1), (var3 + 0), var4 + var18, var12, var16);
/* 1496 */       var5.a((var2 + 1), (var3 + 1), var4 + var18, var12, var14);
/* 1497 */       var5.a((var2 + 0), (var3 + 1), var4 + var18, var22, var14);
/* 1498 */       var5.a((var2 + 0), (var3 + 0), var4 + var18, var22, var16);
/* 1499 */       var5.a((var2 + 0), (var3 + 0), var4 + var18, var22, var16);
/* 1500 */       var5.a((var2 + 0), (var3 + 1), var4 + var18, var22, var14);
/* 1501 */       var5.a((var2 + 1), (var3 + 1), var4 + var18, var12, var14);
/* 1502 */       var5.a((var2 + 1), (var3 + 0), var4 + var18, var12, var16);
/*      */     } 
/*      */     
/* 1505 */     if ((var20 & 0x1) != 0) {
/* 1506 */       var5.a((var2 + 1), (var3 + 1), (var4 + 1) - var18, var22, var14);
/* 1507 */       var5.a((var2 + 1), (var3 + 0), (var4 + 1) - var18, var22, var16);
/* 1508 */       var5.a((var2 + 0), (var3 + 0), (var4 + 1) - var18, var12, var16);
/* 1509 */       var5.a((var2 + 0), (var3 + 1), (var4 + 1) - var18, var12, var14);
/* 1510 */       var5.a((var2 + 0), (var3 + 1), (var4 + 1) - var18, var12, var14);
/* 1511 */       var5.a((var2 + 0), (var3 + 0), (var4 + 1) - var18, var12, var16);
/* 1512 */       var5.a((var2 + 1), (var3 + 0), (var4 + 1) - var18, var22, var16);
/* 1513 */       var5.a((var2 + 1), (var3 + 1), (var4 + 1) - var18, var22, var14);
/*      */     } 
/*      */     
/* 1516 */     if (this.a.h(var2, var3 + 1, var4)) {
/* 1517 */       var5.a((var2 + 1), (var3 + 1) - var18, (var4 + 0), var22, var14);
/* 1518 */       var5.a((var2 + 1), (var3 + 1) - var18, (var4 + 1), var22, var16);
/* 1519 */       var5.a((var2 + 0), (var3 + 1) - var18, (var4 + 1), var12, var16);
/* 1520 */       var5.a((var2 + 0), (var3 + 1) - var18, (var4 + 0), var12, var14);
/*      */     } 
/*      */     
/* 1523 */     return true;
/*      */   }
/*      */   
/*      */   public boolean a(akq var1, int var2, int var3, int var4) {
/* 1527 */     int var65, var66, var5 = this.a.b();
/* 1528 */     adz var6 = adz.a;
/* 1529 */     var6.b(var1.d(this.a, var2, var3, var4));
/* 1530 */     float var7 = 1.0F;
/* 1531 */     int var8 = var1.c(this.a, var2, var3, var4);
/* 1532 */     float var9 = (var8 >> 16 & 0xFF) / 255.0F;
/* 1533 */     float var10 = (var8 >> 8 & 0xFF) / 255.0F;
/* 1534 */     float var11 = (var8 & 0xFF) / 255.0F;
/* 1535 */     if (lr.a) {
/* 1536 */       float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
/* 1537 */       float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
/* 1538 */       float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
/* 1539 */       var9 = var12;
/* 1540 */       var10 = var13;
/* 1541 */       var11 = var14;
/*      */     } 
/*      */     
/* 1544 */     var6.a(var7 * var9, var7 * var10, var7 * var11);
/* 1545 */     boolean var64 = false;
/* 1546 */     boolean var67 = false;
/*      */ 
/*      */ 
/*      */     
/* 1550 */     if (this.d >= 0) {
/* 1551 */       var65 = this.d;
/* 1552 */       var66 = this.d;
/*      */     } else {
/* 1554 */       int i = this.a.e(var2, var3, var4);
/* 1555 */       var65 = var1.a(0, i);
/* 1556 */       var66 = var1.v();
/*      */     } 
/*      */     
/* 1559 */     int var68 = (var65 & 0xF) << 4;
/* 1560 */     int var15 = var65 & 0xF0;
/* 1561 */     double var16 = (var68 / 256.0F);
/* 1562 */     double var18 = ((var68 + 7.99F) / 256.0F);
/* 1563 */     double var20 = ((var68 + 15.99F) / 256.0F);
/* 1564 */     double var22 = (var15 / 256.0F);
/* 1565 */     double var24 = ((var15 + 15.99F) / 256.0F);
/* 1566 */     int var26 = (var66 & 0xF) << 4;
/* 1567 */     int var27 = var66 & 0xF0;
/* 1568 */     double var28 = ((var26 + 7) / 256.0F);
/* 1569 */     double var30 = ((var26 + 8.99F) / 256.0F);
/* 1570 */     double var32 = (var27 / 256.0F);
/* 1571 */     double var34 = ((var27 + 8) / 256.0F);
/* 1572 */     double var36 = ((var27 + 15.99F) / 256.0F);
/* 1573 */     double var38 = var2;
/* 1574 */     double var40 = var2 + 0.5D;
/* 1575 */     double var42 = (var2 + 1);
/* 1576 */     double var44 = var4;
/* 1577 */     double var46 = var4 + 0.5D;
/* 1578 */     double var48 = (var4 + 1);
/* 1579 */     double var50 = var2 + 0.5D - 0.0625D;
/* 1580 */     double var52 = var2 + 0.5D + 0.0625D;
/* 1581 */     double var54 = var4 + 0.5D - 0.0625D;
/* 1582 */     double var56 = var4 + 0.5D + 0.0625D;
/* 1583 */     boolean var58 = var1.e(this.a.a(var2, var3, var4 - 1));
/* 1584 */     boolean var59 = var1.e(this.a.a(var2, var3, var4 + 1));
/* 1585 */     boolean var60 = var1.e(this.a.a(var2 - 1, var3, var4));
/* 1586 */     boolean var61 = var1.e(this.a.a(var2 + 1, var3, var4));
/* 1587 */     boolean var62 = var1.a(this.a, var2, var3 + 1, var4, 1);
/* 1588 */     boolean var63 = var1.a(this.a, var2, var3 - 1, var4, 0);
/* 1589 */     if ((!var60 || !var61) && (var60 || var61 || var58 || var59)) {
/* 1590 */       if (var60 && !var61) {
/* 1591 */         var6.a(var38, (var3 + 1), var46, var16, var22);
/* 1592 */         var6.a(var38, (var3 + 0), var46, var16, var24);
/* 1593 */         var6.a(var40, (var3 + 0), var46, var18, var24);
/* 1594 */         var6.a(var40, (var3 + 1), var46, var18, var22);
/* 1595 */         var6.a(var40, (var3 + 1), var46, var16, var22);
/* 1596 */         var6.a(var40, (var3 + 0), var46, var16, var24);
/* 1597 */         var6.a(var38, (var3 + 0), var46, var18, var24);
/* 1598 */         var6.a(var38, (var3 + 1), var46, var18, var22);
/* 1599 */         if (!var59 && !var58) {
/* 1600 */           var6.a(var40, (var3 + 1), var56, var28, var32);
/* 1601 */           var6.a(var40, (var3 + 0), var56, var28, var36);
/* 1602 */           var6.a(var40, (var3 + 0), var54, var30, var36);
/* 1603 */           var6.a(var40, (var3 + 1), var54, var30, var32);
/* 1604 */           var6.a(var40, (var3 + 1), var54, var28, var32);
/* 1605 */           var6.a(var40, (var3 + 0), var54, var28, var36);
/* 1606 */           var6.a(var40, (var3 + 0), var56, var30, var36);
/* 1607 */           var6.a(var40, (var3 + 1), var56, var30, var32);
/*      */         } 
/*      */         
/* 1610 */         if (var62 || (var3 < var5 - 1 && this.a.i(var2 - 1, var3 + 1, var4))) {
/* 1611 */           var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1612 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1613 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var36);
/* 1614 */           var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1615 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1616 */           var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1617 */           var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var36);
/* 1618 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var34);
/*      */         } 
/*      */         
/* 1621 */         if (var63 || (var3 > 1 && this.a.i(var2 - 1, var3 - 1, var4))) {
/* 1622 */           var6.a(var38, var3 - 0.01D, var56, var30, var34);
/* 1623 */           var6.a(var40, var3 - 0.01D, var56, var30, var36);
/* 1624 */           var6.a(var40, var3 - 0.01D, var54, var28, var36);
/* 1625 */           var6.a(var38, var3 - 0.01D, var54, var28, var34);
/* 1626 */           var6.a(var40, var3 - 0.01D, var56, var30, var34);
/* 1627 */           var6.a(var38, var3 - 0.01D, var56, var30, var36);
/* 1628 */           var6.a(var38, var3 - 0.01D, var54, var28, var36);
/* 1629 */           var6.a(var40, var3 - 0.01D, var54, var28, var34);
/*      */         } 
/* 1631 */       } else if (!var60 && var61) {
/* 1632 */         var6.a(var40, (var3 + 1), var46, var18, var22);
/* 1633 */         var6.a(var40, (var3 + 0), var46, var18, var24);
/* 1634 */         var6.a(var42, (var3 + 0), var46, var20, var24);
/* 1635 */         var6.a(var42, (var3 + 1), var46, var20, var22);
/* 1636 */         var6.a(var42, (var3 + 1), var46, var18, var22);
/* 1637 */         var6.a(var42, (var3 + 0), var46, var18, var24);
/* 1638 */         var6.a(var40, (var3 + 0), var46, var20, var24);
/* 1639 */         var6.a(var40, (var3 + 1), var46, var20, var22);
/* 1640 */         if (!var59 && !var58) {
/* 1641 */           var6.a(var40, (var3 + 1), var54, var28, var32);
/* 1642 */           var6.a(var40, (var3 + 0), var54, var28, var36);
/* 1643 */           var6.a(var40, (var3 + 0), var56, var30, var36);
/* 1644 */           var6.a(var40, (var3 + 1), var56, var30, var32);
/* 1645 */           var6.a(var40, (var3 + 1), var56, var28, var32);
/* 1646 */           var6.a(var40, (var3 + 0), var56, var28, var36);
/* 1647 */           var6.a(var40, (var3 + 0), var54, var30, var36);
/* 1648 */           var6.a(var40, (var3 + 1), var54, var30, var32);
/*      */         } 
/*      */         
/* 1651 */         if (var62 || (var3 < var5 - 1 && this.a.i(var2 + 1, var3 + 1, var4))) {
/* 1652 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1653 */           var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1654 */           var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1655 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var32);
/* 1656 */           var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1657 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1658 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1659 */           var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var32);
/*      */         } 
/*      */         
/* 1662 */         if (var63 || (var3 > 1 && this.a.i(var2 + 1, var3 - 1, var4))) {
/* 1663 */           var6.a(var40, var3 - 0.01D, var56, var30, var32);
/* 1664 */           var6.a(var42, var3 - 0.01D, var56, var30, var34);
/* 1665 */           var6.a(var42, var3 - 0.01D, var54, var28, var34);
/* 1666 */           var6.a(var40, var3 - 0.01D, var54, var28, var32);
/* 1667 */           var6.a(var42, var3 - 0.01D, var56, var30, var32);
/* 1668 */           var6.a(var40, var3 - 0.01D, var56, var30, var34);
/* 1669 */           var6.a(var40, var3 - 0.01D, var54, var28, var34);
/* 1670 */           var6.a(var42, var3 - 0.01D, var54, var28, var32);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1674 */       var6.a(var38, (var3 + 1), var46, var16, var22);
/* 1675 */       var6.a(var38, (var3 + 0), var46, var16, var24);
/* 1676 */       var6.a(var42, (var3 + 0), var46, var20, var24);
/* 1677 */       var6.a(var42, (var3 + 1), var46, var20, var22);
/* 1678 */       var6.a(var42, (var3 + 1), var46, var16, var22);
/* 1679 */       var6.a(var42, (var3 + 0), var46, var16, var24);
/* 1680 */       var6.a(var38, (var3 + 0), var46, var20, var24);
/* 1681 */       var6.a(var38, (var3 + 1), var46, var20, var22);
/* 1682 */       if (var62) {
/* 1683 */         var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1684 */         var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1685 */         var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var32);
/* 1686 */         var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var36);
/* 1687 */         var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1688 */         var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1689 */         var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var32);
/* 1690 */         var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var36);
/*      */       } else {
/* 1692 */         if (var3 < var5 - 1 && this.a.i(var2 - 1, var3 + 1, var4)) {
/* 1693 */           var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1694 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1695 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var36);
/* 1696 */           var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1697 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1698 */           var6.a(var38, (var3 + 1) + 0.01D, var56, var30, var36);
/* 1699 */           var6.a(var38, (var3 + 1) + 0.01D, var54, var28, var36);
/* 1700 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var34);
/*      */         } 
/*      */         
/* 1703 */         if (var3 < var5 - 1 && this.a.i(var2 + 1, var3 + 1, var4)) {
/* 1704 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1705 */           var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1706 */           var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1707 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var32);
/* 1708 */           var6.a(var42, (var3 + 1) + 0.01D, var56, var30, var32);
/* 1709 */           var6.a(var40, (var3 + 1) + 0.01D, var56, var30, var34);
/* 1710 */           var6.a(var40, (var3 + 1) + 0.01D, var54, var28, var34);
/* 1711 */           var6.a(var42, (var3 + 1) + 0.01D, var54, var28, var32);
/*      */         } 
/*      */       } 
/*      */       
/* 1715 */       if (var63) {
/* 1716 */         var6.a(var38, var3 - 0.01D, var56, var30, var36);
/* 1717 */         var6.a(var42, var3 - 0.01D, var56, var30, var32);
/* 1718 */         var6.a(var42, var3 - 0.01D, var54, var28, var32);
/* 1719 */         var6.a(var38, var3 - 0.01D, var54, var28, var36);
/* 1720 */         var6.a(var42, var3 - 0.01D, var56, var30, var36);
/* 1721 */         var6.a(var38, var3 - 0.01D, var56, var30, var32);
/* 1722 */         var6.a(var38, var3 - 0.01D, var54, var28, var32);
/* 1723 */         var6.a(var42, var3 - 0.01D, var54, var28, var36);
/*      */       } else {
/* 1725 */         if (var3 > 1 && this.a.i(var2 - 1, var3 - 1, var4)) {
/* 1726 */           var6.a(var38, var3 - 0.01D, var56, var30, var34);
/* 1727 */           var6.a(var40, var3 - 0.01D, var56, var30, var36);
/* 1728 */           var6.a(var40, var3 - 0.01D, var54, var28, var36);
/* 1729 */           var6.a(var38, var3 - 0.01D, var54, var28, var34);
/* 1730 */           var6.a(var40, var3 - 0.01D, var56, var30, var34);
/* 1731 */           var6.a(var38, var3 - 0.01D, var56, var30, var36);
/* 1732 */           var6.a(var38, var3 - 0.01D, var54, var28, var36);
/* 1733 */           var6.a(var40, var3 - 0.01D, var54, var28, var34);
/*      */         } 
/*      */         
/* 1736 */         if (var3 > 1 && this.a.i(var2 + 1, var3 - 1, var4)) {
/* 1737 */           var6.a(var40, var3 - 0.01D, var56, var30, var32);
/* 1738 */           var6.a(var42, var3 - 0.01D, var56, var30, var34);
/* 1739 */           var6.a(var42, var3 - 0.01D, var54, var28, var34);
/* 1740 */           var6.a(var40, var3 - 0.01D, var54, var28, var32);
/* 1741 */           var6.a(var42, var3 - 0.01D, var56, var30, var32);
/* 1742 */           var6.a(var40, var3 - 0.01D, var56, var30, var34);
/* 1743 */           var6.a(var40, var3 - 0.01D, var54, var28, var34);
/* 1744 */           var6.a(var42, var3 - 0.01D, var54, var28, var32);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1749 */     if ((!var58 || !var59) && (var60 || var61 || var58 || var59)) {
/* 1750 */       if (var58 && !var59) {
/* 1751 */         var6.a(var40, (var3 + 1), var44, var16, var22);
/* 1752 */         var6.a(var40, (var3 + 0), var44, var16, var24);
/* 1753 */         var6.a(var40, (var3 + 0), var46, var18, var24);
/* 1754 */         var6.a(var40, (var3 + 1), var46, var18, var22);
/* 1755 */         var6.a(var40, (var3 + 1), var46, var16, var22);
/* 1756 */         var6.a(var40, (var3 + 0), var46, var16, var24);
/* 1757 */         var6.a(var40, (var3 + 0), var44, var18, var24);
/* 1758 */         var6.a(var40, (var3 + 1), var44, var18, var22);
/* 1759 */         if (!var61 && !var60) {
/* 1760 */           var6.a(var50, (var3 + 1), var46, var28, var32);
/* 1761 */           var6.a(var50, (var3 + 0), var46, var28, var36);
/* 1762 */           var6.a(var52, (var3 + 0), var46, var30, var36);
/* 1763 */           var6.a(var52, (var3 + 1), var46, var30, var32);
/* 1764 */           var6.a(var52, (var3 + 1), var46, var28, var32);
/* 1765 */           var6.a(var52, (var3 + 0), var46, var28, var36);
/* 1766 */           var6.a(var50, (var3 + 0), var46, var30, var36);
/* 1767 */           var6.a(var50, (var3 + 1), var46, var30, var32);
/*      */         } 
/*      */         
/* 1770 */         if (var62 || (var3 < var5 - 1 && this.a.i(var2, var3 + 1, var4 - 1))) {
/* 1771 */           var6.a(var50, (var3 + 1), var44, var30, var32);
/* 1772 */           var6.a(var50, (var3 + 1), var46, var30, var34);
/* 1773 */           var6.a(var52, (var3 + 1), var46, var28, var34);
/* 1774 */           var6.a(var52, (var3 + 1), var44, var28, var32);
/* 1775 */           var6.a(var50, (var3 + 1), var46, var30, var32);
/* 1776 */           var6.a(var50, (var3 + 1), var44, var30, var34);
/* 1777 */           var6.a(var52, (var3 + 1), var44, var28, var34);
/* 1778 */           var6.a(var52, (var3 + 1), var46, var28, var32);
/*      */         } 
/*      */         
/* 1781 */         if (var63 || (var3 > 1 && this.a.i(var2, var3 - 1, var4 - 1))) {
/* 1782 */           var6.a(var50, var3, var44, var30, var32);
/* 1783 */           var6.a(var50, var3, var46, var30, var34);
/* 1784 */           var6.a(var52, var3, var46, var28, var34);
/* 1785 */           var6.a(var52, var3, var44, var28, var32);
/* 1786 */           var6.a(var50, var3, var46, var30, var32);
/* 1787 */           var6.a(var50, var3, var44, var30, var34);
/* 1788 */           var6.a(var52, var3, var44, var28, var34);
/* 1789 */           var6.a(var52, var3, var46, var28, var32);
/*      */         } 
/* 1791 */       } else if (!var58 && var59) {
/* 1792 */         var6.a(var40, (var3 + 1), var46, var18, var22);
/* 1793 */         var6.a(var40, (var3 + 0), var46, var18, var24);
/* 1794 */         var6.a(var40, (var3 + 0), var48, var20, var24);
/* 1795 */         var6.a(var40, (var3 + 1), var48, var20, var22);
/* 1796 */         var6.a(var40, (var3 + 1), var48, var18, var22);
/* 1797 */         var6.a(var40, (var3 + 0), var48, var18, var24);
/* 1798 */         var6.a(var40, (var3 + 0), var46, var20, var24);
/* 1799 */         var6.a(var40, (var3 + 1), var46, var20, var22);
/* 1800 */         if (!var61 && !var60) {
/* 1801 */           var6.a(var52, (var3 + 1), var46, var28, var32);
/* 1802 */           var6.a(var52, (var3 + 0), var46, var28, var36);
/* 1803 */           var6.a(var50, (var3 + 0), var46, var30, var36);
/* 1804 */           var6.a(var50, (var3 + 1), var46, var30, var32);
/* 1805 */           var6.a(var50, (var3 + 1), var46, var28, var32);
/* 1806 */           var6.a(var50, (var3 + 0), var46, var28, var36);
/* 1807 */           var6.a(var52, (var3 + 0), var46, var30, var36);
/* 1808 */           var6.a(var52, (var3 + 1), var46, var30, var32);
/*      */         } 
/*      */         
/* 1811 */         if (var62 || (var3 < var5 - 1 && this.a.i(var2, var3 + 1, var4 + 1))) {
/* 1812 */           var6.a(var50, (var3 + 1), var46, var28, var34);
/* 1813 */           var6.a(var50, (var3 + 1), var48, var28, var36);
/* 1814 */           var6.a(var52, (var3 + 1), var48, var30, var36);
/* 1815 */           var6.a(var52, (var3 + 1), var46, var30, var34);
/* 1816 */           var6.a(var50, (var3 + 1), var48, var28, var34);
/* 1817 */           var6.a(var50, (var3 + 1), var46, var28, var36);
/* 1818 */           var6.a(var52, (var3 + 1), var46, var30, var36);
/* 1819 */           var6.a(var52, (var3 + 1), var48, var30, var34);
/*      */         } 
/*      */         
/* 1822 */         if (var63 || (var3 > 1 && this.a.i(var2, var3 - 1, var4 + 1))) {
/* 1823 */           var6.a(var50, var3, var46, var28, var34);
/* 1824 */           var6.a(var50, var3, var48, var28, var36);
/* 1825 */           var6.a(var52, var3, var48, var30, var36);
/* 1826 */           var6.a(var52, var3, var46, var30, var34);
/* 1827 */           var6.a(var50, var3, var48, var28, var34);
/* 1828 */           var6.a(var50, var3, var46, var28, var36);
/* 1829 */           var6.a(var52, var3, var46, var30, var36);
/* 1830 */           var6.a(var52, var3, var48, var30, var34);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1834 */       var6.a(var40, (var3 + 1), var48, var16, var22);
/* 1835 */       var6.a(var40, (var3 + 0), var48, var16, var24);
/* 1836 */       var6.a(var40, (var3 + 0), var44, var20, var24);
/* 1837 */       var6.a(var40, (var3 + 1), var44, var20, var22);
/* 1838 */       var6.a(var40, (var3 + 1), var44, var16, var22);
/* 1839 */       var6.a(var40, (var3 + 0), var44, var16, var24);
/* 1840 */       var6.a(var40, (var3 + 0), var48, var20, var24);
/* 1841 */       var6.a(var40, (var3 + 1), var48, var20, var22);
/* 1842 */       if (var62) {
/* 1843 */         var6.a(var52, (var3 + 1), var48, var30, var36);
/* 1844 */         var6.a(var52, (var3 + 1), var44, var30, var32);
/* 1845 */         var6.a(var50, (var3 + 1), var44, var28, var32);
/* 1846 */         var6.a(var50, (var3 + 1), var48, var28, var36);
/* 1847 */         var6.a(var52, (var3 + 1), var44, var30, var36);
/* 1848 */         var6.a(var52, (var3 + 1), var48, var30, var32);
/* 1849 */         var6.a(var50, (var3 + 1), var48, var28, var32);
/* 1850 */         var6.a(var50, (var3 + 1), var44, var28, var36);
/*      */       } else {
/* 1852 */         if (var3 < var5 - 1 && this.a.i(var2, var3 + 1, var4 - 1)) {
/* 1853 */           var6.a(var50, (var3 + 1), var44, var30, var32);
/* 1854 */           var6.a(var50, (var3 + 1), var46, var30, var34);
/* 1855 */           var6.a(var52, (var3 + 1), var46, var28, var34);
/* 1856 */           var6.a(var52, (var3 + 1), var44, var28, var32);
/* 1857 */           var6.a(var50, (var3 + 1), var46, var30, var32);
/* 1858 */           var6.a(var50, (var3 + 1), var44, var30, var34);
/* 1859 */           var6.a(var52, (var3 + 1), var44, var28, var34);
/* 1860 */           var6.a(var52, (var3 + 1), var46, var28, var32);
/*      */         } 
/*      */         
/* 1863 */         if (var3 < var5 - 1 && this.a.i(var2, var3 + 1, var4 + 1)) {
/* 1864 */           var6.a(var50, (var3 + 1), var46, var28, var34);
/* 1865 */           var6.a(var50, (var3 + 1), var48, var28, var36);
/* 1866 */           var6.a(var52, (var3 + 1), var48, var30, var36);
/* 1867 */           var6.a(var52, (var3 + 1), var46, var30, var34);
/* 1868 */           var6.a(var50, (var3 + 1), var48, var28, var34);
/* 1869 */           var6.a(var50, (var3 + 1), var46, var28, var36);
/* 1870 */           var6.a(var52, (var3 + 1), var46, var30, var36);
/* 1871 */           var6.a(var52, (var3 + 1), var48, var30, var34);
/*      */         } 
/*      */       } 
/*      */       
/* 1875 */       if (var63) {
/* 1876 */         var6.a(var52, var3, var48, var30, var36);
/* 1877 */         var6.a(var52, var3, var44, var30, var32);
/* 1878 */         var6.a(var50, var3, var44, var28, var32);
/* 1879 */         var6.a(var50, var3, var48, var28, var36);
/* 1880 */         var6.a(var52, var3, var44, var30, var36);
/* 1881 */         var6.a(var52, var3, var48, var30, var32);
/* 1882 */         var6.a(var50, var3, var48, var28, var32);
/* 1883 */         var6.a(var50, var3, var44, var28, var36);
/*      */       } else {
/* 1885 */         if (var3 > 1 && this.a.i(var2, var3 - 1, var4 - 1)) {
/* 1886 */           var6.a(var50, var3, var44, var30, var32);
/* 1887 */           var6.a(var50, var3, var46, var30, var34);
/* 1888 */           var6.a(var52, var3, var46, var28, var34);
/* 1889 */           var6.a(var52, var3, var44, var28, var32);
/* 1890 */           var6.a(var50, var3, var46, var30, var32);
/* 1891 */           var6.a(var50, var3, var44, var30, var34);
/* 1892 */           var6.a(var52, var3, var44, var28, var34);
/* 1893 */           var6.a(var52, var3, var46, var28, var32);
/*      */         } 
/*      */         
/* 1896 */         if (var3 > 1 && this.a.i(var2, var3 - 1, var4 + 1)) {
/* 1897 */           var6.a(var50, var3, var46, var28, var34);
/* 1898 */           var6.a(var50, var3, var48, var28, var36);
/* 1899 */           var6.a(var52, var3, var48, var30, var36);
/* 1900 */           var6.a(var52, var3, var46, var30, var34);
/* 1901 */           var6.a(var50, var3, var48, var28, var34);
/* 1902 */           var6.a(var50, var3, var46, var28, var36);
/* 1903 */           var6.a(var52, var3, var46, var30, var36);
/* 1904 */           var6.a(var52, var3, var48, var30, var34);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1909 */     return true;
/*      */   }
/*      */   
/*      */   public boolean j(pb var1, int var2, int var3, int var4) {
/* 1913 */     adz var5 = adz.a;
/* 1914 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1915 */     float var6 = 1.0F;
/* 1916 */     int var7 = var1.c(this.a, var2, var3, var4);
/* 1917 */     float var8 = (var7 >> 16 & 0xFF) / 255.0F;
/* 1918 */     float var9 = (var7 >> 8 & 0xFF) / 255.0F;
/* 1919 */     float var10 = (var7 & 0xFF) / 255.0F;
/* 1920 */     if (lr.a) {
/* 1921 */       float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
/* 1922 */       float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
/* 1923 */       float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
/* 1924 */       var8 = var11;
/* 1925 */       var9 = var12;
/* 1926 */       var10 = var13;
/*      */     } 
/*      */     
/* 1929 */     var5.a(var6 * var8, var6 * var9, var6 * var10);
/* 1930 */     double var19 = var2;
/* 1931 */     double var20 = var3;
/* 1932 */     double var15 = var4;
/* 1933 */     if (var1 == pb.X) {
/* 1934 */       long var17 = (var2 * 3129871) ^ var4 * 116129781L ^ var3;
/* 1935 */       var17 = var17 * var17 * 42317861L + var17 * 11L;
/* 1936 */       var19 += (((float)(var17 >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/* 1937 */       var20 += (((float)(var17 >> 20L & 0xFL) / 15.0F) - 1.0D) * 0.2D;
/* 1938 */       var15 += (((float)(var17 >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/*      */     } 
/*      */     
/* 1941 */     a(var1, this.a.e(var2, var3, var4), var19, var20, var15);
/* 1942 */     return true;
/*      */   }
/*      */   
/*      */   public boolean k(pb var1, int var2, int var3, int var4) {
/* 1946 */     aei var5 = (aei)var1;
/* 1947 */     adz var6 = adz.a;
/* 1948 */     var6.b(var5.d(this.a, var2, var3, var4));
/* 1949 */     float var7 = 1.0F;
/* 1950 */     int var8 = var5.c(this.a, var2, var3, var4);
/* 1951 */     float var9 = (var8 >> 16 & 0xFF) / 255.0F;
/* 1952 */     float var10 = (var8 >> 8 & 0xFF) / 255.0F;
/* 1953 */     float var11 = (var8 & 0xFF) / 255.0F;
/* 1954 */     if (lr.a) {
/* 1955 */       float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
/* 1956 */       float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
/* 1957 */       float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
/* 1958 */       var9 = var12;
/* 1959 */       var10 = var13;
/* 1960 */       var11 = var14;
/*      */     } 
/*      */     
/* 1963 */     var6.a(var7 * var9, var7 * var10, var7 * var11);
/* 1964 */     var5.a(this.a, var2, var3, var4);
/* 1965 */     int var15 = var5.g(this.a, var2, var3, var4);
/* 1966 */     if (var15 < 0) {
/* 1967 */       a((pb)var5, this.a.e(var2, var3, var4), var5.bZ, var2, var3, var4);
/*      */     } else {
/* 1969 */       a((pb)var5, this.a.e(var2, var3, var4), 0.5D, var2, var3, var4);
/* 1970 */       a((pb)var5, this.a.e(var2, var3, var4), var15, var5.bZ, var2, var3, var4);
/*      */     } 
/*      */     
/* 1973 */     return true;
/*      */   }
/*      */   
/*      */   public boolean l(pb var1, int var2, int var3, int var4) {
/* 1977 */     adz var5 = adz.a;
/* 1978 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 1979 */     var5.a(1.0F, 1.0F, 1.0F);
/* 1980 */     b(var1, this.a.e(var2, var3, var4), var2, (var3 - 0.0625F), var4);
/* 1981 */     return true;
/*      */   }
/*      */   
/*      */   public void a(pb var1, double var2, double var4, double var6, double var8, double var10) {
/* 1985 */     adz var12 = adz.a;
/* 1986 */     int var13 = var1.a_(0);
/* 1987 */     if (this.d >= 0) {
/* 1988 */       var13 = this.d;
/*      */     }
/*      */     
/* 1991 */     int var14 = (var13 & 0xF) << 4;
/* 1992 */     int var15 = var13 & 0xF0;
/* 1993 */     float var16 = var14 / 256.0F;
/* 1994 */     float var17 = (var14 + 15.99F) / 256.0F;
/* 1995 */     float var18 = var15 / 256.0F;
/* 1996 */     float var19 = (var15 + 15.99F) / 256.0F;
/* 1997 */     double var20 = var16 + 0.02734375D;
/* 1998 */     double var22 = var18 + 0.0234375D;
/* 1999 */     double var24 = var16 + 0.03515625D;
/* 2000 */     double var26 = var18 + 0.03125D;
/* 2001 */     var2 += 0.5D;
/* 2002 */     var6 += 0.5D;
/* 2003 */     double var28 = var2 - 0.5D;
/* 2004 */     double var30 = var2 + 0.5D;
/* 2005 */     double var32 = var6 - 0.5D;
/* 2006 */     double var34 = var6 + 0.5D;
/* 2007 */     double var36 = 0.0625D;
/* 2008 */     double var38 = 0.625D;
/* 2009 */     var12.a(var2 + var8 * (1.0D - var38) - var36, var4 + var38, var6 + var10 * (1.0D - var38) - var36, var20, var22);
/* 2010 */     var12.a(var2 + var8 * (1.0D - var38) - var36, var4 + var38, var6 + var10 * (1.0D - var38) + var36, var20, var26);
/* 2011 */     var12.a(var2 + var8 * (1.0D - var38) + var36, var4 + var38, var6 + var10 * (1.0D - var38) + var36, var24, var26);
/* 2012 */     var12.a(var2 + var8 * (1.0D - var38) + var36, var4 + var38, var6 + var10 * (1.0D - var38) - var36, var24, var22);
/* 2013 */     var12.a(var2 - var36, var4 + 1.0D, var32, var16, var18);
/* 2014 */     var12.a(var2 - var36 + var8, var4 + 0.0D, var32 + var10, var16, var19);
/* 2015 */     var12.a(var2 - var36 + var8, var4 + 0.0D, var34 + var10, var17, var19);
/* 2016 */     var12.a(var2 - var36, var4 + 1.0D, var34, var17, var18);
/* 2017 */     var12.a(var2 + var36, var4 + 1.0D, var34, var16, var18);
/* 2018 */     var12.a(var2 + var8 + var36, var4 + 0.0D, var34 + var10, var16, var19);
/* 2019 */     var12.a(var2 + var8 + var36, var4 + 0.0D, var32 + var10, var17, var19);
/* 2020 */     var12.a(var2 + var36, var4 + 1.0D, var32, var17, var18);
/* 2021 */     var12.a(var28, var4 + 1.0D, var6 + var36, var16, var18);
/* 2022 */     var12.a(var28 + var8, var4 + 0.0D, var6 + var36 + var10, var16, var19);
/* 2023 */     var12.a(var30 + var8, var4 + 0.0D, var6 + var36 + var10, var17, var19);
/* 2024 */     var12.a(var30, var4 + 1.0D, var6 + var36, var17, var18);
/* 2025 */     var12.a(var30, var4 + 1.0D, var6 - var36, var16, var18);
/* 2026 */     var12.a(var30 + var8, var4 + 0.0D, var6 - var36 + var10, var16, var19);
/* 2027 */     var12.a(var28 + var8, var4 + 0.0D, var6 - var36 + var10, var17, var19);
/* 2028 */     var12.a(var28, var4 + 1.0D, var6 - var36, var17, var18);
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, double var3, double var5, double var7) {
/* 2032 */     adz var9 = adz.a;
/* 2033 */     int var10 = var1.a(0, var2);
/* 2034 */     if (this.d >= 0) {
/* 2035 */       var10 = this.d;
/*      */     }
/*      */     
/* 2038 */     int var11 = (var10 & 0xF) << 4;
/* 2039 */     int var12 = var10 & 0xF0;
/* 2040 */     double var13 = (var11 / 256.0F);
/* 2041 */     double var15 = ((var11 + 15.99F) / 256.0F);
/* 2042 */     double var17 = (var12 / 256.0F);
/* 2043 */     double var19 = ((var12 + 15.99F) / 256.0F);
/* 2044 */     double var21 = var3 + 0.5D - 0.45D;
/* 2045 */     double var23 = var3 + 0.5D + 0.45D;
/* 2046 */     double var25 = var7 + 0.5D - 0.45D;
/* 2047 */     double var27 = var7 + 0.5D + 0.45D;
/* 2048 */     var9.a(var21, var5 + 1.0D, var25, var13, var17);
/* 2049 */     var9.a(var21, var5 + 0.0D, var25, var13, var19);
/* 2050 */     var9.a(var23, var5 + 0.0D, var27, var15, var19);
/* 2051 */     var9.a(var23, var5 + 1.0D, var27, var15, var17);
/* 2052 */     var9.a(var23, var5 + 1.0D, var27, var13, var17);
/* 2053 */     var9.a(var23, var5 + 0.0D, var27, var13, var19);
/* 2054 */     var9.a(var21, var5 + 0.0D, var25, var15, var19);
/* 2055 */     var9.a(var21, var5 + 1.0D, var25, var15, var17);
/* 2056 */     var9.a(var21, var5 + 1.0D, var27, var13, var17);
/* 2057 */     var9.a(var21, var5 + 0.0D, var27, var13, var19);
/* 2058 */     var9.a(var23, var5 + 0.0D, var25, var15, var19);
/* 2059 */     var9.a(var23, var5 + 1.0D, var25, var15, var17);
/* 2060 */     var9.a(var23, var5 + 1.0D, var25, var13, var17);
/* 2061 */     var9.a(var23, var5 + 0.0D, var25, var13, var19);
/* 2062 */     var9.a(var21, var5 + 0.0D, var27, var15, var19);
/* 2063 */     var9.a(var21, var5 + 1.0D, var27, var15, var17);
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, double var3, double var5, double var7, double var9) {
/* 2067 */     adz var11 = adz.a;
/* 2068 */     int var12 = var1.a(0, var2);
/* 2069 */     if (this.d >= 0) {
/* 2070 */       var12 = this.d;
/*      */     }
/*      */     
/* 2073 */     int var13 = (var12 & 0xF) << 4;
/* 2074 */     int var14 = var12 & 0xF0;
/* 2075 */     double var15 = (var13 / 256.0F);
/* 2076 */     double var17 = ((var13 + 15.99F) / 256.0F);
/* 2077 */     double var19 = (var14 / 256.0F);
/* 2078 */     double var21 = (var14 + 15.989999771118164D * var3) / 256.0D;
/* 2079 */     double var23 = var5 + 0.5D - 0.44999998807907104D;
/* 2080 */     double var25 = var5 + 0.5D + 0.44999998807907104D;
/* 2081 */     double var27 = var9 + 0.5D - 0.44999998807907104D;
/* 2082 */     double var29 = var9 + 0.5D + 0.44999998807907104D;
/* 2083 */     var11.a(var23, var7 + var3, var27, var15, var19);
/* 2084 */     var11.a(var23, var7 + 0.0D, var27, var15, var21);
/* 2085 */     var11.a(var25, var7 + 0.0D, var29, var17, var21);
/* 2086 */     var11.a(var25, var7 + var3, var29, var17, var19);
/* 2087 */     var11.a(var25, var7 + var3, var29, var15, var19);
/* 2088 */     var11.a(var25, var7 + 0.0D, var29, var15, var21);
/* 2089 */     var11.a(var23, var7 + 0.0D, var27, var17, var21);
/* 2090 */     var11.a(var23, var7 + var3, var27, var17, var19);
/* 2091 */     var11.a(var23, var7 + var3, var29, var15, var19);
/* 2092 */     var11.a(var23, var7 + 0.0D, var29, var15, var21);
/* 2093 */     var11.a(var25, var7 + 0.0D, var27, var17, var21);
/* 2094 */     var11.a(var25, var7 + var3, var27, var17, var19);
/* 2095 */     var11.a(var25, var7 + var3, var27, var15, var19);
/* 2096 */     var11.a(var25, var7 + 0.0D, var27, var15, var21);
/* 2097 */     var11.a(var23, var7 + 0.0D, var29, var17, var21);
/* 2098 */     var11.a(var23, var7 + var3, var29, var17, var19);
/*      */   }
/*      */   
/*      */   public boolean m(pb var1, int var2, int var3, int var4) {
/* 2102 */     adz var5 = adz.a;
/* 2103 */     int var6 = var1.bN;
/* 2104 */     if (this.d >= 0) {
/* 2105 */       var6 = this.d;
/*      */     }
/*      */     
/* 2108 */     int var7 = (var6 & 0xF) << 4;
/* 2109 */     int var8 = var6 & 0xF0;
/* 2110 */     float var9 = 0.015625F;
/* 2111 */     double var10 = (var7 / 256.0F);
/* 2112 */     double var12 = ((var7 + 15.99F) / 256.0F);
/* 2113 */     double var14 = (var8 / 256.0F);
/* 2114 */     double var16 = ((var8 + 15.99F) / 256.0F);
/* 2115 */     long var18 = (var2 * 3129871) ^ var4 * 116129781L ^ var3;
/* 2116 */     var18 = var18 * var18 * 42317861L + var18 * 11L;
/* 2117 */     int var20 = (int)(var18 >> 16L & 0x3L);
/* 2118 */     var5.b(var1.d(this.a, var2, var3, var4));
/* 2119 */     float var21 = var2 + 0.5F;
/* 2120 */     float var22 = var4 + 0.5F;
/* 2121 */     float var23 = (var20 & 0x1) * 0.5F * (1 - var20 / 2 % 2 * 2);
/* 2122 */     float var24 = (var20 + 1 & 0x1) * 0.5F * (1 - (var20 + 1) / 2 % 2 * 2);
/* 2123 */     var5.c(var1.i());
/* 2124 */     var5.a((var21 + var23 - var24), (var3 + var9), (var22 + var23 + var24), var10, var14);
/* 2125 */     var5.a((var21 + var23 + var24), (var3 + var9), (var22 - var23 + var24), var12, var14);
/* 2126 */     var5.a((var21 - var23 + var24), (var3 + var9), (var22 - var23 - var24), var12, var16);
/* 2127 */     var5.a((var21 - var23 - var24), (var3 + var9), (var22 + var23 - var24), var10, var16);
/* 2128 */     var5.c((var1.i() & 0xFEFEFE) >> 1);
/* 2129 */     var5.a((var21 - var23 - var24), (var3 + var9), (var22 + var23 - var24), var10, var16);
/* 2130 */     var5.a((var21 - var23 + var24), (var3 + var9), (var22 - var23 - var24), var12, var16);
/* 2131 */     var5.a((var21 + var23 + var24), (var3 + var9), (var22 - var23 + var24), var12, var14);
/* 2132 */     var5.a((var21 + var23 - var24), (var3 + var9), (var22 + var23 + var24), var10, var14);
/* 2133 */     return true;
/*      */   }
/*      */   
/*      */   public void a(pb var1, int var2, int var3, double var4, double var6, double var8, double var10) {
/* 2137 */     adz var12 = adz.a;
/* 2138 */     int var13 = var1.a(0, var2) + 16;
/* 2139 */     if (this.d >= 0) {
/* 2140 */       var13 = this.d;
/*      */     }
/*      */     
/* 2143 */     int var14 = (var13 & 0xF) << 4;
/* 2144 */     int var15 = var13 & 0xF0;
/* 2145 */     double var16 = (var14 / 256.0F);
/* 2146 */     double var18 = ((var14 + 15.99F) / 256.0F);
/* 2147 */     double var20 = (var15 / 256.0F);
/* 2148 */     double var22 = (var15 + 15.989999771118164D * var4) / 256.0D;
/* 2149 */     double var24 = var6 + 0.5D - 0.5D;
/* 2150 */     double var26 = var6 + 0.5D + 0.5D;
/* 2151 */     double var28 = var10 + 0.5D - 0.5D;
/* 2152 */     double var30 = var10 + 0.5D + 0.5D;
/* 2153 */     double var32 = var6 + 0.5D;
/* 2154 */     double var34 = var10 + 0.5D;
/* 2155 */     if ((var3 + 1) / 2 % 2 == 1) {
/* 2156 */       double var36 = var18;
/* 2157 */       var18 = var16;
/* 2158 */       var16 = var36;
/*      */     } 
/*      */     
/* 2161 */     if (var3 < 2) {
/* 2162 */       var12.a(var24, var8 + var4, var34, var16, var20);
/* 2163 */       var12.a(var24, var8 + 0.0D, var34, var16, var22);
/* 2164 */       var12.a(var26, var8 + 0.0D, var34, var18, var22);
/* 2165 */       var12.a(var26, var8 + var4, var34, var18, var20);
/* 2166 */       var12.a(var26, var8 + var4, var34, var18, var20);
/* 2167 */       var12.a(var26, var8 + 0.0D, var34, var18, var22);
/* 2168 */       var12.a(var24, var8 + 0.0D, var34, var16, var22);
/* 2169 */       var12.a(var24, var8 + var4, var34, var16, var20);
/*      */     } else {
/* 2171 */       var12.a(var32, var8 + var4, var30, var16, var20);
/* 2172 */       var12.a(var32, var8 + 0.0D, var30, var16, var22);
/* 2173 */       var12.a(var32, var8 + 0.0D, var28, var18, var22);
/* 2174 */       var12.a(var32, var8 + var4, var28, var18, var20);
/* 2175 */       var12.a(var32, var8 + var4, var28, var18, var20);
/* 2176 */       var12.a(var32, var8 + 0.0D, var28, var18, var22);
/* 2177 */       var12.a(var32, var8 + 0.0D, var30, var16, var22);
/* 2178 */       var12.a(var32, var8 + var4, var30, var16, var20);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void b(pb var1, int var2, double var3, double var5, double var7) {
/* 2184 */     adz var9 = adz.a;
/* 2185 */     int var10 = var1.a(0, var2);
/* 2186 */     if (this.d >= 0) {
/* 2187 */       var10 = this.d;
/*      */     }
/*      */     
/* 2190 */     int var11 = (var10 & 0xF) << 4;
/* 2191 */     int var12 = var10 & 0xF0;
/* 2192 */     double var13 = (var11 / 256.0F);
/* 2193 */     double var15 = ((var11 + 15.99F) / 256.0F);
/* 2194 */     double var17 = (var12 / 256.0F);
/* 2195 */     double var19 = ((var12 + 15.99F) / 256.0F);
/* 2196 */     double var21 = var3 + 0.5D - 0.25D;
/* 2197 */     double var23 = var3 + 0.5D + 0.25D;
/* 2198 */     double var25 = var7 + 0.5D - 0.5D;
/* 2199 */     double var27 = var7 + 0.5D + 0.5D;
/* 2200 */     var9.a(var21, var5 + 1.0D, var25, var13, var17);
/* 2201 */     var9.a(var21, var5 + 0.0D, var25, var13, var19);
/* 2202 */     var9.a(var21, var5 + 0.0D, var27, var15, var19);
/* 2203 */     var9.a(var21, var5 + 1.0D, var27, var15, var17);
/* 2204 */     var9.a(var21, var5 + 1.0D, var27, var13, var17);
/* 2205 */     var9.a(var21, var5 + 0.0D, var27, var13, var19);
/* 2206 */     var9.a(var21, var5 + 0.0D, var25, var15, var19);
/* 2207 */     var9.a(var21, var5 + 1.0D, var25, var15, var17);
/* 2208 */     var9.a(var23, var5 + 1.0D, var27, var13, var17);
/* 2209 */     var9.a(var23, var5 + 0.0D, var27, var13, var19);
/* 2210 */     var9.a(var23, var5 + 0.0D, var25, var15, var19);
/* 2211 */     var9.a(var23, var5 + 1.0D, var25, var15, var17);
/* 2212 */     var9.a(var23, var5 + 1.0D, var25, var13, var17);
/* 2213 */     var9.a(var23, var5 + 0.0D, var25, var13, var19);
/* 2214 */     var9.a(var23, var5 + 0.0D, var27, var15, var19);
/* 2215 */     var9.a(var23, var5 + 1.0D, var27, var15, var17);
/* 2216 */     var21 = var3 + 0.5D - 0.5D;
/* 2217 */     var23 = var3 + 0.5D + 0.5D;
/* 2218 */     var25 = var7 + 0.5D - 0.25D;
/* 2219 */     var27 = var7 + 0.5D + 0.25D;
/* 2220 */     var9.a(var21, var5 + 1.0D, var25, var13, var17);
/* 2221 */     var9.a(var21, var5 + 0.0D, var25, var13, var19);
/* 2222 */     var9.a(var23, var5 + 0.0D, var25, var15, var19);
/* 2223 */     var9.a(var23, var5 + 1.0D, var25, var15, var17);
/* 2224 */     var9.a(var23, var5 + 1.0D, var25, var13, var17);
/* 2225 */     var9.a(var23, var5 + 0.0D, var25, var13, var19);
/* 2226 */     var9.a(var21, var5 + 0.0D, var25, var15, var19);
/* 2227 */     var9.a(var21, var5 + 1.0D, var25, var15, var17);
/* 2228 */     var9.a(var23, var5 + 1.0D, var27, var13, var17);
/* 2229 */     var9.a(var23, var5 + 0.0D, var27, var13, var19);
/* 2230 */     var9.a(var21, var5 + 0.0D, var27, var15, var19);
/* 2231 */     var9.a(var21, var5 + 1.0D, var27, var15, var17);
/* 2232 */     var9.a(var21, var5 + 1.0D, var27, var13, var17);
/* 2233 */     var9.a(var21, var5 + 0.0D, var27, var13, var19);
/* 2234 */     var9.a(var23, var5 + 0.0D, var27, var15, var19);
/* 2235 */     var9.a(var23, var5 + 1.0D, var27, var15, var17);
/*      */   }
/*      */   
/*      */   public boolean n(pb var1, int var2, int var3, int var4) {
/* 2239 */     adz var5 = adz.a;
/* 2240 */     int var6 = var1.c(this.a, var2, var3, var4);
/* 2241 */     float var7 = (var6 >> 16 & 0xFF) / 255.0F;
/* 2242 */     float var8 = (var6 >> 8 & 0xFF) / 255.0F;
/* 2243 */     float var9 = (var6 & 0xFF) / 255.0F;
/* 2244 */     boolean var10 = var1.a(this.a, var2, var3 + 1, var4, 1);
/* 2245 */     boolean var11 = var1.a(this.a, var2, var3 - 1, var4, 0);
/* 2246 */     boolean[] var12 = { var1.a(this.a, var2, var3, var4 - 1, 2), var1.a(this.a, var2, var3, var4 + 1, 3), 
/* 2247 */         var1.a(this.a, var2 - 1, var3, var4, 4), var1.a(this.a, var2 + 1, var3, var4, 5) };
/* 2248 */     if (!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
/* 2249 */       return false;
/*      */     }
/* 2251 */     boolean var13 = false;
/* 2252 */     float var14 = 0.5F;
/* 2253 */     float var15 = 1.0F;
/* 2254 */     float var16 = 0.8F;
/* 2255 */     float var17 = 0.6F;
/* 2256 */     double var18 = 0.0D;
/* 2257 */     double var20 = 1.0D;
/* 2258 */     acn var22 = var1.cd;
/* 2259 */     int var23 = this.a.e(var2, var3, var4);
/* 2260 */     double var24 = a(var2, var3, var4, var22);
/* 2261 */     double var26 = a(var2, var3, var4 + 1, var22);
/* 2262 */     double var28 = a(var2 + 1, var3, var4 + 1, var22);
/* 2263 */     double var30 = a(var2 + 1, var3, var4, var22);
/* 2264 */     double var32 = 0.0010000000474974513D;
/*      */ 
/*      */     
/* 2267 */     if (this.f || var10) {
/* 2268 */       var13 = true;
/* 2269 */       int i = var1.a(1, var23);
/* 2270 */       float var35 = (float)agv.a(this.a, var2, var3, var4, var22);
/* 2271 */       if (var35 > -999.0F) {
/* 2272 */         i = var1.a(2, var23);
/*      */       }
/*      */       
/* 2275 */       var24 -= var32;
/* 2276 */       var26 -= var32;
/* 2277 */       var28 -= var32;
/* 2278 */       var30 -= var32;
/* 2279 */       int var36 = (i & 0xF) << 4;
/* 2280 */       int var37 = i & 0xF0;
/* 2281 */       double var38 = (var36 + 8.0D) / 256.0D;
/* 2282 */       double var40 = (var37 + 8.0D) / 256.0D;
/* 2283 */       if (var35 < -999.0F) {
/* 2284 */         var35 = 0.0F;
/*      */       } else {
/* 2286 */         var38 = ((var36 + 16) / 256.0F);
/* 2287 */         var40 = ((var37 + 16) / 256.0F);
/*      */       } 
/*      */       
/* 2290 */       double var42 = (gk.a(var35) * 8.0F) / 256.0D;
/* 2291 */       double var44 = (gk.b(var35) * 8.0F) / 256.0D;
/* 2292 */       var5.b(var1.d(this.a, var2, var3, var4));
/* 2293 */       float var46 = 1.0F;
/* 2294 */       var5.a(var15 * var46 * var7, var15 * var46 * var8, var15 * var46 * var9);
/* 2295 */       var5.a((var2 + 0), var3 + var24, (var4 + 0), var38 - var44 - var42, var40 - var44 + var42);
/* 2296 */       var5.a((var2 + 0), var3 + var26, (var4 + 1), var38 - var44 + var42, var40 + var44 + var42);
/* 2297 */       var5.a((var2 + 1), var3 + var28, (var4 + 1), var38 + var44 + var42, var40 + var44 - var42);
/* 2298 */       var5.a((var2 + 1), var3 + var30, (var4 + 0), var38 + var44 - var42, var40 - var44 - var42);
/*      */     } 
/*      */     
/* 2301 */     if (this.f || var11) {
/* 2302 */       var5.b(var1.d(this.a, var2, var3 - 1, var4));
/* 2303 */       float var65 = 1.0F;
/* 2304 */       var5.a(var14 * var65, var14 * var65, var14 * var65);
/* 2305 */       a(var1, var2, var3 + var32, var4, var1.a_(0));
/* 2306 */       var13 = true;
/*      */     } 
/*      */     
/* 2309 */     for (int var34 = 0; var34 < 4; var34++) {
/* 2310 */       int var64 = var2;
/* 2311 */       int var37 = var4;
/* 2312 */       if (var34 == 0) {
/* 2313 */         var37 = var4 - 1;
/*      */       }
/*      */       
/* 2316 */       if (var34 == 1) {
/* 2317 */         var37++;
/*      */       }
/*      */       
/* 2320 */       if (var34 == 2) {
/* 2321 */         var64 = var2 - 1;
/*      */       }
/*      */       
/* 2324 */       if (var34 == 3) {
/* 2325 */         var64++;
/*      */       }
/*      */       
/* 2328 */       int var66 = var1.a(var34 + 2, var23);
/* 2329 */       int var39 = (var66 & 0xF) << 4;
/* 2330 */       int var67 = var66 & 0xF0;
/* 2331 */       if (this.f || var12[var34]) {
/*      */         double var43, var41, var47, var45, var51, var49;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2338 */         if (var34 == 0) {
/* 2339 */           var41 = var24;
/* 2340 */           var43 = var30;
/* 2341 */           var45 = var2;
/* 2342 */           var49 = (var2 + 1);
/* 2343 */           var47 = var4 + var32;
/* 2344 */           var51 = var4 + var32;
/* 2345 */         } else if (var34 == 1) {
/* 2346 */           var41 = var28;
/* 2347 */           var43 = var26;
/* 2348 */           var45 = (var2 + 1);
/* 2349 */           var49 = var2;
/* 2350 */           var47 = (var4 + 1) - var32;
/* 2351 */           var51 = (var4 + 1) - var32;
/* 2352 */         } else if (var34 == 2) {
/* 2353 */           var41 = var26;
/* 2354 */           var43 = var24;
/* 2355 */           var45 = var2 + var32;
/* 2356 */           var49 = var2 + var32;
/* 2357 */           var47 = (var4 + 1);
/* 2358 */           var51 = var4;
/*      */         } else {
/* 2360 */           var41 = var30;
/* 2361 */           var43 = var28;
/* 2362 */           var45 = (var2 + 1) - var32;
/* 2363 */           var49 = (var2 + 1) - var32;
/* 2364 */           var47 = var4;
/* 2365 */           var51 = (var4 + 1);
/*      */         } 
/*      */         
/* 2368 */         var13 = true;
/* 2369 */         double var53 = ((var39 + 0) / 256.0F);
/* 2370 */         double var55 = ((var39 + 16) - 0.01D) / 256.0D;
/* 2371 */         double var57 = (var67 + (1.0D - var41) * 16.0D) / 256.0D;
/* 2372 */         double var59 = (var67 + (1.0D - var43) * 16.0D) / 256.0D;
/* 2373 */         double var61 = ((var67 + 16) - 0.01D) / 256.0D;
/* 2374 */         var5.b(var1.d(this.a, var64, var3, var37));
/* 2375 */         float var63 = 1.0F;
/* 2376 */         if (var34 < 2) {
/* 2377 */           var63 *= var16;
/*      */         } else {
/* 2379 */           var63 *= var17;
/*      */         } 
/*      */         
/* 2382 */         var5.a(var15 * var63 * var7, var15 * var63 * var8, var15 * var63 * var9);
/* 2383 */         var5.a(var45, var3 + var41, var47, var53, var57);
/* 2384 */         var5.a(var49, var3 + var43, var51, var55, var59);
/* 2385 */         var5.a(var49, (var3 + 0), var51, var55, var61);
/* 2386 */         var5.a(var45, (var3 + 0), var47, var53, var61);
/*      */       } 
/*      */     } 
/*      */     
/* 2390 */     var1.bW = var18;
/* 2391 */     var1.bZ = var20;
/* 2392 */     return var13;
/*      */   }
/*      */ 
/*      */   
/*      */   public float a(int var1, int var2, int var3, acn var4) {
/* 2397 */     int var5 = 0;
/* 2398 */     float var6 = 0.0F;
/*      */     
/* 2400 */     for (int var7 = 0; var7 < 4; var7++) {
/* 2401 */       int var8 = var1 - (var7 & 0x1);
/* 2402 */       int var10 = var3 - (var7 >> 1 & 0x1);
/* 2403 */       if (this.a.f(var8, var2 + 1, var10) == var4) {
/* 2404 */         return 1.0F;
/*      */       }
/*      */       
/* 2407 */       acn var11 = this.a.f(var8, var2, var10);
/* 2408 */       if (var11 == var4) {
/* 2409 */         int var12 = this.a.e(var8, var2, var10);
/* 2410 */         if (var12 >= 8 || var12 == 0) {
/* 2411 */           var6 += agv.e(var12) * 10.0F;
/* 2412 */           var5 += 10;
/*      */         } 
/*      */         
/* 2415 */         var6 += agv.e(var12);
/* 2416 */         var5++;
/* 2417 */       } else if (!var11.a()) {
/* 2418 */         var6++;
/* 2419 */         var5++;
/*      */       } 
/*      */     } 
/*      */     
/* 2423 */     return 1.0F - var6 / var5;
/*      */   }
/*      */   
/*      */   public void a(pb var1, xd var2, int var3, int var4, int var5) {
/* 2427 */     float var6 = 0.5F;
/* 2428 */     float var7 = 1.0F;
/* 2429 */     float var8 = 0.8F;
/* 2430 */     float var9 = 0.6F;
/* 2431 */     adz var10 = adz.a;
/* 2432 */     var10.b();
/* 2433 */     var10.b(var1.d((ali)var2, var3, var4, var5));
/* 2434 */     float var11 = 1.0F;
/* 2435 */     float var12 = 1.0F;
/* 2436 */     if (var12 < var11) {
/* 2437 */       var12 = var11;
/*      */     }
/*      */     
/* 2440 */     var10.a(var6 * var12, var6 * var12, var6 * var12);
/* 2441 */     a(var1, -0.5D, -0.5D, -0.5D, var1.a_(0));
/* 2442 */     var12 = 1.0F;
/* 2443 */     if (var12 < var11) {
/* 2444 */       var12 = var11;
/*      */     }
/*      */     
/* 2447 */     var10.a(var7 * var12, var7 * var12, var7 * var12);
/* 2448 */     b(var1, -0.5D, -0.5D, -0.5D, var1.a_(1));
/* 2449 */     var12 = 1.0F;
/* 2450 */     if (var12 < var11) {
/* 2451 */       var12 = var11;
/*      */     }
/*      */     
/* 2454 */     var10.a(var8 * var12, var8 * var12, var8 * var12);
/* 2455 */     c(var1, -0.5D, -0.5D, -0.5D, var1.a_(2));
/* 2456 */     var12 = 1.0F;
/* 2457 */     if (var12 < var11) {
/* 2458 */       var12 = var11;
/*      */     }
/*      */     
/* 2461 */     var10.a(var8 * var12, var8 * var12, var8 * var12);
/* 2462 */     d(var1, -0.5D, -0.5D, -0.5D, var1.a_(3));
/* 2463 */     var12 = 1.0F;
/* 2464 */     if (var12 < var11) {
/* 2465 */       var12 = var11;
/*      */     }
/*      */     
/* 2468 */     var10.a(var9 * var12, var9 * var12, var9 * var12);
/* 2469 */     e(var1, -0.5D, -0.5D, -0.5D, var1.a_(4));
/* 2470 */     var12 = 1.0F;
/* 2471 */     if (var12 < var11) {
/* 2472 */       var12 = var11;
/*      */     }
/*      */     
/* 2475 */     var10.a(var9 * var12, var9 * var12, var9 * var12);
/* 2476 */     f(var1, -0.5D, -0.5D, -0.5D, var1.a_(5));
/* 2477 */     var10.a();
/*      */   }
/*      */   
/*      */   public boolean o(pb var1, int var2, int var3, int var4) {
/* 2481 */     int var5 = var1.c(this.a, var2, var3, var4);
/* 2482 */     float var6 = (var5 >> 16 & 0xFF) / 255.0F;
/* 2483 */     float var7 = (var5 >> 8 & 0xFF) / 255.0F;
/* 2484 */     float var8 = (var5 & 0xFF) / 255.0F;
/* 2485 */     if (lr.a) {
/* 2486 */       float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
/* 2487 */       float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
/* 2488 */       float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
/* 2489 */       var6 = var9;
/* 2490 */       var7 = var10;
/* 2491 */       var8 = var11;
/*      */     } 
/*      */     
/* 2494 */     return (Minecraft.t() && pb.q[var1.bO] == 0) ? a(var1, var2, var3, var4, var6, var7, var8) : b(var1, var2, var3, var4, var6, var7, var8);
/*      */   }
/*      */   
/*      */   public boolean a(pb var1, int var2, int var3, int var4, float var5, float var6, float var7) {
/* 2498 */     this.m = true;
/* 2499 */     boolean var8 = false;
/* 2500 */     float var9 = this.n;
/* 2501 */     float var10 = this.n;
/* 2502 */     float var11 = this.n;
/* 2503 */     float var12 = this.n;
/* 2504 */     boolean var13 = true;
/* 2505 */     boolean var14 = true;
/* 2506 */     boolean var15 = true;
/* 2507 */     boolean var16 = true;
/* 2508 */     boolean var17 = true;
/* 2509 */     boolean var18 = true;
/* 2510 */     this.n = var1.f(this.a, var2, var3, var4);
/* 2511 */     this.o = var1.f(this.a, var2 - 1, var3, var4);
/* 2512 */     this.p = var1.f(this.a, var2, var3 - 1, var4);
/* 2513 */     this.q = var1.f(this.a, var2, var3, var4 - 1);
/* 2514 */     this.r = var1.f(this.a, var2 + 1, var3, var4);
/* 2515 */     this.s = var1.f(this.a, var2, var3 + 1, var4);
/* 2516 */     this.t = var1.f(this.a, var2, var3, var4 + 1);
/* 2517 */     int var19 = var1.d(this.a, var2, var3, var4);
/* 2518 */     int var20 = var19;
/* 2519 */     int var21 = var19;
/* 2520 */     int var22 = var19;
/* 2521 */     int var23 = var19;
/* 2522 */     int var24 = var19;
/* 2523 */     int var25 = var19;
/* 2524 */     if (var1.bW <= 0.0D) {
/* 2525 */       var21 = var1.d(this.a, var2, var3 - 1, var4);
/*      */     }
/*      */     
/* 2528 */     if (var1.bZ >= 1.0D) {
/* 2529 */       var24 = var1.d(this.a, var2, var3 + 1, var4);
/*      */     }
/*      */     
/* 2532 */     if (var1.bV <= 0.0D) {
/* 2533 */       var20 = var1.d(this.a, var2 - 1, var3, var4);
/*      */     }
/*      */     
/* 2536 */     if (var1.bY >= 1.0D) {
/* 2537 */       var23 = var1.d(this.a, var2 + 1, var3, var4);
/*      */     }
/*      */     
/* 2540 */     if (var1.bX <= 0.0D) {
/* 2541 */       var22 = var1.d(this.a, var2, var3, var4 - 1);
/*      */     }
/*      */     
/* 2544 */     if (var1.ca >= 1.0D) {
/* 2545 */       var25 = var1.d(this.a, var2, var3, var4 + 1);
/*      */     }
/*      */     
/* 2548 */     adz var26 = adz.a;
/* 2549 */     var26.b(983055);
/* 2550 */     this.aA = pb.p[this.a.a(var2 + 1, var3 + 1, var4)];
/* 2551 */     this.aI = pb.p[this.a.a(var2 + 1, var3 - 1, var4)];
/* 2552 */     this.aE = pb.p[this.a.a(var2 + 1, var3, var4 + 1)];
/* 2553 */     this.aG = pb.p[this.a.a(var2 + 1, var3, var4 - 1)];
/* 2554 */     this.aB = pb.p[this.a.a(var2 - 1, var3 + 1, var4)];
/* 2555 */     this.aJ = pb.p[this.a.a(var2 - 1, var3 - 1, var4)];
/* 2556 */     this.aD = pb.p[this.a.a(var2 - 1, var3, var4 - 1)];
/* 2557 */     this.aF = pb.p[this.a.a(var2 - 1, var3, var4 + 1)];
/* 2558 */     this.aC = pb.p[this.a.a(var2, var3 + 1, var4 + 1)];
/* 2559 */     this.az = pb.p[this.a.a(var2, var3 + 1, var4 - 1)];
/* 2560 */     this.aK = pb.p[this.a.a(var2, var3 - 1, var4 + 1)];
/* 2561 */     this.aH = pb.p[this.a.a(var2, var3 - 1, var4 - 1)];
/* 2562 */     if (var1.bN == 3) {
/* 2563 */       var18 = false;
/* 2564 */       var17 = false;
/* 2565 */       var16 = false;
/* 2566 */       var15 = false;
/* 2567 */       var13 = false;
/*      */     } 
/*      */     
/* 2570 */     if (this.d >= 0) {
/* 2571 */       var18 = false;
/* 2572 */       var17 = false;
/* 2573 */       var16 = false;
/* 2574 */       var15 = false;
/* 2575 */       var13 = false;
/*      */     } 
/*      */     
/* 2578 */     if (this.f || var1.a(this.a, var2, var3 - 1, var4, 0)) {
/* 2579 */       if (this.ai > 0) {
/* 2580 */         if (var1.bW <= 0.0D) {
/* 2581 */           var3--;
/*      */         }
/*      */         
/* 2584 */         this.P = var1.d(this.a, var2 - 1, var3, var4);
/* 2585 */         this.R = var1.d(this.a, var2, var3, var4 - 1);
/* 2586 */         this.S = var1.d(this.a, var2, var3, var4 + 1);
/* 2587 */         this.U = var1.d(this.a, var2 + 1, var3, var4);
/* 2588 */         this.v = var1.f(this.a, var2 - 1, var3, var4);
/* 2589 */         this.x = var1.f(this.a, var2, var3, var4 - 1);
/* 2590 */         this.y = var1.f(this.a, var2, var3, var4 + 1);
/* 2591 */         this.A = var1.f(this.a, var2 + 1, var3, var4);
/* 2592 */         if (!this.aH && !this.aJ) {
/* 2593 */           this.u = this.v;
/* 2594 */           this.O = this.P;
/*      */         } else {
/* 2596 */           this.u = var1.f(this.a, var2 - 1, var3, var4 - 1);
/* 2597 */           this.O = var1.d(this.a, var2 - 1, var3, var4 - 1);
/*      */         } 
/*      */         
/* 2600 */         if (!this.aK && !this.aJ) {
/* 2601 */           this.w = this.v;
/* 2602 */           this.Q = this.P;
/*      */         } else {
/* 2604 */           this.w = var1.f(this.a, var2 - 1, var3, var4 + 1);
/* 2605 */           this.Q = var1.d(this.a, var2 - 1, var3, var4 + 1);
/*      */         } 
/*      */         
/* 2608 */         if (!this.aH && !this.aI) {
/* 2609 */           this.z = this.A;
/* 2610 */           this.T = this.U;
/*      */         } else {
/* 2612 */           this.z = var1.f(this.a, var2 + 1, var3, var4 - 1);
/* 2613 */           this.T = var1.d(this.a, var2 + 1, var3, var4 - 1);
/*      */         } 
/*      */         
/* 2616 */         if (!this.aK && !this.aI) {
/* 2617 */           this.B = this.A;
/* 2618 */           this.V = this.U;
/*      */         } else {
/* 2620 */           this.B = var1.f(this.a, var2 + 1, var3, var4 + 1);
/* 2621 */           this.V = var1.d(this.a, var2 + 1, var3, var4 + 1);
/*      */         } 
/*      */         
/* 2624 */         if (var1.bW <= 0.0D) {
/* 2625 */           var3++;
/*      */         }
/*      */         
/* 2628 */         var9 = (this.w + this.v + this.y + this.p) / 4.0F;
/* 2629 */         var12 = (this.y + this.p + this.B + this.A) / 4.0F;
/* 2630 */         var11 = (this.p + this.x + this.A + this.z) / 4.0F;
/* 2631 */         var10 = (this.v + this.u + this.p + this.x) / 4.0F;
/* 2632 */         this.aj = a(this.Q, this.P, this.S, var21);
/* 2633 */         this.am = a(this.S, this.V, this.U, var21);
/* 2634 */         this.al = a(this.R, this.U, this.T, var21);
/* 2635 */         this.ak = a(this.P, this.O, this.R, var21);
/*      */       } else {
/* 2637 */         var12 = this.p;
/* 2638 */         var11 = this.p;
/* 2639 */         var10 = this.p;
/* 2640 */         var9 = this.p;
/* 2641 */         this.aj = this.ak = this.al = this.am = this.P;
/*      */       } 
/*      */       
/* 2644 */       this.an = this.ao = this.ap = this.aq = (var13 ? var5 : 1.0F) * 0.5F;
/* 2645 */       this.ar = this.as = this.at = this.au = (var13 ? var6 : 1.0F) * 0.5F;
/* 2646 */       this.av = this.aw = this.ax = this.ay = (var13 ? var7 : 1.0F) * 0.5F;
/* 2647 */       this.an *= var9;
/* 2648 */       this.ar *= var9;
/* 2649 */       this.av *= var9;
/* 2650 */       this.ao *= var10;
/* 2651 */       this.as *= var10;
/* 2652 */       this.aw *= var10;
/* 2653 */       this.ap *= var11;
/* 2654 */       this.at *= var11;
/* 2655 */       this.ax *= var11;
/* 2656 */       this.aq *= var12;
/* 2657 */       this.au *= var12;
/* 2658 */       this.ay *= var12;
/* 2659 */       a(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 0));
/* 2660 */       var8 = true;
/*      */     } 
/*      */     
/* 2663 */     if (this.f || var1.a(this.a, var2, var3 + 1, var4, 1)) {
/* 2664 */       if (this.ai > 0) {
/* 2665 */         if (var1.bZ >= 1.0D) {
/* 2666 */           var3++;
/*      */         }
/*      */         
/* 2669 */         this.X = var1.d(this.a, var2 - 1, var3, var4);
/* 2670 */         this.ab = var1.d(this.a, var2 + 1, var3, var4);
/* 2671 */         this.Z = var1.d(this.a, var2, var3, var4 - 1);
/* 2672 */         this.ac = var1.d(this.a, var2, var3, var4 + 1);
/* 2673 */         this.D = var1.f(this.a, var2 - 1, var3, var4);
/* 2674 */         this.H = var1.f(this.a, var2 + 1, var3, var4);
/* 2675 */         this.F = var1.f(this.a, var2, var3, var4 - 1);
/* 2676 */         this.I = var1.f(this.a, var2, var3, var4 + 1);
/* 2677 */         if (!this.az && !this.aB) {
/* 2678 */           this.C = this.D;
/* 2679 */           this.W = this.X;
/*      */         } else {
/* 2681 */           this.C = var1.f(this.a, var2 - 1, var3, var4 - 1);
/* 2682 */           this.W = var1.d(this.a, var2 - 1, var3, var4 - 1);
/*      */         } 
/*      */         
/* 2685 */         if (!this.az && !this.aA) {
/* 2686 */           this.G = this.H;
/* 2687 */           this.aa = this.ab;
/*      */         } else {
/* 2689 */           this.G = var1.f(this.a, var2 + 1, var3, var4 - 1);
/* 2690 */           this.aa = var1.d(this.a, var2 + 1, var3, var4 - 1);
/*      */         } 
/*      */         
/* 2693 */         if (!this.aC && !this.aB) {
/* 2694 */           this.E = this.D;
/* 2695 */           this.Y = this.X;
/*      */         } else {
/* 2697 */           this.E = var1.f(this.a, var2 - 1, var3, var4 + 1);
/* 2698 */           this.Y = var1.d(this.a, var2 - 1, var3, var4 + 1);
/*      */         } 
/*      */         
/* 2701 */         if (!this.aC && !this.aA) {
/* 2702 */           this.J = this.H;
/* 2703 */           this.ad = this.ab;
/*      */         } else {
/* 2705 */           this.J = var1.f(this.a, var2 + 1, var3, var4 + 1);
/* 2706 */           this.ad = var1.d(this.a, var2 + 1, var3, var4 + 1);
/*      */         } 
/*      */         
/* 2709 */         if (var1.bZ >= 1.0D) {
/* 2710 */           var3--;
/*      */         }
/*      */         
/* 2713 */         var12 = (this.E + this.D + this.I + this.s) / 4.0F;
/* 2714 */         var9 = (this.I + this.s + this.J + this.H) / 4.0F;
/* 2715 */         var10 = (this.s + this.F + this.H + this.G) / 4.0F;
/* 2716 */         var11 = (this.D + this.C + this.s + this.F) / 4.0F;
/* 2717 */         this.am = a(this.Y, this.X, this.ac, var24);
/* 2718 */         this.aj = a(this.ac, this.ad, this.ab, var24);
/* 2719 */         this.ak = a(this.Z, this.ab, this.aa, var24);
/* 2720 */         this.al = a(this.X, this.W, this.Z, var24);
/*      */       } else {
/* 2722 */         var12 = this.s;
/* 2723 */         var11 = this.s;
/* 2724 */         var10 = this.s;
/* 2725 */         var9 = this.s;
/* 2726 */         this.aj = this.ak = this.al = this.am = var24;
/*      */       } 
/*      */       
/* 2729 */       this.an = this.ao = this.ap = this.aq = var14 ? var5 : 1.0F;
/* 2730 */       this.ar = this.as = this.at = this.au = var14 ? var6 : 1.0F;
/* 2731 */       this.av = this.aw = this.ax = this.ay = var14 ? var7 : 1.0F;
/* 2732 */       this.an *= var9;
/* 2733 */       this.ar *= var9;
/* 2734 */       this.av *= var9;
/* 2735 */       this.ao *= var10;
/* 2736 */       this.as *= var10;
/* 2737 */       this.aw *= var10;
/* 2738 */       this.ap *= var11;
/* 2739 */       this.at *= var11;
/* 2740 */       this.ax *= var11;
/* 2741 */       this.aq *= var12;
/* 2742 */       this.au *= var12;
/* 2743 */       this.ay *= var12;
/* 2744 */       b(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 1));
/* 2745 */       var8 = true;
/*      */     } 
/*      */ 
/*      */     
/* 2749 */     if (this.f || var1.a(this.a, var2, var3, var4 - 1, 2)) {
/* 2750 */       if (this.ai > 0) {
/* 2751 */         if (var1.bX <= 0.0D) {
/* 2752 */           var4--;
/*      */         }
/*      */         
/* 2755 */         this.K = var1.f(this.a, var2 - 1, var3, var4);
/* 2756 */         this.x = var1.f(this.a, var2, var3 - 1, var4);
/* 2757 */         this.F = var1.f(this.a, var2, var3 + 1, var4);
/* 2758 */         this.L = var1.f(this.a, var2 + 1, var3, var4);
/* 2759 */         this.ae = var1.d(this.a, var2 - 1, var3, var4);
/* 2760 */         this.R = var1.d(this.a, var2, var3 - 1, var4);
/* 2761 */         this.Z = var1.d(this.a, var2, var3 + 1, var4);
/* 2762 */         this.af = var1.d(this.a, var2 + 1, var3, var4);
/* 2763 */         if (!this.aD && !this.aH) {
/* 2764 */           this.u = this.K;
/* 2765 */           this.O = this.ae;
/*      */         } else {
/* 2767 */           this.u = var1.f(this.a, var2 - 1, var3 - 1, var4);
/* 2768 */           this.O = var1.d(this.a, var2 - 1, var3 - 1, var4);
/*      */         } 
/*      */         
/* 2771 */         if (!this.aD && !this.az) {
/* 2772 */           this.C = this.K;
/* 2773 */           this.W = this.ae;
/*      */         } else {
/* 2775 */           this.C = var1.f(this.a, var2 - 1, var3 + 1, var4);
/* 2776 */           this.W = var1.d(this.a, var2 - 1, var3 + 1, var4);
/*      */         } 
/*      */         
/* 2779 */         if (!this.aG && !this.aH) {
/* 2780 */           this.z = this.L;
/* 2781 */           this.T = this.af;
/*      */         } else {
/* 2783 */           this.z = var1.f(this.a, var2 + 1, var3 - 1, var4);
/* 2784 */           this.T = var1.d(this.a, var2 + 1, var3 - 1, var4);
/*      */         } 
/*      */         
/* 2787 */         if (!this.aG && !this.az) {
/* 2788 */           this.G = this.L;
/* 2789 */           this.aa = this.af;
/*      */         } else {
/* 2791 */           this.G = var1.f(this.a, var2 + 1, var3 + 1, var4);
/* 2792 */           this.aa = var1.d(this.a, var2 + 1, var3 + 1, var4);
/*      */         } 
/*      */         
/* 2795 */         if (var1.bX <= 0.0D) {
/* 2796 */           var4++;
/*      */         }
/*      */         
/* 2799 */         var9 = (this.K + this.C + this.q + this.F) / 4.0F;
/* 2800 */         var10 = (this.q + this.F + this.L + this.G) / 4.0F;
/* 2801 */         var11 = (this.x + this.q + this.z + this.L) / 4.0F;
/* 2802 */         var12 = (this.u + this.K + this.x + this.q) / 4.0F;
/* 2803 */         this.aj = a(this.ae, this.W, this.Z, var22);
/* 2804 */         this.ak = a(this.Z, this.af, this.aa, var22);
/* 2805 */         this.al = a(this.R, this.T, this.af, var22);
/* 2806 */         this.am = a(this.O, this.ae, this.R, var22);
/*      */       } else {
/* 2808 */         var12 = this.q;
/* 2809 */         var11 = this.q;
/* 2810 */         var10 = this.q;
/* 2811 */         var9 = this.q;
/* 2812 */         this.aj = this.ak = this.al = this.am = var22;
/*      */       } 
/*      */       
/* 2815 */       this.an = this.ao = this.ap = this.aq = (var15 ? var5 : 1.0F) * 0.8F;
/* 2816 */       this.ar = this.as = this.at = this.au = (var15 ? var6 : 1.0F) * 0.8F;
/* 2817 */       this.av = this.aw = this.ax = this.ay = (var15 ? var7 : 1.0F) * 0.8F;
/* 2818 */       this.an *= var9;
/* 2819 */       this.ar *= var9;
/* 2820 */       this.av *= var9;
/* 2821 */       this.ao *= var10;
/* 2822 */       this.as *= var10;
/* 2823 */       this.aw *= var10;
/* 2824 */       this.ap *= var11;
/* 2825 */       this.at *= var11;
/* 2826 */       this.ax *= var11;
/* 2827 */       this.aq *= var12;
/* 2828 */       this.au *= var12;
/* 2829 */       this.ay *= var12;
/* 2830 */       int var27 = var1.d(this.a, var2, var3, var4, 2);
/* 2831 */       c(var1, var2, var3, var4, var27);
/* 2832 */       if (cfgGrassFix && var27 == 3 && this.d < 0) {
/* 2833 */         this.an *= var5;
/* 2834 */         this.ao *= var5;
/* 2835 */         this.ap *= var5;
/* 2836 */         this.aq *= var5;
/* 2837 */         this.ar *= var6;
/* 2838 */         this.as *= var6;
/* 2839 */         this.at *= var6;
/* 2840 */         this.au *= var6;
/* 2841 */         this.av *= var7;
/* 2842 */         this.aw *= var7;
/* 2843 */         this.ax *= var7;
/* 2844 */         this.ay *= var7;
/* 2845 */         c(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 2848 */       var8 = true;
/*      */     } 
/*      */     
/* 2851 */     if (this.f || var1.a(this.a, var2, var3, var4 + 1, 3)) {
/* 2852 */       if (this.ai > 0) {
/* 2853 */         if (var1.ca >= 1.0D) {
/* 2854 */           var4++;
/*      */         }
/*      */         
/* 2857 */         this.M = var1.f(this.a, var2 - 1, var3, var4);
/* 2858 */         this.N = var1.f(this.a, var2 + 1, var3, var4);
/* 2859 */         this.y = var1.f(this.a, var2, var3 - 1, var4);
/* 2860 */         this.I = var1.f(this.a, var2, var3 + 1, var4);
/* 2861 */         this.ag = var1.d(this.a, var2 - 1, var3, var4);
/* 2862 */         this.ah = var1.d(this.a, var2 + 1, var3, var4);
/* 2863 */         this.S = var1.d(this.a, var2, var3 - 1, var4);
/* 2864 */         this.ac = var1.d(this.a, var2, var3 + 1, var4);
/* 2865 */         if (!this.aF && !this.aK) {
/* 2866 */           this.w = this.M;
/* 2867 */           this.Q = this.ag;
/*      */         } else {
/* 2869 */           this.w = var1.f(this.a, var2 - 1, var3 - 1, var4);
/* 2870 */           this.Q = var1.d(this.a, var2 - 1, var3 - 1, var4);
/*      */         } 
/*      */         
/* 2873 */         if (!this.aF && !this.aC) {
/* 2874 */           this.E = this.M;
/* 2875 */           this.Y = this.ag;
/*      */         } else {
/* 2877 */           this.E = var1.f(this.a, var2 - 1, var3 + 1, var4);
/* 2878 */           this.Y = var1.d(this.a, var2 - 1, var3 + 1, var4);
/*      */         } 
/*      */         
/* 2881 */         if (!this.aE && !this.aK) {
/* 2882 */           this.B = this.N;
/* 2883 */           this.V = this.ah;
/*      */         } else {
/* 2885 */           this.B = var1.f(this.a, var2 + 1, var3 - 1, var4);
/* 2886 */           this.V = var1.d(this.a, var2 + 1, var3 - 1, var4);
/*      */         } 
/*      */         
/* 2889 */         if (!this.aE && !this.aC) {
/* 2890 */           this.J = this.N;
/* 2891 */           this.ad = this.ah;
/*      */         } else {
/* 2893 */           this.J = var1.f(this.a, var2 + 1, var3 + 1, var4);
/* 2894 */           this.ad = var1.d(this.a, var2 + 1, var3 + 1, var4);
/*      */         } 
/*      */         
/* 2897 */         if (var1.ca >= 1.0D) {
/* 2898 */           var4--;
/*      */         }
/*      */         
/* 2901 */         var9 = (this.M + this.E + this.t + this.I) / 4.0F;
/* 2902 */         var12 = (this.t + this.I + this.N + this.J) / 4.0F;
/* 2903 */         var11 = (this.y + this.t + this.B + this.N) / 4.0F;
/* 2904 */         var10 = (this.w + this.M + this.y + this.t) / 4.0F;
/* 2905 */         this.aj = a(this.ag, this.Y, this.ac, var25);
/* 2906 */         this.am = a(this.ac, this.ah, this.ad, var25);
/* 2907 */         this.al = a(this.S, this.V, this.ah, var25);
/* 2908 */         this.ak = a(this.Q, this.ag, this.S, var25);
/*      */       } else {
/* 2910 */         var12 = this.t;
/* 2911 */         var11 = this.t;
/* 2912 */         var10 = this.t;
/* 2913 */         var9 = this.t;
/* 2914 */         this.aj = this.ak = this.al = this.am = var25;
/*      */       } 
/*      */       
/* 2917 */       this.an = this.ao = this.ap = this.aq = (var16 ? var5 : 1.0F) * 0.8F;
/* 2918 */       this.ar = this.as = this.at = this.au = (var16 ? var6 : 1.0F) * 0.8F;
/* 2919 */       this.av = this.aw = this.ax = this.ay = (var16 ? var7 : 1.0F) * 0.8F;
/* 2920 */       this.an *= var9;
/* 2921 */       this.ar *= var9;
/* 2922 */       this.av *= var9;
/* 2923 */       this.ao *= var10;
/* 2924 */       this.as *= var10;
/* 2925 */       this.aw *= var10;
/* 2926 */       this.ap *= var11;
/* 2927 */       this.at *= var11;
/* 2928 */       this.ax *= var11;
/* 2929 */       this.aq *= var12;
/* 2930 */       this.au *= var12;
/* 2931 */       this.ay *= var12;
/* 2932 */       int var27 = var1.d(this.a, var2, var3, var4, 3);
/* 2933 */       d(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 3));
/* 2934 */       if (cfgGrassFix && var27 == 3 && this.d < 0) {
/* 2935 */         this.an *= var5;
/* 2936 */         this.ao *= var5;
/* 2937 */         this.ap *= var5;
/* 2938 */         this.aq *= var5;
/* 2939 */         this.ar *= var6;
/* 2940 */         this.as *= var6;
/* 2941 */         this.at *= var6;
/* 2942 */         this.au *= var6;
/* 2943 */         this.av *= var7;
/* 2944 */         this.aw *= var7;
/* 2945 */         this.ax *= var7;
/* 2946 */         this.ay *= var7;
/* 2947 */         d(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 2950 */       var8 = true;
/*      */     } 
/*      */     
/* 2953 */     if (this.f || var1.a(this.a, var2 - 1, var3, var4, 4)) {
/* 2954 */       if (this.ai > 0) {
/* 2955 */         if (var1.bV <= 0.0D) {
/* 2956 */           var2--;
/*      */         }
/*      */         
/* 2959 */         this.v = var1.f(this.a, var2, var3 - 1, var4);
/* 2960 */         this.K = var1.f(this.a, var2, var3, var4 - 1);
/* 2961 */         this.M = var1.f(this.a, var2, var3, var4 + 1);
/* 2962 */         this.D = var1.f(this.a, var2, var3 + 1, var4);
/* 2963 */         this.P = var1.d(this.a, var2, var3 - 1, var4);
/* 2964 */         this.ae = var1.d(this.a, var2, var3, var4 - 1);
/* 2965 */         this.ag = var1.d(this.a, var2, var3, var4 + 1);
/* 2966 */         this.X = var1.d(this.a, var2, var3 + 1, var4);
/* 2967 */         if (!this.aD && !this.aJ) {
/* 2968 */           this.u = this.K;
/* 2969 */           this.O = this.ae;
/*      */         } else {
/* 2971 */           this.u = var1.f(this.a, var2, var3 - 1, var4 - 1);
/* 2972 */           this.O = var1.d(this.a, var2, var3 - 1, var4 - 1);
/*      */         } 
/*      */         
/* 2975 */         if (!this.aF && !this.aJ) {
/* 2976 */           this.w = this.M;
/* 2977 */           this.Q = this.ag;
/*      */         } else {
/* 2979 */           this.w = var1.f(this.a, var2, var3 - 1, var4 + 1);
/* 2980 */           this.Q = var1.d(this.a, var2, var3 - 1, var4 + 1);
/*      */         } 
/*      */         
/* 2983 */         if (!this.aD && !this.aB) {
/* 2984 */           this.C = this.K;
/* 2985 */           this.W = this.ae;
/*      */         } else {
/* 2987 */           this.C = var1.f(this.a, var2, var3 + 1, var4 - 1);
/* 2988 */           this.W = var1.d(this.a, var2, var3 + 1, var4 - 1);
/*      */         } 
/*      */         
/* 2991 */         if (!this.aF && !this.aB) {
/* 2992 */           this.E = this.M;
/* 2993 */           this.Y = this.ag;
/*      */         } else {
/* 2995 */           this.E = var1.f(this.a, var2, var3 + 1, var4 + 1);
/* 2996 */           this.Y = var1.d(this.a, var2, var3 + 1, var4 + 1);
/*      */         } 
/*      */         
/* 2999 */         if (var1.bV <= 0.0D) {
/* 3000 */           var2++;
/*      */         }
/*      */         
/* 3003 */         var12 = (this.v + this.w + this.o + this.M) / 4.0F;
/* 3004 */         var9 = (this.o + this.M + this.D + this.E) / 4.0F;
/* 3005 */         var10 = (this.K + this.o + this.C + this.D) / 4.0F;
/* 3006 */         var11 = (this.u + this.v + this.K + this.o) / 4.0F;
/* 3007 */         this.am = a(this.P, this.Q, this.ag, var20);
/* 3008 */         this.aj = a(this.ag, this.X, this.Y, var20);
/* 3009 */         this.ak = a(this.ae, this.W, this.X, var20);
/* 3010 */         this.al = a(this.O, this.P, this.ae, var20);
/*      */       } else {
/* 3012 */         var12 = this.o;
/* 3013 */         var11 = this.o;
/* 3014 */         var10 = this.o;
/* 3015 */         var9 = this.o;
/* 3016 */         this.aj = this.ak = this.al = this.am = var20;
/*      */       } 
/*      */       
/* 3019 */       this.an = this.ao = this.ap = this.aq = (var17 ? var5 : 1.0F) * 0.6F;
/* 3020 */       this.ar = this.as = this.at = this.au = (var17 ? var6 : 1.0F) * 0.6F;
/* 3021 */       this.av = this.aw = this.ax = this.ay = (var17 ? var7 : 1.0F) * 0.6F;
/* 3022 */       this.an *= var9;
/* 3023 */       this.ar *= var9;
/* 3024 */       this.av *= var9;
/* 3025 */       this.ao *= var10;
/* 3026 */       this.as *= var10;
/* 3027 */       this.aw *= var10;
/* 3028 */       this.ap *= var11;
/* 3029 */       this.at *= var11;
/* 3030 */       this.ax *= var11;
/* 3031 */       this.aq *= var12;
/* 3032 */       this.au *= var12;
/* 3033 */       this.ay *= var12;
/* 3034 */       int var27 = var1.d(this.a, var2, var3, var4, 4);
/* 3035 */       e(var1, var2, var3, var4, var27);
/* 3036 */       if (cfgGrassFix && var27 == 3 && this.d < 0) {
/* 3037 */         this.an *= var5;
/* 3038 */         this.ao *= var5;
/* 3039 */         this.ap *= var5;
/* 3040 */         this.aq *= var5;
/* 3041 */         this.ar *= var6;
/* 3042 */         this.as *= var6;
/* 3043 */         this.at *= var6;
/* 3044 */         this.au *= var6;
/* 3045 */         this.av *= var7;
/* 3046 */         this.aw *= var7;
/* 3047 */         this.ax *= var7;
/* 3048 */         this.ay *= var7;
/* 3049 */         e(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3052 */       var8 = true;
/*      */     } 
/*      */     
/* 3055 */     if (this.f || var1.a(this.a, var2 + 1, var3, var4, 5)) {
/* 3056 */       if (this.ai > 0) {
/* 3057 */         if (var1.bY >= 1.0D) {
/* 3058 */           var2++;
/*      */         }
/*      */         
/* 3061 */         this.A = var1.f(this.a, var2, var3 - 1, var4);
/* 3062 */         this.L = var1.f(this.a, var2, var3, var4 - 1);
/* 3063 */         this.N = var1.f(this.a, var2, var3, var4 + 1);
/* 3064 */         this.H = var1.f(this.a, var2, var3 + 1, var4);
/* 3065 */         this.U = var1.d(this.a, var2, var3 - 1, var4);
/* 3066 */         this.af = var1.d(this.a, var2, var3, var4 - 1);
/* 3067 */         this.ah = var1.d(this.a, var2, var3, var4 + 1);
/* 3068 */         this.ab = var1.d(this.a, var2, var3 + 1, var4);
/* 3069 */         if (!this.aI && !this.aG) {
/* 3070 */           this.z = this.L;
/* 3071 */           this.T = this.af;
/*      */         } else {
/* 3073 */           this.z = var1.f(this.a, var2, var3 - 1, var4 - 1);
/* 3074 */           this.T = var1.d(this.a, var2, var3 - 1, var4 - 1);
/*      */         } 
/*      */         
/* 3077 */         if (!this.aI && !this.aE) {
/* 3078 */           this.B = this.N;
/* 3079 */           this.V = this.ah;
/*      */         } else {
/* 3081 */           this.B = var1.f(this.a, var2, var3 - 1, var4 + 1);
/* 3082 */           this.V = var1.d(this.a, var2, var3 - 1, var4 + 1);
/*      */         } 
/*      */         
/* 3085 */         if (!this.aA && !this.aG) {
/* 3086 */           this.G = this.L;
/* 3087 */           this.aa = this.af;
/*      */         } else {
/* 3089 */           this.G = var1.f(this.a, var2, var3 + 1, var4 - 1);
/* 3090 */           this.aa = var1.d(this.a, var2, var3 + 1, var4 - 1);
/*      */         } 
/*      */         
/* 3093 */         if (!this.aA && !this.aE) {
/* 3094 */           this.J = this.N;
/* 3095 */           this.ad = this.ah;
/*      */         } else {
/* 3097 */           this.J = var1.f(this.a, var2, var3 + 1, var4 + 1);
/* 3098 */           this.ad = var1.d(this.a, var2, var3 + 1, var4 + 1);
/*      */         } 
/*      */         
/* 3101 */         if (var1.bY >= 1.0D) {
/* 3102 */           var2--;
/*      */         }
/*      */         
/* 3105 */         var9 = (this.A + this.B + this.r + this.N) / 4.0F;
/* 3106 */         var12 = (this.r + this.N + this.H + this.J) / 4.0F;
/* 3107 */         var11 = (this.L + this.r + this.G + this.H) / 4.0F;
/* 3108 */         var10 = (this.z + this.A + this.L + this.r) / 4.0F;
/* 3109 */         this.aj = a(this.U, this.V, this.ah, var23);
/* 3110 */         this.am = a(this.ah, this.ab, this.ad, var23);
/* 3111 */         this.al = a(this.af, this.aa, this.ab, var23);
/* 3112 */         this.ak = a(this.T, this.U, this.af, var23);
/*      */       } else {
/* 3114 */         var12 = this.r;
/* 3115 */         var11 = this.r;
/* 3116 */         var10 = this.r;
/* 3117 */         var9 = this.r;
/* 3118 */         this.aj = this.ak = this.al = this.am = var23;
/*      */       } 
/*      */       
/* 3121 */       this.an = this.ao = this.ap = this.aq = (var18 ? var5 : 1.0F) * 0.6F;
/* 3122 */       this.ar = this.as = this.at = this.au = (var18 ? var6 : 1.0F) * 0.6F;
/* 3123 */       this.av = this.aw = this.ax = this.ay = (var18 ? var7 : 1.0F) * 0.6F;
/* 3124 */       this.an *= var9;
/* 3125 */       this.ar *= var9;
/* 3126 */       this.av *= var9;
/* 3127 */       this.ao *= var10;
/* 3128 */       this.as *= var10;
/* 3129 */       this.aw *= var10;
/* 3130 */       this.ap *= var11;
/* 3131 */       this.at *= var11;
/* 3132 */       this.ax *= var11;
/* 3133 */       this.aq *= var12;
/* 3134 */       this.au *= var12;
/* 3135 */       this.ay *= var12;
/* 3136 */       int var27 = var1.d(this.a, var2, var3, var4, 5);
/* 3137 */       f(var1, var2, var3, var4, var27);
/* 3138 */       if (cfgGrassFix && var27 == 3 && this.d < 0) {
/* 3139 */         this.an *= var5;
/* 3140 */         this.ao *= var5;
/* 3141 */         this.ap *= var5;
/* 3142 */         this.aq *= var5;
/* 3143 */         this.ar *= var6;
/* 3144 */         this.as *= var6;
/* 3145 */         this.at *= var6;
/* 3146 */         this.au *= var6;
/* 3147 */         this.av *= var7;
/* 3148 */         this.aw *= var7;
/* 3149 */         this.ax *= var7;
/* 3150 */         this.ay *= var7;
/* 3151 */         f(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3154 */       var8 = true;
/*      */     } 
/*      */     
/* 3157 */     this.m = false;
/* 3158 */     return var8;
/*      */   }
/*      */   
/*      */   public int a(int var1, int var2, int var3, int var4) {
/* 3162 */     if (var1 == 0) {
/* 3163 */       var1 = var4;
/*      */     }
/*      */     
/* 3166 */     if (var2 == 0) {
/* 3167 */       var2 = var4;
/*      */     }
/*      */     
/* 3170 */     if (var3 == 0) {
/* 3171 */       var3 = var4;
/*      */     }
/*      */     
/* 3174 */     return var1 + var2 + var3 + var4 >> 2 & 0xFF00FF;
/*      */   }
/*      */   
/*      */   public boolean b(pb var1, int var2, int var3, int var4, float var5, float var6, float var7) {
/* 3178 */     this.m = false;
/* 3179 */     adz var8 = adz.a;
/* 3180 */     boolean var9 = false;
/* 3181 */     float var10 = 0.5F;
/* 3182 */     float var11 = 1.0F;
/* 3183 */     float var12 = 0.8F;
/* 3184 */     float var13 = 0.6F;
/* 3185 */     float var14 = var11 * var5;
/* 3186 */     float var15 = var11 * var6;
/* 3187 */     float var16 = var11 * var7;
/* 3188 */     float var17 = var10;
/* 3189 */     float var18 = var12;
/* 3190 */     float var19 = var13;
/* 3191 */     float var20 = var10;
/* 3192 */     float var21 = var12;
/* 3193 */     float var22 = var13;
/* 3194 */     float var23 = var10;
/* 3195 */     float var24 = var12;
/* 3196 */     float var25 = var13;
/* 3197 */     if (var1 != pb.u) {
/* 3198 */       var17 = var10 * var5;
/* 3199 */       var18 = var12 * var5;
/* 3200 */       var19 = var13 * var5;
/* 3201 */       var20 = var10 * var6;
/* 3202 */       var21 = var12 * var6;
/* 3203 */       var22 = var13 * var6;
/* 3204 */       var23 = var10 * var7;
/* 3205 */       var24 = var12 * var7;
/* 3206 */       var25 = var13 * var7;
/*      */     } 
/*      */     
/* 3209 */     int var26 = var1.d(this.a, var2, var3, var4);
/* 3210 */     if (this.f || var1.a(this.a, var2, var3 - 1, var4, 0)) {
/* 3211 */       var8.b((var1.bW > 0.0D) ? var26 : var1.d(this.a, var2, var3 - 1, var4));
/* 3212 */       var8.a(var17, var20, var23);
/* 3213 */       a(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 0));
/* 3214 */       var9 = true;
/*      */     } 
/*      */     
/* 3217 */     if (this.f || var1.a(this.a, var2, var3 + 1, var4, 1)) {
/* 3218 */       var8.b((var1.bZ < 1.0D) ? var26 : var1.d(this.a, var2, var3 + 1, var4));
/* 3219 */       var8.a(var14, var15, var16);
/* 3220 */       b(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 1));
/* 3221 */       var9 = true;
/*      */     } 
/*      */ 
/*      */     
/* 3225 */     if (this.f || var1.a(this.a, var2, var3, var4 - 1, 2)) {
/* 3226 */       var8.b((var1.bX > 0.0D) ? var26 : var1.d(this.a, var2, var3, var4 - 1));
/* 3227 */       var8.a(var18, var21, var24);
/* 3228 */       int var28 = var1.d(this.a, var2, var3, var4, 2);
/* 3229 */       c(var1, var2, var3, var4, var28);
/* 3230 */       if (cfgGrassFix && var28 == 3 && this.d < 0) {
/* 3231 */         var8.a(var18 * var5, var21 * var6, var24 * var7);
/* 3232 */         c(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3235 */       var9 = true;
/*      */     } 
/*      */     
/* 3238 */     if (this.f || var1.a(this.a, var2, var3, var4 + 1, 3)) {
/* 3239 */       var8.b((var1.ca < 1.0D) ? var26 : var1.d(this.a, var2, var3, var4 + 1));
/* 3240 */       var8.a(var18, var21, var24);
/* 3241 */       int var28 = var1.d(this.a, var2, var3, var4, 3);
/* 3242 */       d(var1, var2, var3, var4, var28);
/* 3243 */       if (cfgGrassFix && var28 == 3 && this.d < 0) {
/* 3244 */         var8.a(var18 * var5, var21 * var6, var24 * var7);
/* 3245 */         d(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3248 */       var9 = true;
/*      */     } 
/*      */     
/* 3251 */     if (this.f || var1.a(this.a, var2 - 1, var3, var4, 4)) {
/* 3252 */       var8.b((var1.bV > 0.0D) ? var26 : var1.d(this.a, var2 - 1, var3, var4));
/* 3253 */       var8.a(var19, var22, var25);
/* 3254 */       int var28 = var1.d(this.a, var2, var3, var4, 4);
/* 3255 */       e(var1, var2, var3, var4, var28);
/* 3256 */       if (cfgGrassFix && var28 == 3 && this.d < 0) {
/* 3257 */         var8.a(var19 * var5, var22 * var6, var25 * var7);
/* 3258 */         e(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3261 */       var9 = true;
/*      */     } 
/*      */     
/* 3264 */     if (this.f || var1.a(this.a, var2 + 1, var3, var4, 5)) {
/* 3265 */       var8.b((var1.bY < 1.0D) ? var26 : var1.d(this.a, var2 + 1, var3, var4));
/* 3266 */       var8.a(var19, var22, var25);
/* 3267 */       int var28 = var1.d(this.a, var2, var3, var4, 5);
/* 3268 */       f(var1, var2, var3, var4, var28);
/* 3269 */       if (cfgGrassFix && var28 == 3 && this.d < 0) {
/* 3270 */         var8.a(var19 * var5, var22 * var6, var25 * var7);
/* 3271 */         f(var1, var2, var3, var4, 38);
/*      */       } 
/*      */       
/* 3274 */       var9 = true;
/*      */     } 
/*      */     
/* 3277 */     return var9;
/*      */   }
/*      */   
/*      */   public boolean p(pb var1, int var2, int var3, int var4) {
/* 3281 */     int var5 = var1.c(this.a, var2, var3, var4);
/* 3282 */     float var6 = (var5 >> 16 & 0xFF) / 255.0F;
/* 3283 */     float var7 = (var5 >> 8 & 0xFF) / 255.0F;
/* 3284 */     float var8 = (var5 & 0xFF) / 255.0F;
/* 3285 */     if (lr.a) {
/* 3286 */       float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
/* 3287 */       float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
/* 3288 */       float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
/* 3289 */       var6 = var9;
/* 3290 */       var7 = var10;
/* 3291 */       var8 = var11;
/*      */     } 
/*      */     
/* 3294 */     return c(var1, var2, var3, var4, var6, var7, var8);
/*      */   }
/*      */   
/*      */   public boolean c(pb var1, int var2, int var3, int var4, float var5, float var6, float var7) {
/* 3298 */     adz var8 = adz.a;
/* 3299 */     boolean var9 = false;
/* 3300 */     float var10 = 0.5F;
/* 3301 */     float var11 = 1.0F;
/* 3302 */     float var12 = 0.8F;
/* 3303 */     float var13 = 0.6F;
/* 3304 */     float var14 = var10 * var5;
/* 3305 */     float var15 = var11 * var5;
/* 3306 */     float var16 = var12 * var5;
/* 3307 */     float var17 = var13 * var5;
/* 3308 */     float var18 = var10 * var6;
/* 3309 */     float var19 = var11 * var6;
/* 3310 */     float var20 = var12 * var6;
/* 3311 */     float var21 = var13 * var6;
/* 3312 */     float var22 = var10 * var7;
/* 3313 */     float var23 = var11 * var7;
/* 3314 */     float var24 = var12 * var7;
/* 3315 */     float var25 = var13 * var7;
/* 3316 */     float var26 = 0.0625F;
/* 3317 */     int var28 = var1.d(this.a, var2, var3, var4);
/* 3318 */     if (this.f || var1.a(this.a, var2, var3 - 1, var4, 0)) {
/* 3319 */       var8.b((var1.bW > 0.0D) ? var28 : var1.d(this.a, var2, var3 - 1, var4));
/* 3320 */       var8.a(var14, var18, var22);
/* 3321 */       a(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 0));
/* 3322 */       var9 = true;
/*      */     } 
/*      */     
/* 3325 */     if (this.f || var1.a(this.a, var2, var3 + 1, var4, 1)) {
/* 3326 */       var8.b((var1.bZ < 1.0D) ? var28 : var1.d(this.a, var2, var3 + 1, var4));
/* 3327 */       var8.a(var15, var19, var23);
/* 3328 */       b(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 1));
/* 3329 */       var9 = true;
/*      */     } 
/*      */     
/* 3332 */     if (this.f || var1.a(this.a, var2, var3, var4 - 1, 2)) {
/* 3333 */       var8.b((var1.bX > 0.0D) ? var28 : var1.d(this.a, var2, var3, var4 - 1));
/* 3334 */       var8.a(var16, var20, var24);
/* 3335 */       var8.c(0.0F, 0.0F, var26);
/* 3336 */       c(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 2));
/* 3337 */       var8.c(0.0F, 0.0F, -var26);
/* 3338 */       var9 = true;
/*      */     } 
/*      */     
/* 3341 */     if (this.f || var1.a(this.a, var2, var3, var4 + 1, 3)) {
/* 3342 */       var8.b((var1.ca < 1.0D) ? var28 : var1.d(this.a, var2, var3, var4 + 1));
/* 3343 */       var8.a(var16, var20, var24);
/* 3344 */       var8.c(0.0F, 0.0F, -var26);
/* 3345 */       d(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 3));
/* 3346 */       var8.c(0.0F, 0.0F, var26);
/* 3347 */       var9 = true;
/*      */     } 
/*      */     
/* 3350 */     if (this.f || var1.a(this.a, var2 - 1, var3, var4, 4)) {
/* 3351 */       var8.b((var1.bV > 0.0D) ? var28 : var1.d(this.a, var2 - 1, var3, var4));
/* 3352 */       var8.a(var17, var21, var25);
/* 3353 */       var8.c(var26, 0.0F, 0.0F);
/* 3354 */       e(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 4));
/* 3355 */       var8.c(-var26, 0.0F, 0.0F);
/* 3356 */       var9 = true;
/*      */     } 
/*      */     
/* 3359 */     if (this.f || var1.a(this.a, var2 + 1, var3, var4, 5)) {
/* 3360 */       var8.b((var1.bY < 1.0D) ? var28 : var1.d(this.a, var2 + 1, var3, var4));
/* 3361 */       var8.a(var17, var21, var25);
/* 3362 */       var8.c(-var26, 0.0F, 0.0F);
/* 3363 */       f(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 5));
/* 3364 */       var8.c(var26, 0.0F, 0.0F);
/* 3365 */       var9 = true;
/*      */     } 
/*      */     
/* 3368 */     return var9;
/*      */   }
/*      */   
/*      */   public boolean a(abg var1, int var2, int var3, int var4) {
/* 3372 */     boolean var5 = false;
/* 3373 */     float var6 = 0.375F;
/* 3374 */     float var7 = 0.625F;
/* 3375 */     var1.a(var6, 0.0F, var6, var7, 1.0F, var7);
/* 3376 */     o((pb)var1, var2, var3, var4);
/* 3377 */     var5 = true;
/* 3378 */     boolean var8 = false;
/* 3379 */     boolean var9 = false;
/* 3380 */     if (var1.g(this.a, var2 - 1, var3, var4) || var1.g(this.a, var2 + 1, var3, var4)) {
/* 3381 */       var8 = true;
/*      */     }
/*      */     
/* 3384 */     if (var1.g(this.a, var2, var3, var4 - 1) || var1.g(this.a, var2, var3, var4 + 1)) {
/* 3385 */       var9 = true;
/*      */     }
/*      */     
/* 3388 */     boolean var10 = var1.g(this.a, var2 - 1, var3, var4);
/* 3389 */     boolean var11 = var1.g(this.a, var2 + 1, var3, var4);
/* 3390 */     boolean var12 = var1.g(this.a, var2, var3, var4 - 1);
/* 3391 */     boolean var13 = var1.g(this.a, var2, var3, var4 + 1);
/* 3392 */     if (!var8 && !var9) {
/* 3393 */       var8 = true;
/*      */     }
/*      */     
/* 3396 */     var6 = 0.4375F;
/* 3397 */     var7 = 0.5625F;
/* 3398 */     float var14 = 0.75F;
/* 3399 */     float var15 = 0.9375F;
/* 3400 */     float var16 = var10 ? 0.0F : var6;
/* 3401 */     float var17 = var11 ? 1.0F : var7;
/* 3402 */     float var18 = var12 ? 0.0F : var6;
/* 3403 */     float var19 = var13 ? 1.0F : var7;
/* 3404 */     if (var8) {
/* 3405 */       var1.a(var16, var14, var6, var17, var15, var7);
/* 3406 */       o((pb)var1, var2, var3, var4);
/* 3407 */       var5 = true;
/*      */     } 
/*      */     
/* 3410 */     if (var9) {
/* 3411 */       var1.a(var6, var14, var18, var7, var15, var19);
/* 3412 */       o((pb)var1, var2, var3, var4);
/* 3413 */       var5 = true;
/*      */     } 
/*      */     
/* 3416 */     var14 = 0.375F;
/* 3417 */     var15 = 0.5625F;
/* 3418 */     if (var8) {
/* 3419 */       var1.a(var16, var14, var6, var17, var15, var7);
/* 3420 */       o((pb)var1, var2, var3, var4);
/* 3421 */       var5 = true;
/*      */     } 
/*      */     
/* 3424 */     if (var9) {
/* 3425 */       var1.a(var6, var14, var18, var7, var15, var19);
/* 3426 */       o((pb)var1, var2, var3, var4);
/* 3427 */       var5 = true;
/*      */     } 
/*      */     
/* 3430 */     var1.a(this.a, var2, var3, var4);
/* 3431 */     return var5;
/*      */   }
/*      */   
/*      */   public boolean a(de var1, int var2, int var3, int var4) {
/* 3435 */     boolean var5 = false;
/* 3436 */     int var6 = 0;
/*      */     
/* 3438 */     for (int var7 = 0; var7 < 8; var7++) {
/* 3439 */       byte var8 = 0;
/* 3440 */       byte var9 = 1;
/* 3441 */       if (var7 == 0) {
/* 3442 */         var8 = 2;
/*      */       }
/*      */       
/* 3445 */       if (var7 == 1) {
/* 3446 */         var8 = 3;
/*      */       }
/*      */       
/* 3449 */       if (var7 == 2) {
/* 3450 */         var8 = 4;
/*      */       }
/*      */       
/* 3453 */       if (var7 == 3) {
/* 3454 */         var8 = 5;
/* 3455 */         var9 = 2;
/*      */       } 
/*      */       
/* 3458 */       if (var7 == 4) {
/* 3459 */         var8 = 6;
/* 3460 */         var9 = 3;
/*      */       } 
/*      */       
/* 3463 */       if (var7 == 5) {
/* 3464 */         var8 = 7;
/* 3465 */         var9 = 5;
/*      */       } 
/*      */       
/* 3468 */       if (var7 == 6) {
/* 3469 */         var8 = 6;
/* 3470 */         var9 = 2;
/*      */       } 
/*      */       
/* 3473 */       if (var7 == 7) {
/* 3474 */         var8 = 3;
/*      */       }
/*      */       
/* 3477 */       float var10 = var8 / 16.0F;
/* 3478 */       float var11 = 1.0F - var6 / 16.0F;
/* 3479 */       float var12 = 1.0F - (var6 + var9) / 16.0F;
/* 3480 */       var6 += var9;
/* 3481 */       var1.a(0.5F - var10, var12, 0.5F - var10, 0.5F + var10, var11, 0.5F + var10);
/* 3482 */       o((pb)var1, var2, var3, var4);
/*      */     } 
/*      */     
/* 3485 */     var5 = true;
/* 3486 */     var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 3487 */     return var5;
/*      */   }
/*      */   
/*      */   public boolean a(ajf var1, int var2, int var3, int var4) {
/* 3491 */     boolean var5 = true;
/* 3492 */     int var6 = this.a.e(var2, var3, var4);
/* 3493 */     boolean var7 = ajf.e(var6);
/* 3494 */     int var8 = w.a(var6);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3499 */     if (var8 != 3 && var8 != 1) {
/* 3500 */       float var15 = 0.0F;
/* 3501 */       float var16 = 0.125F;
/* 3502 */       float var17 = 0.4375F;
/* 3503 */       float var18 = 0.5625F;
/* 3504 */       var1.a(var15, 0.3125F, var17, var16, 1.0F, var18);
/* 3505 */       o((pb)var1, var2, var3, var4);
/* 3506 */       var15 = 0.875F;
/* 3507 */       var16 = 1.0F;
/* 3508 */       var1.a(var15, 0.3125F, var17, var16, 1.0F, var18);
/* 3509 */       o((pb)var1, var2, var3, var4);
/*      */     } else {
/* 3511 */       float var15 = 0.4375F;
/* 3512 */       float var16 = 0.5625F;
/* 3513 */       float var17 = 0.0F;
/* 3514 */       float var18 = 0.125F;
/* 3515 */       var1.a(var15, 0.3125F, var17, var16, 1.0F, var18);
/* 3516 */       o((pb)var1, var2, var3, var4);
/* 3517 */       var17 = 0.875F;
/* 3518 */       var18 = 1.0F;
/* 3519 */       var1.a(var15, 0.3125F, var17, var16, 1.0F, var18);
/* 3520 */       o((pb)var1, var2, var3, var4);
/*      */     } 
/*      */     
/* 3523 */     if (!var7) {
/* 3524 */       if (var8 != 3 && var8 != 1) {
/* 3525 */         float f1 = 0.375F;
/* 3526 */         float f3 = 0.5F;
/* 3527 */         float f2 = 0.4375F;
/* 3528 */         float f4 = 0.5625F;
/* 3529 */         var1.a(f1, 0.375F, f2, f3, 0.9375F, f4);
/* 3530 */         o((pb)var1, var2, var3, var4);
/* 3531 */         f1 = 0.5F;
/* 3532 */         f3 = 0.625F;
/* 3533 */         var1.a(f1, 0.375F, f2, f3, 0.9375F, f4);
/* 3534 */         o((pb)var1, var2, var3, var4);
/* 3535 */         f1 = 0.625F;
/* 3536 */         f3 = 0.875F;
/* 3537 */         var1.a(f1, 0.375F, f2, f3, 0.5625F, f4);
/* 3538 */         o((pb)var1, var2, var3, var4);
/* 3539 */         var1.a(f1, 0.75F, f2, f3, 0.9375F, f4);
/* 3540 */         o((pb)var1, var2, var3, var4);
/* 3541 */         f1 = 0.125F;
/* 3542 */         f3 = 0.375F;
/* 3543 */         var1.a(f1, 0.375F, f2, f3, 0.5625F, f4);
/* 3544 */         o((pb)var1, var2, var3, var4);
/* 3545 */         var1.a(f1, 0.75F, f2, f3, 0.9375F, f4);
/* 3546 */         o((pb)var1, var2, var3, var4);
/*      */       } else {
/* 3548 */         float f1 = 0.4375F;
/* 3549 */         float f3 = 0.5625F;
/* 3550 */         float f2 = 0.375F;
/* 3551 */         float f4 = 0.5F;
/* 3552 */         var1.a(f1, 0.375F, f2, f3, 0.9375F, f4);
/* 3553 */         o((pb)var1, var2, var3, var4);
/* 3554 */         f2 = 0.5F;
/* 3555 */         f4 = 0.625F;
/* 3556 */         var1.a(f1, 0.375F, f2, f3, 0.9375F, f4);
/* 3557 */         o((pb)var1, var2, var3, var4);
/* 3558 */         f2 = 0.625F;
/* 3559 */         f4 = 0.875F;
/* 3560 */         var1.a(f1, 0.375F, f2, f3, 0.5625F, f4);
/* 3561 */         o((pb)var1, var2, var3, var4);
/* 3562 */         var1.a(f1, 0.75F, f2, f3, 0.9375F, f4);
/* 3563 */         o((pb)var1, var2, var3, var4);
/* 3564 */         f2 = 0.125F;
/* 3565 */         f4 = 0.375F;
/* 3566 */         var1.a(f1, 0.375F, f2, f3, 0.5625F, f4);
/* 3567 */         o((pb)var1, var2, var3, var4);
/* 3568 */         var1.a(f1, 0.75F, f2, f3, 0.9375F, f4);
/* 3569 */         o((pb)var1, var2, var3, var4);
/*      */       } 
/* 3571 */     } else if (var8 == 3) {
/* 3572 */       var1.a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
/* 3573 */       o((pb)var1, var2, var3, var4);
/* 3574 */       var1.a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
/* 3575 */       o((pb)var1, var2, var3, var4);
/* 3576 */       var1.a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
/* 3577 */       o((pb)var1, var2, var3, var4);
/* 3578 */       var1.a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
/* 3579 */       o((pb)var1, var2, var3, var4);
/* 3580 */       var1.a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
/* 3581 */       o((pb)var1, var2, var3, var4);
/* 3582 */       var1.a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
/* 3583 */       o((pb)var1, var2, var3, var4);
/* 3584 */     } else if (var8 == 1) {
/* 3585 */       var1.a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
/* 3586 */       o((pb)var1, var2, var3, var4);
/* 3587 */       var1.a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
/* 3588 */       o((pb)var1, var2, var3, var4);
/* 3589 */       var1.a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
/* 3590 */       o((pb)var1, var2, var3, var4);
/* 3591 */       var1.a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
/* 3592 */       o((pb)var1, var2, var3, var4);
/* 3593 */       var1.a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
/* 3594 */       o((pb)var1, var2, var3, var4);
/* 3595 */       var1.a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
/* 3596 */       o((pb)var1, var2, var3, var4);
/* 3597 */     } else if (var8 == 0) {
/* 3598 */       var1.a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
/* 3599 */       o((pb)var1, var2, var3, var4);
/* 3600 */       var1.a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
/* 3601 */       o((pb)var1, var2, var3, var4);
/* 3602 */       var1.a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
/* 3603 */       o((pb)var1, var2, var3, var4);
/* 3604 */       var1.a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
/* 3605 */       o((pb)var1, var2, var3, var4);
/* 3606 */       var1.a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
/* 3607 */       o((pb)var1, var2, var3, var4);
/* 3608 */       var1.a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
/* 3609 */       o((pb)var1, var2, var3, var4);
/* 3610 */     } else if (var8 == 2) {
/* 3611 */       var1.a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
/* 3612 */       o((pb)var1, var2, var3, var4);
/* 3613 */       var1.a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
/* 3614 */       o((pb)var1, var2, var3, var4);
/* 3615 */       var1.a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
/* 3616 */       o((pb)var1, var2, var3, var4);
/* 3617 */       var1.a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
/* 3618 */       o((pb)var1, var2, var3, var4);
/* 3619 */       var1.a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
/* 3620 */       o((pb)var1, var2, var3, var4);
/* 3621 */       var1.a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
/* 3622 */       o((pb)var1, var2, var3, var4);
/*      */     } 
/*      */     
/* 3625 */     var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 3626 */     return var5;
/*      */   }
/*      */   
/*      */   public boolean q(pb var1, int var2, int var3, int var4) {
/* 3630 */     int var5 = this.a.e(var2, var3, var4);
/* 3631 */     int var6 = var5 & 0x3;
/* 3632 */     float var7 = 0.0F;
/* 3633 */     float var8 = 0.5F;
/* 3634 */     float var9 = 0.5F;
/* 3635 */     float var10 = 1.0F;
/* 3636 */     if ((var5 & 0x4) != 0) {
/* 3637 */       var7 = 0.5F;
/* 3638 */       var8 = 1.0F;
/* 3639 */       var9 = 0.0F;
/* 3640 */       var10 = 0.5F;
/*      */     } 
/*      */     
/* 3643 */     var1.a(0.0F, var7, 0.0F, 1.0F, var8, 1.0F);
/* 3644 */     o(var1, var2, var3, var4);
/* 3645 */     if (var6 == 0) {
/* 3646 */       var1.a(0.5F, var9, 0.0F, 1.0F, var10, 1.0F);
/* 3647 */       o(var1, var2, var3, var4);
/* 3648 */     } else if (var6 == 1) {
/* 3649 */       var1.a(0.0F, var9, 0.0F, 0.5F, var10, 1.0F);
/* 3650 */       o(var1, var2, var3, var4);
/* 3651 */     } else if (var6 == 2) {
/* 3652 */       var1.a(0.0F, var9, 0.5F, 1.0F, var10, 1.0F);
/* 3653 */       o(var1, var2, var3, var4);
/* 3654 */     } else if (var6 == 3) {
/* 3655 */       var1.a(0.0F, var9, 0.0F, 1.0F, var10, 0.5F);
/* 3656 */       o(var1, var2, var3, var4);
/*      */     } 
/*      */     
/* 3659 */     var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 3660 */     return true;
/*      */   }
/*      */   
/*      */   public boolean r(pb var1, int var2, int var3, int var4) {
/* 3664 */     adz var5 = adz.a;
/* 3665 */     acb var6 = (acb)var1;
/* 3666 */     boolean var7 = false;
/* 3667 */     float var8 = 0.5F;
/* 3668 */     float var9 = 1.0F;
/* 3669 */     float var10 = 0.8F;
/* 3670 */     float var11 = 0.6F;
/* 3671 */     int var12 = var1.d(this.a, var2, var3, var4);
/* 3672 */     var5.b((var1.bW > 0.0D) ? var12 : var1.d(this.a, var2, var3 - 1, var4));
/* 3673 */     var5.a(var8, var8, var8);
/* 3674 */     a(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 0));
/* 3675 */     var7 = true;
/* 3676 */     var5.b((var1.bZ < 1.0D) ? var12 : var1.d(this.a, var2, var3 + 1, var4));
/* 3677 */     var5.a(var9, var9, var9);
/* 3678 */     b(var1, var2, var3, var4, var1.d(this.a, var2, var3, var4, 1));
/* 3679 */     var7 = true;
/* 3680 */     var5.b((var1.bX > 0.0D) ? var12 : var1.d(this.a, var2, var3, var4 - 1));
/* 3681 */     var5.a(var10, var10, var10);
/* 3682 */     int var14 = var1.d(this.a, var2, var3, var4, 2);
/* 3683 */     if (var14 < 0) {
/* 3684 */       this.e = true;
/* 3685 */       var14 = -var14;
/*      */     } 
/*      */     
/* 3688 */     c(var1, var2, var3, var4, var14);
/* 3689 */     var7 = true;
/* 3690 */     this.e = false;
/* 3691 */     var5.b((var1.ca < 1.0D) ? var12 : var1.d(this.a, var2, var3, var4 + 1));
/* 3692 */     var5.a(var10, var10, var10);
/* 3693 */     var14 = var1.d(this.a, var2, var3, var4, 3);
/* 3694 */     if (var14 < 0) {
/* 3695 */       this.e = true;
/* 3696 */       var14 = -var14;
/*      */     } 
/*      */     
/* 3699 */     d(var1, var2, var3, var4, var14);
/* 3700 */     var7 = true;
/* 3701 */     this.e = false;
/* 3702 */     var5.b((var1.bV > 0.0D) ? var12 : var1.d(this.a, var2 - 1, var3, var4));
/* 3703 */     var5.a(var11, var11, var11);
/* 3704 */     var14 = var1.d(this.a, var2, var3, var4, 4);
/* 3705 */     if (var14 < 0) {
/* 3706 */       this.e = true;
/* 3707 */       var14 = -var14;
/*      */     } 
/*      */     
/* 3710 */     e(var1, var2, var3, var4, var14);
/* 3711 */     var7 = true;
/* 3712 */     this.e = false;
/* 3713 */     var5.b((var1.bY < 1.0D) ? var12 : var1.d(this.a, var2 + 1, var3, var4));
/* 3714 */     var5.a(var11, var11, var11);
/* 3715 */     var14 = var1.d(this.a, var2, var3, var4, 5);
/* 3716 */     if (var14 < 0) {
/* 3717 */       this.e = true;
/* 3718 */       var14 = -var14;
/*      */     } 
/*      */     
/* 3721 */     f(var1, var2, var3, var4, var14);
/* 3722 */     var7 = true;
/* 3723 */     this.e = false;
/* 3724 */     return var7;
/*      */   }
/*      */   
/*      */   public void a(pb var1, double var2, double var4, double var6, int var8) {
/* 3728 */     adz var9 = adz.a;
/* 3729 */     if (this.d >= 0) {
/* 3730 */       var8 = this.d;
/*      */     }
/*      */     
/* 3733 */     int var10 = (var8 & 0xF) << 4;
/* 3734 */     int var11 = var8 & 0xF0;
/* 3735 */     double var12 = (var10 + var1.bV * 16.0D) / 256.0D;
/* 3736 */     double var14 = (var10 + var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3737 */     double var16 = (var11 + var1.bX * 16.0D) / 256.0D;
/* 3738 */     double var18 = (var11 + var1.ca * 16.0D - 0.01D) / 256.0D;
/* 3739 */     if (var1.bV < 0.0D || var1.bY > 1.0D) {
/* 3740 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 3741 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3744 */     if (var1.bX < 0.0D || var1.ca > 1.0D) {
/* 3745 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 3746 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3749 */     double var20 = var14;
/* 3750 */     double var22 = var12;
/* 3751 */     double var24 = var16;
/* 3752 */     double var26 = var18;
/* 3753 */     if (this.l == 2) {
/* 3754 */       var12 = (var10 + var1.bX * 16.0D) / 256.0D;
/* 3755 */       var16 = ((var11 + 16) - var1.bY * 16.0D) / 256.0D;
/* 3756 */       var14 = (var10 + var1.ca * 16.0D) / 256.0D;
/* 3757 */       var18 = ((var11 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3758 */       var24 = var16;
/* 3759 */       var26 = var18;
/* 3760 */       var20 = var12;
/* 3761 */       var22 = var14;
/* 3762 */       var16 = var18;
/* 3763 */       var18 = var24;
/* 3764 */     } else if (this.l == 1) {
/* 3765 */       var12 = ((var10 + 16) - var1.ca * 16.0D) / 256.0D;
/* 3766 */       var16 = (var11 + var1.bV * 16.0D) / 256.0D;
/* 3767 */       var14 = ((var10 + 16) - var1.bX * 16.0D) / 256.0D;
/* 3768 */       var18 = (var11 + var1.bY * 16.0D) / 256.0D;
/* 3769 */       var20 = var14;
/* 3770 */       var22 = var12;
/* 3771 */       var12 = var14;
/* 3772 */       var14 = var22;
/* 3773 */       var24 = var18;
/* 3774 */       var26 = var16;
/* 3775 */     } else if (this.l == 3) {
/* 3776 */       var12 = ((var10 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3777 */       var14 = ((var10 + 16) - var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3778 */       var16 = ((var11 + 16) - var1.bX * 16.0D) / 256.0D;
/* 3779 */       var18 = ((var11 + 16) - var1.ca * 16.0D - 0.01D) / 256.0D;
/* 3780 */       var20 = var14;
/* 3781 */       var22 = var12;
/* 3782 */       var24 = var16;
/* 3783 */       var26 = var18;
/*      */     } 
/*      */     
/* 3786 */     double var28 = var2 + var1.bV;
/* 3787 */     double var30 = var2 + var1.bY;
/* 3788 */     double var32 = var4 + var1.bW;
/* 3789 */     double var34 = var6 + var1.bX;
/* 3790 */     double var36 = var6 + var1.ca;
/* 3791 */     if (this.m) {
/* 3792 */       var9.a(this.an, this.ar, this.av);
/* 3793 */       var9.b(this.aj);
/* 3794 */       var9.a(var28, var32, var36, var22, var26);
/* 3795 */       var9.a(this.ao, this.as, this.aw);
/* 3796 */       var9.b(this.ak);
/* 3797 */       var9.a(var28, var32, var34, var12, var16);
/* 3798 */       var9.a(this.ap, this.at, this.ax);
/* 3799 */       var9.b(this.al);
/* 3800 */       var9.a(var30, var32, var34, var20, var24);
/* 3801 */       var9.a(this.aq, this.au, this.ay);
/* 3802 */       var9.b(this.am);
/* 3803 */       var9.a(var30, var32, var36, var14, var18);
/*      */     } else {
/* 3805 */       var9.a(var28, var32, var36, var22, var26);
/* 3806 */       var9.a(var28, var32, var34, var12, var16);
/* 3807 */       var9.a(var30, var32, var34, var20, var24);
/* 3808 */       var9.a(var30, var32, var36, var14, var18);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void b(pb var1, double var2, double var4, double var6, int var8) {
/* 3814 */     adz var9 = adz.a;
/* 3815 */     if (this.d >= 0) {
/* 3816 */       var8 = this.d;
/*      */     }
/*      */     
/* 3819 */     int var10 = (var8 & 0xF) << 4;
/* 3820 */     int var11 = var8 & 0xF0;
/* 3821 */     double var12 = (var10 + var1.bV * 16.0D) / 256.0D;
/* 3822 */     double var14 = (var10 + var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3823 */     double var16 = (var11 + var1.bX * 16.0D) / 256.0D;
/* 3824 */     double var18 = (var11 + var1.ca * 16.0D - 0.01D) / 256.0D;
/* 3825 */     if (var1.bV < 0.0D || var1.bY > 1.0D) {
/* 3826 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 3827 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3830 */     if (var1.bX < 0.0D || var1.ca > 1.0D) {
/* 3831 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 3832 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3835 */     double var20 = var14;
/* 3836 */     double var22 = var12;
/* 3837 */     double var24 = var16;
/* 3838 */     double var26 = var18;
/* 3839 */     if (this.k == 1) {
/* 3840 */       var12 = (var10 + var1.bX * 16.0D) / 256.0D;
/* 3841 */       var16 = ((var11 + 16) - var1.bY * 16.0D) / 256.0D;
/* 3842 */       var14 = (var10 + var1.ca * 16.0D) / 256.0D;
/* 3843 */       var18 = ((var11 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3844 */       var24 = var16;
/* 3845 */       var26 = var18;
/* 3846 */       var20 = var12;
/* 3847 */       var22 = var14;
/* 3848 */       var16 = var18;
/* 3849 */       var18 = var24;
/* 3850 */     } else if (this.k == 2) {
/* 3851 */       var12 = ((var10 + 16) - var1.ca * 16.0D) / 256.0D;
/* 3852 */       var16 = (var11 + var1.bV * 16.0D) / 256.0D;
/* 3853 */       var14 = ((var10 + 16) - var1.bX * 16.0D) / 256.0D;
/* 3854 */       var18 = (var11 + var1.bY * 16.0D) / 256.0D;
/* 3855 */       var20 = var14;
/* 3856 */       var22 = var12;
/* 3857 */       var12 = var14;
/* 3858 */       var14 = var22;
/* 3859 */       var24 = var18;
/* 3860 */       var26 = var16;
/* 3861 */     } else if (this.k == 3) {
/* 3862 */       var12 = ((var10 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3863 */       var14 = ((var10 + 16) - var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3864 */       var16 = ((var11 + 16) - var1.bX * 16.0D) / 256.0D;
/* 3865 */       var18 = ((var11 + 16) - var1.ca * 16.0D - 0.01D) / 256.0D;
/* 3866 */       var20 = var14;
/* 3867 */       var22 = var12;
/* 3868 */       var24 = var16;
/* 3869 */       var26 = var18;
/*      */     } 
/*      */     
/* 3872 */     double var28 = var2 + var1.bV;
/* 3873 */     double var30 = var2 + var1.bY;
/* 3874 */     double var32 = var4 + var1.bZ;
/* 3875 */     double var34 = var6 + var1.bX;
/* 3876 */     double var36 = var6 + var1.ca;
/* 3877 */     if (this.m) {
/* 3878 */       var9.a(this.an, this.ar, this.av);
/* 3879 */       var9.b(this.aj);
/* 3880 */       var9.a(var30, var32, var36, var14, var18);
/* 3881 */       var9.a(this.ao, this.as, this.aw);
/* 3882 */       var9.b(this.ak);
/* 3883 */       var9.a(var30, var32, var34, var20, var24);
/* 3884 */       var9.a(this.ap, this.at, this.ax);
/* 3885 */       var9.b(this.al);
/* 3886 */       var9.a(var28, var32, var34, var12, var16);
/* 3887 */       var9.a(this.aq, this.au, this.ay);
/* 3888 */       var9.b(this.am);
/* 3889 */       var9.a(var28, var32, var36, var22, var26);
/*      */     } else {
/* 3891 */       var9.a(var30, var32, var36, var14, var18);
/* 3892 */       var9.a(var30, var32, var34, var20, var24);
/* 3893 */       var9.a(var28, var32, var34, var12, var16);
/* 3894 */       var9.a(var28, var32, var36, var22, var26);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void c(pb var1, double var2, double var4, double var6, int var8) {
/* 3900 */     adz var9 = adz.a;
/* 3901 */     if (this.d >= 0) {
/* 3902 */       var8 = this.d;
/*      */     }
/*      */     
/* 3905 */     int var10 = (var8 & 0xF) << 4;
/* 3906 */     int var11 = var8 & 0xF0;
/* 3907 */     double var12 = (var10 + var1.bV * 16.0D) / 256.0D;
/* 3908 */     double var14 = (var10 + var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3909 */     double var16 = ((var11 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 3910 */     double var18 = ((var11 + 16) - var1.bW * 16.0D - 0.01D) / 256.0D;
/*      */     
/* 3912 */     if (this.e) {
/* 3913 */       double d = var12;
/* 3914 */       var12 = var14;
/* 3915 */       var14 = d;
/*      */     } 
/*      */     
/* 3918 */     if (var1.bV < 0.0D || var1.bY > 1.0D) {
/* 3919 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 3920 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3923 */     if (var1.bW < 0.0D || var1.bZ > 1.0D) {
/* 3924 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 3925 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 3928 */     double var20 = var14;
/* 3929 */     double var22 = var12;
/* 3930 */     double var24 = var16;
/* 3931 */     double var26 = var18;
/* 3932 */     if (this.g == 2) {
/* 3933 */       var12 = (var10 + var1.bW * 16.0D) / 256.0D;
/* 3934 */       var16 = ((var11 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3935 */       var14 = (var10 + var1.bZ * 16.0D) / 256.0D;
/* 3936 */       var18 = ((var11 + 16) - var1.bY * 16.0D) / 256.0D;
/* 3937 */       var24 = var16;
/* 3938 */       var26 = var18;
/* 3939 */       var20 = var12;
/* 3940 */       var22 = var14;
/* 3941 */       var16 = var18;
/* 3942 */       var18 = var24;
/* 3943 */     } else if (this.g == 1) {
/* 3944 */       var12 = ((var10 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 3945 */       var16 = (var11 + var1.bY * 16.0D) / 256.0D;
/* 3946 */       var14 = ((var10 + 16) - var1.bW * 16.0D) / 256.0D;
/* 3947 */       var18 = (var11 + var1.bV * 16.0D) / 256.0D;
/* 3948 */       var20 = var14;
/* 3949 */       var22 = var12;
/* 3950 */       var12 = var14;
/* 3951 */       var14 = var22;
/* 3952 */       var24 = var18;
/* 3953 */       var26 = var16;
/* 3954 */     } else if (this.g == 3) {
/* 3955 */       var12 = ((var10 + 16) - var1.bV * 16.0D) / 256.0D;
/* 3956 */       var14 = ((var10 + 16) - var1.bY * 16.0D - 0.01D) / 256.0D;
/* 3957 */       var16 = (var11 + var1.bZ * 16.0D) / 256.0D;
/* 3958 */       var18 = (var11 + var1.bW * 16.0D - 0.01D) / 256.0D;
/* 3959 */       var20 = var14;
/* 3960 */       var22 = var12;
/* 3961 */       var24 = var16;
/* 3962 */       var26 = var18;
/*      */     } 
/*      */     
/* 3965 */     double var28 = var2 + var1.bV;
/* 3966 */     double var30 = var2 + var1.bY;
/* 3967 */     double var32 = var4 + var1.bW;
/* 3968 */     double var34 = var4 + var1.bZ;
/* 3969 */     double var36 = var6 + var1.bX;
/* 3970 */     if (this.m) {
/* 3971 */       var9.a(this.an, this.ar, this.av);
/* 3972 */       var9.b(this.aj);
/* 3973 */       var9.a(var28, var34, var36, var20, var24);
/* 3974 */       var9.a(this.ao, this.as, this.aw);
/* 3975 */       var9.b(this.ak);
/* 3976 */       var9.a(var30, var34, var36, var12, var16);
/* 3977 */       var9.a(this.ap, this.at, this.ax);
/* 3978 */       var9.b(this.al);
/* 3979 */       var9.a(var30, var32, var36, var22, var26);
/* 3980 */       var9.a(this.aq, this.au, this.ay);
/* 3981 */       var9.b(this.am);
/* 3982 */       var9.a(var28, var32, var36, var14, var18);
/*      */     } else {
/* 3984 */       var9.a(var28, var34, var36, var20, var24);
/* 3985 */       var9.a(var30, var34, var36, var12, var16);
/* 3986 */       var9.a(var30, var32, var36, var22, var26);
/* 3987 */       var9.a(var28, var32, var36, var14, var18);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void d(pb var1, double var2, double var4, double var6, int var8) {
/* 3993 */     adz var9 = adz.a;
/* 3994 */     if (this.d >= 0) {
/* 3995 */       var8 = this.d;
/*      */     }
/*      */     
/* 3998 */     int var10 = (var8 & 0xF) << 4;
/* 3999 */     int var11 = var8 & 0xF0;
/* 4000 */     double var12 = (var10 + var1.bV * 16.0D) / 256.0D;
/* 4001 */     double var14 = (var10 + var1.bY * 16.0D - 0.01D) / 256.0D;
/* 4002 */     double var16 = ((var11 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4003 */     double var18 = ((var11 + 16) - var1.bW * 16.0D - 0.01D) / 256.0D;
/*      */     
/* 4005 */     if (this.e) {
/* 4006 */       double d = var12;
/* 4007 */       var12 = var14;
/* 4008 */       var14 = d;
/*      */     } 
/*      */     
/* 4011 */     if (var1.bV < 0.0D || var1.bY > 1.0D) {
/* 4012 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 4013 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4016 */     if (var1.bW < 0.0D || var1.bZ > 1.0D) {
/* 4017 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 4018 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4021 */     double var20 = var14;
/* 4022 */     double var22 = var12;
/* 4023 */     double var24 = var16;
/* 4024 */     double var26 = var18;
/* 4025 */     if (this.h == 1) {
/* 4026 */       var12 = (var10 + var1.bW * 16.0D) / 256.0D;
/* 4027 */       var18 = ((var11 + 16) - var1.bV * 16.0D) / 256.0D;
/* 4028 */       var14 = (var10 + var1.bZ * 16.0D) / 256.0D;
/* 4029 */       var16 = ((var11 + 16) - var1.bY * 16.0D) / 256.0D;
/* 4030 */       var24 = var16;
/* 4031 */       var26 = var18;
/* 4032 */       var20 = var12;
/* 4033 */       var22 = var14;
/* 4034 */       var16 = var18;
/* 4035 */       var18 = var24;
/* 4036 */     } else if (this.h == 2) {
/* 4037 */       var12 = ((var10 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4038 */       var16 = (var11 + var1.bV * 16.0D) / 256.0D;
/* 4039 */       var14 = ((var10 + 16) - var1.bW * 16.0D) / 256.0D;
/* 4040 */       var18 = (var11 + var1.bY * 16.0D) / 256.0D;
/* 4041 */       var20 = var14;
/* 4042 */       var22 = var12;
/* 4043 */       var12 = var14;
/* 4044 */       var14 = var22;
/* 4045 */       var24 = var18;
/* 4046 */       var26 = var16;
/* 4047 */     } else if (this.h == 3) {
/* 4048 */       var12 = ((var10 + 16) - var1.bV * 16.0D) / 256.0D;
/* 4049 */       var14 = ((var10 + 16) - var1.bY * 16.0D - 0.01D) / 256.0D;
/* 4050 */       var16 = (var11 + var1.bZ * 16.0D) / 256.0D;
/* 4051 */       var18 = (var11 + var1.bW * 16.0D - 0.01D) / 256.0D;
/* 4052 */       var20 = var14;
/* 4053 */       var22 = var12;
/* 4054 */       var24 = var16;
/* 4055 */       var26 = var18;
/*      */     } 
/*      */     
/* 4058 */     double var28 = var2 + var1.bV;
/* 4059 */     double var30 = var2 + var1.bY;
/* 4060 */     double var32 = var4 + var1.bW;
/* 4061 */     double var34 = var4 + var1.bZ;
/* 4062 */     double var36 = var6 + var1.ca;
/* 4063 */     if (this.m) {
/* 4064 */       var9.a(this.an, this.ar, this.av);
/* 4065 */       var9.b(this.aj);
/* 4066 */       var9.a(var28, var34, var36, var12, var16);
/* 4067 */       var9.a(this.ao, this.as, this.aw);
/* 4068 */       var9.b(this.ak);
/* 4069 */       var9.a(var28, var32, var36, var22, var26);
/* 4070 */       var9.a(this.ap, this.at, this.ax);
/* 4071 */       var9.b(this.al);
/* 4072 */       var9.a(var30, var32, var36, var14, var18);
/* 4073 */       var9.a(this.aq, this.au, this.ay);
/* 4074 */       var9.b(this.am);
/* 4075 */       var9.a(var30, var34, var36, var20, var24);
/*      */     } else {
/* 4077 */       var9.a(var28, var34, var36, var12, var16);
/* 4078 */       var9.a(var28, var32, var36, var22, var26);
/* 4079 */       var9.a(var30, var32, var36, var14, var18);
/* 4080 */       var9.a(var30, var34, var36, var20, var24);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void e(pb var1, double var2, double var4, double var6, int var8) {
/* 4086 */     adz var9 = adz.a;
/* 4087 */     if (this.d >= 0) {
/* 4088 */       var8 = this.d;
/*      */     }
/*      */     
/* 4091 */     int var10 = (var8 & 0xF) << 4;
/* 4092 */     int var11 = var8 & 0xF0;
/* 4093 */     double var12 = (var10 + var1.bX * 16.0D) / 256.0D;
/* 4094 */     double var14 = (var10 + var1.ca * 16.0D - 0.01D) / 256.0D;
/* 4095 */     double var16 = ((var11 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4096 */     double var18 = ((var11 + 16) - var1.bW * 16.0D - 0.01D) / 256.0D;
/*      */     
/* 4098 */     if (this.e) {
/* 4099 */       double d = var12;
/* 4100 */       var12 = var14;
/* 4101 */       var14 = d;
/*      */     } 
/*      */     
/* 4104 */     if (var1.bX < 0.0D || var1.ca > 1.0D) {
/* 4105 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 4106 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4109 */     if (var1.bW < 0.0D || var1.bZ > 1.0D) {
/* 4110 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 4111 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4114 */     double var20 = var14;
/* 4115 */     double var22 = var12;
/* 4116 */     double var24 = var16;
/* 4117 */     double var26 = var18;
/* 4118 */     if (this.j == 1) {
/* 4119 */       var12 = (var10 + var1.bW * 16.0D) / 256.0D;
/* 4120 */       var16 = ((var11 + 16) - var1.ca * 16.0D) / 256.0D;
/* 4121 */       var14 = (var10 + var1.bZ * 16.0D) / 256.0D;
/* 4122 */       var18 = ((var11 + 16) - var1.bX * 16.0D) / 256.0D;
/* 4123 */       var24 = var16;
/* 4124 */       var26 = var18;
/* 4125 */       var20 = var12;
/* 4126 */       var22 = var14;
/* 4127 */       var16 = var18;
/* 4128 */       var18 = var24;
/* 4129 */     } else if (this.j == 2) {
/* 4130 */       var12 = ((var10 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4131 */       var16 = (var11 + var1.bX * 16.0D) / 256.0D;
/* 4132 */       var14 = ((var10 + 16) - var1.bW * 16.0D) / 256.0D;
/* 4133 */       var18 = (var11 + var1.ca * 16.0D) / 256.0D;
/* 4134 */       var20 = var14;
/* 4135 */       var22 = var12;
/* 4136 */       var12 = var14;
/* 4137 */       var14 = var22;
/* 4138 */       var24 = var18;
/* 4139 */       var26 = var16;
/* 4140 */     } else if (this.j == 3) {
/* 4141 */       var12 = ((var10 + 16) - var1.bX * 16.0D) / 256.0D;
/* 4142 */       var14 = ((var10 + 16) - var1.ca * 16.0D - 0.01D) / 256.0D;
/* 4143 */       var16 = (var11 + var1.bZ * 16.0D) / 256.0D;
/* 4144 */       var18 = (var11 + var1.bW * 16.0D - 0.01D) / 256.0D;
/* 4145 */       var20 = var14;
/* 4146 */       var22 = var12;
/* 4147 */       var24 = var16;
/* 4148 */       var26 = var18;
/*      */     } 
/*      */     
/* 4151 */     double var28 = var2 + var1.bV;
/* 4152 */     double var30 = var4 + var1.bW;
/* 4153 */     double var32 = var4 + var1.bZ;
/* 4154 */     double var34 = var6 + var1.bX;
/* 4155 */     double var36 = var6 + var1.ca;
/* 4156 */     if (this.m) {
/* 4157 */       var9.a(this.an, this.ar, this.av);
/* 4158 */       var9.b(this.aj);
/* 4159 */       var9.a(var28, var32, var36, var20, var24);
/* 4160 */       var9.a(this.ao, this.as, this.aw);
/* 4161 */       var9.b(this.ak);
/* 4162 */       var9.a(var28, var32, var34, var12, var16);
/* 4163 */       var9.a(this.ap, this.at, this.ax);
/* 4164 */       var9.b(this.al);
/* 4165 */       var9.a(var28, var30, var34, var22, var26);
/* 4166 */       var9.a(this.aq, this.au, this.ay);
/* 4167 */       var9.b(this.am);
/* 4168 */       var9.a(var28, var30, var36, var14, var18);
/*      */     } else {
/* 4170 */       var9.a(var28, var32, var36, var20, var24);
/* 4171 */       var9.a(var28, var32, var34, var12, var16);
/* 4172 */       var9.a(var28, var30, var34, var22, var26);
/* 4173 */       var9.a(var28, var30, var36, var14, var18);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void f(pb var1, double var2, double var4, double var6, int var8) {
/* 4179 */     adz var9 = adz.a;
/* 4180 */     if (this.d >= 0) {
/* 4181 */       var8 = this.d;
/*      */     }
/*      */     
/* 4184 */     int var10 = (var8 & 0xF) << 4;
/* 4185 */     int var11 = var8 & 0xF0;
/* 4186 */     double var12 = (var10 + var1.bX * 16.0D) / 256.0D;
/* 4187 */     double var14 = (var10 + var1.ca * 16.0D - 0.01D) / 256.0D;
/* 4188 */     double var16 = ((var11 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4189 */     double var18 = ((var11 + 16) - var1.bW * 16.0D - 0.01D) / 256.0D;
/*      */     
/* 4191 */     if (this.e) {
/* 4192 */       double d = var12;
/* 4193 */       var12 = var14;
/* 4194 */       var14 = d;
/*      */     } 
/*      */     
/* 4197 */     if (var1.bX < 0.0D || var1.ca > 1.0D) {
/* 4198 */       var12 = ((var10 + 0.0F) / 256.0F);
/* 4199 */       var14 = ((var10 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4202 */     if (var1.bW < 0.0D || var1.bZ > 1.0D) {
/* 4203 */       var16 = ((var11 + 0.0F) / 256.0F);
/* 4204 */       var18 = ((var11 + 15.99F) / 256.0F);
/*      */     } 
/*      */     
/* 4207 */     double var20 = var14;
/* 4208 */     double var22 = var12;
/* 4209 */     double var24 = var16;
/* 4210 */     double var26 = var18;
/* 4211 */     if (this.i == 2) {
/* 4212 */       var12 = (var10 + var1.bW * 16.0D) / 256.0D;
/* 4213 */       var16 = ((var11 + 16) - var1.bX * 16.0D) / 256.0D;
/* 4214 */       var14 = (var10 + var1.bZ * 16.0D) / 256.0D;
/* 4215 */       var18 = ((var11 + 16) - var1.ca * 16.0D) / 256.0D;
/* 4216 */       var24 = var16;
/* 4217 */       var26 = var18;
/* 4218 */       var20 = var12;
/* 4219 */       var22 = var14;
/* 4220 */       var16 = var18;
/* 4221 */       var18 = var24;
/* 4222 */     } else if (this.i == 1) {
/* 4223 */       var12 = ((var10 + 16) - var1.bZ * 16.0D) / 256.0D;
/* 4224 */       var16 = (var11 + var1.ca * 16.0D) / 256.0D;
/* 4225 */       var14 = ((var10 + 16) - var1.bW * 16.0D) / 256.0D;
/* 4226 */       var18 = (var11 + var1.bX * 16.0D) / 256.0D;
/* 4227 */       var20 = var14;
/* 4228 */       var22 = var12;
/* 4229 */       var12 = var14;
/* 4230 */       var14 = var22;
/* 4231 */       var24 = var18;
/* 4232 */       var26 = var16;
/* 4233 */     } else if (this.i == 3) {
/* 4234 */       var12 = ((var10 + 16) - var1.bX * 16.0D) / 256.0D;
/* 4235 */       var14 = ((var10 + 16) - var1.ca * 16.0D - 0.01D) / 256.0D;
/* 4236 */       var16 = (var11 + var1.bZ * 16.0D) / 256.0D;
/* 4237 */       var18 = (var11 + var1.bW * 16.0D - 0.01D) / 256.0D;
/* 4238 */       var20 = var14;
/* 4239 */       var22 = var12;
/* 4240 */       var24 = var16;
/* 4241 */       var26 = var18;
/*      */     } 
/*      */     
/* 4244 */     double var28 = var2 + var1.bY;
/* 4245 */     double var30 = var4 + var1.bW;
/* 4246 */     double var32 = var4 + var1.bZ;
/* 4247 */     double var34 = var6 + var1.bX;
/* 4248 */     double var36 = var6 + var1.ca;
/* 4249 */     if (this.m) {
/* 4250 */       var9.a(this.an, this.ar, this.av);
/* 4251 */       var9.b(this.aj);
/* 4252 */       var9.a(var28, var30, var36, var22, var26);
/* 4253 */       var9.a(this.ao, this.as, this.aw);
/* 4254 */       var9.b(this.ak);
/* 4255 */       var9.a(var28, var30, var34, var14, var18);
/* 4256 */       var9.a(this.ap, this.at, this.ax);
/* 4257 */       var9.b(this.al);
/* 4258 */       var9.a(var28, var32, var34, var20, var24);
/* 4259 */       var9.a(this.aq, this.au, this.ay);
/* 4260 */       var9.b(this.am);
/* 4261 */       var9.a(var28, var32, var36, var12, var16);
/*      */     } else {
/* 4263 */       var9.a(var28, var30, var36, var22, var26);
/* 4264 */       var9.a(var28, var30, var34, var14, var18);
/* 4265 */       var9.a(var28, var32, var34, var20, var24);
/* 4266 */       var9.a(var28, var32, var36, var12, var16);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(pb var1, int var2, float var3) {
/* 4272 */     adz var4 = adz.a;
/* 4273 */     boolean var5 = (var1.bO == pb.u.bO);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4278 */     if (this.c) {
/* 4279 */       int i = var1.d(var2);
/* 4280 */       if (var5) {
/* 4281 */         i = 16777215;
/*      */       }
/*      */       
/* 4284 */       float var7 = (i >> 16 & 0xFF) / 255.0F;
/* 4285 */       float var8 = (i >> 8 & 0xFF) / 255.0F;
/* 4286 */       float var9 = (i & 0xFF) / 255.0F;
/* 4287 */       GL11.glColor4f(var7 * var3, var8 * var3, var9 * var3, 1.0F);
/*      */     } 
/*      */     
/* 4290 */     int var6 = var1.d();
/*      */     
/* 4292 */     if (var6 != 0 && var6 != 16) {
/* 4293 */       if (var6 == 1) {
/* 4294 */         var4.b();
/* 4295 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4296 */         a(var1, var2, -0.5D, -0.5D, -0.5D);
/* 4297 */         var4.a();
/* 4298 */       } else if (var6 == 19) {
/* 4299 */         var4.b();
/* 4300 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4301 */         var1.h();
/* 4302 */         a(var1, var2, var1.bZ, -0.5D, -0.5D, -0.5D);
/* 4303 */         var4.a();
/* 4304 */       } else if (var6 == 23) {
/* 4305 */         var4.b();
/* 4306 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4307 */         var1.h();
/* 4308 */         var4.a();
/* 4309 */       } else if (var6 == 13) {
/* 4310 */         var1.h();
/* 4311 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4312 */         float var7 = 0.0625F;
/* 4313 */         var4.b();
/* 4314 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4315 */         a(var1, 0.0D, 0.0D, 0.0D, var1.a_(0));
/* 4316 */         var4.a();
/* 4317 */         var4.b();
/* 4318 */         var4.b(0.0F, 1.0F, 0.0F);
/* 4319 */         b(var1, 0.0D, 0.0D, 0.0D, var1.a_(1));
/* 4320 */         var4.a();
/* 4321 */         var4.b();
/* 4322 */         var4.b(0.0F, 0.0F, -1.0F);
/* 4323 */         var4.c(0.0F, 0.0F, var7);
/* 4324 */         c(var1, 0.0D, 0.0D, 0.0D, var1.a_(2));
/* 4325 */         var4.c(0.0F, 0.0F, -var7);
/* 4326 */         var4.a();
/* 4327 */         var4.b();
/* 4328 */         var4.b(0.0F, 0.0F, 1.0F);
/* 4329 */         var4.c(0.0F, 0.0F, -var7);
/* 4330 */         d(var1, 0.0D, 0.0D, 0.0D, var1.a_(3));
/* 4331 */         var4.c(0.0F, 0.0F, var7);
/* 4332 */         var4.a();
/* 4333 */         var4.b();
/* 4334 */         var4.b(-1.0F, 0.0F, 0.0F);
/* 4335 */         var4.c(var7, 0.0F, 0.0F);
/* 4336 */         e(var1, 0.0D, 0.0D, 0.0D, var1.a_(4));
/* 4337 */         var4.c(-var7, 0.0F, 0.0F);
/* 4338 */         var4.a();
/* 4339 */         var4.b();
/* 4340 */         var4.b(1.0F, 0.0F, 0.0F);
/* 4341 */         var4.c(-var7, 0.0F, 0.0F);
/* 4342 */         f(var1, 0.0D, 0.0D, 0.0D, var1.a_(5));
/* 4343 */         var4.c(var7, 0.0F, 0.0F);
/* 4344 */         var4.a();
/* 4345 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 4346 */       } else if (var6 == 22) {
/* 4347 */         df.a.a(var1, var2, var3);
/* 4348 */         GL11.glEnable(32826);
/* 4349 */       } else if (var6 == 6) {
/* 4350 */         var4.b();
/* 4351 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4352 */         b(var1, var2, -0.5D, -0.5D, -0.5D);
/* 4353 */         var4.a();
/* 4354 */       } else if (var6 == 2) {
/* 4355 */         var4.b();
/* 4356 */         var4.b(0.0F, -1.0F, 0.0F);
/* 4357 */         a(var1, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
/* 4358 */         var4.a();
/* 4359 */       } else if (var6 == 10) {
/* 4360 */         for (int var14 = 0; var14 < 2; var14++) {
/* 4361 */           if (var14 == 0) {
/* 4362 */             var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
/*      */           }
/*      */           
/* 4365 */           if (var14 == 1) {
/* 4366 */             var1.a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
/*      */           }
/*      */           
/* 4369 */           GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4370 */           var4.b();
/* 4371 */           var4.b(0.0F, -1.0F, 0.0F);
/* 4372 */           a(var1, 0.0D, 0.0D, 0.0D, var1.a_(0));
/* 4373 */           var4.a();
/* 4374 */           var4.b();
/* 4375 */           var4.b(0.0F, 1.0F, 0.0F);
/* 4376 */           b(var1, 0.0D, 0.0D, 0.0D, var1.a_(1));
/* 4377 */           var4.a();
/* 4378 */           var4.b();
/* 4379 */           var4.b(0.0F, 0.0F, -1.0F);
/* 4380 */           c(var1, 0.0D, 0.0D, 0.0D, var1.a_(2));
/* 4381 */           var4.a();
/* 4382 */           var4.b();
/* 4383 */           var4.b(0.0F, 0.0F, 1.0F);
/* 4384 */           d(var1, 0.0D, 0.0D, 0.0D, var1.a_(3));
/* 4385 */           var4.a();
/* 4386 */           var4.b();
/* 4387 */           var4.b(-1.0F, 0.0F, 0.0F);
/* 4388 */           e(var1, 0.0D, 0.0D, 0.0D, var1.a_(4));
/* 4389 */           var4.a();
/* 4390 */           var4.b();
/* 4391 */           var4.b(1.0F, 0.0F, 0.0F);
/* 4392 */           f(var1, 0.0D, 0.0D, 0.0D, var1.a_(5));
/* 4393 */           var4.a();
/* 4394 */           GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */         } 
/* 4396 */       } else if (var6 == 27) {
/* 4397 */         int var14 = 0;
/* 4398 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4399 */         var4.b();
/*      */         
/* 4401 */         for (int var15 = 0; var15 < 8; var15++) {
/* 4402 */           byte var16 = 0;
/* 4403 */           byte var17 = 1;
/* 4404 */           if (var15 == 0) {
/* 4405 */             var16 = 2;
/*      */           }
/*      */           
/* 4408 */           if (var15 == 1) {
/* 4409 */             var16 = 3;
/*      */           }
/*      */           
/* 4412 */           if (var15 == 2) {
/* 4413 */             var16 = 4;
/*      */           }
/*      */           
/* 4416 */           if (var15 == 3) {
/* 4417 */             var16 = 5;
/* 4418 */             var17 = 2;
/*      */           } 
/*      */           
/* 4421 */           if (var15 == 4) {
/* 4422 */             var16 = 6;
/* 4423 */             var17 = 3;
/*      */           } 
/*      */           
/* 4426 */           if (var15 == 5) {
/* 4427 */             var16 = 7;
/* 4428 */             var17 = 5;
/*      */           } 
/*      */           
/* 4431 */           if (var15 == 6) {
/* 4432 */             var16 = 6;
/* 4433 */             var17 = 2;
/*      */           } 
/*      */           
/* 4436 */           if (var15 == 7) {
/* 4437 */             var16 = 3;
/*      */           }
/*      */           
/* 4440 */           float var11 = var16 / 16.0F;
/* 4441 */           float var12 = 1.0F - var14 / 16.0F;
/* 4442 */           float var13 = 1.0F - (var14 + var17) / 16.0F;
/* 4443 */           var14 += var17;
/* 4444 */           var1.a(0.5F - var11, var13, 0.5F - var11, 0.5F + var11, var12, 0.5F + var11);
/* 4445 */           var4.b(0.0F, -1.0F, 0.0F);
/* 4446 */           a(var1, 0.0D, 0.0D, 0.0D, var1.a_(0));
/* 4447 */           var4.b(0.0F, 1.0F, 0.0F);
/* 4448 */           b(var1, 0.0D, 0.0D, 0.0D, var1.a_(1));
/* 4449 */           var4.b(0.0F, 0.0F, -1.0F);
/* 4450 */           c(var1, 0.0D, 0.0D, 0.0D, var1.a_(2));
/* 4451 */           var4.b(0.0F, 0.0F, 1.0F);
/* 4452 */           d(var1, 0.0D, 0.0D, 0.0D, var1.a_(3));
/* 4453 */           var4.b(-1.0F, 0.0F, 0.0F);
/* 4454 */           e(var1, 0.0D, 0.0D, 0.0D, var1.a_(4));
/* 4455 */           var4.b(1.0F, 0.0F, 0.0F);
/* 4456 */           f(var1, 0.0D, 0.0D, 0.0D, var1.a_(5));
/*      */         } 
/*      */         
/* 4459 */         var4.a();
/* 4460 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 4461 */         var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 4462 */       } else if (var6 == 11) {
/* 4463 */         for (int var14 = 0; var14 < 4; var14++) {
/* 4464 */           float var8 = 0.125F;
/* 4465 */           if (var14 == 0) {
/* 4466 */             var1.a(0.5F - var8, 0.0F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
/*      */           }
/*      */           
/* 4469 */           if (var14 == 1) {
/* 4470 */             var1.a(0.5F - var8, 0.0F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
/*      */           }
/*      */           
/* 4473 */           var8 = 0.0625F;
/* 4474 */           if (var14 == 2) {
/* 4475 */             var1.a(0.5F - var8, 1.0F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 1.0F - var8, 1.0F + var8 * 2.0F);
/*      */           }
/*      */           
/* 4478 */           if (var14 == 3) {
/* 4479 */             var1.a(0.5F - var8, 0.5F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 0.5F - var8, 1.0F + var8 * 2.0F);
/*      */           }
/*      */           
/* 4482 */           GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4483 */           var4.b();
/* 4484 */           var4.b(0.0F, -1.0F, 0.0F);
/* 4485 */           a(var1, 0.0D, 0.0D, 0.0D, var1.a_(0));
/* 4486 */           var4.a();
/* 4487 */           var4.b();
/* 4488 */           var4.b(0.0F, 1.0F, 0.0F);
/* 4489 */           b(var1, 0.0D, 0.0D, 0.0D, var1.a_(1));
/* 4490 */           var4.a();
/* 4491 */           var4.b();
/* 4492 */           var4.b(0.0F, 0.0F, -1.0F);
/* 4493 */           c(var1, 0.0D, 0.0D, 0.0D, var1.a_(2));
/* 4494 */           var4.a();
/* 4495 */           var4.b();
/* 4496 */           var4.b(0.0F, 0.0F, 1.0F);
/* 4497 */           d(var1, 0.0D, 0.0D, 0.0D, var1.a_(3));
/* 4498 */           var4.a();
/* 4499 */           var4.b();
/* 4500 */           var4.b(-1.0F, 0.0F, 0.0F);
/* 4501 */           e(var1, 0.0D, 0.0D, 0.0D, var1.a_(4));
/* 4502 */           var4.a();
/* 4503 */           var4.b();
/* 4504 */           var4.b(1.0F, 0.0F, 0.0F);
/* 4505 */           f(var1, 0.0D, 0.0D, 0.0D, var1.a_(5));
/* 4506 */           var4.a();
/* 4507 */           GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */         } 
/*      */         
/* 4510 */         var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 4511 */       } else if (var6 == 21) {
/* 4512 */         for (int var14 = 0; var14 < 3; var14++) {
/* 4513 */           float var8 = 0.0625F;
/* 4514 */           if (var14 == 0) {
/* 4515 */             var1.a(0.5F - var8, 0.3F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
/*      */           }
/*      */           
/* 4518 */           if (var14 == 1) {
/* 4519 */             var1.a(0.5F - var8, 0.3F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
/*      */           }
/*      */           
/* 4522 */           var8 = 0.0625F;
/* 4523 */           if (var14 == 2) {
/* 4524 */             var1.a(0.5F - var8, 0.5F, 0.0F, 0.5F + var8, 1.0F - var8, 1.0F);
/*      */           }
/*      */           
/* 4527 */           GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4528 */           var4.b();
/* 4529 */           var4.b(0.0F, -1.0F, 0.0F);
/* 4530 */           a(var1, 0.0D, 0.0D, 0.0D, var1.a_(0));
/* 4531 */           var4.a();
/* 4532 */           var4.b();
/* 4533 */           var4.b(0.0F, 1.0F, 0.0F);
/* 4534 */           b(var1, 0.0D, 0.0D, 0.0D, var1.a_(1));
/* 4535 */           var4.a();
/* 4536 */           var4.b();
/* 4537 */           var4.b(0.0F, 0.0F, -1.0F);
/* 4538 */           c(var1, 0.0D, 0.0D, 0.0D, var1.a_(2));
/* 4539 */           var4.a();
/* 4540 */           var4.b();
/* 4541 */           var4.b(0.0F, 0.0F, 1.0F);
/* 4542 */           d(var1, 0.0D, 0.0D, 0.0D, var1.a_(3));
/* 4543 */           var4.a();
/* 4544 */           var4.b();
/* 4545 */           var4.b(-1.0F, 0.0F, 0.0F);
/* 4546 */           e(var1, 0.0D, 0.0D, 0.0D, var1.a_(4));
/* 4547 */           var4.a();
/* 4548 */           var4.b();
/* 4549 */           var4.b(1.0F, 0.0F, 0.0F);
/* 4550 */           f(var1, 0.0D, 0.0D, 0.0D, var1.a_(5));
/* 4551 */           var4.a();
/* 4552 */           GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */         } 
/*      */         
/* 4555 */         var1.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*      */       } else {
/* 4557 */         ModLoader.renderInvBlock(this, var1, var2, var6);
/*      */       } 
/*      */     } else {
/* 4560 */       if (var6 == 16) {
/* 4561 */         var2 = 1;
/*      */       }
/*      */       
/* 4564 */       var1.h();
/* 4565 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 4566 */       var4.b();
/* 4567 */       var4.b(0.0F, -1.0F, 0.0F);
/* 4568 */       a(var1, 0.0D, 0.0D, 0.0D, var1.a(0, var2));
/* 4569 */       var4.a();
/* 4570 */       if (var5 && this.c) {
/* 4571 */         int var14 = var1.d(var2);
/* 4572 */         float var8 = (var14 >> 16 & 0xFF) / 255.0F;
/* 4573 */         float var9 = (var14 >> 8 & 0xFF) / 255.0F;
/* 4574 */         float var10 = (var14 & 0xFF) / 255.0F;
/* 4575 */         GL11.glColor4f(var8 * var3, var9 * var3, var10 * var3, 1.0F);
/*      */       } 
/*      */       
/* 4578 */       var4.b();
/* 4579 */       var4.b(0.0F, 1.0F, 0.0F);
/* 4580 */       b(var1, 0.0D, 0.0D, 0.0D, var1.a(1, var2));
/* 4581 */       var4.a();
/* 4582 */       if (var5 && this.c) {
/* 4583 */         GL11.glColor4f(var3, var3, var3, 1.0F);
/*      */       }
/*      */       
/* 4586 */       var4.b();
/* 4587 */       var4.b(0.0F, 0.0F, -1.0F);
/* 4588 */       c(var1, 0.0D, 0.0D, 0.0D, var1.a(2, var2));
/* 4589 */       var4.a();
/* 4590 */       var4.b();
/* 4591 */       var4.b(0.0F, 0.0F, 1.0F);
/* 4592 */       d(var1, 0.0D, 0.0D, 0.0D, var1.a(3, var2));
/* 4593 */       var4.a();
/* 4594 */       var4.b();
/* 4595 */       var4.b(-1.0F, 0.0F, 0.0F);
/* 4596 */       e(var1, 0.0D, 0.0D, 0.0D, var1.a(4, var2));
/* 4597 */       var4.a();
/* 4598 */       var4.b();
/* 4599 */       var4.b(1.0F, 0.0F, 0.0F);
/* 4600 */       f(var1, 0.0D, 0.0D, 0.0D, var1.a(5, var2));
/* 4601 */       var4.a();
/* 4602 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean a(int var0) {
/* 4608 */     return (var0 == 0) ? true : ((var0 == 13) ? true : ((var0 == 10) ? true : ((var0 == 11) ? true : ((var0 == 27) ? true : ((var0 == 22) ? true : ((var0 == 21) ? true : 
/* 4609 */       ModLoader.renderBlockIsItemFull3D(var0)))))));
/*      */   }
/*      */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\vl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */