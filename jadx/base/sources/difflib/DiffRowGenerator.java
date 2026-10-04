package difflib;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import difflib.DiffRow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiffRowGenerator {
    private final String InlineNewCssClass;
    private final String InlineNewTag;
    private final String InlineOldCssClass;
    private final String InlineOldTag;
    private final int columnWidth;
    private final boolean ignoreBlankLines;
    private final boolean ignoreWhiteSpaces;
    private final boolean showInlineDiffs;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private boolean showInlineDiffs = false;
        private boolean ignoreWhiteSpaces = true;
        private boolean ignoreBlankLines = true;
        private String InlineOldTag = "span";
        private String InlineNewTag = "span";
        private String InlineOldCssClass = "editOldInline";
        private String InlineNewCssClass = "editNewInline";
        private int columnWidth = 80;

        public Builder InlineNewCssClass(String str) {
            this.InlineNewCssClass = str;
            return this;
        }

        public Builder InlineNewTag(String str) {
            this.InlineNewTag = str;
            return this;
        }

        public Builder InlineOldCssClass(String str) {
            this.InlineOldCssClass = str;
            return this;
        }

        public Builder InlineOldTag(String str) {
            this.InlineOldTag = str;
            return this;
        }

        public DiffRowGenerator build() {
            return new DiffRowGenerator(this);
        }

        public Builder columnWidth(int i) {
            if (i > 0) {
                this.columnWidth = i;
            }
            return this;
        }

        public Builder ignoreBlankLines(boolean z) {
            this.ignoreBlankLines = z;
            return this;
        }

        public Builder ignoreWhiteSpaces(boolean z) {
            this.ignoreWhiteSpaces = z;
            return this;
        }

        public Builder showInlineDiffs(boolean z) {
            this.showInlineDiffs = z;
            return this;
        }
    }

    private void addInlineDiffs(Delta delta) {
        List<?> lines = delta.getOriginal().getLines();
        List<?> lines2 = delta.getRevised().getLines();
        LinkedList<String> linkedList = new LinkedList<>();
        for (char c : join(lines, "\n").toCharArray()) {
            linkedList.add(Character.valueOf(c).toString());
        }
        LinkedList<String> linkedList2 = new LinkedList<>();
        for (char c2 : join(lines2, "\n").toCharArray()) {
            linkedList2.add(Character.valueOf(c2).toString());
        }
        List<Delta> deltas = DiffUtils.diff(linkedList, linkedList2).getDeltas();
        if (deltas.size() < 3) {
            Collections.reverse(deltas);
            for (Delta delta2 : deltas) {
                Chunk original = delta2.getOriginal();
                Chunk revised = delta2.getRevised();
                if (delta2.getClass().equals(DeleteDelta.class)) {
                    linkedList = wrapInTag(linkedList, original.getPosition(), original.size() + original.getPosition() + 1, this.InlineOldTag, this.InlineOldCssClass);
                } else if (delta2.getClass().equals(InsertDelta.class)) {
                    linkedList2 = wrapInTag(linkedList2, revised.getPosition(), revised.size() + revised.getPosition() + 1, this.InlineNewTag, this.InlineNewCssClass);
                } else if (delta2.getClass().equals(ChangeDelta.class)) {
                    linkedList = wrapInTag(linkedList, original.getPosition(), original.size() + original.getPosition() + 1, this.InlineOldTag, this.InlineOldCssClass);
                    linkedList2 = wrapInTag(linkedList2, revised.getPosition(), revised.size() + revised.getPosition() + 1, this.InlineNewTag, this.InlineNewCssClass);
                }
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            Iterator<String> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next());
            }
            delta.getOriginal().setLines(Arrays.asList(sb.toString().split("\n")));
            delta.getRevised().setLines(Arrays.asList(sb2.toString().split("\n")));
        }
    }

    private static <T> String join(Iterable<T> iterable, String str) {
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

    public static LinkedList<String> wrapInTag(LinkedList<String> linkedList, int i, int i2, String str, String str2) {
        LinkedList<String> linkedList2 = (LinkedList) linkedList.clone();
        StringBuilder sbM781w = AbstractC0541b.m781w("<", str);
        if (str2 != null) {
            AbstractC1974b.m1332y(sbM781w, " class=\"", str2, "\"");
        }
        sbM781w.append(">");
        String string = sbM781w.toString();
        sbM781w.delete(0, sbM781w.length());
        sbM781w.append("</");
        sbM781w.append(str);
        sbM781w.append(">");
        String string2 = sbM781w.toString();
        linkedList2.add(i, string);
        linkedList2.add(i2, string2);
        return linkedList2;
    }

    public List<DiffRow> generateDiffRows(List<String> list, List<String> list2) {
        return generateDiffRows(list, list2, DiffUtils.diff(list, list2));
    }

    private DiffRowGenerator(Builder builder) {
        this.showInlineDiffs = builder.showInlineDiffs;
        this.ignoreWhiteSpaces = builder.ignoreWhiteSpaces;
        this.ignoreBlankLines = builder.ignoreBlankLines;
        this.InlineOldTag = builder.InlineOldTag;
        this.InlineNewTag = builder.InlineNewTag;
        this.InlineOldCssClass = builder.InlineOldCssClass;
        this.InlineNewCssClass = builder.InlineNewCssClass;
        this.columnWidth = builder.columnWidth;
    }

    public List<DiffRow> generateDiffRows(List<String> list, List<String> list2, Patch patch) {
        List<String> listNormalize = StringUtills.normalize(list);
        List<String> listNormalize2 = StringUtills.normalize(list2);
        List<String> listWrapText = StringUtills.wrapText(listNormalize, this.columnWidth);
        StringUtills.wrapText(listNormalize2, this.columnWidth);
        ArrayList arrayList = new ArrayList();
        List<Delta> deltas = patch.getDeltas();
        int iLast = 0;
        for (int i = 0; i < deltas.size(); i++) {
            Delta delta = deltas.get(i);
            Chunk original = delta.getOriginal();
            Chunk revised = delta.getRevised();
            original.setLines(StringUtills.normalize((List<String>) original.getLines()));
            revised.setLines(StringUtills.normalize((List<String>) revised.getLines()));
            original.setLines(StringUtills.wrapText((List<String>) original.getLines(), this.columnWidth));
            revised.setLines(StringUtills.wrapText((List<String>) revised.getLines(), this.columnWidth));
            for (String str : listWrapText.subList(iLast, original.getPosition())) {
                arrayList.add(new DiffRow(DiffRow.Tag.EQUAL, str, str));
            }
            if (delta.getClass().equals(InsertDelta.class)) {
                iLast = original.last() + 1;
                Iterator<?> it = revised.getLines().iterator();
                while (it.hasNext()) {
                    arrayList.add(new DiffRow(DiffRow.Tag.INSERT, "", (String) it.next()));
                }
            } else if (delta.getClass().equals(DeleteDelta.class)) {
                iLast = original.last() + 1;
                Iterator<?> it2 = original.getLines().iterator();
                while (it2.hasNext()) {
                    arrayList.add(new DiffRow(DiffRow.Tag.DELETE, (String) it2.next(), ""));
                }
            } else {
                if (this.showInlineDiffs) {
                    addInlineDiffs(delta);
                }
                if (original.size() == revised.size()) {
                    for (int i2 = 0; i2 < original.size(); i2++) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, (String) original.getLines().get(i2), (String) revised.getLines().get(i2)));
                    }
                } else if (original.size() > revised.size()) {
                    int i4 = 0;
                    while (i4 < original.size()) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, (String) original.getLines().get(i4), revised.getLines().size() > i4 ? (String) revised.getLines().get(i4) : ""));
                        i4++;
                    }
                } else {
                    int i5 = 0;
                    while (i5 < revised.size()) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, original.getLines().size() > i5 ? (String) original.getLines().get(i5) : "", (String) revised.getLines().get(i5)));
                        i5++;
                    }
                }
                iLast = original.last() + 1;
            }
        }
        for (String str2 : listWrapText.subList(iLast, listWrapText.size())) {
            arrayList.add(new DiffRow(DiffRow.Tag.EQUAL, str2, str2));
        }
        return arrayList;
    }

    public static String wrapInTag(String str, String str2, String str3) {
        StringBuilder sbM781w = AbstractC0541b.m781w("<", str2);
        if (str3 != null) {
            AbstractC1974b.m1332y(sbM781w, " class=\"", str3, "\"");
        }
        sbM781w.append(">");
        String string = sbM781w.toString();
        sbM781w.delete(0, sbM781w.length());
        sbM781w.append("</");
        sbM781w.append(str2);
        sbM781w.append(">");
        return AbstractC0541b.m757C(string, str, sbM781w.toString());
    }
}
