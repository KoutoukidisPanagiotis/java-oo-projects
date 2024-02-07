package ch17;

import java.io.Serializable;

public abstract class AbstractShape implements IShape, Serializable {
    private static final long serialVersionUID = 1L;
    private long id;

    public AbstractShape(long id) {
        this.id = id;
    }

    public AbstractShape(AbstractShape abstractShape) {
        this(abstractShape.getId());
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
