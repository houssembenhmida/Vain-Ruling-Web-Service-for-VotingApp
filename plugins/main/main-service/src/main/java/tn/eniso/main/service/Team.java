/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.service;

import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.Sequence;

/**
 *
 * @author fedi
 */
@Entity
public class Team {
    @Id @Sequence
    private int id;
    private String teamName;
    private String criteriaA;
    private String criteriaB;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTeamName(String name){
        this.teamName=name;
    }
    public String getTeamName(){
        return this.teamName;
    }
    
    public void setCiteriaA(String valueA){
        this.criteriaA=valueA;
    }
    public String getCriteriaA(){
        return this.criteriaA;
    }
    
    public void setCriteriaB(String valueB){
        this.criteriaB=valueB;
    }
    public String getCriteriaB(){
        return this.criteriaB;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + this.getId() + ", teamName=" + this.getTeamName() + ", criteriaA=" + this.getCriteriaA() + ", criteriaB=" + this.getCriteriaB() + '}';
    }
    
}
