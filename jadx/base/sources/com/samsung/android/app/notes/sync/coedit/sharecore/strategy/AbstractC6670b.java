package com.samsung.android.app.notes.sync.coedit.sharecore.strategy;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.glance.CompositionLocalsKt;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.ocr.MOCRLang;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import com.samsung.android.sdk.handwriting.LanguageID;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskCompletionSource;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharecore.strategy.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC6670b {
    /* JADX INFO: renamed from: A */
    public static void m4736A(int i, String str, String str2) {
        MainLogger.m7254d(str2, str + i);
    }

    /* JADX INFO: renamed from: B */
    public static void m4737B(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.toString());
        SmpLog.m6494e(str, sb.toString());
    }

    /* JADX INFO: renamed from: C */
    public static void m4738C(String str, String str2, String str3) {
        MainLogger.m7255e(str3, str + str2);
    }

    /* JADX INFO: renamed from: D */
    public static void m4739D(String str, String str2, boolean z) {
        MainLogger.m7258i(str2, str + z);
    }

    /* JADX INFO: renamed from: a */
    public static Canvas m4740a(Bitmap bitmap, String str, Bitmap bitmap2) {
        Intrinsics.checkNotNullExpressionValue(bitmap, str);
        return new Canvas(bitmap2);
    }

    /* JADX INFO: renamed from: b */
    public static Object m4741b(int i, Composer composer, int i2) {
        composer.startReplaceableGroup(i);
        composer.startReplaceableGroup(i2);
        return composer.consume(CompositionLocalsKt.getLocalState());
    }

    /* JADX INFO: renamed from: c */
    public static Object m4742c(ValueAnimator valueAnimator, String str, String str2) {
        Intrinsics.checkNotNullParameter(valueAnimator, str);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, str2);
        return animatedValue;
    }

    /* JADX INFO: renamed from: d */
    public static String m4743d(String str, String str2, StringBuilder sb) {
        sb.append(SDocUtil.logPath(str));
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public static void m4744e(int i, int i2, String str, String str2, String str3) {
        Log.i(str3, str + i + str2 + i2);
    }

    /* JADX INFO: renamed from: f */
    public static void m4745f(int i, MOCRLang.C72111 c72111, String str, int i2, String str2) {
        c72111.put(str, Integer.valueOf(i));
        c72111.put(str2, Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: g */
    public static void m4746g(int i, HwrLanguageID.C72641 c72641, String str, int i2, String str2) {
        c72641.put(str, Integer.valueOf(i));
        c72641.put(str2, Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: h */
    public static void m4747h(int i, LanguageID.C72671 c72671, String str, int i2, String str2) {
        c72671.put(str, Integer.valueOf(i));
        c72671.put(str2, Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: i */
    public static void m4748i(int i, TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setException(new ResultException(i));
    }

    /* JADX INFO: renamed from: j */
    public static void m4749j(int i, String str, TaskCompletionSource taskCompletionSource) {
        taskCompletionSource.setException(new ResultException(i, str));
    }

    /* JADX INFO: renamed from: k */
    public static void m4750k(int i, String str, String str2) {
        com.samsung.android.sdk.scs.base.utils.Log.m6487e(str2, str + i);
    }

    /* JADX INFO: renamed from: l */
    public static void m4751l(int i, HashMap map, String str, int i2, String str2) {
        map.put(Integer.valueOf(i), str);
        map.put(Integer.valueOf(i2), str2);
    }

    /* JADX INFO: renamed from: m */
    public static void m4752m(SyncException syncException, StringBuilder sb, String str) {
        sb.append(syncException.getMessage());
        Debugger.m8609e(str, sb.toString());
    }

    /* JADX INFO: renamed from: n */
    public static void m4753n(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        MSLogger.m8633e(str, sb.toString());
    }

    /* JADX INFO: renamed from: o */
    public static void m4754o(String str, int i, String str2, boolean z, String str3) {
        Log.i(str3, str + i + str2 + z);
    }

    /* JADX INFO: renamed from: p */
    public static void m4755p(String str, IOException iOException, String str2) {
        DocumentLogger.m7179e(str2, str + iOException);
    }

    /* JADX INFO: renamed from: q */
    public static void m4756q(String str, String str2, String str3) {
        Log.i(str3, str + str2);
    }

    /* JADX INFO: renamed from: r */
    public static void m4757r(String str, String str2, String str3, String str4) {
        Log.d(str4, str + str2 + str3);
    }

    /* JADX INFO: renamed from: s */
    public static void m4758s(String str, String str2, String str3, boolean z, boolean z2) {
        Log.i(str3, str + z + str2 + z2);
    }

    /* JADX INFO: renamed from: t */
    public static void m4759t(String str, String str2, boolean z) {
        Log.d(str2, str + z);
    }

    /* JADX INFO: renamed from: u */
    public static void m4760u(Object[] objArr, int i, String str, String str2, String str3) {
        String str4 = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(str4, str2);
        Log.d(str3, str4);
    }

    /* JADX INFO: renamed from: v */
    public static void m4761v(int i, String str, String str2) {
        Logger.m7100d(str2, str + i);
    }

    /* JADX INFO: renamed from: w */
    public static void m4762w(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        AbstractC0299q.m646q(str, sb.toString());
    }

    /* JADX INFO: renamed from: x */
    public static void m4763x(String str, String str2, String str3) {
        Logger.m7100d(str3, str + str2);
    }

    /* JADX INFO: renamed from: y */
    public static void m4764y(String str, String str2, boolean z) {
        Logger.m7100d(str2, str + z);
    }

    /* JADX INFO: renamed from: z */
    public static void m4765z(Object[] objArr, int i, String str, String str2, String str3) {
        String str4 = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(str4, str2);
        Log.i(str3, str4);
    }
}
