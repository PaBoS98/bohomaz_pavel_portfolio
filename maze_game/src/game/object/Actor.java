package game.object;

import game.MazeMain;

public class Actor {

    public int actorX;
    public int actorY;

    public Actor(int x1, int y1) {

        actorX = x1;
        actorY = y1;
    }

//    public void dynamics() {
//
//        int changesY = 0;
//
//        if (MazeMain.different != 0) {
////            if (actor.actorX >= Maze.maze.length - Math.abs(different)) {
////                differentX = -different * SCALE;
////            } else if (actor.actorX <= Math.abs(different)) {
////                differentX = different * SCALE;
////            } else differentX = 0;
////            if (actor.actorY >= Maze.maze.length - Math.abs(different)) {
////                differentY = -different * SCALE;
////            } else if (actor.actorY <= Math.abs(different)) {
////                differentY = different * SCALE;
////            } else differentY = 0;
//
//            if (MazeMain.changesX > MazeMain.different && MazeMain.direction != 1) {
//                System.out.println(MazeMain.changesX);
//                if (actorX < 2) {
//                    MazeMain.differentX -= 5 * MazeMain.SCALE;
//                    actorX += 5;
//                    MazeMain.changesX -= 5;
//                }
//            } else if (MazeMain.changesX < -MazeMain.different && MazeMain.direction != 3) {
//                System.out.println(MazeMain.changesX);
//                if (actorX < Maze.maze.length - 2) {
//                    MazeMain.differentX += 5 * MazeMain.SCALE;
//                    actorX -= 5;
//                    MazeMain.changesX += 5;
//                }
//            }
//
//        }
//    }

}
