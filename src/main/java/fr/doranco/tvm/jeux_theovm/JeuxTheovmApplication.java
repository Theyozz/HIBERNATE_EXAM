package fr.doranco.tvm.jeux_theovm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JeuxTheovmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeuxTheovmApplication.class, args);
	}
	
	@Bean
	// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
		return args -> {

			String[] noms = applicationContext.getBeanDefinitionNames();

			for (String nom : noms) {
				System.out.println(nom + " : " + applicationContext.getBean(nom).getClass().getSimpleName());
			}
		};
	}

}
