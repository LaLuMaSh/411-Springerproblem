package ch.lalumash.M411.springerproblem;

import lombok.Getter;

import java.util.Stack;

@Getter
public class Problem {
    private Board board;

    public Problem() {
        this.board = new Board(8);
    }

    public Problem(int dimension) {
        this.board = new Board(dimension);
    }

    public Problem(Board board) {
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
