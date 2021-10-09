/*     */ package codechicken.nei;
/*     */ 
/*     */ import ContainerCreativeInv;
/*     */ import aan;
/*     */ import abs;
/*     */ import adl;
/*     */ import codechicken.core.CoreUtils;
/*     */ import codechicken.core.ICustomPacketHandler;
/*     */ import codechicken.core.PacketCustom;
/*     */ import dd;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mod_NotEnoughItems;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import vp;
/*     */ import xd;
/*     */ import yw;
/*     */ 
/*     */ public class NEIPacketHandler implements ICustomPacketHandler {
/*     */   public void handlePacket(PacketCustom packet, adl nethandler, Minecraft mc) {
/*  21 */     switch (packet.getType()) {
/*     */       
/*     */       case 1:
/*  24 */         handleSMPCheck(packet.readUnsignedByte(), mc.f);
/*     */         break;
/*     */       case 6:
/*  27 */         NEIConfig.setMagnetMode(packet.readBoolean());
/*     */         break;
/*     */       case 7:
/*  30 */         NEIUtils.setCreativeMode(packet.readUnsignedByte());
/*     */         break;
/*     */       case 10:
/*  33 */         handlePermissableActions(packet);
/*     */         break;
/*     */       case 11:
/*  36 */         handleBannedBlocks(packet);
/*     */         break;
/*     */       case 12:
/*  39 */         handleDisabledProperties(packet);
/*     */         break;
/*     */       case 13:
/*  42 */         mod_NotEnoughItems.addSMPMagneticItem(packet.readInt(), mc.f);
/*     */         break;
/*     */       case 21:
/*  45 */         CoreUtils.openSMPGui(packet.readUnsignedByte(), (vp)new GuiEnchantmentModifier(mc.h.ap, mc.f, 0, 0, 0));
/*     */         break;
/*     */       case 23:
/*  48 */         CoreUtils.openSMPGui(packet.readUnsignedByte(), (vp)new GuiExtendedCreativeInv((dd)new ContainerCreativeInv((yw)mc.h)));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleDisabledProperties(PacketCustom packet) {
/*  55 */     NEIConfig.resetDisabledProperties();
/*  56 */     int num = packet.readUnsignedByte();
/*  57 */     for (int i = 0; i < num; i++)
/*     */     {
/*  59 */       NEIConfig.setPropertyDisabled(packet.readUnsignedByte()); } 
/*     */   }
/*     */   
/*     */   public static final String channel = "NEI";
/*     */   
/*     */   private void handleBannedBlocks(PacketCustom packet) {
/*  65 */     int num = packet.readInt();
/*  66 */     ArrayList<ItemHash> items = new ArrayList(num);
/*  67 */     for (int i = 0; i < num; i++)
/*     */     {
/*  69 */       items.add(new ItemHash(packet.readUnsignedShort(), packet.readUnsignedShort()));
/*     */     }
/*  71 */     NEIConfig.setBannedBlocks(items);
/*     */     
/*  73 */     if (NEIController.window != null) {
/*  74 */       NEIController.window.refresh();
/*     */     }
/*     */   }
/*     */   
/*     */   private void handlePermissableActions(PacketCustom packet) {
/*  79 */     NEIConfig.resetPermissableActions();
/*  80 */     int num = packet.readUnsignedByte();
/*  81 */     for (int i = 0; i < num; i++)
/*     */     {
/*  83 */       NEIConfig.addPermissableAction(InterActionMap.values()[packet.readUnsignedByte()]);
/*     */     }
/*     */     
/*  86 */     if (NEIController.window != null) {
/*  87 */       NEIController.window.refresh();
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleSMPCheck(int serverprotocol, xd world) {
/*  92 */     if (serverprotocol > 4) {
/*     */       
/*  94 */       NEIUtils.addChatMessage("NEI version mismatch: Outdated Client");
/*     */     }
/*  96 */     else if (serverprotocol < 4) {
/*     */       
/*  98 */       NEIUtils.addChatMessage("NEI version mismatch: Outdated Server");
/*     */     }
/*     */     else {
/*     */       
/* 102 */       mod_NotEnoughItems.reset(world);
/* 103 */       NEIConfig.setHasSMPCounterPart(true);
/* 104 */       sendRequestLoginInfo();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSpawnItem(aan spawnstack, boolean infinite) {
/* 110 */     PacketCustom packet = new PacketCustom("NEI", 1);
/* 111 */     packet.writeBoolean(infinite);
/*     */     
/* 113 */     List name = NEIUtils.itemDisplayNameMultiline(spawnstack, false);
/* 114 */     packet.writeByte(name.size());
/* 115 */     for (String s : name)
/*     */     {
/* 117 */       packet.writeString(s);
/*     */     }
/*     */     
/* 120 */     packet.writeItemStack(spawnstack);
/* 121 */     packet.writeInt(spawnstack.a);
/* 122 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendDeleteAllItems() {
/* 127 */     PacketCustom packet = new PacketCustom("NEI", 4);
/* 128 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendStateLoad(aan[] state) {
/* 133 */     sendDeleteAllItems();
/* 134 */     for (int slot = 0; slot < state.length; slot++) {
/*     */       
/* 136 */       aan item = state[slot];
/* 137 */       if (item != null)
/*     */       {
/*     */ 
/*     */         
/* 141 */         sendSetSlot(slot, item, false);
/*     */       }
/*     */     } 
/* 144 */     PacketCustom packet = new PacketCustom("NEI", 11);
/* 145 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSetSlot(int slot, aan stack, boolean container) {
/* 150 */     PacketCustom packet = new PacketCustom("NEI", 5);
/* 151 */     packet.writeBoolean(container);
/* 152 */     packet.writeShort(slot);
/* 153 */     packet.writeItemStack(stack);
/* 154 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sendRequestLoginInfo() {
/* 159 */     PacketCustom packet = new PacketCustom("NEI", 10);
/* 160 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendToggleMagnetMode() {
/* 165 */     PacketCustom packet = new PacketCustom("NEI", 6);
/* 166 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSetTime(int hour) {
/* 171 */     PacketCustom packet = new PacketCustom("NEI", 7);
/* 172 */     packet.writeByte(hour);
/* 173 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendHeal() {
/* 178 */     PacketCustom packet = new PacketCustom("NEI", 8);
/* 179 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendToggleRain() {
/* 184 */     PacketCustom packet = new PacketCustom("NEI", 9);
/* 185 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendOpenEnchantmentWindow() {
/* 190 */     PacketCustom packet = new PacketCustom("NEI", 21);
/* 191 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendModifyEnchantment(int enchID, int level, boolean add) {
/* 196 */     PacketCustom packet = new PacketCustom("NEI", 22);
/* 197 */     packet.writeByte(enchID);
/* 198 */     packet.writeByte(level);
/* 199 */     packet.writeBoolean(add);
/* 200 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSetPropertyDisabled(String name, boolean enable) {
/* 205 */     PacketCustom packet = new PacketCustom("NEI", 12);
/* 206 */     packet.writeByte(((Integer)AllowedPropertyMap.nameToIDMap.get(name)).intValue());
/* 207 */     packet.writeBoolean(enable);
/* 208 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendCycleCreativeMode() {
/* 213 */     PacketCustom packet = new PacketCustom("NEI", 13);
/* 214 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendOpenCreativeInv() {
/* 221 */     PacketCustom packet = new PacketCustom("NEI", 23);
/* 222 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendCreativeScroll(int steps) {
/* 227 */     PacketCustom packet = new PacketCustom("NEI", 14);
/* 228 */     packet.writeInt(steps);
/* 229 */     CoreUtils.sendPacket((abs)packet.toPacket());
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIPacketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */