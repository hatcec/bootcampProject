package tobeto.bootcampProject.core.results;

public class Result {
    private boolean success;
    private String message;
    public  Result(boolean success){//sadece succes dönebilir
        this.success=success;
    }
    public  Result(boolean success, String message){
        this(success);
        this.message=message;
    }
    public  boolean isSuccess(){
        return success;
    }
    public  String getMessage(){//getterı
        return message;
    }
}
