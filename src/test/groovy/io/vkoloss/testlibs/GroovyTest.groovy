package io.vkoloss.testlibs

import org.junit.Test

import static io.vkoloss.testlibs.Entity.Status.ACTIVE

class GroovyTest {

    def service = new Service();

    @Test
    void shouldReturnAllHavingChild() {
        // setup
        Entity e1 = new Entity(id: 1, name: 'first', status: ACTIVE);
        Entity e2 = new Entity(id: 2, name: 'second', status: ACTIVE, parent: e1);
        Entity e3 = new Entity(id: 3, name: 'third', status: ACTIVE);
        service.dao = [getAll: { [e1, e2, e3] }] as Dao // map coercion

        // stimulus
        List<Entity> allHavingChild = service.getAllHavingParent();

        // assert
        assert allHavingChild.size() == 2
    }
}
