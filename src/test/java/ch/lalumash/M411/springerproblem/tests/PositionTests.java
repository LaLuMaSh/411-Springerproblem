package ch.lalumash.M411.springerproblem.tests;

import ch.lalumash.M411.springerproblem.Board;
import ch.lalumash.M411.springerproblem.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PositionTests {

    @Test
    public void get_possible_positions_center() {
        Board board = new Board(8);
        List<Position> result = board.get(4, 4).getPossiblePositions();

        Assertions.assertEquals(8, result.size());
    }

    @Test
    public void get_possible_positions_in_corner() {
        Board board = new Board(8);
        List<Position> result = board.get(0, 0).getPossiblePositions();

        Assertions.assertEquals(2, result.size());
    }
}
