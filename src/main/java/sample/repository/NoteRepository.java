package sample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Note;


public interface NoteRepository extends CrudRepository<Note, Long> {

	List<Note> findAll();

}
