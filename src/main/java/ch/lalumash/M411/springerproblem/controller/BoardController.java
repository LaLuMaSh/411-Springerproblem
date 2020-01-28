package ch.lalumash.M411.springerproblem.controller;

import ch.lalumash.M411.springerproblem.dtos.BoardDto;
import ch.lalumash.M411.springerproblem.model.Path;
import ch.lalumash.M411.springerproblem.services.KnightMover;
import ch.lalumash.M411.springerproblem.services.PathConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic RestController for getting one board or all possible boards.
 */
@RestController
@RequestMapping("api/board/")
@CrossOrigin(origins = {"*"})
public class BoardController {

    @GetMapping("get")
    public BoardDto getBoard(@RequestParam Integer x, @RequestParam Integer y, @RequestParam(required = false) Integer dimensions) {
        if (dimensions == null) {
            dimensions = 8;
        }

        if (x < 0 || y <  0 || x >= dimensions || y >= dimensions) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Position nicht auf dem Feld. ");
        }

        KnightMover knightMover = new KnightMover(dimensions);
        Path path = knightMover.get(x, y);

        if (path == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keine Möglichkeiten gefunden.");
        }

        return PathConverter.getInstance().convert(path);
    }

    @GetMapping("getAll")
    public List<BoardDto> getAll(@RequestParam Integer x, @RequestParam Integer y, @RequestParam(required = false) Integer dimensions) {
        if (dimensions == null) {
            dimensions = 8;
        }

        if (x < 0 | y <  0 | x >= dimensions || y >= dimensions) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position nicht auf dem Feld. ");
        }

        KnightMover knightMover = new KnightMover(dimensions);
        List<Path> paths = knightMover.getAll(x, y);
        if (paths.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keine möglichkeiten gefunden.");
        }

        List<BoardDto> results = new ArrayList<>();

        for (Path path : paths) {
            results.add(PathConverter.getInstance().convert(path));
        }
        return results;
    }
}
