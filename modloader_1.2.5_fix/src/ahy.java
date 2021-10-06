/*    */ public class ahy extends wp {
/*  2 */   public static abn[] biomeArray = new abn[] { abn.d, abn.f, abn.e, abn.h, abn.c, 
/*  3 */       abn.g, abn.w };
/*  4 */   private abn[] b = biomeArray;
/*    */   
/*    */   public ahy(long paramLong, wp paramwp, vx paramvx) {
/*  7 */     super(paramLong);
/*  8 */     this.a = paramwp;
/*    */     
/* 10 */     if (paramvx == vx.d)
/* 11 */       this.b = new abn[] { abn.d, abn.f, abn.e, abn.h, abn.c, abn.g }; 
/*    */   }
/*    */   
/*    */   public int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 15 */     int[] arrayOfInt1 = this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */     
/* 17 */     int[] arrayOfInt2 = ad.a(paramInt3 * paramInt4);
/* 18 */     for (int i = 0; i < paramInt4; i++) {
/* 19 */       for (int j = 0; j < paramInt3; j++) {
/* 20 */         a((j + paramInt1), (i + paramInt2));
/* 21 */         int k = arrayOfInt1[j + i * paramInt3];
/* 22 */         if (k == 0) { arrayOfInt2[j + i * paramInt3] = 0; }
/* 23 */         else if (k == abn.p.M) { arrayOfInt2[j + i * paramInt3] = k; }
/* 24 */         else if (k == 1) { arrayOfInt2[j + i * paramInt3] = (this.b[a(this.b.length)]).M; }
/*    */         else
/* 26 */         { arrayOfInt2[j + i * paramInt3] = abn.n.M; }
/*    */       
/*    */       } 
/*    */     } 
/*    */     
/* 31 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ahy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */