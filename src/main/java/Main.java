import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String... args) {

        try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("my-config.xml")) {

            final BeanFactory beanFactory = context;

            final A a = beanFactory.getBean(A.class);
            System.out.println(a);

            final A a2 = (A) beanFactory.getBean("a");
            System.out.println(a2);

            final B b = beanFactory.getBean(B.class);
            System.out.println(b);
            System.out.println(b.a);

            final B2 b2 = beanFactory.getBean(B2.class);
            System.out.println(b2);
            System.out.println(b2.a);
        }

    }
}
