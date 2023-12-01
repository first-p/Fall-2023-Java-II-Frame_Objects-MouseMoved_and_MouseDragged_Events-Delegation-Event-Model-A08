import java.awt.*;
import java.awt.event.*;

public class Proj08Runner extends Frame {
    private int xCoor;
    private int yCoor;
    private boolean isDragging = false; // Flag to indicate dragging

    // Constructor for Proj08Runner
    public Proj08Runner() {
        // Call the constructor of Frame to set the title
        super("Proj08 - Fred Butoma");

        // Set the size of the frame
        setSize(300, 100);

        // Set the frame to exit on close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Add a mouse motion listener to handle mouse drag events
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Update coordinates with mouse drag
                xCoor = e.getX();
                yCoor = e.getY();

                // Repaint the frame to show the new coordinates
                repaint();
            }

            public void mouseMoved(MouseEvent e) {
                if (!isDragging) { // Only update when not dragging
                    // Update coordinates with mouse move
                    xCoor = e.getX();
                    yCoor = e.getY();

                    // Repaint the frame to show the new coordinates
                    repaint();
                }
            }
        });

        // Add a mouse listener to track the mouse pressed and released events
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                isDragging = true; // Set the flag when mouse is pressed
            }

            public void mouseReleased(MouseEvent e) {
                isDragging = false; // Clear the flag when mouse is released
                repaint(); // Repaint to show the coordinates in black again
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    // Override the paint method to draw the coordinates
    public void paint(Graphics g) {
        // Call the superclass's paint method
        super.paint(g);

        // Set the text color based on the isDragging flag
        if (isDragging) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }

        // Draw the string at the current x,y coordinates
        g.drawString(xCoor + ", " + yCoor, xCoor, yCoor);
    }

}
