package ch.lalumash.M411.springerproblem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Move {
    private int x;
    private int y;

    public static Move[] moves = {
            new Move(2, 1),
            new Move(1, 2),
            new Move(-1, 2),
            new Move(-2, 1),
            new Move(-2, -1),
            new Move(-1, -2),
            new Move(1, -2),
            new Move(2, -1)
    };
}
