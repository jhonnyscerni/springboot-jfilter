package br.com.siberius.jfilter;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.siberius.jfilter")
@AutoConfigurationPackage
public class JFilterModuleConfiguration {

}
