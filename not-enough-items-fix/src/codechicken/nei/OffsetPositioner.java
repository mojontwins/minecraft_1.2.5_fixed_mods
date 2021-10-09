/*    */ package codechicken.nei;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class OffsetPositioner implements IStackPositioner {
/*    */   int offsetx;
/*    */   
/*    */   public OffsetPositioner(int x, int y) {
/*  9 */     this.offsetx = x;
/* 10 */     this.offsety = y;
/*    */   }
/*    */   
/*    */   int offsety;
/*    */   
/*    */   public ArrayList positionStacks(ArrayList ai) {
/* 16 */     for (PositionedStack stack : ai) {
/*    */       
/* 18 */       stack.relx += this.offsetx;
/* 19 */       stack.rely += this.offsety;
/*    */     } 
/* 21 */     return ai;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\OffsetPositioner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */