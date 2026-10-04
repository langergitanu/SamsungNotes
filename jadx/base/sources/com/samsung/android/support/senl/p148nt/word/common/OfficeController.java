package com.samsung.android.support.senl.p148nt.word.common;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H$J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H$J<\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u0007H$J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0007H$¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/common/OfficeController;", "OfficeDocument", "OfficeElement", "", "<init>", "()V", "wdocToOffice", "", "context", "Landroid/content/Context;", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "sdocPath", "fileName", "shareDir", "getTag", "createOfficeParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "isLongPage", "", "createOfficeDocument", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "officeParams", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "getMimeType", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class OfficeController<OfficeDocument, OfficeElement> {
    @NotNull
    public abstract OfficeView<OfficeDocument, OfficeElement> createOfficeDocument(@Nullable Context context, @Nullable OfficeParams officeParams, @Nullable WNoteData wNoteData, @Nullable String sdocPath);

    @NotNull
    public abstract OfficeParams createOfficeParams(boolean isLongPage);

    @Nullable
    public abstract String getMimeType();

    @Nullable
    public abstract String getTag();

    @NotNull
    public final String wdocToOffice(@Nullable Context context, @NotNull SpenWNote spenWNote, @Nullable String sdocPath, @NotNull String fileName, @NotNull String shareDir) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(shareDir, "shareDir");
        WNoteData wNoteData = new WNoteData(context, spenWNote, true, true);
        int i = (DeviceUtils.isTabletModel() || ModelFeature.getFeature().isFoldableModel() || spenWNote.getBodyTextFontSizeDelta() == -5) ? 5 : 0;
        boolean z = spenWNote.getPageMode() == SpenWNote.PageMode.LIST;
        OfficeParams officeParamsCreateOfficeParams = createOfficeParams(WordUtils.INSTANCE.isLongPage(spenWNote) && z);
        officeParamsCreateOfficeParams.setFontSizeDelta(i);
        OfficeView<OfficeDocument, OfficeElement> officeViewCreateOfficeDocument = createOfficeDocument(context, officeParamsCreateOfficeParams, wNoteData, sdocPath);
        File fileExportFixedSizePage = z ? officeViewCreateOfficeDocument.exportFixedSizePage(fileName, shareDir) : officeViewCreateOfficeDocument.exportContinuousPage(fileName, shareDir);
        if (fileExportFixedSizePage == null) {
            return "";
        }
        String path = fileExportFixedSizePage.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        UriHelper.requestScanFile(context, path, getMimeType());
        return path;
    }
}
