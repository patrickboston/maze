package maze;

import java.util.LinkedList;

public class PathFinder {

    Maze maze;
    LinkedList<Coordinate> myPath = new LinkedList<Coordinate>();
    boolean exitFound = false;
            
    public PathFinder(Maze iMaze) {
        maze = iMaze;
    }

    public LinkedList<Coordinate> findPath(int startRow, int startColumn) {
        
        myPath.add(new Coordinate(startRow, startColumn));
        tracePath(startRow, startColumn, '0');
        return (myPath);
    }

    public boolean tracePath(int row, int column, char direction) {

        if (maze.isExit(row, column)) {
            exitFound = true;
            return (true);
        } else {
            if (!maze.hasNorthWall(row, column) && direction != 'S')  {
                exitFound = tracePath(row - 1, column, 'N');
            }
            if (!exitFound && !maze.hasSouthWall(row, column) && direction != 'N') {
                exitFound = tracePath(row + 1, column, 'S');
            }
            if (!exitFound && !maze.hasEastWall(row, column) && direction != 'W') {
                exitFound = tracePath(row, column + 1, 'E');
            }
            if (!exitFound && !maze.hasWestWall(row,column) && direction != 'E') {
                exitFound = tracePath(row, column - 1, 'W');
            }
            if(exitFound){
               myPath.add(new Coordinate(row, column));  
            }
            return (exitFound);
        }
    }
}