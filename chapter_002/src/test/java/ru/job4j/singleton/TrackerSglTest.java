package ru.job4j.singleton;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class TrackerSglTest {
    @Test
    public void whenSgl1() {
        TrackerSgl1 trcksg =  TrackerSgl1.INSTANCE;
        assertThat(trcksg, is(TrackerSgl1.INSTANCE));
    }
    @Test
    public void whenSgl2() {
        TrackerSgl2 trcksg =  TrackerSgl2.getInstance();
        assertThat(trcksg, is(TrackerSgl2.getInstance()));
    }
    @Test
    public void whenSgl3() {
        TrackerSgl3 trcksg =  TrackerSgl3.getInstance();
        assertThat(trcksg, is(TrackerSgl3.getInstance()));
    }
    @Test
    public void whenSgl4() {
        TrackerSgl4 trcksg =  TrackerSgl4.getInstance();
        assertThat(trcksg, is(TrackerSgl4.getInstance()));
    }
}
