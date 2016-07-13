package io.vkoloss.testlibs

import spock.lang.Specification

import static io.vkoloss.testlibs.Entity.Status.ACTIVE

class SpockTest extends Specification {

    def service = new Service();

    def "should return new uppercase instance"() {
        when:
        Entity e1 = new Entity(name: 'first')

        then:
        e1.instance.instanceUppercase.name == "First"
    }

    def "should return all having child"() {
        given:
        Entity e1 = new Entity(id: 1, name: 'first', status: ACTIVE);
        Entity e2 = new Entity(id: 2, name: 'second', status: ACTIVE, parent: e1);
        Entity e3 = new Entity(id: 3, name: 'third', status: ACTIVE);
        service.dao = Stub(Dao)
        service.dao.getAll() >> [e1, e2, e3]

        when:
        List<Entity> allHavingChild = service.getAllHavingParent();

        then:
        allHavingChild.size() == 2
    }
}
