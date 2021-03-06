package src;

import java.lang.String;

public class Messages {
    private String message;
    private String title;
    private String name;

    //Constructor, sets title, message, and name to be used in one step
    Messages (String m, String t) {
        this.message = m;
        this.title = t;
    }

    //Only requires the message to be input
    Messages (String m){
        this.message = m;
        this.title = "";
        this.name = "";
    }
    //Empty to allow instantiation without needing to initialized
    Messages() {
        this.message = "";
        this.title = "";
        this.name = "";
    }


    //////// New included getter functions //////////////
    public String getContent() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }
    //////////////////////////////////////////////////////



    //set message that will be used
    void setMessage(String m) {
        this.message = m;
        //Check if the name also exists and set the name in the message
        if (itemExists(this.name)) {
            this.nameInput();
        }
    }

    //set name to be used in the message
    void setName(String n){
        this.name = n;
        //Check if the message also exists and set the name in the message
        if(itemExists(this.message)){
            this.nameInput();
        }
    }

    //Set title for the message
    void setTitle(String t){
        this.title = t;
    }

    //Check if the name, title, or message has been input
    private boolean itemExists(String item){
        //Set boolean variable, initialized
        boolean exists = false;
        //Validate existence
        if(item == ""){
            exists = false;
        }
        return exists;
    }

    //Change the dollar sign place holder for the name inputted
    private void nameInput() {
        if(itemExists(this.message) && itemExists(this.name)) {
            this.message.replace("`", this.name);
        }
    }

    void display (){
        System.out.println(this.message);
    }

    //Erases all data from the object, sets to NULL
    void erase () {
        this.message = "";
        this.title = "";
        this.name = "";
    }
}