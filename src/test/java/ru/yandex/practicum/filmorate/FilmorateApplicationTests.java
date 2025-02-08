package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringReader;
import java.util.Arrays;

@SpringBootTest
class FilmorateApplicationTests {

	@BeforeAll
	public void contextLoads() {
	}

	@Test
	public void test() {
		Assertions.assertTrue(true);
	}

}
