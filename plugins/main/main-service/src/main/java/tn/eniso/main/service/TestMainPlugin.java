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
import tn.eniso.main.model.Team;

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

    public int getParticipantNumber() {int id=0;
        List<String> l=UPA.getPersistenceUnit().createQuery("select i.teamName from Team i ").getResultList();
        return l.size();
    }
    
    
    public void addParticipant(String teamname) {
        Team team = new Team();
        team.setTeamName(teamname);
        team.setInnovativeIdea(0);
        team.setPeaching_And_Communication(0);
        team.setThemeAdequate(0);
        team.setMaterialUsed(0);
        team.setSmart_Concept(0);
        team.setAcessibility(0);
        team.setLocal_Influance(0);
        team.setInternational_Exportability(0);
        team.setTeam_Chemistry(0);
        team.setJury_Appriciation(0);
        
    
        UPA.getPersistenceUnit().persist(team);
    }
    
    public void updateParticipant(int id,String name,int innovation,int peaching, int theme,int material
    ,int smart,int acces,int local,int international,int chemistry,int jury){
        
        Team t=UPA.getPersistenceUnit().createQuery("select i from Team i where i.id = :p").setParameter("p", id).getFirstResultOrNull();
     
        t.setTeamName(name);
        t.setInnovativeIdea((innovation+t.getInnovativeIdea()*t.getVotes())/(t.getVotes()+1));
        t.setPeaching_And_Communication((peaching+t.getPeaching_And_Communication()*t.getVotes())/(t.getVotes()+1));
        t.setThemeAdequate((theme+t.getThemeAdequate()*t.getVotes())/(t.getVotes()+1));
        t.setMaterialUsed((material+t.getMaterialUsed()*t.getVotes())/(t.getVotes()+1));
        t.setSmart_Concept((smart+t.getSmart_Concept()*t.getVotes())/(t.getVotes()+1));
        t.setAcessibility((acces+t.getAcessibility()*t.getVotes())/(t.getVotes()+1));
        t.setLocal_Influance((local+t.getLocal_Influance()*t.getVotes())/(t.getVotes()+1));
        t.setInternational_Exportability((international+t.getInternational_Exportability()*t.getVotes())/(t.getVotes()+1));
        t.setTeam_Chemistry((chemistry+t.getTeam_Chemistry()*t.getVotes())/(t.getVotes()+1));
        t.setJury_Appriciation((jury+t.getJury_Appriciation()*t.getVotes())/(t.getVotes()+1));
        
        t.setOverallScore((t.getInnovativeIdea()+t.getPeaching_And_Communication()+t.getThemeAdequate()
        +t.getMaterialUsed()+t.getSmart_Concept()+t.getAcessibility()+t.getLocal_Influance()
        +t.getInternational_Exportability()+t.getTeam_Chemistry()+t.getJury_Appriciation())/10);
        
        t.setVotes(t.getVotes()+1);
        
        UPA.getPersistenceUnit().merge(t);
    }
    public List<String> getAllParticipantNames() {
        return UPA.getPersistenceUnit().createQuery("select i.teamName from Team i")
                .getResultList();

    }
    public List<String> getAllParticipantsData() {
        return UPA.getPersistenceUnit().createQuery("select i  from Team i")
                .getResultList();

    }
    public Team getWinner(){
        List<Team> teams= UPA.getPersistenceUnit().createQuery("Select i from team i").getResultList();
        Team winner=teams.get(0);
        double max_overall=winner.getOverallScore();
        for(int i=0;i<teams.size();i++){
            if(teams.get(i).getOverallScore()>max_overall){
                max_overall=teams.get(i).getOverallScore();
                winner=teams.get(i);
            }
        }
        return winner;
    }
    
}
