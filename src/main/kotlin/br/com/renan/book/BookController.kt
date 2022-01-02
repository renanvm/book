package br.com.renan.book

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(var bookRepository: BookRepository) {

    @GetMapping()
    fun getAllBooks() : List<Book> {
       return bookRepository.findAll();
    }

    @PostMapping
    fun saveBook(@RequestBody book : Book) {
        bookRepository.save(book)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id : Long) : Book {
        return bookRepository.findById(id).get()
    }

}