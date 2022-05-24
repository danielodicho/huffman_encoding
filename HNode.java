/*
 * File Name: HNode.java
 *   Created: Feb 14, 2022
 *    Author: 
 */
public class HNode extends Object implements Comparable
{
  //Add instance variables as you see fit...
  char symbol;
  public int weight;
  HNode left;
  HNode right;
  
  
  
  public HNode(char symbol, int weight, HNode left, HNode right)
  {
    this.symbol = symbol;
    this.weight = weight;
    this.left = left;
    this.right = right;

  }
public HNode(char symbol, int weight){
  this(symbol, weight, null, null);
}
  
  
  public boolean isLeaf()
  {
    if ((left == null) && (right == null)) return true;
   
    return false;
  }
  
  public int getWeight()
  {
    return weight;
  }
  
  public char getLetter()
  {
    return symbol;
  }
  
  public HNode getLeft()
  {
    return left;
  }
  
  public HNode getRight()
  {
    return right;
  }
  
  public void setLeft(HNode left1)
  {
    left = left1;
  }
  
  public void setRight(HNode right1)
  {

    right = right1;
  }
  
  public void setWeight(int newWeight)
  {
    weight = newWeight;
  }
  
  public void setLetter(char newLetter)
  {
      symbol = newLetter;
  }
  
  @Override
  public int compareTo(Object obj)
  {
    HNode x = (HNode) obj;

    if( this.weight > x.weight) return 1;
    else if (this.weight < x.weight) return -1;
    return 0;
  }
  
    public String toString()
  {
    String s = "";
    
    if (getLetter() == '\n') s+= "\\n "; 
    else if (getLetter() == '\r') s+= "\\r ";
    else if (getLetter() == '\t') s+= "\\t ";
    else if (getLetter() == ' ') s += "sp ";
    else if (getLetter() > 32) s += " "+getLetter()+" ";
    else s += "-- ";

    s += getWeight();
    return s;
  }
}
