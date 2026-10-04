package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AssetPackStates {
    /* JADX INFO: renamed from: a */
    public static AssetPackStates m3625a(long j, Map<String, AssetPackState> map) {
        return new C5052bi(j, map);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();

    /* JADX INFO: renamed from: a */
    public static AssetPackStates m3626a(Bundle bundle, C5069bz c5069bz) {
        return m3628a(bundle, c5069bz, new ArrayList());
    }

    /* JADX INFO: renamed from: a */
    public static AssetPackStates m3627a(Bundle bundle, C5069bz c5069bz, InterfaceC5042az interfaceC5042az) {
        return m3629a(bundle, c5069bz, new ArrayList(), interfaceC5042az);
    }

    /* JADX INFO: renamed from: a */
    public static AssetPackStates m3628a(Bundle bundle, C5069bz c5069bz, List<String> list) {
        return m3629a(bundle, c5069bz, list, C5044ba.f2598a);
    }

    /* JADX INFO: renamed from: a */
    private static AssetPackStates m3629a(Bundle bundle, C5069bz c5069bz, List<String> list, InterfaceC5042az interfaceC5042az) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap map = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            map.put(str, AssetPackState.m3623a(bundle, str, c5069bz, interfaceC5042az));
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = list.get(i2);
            map.put(str2, AssetPackState.m3624a(str2, 4, 0, 0L, 0L, 0.0d));
        }
        return m3625a(bundle.getLong("total_bytes_to_download"), map);
    }
}
