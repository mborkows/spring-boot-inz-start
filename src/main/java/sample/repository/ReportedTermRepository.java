package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.ReportedTerm;
import sample.domain.ReportedTermPK;

/**
 * Created by marek on 10.11.16.
 */
public interface ReportedTermRepository extends CrudRepository <ReportedTerm, ReportedTermPK>{
}
