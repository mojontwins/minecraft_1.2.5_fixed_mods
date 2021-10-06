/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BaseMod
/*     */ {
/*     */   public int addFuel(int id, int metadata) {
/*  17 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRenderer(Map<Class<? extends nn>, um> renderers) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dispenseEntity(xd world, double x, double y, double z, int xVel, int zVel, aan item) {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateNether(xd world, Random random, int chunkX, int chunkZ) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateSurface(xd world, Random random, int chunkX, int chunkZ) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  67 */     return getClass().getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPriorities() {
/* 119 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String getVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyboardEvent(afu event) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void load();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void modsLoaded() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onItemPickup(yw player, aan item) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onTickInGame(float tick, Minecraft game) {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onTickInGUI(float tick, Minecraft game, vp gui) {
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveChatPacket(String text) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveCustomPacket(ee packet) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerAnimation(Minecraft game) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInvBlock(vl renderer, pb block, int metadata, int modelID) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(vl renderer, ali world, int x, int y, int z, pb block, int modelID) {
/* 207 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serverConnect(adl handler) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serverDisconnect() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void takenFromCrafting(yw player, aan item, io matrix) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void takenFromFurnace(yw player, aan item) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 235 */     return String.valueOf(getName()) + ' ' + getVersion();
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\BaseMod.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */