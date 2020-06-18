package javacore.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 绘制球的组件
 */
class BallComponent extends JPanel {
    private static final long serialVersionUID = -6511452480898554430L;
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HIGHT = 350;

    private final List<Ball> balls = new ArrayList<>();

    /**
     * 增加一个球到组件里
     *
     * @param b
     */
    public void add(Ball b) {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BallComponent.DEFAULT_WIDTH, BallComponent.DEFAULT_HIGHT);
    }
}
