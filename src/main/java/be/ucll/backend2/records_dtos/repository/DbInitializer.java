package be.ucll.backend2.records_dtos.repository;

import be.ucll.backend2.records_dtos.model.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
    private final PostRepository postRepository;

    public DbInitializer(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void initialize() {
        final var post1 = new Post("Welcome to my blog!", "I hope you enjoy it!");
        final var post2 = new Post("What makes cats such great pets?",
                """
                 Cats make wonderful pets for a variety of reasons. They are independent yet affectionate, often forming strong bonds with their owners.
                 Their playful nature and curious personalities provide endless entertainment. Cats are also relatively low-maintenance, requiring less attention than some other pets,
                 which makes them ideal for busy individuals. Overall, cats bring joy, companionship, and a sense of tranquility to any home.
                 """);

        postRepository.save(post1);
        postRepository.save(post2);
    }
}
