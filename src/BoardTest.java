import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void checkDimension() {
        int[][] block = new int[1][5];
        Board board = new Board(block);
        Assertions.assertEquals(1, board.dimension());
    }

    @Test
    public void checkDimension10() {
        int[][] block = new int[10][10];
        Board board = new Board(block);
        Assertions.assertEquals(10, board.dimension());
    }

    @Test
    public void checkOutput() {
        Board board = new Board(defaultBlock());
        Assertions.assertEquals("8 1 3\n4 0 2\n7 6 5", board.toString());
    }

    @Test
    public void isEqualIfSameBlock() {
        int[][] block = defaultBlock();
        Board board1 = new Board(block);
        Board board2 = new Board(block);

        Assertions.assertTrue(board1.equals(board2));
    }

    @Test
    public void isEqualIfSameContent() {
        Board board1 = new Board(defaultBlock());
        Board board2 = new Board(defaultBlock());

        Assertions.assertTrue(board1.equals(board2));
    }

    @Test
    public void isNotEqualIfDifferentContent() {
        int[][] block = defaultBlock();
        Board board1 = new Board(block);
        int[][] secondBlock = defaultBlock();
        secondBlock[1][1] = 123;
        Board board2 = new Board(secondBlock);

        Assertions.assertFalse(board1.equals(board2));
    }

    @Test
    public void hammingFirstState() {
        int[][] block = defaultBlock();
        Board board = new Board(block);

        Assertions.assertEquals(5 + 0, board.hamming());
    }

    @Test
    public void hammingFinishedState() {
        int[][] block = finishedBlock();
        Board board = new Board(block);

        Assertions.assertEquals(0, board.hamming());
    }

    @Test
    public void manhattanFirstState() {
        int[][] block = defaultBlock();
        Board board = new Board(block);

        Assertions.assertEquals(10, board.manhattan());
    }

    @Test
    public void manhattanFinishedState() {
        int[][] block = finishedBlock();
        Board board = new Board(block);

        Assertions.assertEquals(0, board.manhattan());
    }

    private static int[][] defaultBlock() {
        int[][] block = new int[3][3];
        block[0][0] = 8;
        block[0][1] = 1;
        block[0][2] = 3;
        block[1][0] = 4;
        block[1][1] = 0;
        block[1][2] = 2;
        block[2][0] = 7;
        block[2][1] = 6;
        block[2][2] = 5;

        return block;
    }

    private static int[][] finishedBlock() {
        int[][] block = new int[3][3];
        block[0][0] = 1;
        block[0][1] = 2;
        block[0][2] = 3;
        block[1][0] = 4;
        block[1][1] = 5;
        block[1][2] = 6;
        block[2][0] = 7;
        block[2][1] = 8;
        block[2][2] = 0;

        return block;
    }
}
