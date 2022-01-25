package br.com.renan.book.config

import br.com.renan.book.domain.Book
import br.com.renan.book.repository.BookRepository
import com.github.javafaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BookInitializer(var bookRepository: BookRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val faker = Faker()

        for (i in 1..10) {
            val book = Book(faker.book().author(), faker.book().genre(), faker.book().publisher(), faker.book().title())
            bookRepository.save(book)
        }
    }
}