package com.samsung.android.support.senl.p148nt.data.repository.pdfwriter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.repository.pdfwriter.PDFWriterRepository;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PDFWriterGsonRepository implements PDFWriterRepository.PDFWriterDataSource {
    static final String FILE_NAME = "PdfWritierData.json";
    private static final String TAG = DataLogger.createTag("PDFWriterGsonRepository");
    private final Gson mGson = createGson();
    private final String mJsonFilePath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Base64TypeAdapter extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public String read2(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            return TextUtils.isEmpty(strNextString) ? "" : Base64Utils.decodeBase64(strNextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) {
            jsonWriter.value(TextUtils.isEmpty(str) ? "" : Base64Utils.encodeBase64(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PDFWriterDocInfo {
        private final String mFilePath;
        private final String mUuid;

        public PDFWriterDocInfo(String str, String str2) {
            this.mUuid = str;
            this.mFilePath = str2;
        }

        public String getFilePath() {
            return this.mFilePath;
        }

        public String getUuid() {
            return this.mUuid;
        }
    }

    public PDFWriterGsonRepository(String str) {
        this.mJsonFilePath = AbstractC0622a.m1170p(File.separator, FILE_NAME, AbstractC1974b.m1324q(str));
    }

    @NonNull
    private Map<String, PDFWriterDocInfo> loadFromFile() {
        Map map = null;
        if (new File(this.mJsonFilePath).exists()) {
            try {
                FileReader fileReaderCreateFileReader = JavaInstanceConstructor.createFileReader(this.mJsonFilePath);
                try {
                    Map map2 = (Map) this.mGson.fromJson(fileReaderCreateFileReader, new TypeToken<Map<String, PDFWriterDocInfo>>() { // from class: com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterGsonRepository.1
                    }.getType());
                    if (fileReaderCreateFileReader != null) {
                        try {
                            fileReaderCreateFileReader.close();
                        } catch (JsonSyntaxException | IOException e) {
                            e = e;
                            map = map2;
                            AbstractC11014a.m12333r(e, new StringBuilder("loadFromFile, e: "), TAG);
                        }
                    }
                    map = map2;
                } finally {
                }
            } catch (JsonSyntaxException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        }
        if (map == null) {
            DataLogger.m12302d(TAG, "loadFromFile, loadedMap is null");
            return new LinkedTreeMap();
        }
        LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
        for (PDFWriterDocInfo pDFWriterDocInfo : map.values()) {
            linkedTreeMap.put(pDFWriterDocInfo.getUuid(), pDFWriterDocInfo);
            DataLogger.m12302d(TAG, "loadFromFile, uuid/filPath: " + pDFWriterDocInfo.getUuid() + " / " + DataLogger.getEncode(pDFWriterDocInfo.getFilePath()));
        }
        return linkedTreeMap;
    }

    private void saveToFile(Map<String, PDFWriterDocInfo> map) {
        String json = this.mGson.toJson(map);
        try {
            FileWriter fileWriterCreateFileWriter = JavaInstanceConstructor.createFileWriter(this.mJsonFilePath);
            try {
                fileWriterCreateFileWriter.write(json);
                fileWriterCreateFileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            AbstractC11014a.m12332q(e, new StringBuilder("saveToFile, e: "), TAG);
        }
    }

    @VisibleForTesting
    public Gson createGson() {
        return new GsonBuilder().setPrettyPrinting().registerTypeAdapter(String.class, new Base64TypeAdapter()).create();
    }

    @Override // com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterRepository.PDFWriterDataSource
    public void delete(@NonNull String str) {
        AbstractC0000a.m2C("delete, uuid : ", str, TAG);
        Map<String, PDFWriterDocInfo> mapLoadFromFile = loadFromFile();
        mapLoadFromFile.remove(str);
        saveToFile(mapLoadFromFile);
    }

    @Override // com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterRepository.PDFWriterDataSource
    public String getFilePath(@NonNull String str) {
        PDFWriterDocInfo pDFWriterDocInfo = loadFromFile().get(str);
        return pDFWriterDocInfo != null ? pDFWriterDocInfo.getFilePath() : "";
    }

    @Override // com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterRepository.PDFWriterDataSource
    public String getUuid(@NonNull String str) {
        for (PDFWriterDocInfo pDFWriterDocInfo : loadFromFile().values()) {
            if (pDFWriterDocInfo.getFilePath().equals(str)) {
                DataLogger.m12302d(TAG, "getUuid, uuid/filPath: " + pDFWriterDocInfo.getUuid() + " / " + DataLogger.getEncode(pDFWriterDocInfo.getFilePath()));
                return pDFWriterDocInfo.getUuid();
            }
        }
        return "";
    }

    @Override // com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterRepository.PDFWriterDataSource
    public void insert(@NonNull String str, @NonNull String str2) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("insert, uuid : ", str, ", filePath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str3, sbM15l.toString());
        Map<String, PDFWriterDocInfo> mapLoadFromFile = loadFromFile();
        mapLoadFromFile.put(str, new PDFWriterDocInfo(str, str2));
        saveToFile(mapLoadFromFile);
    }

    @Override // com.samsung.android.support.senl.nt.data.repository.pdfwriter.PDFWriterRepository.PDFWriterDataSource
    public void trimDummy(Set<String> set) {
        HashSet hashSet = new HashSet();
        for (String str : loadFromFile().keySet()) {
            if (!set.contains(str)) {
                hashSet.add(str);
            }
        }
        DataLogger.m12302d(TAG, "trimDummy, invalid uuids: " + hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            delete((String) it.next());
        }
    }
}
