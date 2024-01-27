package Client;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
   public ArrayList<String> notifications;
   private String name;
   public boolean isActive;

   public User(String name){
      this.name=name;
      notifications= new ArrayList<>();
      isActive=true;
   }

   public ArrayList<String> getNotifications() {
      return notifications;
   }

   public void setNotifications(ArrayList<String> notifications) {
      this.notifications = notifications;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void update(String msg){
      notifications.add(msg);
   }


}
