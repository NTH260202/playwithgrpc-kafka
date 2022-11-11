package com.example.playwithgrpc.service;

import gov.nist.csd.pm.pap.PAP;
import gov.nist.csd.pm.pap.memory.MemoryPAP;
import gov.nist.csd.pm.pap.memory.MemoryPolicyStore;
import gov.nist.csd.pm.pdp.PDP;
import gov.nist.csd.pm.pdp.adjudicator.Prohibitions;
import gov.nist.csd.pm.pdp.memory.MemoryPDP;
import gov.nist.csd.pm.policy.exceptions.PMException;
import gov.nist.csd.pm.policy.model.graph.Graph;
import gov.nist.csd.pm.policy.model.prohibition.Prohibition;

public class ACServiceImpl {
    public void createGraph() throws PMException {
        Graph graph = new Graph();
        PAP pap = null;
        try {
            pap = new MemoryPAP();
        } catch (PMException e) {
            throw new RuntimeException(e);
        }
        PDP pdp = new MemoryPDP(pap);
        MemoryPolicyStore memoryPolicyStore = new MemoryPolicyStore();
//        memoryPolicyStore.graph().createPolicyClass()
    }
}
