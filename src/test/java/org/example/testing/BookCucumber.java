package org.example.testing;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.classes.Book;
import org.example.classes.BookStore;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookCucumber {

    private BookStore store;
    private List<Book> foundBooks;

    @Before
    public void setUp() {
        store = new BookStore();
        foundBooks = new ArrayList<>();
    }

    @DataTableType
    public Book bookEntry(Map<String, String> entry) {
        return new Book(entry.get("title"), entry.get("author"));
    }

    @Given("^I have the following books in the store$")
    public void haveBooksInTheStoreByList(List<Book> books) {
        store.addAllBooks(books);
    }

    @When("I search for books by author {string}")
    public void findBookByAuthor(String author) {
        foundBooks = store.booksByAuthor(author);
        System.out.println("Found " + foundBooks.size() + " books");
    }

    @Then("I find {int} books")
    public void checkCount(int count) {
        Assert.assertEquals(count, foundBooks.size());
    }
}
