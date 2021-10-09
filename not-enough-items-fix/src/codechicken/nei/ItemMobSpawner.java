/*     */ package codechicken.nei;
/*     */ 
/*     */ import ModLoader;
/*     */ import aan;
/*     */ import aao;
/*     */ import acq;
/*     */ import cj;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pb;
/*     */ import vd;
/*     */ import xd;
/*     */ import yr;
/*     */ import yw;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMobSpawner
/*     */   extends vd
/*     */ {
/*     */   private static Map entityHashMap;
/*     */   private static Map IDtoNameMap;
/*     */   public static int idPig;
/*     */   private static boolean loaded;
/*     */   
/*     */   public ItemMobSpawner(xd world) {
/*  29 */     super(pb.as.bO - 256);
/*  30 */     e[this.bQ] = (yr)this;
/*  31 */     this.bU = true;
/*     */     
/*  33 */     entityHashMap = new HashMap<Object, Object>();
/*  34 */     IDtoNameMap = new HashMap<Object, Object>();
/*  35 */     loadSpawners(world);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(aan itemstack, yw entityplayer, xd world, int i, int j, int k, int l) {
/*  40 */     int i1 = world.a(i, j, k);
/*  41 */     if (super.a(itemstack, entityplayer, world, i, j, k, l)) {
/*     */       
/*  43 */       if (i1 == pb.aS.bO) {
/*     */         
/*  45 */         l = 0;
/*     */       }
/*  47 */       else if (i1 != pb.bu.bO) {
/*     */         
/*  49 */         if (l == 0)
/*     */         {
/*  51 */           j--;
/*     */         }
/*  53 */         if (l == 1)
/*     */         {
/*  55 */           j++;
/*     */         }
/*  57 */         if (l == 2)
/*     */         {
/*  59 */           k--;
/*     */         }
/*  61 */         if (l == 3)
/*     */         {
/*  63 */           k++;
/*     */         }
/*  65 */         if (l == 4)
/*     */         {
/*  67 */           i--;
/*     */         }
/*  69 */         if (l == 5)
/*     */         {
/*  71 */           i++;
/*     */         }
/*     */       } 
/*  74 */       cj tileentitymobspawner = (cj)world.b(i, j, k);
/*  75 */       if (tileentitymobspawner != null) {
/*     */         
/*  77 */         setDefaultTag(itemstack);
/*  78 */         String mobtype = (String)IDtoNameMap.get(Integer.valueOf(itemstack.i()));
/*  79 */         if (mobtype != null)
/*     */         {
/*  81 */           tileentitymobspawner.a(mobtype);
/*     */         }
/*     */       } 
/*  84 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(aan itemstack, List<String> list) {
/*  95 */     setDefaultTag(itemstack);
/*  96 */     int meta = itemstack.i();
/*  97 */     if (meta == 0)
/*     */     {
/*  99 */       meta = idPig;
/*     */     }
/* 101 */     acq acq = getEntity(meta);
/* 102 */     if (acq == null)
/* 103 */       return;  list.add("§" + ((acq instanceof xf) ? "4" : "3") + (String)IDtoNameMap.get(Integer.valueOf(meta)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static acq getEntity(int ID) {
/* 109 */     acq entityliving = (acq)entityHashMap.get(Integer.valueOf(ID));
/* 110 */     if (entityliving == null) {
/*     */       
/* 112 */       xd world = (NEIUtils.getMinecraft()).f;
/* 113 */       loadSpawners(world);
/*     */       
/*     */       try {
/* 116 */         Class<?> class1 = (Class)((HashMap)ModLoader.getPrivateValue(aao.class, null, 2)).get(Integer.valueOf(ID));
/* 117 */         if (class1 != null && acq.class.isAssignableFrom(class1))
/*     */         {
/* 119 */           entityliving = class1.getConstructor(new Class[] { xd.class }).newInstance(new Object[] {
/* 120 */                 world
/*     */               });
/*     */         }
/* 123 */       } catch (Throwable t) {
/*     */         
/* 125 */         t.printStackTrace();
/*     */       } 
/* 127 */       entityHashMap.put(Integer.valueOf(ID), entityliving);
/*     */     } 
/* 129 */     return entityliving;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setDefaultTag(aan itemstack) {
/* 134 */     if (!IDtoNameMap.containsKey(Integer.valueOf(itemstack.i())))
/*     */     {
/* 136 */       itemstack.b(idPig);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadSpawners(xd world) {
/* 143 */     if (loaded)
/* 144 */       return;  loaded = true;
/* 145 */     ArrayList<Integer> eIDs = new ArrayList();
/*     */     
/*     */     try {
/* 148 */       HashMap classToStringMapping = (HashMap)ModLoader.getPrivateValue(aao.class, null, 1);
/* 149 */       HashMap classToIDMapping = (HashMap)ModLoader.getPrivateValue(aao.class, null, 3);
/* 150 */       for (Class<?> eclass : (Iterable<Class<?>>)classToStringMapping.keySet())
/*     */       {
/* 152 */         if (!acq.class.isAssignableFrom(eclass))
/*     */           continue; 
/*     */         try {
/* 155 */           acq entityliving = eclass.getConstructor(new Class[] { xd.class }).newInstance(new Object[] { world });
/* 156 */           entityliving.bi();
/*     */         }
/* 158 */         catch (Throwable t) {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 163 */         int id = ((Integer)classToIDMapping.get(eclass)).intValue();
/* 164 */         String name = (String)classToStringMapping.get(eclass);
/*     */         
/* 166 */         if (name.equals("EnderDragon"))
/*     */           continue; 
/* 168 */         IDtoNameMap.put(Integer.valueOf(id), name);
/* 169 */         eIDs.add(Integer.valueOf(id));
/*     */         
/* 171 */         if (name.equals("Pig"))
/*     */         {
/* 173 */           idPig = id;
/*     */         }
/*     */       }
/*     */     
/* 177 */     } catch (Throwable t) {
/*     */       
/* 179 */       t.printStackTrace();
/*     */     } 
/*     */     
/* 182 */     API.setItemDamageVariants(pb.as.bO, eIDs);
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\ItemMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */