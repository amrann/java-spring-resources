package com.learn;

import com.learn.configuration.DependencyInjectionConfig;
import com.learn.data.Bar;
import com.learn.data.Foo;
import com.learn.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

  private ApplicationContext applicationContext;

  @BeforeEach
  void setup() {
    applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfig.class);
  }

  // menggunakan dependency injection
  @Test
  void testDI() {

    Foo foo = applicationContext.getBean(Foo.class);
    Bar bar = applicationContext.getBean(Bar.class);

    FooBar fooBar = applicationContext.getBean(FooBar.class);

    Assertions.assertSame(foo, fooBar.getFoo());
    Assertions.assertSame(bar, fooBar.getBar());
  }


  // sebelum menggunakan dependency injection
  @Test
  void testNoDI() {

    Foo foo = new Foo();
    Bar bar = new Bar();

    FooBar fooBar = new FooBar(foo, bar);

    Assertions.assertSame(foo, fooBar.getFoo());
    Assertions.assertSame(bar, fooBar.getBar());
  }
}
