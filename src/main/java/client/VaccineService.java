package client;

/* The CAOService class has constants to define all of the messages that are sent between the Client and Server
 */

public class VaccineService
{
    /* The CAOService class has constants to define all of the messages that are sent between the Client and Server
     */
    public static final int PORT_NUM = 50025;
    public static final String HOSTNAME = "localhost";

    public static final String BREAKING_CHARACTER = "%%";

    public static final String REGISTER_COMMAND = "REGISTER";
    public static final String SUCCESSFUL_REGISTER = "REGISTERED";
    public static final String FAILED_REGISTER = "REG FAILED";

    public static final String LOGIN_COMMAND = "LOGIN";
    public static final String LOGOUT_COMMAND = "LOGOUT";
    public static final String LOGIN_SUCCESSFUL = "LOGGED IN";
    public static final String LOGIN_FAILED = "LOGIN FAILED";
    public static final String LOGGED_OUT = "LOGGED OUT";


    public static final String DISPLAY_COMMAND = "DISPLAY COURSE";
    public static final String DISPLAY_FAILED = "DISPLAY FAILED";

    public static final String DISPLAY_ALL = "DISPLAY ALL";
    public static final String FAILED_DISPLAY_ALL = "DISPLAY ALL FAILED";
    public static final String SUCCESSFUL_DISPLAY_ALL = "SUCCESSFUL DISPLAY ALL ";

    public static final String DISPLAY_CURRENT = "DISPLAY CURRENT";
    public static final String FAILED_DISPLAY_CURRENT = "DISPLAY CURRENT FAILED";
    public static final String SUCCESSFUL_DISPLAY_CURRENT = "DISPLAY CURRENT SUCCESSFUL";

    public static final String UPDATE_CURRENT = "UPDATE COMMAND";
    public static final String FAILED_UPDATE_CURRENT = "UPDATE CURRENT FAILED";
    public static final String SUCCESSFUL_UPDATE_CURRENT = "UPDATE CURRENT SUCCESSFUL";
}

