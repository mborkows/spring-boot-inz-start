package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Day;

import java.sql.Date;

/**
 * Created by marek on 10.11.16.
 */
public interface DayRepository extends CrudRepository<Day, Date> {
}
