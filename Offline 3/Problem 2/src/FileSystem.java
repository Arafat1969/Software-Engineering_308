import java.util.Date;

public interface FileSystem {
    FileSystem changeDirectory(String name);
    void details();
    void listing();
    void delete(String name);
    void recursiveDelete();
    void makeDir(String name);
    void touch(String name,int size);
    void makeDrive(String name);
    String getName();
    String getDirectory();
    int getSize();
    int getComponentCount();
    Date getCreationTime();
    FileSystem getComponent(String name);
}
