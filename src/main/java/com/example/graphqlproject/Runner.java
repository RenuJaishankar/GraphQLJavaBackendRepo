package com.example.graphqlproject;


import com.example.graphqlproject.GraphQL.GraphQLDataFetchers;
import com.example.graphqlproject.Model.Animal;
import com.example.graphqlproject.Model.ArcadeGame;
import com.example.graphqlproject.Model.Fruit;
import com.example.graphqlproject.Repository.AnimalRepository;
import com.example.graphqlproject.Repository.ArcadeGameRepository;
import com.example.graphqlproject.Repository.FruitRepository;
import com.example.graphqlproject.Repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


//CommandLineRunner lets you write instructions for the program at the start of runtime
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ArcadeGameRepository arcadeGameRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    FruitRepository fruitRepository;
    @Autowired
    MajorRepository majorRepository;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    // this run method will resolve at the start of your programs runtime
    @Override
    public void run(String... args) throws Exception {
        // this code will always run and thus constantly update our lists
        // our lists are crucial for our GraphQL apis
        //While true is for the list to continuously update
        while(true) {
//        arcadeGameRepository.save(new ArcadeGame( "Pac-Man", 1));
//        arcadeGameRepository.save(new ArcadeGame("Ms. Pac-Man", 1));
//        arcadeGameRepository.save(new ArcadeGame("Pong", 2));
            // this code block turns our repository into a workable list
            GraphQLDataFetchers.arcadeGameList = StreamSupport
                    .stream(arcadeGameRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());

            Animal testAnimal = new Animal(4, "Wolf");

//        animalRepository.save(new Animal( 0, "Snake"));
//        animalRepository.save(new Animal( 4, "Cat"));
//        animalRepository.save(testAnimal);
            GraphQLDataFetchers.animalList = StreamSupport
                    .stream(animalRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            //this equates animal list to stream.find all animals in repositrory and convert into string
//        fruitRepository.save(new Fruit("Black Berries","ALABAMA","Black"));
//        fruitRepository.save(new Fruit("Water Melon","Arkansas","Green"));
//        fruitRepository.save(new Fruit("Asian Pears","Connecticut","Red"));
            GraphQLDataFetchers.fruiTList = StreamSupport
                    .stream(fruitRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            GraphQLDataFetchers.majoRList = StreamSupport
                    .stream(majorRepository.findAll().spliterator(), false)
                    .collect(Collectors.toList());
        }

//        System.out.println("Data Saved!");
//        System.out.println(testAnimal.getId());
//        System.out.println(GraphQLDataFetchers.arcadeGameList);
//        System.out.println(GraphQLDataFetchers.animalList);
//        System.out.println(GraphQLDataFetchers.fruiTList);
//        System.out.println(GraphQLDataFetchers.majoRList);
    }
}