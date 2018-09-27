package com.mycompany.engine.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mycompany.engine1.common.Util;

@RunWith(JUnit4.class)
public class UtilTest {

	@Test
	public void testGetString() throws Exception {
		assertNotNull(Util.getString());
		String a = Util.getString();
		String b = Util.getString();
		assertEquals(a, b);
	}

}
