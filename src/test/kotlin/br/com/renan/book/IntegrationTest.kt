package br.com.renan.book

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTest(@Autowired val restTemplate : TestRestTemplate) {

    @Test
    fun testBookEndpoint(){
        val entity = restTemplate.getForEntity<String>("/books")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

}