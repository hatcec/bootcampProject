package tobeto.bootcampProject.wepApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import tobeto.bootcampProject.business.requests.applicationstate.CreateApplicationStateRequest;
import tobeto.bootcampProject.business.requests.applicationstate.UpdateApplicationStateRequest;

public class ApplicationStateController extends  BaseController{
    private ApplicationStateService applicationStateService;
    @RequestMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(applicationStateService.getAll());
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateApplicationStateRequest createApplicationStateRequest) {
        return handleDataResult(applicationStateService.add(createApplicationStateRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateApplicationStateRequest updateApplicationStateRequest) {
        return handleDataResult(applicationStateService.update(updateApplicationStateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return  handleResult(applicationStateService.delete(id));
    }
}
