package ch.lalumash.M411.springerproblem.services;

import ch.lalumash.M411.springerproblem.model.Board;
import ch.lalumash.M411.springerproblem.model.Position;
import lombok.Getter;

import java.util.Stack;

@Getter
public class KnightMover {
    private Board board;

    public KnightMover() {
        this.board = new Board(8);
    }

    public KnightMover(int dimension) {
        this.board = new Board(dimension);
    }

    public KnightMover(Board board) {
        this.board = board;
    }

    public Stack<Position> solve(Stack<Position> current, int x, int y) {

        Position position = board.get(x, y);
        current.push(position);

        if (current.size() == board.getDimensions() * board.getDimensions()) {
            return current;
        }

        for (Position possiblePosition : position.getPossiblePositions()) {
            if (!current.contains(possiblePosition)) {
                Stack<Position> result = this.solve((Stack<Position>) current.clone(), possiblePosition.getX(), possiblePosition.getY());

                if (result.size() == board.getDimensions() * board.getDimensions()) {
                    return result;
                }
            }
        }
        return current;
    }
}
