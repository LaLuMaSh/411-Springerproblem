package ch.lalumash.M411.springerproblem.tests;

import ch.lalumash.M411.springerproblem.model.Position;
import ch.lalumash.M411.springerproblem.services.KnightMover;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class KnightMoverTests {
    @Test
    public void test() {
        KnightMover knightMover = new KnightMover(5);
        Stack<Position> pos = knightMover.solve(new Stack<Position>(), 0, 0);
        System.out.println(pos);
        for (Position po : pos) {
            System.out.println(po);
        }
        System.out.println(pos.size());
    }
}
