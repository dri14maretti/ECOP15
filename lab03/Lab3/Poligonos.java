
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Poligonos extends JPanel 
{
   // draw polygons and polylines
   public void paintComponent( Graphics graphics )
   {
      super.paintComponent( graphics );
      int[] xPoligono1 = { 20, 40, 50, 30, 20, 15 };
      int[] yPoligono1 = { 50, 50, 60, 80, 80, 60 };
      Polygon poligono1 = new Polygon( xPoligono1, yPoligono1, 6 );
      graphics.drawPolygon( poligono1 );

      int[] xPoligono2 = { 70, 90, 100, 80, 70, 65, 60 };
      int[] yPoligono2 = { 100, 100, 110, 110, 130, 110, 90 };
      graphics.drawPolyline( xPoligono2, yPoligono2, 7 );

      int[] xPoligono3 = { 120, 140, 150, 190 };
      int[] yPoligono3 = { 40, 70, 80, 60 };
      graphics.fillPolygon( xPoligono3, yPoligono3, 4 );

      Polygon polygon2 = new Polygon();
      polygon2.addPoint( 165, 135 );
      polygon2.addPoint( 175, 150 );
      polygon2.addPoint( 270, 200 );
      polygon2.addPoint( 200, 220 );
      polygon2.addPoint( 130, 180 );
      graphics.fillPolygon( polygon2 );
   } 
} 
