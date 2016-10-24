package sample.repository;


import org.springframework.data.repository.CrudRepository;
import sample.domain.Note;


public interface NoteRepository extends CrudRepository<Note, Long> {
}
