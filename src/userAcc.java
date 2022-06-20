public class userAcc {
    private static String email;
    private static String password;
    private static String username;
    private static String alamat;

    public static String getEmail() {
        return email;
    }

    public void newEmail (String email) {
        this.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public void newPassword(String password) {
        this.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public void newUsername (String username) {
        this.username = username;
    }

    public static String getAdd() {
        return alamat;
    }

    public void newAdd (String alamat) {
        this.username = alamat;
    }


    public userAcc(String email, String password, String username, String alamat) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
    }
}
