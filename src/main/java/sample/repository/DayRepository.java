package sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.domain.Day;

/**
 * Created by marek on 10.11.16.
 */
@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {
}
