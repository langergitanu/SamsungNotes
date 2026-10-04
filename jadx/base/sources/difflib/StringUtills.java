package difflib;

import com.google.android.gms.common.data.AbstractC4539a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StringUtills {
    public static String expandTabs(String str) {
        return str.replace("\t", "    ");
    }

    public static String htmlEntites(String str) {
        return str.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static <T> String join(Iterable<T> iterable, String str) {
        Iterator<T> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(it.next()));
        while (it.hasNext()) {
            stringBuffer.append(str);
            stringBuffer.append(String.valueOf(it.next()));
        }
        return stringBuffer.toString();
    }

    public static String normalize(String str) {
        return expandTabs(htmlEntites(str));
    }

    public static List<String> wrapText(List<String> list, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(wrapText(it.next(), i));
        }
        return linkedList;
    }

    public static List<String> normalize(List<String> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(normalize(it.next()));
        }
        return linkedList;
    }

    public static String wrapText(String str, int i) {
        int length = str.length();
        int i2 = i;
        int i4 = 0;
        while (length > i2) {
            StringBuilder sb = new StringBuilder();
            int i5 = (4 * i4) + i2;
            sb.append((Object) str.subSequence(0, i5));
            sb.append("<br>");
            str = AbstractC4539a.m3198h(sb, str, i5);
            i2 += i;
            i4++;
        }
        return str;
    }
}
