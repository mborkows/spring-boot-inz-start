package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Position;

/**
 * Created by marek on 22.11.16.
 */
public interface PositionRepository extends CrudRepository<Position, Integer> {
}
