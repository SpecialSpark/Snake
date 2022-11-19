import java.util.ArrayList;

public class ThreadsController extends Thread {
    ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
    Tuple snakeHeadPos;
    int snakeSize = 3;
    long speed = 50;
    public static int snakeDirection;
    //
    ArrayList<Tuple> positions = new ArrayList<Tuple>();
    Tuple foodPosition;

    //Constructor of ControllerThread
    ThreadsController(Tuple positionDepart) {
        
        //Get all the threads
        Squares = Window.grid;

        snakeHeadPos = new Tuple(positionDepart.x,positionDepart.y);
        snakeDirection = 1;

        //Pointer (IMPORTANT)
        Tuple headPos = new Tuple(snakeHeadPos.getX(),snakeHeadPos.getY());
        positions.add(headPos);

        foodPosition = new Tuple(Window.height-1,Window.width -1);
        spawnFood(foodPosition);
    }
    //important part:
    public void run() {
        while(true) {
            moveInterne(snakeDirection);
            checkCollision();
        }
    }
    private void pauser(){
        //try{
        //
        //} catch (InterruptedException exception) {
        //    exception.printStackTrace();
        //}
    }

    //checks if snake collides with itself
    private void checkCollision() {
        Tuple posCritique = positions.get(positions.size() -1);
        for(int i = 0; i <= positions.size() -2; i++) {
            boolean biteItself = posCritique.getX() == positions.get(i).getX() && posCritique.getY()==positions.get(i).getY();
            if(biteItself) {
                stopTheGame();
            }
        }
    }
    //Stops the game
    private void stopTheGame(){
        System.out.println("Collision! \n");
        while(true){
            pauser();
        }
    }
    // put food in position and displays it
    private void spawnFood(Tuple foodPositionIn) {
        Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
    }

    // right = 1
    // left = 2
    // up = 3
    // bottom = 4
    private void moveInterne(int dir) {
        switch(dir) {
            case 4:
                snakeHeadPos.ChangeData(snakeHeadPos.x,(snakeHeadPos.y-1)%20);
                positions.add(new Tuple(snakeHeadPos.x,snakeHeadPos.y));
                break;
            case 3:
                if(snakeHeadPos.y -1 < 0) {
                    snakeHeadPos.ChangeData(snakeHeadPos.x,19);
                } else {
                    snakeHeadPos.ChangeData(snakeHeadPos.x,Math.abs(snakeHeadPos.y - 1)%20);
                }
                positions.add(new Tuple(snakeHeadPos.x,snakeHeadPos.y));
                break;
            case 2:
            if(snakeHeadPos.x -1 < 0) {
                snakeHeadPos.ChangeData(snakeHeadPos.x,19);
            } else {
                snakeHeadPos.ChangeData(Math.abs(snakeHeadPos.x - 1)%20,snakeHeadPos.y);
            }
            positions.add(new Tuple(snakeHeadPos.x,snakeHeadPos.y));
            break;
            case 1:
                snakeHeadPos.ChangeData((snakeHeadPos.x + 1)%20,snakeHeadPos.y);
                positions.add(new Tuple(snakeHeadPos.x,snakeHeadPos.y));
                break;
        }
    }
}
