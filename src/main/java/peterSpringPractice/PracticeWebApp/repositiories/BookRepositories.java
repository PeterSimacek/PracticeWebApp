package peterSpringPractice.PracticeWebApp.repositiories;


import org.springframework.data.repository.CrudRepository;

import peterSpringPractice.PracticeWebApp.domain.Book;

public interface BookRepositories extends CrudRepository<Book, Long> {

}
