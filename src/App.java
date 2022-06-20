import org.apache.commons.codec.digest.DigestUtils;

public class App{
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("admin"));
    }
}