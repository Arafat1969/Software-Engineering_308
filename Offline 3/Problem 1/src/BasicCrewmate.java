public class BasicCrewmate implements Crewmate{
    public BasicCrewmate(){
        System.out.println("Welcome Crewmate!");
    }
    @Override
    public void repair() {
        System.out.println("Repairing the spaceship.");
    }

    @Override
    public void work() {
        System.out.println("Doing research");
    }

    @Override
    public void logout() {
        System.out.println("Bye Bye crewmate.");
    }
}
