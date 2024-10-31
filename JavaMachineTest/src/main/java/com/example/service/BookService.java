package com.example.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.entity.Book;
import com.example.repository.BookRepository;

@Component
public class BookService {
         

	
	@Autowired
	private BookRepository bookRepository;
	
		public List<Book> getAllBooks(){
		List<Book>list=(List<Book>)this.bookRepository.findAll();
		return list;
		
		}
	// get single book
	
	public Book getBookById(int id) {
		 Book book=null;
			

		try {
            this. bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}
		public Book addBook(Book b) {
			
				Book result = bookRepository.save(b);
				return result;
		
			}
	
	public void deleteBook(int bookId) {
	     bookRepository.deleteById(bookId);
	}
	
	public void updateBook(Book book,int bookId) {
		   book.setId(bookId);
	       bookRepository.save(book);
	}
}
