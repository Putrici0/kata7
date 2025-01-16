package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Ball;

import javax.swing.*;
import java.awt.*;

public class BallView extends JPanel {
    private final Ball ball;
    private double ballY;
    private final int groundLevel;

    public BallView(Ball ball, double initialBallY, int groundLevel) {
        this.ball = ball;
        this.ballY = initialBallY;
        this.groundLevel = groundLevel;
    }

    public void updateBallPosition(double ballY) {
        this.ballY = ballY;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawBall(g);
        drawGround(g);
    }

    private void drawGround(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, groundLevel, getWidth(), groundLevel);
    }

    private void drawBall(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getWidth() / 2 - (int) ball.radius(), (int) ballY,
                (int) (ball.radius() * 2), (int) (ball.radius() * 2));
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
