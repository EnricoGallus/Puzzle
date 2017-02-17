public class Board {

    private int[][] block;

    /**
     * construct a board from an n-by-n array of blocks
     * (where blocks[i][j] = block in row i, column j)
     * @param blocks
     */
    public Board(int[][] blocks) {
        block = blocks;
    }

    /**
     * board dimension n
     * @return
     */
    public int dimension() {
        return block.length;
    }

    /**
     * number of blocks out of place
     * @return
     */
    public int hamming() {
        int hamming = 0;
        int length = block.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (block[i][j] == 0) continue;
                int runningValue = j + 1 + (i * length);
                if (block[i][j] != runningValue) {
                    hamming++;
                }

            }
        }

        return hamming;
    }

    /**
     * sum of Manhattan distances between blocks and goal
     * @return
     */
    public int manhattan() {
        int manhattan = 0;
        int length = block.length;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (block[i - 1][j - 1] == 0) continue;

                int mod = block[i - 1][j - 1] % length;
                int correction = mod == 0 ? length : mod;
                int horizontalCorrection = j > correction ? j - correction : correction - j;

                double div = block[i -1][j - 1] / (double)length;
                int ceil = (int)Math.ceil(div);
                int verticalCorrection =  i < ceil ? ceil - i : i - ceil;

                manhattan += horizontalCorrection + verticalCorrection;
            }
        }

        return manhattan;
    }

    /**
     * is this board the goal board?
     * @return
     */
    public boolean isGoal() {
        return false;
    }

    /**
     * a board that is obtained by exchanging any pair of blocks
     * @return
     */
    public Board twin() {
        return new Board(block);
    }

    /**
     * does this board equal y?
     * @param y
     * @return
     */
    public boolean equals(Object y) {
        if (y instanceof Board) {
            Board other = (Board)y;
            if (this.dimension() == other.dimension())
            {
                boolean result = this.toString().equals(other.toString());
                return result;
            }
        }

        return false;
    }

    /**
     * all neighboring boards
     * @return
     */
    public Iterable<Board> neighbors() {
        return new Board(block).neighbors();
    }

    /**
     * string representation of this board (in the output format specified below)
     * @return
     */
    public String toString() {
        String output = "";
        int length = block.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                output += block[i][j];
                if (j != length -1) {
                    output +=  " ";
                }

            }

            if (i != length -1) {
                output += "\n";
            }
        }

        return output;
    }

    /**
     * unit tests (not graded)
     * @param args
     */
    public static void main(String[] args) {

    }
}