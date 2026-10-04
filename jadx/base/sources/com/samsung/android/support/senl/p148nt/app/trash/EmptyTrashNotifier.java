package com.samsung.android.support.senl.p148nt.app.trash;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EmptyTrashNotifier {
    private static final String MY_FILES_KEY = "is_empty_trash";
    private static final String MY_FILES_METHOD = "SET_TRASH_STATUS";
    private static final String PREF_KEY_EMPTY_STATUS = "MY_FILES_EMPTY_STATUS";
    private static final String PREF_NAME = "MY_FILES_EMPTY_STATUS";
    private static final String TAG = "EmptyTrashNotifier";
    private static final String URI_MY_FILES = "content://myfiles/";

    private void notifyToMyFiles(@NonNull Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MY_FILES_KEY, z);
        AbstractC8014b.m7210l("notifyToMyFiles, isEmpty: ", TAG, z);
        try {
            context.getContentResolver().call(Uri.parse(URI_MY_FILES), MY_FILES_METHOD, (String) null, bundle);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("notifyToMyFiles, e: "), TAG);
        }
    }

    public void execute(boolean z) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            MainLogger.m7259w(TAG, "notifyToMyFiles, context is null");
            return;
        }
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("MY_FILES_EMPTY_STATUS");
        boolean z2 = sharedPreferencesCompat.getBoolean("MY_FILES_EMPTY_STATUS", true);
        boolean zIsEmpty = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesRecycleBinRepository().isEmpty();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("notifyToMyFiles, isPrevEmpty/isEmpty: ", "/", ", force: ", z2, zIsEmpty);
        sbM2230u.append(z);
        MainLogger.m7254d(TAG, sbM2230u.toString());
        if (zIsEmpty != z2 || z) {
            sharedPreferencesCompat.putBoolean("MY_FILES_EMPTY_STATUS", zIsEmpty);
            notifyToMyFiles(applicationContext, zIsEmpty);
        }
    }
}
