package com.samsung.android.support.senl.p148nt.app.main.common.data;

import android.content.Context;
import android.content.res.Configuration;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ReservedFolderName {
    private static final String BUILDED_PREFS_NAME = "builded_prefs_screen_off_memo_name";
    private static final String IS_BUILDED = "is_screen_off_memo_builded";
    private static final String RESERVED_PREFS_NAME = "reserved_prefs_screen_off_memo_name";
    private static final String TAG = "ReservedFolderName";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MakeInstanceThread implements Runnable {
        final Context mContext;

        public MakeInstanceThread(Context context) {
            this.mContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainLogger.m7258i(ReservedFolderName.TAG, "MakeInstanceThread start");
            synchronized (ReservedFolderName.class) {
                try {
                    if (ReservedFolderName.isBuiltReservedFolder()) {
                        return;
                    }
                    ReservedFolderName.executeReservedFolderName(this.mContext);
                    MainLogger.m7258i(ReservedFolderName.TAG, "MakeInstanceThread end");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean buildReservedFolder(Context context) {
        if (isBuiltReservedFolder()) {
            return false;
        }
        new SenlThreadFactory(TAG).newThread(new MakeInstanceThread(context)).start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void executeReservedFolderName(Context context) {
        MainLogger.m7258i(TAG, "ReservedFolderName start");
        Locale[] availableLocales = Locale.getAvailableLocales();
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        for (Locale locale : availableLocales) {
            configuration.setLocale(locale);
            String string = context.createConfigurationContext(configuration).getResources().getString(C8003R.string.string_screen_off_memo);
            if (FolderManager.getInstance().addReservedFolderName(string)) {
                SharedPreferencesCompat.getInstance(RESERVED_PREFS_NAME).edit().putString(string, "");
            }
        }
        SharedPreferencesCompat.getInstance(RESERVED_PREFS_NAME).edit().apply();
        SharedPreferencesCompat.getInstance(BUILDED_PREFS_NAME).putBoolean(IS_BUILDED, true);
        MainLogger.m7258i(TAG, "ReservedFolderName end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isBuiltReservedFolder() {
        return SharedPreferencesCompat.getInstance(BUILDED_PREFS_NAME).getBoolean(IS_BUILDED, false);
    }

    public static boolean isReservedFolderForDataSet(Context context, String str) {
        boolean zIsReservedFolderName;
        synchronized (ReservedFolderName.class) {
            try {
                boolean zIsBuiltReservedFolder = isBuiltReservedFolder();
                if (zIsBuiltReservedFolder) {
                    setReservedString(context);
                } else {
                    executeReservedFolderName(context);
                }
                MainLogger.m7258i(TAG, "isReservedFolderForDataSet# folderName : " + MainLogger.getEncode(str) + " isBuilding " + zIsBuiltReservedFolder);
                zIsReservedFolderName = FolderManager.getInstance().isReservedFolderName(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsReservedFolderName;
    }

    public static boolean isReservedFolderForLayoutSet(Context context, String str) {
        boolean zIsReservedFolderName;
        if (buildReservedFolder(context)) {
            MainLogger.m7258i(TAG, "isReservedFolderForLayoutSet isBuilding # folderName : " + MainLogger.getEncode(str));
            return false;
        }
        MainLogger.m7258i(TAG, "isReservedFolderForLayoutSet# folderName : " + MainLogger.getEncode(str));
        setReservedString(context);
        synchronized (ReservedFolderName.class) {
            zIsReservedFolderName = FolderManager.getInstance().isReservedFolderName(str);
        }
        return zIsReservedFolderName;
    }

    private static synchronized void setReservedString(Context context) {
        if (context == null) {
            return;
        }
        synchronized (ReservedFolderName.class) {
            try {
                if (!FolderManager.getInstance().hasReservedFolderName()) {
                    Iterator<Map.Entry<String, ?>> it = context.getSharedPreferences(RESERVED_PREFS_NAME, 0).getAll().entrySet().iterator();
                    while (it.hasNext()) {
                        FolderManager.getInstance().addReservedFolderName(it.next().getKey());
                    }
                    if (!FolderManager.getInstance().hasReservedFolderName()) {
                        executeReservedFolderName(context);
                    }
                }
            } finally {
            }
        }
    }
}
