package sample.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import sample.domain.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaNoteRepositoryIntegrationTests {

	@Autowired
	NoteRepository noteRepo;

	@Test
	public void findsAllNotes() {
		List<Note> notes = this.noteRepo.findAll();
		assertThat(notes).hasSize(4);
		for (Note note : notes) {
			assertThat(note.getTags().size()).isGreaterThan(0);
		}
	}

}
