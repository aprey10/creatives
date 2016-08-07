package com.graywolf.creatives;

import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Order;

@SpringBootApplication
public class CreativesApplication implements CommandLineRunner{

	@Autowired
	private CreativesRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CreativesApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception{
		repository.deleteAll();
		repository.save(new Creatives("test", "test"));
		repository.save(new Creatives("test2", "test2"));

		for(Creatives creatives: repository.findAll()){
			System.out.println(creatives);
		}
	}


}
