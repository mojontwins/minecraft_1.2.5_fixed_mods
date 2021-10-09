/*    */ package codechicken.nei;
/*    */ 
/*    */ import aak;
/*    */ import abp;
/*    */ import dd;
/*    */ import gb;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import xd;
/*    */ 
/*    */ public class GuiEnchantmentModifier
/*    */   extends gb
/*    */ {
/*    */   ContainerEnchantmentModifier container;
/*    */   
/*    */   public GuiEnchantmentModifier(aak inventoryplayer, xd world, int i, int j, int k) {
/* 16 */     super((dd)new ContainerEnchantmentModifier(inventoryplayer, world, i, j, k));
/* 17 */     this.container = (ContainerEnchantmentModifier)this.d;
/* 18 */     this.container.parentscreen = this;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void d() {
/* 23 */     this.u.b("Enchant", 12, 6, 4210752);
/* 24 */     this.u.b("Level", 19, 20, 4210752);
/* 25 */     this.u.b("Inventory", 8, this.c - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(float f, int i, int j) {
/* 30 */     int k = this.p.p.b("/gui/enchant.png");
/* 31 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */     this.p.p.b(k);
/* 33 */     GL11.glTranslatef(this.e, this.f, 0.0F);
/* 34 */     b(0, 0, 0, 0, this.b, this.c);
/*    */     
/* 36 */     this.container.onUpdate(i, j);
/* 37 */     this.container.drawSlots(this);
/* 38 */     this.container.drawScrollBar(this);
/*    */     
/* 40 */     int m = this.container.level;
/* 41 */     this.u.b(m, 33 - this.u.a(m) / 2, 34, -10461088);
/*    */     
/* 43 */     GL11.glTranslatef(-this.e, -this.f, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void c() {
/* 49 */     super.c();
/*    */     
/* 51 */     this.s.add(new GuiNEIButton(0, this.q / 2 - 78, this.r / 2 - 52, 12, 12, "<"));
/* 52 */     this.s.add(new GuiNEIButton(1, this.q / 2 - 44, this.r / 2 - 52, 12, 12, ">"));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(abp guibutton) {
/* 57 */     if (guibutton.f == 0) {
/*    */       
/* 59 */       changeLevel(-1);
/*    */     }
/* 61 */     else if (guibutton.f == 1) {
/*    */       
/* 63 */       changeLevel(1);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void changeLevel(int i) {
/* 69 */     this.container.level += i;
/* 70 */     ((abp)this.s.get(0)).h = (this.container.level != 1);
/* 71 */     ((abp)this.s.get(1)).h = (this.container.level != 10);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(int i, int j, int k) {
/* 76 */     if (this.container.clickButton(i, j, k))
/* 77 */       return;  if (this.container.clickScrollBar(i, j, k))
/*    */       return; 
/* 79 */     super.a(i, j, k);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void b(int i, int j, int k) {
/* 84 */     this.container.mouseUp(i, j, k);
/* 85 */     super.b(i, j, k);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiEnchantmentModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */