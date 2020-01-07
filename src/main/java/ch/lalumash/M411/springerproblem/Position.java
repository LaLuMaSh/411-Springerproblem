package ch.lalumash.M411.springerproblem;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Position {
    private int x;
    private int y;
    @Setter(AccessLevel.PROTECTED)
    private boolean visited;
    @Getter(AccessLevel.PRIVATE)
    private transient Board board;

    public Position(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.visited = false;
        this.board = board;
    }

    public void visit() {
        visited = true;
    }

    public List<Position> getPossiblePositions() {

        //https://www.geeksforgeeks.org/possible-moves-knight/

        return new ArrayList<Position>();
    }
}
