package com.hasancbngl

import com.hasancbngl.models.ApiResponse
import com.hasancbngl.repository.HeroRepositoryImp
import com.hasancbngl.repository.NEXT_PAGE_KEY
import com.hasancbngl.repository.PREVIOUS_PAGE_KEY
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `access root endpoint, assert correct information`() =
        testApplication {
            val response = client.get("/")
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = response.status
            )
            assertEquals(
                expected = "Welcome to Hero API!",
                actual = response.bodyAsText()
            )
        }

    @Test
    fun `access all heroes endpoint, query all pages assert correct information`() =
        testApplication {
            val repo = HeroRepositoryImp()
            val pages = 1..5
            val heroes = listOf(
                repo.page1,
                repo.page2,
                repo.page3,
                repo.page4,
                repo.page5
            )
            pages.forEach { page ->
                val response = client.get("/heroes?page=$page")
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status
                )
                val expected = ApiResponse(
                    success = true,
                    message = "ok",
                    prevPage = calculatePage(page)["prevPage"],
                    nextPage = calculatePage(page)["nextPage"],
                    heroes = heroes[page - 1]
                )
                val actual = Json.decodeFromString<ApiResponse>(response.bodyAsText())
                assertEquals(
                    expected = expected,
                    actual = actual
                )
            }

        }

    @Test
    fun `access all heroes endpoint, query invalid page number, assert error`() = testApplication {
        val response = client.get("/heroes?page=asa")
        assertEquals(
            expected = HttpStatusCode.BadRequest,
            actual = response.status
        )
        val expected = ApiResponse(
            success = false,
            message = "Invalid Page.Only numbers allowed.",
        )
        val actual = Json.decodeFromString<ApiResponse>(response.bodyAsText())
        assertEquals(
            expected = expected,
            actual = actual
        )
    }

    @Test
    fun `access all heroes endpoint, query non existing page number, assert error`() =
        testApplication {
            val response = client.get("/heroes?page=8")
            assertEquals(
                expected = HttpStatusCode.NotFound,
                actual = response.status
            )
            println("response: ${response.bodyAsText()}")
            assertEquals(
                expected = "Page not found.",
                actual = response.bodyAsText()
            )
        }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) nextPage = nextPage?.plus(1)
        if (page in 2..5) prevPage = prevPage?.minus(1)
        if (page == 1) prevPage = null
        if (page == 5) nextPage = null
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }
}
