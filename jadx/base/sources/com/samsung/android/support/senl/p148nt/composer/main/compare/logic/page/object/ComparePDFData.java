package com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/ComparePDFData;", "", "<init>", "()V", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComparePDFData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float EPS = 0.001f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/ComparePDFData$Companion;", "", "<init>", "()V", "EPS", "", "isNotSameData", "", "pdfDataLocal", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage$PDFData;", "pdfDataSyncDown", "getFileName", "", "path", "compareRect", "rect1", "Landroid/graphics/RectF;", "rect2", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean compareRect(RectF rect1, RectF rect2) {
            return rect1 != null && rect2 != null && Math.abs((double) (rect1.left - rect2.left)) <= ((double) (rect1.left * 0.001f)) && Math.abs((double) (rect1.top - rect2.top)) <= ((double) (rect1.top * 0.001f)) && Math.abs((double) (rect1.right - rect2.right)) <= ((double) (rect1.right * 0.001f)) && Math.abs((double) (rect1.bottom - rect2.bottom)) <= ((double) (rect1.bottom * 0.001f));
        }

        private final String getFileName(String path) {
            int iM14130D = path != null ? StringsKt.m14130D(path, '/') : 0;
            if (iM14130D <= 0 || path == null) {
                return null;
            }
            String strSubstring = path.substring(iM14130D + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        public final boolean isNotSameData(@NotNull SpenWPage.PDFData pdfDataLocal, @NotNull SpenWPage.PDFData pdfDataSyncDown) {
            Intrinsics.checkNotNullParameter(pdfDataLocal, "pdfDataLocal");
            Intrinsics.checkNotNullParameter(pdfDataSyncDown, "pdfDataSyncDown");
            String fileName = getFileName(pdfDataLocal.getFilePath());
            String fileName2 = getFileName(pdfDataSyncDown.getFilePath());
            if ((fileName == null || Intrinsics.areEqual(fileName, fileName2)) && pdfDataLocal.getBoundFileId() == pdfDataSyncDown.getBoundFileId() && pdfDataLocal.index == pdfDataSyncDown.index) {
                return !compareRect(pdfDataLocal.rect, pdfDataSyncDown.rect);
            }
            return true;
        }

        private Companion() {
        }
    }
}
