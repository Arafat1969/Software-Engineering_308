public class ImposterDecorator implements Crewmate{
    private final Crewmate crewmate;
    public ImposterDecorator(Crewmate crewmate){
        this.crewmate=crewmate;
        System.out.println("We won’t tell anyone; you are an imposter.");
    }
    @Override
    public void repair() {
        crewmate.repair();
        System.out.println("Damaging the spaceship.");
    }

    @Override
    public void work() {
        crewmate.work();
        System.out.println("Trying to kill a crewmate.");
        System.out.println("Successfully killed a crewmate.");
    }

    @Override
    public void logout() {
        crewmate.logout();
        System.out.println("See you again Comrade Imposter.");
    }
}
