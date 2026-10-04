package com.samsung.android.support.senl.p145cm.base.framework.observer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002R,\u0010\u0004\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver;", "", "<init>", "()V", "mChangedCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/net/Uri;", "Landroid/util/Pair;", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "Landroid/database/ContentObserver;", "addSettingsContentChangedCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "what", "", "type", "", "removeSettingsContentChangedCallback", "notifyOnChanged", "", "selfChange", "uri", PackageRelationship.TYPE_ATTRIBUTE_NAME, "SettingsContentChangedCallback", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsContentObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SettingsContentObserver";

    @Nullable
    private static Context mApplicationContext;

    @Nullable
    private static SettingsContentObserver mInstance;

    @NotNull
    private final ConcurrentHashMap<Uri, Pair<SettingsContentChangedCallback, ContentObserver>> mChangedCallbackList = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mApplicationContext", "Landroid/content/Context;", "setApplicationContext", "", "context", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SettingsContentObserver getInstance() {
            SettingsContentObserver settingsContentObserver;
            try {
                if (SettingsContentObserver.mInstance == null) {
                    SettingsContentObserver.mInstance = new SettingsContentObserver();
                }
                settingsContentObserver = SettingsContentObserver.mInstance;
                Intrinsics.checkNotNull(settingsContentObserver, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver");
            } catch (Throwable th) {
                throw th;
            }
            return settingsContentObserver;
        }

        @JvmStatic
        public final void setApplicationContext(@Nullable Context context) {
            SettingsContentObserver.mApplicationContext = context;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "", "onChanged", "", "selfChange", "", "uri", "Landroid/net/Uri;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SettingsContentChangedCallback {
        void onChanged(boolean selfChange, @Nullable Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$Type;", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Type {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int GLOBAL = 1;
        public static final int SYSTEM = 0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$Type$Companion;", "", "<init>", "()V", "SYSTEM", "", "GLOBAL", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int GLOBAL = 1;
            public static final int SYSTEM = 0;

            private Companion() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyOnChanged(boolean selfChange, Uri uri) {
        SettingsContentChangedCallback settingsContentChangedCallback;
        LoggerBase.INSTANCE.m7132d(TAG, "notifyOnChanged selfChange " + selfChange);
        for (Map.Entry<Uri, Pair<SettingsContentChangedCallback, ContentObserver>> entry : this.mChangedCallbackList.entrySet()) {
            Uri key = entry.getKey();
            Pair<SettingsContentChangedCallback, ContentObserver> value = entry.getValue();
            if (key != null && Intrinsics.areEqual(uri, key)) {
                if ((value != null ? (SettingsContentChangedCallback) value.first : null) != null && (settingsContentChangedCallback = (SettingsContentChangedCallback) value.first) != null) {
                    settingsContentChangedCallback.onChanged(selfChange, uri);
                }
            }
        }
    }

    @JvmStatic
    public static final void setApplicationContext(@Nullable Context context) {
        INSTANCE.setApplicationContext(context);
    }

    public final boolean addSettingsContentChangedCallback(@Nullable SettingsContentChangedCallback callback, @NotNull String what, int type) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(what, "what");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "addSettingsContentChangedCallback, callback/what : " + (callback == null ? "null" : callback) + "/" + what);
        if (callback == null || TextUtils.isEmpty(what)) {
            companion.m7132d(TAG, "addSettingsContentChangedCallback, invalid arguments");
            return false;
        }
        Iterator<Map.Entry<Uri, Pair<SettingsContentChangedCallback, ContentObserver>>> it = this.mChangedCallbackList.entrySet().iterator();
        while (it.hasNext()) {
            Pair<SettingsContentChangedCallback, ContentObserver> value = it.next().getValue();
            if (value != null) {
                Object obj = value.first;
                if ((obj != null ? obj.hashCode() : 0) == callback.hashCode()) {
                    LoggerBase.INSTANCE.m7132d(TAG, "addSettingsContentChangedCallback, already added");
                    return false;
                }
            }
        }
        Uri uriFor = type == 0 ? Settings.System.getUriFor(what) : Settings.Global.getUriFor(what);
        final Handler handler = new Handler();
        ContentObserver contentObserver = new ContentObserver(handler) { // from class: com.samsung.android.support.senl.cm.base.framework.observer.SettingsContentObserver$addSettingsContentChangedCallback$contentObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                this.this$0.notifyOnChanged(selfChange, uri);
            }
        };
        Context context = mApplicationContext;
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            contentResolver.registerContentObserver(uriFor, false, contentObserver);
        }
        this.mChangedCallbackList.put(uriFor, new Pair<>(callback, contentObserver));
        return true;
    }

    public final boolean removeSettingsContentChangedCallback(@Nullable SettingsContentChangedCallback callback) {
        ContentResolver contentResolver;
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "removeSettingsContentChangedCallback, callback : " + (callback == null ? "null" : callback));
        if (callback == null) {
            companion.m7132d(TAG, "removeSettingsContentChangedCallback, invalid argument");
            return false;
        }
        for (Map.Entry<Uri, Pair<SettingsContentChangedCallback, ContentObserver>> entry : this.mChangedCallbackList.entrySet()) {
            Uri key = entry.getKey();
            Pair<SettingsContentChangedCallback, ContentObserver> value = entry.getValue();
            if (value != null) {
                Object obj = value.first;
                if ((obj != null ? obj.hashCode() : 0) == callback.hashCode()) {
                    Context context = mApplicationContext;
                    if (context != null && (contentResolver = context.getContentResolver()) != null) {
                        contentResolver.unregisterContentObserver((ContentObserver) value.second);
                    }
                    this.mChangedCallbackList.remove(key);
                    return true;
                }
            }
        }
        return false;
    }
}
