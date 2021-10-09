/*     */ package codechicken.nei;
/*     */ 
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import vp;
/*     */ import xn;
/*     */ 
/*     */ public class RenameableButton extends Button {
/*     */   long backdowntime;
/*     */   int backs;
/*     */   
/*     */   public RenameableButton(String s, String ident) {
/*  12 */     super(s, ident);
/*     */   }
/*     */   int cursorCounter; boolean focused;
/*     */   
/*     */   public boolean handleClick(int mousex, int mousey, int button) {
/*  17 */     if (button == 1) {
/*     */       
/*  19 */       this.label = this.label.substring(0, 5);
/*  20 */       NEIController.onTextChange(this.label, this.identifier);
/*  21 */       this.focused = true;
/*  22 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  26 */     return super.handleClick(mousex, mousey, button);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClick(int i, int j) {
/*  32 */     if (!contains(i, j))
/*     */     {
/*  34 */       this.focused = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleKeyPress(int keyID, char keyChar) {
/*  40 */     if (!this.focused) return false;
/*     */     
/*  42 */     if (keyID == 14) {
/*     */       
/*  44 */       if (this.label.length() > 5)
/*     */       {
/*  46 */         this.label = this.label.substring(0, this.label.length() - 1);
/*  47 */         NEIController.onTextChange(this.label, this.identifier);
/*  48 */         this.backdowntime = System.currentTimeMillis();
/*     */       }
/*     */     
/*  51 */     } else if (keyID == 28) {
/*     */       
/*  53 */       this.focused = false;
/*  54 */       NEIController.onTextSet(this.label, this.identifier);
/*     */     }
/*  56 */     else if (keyChar == '\026') {
/*     */       
/*  58 */       String pastestring = vp.h();
/*  59 */       if (pastestring == null)
/*     */       {
/*  61 */         pastestring = "";
/*     */       }
/*     */       
/*  64 */       this.label = String.valueOf(this.label) + pastestring;
/*  65 */       NEIController.onTextChange(this.label, this.identifier);
/*     */     }
/*  67 */     else if (xn.a.indexOf(keyChar) >= 0) {
/*     */       
/*  69 */       this.label = String.valueOf(this.label) + keyChar;
/*  70 */       NEIController.onTextChange(this.label, this.identifier);
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(GuiManager gui) {
/*  77 */     this.cursorCounter++;
/*  78 */     if (this.backdowntime > 0L)
/*     */     {
/*  80 */       if (Keyboard.isKeyDown(14) && this.label.length() > 5) {
/*     */         
/*  82 */         if ((float)(System.currentTimeMillis() - this.backdowntime) > 200.0F / (1.0F + this.backs * 0.3F))
/*     */         {
/*  84 */           this.label = this.label.substring(0, this.label.length() - 1);
/*  85 */           NEIController.onTextChange(this.label, this.identifier);
/*  86 */           this.backdowntime = System.currentTimeMillis();
/*  87 */           this.backs++;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  92 */         this.backdowntime = 0L;
/*  93 */         this.backs = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(GuiManager gui, int mousex, int mousey) {
/* 100 */     super.draw(gui, mousex, mousey);
/* 101 */     if (this.focused)
/*     */     {
/* 103 */       if (this.cursorCounter / 6 % 2 == 0)
/*     */       {
/* 105 */         gui.drawText(this.x + (this.width + gui.getTextWidth(this.label)) / 2, this.y + (this.height - 8) / 2, "_", -1);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\RenameableButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */