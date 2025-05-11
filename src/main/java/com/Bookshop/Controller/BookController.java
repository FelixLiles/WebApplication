package com.Bookshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bookshop.Model.Book;
import com.Bookshop.Model.MyBookList;
import com.Bookshop.Service.BookService;
import com.Bookshop.Service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	
	@GetMapping("/book_register")
	
	public String bookRegister() {
		
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	
	public ModelAndView getAllBooks() {
		List<Book>list=bookService.getAllBooks();
		return new ModelAndView("bookList","book",list);
		
	}
	 
	 @PostMapping("/save")
	 public String addBook(@ModelAttribute Book b) {
		 bookService.save(b);
		 return "redirect:/available_books";
	 }
	 
	 
	 @GetMapping("/my_books")
	
	public String getMyBooks(Model model) {
		 List<MyBookList>list = myBookService.getAllBooks();
		 model.addAttribute("book",list);
		 return "myBooks";
	 }
	 
	 @RequestMapping("/mylist/{id}")
	 public String getMyList(@PathVariable("id") long id) {
		 Book b = bookService.getBoookById(id);
		 MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		 myBookService.saveMyBooks(mb);
		 return "redirect:/my_books";
	 }
	 
	 @RequestMapping("/editBook/{id}")
	 
	 public String editBook(@PathVariable("id") long id, Model model) {
		Book b = bookService.getBoookById(id);
		 model.addAttribute("book",b);
		 return "bookEdit";
	 }
	 
	 @RequestMapping("/deleteBook/{id}")
	 public String deleteBook(@PathVariable("id") long id) {
		  
		 bookService.deleteById(id);
		  return "redirect:/available_books";
	 }
	 
	 
	 

	 
	 
}
