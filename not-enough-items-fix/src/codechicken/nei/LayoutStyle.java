package codechicken.nei;

public abstract class LayoutStyle {
  public abstract void init();
  
  public abstract void reset();
  
  public abstract void position(Button paramButton, GuiManager paramGuiManager);
  
  public abstract String getName();
  
  public void drawBackground(GuiManager gui) {}
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\LayoutStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */