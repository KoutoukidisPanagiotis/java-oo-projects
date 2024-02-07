package ch19.model;

public class AbstractEntity implements IIdentifiableEntity {
    private Long id;
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
