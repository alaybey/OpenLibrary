package repository;

import model.Author;
import java.util.List;

public interface AuthorRepository extends GenericRepository{

    void add(Author author);
    Author getAuthor(int id);
    List<Author> findAllAuthor();
    Author update(Author author);
    void remove(int id);
}
