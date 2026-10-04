package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import p125c0.InterfaceC4205a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LockUtilsContractImpl implements InterfaceC4205a {
    @Override // p125c0.InterfaceC4205a
    public String backupSettings(Context context) {
        return LockUtils.backupSettings(context);
    }

    @Override // p125c0.InterfaceC4205a
    public String getPasswordHash(Context context) {
        return LockUtils.getPasswordHash(context);
    }

    @Override // p125c0.InterfaceC4205a
    public String getPasswordSalt(Context context) {
        return LockUtils.getPasswordSalt(context);
    }

    @Override // p125c0.InterfaceC4205a
    public boolean isSetPassword(Context context) {
        return LockUtils.isSetPassword(context);
    }

    @Override // p125c0.InterfaceC4205a
    public void updateUserAuthInfo(Context context, String str, String str2) {
        LockUtils.setPasswordHashAndSalt(context, str, str2, LockUtils.NotesPasswordHashSaltBy.SYNC.value);
    }

    @Override // p125c0.InterfaceC4205a
    public boolean updateUserAuthInfo(Context context, String str, boolean z) {
        return LockUtils.updateUserAuthInfo(context, str, z);
    }
}
