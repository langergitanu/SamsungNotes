package opennlp.tools.util.featuregen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BrownCluster implements SerializableArtifact {
    private static final Pattern tabPattern = Pattern.compile("\t");
    private final Map<String, String> tokenToClusterMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BrownClusterSerializer implements ArtifactSerializer<BrownCluster> {
        @Override // opennlp.tools.util.model.ArtifactSerializer
        public BrownCluster create(InputStream inputStream) {
            return new BrownCluster(inputStream);
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public void serialize(BrownCluster brownCluster, OutputStream outputStream) throws IOException {
            brownCluster.serialize(outputStream);
        }
    }

    public BrownCluster(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                String[] strArrSplit = tabPattern.split(line);
                if (strArrSplit.length == 3) {
                    if (Integer.parseInt(strArrSplit[2]) > 5) {
                        this.tokenToClusterMap.put(strArrSplit[1], strArrSplit[0]);
                    }
                } else if (strArrSplit.length == 2) {
                    this.tokenToClusterMap.put(strArrSplit[0], strArrSplit[1]);
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // opennlp.tools.util.model.SerializableArtifact
    public Class<?> getArtifactSerializerClass() {
        return BrownClusterSerializer.class;
    }

    public String lookupToken(String str) {
        return this.tokenToClusterMap.get(str);
    }

    public void serialize(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            for (Map.Entry<String, String> entry : this.tokenToClusterMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
