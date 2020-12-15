package guru.springframework.spring5mongodbrecipeapp.repositories;

import guru.springframework.spring5mongodbrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
