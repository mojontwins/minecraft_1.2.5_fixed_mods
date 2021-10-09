/*     */ package codechicken.nei;
/*     */ import aan;
/*     */ import ady;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ 
/*     */ public class LayoutManager {
/*     */   public static int mousex;
/*     */   public static int mousey;
/*     */   private static Widget inputFocused;
/*     */   static TreeSet drawWidgets;
/*     */   static TreeSet controlWidgets;
/*     */   public static GuiManager gui;
/*     */   
/*     */   public static boolean onClick(int mx, int my, int button) {
/*     */     try {
/*  18 */       if (NEIConfig.isHidden())
/*     */       {
/*  20 */         return false;
/*     */       }
/*  22 */       if (!NEIConfig.isEnabled())
/*     */       {
/*  24 */         return (options.contains(mx, my) && options.handleClick(mx, my, button));
/*     */       }
/*  26 */       boolean clickhandled = false;
/*  27 */       for (Widget widget : controlWidgets) {
/*     */         
/*  29 */         widget.onGuiClick(mx, my);
/*  30 */         if (!clickhandled && widget.contains(mx, my) && widget.handleClick(mx, my, button))
/*     */         {
/*  32 */           clickhandled = true;
/*     */         }
/*     */       } 
/*     */       
/*  36 */       if (clickhandled) {
/*  37 */         return true;
/*     */       }
/*  39 */       for (IHandleInput inputhander : NEIController.inputHandlers) {
/*     */         
/*  41 */         if (inputhander.mouseClicked(gui.window, mx, my, button)) {
/*  42 */           return true;
/*     */         }
/*     */       } 
/*  45 */       return false;
/*     */     }
/*  47 */     catch (Exception exception) {
/*     */       
/*  49 */       NEIUtils.reportException(exception);
/*  50 */       NEIConfig.setEnabled(false);
/*  51 */       return false;
/*     */     } 
/*     */   }
/*     */   public static ItemPanel itemPanel; public static DropDownWidget dropDown; public static TextField searchField; public static Button options; public static Button prev; public static Button next; public static Label pageLabel; public static Button more; public static Button less; public static ItemQuantityField quantity; public static RenameableButton[] stateButtons; public static Button[] deleteButtons; public static Button delete;
/*     */   public static Button2ActiveState creative;
/*     */   
/*     */   public static boolean widgetContains(int mx, int my) {
/*     */     try {
/*  59 */       if (!NEIConfig.isEnabled() || NEIConfig.isHidden())
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       for (Widget widget : controlWidgets) {
/*     */         
/*  66 */         if (widget.contains(mx, my))
/*     */         {
/*  68 */           return true;
/*     */         }
/*     */       } 
/*  71 */       return false;
/*     */     }
/*  73 */     catch (Exception exception) {
/*     */       
/*  75 */       NEIUtils.reportException(exception);
/*  76 */       NEIConfig.setEnabled(false);
/*  77 */       return false;
/*     */     } 
/*     */   }
/*     */   public static Button rain; public static Button magnet; public static Button dawn; public static Button noon; public static Button dusk; public static Button midnight;
/*     */   public static Button heal;
/*     */   
/*     */   public static boolean keyPress(int keyID, char keyChar) {
/*     */     try {
/*  85 */       if (NEIConfig.isEnabled() && !NEIConfig.isHidden()) {
/*     */         
/*  87 */         if (inputFocused != null) {
/*  88 */           return inputFocused.handleKeyPress(keyID, keyChar);
/*     */         }
/*  90 */         for (Widget widget : controlWidgets) {
/*     */           
/*  92 */           if (widget.handleKeyPress(keyID, keyChar)) {
/*  93 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*  97 */       for (IHandleInput inputhander : NEIController.inputHandlers) {
/*     */         
/*  99 */         if (inputhander.keyTyped(gui.window, keyChar, keyID)) {
/* 100 */           return true;
/*     */         }
/*     */       } 
/* 103 */       if (keyID == NEIConfig.getKeyBinding("hide")) {
/*     */         
/* 105 */         NEIConfig.toggleBooleanSetting("options.hidden");
/* 106 */         return true;
/*     */       } 
/*     */       
/* 109 */       return false;
/*     */     }
/* 111 */     catch (Exception exception) {
/*     */       
/* 113 */       NEIUtils.reportException(exception);
/* 114 */       NEIConfig.setEnabled(false);
/* 115 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void mouseUp(int mx, int my, int button) {
/*     */     try {
/* 123 */       if (!NEIConfig.isEnabled() || NEIConfig.isHidden()) {
/*     */         return;
/*     */       }
/*     */       
/* 127 */       for (Widget widget : controlWidgets)
/*     */       {
/* 129 */         widget.mouseUp(mx, my, button);
/*     */       }
/*     */     }
/* 132 */     catch (Exception exception) {
/*     */       
/* 134 */       NEIUtils.reportException(exception);
/* 135 */       NEIConfig.setEnabled(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static aan getStackMouseOver(int mx, int my) {
/*     */     try {
/* 143 */       if (!NEIConfig.isEnabled() || NEIConfig.isHidden())
/*     */       {
/* 145 */         return null;
/*     */       }
/*     */       
/* 148 */       for (Widget widget : controlWidgets) {
/*     */         
/* 150 */         aan stack = widget.getStackMouseOver(mx, my);
/* 151 */         if (stack != null) {
/* 152 */           return stack;
/*     */         }
/*     */       } 
/* 155 */     } catch (Exception exception) {
/*     */       
/* 157 */       NEIUtils.reportException(exception);
/* 158 */       NEIConfig.setEnabled(false);
/*     */     } 
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draw(int mx, int my) {
/* 165 */     mousex = mx;
/* 166 */     mousey = my;
/* 167 */     layout();
/*     */     
/*     */     try {
/* 170 */       if (!NEIConfig.isHidden())
/*     */       {
/*     */         
/* 173 */         if (NEIConfig.isEnabled()) {
/*     */           
/* 175 */           drawWidgets(mousex, mousey);
/*     */         }
/*     */         else {
/*     */           
/* 179 */           options.draw(gui, mousex, mousey);
/*     */         }  } 
/* 181 */       gui.enable2DRender();
/*     */     }
/* 183 */     catch (Exception exception) {
/*     */       
/* 185 */       NEIUtils.reportException(exception);
/* 186 */       NEIConfig.setEnabled(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawWidgets(int mx, int my) {
/* 192 */     getLayoutStyle().drawBackground(gui);
/* 193 */     for (Widget widget : drawWidgets)
/*     */     {
/* 195 */       widget.draw(gui, mx, my);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void showToolTip(int mx, int my) {
/* 201 */     List tooltip = new LinkedList();
/*     */     
/* 203 */     if (!NEIConfig.isHidden() && NEIConfig.isEnabled())
/*     */     {
/* 205 */       for (Widget widget : controlWidgets)
/*     */       {
/* 207 */         tooltip = widget.handleTooltip(mx, my, tooltip);
/*     */       }
/*     */     }
/*     */     
/* 211 */     if (tooltip.isEmpty() && (NEIUtils.getMinecraft()).h.ap.k() == null) {
/*     */       
/* 213 */       aan stack = gui.window.getStackMouseOver();
/* 214 */       if (stack != null) {
/* 215 */         tooltip = NEIUtils.itemDisplayNameMultiline(stack, NEIConfig.showIDs());
/*     */       }
/*     */     } 
/* 218 */     for (IHandleTooltip handler : NEIController.tooltipHandlers)
/*     */     {
/* 220 */       tooltip = handler.handleTooltip(gui.window, tooltip);
/*     */     }
/*     */     
/* 223 */     gui.drawMultilineTip(mx, my, tooltip);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void layout() {
/* 228 */     int windowWidth = gui.window.q;
/* 229 */     int windowHeight = gui.window.r;
/* 230 */     int containerWidth = gui.window.b;
/* 231 */     int containerHeight = gui.window.c;
/* 232 */     int containerLeft = gui.window.e;
/* 233 */     int containerTop = gui.window.f;
/*     */     
/* 235 */     boolean sidesOffScreen = (containerLeft - 4 < 76);
/*     */     
/* 237 */     prev.y = 2;
/* 238 */     prev.height = 16;
/* 239 */     prev.width = containerLeft / 3;
/* 240 */     if (sidesOffScreen) {
/*     */       
/* 242 */       prev.x = -1000;
/* 243 */       next.x = -1000;
/*     */     }
/*     */     else {
/*     */       
/* 247 */       prev.x = (containerWidth + windowWidth) / 2 + 2;
/* 248 */       next.x = windowWidth - prev.width - 2;
/*     */     } 
/*     */     
/* 251 */     next.y = prev.y;
/* 252 */     next.width = prev.width;
/* 253 */     next.height = prev.height;
/* 254 */     pageLabel.x = containerLeft * 3 / 2 + containerWidth + 1;
/* 255 */     pageLabel.y = prev.y + 5;
/* 256 */     if (itemPanel.getNumPages() == 0) {
/* 257 */       pageLabel.text = "(0/0)";
/*     */     } else {
/* 259 */       pageLabel.text = "(" + (itemPanel.getPage() + 1) + "/" + itemPanel.getNumPages() + ")";
/* 260 */     }  itemPanel.y = prev.height + prev.y;
/*     */     
/* 262 */     more.x = prev.x;
/* 263 */     less.x = windowWidth - less.width - 2;
/* 264 */     less.y = windowHeight - more.height - 2;
/*     */     
/* 266 */     quantity.x = more.x + more.width + 2;
/* 267 */     quantity.y = more.y;
/* 268 */     quantity.width = less.x - quantity.x - 2;
/* 269 */     quantity.height = more.height;
/*     */     
/* 271 */     options.x = sidesOffScreen ? -1000 : (NEIConfig.isEnabled() ? 0 : 6);
/* 272 */     options.y = NEIConfig.isEnabled() ? (windowHeight - 22) : (windowHeight - 28);
/*     */     
/* 274 */     delete.state = 4;
/* 275 */     if (NEIController.deleteMode) {
/* 276 */       delete.state |= 0x1;
/* 277 */     } else if (gui.window instanceof sr) {
/* 278 */       delete.state |= 0x2;
/*     */     } 
/* 280 */     rain.state = 4;
/* 281 */     if (NEIUtils.isRaining()) {
/* 282 */       rain.state |= 0x1;
/* 283 */     } else if (NEIConfig.isPropertyDisabled("rain")) {
/* 284 */       rain.state |= 0x2;
/*     */     } 
/* 286 */     creative.state = 4;
/* 287 */     if (NEIUtils.getCreativeMode() != 0)
/* 288 */       creative.state |= 0x1; 
/* 289 */     if (NEIUtils.getCreativeMode() == 2) {
/* 290 */       creative.state |= 0x8;
/*     */     }
/* 292 */     magnet.state = 0x4 | (NEIConfig.getMagnetMode() ? 1 : 0);
/* 293 */     dawn.state = NEIConfig.isPropertyDisabled("dawn") ? 2 : 0;
/* 294 */     noon.state = NEIConfig.isPropertyDisabled("noon") ? 2 : 0;
/* 295 */     dusk.state = NEIConfig.isPropertyDisabled("dusk") ? 2 : 0;
/* 296 */     midnight.state = NEIConfig.isPropertyDisabled("midnight") ? 2 : 0;
/*     */     
/* 298 */     LayoutStyle style = getLayoutStyle();
/* 299 */     style.reset();
/*     */     
/* 301 */     if (NEIConfig.isActionPermissable(InterActionMap.DELETE))
/* 302 */       layoutButton(delete, style); 
/* 303 */     if (NEIConfig.isActionPermissable(InterActionMap.RAIN))
/* 304 */       layoutButton(rain, style); 
/* 305 */     if (NEIConfig.isActionPermissable(InterActionMap.CREATIVE))
/* 306 */       layoutButton(creative, style); 
/* 307 */     if (NEIConfig.isActionPermissable(InterActionMap.MAGNET))
/* 308 */       layoutButton(magnet, style); 
/* 309 */     if (NEIConfig.isActionPermissable(InterActionMap.TIME)) {
/*     */       
/* 311 */       layoutButton(dawn, style);
/* 312 */       layoutButton(noon, style);
/* 313 */       layoutButton(dusk, style);
/* 314 */       layoutButton(midnight, style);
/*     */     } 
/* 316 */     if (NEIConfig.isActionPermissable(InterActionMap.HEAL)) {
/* 317 */       layoutButton(heal, style);
/*     */     }
/* 319 */     if (sidesOffScreen)
/*     */     {
/* 321 */       rain.x = creative.x = heal.x = -1000;
/*     */     }
/*     */     
/* 324 */     if (sidesOffScreen) {
/*     */       
/* 326 */       itemPanel.x = -1000;
/* 327 */       itemPanel.width = 5;
/*     */     }
/*     */     else {
/*     */       
/* 331 */       itemPanel.x = (containerWidth + windowWidth) / 2 + 3;
/* 332 */       itemPanel.width = windowWidth - 3 - itemPanel.x;
/*     */     } 
/* 334 */     itemPanel.height = windowHeight - 15 - itemPanel.y;
/* 335 */     itemPanel.resize();
/*     */     
/* 337 */     searchField.y = windowHeight - searchField.height - 2;
/* 338 */     if (windowHeight - containerHeight <= 40 || sidesOffScreen) {
/*     */       
/* 340 */       dropDown.x = -1000;
/* 341 */       dropDown.setDropDown(0);
/*     */       
/* 343 */       searchField.x = -1000;
/* 344 */       searchField.setFocus(false);
/*     */     }
/*     */     else {
/*     */       
/* 348 */       dropDown.x = (NEIConfig.getLayoutStyle() == 1) ? 93 : 90;
/* 349 */       dropDown.width = prev.x - dropDown.x - 3;
/* 350 */       searchField.x = (windowWidth - searchField.width) / 2;
/*     */     } 
/*     */     
/* 353 */     int maxWidth = 0; int i;
/* 354 */     for (i = 0; i < 7; i++) {
/*     */       int j;
/* 356 */       (deleteButtons[i]).x = -1000;
/*     */       
/* 358 */       ady statelist = NEIConfig.saveCompound.m("statename");
/* 359 */       NEIConfig.saveCompound.a("statename", (gh)statelist);
/* 360 */       String name = statelist.j(i);
/* 361 */       if (statelist.b(i) == null) {
/*     */         
/* 363 */         j = i + 1;
/* 364 */         statelist.a(i, j);
/*     */       } 
/* 366 */       (stateButtons[i]).label = String.valueOf(NEIConfig.isStateSaved(i) ? "Load " : "Save ") + j;
/*     */       
/* 368 */       int width = gui.getTextWidth((stateButtons[i]).label) + 26;
/* 369 */       if (width + 22 > containerLeft)
/*     */       {
/* 371 */         width = containerLeft - 22;
/*     */       }
/* 373 */       if (width > maxWidth)
/*     */       {
/* 375 */         maxWidth = width;
/*     */       }
/*     */     } 
/*     */     
/* 379 */     for (i = 0; i < 7; i++) {
/*     */       
/* 381 */       if (sidesOffScreen) {
/*     */         
/* 383 */         (stateButtons[i]).x = -1000;
/* 384 */         (deleteButtons[i]).x = -1000;
/*     */       }
/*     */       else {
/*     */         
/* 388 */         (stateButtons[i]).x = 0;
/* 389 */         (stateButtons[i]).width = maxWidth;
/* 390 */         if (NEIConfig.isStateSaved(i)) {
/*     */           
/* 392 */           (deleteButtons[i]).x = (stateButtons[i]).width + 3;
/* 393 */           (deleteButtons[i]).y = (stateButtons[i]).y + 2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void layoutButton(Button button, LayoutStyle style) {
/* 401 */     style.position(button, gui);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void init() {
/* 406 */     itemPanel = new ItemPanel();
/* 407 */     dropDown = new DropDownWidget();
/* 408 */     searchField = new SearchField("search");
/*     */     
/* 410 */     options = new Button("Options", "options");
/* 411 */     prev = new Button("Prev", "prev");
/* 412 */     next = new Button("Next", "next");
/* 413 */     pageLabel = new Label("(0/0)", true);
/* 414 */     more = new Button("+", "more");
/* 415 */     less = new Button("-", "less");
/* 416 */     quantity = new ItemQuantityField("quantity");
/*     */     
/* 418 */     stateButtons = new RenameableButton[7];
/* 419 */     deleteButtons = new Button[7];
/*     */     
/* 421 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 423 */       stateButtons[i] = new RenameableButton("", "state" + i);
/* 424 */       deleteButtons[i] = new Button("x", "delete" + i);
/*     */     } 
/*     */     
/* 427 */     delete = new Button("delete");
/* 428 */     creative = new Button2ActiveState("creative");
/* 429 */     rain = new Button("rain");
/* 430 */     magnet = new Button("magnet");
/* 431 */     dawn = new Button("dawn");
/* 432 */     noon = new Button("noon");
/* 433 */     dusk = new Button("dusk");
/* 434 */     midnight = new Button("midnight");
/* 435 */     heal = new Button("heal");
/*     */     
/* 437 */     delete.state |= 0x4;
/* 438 */     creative.state |= 0x4;
/* 439 */     rain.state |= 0x4;
/* 440 */     magnet.state |= 0x4;
/*     */     
/* 442 */     layoutZOrders();
/* 443 */     setStaticDimensions();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setStaticDimensions() {
/* 448 */     options.width = 80;
/* 449 */     options.height = 22;
/* 450 */     dropDown.height = 20;
/* 451 */     searchField.height = 20;
/* 452 */     searchField.width = 150;
/*     */     
/* 454 */     more.width = more.height = less.width = less.height = 16;
/*     */     
/* 456 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 458 */       (stateButtons[i]).x = 0;
/* 459 */       (stateButtons[i]).y = 58 + i * 22;
/* 460 */       (stateButtons[i]).height = 20;
/* 461 */       (deleteButtons[i]).width = 16;
/* 462 */       (deleteButtons[i]).height = 16;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void layoutZOrders() {
/* 468 */     dropDown.z = -5;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void reloadWidgets(GuiManager gui1) {
/* 473 */     gui = gui1;
/* 474 */     setInputFocused(null);
/*     */     
/* 476 */     drawWidgets = new TreeSet(new WidgetZOrder(false));
/* 477 */     controlWidgets = new TreeSet(new WidgetZOrder(true));
/*     */     
/* 479 */     addWidget(itemPanel);
/* 480 */     addWidget(dropDown);
/* 481 */     addWidget(searchField);
/* 482 */     addWidget(options);
/* 483 */     addWidget(prev);
/* 484 */     addWidget(next);
/* 485 */     addWidget(pageLabel);
/* 486 */     addWidget(more);
/* 487 */     addWidget(less);
/* 488 */     addWidget(quantity);
/*     */     
/* 490 */     getLayoutStyle().init();
/* 491 */     layout();
/*     */     
/* 493 */     if (NEIConfig.isActionPermissable(InterActionMap.ITEM))
/*     */     {
/* 495 */       for (int i = 0; i < 7; i++) {
/*     */         
/* 497 */         addWidget(deleteButtons[i]);
/* 498 */         addWidget(stateButtons[i]);
/*     */       } 
/*     */     }
/* 501 */     if (NEIConfig.isActionPermissable(InterActionMap.DELETE))
/*     */     {
/* 503 */       addWidget(delete);
/*     */     }
/* 505 */     if (NEIConfig.isActionPermissable(InterActionMap.TIME)) {
/*     */       
/* 507 */       addWidget(dawn);
/* 508 */       addWidget(noon);
/* 509 */       addWidget(dusk);
/* 510 */       addWidget(midnight);
/*     */     } 
/* 512 */     if (NEIConfig.isActionPermissable(InterActionMap.RAIN))
/* 513 */       addWidget(rain); 
/* 514 */     if (NEIConfig.isActionPermissable(InterActionMap.HEAL))
/* 515 */       addWidget(heal); 
/* 516 */     if (NEIConfig.isActionPermissable(InterActionMap.MAGNET))
/* 517 */       addWidget(magnet); 
/* 518 */     if (NEIConfig.isActionPermissable(InterActionMap.CREATIVE)) {
/* 519 */       addWidget(creative);
/*     */     }
/*     */   }
/*     */   
/*     */   public static LayoutStyle getLayoutStyle() {
/* 524 */     LayoutStyle style = (LayoutStyle)layoutStyles.get(Integer.valueOf(NEIConfig.getLayoutStyle()));
/* 525 */     if (style == null)
/* 526 */       style = (LayoutStyle)layoutStyles.get(Integer.valueOf(0)); 
/* 527 */     return style;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addWidget(Widget widget) {
/* 532 */     drawWidgets.add(widget);
/* 533 */     controlWidgets.add(widget);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void tick() {
/*     */     try {
/* 540 */       if (!NEIConfig.isEnabled()) {
/*     */         return;
/*     */       }
/*     */       
/* 544 */       for (Widget widget : controlWidgets)
/*     */       {
/* 546 */         widget.update(gui);
/*     */       }
/*     */     }
/* 549 */     catch (Exception exception) {
/*     */       
/* 551 */       NEIUtils.reportException(exception);
/* 552 */       NEIConfig.setEnabled(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean onMouseWheel(int i) {
/*     */     try {
/* 560 */       if (NEIConfig.isHidden() || !NEIConfig.isEnabled())
/*     */       {
/* 562 */         return false;
/*     */       }
/* 564 */       for (Widget widget : controlWidgets)
/*     */       {
/* 566 */         if (widget.onMouseWheel(i, mousex, mousey))
/*     */         {
/* 568 */           return true;
/*     */         }
/*     */       }
/*     */     
/* 572 */     } catch (Exception exception) {
/*     */       
/* 574 */       NEIUtils.reportException(exception);
/* 575 */       NEIConfig.setEnabled(false);
/*     */     } 
/* 577 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Widget getInputFocused() {
/* 582 */     return inputFocused;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setInputFocused(Widget widget) {
/* 587 */     if (inputFocused != null) {
/* 588 */       inputFocused.loseFocus();
/*     */     }
/* 590 */     inputFocused = widget;
/* 591 */     if (inputFocused != null) {
/* 592 */       inputFocused.gainFocus();
/*     */     }
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
/* 630 */   public static HashMap layoutStyles = new HashMap<Object, Object>();
/*     */ 
/*     */   
/*     */   static {
/* 634 */     API.addLayoutStyle(0, new LayoutStyleMinecraft());
/* 635 */     API.addLayoutStyle(1, new LayoutStyleTMIOld());
/* 636 */     init();
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\LayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */