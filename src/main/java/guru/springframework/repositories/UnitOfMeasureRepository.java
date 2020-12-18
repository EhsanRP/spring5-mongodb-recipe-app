package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;


public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Flux<UnitOfMeasure> findByDescription(String description);
}
