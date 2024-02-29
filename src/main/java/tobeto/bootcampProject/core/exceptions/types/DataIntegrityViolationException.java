package tobeto.bootcampProject.core.exceptions.types;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message) {//veritabanında hata olduğunda.
        super(message);
    }
}
