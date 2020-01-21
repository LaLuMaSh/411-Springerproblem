package ch.lalumash.M411.springerproblem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

@AllArgsConstructor
@Getter
public class Path {
    private int dimensions;
    private Stack<Position> values;
}
