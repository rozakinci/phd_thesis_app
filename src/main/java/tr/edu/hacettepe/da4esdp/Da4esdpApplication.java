package tr.edu.hacettepe.da4esdp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tr.edu.hacettepe.da4esdp.entity.Alternative;
import tr.edu.hacettepe.da4esdp.repository.AlternativeRepository;
import tr.edu.hacettepe.da4esdp.service.Config;

import java.util.Arrays;

@SpringBootApplication
public class Da4esdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Da4esdpApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AlternativeRepository alternativeRepository) {
        return args -> {

            Arrays.stream(Config.alternatives).forEach(strAlt -> {
                Alternative alternative = new Alternative(strAlt);
                alternativeRepository.save(alternative);
            });
            alternativeRepository.findAll().forEach(System.out::println);
        };

    }
}
