/*     */ package codechicken.nei;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class Button extends Widget {
/*     */   public String label;
/*     */   public String identifier;
/*     */   
/*     */   public Button(String s, String ident) {
/*  11 */     this.label = s;
/*  12 */     this.identifier = ident;
/*     */   }
/*     */   public Image icon; public boolean iconHighlight; public int state;
/*     */   
/*     */   public Button(String ident) {
/*  17 */     this.label = "";
/*  18 */     this.identifier = ident;
/*     */   }
/*     */ 
/*     */   
/*     */   public int contentWidth(GuiManager gui) {
/*  23 */     int textw = (getRenderIcon() == null) ? gui.getTextWidth(this.label) : (getRenderIcon()).width;
/*  24 */     if (NEIConfig.getLayoutStyle() == 0) {
/*     */       
/*  26 */       textw += 4;
/*     */     }
/*  28 */     else if ((this.state & 0x4) != 0) {
/*     */       
/*  30 */       textw += stateOff.width;
/*     */     } 
/*  32 */     return textw;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOwnWidth(GuiManager gui) {
/*  37 */     this.width = contentWidth(gui) + getMargin();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMargin() {
/*  42 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/*  47 */     boolean mouseover = contains(mousex, mousey);
/*  48 */     Image renderIcon = getRenderIcon();
/*  49 */     if (NEIConfig.getLayoutStyle() == 1) {
/*     */       
/*  51 */       int cwidth = contentWidth(gui);
/*  52 */       int textx = this.x + (this.width - cwidth) / 2;
/*  53 */       int texty = this.y + (this.height - 8) / 2;
/*     */       
/*  55 */       gui.drawRect(this.x, this.y, this.width, this.height, contains(mousex, mousey) ? -297791480 : -301989888);
/*     */       
/*  57 */       if (renderIcon == null) {
/*     */         
/*  59 */         gui.drawText(textx, texty, this.label, -1);
/*     */       }
/*     */       else {
/*     */         
/*  63 */         int icony = this.y + (this.height - renderIcon.height) / 2;
/*  64 */         gui.drawIcon(textx, icony, renderIcon);
/*  65 */         if ((this.state & 0x3) == 2) {
/*  66 */           gui.drawRect(textx, icony, renderIcon.width, renderIcon.height, -2147483648);
/*     */         }
/*  68 */         if ((this.state & 0x4) != 0) {
/*     */           Image stateimage;
/*     */           
/*  71 */           if ((this.state & 0x3) == 1) {
/*  72 */             stateimage = stateOn;
/*  73 */           } else if ((this.state & 0x3) == 2) {
/*  74 */             stateimage = stateDisabled;
/*     */           } else {
/*  76 */             stateimage = stateOff;
/*  77 */           }  gui.drawIcon(textx + renderIcon.width, icony, stateimage);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       int tex;
/*     */       
/*  83 */       GL11.glDisable(2896);
/*  84 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */       
/*  87 */       if ((this.state & 0x3) == 1) {
/*  88 */         tex = 2;
/*  89 */       } else if ((this.state & 0x3) == 2) {
/*  90 */         tex = 0;
/*     */       } else {
/*  92 */         tex = 1;
/*  93 */       }  gui.drawButtonBackground(this.x, this.y, this.width, this.height, true, tex);
/*     */       
/*  95 */       if (renderIcon == null) {
/*     */         
/*  97 */         if ((mouseover && (this.state & 0x3) != 2) || (this.state & 0x3) == 1)
/*     */         {
/*  99 */           gui.drawTextCentered(this.label, this.x + this.width / 2, this.y + (this.height - 8) / 2, 16777120);
/*     */         }
/* 101 */         else if ((this.state & 0x3) == 2)
/*     */         {
/* 103 */           gui.drawTextCentered(this.label, this.x + this.width / 2, this.y + (this.height - 8) / 2, 6295568);
/*     */         }
/*     */         else
/*     */         {
/* 107 */           gui.drawTextCentered(this.label, this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 112 */         if (!this.iconHighlight)
/*     */         {
/* 114 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         }
/* 116 */         int iconx = this.x + (this.width - this.icon.width) / 2;
/* 117 */         int icony = this.y + (this.height - this.icon.height) / 2;
/* 118 */         gui.drawIcon(iconx, icony, renderIcon);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleClick(int i, int j, int k) {
/* 126 */     if (k == 1 || k == 0)
/* 127 */       NEIController.onButtonPress(this.identifier, (k == 1)); 
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Image getRenderIcon() {
/* 133 */     return this.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List handleTooltip(int mx, int my, List<String> tooltip) {
/* 139 */     if (!contains(mx, my)) {
/* 140 */       return tooltip;
/*     */     }
/* 142 */     String tip = NEIController.getButtonTip(this);
/* 143 */     if (tip != null)
/* 144 */       tooltip.add(tip); 
/* 145 */     return tooltip;
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
/* 161 */   public static final Image stateOff = new Image(48, 0, 8, 12);
/* 162 */   public static final Image stateOn = new Image(56, 0, 8, 12);
/* 163 */   public static final Image stateDisabled = new Image(64, 0, 8, 12);
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\Button.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */