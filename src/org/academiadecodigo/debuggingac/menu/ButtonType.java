package org.academiadecodigo.debuggingac.menu;

public enum ButtonType {
    PLAY(812, 604, 1123, 695),
    TUTORIAL(759, 739, 938, 788),
    CREDITS(990, 739, 1167, 788),
    BACK(43, 692, 744, 766);

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    ButtonType(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
