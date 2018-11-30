package DungeonsAndDragons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UserLogin {

    private static String url = "jdbc:mysql://localhost:3306/charactersheet_database";
    private static Label label = new Label("");

    /**
     * Allows user to login with username and password and close screen with "Close" button.
     * @return True if user is authenticated, false if uesr is closing the window
     */
    public static boolean main(CharacterSheet mainCharacter) {
        login("", new Stage(),mainCharacter);
        while (!label.getText().equals("true")){
            if (label.getText().equals("close")){
                return false;
            }else if (label.getText().equals("User created")){
                login("",new Stage(),mainCharacter);
            }else login("Invalid credentials. Please try again", new Stage(),mainCharacter);
        }
        return true;
    }

    /**
     * Prompts the user to login with username and password prior to opening charactersheet.
     * @param errorMessage String of an error message that would be displayed above the username and password fields.
     */
    private static void login (String errorMessage, Stage loginStage,CharacterSheet mainCharacter){
        label.setText("");
        VBox pane = new VBox(20);
        Scene scene = new Scene(pane,325,275);
        Label error = new Label(errorMessage);

        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        Button newUser = new Button("New User? Set up account here");
        Button login = new Button("Login");
        Button close = new Button("Close");

        close.setOnAction(e->{
            label.setText("close");
            loginStage.close();
        });

        login.setOnAction(e->{
            try {
                Connection con = DriverManager.getConnection(url,"generaluser","4Testing");
                PreparedStatement usernameQuery = con.prepareStatement("SELECT id FROM characterinfo WHERE username = ?");
                usernameQuery.setString(1,userName.getText());
                ResultSet usernameResultSet = usernameQuery.executeQuery();
                PreparedStatement passwordQuery = con.prepareStatement("SELECT password FROM characterinfo WHERE username = ?");
                passwordQuery.setString(1,userName.getText());
                ResultSet passwordResultSet = passwordQuery.executeQuery();

                if (usernameResultSet.next() && passwordResultSet.next()){
                    if (passwordResultSet.getString(1).equals(password.getText())){
                        System.out.println("Login successful");
                        //TODO Need to add primaryKey to Charactersheet. Take CharacterSheet as a parameter for main / login / newUser (mainCharacter = new Character(getPrimaryKey.executeQuery()););
                        label.setText("true");
                        con.close();
                        loginStage.close();
                    }else{
                        System.out.println("Login failed");
                        label.setText("false");
                        con.close();
                        loginStage.close();
                    }
                }
                else{
                    System.out.println("Login failed");
                    label.setText("false");
                    con.close();
                    loginStage.close();
                }


            } catch (SQLException q) {
                q.printStackTrace();


            }
        });

        newUser.setOnAction(e->{
            newUserSetUp("", loginStage,mainCharacter);
        });

        ButtonBar loginAndClose = new ButtonBar();
        loginAndClose.getButtons().addAll(login,close);
        loginAndClose.setTranslateX(-30);
        newUser.setTranslateX(13);

        pane.getChildren().addAll(error,new HBox(new Label("Username: "),userName),new HBox(new Label("Password:  "),password),loginAndClose,newUser);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(30,40,50,40));

        loginStage.setTitle("Login");
        loginStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("fx-border-color: black");
        loginStage.setScene(scene);
        loginStage.showAndWait();
    }

    private static void newUserSetUp (String errorMessage, Stage newUserStage,CharacterSheet mainCharacter){
        // Advise not to use a password that is used for anything secure
        VBox pane = new VBox(20);
        Scene scene;
        if (!errorMessage.equals("")){
            scene = new Scene(pane,410,400);
        }else scene = new Scene(pane,410,365);
        newUserStage.setTitle("New user set up");

        Label error = new Label(errorMessage);
        error.setTextFill(Color.RED);
        error.setWrapText(true);
        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        PasswordField confirmPassword = new PasswordField();
        Button createAccount = new Button("Create account");

        Pattern pattern = Pattern.compile("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}`~]+");

        createAccount.setOnAction(event -> {
            try {
                Connection con = DriverManager.getConnection(url,"generaluser","4Testing");

                if (password.getText().length()>=6 && userName.getText().length() >=6  ){
                    PreparedStatement uniqueUsernameCheck = con.prepareStatement("SELECT username from characterinfo WHERE username = ?");
                    uniqueUsernameCheck.setString(1,userName.getText());
                    ResultSet usernameResults = uniqueUsernameCheck.executeQuery();
                    if (!usernameResults.next()){
                        if (!password.getText().equals("")&&password.getText().equals(confirmPassword.getText()) && !userName.getText().equals("")){

                            Matcher usernameMatcher = pattern.matcher(userName.getCharacters());
                            Matcher passwordMatcher = pattern.matcher(password.getCharacters());
                            if (!usernameMatcher.find()&& !passwordMatcher.find()){
                                PreparedStatement createUser = con.prepareStatement("Insert INTO characterinfo(username,password) Values(?,?);");
                                createUser.setString(1,userName.getText());
                                createUser.setString(2,password.getText());
                                createUser.execute();
                                label.setText("User created");
                                con.close();
                                newUserStage.close();
                                System.out.println("User created");

                            }else{
                                newUserSetUp("Unable to create account from information provided. Please confirm that the username and password field do not contain special characters and that the password fields match", newUserStage,mainCharacter);
                                System.out.println("Error 1");
                            }
                        }
                        else{
                            newUserSetUp("Unable to create account from information provide. Please confirm that the username and password field do not contain special characters and that the password fields match", newUserStage,mainCharacter);
                            System.out.println("Error 2");
                        }
                    }else {
                        newUserSetUp("Unable to create account from information provide. Please select an unique username.", newUserStage,mainCharacter);
                        System.out.println("Error 3");
                    }
                } else {
                    newUserSetUp("Unable to create account from information provide. Please confirm that the username and password are greater than 6 characters", newUserStage,mainCharacter);
                    System.out.println("Error 4");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }



        });
        pane.getChildren().addAll(error,new HBox(new Label("Username: "),userName),new HBox(new Label("Password:  "),password),new HBox(new Label("Confirm Password: "),confirmPassword),createAccount, new Label("Requirements:\n1.) Username/Password length must exceed 5 characters\n2.) Username/Password cannot contain special characters.\n3.) Username must be unique."));

        userName.setTranslateX(50);
        password.setTranslateX(50);
        confirmPassword.setTranslateX(8);

        pane.setPadding(new Insets(20,50,50,50));
        pane.setAlignment(Pos.TOP_CENTER);
        newUserStage.setScene(scene);


    }

}
