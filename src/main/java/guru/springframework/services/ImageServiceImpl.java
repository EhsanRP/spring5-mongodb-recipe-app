package guru.springframework.services;

import guru.springframework.repositories.reactive.RecipeReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeReactiveRepository recipeReactiveRepository;

    public ImageServiceImpl(RecipeReactiveRepository recipeReactiveRepository) {

        this.recipeReactiveRepository = recipeReactiveRepository;
    }

    @Override
    @Transactional
    public Mono<Void> saveImageFile(String recipeId, MultipartFile file) {
        recipeReactiveRepository.findById(recipeId)
                .map(recipe -> {
                    try {
                        Byte[] bytes = new Byte[file.getBytes().length];

                        var i = 0;
                        for (byte b : file.getBytes())
                            bytes[i++] = b;

                        recipe.setImage(bytes);
                        return recipe;

                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }).publish(recipeMono -> recipeReactiveRepository.save(recipeMono.block()));

        return Mono.empty();
    }
}
