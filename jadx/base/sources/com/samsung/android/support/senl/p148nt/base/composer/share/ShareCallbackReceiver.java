package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSA;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareCallbackReceiver extends BroadcastReceiver {
    public static final String ACTION_SHARE_CALLBACK = "com.samsung.android.app.notes.ACTION_SHARE_CALLBACK";
    public static final String EXTRA_KEY_CALLER = "extra_key_caller";
    public static final String EXTRA_KEY_FILE_PATH = "extra_key_file_path";
    private static final String TAG = Logger.createTag("CPLog$ShareCallbackReceiver");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ShareCaller {
        None(""),
        PopupNote(""),
        ComposerToolbar(""),
        ComposerContextMenu(""),
        MemoList(""),
        StickyMemo("");

        private final String mTag;

        ShareCaller(String str) {
            this.mTag = str;
        }

        public String getTag() {
            return this.mTag;
        }
    }

    public IntentSender getIntentSender(Context context, @Nullable ShareCaller shareCaller, String str) {
        Intent intent = new Intent(context, (Class<?>) ShareCallbackReceiver.class);
        intent.setAction(ACTION_SHARE_CALLBACK);
        if (shareCaller == null) {
            shareCaller = ShareCaller.None;
        }
        intent.putExtra(EXTRA_KEY_CALLER, shareCaller.ordinal());
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(EXTRA_KEY_FILE_PATH, str);
        }
        return PendingIntent.getBroadcast(context, 0, intent, 167772160).getIntentSender();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String str = TAG;
        Logger.m8697d(str, "onReceive, action: " + action);
        if (ACTION_SHARE_CALLBACK.equals(action)) {
            Logger.m8697d(str, "onReceive, caller: " + ShareCaller.values()[intent.getIntExtra(EXTRA_KEY_CALLER, ShareCaller.None.ordinal())]);
            ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                Logger.m8697d(str, "onReceive, packageName: " + packageName);
                if (!TextUtils.isEmpty(packageName)) {
                    BaseComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, "9966", packageName);
                }
            }
            String stringExtra = intent.getStringExtra(EXTRA_KEY_FILE_PATH);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            FileUtils.deleteFile(stringExtra);
        }
    }
}
