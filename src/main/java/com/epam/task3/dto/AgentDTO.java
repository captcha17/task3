package com.epam.task3.dto;

import java.math.BigInteger;

public class AgentDTO {
    private String agentName;
    private BigInteger totalSum;

    public AgentDTO(String agentName, BigInteger totalSum) {
        this.agentName = agentName;
        this.totalSum = totalSum;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public BigInteger getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigInteger totalSum) {
        this.totalSum = totalSum;
    }
}
