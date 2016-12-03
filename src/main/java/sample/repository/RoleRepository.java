package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Role;

/**
 * Created by marek on 28.11.16.
 */
public interface RoleRepository extends CrudRepository<Role, Integer>{
}
