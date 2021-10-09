/*     */ package codechicken.nei;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InstallerGui
/*     */   extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private JTextField labelInfo;
/*     */   private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
/*     */   
/*     */   public InstallerGui() {
/*  35 */     setTitle("TMI Uninstaller");
/*  36 */     initComponents();
/*     */   }
/*     */   
/*     */   private class ResizeListener
/*     */     implements LayoutManager
/*     */   {
/*     */     private ResizeListener() {}
/*     */     
/*     */     public void addLayoutComponent(String name, Component comp) {}
/*     */     
/*     */     public void layoutContainer(Container parent) {
/*  47 */       int w = TMIUninstaller.InstallerGui.this.getContentPane().getWidth();
/*  48 */       TMIUninstaller.InstallerGui.this.labelInfo.setBounds(10, 45, w - 20, 20);
/*  49 */       TMIUninstaller.InstallerGui.this.labelInfo.setScrollOffset(1000);
/*  50 */       TMIUninstaller.InstallerGui.this.labelInfo.update(TMIUninstaller.InstallerGui.this.getGraphics());
/*     */     }
/*     */ 
/*     */     
/*     */     public Dimension minimumLayoutSize(Container parent) {
/*  55 */       return new Dimension(150, 100);
/*     */     }
/*     */ 
/*     */     
/*     */     public Dimension preferredLayoutSize(Container parent) {
/*  60 */       return new Dimension(250, 120);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeLayoutComponent(Component comp) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  70 */     setLayout(new ResizeListener(null));
/*  71 */     add(getLabelInfo());
/*  72 */     setSize(358, 270);
/*     */   }
/*     */ 
/*     */   
/*     */   public class InstallerListener
/*     */     implements ActionListener
/*     */   {
/*     */     public void actionPerformed(ActionEvent e) {}
/*     */   }
/*     */   
/*     */   public JTextField getLabelInfo() {
/*  83 */     if (this.labelInfo == null) {
/*  84 */       this.labelInfo = new JTextField();
/*  85 */       this.labelInfo.setFont(new Font("Tahoma", 0, 13));
/*  86 */       this.labelInfo.setHorizontalAlignment(0);
/*  87 */       this.labelInfo.setEditable(false);
/*  88 */       this.labelInfo.setText("Uninstalling TMI");
/*     */     } 
/*  90 */     return this.labelInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void installLnF() {
/*     */     try {
/*  97 */       String lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
/*  98 */       UIManager.setLookAndFeel(lnfClassname);
/*     */     }
/* 100 */     catch (Exception e) {
/*     */       
/* 102 */       System.err.println("Cannot install com.sun.java.swing.plaf.windows.WindowsLookAndFeel on this platform:" + e.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TMIUninstaller$InstallerGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */