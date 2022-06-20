public class Session {
    private String id;
    private String nama;
    private String email;
    private String pass;
    private String alamat;
    private String role;

    public String getId(){
        return id;
    }

    public String getName(){
        return nama;
    }

    public String getEmail(){
        return email;
    }

    public String getPass(){
        return pass;
    }

    public String getAlamat(){
        return alamat;
    }

    public String getRole(){
        return role;
    }

    public Session(String id, String nama, String email, String pass, String alamat, String role ){
        this.id =id;
        this.nama = nama;
        this.email = email;
        this.pass = pass;
        this.alamat = alamat;
        this.role = role;
    }


}
