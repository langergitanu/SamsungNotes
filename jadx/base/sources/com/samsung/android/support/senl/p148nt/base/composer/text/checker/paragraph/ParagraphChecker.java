package com.samsung.android.support.senl.p148nt.base.composer.text.checker.paragraph;

import android.annotation.SuppressLint;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/ParagraphChecker;", "", "<init>", "()V", "checkSingleParagraphTask", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "paragraphStart", "paragraphEnd", "checkParagraph", "", "defaultAlign", "checkParagraphRange", "", "paragraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "isNotAllowedIndent", "systemAlign", "currentAlign", "ParagraphTypes", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ParagraphChecker {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/ParagraphChecker$ParagraphTypes;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ParagraphTypes {
        public static final int ALIGN = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int INDENT = 2;
        public static final int TASK = 1;
        public static final int TEXT_FORMAT = 3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/checker/paragraph/ParagraphChecker$ParagraphTypes$Companion;", "", "<init>", "()V", "ALIGN", "", "TASK", "INDENT", "TEXT_FORMAT", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ALIGN = 0;
            public static final int INDENT = 2;
            public static final int TASK = 1;
            public static final int TEXT_FORMAT = 3;

            private Companion() {
            }
        }
    }

    private final boolean checkParagraphRange(int paragraphStart, int paragraphEnd, SpenTextParagraphBase paragraph) {
        return paragraph.getStart() >= paragraphStart && paragraph.getEnd() <= paragraphEnd;
    }

    private final boolean isNotAllowedIndent(int systemAlign, int currentAlign) {
        return (systemAlign == 0 && currentAlign == 1) || (systemAlign == 1 && currentAlign == 0);
    }

    @SuppressLint({"UseSparseArrays"})
    @NotNull
    public final int[] checkParagraph(@NotNull SpenObjectShape textBox, int paragraphStart, int paragraphEnd, int defaultAlign) {
        char c;
        char c2;
        int i;
        int i2;
        AbsParagraphChecker absParagraphChecker;
        char c4 = 3;
        char c5 = 2;
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = textBox.findTextParagraph(paragraphStart, paragraphEnd);
        int i4 = -1;
        int i5 = 0;
        if (arrayListFindTextParagraph == null) {
            return new int[]{defaultAlign, 0, 0, -1};
        }
        HashMap map = new HashMap(4);
        map.put(3, new AlignChecker(paragraphStart, paragraphEnd, defaultAlign));
        map.put(5, new BulletChecker(paragraphStart, paragraphEnd));
        map.put(2, new IndentChecker(paragraphStart, paragraphEnd));
        map.put(10, new TextFormatChecker(paragraphStart, paragraphEnd));
        Iterator<SpenTextParagraphBase> it = arrayListFindTextParagraph.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        loop0: while (true) {
            c = c4;
            if (!it.hasNext()) {
                c2 = c5;
                i = i4;
                i2 = i5;
                break;
            }
            SpenTextParagraphBase next = it.next();
            c2 = c5;
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextParagraphBase spenTextParagraphBase = next;
            i = i4;
            i2 = i5;
            if (spenTextParagraphBase.getType() != 6 && checkParagraphRange(paragraphStart, paragraphEnd, spenTextParagraphBase) && (absParagraphChecker = (AbsParagraphChecker) map.get(Integer.valueOf(spenTextParagraphBase.getType()))) != null && absParagraphChecker.checkParagraph(spenTextParagraphBase) != 1) {
                for (Object obj : map.values()) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    if (((AbsParagraphChecker) obj).getEnable()) {
                        break;
                    }
                }
                break loop0;
            }
            i4 = i;
            c4 = c;
            c5 = c2;
            i5 = i2;
        }
        AbsParagraphChecker absParagraphChecker2 = (AbsParagraphChecker) map.get(3);
        AbsParagraphChecker absParagraphChecker3 = (AbsParagraphChecker) map.get(5);
        AbsParagraphChecker absParagraphChecker4 = (AbsParagraphChecker) map.get(2);
        AbsParagraphChecker absParagraphChecker5 = (AbsParagraphChecker) map.get(10);
        int[] iArr = new int[4];
        iArr[i2] = absParagraphChecker2 != null ? absParagraphChecker2.getResult() : i;
        iArr[1] = absParagraphChecker3 != null ? absParagraphChecker3.getResult() : i2;
        iArr[c2] = absParagraphChecker4 != null ? absParagraphChecker4.getResult() : i2;
        iArr[c] = absParagraphChecker5 != null ? absParagraphChecker5.getResult() : i;
        if (isNotAllowedIndent(defaultAlign, iArr[i2])) {
            iArr[c2] = i;
        }
        return iArr;
    }

    public final int checkSingleParagraphTask(@NotNull SpenObjectShape textBox, int paragraphStart, int paragraphEnd) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = textBox.findTextParagraph(paragraphStart, paragraphEnd);
        if (arrayListFindTextParagraph == null) {
            return 0;
        }
        Iterator<SpenTextParagraphBase> it = arrayListFindTextParagraph.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextParagraphBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextParagraphBase spenTextParagraphBase = next;
            if (spenTextParagraphBase.getType() == 5 && checkParagraphRange(paragraphStart, paragraphEnd, spenTextParagraphBase)) {
                return ((SpenBulletParagraph) spenTextParagraphBase).getBulletType();
            }
        }
        return 0;
    }
}
