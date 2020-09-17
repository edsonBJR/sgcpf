package com.sgcpf.domain;

import java.util.ArrayList;
import java.util.List;

public class Cpfs { 
	
    private List<Cpf> cpfList;
    
    public List<Cpf> getCpfList() {
        if(cpfList == null) {
            cpfList = new ArrayList<>();
        }
        return cpfList;
    }
 
    public void setCpfList(List<Cpf> cpfList) {
        this.cpfList = cpfList;
    }
}