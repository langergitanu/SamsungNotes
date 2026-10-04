package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C5156ae;
import com.google.android.play.core.internal.C5173av;
import com.google.android.play.core.internal.C5202bx;
import com.google.android.play.core.splitcompat.C5271p;
import com.google.android.play.core.splitinstall.C5306h;
import com.google.android.play.core.splitinstall.C5315p;
import com.google.android.play.core.splitinstall.EnumC5310l;
import com.google.android.play.core.splitinstall.InterfaceC5303e;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class FakeSplitInstallManager implements SplitInstallManager {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f3153a = 0;

    /* JADX INFO: renamed from: c */
    private static final long f3154c = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: b */
    private final Handler f3155b;

    /* JADX INFO: renamed from: d */
    private final Context f3156d;

    /* JADX INFO: renamed from: e */
    private final C5315p f3157e;

    /* JADX INFO: renamed from: f */
    private final C5202bx f3158f;

    /* JADX INFO: renamed from: g */
    private final C5156ae<SplitInstallSessionState> f3159g;

    /* JADX INFO: renamed from: h */
    private final Executor f3160h;

    /* JADX INFO: renamed from: i */
    private final InterfaceC5303e f3161i;

    /* JADX INFO: renamed from: j */
    private final File f3162j;

    /* JADX INFO: renamed from: k */
    private final AtomicReference<SplitInstallSessionState> f3163k;

    /* JADX INFO: renamed from: l */
    private final Set<String> f3164l;

    /* JADX INFO: renamed from: m */
    private final Set<String> f3165m;

    /* JADX INFO: renamed from: n */
    private final AtomicBoolean f3166n;

    /* JADX INFO: renamed from: o */
    private final C5320a f3167o;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new C5315p(context, context.getPackageName()));
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ SplitInstallSessionState m4155a(int i, SplitInstallSessionState splitInstallSessionState) {
        int iStatus;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((iStatus = splitInstallSessionState.status()) == 1 || iStatus == 2 || iStatus == 8 || iStatus == 9 || iStatus == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    private final SplitInstallSessionState m4169c() {
        return this.f3163k.get();
    }

    /* JADX INFO: renamed from: d */
    private final C5306h m4170d() {
        C5306h c5306hM4150c = this.f3157e.m4150c();
        if (c5306hM4150c != null) {
            return c5306hM4150c;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(final int i) {
        try {
            SplitInstallSessionState splitInstallSessionStateM4156a = m4156a(new InterfaceC5329j(i) { // from class: com.google.android.play.core.splitinstall.testing.e

                /* JADX INFO: renamed from: a */
                private final int f3181a;

                {
                    this.f3181a = i;
                }

                @Override // com.google.android.play.core.splitinstall.testing.InterfaceC5329j
                /* JADX INFO: renamed from: a */
                public final SplitInstallSessionState mo4176a(SplitInstallSessionState splitInstallSessionState) {
                    return FakeSplitInstallManager.m4155a(this.f3181a, splitInstallSessionState);
                }
            });
            if (splitInstallSessionStateM4156a != null) {
                m4168b(splitInstallSessionStateM4156a);
            }
            return Tasks.m4185a((Object) null);
        } catch (SplitInstallException e) {
            return Tasks.m4184a((Exception) e);
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.m4184a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.m4184a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.m4184a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.m4184a((Exception) new SplitInstallException(-5));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        return new HashSet(this.f3165m);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        return new HashSet(this.f3164l);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState splitInstallSessionStateM4169c = m4169c();
        return (splitInstallSessionStateM4169c == null || splitInstallSessionStateM4169c.sessionId() != i) ? Tasks.m4184a((Exception) new SplitInstallException(-4)) : Tasks.m4185a(splitInstallSessionStateM4169c);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState splitInstallSessionStateM4169c = m4169c();
        return Tasks.m4185a(splitInstallSessionStateM4169c != null ? Collections.singletonList(splitInstallSessionStateM4169c) : Collections.EMPTY_LIST);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3159g.m3870a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.f3166n.set(z);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) {
        return false;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        int i;
        File[] fileArr;
        int i2;
        int i4;
        try {
            final SplitInstallRequest splitInstallRequest2 = splitInstallRequest;
            SplitInstallSessionState splitInstallSessionStateM4156a = m4156a(new InterfaceC5329j(splitInstallRequest2) { // from class: com.google.android.play.core.splitinstall.testing.d

                /* JADX INFO: renamed from: a */
                private final SplitInstallRequest f3180a;

                {
                    this.f3180a = splitInstallRequest2;
                }

                @Override // com.google.android.play.core.splitinstall.testing.InterfaceC5329j
                /* JADX INFO: renamed from: a */
                public final SplitInstallSessionState mo4176a(SplitInstallSessionState splitInstallSessionState) {
                    SplitInstallRequest splitInstallRequest3 = this.f3180a;
                    int i5 = FakeSplitInstallManager.f3153a;
                    if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
                        return SplitInstallSessionState.create(splitInstallSessionState != null ? 1 + splitInstallSessionState.sessionId() : 1, 1, 0, 0L, 0L, splitInstallRequest3.getModuleNames(), new ArrayList());
                    }
                    throw new SplitInstallException(-1);
                }
            });
            if (splitInstallSessionStateM4156a == null) {
                return Tasks.m4184a((Exception) new SplitInstallException(-100));
            }
            int iSessionId = splitInstallSessionStateM4156a.sessionId();
            final ArrayList arrayList = new ArrayList();
            Iterator<Locale> it = splitInstallRequest2.getLanguages().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getLanguage());
            }
            HashSet hashSet = new HashSet();
            final ArrayList arrayList2 = new ArrayList();
            File[] fileArrListFiles = this.f3162j.listFiles();
            if (fileArrListFiles == null) {
                Log.w("FakeSplitInstallManager", "Specified splits directory does not exist.");
                return Tasks.m4184a((Exception) new SplitInstallException(-5));
            }
            int length = fileArrListFiles.length;
            int i5 = 0;
            long length2 = 0;
            while (i5 < length) {
                File file = fileArrListFiles[i5];
                String strM3911a = C5173av.m3911a(file);
                if (splitInstallRequest2.getModuleNames().contains(m4158a(strM3911a))) {
                    String strM4158a = m4158a(strM3911a);
                    i = iSessionId;
                    HashSet<String> hashSet2 = new HashSet(this.f3158f.m3972a());
                    Map<String, Set<String>> mapM4137a = m4170d().m4137a(Arrays.asList(strM4158a));
                    HashSet hashSet3 = new HashSet();
                    Iterator<Set<String>> it2 = mapM4137a.values().iterator();
                    while (it2.hasNext()) {
                        hashSet3.addAll(it2.next());
                        mapM4137a = mapM4137a;
                    }
                    Map<String, Set<String>> map = mapM4137a;
                    HashSet hashSet4 = new HashSet();
                    for (String str : hashSet2) {
                        File[] fileArr2 = fileArrListFiles;
                        if (str.contains("_")) {
                            i4 = length;
                            str = str.split("_", -1)[0];
                        } else {
                            i4 = length;
                        }
                        hashSet4.add(str);
                        fileArrListFiles = fileArr2;
                        length = i4;
                    }
                    fileArr = fileArrListFiles;
                    i2 = length;
                    hashSet4.addAll(this.f3165m);
                    hashSet4.addAll(arrayList);
                    HashSet hashSet5 = new HashSet();
                    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                        if (hashSet4.contains(entry.getKey())) {
                            hashSet5.addAll(entry.getValue());
                        }
                    }
                    if (!hashSet3.contains(strM3911a) || hashSet5.contains(strM3911a)) {
                        length2 += file.length();
                        hashSet.add(C5173av.m3911a(file));
                        arrayList2.add(file);
                        break;
                    }
                    i5++;
                    splitInstallRequest2 = splitInstallRequest;
                    iSessionId = i;
                    fileArrListFiles = fileArr;
                    length = i2;
                } else {
                    i = iSessionId;
                    fileArr = fileArrListFiles;
                    i2 = length;
                }
                List<Locale> languages = splitInstallRequest.getLanguages();
                ArrayList arrayList3 = new ArrayList(this.f3164l);
                arrayList3.addAll(Arrays.asList("", "base"));
                Map<String, Set<String>> mapM4137a2 = m4170d().m4137a(arrayList3);
                for (Locale locale : languages) {
                    if (mapM4137a2.containsKey(locale.getLanguage()) && mapM4137a2.get(locale.getLanguage()).contains(strM3911a)) {
                        length2 += file.length();
                        hashSet.add(C5173av.m3911a(file));
                        arrayList2.add(file);
                        break;
                        break;
                    }
                }
                i5++;
                splitInstallRequest2 = splitInstallRequest;
                iSessionId = i;
                fileArrListFiles = fileArr;
                length = i2;
            }
            int i6 = iSessionId;
            String strValueOf = String.valueOf(hashSet);
            String strValueOf2 = String.valueOf(splitInstallRequest.getModuleNames());
            Log.i("FakeSplitInstallManager", AbstractC0541b.m776r(new StringBuilder(strValueOf.length() + 21 + strValueOf2.length()), "availableSplits", strValueOf, " want ", strValueOf2));
            if (!hashSet.containsAll(new HashSet(splitInstallRequest.getModuleNames()))) {
                return Tasks.m4184a((Exception) new SplitInstallException(-2));
            }
            Long lValueOf = Long.valueOf(length2);
            List<String> moduleNames = splitInstallRequest.getModuleNames();
            Integer numValueOf = Integer.valueOf(i6);
            m4165a(1, 0, 0L, lValueOf, moduleNames, numValueOf, arrayList);
            this.f3160h.execute(new Runnable(this, arrayList2, arrayList) { // from class: com.google.android.play.core.splitinstall.testing.c

                /* JADX INFO: renamed from: a */
                private final FakeSplitInstallManager f3177a;

                /* JADX INFO: renamed from: b */
                private final List f3178b;

                /* JADX INFO: renamed from: c */
                private final List f3179c;

                {
                    this.f3177a = this;
                    this.f3178b = arrayList2;
                    this.f3179c = arrayList;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f3177a.m4174a(this.f3178b, this.f3179c);
                }
            });
            return Tasks.m4185a(numValueOf);
        } catch (SplitInstallException e) {
            return Tasks.m4184a((Exception) e);
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3159g.m3872b(splitInstallStateUpdatedListener);
    }

    public FakeSplitInstallManager(Context context, @Nullable File file, C5315p c5315p) {
        Executor executorM4098a = C5271p.m4098a();
        C5202bx c5202bx = new C5202bx(context);
        C5320a c5320a = C5320a.f3169a;
        this.f3155b = new Handler(Looper.getMainLooper());
        this.f3163k = new AtomicReference<>();
        this.f3164l = Collections.synchronizedSet(new HashSet());
        this.f3165m = Collections.synchronizedSet(new HashSet());
        this.f3166n = new AtomicBoolean(false);
        this.f3156d = context;
        this.f3162j = file;
        this.f3157e = c5315p;
        this.f3160h = executorM4098a;
        this.f3158f = c5202bx;
        this.f3167o = c5320a;
        this.f3159g = new C5156ae<>();
        this.f3161i = EnumC5310l.f3133a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private final synchronized SplitInstallSessionState m4156a(InterfaceC5329j interfaceC5329j) {
        SplitInstallSessionState splitInstallSessionStateMo4176a;
        boolean z;
        SplitInstallSessionState splitInstallSessionStateM4169c = m4169c();
        splitInstallSessionStateMo4176a = interfaceC5329j.mo4176a(splitInstallSessionStateM4169c);
        AtomicReference<SplitInstallSessionState> atomicReference = this.f3163k;
        while (true) {
            if (atomicReference.compareAndSet(splitInstallSessionStateM4169c, splitInstallSessionStateMo4176a)) {
                z = true;
                break;
            }
            if (atomicReference.get() != splitInstallSessionStateM4169c) {
                z = false;
                break;
            }
        }
        if (z) {
            return splitInstallSessionStateMo4176a;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ void m4167b() {
        SystemClock.sleep(f3154c);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    private final void m4168b(final SplitInstallSessionState splitInstallSessionState) {
        this.f3155b.post(new Runnable(this, splitInstallSessionState) { // from class: com.google.android.play.core.splitinstall.testing.f

            /* JADX INFO: renamed from: a */
            private final FakeSplitInstallManager f3182a;

            /* JADX INFO: renamed from: b */
            private final SplitInstallSessionState f3183b;

            {
                this.f3182a = this;
                this.f3183b = splitInstallSessionState;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3182a.m4173a(this.f3183b);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ SplitInstallSessionState m4157a(Integer num, int i, int i2, Long l, Long l2, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState splitInstallSessionStateCreate = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0L, 0L, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? splitInstallSessionStateCreate.sessionId() : num.intValue(), i, i2, l == null ? splitInstallSessionStateCreate.bytesDownloaded() : l.longValue(), l2 == null ? splitInstallSessionStateCreate.totalBytesToDownload() : l2.longValue(), list == null ? splitInstallSessionStateCreate.moduleNames() : list, list2 == null ? splitInstallSessionStateCreate.languages() : list2);
    }

    /* JADX INFO: renamed from: a */
    public final File m4171a() {
        return this.f3162j;
    }

    /* JADX INFO: renamed from: a */
    private static String m4158a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m4172a(final long j, final List list, final List list2, final List list3) {
        long j2 = j / 3;
        long jMin = 0;
        for (int i = 0; i < 3; i++) {
            jMin = Math.min(j, jMin + j2);
            m4165a(2, 0, Long.valueOf(jMin), Long.valueOf(j), null, null, null);
            m4167b();
            SplitInstallSessionState splitInstallSessionStateM4169c = m4169c();
            if (splitInstallSessionStateM4169c.status() == 9 || splitInstallSessionStateM4169c.status() == 7 || splitInstallSessionStateM4169c.status() == 6) {
                return;
            }
        }
        this.f3160h.execute(new Runnable(this, list, list2, list3, j) { // from class: com.google.android.play.core.splitinstall.testing.h

            /* JADX INFO: renamed from: a */
            private final FakeSplitInstallManager f3189a;

            /* JADX INFO: renamed from: b */
            private final List f3190b;

            /* JADX INFO: renamed from: c */
            private final List f3191c;

            /* JADX INFO: renamed from: d */
            private final List f3192d;

            /* JADX INFO: renamed from: e */
            private final long f3193e;

            {
                this.f3189a = this;
                this.f3190b = list;
                this.f3191c = list2;
                this.f3192d = list3;
                this.f3193e = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3189a.m4175a(this.f3190b, this.f3191c, this.f3192d, this.f3193e);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m4173a(SplitInstallSessionState splitInstallSessionState) {
        this.f3159g.m3871a(splitInstallSessionState);
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m4174a(List list, final List list2) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            File file = (File) list.get(i);
            String strM3911a = C5173av.m3911a(file);
            Uri uriFromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriFromFile, this.f3156d.getContentResolver().getType(uriFromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", m4158a(strM3911a));
            intent.putExtra("split_id", strM3911a);
            arrayList.add(intent);
            arrayList2.add(m4158a(C5173av.m3911a(file)));
        }
        SplitInstallSessionState splitInstallSessionStateM4169c = m4169c();
        if (splitInstallSessionStateM4169c == null) {
            return;
        }
        final long j = splitInstallSessionStateM4169c.totalBytesToDownload();
        this.f3160h.execute(new Runnable(this, j, arrayList, arrayList2, list2) { // from class: com.google.android.play.core.splitinstall.testing.g

            /* JADX INFO: renamed from: a */
            private final FakeSplitInstallManager f3184a;

            /* JADX INFO: renamed from: b */
            private final long f3185b;

            /* JADX INFO: renamed from: c */
            private final List f3186c;

            /* JADX INFO: renamed from: d */
            private final List f3187d;

            /* JADX INFO: renamed from: e */
            private final List f3188e;

            {
                this.f3184a = this;
                this.f3185b = j;
                this.f3186c = arrayList;
                this.f3187d = arrayList2;
                this.f3188e = list2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3184a.m4172a(this.f3185b, this.f3186c, this.f3187d, this.f3188e);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m4175a(List list, List list2, List list3, long j) {
        if (this.f3166n.get()) {
            m4164a(-6);
        } else {
            m4163a((List<Intent>) list, (List<String>) list2, (List<String>) list3, j, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4163a(List<Intent> list, List<String> list2, List<String> list3, long j, boolean z) {
        this.f3161i.mo4134a().mo3904a(list, new C5328i(this, list2, list3, j, z, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final boolean m4164a(int i) {
        return m4165a(6, i, null, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final boolean m4165a(final int i, final int i2, @Nullable final Long l, @Nullable final Long l2, @Nullable final List<String> list, @Nullable final Integer num, @Nullable final List<String> list2) {
        SplitInstallSessionState splitInstallSessionStateM4156a = m4156a(new InterfaceC5329j(num, i, i2, l, l2, list, list2) { // from class: com.google.android.play.core.splitinstall.testing.b

            /* JADX INFO: renamed from: a */
            private final Integer f3170a;

            /* JADX INFO: renamed from: b */
            private final int f3171b;

            /* JADX INFO: renamed from: c */
            private final int f3172c;

            /* JADX INFO: renamed from: d */
            private final Long f3173d;

            /* JADX INFO: renamed from: e */
            private final Long f3174e;

            /* JADX INFO: renamed from: f */
            private final List f3175f;

            /* JADX INFO: renamed from: g */
            private final List f3176g;

            {
                this.f3170a = num;
                this.f3171b = i;
                this.f3172c = i2;
                this.f3173d = l;
                this.f3174e = l2;
                this.f3175f = list;
                this.f3176g = list2;
            }

            @Override // com.google.android.play.core.splitinstall.testing.InterfaceC5329j
            /* JADX INFO: renamed from: a */
            public final SplitInstallSessionState mo4176a(SplitInstallSessionState splitInstallSessionState) {
                return FakeSplitInstallManager.m4157a(this.f3170a, this.f3171b, this.f3172c, this.f3173d, this.f3174e, this.f3175f, this.f3176g, splitInstallSessionState);
            }
        });
        if (splitInstallSessionStateM4156a == null) {
            return false;
        }
        m4168b(splitInstallSessionStateM4156a);
        return true;
    }
}
