/*    */ public class ajv extends yu {
/*    */   private yw a;
/*    */   private int f;
/*    */   
/*    */   public ajv(yw paramyw, io paramio, int paramInt1, int paramInt2, int paramInt3) {
/*  6 */     super(paramio, paramInt1, paramInt2, paramInt3);
/*    */     
/*  8 */     this.a = paramyw;
/*    */   }
/*    */   
/*    */   public boolean a(aan paramaan) {
/* 12 */     return false;
/*    */   }
/*    */   
/*    */   public aan a(int paramInt) {
/* 16 */     if (c()) {
/* 17 */       this.f += Math.min(paramInt, (b()).a);
/*    */     }
/* 19 */     return super.a(paramInt);
/*    */   }
/*    */   
/*    */   public void b(aan paramaan) {
/* 23 */     c(paramaan);
/* 24 */     super.b(paramaan);
/*    */   }
/*    */   
/*    */   protected void a(aan paramaan, int paramInt) {
/* 28 */     this.f += paramInt;
/* 29 */     c(paramaan);
/*    */   }
/*    */   
/*    */   protected void c(aan paramaan) {
/* 33 */     paramaan.a(this.a.k, this.a, this.f);
/* 34 */     this.f = 0;
/*    */     
/* 36 */     ModLoader.takenFromFurnace(this.a, paramaan);
/*    */     
/* 38 */     if (paramaan.c == yr.o.bQ)
/* 39 */       this.a.a((ajw)dp.k, 1); 
/* 40 */     if (paramaan.c == yr.aV.bQ)
/* 41 */       this.a.a((ajw)dp.p, 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ajv.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */