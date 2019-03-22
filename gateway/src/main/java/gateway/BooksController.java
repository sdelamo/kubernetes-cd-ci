package gateway;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.Collections;
import java.util.List;

@Controller("/books")
public class BooksController {

    private final BooksClient booksClient;

    public BooksController(BooksClient booksClient) {
        this.booksClient = booksClient;
    }
    @Get
    Single<List<Book>> index() {
        return booksClient.index();
    }
}
