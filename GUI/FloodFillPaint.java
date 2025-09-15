import javax.swing.*;
import java.awt.*;

public class FloodFillPaint {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Tool");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);

            // Create the drawing panel
            PaintTool paintTool = new PaintTool();

            // Color picker panel
            JPanel colorTray = new JPanel();
            colorTray.setLayout(new FlowLayout(FlowLayout.LEFT));

            // Create
            JButton blueButton = new JButton();
            blueButton.setBackground(Color.BLUE);
            blueButton.setPreferredSize(new Dimension(40, 40));
            blueButton.addActionListener(e -> paintTool.setCurrentColor(Color.BLUE));

            JButton redButton = new JButton();
            redButton.setBackground(Color.RED);
            redButton.setPreferredSize(new Dimension(40, 40));
            redButton.addActionListener(e -> paintTool.setCurrentColor(Color.RED));

            JButton greenButton = new JButton();
            greenButton.setBackground(Color.GREEN);
            greenButton.setPreferredSize(new Dimension(40, 40));
            greenButton.addActionListener(e -> paintTool.setCurrentColor(Color.GREEN));

            JButton pinkButton = new JButton();
            pinkButton.setBackground(Color.PINK);
            pinkButton.setPreferredSize(new Dimension(40, 40));
            pinkButton.addActionListener(e -> paintTool.setCurrentColor(Color.PINK));

            colorTray.add(blueButton);
            colorTray.add(redButton);

            colorTray.add(greenButton);
            colorTray.add(pinkButton);

            // Shape selection panel
            JPanel shapeTray = new JPanel();
            shapeTray.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton ovalButton = new JButton("Oval");
            ovalButton.addActionListener(e -> paintTool.setCurrentShape("Oval"));

            JButton rectButton = new JButton("Rectangle");
            rectButton.addActionListener(e -> paintTool.setCurrentShape("Rectangle"));

            shapeTray.add(ovalButton);
            shapeTray.add(rectButton);

            // Layout for the frame
            frame.setLayout(new BorderLayout());
            frame.add(colorTray, BorderLayout.NORTH);
            frame.add(paintTool, BorderLayout.CENTER);
            frame.add(shapeTray, BorderLayout.SOUTH);

            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true);
        });
    }
}
