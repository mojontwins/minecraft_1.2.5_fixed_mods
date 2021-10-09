/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import dd;
/*     */ import io;
/*     */ import yu;
/*     */ import yw;
/*     */ 
/*     */ public class ContainerRecipe
/*     */   extends dd
/*     */   implements io {
/*     */   public void clearInventory() {
/*  13 */     this.d.clear();
/*  14 */     this.e.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public aan a(int slot, int button, boolean flag, yw entityplayer) {
/*  19 */     if (slot < 0) {
/*  20 */       return null;
/*     */     }
/*  22 */     aan stack = k_(slot);
/*  23 */     if (stack != null)
/*     */     {
/*  25 */       if (button == 0) {
/*  26 */         GuiCraftingRecipe.openRecipeGui("item", new Object[] { stack });
/*  27 */       } else if (button == 1) {
/*  28 */         GuiUsageRecipe.openRecipeGui("item", new Object[] { stack });
/*     */       }  } 
/*  30 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSlot(PositionedStack stack, int recipex, int recipey) {
/*  35 */     int slot = this.e.size();
/*  36 */     a(new yu(this, slot, recipex + stack.relx, recipey + stack.rely)
/*     */         {
/*     */           
/*     */           public boolean a(aan par1ItemStack)
/*     */           {
/*  41 */             return false;
/*     */           }
/*     */         });
/*  44 */     a(slot, stack.item);
/*     */   }
/*     */ 
/*     */   
/*     */   public yu getSlotWithStack(PositionedStack stack, int recipex, int recipey) {
/*  49 */     for (int i = 0; i < this.e.size(); i++) {
/*     */       
/*  51 */       yu slot = this.e.get(i);
/*  52 */       if (slot.d == stack.relx + recipex && slot.e == stack.rely + recipey)
/*  53 */         return slot; 
/*     */     } 
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(yw entityplayer) {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a_(yw entityplayer) {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a() {
/*  70 */     return this.e.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public aan k_(int i) {
/*  75 */     if (i == -999) return null; 
/*  76 */     return this.d.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public aan a(int i, int j) {
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int slot, aan itemstack) {
/*  87 */     this.d.set(slot, itemstack);
/*     */   }
/*     */ 
/*     */   
/*     */   public String c() {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int d() {
/*  97 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void j() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void e() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public aan b(int var1) {
/* 115 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ContainerRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */