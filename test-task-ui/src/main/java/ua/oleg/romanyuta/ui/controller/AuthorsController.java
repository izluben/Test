package ua.oleg.romanyuta.ui.controller;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.oleg.romanyuta.dao.AuthorRepository;
import ua.oleg.romanyuta.domain.Author;
import ua.oleg.romanyuta.domain.exception.BadRequestException;
import ua.oleg.romanyuta.domain.exception.NotFoundException;


import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Long id) {
        Author author = authorRepository.findOne(id);
        if (author == null) {
            throw new NotFoundException(String.format("Author with id %s does not exist", id));
        }

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = Lists.newArrayList(authorRepository.findAll());

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        authorRepository.save(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        if (author.getId() == null) {
            throw new BadRequestException("Unable to update, id must be provided");
        }
        authorRepository.save(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
