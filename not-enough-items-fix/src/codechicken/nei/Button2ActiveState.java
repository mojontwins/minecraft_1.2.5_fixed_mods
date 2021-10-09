/*    */ package codechicken.nei;
/*    */ 
/*    */ public class Button2ActiveState extends Button {
/*    */   public Image icon2;
/*    */   
/*    */   public Button2ActiveState(String ident) {
/*  7 */     super(ident);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Image getRenderIcon() {
/* 13 */     if ((this.state & 0x8) != 0) {
/* 14 */       return this.icon2;
/*    */     }
/* 16 */     return this.icon;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\Button2ActiveState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */