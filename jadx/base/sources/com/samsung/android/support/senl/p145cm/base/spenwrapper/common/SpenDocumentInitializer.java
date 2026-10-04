package com.samsung.android.support.senl.p145cm.base.spenwrapper.common;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenDocumentInitializer;", "", "<init>", "()V", "setPageVerticalPadding", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenDocumentInitializer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PAGE_WIDTH = 1080;
    public static final float DOC_BASE_WIDTH = 360.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenDocumentInitializer$Companion;", "", "<init>", "()V", "DOC_BASE_WIDTH", "", "DEFAULT_PAGE_WIDTH", "", "convertDpToNoteValue", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "value", "docRatio", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float docRatio(SpenWNote note) {
            return (note.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW ? note.getPageDefaultHeight() : note.getPageDefaultWidth()) / 360.0f;
        }

        public final float convertDpToNoteValue(@NotNull SpenWNote note, float value) {
            Intrinsics.checkNotNullParameter(note, "note");
            return docRatio(note) * value;
        }

        private Companion() {
        }
    }

    public final void setPageVerticalPadding(@NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        wNote.setPageVerticalPadding((int) ((wNote.getPageDefaultWidth() / 360.0f) * 8));
    }
}
