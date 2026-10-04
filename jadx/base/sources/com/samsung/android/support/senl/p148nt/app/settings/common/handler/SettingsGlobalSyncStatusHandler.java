package com.samsung.android.support.senl.p148nt.app.settings.common.handler;

import android.content.ContentResolver;
import android.content.SyncStatusObserver;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler;", "Landroid/os/Handler;", "mListener", "Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler$Listener;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler$Listener;)V", "mSyncStatusChangeHandle", "", "mSyncStatusObserver", "Landroid/content/SyncStatusObserver;", "initialize", "", "initSyncStatusObserver", "initSyncStatusChangeHandle", "release", "releaseSyncStatusObserver", "releaseSyncStatusChangeHandle", "Listener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsGlobalSyncStatusHandler extends Handler {

    @Nullable
    private Listener mListener;

    @Nullable
    private Object mSyncStatusChangeHandle;

    @Nullable
    private SyncStatusObserver mSyncStatusObserver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/handler/SettingsGlobalSyncStatusHandler$Listener;", "", "onGlobalSyncChanged", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onGlobalSyncChanged();
    }

    public SettingsGlobalSyncStatusHandler(@Nullable Listener listener) {
        super(Looper.getMainLooper());
        this.mListener = listener;
    }

    private final void initSyncStatusChangeHandle() {
        SyncStatusObserver syncStatusObserver = this.mSyncStatusObserver;
        if (syncStatusObserver == null || this.mSyncStatusChangeHandle != null) {
            return;
        }
        this.mSyncStatusChangeHandle = ContentResolver.addStatusChangeListener(1, syncStatusObserver);
    }

    private final void initSyncStatusObserver() {
        if (this.mSyncStatusObserver != null) {
            return;
        }
        this.mSyncStatusObserver = new SyncStatusObserver() { // from class: U2.a
            @Override // android.content.SyncStatusObserver
            public final void onStatusChanged(int i) {
                SettingsGlobalSyncStatusHandler.initSyncStatusObserver$lambda$1(this.f811a, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSyncStatusObserver$lambda$1(SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler, int i) {
        settingsGlobalSyncStatusHandler.post(new RunnableC0015b(settingsGlobalSyncStatusHandler, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSyncStatusObserver$lambda$1$lambda$0(SettingsGlobalSyncStatusHandler settingsGlobalSyncStatusHandler) {
        Listener listener = settingsGlobalSyncStatusHandler.mListener;
        if (listener == null) {
            return;
        }
        listener.onGlobalSyncChanged();
    }

    private final void releaseSyncStatusChangeHandle() {
        Object obj = this.mSyncStatusChangeHandle;
        if (obj == null) {
            return;
        }
        ContentResolver.removeStatusChangeListener(obj);
        this.mSyncStatusChangeHandle = null;
    }

    private final void releaseSyncStatusObserver() {
        if (this.mSyncStatusObserver != null) {
            this.mSyncStatusObserver = null;
        }
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public final void initialize() {
        initSyncStatusObserver();
        initSyncStatusChangeHandle();
    }

    public final void release() {
        releaseSyncStatusObserver();
        releaseSyncStatusChangeHandle();
    }
}
