package ourPackage;

public enum Direction {
    N(0),
    E(90),
    S(180),
    W(270);

    private int directionInDegrees;

    Direction(int directionInDegrees){
        this.directionInDegrees=directionInDegrees;
    }

    public int getDirection() {
        return directionInDegrees;
    }
}

