package prove02;

import java.awt.*;

public class Zombie extends Creature implements Movable, Aggressor{

    @Override
    public void attack(Creature target) {
        if((target instanceof Animal)) target.takeDamage(10);
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return Color.BLUE;
    }

    @Override
    Boolean isAlive() {
        return true;
    }

    @Override
    public void move() {
        _location.x++;
    }

}
