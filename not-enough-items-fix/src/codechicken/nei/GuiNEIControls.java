/*     */ package codechicken.nei;
/*     */ 
/*     */ import abp;
/*     */ import gb;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import z;
/*     */ 
/*     */ public class GuiNEIControls
/*     */   extends GuiNEIOptions
/*     */ {
/*     */   int focusedButton;
/*     */   public List keyBinds;
/*     */   
/*     */   public static class NEIKeyBind {
/*     */     String ident;
/*     */     String desc;
/*     */     
/*     */     public NEIKeyBind(String s, String s1) {
/*  23 */       this.ident = s;
/*  24 */       this.desc = s1;
/*     */     }
/*     */   }
/*     */   
/*     */   public GuiNEIControls(gb parentContainer)
/*     */   {
/*  30 */     super(parentContainer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.focusedButton = -1;
/* 144 */     this.keyBinds = new ArrayList();
/*     */     this.keyBinds = getOptionList();
/* 146 */   } static HashMap keyBindMap = new HashMap<Object, Object>();
/*     */   
/*     */   public void c() {
/*     */     for (int i = 0; i < this.keyBinds.size(); i++)
/*     */       this.s.add(new z(i, this.q / 2 - 155 + i % 2 * 160, this.r / 6 + 24 * (i >> 1), 70, 20, "")); 
/*     */     super.c();
/*     */   }
/*     */   
/*     */   public String getBackButtonName() {
/*     */     return "Settings";
/*     */   }
/*     */   
/*     */   public void onBackButtonClick() {
/*     */     this.p.a(new GuiNEISettings(this.parentScreen));
/*     */   }
/*     */   
/*     */   private boolean doesButtonClash(String ident) {
/*     */     int buttonID = NEIConfig.getKeyBinding(ident);
/*     */     if (buttonID == this.p.A.s.d)
/*     */       return true; 
/*     */     for (NEIKeyBind key : this.keyBinds) {
/*     */       if (!ident.equals(key.ident) && buttonID == NEIConfig.getKeyBinding(key.ident))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void updateButtonNames() {
/*     */     for (int i = 0; i < this.keyBinds.size(); i++) {
/*     */       abp button = this.s.get(i);
/*     */       String name = ((NEIKeyBind)this.keyBinds.get(i)).ident;
/*     */       int keyCode = NEIConfig.getKeyBinding(name);
/*     */       if (this.focusedButton == i) {
/*     */         button.e = "§f> §e??? §f<";
/*     */       } else if (doesButtonClash(name)) {
/*     */         button.e = "§c" + Keyboard.getKeyName(keyCode);
/*     */       } else {
/*     */         button.e = Keyboard.getKeyName(keyCode);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(abp guibutton) {
/*     */     if (guibutton.f < this.keyBinds.size()) {
/*     */       this.focusedButton = guibutton.f;
/*     */       updateButtonNames();
/*     */     } else {
/*     */       super.a(guibutton);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(char keyChar, int keyID) {
/*     */     if (this.focusedButton >= 0 && keyID != 1) {
/*     */       NEIConfig.setKeyBinding(((NEIKeyBind)this.keyBinds.get(this.focusedButton)).ident, keyID);
/*     */       this.focusedButton = -1;
/*     */     } 
/*     */     super.a(keyChar, keyID);
/*     */   }
/*     */   
/*     */   protected void a(int i, int j, int k) {
/*     */     if (this.focusedButton >= 0)
/*     */       this.focusedButton = -1; 
/*     */     super.a(i, j, 0);
/*     */   }
/*     */   
/*     */   public void a(int i, int j, float f) {
/*     */     super.a(i, j, f);
/*     */     a(this.u, "NEI Controls", this.q / 2, this.r / 6 - 24, 16777215);
/*     */     for (int b = 0; b < this.keyBinds.size(); b++)
/*     */       b(this.u, ((NEIKeyBind)this.keyBinds.get(b)).desc, this.q / 2 - 155 + b % 2 * 160 + 70 + 6, this.r / 6 + 24 * (b >> 1) + 7, -1); 
/*     */   }
/*     */   
/*     */   public List getOptionList() {
/*     */     Class<?> classz = getClass();
/*     */     while (GuiNEIControls.class.isAssignableFrom(classz)) {
/*     */       LinkedList list = (LinkedList)keyBindMap.get(getClass());
/*     */       if (list != null)
/*     */         return list; 
/*     */       classz = classz.getSuperclass();
/*     */     } 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEIControls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */