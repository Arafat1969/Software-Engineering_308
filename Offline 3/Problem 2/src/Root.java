import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Root implements FileSystem {
    private List<FileSystem> components;
    private static Root instance=null;
    private final String name;
    private final String directory;
    private final Date creationTime;

    private Root(){
        components=new ArrayList<>();
        this.name="root";
        this.directory=":";
        this.creationTime=new Date();
    }

    public static Root getInstance(){
        if(instance==null){
            instance=new Root();
        }
        return instance;
    }

    @Override
    public FileSystem getComponent(String name){
        FileSystem current=null;
        for (FileSystem x: components) {
            if(x.getName().equalsIgnoreCase(name)){
                current=x;
            }
        }
        return current;
    }

    @Override
    public FileSystem changeDirectory(String name) {
        FileSystem current=null;
        for (FileSystem x:components) {
            if(x.getName().equalsIgnoreCase(name)){
                current=x;
            }
        }
        if( current instanceof File || current==null) {
            System.out.println("The directory name is invalid.");
            return null;
        }
        System.out.println("Changed to "+current.getName()+" directory");
        return current;
    }

    @Override
    public void details() {
        System.out.println("Name: "+getName());
        System.out.println("Type: ");
        System.out.println("Size: "+getSize()+" kB");
        System.out.println("Directory: \""+getDirectory()+"\"");
        System.out.println("Component Count: "+getComponentCount());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy HH:mm aa");
        String formattedTime = dateFormat.format(getCreationTime());
        System.out.println("Creation time: "+formattedTime);
    }

    @Override
    public void listing() {
        System.out.println("jnsj");
        for (FileSystem x:components) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aa");
            String formattedTime = dateFormat.format(x.getCreationTime());
            System.out.println(x.getName()+"    "+x.getSize()+" kB    "+formattedTime);
        }
    }

    @Override
    public void delete(String name) {
        FileSystem current=null;
        int i=0;
        int index=i;
        for (FileSystem x:components) {
            if(x.getName().equalsIgnoreCase(name)){
                current=x;
                index=i;
            }
            i++;
        }
        if(current instanceof Drive) {
            if(current.getComponentCount()==0){
                System.out.println("Folder '" + name + "' deleted.");
            }else{
                current=null;
            }
        }else{
            System.out.println("The directory or file name is invalid.");
        }

        if(current!=null){
            components.remove(components.get(index));
        }
    }

    @Override
    public void recursiveDelete() {
        System.out.println("Not applicable for root");
    }

    @Override
    public void makeDir(String name) {
        System.out.println("Cannot create directory in root");
    }

    @Override
    public void touch(String name,int size) {
        System.out.println("Cannot create file in root");
    }

    @Override
    public void makeDrive(String name) {
        FileSystem drive= new Drive(name);
        components.add(drive);
        System.out.println("New drive "+drive.getName()+" created");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public int getSize() {
        int size=0;
        for (FileSystem x:components) {
            size+=x.getSize();
        }
        return  size;
    }

    @Override
    public int getComponentCount() {
        int componentCount=0;
        for (FileSystem x:components) {
            componentCount++;
        }
        return componentCount;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }
}
