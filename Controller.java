/**
 * Basic Controller class for all other controller to inherit from
 * Provides all controllers with a CSVDataManager
 * */
public class Controller {
    private CSVDataManager manager;

    /**
     * public constructor
     * @param manager the manager
     * */
    public Controller(CSVDataManager manager) {
        this.manager = manager;
    }

    /**
     * gets the manager to be used by the subclasses
     * @return the manager itself
     * */
    protected CSVDataManager getManager() {
        return this.manager;
    }
}
