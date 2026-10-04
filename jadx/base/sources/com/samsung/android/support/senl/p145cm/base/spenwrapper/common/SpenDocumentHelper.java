package com.samsung.android.support.senl.p145cm.base.spenwrapper.common;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/SpenDocumentHelper;", "", "<init>", "()V", "updateDefaultHeight", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenDocumentHelper {

    @NotNull
    public static final SpenDocumentHelper INSTANCE = new SpenDocumentHelper();

    private SpenDocumentHelper() {
    }

    @JvmStatic
    public static final void updateDefaultHeight(@Nullable SpenWNote note) {
        if (note == null || note.getPageDefaultHeight() != 0) {
            return;
        }
        if (note.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            note.setPageDefaultHeight((int) (note.getPageDefaultWidth() / 1.4142857f));
        } else {
            note.setPageDefaultHeight((int) (note.getPageDefaultWidth() * 1.4142857f));
        }
    }
}
