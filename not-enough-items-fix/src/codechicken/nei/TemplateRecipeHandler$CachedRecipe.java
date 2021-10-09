/*     */ package codechicken.nei;
/*     */ 
/*     */ import aan;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Random;
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
/*     */ public abstract class CachedRecipe
/*     */ {
/*     */   public abstract PositionedStack getResult();
/*     */   
/*     */   public ArrayList getIngredients() {
/*  45 */     ArrayList<PositionedStack> stacks = new ArrayList();
/*  46 */     PositionedStack stack = getIngredient();
/*  47 */     if (stack != null)
/*  48 */       stacks.add(stack); 
/*  49 */     return stacks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PositionedStack getIngredient() {
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList getOtherStacks() {
/*  67 */     ArrayList<PositionedStack> stacks = new ArrayList();
/*  68 */     PositionedStack stack = getOtherStack();
/*  69 */     if (stack != null)
/*  70 */       stacks.add(stack); 
/*  71 */     return stacks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PositionedStack getOtherStack() {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList getCycledIngredients(int cycle, ArrayList<PositionedStack> ingredients) {
/*  89 */     ArrayList<PositionedStack> cycledstacks = new ArrayList();
/*  90 */     for (int itemIndex = 0; itemIndex < ingredients.size(); itemIndex++) {
/*     */       
/*  92 */       PositionedStack stack = ((PositionedStack)ingredients.get(itemIndex)).copy();
/*  93 */       if (stack.items.length > 1) {
/*     */ 
/*     */         
/*  96 */         Random rand = new Random((cycle + itemIndex) + this.offset);
/*  97 */         stack.setPermutationToRender(Math.abs(rand.nextInt()) % stack.items.length);
/*     */ 
/*     */       
/*     */       }
/* 101 */       else if (stack.item.i() == -1) {
/*     */         
/* 103 */         int maxDamage = 0;
/*     */         
/*     */         do {
/* 106 */           maxDamage++;
/* 107 */           stack.item.b(maxDamage);
/*     */         }
/* 109 */         while (NEIUtils.isValidItem(stack.item));
/*     */         
/* 111 */         stack.item.b(cycle % maxDamage);
/*     */       } 
/*     */       
/* 114 */       cycledstacks.add(stack);
/*     */     } 
/* 116 */     return cycledstacks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceMetaOnIngredients(Collection ingredients, aan ingredient) {
/* 125 */     for (PositionedStack stack : ingredients) {
/*     */       
/* 127 */       for (int i = 0; i < stack.items.length; i++) {
/*     */         
/* 129 */         if (NEIUtils.areStacksSameTypeCrafting(ingredient, stack.items[i])) {
/*     */           
/* 131 */           stack.item = stack.items[i];
/* 132 */           stack.item.b(ingredient.i());
/* 133 */           stack.items = new aan[] { stack.item };
/* 134 */           stack.setPermutationToRender(0);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Collection ingredients, aan ingredient) {
/* 147 */     for (PositionedStack stack : ingredients) {
/*     */       byte b; int i; aan[] arrayOfAan;
/* 149 */       for (i = (arrayOfAan = stack.items).length, b = 0; b < i; ) { aan item = arrayOfAan[b];
/*     */         
/* 151 */         if (NEIUtils.areStacksSameTypeCrafting(item, ingredient))
/* 152 */           return true;  b++; }
/*     */     
/*     */     } 
/* 155 */     return false;
/*     */   }
/*     */   
/* 158 */   final long offset = System.currentTimeMillis();
/*     */ }


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TemplateRecipeHandler$CachedRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */