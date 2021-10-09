package codechicken.nei;

import gb;

public interface IHandleInput {
  boolean canHandle(Class paramClass);
  
  boolean keyTyped(gb paramgb, char paramChar, int paramInt);
  
  boolean mouseClicked(gb paramgb, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\IHandleInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */