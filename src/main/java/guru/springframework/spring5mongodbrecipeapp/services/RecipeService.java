package guru.springframework.spring5mongodbrecipeapp.services;

import guru.springframework.spring5mongodbrecipeapp.commands.RecipeCommand;
import guru.springframework.spring5mongodbrecipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
