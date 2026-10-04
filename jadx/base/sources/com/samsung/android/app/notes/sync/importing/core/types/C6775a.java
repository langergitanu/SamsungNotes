package com.samsung.android.app.notes.sync.importing.core.types;

import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.IntConsumer;
import org.json.JSONArray;
import p089W.C0329c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.core.types.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6775a implements IntConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4153a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ImportBaseTask f4154b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4155c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Serializable f4156d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f4157e;

    public /* synthetic */ C6775a(MemoLocalSync memoLocalSync, File file, String[] strArr, File file2) {
        this.f4154b = memoLocalSync;
        this.f4155c = file;
        this.f4157e = strArr;
        this.f4156d = file2;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f4153a) {
            case 0:
                ((MemoLocalSync) this.f4154b).lambda$copyDirectory$1((File) this.f4155c, (String[]) this.f4157e, (File) this.f4156d, i);
                break;
            default:
                ((SnoteScloudSync) this.f4154b).lambda$getSPDImportListFromServer$0((JSONArray) this.f4155c, (ArrayList) this.f4156d, (C0329c) this.f4157e, i);
                break;
        }
    }

    public /* synthetic */ C6775a(SnoteScloudSync snoteScloudSync, JSONArray jSONArray, ArrayList arrayList, C0329c c0329c) {
        this.f4154b = snoteScloudSync;
        this.f4155c = jSONArray;
        this.f4156d = arrayList;
        this.f4157e = c0329c;
    }
}
