import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class gitHubIssuesTest {

    @Test
    void gitHubConnectionWhiteship() throws IOException, ParseException {
        gitHubIssues gitHub = new gitHubIssues();
        GHRepository repository = gitHub.gitHubConnection("whiteship/live-study");
        assertEquals(repository.getDescription(), "온라인 스터디");
    }

    @Test
    void checkIssuesSize() throws IOException, ParseException {
        gitHubIssues gitHub = new gitHubIssues();
        gitHub.gitHubConnection("whiteship/live-study");
        assertEquals(gitHub.getIssues().size(), 18);
    }

    @Test
    void getCrewList(){

    }

    @Test
    void writeFile(){
        String path = "resources/tempList.txt";
        Map<String, Integer> tempList = new HashMap<String, Integer>();
        tempList.put("image",1);
        tempList.put("maven", 10);
        tempList.put("ysl",18);

        File file = new File(path);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(String key : tempList.keySet()){
                writer.write(String.format("ID : %s  -> 참여율 : %.2f\n", key, (float)tempList.get(key) / 18 * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(file.exists());
    }
}