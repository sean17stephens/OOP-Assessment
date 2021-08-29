package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class VaccineClient {
    private static Scanner kb = new Scanner(System.in);
    Socket socket;
    BufferedReader socketReader;
    PrintWriter socketWriter;

    public static void main(String[] args) {
        VaccineClient client = new VaccineClient();
        client.doLoginMenuLoop();
    }

    public VaccineClient() {
        try {
            this.socket = new Socket("localhost", 50000);

            InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
            this.socketReader = new BufferedReader(isReader);

            this.socketWriter = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort());

        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }


    private void doLoginMenuLoop() {
        boolean loop = true;
        int option;
        LoginMenu LoginMenuOption;

        while (loop) {
            printLoginMenu();
            try {
                option = kb.nextInt();
                kb.nextLine();
                LoginMenuOption = LoginMenu.values()[option];
                switch (LoginMenuOption) {
                    case QUIT:
                        loop = false;
                        break;
                    case REGISTER:
                        System.out.println("Register chosen");
                        register();
                        break;
                    case LOGIN:
                        System.out.println("Login Chosen");
                        login();
                        doMenuLoop();
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doMenuLoop() {
        boolean loop = true;
        int option;
        Menu menuOption;

        while (loop) {
            printMainMenu();
            try {
                option = kb.nextInt();
                kb.nextLine();
                menuOption = Menu.values()[option];
                switch (menuOption) {
                    case QUIT:
                        loop = false;
                        break;
                    case LOGOUT:
                        System.out.println("Register chosen");
                        logout();
                        break;
                    case DISPLAY_VACCINE_CENTRES:
                        System.out.println("Display Vaccine Centres");
                        findVaccineCentre();
                        break;
                    case BOOK_VACCINE:
                        System.out.println("Book Vaccine");
                        bookVaccine();
                        break;
                    case DISPLAY_VACCINE_APPOINTMENT:
                        System.out.println("Display Vaccine Appointment");
                        displayVaccineAppointment();
                        break;
                    case UPDATE_VACCINE_APPOINTMENT:
                        System.out.println("Update Vaccine Appointment");
                        updateVaccineAppointment();
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void printLoginMenu() {
        System.out.println("\n Options to select:");
        for (int i = 0; i < LoginMenu.values().length; i++) {
            System.out.println("\t" + i + ". " + LoginMenu.values()[i].toString());
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }

    private void printMainMenu() {
        System.out.println("\n Options to select:");
        for (int i = 0; i < Menu.values().length; i++) {
            System.out.println("\t" + i + ". " + Menu.values()[i].toString());
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }

    private void register() {
        try {
            System.out.println("Enter a user id");
            int user_id = kb.nextInt();
            kb.nextLine();
            RegexChecker.checkUser(user_id);
            System.out.println("Please enter your email");
            String email = kb.nextLine();
            RegexChecker.checkEmail(email);
            System.out.println("Please enter your password");
            String password = kb.nextLine();
            RegexChecker.checkPassword(password);

            String message = VaccineService.REGISTER_COMMAND + VaccineService.BREAKING_CHARACTER +
                    user_id + VaccineService.BREAKING_CHARACTER +
                    email + VaccineService.BREAKING_CHARACTER +
                    password;

            System.out.println("Message ready to be sent to the server" + message);

            this.socketWriter.println(message);

            String response = this.socketReader.readLine();
            System.out.println(response);
            if (response.equalsIgnoreCase("Registered")) {
                System.out.println("Connected to the server successfully");
            } else if (response.equalsIgnoreCase("Reg failed")) {
                System.out.println("Registration Unsuccessful");
            }
        } catch (Exception e) {
        }
    }


    public void login() throws IOException {
        System.out.println("LOGIN");
        System.out.println("Please enter your user id:");
        int user_id = kb.nextInt();
        RegexChecker.checkUser(user_id);
        System.out.println("Please enter your Password: ");
        String password = kb.next();

        String message = VaccineService.LOGIN_COMMAND + VaccineService.BREAKING_CHARACTER + user_id + VaccineService.BREAKING_CHARACTER +
                password;

        System.out.println("Message ready to be sent to the server" + message);

        System.out.println(message);
        this.doMenuLoop();
        /*if (socketReader.readLine().equalsIgnoreCase("True")) {
            System.out.println("Login Successful");

            this.doMenuLoop();

        } else {
            System.out.println("Login Failed");
        }*/

    }

    public void logout() {
        System.out.println("You have been logged out");
        doLoginMenuLoop();
    }


    public void findVaccineCentre() {
        try {

            System.out.println("Find Vaccine Centre");
            System.out.println("Please enter the vaccine centre you want to see.");
            String vaccine = kb.next();

            String message = VaccineService.DISPLAY_COMMAND + VaccineService.BREAKING_CHARACTER +
                    vaccine;

            System.out.println("Message ready to be sent to the server" + message);

            this.socketWriter.println(message);
            String response = this.socketReader.readLine();

            if (response.startsWith("Vaccine")) {
                System.out.println(response);
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
        }
    }

    public void bookVaccine() {
        try {

            System.out.println("Book Vaccine");
            System.out.println("Please enter the vaccine details");
            String vaccine = kb.next();

            String message = VaccineService.DISPLAY_COMMAND + VaccineService.BREAKING_CHARACTER +
                    vaccine;

            System.out.println("Message ready to be sent to the server" + message);

            this.socketWriter.println(message);
            String response = this.socketReader.readLine();

            if (response.startsWith("Vaccine")) {
                System.out.println(response);
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
        }

    }


    public void displayVaccineAppointment() {
        try {

            String message = VaccineService.DISPLAY_ALL;

            System.out.println("Message ready to be sent to the server" + message);

            socketWriter.println(message);

            String test = this.socketReader.readLine();
            System.out.println(test);

            String response = this.socketReader.readLine();
            System.out.println(response);

            if (response.startsWith("SUCCESSFUL DISPLAY ALL")) {
                System.out.println(response);
            }
        } catch (Exception e) {

        }

    }

    public void updateVaccineAppointment() {
        try {
            System.out.println("Find users appointment");
            System.out.println("Please enter your User id:");
            int user_id = kb.nextInt();
            RegexChecker.checkUser(user_id);

            String message = VaccineService.DISPLAY_CURRENT + VaccineService.BREAKING_CHARACTER +
                    user_id;

            System.out.println("Message ready to be sent to the server" + message);

            socketWriter.println(message);

            String response = this.socketReader.readLine();
            System.out.println(response);
        } catch (Exception e) {
        }

    }
}

