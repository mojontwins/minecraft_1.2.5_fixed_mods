/*    */ public class amn extends yu {
/*    */   private final io a;
/*    */   private yw f;
/*    */   private int g;
/*    */   
/*    */   public amn(yw paramyw, io paramio1, io paramio2, int paramInt1, int paramInt2, int paramInt3) {
/*  7 */     super(paramio2, paramInt1, paramInt2, paramInt3);
/*  8 */     this.f = paramyw;
/*  9 */     this.a = paramio1;
/*    */   }
/*    */   
/*    */   public boolean a(aan paramaan) {
/* 13 */     return false;
/*    */   }
/*    */   
/*    */   public aan a(int paramInt) {
/* 17 */     if (c()) {
/* 18 */       this.g += Math.min(paramInt, (b()).a);
/*    */     }
/* 20 */     return super.a(paramInt);
/*    */   }
/*    */   
/*    */   protected void a(aan paramaan, int paramInt) {
/* 24 */     this.g += paramInt;
/* 25 */     c(paramaan);
/*    */   }
/*    */   
/*    */   protected void c(aan paramaan) {
/* 29 */     paramaan.a(this.f.k, this.f, this.g);
/* 30 */     this.g = 0;
/*    */     
/* 32 */     if (paramaan.c == pb.ay.bO) { this.f.a((ajw)dp.h, 1); }
/* 33 */     else if (paramaan.c == yr.t.bQ) { this.f.a((ajw)dp.i, 1); }
/* 34 */     else if (paramaan.c == pb.aB.bO) { this.f.a((ajw)dp.j, 1); }
/* 35 */     else if (paramaan.c == yr.N.bQ) { this.f.a((ajw)dp.l, 1); }
/* 36 */     else if (paramaan.c == yr.U.bQ) { this.f.a((ajw)dp.m, 1); }
/* 37 */     else if (paramaan.c == yr.aZ.bQ) { this.f.a((ajw)dp.n, 1); }
/* 38 */     else if (paramaan.c == yr.x.bQ) { this.f.a((ajw)dp.o, 1); }
/* 39 */     else if (paramaan.c == yr.r.bQ) { this.f.a((ajw)dp.r, 1); }
/* 40 */     else if (paramaan.c == pb.bE.bO) { this.f.a((ajw)dp.D, 1); }
/* 41 */     else if (paramaan.c == pb.an.bO)
/* 42 */     { this.f.a((ajw)dp.F, 1); }
/*    */     
/* 44 */     ModLoader.takenFromCrafting(this.f, paramaan, this.a);
/*    */   }
/*    */   
/*    */   public void b(aan paramaan) {
/* 48 */     c(paramaan);
/*    */     
/* 50 */     for (int i = 0; i < this.a.a(); i++) {
/* 51 */       aan localaan1 = this.a.k_(i);
/* 52 */       if (localaan1 != null) {
/* 53 */         this.a.a(i, 1);
/*    */         
/* 55 */         if (localaan1.a().m()) {
/*    */ 
/*    */ 
/*    */           
/* 59 */           aan localaan2 = new aan(localaan1.a().l());
/*    */           
/* 61 */           if (!localaan1.a().i(localaan1) || !this.f.ap.a(localaan2))
/*    */           {
/*    */ 
/*    */             
/* 65 */             if (this.a.k_(i) == null)
/* 66 */             { this.a.a(i, localaan2); }
/* 67 */             else { this.f.a(localaan2); }
/*    */           
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\amn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */