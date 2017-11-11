package ua.oleg.romanyuta.ui.controller;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.oleg.romanyuta.dao.AuthorRepository;
import ua.oleg.romanyuta.domain.Author;


import java.util.List;

@RestController
@RequestMapping("/authors")
public class RESTController {

    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Author>> listAllAuthors() {
        List<Author> authors = Lists.newArrayList(authorRepository.findOne(3l));

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> saveAuthor(@RequestBody Author author) {
        List<Author> authors = Lists.newArrayList(authorRepository.findOne(3l));

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
