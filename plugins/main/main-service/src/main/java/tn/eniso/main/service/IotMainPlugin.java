package tn.eniso.main.service;


import java.util.ArrayList;
import java.util.List;
import net.vpc.app.vainruling.core.service.CorePlugin;
import net.vpc.app.vainruling.core.service.plugins.VrPlugin;
import net.vpc.app.vainruling.core.service.plugins.Install;
import net.vpc.app.vainruling.core.service.plugins.Start;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import net.vpc.app.vainruling.core.service.model.AppUser;
import net.vpc.upa.UPA;
import tn.eniso.main.model.Evaluation;
import tn.eniso.main.model.Team;
import tn.eniso.main.model.TeamOrder;

/**
 * Plugin (Module) Main for application
 *
 * @author Houssem
 */
@VrPlugin
public class IotMainPlugin {

    private static final Logger log = Logger.getLogger(IotMainPlugin.class.getName());
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
        core.setAppProperty("System.App.Description", null, "iot");
        core.setAppProperty("System.App.Keywords", null, "iot");
        core.setAppProperty("System.App.Title.Major.Main", null, "iot");
        core.setAppProperty("System.App.Title.Major.Secondary", null, "app");
        core.setAppProperty("System.App.Title.Minor.Main", null, "iot");
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
        return IotMainPlugin.participants;
    }

    public int getParticipantNumber() {int id=0;
        List<String> l=UPA.getPersistenceUnit().createQuery("select i.teamName from Team i ").getResultList();
        return l.size();
    }
    
    
    public void addParticipant(String teamname) {
        Team team = new Team();
        team.setTeamName(teamname);
        UPA.getPersistenceUnit().persist(team);
    }
    
    public Team getTeamById(int id){
        return UPA.getPersistenceUnit().findById(Team.class, id);
    }
    public AppUser getJuryById(int id){
        return UPA.getPersistenceUnit().findById(AppUser.class, id);
    }
    
//    public void updateParticipant(int id,String name,int innovation,int peaching, int theme,int material
//    ,int smart,int acces,int local,int international,int chemistry,int jury){
//        
//        Team t=UPA.getPersistenceUnit().createQuery("select i from Team i where i.id = :p").setParameter("p", id).getFirstResultOrNull();
//     
//        t.setTeamName(name);
//        t.setInnovativeIdea((innovation+t.getInnovativeIdea()*t.getVotes())/(t.getVotes()+1));
//        t.setPeaching_And_Communication((peaching+t.getPeaching_And_Communication()*t.getVotes())/(t.getVotes()+1));
//        t.setThemeAdequate((theme+t.getThemeAdequate()*t.getVotes())/(t.getVotes()+1));
//        t.setMaterialUsed((material+t.getMaterialUsed()*t.getVotes())/(t.getVotes()+1));
//        t.setSmart_Concept((smart+t.getSmart_Concept()*t.getVotes())/(t.getVotes()+1));
//        t.setAcessibility((acces+t.getAcessibility()*t.getVotes())/(t.getVotes()+1));
//        t.setLocal_Influance((local+t.getLocal_Influance()*t.getVotes())/(t.getVotes()+1));
//        t.setInternational_Exportability((international+t.getInternational_Exportability()*t.getVotes())/(t.getVotes()+1));
//        t.setTeam_Chemistry((chemistry+t.getTeam_Chemistry()*t.getVotes())/(t.getVotes()+1));
//        t.setJury_Appriciation((jury+t.getJury_Appriciation()*t.getVotes())/(t.getVotes()+1));
//        
//        t.setOverallScore((t.getInnovativeIdea()+t.getPeaching_And_Communication()+t.getThemeAdequate()
//        +t.getMaterialUsed()+t.getSmart_Concept()+t.getAcessibility()+t.getLocal_Influance()
//        +t.getInternational_Exportability()+t.getTeam_Chemistry()+t.getJury_Appriciation())/10);
//        
//        t.setVotes(t.getVotes()+1);
//        
//        UPA.getPersistenceUnit().merge(t);
//    }
    public List<String> getAllParticipantNames() {
        return UPA.getPersistenceUnit().createQuery("select i.teamName from Team i")
                .getResultList();

    }
    public List<Team> getAllParticipantsData() {
        return UPA.getPersistenceUnit().createQuery("select i  from Team i")
                .getResultList();

    }
//    public Team getWinner(){
////        List<Team> teams= UPA.getPersistenceUnit().createQuery("Select i from team i").getResultList();
////        Team winner=teams.get(0);
////        double max_overall=winner.getOverallScore();
////        for(int i=0;i<teams.size();i++){
////            if(teams.get(i).getOverallScore()>max_overall){
////                max_overall=teams.get(i).getOverallScore();
////                winner=teams.get(i);
////            }
////        }
////        return winner;
//
//    }
    
    public List<TeamOrder> getTeamOrder(){
        List<Team> l = getAllParticipantsData();
        l.sort((Team o1, Team o2) -> Double.compare(o2.getFinalScore(), o1.getFinalScore()));
                List<TeamOrder> ol = new ArrayList<>();
                int x=1;
                for (Team team : l) {
                    TeamOrder to = new TeamOrder();
                    to.setOrder(x);
                    to.setTeam(team);
                    ol.add(to);
                    x++;
        }
                return ol;
    }
    
    public List<Team> getTeamsByChallengeId(int id){
        return UPA.getPersistenceUnit().createQuery("select i.evaluation.team from CriteriaEvaluation i where i.criteria.challenge.id = :challengeId")
                .setParameter("challengeId", id)
                .getResultList();
    }
    
    public void AddEvaluationweb(Evaluation evaluation){
        UPA.getPersistenceUnit().persist(evaluation);
    }
    
//    public void AddEvaluation(int teamId,int juryMemberId,double InnovativeIdea,double Peaching_And_Communication,double ThemeAdequate,double MaterialUsed,
//    double Smart_Concept,double Acessibility,double Local_Influance,double International_Exportability,double Team_Chemistry,double Jury_Appriciation){
//        Evaluation e = new Evaluation();
//        e.setTeam(getTeamById(teamId));
//        e.setJuryMember(getJuryById(juryMemberId));
//        e.setInnovativeIdea(InnovativeIdea);
//        e.setPeaching_And_Communication(Peaching_And_Communication);
//        e.setThemeAdequate(ThemeAdequate);
//        e.setMaterialUsed(MaterialUsed);
//        e.setSmart_Concept(Smart_Concept);
//        e.setAcessibility(Acessibility);
//        e.setLocal_Influance(Local_Influance);
//        e.setInternational_Exportability(International_Exportability);
//        e.setTeam_Chemistry(Team_Chemistry);
//        e.setJury_Appriciation(Jury_Appriciation);
//        AddEvaluationweb(e);
//    }
    
    public List<Evaluation> getEvaluationsByTeamId(int id){
        return UPA.getPersistenceUnit().createQuery("select i from Evaluation i where i.team.id = :p")
                .setParameter("p", id)
                .getResultList();
    }
    
//    public void getFinalScores(){
//        List<Team> teams = getTeams();
//        for (Team team : teams) {
//            List<Evaluation> eval = getEvaluationsByTeamId(team.getId());
//            for (Evaluation evaluation : eval) {
//                team.setFinalScore(team.getFinalScore()+evaluation.getJuryMemberScore());
//                team.setFinalJuryAppriciation(team.getFinalJuryAppriciation()+evaluation.getJury_Appriciation());
//            }
//            UPA.getPersistenceUnit().merge(team);
//        }
//    }
    
    public Double getFinalScoreByTeamAndChallengeId(int teamId,int challengeId){
        return UPA.getPersistenceUnit().createQuery("select sum(i.score) from CriteriaEvaluation i where i.evaluation.team.id = :teamId and i.criteria.challenge.id = :challengeId")
                .setParameter("teamId", teamId)
                .setParameter("challengeId", challengeId)
                .getDouble();
    }
    
    public Double getScoreByTeamChallengeAndJuryId(int teamId,int challengeId,int juryId){
        return UPA.getPersistenceUnit().createQuery("select sum(i.score) from CriteriaEvaluation i where i.evaluation.team.id = :teamId and "
                + "i.criteria.challenge.id = :challengeId and i.evaluation.jury.id = :juryId")
                .setParameter("teamId", teamId)
                .setParameter("challengeId", challengeId)
                .setParameter("juryId", juryId)
                .getDouble();
    }
}
