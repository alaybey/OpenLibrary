package service;

import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl() {
        authorRepository = new AuthorRepositoryImpl();
    }

    @Override
    public void add(Author author) {
        authorRepository.add(author);
    }

    @Override
    public Author getAuthor(int id) {
        return authorRepository.getAuthor(id);
    }

    @Override
    public List<Author> findAllAuthor() {
        return authorRepository.findAllAuthor();
    }

    public List<Author> findByAuthorName(String name) {
        return findAllAuthor().stream().filter(a -> a.getFullName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooks(int id) {
        return authorRepository.getAuthor(id).getBooks();
    }

    @Override
    public void update(int id) {
        authorRepository.update(getAuthor(id));
    }

    @Override
    public void remove(int id) {
        authorRepository.remove(id);
    }
}
