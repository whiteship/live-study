import org.json.simple.parser.ParseException;
import org.kohsuke.github.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gitHubIssues {
    GitHub gitHub;
    GHRepository repository;

    private String getToken() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject token = (JSONObject) parser.parse(new FileReader("config/config.json"));
        return (String) token.get("token");
    }

    public GHRepository gitHubConnection(String name) throws IOException, ParseException {
        gitHub = new GitHubBuilder().withOAuthToken(this.getToken()).build();
        repository = gitHub.getRepository(name);
        return repository;
    }

    public List<GHIssue> getIssues() throws IOException {
        return repository.getIssues(GHIssueState.valueOf("ALL"));
    }

    public Map<String, Integer> getCrewList(Map<String, Integer> crewList, List<GHIssue> issues) throws IOException {
        for(GHIssue issue : issues){
            PagedIterable<GHIssueComment> lists = issue.listComments();
            for(GHIssueComment list : lists){
                String crew = list.getUser().getLogin();
                if(crewList.containsKey(crew)){
                    crewList.put(crew,crewList.get(crew)+1);
                }else {
                    crewList.put(crew, 1);
                }
            }
        }
        return crewList;
    }

    public void writeFile(String path, Map<String, Integer> crewList){
        File file = new File(path);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String key : crewList.keySet()) {
                writer.write(String.format("ID : %s  -> 참여율 : %.2f\n", key, (float)crewList.get(key) / 18 * 100));
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        Map<String, Integer> crewList = new HashMap<String, Integer>();
        gitHubIssues gitHub = new gitHubIssues();

        gitHub.gitHubConnection("whiteship/live-study");

        List<GHIssue> issues = gitHub.getIssues();

        crewList = gitHub.getCrewList(crewList, issues);

        gitHub.writeFile("resources/crewList.txt", crewList);
    }
}
