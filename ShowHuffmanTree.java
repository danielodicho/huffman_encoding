import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;

public class ShowHuffmanTree extends JPanel
{
  private int panelWidth = 1024, panelHeight = 512;
  private HNode root;
  private Font f = new Font(Font.MONOSPACED, Font.BOLD, 14);

  public ShowHuffmanTree(HNode r, int w, int h)
  {        
    root = r;
    if (w < 400) w = 400;
    if (h < 200) h = 200;

    super.setBackground(new Color(225, 225, 225));
    super.setPreferredSize(new java.awt.Dimension(panelWidth, panelHeight));
    super.setMinimumSize(new java.awt.Dimension(panelWidth, panelHeight));
    super.setMaximumSize(new java.awt.Dimension(panelWidth, panelHeight));

    
    Dimension appSize = new Dimension(w, h);
    JScrollPane jsp = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    jsp.setPreferredSize(appSize);
    jsp.setMinimumSize(appSize);
    jsp.setMaximumSize(appSize);
    jsp.setRowHeaderView(jsp.getVerticalScrollBar());
    jsp.setColumnHeaderView(jsp.getHorizontalScrollBar());


    JFrame.setDefaultLookAndFeelDecorated(false);
    java.awt.EventQueue.invokeLater( 
    new Runnable() 
    { 
      public void run() 
      {
        JFrame fr = new JFrame("Visualization of your Huffman Tree");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocation(10, 10);
        fr.setContentPane(jsp);
        fr.pack();
        fr.setVisible(true);
      }
    } 
    );
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    this.update(g, root, panelWidth/2, 15, panelWidth);
  }

  private void update(Graphics g, HNode h, int x, int y, int w)
  {
    g.setColor(Color.RED);
    g.setFont(f);
    if (h != null) g.drawString(h.toString(), x - 0, y);
    HNode L = h.getLeft(), R = h.getRight();
    g.setColor(Color.DARK_GRAY);
    if (L != null)
    {
      g.drawLine(x, y+5, x - w/4, y+50);
      update(g, L, x - w/4, y + 50, w / 2);
    }
    if (R != null)
    {
      g.drawLine(x, y+5, x + w/4, y+50);
      update(g, R, x + w/4, y + 50, w / 2);
    }
  }


}