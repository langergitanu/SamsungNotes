package opennlp.tools.doccat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.commons.Sample;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentSample implements Sample {
    private static final long serialVersionUID = -1775688015002177141L;
    private final String category;
    private final Map<String, Object> extraInformation;
    private final List<String> text;

    public DocumentSample(String str, String[] strArr) {
        this(str, strArr, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DocumentSample) {
            DocumentSample documentSample = (DocumentSample) obj;
            if (getCategory().equals(documentSample.getCategory()) && Arrays.equals(getText(), documentSample.getText())) {
                return true;
            }
        }
        return false;
    }

    public String getCategory() {
        return this.category;
    }

    public Map<String, Object> getExtraInformation() {
        return this.extraInformation;
    }

    public String[] getText() {
        return (String[]) this.text.toArray(new String[0]);
    }

    public int hashCode() {
        return Objects.hash(getCategory(), Integer.valueOf(Arrays.hashCode(getText())));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.category);
        sb.append('\t');
        Iterator<String> it = this.text.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public DocumentSample(String str, String[] strArr, Map<String, Object> map) {
        Objects.requireNonNull(strArr, "text must not be null");
        Objects.requireNonNull(str, "category must not be null");
        this.category = str;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            Objects.requireNonNull(str2);
            arrayList.add(str2);
        }
        this.text = Collections.unmodifiableList(arrayList);
        Map<String, Object> map2 = Collections.EMPTY_MAP;
        if (map == null) {
            Objects.requireNonNull(map2, "defaultObj");
            map = map2;
        }
        this.extraInformation = map;
    }
}
