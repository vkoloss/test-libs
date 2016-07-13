package io.vkoloss.testlibs;

public class Entity {

    private Long id;
    private String name;
    private Entity parent;
    private Status status;

    public Entity getInstance() {
        return this;
    }

    public Entity getInstanceUppercase() {
        Entity newE = new Entity();
        newE.id = id;
        newE.name = name.toUpperCase();
        newE.parent = parent;
        newE.status = status;
        return newE;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getParent() {
        return parent;
    }

    public void setParent(Entity parent) {
        this.parent = parent;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
