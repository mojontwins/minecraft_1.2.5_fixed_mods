/*    */ package codechicken.nei;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class AllowedPropertyMap
/*    */ {
/*  8 */   public static HashMap idToNameMap = new HashMap<Object, Object>();
/*  9 */   public static HashMap nameToIDMap = new HashMap<Object, Object>();
/* 10 */   public static HashSet nameSet = new HashSet();
/*    */   
/*    */   private static int counter;
/*    */   
/*    */   public static void addAction(String actionName) {
/* 15 */     idToNameMap.put(Integer.valueOf(counter), actionName);
/* 16 */     nameToIDMap.put(actionName, Integer.valueOf(counter));
/* 17 */     nameSet.add(actionName);
/* 18 */     counter++;
/*    */   }
/*    */ 
/*    */   
/*    */   static {
/* 23 */     addAction("dawn");
/* 24 */     addAction("noon");
/* 25 */     addAction("dusk");
/* 26 */     addAction("midnight");
/* 27 */     addAction("rain");
/*    */   }
/*    */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\AllowedPropertyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */