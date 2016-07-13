package io.vkoloss.testlibs;

import static io.vkoloss.testlibs.Entity.Status.ACTIVE;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.mockito.Mockito;

public class JunitHamcrestTest {

    Service service = new Service();

    @Test
    public void shouldReturnNewUppercaseInstance() {
        // setup
        Entity e1 = new Entity();
        e1.setName("first");

        // stimulus & assert
        assertThat(e1.getInstance().getInstanceUppercase().getName(), is("First"));
    }

    @Test
    public void shouldReturnAllHavingChild() {
        // setup
        Entity e1 = new Entity();
        e1.setId(1L);
        e1.setName("first");
        e1.setStatus(ACTIVE);
        Entity e2 = new Entity();
        e2.setId(2L);
        e2.setName("second");
        e2.setStatus(ACTIVE);
        e2.setParent(e1);
        Entity e3 = new Entity();
        e3.setId(3L);
        e3.setName("third");
        e3.setStatus(ACTIVE);
        service.dao = Mockito.mock(Dao.class);
        Mockito.when(service.dao.getAll()).thenReturn(Arrays.asList(e1, e2, e3));

        // stimulus
        List<Entity> allHavingChild = service.getAllHavingParent();

        // assert
        assertThat(allHavingChild, hasSize(2));
    }
}
