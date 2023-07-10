package com.learn.configuration;

import com.learn.data.Bar;
import com.learn.data.Foo;
import com.learn.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {

  @Bean
  public Foo foo() {
    return new Foo();
  }

  @Bean
  public Bar bar() {
    return new Bar();
  }

  @Bean
  public FooBar fooBar(Foo foo, Bar bar) {
    return new FooBar(foo, bar);
  }

}
