package com.hansen.bookshelf.ctrlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.bookshelf.model.Book;
import com.hansen.bookshelf.srvc.BookSrvc;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookSrvc bookSrvc;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Book bookToBeCreated) {
		ResponseEntity<String> bookResponse;
		
		
		String book = bookSrvc.createBook(bookToBeCreated);
		
		
		bookResponse = new ResponseEntity<String>(book, null, HttpStatus.CREATED);
		return bookResponse;
	}

	@RequestMapping(value = "{bookId}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable(value = "bookId") Integer bookId) {

		ResponseEntity<?> bookResponse = null;

		Book book = bookSrvc.getBook(bookId);

		if (book != null) {
			bookResponse = new ResponseEntity<Book>(book, null, HttpStatus.OK);
		} 
		else {
			bookResponse = new ResponseEntity<String>("NOT FOUND !! ", HttpStatus.NOT_FOUND);
		}

		return bookResponse;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> readAll() {
		ResponseEntity<List<Book>> bookResponse;
		
		
		List<Book> bookList = bookSrvc.getAllBooks();
		
		
		bookResponse = new ResponseEntity<List<Book>>(bookList, null, HttpStatus.OK);
		return bookResponse;
	}

	@RequestMapping(method = RequestMethod.PATCH) //OR PUT
    public ResponseEntity<String> update(@RequestBody Book bookToBeUpdated) {
        ResponseEntity<String> bookResponse;
        
        
        String book = bookSrvc.updateBook(bookToBeUpdated);
        
        
        bookResponse = new ResponseEntity<String>(book, null, HttpStatus.CREATED);
        return bookResponse;
    }

	@RequestMapping(value = "{bookId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "bookId") Integer bookId) {
		ResponseEntity<Boolean> bookResponse;
		
		
		boolean isdeleted = bookSrvc.deleteBook(bookId);
		
		
		
		if (isdeleted) {
			bookResponse = new ResponseEntity<Boolean>(isdeleted, null, HttpStatus.OK);
		} else {
			bookResponse = new ResponseEntity<Boolean>(isdeleted, null, HttpStatus.NOT_FOUND);
		}
		return bookResponse;
	}

}
