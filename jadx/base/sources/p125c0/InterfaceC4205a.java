package p125c0;

import android.content.Context;

/* JADX INFO: renamed from: c0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface InterfaceC4205a {
    String backupSettings(Context context);

    String getPasswordHash(Context context);

    String getPasswordSalt(Context context);

    boolean isSetPassword(Context context);

    void updateUserAuthInfo(Context context, String str, String str2);

    boolean updateUserAuthInfo(Context context, String str, boolean z);
}
