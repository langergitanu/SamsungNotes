package p025F0;

import androidx.room.migration.Migration;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import p042J1.C0145c;

/* JADX INFO: renamed from: F0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0089d {

    /* JADX INFO: renamed from: a */
    public static final Migration[] f295a = new Migration[0];

    /* JADX INFO: renamed from: a */
    public static String m229a() {
        return C0145c.m331p("GRAPH_PREFERENCE", "account_id", "");
    }

    /* JADX INFO: renamed from: b */
    public static void m230b(boolean z) {
        C0145c.m304L("GRAPH_PREFERENCE", "key_is_request_login", z);
    }

    /* JADX INFO: renamed from: c */
    public static void m231c(long j) {
        SharedPreferencesCompat.getInstance("Settings").putLong("key_last_sync_time", j);
        C0145c.m308P(j, "GRAPH_PREFERENCE", "synced_time");
    }
}
