/*
 * File Name: FrequencyCount.java
 *   Created: Apr 29, 2021
 *    Author: 
 */

public class FrequencyCount extends Object
{
  //This is the only method that you need to complete, but look at the 
  //code below to make sure your method does the correct thing...
  public void updateFrequencyTable(String s)
  {
    int x = 0;
     for (; x<s.length();x++){
       
       if ((int)s.charAt(x)<128){
       frequency[(int)s.charAt(x)]++;
     }}
    //  System.out.println(x);
  }


  private static final int TABLE_SIZE = 128;

  private int[] frequency = new int[TABLE_SIZE];
        
  public FrequencyCount(String s)
  {
    this.updateFrequencyTable(s);
  }
  
  public FrequencyCount(String[] many)
  {
    for (String m : many) this.updateFrequencyTable(m);
  }
  


  public int[] getFrequencyArray()
  {
    int[] f = new int[TABLE_SIZE];
    for (int m = 0; m < TABLE_SIZE; m++) f[m] = frequency[m];
    return f;
  }
  
  @Override
  public String toString()
  {
    return toStringTable(false);
  }
  
  public String toStringAll()
  {
    return toStringTable(true);
  }
  
  private String toStringTable(boolean showAll)
  {
    StringBuffer s = new StringBuffer("CHAR  FREQUENCY\n----  ---------\n");
    for (int m = 0; m < TABLE_SIZE; m++)
    {
      if (frequency[m] > 0 || showAll == true)
      {
        char c = (char)m;
        if (c < 32)
        {
          s.append("  \\");
          if (c == '\n')  s.append("n");
          if (c == '\r')  s.append("r");
          if (c == '\t')  s.append("t");
          s.append("  ");
        }
        else
        {
          s.append("   "+c+"  ");
        }
        s.append(frequency[m]+"\n");
      }
    }
    return s.toString();
  }


  
}
