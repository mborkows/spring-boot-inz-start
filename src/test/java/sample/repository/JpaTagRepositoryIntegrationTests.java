package sample.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import sample.domain.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaTagRepositoryIntegrationTests {

	@Autowired
	TagRepository tagRepo;

	@Test
	public void findsAllTags() {
		List<Tag> tags = this.tagRepo.findAll();
		assertThat(tags).hasSize(3);
		for (Tag tag : tags) {
			assertThat(tag.getNotes().size()).isGreaterThan(0);
		}
	}

}
