import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/*      */ 
/*      */ public final class ModLoader {
/*   26 */   private static final List<tt> animList = new LinkedList<tt>();
/*   27 */   private static final Map<Integer, BaseMod> blockModels = new HashMap<Integer, BaseMod>();
/*   28 */   private static final Map<Integer, Boolean> blockSpecialInv = new HashMap<Integer, Boolean>();
/*   29 */   private static final File cfgdir = new File(Minecraft.b(), "/config/");
/*   30 */   private static final File cfgfile = new File(cfgdir, "ModLoader.cfg");
/*      */   
/*   32 */   public static Level cfgLoggingLevel = Level.FINER;
/*   33 */   private static Map<String, Class<? extends nn>> classMap = null;
/*   34 */   private static long clock = 0L;
/*      */   
/*      */   public static final boolean DEBUG = false;
/*   37 */   private static Field field_animList = null;
/*   38 */   private static Field field_armorList = null;
/*   39 */   private static Field field_modifiers = null;
/*   40 */   private static Field field_TileEntityRenderers = null;
/*      */   private static boolean hasInit = false;
/*   42 */   private static int highestEntityId = 3000;
/*   43 */   private static final Map<BaseMod, Boolean> inGameHooks = new HashMap<BaseMod, Boolean>();
/*   44 */   private static final Map<BaseMod, Boolean> inGUIHooks = new HashMap<BaseMod, Boolean>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   49 */   private static Minecraft instance = null;
/*   50 */   private static int itemSpriteIndex = 0;
/*   51 */   private static int itemSpritesLeft = 0;
/*   52 */   private static final Map<BaseMod, Map<afu, boolean[]>> keyList = new HashMap<BaseMod, Map<afu, boolean[]>>();
/*   53 */   private static String langPack = null;
/*   54 */   private static Map<String, Map<String, String>> localizedStrings = new HashMap<String, Map<String, String>>();
/*   55 */   private static final File logfile = new File(Minecraft.b(), "ModLoader.txt");
/*   56 */   private static final Logger logger = Logger.getLogger("ModLoader");
/*   57 */   private static FileHandler logHandler = null;
/*   58 */   private static Method method_RegisterEntityID = null;
/*   59 */   private static Method method_RegisterTileEntity = null;
/*   60 */   private static final File modDir = new File(Minecraft.b(), "/mods/");
/*   61 */   private static final LinkedList<BaseMod> modList = new LinkedList<BaseMod>();
/*   62 */   private static int nextBlockModelID = 1000;
/*   63 */   private static final Map<Integer, Map<String, Integer>> overrides = new HashMap<Integer, Map<String, Integer>>();
/*   64 */   private static final Map<String, BaseMod> packetChannels = new HashMap<String, BaseMod>();
/*      */   
/*   66 */   public static final Properties props = new Properties();
/*      */   private static abn[] standardBiomes;
/*   68 */   private static int terrainSpriteIndex = 0;
/*      */   
/*   70 */   private static int terrainSpritesLeft = 0;
/*      */   
/*   72 */   private static String texPack = null;
/*      */   
/*      */   private static boolean texturesAdded = false;
/*      */   
/*   76 */   private static final boolean[] usedItemSprites = new boolean[256];
/*      */   
/*   78 */   private static final boolean[] usedTerrainSprites = new boolean[256];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String VERSION = "ModLoader 1.2.5";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addAchievementDesc(aeb achievement, String name, String description) {
/*      */     try {
/*  138 */       if (achievement.i().contains(".")) {
/*  139 */         String[] split = achievement.i().split("\\.");
/*  140 */         if (split.length == 2) {
/*  141 */           String key = split[1];
/*  142 */           addLocalization("achievement." + key, name);
/*  143 */           addLocalization("achievement." + key + ".desc", description);
/*  144 */           setPrivateValue(ajw.class, achievement, 1, cy.a("achievement." + key));
/*  145 */           setPrivateValue(aeb.class, achievement, 3, cy.a("achievement." + key + ".desc"));
/*      */         } else {
/*  147 */           setPrivateValue(ajw.class, achievement, 1, name);
/*  148 */           setPrivateValue(aeb.class, achievement, 3, description);
/*      */         } 
/*      */       } else {
/*  151 */         setPrivateValue(ajw.class, achievement, 1, name);
/*  152 */         setPrivateValue(aeb.class, achievement, 3, description);
/*      */       } 
/*  154 */     } catch (IllegalArgumentException e) {
/*  155 */       logger.throwing("ModLoader", "AddAchievementDesc", e);
/*  156 */       throwException(e);
/*  157 */     } catch (SecurityException e) {
/*  158 */       logger.throwing("ModLoader", "AddAchievementDesc", e);
/*  159 */       throwException(e);
/*  160 */     } catch (NoSuchFieldException e) {
/*  161 */       logger.throwing("ModLoader", "AddAchievementDesc", e);
/*  162 */       throwException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int addAllFuel(int id, int metadata) {
/*  173 */     logger.finest("Finding fuel for " + id);
/*  174 */     int result = 0;
/*  175 */     for (Iterator<BaseMod> iter = modList.iterator(); iter.hasNext() && result == 0;)
/*  176 */       result = ((BaseMod)iter.next()).addFuel(id, metadata); 
/*  177 */     if (result != 0)
/*  178 */       logger.finest("Returned " + result); 
/*  179 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addAllRenderers(Map<Class<? extends nn>, um> renderers) {
/*  188 */     if (!hasInit) {
/*  189 */       init();
/*  190 */       logger.fine("Initialized");
/*      */     } 
/*      */     
/*  193 */     for (BaseMod mod : modList) {
/*  194 */       mod.addRenderer(renderers);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addAnimation(tt anim) {
/*  201 */     logger.finest("Adding animation " + anim.toString());
/*  202 */     for (tt oldAnim : animList) {
/*  203 */       if (oldAnim.g == anim.g && oldAnim.k == anim.k) {
/*  204 */         animList.remove(anim);
/*      */         break;
/*      */       } 
/*      */     } 
/*  208 */     animList.add(anim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int addArmor(String armor) {
/*      */     try {
/*  220 */       String[] existingArmor = (String[])field_armorList.get((Object)null);
/*  221 */       List<String> existingArmorList = Arrays.asList(existingArmor);
/*  222 */       List<String> combinedList = new ArrayList<String>();
/*  223 */       combinedList.addAll(existingArmorList);
/*  224 */       if (!combinedList.contains(armor))
/*  225 */         combinedList.add(armor); 
/*  226 */       int index = combinedList.indexOf(armor);
/*  227 */       field_armorList.set((Object)null, combinedList.toArray(new String[0]));
/*  228 */       return index;
/*  229 */     } catch (IllegalArgumentException e) {
/*  230 */       logger.throwing("ModLoader", "AddArmor", e);
/*  231 */       throwException("An impossible error has occured!", e);
/*  232 */     } catch (IllegalAccessException e) {
/*  233 */       logger.throwing("ModLoader", "AddArmor", e);
/*  234 */       throwException("An impossible error has occured!", e);
/*      */     } 
/*  236 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addBiome(abn biome) {
/*  243 */     abn[] existingBiomes = ahy.biomeArray;
/*  244 */     List<abn> existingBiomeList = Arrays.asList(existingBiomes);
/*  245 */     List<abn> combinedList = new ArrayList<abn>();
/*  246 */     combinedList.addAll(existingBiomeList);
/*  247 */     if (!combinedList.contains(biome))
/*  248 */       combinedList.add(biome); 
/*  249 */     ahy.biomeArray = combinedList.<abn>toArray(new abn[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addLocalization(String key, String value) {
/*  257 */     addLocalization(key, "en_US", value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addLocalization(String key, String lang, String value) {
/*      */     Map<String, String> langMap;
/*  266 */     if (localizedStrings.containsKey(lang)) { langMap = localizedStrings.get(lang); }
/*      */     else
/*  268 */     { langMap = new HashMap<String, String>();
/*  269 */       localizedStrings.put(lang, langMap); }
/*      */     
/*  271 */     langMap.put(key, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addMod(ClassLoader loader, String filename) {
/*      */     try {
/*  281 */       String name = filename.split("\\.")[0];
/*  282 */       if (name.contains("$"))
/*      */         return; 
/*  284 */       if (props.containsKey(name) && (props.getProperty(name).equalsIgnoreCase("no") || props.getProperty(name).equalsIgnoreCase("off")))
/*      */         return; 
/*  286 */       Package pack = ModLoader.class.getPackage();
/*  287 */       if (pack != null)
/*  288 */         name = String.valueOf(pack.getName()) + "." + name; 
/*  289 */       Class<?> instclass = loader.loadClass(name);
/*  290 */       if (!BaseMod.class.isAssignableFrom(instclass)) {
/*      */         return;
/*      */       }
/*  293 */       setupProperties((Class)instclass);
/*  294 */       BaseMod mod = (BaseMod)instclass.newInstance();
/*      */       
/*  296 */       if (mod != null) {
/*  297 */         modList.add(mod);
/*  298 */         logger.fine("Mod Initialized: \"" + mod.toString() + "\" from " + filename);
/*  299 */         System.out.println("Mod Initialized: " + mod.toString());
/*      */       } 
/*  301 */     } catch (Throwable e) {
/*  302 */       logger.fine("Failed to load mod from \"" + filename + "\"");
/*  303 */       System.out.println("Failed to load mod from \"" + filename + "\"");
/*  304 */       logger.throwing("ModLoader", "addMod", e);
/*  305 */       throwException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addName(Object instance, String name) {
/*  314 */     addName(instance, "en_US", name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addName(Object instance, String lang, String name) {
/*  322 */     String tag = null;
/*  323 */     if (instance instanceof yr) {
/*  324 */       yr item = (yr)instance;
/*  325 */       if (item.e() != null)
/*  326 */         tag = String.valueOf(item.e()) + ".name"; 
/*  327 */     } else if (instance instanceof pb) {
/*  328 */       pb block = (pb)instance;
/*  329 */       if (block.s() != null)
/*  330 */         tag = String.valueOf(block.s()) + ".name"; 
/*  331 */     } else if (instance instanceof aan) {
/*  332 */       aan stack = (aan)instance;
/*  333 */       String stackTag = yr.e[stack.c].a(stack);
/*  334 */       if (stackTag != null)
/*  335 */         tag = String.valueOf(stackTag) + ".name"; 
/*      */     } else {
/*  337 */       Exception e = new Exception(String.valueOf(instance.getClass().getName()) + " cannot have name attached to it!");
/*  338 */       logger.throwing("ModLoader", "AddName", e);
/*  339 */       throwException(e);
/*      */     } 
/*  341 */     if (tag != null) { addLocalization(tag, lang, name); }
/*      */     else
/*  343 */     { Exception e = new Exception(instance + " is missing name tag!");
/*  344 */       logger.throwing("ModLoader", "AddName", e);
/*  345 */       throwException(e); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int addOverride(String fileToOverride, String fileToAdd) {
/*      */     try {
/*  357 */       int i = getUniqueSpriteIndex(fileToOverride);
/*  358 */       addOverride(fileToOverride, fileToAdd, i);
/*  359 */       return i;
/*  360 */     } catch (Throwable e) {
/*  361 */       logger.throwing("ModLoader", "addOverride", e);
/*  362 */       throwException(e);
/*  363 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addOverride(String path, String overlayPath, int index) {
/*  373 */     int dst = -1;
/*  374 */     int left = 0;
/*  375 */     if (path.equals("/terrain.png"))
/*  376 */     { dst = 0;
/*  377 */       left = terrainSpritesLeft; }
/*  378 */     else if (path.equals("/gui/items.png"))
/*  379 */     { dst = 1;
/*  380 */       left = itemSpritesLeft; }
/*      */     else { return; }
/*  382 */      System.out.println("Overriding " + path + " with " + overlayPath + " @ " + index + ". " + left + " left.");
/*  383 */     logger.finer("addOverride(" + path + "," + overlayPath + "," + index + "). " + left + " left.");
/*  384 */     Map<String, Integer> overlays = overrides.get(Integer.valueOf(dst));
/*  385 */     if (overlays == null) {
/*  386 */       overlays = new HashMap<String, Integer>();
/*  387 */       overrides.put(Integer.valueOf(dst), overlays);
/*      */     } 
/*  389 */     overlays.put(overlayPath, Integer.valueOf(index));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addRecipe(aan output, Object... params) {
/*  401 */     fr.a().a(output, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addShapelessRecipe(aan output, Object... params) {
/*  409 */     fr.a().b(output, params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addSmelting(int input, aan output) {
/*  417 */     dy.a().a(input, output);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addSpawn(Class<? extends acq> entityClass, int weightedProb, int min, int max, acf spawnList) {
/*  429 */     addSpawn(entityClass, weightedProb, min, max, spawnList, (abn[])null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addSpawn(Class<? extends acq> entityClass, int weightedProb, int min, int max, acf spawnList, abn... biomes) {
/*  442 */     if (entityClass == null) {
/*  443 */       throw new IllegalArgumentException("entityClass cannot be null");
/*      */     }
/*  445 */     if (spawnList == null) {
/*  446 */       throw new IllegalArgumentException("spawnList cannot be null");
/*      */     }
/*  448 */     if (biomes == null) {
/*  449 */       biomes = standardBiomes;
/*      */     }
/*  451 */     for (int i = 0; i < biomes.length; i++) {
/*      */       
/*  453 */       List<bg> list = biomes[i].a(spawnList);
/*      */       
/*  455 */       if (list != null) {
/*  456 */         boolean exists = false;
/*  457 */         for (bg entry : list) {
/*  458 */           if (entry.a == entityClass) {
/*  459 */             entry.d = weightedProb;
/*  460 */             entry.b = min;
/*  461 */             entry.c = max;
/*  462 */             exists = true;
/*      */             break;
/*      */           } 
/*      */         } 
/*  466 */         if (!exists) {
/*  467 */           list.add(new bg(entityClass, weightedProb, min, max));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addSpawn(String entityName, int weightedProb, int min, int max, acf spawnList) {
/*  481 */     addSpawn(entityName, weightedProb, min, max, spawnList, (abn[])null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addSpawn(String entityName, int weightedProb, int min, int max, acf spawnList, abn... biomes) {
/*  495 */     Class<? extends nn> entityClass = classMap.get(entityName);
/*  496 */     if (entityClass != null && acq.class.isAssignableFrom(entityClass)) {
/*  497 */       addSpawn((Class)entityClass, weightedProb, min, max, spawnList, biomes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean dispenseEntity(xd world, double x, double y, double z, int xVel, int zVel, aan item) {
/*  512 */     boolean result = false;
/*  513 */     for (Iterator<BaseMod> iter = modList.iterator(); iter.hasNext() && !result;)
/*  514 */       result = ((BaseMod)iter.next()).dispenseEntity(world, x, y, z, xVel, zVel, item); 
/*  515 */     return result;
/*      */   }
/*      */   
/*      */   public static void genericContainerRemoval(xd world, int x, int y, int z) {
/*  519 */     io container = (io)world.b(x, y, z);
/*  520 */     if (container != null) {
/*  521 */       for (int i = 0; i < container.a(); i++) {
/*  522 */         aan item = container.k_(i);
/*  523 */         if (item != null) {
/*  524 */           double xOffset = world.r.nextDouble() * 0.8D + 0.1D;
/*  525 */           double yOffset = world.r.nextDouble() * 0.8D + 0.1D;
/*  526 */           double zOffset = world.r.nextDouble() * 0.8D + 0.1D;
/*      */           
/*  528 */           while (item.a > 0) {
/*  529 */             int amt = world.r.nextInt(21) + 10;
/*  530 */             if (amt > item.a)
/*  531 */               amt = item.a; 
/*  532 */             item.a -= amt;
/*      */             
/*  534 */             fq entity = new fq(world, x + xOffset, y + yOffset, z + zOffset, new aan(item.c, amt, item.i()));
/*  535 */             double speed = 0.05D;
/*  536 */             entity.r = world.r.nextGaussian() * speed;
/*  537 */             entity.s = world.r.nextGaussian() * speed + 0.2D;
/*  538 */             entity.t = world.r.nextGaussian() * speed;
/*  539 */             if (item.n()) {
/*  540 */               entity.a.d((ady)item.o().b());
/*      */             }
/*  542 */             world.a(entity);
/*      */           } 
/*      */           
/*  545 */           container.a(i, null);
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<BaseMod> getLoadedMods() {
/*  555 */     return Collections.unmodifiableList(modList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Logger getLogger() {
/*  562 */     return logger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Minecraft getMinecraftInstance() {
/*  569 */     if (instance == null) {
/*      */       try {
/*  571 */         ThreadGroup group = Thread.currentThread().getThreadGroup();
/*  572 */         int count = group.activeCount();
/*  573 */         Thread[] threads = new Thread[count];
/*  574 */         group.enumerate(threads); int i;
/*  575 */         for (i = 0; i < threads.length; i++) {
/*  576 */           System.out.println(threads[i].getName());
/*      */         }
/*  578 */         for (i = 0; i < threads.length; i++) {
/*  579 */           if (threads[i].getName().equals("Minecraft main thread")) {
/*  580 */             instance = getPrivateValue(Thread.class, threads[i], "target");
/*      */             break;
/*      */           } 
/*      */         } 
/*  584 */       } catch (SecurityException e) {
/*  585 */         logger.throwing("ModLoader", "getMinecraftInstance", e);
/*  586 */         throw new RuntimeException(e);
/*  587 */       } catch (NoSuchFieldException e) {
/*  588 */         logger.throwing("ModLoader", "getMinecraftInstance", e);
/*  589 */         throw new RuntimeException(e);
/*      */       } 
/*      */     }
/*  592 */     return instance;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, int fieldindex) throws IllegalArgumentException, SecurityException, NoSuchFieldException {
/*      */     try {
/*  611 */       Field f = instanceclass.getDeclaredFields()[fieldindex];
/*  612 */       f.setAccessible(true);
/*  613 */       return (T)f.get(instance);
/*  614 */     } catch (IllegalAccessException e) {
/*  615 */       logger.throwing("ModLoader", "getPrivateValue", e);
/*  616 */       throwException("An impossible error has occured!", e);
/*      */       
/*  618 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T, E> T getPrivateValue(Class<? super E> instanceclass, E instance, String field) throws IllegalArgumentException, SecurityException, NoSuchFieldException {
/*      */     try {
/*  637 */       Field f = instanceclass.getDeclaredField(field);
/*  638 */       f.setAccessible(true);
/*  639 */       return (T)f.get(instance);
/*  640 */     } catch (IllegalAccessException e) {
/*  641 */       logger.throwing("ModLoader", "getPrivateValue", e);
/*  642 */       throwException("An impossible error has occured!", e);
/*      */       
/*  644 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUniqueBlockModelID(BaseMod mod, boolean full3DItem) {
/*  654 */     int id = nextBlockModelID++;
/*  655 */     blockModels.put(Integer.valueOf(id), mod);
/*  656 */     blockSpecialInv.put(Integer.valueOf(id), Boolean.valueOf(full3DItem));
/*  657 */     return id;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUniqueEntityId() {
/*  695 */     return highestEntityId++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getUniqueItemSpriteIndex() {
/*  702 */     for (; itemSpriteIndex < usedItemSprites.length; itemSpriteIndex++) {
/*  703 */       if (!usedItemSprites[itemSpriteIndex]) {
/*  704 */         usedItemSprites[itemSpriteIndex] = true;
/*  705 */         itemSpritesLeft--;
/*  706 */         return itemSpriteIndex++;
/*      */       } 
/*  708 */     }  Exception e = new Exception("No more empty item sprite indices left!");
/*  709 */     logger.throwing("ModLoader", "getUniqueItemSpriteIndex", e);
/*  710 */     throwException(e);
/*  711 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUniqueSpriteIndex(String path) {
/*  719 */     if (path.equals("/gui/items.png")) return getUniqueItemSpriteIndex(); 
/*  720 */     if (path.equals("/terrain.png"))
/*  721 */       return getUniqueTerrainSpriteIndex(); 
/*  722 */     Exception e = new Exception("No registry for this texture: " + path);
/*  723 */     logger.throwing("ModLoader", "getUniqueItemSpriteIndex", e);
/*  724 */     throwException(e);
/*  725 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int getUniqueTerrainSpriteIndex() {
/*  732 */     for (; terrainSpriteIndex < usedTerrainSprites.length; terrainSpriteIndex++) {
/*  733 */       if (!usedTerrainSprites[terrainSpriteIndex]) {
/*  734 */         usedTerrainSprites[terrainSpriteIndex] = true;
/*  735 */         terrainSpritesLeft--;
/*  736 */         return terrainSpriteIndex++;
/*      */       } 
/*  738 */     }  Exception e = new Exception("No more empty terrain sprite indices left!");
/*  739 */     logger.throwing("ModLoader", "getUniqueItemSpriteIndex", e);
/*  740 */     throwException(e);
/*  741 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void init() {
/*  746 */     hasInit = true;
/*      */ 
/*      */     
/*  749 */     String usedItemSpritesString = 
/*  750 */       "1111111111111111111111111111111111111101111111111111111111111111111111111111111111111111111111111111110111111111111111000111111111111101111111110000000101111111000000010101111100000000000000110000000000000000000000000000000000000000000000001111111111111111";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  766 */     String usedTerrainSpritesString = 
/*  767 */       "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000001111111111000000001111111100000111111111100000001111111110000001111111111111111111";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  784 */     for (int i = 0; i < 256; i++) {
/*  785 */       usedItemSprites[i] = (usedItemSpritesString.charAt(i) == '1');
/*  786 */       if (!usedItemSprites[i])
/*  787 */         itemSpritesLeft++; 
/*  788 */       usedTerrainSprites[i] = (usedTerrainSpritesString.charAt(i) == '1');
/*  789 */       if (!usedTerrainSprites[i]) {
/*  790 */         terrainSpritesLeft++;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  799 */       instance = getPrivateValue(Minecraft.class, (Minecraft)null, 1);
/*      */       
/*  801 */       instance.u = new EntityRendererProxy(instance);
/*  802 */       classMap = getPrivateValue(aao.class, (aao)null, 0);
/*  803 */       field_modifiers = Field.class.getDeclaredField("modifiers");
/*  804 */       field_modifiers.setAccessible(true);
/*  805 */       field_TileEntityRenderers = ach.class.getDeclaredFields()[0];
/*  806 */       field_TileEntityRenderers.setAccessible(true);
/*  807 */       field_armorList = we.class.getDeclaredFields()[3];
/*  808 */       field_modifiers.setInt(field_armorList, field_armorList.getModifiers() & 0xFFFFFFEF);
/*  809 */       field_armorList.setAccessible(true);
/*  810 */       field_animList = aaw.class.getDeclaredFields()[6];
/*  811 */       field_animList.setAccessible(true);
/*      */       
/*  813 */       Field[] fieldArray = abn.class.getDeclaredFields();
/*      */       
/*  815 */       List<abn> biomes = new LinkedList<abn>();
/*  816 */       for (int j = 0; j < fieldArray.length; j++) {
/*  817 */         Class<?> fieldType = fieldArray[j].getType();
/*      */         
/*  819 */         if ((fieldArray[j].getModifiers() & 0x8) != 0 && fieldType.isAssignableFrom(abn.class)) {
/*  820 */           abn biome = (abn)fieldArray[j].get((Object)null);
/*  821 */           if (!(biome instanceof td) && !(biome instanceof fz))
/*      */           {
/*  823 */             biomes.add(biome);
/*      */           }
/*      */         } 
/*      */       } 
/*  827 */       standardBiomes = biomes.<abn>toArray(new abn[0]);
/*      */       
/*      */       try {
/*  830 */         method_RegisterTileEntity = kw.class.getDeclaredMethod("a", new Class[] { Class.class, String.class });
/*  831 */       } catch (NoSuchMethodException e) {
/*  832 */         method_RegisterTileEntity = kw.class.getDeclaredMethod("addMapping", new Class[] { Class.class, String.class });
/*      */       } 
/*  834 */       method_RegisterTileEntity.setAccessible(true);
/*      */       
/*      */       try {
/*  837 */         method_RegisterEntityID = aao.class.getDeclaredMethod("a", new Class[] { Class.class, String.class, int.class });
/*  838 */       } catch (NoSuchMethodException e) {
/*  839 */         method_RegisterEntityID = aao.class.getDeclaredMethod("addMapping", new Class[] { Class.class, String.class, int.class });
/*      */       } 
/*  841 */       method_RegisterEntityID.setAccessible(true);
/*      */     }
/*  843 */     catch (SecurityException e) {
/*  844 */       logger.throwing("ModLoader", "init", e);
/*  845 */       throwException(e);
/*  846 */       throw new RuntimeException(e);
/*  847 */     } catch (NoSuchFieldException e) {
/*  848 */       logger.throwing("ModLoader", "init", e);
/*  849 */       throwException(e);
/*  850 */       throw new RuntimeException(e);
/*  851 */     } catch (NoSuchMethodException e) {
/*  852 */       logger.throwing("ModLoader", "init", e);
/*  853 */       throwException(e);
/*  854 */       throw new RuntimeException(e);
/*  855 */     } catch (IllegalArgumentException e) {
/*  856 */       logger.throwing("ModLoader", "init", e);
/*  857 */       throwException(e);
/*  858 */       throw new RuntimeException(e);
/*  859 */     } catch (IllegalAccessException e) {
/*  860 */       logger.throwing("ModLoader", "init", e);
/*  861 */       throwException(e);
/*  862 */       throw new RuntimeException(e);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  868 */       loadConfig();
/*  869 */       if (props.containsKey("loggingLevel"))
/*  870 */         cfgLoggingLevel = Level.parse(props.getProperty("loggingLevel")); 
/*  871 */       if (props.containsKey("grassFix")) {
/*  872 */         vl.cfgGrassFix = Boolean.parseBoolean(props.getProperty("grassFix"));
/*      */       }
/*  874 */       logger.setLevel(cfgLoggingLevel);
/*  875 */       if ((logfile.exists() || logfile.createNewFile()) && logfile.canWrite() && logHandler == null) {
/*  876 */         logHandler = new FileHandler(logfile.getPath());
/*  877 */         logHandler.setFormatter(new SimpleFormatter());
/*  878 */         logger.addHandler(logHandler);
/*      */       } 
/*  880 */       logger.fine("ModLoader 1.2.5 Initializing...");
				//File source = new File(ModLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI());
				File file;
				{// resolve jar path | fixed by na_th_an @ 2021 based on coffeenotfound @ 2017
					System.out.println("***** Modloader Fix by na_th_an @ 2021 based on by coffeenotfound @ 2017 ~ https://github.com/coffeenotfound ~ https://bitangent.net/ ****");
					try {
						String rawJarPath = URLDecoder.decode(ModLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
						
						// fix path
						rawJarPath = rawJarPath.replace("jar:", "").replace("file:/", "").replace("file:\\", ""); /* replace scheme part */
						if(rawJarPath.contains(".jar!")) {
							rawJarPath = rawJarPath.substring(0, rawJarPath.lastIndexOf(".jar!") + ".jar".length());
						}
						
						// cleanup
						rawJarPath = new File(rawJarPath).getAbsolutePath();
						
						// log
						System.out.println("[Modloader Fix] original jar path = " + ((ModLoader.class).getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
						System.out.println("[Modloader Fix] new jar path = " + rawJarPath);
						
						// set file
						file = new File(rawJarPath);
					}
					catch(Exception e) {
						throw new RuntimeException("Failed to resolve minecraft jar path; this is the fixed code, if this exception ever gets thrown I owe you a beer.", e);
					}
				}
				
				modDir.mkdirs();
				//readFromClassPath(source);
				readFromClassPath(file);
/*  887 */       readFromModFolder(modDir);
/*  888 */       sortModList();
/*      */       
/*  890 */       for (BaseMod mod : modList) {
/*  891 */         mod.load();
/*  892 */         logger.fine("Mod Loaded: \"" + mod.toString() + "\"");
/*  893 */         System.out.println("Mod Loaded: " + mod.toString());
/*  894 */         if (!props.containsKey(mod.getClass().getSimpleName())) {
/*  895 */           props.setProperty(mod.getClass().getSimpleName(), "on");
/*      */         }
/*      */       } 
/*  898 */       for (BaseMod mod : modList) {
/*  899 */         mod.modsLoaded();
/*      */       }
/*      */       
/*  902 */       System.out.println("Done.");
/*      */       
/*  904 */       props.setProperty("loggingLevel", cfgLoggingLevel.getName());
/*  905 */       props.setProperty("grassFix", Boolean.toString(vl.cfgGrassFix));
/*      */       
/*  907 */       instance.A.A = registerAllKeys(instance.A.A);
/*  908 */       instance.A.a();
/*      */       
/*  910 */       initStats();
/*      */       
/*  912 */       saveConfig();
/*  913 */     } catch (Throwable e) {
/*  914 */       logger.throwing("ModLoader", "init", e);
/*  915 */       throwException("ModLoader has failed to initialize.", e);
/*  916 */       if (logHandler != null)
/*  917 */         logHandler.close(); 
/*  918 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */   private static void initStats() {
/*      */     int id;
/*  923 */     for (id = 0; id < pb.m.length; id++) {
/*  924 */       if (!gv.a.containsKey(Integer.valueOf(16777216 + id)) && pb.m[id] != null && pb.m[id].t()) {
/*  925 */         String str = cy.a("stat.mineBlock", new Object[] { pb.m[id].r() });
/*  926 */         gv.C[id] = (new aii(16777216 + id, str, id)).a();
/*  927 */         gv.e.add(gv.C[id]);
/*      */       } 
/*      */     } 
/*      */     
/*  931 */     for (id = 0; id < yr.e.length; id++) {
/*  932 */       if (!gv.a.containsKey(Integer.valueOf(16908288 + id)) && yr.e[id] != null) {
/*  933 */         String str = cy.a("stat.useItem", new Object[] { yr.e[id].n() });
/*  934 */         gv.E[id] = (new aii(16908288 + id, str, id)).a();
/*      */         
/*  936 */         if (id >= pb.m.length) {
/*  937 */           gv.d.add(gv.E[id]);
/*      */         }
/*      */       } 
/*      */       
/*  941 */       if (!gv.a.containsKey(Integer.valueOf(16973824 + id)) && yr.e[id] != null && yr.e[id].i()) {
/*  942 */         String str = cy.a("stat.breakItem", new Object[] { yr.e[id].n() });
/*  943 */         gv.F[id] = (new aii(16973824 + id, str, id)).a();
/*      */       } 
/*      */     } 
/*      */     
/*  947 */     HashSet<Integer> idHashSet = new HashSet<Integer>();
/*      */     
/*  949 */     for (Object result : fr.a().b()) {
/*  950 */       idHashSet.add(Integer.valueOf((((wf)result).b()).c));
/*      */     }
/*  952 */     for (Object result : dy.a().b().values()) {
/*  953 */       idHashSet.add(Integer.valueOf(((aan)result).c));
/*      */     }
/*  955 */     for (Iterator<Integer> iterator = idHashSet.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  956 */       if (!gv.a.containsKey(Integer.valueOf(16842752 + i)) && yr.e[i] != null) {
/*  957 */         String str = cy.a("stat.craftItem", new Object[] { yr.e[i].n() });
/*  958 */         gv.D[i] = (new aii(16842752 + i, str, i)).a();
/*      */       }  }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGUIOpen(Class<? extends vp> gui) {
/*  968 */     Minecraft game = getMinecraftInstance();
/*  969 */     if (gui == null) {
/*  970 */       return (game.s == null);
/*      */     }
/*  972 */     if (game.s == null && gui != null) {
/*  973 */       return false;
/*      */     }
/*  975 */     return gui.isInstance(game.s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isModLoaded(String modname) {
/*  983 */     for (BaseMod mod : modList) {
/*  984 */       if (modname.contentEquals(mod.getName()))
/*  985 */         return true; 
/*      */     } 
/*  987 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void loadConfig() throws IOException {
/*  994 */     cfgdir.mkdir();
/*      */     
/*  996 */     if (!cfgfile.exists() && !cfgfile.createNewFile()) {
/*      */       return;
/*      */     }
/*  999 */     if (cfgfile.canRead()) {
/* 1000 */       InputStream in = new FileInputStream(cfgfile);
/* 1001 */       props.load(in);
/* 1002 */       in.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedImage loadImage(aaw texCache, String path) throws Exception {
/* 1012 */     gi pack = getPrivateValue(aaw.class, texCache, 11);
/* 1013 */     InputStream input = pack.a.a(path);
/* 1014 */     if (input == null)
/* 1015 */       throw new Exception("Image not found: " + path); 
/* 1016 */     BufferedImage image = ImageIO.read(input);
/* 1017 */     if (image == null)
/* 1018 */       throw new Exception("Image corrupted: " + path); 
/* 1019 */     return image;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void onItemPickup(yw player, aan item) {
/* 1027 */     for (BaseMod mod : modList) {
/* 1028 */       mod.onItemPickup(player, item);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void onTick(float tick, Minecraft game) {
/* 1036 */     lv.b();
/* 1037 */     lv.b();
/* 1038 */     lv.a("modtick");
/* 1039 */     if (!hasInit) {
/* 1040 */       init();
/* 1041 */       logger.fine("Initialized");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1046 */     if (texPack == null || game.A.m != texPack) {
/* 1047 */       texturesAdded = false;
/* 1048 */       texPack = game.A.m;
/*      */     } 
/*      */     
/* 1051 */     if (langPack == null || adn.a().c() != langPack) {
/* 1052 */       Properties localized = null;
/*      */       try {
/* 1054 */         localized = getPrivateValue(adn.class, adn.a(), 1);
/* 1055 */       } catch (SecurityException e) {
/* 1056 */         logger.throwing("ModLoader", "AddLocalization", e);
/* 1057 */         throwException(e);
/* 1058 */       } catch (NoSuchFieldException e) {
/* 1059 */         logger.throwing("ModLoader", "AddLocalization", e);
/* 1060 */         throwException(e);
/*      */       } 
/* 1062 */       langPack = adn.a().c();
/* 1063 */       if (localized != null) {
/* 1064 */         if (localizedStrings.containsKey("en_US"))
/* 1065 */           localized.putAll(localizedStrings.get("en_US")); 
/* 1066 */         if (!langPack.contentEquals("en_US") && localizedStrings.containsKey(langPack)) {
/* 1067 */           localized.putAll(localizedStrings.get(langPack));
/*      */         }
/*      */       } 
/*      */     } 
/* 1071 */     if (!texturesAdded && game.p != null) {
/*      */ 
/*      */       
/* 1074 */       registerAllTextureOverrides(game.p);
/*      */ 
/*      */ 
/*      */       
/* 1078 */       texturesAdded = true;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1084 */     long newclock = 0L;
/*      */     
/* 1086 */     if (game.f != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1097 */       newclock = game.f.w();
/* 1098 */       for (Iterator<Map.Entry<BaseMod, Boolean>> iter = inGameHooks.entrySet().iterator(); iter.hasNext(); ) {
/* 1099 */         Map.Entry<BaseMod, Boolean> modSet = iter.next();
/* 1100 */         if (clock == newclock && ((Boolean)modSet.getValue()).booleanValue())
/*      */           continue; 
/* 1102 */         if (!((BaseMod)modSet.getKey()).onTickInGame(tick, game)) {
/* 1103 */           iter.remove();
/*      */         }
/*      */       } 
/*      */     } 
/* 1107 */     if (game.r != null) {
/* 1108 */       for (Iterator<Map.Entry<BaseMod, Boolean>> iter = inGUIHooks.entrySet().iterator(); iter.hasNext(); ) {
/* 1109 */         Map.Entry<BaseMod, Boolean> modSet = iter.next();
/* 1110 */         if (clock == newclock && ( ( ((Boolean)modSet.getValue()).booleanValue() ? 1 : 0) & ((game.f != null) ? 1 : 0)) != 0)
/*      */           continue; 
/* 1112 */         if (!((BaseMod)modSet.getKey()).onTickInGUI(tick, game, game.s)) {
/* 1113 */           iter.remove();
/*      */         }
/*      */       } 
/*      */     }
/* 1117 */     if (clock != newclock) {
/* 1118 */       for (Map.Entry<BaseMod, Map<afu, boolean[]>> modSet : keyList.entrySet()) {
/* 1119 */         for (Map.Entry<afu, boolean[]> keySet : (Iterable<Map.Entry<afu, boolean[]>>)((Map)modSet.getValue()).entrySet()) {
/* 1120 */           boolean state; int key = ((afu)keySet.getKey()).d;
/*      */           
/* 1122 */           if (key < 0) {
/* 1123 */             key += 100;
/* 1124 */             state = Mouse.isButtonDown(key);
/*      */           } else {
/* 1126 */             state = Keyboard.isKeyDown(key);
/*      */           } 
/* 1128 */           boolean[] keyInfo = keySet.getValue();
/* 1129 */           boolean oldState = keyInfo[1];
/* 1130 */           keyInfo[1] = state;
/* 1131 */           if (!state || (
/* 1132 */             oldState && !keyInfo[0]))
/*      */             continue; 
/* 1134 */           ((BaseMod)modSet.getKey()).keyboardEvent(keySet.getKey());
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1140 */     clock = newclock;
/* 1141 */     lv.b();
/* 1142 */     lv.a("render");
/* 1143 */     lv.a("gameRenderer");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void openGUI(yw player, vp gui) {
/* 1151 */     if (!hasInit) {
/* 1152 */       init();
/* 1153 */       logger.fine("Initialized");
/*      */     } 
/* 1155 */     Minecraft game = getMinecraftInstance();
/* 1156 */     if (game.i != player)
/*      */       return; 
/* 1158 */     if (gui != null) {
/* 1159 */       game.a(gui);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void populateChunk(ca generator, int chunkX, int chunkZ, xd world) {
/* 1172 */     if (!hasInit) {
/* 1173 */       init();
/* 1174 */       logger.fine("Initialized");
/*      */     } 
/*      */     
/* 1177 */     Random rnd = new Random(world.v());
/* 1178 */     long xSeed = rnd.nextLong() / 2L * 2L + 1L;
/* 1179 */     long zSeed = rnd.nextLong() / 2L * 2L + 1L;
/* 1180 */     rnd.setSeed(chunkX * xSeed + chunkZ * zSeed ^ world.v());
/*      */     
/* 1182 */     for (BaseMod mod : modList) {
/*      */       
/* 1184 */       if (generator.c().equals("RandomLevelSource")) { mod.generateSurface(world, rnd, chunkX << 4, chunkZ << 4); continue; }
/* 1185 */        if (generator.c().equals("HellRandomLevelSource")) {
/* 1186 */         mod.generateNether(world, rnd, chunkX << 4, chunkZ << 4);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void readFromClassPath(File source) throws FileNotFoundException, IOException {
/* 1196 */     logger.finer("Adding mods from " + source.getCanonicalPath());
/* 1197 */     ClassLoader loader = ModLoader.class.getClassLoader();
/* 1198 */     if (source.isFile() && (source.getName().endsWith(".jar") || source.getName().endsWith(".zip"))) {
/* 1199 */       logger.finer("Zip found.");
/* 1200 */       InputStream input = new FileInputStream(source);
/* 1201 */       ZipInputStream zip = new ZipInputStream(input);
/* 1202 */       ZipEntry entry = null;
/*      */       while (true) {
/* 1204 */         entry = zip.getNextEntry();
/* 1205 */         if (entry == null) {
/*      */           break;
/*      */         }
/* 1208 */         String name = entry.getName();
/* 1209 */         if (!entry.isDirectory() && name.startsWith("mod_") && name.endsWith(".class"))
/* 1210 */           addMod(loader, name); 
/*      */       } 
/* 1212 */       input.close();
/* 1213 */     } else if (source.isDirectory()) {
/* 1214 */       Package pkg = ModLoader.class.getPackage();
/* 1215 */       if (pkg != null) {
/* 1216 */         String pkgdir = pkg.getName().replace('.', File.separatorChar);
/* 1217 */         source = new File(source, pkgdir);
/*      */       } 
/* 1219 */       logger.finer("Directory found.");
/* 1220 */       File[] files = source.listFiles();
/* 1221 */       if (files != null) {
/* 1222 */         for (int i = 0; i < files.length; i++) {
/* 1223 */           String name = files[i].getName();
/* 1224 */           if (files[i].isFile() && name.startsWith("mod_") && name.endsWith(".class")) {
/* 1225 */             addMod(loader, name);
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void readFromModFolder(File folder) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
/* 1236 */     ClassLoader loader = Minecraft.class.getClassLoader();
/* 1237 */     Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
/* 1238 */     addURL.setAccessible(true);
/*      */     
/* 1240 */     if (!folder.isDirectory()) {
/* 1241 */       throw new IllegalArgumentException("folder must be a Directory.");
/*      */     }
/* 1243 */     File[] sourcefiles = folder.listFiles();
/* 1244 */     Arrays.sort((Object[])sourcefiles);
/*      */     
/* 1246 */     if (loader instanceof URLClassLoader) {
/* 1247 */       for (int i = 0; i < sourcefiles.length; i++) {
/* 1248 */         File source = sourcefiles[i];
/*      */         
/* 1250 */         if (source.isDirectory() || (source.isFile() && (source.getName().endsWith(".jar") || source.getName().endsWith(".zip"))))
/*      */         {
/*      */           
/* 1253 */           addURL.invoke(loader, new Object[] { source.toURI().toURL() });
/*      */         }
/*      */       } 
/*      */     }
/* 1257 */     for (int file = 0; file < sourcefiles.length; file++) {
/* 1258 */       File source = sourcefiles[file];
/*      */       
/* 1260 */       if (source.isDirectory() || (source.isFile() && (source.getName().endsWith(".jar") || source.getName().endsWith(".zip")))) {
/*      */ 
/*      */         
/* 1263 */         logger.finer("Adding mods from " + source.getCanonicalPath());
/* 1264 */         if (source.isFile()) {
/* 1265 */           logger.finer("Zip found.");
/* 1266 */           InputStream input = new FileInputStream(source);
/* 1267 */           ZipInputStream zip = new ZipInputStream(input);
/* 1268 */           ZipEntry entry = null;
/*      */           while (true) {
/* 1270 */             entry = zip.getNextEntry();
/* 1271 */             if (entry == null) {
/*      */               break;
/*      */             }
/* 1274 */             String name = entry.getName();
/* 1275 */             if (!entry.isDirectory() && name.startsWith("mod_") && name.endsWith(".class"))
/* 1276 */               addMod(loader, name); 
/*      */           } 
/* 1278 */           zip.close();
/* 1279 */           input.close();
/* 1280 */         } else if (source.isDirectory()) {
/* 1281 */           Package pkg = ModLoader.class.getPackage();
/* 1282 */           if (pkg != null) {
/* 1283 */             String pkgdir = pkg.getName().replace('.', File.separatorChar);
/* 1284 */             source = new File(source, pkgdir);
/*      */           } 
/* 1286 */           logger.finer("Directory found.");
/* 1287 */           File[] dirfiles = source.listFiles();
/* 1288 */           if (dirfiles != null)
/* 1289 */             for (int j = 0; j < dirfiles.length; j++) {
/* 1290 */               String name = dirfiles[j].getName();
/* 1291 */               if (dirfiles[j].isFile() && name.startsWith("mod_") && name.endsWith(".class"))
/* 1292 */                 addMod(loader, name); 
/*      */             }  
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void receivePacket(ee packet) {
/* 1300 */     if (packetChannels.containsKey(packet.a)) {
/* 1301 */       BaseMod mod = packetChannels.get(packet.a);
/* 1302 */       if (mod != null) {
/* 1303 */         mod.receiveCustomPacket(packet);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static afu[] registerAllKeys(afu[] keys) {
/* 1312 */     List<afu> combinedList = new LinkedList<afu>();
/* 1313 */     combinedList.addAll(Arrays.asList(keys));
/* 1314 */     for (Map<afu, boolean[]> keyMap : keyList.values())
/* 1315 */       combinedList.addAll(keyMap.keySet()); 
/* 1316 */     return combinedList.<afu>toArray(new afu[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerAllTextureOverrides(aaw cache) {
/* 1327 */     animList.clear();
/*      */     
/* 1329 */     Minecraft game = getMinecraftInstance();
/* 1330 */     for (BaseMod mod : modList) {
/* 1331 */       mod.registerAnimation(game);
/*      */     }
/* 1333 */     for (tt anim : animList)
/*      */     {
/*      */       
/* 1336 */       cache.a(anim);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1342 */     for (Map.Entry<Integer, Map<String, Integer>> overlay : overrides.entrySet()) {
/* 1343 */       for (Map.Entry<String, Integer> overlayEntry : (Iterable<Map.Entry<String, Integer>>)((Map)overlay.getValue()).entrySet()) {
/* 1344 */         String overlayPath = overlayEntry.getKey();
/* 1345 */         int index = ((Integer)overlayEntry.getValue()).intValue();
/* 1346 */         int dst = ((Integer)overlay.getKey()).intValue();
/*      */         try {
/* 1348 */           BufferedImage im = loadImage(cache, overlayPath);
/* 1349 */           tt anim = new ModTextureStatic(index, dst, im);
/*      */ 
/*      */           
/* 1352 */           cache.a(anim);
/* 1353 */         } catch (Exception e) {
/* 1354 */           logger.throwing("ModLoader", "RegisterAllTextureOverrides", e);
/* 1355 */           throwException(e);
/* 1356 */           throw new RuntimeException(e);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerBlock(pb block) {
/* 1368 */     registerBlock(block, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerBlock(pb block, Class<? extends vd> itemclass) {
/*      */     try {
/* 1378 */       if (block == null) {
/* 1379 */         throw new IllegalArgumentException("block parameter cannot be null.");
/*      */       }
/* 1381 */       int id = block.bO;
/* 1382 */       vd item = null;
/* 1383 */       if (itemclass != null) { item = itemclass.getConstructor(new Class[] { int.class }).newInstance(new Object[] { Integer.valueOf(id - 256) }); }
/* 1384 */       else { item = new vd(id - 256); }
/*      */       
/* 1386 */       if (pb.m[id] != null && yr.e[id] == null)
/* 1387 */         yr.e[id] = (yr)item; 
/* 1388 */     } catch (IllegalArgumentException e) {
/* 1389 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1390 */       throwException(e);
/* 1391 */     } catch (IllegalAccessException e) {
/* 1392 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1393 */       throwException(e);
/* 1394 */     } catch (SecurityException e) {
/* 1395 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1396 */       throwException(e);
/* 1397 */     } catch (InstantiationException e) {
/* 1398 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1399 */       throwException(e);
/* 1400 */     } catch (InvocationTargetException e) {
/* 1401 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1402 */       throwException(e);
/* 1403 */     } catch (NoSuchMethodException e) {
/* 1404 */       logger.throwing("ModLoader", "RegisterBlock", e);
/* 1405 */       throwException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerEntityID(Class<? extends nn> entityClass, String entityName, int id) {
/*      */     try {
/* 1416 */       method_RegisterEntityID.invoke(null, new Object[] { entityClass, entityName, Integer.valueOf(id) });
/* 1417 */     } catch (IllegalArgumentException e) {
/* 1418 */       logger.throwing("ModLoader", "RegisterEntityID", e);
/* 1419 */       throwException(e);
/* 1420 */     } catch (IllegalAccessException e) {
/* 1421 */       logger.throwing("ModLoader", "RegisterEntityID", e);
/* 1422 */       throwException(e);
/* 1423 */     } catch (InvocationTargetException e) {
/* 1424 */       logger.throwing("ModLoader", "RegisterEntityID", e);
/* 1425 */       throwException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerEntityID(Class<? extends nn> entityClass, String entityName, int id, int background, int foreground) {
/* 1438 */     registerEntityID(entityClass, entityName, id);
/*      */     
/* 1440 */     aao.a.put(Integer.valueOf(id), new hr(id, background, foreground));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerKey(BaseMod mod, afu keyHandler, boolean allowRepeat) {
/* 1453 */     Map<afu, boolean[]> keyMap = keyList.get(mod);
/* 1454 */     if (keyMap == null)
/* 1455 */       keyMap = (Map)new HashMap<afu, boolean []>(); 
/* 1456 */     keyMap.put(keyHandler, new boolean[] { allowRepeat });
/* 1457 */     keyList.put(mod, keyMap);
/*      */   }
/*      */   
/*      */   public static void registerPacketChannel(BaseMod mod, String channel) {
/* 1461 */     if (channel.length() < 16) { packetChannels.put(channel, mod); }
/* 1462 */     else { throw new RuntimeException(String.format("Invalid channel name: %s. Must be less than 16 characters.", new Object[] { channel })); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerTileEntity(Class<? extends kw> tileEntityClass, String id) {
/* 1470 */     registerTileEntity(tileEntityClass, id, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerTileEntity(Class<? extends kw> tileEntityClass, String id, aar renderer) {
/*      */     try {
/* 1480 */       method_RegisterTileEntity.invoke(null, new Object[] { tileEntityClass, id });
/* 1481 */       if (renderer != null) {
/* 1482 */         ach ref = ach.a;
/*      */         
/* 1484 */         Map<Class<? extends kw>, aar> renderers = (Map<Class<? extends kw>, aar>)field_TileEntityRenderers.get(ref);
/* 1485 */         renderers.put(tileEntityClass, renderer);
/* 1486 */         renderer.a(ref);
/*      */       } 
/* 1488 */     } catch (IllegalArgumentException e) {
/* 1489 */       logger.throwing("ModLoader", "RegisterTileEntity", e);
/* 1490 */       throwException(e);
/* 1491 */     } catch (IllegalAccessException e) {
/* 1492 */       logger.throwing("ModLoader", "RegisterTileEntity", e);
/* 1493 */       throwException(e);
/* 1494 */     } catch (InvocationTargetException e) {
/* 1495 */       logger.throwing("ModLoader", "RegisterTileEntity", e);
/* 1496 */       throwException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeBiome(abn biome) {
/* 1504 */     abn[] existingBiomes = ahy.biomeArray;
/* 1505 */     List<abn> existingBiomeList = Arrays.asList(existingBiomes);
/* 1506 */     List<abn> combinedList = new ArrayList<abn>();
/* 1507 */     combinedList.addAll(existingBiomeList);
/* 1508 */     if (combinedList.contains(biome))
/* 1509 */       combinedList.remove(biome); 
/* 1510 */     ahy.biomeArray = combinedList.<abn>toArray(new abn[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeSpawn(Class<? extends acq> entityClass, acf spawnList) {
/* 1519 */     removeSpawn(entityClass, spawnList, (abn[])null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeSpawn(Class<? extends acq> entityClass, acf spawnList, abn... biomes) {
/* 1529 */     if (entityClass == null) {
/* 1530 */       throw new IllegalArgumentException("entityClass cannot be null");
/*      */     }
/* 1532 */     if (spawnList == null) {
/* 1533 */       throw new IllegalArgumentException("spawnList cannot be null");
/*      */     }
/* 1535 */     if (biomes == null) {
/* 1536 */       biomes = standardBiomes;
/*      */     }
/* 1538 */     for (int i = 0; i < biomes.length; i++) {
/*      */       
/* 1540 */       List<bg> list = biomes[i].a(spawnList);
/*      */       
/* 1542 */       if (list != null) {
/* 1543 */         for (Iterator<bg> iter = list.iterator(); iter.hasNext(); ) {
/* 1544 */           bg entry = iter.next();
/* 1545 */           if (entry.a == entityClass) {
/* 1546 */             iter.remove();
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeSpawn(String entityName, acf spawnList) {
/* 1558 */     removeSpawn(entityName, spawnList, (abn[])null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeSpawn(String entityName, acf spawnList, abn... biomes) {
/* 1568 */     Class<? extends nn> entityClass = classMap.get(entityName);
/* 1569 */     if (entityClass != null && acq.class.isAssignableFrom(entityClass)) {
/* 1570 */       removeSpawn((Class)entityClass, spawnList, biomes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean renderBlockIsItemFull3D(int modelID) {
/* 1579 */     if (!blockSpecialInv.containsKey(Integer.valueOf(modelID)))
/* 1580 */       return (modelID == 16); 
/* 1581 */     return ((Boolean)blockSpecialInv.get(Integer.valueOf(modelID))).booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void renderInvBlock(vl renderer, pb block, int metadata, int modelID) {
/* 1594 */     BaseMod mod = blockModels.get(Integer.valueOf(modelID));
/* 1595 */     if (mod == null)
/*      */       return; 
/* 1597 */     mod.renderInvBlock(renderer, block, metadata, modelID);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean renderWorldBlock(vl renderer, ali world, int x, int y, int z, pb block, int modelID) {
/* 1612 */     BaseMod mod = blockModels.get(Integer.valueOf(modelID));
/* 1613 */     if (mod == null)
/* 1614 */       return false; 
/* 1615 */     return mod.renderWorldBlock(renderer, world, x, y, z, block, modelID);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void saveConfig() throws IOException {
/* 1622 */     cfgdir.mkdir();
/*      */     
/* 1624 */     if (!cfgfile.exists() && !cfgfile.createNewFile()) {
/*      */       return;
/*      */     }
/* 1627 */     if (cfgfile.canWrite()) {
/* 1628 */       OutputStream out = new FileOutputStream(cfgfile);
/* 1629 */       props.store(out, "ModLoader Config");
/* 1630 */       out.close();
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void serverChat(String text) {
/* 1635 */     for (BaseMod mod : modList)
/* 1636 */       mod.receiveChatPacket(text); 
/*      */   }
/*      */   
/* 1639 */   private static adl netHandler = null;
/*      */   
/*      */   public static void serverConnect(adl handler, aec loginPacket) {
/* 1642 */     netHandler = handler;
/* 1643 */     if (packetChannels.size() > 0) {
/* 1644 */       ee packet = new ee();
/* 1645 */       packet.a = "REGISTER";
/* 1646 */       StringBuilder channels = new StringBuilder();
/* 1647 */       Iterator<String> iter = packetChannels.keySet().iterator();
/* 1648 */       channels.append(iter.next());
/* 1649 */       while (iter.hasNext()) {
/* 1650 */         channels.append("\000");
/* 1651 */         channels.append(iter.next());
/*      */       } 
/* 1653 */       packet.c = channels.toString().getBytes(Charset.forName("UTF8"));
/* 1654 */       packet.b = packet.c.length;
/* 1655 */       sendPacket((abs)packet);
/*      */     } 
/* 1657 */     for (BaseMod mod : modList)
/* 1658 */       mod.serverConnect(netHandler); 
/*      */   }
/*      */   
/*      */   public static void serverDisconnect() {
/* 1662 */     for (BaseMod mod : modList)
/* 1663 */       mod.serverDisconnect(); 
/* 1664 */     netHandler = null;
/*      */   }
/*      */   
/*      */   public static void sendPacket(abs packet) {
/* 1668 */     if (netHandler != null) {
/* 1669 */       netHandler.c(packet);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setInGameHook(BaseMod mod, boolean enable, boolean useClock) {
/* 1679 */     if (enable) { inGameHooks.put(mod, Boolean.valueOf(useClock)); }
/* 1680 */     else { inGameHooks.remove(mod); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setInGUIHook(BaseMod mod, boolean enable, boolean useClock) {
/* 1690 */     if (enable) { inGUIHooks.put(mod, Boolean.valueOf(useClock)); }
/* 1691 */     else { inGUIHooks.remove(mod); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, int fieldindex, E value) throws IllegalArgumentException, SecurityException, NoSuchFieldException {
/*      */     try {
/* 1709 */       Field f = instanceclass.getDeclaredFields()[fieldindex];
/* 1710 */       f.setAccessible(true);
/* 1711 */       int modifiers = field_modifiers.getInt(f);
/* 1712 */       if ((modifiers & 0x10) != 0)
/* 1713 */         field_modifiers.setInt(f, modifiers & 0xFFFFFFEF); 
/* 1714 */       f.set(instance, value);
/* 1715 */     } catch (IllegalAccessException e) {
/* 1716 */       logger.throwing("ModLoader", "setPrivateValue", e);
/* 1717 */       throwException("An impossible error has occured!", e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T, E> void setPrivateValue(Class<? super T> instanceclass, T instance, String field, E value) throws IllegalArgumentException, SecurityException, NoSuchFieldException {
/*      */     try {
/* 1736 */       Field f = instanceclass.getDeclaredField(field);
/* 1737 */       int modifiers = field_modifiers.getInt(f);
/* 1738 */       if ((modifiers & 0x10) != 0)
/* 1739 */         field_modifiers.setInt(f, modifiers & 0xFFFFFFEF); 
/* 1740 */       f.setAccessible(true);
/* 1741 */       f.set(instance, value);
/* 1742 */     } catch (IllegalAccessException e) {
/* 1743 */       logger.throwing("ModLoader", "setPrivateValue", e);
/* 1744 */       throwException("An impossible error has occured!", e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void setupProperties(Class<? extends BaseMod> mod) throws IllegalArgumentException, IllegalAccessException, IOException, SecurityException, NoSuchFieldException, NoSuchAlgorithmException, DigestException {
/* 1751 */     List<Field> fieldList = new LinkedList<Field>();
/* 1752 */     Properties modprops = new Properties();
/* 1753 */     int currentHash = 0;
/* 1754 */     int cfgHash = 0;
/*      */     
/* 1756 */     File modcfgfile = new File(cfgdir, String.valueOf(mod.getSimpleName()) + ".cfg");
/* 1757 */     if (modcfgfile.exists() && modcfgfile.canRead()) {
/* 1758 */       modprops.load(new FileInputStream(modcfgfile));
/*      */     }
/* 1760 */     if (modprops.containsKey("checksum"))
/* 1761 */       cfgHash = Integer.parseInt(modprops.getProperty("checksum"), 36);  byte b; int i;
/*      */     Field[] arrayOfField;
/* 1763 */     for (i = (arrayOfField = mod.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/* 1764 */       if ((field.getModifiers() & 0x8) != 0 && field.isAnnotationPresent((Class)MLProp.class)) {
/* 1765 */         fieldList.add(field);
/* 1766 */         Object currentvalue = field.get((Object)null);
/* 1767 */         currentHash += currentvalue.hashCode();
/*      */       } 
/*      */       b++; }
/*      */     
/* 1771 */     StringBuilder helptext = new StringBuilder();
/* 1772 */     for (Field field : fieldList) {
/* 1773 */       if ((field.getModifiers() & 0x8) != 0 && field.isAnnotationPresent((Class)MLProp.class)) {
/* 1774 */         Class<?> type = field.getType();
/* 1775 */         MLProp annotation = field.<MLProp>getAnnotation(MLProp.class);
/* 1776 */         String key = (annotation.name().length() == 0) ? field.getName() : annotation.name();
/* 1777 */         Object currentvalue = field.get((Object)null);
/*      */         
/* 1779 */         StringBuilder range = new StringBuilder();
/* 1780 */         if (annotation.min() != Double.NEGATIVE_INFINITY)
/* 1781 */           range.append(String.format(",>=%.1f", new Object[] { Double.valueOf(annotation.min()) })); 
/* 1782 */         if (annotation.max() != Double.POSITIVE_INFINITY) {
/* 1783 */           range.append(String.format(",<=%.1f", new Object[] { Double.valueOf(annotation.max()) }));
/*      */         }
/* 1785 */         StringBuilder info = new StringBuilder();
/* 1786 */         if (annotation.info().length() > 0) {
/* 1787 */           info.append(" -- ");
/* 1788 */           info.append(annotation.info());
/*      */         } 
/*      */         
/* 1791 */         helptext.append(String.format("%s (%s:%s%s)%s\n", new Object[] { key, type.getName(), currentvalue, range, info }));
/*      */         
/* 1793 */         if (cfgHash == currentHash && modprops.containsKey(key)) {
/* 1794 */           String strvalue = modprops.getProperty(key);
/*      */           
/* 1796 */           Object value = null;
/* 1797 */           if (type.isAssignableFrom(String.class)) { value = strvalue; }
/* 1798 */           else if (type.isAssignableFrom(int.class)) { value = Integer.valueOf(Integer.parseInt(strvalue)); }
/* 1799 */           else if (type.isAssignableFrom(short.class)) { value = Short.valueOf(Short.parseShort(strvalue)); }
/* 1800 */           else if (type.isAssignableFrom(byte.class)) { value = Byte.valueOf(Byte.parseByte(strvalue)); }
/* 1801 */           else if (type.isAssignableFrom(boolean.class)) { value = Boolean.valueOf(Boolean.parseBoolean(strvalue)); }
/* 1802 */           else if (type.isAssignableFrom(float.class)) { value = Float.valueOf(Float.parseFloat(strvalue)); }
/* 1803 */           else if (type.isAssignableFrom(double.class))
/* 1804 */           { value = Double.valueOf(Double.parseDouble(strvalue)); }
/*      */           
/* 1806 */           if (value != null) {
/* 1807 */             if (value instanceof Number) {
/* 1808 */               double num = ((Number)value).doubleValue();
/* 1809 */               if (annotation.min() != Double.NEGATIVE_INFINITY && num < annotation.min())
/*      */                 continue; 
/* 1811 */               if (annotation.max() != Double.POSITIVE_INFINITY && num > annotation.max()) {
/*      */                 continue;
/*      */               }
/*      */             } 
/* 1815 */             logger.finer(String.valueOf(key) + " set to " + value);
/* 1816 */             if (!value.equals(currentvalue))
/* 1817 */               field.set((Object)null, value); 
/*      */           }  continue;
/*      */         } 
/* 1820 */         logger.finer(String.valueOf(key) + " not in config, using default: " + currentvalue);
/* 1821 */         modprops.setProperty(key, currentvalue.toString());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1826 */     modprops.put("checksum", Integer.toString(currentHash, 36));
/*      */     
/* 1828 */     if (!modprops.isEmpty() && (modcfgfile.exists() || modcfgfile.createNewFile()) && modcfgfile.canWrite())
/* 1829 */       modprops.store(new FileOutputStream(modcfgfile), helptext.toString()); 
/*      */   }
/*      */   
/*      */   private static void sortModList() throws Exception {
/* 1833 */     HashMap<String, BaseMod> loadedMods = new HashMap<String, BaseMod>();
/* 1834 */     for (BaseMod mod : getLoadedMods()) {
/* 1835 */       loadedMods.put(mod.getClass().getSimpleName(), mod);
/*      */     }
/* 1837 */     LinkedList<BaseMod> newList = new LinkedList<BaseMod>();
/* 1838 */     int pass = 0;
/* 1839 */     while (newList.size() != modList.size() && 
/* 1840 */       pass <= 10) {
/*      */       
/* 1842 */       label81: for (BaseMod mod : modList) {
/* 1843 */         if (newList.contains(mod))
/*      */           continue; 
/* 1845 */         String priority = mod.getPriorities();
/*      */         
/* 1847 */         if (priority == null || priority.length() == 0 || priority.indexOf(':') == -1) {
/* 1848 */           newList.add(mod);
/*      */           
/*      */           continue;
/*      */         } 
/* 1852 */         if (pass > 0) {
/*      */           String[] rules;
/* 1854 */           int newIndex = -1;
/* 1855 */           int max = Integer.MIN_VALUE;
/* 1856 */           int min = Integer.MAX_VALUE;
/* 1857 */           if (priority.indexOf(';') > 0) {
/* 1858 */             rules = priority.split(";");
/*      */           } else {
/* 1860 */             rules = new String[] { priority };
/*      */           } 
/*      */           
/* 1863 */           for (int i = 0; i < rules.length; i++) {
/* 1864 */             String rule = rules[i];
/* 1865 */             if (rule.indexOf(':') != -1) {
/*      */ 
/*      */               
/* 1868 */               String[] keyValuePair = rule.split(":");
/* 1869 */               String key = keyValuePair[0];
/* 1870 */               String value = keyValuePair[1];
/*      */               
/* 1872 */               if (key.contentEquals("required-before") || key.contentEquals("before") || key.contentEquals("after") || key.contentEquals("required-after")) {
/*      */ 
/*      */ 
/*      */                 
/* 1876 */                 if (value.contentEquals("*")) {
/* 1877 */                   if (key.contentEquals("required-before") || key.contentEquals("before")) {
/* 1878 */                     newIndex = 0; break;
/* 1879 */                   }  if (key.contentEquals("required-after") || key.contentEquals("after")) {
/* 1880 */                     newIndex = newList.size();
/*      */                   }
/*      */                   
/*      */                   break;
/*      */                 } 
/* 1885 */                 if ((key.contentEquals("required-before") || key.contentEquals("required-after")) && !loadedMods.containsKey(value)) {
/* 1886 */                   throw new Exception(String.format("%s is missing dependency: %s", new Object[] { mod, value }));
/*      */                 }
/* 1888 */                 BaseMod mod2 = loadedMods.get(value);
/* 1889 */                 if (!newList.contains(mod2)) {
/*      */                   continue label81;
/*      */                 }
/* 1892 */                 int index = newList.indexOf(mod2);
/*      */                 
/* 1894 */                 if (key.contentEquals("required-before") || key.contentEquals("before")) {
/* 1895 */                   newIndex = index;
/* 1896 */                   if (newIndex < min) { min = newIndex; }
/*      */                   else
/* 1898 */                   { newIndex = min; }
/*      */                 
/* 1900 */                 } else if (key.contentEquals("required-after") || key.contentEquals("after")) {
/* 1901 */                   newIndex = index + 1;
/* 1902 */                   if (newIndex > max) { max = newIndex; }
/*      */                   else
/* 1904 */                   { newIndex = max; }
/*      */                 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1912 */           if (newIndex != -1)
/* 1913 */             newList.add(newIndex, mod); 
/*      */         } 
/*      */       } 
/* 1916 */       pass++;
/*      */     } 
/* 1918 */     modList.clear();
/* 1919 */     modList.addAll(newList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void takenFromCrafting(yw player, aan item, io matrix) {
/* 1929 */     for (BaseMod mod : modList) {
/* 1930 */       mod.takenFromCrafting(player, item, matrix);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void takenFromFurnace(yw player, aan item) {
/* 1939 */     for (BaseMod mod : modList) {
/* 1940 */       mod.takenFromFurnace(player, item);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void throwException(String message, Throwable e) {
/* 1948 */     Minecraft game = getMinecraftInstance();
/* 1949 */     if (game != null) { game.a(new ja(message, e)); }
/* 1950 */     else { throw new RuntimeException(e); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void throwException(Throwable e) {
/* 1958 */     throwException("Exception occured in ModLoader", e);
/*      */   }
/*      */ }


/* Location:              C:\Users\na_th_an\Downloads\ModLoader 1.2.5.zip!\ModLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */