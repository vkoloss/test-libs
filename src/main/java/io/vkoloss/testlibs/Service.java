package io.vkoloss.testlibs;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    Dao dao = new Dao();

    public List<Entity> getAll() {
        return dao.getAll();
    }

    public List<Entity> getAllHavingParent() {
        List<Entity> list = dao.getAll();
        return list.stream().filter(entity -> entity.getParent() != null).collect(Collectors.toList());
    }

}
