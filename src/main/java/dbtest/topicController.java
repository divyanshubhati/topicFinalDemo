package dbtest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class topicController {
	@Autowired
	private topicServices ts;
	
	@RequestMapping("/topics")
	public List<topics> getAlltopics(){
		return ts.getAllTopics(); 
		
	} 
	
	@RequestMapping("/topics/{Id}")
	public topics getTopic(@PathVariable String Id) {
		return ts.getTopic(Id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopics(@RequestBody topics tp) {
		ts.addTopics(tp);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void addTopics(@RequestBody topics tp,@PathVariable String id) {
		ts.updateTopics(id,tp);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopics(@PathVariable String id) {
		ts.deleteTopics(id);
	}


	@RequestMapping(method=RequestMethod.GET, value="/test")
	public String deleteTopics() {
	return  "Hello";
	}


}
