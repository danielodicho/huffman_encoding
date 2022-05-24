/*
 * File Name: Heap.java
 *   Created: Feb 08, 2022
 *    Author: Daniel Odicho
 */

public class PriorityQueue<ItemType extends Comparable>
{
  private ItemType[] list;
  private int nextOpenIndex;

  public PriorityQueue(int initCap)
  {
    if (initCap < 1) initCap = 1;
    list = (ItemType[]) new Comparable[initCap];
    nextOpenIndex = 0;
  }

  public boolean isEmpty()
  {
    return nextOpenIndex == 0;
  }

  public ItemType peekMin()
  {
    if (this.isEmpty()) throw new Error("Empty Heap");
    return list[0];
  }

  public void add(ItemType d)
  {
    if (nextOpenIndex == list.length)
    {
      ItemType[] temp = (ItemType[]) new Comparable[list.length*2];
      for (int m = 0; m < list.length; m++) temp[m] = list[m];
      list = temp;
    }
    list[nextOpenIndex] = d;
    int c = nextOpenIndex;
    nextOpenIndex++;
    int p = (c-1) / 2;
    
    while (c > 0 && (list[p].compareTo(list[c]) > 0))
    {
      ItemType temp = list[p];
      list[p] = list[c];
      list[c] = temp;
      c = p;
      p = (c-1) / 2;
    }
  }

  public ItemType removeMin()
  {
    if (this.isEmpty()) throw new Error("Empty Heap");
    ItemType retVal = list[0];
    nextOpenIndex--;
    if (nextOpenIndex > 0)
    {
      list[0] = list[nextOpenIndex];
      int p = 0, lc = 1, rc = 2;
      while (lc < nextOpenIndex)
      {
        int swapWith = lc;
        
        if (rc < nextOpenIndex && (list[lc].compareTo(list[rc]) >0)) swapWith = rc;
        
        if (list[p].compareTo(list[swapWith])<0) break;
        ItemType temp = list[p];
        list[p] = list[swapWith];
        list[swapWith] = temp;
        p = swapWith;
        lc = p * 2 + 1;
        rc = lc + 1;
      }
    }
    list[nextOpenIndex]=null;
    return retVal;
  }



}