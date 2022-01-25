package br.com.renan.book.service

import br.com.renan.book.domain.Book
import br.com.renan.book.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(val bookRepository: BookRepository) {

    fun saveOrUpdate(book: Book) {
        bookRepository.save(book)
    }

    fun findAll() : List<Book>{
        return bookRepository.findAll()
    }

    fun findById(id: Long): Optional<Book> {
        return bookRepository.findById(id)
    }

    fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }

}