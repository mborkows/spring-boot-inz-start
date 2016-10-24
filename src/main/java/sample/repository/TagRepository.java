package sample.repository;


import org.springframework.data.repository.CrudRepository;
import sample.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
}
