import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PaintTool extends JPanel {
    private BufferedImage canvas;
    private Color currentColor = Color.RED;
    private String currentShape = "Oval"; // Default shape is Oval

    private int startX, startY, endX, endY;

    public PaintTool() {
        // Initialize the canvas
        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        clearCanvas();

        // Mouse listener to draw shapes
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawShape(startX, startY, endX, endY);
                repaint();
            }
        });
    }

    // Draw the selected shape on the canvas
    private void drawShape(int startX, int startY, int endX, int endY) {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(currentColor);

        if ("Oval".equals(currentShape)) {
            g2d.fillOval(Math.min(startX, endX), Math.min(startY, endY), Math.abs(endX - startX),
                    Math.abs(endY - startY));
        } else if ("Rectangle".equals(currentShape)) {
            g2d.fillRect(Math.min(startX, endX), Math.min(startY, endY), Math.abs(endX - startX),
                    Math.abs(endY - startY));
        }

        g2d.dispose();
    }

    // Clear the canvas
    public void clearCanvas() {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }
}
