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

    @Test (expected = ImpossibleMoveException.class)
    public void testWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = {};
        way = bishopBlack.way(Cell.G5);
        Cell[] test = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        for (int i = 0; i < way.length; i++) {
            if (way[i] != test[i]) assertFalse(true);
        }
        assertTrue(true);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testWayException() throws ImpossibleMoveException{
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        String str="";
        try {
            Cell[] way = bishopBlack.way(Cell.G4);
        } catch (Exception e) {str= e.getMessage();}
            assertTrue(str.toString().equals("Could not way by diagonal from C1 to G4"));
        }
}