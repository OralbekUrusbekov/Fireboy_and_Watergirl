package GameCode;

import java.awt.*;

public class GameElementFactory {

    // Ойын элементтерін жасау үшін жалпы әдіс
    public static Player createPlayer(char moveUp, char moveLeft, char moveRight, int x, int y, Color color, int destX, int destY) {
        return new Player(moveUp, moveLeft, moveRight, x, y, color, destX, destY);
    }

    // Wall объектісін жасау
    public static Wall createWall(int x1, int y1, int x2, int y2) {
        return new Wall(x1, y1, x2, y2);
    }

    // Pool объектісін жасау
    public static Pool createPool(int startX, int startY, int length, int type) {
        return new Pool(startX, startY, length, type);
    }

    // Door объектісін жасау
    public static Door createDoor(int x, int y, Color color) {
        return new Door(x, y, color);
    }
}
