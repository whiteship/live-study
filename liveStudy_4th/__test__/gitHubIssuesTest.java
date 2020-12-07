import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class githubReadMeTest {

    @Test
    void sum1() {
        githubReadMe model = new githubReadMe();
        assertEquals(model.sum(1,2), 3);
    }
}