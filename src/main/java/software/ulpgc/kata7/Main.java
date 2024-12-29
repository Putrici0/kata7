package software.ulpgc.kata7;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Ball ball = Ball.create(20, 0.9);
        JFrame frame = new JFrame("Ball Simulator");
        BallSimulator simulator = new BallSimulator(9.8, 800, ball);
        frame.add(simulator);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
