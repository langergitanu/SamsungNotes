package com.samsung.android.app.notes.sync.importing.core;

import android.content.Context;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;
import com.samsung.android.app.notes.sync.importing.core.types.MemoCloudImportType;
import com.samsung.android.app.notes.sync.importing.core.types.MemoLocalImportType;
import com.samsung.android.app.notes.sync.importing.core.types.ScrapbookCloudImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveImportHelperAdapter;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteNetworkImportType;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HelperClassRegistry {
    private static final String TAG = "HelperClassRegistry";
    private HashMap<Class<?>, Class<?>> mHelperClassMap = new HashMap<>();
    private HashMap<Class<?>, Class<?>> mAdapterClassMap = new HashMap<>();

    public HelperClassRegistry() {
        this.mHelperClassMap.put(SnoteLocalImportType.class, SnoteLocalImportHelper.class);
        this.mHelperClassMap.put(SnoteNetworkImportType.class, SnoteCloudImportHelper.class);
        this.mHelperClassMap.put(MemoLocalImportType.class, MemoLocalImportHelper.class);
        this.mHelperClassMap.put(MemoCloudImportType.class, MemoCloudImportHelper.class);
        this.mHelperClassMap.put(ScrapbookCloudImportType.class, ScrapbookCloudImportHelper.class);
        this.mHelperClassMap.put(SnoteGoogleDriveImportType.class, SnoteGoogleImportHelper.class);
        Iterator<Class<?>> it = this.mHelperClassMap.keySet().iterator();
        while (it.hasNext()) {
            this.mAdapterClassMap.put(it.next(), BasicImportHelperAdapter.class);
        }
        this.mAdapterClassMap.put(SnoteGoogleDriveImportType.class, SnoteGoogleDriveImportHelperAdapter.class);
    }

    public BasicImportHelperAdapter createImportHelperAdapter(Context context, AbstractImportType abstractImportType) {
        return createImportHelperAdapterClassByType(createImportHelperClassByType(context, abstractImportType), abstractImportType);
    }

    public BasicImportHelperAdapter createImportHelperAdapterClassByType(ImportHelper importHelper, AbstractImportType abstractImportType) {
        Class<?> cls = this.mAdapterClassMap.get(abstractImportType.getClass());
        if (cls == null) {
            return null;
        }
        try {
            return (BasicImportHelperAdapter) cls.getConstructor(ImportHelper.class).newInstance(importHelper);
        } catch (Exception e) {
            Debugger.m8607d(TAG, e.toString());
            return null;
        }
    }

    public ImportHelper createImportHelperClassByType(Context context, AbstractImportType abstractImportType) {
        Class<?> cls = this.mHelperClassMap.get(abstractImportType.getClass());
        if (cls == null) {
            return null;
        }
        try {
            return (ImportHelper) cls.getConstructor(Context.class).newInstance(context);
        } catch (Exception e) {
            Debugger.m8607d(TAG, e.toString());
            return null;
        }
    }
}
