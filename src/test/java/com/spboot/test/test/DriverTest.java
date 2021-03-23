package com.spboot.test.test;

import org.junit.jupiter.api.Test;

public class DriverTest {

	@Test
	public void test() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
