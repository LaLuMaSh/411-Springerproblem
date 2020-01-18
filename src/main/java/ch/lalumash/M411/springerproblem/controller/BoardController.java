package ch.lalumash.M411.springerproblem.controller;

import ch.lalumash.M411.springerproblem.services.KnightMover;
import ch.lalumash.M411.springerproblem.model.Position;
import ch.lalumash.M411.springerproblem.services.BoardConverter;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@RestController
@RequestMapping("api/board/")
@CrossOrigin(origins = {"*"})
public class BoardController {

    public BoardController() {
        System.out.println("hallo");
    }

    @GetMapping("get")
    public int[][] getBoard(@RequestParam Integer x, @RequestParam Integer y, @RequestParam(required = false) Integer dimensions) {
        if (dimensions == null) {
            dimensions = 8;
        }
        KnightMover knightMover = new KnightMover(dimensions);
        Stack<Position> positions =knightMover.solve(new Stack<>(), x, y);

        return BoardConverter.getInstance().convert(positions);
    }
}
