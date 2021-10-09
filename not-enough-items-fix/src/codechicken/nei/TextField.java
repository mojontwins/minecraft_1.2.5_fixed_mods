/*     */ package codechicken.nei;
/*     */ 
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import vp;
/*     */ import xn;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TextField
/*     */   extends Widget
/*     */ {
/*     */   public boolean centered;
/*     */   public long backdowntime;
/*     */   public int backs;
/*     */   public String text;
/*     */   public String identifier;
/*     */   public int cursorCounter;
/*     */   
/*     */   public TextField(String ident) {
/* 171 */     this.text = "";
/*     */     this.identifier = ident;
/*     */   }
/*     */   
/*     */   public int getTextColour() {
/*     */     return focused() ? -2039584 : -7303024;
/*     */   }
/*     */   
/*     */   public void drawBox(GuiManager gui) {
/*     */     gui.drawRect(this.x, this.y, this.width, this.height, -6250336);
/*     */     gui.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2, -16777216);
/*     */   }
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/*     */     drawBox(gui);
/*     */     String drawtext = this.text;
/*     */     if (this.text.length() > getMaxTextLength())
/*     */       drawtext = drawtext.substring(drawtext.length() - getMaxTextLength()); 
/*     */     if (focused())
/*     */       if (this.cursorCounter / 6 % 2 == 0)
/*     */         drawtext = String.valueOf(drawtext) + '_';  
/*     */     int textWidth = gui.getTextWidth(this.text);
/*     */     int textx = this.centered ? (this.x + (this.width - textWidth) / 2) : (this.x + 4);
/*     */     int texty = this.y + (this.height + 1) / 2 - 3;
/*     */     gui.drawText(textx, texty, drawtext, getTextColour());
/*     */   }
/*     */   
/*     */   public void onGuiClick(int mousex, int mousey) {
/*     */     if (!contains(mousex, mousey))
/*     */       setFocus(false); 
/*     */   }
/*     */   
/*     */   public boolean handleClick(int mousex, int mousey, int button) {
/*     */     if (button == 1) {
/*     */       this.text = "";
/*     */       NEIController.onTextChange(this.text, this.identifier);
/*     */     } 
/*     */     setFocus(true);
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean handleKeyPress(int keyID, char keyChar) {
/*     */     if (LayoutManager.getInputFocused() != this)
/*     */       return false; 
/*     */     if (keyID == 14) {
/*     */       if (this.text.length() > 0) {
/*     */         this.text = this.text.substring(0, this.text.length() - 1);
/*     */         NEIController.onTextChange(this.text, this.identifier);
/*     */         this.backdowntime = System.currentTimeMillis();
/*     */       } 
/*     */     } else if (keyID == 28) {
/*     */       setFocus(false);
/*     */       NEIController.onTextSet(this.text, this.identifier);
/*     */     } else if (keyChar == '\026') {
/*     */       String pastestring = vp.h();
/*     */       if (pastestring == null)
/*     */         pastestring = ""; 
/*     */       if (isValid(String.valueOf(this.text) + pastestring)) {
/*     */         this.text = String.valueOf(this.text) + pastestring;
/*     */         NEIController.onTextChange(this.text, this.identifier);
/*     */       } 
/*     */     } else if (isValid(String.valueOf(this.text) + keyChar)) {
/*     */       this.text = String.valueOf(this.text) + keyChar;
/*     */       NEIController.onTextChange(this.text, this.identifier);
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean isValid(String string) {
/*     */     return (xn.a.indexOf(string.charAt(string.length() - 1)) >= 0);
/*     */   }
/*     */   
/*     */   public void update(GuiManager gui) {
/*     */     this.cursorCounter++;
/*     */     if (this.backdowntime > 0L)
/*     */       if (Keyboard.isKeyDown(14) && this.text.length() > 0) {
/*     */         if ((float)(System.currentTimeMillis() - this.backdowntime) > 200.0F / (1.0F + this.backs * 0.3F)) {
/*     */           this.text = this.text.substring(0, this.text.length() - 1);
/*     */           NEIController.onTextChange(this.text, this.identifier);
/*     */           this.backdowntime = System.currentTimeMillis();
/*     */           this.backs++;
/*     */         } 
/*     */       } else {
/*     */         this.backdowntime = 0L;
/*     */         this.backs = 0;
/*     */       }  
/*     */   }
/*     */   
/*     */   public void setText(String s) {
/*     */     this.text = s;
/*     */     NEIController.onTextChange(this.text, this.identifier);
/*     */   }
/*     */   
/*     */   private int getMaxTextLength() {
/*     */     return this.width / 6 - 2;
/*     */   }
/*     */   
/*     */   public void setFocus(boolean focus) {
/*     */     if (focus) {
/*     */       LayoutManager.setInputFocused(this);
/*     */     } else if (focused()) {
/*     */       LayoutManager.setInputFocused(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean focused() {
/*     */     return (LayoutManager.getInputFocused() == this);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TextField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */