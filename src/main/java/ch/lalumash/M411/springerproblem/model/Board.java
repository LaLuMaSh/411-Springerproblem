package ch.lalumash.M411.springerproblem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Cloneable, Iterable<Position> {

    private Position[][] positions;
    private List<Position> positionsList;
    @Getter
    private int dimensions;

    public Board(int dimensions) {
        this.positionsList = new ArrayList<>();
        this.positions = new Position[dimensions][dimensions];
        this.dimensions = dimensions;
        for (int x = 0; x < dimensions; x++) {
            for (int y = 0; y < dimensions; y++) {
                Position position = new Position(x, y, this);
                positions[x][y] = position;
                positionsList.add(position);
            }
        }
    }

    public Position get(int x, int y) {

        if (!isInBoard(x, y)) {
            throw new IllegalArgumentException("position (" + x + ", " + y + ") not on board.");
        }

        return positions[x][y];
    }

    public boolean isInBoard(int x, int y) {
        return x >= 0 && x <= dimensions - 1 && y >= 0 && y <= dimensions - 1;
    }

    public boolean canBeJumpedTo(int x, int y) {
        if (!isInBoard(x, y)) {
            return false;
        }
        return !positions[x][y].isVisited();
    }

    @Override
    public Board clone() {
        Board board = new Board(this.dimensions);

        for (Position position : board) {
            position.setVisited(this.get(position.getX(), position.getY()).isVisited());
        }
        return board;
    }

    public Iterator<Position> iterator() {
        return positionsList.iterator();
    }
}
