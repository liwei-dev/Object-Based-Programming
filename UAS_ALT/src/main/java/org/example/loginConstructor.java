package org.example;

class loginConstructor{

    private String userID;
    private String userCode;

    public loginConstructor(String userID, String userCode, String userInput) {
        this.userID = userID;
        this.userCode= userCode;
    }

    public loginConstructor(){}

    public String getUserID() {
        return userID;
    }

    public String getUserCode() {
        return userCode;
    }

}
