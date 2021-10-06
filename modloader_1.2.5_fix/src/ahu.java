/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ahu {
/*   6 */   private Map<Class<? extends nn>, um> o = new HashMap<Class<? extends nn>, um>();
/*     */   
/*   8 */   public static ahu a = new ahu();
/*     */   private nl p;
/*     */   public static double b;
/*     */   public static double c;
/*     */   public static double d;
/*     */   public aaw e;
/*     */   public mn f;
/*     */   public xd g;
/*     */   public acq h;
/*     */   public float i;
/*     */   public float j;
/*     */   public hu k;
/*     */   public double l;
/*     */   public double m;
/*     */   public double n;
/*     */   
/*     */   private ahu() {
/*  25 */     this.o.put(cb.class, new amo());
/*  26 */     this.o.put(fn.class, new amo());
/*  27 */     this.o.put(qr.class, new ix((ho)new dl(), (ho)new dl(0.5F), 0.7F));
/*  28 */     this.o.put(cu.class, new alq((ho)new jm(), (ho)new dj(), 0.7F));
/*  29 */     this.o.put(un.class, new ajh((ho)new ze(), 0.7F));
/*  30 */     this.o.put(of.class, new cl((ho)new ze(), 0.7F));
/*  31 */     this.o.put(yo.class, new aki((ho)new sx(), 0.5F));
/*  32 */     this.o.put(rd.class, new gn((ho)new ahp(), 0.3F));
/*  33 */     this.o.put(uo.class, new sw((ho)new mu(), 0.4F));
/*  34 */     this.o.put(qn.class, new vs());
/*  35 */     this.o.put(yd.class, new sv());
/*  36 */     this.o.put(jg.class, new st());
/*  37 */     this.o.put(q.class, new afm());
/*  38 */     this.o.put(xr.class, new tg((xg)new ie(), 0.5F));
/*  39 */     this.o.put(adg.class, new qz());
/*  40 */     this.o.put(ajg.class, new tg((xg)new wr(), 0.5F));
/*  41 */     this.o.put(aja.class, new jd((ho)new ads(16), (ho)new ads(0), 0.25F));
/*  42 */     this.o.put(aic.class, new aw());
/*  43 */     this.o.put(yw.class, new we());
/*  44 */     this.o.put(kh.class, new alz((ho)new wr(), 0.5F, 6.0F));
/*  45 */     this.o.put(ui.class, new lm());
/*  46 */     this.o.put(all.class, new ww((ho)new qw(), 0.7F));
/*  47 */     this.o.put(ed.class, new zb());
/*  48 */     this.o.put(tl.class, new co());
/*  49 */     this.o.put(acq.class, new fe((ho)new xg(), 0.5F));
/*     */     
/*  51 */     this.o.put(oq.class, new or());
/*  52 */     this.o.put(el.class, new ik());
/*     */     
/*  54 */     this.o.put(nn.class, new it());
/*     */     
/*  56 */     this.o.put(mk.class, new dh());
/*  57 */     this.o.put(nm.class, new iv());
/*  58 */     this.o.put(uq.class, new cr(yr.aD.b(0)));
/*  59 */     this.o.put(adw.class, new cr(yr.bn.b(0)));
/*  60 */     this.o.put(va.class, new cr(yr.bA.b(0)));
/*  61 */     this.o.put(qe.class, new cr(yr.aP.b(0)));
/*  62 */     this.o.put(bj.class, new cr(154));
/*  63 */     this.o.put(hf.class, new cr(yr.bD.b(0)));
/*  64 */     this.o.put(bt.class, new abu(2.0F));
/*  65 */     this.o.put(qb.class, new abu(0.5F));
/*  66 */     this.o.put(fq.class, new tw());
/*  67 */     this.o.put(bz.class, new tb());
/*  68 */     this.o.put(agg.class, new aeo());
/*  69 */     this.o.put(abf.class, new yt());
/*     */     
/*  71 */     this.o.put(ama.class, new ahm());
/*  72 */     this.o.put(ep.class, new ea());
/*  73 */     this.o.put(act.class, new afj());
/*     */     
/*  75 */     this.o.put(d.class, new afg());
/*     */     
/*  77 */     ModLoader.addAllRenderers(this.o);
/*     */     
/*  79 */     for (um localum : this.o.values())
/*  80 */       localum.a(this); 
/*     */   }
/*     */   
/*     */   public um a(Class<nn> paramClass) {
/*  84 */     um localum = this.o.get(paramClass);
/*  85 */     if (localum == null && paramClass != nn.class) {
/*  86 */       localum = a(paramClass.getSuperclass());
/*  87 */       this.o.put(paramClass, localum);
/*     */     } 
/*  89 */     return localum;
/*     */   }
/*     */   
/*     */   public um a(nn paramnn) {
/*  93 */     return a(paramnn.getClass());
/*     */   }
/*     */   
/*     */   public void a(xd paramxd, aaw paramaaw, nl paramnl, acq paramacq, hu paramhu, float paramFloat) {
/*  97 */     this.g = paramxd;
/*  98 */     this.e = paramaaw;
/*  99 */     this.k = paramhu;
/* 100 */     this.h = paramacq;
/* 101 */     this.p = paramnl;
/*     */     
/* 103 */     if (paramacq.az()) {
/* 104 */       int i1 = paramxd.a(gk.c(paramacq.o), gk.c(paramacq.p), gk.c(paramacq.q));
/* 105 */       if (i1 == pb.S.bO) {
/* 106 */         int i2 = paramxd.e(gk.c(paramacq.o), gk.c(paramacq.p), gk.c(paramacq.q));
/*     */         
/* 108 */         int i3 = i2 & 0x3;
/*     */         
/* 110 */         this.i = (i3 * 90 + 180);
/* 111 */         this.j = 0.0F;
/*     */       } 
/*     */     } else {
/*     */       
/* 115 */       this.i = paramacq.w + (paramacq.u - paramacq.w) * paramFloat;
/* 116 */       this.j = paramacq.x + (paramacq.v - paramacq.x) * paramFloat;
/*     */     } 
/*     */     
/* 119 */     if (paramhu.E == 2) {
/* 120 */       this.i += 180.0F;
/*     */     }
/*     */     
/* 123 */     this.l = paramacq.N + (paramacq.o - paramacq.N) * paramFloat;
/* 124 */     this.m = paramacq.O + (paramacq.p - paramacq.O) * paramFloat;
/* 125 */     this.n = paramacq.P + (paramacq.q - paramacq.P) * paramFloat;
/*     */   }
/*     */   
/*     */   public void a(nn paramnn, float paramFloat) {
/* 129 */     double d1 = paramnn.N + (paramnn.o - paramnn.N) * paramFloat;
/* 130 */     double d2 = paramnn.O + (paramnn.p - paramnn.O) * paramFloat;
/* 131 */     double d3 = paramnn.P + (paramnn.q - paramnn.P) * paramFloat;
/* 132 */     float f1 = paramnn.w + (paramnn.u - paramnn.w) * paramFloat;
/*     */     
/* 134 */     int i1 = paramnn.b(paramFloat);
/* 135 */     if (paramnn.T()) {
/* 136 */       i1 = 15728880;
/*     */     }
/* 138 */     int i2 = i1 % 65536;
/* 139 */     int i3 = i1 / 65536;
/* 140 */     es.a(es.b, i2 / 1.0F, i3 / 1.0F);
/* 141 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 143 */     a(paramnn, d1 - b, d2 - c, d3 - d, f1, paramFloat);
/*     */   }
/*     */   
/*     */   public void a(nn paramnn, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2) {
/* 147 */     um localum = a(paramnn);
/* 148 */     if (localum != null) {
/* 149 */       localum.a(paramnn, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramFloat2);
/* 150 */       localum.b(paramnn, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramFloat2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(xd paramxd) {
/* 155 */     this.g = paramxd;
/*     */   }
/*     */   
/*     */   public double a(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 159 */     double d1 = paramDouble1 - this.l;
/* 160 */     double d2 = paramDouble2 - this.m;
/* 161 */     double d3 = paramDouble3 - this.n;
/* 162 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*     */   }
/*     */   
/*     */   public nl a() {
/* 166 */     return this.p;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ahu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */