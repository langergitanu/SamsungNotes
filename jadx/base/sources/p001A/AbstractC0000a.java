package p001A;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: A.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC0000a {
    /* JADX INFO: renamed from: A */
    public static void m0A(int i, String str, String str2) {
        Debugger.m8615i(str2, str + i);
    }

    /* JADX INFO: renamed from: B */
    public static void m1B(IOException iOException, StringBuilder sb, String str) {
        sb.append(iOException.getMessage());
        AbstractC0299q.m646q(str, sb.toString());
    }

    /* JADX INFO: renamed from: C */
    public static void m2C(String str, String str2, String str3) {
        DataLogger.m12307i(str3, str + str2);
    }

    /* JADX INFO: renamed from: D */
    public static void m3D(int i, String str, String str2) {
        Logger.m10999d(str2, str + i);
    }

    /* JADX INFO: renamed from: a */
    public static char m4a(int i, String str) {
        return str.charAt(str.length() - i);
    }

    /* JADX INFO: renamed from: b */
    public static double m5b(double d, double d2, double d3) {
        return (Math.sin(d) * d2) + d3;
    }

    /* JADX INFO: renamed from: c */
    public static float m6c(float f, float f4, float f5, float f6) {
        return (f5 - (f * f4)) / f6;
    }

    /* JADX INFO: renamed from: d */
    public static int m7d(int i, int i2, int i4, int i5) {
        return ((i - i2) / i4) + i5;
    }

    /* JADX INFO: renamed from: e */
    public static CompositionScopedCoroutineScopeCanceller m8e(CoroutineScope coroutineScope, Composer composer) {
        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(coroutineScope);
        composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
        return compositionScopedCoroutineScopeCanceller;
    }

    /* JADX INFO: renamed from: f */
    public static NotesDocumentEntity m9f(Context context, String str) {
        return NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str);
    }

    /* JADX INFO: renamed from: g */
    public static Object m10g(List list, int i) {
        return list.get(list.size() - i);
    }

    /* JADX INFO: renamed from: h */
    public static String m11h(int i, String str) {
        return str + i;
    }

    /* JADX INFO: renamed from: i */
    public static String m12i(Resources resources, int i, StringBuilder sb) {
        sb.append(resources.getString(i));
        return sb.toString();
    }

    /* JADX INFO: renamed from: j */
    public static String m13j(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: k */
    public static String m14k(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: l */
    public static StringBuilder m15l(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: m */
    public static StringBuilder m16m(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    /* JADX INFO: renamed from: n */
    public static void m17n(int i, String str, String str2) {
        Debugger.m8607d(str2, str + i);
    }

    /* JADX INFO: renamed from: o */
    public static void m18o(Context context, Context context2, Context context3) {
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context2).createDocumentCoverRepository();
        NotesDataRepositoryFactory.newInstance(context3).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
    }

    /* JADX INFO: renamed from: p */
    public static void m19p(SQLiteException sQLiteException, StringBuilder sb, String str) {
        sb.append(sQLiteException.getMessage());
        DataLogger.m12305f(str, sb.toString());
    }

    /* JADX INFO: renamed from: q */
    public static void m20q(IOException iOException, StringBuilder sb, String str) {
        sb.append(iOException.getMessage());
        Debugger.m8609e(str, sb.toString());
    }

    /* JADX INFO: renamed from: r */
    public static void m21r(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Debugger.m8609e(str, sb.toString());
    }

    /* JADX INFO: renamed from: s */
    public static void m22s(String str, Exception exc, String str2) {
        Debugger.m8609e(str2, str + exc);
    }

    /* JADX INFO: renamed from: t */
    public static void m23t(String str, String str2, LoggerBase.Companion companion, String str3) {
        companion.m7133e(str3, str + str2);
    }

    /* JADX INFO: renamed from: u */
    public static void m24u(String str, String str2, SOLogger sOLogger, String str3) {
        sOLogger.SOLoggerE(str3, str + str2);
    }

    /* JADX INFO: renamed from: v */
    public static void m25v(String str, String str2, String str3) {
        MainLogger.m7254d(str3, str + str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m26w(StringBuilder sb, String str, int i) {
        sb.append(i);
        Log.i(str, sb.toString());
    }

    /* JADX INFO: renamed from: x */
    public static void m27x(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        Log.i(str, sb.toString());
    }

    /* JADX INFO: renamed from: y */
    public static void m28y(Collection collection, StringBuilder sb, String str) {
        sb.append(collection.size());
        DataLogger.m12307i(str, sb.toString());
    }

    /* JADX INFO: renamed from: z */
    public static float m29z(float f, float f4, float f5, float f6) {
        return ((f - f4) * f5) + f6;
    }
}
