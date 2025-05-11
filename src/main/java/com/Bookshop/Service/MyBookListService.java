package com.Bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookshop.Model.MyBookList;
import com.Bookshop.Repository.MyBookListRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookListRepository myBooks;
	
	public void saveMyBooks(MyBookList book) {
		
		myBooks.save(book);
	}
	
	
	public List<MyBookList> getAllBooks(){
		
		return myBooks.findAll();	}

	  public void deleteteById(long id) {
		  
		  myBooks.deleteById(id);
	  }
}
