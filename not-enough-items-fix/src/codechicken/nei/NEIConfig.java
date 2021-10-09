/*     */ package codechicken.nei;
/*     */ 
/*     */ import aak;
/*     */ import aan;
/*     */ import ady;
/*     */ import codechicken.core.CommonUtils;
/*     */ import codechicken.core.ConfigFile;
/*     */ import codechicken.core.ConfigTag;
/*     */ import codechicken.core.CoreUtils;
/*     */ import codechicken.core.IStringMatcher;
/*     */ import gh;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import no;
/*     */ import xd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NEIConfig
/*     */ {
/*     */   private static void setDefaults() {
/*  35 */     globalConfig.setComment("Main configuration of NEI.:Most of these options can be changed ingame.:Deleting any element will restore it to it's default value");
/*     */     
/*  37 */     globalConfig.getTag("KeyBinding").useBraces();
/*  38 */     globalConfig.getTag("options").useBraces();
/*  39 */     globalConfig.getTag("command").useBraces().setComment("Change these options if you have a different mod installed on the server that handles the commands differently, Eg. Bukkit Essentials");
/*  40 */     globalConfig.setNewLineMode(1);
/*     */     
/*  42 */     globalConfig.getTag("options.enable").setPosition(0).getBooleanValue(true);
/*  43 */     globalConfig.getTag("options.enablemp").setPosition(1).getBooleanValue(true);
/*  44 */     API.addSetting(new GuiNEISettings.NEIOption("")
/*     */         {
/*     */           
/*     */           public String getIdent()
/*     */           {
/*  49 */             return NEIConfig.isMultiplayer() ? "options.enablemp" : "options.enable";
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public String updateText() {
/*  55 */             return "NEI " + (enabled() ? "Enabled" : "Disabled");
/*     */           }
/*     */         });
/*     */     
/*  59 */     globalConfig.getTag("options.hidden").setPosition(2).getBooleanValue(false);
/*     */     
/*  61 */     globalConfig.getTag("options.cheatmode").setPosition(3).setNewLine(true).getIntValue(2);
/*  62 */     API.addSetting(new GuiNEISettings.NEIOption("options.cheatmode")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/*  67 */             (new String[3])[0] = "Recipe"; (new String[3])[1] = "Utility"; (new String[3])[2] = "Cheat"; return String.valueOf((new String[3])[intValue()]) + " Mode";
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void onClick() {
/*  73 */             NEIConfig.cycleCheatMode();
/*     */           }
/*     */         });
/*  76 */     globalConfig.getTag("options.lockmode").setPosition(4).setComment("For those who can't help themselves:Set this to a mode and you will be unable to change it ingame").getIntValue(-1);
/*  77 */     globalConfig.getTag("options.utility actions").setPosition(5).setDefaultValue("delete, magnet");
/*     */     
/*  79 */     StringBuilder actionlist = new StringBuilder();
/*  80 */     InterActionMap[] actions = InterActionMap.values();
/*  81 */     for (int i = 0; i < actions.length; i++) {
/*     */       
/*  83 */       if (i != 0)
/*  84 */         actionlist.append(", "); 
/*  85 */       actionlist.append(actions[i].getName());
/*     */     } 
/*     */     
/*  88 */     globalConfig.getTag("options.utility actions").setComment("list the actions that are considered 'utilities' rather than cheats:Choose from " + actionlist.toString());
/*     */ 
/*     */     
/*  91 */     globalConfig.getTag("options.layout style").setPosition(6).setNewLine(true).getIntValue(0);
/*  92 */     API.addSetting(new GuiNEISettings.NEIOption("options.layout style")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/*  97 */             return LayoutManager.getLayoutStyle().getName();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void onClick() {
/* 103 */             NEIConfig.cycleLayoutStyle();
/*     */           }
/*     */         });
/* 106 */     globalConfig.getTag("options.edge-align buttons").setPosition(7).getBooleanValue(false);
/*     */     
/* 108 */     globalConfig.getTag("options.show ids").setPosition(8).setNewLine(true).getIntValue(1);
/* 109 */     API.addSetting(new GuiNEISettings.NEIOption("options.show ids")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 114 */             (new String[3])[0] = "Hidden"; (new String[3])[1] = "Auto"; (new String[3])[2] = "Shown"; return "ItemID's: " + (new String[3])[intValue()];
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void onClick() {
/* 120 */             NEIConfig.cycleIDVisibility();
/*     */           }
/*     */         });
/*     */     
/* 124 */     globalConfig.getTag("options.realtimesearch").setPosition(9).getBooleanValue(true);
/* 125 */     API.addSetting(new GuiNEISettings.NEIOption("options.realtimesearch")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 130 */             return " Realtime Search " + (enabled() ? "Enabled" : "Disabled");
/*     */           }
/*     */         });
/* 133 */     globalConfig.getTag("options.searchinventories").setPosition(10).getBooleanValue(false);
/*     */     
/* 135 */     globalConfig.getTag("options.itemdrops").setPosition(11).setNewLine(true).getBooleanValue(true);
/* 136 */     API.addSetting(new GuiNEISettings.NEIOption("options.itemdrops")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 141 */             return "Item Drops: " + ((enabled() || NEIConfig.isMultiplayer()) ? "Enabled" : "Disabled");
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void onClick() {
/* 147 */             if (!NEIConfig.isMultiplayer()) {
/* 148 */               super.onClick();
/*     */             }
/*     */           }
/*     */         });
/* 152 */     globalConfig.getTag("command.creative").setComment("{0} = player, {1} = 1 for creative, 0 for survival").setDefaultValue("/gamemode {0} {1}");
/* 153 */     globalConfig.getTag("command.give").setNewLine(true).setComment("{0} = player, {1} = itemID, {2} = quantity, {3} = itemDamage").setDefaultValue("/give {0} {1} {2} {3}");
/* 154 */     globalConfig.getTag("command.time").setNewLine(true).setComment("{0} = worldtime").setDefaultValue("/time set {0}");
/* 155 */     globalConfig.getTag("command.rain").setNewLine(true).setComment("{0} = 1 for on, 0 for off").setDefaultValue("/toggledownfall");
/* 156 */     globalConfig.getTag("command.heal").setNewLine(true).setComment("The vanilla server doesn't have a heal command, however others may:{0} = player").setDefaultValue("null");
/*     */     
/* 158 */     checkCheatMode();
/*     */     
/* 160 */     addBlockIDSettings();
/* 161 */     setDefaultKeyBindings();
/*     */     
/* 163 */     globalConfig.saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addBlockIDSettings() {
/* 168 */     API.addSetting((new GuiNEISettings.NEIOption("")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 173 */             return "Block/Item ID Settings";
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void onClick() {
/* 179 */             NEIUtils.getMinecraft().a(new GuiNEIBlockIDs(((GuiNEISettings)(NEIUtils.getMinecraft()).s).parentScreen));
/*     */           }
/* 181 */         }).setGlobalOnly());
/*     */     
/* 183 */     globalConfig.getTag("ID dump").useBraces().setComment("Block/Item ID settings, configured via the options menu ingame.");
/* 184 */     globalConfig.getTag("ID dump.show empty blockIDs").getBooleanValue(false);
/* 185 */     API.addSetting(GuiNEIBlockIDs.class, new GuiNEISettings.NEIOption("ID dump.show empty blockIDs")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 190 */             return String.valueOf(enabled() ? "Show" : "Hide") + " Unused BlockIDs";
/*     */           }
/*     */         });
/* 193 */     globalConfig.getTag("ID dump.dump on load").getBooleanValue(false);
/* 194 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("ID dump.dump on load")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 199 */             return String.valueOf(enabled() ? "Dump ID Map" : "Do Nothing") + " on Load";
/*     */           }
/* 201 */         }).setGlobalOnly());
/* 202 */     globalConfig.getTag("ID dump.blockIDs").getBooleanValue(true);
/* 203 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("ID dump.blockIDs")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 208 */             return String.valueOf(enabled() ? "Dump" : "Ignore") + " BlockIDs";
/*     */           }
/* 210 */         }).setGlobalOnly());
/* 211 */     globalConfig.getTag("ID dump.itemIDs").getBooleanValue(false);
/* 212 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("ID dump.itemIDs")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 217 */             return String.valueOf(enabled() ? "Dump" : "Ignore") + " ItemIDs";
/*     */           }
/* 219 */         }).setGlobalOnly());
/* 220 */     globalConfig.getTag("ID dump.unused blockIDs").getBooleanValue(true);
/* 221 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("ID dump.unused blockIDs")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 226 */             return String.valueOf(enabled() ? "Dump" : "Ignore") + " Unused BlockIDs";
/*     */           }
/* 228 */         }).setGlobalOnly());
/* 229 */     globalConfig.getTag("ID dump.unused itemIDs").getBooleanValue(false);
/* 230 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("ID dump.unused itemIDs")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 235 */             return String.valueOf(enabled() ? "Dump" : "Ignore") + " Unused ItemIDs";
/*     */           }
/* 237 */         }).setGlobalOnly());
/*     */     
/* 239 */     API.addSetting(GuiNEIBlockIDs.class, (new GuiNEISettings.NEIOption("")
/*     */         {
/*     */           
/*     */           public String updateText()
/*     */           {
/* 244 */             return NEIConfig.canDump() ? "Dump ID Map Now" : "Nothing To Dump";
/*     */           }
/*     */ 
/*     */           
/*     */           public void onClick() {
/* 249 */             if (NEIConfig.canDump())
/* 250 */               NEIUtils.dumpIDs(); 
/*     */           }
/* 252 */         }).setGlobalOnly());
/*     */     
/* 254 */     if (!canDump()) {
/* 255 */       globalConfig.getTag("ID dump.dump on load").setBooleanValue(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canDump() {
/* 260 */     return !(!getBooleanSetting("ID dump.itemIDs") && !getBooleanSetting("ID dump.blockIDs") && !getBooleanSetting("ID dump.unused itemIDs") && !getBooleanSetting("ID dump.unused blockIDs"));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setDefaultKeyBindings() {
/* 265 */     API.addKeyBind("recipe", "Recipe", 19);
/* 266 */     API.addKeyBind("usage", "Usage", 22);
/* 267 */     API.addKeyBind("back", "Previous Recipe", 14);
/* 268 */     API.addKeyBind("enchant", "Enchantment", 45);
/* 269 */     API.addKeyBind("prev", "Prev Page", 201);
/* 270 */     API.addKeyBind("next", "Next Page", 209);
/* 271 */     API.addKeyBind("hide", "Hide\\Show", 24);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void convertBooleanSetting(ConfigTag tag, int valtrue, int valfalse) {
/* 277 */     String val = tag.getValue();
/* 278 */     if (val.equals("true")) {
/*     */       
/* 280 */       tag.setIntValue(valtrue);
/*     */     }
/* 282 */     else if (val.equals("false")) {
/*     */       
/* 284 */       tag.setIntValue(valfalse);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void loadWorld() {
/*     */     File saveDir;
/* 290 */     loadConfig();
/*     */     
/* 292 */     xd world = (NEIUtils.getMinecraft()).f;
/*     */     
/* 294 */     if (world instanceof je) {
/* 295 */       saveDir = new File(CoreUtils.getMinecraftDir(), "saves/NEI/" + CoreUtils.getServerIP().replace(':', '~'));
/*     */     } else {
/* 297 */       saveDir = CoreUtils.getWorldBaseSaveLocation(world);
/* 298 */     }  if (!saveDir.exists()) {
/* 299 */       saveDir.mkdirs();
/*     */     }
/* 301 */     worldConfig = new ConfigFile(new File(saveDir, "NEI.cfg"));
/* 302 */     localSave = new File(saveDir, "NEI.dat");
/*     */ 
/*     */     
/*     */     try {
/* 306 */       if (!localSave.exists()) {
/* 307 */         localSave.createNewFile();
/*     */       }
/* 309 */       if (localSave.length() == 0L) {
/* 310 */         localCompound = new ady();
/*     */       } else {
/*     */         
/* 313 */         FileInputStream fin = new FileInputStream(localSave);
/* 314 */         DataInputStream din = new DataInputStream(fin);
/*     */         
/* 316 */         localCompound = (ady)gh.b(din);
/*     */         
/* 318 */         din.close();
/* 319 */         fin.close();
/*     */       }
/*     */     
/* 322 */     } catch (Exception e) {
/*     */       
/* 324 */       NEIUtils.reportException(e);
/*     */     } 
/*     */     
/* 327 */     worldConfig.setComment("World based configuration of NEI.:Most of these options can be changed ingame.:Deleting any element will restore it to it's default value");
/*     */     
/* 329 */     worldConfig.getTag("options").useBraces();
/* 330 */     worldConfig.getTag("options.searchinventories").getBooleanValue(false);
/* 331 */     worldConfig.removeTag("saved");
/*     */     
/* 333 */     setDefaultBoolean("magnetmode", false);
/* 334 */     setDefaultBoolean("creativeinv", false);
/*     */     
/* 336 */     for (String s : AllowedPropertyMap.nameSet)
/*     */     {
/* 338 */       setDefaultBoolean("disabled-" + s, false);
/*     */     }
/*     */     
/* 341 */     if (!localCompound.c("search")) {
/* 342 */       localCompound.a("search", "");
/*     */     }
/* 344 */     if (!localCompound.c("quantity")) {
/* 345 */       localCompound.a("quantity", 0);
/*     */     }
/* 347 */     creativeInv = new aan[54];
/* 348 */     no itemList = localCompound.n("creativeitems");
/* 349 */     if (itemList != null)
/*     */     {
/* 351 */       for (int tagPos = 0; tagPos < itemList.d(); tagPos++) {
/*     */         
/* 353 */         ady stacksave = (ady)itemList.a(tagPos);
/*     */         
/* 355 */         creativeInv[stacksave.d("Slot") & 0xFF] = aan.a(stacksave);
/*     */       } 
/*     */     }
/*     */     
/* 359 */     saveLocalConfig();
/*     */     
/* 361 */     LayoutManager.searchField.setText(getSearchExpression());
/* 362 */     LayoutManager.quantity.setText(Integer.toString(getItemQuantity()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getItemQuantity() {
/* 367 */     return localCompound.f("quantity");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setDefaultBoolean(String setting, boolean value) {
/* 372 */     if (!localCompound.c(setting)) {
/* 373 */       localCompound.a(setting, value);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean isWorldSpecific(String setting) {
/* 378 */     return (worldConfig != null && worldConfig.containsTag(setting));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copyWorldSetting(String setting) {
/* 383 */     if (worldConfig != null) {
/* 384 */       worldConfig.getTag(setting).setValue(globalConfig.getTag(setting).getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void removeWorldSetting(String setting) {
/* 389 */     if (worldConfig != null) {
/* 390 */       worldConfig.removeTag(setting);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean isMultiplayer() {
/* 395 */     return (NEIUtils.getMinecraft()).f.F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isStateSaved(int i) {
/* 400 */     return statesSaved[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public static ConfigTag getSetting(String s) {
/* 405 */     if (worldConfig == null || global || !worldConfig.containsTag(s)) {
/* 406 */       return globalConfig.getTag(s);
/*     */     }
/* 408 */     return worldConfig.getTag(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean getBooleanSetting(String s) {
/* 413 */     return getSetting(s).getBooleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEnabled() {
/* 418 */     return isMultiplayer() ? getBooleanSetting("options.enablemp") : getBooleanSetting("options.enable");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setEnabled(boolean flag) {
/* 423 */     getSetting(isMultiplayer() ? "options.enablemp" : "options.enable").setBooleanValue(flag);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getKeyBinding(String string) {
/* 428 */     return getSetting("KeyBinding." + string).getIntValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setKeyBinding(String string, int key) {
/* 433 */     getSetting("KeyBinding." + string).setIntValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDefaultKeyBinding(String string, int key) {
/* 438 */     globalConfig.getTag("KeyBinding." + string).getIntValue(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getCheatMode() {
/* 443 */     return getIntSetting("options.cheatmode");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void cycleCheatMode() {
/* 448 */     cycleSetting("options.cheatmode", 3);
/* 449 */     checkCheatMode();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void checkCheatMode() {
/* 454 */     if (getLockedMode() != -1) {
/* 455 */       setIntSetting("options.cheatmode", getLockedMode());
/*     */     }
/*     */   }
/*     */   
/*     */   public static int getLockedMode() {
/* 460 */     return getIntSetting("options.lockmode");
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getLayoutStyle() {
/* 465 */     return getIntSetting("options.layout style");
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void cycleLayoutStyle() {
/* 470 */     LinkedList<Integer> list = new LinkedList();
/* 471 */     for (Map.Entry entry : LayoutManager.layoutStyles.entrySet())
/*     */     {
/* 473 */       list.add((Integer)entry.getKey());
/*     */     }
/* 475 */     Collections.sort(list);
/*     */     
/* 477 */     int currentLayout = getLayoutStyle();
/* 478 */     int nextLayout = currentLayout;
/*     */     
/* 480 */     if (nextLayout == ((Integer)list.getLast()).intValue())
/* 481 */       nextLayout = -1; 
/* 482 */     for (Integer i : list) {
/*     */       
/* 484 */       if (i.intValue() > nextLayout) {
/*     */         
/* 486 */         nextLayout = i.intValue();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 491 */     setIntSetting("options.layout style", nextLayout);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getStringSetting(String s) {
/* 496 */     return getSetting(s).getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isHidden() {
/* 501 */     return getBooleanSetting("options.hidden");
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean showIDs() {
/* 506 */     int i = getIntSetting("options.show ids");
/* 507 */     return !(i != 2 && (i != 1 || !isEnabled() || isHidden()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getIDVisibility() {
/* 512 */     return getIntSetting("options.show ids");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void cycleIDVisibility() {
/* 517 */     cycleSetting("options.show ids", 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void toggleBooleanSetting(String setting) {
/* 522 */     ConfigTag tag = getSetting(setting);
/* 523 */     tag.setBooleanValue(!tag.getBooleanValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void cycleSetting(String setting, int max) {
/* 528 */     ConfigTag tag = getSetting(setting);
/* 529 */     tag.setIntValue((tag.getIntValue() + 1) % max);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getIntSetting(String setting) {
/* 534 */     return getSetting(setting).getIntValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setIntSetting(String setting, int val) {
/* 539 */     getSetting(setting).setIntValue(val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getSearchExpression() {
/* 544 */     return localCompound.j("search");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSearchExpression(String expression) {
/* 549 */     localCompound.a("search", expression);
/* 550 */     saveLocalConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean getMagnetMode() {
/* 555 */     return isMultiplayer() ? SMPMagnetMode : localCompound.o("magnetmode");
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean invCreativeMode() {
/* 560 */     return isMultiplayer() ? SMPCreativeInv : localCompound.o("creativeinv");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setInvCreative(boolean b) {
/* 565 */     if (isMultiplayer()) {
/* 566 */       SMPCreativeInv = b;
/*     */     } else {
/*     */       
/* 569 */       localCompound.a("creativeinv", b);
/* 570 */       saveLocalConfig();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setMagnetMode(boolean b) {
/* 576 */     if (isMultiplayer()) {
/* 577 */       SMPMagnetMode = b;
/*     */     } else {
/*     */       
/* 580 */       localCompound.a("magnetmode", b);
/* 581 */       saveLocalConfig();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean areDamageVariantsShown() {
/* 587 */     if (isMultiplayer()) {
/*     */       
/* 589 */       String s = getSetting("command.give").getValue();
/* 590 */       return s.contains("{3}");
/*     */     } 
/*     */     
/* 593 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearState(int state) {
/* 599 */     for (int i = 0; i < (states[state]).length; i++)
/*     */     {
/* 601 */       states[state][i] = null;
/*     */     }
/* 603 */     statesSaved[state] = false;
/* 604 */     saveCompound.a("save" + state, (gh)new no());
/* 605 */     saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadState(int state) {
/* 610 */     if (!statesSaved[state]) {
/*     */       return;
/*     */     }
/*     */     
/* 614 */     aak inv = (NEIUtils.getMinecraft()).h.ap;
/* 615 */     if (isMultiplayer()) {
/*     */       
/* 617 */       NEIPacketHandler.sendStateLoad(states[state]);
/*     */       return;
/*     */     } 
/* 620 */     for (int i = 0; i < (states[state]).length; i++) {
/*     */       
/* 622 */       aan itemstack = NEIUtils.copyStack(states[state][i]);
/* 623 */       if (itemstack != null && itemstack.a() == null)
/*     */       {
/* 625 */         itemstack = null;
/*     */       }
/*     */       
/* 628 */       inv.a(i, itemstack);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void saveState(int state) {
/* 634 */     no statesave = saveCompound.n("save" + state);
/* 635 */     aak inv = (NEIUtils.getMinecraft()).h.ap;
/* 636 */     for (int i = 0; i < (states[state]).length; i++) {
/*     */       
/* 638 */       states[state][i] = NEIUtils.copyStack(inv.k_(i));
/* 639 */       if (states[state][i] != null) {
/*     */         
/* 641 */         ady stacksave = new ady();
/* 642 */         stacksave.a("Slot", (byte)i);
/* 643 */         states[state][i].b(stacksave);
/* 644 */         statesave.a((gh)stacksave);
/*     */       } 
/*     */     } 
/* 647 */     saveCompound.a("save" + state, (gh)statesave);
/*     */     
/* 649 */     statesSaved[state] = true;
/* 650 */     saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadStates() {
/* 655 */     boolean upgradedStateSaves = saveCompound.o("saveState2");
/* 656 */     if (!upgradedStateSaves) {
/*     */       
/* 658 */       saveCompound.a("saveState2", true);
/* 659 */       for (int i = 0; i < 7; i++)
/*     */       {
/* 661 */         clearState(i);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 666 */     for (int state = 0; state < 7; state++) {
/*     */       
/* 668 */       no statesave = saveCompound.n("save" + state);
/* 669 */       for (int tagPos = 0; tagPos < statesave.d(); tagPos++) {
/*     */         
/* 671 */         ady stacksave = (ady)statesave.a(tagPos);
/* 672 */         int i = stacksave.d("Slot") & 0xFF;
/* 673 */         aan stack = aan.a(stacksave);
/*     */         
/* 675 */         states[state][i] = stack;
/*     */       } 
/* 677 */       if (statesave.d() > 0)
/*     */       {
/* 679 */         statesSaved[state] = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadConfig() {
/* 686 */     if (configLoaded) {
/*     */       return;
/*     */     }
/*     */     
/* 690 */     loadSavedConfig();
/* 691 */     vishash = new ItemVisibilityHash();
/* 692 */     ItemInfo.load();
/*     */     
/* 694 */     configLoaded = true;
/* 695 */     ArrayList configclasses = CommonUtils.findClasses(new IStringMatcher()
/*     */         {
/*     */           public boolean matches(String test)
/*     */           {
/* 699 */             return (test.startsWith("NEI") && test.endsWith("Config.class"));
/*     */           }
/* 701 */         },  new Class[] { IConfigureNEI.class });
/*     */     
/* 703 */     for (Class<IConfigureNEI> class1 : (Iterable<Class<IConfigureNEI>>)configclasses) {
/*     */ 
/*     */       
/*     */       try {
/* 707 */         IConfigureNEI config = class1.newInstance();
/* 708 */         config.loadConfig();
/* 709 */         System.out.println("Loaded " + class1.getName());
/*     */       }
/* 711 */       catch (Exception e) {
/*     */         
/* 713 */         System.out.println("Failed to Load " + class1.getName());
/* 714 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveConfig() {
/*     */     try {
/* 723 */       if (!saveFile.exists())
/*     */       {
/* 725 */         saveFile.createNewFile();
/*     */       }
/* 727 */       FileOutputStream fout = new FileOutputStream(saveFile);
/* 728 */       DataOutputStream dout = new DataOutputStream(fout);
/* 729 */       gh.a((gh)saveCompound, dout);
/* 730 */       dout.close();
/* 731 */       fout.close();
/*     */     }
/* 733 */     catch (Exception e) {
/*     */       
/* 735 */       NEIUtils.reportException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void saveCreativeInv() {
/* 741 */     if (CoreUtils.isClient()) {
/*     */       return;
/*     */     }
/* 744 */     no invsave = new no();
/* 745 */     for (int i = 0; i < creativeInv.length; i++) {
/*     */       
/* 747 */       if (creativeInv[i] != null) {
/*     */         
/* 749 */         ady stacksave = new ady();
/* 750 */         stacksave.a("Slot", (byte)i);
/* 751 */         creativeInv[i].b(stacksave);
/* 752 */         invsave.a((gh)stacksave);
/*     */       } 
/*     */     } 
/* 755 */     localCompound.a("creativeitems", (gh)invsave);
/* 756 */     saveLocalConfig();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveLocalConfig() {
/*     */     try {
/* 763 */       DataOutputStream dout = new DataOutputStream(new FileOutputStream(localSave));
/* 764 */       gh.a((gh)localCompound, dout);
/* 765 */       dout.close();
/*     */     }
/* 767 */     catch (Exception e) {
/*     */       
/* 769 */       NEIUtils.reportException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void loadSavedConfig() {
/*     */     try {
/* 777 */       if (!saveFile.exists())
/*     */       {
/* 779 */         saveFile.createNewFile();
/*     */       }
/* 781 */       if (saveFile.length() == 0L) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 786 */       FileInputStream fin = new FileInputStream(saveFile);
/* 787 */       DataInputStream din = new DataInputStream(fin);
/*     */       
/* 789 */       saveCompound = (ady)gh.b(din);
/*     */       
/* 791 */       din.close();
/* 792 */       fin.close();
/*     */       
/* 794 */       loadStates();
/* 795 */       ItemVisibilityHash.loadStates();
/*     */     }
/* 797 */     catch (Exception e) {
/*     */       
/* 799 */       NEIUtils.reportException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasSMPCounterPart() {
/* 805 */     return hasSMPCounterpart;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setHasSMPCounterPart(boolean flag) {
/* 810 */     hasSMPCounterpart = flag;
/* 811 */     permissableActions.clear();
/* 812 */     bannedBlocks.clear();
/* 813 */     disabledProperties.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void resetPermissableActions() {
/* 818 */     permissableActions.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addPermissableAction(InterActionMap action) {
/* 823 */     permissableActions.add(action);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isActionPermissable(InterActionMap action) {
/* 828 */     return isActionPermissable(action.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isActionPermissable(String actionname) {
/* 833 */     if (!isEnabled() || isHidden()) {
/* 834 */       return false;
/*     */     }
/* 836 */     if (actionname.equals("nbt"))
/*     */     {
/* 838 */       return !(isMultiplayer() && !hasSMPCounterPart());
/*     */     }
/*     */     
/* 841 */     InterActionMap action = InterActionMap.getAction(actionname);
/* 842 */     if (!isActionPermissableInMode(actionname))
/* 843 */       return false; 
/* 844 */     if (isMultiplayer()) {
/*     */       
/* 846 */       if (action == InterActionMap.HEAL && 
/* 847 */         !hasSMPCounterpart) {
/* 848 */         return !getStringSetting("command.heal").equals("null");
/*     */       }
/* 850 */       if (hasSMPCounterpart)
/* 851 */         return permissableActions.contains(action); 
/* 852 */       if (!hasSMPCounterpart && !action.requiresSMPCounterpart)
/* 853 */         return true; 
/* 854 */       return false;
/*     */     } 
/* 856 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isActionPermissableInMode(String actionmode) {
/* 861 */     if (getCheatMode() == 0)
/* 862 */       return false; 
/* 863 */     if (getCheatMode() == 2) {
/* 864 */       return true;
/*     */     }
/*     */     
/* 867 */     String[] actions = getUtilityDefinition(); byte b; int i; String[] arrayOfString1;
/* 868 */     for (i = (arrayOfString1 = actions).length, b = 0; b < i; ) { String action = arrayOfString1[b];
/*     */       
/* 870 */       if (action.equalsIgnoreCase(actionmode))
/* 871 */         return true; 
/*     */       b++; }
/*     */     
/* 874 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String[] getUtilityDefinition() {
/* 879 */     return getStringSetting("options.utility actions").replace(" ", "").split(",");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setBannedBlocks(ArrayList ahash) {
/* 884 */     bannedBlocks.clear();
/* 885 */     for (ItemHash hash : ahash)
/*     */     {
/* 887 */       bannedBlocks.add(hash);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void resetDisabledProperties() {
/* 893 */     disabledProperties.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canGetItem(ItemHash item) {
/* 898 */     return isMultiplayer() ? (!bannedBlocks.contains(item)) : true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPropertyDisabled(String name) {
/* 903 */     if (isMultiplayer()) {
/* 904 */       return disabledProperties.contains(AllowedPropertyMap.nameToIDMap.get(name));
/*     */     }
/* 906 */     return localCompound.o("disabled-" + name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPropertyDisabled(int ID) {
/* 915 */     disabledProperties.add(Integer.valueOf(ID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setPropertyDisabled(String name, boolean disable) {
/* 920 */     if (isMultiplayer()) {
/*     */       
/* 922 */       if (hasSMPCounterPart()) {
/* 923 */         NEIPacketHandler.sendSetPropertyDisabled(name, disable);
/*     */       }
/*     */     } else {
/*     */       
/* 927 */       localCompound.a("disabled-" + name, disable);
/* 928 */       saveLocalConfig();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setItemQuantity(int i) {
/* 934 */     localCompound.a("quantity", i);
/* 935 */     saveLocalConfig();
/*     */   }
/*     */   
/* 938 */   private static aan[][] states = new aan[7][40];
/* 939 */   private static boolean[] statesSaved = new boolean[7];
/*     */   
/*     */   public static ItemVisibilityHash vishash;
/*     */   
/*     */   private static boolean configLoaded;
/*     */   private static boolean SMPMagnetMode;
/*     */   private static boolean SMPCreativeInv;
/*     */   private static boolean hasSMPCounterpart;
/* 947 */   private static HashSet permissableActions = new HashSet();
/* 948 */   private static HashSet bannedBlocks = new HashSet();
/* 949 */   private static HashSet disabledProperties = new HashSet();
/*     */   
/* 951 */   public static ady saveCompound = new ady();
/* 952 */   public static File saveFile = new File(Minecraft.b(), "saves/NEI.dat");
/* 953 */   public static ConfigFile globalConfig = new ConfigFile(new File(Minecraft.b(), "config/NEI.cfg"));
/*     */   
/*     */   public static ady localCompound;
/*     */   
/*     */   public static File localSave;
/*     */   
/*     */   public static ConfigFile worldConfig;
/*     */   public static aan[] creativeInv;
/*     */   public static boolean global = false;
/*     */   
/*     */   static {
/* 964 */     setDefaults();
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */