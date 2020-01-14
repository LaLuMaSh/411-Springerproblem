package ch.lalumash.M411.springerproblem.tests;

import ch.lalumash.M411.springerproblem.Position;
import ch.lalumash.M411.springerproblem.Problem;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ProblemTests {
    @Test
    public void test() {
        Problem problem = new Problem(5);
        Stack<Position> pos = problem.solve(new Stack<Position>(), 0, 0);
        System.out.println(pos);
        for (Position po : pos) {
            System.out.println(po);
        }
        System.out.println(pos.size());
    }
}
