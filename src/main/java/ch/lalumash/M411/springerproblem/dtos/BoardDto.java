package ch.lalumash.M411.springerproblem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The DTO object that will be sent via a REST Request.
 */
@AllArgsConstructor
@Getter
public class BoardDto {
    private int[][] values;
}
