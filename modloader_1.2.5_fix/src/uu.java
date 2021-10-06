/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import java.awt.Panel;
/*    */ import java.awt.TextArea;
/*    */ import java.io.PrintWriter;
/*    */ import java.io.StringWriter;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.lwjgl.Sys;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class uu extends Panel {
/*    */   public uu(ja paramja) {
/* 15 */     setBackground(new Color(3028036));
/* 16 */     setLayout(new BorderLayout());
/* 17 */     StringWriter localStringWriter = new StringWriter();
/* 18 */     paramja.b.printStackTrace(new PrintWriter(localStringWriter));
/* 19 */     String str1 = localStringWriter.toString();
/*    */     
/* 21 */     String str2 = "";
/*    */     
/* 23 */     String str3 = "";
/*    */     try {
/* 25 */       str3 = String.valueOf(str3) + "Generated " + (new SimpleDateFormat()).format(new Date()) + "\n";
/* 26 */       str3 = String.valueOf(str3) + "\n";
/* 27 */       str3 = String.valueOf(str3) + "Minecraft: Minecraft 1.2.5\n";
/* 28 */       str3 = String.valueOf(str3) + "OS: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version") + "\n";
/* 29 */       str3 = String.valueOf(str3) + "Java: " + System.getProperty("java.version") + ", " + System.getProperty("java.vendor") + "\n";
/* 30 */       str3 = String.valueOf(str3) + "VM: " + System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor") + 
/* 31 */         "\n";
/* 32 */       str3 = String.valueOf(str3) + "LWJGL: " + Sys.getVersion() + "\n";
/*    */       
/* 34 */       str2 = GL11.glGetString(7936);
/* 35 */       str3 = String.valueOf(str3) + "OpenGL: " + GL11.glGetString(7937) + " version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936) + "\n";
/* 36 */     } catch (Throwable localThrowable) {
/* 37 */       str3 = String.valueOf(str3) + "[failed to get system properties (" + localThrowable + ")]\n";
/*    */     } 
/* 39 */     str3 = String.valueOf(str3) + "\n";
/* 40 */     str3 = String.valueOf(str3) + str1;
/*    */     
/* 42 */     String str4 = "";
/* 43 */     str4 = String.valueOf(str4) + "Mods loaded: " + (ModLoader.getLoadedMods().size() + 1) + "\n";
/* 44 */     str4 = String.valueOf(str4) + "ModLoader 1.2.5" + "\n";
/* 45 */     for (BaseMod mod : ModLoader.getLoadedMods()) {
/* 46 */       str4 = String.valueOf(str4) + mod.getName() + " " + mod.getVersion() + "\n";
/*    */     }
/* 48 */     str4 = String.valueOf(str4) + "\n";
/*    */     
/* 50 */     if (str1.contains("Pixel format not accelerated")) {
/* 51 */       str4 = String.valueOf(str4) + "      Bad video card drivers!      \n";
/* 52 */       str4 = String.valueOf(str4) + "      -----------------------      \n";
/* 53 */       str4 = String.valueOf(str4) + "\n";
/* 54 */       str4 = String.valueOf(str4) + "Minecraft was unable to start because it failed to find an accelerated OpenGL mode.\n";
/* 55 */       str4 = String.valueOf(str4) + "This can usually be fixed by updating the video card drivers.\n";
/* 56 */       if (str2.toLowerCase().contains("nvidia")) {
/* 57 */         str4 = String.valueOf(str4) + "\n";
/* 58 */         str4 = String.valueOf(str4) + "You might be able to find drivers for your video card here:\n";
/* 59 */         str4 = String.valueOf(str4) + "  http://www.nvidia.com/\n";
/* 60 */       } else if (str2.toLowerCase().contains("ati")) {
/* 61 */         str4 = String.valueOf(str4) + "\n";
/* 62 */         str4 = String.valueOf(str4) + "You might be able to find drivers for your video card here:\n";
/* 63 */         str4 = String.valueOf(str4) + "  http://www.amd.com/\n";
/*    */       } 
/*    */     } else {
/* 66 */       str4 = String.valueOf(str4) + "      Minecraft has crashed!      \n";
/* 67 */       str4 = String.valueOf(str4) + "      ----------------------      \n";
/* 68 */       str4 = String.valueOf(str4) + "\n";
/* 69 */       str4 = String.valueOf(str4) + "Minecraft has stopped running because it encountered a problem.\n";
/* 70 */       str4 = String.valueOf(str4) + "\n";
/*    */     } 
/* 72 */     str4 = String.valueOf(str4) + "\n";
/* 73 */     str4 = String.valueOf(str4) + "\n";
/* 74 */     str4 = String.valueOf(str4) + "\n";
/* 75 */     str4 = String.valueOf(str4) + "--- BEGIN ERROR REPORT " + Integer.toHexString(str4.hashCode()) + " --------\n";
/* 76 */     str4 = String.valueOf(str4) + str3;
/*    */     
/* 78 */     str4 = String.valueOf(str4) + "--- END ERROR REPORT " + Integer.toHexString(str4.hashCode()) + " ----------\n";
/* 79 */     str4 = String.valueOf(str4) + "\n";
/* 80 */     str4 = String.valueOf(str4) + "\n";
/*    */     
/* 82 */     TextArea localTextArea = new TextArea(str4, 0, 0, 1);
/* 83 */     localTextArea.setFont(new Font("Monospaced", 0, 12));
/* 84 */     add((Component)new eo(), "North");
/* 85 */     add((Component)new aku(80), "East");
/* 86 */     add((Component)new aku(80), "West");
/* 87 */     add((Component)new aku(100), "South");
/* 88 */     add(localTextArea, "Center");
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip\\uu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */