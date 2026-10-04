package opennlp.tools.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadUtil {
    private static final String BASE_URL = "https://dlcdn.apache.org/opennlp/";
    private static final String MODELS_UD_MODELS_1_0 = "models/ud-models-1.0/";
    public static final Map<String, Map<ModelType, String>> available_models;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DownloadUtil.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Internal
    public static class DownloadParser {
        private static final Pattern LINK_PATTERN = Pattern.compile("<a href=\\\"(.*?)\\\">(.*?)</a>", 34);
        private final URL indexUrl;

        public DownloadParser(URL url) {
            Objects.requireNonNull(url);
            this.indexUrl = url;
        }

        private void addModel(String str, String str2, Map<String, Map<ModelType, String>> map) {
            Object obj;
            Map<ModelType, String> orDefault = map.getOrDefault(str, new HashMap());
            if (this.indexUrl.toString().endsWith("/")) {
                obj = this.indexUrl;
            } else {
                obj = this.indexUrl + "/";
            }
            String str3 = obj + str2;
            if (str2.contains("sentence")) {
                orDefault.put(ModelType.SENTENCE_DETECTOR, str3);
            } else if (str2.contains("tokens")) {
                orDefault.put(ModelType.TOKENIZER, str3);
            } else if (str2.contains("pos")) {
                orDefault.put(ModelType.POS, str3);
            }
            map.putIfAbsent(str, orDefault);
        }

        private String fetchPageIndex() {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.indexUrl.openStream(), StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } finally {
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                DownloadUtil.logger.error("Could not read page index from {}", this.indexUrl, e);
            }
            return sb.toString();
        }

        private Map<String, Map<ModelType, String>> toMap(List<String> list) {
            HashMap map = new HashMap();
            for (String str : list) {
                if (str.endsWith(".bin")) {
                    if (str.contains("de-ud")) {
                        addModel(LangPackConfigConstants.LANGUAGE_CODE_DE, str, map);
                    } else if (str.contains("en-ud")) {
                        addModel("en", str, map);
                    } else if (str.contains("it-ud")) {
                        addModel(LangPackConfigConstants.LANGUAGE_CODE_IT, str, map);
                    } else if (str.contains("nl-ud")) {
                        addModel("nl", str, map);
                    } else if (str.contains("fr-ud")) {
                        addModel(LangPackConfigConstants.LANGUAGE_CODE_FR, str, map);
                    }
                }
            }
            return map;
        }

        public Map<String, Map<ModelType, String>> getAvailableModels() {
            Matcher matcher = LINK_PATTERN.matcher(fetchPageIndex());
            ArrayList arrayList = new ArrayList();
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
            return toMap(arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ModelType {
        TOKENIZER(ResponseType.TOKEN),
        SENTENCE_DETECTOR("sent"),
        POS("pos-perceptron"),
        NAME_FINDER("ner"),
        CHUNKER("chunker"),
        PARSER("parser-chunking");

        private final String name;

        ModelType(String str) {
            this.name = str;
        }
    }

    static {
        try {
            available_models = new DownloadParser(new URL("https://dlcdn.apache.org/opennlp/models/ud-models-1.0/")).getAvailableModels();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends BaseModel> T downloadModel(String str, ModelType modelType, Class<T> cls) throws IOException {
        String str2;
        Map<String, Map<ModelType, String>> map = available_models;
        if (!map.containsKey(str) || (str2 = map.get(str).get(modelType)) == null) {
            throw new IOException("Invalid model.");
        }
        return (T) downloadModel(new URL(str2), cls);
    }

    public static <T extends BaseModel> T downloadModel(URL url, Class<T> cls) throws IOException {
        Path path = Paths.get(AbstractC0541b.m756B(System.getProperty("user.home"), "/.opennlp/"), new String[0]);
        if (!Files.isDirectory(path, new LinkOption[0])) {
            path.toFile().mkdir();
        }
        Path path2 = Paths.get(path.toString(), url.toString().substring(url.toString().lastIndexOf("/") + 1));
        if (!Files.exists(path2, new LinkOption[0])) {
            Logger logger2 = logger;
            logger2.debug("Downloading model from {} to {}.", url, path2);
            InputStream inputStreamOpenStream = url.openStream();
            try {
                Files.copy(inputStreamOpenStream, path2, StandardCopyOption.REPLACE_EXISTING);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                logger2.debug("Download complete.");
            } catch (Throwable th) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        try {
            return cls.getConstructor(Path.class).newInstance(path2);
        } catch (Exception e) {
            throw new IOException(AbstractC0541b.m772n("Could not initialize Model of type ", cls.getTypeName()), e);
        }
    }
}
