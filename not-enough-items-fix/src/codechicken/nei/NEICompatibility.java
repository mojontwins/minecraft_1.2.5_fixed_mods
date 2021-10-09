/*    */ package codechicken.nei;
/*    */ 
/*    */ import codechicken.core.ReflectionManager;
/*    */ import dd;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NEICompatibility
/*    */ {
/*    */   public static boolean callConvenientInventoryHandler(int i, int j, boolean flag, Minecraft minecraft, dd container) {
/*    */     try {
/* 17 */       Class class1 = ReflectionManager.findClass("ConvenientInventory");
/* 18 */       if (class1 == null) return false; 
/* 19 */       Method method = class1.getMethod("mod_convenientInventory_handleClickOnSlot", new Class[] { int.class, int.class, boolean.class, Minecraft.class, dd.class });
/* 20 */       method.invoke(null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(flag), minecraft, container });
/* 21 */       return true;
/*    */     }
/* 23 */     catch (NoSuchMethodException noSuchMethodException) {
/*    */ 
/*    */     
/* 26 */     } catch (InvocationTargetException invocationTargetException) {
/*    */ 
/*    */     
/* 29 */     } catch (IllegalAccessException illegalAccessException) {}
/*    */ 
/*    */     
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void disableMillenaireKeys() {
/*    */     try {
/* 39 */       ReflectionManager.setField(ReflectionManager.findClass("mod_Millenaire"), ReflectionManager.getMod("mod_Millenaire"), "lastPing", Long.valueOf(System.currentTimeMillis()));
/*    */     }
/* 41 */     catch (Exception exception) {}
/*    */   }
/*    */ 
/*    */   
/* 45 */   public static boolean hasForge = ReflectionManager.classExists("forge.MinecraftForge");
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\NEICompatibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */