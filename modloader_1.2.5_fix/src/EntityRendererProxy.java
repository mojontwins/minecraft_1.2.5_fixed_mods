/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityRendererProxy
/*    */   extends lr
/*    */ {
/*    */   private Minecraft game;
/*    */   
/*    */   public EntityRendererProxy(Minecraft minecraft) {
/* 15 */     super(minecraft);
/* 16 */     this.game = minecraft;
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(float tick) {
/* 21 */     super.b(tick);
/* 22 */     ModLoader.onTick(tick, this.game);
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\EntityRendererProxy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */