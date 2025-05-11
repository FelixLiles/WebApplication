package com.Bookshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookshop.Model.MyBookList;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList, Long> {

}
