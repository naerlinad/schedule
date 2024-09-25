package model.writers;

import java.io.IOException;
import java.io.Serializable;

public interface Writer extends Serializable {

    void write(Serializable obj) throws IOException;
    Object read() throws IOException, ClassNotFoundException;
    void setPath(String path);
    String getPath();
}
