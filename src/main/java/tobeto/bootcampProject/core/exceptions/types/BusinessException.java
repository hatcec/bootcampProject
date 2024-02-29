package tobeto.bootcampProject.core.exceptions.types;

public class BusinessException extends  RuntimeException{
    public  BusinessException (String  message){
        super(message);//super base sınıftır. runtime a mesajı yolladık
    }
}
