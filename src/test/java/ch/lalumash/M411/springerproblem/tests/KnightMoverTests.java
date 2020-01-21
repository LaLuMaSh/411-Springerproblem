package ch.lalumash.M411.springerproblem.tests;

import ch.lalumash.M411.springerproblem.model.Path;
import ch.lalumash.M411.springerproblem.model.Position;
import ch.lalumash.M411.springerproblem.services.KnightMover;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

public class KnightMoverTests {
    @Test
    public void test() {
        KnightMover knightMover = new KnightMover(5);
        Path pos = knightMover.get(0, 0);
        System.out.println(pos);
        for (Position po : pos.getValues()) {
            System.out.println(po);
        }
        System.out.println(pos.getValues().size());
    }
}
