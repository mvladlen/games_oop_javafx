package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.position(), Cell.C1);
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopCopy = bishopBlack.copy(Cell.D2);
        assertEquals(bishopCopy.position(), Cell.D2);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = {};
        try {
            way = bishopBlack.way(Cell.G5);
        } catch (Exception e) {
        }
        Cell[] test = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        for (int i = 0; i < way.length; i++) {
            if (way[i] != test[i]) assertFalse(true);
        }
        assertTrue(true);
    }

    @Test
    public void testWayException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        try {
            Cell[] way = bishopBlack.way(Cell.G4);
        } catch (ImpossibleMoveException e) {
            assertTrue(e.getMessage().equals("Could not way by diagonal from C1 to G4"));
        }
    }


}