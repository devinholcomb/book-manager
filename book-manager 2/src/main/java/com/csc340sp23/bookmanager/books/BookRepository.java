
package com.csc340sp23.bookmanager.books;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author devin
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
