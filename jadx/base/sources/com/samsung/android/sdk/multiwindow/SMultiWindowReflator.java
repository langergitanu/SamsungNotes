package com.samsung.android.sdk.multiwindow;

import android.util.Pair;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SMultiWindowReflator {
    private HashMap<String, Pair<Object, Method>> mMethodMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Intent {
        public static String EXTRA_WINDOW_DEFAULT_SIZE;
        public static String EXTRA_WINDOW_LAST_SIZE;
        public static String EXTRA_WINDOW_MODE;
        public static String EXTRA_WINDOW_POSITION;
        public static String EXTRA_WINDOW_SCALE;
        static String[] FIELD_NAMES;

        static {
            String[] strArr = {"EXTRA_WINDOW_MODE", "EXTRA_WINDOW_POSITION", "EXTRA_WINDOW_DEFAULT_SIZE", "EXTRA_WINDOW_LAST_SIZE", "EXTRA_WINDOW_SCALE"};
            FIELD_NAMES = strArr;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.content.Intent.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = Intent.class.getField(FIELD_NAMES[i]);
                    field.set(field, declaredField.get(declaredField));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MultiWindowStyle {
        static String[] FIELD_NAMES;
        public static int NOTIFY_STATE_HIDDEN;
        public static int NOTIFY_STATE_SHOWN;
        public static int OPTION_SCALE;
        public static int TYPE_CASCADE;
        public static int TYPE_NORMAL;
        public static int TYPE_SPLIT;
        public static int ZONE_A;
        public static int ZONE_B;
        public static int ZONE_C;
        public static int ZONE_D;
        public static int ZONE_E;
        public static int ZONE_F;
        public static int ZONE_FULL;
        public static int ZONE_UNKNOWN;

        static {
            String[] strArr = {"TYPE_NORMAL", "TYPE_SPLIT", "TYPE_CASCADE", "ZONE_UNKNOWN", "ZONE_A", "ZONE_B", "ZONE_C", "ZONE_D", "ZONE_E", "ZONE_F", "ZONE_FULL", "OPTION_SCALE", "NOTIFY_STATE_HIDDEN", "NOTIFY_STATE_SHOWN"};
            FIELD_NAMES = strArr;
            int length = strArr.length;
            try {
                Class.forName("com.samsung.android.multiwindow.MultiWindowStyle");
                for (int i = 0; i < length; i++) {
                    Field declaredField = com.samsung.android.multiwindow.MultiWindowStyle.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = MultiWindowStyle.class.getField(FIELD_NAMES[i]);
                    field.setInt(field, declaredField.getInt(declaredField));
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PackageManager {
        public static String FEATURE_MULTIWINDOW;
        public static String FEATURE_MULTIWINDOW_FREESTYLE;
        public static String FEATURE_MULTIWINDOW_FREESTYLE_DOCKING;
        public static String FEATURE_MULTIWINDOW_FREESTYLE_LAUNCH;
        public static String FEATURE_MULTIWINDOW_MINIMIZE;
        public static String FEATURE_MULTIWINDOW_MULTIINSTANCE;
        public static String FEATURE_MULTIWINDOW_PHONE;
        public static String FEATURE_MULTIWINDOW_QUADVIEW;
        public static String FEATURE_MULTIWINDOW_TABLET;
        static String[] FIELD_NAMES;

        static {
            String[] strArr = {"FEATURE_MULTIWINDOW", "FEATURE_MULTIWINDOW_FREESTYLE", "FEATURE_MULTIWINDOW_MINIMIZE", "FEATURE_MULTIWINDOW_QUADVIEW", "FEATURE_MULTIWINDOW_MULTIINSTANCE", "FEATURE_MULTIWINDOW_FREESTYLE_DOCKING", "FEATURE_MULTIWINDOW_FREESTYLE_LAUNCH", "FEATURE_MULTIWINDOW_PHONE", "FEATURE_MULTIWINDOW_TABLET"};
            FIELD_NAMES = strArr;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.content.pm.PackageManager.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = PackageManager.class.getField(FIELD_NAMES[i]);
                    field.set(field, declaredField.get(declaredField));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WindowManagerPolicy {
        static String[] FIELD_NAMES;
        public static int WINDOW_MODE_FREESTYLE;
        public static int WINDOW_MODE_MASK;
        public static int WINDOW_MODE_NORMAL;
        public static int WINDOW_MODE_OPTION_COMMON_MINIMIZED;
        public static int WINDOW_MODE_OPTION_COMMON_PINUP;
        public static int WINDOW_MODE_OPTION_COMMON_SCALE;
        public static int WINDOW_MODE_OPTION_COMMON_UNIQUEOP_MASK;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_A;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_B;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_C;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_D;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_E;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_F;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_MASK;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN;

        static {
            String[] strArr = {"WINDOW_MODE_MASK", "WINDOW_MODE_NORMAL", "WINDOW_MODE_FREESTYLE", "WINDOW_MODE_OPTION_COMMON_SCALE", "WINDOW_MODE_OPTION_COMMON_PINUP", "WINDOW_MODE_OPTION_COMMON_MINIMIZED", "WINDOW_MODE_OPTION_SPLIT_ZONE_MASK", "WINDOW_MODE_OPTION_SPLIT_ZONE_A", "WINDOW_MODE_OPTION_SPLIT_ZONE_B", "WINDOW_MODE_OPTION_SPLIT_ZONE_C", "WINDOW_MODE_OPTION_SPLIT_ZONE_D", "WINDOW_MODE_OPTION_SPLIT_ZONE_E", "WINDOW_MODE_OPTION_SPLIT_ZONE_F", "WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN", "WINDOW_MODE_OPTION_COMMON_UNIQUEOP_MASK"};
            FIELD_NAMES = strArr;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.view.WindowManagerPolicy.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = WindowManagerPolicy.class.getField(FIELD_NAMES[i]);
                    field.setInt(field, declaredField.getInt(declaredField));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
                }
            }
        }
    }

    public boolean checkMethod(String str) {
        return this.mMethodMap.get(str) != null;
    }

    public Object invoke(String str, Object... objArr) {
        try {
            Pair<Object, Method> pair = this.mMethodMap.get(str);
            if (pair != null) {
                return ((Method) pair.second).invoke(pair.first, objArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putMethod(Class<?> cls, Object obj, String str, Class<?>[] clsArr) {
        try {
            this.mMethodMap.put(str, new Pair<>(obj, cls.getMethod(str, clsArr)));
        } catch (NoSuchMethodException unused) {
        }
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
