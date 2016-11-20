package sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.domain.ReportedTerm;
import sample.domain.ReportedTermPK;

/**
 * Created by marek on 10.11.16.
 */
@Repository
public interface ReportedTermRepository extends CrudRepository <ReportedTerm, ReportedTermPK>{


}
