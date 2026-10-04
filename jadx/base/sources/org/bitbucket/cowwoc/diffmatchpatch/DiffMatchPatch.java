package org.bitbucket.cowwoc.diffmatchpatch;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.slf4j.Marker;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DiffMatchPatch {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final short MATCH_MAX_BITS = 32;
    public float diffTimeout = 1.0f;
    public short diffEditCost = 4;
    public float matchThreshold = 0.5f;
    public int matchDistance = 1000;
    public float patchDeleteThreshold = 0.5f;
    public short patchMargin = 4;
    private final Pattern BLANKLINEEND = Pattern.compile("\\n\\r?\\n\\Z", 32);
    private final Pattern BLANKLINESTART = Pattern.compile("\\A\\r?\\n\\r?\\n", 32);

    /* JADX INFO: renamed from: org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C141961 {

        /* JADX INFO: renamed from: $SwitchMap$org$bitbucket$cowwoc$diffmatchpatch$DiffMatchPatch$Operation */
        static final /* synthetic */ int[] f10184x3fe1b310;

        static {
            int[] iArr = new int[Operation.values().length];
            f10184x3fe1b310 = iArr;
            try {
                iArr[Operation.INSERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10184x3fe1b310[Operation.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10184x3fe1b310[Operation.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Diff {
        public Operation operation;
        public String text;

        public Diff(Operation operation, String str) {
            this.operation = operation;
            this.text = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Diff diff = (Diff) obj;
            if (this.operation != diff.operation) {
                return false;
            }
            String str = this.text;
            if (str == null) {
                if (diff.text != null) {
                    return false;
                }
            } else if (!str.equals(diff.text)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Operation operation = this.operation;
            int iHashCode = operation == null ? 0 : operation.hashCode();
            String str = this.text;
            return ((str != null ? str.hashCode() : 0) * 31) + iHashCode;
        }

        public String toString() {
            return "Diff(" + this.operation + ",\"" + this.text.replace('\n', Typography.paragraph) + "\")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinesToCharsResult {
        protected String chars1;
        protected String chars2;
        protected List<String> lineArray;

        public LinesToCharsResult(String str, String str2, List<String> list) {
            this.chars1 = str;
            this.chars2 = str2;
            this.lineArray = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Operation {
        DELETE,
        INSERT,
        EQUAL
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Patch {
        public LinkedList<Diff> diffs = new LinkedList<>();
        public int length1;
        public int length2;
        public int start1;
        public int start2;

        public String toString() {
            String string;
            String string2;
            int i = this.length1;
            if (i == 0) {
                string = AbstractC2821a.m2223n(new StringBuilder(), ",0", this.start1);
            } else if (i == 1) {
                string = Integer.toString(this.start1 + 1);
            } else {
                string = (this.start1 + 1) + "," + this.length1;
            }
            int i2 = this.length2;
            if (i2 == 0) {
                string2 = AbstractC2821a.m2223n(new StringBuilder(), ",0", this.start2);
            } else if (i2 == 1) {
                string2 = Integer.toString(this.start2 + 1);
            } else {
                string2 = (this.start2 + 1) + "," + this.length2;
            }
            StringBuilder sbM16m = AbstractC0000a.m16m("@@ -", string, " +", string2, " @@\n");
            for (Diff diff : this.diffs) {
                int i4 = C141961.f10184x3fe1b310[diff.operation.ordinal()];
                if (i4 == 1) {
                    sbM16m.append('+');
                } else if (i4 == 2) {
                    sbM16m.append('-');
                } else if (i4 == 3) {
                    sbM16m.append(' ');
                }
                try {
                    sbM16m.append(URLEncoder.encode(diff.text, "UTF-8").replace('+', ' '));
                    sbM16m.append("\n");
                } catch (UnsupportedEncodingException e) {
                    throw new Error("This system does not support UTF-8.", e);
                }
            }
            return DiffMatchPatch.unescapeForEncodeUriCompatability(sbM16m.toString());
        }
    }

    private LinkedList<Diff> diffBisectSplit(String str, String str2, int i, int i2, long j) {
        String strSubstring = str.substring(0, i);
        String strSubstring2 = str2.substring(0, i2);
        String strSubstring3 = str.substring(i);
        String strSubstring4 = str2.substring(i2);
        LinkedList<Diff> linkedListDiffMain = diffMain(strSubstring, strSubstring2, false, j);
        linkedListDiffMain.addAll(diffMain(strSubstring3, strSubstring4, false, j));
        return linkedListDiffMain;
    }

    private int diffCleanupSemanticScore(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0) {
            return 6;
        }
        char cM4a = AbstractC0000a.m4a(1, str);
        char cCharAt = str2.charAt(0);
        boolean zIsLetterOrDigit = Character.isLetterOrDigit(cM4a);
        boolean zIsLetterOrDigit2 = Character.isLetterOrDigit(cCharAt);
        boolean z = !zIsLetterOrDigit && Character.isWhitespace(cM4a);
        boolean z2 = !zIsLetterOrDigit2 && Character.isWhitespace(cCharAt);
        boolean z3 = z && Character.getType(cM4a) == 15;
        boolean z4 = z2 && Character.getType(cCharAt) == 15;
        boolean z5 = z3 && this.BLANKLINEEND.matcher(str).find();
        boolean z6 = z4 && this.BLANKLINESTART.matcher(str2).find();
        if (z5 || z6) {
            return 5;
        }
        if (z3 || z4) {
            return 4;
        }
        if (!zIsLetterOrDigit && !z && z2) {
            return 3;
        }
        if (z || z2) {
            return 2;
        }
        return (zIsLetterOrDigit && zIsLetterOrDigit2) ? 0 : 1;
    }

    private LinkedList<Diff> diffCompute(String str, String str2, boolean z, long j) {
        LinkedList<Diff> linkedList = new LinkedList<>();
        if (str.length() == 0) {
            linkedList.add(new Diff(Operation.INSERT, str2));
            return linkedList;
        }
        if (str2.length() == 0) {
            linkedList.add(new Diff(Operation.DELETE, str));
            return linkedList;
        }
        String str3 = str.length() > str2.length() ? str : str2;
        String str4 = str.length() > str2.length() ? str2 : str;
        int iIndexOf = str3.indexOf(str4);
        if (iIndexOf != -1) {
            Operation operation = str.length() > str2.length() ? Operation.DELETE : Operation.INSERT;
            linkedList.add(new Diff(operation, str3.substring(0, iIndexOf)));
            linkedList.add(new Diff(Operation.EQUAL, str4));
            linkedList.add(new Diff(operation, str3.substring(str4.length() + iIndexOf)));
            return linkedList;
        }
        if (str4.length() == 1) {
            linkedList.add(new Diff(Operation.DELETE, str));
            linkedList.add(new Diff(Operation.INSERT, str2));
            return linkedList;
        }
        String[] strArrDiffHalfMatch = diffHalfMatch(str, str2);
        if (strArrDiffHalfMatch == null) {
            return (!z || str.length() <= 100 || str2.length() <= 100) ? diffBisect(str, str2, j) : diffLineMode(str, str2, j);
        }
        String str5 = strArrDiffHalfMatch[0];
        String str6 = strArrDiffHalfMatch[1];
        String str7 = strArrDiffHalfMatch[2];
        String str8 = strArrDiffHalfMatch[3];
        String str9 = strArrDiffHalfMatch[4];
        LinkedList<Diff> linkedListDiffMain = diffMain(str5, str7, z, j);
        LinkedList<Diff> linkedListDiffMain2 = diffMain(str6, str8, z, j);
        linkedListDiffMain.add(new Diff(Operation.EQUAL, str9));
        linkedListDiffMain.addAll(linkedListDiffMain2);
        return linkedListDiffMain;
    }

    private String[] diffHalfMatchI(String str, String str2, int i) {
        String strSubstring = str.substring(i, (str.length() / 4) + i);
        int i2 = -1;
        String str3 = "";
        int iIndexOf = -1;
        String str4 = "";
        String str5 = str4;
        String str6 = str5;
        String strSubstring2 = str6;
        while (true) {
            iIndexOf = str2.indexOf(strSubstring, iIndexOf + 1);
            if (iIndexOf == i2) {
                break;
            }
            int iDiffCommonPrefix = diffCommonPrefix(str.substring(i), str2.substring(iIndexOf));
            int iDiffCommonSuffix = diffCommonSuffix(str.substring(0, i), str2.substring(0, iIndexOf));
            if (str3.length() < iDiffCommonSuffix + iDiffCommonPrefix) {
                StringBuilder sb = new StringBuilder();
                int i4 = iIndexOf - iDiffCommonSuffix;
                sb.append(str2.substring(i4, iIndexOf));
                int i5 = iIndexOf + iDiffCommonPrefix;
                sb.append(str2.substring(iIndexOf, i5));
                String string = sb.toString();
                String strSubstring3 = str.substring(0, i - iDiffCommonSuffix);
                String strSubstring4 = str.substring(i + iDiffCommonPrefix);
                String strSubstring5 = str2.substring(0, i4);
                strSubstring2 = str2.substring(i5);
                str4 = strSubstring3;
                str5 = strSubstring4;
                str6 = strSubstring5;
                str3 = string;
            }
            i2 = -1;
        }
        if (str3.length() * 2 >= str.length()) {
            return new String[]{str4, str5, str6, strSubstring2, str3};
        }
        return null;
    }

    private LinkedList<Diff> diffLineMode(String str, String str2, long j) {
        LinesToCharsResult linesToCharsResultDiffLinesToChars = diffLinesToChars(str, str2);
        String str3 = linesToCharsResultDiffLinesToChars.chars1;
        String str4 = linesToCharsResultDiffLinesToChars.chars2;
        List<String> list = linesToCharsResultDiffLinesToChars.lineArray;
        DiffMatchPatch diffMatchPatch = this;
        LinkedList<Diff> linkedListDiffMain = diffMatchPatch.diffMain(str3, str4, false, j);
        diffCharsToLines(linkedListDiffMain, list);
        diffCleanupSemantic(linkedListDiffMain);
        linkedListDiffMain.add(new Diff(Operation.EQUAL, ""));
        ListIterator<Diff> listIterator = linkedListDiffMain.listIterator();
        Diff next = listIterator.next();
        String string = "";
        String string2 = string;
        int i = 0;
        int i2 = 0;
        while (next != null) {
            int i4 = C141961.f10184x3fe1b310[next.operation.ordinal()];
            if (i4 == 1) {
                i++;
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                sbM1324q.append(next.text);
                string = sbM1324q.toString();
            } else if (i4 == 2) {
                i2++;
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string2);
                sbM1324q2.append(next.text);
                string2 = sbM1324q2.toString();
            } else if (i4 == 3) {
                if (i2 >= 1 && i >= 1) {
                    listIterator.previous();
                    for (int i5 = 0; i5 < i2 + i; i5++) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    Iterator<Diff> it = diffMatchPatch.diffMain(string2, string, false, j).iterator();
                    while (it.hasNext()) {
                        listIterator.add(it.next());
                    }
                }
                string = "";
                string2 = string;
                i = 0;
                i2 = 0;
            }
            next = listIterator.hasNext() ? listIterator.next() : null;
            diffMatchPatch = this;
        }
        linkedListDiffMain.removeLast();
        return linkedListDiffMain;
    }

    private String diffLinesToCharsMunge(String str, List<String> list, Map<String, Integer> map, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int iIndexOf = -1;
        while (iIndexOf < str.length() - 1) {
            iIndexOf = str.indexOf(10, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length() - 1;
            }
            String strSubstring = str.substring(i2, iIndexOf + 1);
            if (map.containsKey(strSubstring)) {
                sb.append(String.valueOf((char) map.get(strSubstring).intValue()));
            } else {
                if (list.size() == i) {
                    strSubstring = str.substring(i2);
                    iIndexOf = str.length();
                }
                list.add(strSubstring);
                map.put(strSubstring, Integer.valueOf(list.size() - 1));
                sb.append(String.valueOf((char) (list.size() - 1)));
            }
            i2 = iIndexOf + 1;
        }
        return sb.toString();
    }

    private double matchBitapScore(int i, int i2, int i4, String str) {
        float length = i / str.length();
        int iAbs = Math.abs(i4 - i2);
        if (this.matchDistance != 0) {
            return (iAbs / r3) + length;
        }
        if (iAbs == 0) {
            return length;
        }
        return 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unescapeForEncodeUriCompatability(String str) {
        return str.replace("%21", "!").replace("%7E", "~").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%3B", ";").replace("%2F", "/").replace("%3F", MsalUtils.QUERY_STRING_SYMBOL).replace("%3A", ":").replace("%40", Log.TAG_SEPARATOR).replace("%26", MsalUtils.QUERY_STRING_DELIMITER).replace("%3D", MarketingConstants.REFERRER_DELIMITER_U003D).replace("%2B", Marker.ANY_NON_NULL_MARKER).replace("%24", "$").replace("%2C", ",").replace("%23", ContentUtils.HASH_SYMBOL);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:29:0x0077
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public java.util.LinkedList<org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch.Diff> diffBisect(java.lang.String r26, java.lang.String r27, long r28) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch.diffBisect(java.lang.String, java.lang.String, long):java.util.LinkedList");
    }

    public void diffCharsToLines(List<Diff> list, List<String> list2) {
        for (Diff diff : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < diff.text.length(); i++) {
                sb.append(list2.get(diff.text.charAt(i)));
            }
            diff.text = sb.toString();
        }
    }

    public void diffCleanupEfficiency(LinkedList<Diff> linkedList) {
        int i;
        if (linkedList.isEmpty()) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.next();
        Diff diff = next;
        String str = null;
        boolean z = false;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (next != null) {
            Operation operation = next.operation;
            if (operation == Operation.EQUAL) {
                if (next.text.length() >= this.diffEditCost || (i2 == 0 && i4 == 0)) {
                    arrayDeque.clear();
                    str = null;
                    i2 = i5;
                    i4 = i6;
                } else {
                    arrayDeque.push(next);
                    str = next.text;
                    next = diff;
                }
                diff = next;
                i5 = i2;
                i6 = i4;
                i2 = 0;
                i4 = 0;
            } else {
                if (operation == Operation.DELETE) {
                    i4 = 1;
                } else {
                    i2 = 1;
                }
                if (str != null && ((i5 != 0 && i6 != 0 && i2 != 0 && i4 != 0) || (str.length() < this.diffEditCost / 2 && i5 + i6 + i2 + i4 == 3))) {
                    while (next != arrayDeque.peek()) {
                        next = listIterator.previous();
                    }
                    listIterator.next();
                    listIterator.set(new Diff(Operation.DELETE, str));
                    Diff diff2 = new Diff(Operation.INSERT, str);
                    listIterator.add(diff2);
                    arrayDeque.pop();
                    if (i5 == 0 || i6 == 0) {
                        if (!arrayDeque.isEmpty()) {
                            arrayDeque.pop();
                        }
                        while ((arrayDeque.isEmpty() ? diff : (Diff) arrayDeque.peek()) != listIterator.previous()) {
                        }
                        i = 0;
                    } else {
                        arrayDeque.clear();
                        diff = diff2;
                        i = 1;
                    }
                    i2 = i;
                    i4 = i2;
                    str = null;
                    z = true;
                }
            }
            next = listIterator.hasNext() ? listIterator.next() : null;
        }
        if (z) {
            diffCleanupMerge(linkedList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0155 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diffCleanupMerge(LinkedList<Diff> linkedList) {
        linkedList.add(new Diff(Operation.EQUAL, ""));
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.next();
        String string = "";
        String string2 = string;
        int i = 0;
        int i2 = 0;
        Diff diff = null;
        while (true) {
            if (next == null) {
                break;
            }
            int i4 = C141961.f10184x3fe1b310[next.operation.ordinal()];
            if (i4 == 1) {
                i++;
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                sbM1324q.append(next.text);
                string = sbM1324q.toString();
            } else if (i4 != 2) {
                if (i4 == 3) {
                    if (i2 + i > 1) {
                        boolean z = (i2 == 0 || i == 0) ? false : true;
                        listIterator.previous();
                        while (true) {
                            int i5 = i2 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            listIterator.previous();
                            listIterator.remove();
                            i2 = i5;
                        }
                        while (true) {
                            int i6 = i - 1;
                            if (i <= 0) {
                                break;
                            }
                            listIterator.previous();
                            listIterator.remove();
                            i = i6;
                        }
                        if (z) {
                            int iDiffCommonPrefix = diffCommonPrefix(string, string2);
                            if (iDiffCommonPrefix != 0) {
                                if (listIterator.hasPrevious()) {
                                    listIterator.previous().text += string.substring(0, iDiffCommonPrefix);
                                    listIterator.next();
                                } else {
                                    listIterator.add(new Diff(Operation.EQUAL, string.substring(0, iDiffCommonPrefix)));
                                }
                                string = string.substring(iDiffCommonPrefix);
                                string2 = string2.substring(iDiffCommonPrefix);
                            }
                            int iDiffCommonSuffix = diffCommonSuffix(string, string2);
                            if (iDiffCommonSuffix != 0) {
                                Diff next2 = listIterator.next();
                                next2.text = string.substring(string.length() - iDiffCommonSuffix) + next2.text;
                                string = AbstractC2322a.m1614d(iDiffCommonSuffix, 0, string);
                                string2 = string2.substring(0, string2.length() - iDiffCommonSuffix);
                                listIterator.previous();
                            }
                        }
                        if (string2.length() != 0) {
                            listIterator.add(new Diff(Operation.DELETE, string2));
                        }
                        if (string.length() != 0) {
                            listIterator.add(new Diff(Operation.INSERT, string));
                        }
                        next = listIterator.hasNext() ? listIterator.next() : null;
                    } else if (diff != null) {
                        diff.text += next.text;
                        listIterator.remove();
                        next = listIterator.previous();
                        listIterator.next();
                    }
                    diff = next;
                    string = "";
                    string2 = string;
                    i = 0;
                    i2 = 0;
                }
                next = !listIterator.hasNext() ? listIterator.next() : null;
            } else {
                i2++;
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string2);
                sbM1324q2.append(next.text);
                string2 = sbM1324q2.toString();
            }
            diff = null;
            if (!listIterator.hasNext()) {
            }
        }
        if (linkedList.getLast().text.length() == 0) {
            linkedList.removeLast();
        }
        ListIterator<Diff> listIterator2 = linkedList.listIterator();
        Diff next3 = listIterator2.hasNext() ? listIterator2.next() : null;
        Diff next4 = listIterator2.hasNext() ? listIterator2.next() : null;
        Diff next5 = listIterator2.hasNext() ? listIterator2.next() : null;
        boolean z2 = false;
        while (next5 != null) {
            Operation operation = next3.operation;
            Operation operation2 = Operation.EQUAL;
            if (operation == operation2 && next5.operation == operation2) {
                if (next4.text.endsWith(next3.text)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(next3.text);
                    String str = next4.text;
                    sb.append(str.substring(0, str.length() - next3.text.length()));
                    next4.text = sb.toString();
                    next5.text = next3.text + next5.text;
                    listIterator2.previous();
                    listIterator2.previous();
                    listIterator2.previous();
                    listIterator2.remove();
                    listIterator2.next();
                    next3 = listIterator2.next();
                    next4 = listIterator2.hasNext() ? listIterator2.next() : null;
                } else {
                    if (next4.text.startsWith(next5.text)) {
                        next3.text += next5.text;
                        next4.text = next4.text.substring(next5.text.length()) + next5.text;
                        listIterator2.remove();
                        Diff diff2 = next4;
                        next4 = listIterator2.hasNext() ? listIterator2.next() : null;
                        next3 = diff2;
                    }
                    next3 = next4;
                    next4 = next5;
                }
                z2 = true;
            } else {
                next3 = next4;
                next4 = next5;
            }
            next5 = listIterator2.hasNext() ? listIterator2.next() : null;
        }
        if (z2) {
            diffCleanupMerge(linkedList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ea, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diffCleanupSemantic(LinkedList<Diff> linkedList) {
        Diff next;
        Diff next2;
        if (linkedList.isEmpty()) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next3 = listIterator.next();
        String str = null;
        boolean z = false;
        int length = 0;
        int length2 = 0;
        int i = 0;
        int i2 = 0;
        while (next3 != null) {
            Operation operation = next3.operation;
            if (operation == Operation.EQUAL) {
                arrayDeque.push(next3);
                str = next3.text;
                i = length;
                i2 = length2;
                length = 0;
                length2 = 0;
            } else {
                if (operation == Operation.INSERT) {
                    length += next3.text.length();
                } else {
                    length2 += next3.text.length();
                }
                if (str != null && str.length() <= Math.max(i, i2) && str.length() <= Math.max(length, length2)) {
                    while (next3 != arrayDeque.peek()) {
                        next3 = listIterator.previous();
                    }
                    listIterator.next();
                    listIterator.set(new Diff(Operation.DELETE, str));
                    listIterator.add(new Diff(Operation.INSERT, str));
                    arrayDeque.pop();
                    if (!arrayDeque.isEmpty()) {
                        arrayDeque.pop();
                    }
                    if (arrayDeque.isEmpty()) {
                        while (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    } else {
                        while (((Diff) arrayDeque.peek()) != listIterator.previous()) {
                        }
                    }
                    z = true;
                    str = null;
                    length = 0;
                    length2 = 0;
                    i = 0;
                    i2 = 0;
                }
            }
            next3 = listIterator.hasNext() ? listIterator.next() : null;
        }
        if (z) {
            diffCleanupMerge(linkedList);
        }
        diffCleanupSemanticLossless(linkedList);
        ListIterator<Diff> listIterator2 = linkedList.listIterator();
        if (listIterator2.hasNext()) {
            next = listIterator2.next();
            if (listIterator2.hasNext()) {
                next2 = listIterator2.next();
            }
        } else {
            next = null;
            next2 = null;
        }
        while (next2 != null) {
            Operation operation2 = next.operation;
            Operation operation3 = Operation.DELETE;
            if (operation2 == operation3) {
                Operation operation4 = next2.operation;
                Operation operation5 = Operation.INSERT;
                if (operation4 == operation5) {
                    String str2 = next.text;
                    String str3 = next2.text;
                    int iDiffCommonOverlap = diffCommonOverlap(str2, str3);
                    int iDiffCommonOverlap2 = diffCommonOverlap(str3, str2);
                    if (iDiffCommonOverlap >= iDiffCommonOverlap2) {
                        double d = iDiffCommonOverlap;
                        if (d >= ((double) str2.length()) / 2.0d || d >= ((double) str3.length()) / 2.0d) {
                            listIterator2.previous();
                            listIterator2.add(new Diff(Operation.EQUAL, str3.substring(0, iDiffCommonOverlap)));
                            next.text = str2.substring(0, str2.length() - iDiffCommonOverlap);
                            next2.text = str3.substring(iDiffCommonOverlap);
                        }
                    } else {
                        double d2 = iDiffCommonOverlap2;
                        if (d2 >= ((double) str2.length()) / 2.0d || d2 >= ((double) str3.length()) / 2.0d) {
                            listIterator2.previous();
                            listIterator2.add(new Diff(Operation.EQUAL, str2.substring(0, iDiffCommonOverlap2)));
                            next.operation = operation5;
                            next.text = AbstractC2322a.m1614d(iDiffCommonOverlap2, 0, str3);
                            next2.operation = operation3;
                            next2.text = str2.substring(iDiffCommonOverlap2);
                        }
                    }
                    next = listIterator2.hasNext() ? listIterator2.next() : null;
                } else {
                    next = next2;
                }
            }
            next2 = listIterator2.hasNext() ? listIterator2.next() : null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x002f, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diffCleanupSemanticLossless(LinkedList<Diff> linkedList) {
        Diff next;
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next2 = listIterator.hasNext() ? listIterator.next() : null;
        Diff next3 = listIterator.hasNext() ? listIterator.next() : null;
        if (listIterator.hasNext()) {
            next = listIterator.next();
            while (next != null) {
                Operation operation = next2.operation;
                Operation operation2 = Operation.EQUAL;
                if (operation == operation2 && next.operation == operation2) {
                    String strM1614d = next2.text;
                    String string = next3.text;
                    String strM756B = next.text;
                    int iDiffCommonSuffix = diffCommonSuffix(strM1614d, string);
                    if (iDiffCommonSuffix != 0) {
                        String strSubstring = string.substring(string.length() - iDiffCommonSuffix);
                        strM1614d = AbstractC2322a.m1614d(iDiffCommonSuffix, 0, strM1614d);
                        StringBuilder sbM1324q = AbstractC1974b.m1324q(strSubstring);
                        sbM1324q.append(string.substring(0, string.length() - iDiffCommonSuffix));
                        string = sbM1324q.toString();
                        strM756B = AbstractC0541b.m756B(strSubstring, strM756B);
                    }
                    String strSubstring2 = strM756B;
                    String str = strSubstring2;
                    int iDiffCleanupSemanticScore = diffCleanupSemanticScore(strM1614d, string) + diffCleanupSemanticScore(string, strM756B);
                    String str2 = string;
                    String str3 = str2;
                    String string2 = strM1614d;
                    while (str2.length() != 0 && strSubstring2.length() != 0 && str2.charAt(0) == strSubstring2.charAt(0)) {
                        StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string2);
                        sbM1324q2.append(str2.charAt(0));
                        string2 = sbM1324q2.toString();
                        str2 = str2.substring(1) + strSubstring2.charAt(0);
                        strSubstring2 = strSubstring2.substring(1);
                        int iDiffCleanupSemanticScore2 = diffCleanupSemanticScore(string2, str2) + diffCleanupSemanticScore(str2, strSubstring2);
                        if (iDiffCleanupSemanticScore2 >= iDiffCleanupSemanticScore) {
                            strM1614d = string2;
                            str3 = str2;
                            str = strSubstring2;
                            iDiffCleanupSemanticScore = iDiffCleanupSemanticScore2;
                        }
                    }
                    if (!next2.text.equals(strM1614d)) {
                        if (strM1614d.length() != 0) {
                            next2.text = strM1614d;
                        } else {
                            listIterator.previous();
                            listIterator.previous();
                            listIterator.previous();
                            listIterator.remove();
                            listIterator.next();
                            listIterator.next();
                        }
                        next3.text = str3;
                        if (str.length() != 0) {
                            next.text = str;
                            next2 = next3;
                            next3 = next;
                        } else {
                            listIterator.remove();
                        }
                    }
                } else {
                    next2 = next3;
                    next3 = next;
                }
                if (listIterator.hasNext()) {
                    next = listIterator.next();
                }
            }
            return;
        }
        next = null;
    }

    public int diffCommonOverlap(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0 || length2 == 0) {
            return 0;
        }
        if (length > length2) {
            str = str.substring(length - length2);
        } else if (length < length2) {
            str2 = str2.substring(0, length);
        }
        int iMin = Math.min(length, length2);
        if (str.equals(str2)) {
            return iMin;
        }
        int i = 1;
        int i2 = 0;
        while (true) {
            int iIndexOf = str2.indexOf(str.substring(iMin - i));
            if (iIndexOf == -1) {
                return i2;
            }
            i += iIndexOf;
            if (iIndexOf == 0 || str.substring(iMin - i).equals(str2.substring(0, i))) {
                i2 = i;
                i++;
            }
        }
    }

    public int diffCommonPrefix(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 0; i < iMin; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return iMin;
    }

    public int diffCommonSuffix(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int iMin = Math.min(length, length2);
        for (int i = 1; i <= iMin; i++) {
            if (str.charAt(length - i) != str2.charAt(length2 - i)) {
                return i - 1;
            }
        }
        return iMin;
    }

    public LinkedList<Diff> diffFromDelta(String str, String str2) {
        LinkedList<Diff> linkedList = new LinkedList<>();
        int i = 0;
        for (String str3 : str2.split("\t")) {
            if (str3.length() != 0) {
                String strSubstring = str3.substring(1);
                char cCharAt = str3.charAt(0);
                if (cCharAt == '+') {
                    String strReplace = strSubstring.replace(Marker.ANY_NON_NULL_MARKER, "%2B");
                    try {
                        linkedList.add(new Diff(Operation.INSERT, URLDecoder.decode(strReplace, "UTF-8")));
                    } catch (UnsupportedEncodingException e) {
                        throw new Error("This system does not support UTF-8.", e);
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalArgumentException(AbstractC0541b.m772n("Illegal escape in diffFromDelta: ", strReplace), e2);
                    }
                } else {
                    if (cCharAt != '-' && cCharAt != '=') {
                        throw new IllegalArgumentException("Invalid diff operation in diffFromDelta: " + str3.charAt(0));
                    }
                    try {
                        int i2 = Integer.parseInt(strSubstring);
                        if (i2 < 0) {
                            throw new IllegalArgumentException(AbstractC0541b.m772n("Negative number in diffFromDelta: ", strSubstring));
                        }
                        int i4 = i2 + i;
                        try {
                            String strSubstring2 = str.substring(i, i4);
                            if (str3.charAt(0) == '=') {
                                linkedList.add(new Diff(Operation.EQUAL, strSubstring2));
                            } else {
                                linkedList.add(new Diff(Operation.DELETE, strSubstring2));
                            }
                            i = i4;
                        } catch (StringIndexOutOfBoundsException e3) {
                            StringBuilder sbM778t = AbstractC0541b.m778t(i4, "Delta length (", ") larger than source text length (");
                            sbM778t.append(str.length());
                            sbM778t.append(").");
                            throw new IllegalArgumentException(sbM778t.toString(), e3);
                        }
                    } catch (NumberFormatException e5) {
                        throw new IllegalArgumentException(AbstractC0541b.m772n("Invalid number in diffFromDelta: ", strSubstring), e5);
                    }
                }
            }
        }
        if (i == str.length()) {
            return linkedList;
        }
        StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "Delta length (", ") smaller than source text length (");
        sbM778t2.append(str.length());
        sbM778t2.append(").");
        throw new IllegalArgumentException(sbM778t2.toString());
    }

    public String[] diffHalfMatch(String str, String str2) {
        if (this.diffTimeout <= 0.0f) {
            return null;
        }
        String str3 = str.length() > str2.length() ? str : str2;
        String str4 = str.length() > str2.length() ? str2 : str;
        if (str3.length() < 4 || str4.length() * 2 < str3.length()) {
            return null;
        }
        String[] strArrDiffHalfMatchI = diffHalfMatchI(str3, str4, (str3.length() + 3) / 4);
        String[] strArrDiffHalfMatchI2 = diffHalfMatchI(str3, str4, (str3.length() + 1) / 2);
        if (strArrDiffHalfMatchI == null && strArrDiffHalfMatchI2 == null) {
            return null;
        }
        if (strArrDiffHalfMatchI2 != null && (strArrDiffHalfMatchI == null || strArrDiffHalfMatchI[4].length() <= strArrDiffHalfMatchI2[4].length())) {
            strArrDiffHalfMatchI = strArrDiffHalfMatchI2;
        }
        return str.length() > str2.length() ? strArrDiffHalfMatchI : new String[]{strArrDiffHalfMatchI[2], strArrDiffHalfMatchI[3], strArrDiffHalfMatchI[0], strArrDiffHalfMatchI[1], strArrDiffHalfMatchI[4]};
    }

    public int diffLevenshtein(List<Diff> list) {
        int iMax = 0;
        int length = 0;
        while (true) {
            int length2 = length;
            for (Diff diff : list) {
                int i = C141961.f10184x3fe1b310[diff.operation.ordinal()];
                if (i == 1) {
                    length += diff.text.length();
                } else if (i == 2) {
                    length2 += diff.text.length();
                } else if (i != 3) {
                }
            }
            return Math.max(length, length2) + iMax;
            iMax += Math.max(length, length2);
            length = 0;
        }
    }

    public LinesToCharsResult diffLinesToChars(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        arrayList.add("");
        return new LinesToCharsResult(diffLinesToCharsMunge(str, arrayList, map, 40000), diffLinesToCharsMunge(str2, arrayList, map, 65535), arrayList);
    }

    public LinkedList<Diff> diffMain(String str, String str2) {
        return diffMain(str, str2, true);
    }

    public String diffPrettyHtml(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            String strReplace = diff.text.replace(MsalUtils.QUERY_STRING_DELIMITER, "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "&para;<br>");
            int i = C141961.f10184x3fe1b310[diff.operation.ordinal()];
            if (i == 1) {
                AbstractC1974b.m1332y(sb, "<ins style=\"background:#e6ffe6;\">", strReplace, "</ins>");
            } else if (i == 2) {
                AbstractC1974b.m1332y(sb, "<del style=\"background:#ffe6e6;\">", strReplace, "</del>");
            } else if (i == 3) {
                AbstractC1974b.m1332y(sb, "<span>", strReplace, "</span>");
            }
        }
        return sb.toString();
    }

    public String diffText1(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            if (diff.operation != Operation.INSERT) {
                sb.append(diff.text);
            }
        }
        return sb.toString();
    }

    public String diffText2(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            if (diff.operation != Operation.DELETE) {
                sb.append(diff.text);
            }
        }
        return sb.toString();
    }

    public String diffToDelta(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            int i = C141961.f10184x3fe1b310[diff.operation.ordinal()];
            if (i == 1) {
                try {
                    sb.append(Marker.ANY_NON_NULL_MARKER);
                    sb.append(URLEncoder.encode(diff.text, "UTF-8").replace('+', ' '));
                    sb.append("\t");
                } catch (UnsupportedEncodingException e) {
                    throw new Error("This system does not support UTF-8.", e);
                }
            } else if (i == 2) {
                sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                sb.append(diff.text.length());
                sb.append("\t");
            } else if (i == 3) {
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(diff.text.length());
                sb.append("\t");
            }
        }
        String string = sb.toString();
        return string.length() != 0 ? unescapeForEncodeUriCompatability(AbstractC2322a.m1614d(1, 0, string)) : string;
    }

    public int diffXIndex(List<Diff> list, int i) {
        Diff next;
        Iterator<Diff> it = list.iterator();
        int length = 0;
        int length2 = 0;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.operation != Operation.INSERT) {
                length = next.text.length() + length;
            }
            if (next.operation != Operation.DELETE) {
                length2 = next.text.length() + length2;
            }
            if (length > i) {
                break;
            }
            i2 = length;
            i4 = length2;
        }
        return (next == null || next.operation != Operation.DELETE) ? (i - i2) + i4 : i4;
    }

    public Map<Character, Integer> matchAlphabet(String str) {
        HashMap map = new HashMap();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            map.put(Character.valueOf(c), 0);
        }
        int i = 0;
        for (char c2 : charArray) {
            map.put(Character.valueOf(c2), Integer.valueOf(((Integer) map.get(Character.valueOf(c2))).intValue() | (1 << ((str.length() - i) - 1))));
            i++;
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int matchBitap(String str, String str2, int i) {
        Map<Character, Integer> mapMatchAlphabet = matchAlphabet(str2);
        double dMin = this.matchThreshold;
        int iIndexOf = str.indexOf(str2, i);
        int i2 = 0;
        int i4 = -1;
        if (iIndexOf != -1) {
            dMin = Math.min(matchBitapScore(0, iIndexOf, i, str2), dMin);
            int iLastIndexOf = str.lastIndexOf(str2, str2.length() + i);
            if (iLastIndexOf != -1) {
                dMin = Math.min(matchBitapScore(0, iLastIndexOf, i, str2), dMin);
            }
        }
        int i5 = 1;
        int length = 1 << (str2.length() - 1);
        int length2 = str.length() + str2.length();
        int[] iArr = new int[0];
        int i6 = 0;
        while (i6 < str2.length()) {
            int i7 = i2;
            int i8 = length2;
            while (i7 < length2) {
                if (matchBitapScore(i6, i + length2, i, str2) <= dMin) {
                    i7 = length2;
                } else {
                    i8 = length2;
                }
                length2 = AbstractC0000a.m7d(i8, i7, 2, i7);
            }
            int iMax = Math.max(i5, (i - length2) + i5);
            int length3 = str2.length() + Math.min(i + length2, str.length());
            int[] iArr2 = new int[length3 + 2];
            iArr2[length3 + 1] = (i5 << i6) - 1;
            while (true) {
                if (length3 < iMax) {
                    break;
                }
                int i9 = i5;
                double d = dMin;
                int i10 = length3 - 1;
                int iIntValue = (str.length() <= i10 || !mapMatchAlphabet.containsKey(Character.valueOf(str.charAt(i10)))) ? 0 : mapMatchAlphabet.get(Character.valueOf(str.charAt(i10))).intValue();
                if (i6 == 0) {
                    iArr2[length3] = iIntValue & ((iArr2[length3 + 1] << 1) | 1);
                } else {
                    int i11 = length3 + 1;
                    int i12 = ((iArr2[i11] << 1) | 1) & iIntValue;
                    int i13 = iArr[i11];
                    iArr2[length3] = i12 | ((i13 | iArr[length3]) << 1) | 1 | i13;
                }
                if ((iArr2[length3] & length) != 0) {
                    double dMatchBitapScore = matchBitapScore(i6, i10, i, str2);
                    if (dMatchBitapScore > d) {
                        i5 = i9;
                        dMin = d;
                    } else {
                        if (i10 <= i) {
                            i5 = i9;
                            i4 = i10;
                            dMin = dMatchBitapScore;
                            break;
                        }
                        i5 = i9;
                        i4 = i10;
                        iMax = Math.max(i5, (i * 2) - i10);
                        dMin = dMatchBitapScore;
                    }
                }
                length3--;
            }
            i6++;
            if (matchBitapScore(i6, i, i, str2) > dMin) {
                return i4;
            }
            iArr = iArr2;
            i2 = 0;
        }
        return i4;
    }

    public int matchMain(String str, String str2, int i) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Null inputs. (matchMain)");
        }
        int iMax = Math.max(0, Math.min(i, str.length()));
        if (str.equals(str2)) {
            return 0;
        }
        if (str.length() == 0) {
            return -1;
        }
        return (str2.length() + iMax > str.length() || !str.substring(iMax, str2.length() + iMax).equals(str2)) ? matchBitap(str, str2, iMax) : iMax;
    }

    public void patchAddContext(Patch patch, String str) {
        if (str.length() == 0) {
            return;
        }
        int i = patch.start2;
        String strSubstring = str.substring(i, patch.length1 + i);
        int i2 = 0;
        while (str.indexOf(strSubstring) != str.lastIndexOf(strSubstring)) {
            int length = strSubstring.length();
            short s = this.patchMargin;
            if (length >= (32 - s) - s) {
                break;
            }
            i2 += s;
            strSubstring = str.substring(Math.max(0, patch.start2 - i2), Math.min(str.length(), patch.start2 + patch.length1 + i2));
        }
        int i4 = i2 + this.patchMargin;
        String strSubstring2 = str.substring(Math.max(0, patch.start2 - i4), patch.start2);
        if (strSubstring2.length() != 0) {
            patch.diffs.addFirst(new Diff(Operation.EQUAL, strSubstring2));
        }
        String strSubstring3 = str.substring(patch.start2 + patch.length1, Math.min(str.length(), patch.start2 + patch.length1 + i4));
        if (strSubstring3.length() != 0) {
            patch.diffs.addLast(new Diff(Operation.EQUAL, strSubstring3));
        }
        patch.start1 -= strSubstring2.length();
        patch.start2 -= strSubstring2.length();
        patch.length1 = AbstractC2821a.m2212c(strSubstring2.length(), patch.length1, strSubstring3);
        patch.length2 = AbstractC2821a.m2212c(strSubstring2.length(), patch.length2, strSubstring3);
    }

    public String patchAddPadding(LinkedList<Patch> linkedList) {
        short s = this.patchMargin;
        String string = "";
        for (short s2 = 1; s2 <= s; s2 = (short) (s2 + 1)) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(String.valueOf((char) s2));
            string = sbM1324q.toString();
        }
        for (Patch patch : linkedList) {
            patch.start1 += s;
            patch.start2 += s;
        }
        Patch first = linkedList.getFirst();
        LinkedList<Diff> linkedList2 = first.diffs;
        if (linkedList2.isEmpty() || linkedList2.getFirst().operation != Operation.EQUAL) {
            linkedList2.addFirst(new Diff(Operation.EQUAL, string));
            first.start1 -= s;
            first.start2 -= s;
            first.length1 += s;
            first.length2 += s;
        } else if (s > linkedList2.getFirst().text.length()) {
            Diff first2 = linkedList2.getFirst();
            int length = s - first2.text.length();
            first2.text = string.substring(first2.text.length()) + first2.text;
            first.start1 = first.start1 - length;
            first.start2 = first.start2 - length;
            first.length1 = first.length1 + length;
            first.length2 += length;
        }
        Patch last = linkedList.getLast();
        LinkedList<Diff> linkedList3 = last.diffs;
        if (linkedList3.isEmpty() || linkedList3.getLast().operation != Operation.EQUAL) {
            linkedList3.addLast(new Diff(Operation.EQUAL, string));
            last.length1 += s;
            last.length2 += s;
            return string;
        }
        if (s > linkedList3.getLast().text.length()) {
            Diff last2 = linkedList3.getLast();
            int length2 = s - last2.text.length();
            last2.text += string.substring(0, length2);
            last.length1 += length2;
            last.length2 += length2;
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object[] patchApply(LinkedList<Patch> linkedList, String str) {
        int iMatchMain;
        int iMatchMain2;
        if (linkedList.isEmpty()) {
            return new Object[]{str, new boolean[0]};
        }
        LinkedList<Patch> linkedListPatchDeepCopy = patchDeepCopy(linkedList);
        String strPatchAddPadding = patchAddPadding(linkedListPatchDeepCopy);
        String strM3198h = strPatchAddPadding + str + strPatchAddPadding;
        patchSplitMax(linkedListPatchDeepCopy);
        boolean[] zArr = new boolean[linkedListPatchDeepCopy.size()];
        int i = 0;
        int i2 = 0;
        for (Patch patch : linkedListPatchDeepCopy) {
            int i4 = patch.start2 + i;
            String strDiffText1 = diffText1(patch.diffs);
            if (strDiffText1.length() > 32) {
                iMatchMain = matchMain(strM3198h, strDiffText1.substring(0, 32), i4);
                if (iMatchMain != -1) {
                    iMatchMain2 = matchMain(strM3198h, strDiffText1.substring(strDiffText1.length() - 32), (strDiffText1.length() + i4) - 32);
                    if (iMatchMain2 == -1 || iMatchMain >= iMatchMain2) {
                        iMatchMain = -1;
                    }
                }
                if (iMatchMain != -1) {
                    zArr[i2] = false;
                    i -= patch.length2 - patch.length1;
                } else {
                    zArr[i2] = true;
                    i = iMatchMain - i4;
                    String strSubstring = iMatchMain2 == -1 ? strM3198h.substring(iMatchMain, Math.min(strDiffText1.length() + iMatchMain, strM3198h.length())) : strM3198h.substring(iMatchMain, Math.min(iMatchMain2 + 32, strM3198h.length()));
                    if (strDiffText1.equals(strSubstring)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strM3198h.substring(0, iMatchMain));
                        sb.append(diffText2(patch.diffs));
                        strM3198h = AbstractC4539a.m3198h(sb, strM3198h, strDiffText1.length() + iMatchMain);
                    } else {
                        LinkedList<Diff> linkedListDiffMain = diffMain(strDiffText1, strSubstring, false);
                        if (strDiffText1.length() <= 32 || diffLevenshtein(linkedListDiffMain) / strDiffText1.length() <= this.patchDeleteThreshold) {
                            diffCleanupSemanticLossless(linkedListDiffMain);
                            int length = 0;
                            for (Diff diff : patch.diffs) {
                                if (diff.operation != Operation.EQUAL) {
                                    int iDiffXIndex = diffXIndex(linkedListDiffMain, length);
                                    Operation operation = diff.operation;
                                    if (operation == Operation.INSERT) {
                                        StringBuilder sb2 = new StringBuilder();
                                        int i5 = iDiffXIndex + iMatchMain;
                                        sb2.append(strM3198h.substring(0, i5));
                                        sb2.append(diff.text);
                                        sb2.append(strM3198h.substring(i5));
                                        strM3198h = sb2.toString();
                                    } else if (operation == Operation.DELETE) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(strM3198h.substring(0, iDiffXIndex + iMatchMain));
                                        strM3198h = AbstractC4539a.m3198h(sb3, strM3198h, diffXIndex(linkedListDiffMain, diff.text.length() + length) + iMatchMain);
                                    }
                                }
                                if (diff.operation != Operation.DELETE) {
                                    length += diff.text.length();
                                }
                            }
                        } else {
                            zArr[i2] = false;
                        }
                    }
                }
                i2++;
            } else {
                iMatchMain = matchMain(strM3198h, strDiffText1, i4);
            }
            iMatchMain2 = -1;
            if (iMatchMain != -1) {
            }
            i2++;
        }
        return new Object[]{strM3198h.substring(strPatchAddPadding.length(), strM3198h.length() - strPatchAddPadding.length()), zArr};
    }

    public LinkedList<Patch> patchDeepCopy(LinkedList<Patch> linkedList) {
        LinkedList<Patch> linkedList2 = new LinkedList<>();
        for (Patch patch : linkedList) {
            Patch patch2 = new Patch();
            for (Diff diff : patch.diffs) {
                patch2.diffs.add(new Diff(diff.operation, diff.text));
            }
            patch2.start1 = patch.start1;
            patch2.start2 = patch.start2;
            patch2.length1 = patch.length1;
            patch2.length2 = patch.length2;
            linkedList2.add(patch2);
        }
        return linkedList2;
    }

    public List<Patch> patchFromText(String str) {
        char cCharAt;
        String strReplace;
        LinkedList linkedList = new LinkedList();
        if (str.length() != 0) {
            LinkedList linkedList2 = new LinkedList(Arrays.asList(str.split("\n")));
            Pattern patternCompile = Pattern.compile("^@@ -(\\d+),?(\\d*) \\+(\\d+),?(\\d*) @@$");
            while (!linkedList2.isEmpty()) {
                Matcher matcher = patternCompile.matcher((CharSequence) linkedList2.getFirst());
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid patch string: " + ((String) linkedList2.getFirst()));
                }
                Patch patch = new Patch();
                linkedList.add(patch);
                patch.start1 = Integer.parseInt(matcher.group(1));
                if (matcher.group(2).length() == 0) {
                    patch.start1--;
                    patch.length1 = 1;
                } else if (matcher.group(2).equals("0")) {
                    patch.length1 = 0;
                } else {
                    patch.start1--;
                    patch.length1 = Integer.parseInt(matcher.group(2));
                }
                patch.start2 = Integer.parseInt(matcher.group(3));
                if (matcher.group(4).length() == 0) {
                    patch.start2--;
                    patch.length2 = 1;
                } else if (matcher.group(4).equals("0")) {
                    patch.length2 = 0;
                } else {
                    patch.start2--;
                    patch.length2 = Integer.parseInt(matcher.group(4));
                }
                linkedList2.removeFirst();
                while (true) {
                    if (!linkedList2.isEmpty()) {
                        try {
                            cCharAt = ((String) linkedList2.getFirst()).charAt(0);
                            strReplace = ((String) linkedList2.getFirst()).substring(1).replace(Marker.ANY_NON_NULL_MARKER, "%2B");
                        } catch (IndexOutOfBoundsException unused) {
                            linkedList2.removeFirst();
                        }
                        try {
                            String strDecode = URLDecoder.decode(strReplace, "UTF-8");
                            if (cCharAt == '-') {
                                patch.diffs.add(new Diff(Operation.DELETE, strDecode));
                            } else if (cCharAt == '+') {
                                patch.diffs.add(new Diff(Operation.INSERT, strDecode));
                            } else if (cCharAt == ' ') {
                                patch.diffs.add(new Diff(Operation.EQUAL, strDecode));
                            } else if (cCharAt != '@') {
                                throw new IllegalArgumentException("Invalid patch mode '" + cCharAt + "' in: " + strDecode);
                            }
                            linkedList2.removeFirst();
                        } catch (UnsupportedEncodingException e) {
                            throw new Error("This system does not support UTF-8.", e);
                        } catch (IllegalArgumentException e2) {
                            throw new IllegalArgumentException(AbstractC0541b.m772n("Illegal escape in patchFromText: ", strReplace), e2);
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public LinkedList<Patch> patchMake(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Null inputs. (patchMake)");
        }
        LinkedList<Diff> linkedListDiffMain = diffMain(str, str2, true);
        if (linkedListDiffMain.size() > 2) {
            diffCleanupSemantic(linkedListDiffMain);
            diffCleanupEfficiency(linkedListDiffMain);
        }
        return patchMake(str, linkedListDiffMain);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0012 -> B:6:0x0013). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void patchSplitMax(LinkedList<Patch> linkedList) {
        ListIterator<Patch> listIterator = linkedList.listIterator();
        Patch next = listIterator.hasNext() ? listIterator.next() : null;
        while (next != null) {
            if (next.length1 > 32) {
                listIterator.remove();
                int length = next.start1;
                int length2 = next.start2;
                String strSubstring = "";
                while (!next.diffs.isEmpty()) {
                    Patch patch = new Patch();
                    patch.start1 = length - strSubstring.length();
                    patch.start2 = length2 - strSubstring.length();
                    if (strSubstring.length() != 0) {
                        int length3 = strSubstring.length();
                        patch.length2 = length3;
                        patch.length1 = length3;
                        patch.diffs.add(new Diff(Operation.EQUAL, strSubstring));
                    }
                    boolean z = true;
                    while (!next.diffs.isEmpty() && patch.length1 < 32 - this.patchMargin) {
                        Operation operation = next.diffs.getFirst().operation;
                        String str = next.diffs.getFirst().text;
                        if (operation == Operation.INSERT) {
                            patch.length2 = str.length() + patch.length2;
                            length2 += str.length();
                            patch.diffs.addLast(next.diffs.removeFirst());
                        } else if (operation == Operation.DELETE && patch.diffs.size() == 1 && patch.diffs.getFirst().operation == Operation.EQUAL && str.length() > 64) {
                            patch.length1 = str.length() + patch.length1;
                            length += str.length();
                            patch.diffs.add(new Diff(operation, str));
                            next.diffs.removeFirst();
                        } else {
                            String strSubstring2 = str.substring(0, Math.min(str.length(), (32 - patch.length1) - this.patchMargin));
                            patch.length1 = strSubstring2.length() + patch.length1;
                            length += strSubstring2.length();
                            if (operation == Operation.EQUAL) {
                                patch.length2 = strSubstring2.length() + patch.length2;
                                length2 += strSubstring2.length();
                            } else {
                                z = false;
                            }
                            patch.diffs.add(new Diff(operation, strSubstring2));
                            if (strSubstring2.equals(next.diffs.getFirst().text)) {
                                next.diffs.removeFirst();
                            } else {
                                next.diffs.getFirst().text = next.diffs.getFirst().text.substring(strSubstring2.length());
                            }
                        }
                        z = false;
                    }
                    String strDiffText2 = diffText2(patch.diffs);
                    strSubstring = strDiffText2.substring(Math.max(0, strDiffText2.length() - this.patchMargin));
                    String strSubstring3 = diffText1(next.diffs).length() > this.patchMargin ? diffText1(next.diffs).substring(0, this.patchMargin) : diffText1(next.diffs);
                    if (strSubstring3.length() != 0) {
                        patch.length1 = strSubstring3.length() + patch.length1;
                        patch.length2 = strSubstring3.length() + patch.length2;
                        if (patch.diffs.isEmpty() || patch.diffs.getLast().operation != Operation.EQUAL) {
                            patch.diffs.add(new Diff(Operation.EQUAL, strSubstring3));
                        } else {
                            StringBuilder sb = new StringBuilder();
                            Diff last = patch.diffs.getLast();
                            last.text = AbstractC0622a.m1170p(last.text, strSubstring3, sb);
                        }
                    }
                    if (!z) {
                        listIterator.add(patch);
                    }
                }
                if (listIterator.hasNext()) {
                    next = listIterator.next();
                }
            } else if (listIterator.hasNext()) {
                next = listIterator.next();
            }
            while (next != null) {
            }
        }
    }

    public String patchToText(List<Patch> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Patch> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public LinkedList<Diff> diffMain(String str, String str2, boolean z) {
        return diffMain(str, str2, z, this.diffTimeout <= 0.0f ? Long.MAX_VALUE : System.currentTimeMillis() + ((long) (this.diffTimeout * 1000.0f)));
    }

    private LinkedList<Diff> diffMain(String str, String str2, boolean z, long j) {
        if (str != null && str2 != null) {
            if (str.equals(str2)) {
                LinkedList<Diff> linkedList = new LinkedList<>();
                if (str.length() != 0) {
                    linkedList.add(new Diff(Operation.EQUAL, str));
                }
                return linkedList;
            }
            int iDiffCommonPrefix = diffCommonPrefix(str, str2);
            String strSubstring = str.substring(0, iDiffCommonPrefix);
            String strSubstring2 = str.substring(iDiffCommonPrefix);
            String strSubstring3 = str2.substring(iDiffCommonPrefix);
            int iDiffCommonSuffix = diffCommonSuffix(strSubstring2, strSubstring3);
            String strSubstring4 = strSubstring2.substring(strSubstring2.length() - iDiffCommonSuffix);
            LinkedList<Diff> linkedListDiffCompute = diffCompute(AbstractC2322a.m1614d(iDiffCommonSuffix, 0, strSubstring2), AbstractC2322a.m1614d(iDiffCommonSuffix, 0, strSubstring3), z, j);
            if (strSubstring.length() != 0) {
                linkedListDiffCompute.addFirst(new Diff(Operation.EQUAL, strSubstring));
            }
            if (strSubstring4.length() != 0) {
                linkedListDiffCompute.addLast(new Diff(Operation.EQUAL, strSubstring4));
            }
            diffCleanupMerge(linkedListDiffCompute);
            return linkedListDiffCompute;
        }
        throw new IllegalArgumentException("Null inputs. (diffMain)");
    }

    public LinkedList<Patch> patchMake(LinkedList<Diff> linkedList) {
        if (linkedList != null) {
            return patchMake(diffText1(linkedList), linkedList);
        }
        throw new IllegalArgumentException("Null inputs. (patchMake)");
    }

    @Deprecated
    public LinkedList<Patch> patchMake(String str, String str2, LinkedList<Diff> linkedList) {
        return patchMake(str, linkedList);
    }

    public LinkedList<Patch> patchMake(String str, LinkedList<Diff> linkedList) {
        if (str != null && linkedList != null) {
            LinkedList<Patch> linkedList2 = new LinkedList<>();
            if (!linkedList.isEmpty()) {
                Patch patch = new Patch();
                Patch patch2 = patch;
                int length = 0;
                int length2 = 0;
                String str2 = str;
                for (Diff diff : linkedList) {
                    if (patch2.diffs.isEmpty() && diff.operation != Operation.EQUAL) {
                        patch2.start1 = length;
                        patch2.start2 = length2;
                    }
                    int i = C141961.f10184x3fe1b310[diff.operation.ordinal()];
                    if (i == 1) {
                        patch2.diffs.add(diff);
                        patch2.length2 = diff.text.length() + patch2.length2;
                        str2 = str2.substring(0, length2) + diff.text + str2.substring(length2);
                    } else if (i == 2) {
                        patch2.length1 = diff.text.length() + patch2.length1;
                        patch2.diffs.add(diff);
                        str2 = str2.substring(0, length2) + str2.substring(diff.text.length() + length2);
                    } else if (i == 3) {
                        if (diff.text.length() <= this.patchMargin * 2 && !patch2.diffs.isEmpty() && diff != linkedList.getLast()) {
                            patch2.diffs.add(diff);
                            patch2.length1 = diff.text.length() + patch2.length1;
                            patch2.length2 = diff.text.length() + patch2.length2;
                        }
                        if (diff.text.length() >= this.patchMargin * 2 && !patch2.diffs.isEmpty() && !patch2.diffs.isEmpty()) {
                            patchAddContext(patch2, str);
                            linkedList2.add(patch2);
                            patch2 = new Patch();
                            str = str2;
                            length = length2;
                        }
                    }
                    if (diff.operation != Operation.INSERT) {
                        length = diff.text.length() + length;
                    }
                    if (diff.operation != Operation.DELETE) {
                        length2 += diff.text.length();
                    }
                }
                if (!patch2.diffs.isEmpty()) {
                    patchAddContext(patch2, str);
                    linkedList2.add(patch2);
                }
            }
            return linkedList2;
        }
        throw new IllegalArgumentException("Null inputs. (patchMake)");
    }
}
