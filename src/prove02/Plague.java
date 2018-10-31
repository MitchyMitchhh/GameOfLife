package prove02;

import java.awt.*;
import java.util.Random;

public class Plague extends Creature implements Aggressor, Movable {
    Random _rand;

    public Plague() {
        _rand = new Random();
    }

    @Override
    public void attack(Creature target) {
        if((target instanceof Alive)) {
            target.gotSick();
        }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return Color.BLACK;
    }

    @Override
    Boolean isAlive() {
        return true;
    }

    @Override
    public void move() {
        switch(_rand.nextInt(4)) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }
    }
}