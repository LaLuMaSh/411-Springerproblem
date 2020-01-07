package ch.lalumash.M411.springerproblem;

import lombok.Getter;

@Getter
public class Problem {
    private Board board;

    public Problem() {
        this.board = new Board(8);
    }

    public Problem(Board board) {
        this.board = board;
    }

    public void solve(int x, int y) {

    }
}
