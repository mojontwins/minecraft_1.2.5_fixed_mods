package codechicken.nei;

import dd;
import gb;
import java.util.ArrayList;
import java.util.List;

public interface IRecipeHandler {
  String getRecipeName();
  
  int getNumRecipes();
  
  void drawBackground(GuiManager paramGuiManager, int paramInt);
  
  void drawForeground(GuiManager paramGuiManager, int paramInt);
  
  ArrayList getIngredientStacks(int paramInt);
  
  ArrayList getOtherStacks(int paramInt);
  
  PositionedStack getResultStack(int paramInt);
  
  void onUpdate();
  
  boolean hasOverlay(gb paramgb, dd paramdd, int paramInt);
  
  IRecipeOverlayRenderer getOverlayRenderer(gb paramgb, int paramInt);
  
  int getRecipiesPerPage();
  
  List handleTooltip(GuiRecipe paramGuiRecipe, List paramList, int paramInt);
  
  boolean keyTyped(GuiRecipe paramGuiRecipe, char paramChar, int paramInt1, int paramInt2);
  
  boolean mouseClicked(GuiRecipe paramGuiRecipe, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\IRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */