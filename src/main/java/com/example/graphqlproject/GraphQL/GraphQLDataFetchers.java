package com.example.graphqlproject.GraphQL;

import com.example.graphqlproject.Model.Animal;
import com.example.graphqlproject.Model.ArcadeGame;
import com.example.graphqlproject.Model.Fruit;
import com.example.graphqlproject.Model.Major;
import com.example.graphqlproject.Repository.AnimalRepository;
import com.example.graphqlproject.Repository.ArcadeGameRepository;
import com.example.graphqlproject.Repository.MajorRepository;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// This component acts as a way to fetch and access our data
// You can call this component your service
// its taking care of all of your business logic
@Component
public class GraphQLDataFetchers {
    @Autowired
    MajorRepository majorRepository;
    @Autowired
    ArcadeGameRepository arcadeGameRepository;

    @Autowired
    AnimalRepository animalRepository;


    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );


    public static List<ArcadeGame> arcadeGameList;
    public static List<Animal> animalList;
    public static List<Fruit> fruiTList;
    public static List<Major> majoRList;



    public DataFetcher getBookByIdDataFetcher() {
        // DataFetchingEnvironment is like an anonymous inner class
        // it's technically a functional interface: this is more succint...
        // ...specifically calls the get method inside of the interface
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }


    public DataFetcher getArcadeGameByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String arcadeGameId = dataFetchingEnvironment.getArgument("id");
            return arcadeGameList
                    .stream()
                    .filter(game -> game.getId().toString().equals(arcadeGameId))
                    .findFirst()
                    .orElse(null);

        };
    }


    public DataFetcher getArcadeGamesFetcher(){
        return dataFetchingEnvironment -> {
            // TODO: get a working match for this query
           //  String match = dataFetchingEnvironment.getArgument("match");
            return arcadeGameList;
        };
    }

    public DataFetcher<List<Animal>> getAnimalsFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            return animalList;
        };
    }

    public DataFetcher<Animal> getAnimalByIdFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            String animalId = dataFetchingEnvironment.getArgument("id");
            return animalList
                    .stream()
                    .filter(animal -> animal.getId().toString().equals(animalId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<Fruit> getFruitByIdFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            String fruitId = dataFetchingEnvironment.getArgument("id");
            return fruiTList
                    .stream()
                    .filter(fruit -> fruit.getId().toString().equals(fruitId))
                    .findFirst()
                    .orElse(null);
        };
    }
    public DataFetcher<List<Fruit>> getFruitsFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            return fruiTList;
        };
    }
    public DataFetcher<Major> getMajorByIdFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            String majorId = dataFetchingEnvironment.getArgument("id");
            //THis id refers refers to id in Query
            return majoRList
                    .stream()
                    .filter(major -> major.getId().toString().equals(majorId))
                    .findFirst()
                    .orElse(null);
        };
    }
    public DataFetcher<List<Major>> getMajorsFetcher(){
        // TODO: get a working match for this query
        return dataFetchingEnvironment -> {
            return majoRList;
        };
    }
    // TODO: Add mutation method for my entities

    // method that creates a new arcade game entry
    // this code directly calls the associated repository instead of the list
    // since our runner has a while loop, our associated list will auto-update


    public DataFetcher createArcadeGame(){
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            int amountOfPlayers = dataFetchingEnvironment.getArgument("amountOfPlayers");
            ArcadeGame newArcadeGame = new ArcadeGame(name, amountOfPlayers);
            arcadeGameRepository.save(newArcadeGame);
            return newArcadeGame;
        };
    }

}


