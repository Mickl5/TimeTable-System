public class Admin extends User{
    private String sysAdmin;

  public Admin(String userId, String name, String password, String sysAdmin) {
    super(userId, name, password);
    this.sysAdmin = sysAdmin;
  }

  public String getSysAdmin() {
    return sysAdmin;
  }
  public void setSysAdmin(String sysAdmin) {}
}
