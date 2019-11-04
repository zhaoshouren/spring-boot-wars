package demo.boot.main;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements ErrorController {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static final String ERROR_PATH = "/error";

	@RequestMapping(ERROR_PATH)
    public String error(HttpServletRequest request) {
        Object errorStatusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (errorStatusCode != null) {
            if (Integer.valueOf(errorStatusCode.toString()) == HttpStatus.NOT_FOUND.value()) {
                return "forward:/index.html";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
