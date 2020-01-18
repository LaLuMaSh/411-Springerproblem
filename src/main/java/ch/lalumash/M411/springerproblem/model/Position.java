package ch.lalumash.M411.springerproblem.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Position implements Cloneable {
    private int x;
    private int y;
    @Setter(AccessLevel.PROTECTED)
    private boolean visited;
    private transient Board board;
    @Getter(AccessLevel.PRIVATE)
    private List<Position> positions;

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
        if (positions == null) {
            List<Position> result = new ArrayList<Position>();

            for (int i = 0; i < Move.moves.length; i++) {
                int x = this.getX() + Move.moves[i].getX();
                int y = this.getY() + Move.moves[i].getY();

                if (x >= 0 && y >= 0
                        && x < board.getDimensions()
                        && y < board.getDimensions()) {
                    result.add(board.get(x, y));
                }
            }
            positions = result;
        }

        return positions;
    }

    @Override
    public Position clone() {
        return new Position(this.getX(), this.getY(), this.board);
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position)) {
            return false;
        }
        Position pos = (Position) other;

        return pos.getY() == this.getY() && pos.getX() == this.getX();
    }
    @Override
    public String toString() {
        return "[" + this.getX() + ";" + this.getY() + "]";
    }
}
