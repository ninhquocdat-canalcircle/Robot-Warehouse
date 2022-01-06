package warehouse.robot;
public class Warehouse {

    private int[][] warehouseGrid = new int[10][10];

    public void place(int x, int y) {
        if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
            if (warehouseGrid[x][y] == 0) {
                warehouseGrid[x][y] = 1;
            } else {
                System.out.println("There is a crate here. Can not drop");
            }
        }
    }

    public void moveOut(int x, int y) {
        if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
            if (warehouseGrid[x][y] == 1) {
                warehouseGrid[x][y] = 0;
            } else {
                System.out.println("There is no crate to grab");
            }
        }
    }

    public boolean grabable(int x, int y) {
        if (warehouseGrid[x][y] == 0) {
            System.out.println("There is no crate to grab");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean dropable(int x, int y) {
        if (warehouseGrid[x][y] == 1) {
            System.out.println("There is a crate here. Can not drop");
            return false;
        } else {
            return true;
        }
    }
}
