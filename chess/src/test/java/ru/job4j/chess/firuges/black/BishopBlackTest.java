package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.A3;
import static ru.job4j.chess.firuges.Cell.B7;
import static ru.job4j.chess.firuges.Cell.B8;
import static ru.job4j.chess.firuges.Cell.C1;
import static ru.job4j.chess.firuges.Cell.C3;
import static ru.job4j.chess.firuges.Cell.C6;
import static ru.job4j.chess.firuges.Cell.C7;
import static ru.job4j.chess.firuges.Cell.D2;
import static ru.job4j.chess.firuges.Cell.D4;
import static ru.job4j.chess.firuges.Cell.D5;
import static ru.job4j.chess.firuges.Cell.D6;
import static ru.job4j.chess.firuges.Cell.E2;
import static ru.job4j.chess.firuges.Cell.E3;
import static ru.job4j.chess.firuges.Cell.E4;
import static ru.job4j.chess.firuges.Cell.E5;
import static ru.job4j.chess.firuges.Cell.F3;
import static ru.job4j.chess.firuges.Cell.F4;
import static ru.job4j.chess.firuges.Cell.G2;
import static ru.job4j.chess.firuges.Cell.G3;
import static ru.job4j.chess.firuges.Cell.G5;

class BishopBlackTest {
    @Test
    void whenSourcePositionTrue() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(C1).isEqualTo(bishopBlack.position());
    }

    @Test
    void whenBishopBlackSourceA3DestC5() {
        BishopBlack source = new BishopBlack(A3);
        Figure dest = source.copy(G5);
        assertThat(G5).isEqualTo(dest.position());
    }

    @Test
    void whenBishopBlackWayFromC1toG5() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] steps = new Cell[]{D2, E3, F4, G5};
        assertThat(steps).isEqualTo(bishopBlack.way(G5));
   }

    @Test
    void whenBishopBlackWayFromG3toB8() {
        BishopBlack bishopBlack = new BishopBlack(G3);
        Cell[] steps = new Cell[]{F4, E5, D6, C7, B8};
        assertThat(steps).isEqualTo(bishopBlack.way(B8));
    }

    @Test
    void whenBishopBlackWayFromB7toG2() {
        BishopBlack bishopBlack = new BishopBlack(B7);
        Cell[] steps = new Cell[]{C6, D5, E4, F3, G2};
        assertThat(steps).isEqualTo(bishopBlack.way(G2));
    }

    @Test
    void whenBishopBlackWayFromE5toC3() {
        BishopBlack bishopBlack = new BishopBlack(E5);
        Cell[] steps = new Cell[]{D4, C3};
        assertThat(steps).isEqualTo(bishopBlack.way(C3));
    }

    @Test
    void whenIsNotDiagonalE2toG5() {
        BishopBlack bishopBlack = new BishopBlack(E2);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(G5);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from E2 to G5.");
    }
}