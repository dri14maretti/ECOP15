// Fig. 12.32: Shapes2.java
// Demonstrating a general path.
import java.awt.Color;
import javax.swing.JFrame;

public class Shapes2
{
   public static void main( String[] args )
   {
      JFrame frame = new JFrame( "Desenhando formas em 2D" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      Shapes2JPanel shapes2JPanel = new Shapes2JPanel(); 
      frame.add( shapes2JPanel ); 
      frame.setBackground( Color.WHITE );
      frame.setSize( 315, 330 ); 
      frame.setVisible( true ); 
   } 
}