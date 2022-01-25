package br.com.renan.book.resource

import br.com.renan.book.domain.Book
import br.com.renan.book.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookResource(val bookService: BookService) {

    @GetMapping()
    fun getAllBooks(): List<Book> {
        return bookService.findAll();
    }

    @PostMapping
    fun createBook(@RequestBody book: Book) {
        bookService.saveOrUpdate(book)
    }

    @PutMapping
    fun updateBook(@RequestBody book: Book) {
        bookService.saveOrUpdate(book)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book {
        return bookService.findById(id).get()
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: Long) {
        bookService.deleteById(id)
    }

}