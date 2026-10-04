package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5173av;
import com.google.android.play.core.internal.C5224h;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.cz */
/* JADX INFO: loaded from: classes5.dex */
final class C5096cz implements InterfaceC5141w {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2778a = new C5157af("FakeAssetPackService");

    /* JADX INFO: renamed from: h */
    private static final AtomicInteger f2779h = new AtomicInteger(1);

    /* JADX INFO: renamed from: b */
    private final String f2780b;

    /* JADX INFO: renamed from: c */
    private final C5039aw f2781c;

    /* JADX INFO: renamed from: d */
    private final C5069bz f2782d;

    /* JADX INFO: renamed from: e */
    private final Context f2783e;

    /* JADX INFO: renamed from: f */
    private final C5109dl f2784f;

    /* JADX INFO: renamed from: g */
    private final InterfaceC5215cj<Executor> f2785g;

    /* JADX INFO: renamed from: i */
    private final Handler f2786i = new Handler(Looper.getMainLooper());

    public C5096cz(File file, C5039aw c5039aw, C5069bz c5069bz, Context context, C5109dl c5109dl, InterfaceC5215cj<Executor> interfaceC5215cj) {
        this.f2780b = file.getAbsolutePath();
        this.f2781c = c5039aw;
        this.f2782d = c5069bz;
        this.f2783e = context;
        this.f2784f = c5109dl;
        this.f2785g = interfaceC5215cj;
    }

    /* JADX INFO: renamed from: a */
    public static long m3770a(@AssetPackStatus int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0L;
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: b */
    public final Task<ParcelFileDescriptor> mo3673b(int i, String str, String str2, int i2) {
        int i4;
        C5345i c5345iM3195e = AbstractC4539a.m3195e(f2778a, "getChunkFileDescriptor(session=%d, %s, %s, %d)", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
        try {
        } catch (LocalTestingException e) {
            f2778a.m3879d("getChunkFileDescriptor failed", e);
            c5345iM3195e.m4198a((Exception) e);
        } catch (FileNotFoundException e2) {
            f2778a.m3879d("getChunkFileDescriptor failed", e2);
            c5345iM3195e.m4198a((Exception) new LocalTestingException("Asset Slice file not found.", e2));
        }
        for (File file : m3774b(str)) {
            if (C5173av.m3911a(file).equals(str2)) {
                c5345iM3195e.m4199a(ParcelFileDescriptor.open(file, 268435456));
                return c5345iM3195e.m4197a();
            }
        }
        throw new LocalTestingException("Local testing slice for '" + str2 + "' not found.");
    }

    /* JADX INFO: renamed from: a */
    private final AssetPackState m3771a(String str, @AssetPackStatus int i) throws LocalTestingException {
        long length = 0;
        for (File file : m3774b(str)) {
            length += file.length();
        }
        return AssetPackState.m3624a(str, i, 0, m3770a(i, length), length, this.f2782d.m3742b(str));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<AssetPackStates> mo3664a(final List<String> list, final InterfaceC5042az interfaceC5042az, Map<String, Long> map) {
        final C5345i c5345iM3195e = AbstractC4539a.m3195e(f2778a, "getPackStates(%s)", new Object[]{list});
        this.f2785g.m3979a().execute(new Runnable(this, list, interfaceC5042az, c5345iM3195e) { // from class: com.google.android.play.core.assetpacks.cv

            /* JADX INFO: renamed from: a */
            private final C5096cz f2768a;

            /* JADX INFO: renamed from: b */
            private final List f2769b;

            /* JADX INFO: renamed from: c */
            private final InterfaceC5042az f2770c;

            /* JADX INFO: renamed from: d */
            private final C5345i f2771d;

            {
                this.f2768a = this;
                this.f2769b = list;
                this.f2770c = interfaceC5042az;
                this.f2771d = c5345iM3195e;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2768a.m3776a(this.f2769b, this.f2770c, this.f2771d);
            }
        });
        return c5345iM3195e.m4197a();
    }

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void m3778b(int i, String str) {
        try {
            m3773a(i, str, 4);
        } catch (LocalTestingException e) {
            f2778a.m3879d("notifyModuleCompleted failed", e);
        }
    }

    /* JADX INFO: renamed from: b */
    private final File[] m3774b(final String str) throws LocalTestingException {
        File file = new File(this.f2780b);
        if (!file.isDirectory()) {
            throw new LocalTestingException(String.format("Local testing directory '%s' not found.", file));
        }
        File[] fileArrListFiles = file.listFiles(new FilenameFilter(str) { // from class: com.google.android.play.core.assetpacks.cx

            /* JADX INFO: renamed from: a */
            private final String f2775a;

            {
                this.f2775a = str;
            }

            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return str2.startsWith(String.valueOf(this.f2775a).concat(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) && str2.endsWith(".apk");
            }
        });
        if (fileArrListFiles == null) {
            throw new LocalTestingException(AbstractC0541b.m773o("Failed fetching APKs for pack '", str, "'."));
        }
        if (fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (C5173av.m3911a(file2).equals(str)) {
                    return fileArrListFiles;
                }
            }
            throw new LocalTestingException(AbstractC0541b.m773o("No master slice available for pack '", str, "'."));
        }
        throw new LocalTestingException(AbstractC0541b.m773o("No APKs available for pack '", str, "'."));
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<AssetPackStates> mo3665a(final List<String> list, final List<String> list2, Map<String, Long> map) {
        final C5345i c5345iM3195e = AbstractC4539a.m3195e(f2778a, "startDownload(%s)", new Object[]{list2});
        this.f2785g.m3979a().execute(new Runnable(this, list2, c5345iM3195e, list) { // from class: com.google.android.play.core.assetpacks.cu

            /* JADX INFO: renamed from: a */
            private final C5096cz f2764a;

            /* JADX INFO: renamed from: b */
            private final List f2765b;

            /* JADX INFO: renamed from: c */
            private final C5345i f2766c;

            /* JADX INFO: renamed from: d */
            private final List f2767d;

            {
                this.f2764a = this;
                this.f2765b = list2;
                this.f2766c = c5345iM3195e;
                this.f2767d = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2764a.m3777a(this.f2765b, this.f2766c, this.f2767d);
            }
        });
        return c5345iM3195e.m4197a();
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final Task<List<String>> mo3666a(Map<String, Long> map) {
        f2778a.m3878c("syncPacks()", new Object[0]);
        return Tasks.m4185a(new ArrayList());
    }

    /* JADX INFO: renamed from: a */
    private static String m3772a(File file) throws LocalTestingException {
        try {
            return C5099db.m3783a((List<File>) Arrays.asList(file));
        } catch (IOException e) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", file), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e2);
        }
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3667a() {
        f2778a.m3878c("keepAlive", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3668a(int i) {
        f2778a.m3878c("notifySessionFailed", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3669a(final int i, final String str) {
        f2778a.m3878c("notifyModuleCompleted", new Object[0]);
        this.f2785g.m3979a().execute(new Runnable(this, i, str) { // from class: com.google.android.play.core.assetpacks.cw

            /* JADX INFO: renamed from: a */
            private final C5096cz f2772a;

            /* JADX INFO: renamed from: b */
            private final int f2773b;

            /* JADX INFO: renamed from: c */
            private final String f2774c;

            {
                this.f2772a = this;
                this.f2773b = i;
                this.f2774c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2772a.m3778b(this.f2773b, this.f2774c);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private final void m3773a(int i, String str, @AssetPackStatus int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f2784f.m3800a());
        bundle.putInt("session_id", i);
        File[] fileArrM3774b = m3774b(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long length = 0;
        for (File file : fileArrM3774b) {
            length += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String strM3911a = C5173av.m3911a(file);
            bundle.putParcelableArrayList(C5224h.m3994a("chunk_intents", str, strM3911a), arrayList2);
            bundle.putString(C5224h.m3994a("uncompressed_hash_sha256", str, strM3911a), m3772a(file));
            bundle.putLong(C5224h.m3994a("uncompressed_size", str, strM3911a), file.length());
            arrayList.add(strM3911a);
        }
        bundle.putStringArrayList(C5224h.m3993a("slice_ids", str), arrayList);
        bundle.putLong(C5224h.m3993a("pack_version", str), this.f2784f.m3800a());
        bundle.putInt(C5224h.m3993a("status", str), i2);
        bundle.putInt(C5224h.m3993a("error_code", str), 0);
        bundle.putLong(C5224h.m3993a("bytes_downloaded", str), m3770a(i2, length));
        bundle.putLong(C5224h.m3993a("total_bytes_to_download", str), length);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", m3770a(i2, length));
        bundle.putLong("total_bytes_to_download", length);
        final Intent intentPutExtra = new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle);
        this.f2786i.post(new Runnable(this, intentPutExtra) { // from class: com.google.android.play.core.assetpacks.cy

            /* JADX INFO: renamed from: a */
            private final C5096cz f2776a;

            /* JADX INFO: renamed from: b */
            private final Intent f2777b;

            {
                this.f2776a = this;
                this.f2777b = intentPutExtra;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2776a.m3775a(this.f2777b);
            }
        });
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3670a(int i, String str, String str2, int i2) {
        f2778a.m3878c("notifyChunkTransferred", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3775a(Intent intent) {
        this.f2781c.mo3590a(this.f2783e, intent);
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3671a(String str) {
        f2778a.m3878c("removePack(%s)", str);
    }

    @Override // com.google.android.play.core.assetpacks.InterfaceC5141w
    /* JADX INFO: renamed from: a */
    public final void mo3672a(List<String> list) {
        f2778a.m3878c("cancelDownload(%s)", list);
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3776a(List list, InterfaceC5042az interfaceC5042az, C5345i c5345i) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState assetPackStateM3771a = m3771a(str, interfaceC5042az.mo3677a(8, str));
                j += assetPackStateM3771a.totalBytesToDownload();
                map.put(str, assetPackStateM3771a);
            } catch (LocalTestingException e) {
                c5345i.m4198a((Exception) e);
                return;
            }
        }
        c5345i.m4199a(AssetPackStates.m3625a(j, map));
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m3777a(List list, C5345i c5345i, List list2) {
        HashMap map = new HashMap();
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            try {
                AssetPackState assetPackStateM3771a = m3771a(str, 1);
                j += assetPackStateM3771a.totalBytesToDownload();
                map.put(str, assetPackStateM3771a);
            } catch (LocalTestingException e) {
                c5345i.m4198a((Exception) e);
                return;
            }
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = (String) list.get(i2);
            try {
                int andIncrement = f2779h.getAndIncrement();
                m3773a(andIncrement, str2, 1);
                m3773a(andIncrement, str2, 2);
                m3773a(andIncrement, str2, 3);
            } catch (LocalTestingException e2) {
                c5345i.m4198a((Exception) e2);
                return;
            }
        }
        int size3 = list2.size();
        for (int i4 = 0; i4 < size3; i4++) {
            String str3 = (String) list2.get(i4);
            map.put(str3, AssetPackState.m3624a(str3, 4, 0, 0L, 0L, 0.0d));
        }
        c5345i.m4199a(AssetPackStates.m3625a(j, map));
    }
}
