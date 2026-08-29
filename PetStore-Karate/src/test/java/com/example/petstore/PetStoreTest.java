package com.example.petstore;

import com.intuit.karate.junit5.Karate;

class PetStoreTest {

    @Karate.Test
    Karate testPetStore() {
        return Karate.run("petstore").relativeTo(getClass());
    }
}