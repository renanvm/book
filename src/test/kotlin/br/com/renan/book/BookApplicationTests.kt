package br.com.renan.book

import br.com.renan.book.domain.Book
import br.com.renan.book.repository.BookRepository
import br.com.renan.book.service.BookService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(
    MockitoExtension::class
)
class BookApplicationTests {

    @InjectMocks
    lateinit var bookService: BookService

    @Mock
    lateinit var bookRepository: BookRepository


    @Test
    fun givenBookIdShouldReturAnBook() {
        val book = Book("Uncle Bob", "Tech", "Clean Code", "Unknow")
        book.id = 1L
        val optionalBook = Optional.of(book)

        Mockito.`when`(bookRepository.findById(1L)).thenReturn(optionalBook)

        val current = bookService.findById(1L)

        Assertions.assertThat(current.get().author).isEqualTo(book.author)
    }

}

