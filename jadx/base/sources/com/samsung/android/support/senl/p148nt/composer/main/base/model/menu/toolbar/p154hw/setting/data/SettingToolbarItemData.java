package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SettingToolbarItemData {
    private static final String ASSISTANCE_USED = "assistance_used";
    private static final String PEN_TYPE = "pen_type";
    private static final String PRIMITIVE_TYPE = "primitive_type";
    InstancePrefData<Integer> mPenTypeInstancePrefData = new InstancePrefData<>(PEN_TYPE, 2);
    InstancePrefData<Integer> mPrimitiveTypeInstancePrefData = new InstancePrefData<>(PRIMITIVE_TYPE, 2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InstancePrefData<T> {
        T mData;
        String mPrefKey;

        /* JADX WARN: Multi-variable type inference failed */
        public InstancePrefData(String str, T t) {
            this.mPrefKey = str;
            if (t instanceof Integer) {
                this.mData = (T) Integer.valueOf(SPenPreferenceResolver.getInt(str, ((Integer) t).intValue()));
            } else if (t instanceof Boolean) {
                this.mData = (T) Boolean.valueOf(SPenPreferenceResolver.getBoolean(str, ((Boolean) t).booleanValue()));
            } else if (t instanceof String) {
                this.mData = (T) SPenPreferenceResolver.getString(str, (String) t);
            }
        }

        public T getData() {
            return this.mData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setData(T t) {
            this.mData = t;
            if (t instanceof Integer) {
                SPenPreferenceResolver.setInt(this.mPrefKey, ((Integer) t).intValue());
            } else if (t instanceof Boolean) {
                SPenPreferenceResolver.setBoolean(this.mPrefKey, ((Boolean) t).booleanValue());
            } else if (t instanceof String) {
                SPenPreferenceResolver.setString(this.mPrefKey, (String) t);
            }
        }
    }

    private String getOrderData() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_TOOLBAR_ITEM_ORDER, "");
    }

    public abstract int getQuickColorUseCount();

    public abstract int getQuickSizeUseCount();

    public int getSelectedPenTypeItem() {
        return this.mPenTypeInstancePrefData.getData().intValue();
    }

    public int getSelectedPrimitiveTypeItem() {
        return this.mPrimitiveTypeInstancePrefData.getData().intValue();
    }

    public boolean isEnableFunction(String str) {
        String orderData = getOrderData();
        if (TextUtils.isEmpty(orderData)) {
            return true;
        }
        return orderData.contains(str);
    }

    public abstract boolean isEnableQuickColor();

    public abstract boolean isEnableQuickSize();

    public abstract boolean isEnabledAssistance();

    public abstract boolean isEnabledAutoFixShapes();

    public abstract boolean isEnabledCleanUpAndConvertText();

    public abstract boolean isEnabledConvertToText();

    public abstract boolean isEnabledEasyWritingPad();

    public abstract boolean isEnabledLaserPointer();

    public abstract boolean isEnabledLockCanvas();

    public abstract boolean isEnabledPenStyle();

    public abstract boolean isEnabledSpenToText();

    public abstract boolean isEnabledStraighten();

    public void setSelectedPenTypeItem(int i) {
        this.mPenTypeInstancePrefData.setData(Integer.valueOf(i));
    }

    public void setSelectedPrimitiveTypeItem(int i) {
        this.mPrimitiveTypeInstancePrefData.setData(Integer.valueOf(i));
    }
}
