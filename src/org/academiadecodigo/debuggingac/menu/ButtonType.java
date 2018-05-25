package org.academiadecodigo.debuggingac.menu;

public enum ButtonType {
    PLAY(326, 107, 875, 639),
    TUTORIAL(14, 757, 223, 778),
    CREDITS(1065, 757, 1186 , 778),
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
