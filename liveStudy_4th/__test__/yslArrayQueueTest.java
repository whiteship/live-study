import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class yslArrayQueueTest {
    @Test
    void queueLimitPushCheck(){
        // given
        yslArrayQueue queue = new yslArrayQueue();

        // when
        for(int i=0; i<1000; i++) queue.push(i);
        queue.pop();

        // then  1000개를 넣은 뒤 다음은 0번.
        assertEquals(0, queue.getEnd());
    }
}