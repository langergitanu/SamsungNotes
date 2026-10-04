package com.samsung.android.support.senl.p148nt.word.data;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0016J\u0006\u0010#\u001a\u00020$R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0014¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "", "mContext", "Landroid/content/Context;", "spenWNoteP", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "enableTitle", "", "enableModifiedTime", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;ZZ)V", "getSpenWNoteP", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "captureEngine", "Lcom/samsung/android/support/senl/nt/base/common/NoteCaptureControl;", "getCaptureEngine", "()Lcom/samsung/android/support/senl/nt/base/common/NoteCaptureControl;", "pageCount", "", "getPageCount", "()I", "getPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "index", "getObjectsPage", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "pageIndex", "width", "getWidth", "height", "getHeight", "hasPdf", "page", "release", "", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WNoteData {
    public static final int DEFAULT_FONT_SIZE = 15;

    @NotNull
    private final NoteCaptureControl captureEngine;

    @Nullable
    private final Context mContext;

    @NotNull
    private final SpenWNote spenWNoteP;

    public WNoteData(@Nullable Context context, @NotNull SpenWNote spenWNoteP, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(spenWNoteP, "spenWNoteP");
        this.mContext = context;
        this.spenWNoteP = spenWNoteP;
        this.captureEngine = new NoteCaptureControl(context);
    }

    @NotNull
    public final NoteCaptureControl getCaptureEngine() {
        return this.captureEngine;
    }

    public final int getHeight() {
        return this.spenWNoteP.getHeight();
    }

    @Nullable
    public final ArrayList<SpenObjectBase> getObjectsPage(int pageIndex) {
        if (pageIndex >= this.spenWNoteP.getPageCount() || pageIndex < 0) {
            return null;
        }
        return this.spenWNoteP.getPage(pageIndex).getObjectList();
    }

    @Nullable
    public final SpenWPage getPage(int index) {
        if (index >= this.spenWNoteP.getPageCount() || index < 0) {
            return null;
        }
        return this.spenWNoteP.getPage(index);
    }

    public final int getPageCount() {
        return this.spenWNoteP.getPageCount();
    }

    @NotNull
    public final SpenWNote getSpenWNoteP() {
        return this.spenWNoteP;
    }

    public final int getWidth() {
        return this.spenWNoteP.getWidth();
    }

    public final boolean hasPdf(@NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return page.hasPDF();
    }

    public final void release() {
        this.captureEngine.close();
    }
}
