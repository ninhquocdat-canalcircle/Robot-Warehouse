package warehouse.robot;

public class Robot {
    private boolean isGrabing = false;
    protected int x;
    protected int y;
    
    public Robot() {
        System.out.println("Init Robot at southwest (0, 0)");
        this.x = 0;
        this.y = 0;
    }
    
    public Robot(int x, int y) {
        System.out.println("Init Robot  at x = " + x + " y = " + y);
        this.x = x;
        this.y = y;
    }

    public void moveNorth() {
        if (this.y < 9) {
            this.y += 1;
        }
    }
    
    public void moveNorthEast() {
        if (this.y < 9) {
            this.y += 1;
        }
        if (this.x < 9) {
            this.x += 1;
        }
    }
    
    public void moveNorthWest() {
        if (this.y < 9) {
            this.y += 1;
        }
        if (this.x > 0) {
            this.x -= 1;
        }
    }

    public void moveSouth() {
        if (this.y > 0) {
            this.y -= 1;
        }
    }
    
    public void moveSouthEast() {
        if (this.y > 0) {
            this.y -= 1;
        }
        if (this.x < 9) {
            this.x += 1;
        }
    }
    
    public void moveSouthWest() {
        if (this.y > 0) {
            this.y -= 1;
        }
        if (this.x > 0) {
            this.x -= 1;
        }
    }
    
    public void moveEast() {
        if (this.x < 9) {
            this.x += 1;
        }
    }
    
    public void moveWest() {
        if (this.x > 0) {
            this.x -= 1;
        }
    }

    public void grab(Warehouse wh) {
        if (!this.isGrabing) {
            if (wh.grabable(this.x, this.y)) {
                System.out.println("Grab a crate at x = " + this.x + " y = " + this.y);
                this.isGrabing = true;
                wh.moveOut(this.x, this.y);
            }
        } else {
            System.out.println("Grabing. Cannot grab more");
        }
    }

    public void drop(Warehouse wh) {
        if (this.isGrabing) {
            if (wh.dropable(this.x, this.y)) {
                this.isGrabing = false;
                System.out.println("Drop a crate at x = " + this.x + " y = " + this.y);
                wh.place(this.x, this.y);
            }
        } else {
            System.out.println("Can not drop");
        }
    }

    public void printLocation() {
        System.out.println("Robot is at x = " + this.x + ", y = " + this.y);
    }

}
