package androidx.appcompat.widget;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.appsearch.app.AppSearchSchema;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.appcompat.widget.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0541b {
    /* JADX INFO: renamed from: A */
    public static void m755A(int i, String str, String str2) {
        Log.d(str2, str + i);
    }

    /* JADX INFO: renamed from: B */
    public static String m756B(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: renamed from: C */
    public static String m757C(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* JADX INFO: renamed from: D */
    public static void m758D(int i, String str, String str2) {
        Log.e(str2, str + i);
    }

    /* JADX INFO: renamed from: a */
    public static int m759a(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection();
    }

    /* JADX INFO: renamed from: b */
    public static AppSearchSchema.Builder m760b(String str, int i, int i2, AppSearchSchema.Builder builder) {
        return builder.addProperty(new AppSearchSchema.LongPropertyConfig.Builder(str).setCardinality(i).setIndexingType(i2).build());
    }

    /* JADX INFO: renamed from: c */
    public static AppSearchSchema.Builder m761c(String str, int i, AppSearchSchema.Builder builder) {
        return builder.addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder(str).setCardinality(i).build());
    }

    /* JADX INFO: renamed from: d */
    public static AppSearchSchema.Builder m762d(String str, String str2, int i, boolean z, AppSearchSchema.Builder builder) {
        return builder.addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder(str, str2).setCardinality(i).setShouldIndexNestedProperties(z).build());
    }

    /* JADX INFO: renamed from: e */
    public static AppSearchSchema.StringPropertyConfig m763e(String str, int i, int i2, int i4, int i5) {
        return new AppSearchSchema.StringPropertyConfig.Builder(str).setCardinality(i).setTokenizerType(i2).setIndexingType(i4).setJoinableValueType(i5).build();
    }

    /* JADX INFO: renamed from: f */
    public static AppSearchSchema m764f(String str, int i, int i2, AppSearchSchema.Builder builder) {
        return builder.addProperty(new AppSearchSchema.LongPropertyConfig.Builder(str).setCardinality(i).setIndexingType(i2).build()).build();
    }

    /* JADX INFO: renamed from: g */
    public static AppSearchSchema m765g(String str, String str2, int i, boolean z, AppSearchSchema.Builder builder) {
        return builder.addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder(str, str2).setCardinality(i).setShouldIndexNestedProperties(z).build()).build();
    }

    /* JADX INFO: renamed from: h */
    public static String m766h(char c, String str, StringBuilder sb) {
        sb.append(c);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, str);
        return string;
    }

    /* JADX INFO: renamed from: i */
    public static String m767i(int i, String str, String str2) {
        return str + i + str2;
    }

    /* JADX INFO: renamed from: j */
    public static String m768j(Class cls, String str, String str2) {
        return str + cls + str2;
    }

    /* JADX INFO: renamed from: k */
    public static String m769k(Object obj, String str) {
        return str + obj;
    }

    /* JADX INFO: renamed from: l */
    public static String m770l(String str, float f, String str2, float f4, String str3) {
        return str + f + str2 + f4 + str3;
    }

    /* JADX INFO: renamed from: m */
    public static String m771m(String str, Uri uri) {
        return str + uri;
    }

    /* JADX INFO: renamed from: n */
    public static String m772n(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: renamed from: o */
    public static String m773o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* JADX INFO: renamed from: p */
    public static String m774p(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    /* JADX INFO: renamed from: q */
    public static String m775q(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    /* JADX INFO: renamed from: r */
    public static String m776r(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* JADX INFO: renamed from: s */
    public static String m777s(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: t */
    public static StringBuilder m778t(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: u */
    public static StringBuilder m779u(CharSequence charSequence, String str, Function2 function2, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    /* JADX INFO: renamed from: v */
    public static StringBuilder m780v(String str, int i, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
        sb.append(str4);
        return sb;
    }

    /* JADX INFO: renamed from: w */
    public static StringBuilder m781w(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: x */
    public static ArrayList m782x(Class cls) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cls);
        return arrayList;
    }

    /* JADX INFO: renamed from: y */
    public static void m783y(int i, int i2, String str, String str2, String str3) {
        Log.d(str3, str + i + str2 + i2);
    }

    /* JADX INFO: renamed from: z */
    public static void m784z(int i, int i2, Function1 function1) {
        function1.invoke(Integer.valueOf(i + i2));
    }
}
