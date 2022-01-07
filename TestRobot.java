
import java.util.Scanner;

public class TestRobot {
    static RobotObject robotObject = new RobotObject ();
    static int[][] grid = new int[10][10];
    public static void main (String[] args) {
        System.out.println("Init position of robot is: "+ robotObject.getX() + " " + robotObject.getY() );
        initCrate(0,0);
        initCrate(1,1);
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Type your command line: ");
            String input = scan.nextLine();
            if (input != null && !input.equals("")) {
                String [] inputArray = input.split(" ");
                for (int i = 0; i < inputArray .length; i++) {
                    switch (inputArray[i]) {
                        case "E":
                            if (i < inputArray.length -1) {
                                if (inputArray[i + 1].equals("S")) {	
                                    robotObject.downAndRight();
                                    i++;
                                } else if (inputArray[i + 1].equals("N")) {
                                    robotObject.upAndRight();
                                    i++;
                                } else {
                                    robotObject.right();
                                }
                            } else {
                                robotObject.right();
                            }

                            break;

                        case "W":
                            if (i < inputArray.length -1) {
                                if (inputArray[i + 1].equals("S")) {
                                    robotObject.downAndLeft();
                                    i++;
                                } else if (inputArray[i + 1].equals("N")) {
                                    robotObject.upAndLeft();
                                    i++;
                                } else {
                                    robotObject.left();
                                }
                            } else {
                                robotObject.left();
                            }

                            break;

                        case "S":
                            if (i < inputArray.length -1) {
                                if (inputArray[i + 1].equals("E")) {
                                    robotObject.downAndRight();
                                    i++;
                                } else if (inputArray[i + 1].equals("W")) {
                                    robotObject.downAndLeft();
                                    i++;
                                } else {
                                    robotObject.down();
                                }
                            } else {
                                robotObject.down();
                            }

                            break;

                        case "N":
                            if (i < inputArray.length -1) {
                                if (inputArray[i + 1].equals("E")) {
                                    robotObject.upAndRight();
                                    i++;
                                } else if (inputArray[i + 1].equals("W")) {
                                    robotObject.upAndLeft();
                                    i++;
                                } else {
                                    robotObject.up();
                                }
                            } else {
                                robotObject.up();
                            }

                            break;

                        case "D":
                            drop();
                            break;

                        case "G":
                            grap();
                            break;

                        default:
                            System.out.println("Wrong command. Please type again !");
                            break;
                    }
                }
                System.out.println("The position of Robot are x: "+ robotObject.getX()+ "   y: "+ robotObject.getY());
            }

        }
    }
    public static void drop () {
        if (robotObject.getCheckGrap()) {
            if(grid[robotObject.getX()][robotObject.getY()]==0) {
                initCrate(robotObject.getX(), robotObject.getY());
                robotObject.setCheckGrap(false);
                System.out.println("Drop Done");
            } else {
                System.out.println("Cannot drop here. already has crate here");
            }
        } else {
            System.out.println("Nothing to drop");
        }
    }

    public static void grap() {
        if (!robotObject.getCheckGrap()) {
            if(grid[robotObject.getX()][robotObject.getY()]==1) {
                removeCrate(robotObject.getX(), robotObject.getY());
                robotObject.setCheckGrap(true);
                System.out.println("Grap Done");
            } else {
                System.out.println("Nothing to grap here !");
            }
        } else {
            System.out.println("Robot's Already grap");
        }
    }

    public static void removeCrate(int x, int y) {
        if (x >=0 && x <= 9 && y >=0 && y <= 9) {
            if (grid[x][y] == 1) {
                grid[x][y]=0;
            } else {
                System.out.println("there was not crate to remove");
            }

        }
    }

    public static void initCrate(int x, int y) {
        if (x >=0 && x <= 9 && y >=0 && y <= 9) {
            if (grid[x][y] == 0) {
                grid[x][y]=1;
            } else {
                System.out.println("there was crate here. cannot init here");
            }
        }
    }
}

class RobotObject {
    private int x;
    private int y;
    private boolean checkGrap;

    public RobotObject () {

    }

    public RobotObject (int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void setX (int x) {
        this.x = x;
    }

    public int getX () {
        return this.x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public int getY () {
        return this.y;
    }

    public void setCheckGrap (boolean checkGrap) {
        this.checkGrap= checkGrap;
    }

    public boolean getCheckGrap () {
        return this.checkGrap;
    }

    public void up () {
        if (y < 9) y++;
    }

    public void down() {
        if (y>0) y--;
    }

    public void right () {
        if (x < 9)  x++;
    }

    public void left () {
        if (x > 0) x--;
    }

    // this one for part 3
    public void upAndLeft () {
        if (y<9) y++;
        if (x>0) x--;
    }

    public void upAndRight () {
        if (y<9) y++;
        if (x<9) x++;
    }

    public void downAndLeft () {
        if (y>0) y--;
        if (x>0) x--;
    }

    public void downAndRight () {
        if (y>0) y--;
        if (x<9) x++;
    }

}