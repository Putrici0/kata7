package software.ulpgc.kata7.model;

public record Ball(double radius, double restitution) {

    public static Ball create(double radius, double restitution) {
        return new Ball(radius, restitution);
    }
}
