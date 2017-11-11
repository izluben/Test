package od.city.claims.dao;

import od.city.claims.domain.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access object for CRUD operations with {@link Claim}
 *

 */
@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {

}
