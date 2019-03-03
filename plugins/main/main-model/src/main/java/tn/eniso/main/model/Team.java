/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.model;

import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.Main;
import net.vpc.upa.config.Sequence;

/**
 *
 * @author fedi
 */
@Entity
public class Team {
    @Id @Sequence
    private int id;
    private int votes ;
    @Main
    private String teamName;
    private double InnovativeIdea;
    private double Peaching_And_Communication;
    private double ThemeAdequate;
    private double MaterialUsed;
    private double Smart_Concept;
    private double Acessibility;
    private double Local_Influance;
    private double International_Exportability;
    private double Team_Chemistry;
    private double Jury_Appriciation;
    private double overallScore;

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", votes=" + votes + ", teamName=" + teamName + ", InnovativeIdea=" + InnovativeIdea + ", Peaching_And_Communication=" + Peaching_And_Communication + ", ThemeAdequate=" + ThemeAdequate + ", MaterialUsed=" + MaterialUsed + ", Smart_Concept=" + Smart_Concept + ", Acessibility=" + Acessibility + ", Local_Influance=" + Local_Influance + ", International_Exportability=" + International_Exportability + ", Team_Chemistry=" + Team_Chemistry + ", Jury_Appriciation=" + Jury_Appriciation + ", overallScore=" + overallScore + '}';
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

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getInnovativeIdea() {
        return InnovativeIdea;
    }

    public void setInnovativeIdea(double InnovativeIdea) {
        this.InnovativeIdea = InnovativeIdea;
    }

    public double getPeaching_And_Communication() {
        return Peaching_And_Communication;
    }

    public void setPeaching_And_Communication(double Peaching_And_Communication) {
        this.Peaching_And_Communication = Peaching_And_Communication;
    }

    public double getThemeAdequate() {
        return ThemeAdequate;
    }

    public void setThemeAdequate(double ThemeAdequate) {
        this.ThemeAdequate = ThemeAdequate;
    }

    public double getMaterialUsed() {
        return MaterialUsed;
    }

    public void setMaterialUsed(double MaterialUsed) {
        this.MaterialUsed = MaterialUsed;
    }

    public double getSmart_Concept() {
        return Smart_Concept;
    }

    public void setSmart_Concept(double Smart_Concept) {
        this.Smart_Concept = Smart_Concept;
    }

    public double getAcessibility() {
        return Acessibility;
    }

    public void setAcessibility(double Acessibility) {
        this.Acessibility = Acessibility;
    }

    public double getLocal_Influance() {
        return Local_Influance;
    }

    public void setLocal_Influance(double Local_Influance) {
        this.Local_Influance = Local_Influance;
    }

    public double getInternational_Exportability() {
        return International_Exportability;
    }

    public void setInternational_Exportability(double International_Exportability) {
        this.International_Exportability = International_Exportability;
    }

    public double getTeam_Chemistry() {
        return Team_Chemistry;
    }

    public void setTeam_Chemistry(double Team_Chemistry) {
        this.Team_Chemistry = Team_Chemistry;
    }

    public double getJury_Appriciation() {
        return Jury_Appriciation;
    }

    public void setJury_Appriciation(double Jury_Appriciation) {
        this.Jury_Appriciation = Jury_Appriciation;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

  
    

}