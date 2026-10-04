package com.samsung.android.support.senl.p145cm.base.framework.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0004,-./B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0015\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000fJ(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017J\u0018\u0010\u001d\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\tJ\u0018\u0010 \u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u000fJ\u0018\u0010!\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u0011J\u0018\u0010\"\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u0013J\u001a\u0010#\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bJ \u0010$\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017J\u0010\u0010&\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u0003\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateImpl;)V", Constant.DOC_SCAN_EDIT_PATH, "Landroid/content/SharedPreferences$Editor;", "contains", "", "key", "", "getBoolean", "defValue", "getInt", "", "getLong", "", "getFloat", "", "getString", "getColor", "getStringSet", "", "defValues", "all", "", "getAll", "()Ljava/util/Map;", "putBoolean", "", "value", "putInt", "putLong", "putFloat", "putString", "putStringSet", "values", "remove", "clear", "registerOnSharedPreferenceChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "SharedPreferencesDelegateImpl", "SharedPreferencesDelegateAndroidImpl", "SharedPreferencesDelegateTestImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SharedPreferencesCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MODE_ANDROID = 0;
    public static final int MODE_TEST = 1;

    @NotNull
    private static final String TAG = "SharedPreferencesCompat";
    private static int mMode;

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static Context sApplicatoinContext;

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static SharedPreferencesCompat sTestInstance;

    @NotNull
    private final SharedPreferencesDelegateImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MODE_ANDROID", "", "MODE_TEST", "mMode", "sApplicatoinContext", "Landroid/content/Context;", "setMode", "", "mode", "setApplicationContext", "context", "sTestInstance", "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "name", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SharedPreferencesCompat getInstance() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (SharedPreferencesCompat.mMode == 0 && SharedPreferencesCompat.sApplicatoinContext != null) {
                Context context = SharedPreferencesCompat.sApplicatoinContext;
                Intrinsics.checkNotNull(context);
                return new SharedPreferencesCompat(new SharedPreferencesDelegateAndroidImpl(context), defaultConstructorMarker);
            }
            if (SharedPreferencesCompat.sTestInstance == null) {
                SharedPreferencesCompat.sTestInstance = new SharedPreferencesCompat(new SharedPreferencesDelegateTestImpl(), defaultConstructorMarker);
            }
            SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.sTestInstance;
            Intrinsics.checkNotNull(sharedPreferencesCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat");
            return sharedPreferencesCompat;
        }

        @JvmStatic
        public final void setApplicationContext(@Nullable Context context) {
            SharedPreferencesCompat.sApplicatoinContext = context;
        }

        @JvmStatic
        public final synchronized void setMode(int mode) {
            try {
                SharedPreferencesCompat.mMode = mode;
                LoggerBase.INSTANCE.m7132d(SharedPreferencesCompat.TAG, "mode : ".concat(mode == 0 ? "MODE_ANDROID" : "MODE_TEST"));
            } catch (Throwable th) {
                throw th;
            }
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final synchronized SharedPreferencesCompat getInstance(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (SharedPreferencesCompat.mMode != 0 || SharedPreferencesCompat.sApplicatoinContext == null) {
                if (SharedPreferencesCompat.sTestInstance == null) {
                    SharedPreferencesCompat.sTestInstance = new SharedPreferencesCompat(new SharedPreferencesDelegateTestImpl(), defaultConstructorMarker);
                }
                SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.sTestInstance;
                Intrinsics.checkNotNull(sharedPreferencesCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat");
                return sharedPreferencesCompat;
            }
            Context context = SharedPreferencesCompat.sApplicatoinContext;
            Intrinsics.checkNotNull(context);
            return new SharedPreferencesCompat(new SharedPreferencesDelegateAndroidImpl(context, name), defaultConstructorMarker);
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0010\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\nH&J*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H&J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0005H&J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\nH&J\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\fH&J\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u000eH&J\u001c\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010 \u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H&J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010#\u001a\u00020\u001aH&J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0012\u0010'\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H&R\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateImpl;", "", Constant.DOC_SCAN_EDIT_PATH, "Landroid/content/SharedPreferences$Editor;", "getBoolean", "", "key", "", "defValue", "getInt", "", "getLong", "", "getFloat", "", "getString", "getColor", "getStringSet", "", "defValues", "all", "", "getAll", "()Ljava/util/Map;", "contains", "putBoolean", "", "value", "putInt", "putLong", "putFloat", "putString", "putStringSet", "values", "remove", "clear", "registerOnSharedPreferenceChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SharedPreferencesDelegateImpl {
        void clear();

        boolean contains(@Nullable String key);

        @NotNull
        SharedPreferences.Editor edit();

        @Nullable
        Map<String, ?> getAll();

        boolean getBoolean(@Nullable String key, boolean defValue);

        int getColor(@Nullable String key, int defValue);

        float getFloat(@Nullable String key, float defValue);

        int getInt(@Nullable String key, int defValue);

        long getLong(@Nullable String key, long defValue);

        @Nullable
        String getString(@Nullable String key, @Nullable String defValue);

        @Nullable
        Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues);

        void putBoolean(@Nullable String key, boolean value);

        void putFloat(@Nullable String key, float value);

        void putInt(@Nullable String key, int value);

        void putLong(@Nullable String key, long value);

        void putString(@Nullable String key, @Nullable String value);

        void putStringSet(@Nullable String key, @Nullable Set<String> values);

        void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener);

        void remove(@Nullable String key);

        void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener);
    }

    public /* synthetic */ SharedPreferencesCompat(SharedPreferencesDelegateImpl sharedPreferencesDelegateImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferencesDelegateImpl);
    }

    @NotNull
    public static final synchronized SharedPreferencesCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final void setApplicationContext(@Nullable Context context) {
        INSTANCE.setApplicationContext(context);
    }

    @JvmStatic
    public static final synchronized void setMode(int i) {
        INSTANCE.setMode(i);
    }

    public final void clear() {
        this.mImpl.clear();
    }

    public final boolean contains(@Nullable String key) {
        return this.mImpl.contains(key);
    }

    @NotNull
    public final SharedPreferences.Editor edit() {
        return this.mImpl.edit();
    }

    @Nullable
    public final Map<String, ?> getAll() {
        return this.mImpl.getAll();
    }

    public final boolean getBoolean(@Nullable String key, boolean defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getBoolean(key, defValue) : defValue;
    }

    public final int getColor(@Nullable String key, int defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getColor(key, defValue) : defValue;
    }

    public final float getFloat(@Nullable String key, float defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getFloat(key, defValue) : defValue;
    }

    public final int getInt(@Nullable String key, int defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getInt(key, defValue) : defValue;
    }

    public final long getLong(@Nullable String key, long defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getLong(key, defValue) : defValue;
    }

    @Nullable
    public final String getString(@Nullable String key, @Nullable String defValue) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getString(key, defValue) : defValue;
    }

    @Nullable
    public final Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues) {
        return !TextUtils.isEmpty(key) ? this.mImpl.getStringSet(key, defValues) : defValues;
    }

    public final void putBoolean(@Nullable String key, boolean value) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putBoolean(key, value);
    }

    public final void putFloat(@Nullable String key, float value) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putFloat(key, value);
    }

    public final void putInt(@Nullable String key, int value) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putInt(key, value);
    }

    public final void putLong(@Nullable String key, long value) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putLong(key, value);
    }

    public final void putString(@Nullable String key, @Nullable String value) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putString(key, value);
    }

    public final void putStringSet(@Nullable String key, @Nullable Set<String> values) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.putStringSet(key, values);
    }

    public final void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        this.mImpl.registerOnSharedPreferenceChangeListener(listener);
    }

    public final void remove(@Nullable String key) {
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mImpl.remove(key);
    }

    public final void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        this.mImpl.unregisterOnSharedPreferenceChangeListener(listener);
    }

    private SharedPreferencesCompat(SharedPreferencesDelegateImpl sharedPreferencesDelegateImpl) {
        this.mImpl = sharedPreferencesDelegateImpl;
    }

    @JvmStatic
    @NotNull
    public static final synchronized SharedPreferencesCompat getInstance(@NotNull String str) {
        return INSTANCE.getInstance(str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001b\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0015H\u0016J*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH\u0016J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010$\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0011H\u0016J\u001a\u0010'\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0015H\u0016J\u001a\u0010(\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0017H\u0016J\u001a\u0010)\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0019H\u0016J\u001c\u0010*\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010+\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH\u0016J\u0012\u0010-\u001a\u00020%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateAndroidImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferenceName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mPrefs", "Landroid/content/SharedPreferences;", "mMutex", "", "getDefaultPreferencesName", Constant.DOC_SCAN_EDIT_PATH, "Landroid/content/SharedPreferences$Editor;", "getBoolean", "", "key", "defValue", "getInt", "", "getLong", "", "getFloat", "", "getString", "getColor", "getStringSet", "", "defValues", "all", "", "getAll", "()Ljava/util/Map;", "contains", "putBoolean", "", "value", "putInt", "putLong", "putFloat", "putString", "putStringSet", "values", "remove", "clear", "registerOnSharedPreferenceChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SharedPreferencesDelegateAndroidImpl implements SharedPreferencesDelegateImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final Map<String, Object> sMutexMap = new ConcurrentHashMap();

        @NotNull
        private final Object mMutex;

        @NotNull
        private final SharedPreferences mPrefs;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateAndroidImpl$Companion;", "", "<init>", "()V", "sMutexMap", "", "", "getMutex", "prefName", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final synchronized Object getMutex(String prefName) {
                Object obj;
                obj = SharedPreferencesDelegateAndroidImpl.sMutexMap.get(prefName);
                if (obj == null) {
                    obj = new Object();
                    SharedPreferencesDelegateAndroidImpl.sMutexMap.put(prefName, obj);
                }
                return obj;
            }

            private Companion() {
            }
        }

        public SharedPreferencesDelegateAndroidImpl(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mMutex = INSTANCE.getMutex(getDefaultPreferencesName(context));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
            this.mPrefs = defaultSharedPreferences;
        }

        private final String getDefaultPreferencesName(Context context) {
            try {
                String defaultSharedPreferencesName = PreferenceManager.getDefaultSharedPreferencesName(context);
                Intrinsics.checkNotNullExpressionValue(defaultSharedPreferencesName, "getDefaultSharedPreferencesName(...)");
                return defaultSharedPreferencesName;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7133e(SharedPreferencesCompat.TAG, "getDefaultPreferencesName, e: " + e.getMessage());
                return AbstractC0541b.m756B(context.getPackageName(), "_preferences");
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void clear() {
            synchronized (this.mMutex) {
                this.mPrefs.edit().clear().apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public boolean contains(@Nullable String key) {
            boolean zContains;
            synchronized (this.mMutex) {
                zContains = this.mPrefs.contains(key);
            }
            return zContains;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @NotNull
        public SharedPreferences.Editor edit() {
            SharedPreferences.Editor editorEdit;
            synchronized (this.mMutex) {
                editorEdit = this.mPrefs.edit();
                Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
            }
            return editorEdit;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @Nullable
        public Map<String, ?> getAll() {
            Map<String, ?> all;
            synchronized (this.mMutex) {
                all = this.mPrefs.getAll();
            }
            return all;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public boolean getBoolean(@Nullable String key, boolean defValue) {
            boolean z;
            synchronized (this.mMutex) {
                z = this.mPrefs.getBoolean(key, defValue);
            }
            return z;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public int getColor(@Nullable String key, int defValue) {
            int i;
            Resources resources;
            Context context = SharedPreferencesCompat.sApplicatoinContext;
            int color = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getColor(defValue, null);
            synchronized (this.mMutex) {
                i = this.mPrefs.getInt(key, color);
            }
            return i;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public float getFloat(@Nullable String key, float defValue) {
            float f;
            synchronized (this.mMutex) {
                f = this.mPrefs.getFloat(key, defValue);
            }
            return f;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public int getInt(@Nullable String key, int defValue) {
            int i;
            synchronized (this.mMutex) {
                i = this.mPrefs.getInt(key, defValue);
            }
            return i;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public long getLong(@Nullable String key, long defValue) {
            long j;
            synchronized (this.mMutex) {
                j = this.mPrefs.getLong(key, defValue);
            }
            return j;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @Nullable
        public String getString(@Nullable String key, @Nullable String defValue) {
            String string;
            synchronized (this.mMutex) {
                string = this.mPrefs.getString(key, defValue);
            }
            return string;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @Nullable
        public Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues) {
            Set<String> stringSet;
            synchronized (this.mMutex) {
                stringSet = this.mPrefs.getStringSet(key, defValues);
            }
            return stringSet;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putBoolean(@Nullable String key, boolean value) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putBoolean(key, value).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putFloat(@Nullable String key, float value) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putFloat(key, value).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putInt(@Nullable String key, int value) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putInt(key, value).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putLong(@Nullable String key, long value) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putLong(key, value).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putString(@Nullable String key, @Nullable String value) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putString(key, value).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putStringSet(@Nullable String key, @Nullable Set<String> values) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().putStringSet(key, values).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
            synchronized (this.mMutex) {
                this.mPrefs.registerOnSharedPreferenceChangeListener(listener);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void remove(@Nullable String key) {
            synchronized (this.mMutex) {
                this.mPrefs.edit().remove(key).apply();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
            synchronized (this.mMutex) {
                this.mPrefs.unregisterOnSharedPreferenceChangeListener(listener);
                Unit unit = Unit.INSTANCE;
            }
        }

        public SharedPreferencesDelegateAndroidImpl(@NotNull Context context, @NotNull String preferenceName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
            this.mMutex = INSTANCE.getMutex(preferenceName);
            SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            this.mPrefs = sharedPreferences;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\fH\u0016J\u001a\u0010\"\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0010H\u0016J\u001a\u0010#\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0012H\u0016J\u001a\u0010$\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0014H\u0016J\u001c\u0010%\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010&\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010)\u001a\u00020 H\u0016J\u0012\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R.\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateTestImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateImpl;", "<init>", "()V", "mMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", Constant.DOC_SCAN_EDIT_PATH, "Landroid/content/SharedPreferences$Editor;", "getBoolean", "", "key", "defValue", "getInt", "", "getLong", "", "getFloat", "", "getString", "getColor", "getStringSet", "", "defValues", "all", "", "getAll", "()Ljava/util/Map;", "contains", "putBoolean", "", "value", "putInt", "putLong", "putFloat", "putString", "putStringSet", "values", "remove", "clear", "registerOnSharedPreferenceChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "unregisterOnSharedPreferenceChangeListener", "Editor", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SharedPreferencesDelegateTestImpl implements SharedPreferencesDelegateImpl {

        @NotNull
        private final HashMap<String, Object> mMap = new HashMap<>();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B/\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0001H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat$SharedPreferencesDelegateTestImpl$Editor;", "Landroid/content/SharedPreferences$Editor;", "mPrefMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "mEditorMap", "mRemovedKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mNeedClear", "", "putString", "key", "value", "putStringSet", "values", "", "putInt", "", "putLong", "", "putFloat", "", "putBoolean", "remove", "clear", "commit", "apply", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Editor implements SharedPreferences.Editor {

            @NotNull
            private final HashMap<String, Object> mEditorMap;
            private boolean mNeedClear;

            @NotNull
            private final HashMap<String, Object> mPrefMap;

            @NotNull
            private final ArrayList<String> mRemovedKeys;

            public Editor(@NotNull HashMap<String, Object> mPrefMap) {
                Intrinsics.checkNotNullParameter(mPrefMap, "mPrefMap");
                this.mPrefMap = mPrefMap;
                this.mEditorMap = new HashMap<>();
                this.mRemovedKeys = new ArrayList<>();
            }

            @Override // android.content.SharedPreferences.Editor
            public void apply() {
                if (this.mNeedClear) {
                    this.mPrefMap.clear();
                    return;
                }
                this.mPrefMap.putAll(this.mEditorMap);
                Iterator<String> it = this.mRemovedKeys.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    String next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    this.mPrefMap.remove(next);
                }
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor clear() {
                this.mNeedClear = true;
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public boolean commit() {
                apply();
                return true;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putBoolean(@NotNull String key, boolean value) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, Boolean.valueOf(value));
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putFloat(@NotNull String key, float value) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, Float.valueOf(value));
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putInt(@NotNull String key, int value) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, Integer.valueOf(value));
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putLong(@NotNull String key, long value) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, Long.valueOf(value));
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putString(@NotNull String key, @Nullable String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, value);
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor putStringSet(@NotNull String key, @Nullable Set<String> values) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mEditorMap.put(key, values);
                }
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            @NotNull
            public SharedPreferences.Editor remove(@NotNull String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!TextUtils.isEmpty(key)) {
                    this.mRemovedKeys.add(key);
                }
                return this;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void clear() {
            this.mMap.clear();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public boolean contains(@Nullable String key) {
            return this.mMap.containsKey(key);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @NotNull
        public SharedPreferences.Editor edit() {
            return new Editor(this.mMap);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @NotNull
        public Map<String, ?> getAll() {
            return this.mMap;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public boolean getBoolean(@Nullable String key, boolean defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public int getColor(@Nullable String key, int defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof Integer ? ((Number) obj).intValue() : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public float getFloat(@Nullable String key, float defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof Float ? ((Number) obj).floatValue() : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public int getInt(@Nullable String key, int defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof Integer ? ((Number) obj).intValue() : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public long getLong(@Nullable String key, long defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof Long ? ((Number) obj).longValue() : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @Nullable
        public String getString(@Nullable String key, @Nullable String defValue) {
            Object obj = this.mMap.get(key);
            return obj instanceof String ? (String) obj : defValue;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        @Nullable
        public Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues) {
            Object obj = this.mMap.get(key);
            return obj instanceof Set ? (Set) obj : defValues;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putBoolean(@Nullable String key, boolean value) {
            this.mMap.put(String.valueOf(key), Boolean.valueOf(value));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putFloat(@Nullable String key, float value) {
            this.mMap.put(String.valueOf(key), Float.valueOf(value));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putInt(@Nullable String key, int value) {
            this.mMap.put(String.valueOf(key), Integer.valueOf(value));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putLong(@Nullable String key, long value) {
            this.mMap.put(String.valueOf(key), Long.valueOf(value));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putString(@Nullable String key, @Nullable String value) {
            this.mMap.put(String.valueOf(key), value);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void putStringSet(@Nullable String key, @Nullable Set<String> values) {
            this.mMap.put(String.valueOf(key), values);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void remove(@Nullable String key) {
            TypeIntrinsics.asMutableMap(this.mMap).remove(key);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.content.SharedPreferencesCompat.SharedPreferencesDelegateImpl
        public void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        }
    }
}
