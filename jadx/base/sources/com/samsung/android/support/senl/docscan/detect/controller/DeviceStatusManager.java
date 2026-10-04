package com.samsung.android.support.senl.docscan.detect.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "value", "", "isPluggedHeadSet", "()Z", "mHasMicrophone", "mAudioManager", "Landroid/media/AudioManager;", "mHeadSetPlugChangedListeners", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager$HeadSetPlugChangedListener;", "Lkotlin/collections/ArrayList;", "enableSystemSound", "", "streamType", "", "mute", "onReceive", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "notifyHeadSetPlugChanged", "isPlugged", "hasMicrophone", "HeadSetPlugChangedListener", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeviceStatusManager extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "DeviceStatusManager";

    @Nullable
    private static DeviceStatusManager mInstance;
    private boolean isPluggedHeadSet;

    @Nullable
    private final AudioManager mAudioManager;
    private boolean mHasMicrophone;

    @NotNull
    private final ArrayList<HeadSetPlugChangedListener> mHeadSetPlugChangedListeners = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final synchronized DeviceStatusManager getInstance() {
            try {
                if (DeviceStatusManager.mInstance == null) {
                    DeviceStatusManager.mInstance = new DeviceStatusManager();
                }
            } catch (Throwable th) {
                throw th;
            }
            return DeviceStatusManager.mInstance;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/DeviceStatusManager$HeadSetPlugChangedListener;", "", "onHeadSetPlugChanged", "", "isPlugged", "", "hasMicrophone", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface HeadSetPlugChangedListener {
        void onHeadSetPlugChanged(boolean isPlugged, boolean hasMicrophone);
    }

    public DeviceStatusManager() {
        Context applicationContext = BaseUtils.getApplicationContext();
        Object systemService = applicationContext != null ? applicationContext.getSystemService("audio") : null;
        this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
    }

    private final void notifyHeadSetPlugChanged(boolean isPlugged, boolean hasMicrophone) {
        int size = this.mHeadSetPlugChangedListeners.size();
        for (int i = 0; i < size; i++) {
            HeadSetPlugChangedListener headSetPlugChangedListener = this.mHeadSetPlugChangedListeners.get(i);
            Intrinsics.checkNotNullExpressionValue(headSetPlugChangedListener, "get(...)");
            headSetPlugChangedListener.onHeadSetPlugChanged(isPlugged, hasMicrophone);
        }
    }

    public final void enableSystemSound(int streamType, boolean mute) {
        Logger.m7145d(TAG, "enableSystemSound# mute? " + mute);
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.adjustStreamVolume(streamType, mute ? -100 : 100, 0);
        }
    }

    /* JADX INFO: renamed from: isPluggedHeadSet, reason: from getter */
    public final boolean getIsPluggedHeadSet() {
        return this.isPluggedHeadSet;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (!Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", action)) {
            if (Intrinsics.areEqual(BaseWidgetConstant.TIME_SET_CHANGED, action)) {
                Logger.m7145d(TAG, "onReceive, intent : " + intent);
                return;
            }
            return;
        }
        Logger.m7145d(TAG, "onReceive, intent : " + intent);
        this.isPluggedHeadSet = intent.getIntExtra("state", 0) == 1;
        boolean z = intent.getIntExtra("microphone", 0) == 1;
        this.mHasMicrophone = z;
        notifyHeadSetPlugChanged(this.isPluggedHeadSet, z);
    }
}
