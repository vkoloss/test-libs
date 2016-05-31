package io.vkoloss.testlibs

import spock.lang.Specification

import static io.vkoloss.testlibs.Entity.Status.ACTIVE

class SpockTest extends Specification {

    def service = new Service();

    def "should return all having child"() {
        given:
        Entity e1 = new Entity(id: 1, name: 'first', status: ACTIVE);
        Entity e2 = new Entity(id: 2, name: 'second', status: ACTIVE, parent: e1);
        Entity e3 = new Entity(id: 3, name: 'third', status: ACTIVE);
        service.dao = [getAll: { [e1, e2, e3] }] as Dao // map coercion

        when:
        List<Entity> allHavingChild = service.getAllHavingParent();

        then:
        assert allHavingChild.size() == 2
    }
}
