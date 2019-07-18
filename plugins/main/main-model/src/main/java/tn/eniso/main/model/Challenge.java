/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.eniso.main.model;

import java.util.Date;
import net.vpc.upa.config.Entity;
import net.vpc.upa.config.Formula;
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
public class Challenge {
    @Id@Sequence
    private int id;
    @Main
    @Formula(value = "concat(Coalesce(this.name,' v'),' ',Coalesce(this.version,'1'))", formulaOrder = 1)
    private String fullName;
    @Summary
    private String name;
    @Summary
    private int version;
    @Summary
    private Date startDate;
    @Summary
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
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
        final Challenge other = (Challenge) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Challenge{" + "id=" + id + ", fullName=" + fullName + ", name=" + name + ", version=" + version + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
}
