package dbtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class topicServices {

    @Autowired
	private TopicRepository topicRepository;

	private List<topics> top= new ArrayList<>(Arrays.asList(new topics("asd","Spring Framework", "Spring Framework Description"),
			new topics("102","JAVA", "JAVA Description"),
			new topics("103","C++", "C++ Description")
			));
	public List<topics> getAllTopics(){
		//return top;
		List<topics> tp = new ArrayList<>();
		topicRepository.findAll().forEach(tp::add);
		return tp;
		
	}
	
	public topics getTopic(String Id) {

		return top.stream().filter(t->t.getId().equals(Id)).findFirst().get();
				
		
	}

	public void addTopics(topics tp) {
		System.out.println(tp);
		topicRepository.save(tp);
		
	}

	public void updateTopics(String id, topics tp) {
		for(int i=0;i<top.size();i++) {
			topics t= top.get(i);
			if(t.getId().equals(id)) {
				top.set(i, tp);
				return;
			}
		}
		
	}

	public void deleteTopics(String id) {
		// TODO Auto-generated method stub
		top.removeIf(t->t.getId().equals(id));
	}
}
