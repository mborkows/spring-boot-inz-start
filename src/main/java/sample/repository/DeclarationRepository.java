package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Declaration;

/**
 * Created by marek on 22.11.16.
 */
public interface DeclarationRepository extends CrudRepository<Declaration, Integer>{
}
