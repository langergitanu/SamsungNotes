package com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.task;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Task implements Runnable {
    protected static final String EXTRA_NAME_PEN_INTENT_COM = "pen_intent_com";
    protected static final String SCREEN_OFF_MEMO_CLASS_NAME = "com.samsung.android.app.notes.screenoffmemo.ScreenOffMemoService";
    protected static final String SETTINGS_PEN_DETECT_MODE_DISABLED = "pen_detect_mode_disabled";
    protected static final int START_DELAY_TIME_MILLS = 3000;

    public Intent createIntent(ComponentName componentName, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(str, str2);
        return intent;
    }

    public int getPenDetectMode() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return 1;
        }
        return Settings.System.getInt(applicationContext.getContentResolver(), SETTINGS_PEN_DETECT_MODE_DISABLED, 1);
    }

    public void setPenDetectMode(int i) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        Settings.System.putInt(applicationContext.getContentResolver(), SETTINGS_PEN_DETECT_MODE_DISABLED, i);
    }

    public void turnOffScreen() {
        if (BaseUtils.getApplicationContext() == null) {
            return;
        }
        PowerManagerCompat.getInstance(BaseUtils.getApplicationContext()).goToSleep(SystemClock.uptimeMillis());
    }
}
