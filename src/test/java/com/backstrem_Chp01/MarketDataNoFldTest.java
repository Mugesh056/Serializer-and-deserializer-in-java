package com.backstrem_Chp01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketDataNoFldTest {


    private File serFile;

    @BeforeEach
    void setUp() throws IOException {
        final  var serPath = Path.of("src","test","resources","MarketDataNoFldTest.ser");
        serFile = serPath.toFile();

        if (!serFile.exists()){
            final var success= serFile.createNewFile();
            assertTrue(success);
        }

    }

    @Test
    @DisplayName("Test basic serialize for Java POJO")
    void testSerialize() throws IOException {
        final var marketData= new MarketDataNoFld();

        try ( final var oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(serFile)))) {
            System.out.println("Before Serialization");
            System.out.println(marketData);
            oos.writeObject(marketData);
        }

    }

    @Test
    @DisplayName("Test basic Deserialize for Java POJO")
    void testDeserilize() throws IOException, ClassNotFoundException {

           try (final var ooi= new ObjectInputStream(
                        new BufferedInputStream(
                            new FileInputStream(serFile)))){

               final var Fromserilize = (MarketDataNoFld) ooi.readObject();
               System.out.println("After Serialization");
               System.out.println(Fromserilize);
               assertNotNull(Fromserilize);
           }

    }

}
