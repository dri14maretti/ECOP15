// Fig. 12.28: DrawPolygons.java
// Drawing polygons.
import javax.swing.JFrame;

public class DesenhaPoligonos 
{
   // execute application
   public static void main( String[] args )
   {
      // create frame for PolygonsJPanel
      JFrame frame = new JFrame( "Drawing Polygons" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      Poligonos polygonsJPanel = new Poligonos(); 
      frame.add( polygonsJPanel );
      frame.setSize( 280, 270 ); 
      frame.setVisible( true );
   } 
} 