/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.model;

import net.vpc.app.vainruling.core.service.model.AppUser;
import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Id;
import net.vpc.upa.config.Main;
import net.vpc.upa.config.Path;
import net.vpc.upa.config.Sequence;
import net.vpc.upa.config.Summary;

/**
 *
 * @author Houssem
 */
@Entity
@Path("/MyMenu")
public class Evaluation {

    @Id
    @Sequence
    private int id;
    @Main
    private Team team;
    @Summary
    private AppUser juryMember;

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

    public AppUser getJuryMember() {
        return juryMember;
    }

    public void setJuryMember(AppUser juryMember) {
        this.juryMember = juryMember;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
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
        final Evaluation other = (Evaluation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id=" + id + ", team=" + team + ", juryMember=" + juryMember + '}';
    }


}
