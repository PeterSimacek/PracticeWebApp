package peterSpringPractice.PracticeWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import peterSpringPractice.PracticeWebApp.domain.Author;
import peterSpringPractice.PracticeWebApp.domain.Book;
import peterSpringPractice.PracticeWebApp.domain.Publisher;
import peterSpringPractice.PracticeWebApp.repositiories.AuthorRepository;
import peterSpringPractice.PracticeWebApp.repositiories.BookRepositories;
import peterSpringPractice.PracticeWebApp.repositiories.PublisherRepository;

@Component	// Tells Spring to detect BootStrapData as Spring Manage Component
public class BootStrapData implements CommandLineRunner{	// tells Spring to look for instances of this type and run them

	private final AuthorRepository authorRepository;	//dependency injection (later in course)
	private final BookRepositories bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	// once Spring implements this component, it will do dependency injection into the
	// constructor for an instance of AuthorRepositiory and BookRepositiory
	public BootStrapData(AuthorRepository authorRepositoty, BookRepositories bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepositoty;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in Bootstrap");
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","123123");
		Publisher bmu = new Publisher();
		bmu.setName("BMU");
		bmu.setCity("Berlin");
		
		publisherRepository.save(bmu);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(bmu);
		bmu.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(bmu);
		
		Author rod =  new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "237643782");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(bmu);
		bmu.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(bmu);
		
		System.out.println("Publisher Count: " + publisherRepository.count());
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Publisher Number of books: " + bmu.getBooks().size());
	}

}
