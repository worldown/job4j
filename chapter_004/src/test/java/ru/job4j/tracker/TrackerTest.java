package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Kosolapov Ilya (d_dexter@mail.ru)
 * @version $ID$
 * @since 0.1
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDexcription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDexcription", 123L);
        Item next = new Item("test2", "testDexcription2", 123L);
        tracker.add(previous);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemTenDeleted() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDexcription", 123L);
        Item item2 = new Item("test2", "testDexcription2", 123L);
        Item item3 = new Item("test3", "testDexcription3", 123L);
        Item item4 = new Item("test4", "testDexcription4", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item4.getId());
        assertThat(tracker.findById(item4.getId()), is(nullValue()));
    }

    @Test
    public void whenGetAllItemsThenSame() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test1", "testDexcription", 123L)),
                tracker.add(new Item("test2", "testDexcription2", 123L)),
                tracker.add(new Item("test3", "testDexcription3", 123L)),
                tracker.add(new Item("test4", "testDexcription4", 123L))
        };
        assertThat(tracker.findAll().toArray(), is(items));
    }

    @Test
    public void whenGetByNameThenGetProperItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test", "testDexcription", 123L),
                new Item("test2", "testDexcription2", 123L),
                new Item("test", "testDexcription3", 123L),
                new Item("test4", "testDexcription4", 123L)
        };
        for (Item item : items) {
            tracker.add(item);
        }
        List<Item> expected = new ArrayList<>();
               expected.add(tracker.findAll().get(0));
               expected.add(tracker.findAll().get(2));
        List<Item> result = tracker.findByName("test");
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetByIdThenGetProperItem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("test1", "testDexcription", 123L),
                new Item("test2", "testDexcription2", 123L),
                new Item("test3", "testDexcription3", 123L),
                new Item("test4", "testDexcription4", 123L)
        };
        for (Item item : items) {
            tracker.add(item);
        }
        String expected = tracker.findAll().get(3).getId();
        String result = tracker.findById(tracker.findAll().get(3).getId()).getId();
        assertThat(result, is(expected));
    }
}