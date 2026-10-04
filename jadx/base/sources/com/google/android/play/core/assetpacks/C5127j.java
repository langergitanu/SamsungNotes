package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5224h;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.splitinstall.C5315p;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.j */
/* JADX INFO: loaded from: classes5.dex */
final class C5127j implements AssetPackManager {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2880a = new C5157af("AssetPackManager");

    /* JADX INFO: renamed from: b */
    private final C5045bb f2881b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5215cj<InterfaceC5141w> f2882c;

    /* JADX INFO: renamed from: d */
    private final C5039aw f2883d;

    /* JADX INFO: renamed from: e */
    private final C5315p f2884e;

    /* JADX INFO: renamed from: f */
    private final C5086cp f2885f;

    /* JADX INFO: renamed from: g */
    private final C5069bz f2886g;

    /* JADX INFO: renamed from: h */
    private final C5057bn f2887h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC5215cj<Executor> f2888i;

    /* JADX INFO: renamed from: j */
    private final Handler f2889j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k */
    private boolean f2890k;

    public C5127j(C5045bb c5045bb, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5039aw c5039aw, C5315p c5315p, C5086cp c5086cp, C5069bz c5069bz, C5057bn c5057bn, InterfaceC5215cj<Executor> interfaceC5215cj2) {
        this.f2881b = c5045bb;
        this.f2882c = interfaceC5215cj;
        this.f2883d = c5039aw;
        this.f2884e = c5315p;
        this.f2885f = c5086cp;
        this.f2886g = c5069bz;
        this.f2887h = c5057bn;
        this.f2888i = interfaceC5215cj2;
    }

    /* JADX INFO: renamed from: c */
    private final void m3838c() {
        this.f2888i.m3979a().execute(new Runnable(this) { // from class: com.google.android.play.core.assetpacks.e

            /* JADX INFO: renamed from: a */
            private final C5127j f2874a;

            {
                this.f2874a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2874a.m3844b();
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private final void m3839d() {
        this.f2888i.m3979a().execute(new RunnableC5123f(this));
        this.f2890k = true;
    }

    @AssetPackStatus
    /* JADX INFO: renamed from: a */
    public final int m3840a(@AssetPackStatus int i, String str) {
        if (!this.f2881b.m3698a(str) && i == 4) {
            return 8;
        }
        if (!this.f2881b.m3698a(str) || i == 4) {
            return i;
        }
        return 4;
    }

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void m3844b() {
        Task<List<String>> taskMo3666a = this.f2882c.m3979a().mo3666a(this.f2881b.m3702b());
        Executor executorM3979a = this.f2888i.m3979a();
        C5045bb c5045bb = this.f2881b;
        c5045bb.getClass();
        taskMo3666a.addOnSuccessListener(executorM3979a, C5124g.m3835a(c5045bb)).addOnFailureListener(this.f2888i.m3979a(), C5125h.f2877a);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> mapM3751a = this.f2885f.m3751a(list);
        HashMap map = new HashMap();
        for (String str : list) {
            Integer num = mapM3751a.get(str);
            map.put(str, AssetPackState.m3624a(str, num == null ? 0 : num.intValue(), 0, 0L, 0L, 0.0d));
        }
        this.f2882c.m3979a().mo3672a(list);
        return AssetPackStates.m3625a(0L, map);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void clearListeners() {
        this.f2883d.m4032a();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> mapM3702b = this.f2881b.m3702b();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(mapM3702b.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.f2882c.m3979a().mo3665a(arrayList2, arrayList, mapM3702b);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String str : list) {
            bundle.putInt(C5224h.m3993a("status", str), 4);
            bundle.putInt(C5224h.m3993a("error_code", str), 0);
            bundle.putLong(C5224h.m3993a("total_bytes_to_download", str), 0L);
            bundle.putLong(C5224h.m3993a("bytes_downloaded", str), 0L);
        }
        bundle.putStringArrayList("pack_names", new ArrayList<>(list));
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        return Tasks.m4185a(AssetPackStates.m3626a(bundle, this.f2886g));
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    @Nullable
    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocationM3699b;
        if (!this.f2890k) {
            this.f2888i.m3979a().execute(new RunnableC5123f(this));
            this.f2890k = true;
        }
        if (this.f2881b.m3698a(str)) {
            try {
                assetPackLocationM3699b = this.f2881b.m3699b(str);
            } catch (IOException unused) {
            }
        } else {
            assetPackLocationM3699b = this.f2884e.m4148a().contains(str) ? AssetPackLocation.m3621a() : null;
        }
        if (assetPackLocationM3699b == null) {
            return null;
        }
        if (assetPackLocationM3699b.packStorageMethod() == 1) {
            return this.f2881b.m3691a(str, str2);
        }
        if (assetPackLocationM3699b.packStorageMethod() == 0) {
            return this.f2881b.m3692a(str, str2, assetPackLocationM3699b);
        }
        f2880a.m3875a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    @Nullable
    public final AssetPackLocation getPackLocation(String str) {
        if (!this.f2890k) {
            m3839d();
        }
        if (this.f2881b.m3698a(str)) {
            try {
                return this.f2881b.m3699b(str);
            } catch (IOException unused) {
                return null;
            }
        }
        if (this.f2884e.m4148a().contains(str)) {
            return AssetPackLocation.m3621a();
        }
        return null;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> mapM3695a = this.f2881b.m3695a();
        HashMap map = new HashMap();
        Iterator<String> it = this.f2884e.m4148a().iterator();
        while (it.hasNext()) {
            map.put(it.next(), AssetPackLocation.m3621a());
        }
        mapM3695a.putAll(map);
        return mapM3695a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.f2882c.m3979a().mo3664a(list, new InterfaceC5042az(this) { // from class: com.google.android.play.core.assetpacks.c

            /* JADX INFO: renamed from: a */
            private final C5127j f2709a;

            {
                this.f2709a = this;
            }

            @Override // com.google.android.play.core.assetpacks.InterfaceC5042az
            /* JADX INFO: renamed from: a */
            public final int mo3677a(int i, String str) {
                return this.f2709a.m3840a(i, str);
            }
        }, this.f2881b.m3702b());
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean zM4037b = this.f2883d.m4037b();
        this.f2883d.m4033a((StateUpdatedListener) assetPackStateUpdateListener);
        if (zM4037b) {
            return;
        }
        m3838c();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Void> removePack(final String str) {
        final C5345i c5345i = new C5345i();
        this.f2888i.m3979a().execute(new Runnable(this, str, c5345i) { // from class: com.google.android.play.core.assetpacks.d

            /* JADX INFO: renamed from: a */
            private final C5127j f2787a;

            /* JADX INFO: renamed from: b */
            private final String f2788b;

            /* JADX INFO: renamed from: c */
            private final C5345i f2789c;

            {
                this.f2787a = this;
                this.f2788b = str;
                this.f2789c = c5345i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2787a.m3842a(this.f2788b, this.f2789c);
            }
        });
        return c5345i.m4197a();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (this.f2887h.m3729a() == null) {
            return Tasks.m4184a((Exception) new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f2887h.m3729a());
        C5345i c5345i = new C5345i();
        intent.putExtra("result_receiver", new ResultReceiverC5126i(this, this.f2889j, c5345i));
        activity.startActivity(intent);
        return c5345i.m4197a();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.f2883d.m4036b(assetPackStateUpdateListener);
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3841a() {
        this.f2881b.m3709d();
        this.f2881b.m3706c();
        this.f2881b.m3714e();
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3842a(String str, C5345i c5345i) {
        if (!this.f2881b.m3710d(str)) {
            c5345i.m4198a((Exception) new IOException(AbstractC0541b.m773o("Failed to remove pack ", str, Extension.DOT)));
        } else {
            c5345i.m4199a((Object) null);
            this.f2882c.m3979a().mo3671a(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3843a(boolean z) {
        boolean zM4037b = this.f2883d.m4037b();
        this.f2883d.m4035a(z);
        if (!z || zM4037b) {
            return;
        }
        m3838c();
    }
}
