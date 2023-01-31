package com.hansen.bookshelf.srvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hansen.bookshelf.model.Book;

@Service
public class BookSrvc {

	private static final String Id = null;
	private static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();

	public String createBook(Book bookToBeCreated) {
		if(!bookMap.containsKey(bookToBeCreated.getId())) {
		bookMap.put(bookToBeCreated.getId(), bookToBeCreated);
		return "data Added";
	
	}
	else
	{
		return "ID  present";
	}
	
	}
	


	public Book getBook(Integer bookId) {
		return bookMap.get(bookId);
	}

	public List<Book> getAllBooks() {
		
		List<Book> bookList = new ArrayList<Book>(bookMap.values());
		return bookList; 
	}

	public String updateBook(Book bookToBeUpdated) {
        if(bookMap.containsKey(bookToBeUpdated.getId())) {
            bookMap.put(bookToBeUpdated.getId(), bookToBeUpdated);
            return "Book Updated";
        }
        else
        {
            return "Id not present..!";
        }
    }

	public boolean deleteBook(Integer bookId) {
		
        if(bookMap.containsKey(bookId))
        {
        bookMap.remove(bookId);
       
        }
        else
        {
        	return false;
        }
        return !bookMap.containsKey(bookId);
	
	}
	
}
