/*    */ package codechicken.nei;
/*    */ 
/*    */ import aan;
/*    */ import acq;
/*    */ import ahu;
/*    */ import es;
/*    */ import forge.IItemRenderer;
/*    */ import nn;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import pb;
/*    */ import vl;
/*    */ import xd;
/*    */ 
/*    */ 
/*    */ public class SpawnerRenderer
/*    */   implements IItemRenderer
/*    */ {
/*    */   public boolean handleRenderType(aan item, IItemRenderer.ItemRenderType type) {
/* 19 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderInventoryItem(vl render, aan item) {
/* 24 */     int meta = item.i();
/*    */     
/* 26 */     if (meta == 0)
/*    */     {
/* 28 */       meta = ItemMobSpawner.idPig;
/*    */     }
/*    */     
/* 31 */     xd world = (NEIUtils.getMinecraft()).f;
/* 32 */     ItemMobSpawner.loadSpawners(world);
/* 33 */     render.a(pb.as, 0, 1.0F);
/* 34 */     GL11.glPushMatrix();
/*    */     
/* 36 */     acq acq = ItemMobSpawner.getEntity(meta);
/* 37 */     if (acq != null) {
/*    */       
/* 39 */       acq.a(world);
/* 40 */       float f1 = 0.4375F;
/* 41 */       if (acq.h_() > 1.5D)
/*    */       {
/* 43 */         f1 = 0.1F;
/*    */       }
/* 45 */       GL11.glRotatef((float)(world.w() * 10L), 0.0F, 1.0F, 0.0F);
/* 46 */       GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
/* 47 */       GL11.glTranslatef(0.0F, -0.4F, 0.0F);
/* 48 */       GL11.glScalef(f1, f1, f1);
/* 49 */       acq.c(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/* 50 */       ahu.a.a((nn)acq, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*    */     } 
/* 52 */     GL11.glPopMatrix();
/*    */     
/* 54 */     GL11.glEnable(32826);
/* 55 */     es.a(es.b);
/* 56 */     GL11.glDisable(3553);
/* 57 */     es.a(es.a);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, aan item, Object... data) {
/* 63 */     switch (type) {
/*    */       
/*    */       case EQUIPPED:
/* 66 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*    */       case null:
/*    */       case INVENTORY:
/* 69 */         renderInventoryItem((vl)data[0], item);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, aan item, IItemRenderer.ItemRendererHelper helper) {
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\SpawnerRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */