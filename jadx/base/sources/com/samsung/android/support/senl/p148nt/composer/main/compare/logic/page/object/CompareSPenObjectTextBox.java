package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object;

import android.graphics.Point;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.ConflictLocation;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.InformationConflict;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.paragraph.CompareSpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.spantext.CompareSpanBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0003789B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0002JH\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c2\u0006\u0010\u001e\u001a\u00020%H\u0002J.\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000b2\u0006\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020\u000eH\u0002J,\u0010-\u001a\b\u0012\u0004\u0012\u00020'0.2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020'0\u000bH\u0002J\u0018\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020'H\u0002J$\u00103\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020)0\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u000eR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox;", "", "<init>", "()V", "mListConflictLocation", "", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/ConflictLocation;", "mTextBoxLocal", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "mTextBoxSync", "mSetOBJLocal", "Ljava/util/TreeSet;", "", "isConflictBody", "", "getListConflictLocation", "compareTextBox", "", "object1", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "object2", "compareBodyText", "addConflictLocation", "info", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$BodyTextConflict;", "getSpans", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox$SpanTextNode;", "listSpan", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "start", "end", "compareSpanArray", "spanLocal", "spanSync", "indexObjectSpan", "res", "Landroid/graphics/Point;", "getParagraph", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox$Paragraph;", "text", "", "listTextParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "isLocal", "getParagraphsFromIndex", "Ljava/util/LinkedList;", "setParagraph", "compareParagraph", "paragraphLocal", "paragraphSync", "compareTextSpan", "listSpanLocal", "listSpanSync", "splitText", "Paragraph", "SpanTextNode", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CompareSPenObjectTextBox {

    @NotNull
    private static final String TAG;
    private boolean isConflictBody;

    @Nullable
    private List<ConflictLocation> mListConflictLocation;

    @Nullable
    private TreeSet<Integer> mSetOBJLocal;

    @Nullable
    private SpenObjectTextBox mTextBoxLocal;

    @Nullable
    private SpenObjectTextBox mTextBoxSync;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox$Paragraph;", "", "start", "", "end", "index", "mapSpan", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "Lkotlin/collections/HashMap;", "<init>", "(IIILjava/util/HashMap;)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "getIndex", "setIndex", "getMapSpan", "()Ljava/util/HashMap;", "setMapSpan", "(Ljava/util/HashMap;)V", "isChecked", "", "()Z", "setChecked", "(Z)V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Paragraph {
        private int end;
        private int index;
        private boolean isChecked;

        @Nullable
        private HashMap<Integer, SpenTextParagraphBase> mapSpan;
        private int start;

        public Paragraph(int i, int i2, int i4, @Nullable HashMap<Integer, SpenTextParagraphBase> map) {
            this.start = i;
            this.end = i2;
            this.index = i4;
            this.mapSpan = map;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getIndex() {
            return this.index;
        }

        @Nullable
        public final HashMap<Integer, SpenTextParagraphBase> getMapSpan() {
            return this.mapSpan;
        }

        public final int getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }

        public final void setChecked(boolean z) {
            this.isChecked = z;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final void setMapSpan(@Nullable HashMap<Integer, SpenTextParagraphBase> map) {
            this.mapSpan = map;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox$SpanTextNode;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "listSpan", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "getListSpan", "()Ljava/util/ArrayList;", "setListSpan", "(Ljava/util/ArrayList;)V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SpanTextNode {
        private int end;

        @NotNull
        private ArrayList<SpenTextSpanBase> listSpan = new ArrayList<>();
        private int start;

        public SpanTextNode(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final int getEnd() {
            return this.end;
        }

        @NotNull
        public final ArrayList<SpenTextSpanBase> getListSpan() {
            return this.listSpan;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final void setListSpan(@NotNull ArrayList<SpenTextSpanBase> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.listSpan = arrayList;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DiffMatchPatch.Operation.values().length];
            try {
                iArr[DiffMatchPatch.Operation.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiffMatchPatch.Operation.INSERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strCreateTag = Logger.createTag("CompareSPenObjectTextBox");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        if (r1.charAt(r0.getEndIndexLocal()) == ' ') goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addConflictLocation(InformationConflict.BodyTextConflict info) {
        if (info.getType() == 2) {
            List<ConflictLocation> list = this.mListConflictLocation;
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                List<ConflictLocation> list2 = this.mListConflictLocation;
                Intrinsics.checkNotNull(list2);
                Intrinsics.checkNotNull(this.mListConflictLocation);
                InformationConflict mInformationConflict = list2.get(r1.size() - 1).getMInformationConflict();
                Intrinsics.checkNotNull(mInformationConflict, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict");
                InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) mInformationConflict;
                if (bodyTextConflict.getType() == info.getType()) {
                    if (bodyTextConflict.getEndIndexLocal() != info.getStartIndexLocal()) {
                        if (bodyTextConflict.getEndIndexLocal() + 1 == info.getStartIndexLocal()) {
                            SpenObjectTextBox spenObjectTextBox = this.mTextBoxLocal;
                            String text = spenObjectTextBox != null ? spenObjectTextBox.getText() : null;
                            Intrinsics.checkNotNull(text);
                        }
                    }
                    bodyTextConflict.setEndIndexLocal(info.getEndIndexLocal());
                    bodyTextConflict.setEndIndexSync(info.getEndIndexSync());
                    bodyTextConflict.setParagraph(info.getIsParagraph());
                    return;
                }
                ConflictLocation conflictLocation = new ConflictLocation(info.getType(), false, null, null);
                conflictLocation.setMInformationConflict(info);
                List<ConflictLocation> list3 = this.mListConflictLocation;
                if (list3 != null) {
                    list3.add(conflictLocation);
                    return;
                }
                return;
            }
        }
        ConflictLocation conflictLocation2 = new ConflictLocation(info.getType(), false, null, null);
        conflictLocation2.setMInformationConflict(info);
        List<ConflictLocation> list4 = this.mListConflictLocation;
        if (list4 != null) {
            list4.add(conflictLocation2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17, types: [int] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    private final boolean compareBodyText() {
        int i;
        int i2;
        LinkedList<DiffMatchPatch.Diff> linkedList;
        TreeSet<Paragraph> treeSet;
        int length;
        int i4;
        SpenObjectTextBox spenObjectTextBox = this.mTextBoxLocal;
        String text = spenObjectTextBox != null ? spenObjectTextBox.getText() : null;
        SpenObjectTextBox spenObjectTextBox2 = this.mTextBoxSync;
        String text2 = spenObjectTextBox2 != null ? spenObjectTextBox2.getText() : null;
        ArrayList<SpenTextSpanBase> arrayList = new ArrayList<>();
        ArrayList<SpenTextSpanBase> arrayList2 = new ArrayList<>();
        SpenObjectTextBox spenObjectTextBox3 = this.mTextBoxLocal;
        if ((spenObjectTextBox3 != null ? spenObjectTextBox3.getTextSpan() : null) != null) {
            SpenObjectTextBox spenObjectTextBox4 = this.mTextBoxLocal;
            ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox4 != null ? spenObjectTextBox4.getTextSpan() : null;
            Intrinsics.checkNotNull(textSpan);
            arrayList.addAll(textSpan);
        }
        SpenObjectTextBox spenObjectTextBox5 = this.mTextBoxSync;
        if ((spenObjectTextBox5 != null ? spenObjectTextBox5.getTextSpan() : null) != null) {
            SpenObjectTextBox spenObjectTextBox6 = this.mTextBoxSync;
            ArrayList<SpenTextSpanBase> textSpan2 = spenObjectTextBox6 != null ? spenObjectTextBox6.getTextSpan() : null;
            Intrinsics.checkNotNull(textSpan2);
            arrayList2.addAll(textSpan2);
        }
        Comparator<SpenTextSpanBase> comparator = new Comparator<SpenTextSpanBase>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox$compareBodyText$comparator$1
            @Override // java.util.Comparator
            public int compare(SpenTextSpanBase o12, SpenTextSpanBase o22) {
                int end;
                int end2;
                Intrinsics.checkNotNullParameter(o12, "o1");
                Intrinsics.checkNotNullParameter(o22, "o2");
                if (o12.getStart() != o22.getStart()) {
                    end = o12.getStart();
                    end2 = o22.getStart();
                } else {
                    end = o12.getEnd();
                    end2 = o22.getEnd();
                }
                return end - end2;
            }
        };
        CollectionsKt.sortWith(arrayList, comparator);
        CollectionsKt.sortWith(arrayList2, comparator);
        boolean z = false;
        int i5 = 1;
        if (text == null || text2 == null) {
            return text == null && text2 == null;
        }
        ArrayList<InformationConflict.BodyTextConflict> arrayList3 = new ArrayList<>();
        DiffMatchPatch diffMatchPatch = new DiffMatchPatch();
        LinkedList<DiffMatchPatch.Diff> linkedListDiffMain = diffMatchPatch.diffMain(text, text2);
        diffMatchPatch.diffCleanupEfficiency(linkedListDiffMain);
        SpenObjectTextBox spenObjectTextBox7 = this.mTextBoxLocal;
        ArrayList<SpenTextParagraphBase> textParagraph = spenObjectTextBox7 != null ? spenObjectTextBox7.getTextParagraph() : null;
        SpenObjectTextBox spenObjectTextBox8 = this.mTextBoxSync;
        ArrayList<SpenTextParagraphBase> textParagraph2 = spenObjectTextBox8 != null ? spenObjectTextBox8.getTextParagraph() : null;
        TreeSet<Paragraph> paragraph = getParagraph(text, textParagraph, true);
        TreeSet<Paragraph> paragraph2 = getParagraph(text2, textParagraph2, false);
        int size = linkedListDiffMain.size();
        int i6 = 0;
        int i7 = -1;
        int length2 = -1;
        while (i6 < size) {
            DiffMatchPatch.Diff diff = linkedListDiffMain.get(i6);
            boolean z2 = z;
            String text3 = diff.text;
            Intrinsics.checkNotNullExpressionValue(text3, "text");
            if (text3.length() == 0) {
                i = i6;
                linkedList = linkedListDiffMain;
                treeSet = paragraph;
            } else {
                DiffMatchPatch.Operation operation = diff.operation;
                int i8 = operation == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
                if (i8 == i5) {
                    i = i6;
                    i2 = i7;
                    linkedList = linkedListDiffMain;
                    treeSet = paragraph;
                    int i9 = length2 + 1;
                    arrayList3.add(InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(1, i2 + 1, AbstractC2821a.m2212c(i2, 1, diff.text), i9, i9));
                    length = diff.text.length();
                } else if (i8 != 2) {
                    int i10 = i7 + 1;
                    LinkedList<Paragraph> paragraphsFromIndex = getParagraphsFromIndex(i10, diff.text.length() + i7, paragraph);
                    i = i6;
                    int i11 = length2 + 1;
                    int i12 = i7;
                    LinkedList<Paragraph> paragraphsFromIndex2 = getParagraphsFromIndex(i11, diff.text.length() + length2, paragraph2);
                    int i13 = length2;
                    linkedList = linkedListDiffMain;
                    if (paragraphsFromIndex.size() > paragraphsFromIndex2.size()) {
                        int size2 = paragraphsFromIndex.size() - paragraphsFromIndex2.size();
                        for (?? r11 = z2; r11 < size2; r11++) {
                            paragraphsFromIndex.removeFirst();
                        }
                    } else if (paragraphsFromIndex.size() < paragraphsFromIndex2.size()) {
                        int size3 = paragraphsFromIndex2.size() - paragraphsFromIndex.size();
                        for (?? r112 = z2; r112 < size3; r112++) {
                            paragraphsFromIndex2.removeFirst();
                        }
                    }
                    int size4 = paragraphsFromIndex.size();
                    for (?? r113 = z2; r113 < size4; r113++) {
                        int i14 = size4;
                        Paragraph paragraph3 = paragraphsFromIndex.get(r113);
                        Intrinsics.checkNotNullExpressionValue(paragraph3, "get(...)");
                        Paragraph paragraph4 = paragraph3;
                        LinkedList<Paragraph> linkedList2 = paragraphsFromIndex;
                        Paragraph paragraph5 = paragraphsFromIndex2.get(r113);
                        Intrinsics.checkNotNullExpressionValue(paragraph5, "get(...)");
                        Paragraph paragraph6 = paragraph5;
                        if (!paragraph4.getIsChecked() && !paragraph6.getIsChecked() && !compareParagraph(paragraph4, paragraph6)) {
                            InformationConflict.BodyTextConflict bodyTextConflictCreateConflictInfo = InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(2, paragraph4.getStart(), paragraph4.getEnd(), paragraph6.getStart(), paragraph6.getEnd());
                            bodyTextConflictCreateConflictInfo.setParagraph(true);
                            arrayList3.add(bodyTextConflictCreateConflictInfo);
                        }
                        size4 = i14;
                        paragraphsFromIndex = linkedList2;
                    }
                    String text4 = diff.text;
                    Intrinsics.checkNotNullExpressionValue(text4, "text");
                    if (StringsKt.trim((CharSequence) text4).toString().length() > 0) {
                        ArrayList<Integer> arrayList4 = new ArrayList<>();
                        TreeSet<Integer> treeSet2 = this.mSetOBJLocal;
                        if (treeSet2 != null && !treeSet2.isEmpty()) {
                            TreeSet<Integer> treeSet3 = this.mSetOBJLocal;
                            SortedSet<Integer> sortedSetSubSet = treeSet3 != null ? treeSet3.subSet(Integer.valueOf(i10), Integer.valueOf(diff.text.length() + i12 + 1)) : null;
                            if (sortedSetSubSet != null) {
                                Iterator<Integer> it = sortedSetSubSet.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    arrayList4.add(next);
                                    SpenObjectTextBox spenObjectTextBox9 = this.mTextBoxLocal;
                                    Intrinsics.checkNotNull(spenObjectTextBox9);
                                    Intrinsics.checkNotNull(next);
                                    SpenObjectBase object = spenObjectTextBox9.getObjectSpanAtTextIndex(next.intValue()).getObject();
                                    int iIntValue = (next.intValue() - i12) + i13;
                                    SpenObjectTextBox spenObjectTextBox10 = this.mTextBoxSync;
                                    Intrinsics.checkNotNull(spenObjectTextBox10);
                                    SpenObjectBase object2 = spenObjectTextBox10.getObjectSpanAtTextIndex(iIntValue).getObject();
                                    Iterator<Integer> it2 = it;
                                    ArrayList<Integer> arrayList5 = arrayList4;
                                    TreeSet<Paragraph> treeSet4 = paragraph;
                                    if (!Intrinsics.areEqual(object.getId() + object.getAppendTime() + object.getType(), object2.getId() + object2.getAppendTime() + object2.getType())) {
                                        InformationConflict.BodyTextConflict.Companion companion = InformationConflict.BodyTextConflict.INSTANCE;
                                        arrayList3.add(companion.createConflictInfo(1, next.intValue(), next.intValue() + 1, iIntValue, iIntValue));
                                        arrayList3.add(companion.createConflictInfo(0, next.intValue(), next.intValue(), iIntValue, iIntValue + 1));
                                    } else if (object.getModifiedTime() != object2.getModifiedTime()) {
                                        InformationConflict.BodyTextConflict bodyTextConflictCreateConflictInfo2 = InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(2, next.intValue(), next.intValue() + 1, iIntValue, iIntValue + 1);
                                        bodyTextConflictCreateConflictInfo2.setSPenObject(true);
                                        arrayList3.add(bodyTextConflictCreateConflictInfo2);
                                    }
                                    it = it2;
                                    arrayList4 = arrayList5;
                                    paragraph = treeSet4;
                                }
                            }
                        }
                        ArrayList<Integer> arrayList6 = arrayList4;
                        treeSet = paragraph;
                        TreeSet<SpanTextNode> spans = getSpans(arrayList, i10, diff.text.length() + i12);
                        TreeSet<SpanTextNode> spans2 = getSpans(arrayList2, i11, diff.text.length() + i13);
                        Point point = new Point(i10, i11);
                        i2 = i12;
                        i4 = i13;
                        compareSpanArray(spans, spans2, arrayList6, arrayList3, point);
                    } else {
                        treeSet = paragraph;
                        i2 = i12;
                        i4 = i13;
                    }
                    length2 = diff.text.length() + i4;
                    length = diff.text.length();
                } else {
                    i = i6;
                    int i15 = length2;
                    linkedList = linkedListDiffMain;
                    treeSet = paragraph;
                    int i16 = i7 + 1;
                    arrayList3.add(InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(0, i16, i16, i15 + 1, AbstractC2821a.m2212c(i15, 1, diff.text)));
                    length2 = diff.text.length() + i15;
                }
                i7 = length + i2;
            }
            i6 = i + 1;
            z = z2;
            linkedListDiffMain = linkedList;
            paragraph = treeSet;
            i5 = 1;
        }
        boolean z3 = z;
        this.mListConflictLocation = new ArrayList();
        CollectionsKt.sortWith(arrayList3, new Comparator<InformationConflict.BodyTextConflict>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox.compareBodyText.1
            @Override // java.util.Comparator
            public int compare(InformationConflict.BodyTextConflict o12, InformationConflict.BodyTextConflict o22) {
                Intrinsics.checkNotNullParameter(o12, "o1");
                Intrinsics.checkNotNullParameter(o22, "o2");
                return o12.getStartIndexLocal() != o22.getStartIndexLocal() ? o12.getStartIndexLocal() - o22.getStartIndexLocal() : o22.getEndIndexLocal() - o12.getEndIndexLocal();
            }
        });
        int size5 = arrayList3.size();
        InformationConflict.BodyTextConflict bodyTextConflict = null;
        for (?? r2 = z3; r2 < size5; r2++) {
            InformationConflict.BodyTextConflict bodyTextConflict2 = arrayList3.get(r2);
            Intrinsics.checkNotNullExpressionValue(bodyTextConflict2, "get(...)");
            InformationConflict.BodyTextConflict bodyTextConflict3 = bodyTextConflict2;
            if (bodyTextConflict == null) {
                if (bodyTextConflict3.getIsParagraph()) {
                    bodyTextConflict = bodyTextConflict3;
                } else {
                    addConflictLocation(bodyTextConflict3);
                }
            } else if (bodyTextConflict3.getIsParagraph()) {
                if (bodyTextConflict.getStartIndexLocal() != bodyTextConflict3.getStartIndexLocal()) {
                    addConflictLocation(bodyTextConflict);
                    bodyTextConflict = bodyTextConflict3;
                }
            } else if (bodyTextConflict3.getEndIndexLocal() > bodyTextConflict.getEndIndexLocal()) {
                addConflictLocation(bodyTextConflict);
                if (bodyTextConflict3.getStartIndexLocal() < bodyTextConflict.getEndIndexLocal()) {
                    bodyTextConflict3.setStartIndexLocal(bodyTextConflict.getEndIndexLocal());
                    bodyTextConflict3.setStartIndexSync(bodyTextConflict.getEndIndexSync());
                    addConflictLocation(bodyTextConflict3);
                }
                bodyTextConflict = null;
            }
            if (r2 == arrayList3.size() - 1 && bodyTextConflict != null) {
                addConflictLocation(bodyTextConflict);
            }
        }
        return z3;
    }

    private final boolean compareParagraph(Paragraph paragraphLocal, Paragraph paragraphSync) {
        Collection<SpenTextParagraphBase> collectionValues;
        Collection<SpenTextParagraphBase> collectionValues2;
        paragraphLocal.setChecked(true);
        paragraphSync.setChecked(true);
        HashMap<Integer, SpenTextParagraphBase> mapSpan = paragraphLocal.getMapSpan();
        Integer numValueOf = (mapSpan == null || (collectionValues2 = mapSpan.values()) == null) ? null : Integer.valueOf(collectionValues2.size());
        HashMap<Integer, SpenTextParagraphBase> mapSpan2 = paragraphSync.getMapSpan();
        if (!Intrinsics.areEqual(numValueOf, (mapSpan2 == null || (collectionValues = mapSpan2.values()) == null) ? null : Integer.valueOf(collectionValues.size()))) {
            return false;
        }
        for (int i = 2; i < 6; i++) {
            HashMap<Integer, SpenTextParagraphBase> mapSpan3 = paragraphLocal.getMapSpan();
            SpenTextParagraphBase spenTextParagraphBase = mapSpan3 != null ? mapSpan3.get(Integer.valueOf(i)) : null;
            HashMap<Integer, SpenTextParagraphBase> mapSpan4 = paragraphSync.getMapSpan();
            if (new CompareSpenTextParagraphBase().isNotSame(spenTextParagraphBase, mapSpan4 != null ? mapSpan4.get(Integer.valueOf(i)) : null)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r5 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r2 = r5.getStart();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if (r20.isEmpty() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r2 = r20.first().getStart();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        if (r20.isEmpty() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        r2 = r20.first().getEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r5 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r2 = r5.getEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r9 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r2 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        r7 = com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict.Companion;
        r10 = r2 + 1;
        r2 = r24.x;
        r1 = r24.y;
        r23.add(r7.createConflictInfo(2, r9, r10, (r9 - r2) + r1, (r10 - r2) + r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
    
        if (r6 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0082, code lost:
    
        r2 = r6.getStart();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        r11 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
    
        if (r21.isEmpty() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        r2 = r21.first().getStart();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
    
        if (r21.isEmpty() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
    
        r2 = r21.first().getEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ab, code lost:
    
        if (r6 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
    
        r2 = r6.getEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
    
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b3, code lost:
    
        if (r11 == (-1)) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b5, code lost:
    
        if (r2 == (-1)) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b7, code lost:
    
        r7 = com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict.Companion;
        r3 = r24.y;
        r1 = r24.x;
        r12 = r2 + 1;
        r23.add(r7.createConflictInfo(2, (r11 - r3) + r1, (r12 - r3) + r1, r11, r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void compareSpanArray(TreeSet<SpanTextNode> spanLocal, TreeSet<SpanTextNode> spanSync, ArrayList<Integer> indexObjectSpan, ArrayList<InformationConflict.BodyTextConflict> res, Point start) {
        int start2;
        int i = indexObjectSpan.isEmpty() ? -1 : 0;
        SpanTextNode spanTextNodePollFirst = null;
        SpanTextNode spanTextNodePollFirst2 = null;
        InformationConflict.BodyTextConflict bodyTextConflictCreateConflictInfo = null;
        while (true) {
            if (spanTextNodePollFirst == null) {
                if (spanLocal.isEmpty()) {
                    break;
                }
                spanTextNodePollFirst = spanLocal.pollFirst();
                if (spanTextNodePollFirst2 == null) {
                }
                Intrinsics.checkNotNull(spanTextNodePollFirst);
                start2 = spanTextNodePollFirst.getStart() - start.x;
                Intrinsics.checkNotNull(spanTextNodePollFirst2);
                if (start2 == spanTextNodePollFirst2.getStart() - start.y) {
                }
            } else {
                if (spanTextNodePollFirst2 == null) {
                    if (spanSync.isEmpty()) {
                        break;
                    } else {
                        spanTextNodePollFirst2 = spanSync.pollFirst();
                    }
                }
                Intrinsics.checkNotNull(spanTextNodePollFirst);
                start2 = spanTextNodePollFirst.getStart() - start.x;
                Intrinsics.checkNotNull(spanTextNodePollFirst2);
                if (start2 == spanTextNodePollFirst2.getStart() - start.y) {
                    Logger.m11000e(TAG, "compareSpanArray error: " + spanTextNodePollFirst.getStart() + " " + spanTextNodePollFirst2.getStart());
                    return;
                }
                if (!compareTextSpan(spanTextNodePollFirst.getListSpan(), spanTextNodePollFirst2.getListSpan())) {
                    int end = spanTextNodePollFirst.getEnd() - start.x <= spanTextNodePollFirst2.getEnd() - start.y ? spanTextNodePollFirst.getEnd() : (spanTextNodePollFirst2.getEnd() - start.y) + start.x;
                    int end2 = spanTextNodePollFirst.getEnd() - start.x > spanTextNodePollFirst2.getEnd() - start.y ? spanTextNodePollFirst2.getEnd() : (spanTextNodePollFirst.getEnd() - start.x) + start.y;
                    Integer num = (i <= -1 || i >= indexObjectSpan.size()) ? -1 : indexObjectSpan.get(i);
                    Intrinsics.checkNotNull(num);
                    int iIntValue = num.intValue();
                    if (bodyTextConflictCreateConflictInfo == null || bodyTextConflictCreateConflictInfo.getEndIndexLocal() != spanTextNodePollFirst.getStart()) {
                        bodyTextConflictCreateConflictInfo = InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(2, spanTextNodePollFirst.getStart(), end + 1, spanTextNodePollFirst2.getStart(), end2 + 1);
                        res.add(bodyTextConflictCreateConflictInfo);
                    } else {
                        bodyTextConflictCreateConflictInfo.setEndIndexLocal(end + 1);
                        bodyTextConflictCreateConflictInfo.setEndIndexSync(end2 + 1);
                    }
                    if (bodyTextConflictCreateConflictInfo != null && iIntValue < bodyTextConflictCreateConflictInfo.getEndIndexLocal() && iIntValue >= bodyTextConflictCreateConflictInfo.getStartIndexLocal()) {
                        if (iIntValue == bodyTextConflictCreateConflictInfo.getStartIndexLocal()) {
                            bodyTextConflictCreateConflictInfo.setStartIndexLocal(bodyTextConflictCreateConflictInfo.getStartIndexLocal() + 1);
                            bodyTextConflictCreateConflictInfo.setStartIndexSync(bodyTextConflictCreateConflictInfo.getStartIndexSync() + 1);
                        } else if (iIntValue == bodyTextConflictCreateConflictInfo.getEndIndexLocal() - 1) {
                            bodyTextConflictCreateConflictInfo.setEndIndexLocal(bodyTextConflictCreateConflictInfo.getEndIndexLocal() - 1);
                            bodyTextConflictCreateConflictInfo.setEndIndexSync(bodyTextConflictCreateConflictInfo.getEndIndexSync() - 1);
                            bodyTextConflictCreateConflictInfo = null;
                        } else {
                            InformationConflict.BodyTextConflict bodyTextConflictCreateConflictInfo2 = InformationConflict.BodyTextConflict.INSTANCE.createConflictInfo(2, iIntValue + 1, bodyTextConflictCreateConflictInfo.getEndIndexLocal(), (iIntValue - start.x) + start.y + 1, bodyTextConflictCreateConflictInfo.getEndIndexSync());
                            res.add(bodyTextConflictCreateConflictInfo2);
                            bodyTextConflictCreateConflictInfo.setEndIndexLocal(iIntValue);
                            bodyTextConflictCreateConflictInfo.setEndIndexSync(bodyTextConflictCreateConflictInfo2.getStartIndexSync() - 1);
                            bodyTextConflictCreateConflictInfo = bodyTextConflictCreateConflictInfo2;
                        }
                        i++;
                    }
                }
                if (spanTextNodePollFirst.getEnd() - start.x < spanTextNodePollFirst2.getEnd() - start.y) {
                    spanTextNodePollFirst2.setStart((spanTextNodePollFirst.getEnd() - start.x) + start.y + 1);
                    spanTextNodePollFirst = null;
                } else if (spanTextNodePollFirst.getEnd() - start.x > spanTextNodePollFirst2.getEnd() - start.y) {
                    spanTextNodePollFirst.setStart((spanTextNodePollFirst2.getEnd() - start.y) + start.x + 1);
                    spanTextNodePollFirst2 = null;
                } else {
                    spanTextNodePollFirst = null;
                    spanTextNodePollFirst2 = null;
                }
            }
        }
    }

    private final boolean compareTextSpan(ArrayList<SpenTextSpanBase> listSpanLocal, ArrayList<SpenTextSpanBase> listSpanSync) {
        if (listSpanLocal.size() != listSpanSync.size()) {
            return false;
        }
        C0016a c0016a = new C0016a(0);
        CollectionsKt.sortWith(listSpanLocal, c0016a);
        CollectionsKt.sortWith(listSpanSync, c0016a);
        int size = listSpanLocal.size();
        for (int i = 0; i < size; i++) {
            SpenTextSpanBase spenTextSpanBase = listSpanLocal.get(i);
            Intrinsics.checkNotNullExpressionValue(spenTextSpanBase, "get(...)");
            SpenTextSpanBase spenTextSpanBase2 = listSpanSync.get(i);
            Intrinsics.checkNotNullExpressionValue(spenTextSpanBase2, "get(...)");
            if (new CompareSpanBase().isNotSame(spenTextSpanBase, spenTextSpanBase2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int compareTextSpan$lambda$2(SpenTextSpanBase spenTextSpanBase, SpenTextSpanBase spenTextSpanBase2) {
        return spenTextSpanBase.getType() - spenTextSpanBase2.getType();
    }

    private final TreeSet<Paragraph> getParagraph(String text, ArrayList<SpenTextParagraphBase> listTextParagraph, boolean isLocal) {
        TreeSet<Paragraph> treeSet = new TreeSet<>(new C0016a(3));
        Iterator<String> it = splitText(text, isLocal).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            int length = next.length() + i;
            HashMap map = new HashMap();
            if (listTextParagraph != null) {
                while (i4 < listTextParagraph.size()) {
                    SpenTextParagraphBase spenTextParagraphBase = listTextParagraph.get(i4);
                    Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase, "get(...)");
                    SpenTextParagraphBase spenTextParagraphBase2 = spenTextParagraphBase;
                    if (spenTextParagraphBase2.getStart() > i2 || spenTextParagraphBase2.getEnd() <= i2) {
                        break;
                    }
                    map.put(Integer.valueOf(spenTextParagraphBase2.getType()), spenTextParagraphBase2);
                    i4++;
                }
            }
            treeSet.add(new Paragraph(i, length, i2, map));
            i2++;
            i = length;
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getParagraph$lambda$1(Paragraph paragraph, Paragraph paragraph2) {
        return paragraph.getStart() - paragraph2.getStart();
    }

    private final LinkedList<Paragraph> getParagraphsFromIndex(int start, int end, TreeSet<Paragraph> setParagraph) {
        LinkedList<Paragraph> linkedList = new LinkedList<>();
        Paragraph paragraphCeiling = setParagraph.ceiling(new Paragraph(start, start, -1, null));
        if (paragraphCeiling != null) {
            linkedList.add(paragraphCeiling);
            while (true) {
                paragraphCeiling = setParagraph.higher(paragraphCeiling);
                if (paragraphCeiling == null || paragraphCeiling.getStart() > end) {
                    break;
                }
                linkedList.add(paragraphCeiling);
            }
        }
        return linkedList;
    }

    private final TreeSet<SpanTextNode> getSpans(ArrayList<SpenTextSpanBase> listSpan, int start, int end) {
        TreeSet<SpanTextNode> treeSet = new TreeSet<>(new C0016a(1));
        treeSet.add(new SpanTextNode(start, end));
        Iterator<SpenTextSpanBase> it = listSpan.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextSpanBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextSpanBase spenTextSpanBase = next;
            if (spenTextSpanBase.getEnd() - 1 >= start) {
                if (spenTextSpanBase.getStart() > end) {
                    break;
                }
                SpanTextNode spanTextNode = new SpanTextNode(spenTextSpanBase.getEnd(), spenTextSpanBase.getEnd());
                while (true) {
                    spanTextNode = treeSet.lower(spanTextNode);
                    if (spanTextNode != null && spenTextSpanBase.getStart() <= spanTextNode.getEnd()) {
                        if (spenTextSpanBase.getStart() <= spanTextNode.getStart()) {
                            if (spenTextSpanBase.getEnd() < spanTextNode.getEnd()) {
                                int end2 = spanTextNode.getEnd();
                                spanTextNode.setEnd(spenTextSpanBase.getEnd() - 1);
                                SpanTextNode spanTextNode2 = new SpanTextNode(spenTextSpanBase.getEnd(), end2);
                                spanTextNode2.getListSpan().addAll(spanTextNode.getListSpan());
                                treeSet.add(spanTextNode2);
                            }
                            spanTextNode.getListSpan().add(spenTextSpanBase);
                        } else {
                            int end3 = spanTextNode.getEnd();
                            spanTextNode.setEnd(spenTextSpanBase.getStart() - 1);
                            SpanTextNode spanTextNode3 = new SpanTextNode(spenTextSpanBase.getStart(), (int) Math.min(spenTextSpanBase.getEnd() - 1, end3));
                            spanTextNode3.getListSpan().addAll(spanTextNode.getListSpan());
                            spanTextNode3.getListSpan().add(spenTextSpanBase);
                            treeSet.add(spanTextNode3);
                            if (spenTextSpanBase.getEnd() <= end3) {
                                SpanTextNode spanTextNode4 = new SpanTextNode(spenTextSpanBase.getEnd(), end3);
                                spanTextNode4.getListSpan().addAll(spanTextNode.getListSpan());
                                treeSet.add(spanTextNode4);
                            }
                        }
                    }
                }
            }
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getSpans$lambda$0(SpanTextNode spanTextNode, SpanTextNode spanTextNode2) {
        return spanTextNode.getStart() - spanTextNode2.getStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int splitText$lambda$3(Integer num, Integer num2) {
        int iIntValue = num.intValue();
        Intrinsics.checkNotNull(num2);
        return iIntValue - num2.intValue();
    }

    public final void compareTextBox(@NotNull SpenObjectBase object1, @NotNull SpenObjectBase object2) {
        Intrinsics.checkNotNullParameter(object1, "object1");
        Intrinsics.checkNotNullParameter(object2, "object2");
        this.mTextBoxLocal = (SpenObjectTextBox) object1;
        this.mTextBoxSync = (SpenObjectTextBox) object2;
        this.isConflictBody = !compareBodyText();
    }

    @NotNull
    public final List<ConflictLocation> getListConflictLocation() {
        List<ConflictLocation> list = this.mListConflictLocation;
        Intrinsics.checkNotNull(list);
        return list;
    }

    /* JADX INFO: renamed from: isConflictBody, reason: from getter */
    public final boolean getIsConflictBody() {
        return this.isConflictBody;
    }

    @NotNull
    public final ArrayList<String> splitText(@NotNull String text, boolean isLocal) {
        Intrinsics.checkNotNullParameter(text, "text");
        ArrayList<String> arrayList = new ArrayList<>();
        C0016a c0016a = new C0016a(2);
        if (isLocal) {
            this.mSetOBJLocal = new TreeSet<>(c0016a);
        }
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = text.charAt(i);
            sb.append(cCharAt);
            if (cCharAt == '\n') {
                arrayList.add(sb.toString());
                sb = new StringBuilder();
            }
            if (cCharAt == 65532 && isLocal) {
                TreeSet<Integer> treeSet = this.mSetOBJLocal;
                Intrinsics.checkNotNull(treeSet);
                treeSet.add(Integer.valueOf(i));
            }
            if (i == text.length() - 1) {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (string.length() != 0) {
                    arrayList.add(sb.toString());
                }
            }
        }
        return arrayList;
    }
}
