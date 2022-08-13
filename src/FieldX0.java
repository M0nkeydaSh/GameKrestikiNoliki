public class FieldX0 {
    char[][] field;
    int size = 9;
    int countToWin = 5;


    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = ' ';
            }
        }
        System.out.println("Field initialized");
        this.printField();
    }

    void printField() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < size; col++) {
                System.out.print("[" + field[col][row] + "]");
            }
            System.out.println();
        }
    }

    boolean isPlaceFree(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= size || colIndex < 0 || colIndex >= size) {
            return false;
        } else if (this.field[rowIndex][colIndex] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    void setValue(int rowIndex, int colIndex, char value) {
        this.field[rowIndex][colIndex] = value;
    }

    boolean isGameOver(char player) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (checkRightDirection(row, col, player)) {
                    return true;
                } else if (checkDownDirection(row, col, player)) {
                    return true;
                } else if (checkRightDiagonal(row, col,player)){
                    return true;
                } else if (checkLeftDiagonal(row, col,player)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkRightDirection(int row, int col, char player) {
        if (col > this.size - this.countToWin) {
            return false;
        }
        for (int i = col; i < col + this.countToWin; i++) {
            if (this.field[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkDownDirection(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
        for (int i = row; i < row + this.countToWin; i++) {
            if (this.field[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkRightDiagonal(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
        if (col > this.size - this.countToWin) {
            return false;
        }
        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
            int rowToChek = row + sdvig;
            int colToChek = col + sdvig;
            if (this.field[rowToChek][colToChek] != player) {
                return false;
            }

        }
        return true;
    }

    boolean checkLeftDiagonal(int row, int col, char player) {
        if (row > this.size - this.countToWin) {
            return false;
        }
        if (col < this.countToWin - 1) {
            return false;
        }
        for (int sdvig = 0; sdvig < this.countToWin; sdvig++) {
           int rowToChek = row + sdvig;
           int colToChek = col - sdvig;
                if (this.field[rowToChek][colToChek] != player) {
                    return false;
                }

        }
        return true;
    }
}
