/*    */ package codechicken.nei;
/*    */ 
/*    */ import abp;
/*    */ import gb;
/*    */ import vp;
/*    */ 
/*    */ public abstract class GuiNEIOptions extends vp {
/*    */   public gb parentScreen;
/*    */   
/*    */   public GuiNEIOptions(gb parentContainer) {
/* 11 */     this.parentScreen = parentContainer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void c() {
/* 17 */     this.s.add(new abp(200, this.q / 2 - 100, this.r / 6 + 168, "Done"));
/* 18 */     addBackButton();
/* 19 */     updateButtonNames();
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void updateButtonNames();
/*    */ 
/*    */   
/*    */   public void addBackButton() {
/* 27 */     this.s.add(new abp(201, this.q / 2 - 100, this.r / 6 + 145, getBackButtonName()));
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract String getBackButtonName();
/*    */ 
/*    */   
/*    */   public abstract void onBackButtonClick();
/*    */   
/*    */   protected void a(abp guibutton) {
/* 37 */     if (guibutton.f == 200) {
/*    */       
/* 39 */       this.p.a((vp)this.parentScreen);
/* 40 */       this.parentScreen.refresh();
/*    */     }
/* 42 */     else if (guibutton.f == 201) {
/*    */       
/* 44 */       onBackButtonClick();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(char keyChar, int keyID) {
/* 50 */     if (keyID == 1) {
/*    */       
/* 52 */       this.p.a((vp)this.parentScreen);
/* 53 */       this.parentScreen.refresh();
/*    */     } 
/* 55 */     super.a(keyChar, keyID);
/* 56 */     updateButtonNames();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(int i, int j, float f) {
/* 61 */     k();
/* 62 */     super.a(i, j, f);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEIOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */