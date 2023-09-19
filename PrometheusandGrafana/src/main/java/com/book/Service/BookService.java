
package com.book.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import com.book.Entity.Book;
import com.book.Repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final Counter createCounter;
	private final Counter readCounter;
	private final Counter updateCounter;
	private final Counter deleteCounter;

	@Autowired
	public BookService(MeterRegistry meterRegistry, BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		this.createCounter = Counter.builder("custom.book.create.counter").register(meterRegistry);
		this.readCounter = Counter.builder("custom.book.read.counter").register(meterRegistry);
		this.updateCounter = Counter.builder("custom.book.update.counter").register(meterRegistry);
		this.deleteCounter = Counter.builder("custom.book.delete.counter").register(meterRegistry);
	}

	public Book addBook(Book book) {
		createCounter.increment();
		return bookRepository.save(book);
	}

	public Book findById(int id) {
		readCounter.increment();
		return bookRepository.findById(id).orElse(null);
	}

	public Page<Book> getAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	public Book updateBook(Book book, Integer id) {
		updateCounter.increment();
		book.setId(id);
		return bookRepository.save(book);
	}

	public void deleteBookById(int id) {
		deleteCounter.increment();
		bookRepository.deleteById(id);
	}

}
