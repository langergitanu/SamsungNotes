package difflib;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import difflib.myers.MyersDiff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiffUtils {
    private static DiffAlgorithm defaultDiffAlgorithm = new MyersDiff();
    private static Pattern unifiedDiffChunkRe = Pattern.compile("^@@\\s+-(?:(\\d+)(?:,(\\d+))?)\\s+\\+(?:(\\d+)(?:,(\\d+))?)\\s+@@$");

    public static Patch diff(List<?> list, List<?> list2) {
        return diff(list, list2, defaultDiffAlgorithm);
    }

    public static List<String> generateUnifiedDiff(String str, String str2, List<String> list, Patch patch, int i) {
        if (patch.getDeltas().isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("--- " + str);
        arrayList.add("+++ " + str2);
        ArrayList arrayList2 = new ArrayList(patch.getDeltas());
        ArrayList arrayList3 = new ArrayList();
        Delta delta = (Delta) arrayList2.get(0);
        arrayList3.add(delta);
        int i2 = 1;
        if (arrayList2.size() > 1) {
            while (i2 < arrayList2.size()) {
                int position = delta.getOriginal().getPosition();
                Delta delta2 = (Delta) arrayList2.get(i2);
                if (delta.getOriginal().size() + position + i >= delta2.getOriginal().getPosition() - i) {
                    arrayList3.add(delta2);
                } else {
                    arrayList.addAll(processDeltas(list, arrayList3, i));
                    arrayList3.clear();
                    arrayList3.add(delta2);
                }
                i2++;
                delta = delta2;
            }
        }
        arrayList.addAll(processDeltas(list, arrayList3, i));
        return arrayList;
    }

    private static List<String> getDeltaText(Delta delta) {
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = delta.getOriginal().getLines().iterator();
        while (it.hasNext()) {
            arrayList.add(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + it.next());
        }
        Iterator<?> it2 = delta.getRevised().getLines().iterator();
        while (it2.hasNext()) {
            arrayList.add(Marker.ANY_NON_NULL_MARKER + it2.next());
        }
        return arrayList;
    }

    public static Patch parseUnifiedDiff(List<String> list) {
        ArrayList<Object[]> arrayList = new ArrayList();
        Patch patch = new Patch();
        char c = 0;
        char c2 = 1;
        int i = 0;
        int i2 = 0;
        for (String str : list) {
            if (c2 == 0) {
                Matcher matcher = unifiedDiffChunkRe.matcher(str);
                if (matcher.find()) {
                    if (arrayList.size() != 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (Object[] objArr : arrayList) {
                            String str2 = (String) objArr[c];
                            String str3 = (String) objArr[1];
                            if (str2.equals(" ") || str2.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                                arrayList2.add(str3);
                            }
                            if (str2.equals(" ") || str2.equals(Marker.ANY_NON_NULL_MARKER)) {
                                arrayList3.add(str3);
                            }
                            c = 0;
                        }
                        patch.addDelta(new ChangeDelta(new Chunk(i - 1, arrayList2), new Chunk(i2 - 1, arrayList3)));
                        arrayList.clear();
                    }
                    int i4 = matcher.group(1) == null ? 1 : Integer.parseInt(matcher.group(1));
                    int i5 = matcher.group(3) == null ? 1 : Integer.parseInt(matcher.group(3));
                    if (i4 == 0) {
                        i4++;
                    }
                    if (i5 == 0) {
                        i5++;
                    }
                    i2 = i5;
                    i = i4;
                } else if (str.length() > 0) {
                    String strSubstring = str.substring(0, 1);
                    String strSubstring2 = str.substring(1);
                    if (strSubstring.equals(" ") || strSubstring.equals(Marker.ANY_NON_NULL_MARKER) || strSubstring.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                        arrayList.add(new Object[]{strSubstring, strSubstring2});
                    }
                } else {
                    arrayList.add(new Object[]{" ", ""});
                }
                c = 0;
            } else if (str.startsWith("+++")) {
                c2 = c;
            }
        }
        if (arrayList.size() != 0) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (Object[] objArr2 : arrayList) {
                String str4 = (String) objArr2[0];
                String str5 = (String) objArr2[1];
                if (str4.equals(" ") || str4.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                    arrayList4.add(str5);
                }
                if (str4.equals(" ") || str4.equals(Marker.ANY_NON_NULL_MARKER)) {
                    arrayList5.add(str5);
                }
            }
            patch.addDelta(new ChangeDelta(new Chunk(i - 1, arrayList4), new Chunk(i2 - 1, arrayList5)));
            arrayList.clear();
        }
        return patch;
    }

    public static List<?> patch(List<?> list, Patch patch) {
        return patch.applyTo(list);
    }

    private static List<String> processDeltas(List<String> list, List<Delta> list2, int i) {
        ArrayList arrayList = new ArrayList();
        Delta delta = list2.get(0);
        int i2 = 1;
        int position = (delta.getOriginal().getPosition() + 1) - i;
        if (position < 1) {
            position = 1;
        }
        int position2 = (delta.getRevised().getPosition() + 1) - i;
        if (position2 < 1) {
            position2 = 1;
        }
        int position3 = delta.getOriginal().getPosition() - i;
        if (position3 < 0) {
            position3 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (position3 < delta.getOriginal().getPosition()) {
            arrayList.add(" " + list.get(position3));
            i4++;
            i5++;
            position3++;
        }
        arrayList.addAll(getDeltaText(delta));
        int size = delta.getOriginal().getLines().size() + i4;
        int size2 = delta.getRevised().getLines().size() + i5;
        while (i2 < list2.size()) {
            Delta delta2 = list2.get(i2);
            for (int size3 = delta.getOriginal().getLines().size() + delta.getOriginal().getPosition(); size3 < delta2.getOriginal().getPosition(); size3++) {
                arrayList.add(" " + list.get(size3));
                size++;
                size2++;
            }
            arrayList.addAll(getDeltaText(delta2));
            size += delta2.getOriginal().getLines().size();
            size2 += delta2.getRevised().getLines().size();
            i2++;
            delta = delta2;
        }
        int size4 = delta.getOriginal().getLines().size() + delta.getOriginal().getPosition();
        for (int i6 = size4; i6 < size4 + i && i6 < list.size(); i6++) {
            arrayList.add(" " + list.get(i6));
            size++;
            size2++;
        }
        StringBuffer stringBuffer = new StringBuffer("@@ -");
        stringBuffer.append(position);
        stringBuffer.append(",");
        stringBuffer.append(size);
        stringBuffer.append(" +");
        stringBuffer.append(position2);
        stringBuffer.append(",");
        stringBuffer.append(size2);
        stringBuffer.append(" @@");
        arrayList.add(0, stringBuffer.toString());
        return arrayList;
    }

    public static List<?> unpatch(List<?> list, Patch patch) {
        return patch.restore(list);
    }

    public static Patch diff(List<?> list, List<?> list2, DiffAlgorithm diffAlgorithm) {
        return diffAlgorithm.diff(list, list2);
    }
}
