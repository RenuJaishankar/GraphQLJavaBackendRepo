package com.example.graphqlproject.GraphQL;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcher <T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
