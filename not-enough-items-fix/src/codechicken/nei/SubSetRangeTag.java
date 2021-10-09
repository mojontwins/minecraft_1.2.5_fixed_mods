/*     */ package codechicken.nei;
/*     */ 
/*     */ import ady;
/*     */ import codechicken.core.ConfigTag;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class SubSetRangeTag extends ConfigTag {
/*     */   public ArrayList sortedtags;
/*     */   public boolean saveTag;
/*     */   public MultiItemRange validranges;
/*     */   public byte state;
/*     */   public int slotwidth;
/*     */   public boolean hasscroll;
/*     */   protected int scrollclicky;
/*     */   protected float scrollpercent;
/*     */   protected int scrollmousey;
/*     */   protected float percentscrolled;
/*     */   
/*  21 */   public SubSetRangeTag(DropDownFile parent, String name) { super(parent, name);
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
/* 896 */     this.sortedtags = new ArrayList();
/* 897 */     this.saveTag = true;
/*     */ 
/*     */ 
/*     */     
/* 901 */     this.slotwidth = 0;
/*     */ 
/*     */     
/* 904 */     this.scrollclicky = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 909 */     this.lastslotclicked = -1; } protected int lastslotclicked; protected long lastslotclicktime; int x; int y; int height; int width; int contentheight; public boolean expanded; public boolean hidden; private static final int slotheight = 18; public SubSetRangeTag(SubSetRangeTag parent, String name) { super(parent, name); this.sortedtags = new ArrayList(); this.saveTag = true; this.slotwidth = 0; this.scrollclicky = -1; this.lastslotclicked = -1;
/*     */     this.saveTag = !(!parent.saveTag && !ConfigFile.loading); }
/*     */ 
/*     */   
/*     */   public SubSetRangeTag getTag(String tagname) {
/*     */     return (SubSetRangeTag)super.getTag(tagname);
/*     */   }
/*     */   
/*     */   public SubSetRangeTag getTag(String tagname, boolean createnew) {
/*     */     return (SubSetRangeTag)super.getTag(tagname, createnew);
/*     */   }
/*     */   
/*     */   public SubSetRangeTag getNewTag(String name) {
/*     */     return new SubSetRangeTag(this, name);
/*     */   }
/*     */   
/*     */   public void setDefaultValue(MultiItemRange range) {
/*     */     if (this.value == null)
/*     */       setRange(range); 
/*     */   }
/*     */   
/*     */   public void setValue(String value) {
/*     */     this.value = value;
/*     */     if (this.saveTag)
/*     */       this.parentfile.saveConfig(); 
/*     */     if (this.validranges == null)
/*     */       this.validranges = new MultiItemRange(value); 
/*     */   }
/*     */   
/*     */   public void setRange(MultiItemRange range) {
/*     */     this.validranges = range;
/*     */     setValue(this.validranges.toString());
/*     */   }
/*     */   
/*     */   public MultiItemRange getRange() {
/*     */     return this.validranges;
/*     */   }
/*     */   
/*     */   public boolean thisContains(int mousex, int mousey) {
/*     */     if (mousex >= this.x && mousex < this.x + this.width && mousey >= this.y && mousey < this.y + this.height)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean contains(int mousex, int mousey) {
/*     */     if (!this.expanded)
/*     */       return false; 
/*     */     if (thisContains(mousex, mousey))
/*     */       return true; 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (stag.contains(mousex, mousey))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int getNumSlots() {
/*     */     return this.childtags.size() + ((this.validranges == null) ? 0 : this.validranges.getNumSlots());
/*     */   }
/*     */   
/*     */   public int getScrollBarWidth() {
/*     */     return 5;
/*     */   }
/*     */   
/*     */   public int getScrollBarHeight() {
/*     */     int sbarh = (int)(this.height / this.contentheight * this.height);
/*     */     if (sbarh > this.height)
/*     */       return this.height; 
/*     */     if (sbarh < this.height / 15)
/*     */       return this.height / 15; 
/*     */     return sbarh;
/*     */   }
/*     */   
/*     */   public int getScrolledSlots() {
/*     */     int slots = getNumSlots();
/*     */     int shownslots = this.height / 18;
/*     */     return (int)(this.percentscrolled * (slots - shownslots) + 0.5F);
/*     */   }
/*     */   
/*     */   private int getClickedSlot(int mousey) {
/*     */     return (mousey - this.y) / 18 + getScrolledSlots();
/*     */   }
/*     */   
/*     */   public void calculatePercentScrolled() {
/*     */     int barempty = this.height - getScrollBarHeight();
/*     */     if (this.scrollclicky >= 0) {
/*     */       int scrolldiff = this.scrollmousey - this.scrollclicky;
/*     */       this.percentscrolled = scrolldiff / barempty + this.scrollpercent;
/*     */     } 
/*     */     if (this.percentscrolled < 0.0F)
/*     */       this.percentscrolled = 0.0F; 
/*     */     if (this.percentscrolled > 1.0F)
/*     */       this.percentscrolled = 1.0F; 
/*     */     int sbary = this.y + (int)((barempty * this.percentscrolled) + 0.5D);
/*     */     this.percentscrolled = (sbary - this.y) / barempty;
/*     */   }
/*     */   
/*     */   public void processScrollMouse(int mousex, int mousey) {
/*     */     if (this.scrollclicky >= 0) {
/*     */       int scrolldiff = mousey - this.scrollclicky;
/*     */       int barupallowed = (int)(((this.height - getScrollBarHeight()) * this.scrollpercent) + 0.5D);
/*     */       int bardownallowed = this.height - getScrollBarHeight() - barupallowed;
/*     */       if (-scrolldiff > barupallowed) {
/*     */         this.scrollmousey = this.scrollclicky - barupallowed;
/*     */       } else if (scrolldiff > bardownallowed) {
/*     */         this.scrollmousey = this.scrollclicky + bardownallowed;
/*     */       } else {
/*     */         this.scrollmousey = mousey;
/*     */       } 
/*     */       calculatePercentScrolled();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String updateMouseOver(int mousex, int mousey, String mouseovername) {
/*     */     this.expanded = !(!mouseovername.equals(this.qualifiedname) && (mouseovername.length() <= this.qualifiedname.length() || !mouseovername.startsWith(this.qualifiedname) || mouseovername.charAt(this.qualifiedname.length()) != '.'));
/*     */     if (!this.expanded) {
/*     */       this.scrollclicky = -1;
/*     */       return "";
/*     */     } 
/*     */     processScrollMouse(mousex, mousey);
/*     */     String currentmouseover = "";
/*     */     if (contains(mousex, mousey))
/*     */       currentmouseover = String.valueOf(this.qualifiedname) + "." + "-"; 
/*     */     int sloty = this.y;
/*     */     int slotx = this.x + (this.hasscroll ? getScrollBarWidth() : 0);
/*     */     int slot = 0;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       slot++;
/*     */       if (slot <= getScrolledSlots())
/*     */         continue; 
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (slotx <= mousex && this.x + this.width > mousex && sloty <= mousey && sloty + 18 > mousey)
/*     */         currentmouseover = stag.qualifiedname; 
/*     */       String s = stag.updateMouseOver(mousex, mousey, mouseovername);
/*     */       if (!s.equals(""))
/*     */         currentmouseover = s; 
/*     */       sloty += 18;
/*     */     } 
/*     */     int tagslots = slot;
/*     */     if (this.validranges != null)
/*     */       for (ItemRange range : this.validranges.ranges) {
/*     */         if (slot + range.encompasseditems.size() <= getScrolledSlots()) {
/*     */           slot += range.encompasseditems.size();
/*     */           continue;
/*     */         } 
/*     */         for (int item = 0; item < range.encompasseditems.size(); item++) {
/*     */           slot++;
/*     */           if (slot > getScrolledSlots()) {
/*     */             if (slotx <= mousex && this.x + this.width > mousex && sloty <= mousey && sloty + 18 > mousey) {
/*     */               currentmouseover = String.valueOf(this.qualifiedname) + "." + (slot - tagslots);
/*     */               break;
/*     */             } 
/*     */             sloty += 18;
/*     */             if (sloty >= this.y + this.height)
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */         if (sloty >= this.y + this.height)
/*     */           break; 
/*     */       }  
/*     */     return currentmouseover;
/*     */   }
/*     */   
/*     */   public boolean click(int mousex, int mousey, int button) {
/*     */     if (!this.expanded)
/*     */       return false; 
/*     */     boolean inbounds = thisContains(mousex, mousey);
/*     */     if (!inbounds)
/*     */       for (ConfigTag tag : this.sortedtags) {
/*     */         SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */         stag.click(mousex, mousey, button);
/*     */       }  
/*     */     int barempty = this.height - getScrollBarHeight();
/*     */     int sbary = this.y + (int)((barempty * this.percentscrolled) + 0.5D);
/*     */     int contentx = this.x + getScrollBarWidth();
/*     */     if (this.hasscroll && button == 0 && getScrollBarHeight() < this.height && mousex >= this.x && mousex < this.x + getScrollBarWidth() && mousey >= this.y && mousey < this.y + this.height) {
/*     */       if (mousey < sbary) {
/*     */         this.percentscrolled = (mousey - this.y) / barempty;
/*     */         calculatePercentScrolled();
/*     */       } else if (mousey > sbary + getScrollBarHeight()) {
/*     */         this.percentscrolled = (mousey - this.y - getScrollBarHeight() + 1) / barempty;
/*     */         calculatePercentScrolled();
/*     */       } else {
/*     */         this.scrollclicky = mousey;
/*     */         this.scrollpercent = this.percentscrolled;
/*     */         this.scrollmousey = mousey;
/*     */         LayoutManager.dropDown.canChangeMouseOver = false;
/*     */       } 
/*     */     } else if (mousex >= contentx && mousex < this.x + this.width && mousey >= this.y && mousey <= this.y + this.height) {
/*     */       int slot = getClickedSlot(mousey);
/*     */       if (slot == this.lastslotclicked && System.currentTimeMillis() - this.lastslotclicktime < 500L && button == 0) {
/*     */         slotClicked(slot, button, true);
/*     */       } else {
/*     */         slotClicked(slot, button, false);
/*     */       } 
/*     */       if (button == 0) {
/*     */         this.lastslotclicked = slot;
/*     */         this.lastslotclicktime = System.currentTimeMillis();
/*     */       } 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public void onMouseWheel(int i) {
/*     */     if (this.scrollclicky != -1)
/*     */       return; 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (stag.expanded) {
/*     */         stag.onMouseWheel(i);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     this.percentscrolled += i / this.contentheight * 100.0F;
/*     */     if (this.percentscrolled > 1.0F) {
/*     */       this.percentscrolled = 1.0F;
/*     */     } else if (this.percentscrolled < 0.0F) {
/*     */       this.percentscrolled = 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void slotClicked(int slot, int button, boolean doubleclick) {
/*     */     int i = 0;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       if (slot == i) {
/*     */         SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */         stag.onClick(button, doubleclick);
/*     */         return;
/*     */       } 
/*     */       i++;
/*     */     } 
/*     */     if (this.validranges != null)
/*     */       this.validranges.slotClicked(slot - i, button, doubleclick); 
/*     */   }
/*     */   
/*     */   public void onClick(int button, boolean doubleclick) {
/*     */     if (button == 0 && !doubleclick) {
/*     */       if (NEIUtils.shiftKey()) {
/*     */         LayoutManager.searchField.setText("@" + this.qualifiedname);
/*     */       } else {
/*     */         showAllItems();
/*     */       } 
/*     */     } else if (button == 0 && doubleclick) {
/*     */       DropDownFile.dropDownInstance.hideAllItems();
/*     */       showAllItems();
/*     */     } else if (button == 1) {
/*     */       hideAllItems();
/*     */     } 
/*     */     DropDownFile.dropDownInstance.updateState();
/*     */     NEIUtils.loadItems();
/*     */     NEIConfig.vishash.save();
/*     */   }
/*     */   
/*     */   public void hideAllItems() {
/*     */     if (this.validranges != null)
/*     */       this.validranges.hideAllItems(); 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.hideAllItems();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void showAllItems() {
/*     */     if (this.validranges != null)
/*     */       this.validranges.showAllItems(); 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.showAllItems();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mouseUp(int mousex, int mousey, int button) {
/*     */     if (this.scrollclicky >= 0 && button == 0) {
/*     */       this.scrollclicky = -1;
/*     */       LayoutManager.dropDown.canChangeMouseOver = true;
/*     */     } 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.mouseUp(mousex, mousey, button);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/*     */     if (!this.expanded)
/*     */       return; 
/*     */     drawScrollBar(gui);
/*     */     int drawy = this.y;
/*     */     int drawx = this.x + (this.hasscroll ? getScrollBarWidth() : 0);
/*     */     int slot = 0;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       slot++;
/*     */       if (slot <= getScrolledSlots())
/*     */         continue; 
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (!this.hidden)
/*     */         if (!DropDownWidget.texturedButtons) {
/*     */           boolean contains = (mousex >= drawx && mousex < drawx + this.slotwidth && mousey >= drawy && mousey < drawy + 18);
/*     */           gui.drawRect(drawx, drawy, this.slotwidth, 18, contains ? -12578808 : -16777216);
/*     */           gui.drawTextCentered(drawx, drawy, this.slotwidth, 18, stag.name, stag.getColourFromState(), (stag.state == 0));
/*     */         } else {
/*     */           GL11.glBindTexture(3553, (gui.window.mc()).p.b("/gui/gui.png"));
/*     */           if (stag.state == 1) {
/*     */             GL11.glColor4f(0.65F, 0.65F, 0.65F, 1.0F);
/*     */           } else {
/*     */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           } 
/*     */           int tex = (stag.state == 0) ? 0 : 1;
/*     */           gui.drawButtonBackground(drawx, drawy, this.slotwidth, 18, false, tex);
/*     */           int textcolour = (stag.state == 2) ? -2039584 : -6250336;
/*     */           gui.drawTextCentered(drawx, drawy, this.slotwidth, 18, stag.name, textcolour);
/*     */         }  
/*     */       stag.draw(gui, mousex, mousey);
/*     */       drawy += 18;
/*     */       if (drawy >= this.y + this.height)
/*     */         break; 
/*     */     } 
/*     */     if (this.validranges != null && drawy < this.y + this.height)
/*     */       for (ItemRange range : this.validranges.ranges) {
/*     */         if (slot + range.encompasseditems.size() <= getScrolledSlots()) {
/*     */           slot += range.encompasseditems.size();
/*     */           continue;
/*     */         } 
/*     */         for (int item = 0; item < range.encompasseditems.size(); item++) {
/*     */           slot++;
/*     */           if (slot > getScrolledSlots()) {
/*     */             ItemHash itemh = range.encompasseditems.get(item);
/*     */             int itemx = drawx + this.slotwidth / 2 - 8;
/*     */             int itemy = drawy + 1;
/*     */             boolean itemvisible = !NEIConfig.vishash.isItemHidden(itemh);
/*     */             if (!DropDownWidget.texturedButtons) {
/*     */               gui.drawRect(drawx, drawy, this.slotwidth, 18, itemvisible ? -16764928 : -13631488);
/*     */             } else {
/*     */               int tex = itemvisible ? 1 : 0;
/*     */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               gui.drawButtonBackground(drawx, drawy, this.slotwidth, 18, false, tex);
/*     */             } 
/*     */             aan stack = itemh.toStack();
/*     */             gui.drawItem(itemx, itemy, stack);
/*     */             if (itemx <= mousex && itemx + 16 > mousex && itemy + 1 <= mousey && itemy + 16 > mousey)
/*     */               LayoutManager.dropDown.setHoverItem(itemh.toStack()); 
/*     */             drawy += 18;
/*     */             if (drawy >= this.y + this.height)
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */         if (drawy >= this.y + this.height)
/*     */           break; 
/*     */       }  
/*     */   }
/*     */   
/*     */   private void drawScrollBar(GuiManager gui) {
/*     */     if (this.hasscroll && !this.hidden) {
/*     */       int sbary = this.y + (int)(((this.height - getScrollBarHeight()) * this.percentscrolled) + 0.5D);
/*     */       gui.drawRect(this.x, this.y, 5, this.height, -14671840);
/*     */       if (DropDownWidget.texturedButtons) {
/*     */         gui.drawRect(this.x, sbary, 5, getScrollBarHeight(), -7631989);
/*     */         gui.drawRect(this.x, sbary, 4, getScrollBarHeight() - 1, -986896);
/*     */         gui.drawRect(this.x + 1, sbary + 1, 4, getScrollBarHeight() - 1, -11184811);
/*     */         gui.drawRect(this.x + 1, sbary + 1, 3, getScrollBarHeight() - 2, -3750202);
/*     */       } else {
/*     */         gui.drawRect(this.x, sbary, 5, getScrollBarHeight(), -2039584);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void position(int px, int py) {
/*     */     this.x = px;
/*     */     this.y = py;
/*     */     recalcSize();
/*     */     if (!this.expanded)
/*     */       return; 
/*     */     int suby = this.y;
/*     */     int subx = this.x + this.width;
/*     */     int slot = 0;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       slot++;
/*     */       if (slot <= getScrolledSlots())
/*     */         continue; 
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.position(subx, suby);
/*     */       suby += 18;
/*     */       if (suby >= this.y + this.height)
/*     */         break; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void recalcSize() {
/*     */     int maxheight = LayoutManager.dropDown.y + LayoutManager.dropDown.maxheight + LayoutManager.dropDown.height - this.y;
/*     */     int extraheight = this.y - LayoutManager.dropDown.height;
/*     */     this.contentheight = getNumSlots() * 18;
/*     */     if (this.contentheight > maxheight)
/*     */       if (this.contentheight <= maxheight + extraheight) {
/*     */         this.y -= this.contentheight - maxheight;
/*     */         maxheight = this.contentheight;
/*     */       } else {
/*     */         this.y -= extraheight;
/*     */         maxheight += extraheight;
/*     */       }  
/*     */     if (this.contentheight > maxheight) {
/*     */       this.height = maxheight / 18 * 18;
/*     */       this.hasscroll = true;
/*     */     } else {
/*     */       this.hasscroll = false;
/*     */       this.height = this.contentheight;
/*     */     } 
/*     */     this.slotwidth = 0;
/*     */     nl fontRenderer = (ModLoader.getMinecraftInstance()).q;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       int tagwidth = fontRenderer.a(tag.name);
/*     */       if (tagwidth > this.slotwidth)
/*     */         this.slotwidth = tagwidth; 
/*     */     } 
/*     */     if (this.validranges != null) {
/*     */       int rangewidth = this.validranges.getWidth();
/*     */       if (rangewidth > this.slotwidth)
/*     */         this.slotwidth = rangewidth; 
/*     */     } 
/*     */     this.slotwidth += 2;
/*     */     this.width = this.slotwidth;
/*     */     if (this.hasscroll)
/*     */       this.width += getScrollBarWidth(); 
/*     */     int totalwidth = this.x + this.width - LayoutManager.dropDown.x;
/*     */     if (this.expanded && totalwidth > LayoutManager.dropDown.droppedwidth)
/*     */       LayoutManager.dropDown.droppedwidth = totalwidth; 
/*     */     this.hidden = (totalwidth <= 0);
/*     */   }
/*     */   
/*     */   public int getWidthAtLevel(int hiddenlevel) {
/*     */     if (!this.expanded)
/*     */       return 0; 
/*     */     if (hiddenlevel == 0)
/*     */       return this.width; 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       int subwidth = stag.getWidthAtLevel(hiddenlevel - 1);
/*     */       if (subwidth != 0)
/*     */         return subwidth; 
/*     */     } 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public void resetHashes() {
/*     */     if (this.validranges != null)
/*     */       this.validranges.resetHashes(); 
/*     */     this.sortedtags = ConfigFile.getSortedTagList(this.childtags);
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.resetHashes();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateState(ItemVisibilityHash vis) {
/*     */     boolean allshown = false;
/*     */     boolean allhidden = false;
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.updateState(vis);
/*     */     } 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (stag.state == 1) {
/*     */         this.state = 1;
/*     */         return;
/*     */       } 
/*     */       if (stag.state == 0) {
/*     */         if (allshown) {
/*     */           this.state = 1;
/*     */           return;
/*     */         } 
/*     */         allhidden = true;
/*     */         continue;
/*     */       } 
/*     */       if (allhidden) {
/*     */         this.state = 1;
/*     */         return;
/*     */       } 
/*     */       allshown = true;
/*     */     } 
/*     */     if (this.validranges != null) {
/*     */       this.validranges.updateState(vis);
/*     */       int rstate = this.validranges.state;
/*     */       if (rstate == 1) {
/*     */         this.state = 1;
/*     */         return;
/*     */       } 
/*     */       if (rstate == 0) {
/*     */         if (allshown) {
/*     */           this.state = 1;
/*     */           return;
/*     */         } 
/*     */         allhidden = true;
/*     */       } else {
/*     */         if (allhidden) {
/*     */           this.state = 1;
/*     */           return;
/*     */         } 
/*     */         allshown = true;
/*     */       } 
/*     */     } 
/*     */     if (allshown) {
/*     */       this.state = 2;
/*     */     } else {
/*     */       this.state = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addItemIfInRange(int item, int damage, ady compound) {
/*     */     if (this.validranges != null)
/*     */       this.validranges.addItemIfInRange(item, damage, compound); 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       stag.addItemIfInRange(item, damage, compound);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isItemInRange(int item, int damage) {
/*     */     if (this.validranges != null && this.validranges.isItemInRange(item, damage))
/*     */       return true; 
/*     */     for (ConfigTag tag : this.sortedtags) {
/*     */       SubSetRangeTag stag = (SubSetRangeTag)tag;
/*     */       if (stag.isItemInRange(item, damage))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int getColourFromState() {
/*     */     if (this.state == 0)
/*     */       return -10481648; 
/*     */     if (this.state == 1)
/*     */       return -8359824; 
/*     */     return -1;
/*     */   }
/*     */   
/*     */   public void setSave(boolean save) {
/*     */     this.saveTag = save;
/*     */     this.parentfile.saveConfig();
/*     */   }
/*     */   
/*     */   public void save(PrintWriter writer, int tabs, String bracequalifier) {
/*     */     if (this.saveTag) {
/*     */       super.save(writer, tabs, bracequalifier);
/*     */     } else if (this.childtags.size() > 0) {
/*     */       ConfigFile.saveTagTree(writer, this.childtags, tabs, bracequalifier);
/*     */     } 
/*     */   }
/*     */   
/*     */   public SubSetRangeTag useBraces() {
/*     */     return (SubSetRangeTag)super.useBraces();
/*     */   }
/*     */   
/*     */   public SubSetRangeTag setComment(String string) {
/*     */     return (SubSetRangeTag)super.setComment(string);
/*     */   }
/*     */   
/*     */   public SubSetRangeTag setPosition(int pos) {
/*     */     this.position = pos;
/*     */     if (this.saveTag)
/*     */       this.parentfile.saveConfig(); 
/*     */     return this;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     return this.qualifiedname;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\SubSetRangeTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */