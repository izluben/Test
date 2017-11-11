package od.city.claims.dao;


import od.city.claims.domain.Reward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends CrudRepository<Reward, Long> {
}
