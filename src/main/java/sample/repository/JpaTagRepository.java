//package sample.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//
//import org.springframework.stereotype.Repository;
//import sample.domain.Tag;
//
//@Repository
//class JpaTagRepository implements TagRepository {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public List<Tag> findAll() {
//		return this.entityManager.createQuery("SELECT t FROM Tag t", Tag.class)
//				.getResultList();
//	}
//
//}
