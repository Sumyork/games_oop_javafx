package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.C1;
import static ru.job4j.chess.firuges.Cell.E3;
import static ru.job4j.chess.firuges.Cell.H6;
import static ru.job4j.chess.firuges.Cell.H7;

public class LogicTest {
    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(
                FigureNotFoundException.class,
                () -> {
                logic.move(C1, H6);
                });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                logic.move(C1, H7);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to H7.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new PawnBlack(E3));
        OccupiedCellException exception = assertThrows(
                OccupiedCellException.class,
                () -> {
                logic.move(C1, H6);
                });
        assertThat(exception.getMessage()).isEqualTo("The cell is occupied.");
    }
}