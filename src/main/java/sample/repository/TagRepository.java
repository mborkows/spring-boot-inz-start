package sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();

}
