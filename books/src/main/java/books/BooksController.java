package books;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Collections;
import java.util.List;

@Controller("/books")
public class BooksController {

    @Get
    List<Book> index() {
        return Collections.singletonList(new Book("Building Microservices"));
    }
}
