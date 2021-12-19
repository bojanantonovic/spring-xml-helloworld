import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String... args) {
        try (final var context = new ClassPathXmlApplicationContext("my-config.xml")) {
            // fetch by type
            final A a = context.getBean(A.class);
            System.out.println(a);

            // fetch by id
            final A a2 = (A) context.getBean("a");
            System.out.println(a2);

            final BPojo bPojo = context.getBean(BPojo.class);
            System.out.println(bPojo);
            System.out.println(bPojo.a);

            final BWithConstructor bWithConstructor = context.getBean(BWithConstructor.class);
            System.out.println(bWithConstructor);
            System.out.println(bWithConstructor.a);
        }

    }
}
