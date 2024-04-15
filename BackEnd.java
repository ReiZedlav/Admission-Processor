
public class BackEnd{
    double GPA;
    String course;
    String name;
    String age;
    
    //PUT STUDENT RELATED DATA HERE
}

class Credentials extends Information{
    String username;
    String password;

    Boolean authenticated = false;

    public Credentials(String u, String p){ //CONSTRUCTOR IS USED FOR THE SIGNING UP PROCESS
        this.username = u;
        this.username = p;
    }

    public Boolean Authenticate(String u, String p){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        } else{
            return false;
        }
    }

}  
