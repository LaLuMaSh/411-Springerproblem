package ch.lalumash.M411.springerproblem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

/**
 * Class representing a Stack of all Positions in to represent a Path, and a Dimension.
 */
@AllArgsConstructor
@Getter
public class Path {
    private int dimensions;
    private Stack<Position> values;
}
