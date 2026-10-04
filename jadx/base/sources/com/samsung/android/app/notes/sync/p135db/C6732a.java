package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import java.util.HashMap;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6732a extends C6735d {

    /* JADX INFO: renamed from: b */
    public final HashMap f4094b;

    public C6732a(Context context, HashMap map) {
        super(context);
        this.f4094b = map;
    }

    /* JADX INFO: renamed from: f */
    public final SyncCategoryTreeInfo m4825f(String str) {
        HashMap map = this.f4094b;
        if (map != null) {
            return (SyncCategoryTreeInfo) map.get(str);
        }
        return null;
    }
}
