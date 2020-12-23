package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (isDiagonal(this.position, dest)) {
            throw new ImpossibleMoveException(
                   String.format("Could not way by diagonal from %s to %s", position, dest)
            ) ;
        }
        int distantion = Math.abs(this.position.getX() - dest.getX());
        int deltaX = (dest.getX() - this.position.getX()) / distantion;
        int deltaY = (dest.getY() - this.position.getY()) / distantion;
        Cell[] cellArray = new Cell[distantion];
        for (int i = 0; i < distantion; i++) {
            int x = this.position.getX() + deltaX * (i + 1);
            int y = this.position.getY() + deltaY * (i + 1);
            cellArray[i] = Cell.findBy(x, y);
        }
        return cellArray;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) != Math.abs(source.getY() - dest.getY()) || source.getY() == dest.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
