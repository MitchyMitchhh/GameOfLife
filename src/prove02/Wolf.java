package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Aware, Aggressor, Movable, Spawner, Alive {

    private Random _rand = new Random();
    private int direction = _rand.nextInt(3);
    private Boolean preg = false;

    Wolf() {
        _health = 1;
    }

    private int getDirection() {
        return direction;
    }

    private void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void attack(Creature target) {
        if((target instanceof Animal)) {
            target.takeDamage(5);
            preg = !target.isAlive();
        }
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        int pd = getDirection();
        // 0: Right
        // 1: Left
        // 2: Up
        // 3: Down

        //Up
        if (pd == 2) {
            if (right instanceof Animal)
                setDirection(0);
            else if (below instanceof Animal)
                setDirection(3);
            else if (left instanceof Animal)
                setDirection(1);
        }

        //Right
        else if (pd == 0) {
            if (above instanceof Animal)
                setDirection(2);
            else if (right instanceof Animal)
                setDirection(0);
            else if (below instanceof Animal)
                setDirection(3);
        }

        //Down
        else if (pd == 1) {
            if (left instanceof Animal)
                setDirection(1);
            else if (above instanceof Animal)
                setDirection(2);
            else if (right instanceof Animal)
                setDirection(0);
        }

        //Left
        else if (pd == 3) {
            if (left instanceof Animal)
                setDirection(1);
            else if (above instanceof Animal)
                setDirection(2);
            else if (right instanceof Animal)
                setDirection(0);
        }

    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return Color.GRAY;
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void move() {
        switch(direction) {
            case 0:
                _location.x++;
                setDirection(0); // Right
                break;
            case 1:
                _location.x--;
                setDirection(1); // Left
                break;
            case 2:
                _location.y++;
                setDirection(2); // Up
                break;
            case 3:
                _location.y--;
                setDirection(3); // Down
                break;
            default:
                break;
        }
    }

    @Override
    public Creature spawnNewCreature() {
        if (preg) {
            Wolf babyWolf = new Wolf();
            Point nPoint = (Point) _location.clone();
            nPoint.x--;
            babyWolf.setDirection(getDirection());
            babyWolf.setLocation(nPoint);
            preg = false;
            return babyWolf;
        }
        else {
            return null;
        }
    }

    @Override
    public Creature Being() {
        return null;
    }
}