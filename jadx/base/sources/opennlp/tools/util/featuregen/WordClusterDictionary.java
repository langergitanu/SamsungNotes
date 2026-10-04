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
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WordClusterDictionary implements SerializableArtifact {
    private final Map<String, String> tokenToClusterMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WordClusterDictionarySerializer implements ArtifactSerializer<WordClusterDictionary> {
        @Override // opennlp.tools.util.model.ArtifactSerializer
        public WordClusterDictionary create(InputStream inputStream) {
            return new WordClusterDictionary(inputStream);
        }

        @Override // opennlp.tools.util.model.ArtifactSerializer
        public void serialize(WordClusterDictionary wordClusterDictionary, OutputStream outputStream) throws IOException {
            wordClusterDictionary.serialize(outputStream);
        }
    }

    public WordClusterDictionary(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                String[] strArrSplit = line.split(" ");
                if (strArrSplit.length == 3) {
                    this.tokenToClusterMap.put(strArrSplit[0], strArrSplit[1].intern());
                } else if (strArrSplit.length == 2) {
                    this.tokenToClusterMap.put(strArrSplit[0], strArrSplit[1].intern());
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
        return WordClusterDictionarySerializer.class;
    }

    public String lookupToken(String str) {
        return this.tokenToClusterMap.get(str);
    }

    public void serialize(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            for (Map.Entry<String, String> entry : this.tokenToClusterMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
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
