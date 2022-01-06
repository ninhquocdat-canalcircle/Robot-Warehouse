package warehouse.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class WarehouseRobot {
    public static void main(String[] args) {
        BufferedReader reader = null;
        Warehouse wh = new Warehouse();
        //init robot
        Robot robot = new Robot();
        //init the first crate
        wh.place(4, 4);
        //init the second crate at northeast 
        wh.place(9, 9);
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Please input command: ");
                String cmd = reader.readLine();
                if (cmd != null) {
                    cmd = cmd.trim().toUpperCase();
                    String[] steps = cmd.split("\\s+");
                    for (int i = 0; i < steps.length; i++) {
                        switch (steps[i]) {
                            case "N":
                                if (i < steps.length - 1) {
                                    if ("E".equals(steps[i + 1])) {
                                        robot.moveNorthEast();
                                        i++;
                                    } else if ("W".equals(steps[i + 1])) {
                                        robot.moveNorthWest();
                                        i++;
                                    } else {
                                        robot.moveNorth();
                                    }
                                } else {
                                    robot.moveNorth();
                                }
                                break;
                            case "W":
                                if (i < steps.length - 1) {
                                    if ("S".equals(steps[i + 1])) {
                                        robot.moveSouthWest();
                                        i++;
                                    } else if ("N".equals(steps[i + 1])) {
                                        robot.moveNorthWest();
                                        i++;
                                    } else {
                                        robot.moveWest();
                                    }
                                } else {
                                    robot.moveWest();
                                }
                                break;
                            case "E":
                                if (i < steps.length - 1) {
                                    if ("S".equals(steps[i + 1])) {
                                        robot.moveSouthEast();
                                        i++;
                                    } else if ("N".equals(steps[i + 1])) {
                                        robot.moveNorthEast();
                                        i++;
                                    } else {
                                        robot.moveEast();
                                    }
                                } else {
                                    robot.moveEast();
                                }
                                break;
                            case "S":
                                if (i < steps.length - 1) {
                                    if ("E".equals(steps[i + 1])) {
                                        robot.moveSouthEast();
                                        i++;
                                    } else if ("W".equals(steps[i + 1])) {
                                        robot.moveSouthWest();
                                        i++;
                                    } else {
                                        robot.moveSouth();
                                    }
                                } else {
                                    robot.moveSouth();
                                }
                                break;
                            case "D":
                                robot.drop(wh);
                                break;
                            case "G":
                                robot.grab(wh);
                                break;
                            default:
                                System.out.println("Not apply for " + steps[i]);
                                break;
                        } 
                    }
                    robot.printLocation();
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error Msg: " + ioe.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println("Reader close exception " + ex.getMessage());
                }
            }
        }
    }

}

