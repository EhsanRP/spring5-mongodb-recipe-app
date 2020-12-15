package guru.springframework.spring5mongodbrecipeapp.repositories;

import guru.springframework.spring5mongodbrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
