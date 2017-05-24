package bl;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements Reader {

    final static Logger logger = Logger.getLogger(FileReader.class);

    public String read() {
        String message = "";
        try {
            URI uri = ClassLoader.getSystemResource("message.txt").toURI();
            logger.info("File URI have been gotten");

            byte[] bytes = Files.readAllBytes(Paths.get(uri));
            logger.info("Byte array from file have been gotten");

            message=new String(bytes);
            logger.info("Message from file have been gotten");

        } catch (URISyntaxException | NullPointerException | IOException e) {
            logger.error(e);
        }
        return message;
    }
}
