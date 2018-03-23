package com.epam.task3.domain;

import com.epam.task3.dto.AgentDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgentRepository extends CrudRepository<Agent, Long> {
    Agent findByName(String name);

    @Query("select new com.epam.task3.dto.AgentDTO(a.name, SUM(es.price)) from Agent a left join Estate es on a.id=es.agent.id group by a.name")
    public List<AgentDTO> getAllAgentsWithTotalSum();
}
