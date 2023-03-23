package serializationWithMemoryBuffer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MarketDataWithMemoryBufferTest {
    @Test
    @DisplayName("Test basic Serialization and DeSerialization for Java POJO in Memory Buffer")
    void testSerializeAndDeserialize() throws IOException, ClassNotFoundException {
        final var marketData=new MarketDataWithMemoryBuffer();

        marketData.setSecurityId("AAPL");
        marketData.setTime(10000L);
        marketData.setLow(160.3D);
        marketData.setOpen(130.1D);
        marketData.setHigh(135.2D);
        marketData.setClose(120.3D);
        marketData.setLast(125.1D);
        marketData.setIsLevelOne(true);

        final var bout=new ByteArrayOutputStream();

        try (final var oos = new ObjectOutputStream(
                   new BufferedOutputStream(bout))) {

            System.out.println("Before Serialization..");
            System.out.println(marketData);
            oos.writeObject(marketData);
        }

        //Deserialization and read//

        try(var ois = new ObjectInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(bout.toByteArray())))) {

            final var fromSerialize = (MarketDataWithMemoryBuffer) ois.readObject();
            System.out.println("After serialization....");
            System.out.println(fromSerialize);




            //assertion
            assertNotNull(fromSerialize);
            assertEquals("AAPL",fromSerialize.getSecurityId());
            assertEquals( 10000L,fromSerialize.getTime());
            assertEquals(160.3D,fromSerialize.getLow());
            assertEquals(130.1D,fromSerialize.getOpen());
            assertEquals(135.2D,fromSerialize.getHigh());
            assertEquals(120.3D,fromSerialize.getClose());
            assertEquals(125.1D,fromSerialize.getLast());
            assertTrue(fromSerialize.getIsLevelOne());




        }


    }


}
