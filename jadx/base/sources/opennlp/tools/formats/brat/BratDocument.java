package opennlp.tools.formats.brat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratDocument {
    private final Map<String, BratAnnotation> annotationMap;
    private final AnnotationConfiguration config;

    /* JADX INFO: renamed from: id */
    private final String f9659id;
    private final String text;

    public BratDocument(AnnotationConfiguration annotationConfiguration, String str, String str2, Collection<BratAnnotation> collection) {
        this.config = annotationConfiguration;
        this.f9659id = str;
        this.text = str2;
        HashMap map = new HashMap();
        ArrayList<AnnotatorNoteAnnotation> arrayList = new ArrayList();
        for (BratAnnotation bratAnnotation : collection) {
            if (bratAnnotation instanceof AnnotatorNoteAnnotation) {
                arrayList.add((AnnotatorNoteAnnotation) bratAnnotation);
            } else {
                map.put(bratAnnotation.getId(), bratAnnotation);
            }
        }
        for (AnnotatorNoteAnnotation annotatorNoteAnnotation : arrayList) {
            BratAnnotation bratAnnotation2 = (BratAnnotation) map.get(annotatorNoteAnnotation.getAttachedId());
            if (bratAnnotation2 != null) {
                bratAnnotation2.setNote(annotatorNoteAnnotation.getNote());
            }
        }
        this.annotationMap = Collections.unmodifiableMap(map);
    }

    public static BratDocument parseDocument(AnnotationConfiguration annotationConfiguration, String str, InputStream inputStream, InputStream inputStream2) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (i <= 0) {
                break;
            }
            sb.append(cArr, 0, i);
        }
        ArrayList arrayList = new ArrayList();
        BratAnnotationStream bratAnnotationStream = new BratAnnotationStream(annotationConfiguration, str, inputStream2);
        while (true) {
            BratAnnotation bratAnnotation = bratAnnotationStream.read();
            if (bratAnnotation == null) {
                bratAnnotationStream.close();
                return new BratDocument(annotationConfiguration, str, sb.toString(), arrayList);
            }
            arrayList.add(bratAnnotation);
        }
    }

    public BratAnnotation getAnnotation(String str) {
        return this.annotationMap.get(str);
    }

    public Collection<BratAnnotation> getAnnotations() {
        return this.annotationMap.values();
    }

    public AnnotationConfiguration getConfig() {
        return this.config;
    }

    public String getId() {
        return this.f9659id;
    }

    public String getText() {
        return this.text;
    }
}
