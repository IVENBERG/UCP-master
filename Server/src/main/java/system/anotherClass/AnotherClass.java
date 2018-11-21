package system.anotherClass;

public class AnotherClass {
    public static int id;
    private String returnString;
    public static int id_user;
    public static int idServ;
    private String returnResult;


    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        AnotherClass.id = id;
    }
    public String getReturnString() {
        return returnString;
    }
    public void setReturnString(String returnString) {
        this.returnString = returnString;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getIdServ() {
        return idServ;
    }
    public void setIdServ(int idServ) {
        AnotherClass.idServ = idServ;
    }
    public String getReturnResult() {
        return returnResult;
    }
    public void setReturnResult(String returnResult) {
        this.returnResult = returnResult;
    }

}
