package gui;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortVisualizerPanel extends JPanel {

    private int[] array;
    private int[] currentArray;

    public SortVisualizerPanel(int size) {
        array = new int[size];
        generateRandomArray();
        currentArray = Arrays.copyOf(array, array.length);
        setPreferredSize(new Dimension(800, 400));
    }

    public void generateRandomArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * getHeight());
        }
        currentArray = Arrays.copyOf(array, array.length);
        repaint();
    }

    public void startSorting(SortAlgorithm algorithm) {
        new Thread(() -> {
            try {
                algorithm.sort(currentArray, current -> {
                    currentArray = current;
                    repaint();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentArray == null) return;

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / currentArray.length;

        for (int i = 0; i < currentArray.length; i++) {
            g.setColor(Color.BLUE);
            int barHeight = currentArray[i];
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }
}
