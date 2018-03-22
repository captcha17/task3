package com.epam.task3;

import com.epam.task3.domain.Agent;
import com.epam.task3.domain.AgentRepository;
import com.epam.task3.domain.Estate;
import com.epam.task3.domain.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class Task3Application {

    @Autowired
    private EstateRepository estateRepository;

    @Autowired
    private AgentRepository agentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            Random random = new Random();
            List<Agent> agentIds = createAgents();
            estateRepository.save(new Estate("Niamiga", 2, 3, new BigInteger("100000"),
                    agentIds.get(random.nextInt(agentIds.size()))));

            estateRepository.save(new Estate("Niamiga", 3, 4, new BigInteger("120000"),
                    agentIds.get(random.nextInt(agentIds.size()))));

            estateRepository.save(new Estate("Lenina", 1, 5, new BigInteger("110000"),
                    agentIds.get(random.nextInt(agentIds.size()))));

            estateRepository.save(new Estate("Lenina", 1, 6, new BigInteger("80000"),
                    agentIds.get(random.nextInt(agentIds.size()))));

            estateRepository.save(new Estate("Gaya", 3, 3, new BigInteger("40000"),
                    agentIds.get(random.nextInt(agentIds.size()))));
        };
    }

    private List<Agent> createAgents() {
        List<Agent> list = new ArrayList<>(3);
        list.add(new Agent("Vasia"));
        list.add(new Agent("Gena"));
        list.add(new Agent("Kolia"));

        Iterable<Agent> agents = agentRepository.saveAll(list);
        return (List)agents;
    }
}
