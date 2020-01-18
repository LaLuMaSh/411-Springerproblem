package ch.lalumash.M411.springerproblem.services;

import ch.lalumash.M411.springerproblem.model.Position;

import java.util.Stack;

public class BoardConverter {

    private static BoardConverter instance;

    public static BoardConverter getInstance() {
        if (instance == null) {
            instance = new BoardConverter();
        }
        return instance;
    }

    public int[][] convert(Stack<Position> stack) {
        int dimensions = stack.peek().getBoard().getDimensions();
        int[][] result = new int[dimensions][dimensions];

        int current = 1;
        for (Position position : stack) {
            result[position.getX()][position.getY()] = current;
            current++;
        }
        return result;
    }
}
