package com.samsung.android.sdk.multiwindow;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.sdk.multiwindow.SMultiWindowListener;
import com.samsung.android.sdk.multiwindow.SMultiWindowReflator;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SMultiWindowActivity {
    private static final String TAG = "SMultiWindowActivity";
    public static final int ZONE_A;
    public static final int ZONE_B;
    public static final int ZONE_FULL;
    private Context mContext;
    private Rect mDefaultSize;
    private float mDensity;
    private SMultiWindow mMultiWindow = new SMultiWindow();
    private SMultiWindowReflator mMultiWindowReflator = new SMultiWindowReflator();
    private StateChangeListener mStateChangeListener;
    private int mWindowMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StateChangeListener {
        void onModeChanged(boolean z);

        void onSizeChanged(Rect rect);

        void onZoneChanged(int i);
    }

    static {
        int i = SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_A;
        ZONE_A = i;
        int i2 = SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_B;
        ZONE_B = i2;
        ZONE_FULL = i | i2;
    }

    public SMultiWindowActivity(Activity activity) {
        Class<?> cls = activity.getClass();
        this.mMultiWindowReflator.putMethod(cls, activity, "getWindowMode", null);
        SMultiWindowReflator sMultiWindowReflator = this.mMultiWindowReflator;
        Class cls2 = Integer.TYPE;
        Class cls3 = Boolean.TYPE;
        sMultiWindowReflator.putMethod(cls, activity, "setWindowMode", new Class[]{cls2, cls3});
        this.mMultiWindowReflator.putMethod(cls, activity, "getWindowInfo", null);
        this.mMultiWindowReflator.putMethod(cls, activity, "getWindow", null);
        try {
            Class<?> cls4 = Class.forName("com.samsung.android.multiwindow.MultiWindowStyle");
            this.mMultiWindowReflator.putMethod(cls, activity, "getMultiWindowStyle", null);
            this.mMultiWindowReflator.putMethod(cls, activity, "setMultiWindowStyle", new Class[]{cls4});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> cls5 = activity.getWindow().getClass();
        this.mMultiWindowReflator.putMethod(cls5, activity.getWindow(), "getMultiPhoneWindowEvent", null);
        this.mMultiWindowReflator.putMethod(cls5, activity.getWindow(), "getWindowManager", null);
        this.mMultiWindowReflator.putMethod(cls5, activity.getWindow(), "getAttributes", null);
        this.mDensity = activity.getResources().getDisplayMetrics().density;
        try {
            Object multiPhoneWindowEvent = getMultiPhoneWindowEvent();
            if (multiPhoneWindowEvent != null) {
                Class<?> cls6 = multiPhoneWindowEvent.getClass();
                this.mMultiWindowReflator.putMethod(cls6, multiPhoneWindowEvent, "setStateChangeListener", new Class[]{SMultiWindowListener.StateChangeListener.class});
                this.mMultiWindowReflator.putMethod(cls6, multiPhoneWindowEvent, "minimizeWindow", new Class[]{cls2, cls3});
                this.mMultiWindowReflator.putMethod(cls6, multiPhoneWindowEvent, "multiWindow", new Class[]{cls2, cls3});
                this.mMultiWindowReflator.putMethod(cls6, multiPhoneWindowEvent, "normalWindow", new Class[]{cls2});
                this.mMultiWindowReflator.putMethod(cls6, multiPhoneWindowEvent, "getScaleInfo", null);
            }
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
        Bundle windowInfo = getWindowInfo();
        if (windowInfo != null) {
            this.mDefaultSize = (Rect) windowInfo.getParcelable(SMultiWindowReflator.Intent.EXTRA_WINDOW_DEFAULT_SIZE);
        }
        try {
            this.mContext = activity;
            insertLogForAPI(TAG);
        } catch (SecurityException unused) {
            throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
        }
    }

    private boolean checkMode(int i) {
        return (i & this.mWindowMode) != 0;
    }

    private boolean checkOption(int i) {
        return (i & this.mWindowMode) != 0;
    }

    private Rect getLastSize() {
        Bundle windowInfo = getWindowInfo();
        Rect rect = windowInfo != null ? (Rect) windowInfo.getParcelable(SMultiWindowReflator.Intent.EXTRA_WINDOW_LAST_SIZE) : null;
        return rect != null ? rect : this.mDefaultSize;
    }

    private Object getMultiPhoneWindowEvent() {
        return this.mMultiWindowReflator.invoke("getMultiPhoneWindowEvent", null);
    }

    private Bundle getWindowInfo() {
        return (Bundle) this.mMultiWindowReflator.invoke("getWindowInfo", null);
    }

    private void insertLogForAPI(String str) {
        int i;
        if (this.mContext == null) {
            return;
        }
        SMultiWindow sMultiWindow = new SMultiWindow();
        String name = SMultiWindow.class.getPackage().getName();
        String str2 = this.mContext.getPackageName() + ContentUtils.HASH_SYMBOL + sMultiWindow.getVersionCode();
        try {
            i = this.mContext.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d("SM_SDK", "Could not find ContextProvider");
            i = -1;
        }
        AbstractC0541b.m755A(i, "context framework's  versionCode: ", "SM_SDK");
        if (i <= 1) {
            Log.d("SM_SDK", "Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
            return;
        }
        if (this.mContext.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            throw new SecurityException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", name);
        contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, str2);
        contentValues.put("extra", str);
        Log.d(TAG, name + SQLKeyword.COMMA + str2 + SQLKeyword.COMMA + str);
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
        intent.putExtra("data", contentValues);
        intent.setPackage("com.samsung.android.providers.context");
        this.mContext.sendBroadcast(intent);
    }

    public static Intent makeMultiWindowIntent(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        if (!new SMultiWindow().isFeatureEnabled(1)) {
            return intent;
        }
        intent.addFlags(268435456);
        intent.putExtra(SMultiWindowReflator.Intent.EXTRA_WINDOW_MODE, i == ZONE_FULL ? SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_NORMAL : i | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE);
        return intent;
    }

    private void setWindowMode() {
        if (this.mMultiWindow.isFeatureEnabled(1)) {
            this.mMultiWindowReflator.invoke("setWindowMode", Integer.valueOf(this.mWindowMode), Boolean.TRUE);
        }
    }

    private void updateWindowMode() {
        Object objInvoke;
        if (!this.mMultiWindow.isFeatureEnabled(1) || (objInvoke = this.mMultiWindowReflator.invoke("getWindowMode", null)) == null) {
            return;
        }
        this.mWindowMode = ((Integer) objInvoke).intValue();
    }

    public Rect getRectInfo() {
        if (isMultiWindow()) {
            return getLastSize();
        }
        Point point = new Point();
        ((WindowManager) this.mMultiWindowReflator.invoke("getWindowManager", null)).getDefaultDisplay().getSize(point);
        return (((WindowManager.LayoutParams) this.mMultiWindowReflator.invoke("getAttributes", null)).flags & 1024) == 0 ? new Rect(0, (int) (this.mDensity * 25.0f), point.x, point.y) : new Rect(0, 0, point.x, point.y);
    }

    public PointF getScaleInfo() {
        return !this.mMultiWindow.isFeatureEnabled(2) ? new PointF(1.0f, 1.0f) : (PointF) this.mMultiWindowReflator.invoke("getScaleInfo", null);
    }

    public int getZoneInfo() {
        updateWindowMode();
        return this.mWindowMode & SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK;
    }

    public boolean isMinimized() {
        if (!this.mMultiWindow.isFeatureEnabled(2)) {
            return false;
        }
        updateWindowMode();
        return checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) && checkOption(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED);
    }

    public boolean isMultiWindow() {
        if (!this.mMultiWindow.isFeatureEnabled(1)) {
            return false;
        }
        updateWindowMode();
        return checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE);
    }

    public boolean isNormalWindow() {
        if (!this.mMultiWindow.isFeatureEnabled(1)) {
            return true;
        }
        updateWindowMode();
        return checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_NORMAL);
    }

    public boolean isScaleWindow() {
        if (!this.mMultiWindow.isFeatureEnabled(2)) {
            return false;
        }
        updateWindowMode();
        return checkOption(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_SCALE);
    }

    public void minimizeWindow() {
        if (this.mMultiWindow.isFeatureEnabled(2)) {
            updateWindowMode();
            if (!checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) || checkOption(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK)) {
                return;
            }
            if (this.mMultiWindowReflator.checkMethod("minimizeWindow")) {
                this.mMultiWindowReflator.invoke("minimizeWindow", Integer.valueOf(this.mWindowMode), Boolean.FALSE);
                return;
            }
            int i = this.mWindowMode & (~SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_MASK);
            this.mWindowMode = i;
            int i2 = i | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE;
            this.mWindowMode = i2;
            int i4 = i2 | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED;
            this.mWindowMode = i4;
            this.mWindowMode = i4 & (~SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK);
            setWindowMode();
        }
    }

    public void multiWindow(float f) {
        if (this.mMultiWindow.isFeatureEnabled(2)) {
            updateWindowMode();
            if ((!checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) || checkOption(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK)) && this.mMultiWindowReflator.checkMethod("setMultiWindowStyle")) {
                try {
                    Class<?> cls = Class.forName("com.samsung.android.multiwindow.MultiWindowStyle");
                    Object objNewInstance = cls.newInstance();
                    Class cls2 = Integer.TYPE;
                    SMultiWindowReflator.invoke(cls, objNewInstance, "setType", new Class[]{cls2}, Integer.valueOf(SMultiWindowReflator.MultiWindowStyle.TYPE_CASCADE));
                    SMultiWindowReflator.invoke(cls, objNewInstance, "setOption", new Class[]{cls2, Boolean.TYPE}, Integer.valueOf(SMultiWindowReflator.MultiWindowStyle.OPTION_SCALE), Boolean.TRUE);
                    SMultiWindowReflator.invoke(cls, objNewInstance, "setScale", new Class[]{Float.TYPE}, Float.valueOf(f));
                    this.mMultiWindowReflator.invoke("setMultiWindowStyle", objNewInstance);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void normalWindow() {
        if (this.mMultiWindow.isFeatureEnabled(1)) {
            updateWindowMode();
            if (checkMode(SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE)) {
                if (this.mMultiWindowReflator.checkMethod("normalWindow")) {
                    this.mMultiWindowReflator.invoke("normalWindow", Integer.valueOf(this.mWindowMode));
                    return;
                }
                int i = this.mWindowMode & (~SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_UNIQUEOP_MASK);
                this.mWindowMode = i;
                int i2 = i & (~SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK);
                this.mWindowMode = i2;
                int i4 = i2 & (~SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_MASK);
                this.mWindowMode = i4;
                this.mWindowMode = i4 | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_NORMAL;
                setWindowMode();
            }
        }
    }

    public boolean setStateChangeListener(StateChangeListener stateChangeListener) {
        if (!this.mMultiWindow.isFeatureEnabled(1) || !this.mMultiWindowReflator.checkMethod("setStateChangeListener")) {
            return false;
        }
        this.mStateChangeListener = stateChangeListener;
        if (stateChangeListener == null) {
            this.mMultiWindowReflator.invoke("setStateChangeListener", null);
        } else {
            this.mMultiWindowReflator.invoke("setStateChangeListener", new SMultiWindowListener.StateChangeListener() { // from class: com.samsung.android.sdk.multiwindow.SMultiWindowActivity.1
                public void onModeChanged(boolean z) {
                    SMultiWindowActivity.this.mStateChangeListener.onModeChanged(z);
                }

                public void onSizeChanged(Rect rect) {
                    SMultiWindowActivity.this.mStateChangeListener.onSizeChanged(rect);
                }

                public void onZoneChanged(int i) {
                    SMultiWindowActivity.this.mStateChangeListener.onZoneChanged(i);
                }
            });
        }
        return true;
    }

    public static Intent makeMultiWindowIntent(Intent intent, float f) {
        if (intent == null) {
            intent = new Intent();
        }
        SMultiWindow sMultiWindow = new SMultiWindow();
        if (!sMultiWindow.isFeatureEnabled(1) || !sMultiWindow.isFeatureEnabled(2)) {
            return intent;
        }
        intent.addFlags(268435456);
        intent.putExtra(SMultiWindowReflator.Intent.EXTRA_WINDOW_MODE, SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_FREESTYLE | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP | SMultiWindowReflator.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_SCALE);
        intent.putExtra(SMultiWindowReflator.Intent.EXTRA_WINDOW_SCALE, f);
        return intent;
    }
}
