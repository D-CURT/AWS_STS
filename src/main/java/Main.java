import com.amazonaws.services.securitytoken.model.Credentials;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        AWSSTSService service = new AWSSTSService();
        Credentials stsCredentials = service.getSTSCredentials("AKIAJ7DT2KMCJAFSBPIQ", "O6cyyXt3ykD5+RGcrlCg2Foo+9+UsOE1pa4NSPBJ");
        JSONObject result = new JSONObject()
                .put("accessKey", stsCredentials.getAccessKeyId())
                .put("secretKey", stsCredentials.getSecretAccessKey())
                .put("sessionToken", stsCredentials.getSessionToken())
                .put("expiration", stsCredentials.getExpiration());
        log.info(result.toString());
        Files.writeString(Path.of("result.json"), result.toString());
    }

}
