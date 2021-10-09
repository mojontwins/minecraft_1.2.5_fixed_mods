/*     */ package codechicken.nei;
/*     */ 
/*     */ import aak;
/*     */ import aan;
/*     */ import ady;
/*     */ import codechicken.core.CoreUtils;
/*     */ import dd;
/*     */ import gb;
/*     */ import gh;
/*     */ import java.awt.Point;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import yu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NEIController
/*     */ {
/*     */   public NEIController(gb gui) {
/*  22 */     window = gui;
/*  23 */     NEIUtils.loadItems();
/*  24 */     LayoutManager.reloadWidgets(new GuiManager(window));
/*  25 */     fastTransferManager = new FastTransferManger(window.d);
/*  26 */     overlayRenderer = null;
/*  27 */     deleteMode = false;
/*     */     
/*  29 */     tooltipHandlers = new LinkedList();
/*  30 */     for (IHandleTooltip tooltiphandler : ItemInfo.tooltipHandlers) {
/*     */       
/*  32 */       if (tooltiphandler.canHandle(gui.getClass()))
/*  33 */         tooltipHandlers.add(tooltiphandler); 
/*     */     } 
/*  35 */     gui.addTooltipHandlers(tooltipHandlers);
/*     */     
/*  37 */     inputHandlers = new LinkedList();
/*  38 */     for (IHandleInput inputHandler : ItemInfo.inputHandlers) {
/*     */       
/*  40 */       if (inputHandler.canHandle(gui.getClass())) {
/*  41 */         inputHandlers.add(inputHandler);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void replacementClickHandler(int mousex, int mousey, int button, boolean incontainer, yu slot, Minecraft minecraft, dd container) {
/*  47 */     aan firstheld = NEIUtils.getHeldItem();
/*  48 */     if (LayoutManager.onClick(mousex, mousey, button)) {
/*     */       return;
/*     */     }
/*     */     
/*  52 */     int slotindex = -1;
/*  53 */     if (slot != null) {
/*     */       
/*  55 */       slotindex = slot.c;
/*     */     }
/*  57 */     else if (!incontainer) {
/*     */       
/*  59 */       slotindex = -999;
/*     */     } 
/*  61 */     if (deleteMode && slotindex >= 0 && slot != null) {
/*     */       
/*  63 */       if (NEIUtils.shiftKey() && button == 0) {
/*     */         
/*  65 */         aan itemstack1 = slot.b();
/*  66 */         if (itemstack1 != null)
/*     */         {
/*  68 */           NEIUtils.deleteItemsOfType(itemstack1, window);
/*     */         }
/*  70 */       } else if (button == 1) {
/*     */         
/*  72 */         NEIUtils.decreaseSlotStack(slot.c);
/*     */       }
/*     */       else {
/*     */         
/*  76 */         NEIUtils.deleteSlotStack(slot.c);
/*     */       }
/*     */     
/*  79 */     } else if (!NEICompatibility.callConvenientInventoryHandler(slotindex, button, (incontainer && NEIUtils.shiftKey()), minecraft, container)) {
/*     */       
/*  81 */       if (button == 1 && slot instanceof amn) {
/*     */         
/*  83 */         for (int i1 = 0; i1 < 64; i1++)
/*     */         {
/*  85 */           window.clickSlot(slot, slotindex, button, NEIUtils.shiftKey());
/*     */         
/*     */         }
/*     */       }
/*  89 */       else if (slotindex >= 0 && NEIUtils.shiftKey() && NEIUtils.getHeldItem() != null && !slot.c()) {
/*     */         
/*  91 */         aan held = NEIUtils.getHeldItem();
/*  92 */         window.clickSlot(slot, slotindex, button, false);
/*  93 */         if (slot.a(held))
/*     */         {
/*  95 */           fastTransferManager.performMassTransfer(window, pickedUpFromSlot, slotindex, held);
/*     */         }
/*     */       }
/*  98 */       else if (NEIUtils.controlKey() && 
/*  99 */         slot != null && slot.b() != null && 
/* 100 */         NEIConfig.isActionPermissable("item") && 
/* 101 */         slot.a(slot.b())) {
/*     */         
/* 103 */         NEIUtils.cheatItem(slot.b(), button, 1);
/*     */       }
/* 105 */       else if (slotindex == -999 && NEIUtils.shiftKey() && button == 0) {
/*     */         
/* 107 */         fastTransferManager.throwAll(window, pickedUpFromSlot);
/*     */       }
/* 109 */       else if (NEIUtils.safeKeyDown((NEIUtils.getMinecraft()).A.t.d) && slotindex >= 0) {
/*     */         
/* 111 */         if (button == 0 && NEIUtils.shiftKey())
/*     */         {
/* 113 */           fastTransferManager.clickSlot(window, slotindex);
/* 114 */           fastTransferManager.throwAll(window, slotindex);
/* 115 */           fastTransferManager.clickSlot(window, slotindex);
/*     */         }
/*     */         else
/*     */         {
/* 119 */           fastTransferManager.clickSlot(window, slotindex);
/* 120 */           fastTransferManager.clickSlot(window, -999, button);
/* 121 */           fastTransferManager.clickSlot(window, slotindex);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 126 */         window.clickSlot(slot, slotindex, button, NEIUtils.shiftKey());
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     aan nowHeld = NEIUtils.getHeldItem();
/*     */     
/* 132 */     if (firstheld != nowHeld) {
/* 133 */       pickedUpFromSlot = slotindex;
/*     */     }
/* 135 */     if (NEIConfig.isActionPermissable(InterActionMap.ITEM) && (
/* 136 */       !NEIConfig.isMultiplayer() || NEIConfig.hasSMPCounterPart())) {
/*     */       
/* 138 */       if (heldStackInfinite != null && slot != null && slot.b == (NEIUtils.getMinecraft()).h.ap) {
/*     */         
/* 140 */         aan stack = slot.b();
/* 141 */         if (stack != null)
/*     */         {
/* 143 */           heldStackInfinite.onPlaceInfinite(stack);
/*     */         }
/* 145 */         NEIUtils.setSlotContents(slotindex, stack, true);
/*     */       } 
/*     */       
/* 148 */       if (firstheld != nowHeld) {
/* 149 */         heldStackInfinite = null;
/*     */       }
/* 151 */       if (firstheld != nowHeld && nowHeld != null)
/*     */       {
/* 153 */         for (IInfiniteItemHandler handler : ItemInfo.infiniteHandlers) {
/*     */           
/* 155 */           if (handler.canHandleItem(nowHeld) && handler.isItemInfinite(nowHeld)) {
/*     */             
/* 157 */             handler.onPickup(nowHeld);
/* 158 */             NEIUtils.setSlotContents(-999, nowHeld, true);
/* 159 */             heldStackInfinite = handler;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onButtonPress(String ident, boolean rightclick) {
/* 169 */     if (ident.equals("delete")) {
/*     */       
/* 171 */       if ((LayoutManager.delete.state & 0x3) == 2) {
/*     */         return;
/*     */       }
/* 174 */       aan held = NEIUtils.getHeldItem();
/* 175 */       if (held != null) {
/*     */         
/* 177 */         if (NEIUtils.shiftKey()) {
/*     */           
/* 179 */           NEIUtils.deleteHeldItem();
/* 180 */           NEIUtils.deleteItemsOfType(held, window);
/* 181 */         } else if (rightclick) {
/*     */           
/* 183 */           NEIUtils.decreaseSlotStack(-999);
/*     */         } else {
/*     */           
/* 186 */           NEIUtils.deleteHeldItem();
/*     */         }
/*     */       
/* 189 */       } else if (NEIUtils.shiftKey()) {
/*     */         
/* 191 */         NEIUtils.deleteEverything();
/*     */       } else {
/*     */         
/* 194 */         deleteMode = !deleteMode;
/*     */       }
/*     */     
/* 197 */     } else if (!handleDisabledButtonPress(ident, rightclick)) {
/*     */ 
/*     */       
/* 200 */       if (rightclick) {
/*     */         return;
/*     */       }
/*     */       
/* 204 */       if (ident.equals("dawn")) {
/*     */         
/* 206 */         NEIUtils.setHourForward(0);
/*     */       }
/* 208 */       else if (ident.equals("noon")) {
/*     */         
/* 210 */         NEIUtils.setHourForward(6);
/*     */       }
/* 212 */       else if (ident.equals("dusk")) {
/*     */         
/* 214 */         NEIUtils.setHourForward(12);
/*     */       }
/* 216 */       else if (ident.equals("midnight")) {
/*     */         
/* 218 */         NEIUtils.setHourForward(18);
/*     */       }
/* 220 */       else if (ident.equals("rain")) {
/*     */         
/* 222 */         NEIUtils.toggleRaining();
/*     */       }
/* 224 */       else if (ident.startsWith("state")) {
/*     */         
/* 226 */         int state = Integer.parseInt(ident.substring(ident.length() - 1));
/* 227 */         if (NEIConfig.isStateSaved(state)) {
/*     */           
/* 229 */           NEIConfig.loadState(state);
/*     */         } else {
/*     */           
/* 232 */           NEIConfig.saveState(state);
/*     */         }
/*     */       
/* 235 */       } else if (ident.startsWith("vishash")) {
/*     */         
/* 237 */         int state = Integer.parseInt(ident.substring(ident.length() - 1));
/* 238 */         if (ItemVisibilityHash.isStateSaved(state)) {
/*     */           
/* 240 */           NEIConfig.vishash.loadState(state);
/*     */         } else {
/*     */           
/* 243 */           NEIConfig.vishash.saveState(state);
/*     */         }
/*     */       
/* 246 */       } else if (ident.startsWith("visdelete")) {
/*     */         
/* 248 */         NEIConfig.vishash.clearState(Integer.parseInt(ident.substring(ident.length() - 1)));
/*     */       }
/* 250 */       else if (ident.startsWith("delete")) {
/*     */         
/* 252 */         NEIConfig.clearState(Integer.parseInt(ident.substring(ident.length() - 1)));
/*     */       }
/* 254 */       else if (ident.equals("next")) {
/*     */         
/* 256 */         LayoutManager.itemPanel.scroll(1);
/*     */       }
/* 258 */       else if (ident.equals("prev")) {
/*     */         
/* 260 */         LayoutManager.itemPanel.scroll(-1);
/*     */       }
/* 262 */       else if (ident.equals("options")) {
/*     */         
/* 264 */         (NEIUtils.getMinecraft()).s = null;
/* 265 */         NEIUtils.getMinecraft().a(new GuiNEISettings(window));
/*     */       }
/* 267 */       else if (ident.equals("creative")) {
/*     */         
/* 269 */         NEIUtils.cycleCreativeMode();
/*     */       }
/* 271 */       else if (ident.equals("heal")) {
/*     */         
/* 273 */         NEIUtils.healPlayer();
/*     */       }
/* 275 */       else if (ident.equals("magnet")) {
/*     */         
/* 277 */         NEIUtils.toggleMagnetMode();
/*     */       }
/* 279 */       else if (ident.equals("more") || ident.equals("less")) {
/*     */         
/* 281 */         int modifier = NEIUtils.controlKey() ? 64 : (NEIUtils.shiftKey() ? 10 : 1);
/* 282 */         if (ident.equals("less")) {
/* 283 */           modifier = -modifier;
/*     */         }
/* 285 */         int quantity = NEIConfig.getItemQuantity() + modifier;
/* 286 */         if (quantity < 0) {
/* 287 */           quantity = 0;
/*     */         }
/* 289 */         NEIUtils.setItemQuantity(quantity);
/*     */       } 
/* 291 */     }  (window.mc()).C.a("random.click", 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean handleDisabledButtonPress(String ident, boolean rightclick) {
/* 296 */     if (!AllowedPropertyMap.nameSet.contains(ident))
/* 297 */       return false; 
/* 298 */     if (rightclick && !NEIConfig.isPropertyDisabled(ident))
/* 299 */       return setPropertyDisabled(ident, true); 
/* 300 */     if (!rightclick && NEIConfig.isPropertyDisabled(ident))
/* 301 */       return setPropertyDisabled(ident, false); 
/* 302 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean setPropertyDisabled(String ident, boolean disable) {
/* 307 */     if (disable && ((Integer)AllowedPropertyMap.nameToIDMap.get(ident)).intValue() < 4) {
/*     */       
/* 309 */       int count = 0;
/* 310 */       for (int i = 0; i < 4; i++) {
/*     */         
/* 312 */         if (NEIConfig.isPropertyDisabled((String)AllowedPropertyMap.idToNameMap.get(Integer.valueOf(i))))
/* 313 */           count++; 
/*     */       } 
/* 315 */       if (count == 3)
/* 316 */         return false; 
/*     */     } 
/* 318 */     NEIConfig.setPropertyDisabled(ident, disable);
/* 319 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onItemEvent(aan itemstack, int button) {
/* 324 */     if (window instanceof GuiRecipe || !NEIConfig.isActionPermissable(InterActionMap.ITEM)) {
/*     */       
/* 326 */       if (button == 0) {
/* 327 */         GuiCraftingRecipe.openRecipeGui("item", new Object[] { itemstack });
/* 328 */       } else if (button == 1) {
/* 329 */         GuiUsageRecipe.openRecipeGui("item", new Object[] { itemstack });
/*     */       } 
/*     */       return;
/*     */     } 
/* 333 */     if (!NEIConfig.isActionPermissable("item")) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 338 */     NEIUtils.cheatItem(itemstack, button, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onTextChange(String text, String ident) {
/* 343 */     if (ident.equals("search")) {
/*     */       
/* 345 */       if (!NEIConfig.getBooleanSetting("options.realtimesearch"))
/*     */         return; 
/* 347 */       NEIConfig.setSearchExpression(text);
/* 348 */       NEIUtils.loadItems();
/*     */     }
/* 350 */     else if (ident.equals("quantity")) {
/*     */       
/* 352 */       NEIConfig.setItemQuantity(LayoutManager.quantity.intValue());
/*     */     }
/* 354 */     else if (ident.startsWith("state")) {
/*     */       
/* 356 */       int state = Integer.parseInt(ident.substring(ident.length() - 1));
/*     */       
/* 358 */       ady statelist = NEIConfig.saveCompound.m("statename");
/* 359 */       NEIConfig.saveCompound.a("statename", (gh)statelist);
/*     */       
/* 361 */       statelist.a(state, text.substring(5));
/* 362 */       NEIConfig.saveConfig();
/*     */     }
/* 364 */     else if (ident.startsWith("vishash")) {
/*     */       
/* 366 */       int state = Integer.parseInt(ident.substring(ident.length() - 1));
/*     */       
/* 368 */       ady hashSave = NEIConfig.saveCompound.m("vis");
/* 369 */       NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */       
/* 371 */       ady statelist = hashSave.m("statename");
/* 372 */       hashSave.a("statename", (gh)statelist);
/*     */       
/* 374 */       statelist.a(state, text.substring(5));
/* 375 */       NEIConfig.saveConfig();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onTextSet(String text, String ident) {
/* 381 */     if (ident.equals("search"))
/*     */     {
/* 383 */       if (!NEIConfig.getBooleanSetting("options.realtimesearch")) {
/*     */         
/* 385 */         NEIConfig.setSearchExpression(text);
/* 386 */         NEIUtils.loadItems();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getStateTip(String name, Button button) {
/* 393 */     if ((button.state & 0x3) == 2) {
/* 394 */       return "Enable " + name;
/*     */     }
/* 396 */     return "Turn " + name + (((button.state & 0x3) == 1) ? " OFF" : " ON");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTimeTip(String zone, String next, Button button) {
/* 401 */     return ((button.state & 0x3) == 2) ? ("Enable " + zone + "-" + next) : ("Set time to " + zone);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getButtonTip(Button button) {
/* 406 */     if (button.identifier.equals("rain"))
/*     */     {
/* 408 */       return getStateTip("Rain", button);
/*     */     }
/* 410 */     if (button.identifier.equals("creative"))
/*     */     {
/* 412 */       return getStateTip("Creative Mode", button);
/*     */     }
/* 414 */     if (button.identifier.equals("heal"))
/*     */     {
/* 416 */       return "Heal the player";
/*     */     }
/* 418 */     if (button.identifier.equals("magnet"))
/*     */     {
/* 420 */       return getStateTip("Magnet Mode", button);
/*     */     }
/* 422 */     if (button.identifier.equals("dawn"))
/*     */     {
/* 424 */       return getTimeTip("dawn", "noon", button);
/*     */     }
/* 426 */     if (button.identifier.equals("noon"))
/*     */     {
/* 428 */       return getTimeTip("noon", "dusk", button);
/*     */     }
/* 430 */     if (button.identifier.equals("dusk"))
/*     */     {
/* 432 */       return getTimeTip("dusk", "midnight", button);
/*     */     }
/* 434 */     if (button.identifier.equals("midnight"))
/*     */     {
/* 436 */       return getTimeTip("midnight", "dawn", button);
/*     */     }
/* 438 */     if (button.identifier.equals("delete")) {
/*     */       
/* 440 */       if ((button.state & 0x3) == 2)
/*     */       {
/* 442 */         return null;
/*     */       }
/*     */       
/* 445 */       aan itemstack = NEIUtils.getHeldItem();
/* 446 */       if (itemstack == null) {
/*     */         
/* 448 */         if (NEIUtils.shiftKey())
/*     */         {
/* 450 */           return "DELETE ALL ITEMS from current inventory screen";
/*     */         }
/*     */         
/* 453 */         return getStateTip("Delete Mode", button);
/*     */       } 
/*     */       
/* 456 */       if (NEIUtils.shiftKey())
/*     */       {
/* 458 */         return "DELETE ALL " + NEIUtils.itemDisplayNameShort(itemstack);
/*     */       }
/*     */       
/* 461 */       return "DELETE " + NEIUtils.itemDisplayNameShort(itemstack);
/*     */     } 
/*     */     
/* 464 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawOverlay() {
/* 469 */     if (overlayRenderer != null)
/*     */     {
/* 471 */       overlayRenderer.renderOverlay(LayoutManager.gui);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateUnlimitedItems(aak inventory) {
/* 477 */     if (!NEIConfig.isActionPermissable(InterActionMap.ITEM) || (NEIConfig.isMultiplayer() && !NEIConfig.hasSMPCounterPart())) {
/*     */       return;
/*     */     }
/*     */     
/* 481 */     LinkedList<aan> beforeStacks = new LinkedList(); int i;
/* 482 */     for (i = 0; i < inventory.a(); i++)
/*     */     {
/* 484 */       beforeStacks.add(NEIUtils.copyStack(inventory.k_(i)));
/*     */     }
/*     */     
/* 487 */     for (i = 0; i < inventory.a(); i++) {
/*     */       
/* 489 */       aan stack = inventory.k_(i);
/* 490 */       if (stack != null)
/*     */       {
/*     */         
/* 493 */         for (IInfiniteItemHandler handler : ItemInfo.infiniteHandlers) {
/*     */           
/* 495 */           if (handler.canHandleItem(stack) && handler.isItemInfinite(stack))
/*     */           {
/* 497 */             handler.replenishInfiniteStack(inventory, i);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 502 */     for (i = 0; i < inventory.a(); i++) {
/*     */       
/* 504 */       aan newstack = inventory.k_(i);
/*     */       
/* 506 */       if (!NEIUtils.areStacksIdentical(beforeStacks.get(i), newstack)) {
/*     */         
/* 508 */         inventory.a(i, beforeStacks.get(i));
/* 509 */         NEIUtils.setSlotContents(i, newstack, false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onMouseWheel(int i) {
/* 516 */     Point mousePos = NEIUtils.getMousePosition();
/* 517 */     yu mouseover = window.a(mousePos.x, mousePos.y);
/* 518 */     if (mouseover != null && mouseover.c()) {
/*     */       
/* 520 */       while (i < 0) {
/*     */         
/* 522 */         fastTransferManager.transferItem(window, mouseover.c);
/* 523 */         i++;
/*     */       } 
/* 525 */       while (i > 0)
/*     */       {
/* 527 */         fastTransferManager.retrieveItem(window, mouseover.c);
/* 528 */         i--;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 533 */       LayoutManager.onMouseWheel(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void processCreativeCycling(aak inventory) {
/* 539 */     if (NEIConfig.invCreativeMode() && NEIUtils.controlKey())
/*     */     {
/* 541 */       if (selectedItem != inventory.c)
/*     */       {
/* 543 */         if (inventory.c == selectedItem + 1 || (inventory.c == 0 && selectedItem == 8)) {
/*     */           
/* 545 */           cycleCreativeInv(inventory, 1);
/* 546 */           inventory.c = selectedItem;
/*     */         }
/* 548 */         else if (inventory.c == selectedItem - 1 || (inventory.c == 8 && selectedItem == 0)) {
/*     */           
/* 550 */           cycleCreativeInv(inventory, -1);
/* 551 */           inventory.c = selectedItem;
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/* 556 */     selectedItem = inventory.c;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void cycleCreativeInv(aak inventory, int steps) {
/* 561 */     if (CoreUtils.isClient()) {
/*     */       
/* 563 */       NEIPacketHandler.sendCreativeScroll(steps);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 568 */     aan[][] slots = new aan[10][9];
/*     */ 
/*     */     
/* 571 */     for (int hotbar = 0; hotbar < 9; hotbar++)
/*     */     {
/* 573 */       slots[9][hotbar] = inventory.a[hotbar];
/*     */     }
/*     */     int row;
/* 576 */     for (row = 0; row < 3; row++) {
/*     */       
/* 578 */       for (int col = 0; col < 9; col++)
/*     */       {
/* 580 */         slots[row + 6][col] = inventory.a[(row + 1) * 9 + col];
/*     */       }
/*     */     } 
/*     */     
/* 584 */     for (row = 0; row < 6; row++) {
/*     */       
/* 586 */       for (int col = 0; col < 9; col++)
/*     */       {
/* 588 */         slots[row][col] = NEIConfig.creativeInv[row * 9 + col];
/*     */       }
/*     */     } 
/*     */     
/* 592 */     aan[][] newslots = new aan[10][];
/*     */ 
/*     */     
/* 595 */     for (int k = 0; k < 10; k++)
/*     */     {
/* 597 */       newslots[(k + steps + 10) % 10] = slots[k];
/*     */     }
/*     */     
/* 600 */     for (int j = 0; j < 9; j++)
/*     */     {
/* 602 */       inventory.a[j] = newslots[9][j];
/*     */     }
/*     */     int i;
/* 605 */     for (i = 0; i < 3; i++) {
/*     */       
/* 607 */       for (int col = 0; col < 9; col++)
/*     */       {
/* 609 */         inventory.a[(i + 1) * 9 + col] = newslots[i + 6][col];
/*     */       }
/*     */     } 
/*     */     
/* 613 */     for (i = 0; i < 6; i++) {
/*     */       
/* 615 */       for (int col = 0; col < 9; col++)
/*     */       {
/* 617 */         NEIConfig.creativeInv[i * 9 + col] = newslots[i][col];
/*     */       }
/*     */     } 
/*     */     
/* 621 */     NEIConfig.saveCreativeInv();
/*     */   }
/*     */   
/* 624 */   public static ArrayList items = new ArrayList();
/* 625 */   public static ArrayList visibleitems = new ArrayList();
/*     */   public static gb window;
/*     */   public static FastTransferManger fastTransferManager;
/*     */   public static boolean deleteMode;
/*     */   private static int pickedUpFromSlot;
/*     */   private static IInfiniteItemHandler heldStackInfinite;
/*     */   public static IRecipeOverlayRenderer overlayRenderer;
/*     */   public static LinkedList inputHandlers;
/*     */   public static LinkedList tooltipHandlers;
/*     */   private static int selectedItem;
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */