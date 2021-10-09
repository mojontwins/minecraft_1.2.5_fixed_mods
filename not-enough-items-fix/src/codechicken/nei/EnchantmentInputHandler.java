/*    */ package codechicken.nei;
/*    */ 
/*    */ import gb;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import vp;
/*    */ 
/*    */ 
/*    */ public class EnchantmentInputHandler
/*    */   implements IHandleInput
/*    */ {
/*    */   public boolean canHandle(Class<GuiEnchantmentModifier> guiClass) {
/* 12 */     return (guiClass != GuiEnchantmentModifier.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean keyTyped(gb gui, char keyChar, int keyCode) {
/* 18 */     Minecraft mc = NEIUtils.getMinecraft();
/* 19 */     if (keyCode == NEIConfig.getKeyBinding("enchant") && NEIConfig.isActionPermissable(InterActionMap.ENCHANT)) {
/*    */       
/* 21 */       if (NEIConfig.isMultiplayer()) {
/*    */         
/* 23 */         NEIPacketHandler.sendOpenEnchantmentWindow();
/*    */       }
/*    */       else {
/*    */         
/* 27 */         mc.h.af();
/* 28 */         mc.a((vp)new GuiEnchantmentModifier(mc.h.ap, mc.f, 0, 0, 0));
/*    */       } 
/* 30 */       return true;
/*    */     } 
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean mouseClicked(gb gui, int mousex, int mousey, int button) {
/* 38 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\EnchantmentInputHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */