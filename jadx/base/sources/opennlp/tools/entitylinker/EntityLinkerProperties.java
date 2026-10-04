package opennlp.tools.entitylinker;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EntityLinkerProperties {
    private Properties props;

    public EntityLinkerProperties(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            init(bufferedInputStream);
            bufferedInputStream.close();
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void init(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        this.props = properties;
        properties.load(inputStream);
    }

    public String getProperty(String str, String str2) throws IOException {
        Properties properties = this.props;
        if (properties != null) {
            return properties.getProperty(str, str2);
        }
        throw new IOException("EntityLinkerProperties was not successfully initialized");
    }

    public EntityLinkerProperties(InputStream inputStream) throws IOException {
        init(inputStream);
    }
}
