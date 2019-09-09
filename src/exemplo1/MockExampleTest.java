package exemplo1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.Test;



public class MockExampleTest {

	@Test
	public void testMockito() {
		
		MockExample demo = mock(MockExample.class);
		assertEquals(0, demo.getInt());
		assertEquals(0, demo.getInteger().intValue());
		assertEquals(0d, demo.getDouble(), 0d);
		assertFalse(demo.getBoolean());
		assertNull(demo.getObject());
		assertEquals(Collections.emptyList(), demo.getCollection());
		assertNull(demo.getArray());
		assertEquals(0L, demo.getStream().count());
		assertFalse(demo.getOptional().isPresent());
		
	}
	
	
}
