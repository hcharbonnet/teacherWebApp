package springmvc.teacherWebApp.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String testing(@PathVariable String id) {
		String result = "test "+ id;
		return result;
	}

}
