/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import ady;
/*     */ import agd;
/*     */ import gh;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class DropDownWidget
/*     */   extends Widget
/*     */ {
/*     */   public DropDownWidget() {
/*  19 */     for (int i = 0; i < 7; i++) {
/*     */       
/*  21 */       this.stateButtons[i] = new RenameableButton("VIS", "vishash" + i);
/*  22 */       this.deleteButtons[i] = new Button("x", "visdelete" + i);
/*     */       
/*  24 */       (this.stateButtons[i]).height = 20;
/*  25 */       (this.deleteButtons[i]).width = 16;
/*  26 */       (this.deleteButtons[i]).height = 16;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/*  32 */     this.hoverItem = null;
/*  33 */     boolean mouseover = super.contains(mousex, mousey);
/*     */     
/*  35 */     texturedButtons = (NEIConfig.getLayoutStyle() == 0);
/*  36 */     if (!texturedButtons) {
/*     */       
/*  38 */       gui.drawRect(this.x, this.y, this.width, this.height, mouseover ? -297791480 : -301989888);
/*  39 */       gui.drawTextCentered(this.x, this.y, this.width, this.height, "Item SubSets", -1);
/*     */     }
/*     */     else {
/*     */       
/*  43 */       GL11.glDisable(2896);
/*  44 */       GL11.glBindTexture(3553, (gui.window.mc()).p.b("/gui/gui.png"));
/*  45 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  46 */       int tex = mouseover ? 2 : 1;
/*  47 */       gui.drawButtonBackground(this.x - 1, this.y, this.width + 2, this.height, true, tex);
/*     */       
/*  49 */       if (mouseover) {
/*     */         
/*  51 */         gui.drawTextCentered("Item SubSets", this.x + this.width / 2, this.y + (this.height - 8) / 2, 16777120);
/*     */       } else {
/*     */         
/*  54 */         gui.drawTextCentered("Item SubSets", this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
/*     */       } 
/*     */     } 
/*     */     
/*  58 */     if (getDropDown() == 1) {
/*     */       
/*  60 */       if (this.mouseovernamestack.size() == 0) {
/*     */         
/*  62 */         setDropDown(0);
/*     */         return;
/*     */       } 
/*  65 */       updateMouseOver(mousex, mousey);
/*  66 */       updatePosition(gui, mousex, mousey);
/*  67 */       this.file.draw(gui, mousex, mousey);
/*     */     }
/*  69 */     else if (getDropDown() == 2) {
/*     */       
/*  71 */       updateStatePosition(gui);
/*  72 */       drawStateButtons(gui, mousex, mousey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawStateButtons(GuiManager gui, int mousex, int mousey) {
/*  78 */     for (int i = 0; i < 7; i++) {
/*     */       
/*  80 */       this.stateButtons[i].draw(gui, mousex, mousey);
/*  81 */       this.deleteButtons[i].draw(gui, mousex, mousey);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateStatePosition(GuiManager gui) {
/*  87 */     int maxWidth = 0;
/*  88 */     for (int i = 0; i < 7; i++) {
/*     */       int k;
/*  90 */       (this.deleteButtons[i]).x = -1000;
/*  91 */       (this.stateButtons[i]).y = this.height + 2 + 22 * i;
/*     */       
/*  93 */       ady hashSave = NEIConfig.saveCompound.m("vis");
/*  94 */       NEIConfig.saveCompound.a("vis", (gh)hashSave);
/*     */       
/*  96 */       ady statelist = hashSave.m("statename");
/*  97 */       hashSave.a("statename", (gh)statelist);
/*     */       
/*  99 */       String name = statelist.j(i);
/* 100 */       if (statelist.b(i) == null) {
/*     */         
/* 102 */         k = i + 1;
/* 103 */         statelist.a(i, k);
/*     */       } 
/* 105 */       (this.stateButtons[i]).label = String.valueOf(ItemVisibilityHash.isStateSaved(i) ? "Load " : "Save ") + k;
/*     */       
/* 107 */       int buttonw = gui.getTextWidth((this.stateButtons[i]).label) + 26;
/* 108 */       if (buttonw + 22 > this.width)
/*     */       {
/* 110 */         buttonw = this.width - 22;
/*     */       }
/* 112 */       if (buttonw > maxWidth)
/*     */       {
/* 114 */         maxWidth = buttonw;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     int buttonx = this.x + (this.width - maxWidth + 20) / 2;
/*     */     
/* 120 */     for (int j = 0; j < 7; j++) {
/*     */       
/* 122 */       (this.stateButtons[j]).width = maxWidth;
/* 123 */       (this.stateButtons[j]).x = buttonx;
/* 124 */       if (ItemVisibilityHash.isStateSaved(j)) {
/*     */         
/* 126 */         (this.deleteButtons[j]).x = (this.stateButtons[j]).x + maxWidth + 2;
/* 127 */         (this.deleteButtons[j]).y = (this.stateButtons[j]).y + 2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateMouseOver(int mousex, int mousey) {
/* 134 */     String newmouseover = this.file.updateMouseOver(mousex, mousey, this.mouseovernamestack.get(0));
/* 135 */     if (!this.mouseoverTickRecorded) {
/*     */       
/* 137 */       if (this.canChangeMouseOver) {
/*     */         
/* 139 */         String prevmouseover = this.mouseovernamestack.get(this.mouseovernamestack.size() - 1);
/* 140 */         String currentmouseover = this.mouseovernamestack.get(0);
/* 141 */         if (!newmouseover.equals(prevmouseover))
/*     */         {
/* 143 */           for (int i = 0; i < this.mouseovernamestack.size(); i++)
/*     */           {
/* 145 */             this.mouseovernamestack.set(i, currentmouseover);
/*     */           }
/*     */         }
/* 148 */         this.mouseovernamestack.add(newmouseover);
/*     */       }
/*     */       else {
/*     */         
/* 152 */         this.mouseovernamestack.add(this.mouseovernamestack.get(this.mouseovernamestack.size() - 1));
/*     */       } 
/* 154 */       this.mouseoverTickRecorded = true;
/*     */     } 
/* 156 */     if (((String)this.mouseovernamestack.get(0)).equals("") && !LayoutManager.dropDown.contains(mousex, mousey))
/*     */     {
/* 158 */       setDropDown(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void updatePosition(GuiManager gui, int mousex, int mousey) {
/* 164 */     rehashMaxHeight(gui);
/*     */     
/*     */     while (true) {
/* 167 */       this.droppedwidth = 0;
/* 168 */       this.file.position(this.x + this.relx, this.y + this.height);
/*     */       
/* 170 */       if (this.droppedwidth > this.width) {
/*     */         
/* 172 */         int levelwidth = this.file.getWidthAtLevel(this.hiddenlevel);
/*     */         
/* 174 */         if (mousex - levelwidth < this.x)
/*     */         {
/* 176 */           levelwidth = this.droppedwidth - this.width;
/*     */         }
/*     */         
/* 179 */         moveMouse(gui.window.mc(), -levelwidth, 0);
/* 180 */         mousex -= levelwidth;
/*     */         
/* 182 */         this.relx -= levelwidth;
/* 183 */         this.hiddenstack.addLast(Integer.valueOf(levelwidth));
/* 184 */         this.hiddenlevel++; continue;
/*     */       } 
/* 186 */       if (this.relx < 0 && this.width - this.droppedwidth > ((Integer)this.hiddenstack.getLast()).intValue()) {
/*     */         
/* 188 */         int levelwidth = ((Integer)this.hiddenstack.getLast()).intValue();
/*     */         
/* 190 */         if (!((String)this.mouseovernamestack.get(0)).equals("")) {
/*     */           
/* 192 */           moveMouse(gui.window.mc(), levelwidth, 0);
/* 193 */           mousex += levelwidth;
/*     */         } 
/*     */         
/* 196 */         this.relx += levelwidth;
/* 197 */         this.hiddenstack.removeLast();
/* 198 */         this.hiddenlevel--;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void moveMouse(Minecraft mc, int relx, int rely) {
/* 209 */     agd sres = new agd(mc.A, mc.d, mc.e);
/* 210 */     Mouse.setCursorPosition(Mouse.getX() + relx * mc.d / sres.a(), Mouse.getY() + rely * mc.e / sres.b());
/*     */   }
/*     */ 
/*     */   
/*     */   private void rehashMaxHeight(GuiManager gui) {
/* 215 */     this.maxheight = gui.window.r - this.height - this.y - 25;
/* 216 */     this.maxheight = this.maxheight / 18 * 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleClick(int mousex, int mousey, int button) {
/* 221 */     if (super.contains(mousex, mousey)) {
/*     */       
/* 223 */       if (button == 0) {
/*     */         
/* 225 */         if (System.currentTimeMillis() - this.lastclicktime < 300L) {
/*     */           
/* 227 */           this.file.showAllItems();
/* 228 */           this.file.updateState();
/* 229 */           NEIUtils.loadItems();
/* 230 */           NEIConfig.vishash.save();
/*     */         } 
/* 232 */         setDropDown(1);
/* 233 */         this.lastclicktime = System.currentTimeMillis();
/*     */       }
/* 235 */       else if (button == 1) {
/*     */         
/* 237 */         if (getDropDown() == 2) {
/*     */           
/* 239 */           setDropDown(0);
/*     */         }
/*     */         else {
/*     */           
/* 243 */           setDropDown(2);
/*     */         } 
/*     */       } 
/* 246 */       return true;
/*     */     } 
/* 248 */     if (getDropDown() == 1)
/*     */     {
/* 250 */       return this.file.click(mousex, mousey, button);
/*     */     }
/* 252 */     if (getDropDown() == 2)
/*     */     {
/* 254 */       return processStateClick(mousex, mousey, button);
/*     */     }
/*     */     
/* 257 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean processStateClick(int mousex, int mousey, int button) {
/* 262 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 264 */       if ((this.stateButtons[i].contains(mousex, mousey) && this.stateButtons[i].handleClick(mousex, mousey, button)) || (
/* 265 */         this.deleteButtons[i].contains(mousex, mousey) && this.deleteButtons[i].handleClick(mousex, mousey, button)))
/*     */       {
/* 267 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 271 */     setDropDown(0);
/* 272 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleKeyPress(int keyID, char keyChar) {
/* 277 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 279 */       if (this.stateButtons[i].handleKeyPress(keyID, keyChar))
/*     */       {
/* 281 */         return true;
/*     */       }
/*     */     } 
/* 284 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClick(int mousex, int mousey) {
/* 289 */     if (getDropDown() == 2) {
/*     */       
/* 291 */       for (int i = 0; i < 7; i++)
/*     */       {
/* 293 */         this.stateButtons[i].onGuiClick(mousex, mousey);
/*     */       }
/* 295 */       if (!contains(mousex, mousey))
/*     */       {
/* 297 */         setDropDown(0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseUp(int mousex, int mousey, int button) {
/* 304 */     if (getDropDown() == 1) this.file.mouseUp(mousex, mousey, button);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean contains(int mousex, int mousey) {
/* 309 */     if (!super.contains(mousex, mousey) && (
/* 310 */       getDropDown() != 1 || !this.file.contains(mousex, mousey)) && (
/* 311 */       getDropDown() != 2 || !statesContain(mousex, mousey))) return false; 
/*     */     return true;
/*     */   }
/*     */   
/*     */   private boolean statesContain(int mousex, int mousey) {
/* 316 */     for (int i = 0; i < 7; i++) {
/*     */       
/* 318 */       if (this.stateButtons[i].contains(mousex, mousey) || this.deleteButtons[i].contains(mousex, mousey))
/*     */       {
/* 320 */         return true;
/*     */       }
/*     */     } 
/* 323 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onMouseWheel(int i, int mousex, int mousey) {
/* 328 */     if (getDropDown() == 1) {
/*     */       
/* 330 */       this.file.onMouseWheel(i);
/* 331 */       return true;
/*     */     } 
/* 333 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHoverItem(aan item) {
/* 338 */     this.hoverItem = item;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(GuiManager gui) {
/* 343 */     if (getDropDown() == 1) {
/*     */       
/* 345 */       if (this.mouseovernamestack.size() == 0) {
/*     */         
/* 347 */         setDropDown(0);
/*     */         return;
/*     */       } 
/* 350 */       this.mouseovernamestack.remove(0);
/* 351 */       if (!this.mouseoverTickRecorded)
/*     */       {
/* 353 */         this.mouseovernamestack.add(this.mouseovernamestack.get(this.mouseovernamestack.size() - 1));
/*     */       }
/* 355 */       this.mouseoverTickRecorded = false;
/*     */     }
/* 357 */     else if (getDropDown() == 2) {
/*     */       
/* 359 */       for (int i = 0; i < 7; i++)
/*     */       {
/* 361 */         this.stateButtons[i].update(gui);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDropDown(int drop) {
/* 368 */     if (drop == 1) {
/*     */       
/* 370 */       this.mouseoverTickRecorded = false;
/* 371 */       this.mouseovernamestack.clear();
/* 372 */       for (int i = 0; i < 4; i++)
/*     */       {
/* 374 */         this.mouseovernamestack.add("");
/*     */       }
/*     */     } 
/* 377 */     this.dropDowna = drop;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDropDown() {
/* 382 */     return this.dropDowna;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public aan getStackMouseOver(int mousex, int mousey) {
/* 388 */     return this.hoverItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List handleTooltip(int mx, int my, List tooltip) {
/* 394 */     if (this.hoverItem != null)
/* 395 */       return NEIUtils.itemDisplayNameMultiline(this.hoverItem, NEIConfig.showIDs()); 
/* 396 */     return tooltip;
/*     */   }
/*     */   
/* 399 */   public DropDownFile file = DropDownFile.dropDownInstance;
/*     */   private int dropDowna;
/*     */   private long lastclicktime;
/* 402 */   private ArrayList mouseovernamestack = new ArrayList();
/*     */   
/*     */   private boolean mouseoverTickRecorded;
/*     */   public boolean canChangeMouseOver = true;
/*     */   public aan hoverItem;
/* 407 */   public RenameableButton[] stateButtons = new RenameableButton[7];
/* 408 */   public Button[] deleteButtons = new Button[7];
/*     */   
/*     */   public int maxheight;
/*     */   public int droppedwidth;
/*     */   private int relx;
/*     */   private int hiddenlevel;
/* 414 */   private LinkedList hiddenstack = new LinkedList();
/*     */   public static boolean texturedButtons;
/*     */   private static final int stacklatency = 4;
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\DropDownWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */