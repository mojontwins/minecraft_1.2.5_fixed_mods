/*      */ package codechicken.nei;
/*      */ import ModLoader;
/*      */ import Packager;
/*      */ import aan;
/*      */ import ady;
/*      */ import aff;
/*      */ import agd;
/*      */ import codechicken.core.ReflectionManager;
/*      */ import gb;
/*      */ import java.awt.Point;
/*      */ import java.io.File;
/*      */ import java.io.PrintWriter;
/*      */ import java.text.MessageFormat;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.regex.PatternSyntaxException;
/*      */ import jt;
/*      */ import ki;
/*      */ import mod_NotEnoughItems;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import no;
/*      */ import org.lwjgl.input.Keyboard;
/*      */ import org.lwjgl.input.Mouse;
/*      */ import pb;
/*      */ import vq;
/*      */ import yr;
/*      */ import yu;
/*      */ import yw;
/*      */ 
/*      */ public class NEIUtils {
/*   37 */   private static Minecraft mc = getMinecraft();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Minecraft getMinecraft() {
/*   45 */     if (mc == null)
/*      */     {
/*   47 */       mc = ModLoader.getMinecraftInstance();
/*      */     }
/*   49 */     return mc;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void loadItems() {
/*      */     try {
/*   56 */       if (ReflectionManager.classExists("net.minecraft.src.PluginHarness"))
/*      */       {
/*   58 */         ReflectionManager.callMethod(ReflectionManager.findClass("net.minecraft.src.PluginHarness"), "reloadPlugins", new Object[0]);
/*      */       }
/*      */     }
/*   61 */     catch (Exception e) {
/*      */       
/*   63 */       reportException(e);
/*      */       
/*      */       return;
/*      */     } 
/*   67 */     ItemVisibilityHash vis = NEIConfig.vishash;
/*   68 */     ArrayList<UnusedBlock> items = NEIController.items;
/*   69 */     ArrayList<UnusedBlock> visibleitems = NEIController.visibleitems;
/*   70 */     items.clear();
/*   71 */     visibleitems.clear();
/*      */     
/*   73 */     DropDownFile.dropDownInstance.resetHashes();
/*   74 */     String matchstring = NEIConfig.getSearchExpression();
/*   75 */     SubSetRangeTag rangematch = null;
/*   76 */     Pattern match = null;
/*   77 */     if (matchstring.startsWith("@") && matchstring.length() > 1) {
/*      */       
/*   79 */       rangematch = DropDownFile.dropDownInstance.getTag(matchstring.substring(1), false);
/*      */     }
/*      */     else {
/*      */       
/*   83 */       matchstring = matchstring.replace(".", "");
/*   84 */       matchstring = matchstring.replace("?", ".");
/*   85 */       matchstring = matchstring.replace("*", ".+?");
/*   86 */       matchstring = matchstring.toLowerCase();
/*      */       
/*      */       try {
/*   89 */         match = Pattern.compile(matchstring);
/*      */       }
/*   91 */       catch (PatternSyntaxException e) {
/*      */         
/*   93 */         match = Pattern.compile("");
/*   94 */         LayoutManager.searchField.setText(matchstring.substring(0, matchstring.length() - 1));
/*      */       } 
/*      */     } 
/*      */     
/*   98 */     for (int itemID = 0; itemID < yr.e.length; itemID++) {
/*      */       
/*  100 */       yr item = yr.e[itemID];
/*  101 */       if (item == null) {
/*      */         
/*  103 */         if (NEIConfig.getBooleanSetting("ID dump.show empty blockIDs") && itemID != 0 && itemID < pb.m.length)
/*      */         {
/*  105 */           items.add(new UnusedBlock(itemID));
/*  106 */           if (nameMatches("UnusedBlock ID: " + itemID, match)) {
/*  107 */             visibleitems.add(new UnusedBlock(itemID));
/*      */           }
/*      */         }
/*      */       
/*  111 */       } else if (!ItemInfo.isHidden(item.bQ)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  116 */         boolean skipDamage0 = false;
/*  117 */         ArrayList datalist = ItemInfo.getItemCompounds(itemID);
/*  118 */         if (datalist != null && NEIConfig.isActionPermissable("nbt"))
/*      */         {
/*  120 */           for (aan stack : datalist) {
/*      */             
/*  122 */             stack = stack.k();
/*  123 */             items.add(new ItemPanelStack(stack));
/*      */             
/*  125 */             DropDownFile.dropDownInstance.addItemIfInRange(itemID, stack.i(), stack.d);
/*  126 */             if (!vis.isItemHidden(itemID, stack.d) && 
/*  127 */               nameMatches(concatenatedDisplayName(stack, NEIConfig.showIDs()), match) && (
/*  128 */               rangematch == null || rangematch.isItemInRange(itemID, 0)) && 
/*  129 */               NEIConfig.canGetItem(new ItemHash(stack.c, stack.i())))
/*      */             {
/*  131 */               visibleitems.add(new ItemPanelStack(stack));
/*      */             }
/*  133 */             skipDamage0 = true;
/*      */           } 
/*      */         }
/*      */         
/*  137 */         HashSet<String> hashset = new HashSet();
/*  138 */         ArrayList damageranges = ItemInfo.getItemDamageVariants(item.bQ);
/*  139 */         for (int[] damagerange : damageranges) {
/*      */           
/*  141 */           for (int damage = damagerange[0]; damage <= damagerange[1]; damage++) {
/*      */             
/*  143 */             aan itemstack = new aan(item, 1, damage);
/*      */ 
/*      */             
/*  146 */             try { int l = item.g(itemstack);
/*  147 */               String name = concatenatedDisplayName(itemstack, false);
/*  148 */               if (!name.equals("Unnamed")) {
/*      */ 
/*      */ 
/*      */                 
/*  152 */                 String s = name + "@" + l;
/*  153 */                 if (!hashset.contains(s)) {
/*      */                   
/*  155 */                   hashset.add(s);
/*  156 */                   if (damage != 0 || !skipDamage0) {
/*      */ 
/*      */ 
/*      */                     
/*  160 */                     items.add(new ItemPanelStack(itemstack));
/*  161 */                     DropDownFile.dropDownInstance.addItemIfInRange(itemID, damage, null);
/*  162 */                     if (!vis.isItemHidden(itemID, damage) && 
/*  163 */                       nameMatches(concatenatedDisplayName(itemstack, NEIConfig.showIDs()), match) && (
/*  164 */                       rangematch == null || rangematch.isItemInRange(itemID, damage)) && 
/*  165 */                       NEIConfig.canGetItem(new ItemHash(itemID, damage)))
/*      */                     {
/*  167 */                       visibleitems.add(new ItemPanelStack(itemstack)); } 
/*      */                   } 
/*      */                 } 
/*      */               }  }
/*  171 */             catch (NullPointerException nullPointerException) {  }
/*  172 */             catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  177 */     DropDownFile.dropDownInstance.updateState();
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean nameMatches(String name, Pattern match) {
/*  182 */     return !(match != null && !match.toString().equals("") && !match.matcher(name.toLowerCase()).find());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void reportException(Exception exception) {
/*      */     try {
/*  189 */       exception.printStackTrace();
/*  190 */       String s = "nei " + (new SimpleDateFormat("d-M-y")).format(new Date()) + " at " + (new SimpleDateFormat("H.m.s.S")).format(new Date()) + ".txt";
/*  191 */       File file = new File(Minecraft.b(), s);
/*  192 */       PrintWriter printwriter = new PrintWriter(new FileWriter(file));
/*  193 */       printwriter.print("[code]NEI Version: " + ((Packager)mod_NotEnoughItems.class.<Packager>getAnnotation(Packager.class)).getVersion() + "\n");
/*  194 */       exception.printStackTrace(printwriter);
/*  195 */       printwriter.println("[/code]");
/*  196 */       printwriter.close();
/*  197 */       addChatMessage("Error written to " + s);
/*      */     }
/*  199 */     catch (Exception exception1) {
/*      */       
/*  201 */       System.out.println("Error during safeReportException:");
/*  202 */       exception1.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addChatMessage(String s) {
/*  208 */     if (mc.w != null) {
/*  209 */       mc.w.a(s);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List itemDisplayNameMultiline(aan itemstack, boolean showIDs) {
/*  221 */     List<String> namelist = null;
/*      */     
/*      */     try {
/*  224 */       namelist = itemstack.q();
/*      */       
/*  226 */       int rarity = (itemstack.s()).e;
/*  227 */       if (rarity != 15) {
/*  228 */         namelist.set(0, "§" + Integer.toHexString(rarity) + (String)namelist.get(0));
/*      */       }
/*  230 */     } catch (Exception exception) {}
/*      */     
/*  232 */     String overridename = ItemInfo.getOverrideName(itemstack.c, itemstack.i());
/*  233 */     if (namelist == null || namelist.size() == 0 || namelist.get(0) == null) {
/*      */       
/*  235 */       namelist = new ArrayList<String>();
/*  236 */       namelist.add(safeName(overridename));
/*      */     } 
/*  238 */     String mainname = ((String)namelist.get(0)).trim();
/*  239 */     if (mainname.length() == 0 || overridename != null) {
/*      */       
/*  241 */       mainname = safeName(overridename);
/*  242 */       namelist.set(0, mainname);
/*      */     } 
/*      */     
/*  245 */     if (showIDs && itemstack != null) {
/*      */       
/*  247 */       mainname = mainname + " " + itemstack.c;
/*  248 */       if (itemstack.i() != 0)
/*      */       {
/*  250 */         mainname = mainname + ":" + itemstack.i();
/*      */       }
/*  252 */       namelist.set(0, mainname);
/*      */     } 
/*      */     
/*  255 */     return namelist;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String safeName(String overridename) {
/*  260 */     return (overridename == null) ? "Unnamed" : overridename;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String itemDisplayNameShort(aan itemstack) {
/*  270 */     List<String> list = itemDisplayNameMultiline(itemstack, false);
/*  271 */     return list.get(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String concatenatedDisplayName(aan itemstack, boolean showIDs) {
/*  281 */     List list = itemDisplayNameMultiline(itemstack, showIDs);
/*  282 */     StringBuilder s = new StringBuilder();
/*  283 */     boolean first = true;
/*  284 */     for (String name : list) {
/*      */       
/*  286 */       if (first) {
/*      */         
/*  288 */         first = false;
/*      */       }
/*      */       else {
/*      */         
/*  292 */         s.append("#");
/*      */       } 
/*  294 */       s.append(name);
/*      */     } 
/*  296 */     return s.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public static aan getValidItem(aan itemstack) {
/*  301 */     if (itemstack.a() != null)
/*      */     {
/*  303 */       return itemstack;
/*      */     }
/*      */     
/*  306 */     return new aan(pb.as);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void deleteHeldItem() {
/*  312 */     deleteSlotStack(-999);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dropHeldItem() {
/*  317 */     (getMinecraft()).c.a(((gb)(getMinecraft()).s).d.f, -999, 0, false, (yw)(getMinecraft()).h);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void deleteSlotStack(int slotNumber) {
/*  322 */     setSlotContents(slotNumber, null, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void decreaseSlotStack(int slotNumber) {
/*  346 */     aan stack = (slotNumber == -999) ? getHeldItem() : mc.h.ar.b(slotNumber).b();
/*  347 */     if (stack == null) {
/*      */       return;
/*      */     }
/*  350 */     if (stack.a == 1) {
/*  351 */       deleteSlotStack(slotNumber);
/*      */     } else {
/*      */       
/*  354 */       stack = stack.k();
/*  355 */       stack.a--;
/*  356 */       setSlotContents(slotNumber, stack, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void deleteEverything() {
/*  362 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  364 */       NEIPacketHandler.sendDeleteAllItems();
/*      */     }
/*      */     else {
/*      */       
/*  368 */       for (int i = 0; i < mc.h.ar.e.size(); i++)
/*      */       {
/*  370 */         mc.h.ar.a(i, null);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void deleteItemsOfType(aan itemstack, gb guicontainer) {
/*  377 */     for (int i = 0; i < guicontainer.d.e.size(); i++) {
/*      */       
/*  379 */       yu slot = guicontainer.d.b(i);
/*  380 */       if (slot != null) {
/*      */ 
/*      */ 
/*      */         
/*  384 */         aan itemstack1 = slot.b();
/*  385 */         if (itemstack1 != null && itemstack1.c == itemstack.c && itemstack1.i() == itemstack.i()) {
/*      */           
/*  387 */           setSlotContents(i, null, true);
/*  388 */           slot.d(null);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static aan getHeldItem() {
/*  395 */     return mc.h.ap.k();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setSlotContents(int slot, aan item, boolean containerInv) {
/*  400 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  402 */       NEIPacketHandler.sendSetSlot(slot, item, containerInv);
/*      */       
/*  404 */       if (slot == -999)
/*      */       {
/*  406 */         mc.h.ap.b(item);
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  411 */     else if (slot == -999) {
/*      */       
/*  413 */       mc.h.ap.b(item);
/*      */     }
/*  415 */     else if (containerInv) {
/*      */       
/*  417 */       mc.h.ar.a(slot, item);
/*      */     }
/*      */     else {
/*      */       
/*  421 */       mc.h.ap.a(slot, item);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void cheatItem(aan typeStack, int button, int mode) {
/*  434 */     if (!NEIConfig.isActionPermissable("item")) {
/*      */       return;
/*      */     }
/*  437 */     if (mode == -1 && button == 0 && shiftKey()) {
/*      */       
/*  439 */       for (IInfiniteItemHandler handler : ItemInfo.infiniteHandlers) {
/*      */         
/*  441 */         if (!handler.canHandleItem(typeStack)) {
/*      */           continue;
/*      */         }
/*  444 */         aan stack = handler.getInfiniteItem(typeStack);
/*  445 */         if (stack != null) {
/*      */           
/*  447 */           giveStack(stack, stack.a, true);
/*      */           return;
/*      */         } 
/*      */       } 
/*  451 */       cheatItem(typeStack, button, 0);
/*      */     }
/*  453 */     else if (typeStack.a().i()) {
/*      */       
/*  455 */       giveStack(typeStack, 1);
/*      */     }
/*  457 */     else if (button == 1) {
/*      */       
/*  459 */       giveStack(typeStack, 1);
/*      */ 
/*      */     
/*      */     }
/*  463 */     else if (mode == 1 && typeStack.a < typeStack.c()) {
/*      */       
/*  465 */       giveStack(typeStack, typeStack.c() - typeStack.a);
/*      */     }
/*      */     else {
/*      */       
/*  469 */       int amount = NEIConfig.getItemQuantity();
/*  470 */       if (amount == 0)
/*  471 */         amount = typeStack.c(); 
/*  472 */       giveStack(typeStack, amount);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void giveStack(aan itemstack) {
/*  479 */     giveStack(itemstack, itemstack.a);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void giveStack(aan itemstack, int i) {
/*  484 */     giveStack(itemstack, i, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void giveStack(aan itemstack, int i, boolean infinite) {
/*  489 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  491 */       aan itemstack1 = copyStack(itemstack, i);
/*  492 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/*  494 */         NEIPacketHandler.sendSpawnItem(itemstack1, infinite);
/*      */       }
/*      */       else
/*      */       {
/*  498 */         sendCommand(NEIConfig.getStringSetting("command.give"), new Object[] { mc.h.aA, Integer.valueOf(itemstack1.c), Integer.valueOf(itemstack1.a), Integer.valueOf(itemstack1.i()) });
/*      */       }
/*      */     
/*  501 */     } else if (infinite) {
/*  502 */       mc.h.ap.a(copyStack(itemstack, i));
/*      */     } else {
/*      */       
/*  505 */       int increment = itemstack.c();
/*  506 */       for (int given = 0; given < i; given += increment) {
/*      */         
/*  508 */         aan itemstack1 = copyStack(itemstack, Math.min(i - given, increment));
/*  509 */         if (!mc.h.ap.a(itemstack1)) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static aan copyStack(aan itemstack, int i) {
/*  517 */     if (itemstack == null)
/*      */     {
/*  519 */       return null;
/*      */     }
/*      */     
/*  522 */     itemstack.a += i;
/*  523 */     return itemstack.a(i);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static aan copyStack(aan itemstack) {
/*  529 */     if (itemstack == null)
/*      */     {
/*  531 */       return null;
/*      */     }
/*      */     
/*  534 */     return copyStack(itemstack, itemstack.a);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void updateUnlimitedItems() {
/*  540 */     aan itemstack = getHeldItem();
/*  541 */     if (itemstack != null && itemstack.a > 64)
/*      */     {
/*  543 */       itemstack.a = 1;
/*      */     }
/*      */     
/*  546 */     aan[] aitemstack = mc.h.ap.a;
/*  547 */     for (int slot = 0; slot < aitemstack.length; slot++) {
/*      */       
/*  549 */       aan itemstack1 = aitemstack[slot];
/*  550 */       if (itemstack1 != null) {
/*      */ 
/*      */ 
/*      */         
/*  554 */         if (itemstack1.a < 0 || itemstack1.a > 64)
/*      */         {
/*  556 */           itemstack1.a = 111;
/*      */         }
/*  558 */         if (itemstack1.i() > -32000 && itemstack1.i() < -30000)
/*      */         {
/*  560 */           itemstack1.b(-32000); } 
/*      */       } 
/*      */     } 
/*  563 */     if (NEIConfig.isMultiplayer() || !NEIConfig.isEnabled()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  568 */     LinkedList<ItemHash> infiniteItems = new LinkedList(); int i;
/*  569 */     for (i = 0; i < aitemstack.length; i++) {
/*      */       
/*  571 */       aan stack = aitemstack[i];
/*  572 */       if (stack != null)
/*      */       {
/*  574 */         if (stack.a == 111)
/*      */         {
/*  576 */           infiniteItems.add(new ItemHash(stack));
/*      */         }
/*      */       }
/*      */     } 
/*  580 */     for (i = 0; i < aitemstack.length; i++) {
/*      */       
/*  582 */       aan stack = aitemstack[i];
/*  583 */       if (stack != null)
/*      */       {
/*  585 */         if (stack.a != 111 && infiniteItems.contains(new ItemHash(stack)))
/*      */         {
/*  587 */           aitemstack[i] = null;
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean areStacksSameType(aan stack1, aan stack2) {
/*  598 */     if (stack1 == null || stack2 == null) {
/*  599 */       return (stack1 == stack2);
/*      */     }
/*  601 */     return (stack1.c == stack2.c && stack1.i() == stack2.i());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean areStacksSameTypeCrafting(aan stack1, aan stack2) {
/*  611 */     if (stack1 == null || stack2 == null) {
/*  612 */       return false;
/*      */     }
/*  614 */     if (stack1.c == stack2.c && (
/*  615 */       stack1.i() == stack2.i() || stack1.i() == -1 || stack2.i() == -1 || stack1.a().i())) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compareStacks(aan stack1, aan stack2) {
/*  625 */     if (stack1 == stack2) return 0; 
/*  626 */     if (stack1 == null || stack2 == null) return (stack1 == null) ? -1 : 1; 
/*  627 */     if (stack1.c != stack2.c) return stack1.c - stack2.c; 
/*  628 */     if (stack1.a != stack2.a) return stack1.a - stack2.a; 
/*  629 */     return stack1.i() - stack2.i();
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean areStacksIdentical(aan stack1, aan stack2) {
/*  634 */     return (compareStacks(stack1, stack2) == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isValidItem(aan test) {
/*  639 */     yr item = test.a();
/*  640 */     if (item == null)
/*      */     {
/*  642 */       return false;
/*      */     }
/*  644 */     if (ItemInfo.isHidden(item.bQ))
/*      */     {
/*  646 */       return false;
/*      */     }
/*  648 */     HashSet<String> hashset = new HashSet();
/*  649 */     ArrayList damageranges = ItemInfo.getItemDamageVariants(item.bQ);
/*  650 */     for (int[] damagerange : damageranges) {
/*      */       
/*  652 */       for (int damage = damagerange[0]; damage <= damagerange[1]; damage++) {
/*      */         
/*  654 */         aan itemstack = new aan(item, item.f(), damage);
/*      */ 
/*      */         
/*  657 */         try { int l = item.g(itemstack);
/*  658 */           String name = concatenatedDisplayName(itemstack, false);
/*  659 */           if (name == null) {
/*      */             
/*  661 */             if (damage == test.i())
/*      */             {
/*  663 */               return false;
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */           else {
/*      */             
/*  670 */             String s = name + "@" + l;
/*      */             
/*  672 */             if (damage == test.i()) {
/*      */               
/*  674 */               if (!hashset.contains(s))
/*      */               {
/*  676 */                 return true;
/*      */               }
/*      */ 
/*      */               
/*  680 */               return false;
/*      */             } 
/*      */             
/*  683 */             if (!hashset.contains(s))
/*      */             {
/*  685 */               hashset.add(s);
/*      */             }
/*      */           }  }
/*  688 */         catch (NullPointerException nullPointerException) {  }
/*  689 */         catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*      */       } 
/*      */     } 
/*  692 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static List getEnchantments(aan itemstack) {
/*  697 */     ArrayList<int[]> arraylist = new ArrayList();
/*  698 */     if (itemstack != null) {
/*      */       
/*  700 */       no nbttaglist = itemstack.p();
/*  701 */       if (nbttaglist != null)
/*      */       {
/*  703 */         for (int i = 0; i < nbttaglist.d(); i++) {
/*      */           
/*  705 */           short word0 = ((ady)nbttaglist.a(i)).e("id");
/*  706 */           short word1 = ((ady)nbttaglist.a(i)).e("lvl");
/*  707 */           int[] ai = {
/*  708 */               word0, word1
/*      */             };
/*  710 */           arraylist.add(ai);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  715 */     return arraylist;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean addEnchantment(aan itemstack, int e, int level) {
/*  720 */     if (e < jt.a.length && jt.a[e] != null) {
/*      */       
/*  722 */       itemstack.a(jt.a[e], level);
/*  723 */       return true;
/*      */     } 
/*      */     
/*  726 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeEnchantment(aan itemstack, int e) {
/*  732 */     no nbttaglist = itemstack.p();
/*  733 */     if (nbttaglist != null)
/*      */     {
/*  735 */       for (int i = 0; i < nbttaglist.d(); i++) {
/*      */         
/*  737 */         int ID = ((ady)nbttaglist.a(i)).e("id");
/*  738 */         if (ID == e) {
/*      */ 
/*      */           
/*      */           try {
/*  742 */             List list = (List)ModLoader.getPrivateValue(no.class, nbttaglist, 0);
/*  743 */             list.remove(i);
/*  744 */             if (list.size() == 0)
/*      */             {
/*  746 */               itemstack.d(null);
/*      */             }
/*      */           }
/*  749 */           catch (Exception ex) {
/*      */             
/*  751 */             ex.printStackTrace();
/*      */           } 
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean stackHasEnchantment(aan itemstack, int e) {
/*  761 */     List allenchantments = getEnchantments(itemstack);
/*  762 */     for (int[] ai : allenchantments) {
/*      */       
/*  764 */       if (ai[0] == e)
/*      */       {
/*  766 */         return true;
/*      */       }
/*      */     } 
/*  769 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getEnchantmentLevel(aan itemstack, int e) {
/*  774 */     List allenchantments = getEnchantments(itemstack);
/*  775 */     for (int[] ai : allenchantments) {
/*      */       
/*  777 */       if (ai[0] == e)
/*      */       {
/*  779 */         return ai[1];
/*      */       }
/*      */     } 
/*  782 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean doesEnchantmentConflict(List enchantments, jt e) {
/*  787 */     for (int[] ai : enchantments) {
/*      */       
/*  789 */       if (!e.a(jt.a[ai[0]]))
/*      */       {
/*  791 */         return true;
/*      */       }
/*      */     } 
/*  794 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean canItemFitInInventory(yw player, aan itemstack) {
/*      */     int i;
/*  799 */     for (i = 0; i < player.ap.a() - 4; i++) {
/*      */       
/*  801 */       if (player.ap.k_(i) == null)
/*      */       {
/*  803 */         return true;
/*      */       }
/*      */     } 
/*  806 */     if (!itemstack.g()) {
/*      */       
/*  808 */       if (itemstack.c() == 1) return false;
/*      */       
/*  810 */       for (i = 0; i < player.ap.a(); i++) {
/*      */         
/*  812 */         aan invstack = player.ap.k_(i);
/*  813 */         if (invstack != null && invstack.c == itemstack.c && invstack.d() && invstack.a < invstack.c() && invstack.a < player.ap.d() && (!invstack.f() || invstack.i() == itemstack.i()))
/*      */         {
/*  815 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*  819 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean shiftKey() {
/*  824 */     return !(!Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean controlKey() {
/*  829 */     return !(!Keyboard.isKeyDown(29) && !Keyboard.isKeyDown(157));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int maxStackSize(int item) {
/*  834 */     return yr.e[item].f();
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getCreativeMode() {
/*  839 */     if (NEIConfig.invCreativeMode())
/*  840 */       return 2; 
/*  841 */     if (mc.c.h()) {
/*  842 */       return 1;
/*      */     }
/*  844 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void cycleCreativeMode() {
/*  849 */     int mode = getCreativeMode();
/*  850 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  852 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/*  854 */         NEIPacketHandler.sendCycleCreativeMode();
/*      */       }
/*      */       else
/*      */       {
/*  858 */         sendCommand(NEIConfig.getStringSetting("command.creative"), new Object[] { mc.h.aA, Integer.valueOf(mode ^ 0x1) });
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  863 */       setCreativeMode((mode + 1) % 3);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setCreativeMode(int mode) {
/*  869 */     NEIConfig.setInvCreative((mode == 2));
/*      */     
/*  871 */     boolean enable = (mode != 0);
/*  872 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  874 */       ((rk)mc.c).a(enable);
/*      */     } else {
/*      */ 
/*      */       
/*      */       try {
/*      */         
/*  880 */         Minecraft minecraft = getMinecraft();
/*  881 */         if (enable) {
/*      */           
/*  883 */           aff.d((yw)mc.h);
/*  884 */           minecraft.c = (ki)new aff(minecraft);
/*      */         } else {
/*      */           
/*  887 */           aff.e((yw)mc.h);
/*  888 */           minecraft.c = (ki)new aes(minecraft);
/*      */         } 
/*  890 */         ReflectionManager.setField(wq.class, minecraft.f.B(), 16, Integer.valueOf(enable ? 1 : 0));
/*      */       
/*      */       }
/*  893 */       catch (Exception exception) {
/*      */         
/*  895 */         reportException(exception);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static long getTime() {
/*  902 */     return (getMinecraft()).f.B().f();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setTime(long l) {
/*  907 */     (getMinecraft()).f.B().a(l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setHourForward(int i) {
/*  912 */     long timethisday = getTime() / 24000L * 24000L;
/*  913 */     long nexthour = timethisday + 24000L + (i * 1000);
/*      */     
/*  915 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  917 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/*  919 */         NEIPacketHandler.sendSetTime(i);
/*      */       }
/*      */       else
/*      */       {
/*  923 */         long l = getTime() / 24000L * 24000L;
/*  924 */         long l1 = l + 24000L + (i * 1000);
/*  925 */         setTime(l1);
/*      */         
/*  927 */         sendCommand(NEIConfig.getStringSetting("command.time"), new Object[] { Long.valueOf(nexthour) });
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  932 */       setTime(nexthour);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void sendCommand(String command, Object... args) {
/*  938 */     NumberFormat numberformat = NumberFormat.getIntegerInstance();
/*  939 */     numberformat.setGroupingUsed(false);
/*  940 */     MessageFormat messageformat = new MessageFormat(command);
/*  941 */     for (int i = 0; i < args.length; i++) {
/*      */       
/*  943 */       if (args[i] instanceof Integer || args[i] instanceof Long)
/*      */       {
/*  945 */         messageformat.setFormatByArgumentIndex(i, numberformat);
/*      */       }
/*      */     } 
/*  948 */     mc.h.a(messageformat.format(args));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isRaining() {
/*  953 */     return (getMinecraft()).f.B().o();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void toggleRaining() {
/*  958 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  960 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/*  962 */         NEIPacketHandler.sendToggleRain();
/*      */       }
/*      */       else
/*      */       {
/*  966 */         sendCommand(NEIConfig.getStringSetting("command.rain"), new Object[] { Integer.valueOf(isRaining() ? 0 : 1) });
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  971 */       (getMinecraft()).f.B().b(!isRaining());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void healPlayer() {
/*  977 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/*  979 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/*  981 */         NEIPacketHandler.sendHeal();
/*      */       }
/*      */       else
/*      */       {
/*  985 */         sendCommand(NEIConfig.getStringSetting("command.heal"), new Object[] { mc.h.aA });
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  990 */       vq vq = mc.h;
/*  991 */       vq.k(20);
/*  992 */       mod_NotEnoughItems.foodStats((yw)vq).a(20);
/*  993 */       mod_NotEnoughItems.foodStats((yw)vq).b(1.0F);
/*  994 */       vq.D();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void toggleMagnetMode() {
/* 1000 */     if (NEIConfig.isMultiplayer()) {
/*      */       
/* 1002 */       if (NEIConfig.hasSMPCounterPart())
/*      */       {
/* 1004 */         NEIPacketHandler.sendToggleMagnetMode();
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1009 */       NEIConfig.setMagnetMode(!NEIConfig.getMagnetMode());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static ArrayList concatIntegersToRanges(List<Comparable> damages) {
/* 1015 */     ArrayList<int[]> ranges = new ArrayList();
/* 1016 */     if (damages.size() == 0) return ranges;
/*      */     
/* 1018 */     Collections.sort(damages);
/* 1019 */     int start = -1;
/* 1020 */     int next = 0;
/* 1021 */     for (Integer i : damages) {
/*      */       
/* 1023 */       if (start == -1) {
/*      */         
/* 1025 */         start = next = i.intValue();
/*      */         continue;
/*      */       } 
/* 1028 */       if (next + 1 != i.intValue()) {
/*      */         
/* 1030 */         ranges.add(new int[] { start, next });
/* 1031 */         start = next = i.intValue();
/*      */         continue;
/*      */       } 
/* 1034 */       next = i.intValue();
/*      */     } 
/* 1036 */     ranges.add(new int[] { start, next });
/* 1037 */     return ranges;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean itemMatchesSearch(aan stack) {
/* 1042 */     String matchstring = NEIConfig.getSearchExpression();
/* 1043 */     SubSetRangeTag rangematch = null;
/* 1044 */     Pattern match = null;
/* 1045 */     if (matchstring.startsWith("@") && matchstring.length() > 1) {
/*      */       
/* 1047 */       rangematch = DropDownFile.dropDownInstance.getTag(matchstring.substring(1), false);
/*      */     }
/*      */     else {
/*      */       
/* 1051 */       matchstring = matchstring.replace(".", "");
/* 1052 */       matchstring = matchstring.replace("?", ".");
/* 1053 */       matchstring = matchstring.replace("*", ".+?");
/* 1054 */       matchstring = matchstring.toLowerCase();
/*      */       
/*      */       try {
/* 1057 */         match = Pattern.compile(matchstring);
/*      */       }
/* 1059 */       catch (PatternSyntaxException e) {
/*      */         
/* 1061 */         match = Pattern.compile("");
/* 1062 */         LayoutManager.searchField.setText(matchstring.substring(0, matchstring.length() - 1));
/*      */       } 
/*      */     } 
/*      */     
/* 1066 */     if (nameMatches(concatenatedDisplayName(stack, NEIConfig.showIDs()), match) && (
/* 1067 */       rangematch == null || rangematch.isItemInRange(stack.c, 0)))
/*      */     {
/* 1069 */       return true;
/*      */     }
/* 1071 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void advanceDisabledTimes() {
/* 1076 */     int hour = (int)(getTime() % 24000L) / 1000;
/* 1077 */     int newhour = hour;
/*      */     
/*      */     while (true) {
/* 1080 */       int zone = newhour / 6;
/* 1081 */       if (NEIConfig.isPropertyDisabled((String)AllowedPropertyMap.idToNameMap.get(Integer.valueOf(zone)))) {
/*      */         
/* 1083 */         newhour = (zone + 1) % 4 * 6;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/* 1090 */     if (newhour != hour)
/*      */     {
/* 1092 */       setHourForward(newhour);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void dumpIDs() {
/*      */     try {
/* 1100 */       boolean blocks = NEIConfig.getBooleanSetting("ID dump.blockIDs");
/* 1101 */       boolean items = NEIConfig.getBooleanSetting("ID dump.itemIDs");
/* 1102 */       boolean unusedblocks = NEIConfig.getBooleanSetting("ID dump.unused blockIDs");
/* 1103 */       boolean unuseditems = NEIConfig.getBooleanSetting("ID dump.unused itemIDs");
/*      */       
/* 1105 */       String s = "IDMap dump " + (new SimpleDateFormat("d-M-y")).format(new Date()) + " at " + (new SimpleDateFormat("H.m.s.S")).format(new Date()) + ".txt";
/*      */       
/* 1107 */       File writeTo = new File(Minecraft.b(), s);
/* 1108 */       if (!writeTo.exists())
/* 1109 */         writeTo.createNewFile(); 
/* 1110 */       PrintWriter writer = new PrintWriter(writeTo);
/*      */       
/* 1112 */       for (int i = 1; i < yr.e.length; i++) {
/*      */         
/* 1114 */         if (i < pb.m.length && pb.m[i] != null) {
/*      */           
/* 1116 */           if (blocks) {
/*      */ 
/*      */             
/* 1119 */             pb block = pb.m[i];
/* 1120 */             String name = block.s();
/* 1121 */             if (name == null) {
/* 1122 */               name = block.getClass().getCanonicalName();
/*      */             }
/* 1124 */             writer.println("Block. Name: " + name + ". ID: " + i);
/*      */           } 
/* 1126 */         } else if (yr.e[i] != null) {
/*      */           
/* 1128 */           if (items) {
/*      */ 
/*      */             
/* 1131 */             yr item = yr.e[i];
/* 1132 */             String name = item.e();
/* 1133 */             if (name == null) {
/* 1134 */               name = item.getClass().getCanonicalName();
/*      */             }
/* 1136 */             writer.println("Item. Name: " + name + ". ID: " + i);
/*      */           } 
/* 1138 */         } else if (i < 256) {
/*      */           
/* 1140 */           if (unusedblocks)
/*      */           {
/*      */             
/* 1143 */             writer.println("Block. Unused ID: " + i);
/*      */           
/*      */           }
/*      */         }
/* 1147 */         else if (unuseditems) {
/*      */ 
/*      */           
/* 1150 */           writer.println("Item. Unused ID: " + i);
/*      */         } 
/*      */       } 
/* 1153 */       writer.close();
/* 1154 */       addChatMessage("Dumped IDMap to " + s);
/*      */     }
/* 1156 */     catch (Exception e) {
/*      */       
/* 1158 */       reportException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean safeKeyDown(int keyCode) {
/*      */     try {
/* 1166 */       return Keyboard.isKeyDown(keyCode);
/*      */     }
/* 1168 */     catch (IndexOutOfBoundsException e) {
/*      */       
/* 1170 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static Point getMousePosition() {
/* 1176 */     agd scaledresolution = new agd(mc.A, mc.d, mc.e);
/* 1177 */     int w = scaledresolution.a();
/* 1178 */     int h = scaledresolution.b();
/* 1179 */     return new Point(Mouse.getX() * w / mc.d, h - Mouse.getY() * h / mc.e - 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setItemQuantity(int i) {
/* 1184 */     NEIConfig.setItemQuantity(i);
/* 1185 */     LayoutManager.quantity.text = Integer.toString(i);
/*      */   }
/*      */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */