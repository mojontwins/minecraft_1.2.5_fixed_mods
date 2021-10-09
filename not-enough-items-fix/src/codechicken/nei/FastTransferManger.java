/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import dd;
/*     */ import gb;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import yr;
/*     */ import yu;
/*     */ import yw;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FastTransferManger
/*     */ {
/*     */   public static class SlotPositionComparator
/*     */     implements Comparator
/*     */   {
/*     */     dd container;
/*     */     
/*     */     public SlotPositionComparator(dd c) {
/*  27 */       this.container = c;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compare(Integer arg0, Integer arg1) {
/*  33 */       yu slot1 = this.container.b(arg0.intValue());
/*  34 */       yu slot2 = this.container.b(arg1.intValue());
/*     */       
/*  36 */       if (slot2.e != slot1.e) return slot1.e - slot2.e; 
/*  37 */       return slot1.d - slot2.d;
/*     */     }
/*     */   }
/*     */   
/*  41 */   public LinkedList slotZones = new LinkedList();
/*  42 */   public HashMap slotZoneMap = new HashMap<Object, Object>();
/*     */ 
/*     */   
/*     */   public FastTransferManger(dd container) {
/*  46 */     generateSlotMap(container);
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateSlotMap(dd container) {
/*  51 */     for (int slotNo = 0; slotNo < container.e.size(); slotNo++) {
/*     */       
/*  53 */       if (!this.slotZoneMap.containsKey(Integer.valueOf(slotNo)) && container.b(slotNo).a(new aan(yr.n, 1))) {
/*     */ 
/*     */         
/*  56 */         HashSet<?> connectedSlots = new HashSet();
/*  57 */         findConnectedSlots(container, slotNo, connectedSlots);
/*     */         
/*  59 */         LinkedList<?> zoneSlots = new LinkedList(connectedSlots);
/*  60 */         Collections.sort(zoneSlots, new SlotPositionComparator(container));
/*  61 */         this.slotZones.add(zoneSlots);
/*     */         
/*  63 */         for (Iterator<?> iterator = zoneSlots.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*     */           
/*  65 */           this.slotZoneMap.put(Integer.valueOf(i), Integer.valueOf(this.slotZones.size() - 1)); }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void findConnectedSlots(dd container, int slotNo, HashSet<Integer> connectedSlots) {
/*  72 */     connectedSlots.add(Integer.valueOf(slotNo));
/*  73 */     yu slot = container.b(slotNo);
/*  74 */     int threshold = 18;
/*     */     
/*  76 */     for (int i = 0; i < container.e.size(); i++) {
/*     */       
/*  78 */       if (!connectedSlots.contains(Integer.valueOf(i))) {
/*     */ 
/*     */         
/*  81 */         yu slot1 = container.b(i);
/*  82 */         if (Math.abs(slot.d - slot1.d) <= 18 && Math.abs(slot.e - slot1.e) <= 18)
/*     */         {
/*  84 */           findConnectedSlots(container, i, connectedSlots);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int findSlotWithItem(dd container, aan teststack) {
/*  91 */     for (int slotNo = 0; slotNo < container.e.size(); slotNo++) {
/*     */       
/*  93 */       aan stack = container.b(slotNo).b();
/*  94 */       if (stack != null && NEIUtils.areStacksSameType(stack, teststack))
/*     */       {
/*  96 */         return slotNo;
/*     */       }
/*     */     } 
/*  99 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearSlots(dd container) {
/* 104 */     for (int slotNo = 0; slotNo < container.e.size(); slotNo++)
/*     */     {
/* 106 */       ((yu)container.e.get(slotNo)).d(null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void performMassTransfer(gb window, int fromSlot, int toSlot, aan heldStack) {
/* 112 */     Integer fromZone = (Integer)this.slotZoneMap.get(Integer.valueOf(fromSlot));
/* 113 */     Integer toZone = (Integer)this.slotZoneMap.get(Integer.valueOf(toSlot));
/*     */     
/* 115 */     if (fromZone == null || toZone == null || fromZone == toZone) {
/*     */       return;
/*     */     }
/* 118 */     if (NEIUtils.getHeldItem() != null && !NEIUtils.areStacksSameType(heldStack, NEIUtils.getHeldItem())) {
/*     */       return;
/*     */     }
/* 121 */     if (!fillZoneWithHeldItem(window, toZone.intValue())) {
/*     */       return;
/*     */     }
/* 124 */     for (Iterator<Integer> iterator = ((LinkedList)this.slotZones.get(fromZone.intValue())).iterator(); iterator.hasNext(); ) { int transferFrom = ((Integer)iterator.next()).intValue();
/*     */       
/* 126 */       aan transferStack = window.d.b(transferFrom).b();
/*     */       
/* 128 */       if (!NEIUtils.areStacksSameType(heldStack, transferStack)) {
/*     */         continue;
/*     */       }
/* 131 */       clickSlot(window, transferFrom);
/* 132 */       if (!fillZoneWithHeldItem(window, toZone.intValue())) {
/*     */         
/* 134 */         clickSlot(window, transferFrom);
/*     */         return;
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int findShiftClickDestinationSlot(dd container, int fromSlot) {
/* 145 */     LinkedList save = saveContainer(container);
/*     */     
/* 147 */     yu slot = container.b(fromSlot);
/* 148 */     aan stack = slot.b();
/* 149 */     if (stack == null) {
/* 150 */       return -1;
/*     */     }
/* 152 */     stack.a = 1;
/* 153 */     slot.d(stack.k());
/*     */     
/* 155 */     LinkedList<aan> compareBefore = saveContainer(container);
/* 156 */     container.a(fromSlot, 0, true, (yw)(NEIUtils.getMinecraft()).h);
/* 157 */     LinkedList<aan> compareAfter = saveContainer(container);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 164 */       for (int i = 0; i < compareBefore.size(); i++) {
/*     */         
/* 166 */         if (i != fromSlot)
/*     */         {
/*     */           
/* 169 */           if (!NEIUtils.areStacksIdentical(compareBefore.get(i), compareAfter.get(i)) && compareAfter.get(i) != null)
/*     */           {
/* 171 */             if ((compareBefore.get(i) == null && NEIUtils.areStacksSameType(stack, compareAfter.get(i))) || (
/* 172 */               NEIUtils.areStacksSameType(stack, compareAfter.get(i)) && 
/* 173 */               ((aan)compareAfter.get(i)).a - 
/* 174 */               ((aan)compareBefore.get(i)).a > 0))
/* 175 */               return i; 
/*     */           }
/*     */         }
/*     */       } 
/* 179 */       return -1;
/*     */     }
/*     */     finally {
/*     */       
/* 183 */       restoreContainer(container, save);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LinkedList saveContainer(dd container) {
/* 189 */     LinkedList<aan> stacks = new LinkedList();
/* 190 */     for (int i = 0; i < container.e.size(); i++)
/*     */     {
/* 192 */       stacks.add(NEIUtils.copyStack(container.b(i).b()));
/*     */     }
/* 194 */     return stacks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void restoreContainer(dd container, LinkedList<aan> items) {
/* 199 */     for (int i = 0; i < container.e.size(); i++)
/*     */     {
/* 201 */       container.b(i).d(items.get(i));
/*     */     }
/*     */     
/* 204 */     container.a(-999, 0, false, (yw)(NEIUtils.getMinecraft()).h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void transferItem(gb window, int fromSlot) {
/* 209 */     System.out.println("Starting Transfer");
/* 210 */     long transferStart = System.currentTimeMillis();
/*     */     
/* 212 */     int toSlot = findShiftClickDestinationSlot(window.d, fromSlot);
/* 213 */     if (toSlot == -1) {
/*     */       
/* 215 */       System.out.println("Transfer Complete: " + (System.currentTimeMillis() - transferStart) + "ms");
/*     */       
/*     */       return;
/*     */     } 
/* 219 */     if (!window.d.b(fromSlot).a(null)) {
/*     */       
/* 221 */       moveOutputSet(window, fromSlot, toSlot);
/*     */     }
/*     */     else {
/*     */       
/* 225 */       moveOneItem(window, fromSlot, toSlot);
/*     */     } 
/*     */     
/* 228 */     System.out.println("Transfer Complete: " + (System.currentTimeMillis() - transferStart) + "ms");
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveOutputSet(gb window, int fromSlot, int toSlot) {
/* 233 */     if (NEIUtils.getHeldItem() != null) {
/*     */       return;
/*     */     }
/* 236 */     clickSlot(window, fromSlot);
/* 237 */     if (NEIUtils.getHeldItem() == null)
/*     */       return; 
/* 239 */     clickSlot(window, toSlot);
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveOneItem(gb window, int fromSlot, int toSlot) {
/* 244 */     clickSlot(window, fromSlot);
/* 245 */     clickSlot(window, toSlot, 1);
/* 246 */     clickSlot(window, fromSlot);
/*     */   }
/*     */ 
/*     */   
/*     */   public void retrieveItem(gb window, int toSlot) {
/* 251 */     yu slot = window.d.b(toSlot);
/* 252 */     aan slotStack = slot.b();
/* 253 */     if (slotStack == null || 
/* 254 */       slotStack.a == slot.a() || 
/* 255 */       slotStack.a == slotStack.c()) {
/*     */       return;
/*     */     }
/* 258 */     Integer destZone = (Integer)this.slotZoneMap.get(Integer.valueOf(toSlot));
/* 259 */     if (destZone == null) {
/*     */       return;
/*     */     }
/* 262 */     int firstZoneSlot = findShiftClickDestinationSlot(window.d, toSlot);
/* 263 */     int firstZone = -1;
/* 264 */     if (firstZoneSlot != -1) {
/*     */       
/* 266 */       Integer integer = (Integer)this.slotZoneMap.get(Integer.valueOf(firstZoneSlot));
/* 267 */       if (integer != null) {
/*     */         
/* 269 */         firstZone = integer.intValue();
/* 270 */         if (retrieveItemFromZone(window, firstZone, toSlot)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 275 */     for (int zone = 0; zone < this.slotZones.size(); zone++) {
/*     */       
/* 277 */       if (zone != destZone.intValue() && zone != firstZone)
/*     */       {
/*     */         
/* 280 */         if (retrieveItemFromZone(window, zone, toSlot))
/*     */           return; 
/*     */       }
/*     */     } 
/* 284 */     retrieveItemFromZone(window, destZone.intValue(), toSlot);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean retrieveItemFromZone(gb window, int zone, int toSlot) {
/* 289 */     aan stack = window.d.b(toSlot).b(); Iterator<Integer> iterator;
/* 290 */     for (iterator = ((LinkedList)this.slotZones.get(zone)).iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*     */       
/* 292 */       if (i == toSlot) {
/*     */         continue;
/*     */       }
/* 295 */       yu slot = window.d.b(i);
/* 296 */       aan stack1 = slot.b();
/*     */       
/* 298 */       if (NEIUtils.areStacksSameType(stack, stack1) && 
/* 299 */         stack1.a != slot.a() && 
/* 300 */         stack1.a != stack1.c()) {
/*     */         
/* 302 */         moveOneItem(window, i, toSlot);
/* 303 */         return true;
/*     */       }  }
/*     */ 
/*     */     
/* 307 */     for (iterator = ((LinkedList<Integer>)this.slotZones.get(zone)).iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*     */       
/* 309 */       if (i == toSlot) {
/*     */         continue;
/*     */       }
/* 312 */       yu slot = window.d.b(i);
/* 313 */       aan stack1 = slot.b();
/*     */       
/* 315 */       if (NEIUtils.areStacksSameType(stack, stack1)) {
/*     */         
/* 317 */         moveOneItem(window, i, toSlot);
/* 318 */         return true;
/*     */       }  }
/*     */     
/* 321 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clickSlot(gb window, int slotIndex) {
/* 326 */     clickSlot(window, slotIndex, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clickSlot(gb window, int slotIndex, int button) {
/* 331 */     clickSlot(window, slotIndex, button, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clickSlot(gb window, int slotIndex, int button, boolean shift) {
/* 336 */     dd container = window.d;
/* 337 */     yu slot = null;
/* 338 */     if (slotIndex >= 0 && slotIndex < container.e.size()) {
/* 339 */       slot = container.b(slotIndex);
/*     */     }
/* 341 */     window.clickSlot(slot, slotIndex, button, shift);
/*     */   }
/*     */   
/*     */   public boolean fillZoneWithHeldItem(gb window, int zoneIndex) {
/*     */     Iterator<Integer> iterator;
/* 346 */     for (iterator = ((LinkedList)this.slotZones.get(zoneIndex)).iterator(); iterator.hasNext(); ) { int transferTo = ((Integer)iterator.next()).intValue();
/*     */       
/* 348 */       aan held = NEIUtils.getHeldItem();
/*     */       
/* 350 */       if (held == null) {
/*     */         break;
/*     */       }
/* 353 */       aan inToSlot = window.d.b(transferTo).b();
/*     */       
/* 355 */       if (!NEIUtils.areStacksSameType(inToSlot, held)) {
/*     */         continue;
/*     */       }
/* 358 */       clickSlot(window, transferTo); }
/*     */ 
/*     */     
/* 361 */     for (iterator = ((LinkedList<Integer>)this.slotZones.get(zoneIndex)).iterator(); iterator.hasNext(); ) { int transferTo = ((Integer)iterator.next()).intValue();
/*     */       
/* 363 */       aan held = NEIUtils.getHeldItem();
/*     */       
/* 365 */       if (held == null) {
/*     */         break;
/*     */       }
/* 368 */       aan inToSlot = window.d.b(transferTo).b();
/*     */       
/* 370 */       if (inToSlot != null) {
/*     */         continue;
/*     */       }
/* 373 */       clickSlot(window, transferTo); }
/*     */ 
/*     */     
/* 376 */     return (NEIUtils.getHeldItem() == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void throwAll(gb window, int pickedUpFromSlot) {
/* 381 */     aan held = NEIUtils.getHeldItem();
/* 382 */     if (held == null) {
/*     */       return;
/*     */     }
/* 385 */     clickSlot(window, -999);
/*     */     
/* 387 */     for (Iterator<Integer> iterator = ((LinkedList)this.slotZones.get(((Integer)this.slotZoneMap.get(Integer.valueOf(pickedUpFromSlot))).intValue())).iterator(); iterator.hasNext(); ) { int slotIndex = ((Integer)iterator.next()).intValue();
/*     */       
/* 389 */       yu slot = window.d.b(slotIndex);
/* 390 */       if (NEIUtils.areStacksSameType(held, slot.b())) {
/*     */         
/* 392 */         clickSlot(window, slotIndex);
/* 393 */         clickSlot(window, -999);
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\FastTransferManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */