package demo.boot.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    
    @GetMapping("/settings")
    public String settings() {
        return "{url: {profile: 'profileUrl'}}";
    }
}