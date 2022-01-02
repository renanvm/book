package br.com.renan.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book(
    var author: String,
    var genre: String,
    var title: String,
    var publisher: String
) {
    @Id @GeneratedValue var id: Long? = null
}