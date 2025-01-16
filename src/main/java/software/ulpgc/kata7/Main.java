package software.ulpgc.kata7;

import software.ulpgc.kata7.model.Ball;
import software.ulpgc.kata7.view.BallView;
import software.ulpgc.kata7.control.BallController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Ball ball = Ball.create(20, 0.9);
        int groundLevel = 900;
        double initialHeight = 800;

        BallView view = new BallView(ball, groundLevel - initialHeight, groundLevel);
        new BallController(ball, view, 9.8, initialHeight, groundLevel);

        JFrame frame = new JFrame("Ball Simulator");
        frame.add(view);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
