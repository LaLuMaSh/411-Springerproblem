package ch.lalumash.M411.springerproblem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class representing a scalable Chess board.
 */
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

    /**
     * @param x the x Position on the Board.
     * @param y the y Position on the Board.
     * @return the Position, if it is not on the board, it will throw a IllegalArgumentException.
     */
    public Position get(int x, int y) {

        if (!isInBoard(x, y)) {
            throw new IllegalArgumentException("position (" + x + ", " + y + ") not on board.");
        }

        return positions[x][y];
    }

    /**
     * checks if a position is on the Board.
     * @param x the x Position.
     * @param y the y Position.
     * @return if the Position is on the Board.
     */
    public boolean isInBoard(int x, int y) {
        return x >= 0 && x <= dimensions - 1 && y >= 0 && y <= dimensions - 1;
    }

    /**
     * @return the Cloned Board.
     */
    @Override
    public Board clone() {
        return new Board(this.dimensions);
    }

    /**
     * allows to iterate over the board.
     * @return the Iterator of the Position List.
     */
    public Iterator<Position> iterator() {
        return positionsList.iterator();
    }
}
