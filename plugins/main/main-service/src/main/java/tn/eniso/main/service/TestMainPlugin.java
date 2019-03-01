package tn.eniso.main.service;

import java.util.ArrayList;
import java.util.List;
import net.vpc.app.vainruling.core.service.CorePlugin;
import net.vpc.app.vainruling.core.service.plugins.VrPlugin;
import net.vpc.app.vainruling.core.service.plugins.Install;
import net.vpc.app.vainruling.core.service.plugins.Start;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import net.vpc.upa.UPA;

/**
 * Plugin (Module) Main for application
 *
 * @author Houssem
 */
@VrPlugin
public class TestMainPlugin {

    private static final Logger log = Logger.getLogger(TestMainPlugin.class.getName());
    private static String text = "default";
    private static List<Team> participants = new ArrayList<>();
    @Autowired
    private CorePlugin core;

    /**
     * module installation process. Called on application startup when the
     * plugin is first bundled (as dependency) or when a new version is bundled
     */
    @Install
    private void onInstall() {
        //configure CMS properties
        core.setAppProperty("System.App.Description", null, "test");
        core.setAppProperty("System.App.Keywords", null, "test");
        core.setAppProperty("System.App.Title.Major.Main", null, "test");
        core.setAppProperty("System.App.Title.Major.Secondary", null, "app");
        core.setAppProperty("System.App.Title.Minor.Main", null, "test");
        core.setAppProperty("System.App.Title.Minor.Secondary", null, "app");
        core.findOrCreateAppDepartment("D", "D", "Department");
        core.findOrCreateArticleDisposition("Services", "Services", "Services");
    }

    /**
     * module initialization process. Called on each application startup (after
     *
     * @Install phase methods if any)
     */
    @Start
    private void onStart() {
    }

    public static List<Team> getTeams() {
        return TestMainPlugin.participants;
    }

    public int getParticipantNumber() {
        List<String> l=UPA.getPersistenceUnit().createQuery("select i.teamName from Team i").getResultList();
        return l.size();
    }

    public void addParticipant(String teamname) {
        Team team = new Team();
        team.setTeamName(teamname);
        team.setCiteriaA("");
        team.setCriteriaB("");
        
    
        UPA.getPersistenceUnit().persist(team);
    }
    
    public void updateParticipant(int id,String n,String a, String b){
        Team t=new Team();
        t.setId(id);
        t.setTeamName(n);
        t.setCiteriaA(a);
        t.setCriteriaB(b);
        UPA.getPersistenceUnit().merge(t);
    }
    public List<String> getAllParticipantNames() {
        return UPA.getPersistenceUnit().createQuery("select i.teamName from Team i")
                .getResultList();

    }
    public List<String> getAllParticipantsData() {
        return UPA.getPersistenceUnit().createQuery("select i.id, i.teamName,i.criteriaA,i.criteriaB from Team i")
                .getResultList();

    }
}
