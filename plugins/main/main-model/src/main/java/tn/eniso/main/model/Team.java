/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.model;

import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.Main;
import net.vpc.upa.config.Path;
import net.vpc.upa.config.Sequence;
import net.vpc.upa.config.Summary;

/**
 *
 * @author fedi
 */
@Entity
@Path("/MyMenu")
public class Team {

    @Id
    @Sequence
    private int id;
    @Main
    private String teamName;
    @Summary
    private String teamProject;
    private double finalScore;
    private double finalJuryAppriciation;

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", teamName=" + teamName + ", teamProject=" + teamProject + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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

    public double getFinalJuryAppriciation() {
        return finalJuryAppriciation;
    }

    public void setFinalJuryAppriciation(double finalJuryAppriciation) {
        this.finalJuryAppriciation = finalJuryAppriciation;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamProject() {
        return teamProject;
    }

    public void setTeamProject(String teamProject) {
        this.teamProject = teamProject;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
