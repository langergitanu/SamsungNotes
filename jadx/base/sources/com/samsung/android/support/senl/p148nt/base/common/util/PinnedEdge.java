package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.addons.base.model.setting.C7956a;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContentResolver", "Landroid/content/ContentResolver;", "mStateChangeListener", "Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge$StateChangeListener;", "isPinnedPanelRunning", "", "()Z", "setPinnedPanelRunning", "(Z)V", "mPanelModeSettingsCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "setStateChangeListener", "", "stateChangeListener", "registerSettingsContentObserver", "unregisterSettingsContentObserver", "initPinnedPanelRunning", "StateChangeListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PinnedEdge {

    @NotNull
    private static final String APP_EDGE_AUTHORITY = "com.samsung.android.app.appsedge.data.AppsEdgeDataProvider";

    @NotNull
    private static final String BUNDLE_KEY_ENABLE_PINNED_EDGE = "enablePinnedEdge";

    @NotNull
    private static final String METHOD_IS_ENABLE_PINNED_EDGE = "isEnablePinnedEdge";
    private static final int MODE_PANEL = 0;
    private static final int MODE_PIN = 1;

    @NotNull
    private static final String PANEL_MODE = "panel_mode";

    @NotNull
    private static final String TAG = "PinnedEdge";
    private boolean isPinnedPanelRunning;

    @NotNull
    private final ContentResolver mContentResolver;

    @NotNull
    private final SettingsContentObserver.SettingsContentChangedCallback mPanelModeSettingsCallback;

    @Nullable
    private StateChangeListener mStateChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge$StateChangeListener;", "", "onStateChanged", "", "isPinnedPanelRunning", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface StateChangeListener {
        void onStateChanged(boolean isPinnedPanelRunning);
    }

    public PinnedEdge(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        this.mContentResolver = contentResolver;
        this.mPanelModeSettingsCallback = new C7956a(this, 1);
        initPinnedPanelRunning();
    }

    private final void initPinnedPanelRunning() {
        if (DeviceUtils.isTabletModel() || FoldStateCompat.INSTANCE.getInstance().isFoldableDevice()) {
            try {
                boolean z = false;
                boolean z2 = Settings.System.getInt(this.mContentResolver, PANEL_MODE, 0) == 1;
                Bundle bundleCall = this.mContentResolver.call(Uri.parse("content://com.samsung.android.app.appsedge.data.AppsEdgeDataProvider"), METHOD_IS_ENABLE_PINNED_EDGE, (String) null, (Bundle) null);
                if (Intrinsics.areEqual(bundleCall != null ? Boolean.valueOf(bundleCall.getBoolean(BUNDLE_KEY_ENABLE_PINNED_EDGE)) : null, Boolean.TRUE) && z2) {
                    z = true;
                }
                this.isPinnedPanelRunning = z;
            } catch (Exception e) {
                AbstractC4539a.m3214x("initPinnedPanelRunning# ", e.getMessage(), TAG);
            }
        }
        Logger.m8697d(TAG, "initPinnedPanelRunning# " + this.isPinnedPanelRunning);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPanelModeSettingsCallback$lambda$0(PinnedEdge pinnedEdge, boolean z, Uri uri) {
        pinnedEdge.initPinnedPanelRunning();
        StateChangeListener stateChangeListener = pinnedEdge.mStateChangeListener;
        if (stateChangeListener != null) {
            stateChangeListener.onStateChanged(pinnedEdge.isPinnedPanelRunning);
        }
    }

    /* JADX INFO: renamed from: isPinnedPanelRunning, reason: from getter */
    public final boolean getIsPinnedPanelRunning() {
        return this.isPinnedPanelRunning;
    }

    public final void registerSettingsContentObserver() {
        if (DeviceUtils.isTabletModel() || FoldStateCompat.INSTANCE.getInstance().isFoldableDevice()) {
            SettingsContentObserver.INSTANCE.getInstance().addSettingsContentChangedCallback(this.mPanelModeSettingsCallback, PANEL_MODE, 0);
        }
    }

    public final void setPinnedPanelRunning(boolean z) {
        this.isPinnedPanelRunning = z;
    }

    public final void setStateChangeListener(@Nullable StateChangeListener stateChangeListener) {
        this.mStateChangeListener = stateChangeListener;
    }

    public final void unregisterSettingsContentObserver() {
        SettingsContentObserver.INSTANCE.getInstance().removeSettingsContentChangedCallback(this.mPanelModeSettingsCallback);
    }
}
