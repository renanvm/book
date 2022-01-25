package br.com.renan.book.resource

import br.com.renan.book.domain.Book
import br.com.renan.book.repository.BookRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookResource(var bookRepository: BookRepository) {

    @GetMapping()
    fun getAllBooks(): List<Book> {
        return bookRepository.findAll();
    }

    @PostMapping
    fun saveBook(@RequestBody book: Book) {
        bookRepository.save(book)
    }

    @PutMapping
    fun updateBook(@RequestBody book: Book) {
        bookRepository.save(book)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book {
        return bookRepository.findById(id).get()
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: Long) {
        bookRepository.deleteById(id)
    }

}