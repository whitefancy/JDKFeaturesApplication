package javacore.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 一个可以移动并且碰到矩形就反弹的球
 */
class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * 获得球当前的位置和形状
     *
     * @return
     */
    Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, Ball.XSIZE, Ball.YSIZE);
    }

    /**
     * 移动到下一个位置，反方向如果触到边界
     *
     * @param bounds
     */
    void move(Rectangle2D bounds) {
        x += dx + Math.random();
        y += dy + Math.random();

        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + Ball.XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - Ball.XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + Ball.YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - Ball.YSIZE;
            dy = -dy;
        }
    }
}
