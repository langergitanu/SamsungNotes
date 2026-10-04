package com.samsung.android.support.senl.p148nt.model.utils;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentPageUtils {
    public static SpenWNote.PageMode convertSettingsPageTypeToWNotePageMode(int i) {
        return i == 0 ? SpenWNote.PageMode.SINGLE : SpenWNote.PageMode.LIST;
    }

    @PageMode
    public static int convertToPageMode(SpenWNote.PageMode pageMode) {
        return pageMode == SpenWNote.PageMode.SINGLE ? 1 : 2;
    }

    public static SpenWNote.PageMode convertToWNotePageMode(@PageMode int i) {
        return i == 1 ? SpenWNote.PageMode.SINGLE : SpenWNote.PageMode.LIST;
    }
}
