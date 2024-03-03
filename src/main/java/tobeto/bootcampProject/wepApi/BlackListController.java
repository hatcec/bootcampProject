package tobeto.bootcampProject.wepApi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.abstracts.BlackListService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import tobeto.bootcampProject.business.requests.blacklist.CreateBlackListRequest;
import tobeto.bootcampProject.business.requests.blacklist.UpdateBlackListRequest;

@RestController
@RequestMapping("/blacklists")
@RequiredArgsConstructor
public class BlackListController extends  BaseController{
    private final BlackListService blackListService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(blackListService.getAll());
    }


    @GetMapping("/{id}")//variable al pathden okur
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(blackListService.getById(id));

    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateBlackListRequest createBlackListRequest) {
        return handleDataResult(blackListService.add(createBlackListRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateBlackListRequest updateBlackListRequest) {
        return handleDataResult(blackListService.update(updateBlackListRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(blackListService.delete(id));
    }

}
