package ch.lalumash.M411.springerproblem.services;

import ch.lalumash.M411.springerproblem.model.Board;
import ch.lalumash.M411.springerproblem.model.Path;
import ch.lalumash.M411.springerproblem.model.Position;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * This Class us used to solve the Knight Problem in variable dimensions.
 */
public class KnightMover {
    private Board board;

    /**
     * Creates a KnightMover with a board with the dimensions 8 x 8.
     */
    public KnightMover() {
        this.board = new Board(8);
    }

    /**
     * Creates a KnightMover with a variable size.
     *
     * @param dimension the dimensions of the board that will be used to solve the Knight Problem.
     */
    public KnightMover(int dimension) {
        this.board = new Board(dimension);
    }

    /**
     * Creates KnightMover with a custom board, this should mostly be used by Unit tests.
     *
     * @param board the board that will be used to solve the Knight Problem.
     */
    public KnightMover(Board board) {
        this.board = board;
    }

    /**
     * The Wrapper Method to solving the Knight Problem.
     *
     * @param x position on the board, starting at 0.
     * @param y position on the board, starting at 0.
     * @return a list of all possibilities.
     */
    public List<Path> getAll(int x, int y) {
        ArrayList<Stack<Position>> possibilities = new ArrayList<>();
        List<Path> r = new ArrayList<>();

        this.solve(possibilities, new Stack<>(), x, y, true);

        for (Stack<Position> result : possibilities) {
            r.add(new Path(board.getDimensions(), result));
        }
        return r;
    }

    /***
     * @param x position on the board, starting at 0.
     * @param y position on the board, starting at 0.
     * @return the first possible valid Path, null if there are none.
     */
    @Nullable
    public Path get(int x, int y) {
        ArrayList<Stack<Position>> results = new ArrayList<>();
        this.solve(results, new Stack<>(), x, y, false);
        return (results.size() != 0)
                ? new Path(board.getDimensions(), results.get(0))
                : null;
    }

    /***
     *
     * The recursive function used to solve the Knight Problem.
     *
     * @param results The List where all successful attempts will be put into. It will always add at least one if there
     *                is any possibility, it will continue depending on the "continueAfterFirstResult" parameter.
     * @param current the Stack that will be used as a base, this object will not be mutated,
     *                it will be cloned on every recursive call.
     * @param x       position on the board, starting at 0.
     * @param y       position on the board, starting at 0.
     * @param continueAfterFirstResult if this value is set to true, it will try to find all possibilities,
     *                                 else it will stop after the first successful solve.
     *                                 When there are no solutions the result will be the last attempt and the results
     *                                 list will not be modified.
     * @return The Stack that was currently modified, DO NOT USE THIS AS A RESULT, use the "results" parameter.
     */
    private Stack<Position> solve(List<Stack<Position>> results, Stack<Position> current, int x, int y, boolean continueAfterFirstResult) {
        Position position = board.get(x, y);
        current.push(position);

        if (current.size() == board.getDimensions() * board.getDimensions()) {
            results.add(current);
            if (!continueAfterFirstResult) {
                return current;
            }
        }

        for (Position possiblePosition : position.getPossiblePositions()) {
            if (!current.contains(possiblePosition)) {
                this.solve(results, (Stack<Position>) current.clone(), possiblePosition.getX(), possiblePosition.getY(), continueAfterFirstResult);
            }
        }
        return current;
    }

}
