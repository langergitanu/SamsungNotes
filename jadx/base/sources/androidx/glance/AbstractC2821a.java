package androidx.glance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.protobuf.CodedOutputStream;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.TableInfo;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.samsung.android.ocr.MOCRLog;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: androidx.glance.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2821a {
    /* JADX INFO: renamed from: A */
    public static void m2206A(StringBuilder sb, String str, float f) {
        sb.append(f);
        Log.i(str, sb.toString());
    }

    /* JADX INFO: renamed from: B */
    public static void m2207B(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    /* JADX INFO: renamed from: C */
    public static void m2208C(StringBuilder sb, boolean z, String str, boolean z2, String str2) {
        sb.append(z);
        sb.append(str);
        sb.append(z2);
        sb.append(str2);
    }

    /* JADX INFO: renamed from: D */
    public static boolean m2209D(Composer composer) {
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return ComposerKt.isTraceInProgress();
    }

    /* JADX INFO: renamed from: a */
    public static double m2210a(double d, double d2, double d3) {
        return (Math.cos(d) * d2) + d3;
    }

    /* JADX INFO: renamed from: b */
    public static int m2211b(int i, int i2, int i4, int i5) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i2 + i4 + i5;
    }

    /* JADX INFO: renamed from: c */
    public static int m2212c(int i, int i2, String str) {
        return str.length() + i + i2;
    }

    /* JADX INFO: renamed from: d */
    public static int m2213d(StringBuilder sb, int i, int i2, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return i + i2;
    }

    /* JADX INFO: renamed from: e */
    public static Intent m2214e(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        return intent;
    }

    /* JADX INFO: renamed from: f */
    public static Bundle m2215f(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    /* JADX INFO: renamed from: g */
    public static FieldDescriptor m2216g(int i, FieldDescriptor.Builder builder) {
        return builder.withProperty(AtProtobuf.builder().tag(i).build()).build();
    }

    /* JADX INFO: renamed from: h */
    public static Object m2217h(Composer composer, Preferences preferences, Preferences.Key key) {
        composer.endReplaceableGroup();
        Object obj = preferences.get(key);
        composer.endReplaceableGroup();
        return obj;
    }

    /* JADX INFO: renamed from: i */
    public static String m2218i(int i, String str, String str2) {
        return str + str2 + i;
    }

    /* JADX INFO: renamed from: j */
    public static String m2219j(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    /* JADX INFO: renamed from: k */
    public static String m2220k(String str, TableInfo tableInfo, String str2, TableInfo tableInfo2) {
        return str + tableInfo + str2 + tableInfo2;
    }

    /* JADX INFO: renamed from: l */
    public static String m2221l(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    /* JADX INFO: renamed from: m */
    public static String m2222m(StringBuilder sb, Object obj, String str) {
        sb.append(obj.getClass());
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: n */
    public static String m2223n(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: o */
    public static String m2224o(StringBuilder sb, String str, long j) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: p */
    public static StringBuilder m2225p(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: q */
    public static StringBuilder m2226q(String str, int i, String str2, boolean z, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(z);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: r */
    public static StringBuilder m2227r(String str, String str2, String str3, String str4) {
        MOCRLog.m5683d(str3, str + str2);
        return new StringBuilder(str4);
    }

    /* JADX INFO: renamed from: s */
    public static StringBuilder m2228s(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    /* JADX INFO: renamed from: t */
    public static StringBuilder m2229t(String str, String str2, String str3, boolean z, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(z);
        sb.append(str4);
        return sb;
    }

    /* JADX INFO: renamed from: u */
    public static StringBuilder m2230u(String str, String str2, String str3, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(z);
        sb.append(str2);
        sb.append(z2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: v */
    public static HashSet m2231v(HashMap map, String str, TableInfo.Column column, int i) {
        map.put(str, column);
        return new HashSet(i);
    }

    /* JADX INFO: renamed from: w */
    public static void m2232w(float f, GlanceModifier.Companion companion, Composer composer, int i, int i2) {
        SpacerKt.Spacer(SizeModifiersKt.m21506size3ABfNKs(companion, C2256Dp.m20968constructorimpl(f)), composer, i, i2);
    }

    /* JADX INFO: renamed from: x */
    public static void m2233x(SupportSQLiteDatabase supportSQLiteDatabase, String str, String str2, String str3, String str4) {
        supportSQLiteDatabase.execSQL(str);
        supportSQLiteDatabase.execSQL(str2);
        supportSQLiteDatabase.execSQL(str3);
        supportSQLiteDatabase.execSQL(str4);
    }

    /* JADX INFO: renamed from: y */
    public static void m2234y(StringBuilder sb, float f, String str, String str2) {
        sb.append(f);
        sb.append(str);
        Log.i(str2, sb.toString());
    }

    /* JADX INFO: renamed from: z */
    public static void m2235z(StringBuilder sb, int i, int i2, String str, String str2) {
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
    }
}
