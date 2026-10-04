package com.google.android.play.core.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.play.core.internal.af */
/* JADX INFO: loaded from: classes5.dex */
public final class C5157af {

    /* JADX INFO: renamed from: a */
    private final String f2933a;

    public C5157af(String str) {
        int iMyUid = Process.myUid();
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(iMyUid);
        sb.append("]  PID: [");
        sb.append(iMyPid);
        sb.append("] ");
        String strValueOf = String.valueOf(sb.toString());
        String strValueOf2 = String.valueOf(str);
        this.f2933a = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    /* JADX INFO: renamed from: a */
    private final int m3873a(int i, String str, @Nullable Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", m3874a(this.f2933a, str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public final void m3877b(String str, @Nullable Object... objArr) {
        m3873a(6, str, objArr);
    }

    /* JADX INFO: renamed from: c */
    public final void m3878c(String str, @Nullable Object... objArr) {
        m3873a(4, str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public final void m3879d(String str, @Nullable Object... objArr) {
        m3873a(5, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    private static String m3874a(String str, String str2, @Nullable Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                String strValueOf = String.valueOf(str2);
                Log.e("PlayCore", strValueOf.length() != 0 ? "Unable to format ".concat(strValueOf) : new String("Unable to format "), e);
                String strJoin = TextUtils.join(SQLKeyword.COMMA, objArr);
                str2 = AbstractC0541b.m776r(new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(strJoin).length()), str2, " [", strJoin, "]");
            }
        }
        return AbstractC2322a.m1626p(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()), str, " : ", str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m3875a(String str, @Nullable Object... objArr) {
        m3873a(3, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    public final void m3876a(Throwable th, String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", m3874a(this.f2933a, str, objArr), th);
        }
    }
}
