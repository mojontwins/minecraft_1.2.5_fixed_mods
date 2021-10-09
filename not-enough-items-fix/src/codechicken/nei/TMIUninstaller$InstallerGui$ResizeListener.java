/*    */ package codechicken.nei;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.LayoutManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ResizeListener
/*    */   implements LayoutManager
/*    */ {
/*    */   private ResizeListener() {}
/*    */   
/*    */   public void addLayoutComponent(String name, Component comp) {}
/*    */   
/*    */   public void layoutContainer(Container parent) {
/* 47 */     int w = TMIUninstaller.InstallerGui.this.getContentPane().getWidth();
/* 48 */     TMIUninstaller.InstallerGui.access$0(TMIUninstaller.InstallerGui.this).setBounds(10, 45, w - 20, 20);
/* 49 */     TMIUninstaller.InstallerGui.access$0(TMIUninstaller.InstallerGui.this).setScrollOffset(1000);
/* 50 */     TMIUninstaller.InstallerGui.access$0(TMIUninstaller.InstallerGui.this).update(TMIUninstaller.InstallerGui.this.getGraphics());
/*    */   }
/*    */ 
/*    */   
/*    */   public Dimension minimumLayoutSize(Container parent) {
/* 55 */     return new Dimension(150, 100);
/*    */   }
/*    */ 
/*    */   
/*    */   public Dimension preferredLayoutSize(Container parent) {
/* 60 */     return new Dimension(250, 120);
/*    */   }
/*    */   
/*    */   public void removeLayoutComponent(Component comp) {}
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TMIUninstaller$InstallerGui$ResizeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */