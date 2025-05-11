package com.Bookshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookshop.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	
}
