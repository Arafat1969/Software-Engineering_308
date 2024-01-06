import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File implements FileSystem{
    private final String name;
    private final int size;
    private final String type;
    private final String directory;
    private final int componentCount;
    private final Date creationTime;


    public File(String name,FileSystem currentDirectory, int size){
        this.name=name;
        this.size=size;
        String part[]=name.split("\\.");
        this.type=part[1];
        this.directory=currentDirectory.getDirectory()+"\\"+name;
        this.componentCount=0;
        this.creationTime=new Date();
    }

    @Override
    public FileSystem getComponent(String name){
        System.out.println("No components present");
        return null;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public int getComponentCount() {
        return componentCount;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FileSystem changeDirectory(String name) {
        System.out.println("Directory cannot be changed.");
        return null;
    }

    @Override
    public void details() {
        System.out.println("Name: "+getName());
        System.out.println("Type: "+getType());
        System.out.println("Size: "+getSize()+" kB");
        System.out.println("Directory: \""+getDirectory()+"\"");
        System.out.println("Component Count: "+getComponentCount());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy HH:mm aa");
        String formattedTime = dateFormat.format(getCreationTime());
        System.out.println("Creation time: "+formattedTime);
    }

    @Override
    public void listing() {
        System.out.println("Listing is not possible");
    }

    @Override
    public void delete(String name) {
        System.out.println("File "+getName()+" deleted");
    }

    @Override
    public void recursiveDelete() {
        System.out.println("Please use recursive delete for folder only");
        delete(name);
    }

    @Override
    public void makeDir(String name) {
        System.out.println("Cannot create a directory");
    }

    @Override
    public void touch(String name,int size) {
        System.out.println("Cannot create a file within a file");
    }

    @Override
    public void makeDrive(String name) {
        System.out.println("Cannot create a drive");
    }
}
