package p186h1;

import android.os.Process;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.TextStreamsKt;
import kotlin.text.Charsets;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p123b3.C4202b;

/* JADX INFO: renamed from: h1.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class CallableC12026g implements Callable {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object call() throws Throwable {
        BufferedReader inputStream;
        BufferedReader bufferedReader;
        Process.setThreadPriority(AbstractC12027h.f8779b);
        ArrayList arrayList = new ArrayList();
        Runtime runtime = Runtime.getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "getRuntime(...)");
        try {
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            bufferedReader = null;
        }
        try {
            String str = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            inputStream = runtime.exec("du -d 1 " + new File(C0148f.m352e())).getInputStream();
            try {
                Debugger.Companion companion = Debugger.INSTANCE;
                String str2 = AbstractC12027h.f8778a;
                companion.m8619d(str2, "GetDataSizeAndLargestFileSizeCallable get stream done");
                Intrinsics.checkNotNull(inputStream);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
                try {
                    try {
                        TextStreamsKt.forEachLine(bufferedReader, new C4202b(arrayList, 10));
                        companion.m8619d(str2, "GetDataSizeAndLargestFileSizeCallable read each line done");
                        CollectionsKt___CollectionsKt.sortDescending(arrayList);
                        companion.m8619d(str2, "GetDataSizeAndLargestFileSizeCallable sort done");
                        long j = 1024;
                        Pair pair = new Pair(Long.valueOf(((Number) arrayList.get(0)).longValue() * j), Long.valueOf((((Number) arrayList.get(1)).longValue() * j) / ((long) AbstractC12027h.f8781d)));
                        try {
                            bufferedReader.close();
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedReader, null);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } finally {
                                }
                            }
                            CloseableKt.closeFinally(inputStream, null);
                            return pair;
                        } finally {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Debugger.INSTANCE.m8621e(AbstractC12027h.f8778a, "e: " + e.getMessage());
                        if (inputStream != null) {
                        }
                        CloseableKt.closeFinally(inputStream, null);
                        if (inputStream != null) {
                        }
                        CloseableKt.closeFinally(inputStream, null);
                        return new Pair(0L, 0L);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            Unit unit2 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(inputStream, null);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            Unit unit3 = Unit.INSTANCE;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    CloseableKt.closeFinally(inputStream, null);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (inputStream != null) {
                }
                CloseableKt.closeFinally(inputStream, null);
                if (inputStream != null) {
                }
                CloseableKt.closeFinally(inputStream, null);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
            bufferedReader = null;
            Debugger.INSTANCE.m8621e(AbstractC12027h.f8778a, "e: " + e.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                    Unit unit4 = Unit.INSTANCE;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            CloseableKt.closeFinally(inputStream, null);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    Unit unit5 = Unit.INSTANCE;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            CloseableKt.closeFinally(inputStream, null);
            return new Pair(0L, 0L);
        }
    }
}
