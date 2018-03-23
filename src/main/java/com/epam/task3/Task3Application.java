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
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("Niamiga", 3, 4, new BigInteger("120000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("Lenina", 1, 5, new BigInteger("110000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("Lenina", 2, 6, new BigInteger("80000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("Gaya", 3, 2, new BigInteger("89000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("Gaya", 1, 5, new BigInteger("60000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("MainStreet", 2, 5, new BigInteger("160000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));

            estateRepository.save(new Estate("MainStreet", 2, 6, new BigInteger("150000"),
                    agentIds.get(random.nextInt(agentIds.size())), Estate.Status.SALE));
        };
    }

    private List<Agent> createAgents() {
        List<Agent> list = new ArrayList<>(7);
        list.add(new Agent("Vasia"));
        list.add(new Agent("Gena"));
        list.add(new Agent("Kolia"));
        list.add(new Agent("Brad"));
        list.add(new Agent("Mike"));
        list.add(new Agent("Walter"));
        list.add(new Agent("Giggs"));

        Iterable<Agent> agents = agentRepository.saveAll(list);
        return (List)agents;
    }
}
