package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintManager {
    private SpenWNote mNote;

    public ConstraintManager(SpenWNote spenWNote) {
        this.mNote = spenWNote;
    }

    public int getThumbnailCount() {
        Iterator<SpenWPage> it = this.mNote.getPageList().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().getObjectList(4).size();
        }
        return size;
    }

    public int getThumbnailMaxCount() {
        return 99999999;
    }
}
