package od.city.claims.dao;


import od.city.claims.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {
}
