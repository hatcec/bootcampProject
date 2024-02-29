package tobeto.bootcampProject.wepApi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResult<?> dataResult) {
        if(dataResult.isSuccess()) {
            return ResponseEntity.ok(dataResult);
        }
        return ResponseEntity.badRequest().body(dataResult);
    }


    public ResponseEntity<?> handleResult(Result result) {
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
