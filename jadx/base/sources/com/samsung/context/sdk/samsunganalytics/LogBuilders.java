package com.samsung.context.sdk.samsunganalytics;

import android.app.Activity;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Validation;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LogBuilders {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CustomBuilder extends LogBuilder<CustomBuilder> {
        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public CustomBuilder getThis() {
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public /* bridge */ /* synthetic */ long getTimeStamp() {
            return super.getTimeStamp();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface CustomDimension {
        public static final String DETAIL = "det";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeviceBuilder extends LogBuilder<DeviceBuilder> {
        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public Map<String, String> build() {
            set("t", "dl");
            return super.build();
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public DeviceBuilder getThis() {
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public /* bridge */ /* synthetic */ long getTimeStamp() {
            return super.getTimeStamp();
        }

        public DeviceBuilder setDimension(Map<String, String> map) {
            set("cd", Utils.makeDelimiterString(Validation.checkSizeLimit(map), Utils.Depth.TWO_DEPTH));
            return getThis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface EventType {
        public static final int BACKGROUND = 1;
        public static final int NORMAL = 0;
        public static final int R_BACKGROUND = 11;
        public static final int R_NORMAL = 10;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class LogBuilder<T extends LogBuilder> {
        protected Map<String, String> logs = new HashMap();

        public Map<String, String> build() {
            set(DBContract.AckColumns.TIMESTAMP, String.valueOf(getTimeStamp()));
            return new HashMap(this.logs);
        }

        public abstract T getThis();

        public long getTimeStamp() {
            return System.currentTimeMillis();
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.logs.put(str, str2);
            }
            return (T) getThis();
        }

        public final T setSessionEnd() {
            set("sc", "e");
            return (T) getThis();
        }

        public final T setSessionStart() {
            set("sc", "s");
            return (T) getThis();
        }

        public final T setSessionUpdate() {
            set("sc", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
            return (T) getThis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Property {
        public static final String AGE = "ag";
        public static final String APP_DEVICE_ID = "app_device_id";
        public static final String APP_LANGUAGE = "al";
        public static final String COUNTRY_CODE = "cc";
        public static final String GENDER = "gd";
        public static final String SAMSUNG_ACCOUNT_ID = "guid";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PropertyBuilder {
        private final Map<String, String> property = new HashMap();

        public Map<String, String> build() {
            if (this.property.isEmpty()) {
                return null;
            }
            this.property.put("t", "pp");
            return new HashMap(this.property);
        }

        public PropertyBuilder set(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                Utils.throwException("Failed to build [PropertyBuilder] : Key cannot be null.");
                return this;
            }
            if (str.equalsIgnoreCase("t")) {
                Utils.throwException("Failure to build logs [PropertyBuilder] : 't' is reserved word, choose another word.");
                return this;
            }
            this.property.put(str, str2);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class QuickSettingBuilder {
        private final Map<String, String> map = new HashMap();

        public Map<String, String> build() {
            HashMap map = new HashMap();
            if (!this.map.isEmpty()) {
                map.put("sti", Utils.makeDelimiterString(Validation.checkSizeLimit(this.map), Utils.Depth.TWO_DEPTH));
                map.put(DBContract.AckColumns.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                map.put("t", "st");
            }
            return map;
        }

        public final QuickSettingBuilder set(String str, int i) {
            return set(str, Integer.toString(i));
        }

        public final QuickSettingBuilder set(String str, float f) {
            return set(str, Float.toString(f));
        }

        public final QuickSettingBuilder set(String str, boolean z) {
            return set(str, Boolean.toString(z));
        }

        public final QuickSettingBuilder set(String str, Set<String> set) {
            String strM756B = "";
            for (String str2 : set) {
                if (!TextUtils.isEmpty(strM756B)) {
                    StringBuilder sbM1324q = AbstractC1974b.m1324q(strM756B);
                    sbM1324q.append(Utils.Depth.THREE_DEPTH.getCollectionDLM());
                    strM756B = sbM1324q.toString();
                }
                strM756B = AbstractC0541b.m756B(strM756B, str2);
            }
            return set(str, strM756B);
        }

        public final QuickSettingBuilder set(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                Utils.throwException("Failure to build logs [setting] : Key cannot be null.");
                return this;
            }
            if (str.equalsIgnoreCase("t")) {
                Utils.throwException("Failure to build logs [setting] : 't' is reserved word, choose another word.");
                return this;
            }
            this.map.put(str, str2);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SettingPrefBuilder {
        private final Map<String, Set<String>> map = new HashMap();

        private SettingPrefBuilder addAppPref(String str) {
            if (!this.map.containsKey(str) && !TextUtils.isEmpty(str)) {
                this.map.put(str, new HashSet());
                return this;
            }
            if (TextUtils.isEmpty(str)) {
                Utils.throwException("Failure to build logs [setting preference] : Preference name cannot be null.");
            }
            return this;
        }

        private static String getValue(String str, String str2) {
            if (str2 == null) {
                return str;
            }
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(Utils.Depth.THREE_DEPTH.getCollectionDLM());
            sbM1324q.append(str2);
            return sbM1324q.toString();
        }

        public SettingPrefBuilder addKey(String str, String str2) {
            return addKey(str, str2, null);
        }

        public SettingPrefBuilder addKeys(String str, Set<String> set) {
            if (set == null || set.isEmpty()) {
                Utils.throwException("Failure to build logs [setting preference] : Setting keys cannot be null.");
            }
            HashMap map = new HashMap();
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2)) {
                    map.put(str2, null);
                }
            }
            return addKeys(str, map);
        }

        public Map<String, Set<String>> build() {
            Debug.LogENG(this.map.toString());
            return new HashMap(this.map);
        }

        public SettingPrefBuilder addKey(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str2)) {
                Utils.throwException("Failure to build logs [setting preference] : Setting key cannot be null.");
            }
            addAppPref(str);
            this.map.get(str).add(getValue(str2, str3));
            return this;
        }

        public SettingPrefBuilder addKeys(String str, Map<String, String> map) {
            if (map == null || map.isEmpty()) {
                Utils.throwException("Failure to build logs [setting preference] : Setting keyVals cannot be null.");
            }
            addAppPref(str);
            Set<String> set = this.map.get(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    set.add(getValue(entry.getKey(), entry.getValue()));
                }
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EventBuilder extends LogBuilder<EventBuilder> {
        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public Map<String, String> build() {
            if (this.logs.containsKey("en")) {
                set("t", "ev");
                return super.build();
            }
            Utils.throwException("Failure to build Log : Event name cannot be null");
            return null;
        }

        public EventBuilder enableSummary() {
            set("is", "true");
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public EventBuilder getThis() {
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public /* bridge */ /* synthetic */ long getTimeStamp() {
            return super.getTimeStamp();
        }

        public EventBuilder setDimension(Map<String, String> map) {
            set("cd", Utils.makeDelimiterString(Validation.checkSizeLimit(map), Utils.Depth.TWO_DEPTH));
            return this;
        }

        public EventBuilder setEventId(String str) {
            if (TextUtils.isEmpty(str)) {
                Utils.throwException("Failure to build Log : Event id cannot be null");
            }
            set("en", str);
            return this;
        }

        @Deprecated
        public EventBuilder setEventName(String str) {
            return setEventId(str);
        }

        public EventBuilder setEventType(int i) {
            set("et", String.valueOf(i));
            return this;
        }

        public EventBuilder setEventValue(long j) {
            set("ev", String.valueOf(j));
            return this;
        }

        public EventBuilder setPersonalize(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                if (sb.length() != 0) {
                    sb.append(Utils.Depth.TWO_DEPTH.getCollectionDLM());
                }
                sb.append(str);
            }
            set("ps", sb.toString());
            return this;
        }

        public EventBuilder setPersonalizedData(Map<String, String[]> map) {
            HashMap map2 = new HashMap();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                sb.setLength(0);
                for (String str : entry.getValue()) {
                    if (sb.length() != 0) {
                        sb.append(Utils.Depth.THREE_DEPTH.getCollectionDLM());
                    }
                    sb.append(str);
                }
                map2.put(entry.getKey(), sb.toString());
            }
            set("pd", Utils.makeDelimiterString(map2, Utils.Depth.TWO_DEPTH));
            return this;
        }

        public EventBuilder setScreenView(String str) {
            if (!TextUtils.isEmpty(str)) {
                set("pn", str);
            }
            return getThis();
        }

        public EventBuilder setScreenView(Activity activity) {
            try {
                setScreenView(activity.getComponentName().getShortClassName());
            } catch (NullPointerException e) {
                Debug.LogException(getClass(), e);
            }
            return getThis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ScreenViewBuilder extends LogBuilder<ScreenViewBuilder> {
        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public Map<String, String> build() {
            if (TextUtils.isEmpty(this.logs.get("pn"))) {
                Utils.throwException("Failure to build Log : Screen name cannot be null");
                return null;
            }
            set("t", "pv");
            return super.build();
        }

        public ScreenViewBuilder enableSummary() {
            set("is", "true");
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public ScreenViewBuilder getThis() {
            return this;
        }

        @Override // com.samsung.context.sdk.samsunganalytics.LogBuilders.LogBuilder
        public /* bridge */ /* synthetic */ long getTimeStamp() {
            return super.getTimeStamp();
        }

        @Deprecated
        public ScreenViewBuilder setDimension(Map<String, String> map) {
            set("cd", Utils.makeDelimiterString(Validation.checkSizeLimit(map), Utils.Depth.TWO_DEPTH));
            return getThis();
        }

        public ScreenViewBuilder setPersonalize(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                if (sb.length() != 0) {
                    sb.append(Utils.Depth.TWO_DEPTH.getCollectionDLM());
                }
                sb.append(str);
            }
            set("ps", sb.toString());
            return this;
        }

        public ScreenViewBuilder setPersonalizedData(Map<String, String[]> map) {
            HashMap map2 = new HashMap();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                sb.setLength(0);
                for (String str : entry.getValue()) {
                    if (sb.length() != 0) {
                        sb.append(Utils.Depth.THREE_DEPTH.getCollectionDLM());
                    }
                    sb.append(str);
                }
                map2.put(entry.getKey(), sb.toString());
            }
            set("pd", Utils.makeDelimiterString(map2, Utils.Depth.TWO_DEPTH));
            return this;
        }

        public ScreenViewBuilder setScreenValue(int i) {
            set("pv", String.valueOf(i));
            return this;
        }

        public ScreenViewBuilder setScreenView(String str) {
            if (TextUtils.isEmpty(str)) {
                Utils.throwException("Failure to set Screen View : Screen name cannot be null.");
            } else {
                set("pn", str);
            }
            return getThis();
        }

        public ScreenViewBuilder setScreenView(Activity activity) {
            try {
                setScreenView(activity.getComponentName().getShortClassName());
            } catch (NullPointerException e) {
                Debug.LogException(getClass(), e);
            }
            return getThis();
        }
    }
}
