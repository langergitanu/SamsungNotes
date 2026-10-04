package p186h1;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: h1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12027h {

    /* JADX INFO: renamed from: a */
    public static final String f8778a;

    /* JADX INFO: renamed from: b */
    public static final int f8779b;

    /* JADX INFO: renamed from: c */
    public static final int f8780c;

    /* JADX INFO: renamed from: d */
    public static final int f8781d;

    /* JADX INFO: renamed from: e */
    public static final int f8782e;

    /* JADX INFO: renamed from: f */
    public static final boolean f8783f;

    /* JADX INFO: renamed from: g */
    public static final int f8784g;

    /* JADX INFO: renamed from: h */
    public static final int f8785h;

    /* JADX INFO: renamed from: i */
    public static final int f8786i;

    /* JADX INFO: renamed from: j */
    public static final int f8787j;

    /* JADX INFO: renamed from: k */
    public static final int f8788k;

    /* JADX INFO: renamed from: l */
    public static Context f8789l;

    /* JADX INFO: renamed from: m */
    public static final ExecutorService f8790m;

    static {
        String strConcat = "SS$".concat("PrepareIntentHelper");
        f8778a = strConcat;
        f8779b = -10;
        f8780c = 1048576;
        f8781d = 2;
        f8782e = 1;
        f8783f = true;
        f8784g = 120000;
        f8785h = 120000;
        f8786i = 2;
        f8787j = 170;
        f8788k = 50;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(strConcat));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        f8790m = executorServiceNewSingleThreadExecutor;
    }
}
