package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5167ap;
import com.google.android.play.core.internal.C5203by;
import com.google.android.play.core.internal.InterfaceC5235s;
import com.google.android.play.core.splitcompat.C5271p;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ar */
/* JADX INFO: loaded from: classes5.dex */
final class C5034ar implements InterfaceC5141w {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2559a = new C5157af("AssetPackServiceImpl");

    /* JADX INFO: renamed from: b */
    private static final Intent f2560b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: c */
    private final String f2561c;

    /* JADX INFO: renamed from: d */
    private final C5069bz f2562d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private C5167ap<InterfaceC5235s> f2563e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private C5167ap<InterfaceC5235s> f2564f;

    /* JADX INFO: renamed from: g */
    private final AtomicBoolean f2565g = new AtomicBoolean();

    public C5034ar(Context context, C5069bz c5069bz) {
        this.f2561c = context.getPackageName();
        this.f2562d = c5069bz;
        if (C5203by.m3973a(context)) {
            Context contextM4096a = C5271p.m4096a(context);
            C5157af c5157af = f2559a;
            Intent intent = f2560b;
            this.f2563e = new C5167ap<>(contextM4096a, c5157af, "AssetPackService", intent, C5142x.f2913a);
            this.f2564f = new C5167ap<>(C5271p.m4096a(context), c5157af, "AssetPackService-keepAlive", intent, C5143y.f2914a);
        }
        f2559a.m3875a("AssetPackService initiated.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public static Bundle m3662e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList<>());
        return bundle;
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<AssetPackStates> mo3664a(List<String> list, InterfaceC5042az interfaceC5042az, Map<String, Long> map) {
        if (this.f2563e == null) {
            return m3661d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "getPackStates(%s)", new Object[]{list});
        this.f2563e.m3897a(new C5021ae(this, c5345iM3195e, list, map, c5345iM3195e, interfaceC5042az));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static Bundle m3656c(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* JADX INFO: renamed from: d */
    private static <T> Task<T> m3661d() {
        f2559a.m3877b("onError(%d)", -11);
        return Tasks.m4184a((Exception) new AssetPackException(-11));
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ Bundle m3652b(Map map) {
        Bundle bundleM3662e = m3662e();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        bundleM3662e.putParcelableArrayList("installed_asset_module", arrayList);
        return bundleM3662e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static Bundle m3657c(int i, String str) {
        Bundle bundleM3656c = m3656c(i);
        bundleM3656c.putString("module_name", str);
        return bundleM3656c;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ Bundle m3658c(int i, String str, String str2, int i2) {
        Bundle bundleM3657c = m3657c(i, str);
        bundleM3657c.putString("slice_id", str2);
        bundleM3657c.putInt("chunk_number", i2);
        return bundleM3657c;
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<AssetPackStates> mo3665a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.f2563e == null) {
            return m3661d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "startDownload(%s)", new Object[]{list2});
        this.f2563e.m3897a(new C5018ab(this, c5345iM3195e, list2, map, c5345iM3195e, list));
        c5345iM3195e.m4197a().addOnSuccessListener(new OnSuccessListener(this) { // from class: com.google.android.play.core.assetpacks.z

            /* JADX INFO: renamed from: a */
            private final C5034ar f2915a;

            {
                this.f2915a = this;
            }

            @Override // com.google.android.play.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f2915a.mo3667a();
            }
        });
        return c5345iM3195e.m4197a();
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: b */
    public final Task<ParcelFileDescriptor> mo3673b(int i, String str, String str2, int i2) {
        if (this.f2563e == null) {
            return m3661d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "getChunkFileDescriptor(%s, %s, %d, session=%d)", new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i)});
        this.f2563e.m3897a(new C5025ai(this, c5345iM3195e, i, str, str2, i2, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<List<String>> mo3666a(Map<String, Long> map) {
        if (this.f2563e == null) {
            return m3661d();
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "syncPacks", new Object[0]);
        this.f2563e.m3897a(new C5020ad(this, c5345iM3195e, map, c5345iM3195e));
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ ArrayList m3646a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ List m3647a(C5034ar c5034ar, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AssetPackState next = AssetPackStates.m3626a((Bundle) list.get(i), c5034ar.f2562d).packStates().values().iterator().next();
            if (next == null) {
                f2559a.m3877b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C5099db.m3784a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final synchronized void mo3667a() {
        if (this.f2564f == null) {
            f2559a.m3879d("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        C5157af c5157af = f2559a;
        c5157af.m3878c("keepAlive", new Object[0]);
        if (!this.f2565g.compareAndSet(false, true)) {
            c5157af.m3878c("Service is already kept alive.", new Object[0]);
        } else {
            C5345i c5345i = new C5345i();
            this.f2564f.m3897a(new C5026aj(this, c5345i, c5345i));
        }
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3668a(int i) {
        if (this.f2563e == null) {
            throw new C5065bv("The Play Store app is not installed or is an unofficial version.", i);
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "notifySessionFailed", new Object[0]);
        this.f2563e.m3897a(new C5024ah(this, c5345iM3195e, i, c5345iM3195e));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3669a(int i, String str) {
        m3648a(i, str, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m3648a(int i, String str, int i2) {
        if (this.f2563e == null) {
            throw new C5065bv("The Play Store app is not installed or is an unofficial version.", i);
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "notifyModuleCompleted", new Object[0]);
        this.f2563e.m3897a(new C5023ag(this, c5345iM3195e, i, str, c5345iM3195e, i2));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3670a(int i, String str, String str2, int i2) {
        if (this.f2563e == null) {
            throw new C5065bv("The Play Store app is not installed or is an unofficial version.", i);
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "notifyChunkTransferred", new Object[0]);
        this.f2563e.m3897a(new C5022af(this, c5345iM3195e, i, str, str2, i2, c5345iM3195e));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3671a(String str) {
        if (this.f2563e == null) {
            return;
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "removePack(%s)", new Object[]{str});
        this.f2563e.m3897a(new C5017aa(this, c5345iM3195e, str, c5345iM3195e));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3672a(List<String> list) {
        if (this.f2563e == null) {
            return;
        }
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2559a, "cancelDownloads(%s)", new Object[]{list});
        this.f2563e.m3897a(new C5019ac(this, c5345iM3195e, list, c5345iM3195e));
    }
}
