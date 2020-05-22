package peterSpringPractice.PracticeWebApp.repositiories;


import org.springframework.data.repository.CrudRepository;

import peterSpringPractice.PracticeWebApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
	
}
