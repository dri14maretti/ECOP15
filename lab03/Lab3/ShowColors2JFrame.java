// Fig. 15.7: ShowColors2JFrame.java
// Choosing colors with JColorChooser.
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowColors2JFrame extends JFrame {

    private JButton changeColorJButton;
    private Color color = Color.LIGHT_GRAY;
    private JPanel colorJPanel;

    // set up GUI
    public ShowColors2JFrame() {
        super("Using JColorChooser");

        // create JPanel for display color
        colorJPanel = new JPanel();
        colorJPanel.setBackground(color);

        // set up changeColorJButton and register its event handler
        changeColorJButton = new JButton("Change Color");
        changeColorJButton.addActionListener(
                new ActionListener() // anonymous inner class
        {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event) {
                color = JColorChooser.showDialog(
                        ShowColors2JFrame.this, "Choose a color", color);

                // set default color, if no color is returned
                if (color == null) {
                    color = Color.LIGHT_GRAY;
                }
                // change content pane's background color
                colorJPanel.setBackground(color);
            } // end method actionPerformed
        } // end anonymous inner class
                ); // end call to addActionListener

        add(colorJPanel, BorderLayout.CENTER); // add colorJPanel
        add(changeColorJButton, BorderLayout.SOUTH); // add button

        setSize(400, 130); // set frame size
        setVisible(true); // display frame
    } // end ShowColor2JFrame constructor
} // end class ShowColors2JFrame