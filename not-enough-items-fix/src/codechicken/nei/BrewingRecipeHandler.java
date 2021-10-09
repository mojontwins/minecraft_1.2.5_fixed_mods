/*     */ package codechicken.nei;
/*     */ 
/*     */ import aad;
/*     */ import aan;
/*     */ import alg;
/*     */ import ei;
/*     */ import hg;
/*     */ import hx;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import yr;
/*     */ 
/*     */ public class BrewingRecipeHandler extends TemplateRecipeHandler {
/*     */   public class CachedBrewingRecipe extends TemplateRecipeHandler.CachedRecipe {
/*     */     int hashcode;
/*     */     PositionedStack precursorPotion;
/*     */     PositionedStack result;
/*     */     PositionedStack ingredient;
/*     */     
/*     */     public CachedBrewingRecipe(int ingredID, int basePotionID, int resultDamage) {
/*  26 */       this.precursorPotion = new PositionedStack(new aan(yr.bs.bQ, 1, basePotionID), 51, 35);
/*  27 */       this.ingredient = new PositionedStack(new aan(ingredID, 1, 0), 74, 6);
/*  28 */       this.result = new PositionedStack(new aan(yr.bs.bQ, 1, resultDamage), 97, 35);
/*  29 */       calculateHashcode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PositionedStack getResult() {
/*  35 */       return this.result;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList getIngredients() {
/*  41 */       ArrayList<PositionedStack> recipestacks = new ArrayList();
/*  42 */       recipestacks.add(this.ingredient);
/*  43 */       recipestacks.add(this.precursorPotion);
/*  44 */       return recipestacks;
/*     */     }
/*     */ 
/*     */     
/*     */     private void calculateHashcode() {
/*  49 */       this.hashcode = this.result.item.i() << 16 + this.precursorPotion.item.i();
/*  50 */       this.hashcode = 31 * this.hashcode + (this.ingredient.item.c << 16 + this.ingredient.item.i());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj) {
/*  55 */       if (!(obj instanceof CachedBrewingRecipe)) return false; 
/*  56 */       CachedBrewingRecipe recipe2 = (CachedBrewingRecipe)obj;
/*  57 */       if (this.result.item.i() == recipe2.result.item.i() && 
/*  58 */         this.precursorPotion.item.i() == recipe2.precursorPotion.item.i() && 
/*  59 */         NEIUtils.areStacksSameType(this.ingredient.item, recipe2.ingredient.item)) return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*  64 */       return this.hashcode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   public static final HashSet ingredientIDs = new HashSet();
/*  74 */   public static final HashSet apotions = new HashSet();
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadTransferRects() {
/*  79 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(58, 3, 14, 30), "brewing", new Object[0]));
/*  80 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(92, 3, 14, 30), "brewing", new Object[0]));
/*  81 */     this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(this, new Rectangle(68, 23, 28, 18), "brewing", new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getGuiClass() {
/*  87 */     return hg.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/*  92 */     return "Brewing";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(String outputId, Object... results) {
/*  98 */     if (outputId.equals("brewing") && getClass() == BrewingRecipeHandler.class) {
/*     */       
/* 100 */       for (CachedBrewingRecipe recipe : apotions)
/*     */       {
/* 102 */         this.arecipes.add(recipe);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 107 */       super.loadCraftingRecipes(outputId, results);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadCraftingRecipes(aan result) {
/* 113 */     if (result.c != yr.bs.bQ)
/* 114 */       return;  int damage = result.i();
/*     */     
/* 116 */     for (CachedBrewingRecipe recipe : apotions) {
/*     */       
/* 118 */       if (recipe.result.item.i() == damage)
/*     */       {
/* 120 */         this.arecipes.add(recipe);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadUsageRecipes(aan ingredient) {
/* 127 */     if (ingredient.c != yr.bs.bQ && !ingredientIDs.contains(Integer.valueOf(ingredient.c)))
/*     */       return; 
/* 129 */     for (CachedBrewingRecipe recipe : apotions) {
/*     */       
/* 131 */       if (NEIUtils.areStacksSameType(recipe.ingredient.item, ingredient) || NEIUtils.areStacksSameType(recipe.precursorPotion.item, ingredient))
/*     */       {
/* 133 */         this.arecipes.add(recipe);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiTexture() {
/* 141 */     return "/gui/alchemy.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawForegrounda(GuiManager gui, int recipe) {
/* 146 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 147 */     gui.bindTextureByName("/gui/alchemy.png");
/*     */     
/* 149 */     int t = this.cycleticks % 120 / 4;
/* 150 */     gui.drawTexturedModalRect(92, 5, 176, 0, 8, t + 1);
/* 151 */     t = this.cycleticks % 35;
/* 152 */     gui.drawTexturedModalRect(60, 33 - t, 185, 31 - t, 12, t - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawExtras(GuiManager gui, int recipe) {
/* 158 */     drawProgressBar(gui, 92, 5, 176, 0, 8, 30, 120, 1);
/* 159 */     drawProgressBar(gui, 60, 1, 185, -2, 12, 30, 35, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void searchPotions() {
/* 164 */     TreeSet<Integer> allPotions = new TreeSet();
/* 165 */     HashSet<Integer> nextLevelPotions = new HashSet();
/* 166 */     nextLevelPotions.add(Integer.valueOf(0));
/*     */     
/*     */     do {
/* 169 */       HashSet<Integer> newPotions = new HashSet();
/* 170 */       for (Integer basePotionID : nextLevelPotions) {
/*     */         
/* 172 */         if (ei.c(basePotionID.intValue())) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 177 */         for (Integer ingredID : ingredientIDs) {
/*     */           
/* 179 */           int result = hx.a(basePotionID.intValue(), yr.e[ingredID.intValue()].o());
/*     */           
/* 181 */           if (ei.c(result)) {
/*     */             
/* 183 */             addPotion(ingredID.intValue(), basePotionID.intValue(), result, allPotions, newPotions);
/*     */             continue;
/*     */           } 
/* 186 */           List baseMods = yr.bs.e_(basePotionID.intValue());
/* 187 */           List newMods = yr.bs.e_(result);
/* 188 */           if ((basePotionID.intValue() > 0 && baseMods == newMods) || (
/* 189 */             baseMods != null && (baseMods.equals(newMods) || newMods == null)) || 
/* 190 */             basePotionID.intValue() == result || 
/* 191 */             levelModifierChanged(basePotionID.intValue(), result)) {
/*     */             continue;
/*     */           }
/*     */           
/* 195 */           addPotion(ingredID.intValue(), basePotionID.intValue(), result, allPotions, newPotions);
/*     */         } 
/*     */       } 
/*     */       
/* 199 */       nextLevelPotions = newPotions;
/*     */     }
/* 201 */     while (nextLevelPotions.size() > 0);
/*     */     
/* 203 */     allPotions.add(Integer.valueOf(0));
/* 204 */     API.setItemDamageVariants(yr.bs.bQ, allPotions);
/* 205 */     API.addSetRange("Vanilla.Items.Potions", (new MultiItemRange()).add((yr)yr.bs));
/* 206 */     API.addSetRange("Vanilla.Items.Potions.Splash", (new MultiItemRange()).add((yr)yr.bs, 16384, 32768));
/*     */     
/* 208 */     MultiItemRange positivepots = new MultiItemRange();
/* 209 */     MultiItemRange negativepots = new MultiItemRange();
/* 210 */     MultiItemRange neutralpots = new MultiItemRange();
/*     */     
/* 212 */     for (Iterator<Integer> iterator = allPotions.iterator(); iterator.hasNext(); ) { int potionID = ((Integer)iterator.next()).intValue();
/*     */ 
/*     */       
/* 215 */       List effectlist = yr.bs.e_(potionID);
/* 216 */       int type = 0;
/* 217 */       if (effectlist != null && !effectlist.isEmpty()) {
/*     */         
/* 219 */         Iterator<alg> iterator1 = effectlist.iterator(); if (iterator1.hasNext()) { alg potioneffect = iterator1.next();
/*     */           
/* 221 */           if (aad.a[potioneffect.a()].f()) {
/*     */             
/* 223 */             type = -1;
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 228 */             type = 1;
/*     */           }  }
/*     */       
/*     */       } 
/*     */       
/* 233 */       if (type == 0) {
/*     */         
/* 235 */         neutralpots.add((yr)yr.bs, potionID, potionID); continue;
/*     */       } 
/* 237 */       if (type == 1) {
/*     */         
/* 239 */         positivepots.add((yr)yr.bs, potionID, potionID); continue;
/*     */       } 
/* 241 */       if (type == -1)
/*     */       {
/* 243 */         negativepots.add((yr)yr.bs, potionID, potionID);
/*     */       } }
/*     */ 
/*     */     
/* 247 */     API.addSetRange("Items.Potions.Positive", positivepots);
/* 248 */     API.addSetRange("Items.Potions.Negative", negativepots);
/* 249 */     API.addSetRange("Items.Potions.Neutral", neutralpots);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean levelModifierChanged(int basePotionID, int result) {
/* 254 */     int basemod = basePotionID & 0xE0;
/* 255 */     int resultmod = result & 0xE0;
/*     */     
/* 257 */     return (basemod != 0 && basemod != resultmod);
/*     */   }
/*     */ 
/*     */   
/*     */   private void addPotion(int ingred, int basePotion, int result, TreeSet<Integer> allPotions, HashSet<Integer> newPotions) {
/* 262 */     apotions.add(new CachedBrewingRecipe(ingred, basePotion, result));
/* 263 */     if (allPotions.add(Integer.valueOf(result)))
/*     */     {
/* 265 */       newPotions.add(Integer.valueOf(result));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOverlayIdentifier() {
/* 272 */     return "brewing";
/*     */   }
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\BrewingRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */