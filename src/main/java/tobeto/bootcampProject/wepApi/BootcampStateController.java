package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.BootCampStateService;
import tobeto.bootcampProject.business.requests.bootcampstate.CreateBootcampStateRequest;
import tobeto.bootcampProject.business.requests.bootcampstate.UpdateBootcampStateRequest;

@RestController
@RequestMapping("/bootcampstates")
@AllArgsConstructor
public class BootcampStateController  extends  BaseController{
    private BootCampStateService bootCampStateService;

    @RequestMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(bootCampStateService.getAll());
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateBootcampStateRequest bootcampStateRequest) {
        return handleDataResult(bootCampStateService.add(bootcampStateRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateBootcampStateRequest bootcampStateRequest) {
        return handleDataResult(bootCampStateService.update(bootcampStateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(bootCampStateService.delete(id));
    }
}
