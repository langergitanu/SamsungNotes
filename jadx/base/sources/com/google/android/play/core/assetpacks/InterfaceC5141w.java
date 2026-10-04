package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.w */
/* JADX INFO: loaded from: classes5.dex */
interface InterfaceC5141w {
    /* JADX INFO: renamed from: a */
    Task<AssetPackStates> mo3664a(List<String> list, InterfaceC5042az interfaceC5042az, Map<String, Long> map);

    /* JADX INFO: renamed from: a */
    Task<AssetPackStates> mo3665a(List<String> list, List<String> list2, Map<String, Long> map);

    /* JADX INFO: renamed from: a */
    Task<List<String>> mo3666a(Map<String, Long> map);

    /* JADX INFO: renamed from: a */
    void mo3667a();

    /* JADX INFO: renamed from: a */
    void mo3668a(int i);

    /* JADX INFO: renamed from: a */
    void mo3669a(int i, String str);

    /* JADX INFO: renamed from: a */
    void mo3670a(int i, String str, String str2, int i2);

    /* JADX INFO: renamed from: a */
    void mo3671a(String str);

    /* JADX INFO: renamed from: a */
    void mo3672a(List<String> list);

    /* JADX INFO: renamed from: b */
    Task<ParcelFileDescriptor> mo3673b(int i, String str, String str2, int i2);
}
