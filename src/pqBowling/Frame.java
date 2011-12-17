package pqBowling;

/**
 * @author Mateu Adsuara Sabater
 */
public class Frame {
    private int shots = 0;
    private int pins[] = {0, 0, 0};
    private int frameNumber = 0;

    public boolean isStrike() {
        return (shots == 1 && pins[0] == 10);
    }

    public boolean isSpare() {
        return (shots == 2 && (pins[0] + pins[1]) == 10);
    }

    public boolean ended() {
        return (frameNumber < 9) && (isStrike() || shots == 2);
    }

    public void shoot(int droppedPins) {
        if (ended())
            throw new IllegalStateException("Shooting on a finished frame");
        pins[shots] = droppedPins;
        shots++;
    }

    public int getScore(){
        return pins[0] + pins[1];
    }

    public void nextFrame(){
        shots = 0;
        pins[0] = 0;
        pins[1] = 0;
        pins[2] = 0;
        frameNumber++;
    }
}

