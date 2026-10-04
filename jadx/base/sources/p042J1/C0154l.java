package p042J1;

import androidx.room.util.StringUtil;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: renamed from: J1.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0154l {

    /* JADX INFO: renamed from: g */
    public static C0154l f467g;

    /* JADX INFO: renamed from: a */
    public long f468a;

    /* JADX INFO: renamed from: b */
    public long f469b;

    /* JADX INFO: renamed from: c */
    public long f470c;

    /* JADX INFO: renamed from: d */
    public long f471d;

    /* JADX INFO: renamed from: e */
    public long f472e;

    /* JADX INFO: renamed from: f */
    public final SimpleDateFormat f473f = new SimpleDateFormat("mm:ss:SSS", Locale.getDefault());

    /* JADX INFO: renamed from: a */
    public static C0154l m383a() {
        if (f467g == null) {
            f467g = new C0154l();
        }
        return f467g;
    }

    /* JADX INFO: renamed from: b */
    public final String m384b(long j) {
        return this.f473f.format(Long.valueOf(j));
    }

    /* JADX INFO: renamed from: c */
    public final void m385c(long j, String str, String str2) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        long j2 = j - this.f472e;
        long j3 = j - this.f468a;
        if (j3 == 0) {
            sbNewStringBuilder.append(">>>>>>> Start");
        } else {
            sbNewStringBuilder.append("tet=");
            sbNewStringBuilder.append(m384b(j2));
        }
        sbNewStringBuilder.append(", t=" + m384b(j) + ", et=" + m384b(j3) + SQLKeyword.COMMA + str2 + " at " + str);
        Debugger.m8607d("!SyncTimer", sbNewStringBuilder.toString());
        this.f468a = j;
        this.f469b = j;
    }
}
