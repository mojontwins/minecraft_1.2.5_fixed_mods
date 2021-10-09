package codechicken.nei;

import aak;
import aan;

public interface IInfiniteItemHandler {
  void onPickup(aan paramaan);
  
  void onPlaceInfinite(aan paramaan);
  
  boolean canHandleItem(aan paramaan);
  
  boolean isItemInfinite(aan paramaan);
  
  void replenishInfiniteStack(aak paramaak, int paramInt);
  
  aan getInfiniteItem(aan paramaan);
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\IInfiniteItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */