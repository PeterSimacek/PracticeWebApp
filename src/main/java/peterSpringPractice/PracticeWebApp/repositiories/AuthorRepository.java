package peterSpringPractice.PracticeWebApp.repositiories;

import org.springframework.data.repository.CrudRepository;

import peterSpringPractice.PracticeWebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
