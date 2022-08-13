import java.util.Scanner;

public class X0Game {
    FieldX0 gameField;
    Scanner sc = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;

    void setupNewGame(){
        System.out.println("Will play new X0 game");
        this.gameField = new FieldX0();
        this.gameField.initField();
    }





    void play(){
        this.setupNewGame();
        System.out.println("Who will make the first turn: ");
        char first = this.sc.next().charAt(0);
        if (first == '0'||first=='X'){
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("Вы ввели непонятно, я понимаю только X или 0, пусть первый ходит X!");
            this.whoMakeNextTurn = 'X';
            }
        while (!gameOver){
            turn();
            this.gameOver = this.gameField.isGameOver(this.whoMakeNextTurn);
            if (this.gameOver){
                System.out.println(this.whoMakeNextTurn + " поздравляю с победой!");
            }
            if (this.whoMakeNextTurn=='X'){
                this.whoMakeNextTurn='0';
            }else {
                this.whoMakeNextTurn='X';
            }
        }
    }


    void turn(){
        System.out.println(this.whoMakeNextTurn + ", your turn.");
        System.out.print("Chose column: ");
        int rowNumber = sc.nextInt();
        System.out.print("Chose row: ");
        int colNumber = sc.nextInt();
        int rowIndex = rowNumber-1;
        int colIndex = colNumber-1;
        if (this.gameField.isPlaceFree(rowIndex,colIndex)){
        this.gameField.setValue(rowIndex,colIndex, whoMakeNextTurn);
        this.gameField.printField();
        }else {
            System.out.println("Неправельный номер (может эта ячейка занята?) попробуйте еще раз");
            turn();
        }
    }
}
