import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UnitTest {
	private static ClassPathXmlApplicationContext context;

	@BeforeAll
	static void init() {
		context = new ClassPathXmlApplicationContext("my-config.xml");
	}

	@AfterAll
	static void closeContext() {
		context.close();
	}

	@Test
	void testA_type_notNull() {
		// act
		final A a = context.getBean(A.class);

		// assert
		Assertions.assertNotNull(a);
		System.out.println("a:" + a);
	}

	@Test
	void testA_id_notNull() {
		// act
		final A a = (A) context.getBean("a");

		// assert
		Assertions.assertNotNull(a);
		System.out.println("a:" + a);
	}

	@Test
	void testBPojo_type_notNull() {
		// act
		final BPojo bPojo = context.getBean(BPojo.class);

		// assert
		Assertions.assertNotNull(bPojo);
		Assertions.assertNotNull(bPojo.a);

		System.out.println(bPojo);
		System.out.println(bPojo.a);
	}

	@Test
	void testBWithConstructor_type_notNull() {
		// act
		final BWithConstructor bWithConstructor = context.getBean(BWithConstructor.class);

		// assert
		Assertions.assertNotNull(bWithConstructor);
		Assertions.assertNotNull(bWithConstructor.a);

		System.out.println(bWithConstructor);
		System.out.println(bWithConstructor.a);
	}
}
