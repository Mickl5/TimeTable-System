public class Controller {
    private CSVDataManager manager;

    public Controller(CSVDataManager manager) {
        this.manager = manager;
    }

    protected CSVDataManager getManager() {
        return this.manager;
    }
}
