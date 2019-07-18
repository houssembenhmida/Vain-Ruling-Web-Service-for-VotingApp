/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.model;

/**
 *
 * @author Houssem
 */
public class TeamOrder {

    private int id;
    private Team team;
    private int order;
    private double finalScore;
    private double finalJuryAppriciation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public double getFinalJuryAppriciation() {
        return finalJuryAppriciation;
    }

    public void setFinalJuryAppriciation(double finalJuryAppriciation) {
        this.finalJuryAppriciation = finalJuryAppriciation;
    }
    

}
