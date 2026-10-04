package opennlp.tools.lemmatizer;

import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryLemmatizer implements Lemmatizer {
    private final Map<List<String>, List<String>> dictMap;

    public DictionaryLemmatizer(InputStream inputStream, Charset charset) throws IOException {
        this.dictMap = new HashMap();
        init(inputStream, charset);
    }

    private List<String> getAllLemmas(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        List<String> list = this.dictMap.get(getDictKeys(str, str2));
        if (list == null || list.isEmpty()) {
            arrayList.add("O");
            return arrayList;
        }
        arrayList.addAll(list);
        return arrayList;
    }

    private List<String> getDictKeys(String str, String str2) {
        return new ArrayList(Arrays.asList(str.toLowerCase(), str2));
    }

    private void init(InputStream inputStream, Charset charset) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String[] strArrSplit = line.split("\t");
            this.dictMap.put(Arrays.asList(strArrSplit[0], strArrSplit[1]), Arrays.asList(strArrSplit[2].split(ContentUtils.HASH_SYMBOL)));
        }
    }

    public Map<List<String>, List<String>> getDictMap() {
        return this.dictMap;
    }

    @Override // opennlp.tools.lemmatizer.Lemmatizer
    public String[] lemmatize(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add(lemmatize(strArr[i], strArr2[i]));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public DictionaryLemmatizer(InputStream inputStream) {
        this(inputStream, StandardCharsets.UTF_8);
    }

    public DictionaryLemmatizer(File file) {
        this(file, StandardCharsets.UTF_8);
    }

    @Override // opennlp.tools.lemmatizer.Lemmatizer
    public List<List<String>> lemmatize(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(getAllLemmas(list.get(i), list2.get(i)));
        }
        return arrayList;
    }

    public DictionaryLemmatizer(File file, Charset charset) throws IOException {
        this.dictMap = new HashMap();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            init(bufferedInputStream, charset);
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

    private String lemmatize(String str, String str2) {
        List<String> list = this.dictMap.get(getDictKeys(str, str2));
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return "O";
    }

    public DictionaryLemmatizer(Path path) throws IOException {
        this.dictMap = new HashMap();
        init(Files.newInputStream(path, new OpenOption[0]), StandardCharsets.UTF_8);
    }
}
