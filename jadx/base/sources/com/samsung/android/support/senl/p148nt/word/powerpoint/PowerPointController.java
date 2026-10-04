package com.samsung.android.support.senl.p148nt.word.powerpoint;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.OfficeController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import com.samsung.android.support.senl.p148nt.word.powerpoint.data.PowerPointParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0014J@\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/PowerPointController;", "Lcom/samsung/android/support/senl/nt/word/common/OfficeController;", "Lorg/apache/poi/xslf/usermodel/XMLSlideShow;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "<init>", "()V", "getTag", "", "createOfficeDocument", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "context", "Landroid/content/Context;", "officeParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "sdocPath", "createOfficeParams", "isLongPage", "", "getMimeType", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PowerPointController extends OfficeController<XMLSlideShow, XSLFSlide> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/PowerPointController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return PowerPointController.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("PowerPointController");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public OfficeView<XMLSlideShow, XSLFSlide> createOfficeDocument(@Nullable Context context, @Nullable OfficeParams officeParams, @Nullable WNoteData wNoteData, @Nullable String sdocPath) {
        return new PowerPointView(context, officeParams, wNoteData, sdocPath);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public OfficeParams createOfficeParams(boolean isLongPage) {
        return new PowerPointParams();
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public String getMimeType() {
        return Constants.MIME_PPTX;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.common.OfficeController
    @NotNull
    public String getTag() {
        return TAG;
    }
}
