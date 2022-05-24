/*
 * File Name: Main.Main
 *   Created: Feb 14, 2022
 *    Author: 
 */

public class Main extends Object
{
  public static void main(String[] args)
  {
    Main.runFrequencyCountTests();
    Main.runHuffmanTests();
  }
  
      private static void runFrequencyCountTests()
  {
    // In input = null;
    // String s = "the cat in the hat";
    // System.out.println("Instantiating fc0 with: "+s);
    // FrequencyCount fc0 = new FrequencyCount(s);
    // System.out.println(fc0);
    
    
    // s = "thin ice heat nice";
    // System.out.println("Adding to fc0: "+s);
    // fc0.updateFrequencyTable(s);
    // System.out.println(fc0);
    
    
    
    // s = "Pease porridge hot\nPease porridge cold\nPease porridge in the pot\nNine days old\nSome like it hot\nSome like it cold\nSome like it in the pot\nNine days old\n";
    // System.out.println("Adding to fc0:\n"+s);
    // fc0.updateFrequencyTable(s);
    // System.out.println(fc0);
    
    
    
    // System.out.println("Instantiating fc1 with the file named \"Gatsby.txt\"");
    // input = new In("Gatsby.txt");
    // FrequencyCount fc1 = new FrequencyCount(input.readAll());
    // System.out.println(fc1);
    

    
    // System.out.println("Instantiating fc2 with the file named \"moby.txt\"");
    // input = new In("moby.txt");
    // FrequencyCount fc2 = new FrequencyCount(input.readAll());
    // System.out.println(fc2);
    
    
    
    // System.out.println("Instantiating fc3 with the file named \"sample1.txt\"");
    // input = new In("sample1.txt");
    // FrequencyCount fc3 = new FrequencyCount(input.readAll());
    // System.out.println(fc3);
        
    
  }
  
  private static void runHuffmanTests()
  {
    In input = new In("moby.txt");
    String s = input.readAll();
    Huffman h = new Huffman(s);
   
    String encoded = h.encode(s);

    System.out.print(encoded.length()/(s.length()*7.0));
    
    // System.out.print(h);
    // System.out.print("h");

    
    
    // System.out.println(encoded);
    String decoded = h.decode(encoded);
    // System.out.println(decoded);
    
    //More tests needed...
  }
}
