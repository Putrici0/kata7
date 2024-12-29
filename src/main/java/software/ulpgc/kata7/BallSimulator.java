package software.ulpgc.kata7;

import java.awt.*;

import javax.swing.*;

public class BallSimulator extends JPanel{

    private final Ball ball;
    private final double gravity;
    private final double height;
    private double velocity = 0;
    private double ballY;
    private final int groundLevel;

    public BallSimulator(double gravity, double initialHeight, Ball ball) {
        this.gravity = gravity;
        this.height = initialHeight;
        this.ball = ball;

        groundLevel = 900;

        ballY = calculateInitialY();

        Timer timer = new Timer(1, _ -> updateSimulation());
        timer.start();
    }

    private void updateSimulation() {
        updateVelocity();
        updateBallPosition();

        if (isBallOnGround()) {

            handleGroundCollision();
        }

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
        g.fillOval(getWidth() / 2 - (int) ball.radius(), (int) ballY, (int) (ball.radius()*2), (int) (ball.radius()*2));
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void handleGroundCollision() {
        ballY = groundLevel - ball.radius()*2;
        invertVelocity();
    }

    private void invertVelocity() {
        velocity = -velocity * ball.restitution();
    }

    private boolean isBallOnGround() {
        return ballY >= groundLevel - ball.radius()*2;
    }

    private void updateBallPosition() {
        ballY += velocity;
    }

    private void updateVelocity() {
        velocity += calculateGravityEffect();
    }

    private double calculateGravityEffect() {
        return gravity * 0.016;
    }

    private double calculateInitialY() {
        return groundLevel - height;
    }
}
