import com.amazonaws.services.securitytoken.model.Credentials;

public class Main {

    public static void main(String[] args) {
        AWSSTSService service = new AWSSTSService();
        Credentials stsCredentials = service.getSTSCredentials("AKIAJ7DT2KMCJAFSBPIQ", "O6cyyXt3ykD5+RGcrlCg2Foo+9+UsOE1pa4NSPBJ");
        System.out.println(String.format("accessKey: %s, secretKey: %s, sessionToken: %s",
                stsCredentials.getAccessKeyId(),
                stsCredentials.getSecretAccessKey(),
                stsCredentials.getSessionToken()));
    }

}
