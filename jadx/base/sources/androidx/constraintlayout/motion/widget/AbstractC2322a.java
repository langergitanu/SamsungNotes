package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.fragment.app.Fragment;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2322a {
    /* JADX INFO: renamed from: A */
    public static boolean m1607A(String str) {
        return new File(str).exists();
    }

    /* JADX INFO: renamed from: B */
    public static int m1608B(int i, int i2, int i4, int i5) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i2 + i4 + i5;
    }

    /* JADX INFO: renamed from: C */
    public static void m1609C(String str, String str2, String str3) {
        Log.d(str3, str + str2);
    }

    /* JADX INFO: renamed from: D */
    public static int m1610D(int i, int i2, int i4, int i5) {
        return ((i / i2) * i4) + i5;
    }

    /* JADX INFO: renamed from: a */
    public static int m1611a(int i, int i2, int i4, int i5) {
        return ((i * i2) / i4) + i5;
    }

    /* JADX INFO: renamed from: b */
    public static int m1612b(List list, int i, int i2) {
        return (list.size() * i) + i2;
    }

    /* JADX INFO: renamed from: c */
    public static Applier m1613c(int i, Composer composer, int i2) {
        composer.startReplaceableGroup(i);
        composer.startReplaceableGroup(i2);
        return composer.getApplier();
    }

    /* JADX INFO: renamed from: d */
    public static String m1614d(int i, int i2, String str) {
        return str.substring(i2, str.length() - i);
    }

    /* JADX INFO: renamed from: e */
    public static String m1615e(int i, String str) {
        return i + str;
    }

    /* JADX INFO: renamed from: f */
    public static String m1616f(int i, String str, String str2, String str3) {
        return str + i + str2 + str3;
    }

    /* JADX INFO: renamed from: g */
    public static String m1617g(File file, String str) {
        return str + file;
    }

    /* JADX INFO: renamed from: h */
    public static String m1618h(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: i */
    public static String m1619i(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    /* JADX INFO: renamed from: j */
    public static String m1620j(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* JADX INFO: renamed from: k */
    public static String m1621k(String str, Class cls) {
        return str + cls;
    }

    /* JADX INFO: renamed from: l */
    public static String m1622l(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    /* JADX INFO: renamed from: m */
    public static String m1623m(String str, Type type) {
        return str + type;
    }

    /* JADX INFO: renamed from: n */
    public static String m1624n(String str, Object[] objArr, int i, String str2) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    /* JADX INFO: renamed from: o */
    public static String m1625o(StringBuilder sb, int i, int i2, String str, String str2) {
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: p */
    public static String m1626p(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: renamed from: q */
    public static StringBuilder m1627q(int i, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        return sb;
    }

    /* JADX INFO: renamed from: r */
    public static StringBuilder m1628r(String str, int i, String str2, float f, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(f);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: s */
    public static StringBuilder m1629s(String str, int i, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    /* JADX INFO: renamed from: t */
    public static List m1630t(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        Objects.requireNonNull(obj);
        arrayList.add(obj2);
        return Collections.unmodifiableList(arrayList2);
    }

    /* JADX INFO: renamed from: u */
    public static void m1631u(int i, String str, String str2) {
        Log.i(str2, str + i);
    }

    /* JADX INFO: renamed from: v */
    public static void m1632v(int i, String str, String str2, String str3) {
        Log.e(str3, str + i + str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m1633w(Canvas canvas, int i, int i2, int i4) {
        InlineMarker.finallyStart(i);
        canvas.restoreToCount(i2);
        InlineMarker.finallyEnd(i4);
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ void m1634x(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else {
                if (!(autoCloseable instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) autoCloseable).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: renamed from: y */
    public static void m1635y(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    /* JADX INFO: renamed from: z */
    public static void m1636z(String str, String str2, String str3) {
        Log.e(str3, str + str2);
    }
}
