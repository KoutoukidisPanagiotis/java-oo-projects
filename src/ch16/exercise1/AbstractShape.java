package ch16.exercise1;

public abstract class AbstractShape implements IShape{
    private long id;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
