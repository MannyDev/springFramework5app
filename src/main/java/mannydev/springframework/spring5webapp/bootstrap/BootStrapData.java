package mannydev.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mannydev.springframework.spring5webapp.domain.Address;
import mannydev.springframework.spring5webapp.domain.Author;
import mannydev.springframework.spring5webapp.domain.Book;
import mannydev.springframework.spring5webapp.domain.Publisher;
import mannydev.springframework.spring5webapp.repositories.AuthorRepository;
import mannydev.springframework.spring5webapp.repositories.BookRepository;
import mannydev.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;


	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setAdress(new Address("C/Huertas", "Madrid", "Spain", "28014"));
		
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Evans");
		Book asd = new Book("Book of Air", "124134235");
		
		eric.getBooks().add(asd);
		asd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(asd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "89898799");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books:" + bookRepository.count());
		System.out.println("Publisher details: " + publisher.getName() + ", "
				+ publisher.getAdress().getCity());
		
	}

}
