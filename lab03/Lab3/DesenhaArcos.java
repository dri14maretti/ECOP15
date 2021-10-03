// Fig. 12.25: DrawArcs.java
// Drawing arcs.
import javax.swing.JFrame;

public class DesenhaArcos {
   public static void main( String[] args ) {
      // create frame for ArcsJPanel
      JFrame frame = new JFrame( "Drawing Arcs" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      ArcsJPanel arcsJPanel = new ArcsJPanel(); 
      frame.add( arcsJPanel ); 
      frame.setSize( 300, 210 ); 
      frame.setVisible( true ); 
   }
} 
