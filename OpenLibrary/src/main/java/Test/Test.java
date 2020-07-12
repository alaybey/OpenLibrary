package Test;


import model.Author;
import model.Book;
import model.Publisher;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;
import repository.BookRepository;
import repository.BookRepositoryImpl;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        BookService bookService = new BookServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        RegisterService registerService = new RegisterServiceImpl();

        LoginService loginService = new LoginServiceImpl();
/*
        HttpSession session = SessionUtil.getSession(false); ->
        System.out.println(registerService.registerUser("deneme","deneme"));
        System.out.println(loginService.login("username", "pass"));

        List<Author> authors = authorService.findByAuthorName("hugo");
        List<Publisher> publishers = publisherService.findByPublisherName("selam");
        System.out.println("----");
        System.out.println(publishers);

        //create book
        myBook2.setAuthor(author);
        bookRepository.add(myBook2);

        //create author with book
        myBook1.setAuthor(author);
        author.addBook(myBook1);
        authorRepository.add(author);
*/
    }
}
