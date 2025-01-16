package software.ulpgc.kata7.control;

import software.ulpgc.kata7.model.Ball;
import software.ulpgc.kata7.view.BallView;

import javax.swing.*;

public class BallController {
    private final Ball ball;
    private final BallView view;
    private final double gravity;
    private double velocity = 0;
    private double ballY;
    private final int groundLevel;

    public BallController(Ball ball, BallView view, double gravity, double initialHeight, int groundLevel) {
        this.ball = ball;
        this.view = view;
        this.gravity = gravity;
        this.ballY = groundLevel - initialHeight;
        this.groundLevel = groundLevel;

        Timer timer = new Timer(1, _ -> updateSimulation());
        timer.start();
    }

    private void updateSimulation() {
        updateVelocity();
        updateBallPosition();

        if (isBallOnGround()) {
            handleGroundCollision();
        }

        view.updateBallPosition(ballY);
    }

    private void updateVelocity() {
        velocity += gravity * 0.016;
    }

    private void updateBallPosition() {
        ballY += velocity;
    }

    private boolean isBallOnGround() {
        return ballY >= groundLevel - ball.radius() * 2;
    }

    private void handleGroundCollision() {
        ballY = groundLevel - ball.radius() * 2;
        velocity = -velocity * ball.restitution();
    }
}
