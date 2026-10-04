package com.samsung.android.support.senl.p148nt.data.common.utils;

import android.util.Log;
import androidx.compose.p109ui.graphics.vector.PathBuilder;
import androidx.glance.unit.ColorProvider;
import androidx.room.RoomDatabase;
import androidx.room.util.StringUtil;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.common.utils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC11014a {
    /* JADX INFO: renamed from: A */
    public static PathBuilder m12312A(float f, float f4, float f5, float f6) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f4);
        pathBuilder.lineTo(f5, f6);
        return pathBuilder;
    }

    /* JADX INFO: renamed from: B */
    public static List m12313B(PathBuilder pathBuilder, float f, float f4, float f5, float f6) {
        pathBuilder.lineToRelative(f, f4);
        pathBuilder.lineToRelative(f5, f6);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }

    /* JADX INFO: renamed from: C */
    public static void m12314C(String str, String str2, String str3) {
        DataLogger.m12303e(str3, str + str2);
    }

    /* JADX INFO: renamed from: D */
    public static List m12315D(PathBuilder pathBuilder, float f, float f4, float f5, float f6) {
        pathBuilder.reflectiveCurveToRelative(f, f4, f5, f6);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }

    /* JADX INFO: renamed from: a */
    public static int m12316a(ColorProvider colorProvider, int i, int i2) {
        return (colorProvider.hashCode() + i) * i2;
    }

    /* JADX INFO: renamed from: b */
    public static int m12317b(StringBuilder sb, String str, Collection collection, StringBuilder sb2, String str2) {
        sb.append(str);
        int size = collection.size();
        StringUtil.appendPlaceholders(sb2, size);
        sb.append(str2);
        return size;
    }

    /* JADX INFO: renamed from: c */
    public static PathBuilder m12318c(float f, float f4) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f4);
        return pathBuilder;
    }

    /* JADX INFO: renamed from: d */
    public static PathBuilder m12319d(float f, float f4, float f5, float f6) {
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(f, f4);
        pathBuilder.lineToRelative(f5, f6);
        return pathBuilder;
    }

    /* JADX INFO: renamed from: e */
    public static String m12320e(File file, String str) {
        return file + str;
    }

    /* JADX INFO: renamed from: f */
    public static String m12321f(String str, int i, String str2, String str3, String str4) {
        return str + i + str2 + str3 + str4;
    }

    /* JADX INFO: renamed from: g */
    public static String m12322g(Collection collection, StringBuilder sb, String str) {
        StringUtil.appendPlaceholders(sb, collection.size());
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: h */
    public static String m12323h(Object[] objArr, int i, Locale locale, String str, String str2) {
        String str3 = String.format(locale, str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    /* JADX INFO: renamed from: i */
    public static StringBuilder m12324i(RoomDatabase roomDatabase, String str) {
        roomDatabase.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append(str);
        return sbNewStringBuilder;
    }

    /* JADX INFO: renamed from: j */
    public static StringBuilder m12325j(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: k */
    public static List m12326k(PathBuilder pathBuilder, float f, float f4, float f5, float f6) {
        pathBuilder.lineTo(f, f4);
        pathBuilder.lineTo(f5, f6);
        pathBuilder.close();
        return pathBuilder.getNodes();
    }

    /* JADX INFO: renamed from: l */
    public static void m12327l(int i, String str, String str2) {
        Logger.m12713i(str2, str + i);
    }

    /* JADX INFO: renamed from: m */
    public static void m12328m(int i, String str, String str2, String str3) {
        Log.i(str3, str + i + str2);
    }

    /* JADX INFO: renamed from: n */
    public static void m12329n(int i, String str, String str2, StringBuilder sb) {
        sb.append(i);
        sb.append(str);
        Log.i(str2, sb.toString());
    }

    /* JADX INFO: renamed from: o */
    public static void m12330o(PathBuilder pathBuilder, float f, float f4, float f5) {
        pathBuilder.lineTo(f, f4);
        pathBuilder.verticalLineToRelative(f5);
        pathBuilder.close();
    }

    /* JADX INFO: renamed from: p */
    public static void m12331p(PathBuilder pathBuilder, float f, float f4, float f5, float f6) {
        pathBuilder.moveTo(f, f4);
        pathBuilder.horizontalLineToRelative(f5);
        pathBuilder.verticalLineToRelative(f6);
    }

    /* JADX INFO: renamed from: q */
    public static void m12332q(IOException iOException, StringBuilder sb, String str) {
        sb.append(iOException.getMessage());
        DataLogger.m12303e(str, sb.toString());
    }

    /* JADX INFO: renamed from: r */
    public static void m12333r(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        DataLogger.m12303e(str, sb.toString());
    }

    /* JADX INFO: renamed from: s */
    public static void m12334s(String str, String str2, String str3) {
        DataLogger.m12302d(str3, str + str2);
    }

    /* JADX INFO: renamed from: t */
    public static void m12335t(String str, String str2, boolean z) {
        DataLogger.m12307i(str2, str + z);
    }

    /* JADX INFO: renamed from: u */
    public static void m12336u(String str, StringBuilder sb, String str2) {
        sb.append(DataLogger.getEncode(str));
        sb.append(str2);
    }

    /* JADX INFO: renamed from: v */
    public static void m12337v(StringBuilder sb, float f, String str, float f4, String str2) {
        sb.append(f);
        sb.append(str);
        sb.append(f4);
        sb.append(str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m12338w(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.i(str2, sb.toString());
    }

    /* JADX INFO: renamed from: x */
    public static void m12339x(StringBuilder sb, String str, String str2, boolean z) {
        sb.append(z);
        sb.append(str);
        Log.i(str2, sb.toString());
    }

    /* JADX INFO: renamed from: y */
    public static void m12340y(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        DataLogger.m12307i(str, sb.toString());
    }

    /* JADX INFO: renamed from: z */
    public static boolean m12341z(String str, String str2, String str3) {
        return Intrinsics.areEqual(str3, str + str2);
    }
}
