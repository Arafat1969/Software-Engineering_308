import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder implements FileSystem{
    private List<FileSystem> components;
    private final String name;
    private final String type;
    private final String directory;
    private final Date creationTime;

    public Folder(String name,FileSystem currentDirectory){
        components=new ArrayList<>();
        this.name=name;
        this.type="Folder";
        this.directory=currentDirectory.getDirectory()+"\\"+name;
        this.creationTime=new Date();
    }

    public String getType() {
        return type;
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

    public Date getCreationTime() {
        return creationTime;
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
        if(current instanceof Folder) {
           if(current.getComponentCount()==0){
               System.out.println("Folder '" + name + "' deleted.");
           }else{
               System.out.println("Folder '" + name + "' is not empty.Cannot be deleted.");
               current=null;
           }
        } else if ( current instanceof File ) {
            System.out.println("ghhghnghngh");
            current.delete(name);
        }else{
            System.out.println("The directory or file name is invalid.");
        }

        if(current!=null){
            components.remove(components.get(index));
        }
    }

    @Override
    public void recursiveDelete() {
        if(getComponentCount()==0){
            return;
        }
        for (FileSystem x: components) {
            System.out.println(x.getName());
            if( x instanceof Folder ){
                x.recursiveDelete();
            }
        }
        int count=getComponentCount();
        for(int i=count-1;i>=0;i--){
            System.out.println(getComponentCount());
            delete(components.get(i).getName());
        }
    }

    @Override
    public void makeDir(String name) {
        FileSystem folder= new Folder(name,this);
        components.add(folder);
        System.out.println("New folder "+folder.getName()+" created");
    }

    @Override
    public void touch(String name,int size) {
        FileSystem file= new File(name,this,size);
        components.add(file);
        System.out.println("New file "+file.getName()+" created");
    }

    @Override
    public void makeDrive(String name) {
        System.out.println("You cannot create a drive inside a directory");
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
    public int getComponentCount() {
        int componentCount=0;
        for (FileSystem x:components) {
            componentCount++;
        }
        return componentCount;
    }

    @Override
    public int getSize() {
        int size=0;
        for (FileSystem x:components) {
            size+=x.getSize();
        }
        return  size;
    }


}
