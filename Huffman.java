/*
 * File Name: Huffman.java
 *   Created: Feb 14, 2022
 *    Author: 
 */
import java.util.HashMap;

public class Huffman extends Object
{
  //Add instance variables as you see fit...
  FrequencyCount fqTable;
  HNode hn;
  PriorityQueue<HNode> pq;
  HNode compN;
  HNode root;
  String[] path1;
  
  // precondition: text is non-null, non-empty
  //
  //postcondition: a Huffman tree using only the characters in the text has been
  //               built based on the frequency count of characters within the text
  public Huffman(String... text)
  {
    
    pq = new PriorityQueue<>(2);
    fqTable = new FrequencyCount(text);
    // System.out.print(fqTable.getFrequencyArray()[85]);
    for (int x = 0; x<128; x++){
      if (fqTable.getFrequencyArray()[x] != 0){
        // System.out.print(fqTable.getFrequencyArray()[x]);
        // System.out.print((char)x);
        hn = new HNode((char)x, fqTable.getFrequencyArray()[x]);
        
        pq.add(hn);
      } 
    }

    char s = '/';
    // StringBuilder result = new StringBuilder();
    while (!pq.isEmpty()){
        HNode l = pq.removeMin();
        if (!pq.isEmpty()){
        HNode r = pq.removeMin();
        compN = new HNode(s, (l.weight+r.weight)  , l, r);
        // System.out.println(pq.peekMin());
        pq.add(compN);
        }
        else{
        root = l;  
        }
    }
   
    // HashMap<String, String> letters = new HashMap<>();
    
      path1 = new String[128];

      leafPathFinder(this.root, "");
      // System.out.print(java.util.Arrays.toString(path1));
          
    

    

    new ShowHuffmanTree(root, 750, 550);
  }


  public void leafPathFinder(HNode x,String path){

    // String path = "";
  if (x.left == null && x.right == null){
      path1[(int)x.symbol] = path;
      path = "";
    // return path;
  }

    if (x.left != null  ){
      // System.out.print(x.left.symbol);
      // path+= "0";
     leafPathFinder(x.left, path+"0");  
      // leafPathFinder(x.right, path+="1");  
    }
    if (x.right != null){
      // path+= "1";
    leafPathFinder(x.right, path+"1");
      }

    // return path;

        
  }
  
  
  // precondition: path is non-null, non-empty, and a valid sequence of
  //               0s and 1s for the Huffman tree created in the constructor
  //
  //postcondition: returns a Huffman decoded String based on the path
  public String decode(String path)
  {
    // "01010101"
    String decoded = "";
    // System.out.print(this.root.right.right.right.left.symbol);
    HNode y = this.root;
    for (int x = 0; x<path.length(); x++){
      if (y.isLeaf()){
        
        decoded += y.symbol;
        y = this.root;
      }
      else{
        if (path.charAt(x) == '0'){
          y = y.left;
          

                if (y.isLeaf()){
        
        decoded += y.symbol;
        y = this.root;
      }
          }
        else if (path.charAt(x)== '1'){
          y = y.right;


                if (y.isLeaf()){
        
        decoded += y.symbol;
        y = this.root;
      }
        }
        }
    }

    

    return decoded;
    
  }
  
  
  
  // precondition: text2 is non-null, non-empty and contains only the characters found
  //               in the text that was used in the constructor; text 2 *may* be the 
  //               same as the text used in the constructor, but is not necessarily
  //               the same (text2 may only contain the characters from text)
  //
  //postcondition: returns a Huffman encoded String of 0s and 1s that represents
  //               the text2
  public String encode(String text2)
  {
   String epath= "";
  for (int x = 0; x<text2.length();x++){
      epath+= encodeLetter(text2.charAt(x));
    
  }    
    return epath;
  
  }
  
  
  
  // precondition: ch is a character found in the text that was used in the constructor
  //               in the constructor
  //
  //postcondition: returns a Huffman encoded String of 0s and 1s that represents
  //               the character ch
  public String encodeLetter(char ch)
  {
    return path1[ch];
    // return this.letters.get(ch);
    
  }
}
