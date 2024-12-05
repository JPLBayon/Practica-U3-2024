package fp.dam.java.unidad3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestPractica {

	static String s = "012333#2##abcccccdef@g@@@79";
	static List<String> l = List.of("333", "##", "ccccc", "@@@");
	
	@Test
	@DisplayName("Método 1")
	void test01() {
		assertTrue(l.equals(Main.m1(s)));
		assertEquals(0, Main.m1("").size());
		assertEquals(0, Main.m1("abcdef").size());
	}
	
	@Test
	@DisplayName("Método 2")
	void test02() {
		assertTrue(l.equals(Main.m2(s)));
		assertEquals(0, Main.m2("").size());
		assertEquals(0, Main.m2("abcdef").size());
	}
	
	@Test
	@DisplayName("Método 3a")
	void test03a() {
		assertEquals(75, Main.m3a(new int[][]{
			{1, 5, 5, 2, 4},
			{2, 1, 4, 14, 3},
			{3, 7, 11, 2, 8},
			{4, 8, 12, 16, 4}
		}));
		assertNull(Main.m3a(new int[][]{
			{1, 5},
			{2, 1},
			{3, 7},
			{4, 8}
		}));
		assertNull(Main.m3a(new int[][]{
			{1, 5, 5, 2, 4},
			{2, 1, 4, 14, 3}
		}));
		assertNull(Main.m3a(new int[][] {}));
	}
	
	@Test
	@DisplayName("Método 3b")
	void test03b() {
		assertTrue(Buscaminas.testTablero(Main.m3b(1), 1));
		assertTrue(Buscaminas.testTablero(Main.m3b(2), 2));
		assertTrue(Buscaminas.testTablero(Main.m3b(3), 3));
		assertNull(Main.m3b(-10));
		assertNull(Main.m3b(0));
		assertNull(Main.m3b(4));
		assertNull(Main.m3b(10));
	}
	
}
