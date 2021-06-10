package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@org.springframework.context.annotation.Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example.sprinddemoaop.dao")
public class Configuration {

}
