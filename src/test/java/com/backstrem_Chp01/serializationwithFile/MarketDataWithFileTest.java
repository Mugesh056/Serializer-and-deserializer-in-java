package com.backstrem_Chp01.serializationwithFile;

import SerializationWithFile.MarketDataWithFile;
import com.backstrem_Chp01.MarketDataNoFld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketDataWithFileTest {

     private File serFile;

    @BeforeEach
    void setUp() throws IOException {
        final  var serPath = Path.of("src","test","resources","MarketDataWithFileTest.ser");
        serFile = serPath.toFile();

        if (!serFile.exists()){
            final var success= serFile.createNewFile();
            assertTrue(success);
        }

    }

    @Test
    @DisplayName("Test basic serialize for Java POJO with File..")
    void testSerialize() throws IOException {
            
        final var marketData= new MarketDataWithFile();

        marketData.setSecurityId("AAPL");
        marketData.setTime(10000L);
        marketData.setLow(160.3D);
        marketData.setOpen(130.1D);
        marketData.setHigh(135.2D);
        marketData.setClose(120.3D);
        marketData.setLast(125.1D);
        marketData.setIsLevelOne(true);

        try ( final var oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(serFile)))) {
            System.out.println("Before Serialization..");
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

            final var Fromserilize = (MarketDataWithFile) ooi.readObject();
            System.out.println("After Serialization");
            System.out.println(Fromserilize);
            assertNotNull(Fromserilize);

            assertNotNull(Fromserilize);
            assertEquals("AAPL",Fromserilize.getSecurityId());
            assertEquals( 10000L,Fromserilize.getTime());
            assertEquals(160.3D,Fromserilize.getLow());
            assertEquals(130.1D,Fromserilize.getOpen());
            assertEquals(135.2D,Fromserilize.getHigh());
            assertEquals(120.3D,Fromserilize.getClose());
            assertEquals(125.1D,Fromserilize.getLast());
            assertTrue(Fromserilize.getIsLevelOne());
        }

    }
}




