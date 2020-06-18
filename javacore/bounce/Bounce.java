package javacore.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 弹跳球游戏，碰到墙壁重新开始
 * 本程序 展示一个弹力球
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * 有球组件和button的帧
 */
class BounceFrame extends JFrame {
    private static final int STEPS = 1000;
    private static final int DELAY = 3;
    private static final long serialVersionUID = -8967952730540159602L;
    private final BallComponent comp;

    /**
     * 构造一个帧，展示球，和开始结束button
     */
    BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        BounceFrame.addButton(buttonPanel, "Start", e -> addBall());
        BounceFrame.addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * 增加一个button到容器里
     *
     * @param c
     * @param title
     * @param listener
     */
    private static void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * 增加一个弹力球并让他弹1000次
     */
    private void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        /*
        想把代码放在一个独立的线程里，只需要实现一个Runnable类，将代码放进去
        然后构造一个Thread 类，start它

        构造一个Thread类的子类，然后调用 start 并不推荐，因为每个任务创建一个线程，付出代价太大了，可以使用线程池
       如果不调用Thread类，直接调用run方法，只会执行同一个线程的任务，不会启动新线程，应该调用Thread.start 才会创建新线程
         */
        Runnable r = () -> {
            for (int i = 0; i < BounceFrame.STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                try {
                    Thread.sleep(BounceFrame.DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        /*
        线程的状态 New Runnable可运行 Blocked Waiting Timedwaiting Terminated被终止
        新创建 在线程运行之前的基础工作
        可运行 也可能没有运行，没有分到时间片 服务器操作系统 抢占式调度 手机小型设备 协作式调度
        被阻塞 试图获得一个内部锁（不是concurrent库中的锁），会进入阻塞状态
        等待 直到另一个线程通知 或等待concurrent库中的锁 或计时等待 但等到了也不一定运行，还要看优先级
        被终止 正常退出 未捕获异常 Interrupt（）请求属于正常退出
         */
        /*
        线程属性

         Java优先级（1~10）Windows 1~7 yield()方法，让当前线程让步状态，将调度优先级不低于它的线程

         守护线程 setDaemon 将线程转换为守护线程
         唯一用途 为其他线程提供服务 比如计时线程 发送计时滴答给其他线程，
          当只剩下守护线程，程序终止，虚拟机退出
          守护线程不应该访问固有资源，文件数据等

          线程组 统一管理线程的集合
           不建议在自己的程序里使用线程组
           异常处理器
           当线程死亡后，将异常信息发送到日志文件，不安装时，使用线程组来作为这个处理器
         */
        /*
        同步 多个线程 需要共享对同一数据的存取

        竞争条件 race condition
        同步存取
         */
        Thread t = new Thread(r);
        t.start();
    }
}