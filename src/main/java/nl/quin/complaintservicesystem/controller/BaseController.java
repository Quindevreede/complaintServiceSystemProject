package nl.quin.complaintservicesystem.controller;
// gebruiken we voor file upload...
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/")
    public String index() {
        return "Endpoint: POST /file-upload";
    }

}
