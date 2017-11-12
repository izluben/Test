package ua.oleg.romanyuta.dao;


import ua.oleg.romanyuta.domain.Reward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends CrudRepository<Reward, Long> {
}
