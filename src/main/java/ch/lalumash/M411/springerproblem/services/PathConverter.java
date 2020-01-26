package ch.lalumash.M411.springerproblem.services;

import ch.lalumash.M411.springerproblem.dtos.BoardDto;
import ch.lalumash.M411.springerproblem.model.Path;
import ch.lalumash.M411.springerproblem.model.Position;

/**
 * Service used to convert a {@link Path} object to a {@link BoardDto}.
 */
public class PathConverter {
    private static PathConverter instance;

    /**
     * simple getInstance Method to get a singleton instance of PathConverter.
     *
     * @return
     */
    public static PathConverter getInstance() {
        if (instance == null) {
            instance = new PathConverter();
        }
        return instance;
    }

    /**
     * a simple method to convert a Path to a BoardDto for the rest api
     *
     * @param path the Path object that should be converted to a DTO.
     * @return the newly created DTO.
     */
    public BoardDto convert(Path path) {
        int dimensions = path.getDimensions();
        int[][] result = new int[dimensions][dimensions];

        int current = 1;
        for (Position position : path.getValues()) {
            result[position.getX()][position.getY()] = current;
            current++;
        }
        return new BoardDto(result);
    }
}
