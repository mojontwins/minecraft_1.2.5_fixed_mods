/*     */ package codechicken.nei;
/*     */ 
/*     */ import abp;
/*     */ import gb;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class GuiNEISettings
/*     */   extends GuiNEIOptions
/*     */ {
/*     */   int mousebutton;
/*     */   
/*     */   public static abstract class NEIOption {
/*     */     private String tagName;
/*     */     private boolean globalOnly = false;
/*     */     
/*     */     public NEIOption(String n) {
/*  19 */       this.tagName = n;
/*     */     }
/*     */ 
/*     */     
/*     */     public NEIOption setGlobalOnly() {
/*  24 */       this.globalOnly = true;
/*  25 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void onClick() {
/*  30 */       NEIConfig.toggleBooleanSetting(getIdent());
/*     */     }
/*     */ 
/*     */     
/*     */     public String getIdent() {
/*  35 */       return this.tagName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean enabled() {
/*  46 */       return NEIConfig.getBooleanSetting(getIdent());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract String updateText();
/*     */ 
/*     */     
/*     */     public int intValue() {
/*  55 */       return NEIConfig.getIntSetting(getIdent());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiNEISettings(gb parentContainer) {
/*  61 */     super(parentContainer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     this.mousebutton = 0;
/*     */     this.options = getOptionList();
/*     */   }
/*     */   
/* 175 */   static HashMap optionMap = new HashMap<Object, Object>();
/*     */   
/*     */   public void c() {
/*     */     for (int i = 0; i < this.options.size(); i++) {
/*     */       if (!(this.options.get(i)).globalOnly || global)
/*     */         this.s.add(new GuiOptionButton(i, this.q / 2 - 155 + i % 2 * 160, this.r / 6 + 24 * (i >> 1), "")); 
/*     */     } 
/*     */     this.s.add(new abp(202, this.q / 2 - 50, this.r / 6 - 30, 100, 20, "NEI " + (global ? "Global" : "World") + " Options"));
/*     */     this.s.add(new abp(201, this.q / 2 - 100, this.r / 6 + 145, "Controls"));
/*     */     super.c();
/*     */   }
/*     */   
/*     */   public void updateButtonNames() {
/*     */     for (int i = 0; i < this.s.size(); i++) {
/*     */       abp button = this.s.get(i);
/*     */       if (button.f < this.options.size()) {
/*     */         NEIOption option = this.options.get(button.f);
/*     */         NEIConfig.global = global;
/*     */         button.e = option.updateText();
/*     */         NEIConfig.global = false;
/*     */         if (!global)
/*     */           button.h = NEIConfig.isWorldSpecific(option.getIdent()); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getBackButtonName() {
/*     */     return "Controls";
/*     */   }
/*     */   
/*     */   public void onBackButtonClick() {
/*     */     this.p.a(new GuiNEIControls(this.parentScreen));
/*     */   }
/*     */   
/*     */   protected void a(abp guibutton) {
/*     */     if (guibutton.f == 202) {
/*     */       global = !global;
/*     */       try {
/*     */         this.p.a(getClass().getConstructor(new Class[] { gb.class }).newInstance(new Object[] { this.parentScreen }));
/*     */       } catch (Exception e) {
/*     */         NEIUtils.reportException(e);
/*     */       } 
/*     */     } else if (guibutton.f < this.options.size()) {
/*     */       NEIOption option = this.options.get(guibutton.f);
/*     */       if (this.mousebutton == 1 && guibutton.h && !global) {
/*     */         NEIConfig.removeWorldSetting(option.getIdent());
/*     */       } else if (this.mousebutton == 0 && !guibutton.h && !global) {
/*     */         NEIConfig.copyWorldSetting(option.getIdent());
/*     */       } else if (this.mousebutton == 0) {
/*     */         NEIConfig.global = global;
/*     */         option.onClick();
/*     */         NEIConfig.global = false;
/*     */       } 
/*     */       updateButtonNames();
/*     */     } else {
/*     */       super.a(guibutton);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List getOptionList() {
/*     */     Class<?> classz = getClass();
/*     */     while (GuiNEISettings.class.isAssignableFrom(classz)) {
/*     */       LinkedList list = (LinkedList)optionMap.get(getClass());
/*     */       if (list != null)
/*     */         return list; 
/*     */       classz = classz.getSuperclass();
/*     */     } 
/*     */     return new LinkedList();
/*     */   }
/*     */   
/*     */   protected void a(int i, int j, int k) {
/*     */     this.mousebutton = k;
/*     */     super.a(i, j, 0);
/*     */   }
/*     */   
/*     */   public static boolean global = true;
/*     */   public List options;
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\GuiNEISettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */