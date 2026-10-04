package com.samsung.android.sdk.composer.voice;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenAudioDeviceReceiver;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/voice/SpenAudioDeviceCallbackListener;", "context", "Landroid/content/Context;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/SpenAudioDeviceCallbackListener;Landroid/content/Context;)V", "mContext", "mListener", "mAudioManager", "Landroid/media/AudioManager;", "mAudioDeviceCallback", "Landroid/media/AudioDeviceCallback;", "mIsWiredHeadsetConnected", "", "mIsSCODeviceConnected", "mIsA2DPDeviceConnected", "close", "", "isWiredHeadsetConnected", "isSCODeviceConnected", "isA2DPDeviceConnected", "isWiredHeadSetPlugged", "registerAudioDeviceCallback", "unregisterAudioDeviceCallback", "initAudioDeviceCallback", "isWiredHeadsetDevice", "device", "Landroid/media/AudioDeviceInfo;", "isBluetoothSCODevice", "isBluetoothA2DPDevice", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenAudioDeviceReceiver {

    @NotNull
    private static final String TAG = "SpenAudioDeviceReceiver";

    @Nullable
    private AudioDeviceCallback mAudioDeviceCallback;

    @Nullable
    private AudioManager mAudioManager;

    @NotNull
    private Context mContext;
    private boolean mIsA2DPDeviceConnected;
    private boolean mIsSCODeviceConnected;
    private boolean mIsWiredHeadsetConnected;

    @NotNull
    private SpenAudioDeviceCallbackListener mListener;

    public SpenAudioDeviceReceiver(@NotNull SpenAudioDeviceCallbackListener listener, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(context, "context");
        Log.i(TAG, TAG);
        this.mListener = listener;
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        registerAudioDeviceCallback();
    }

    private final void initAudioDeviceCallback() {
        if (this.mAudioDeviceCallback != null) {
            Log.i(TAG, "mAudioDeviceCallback is not null");
        } else {
            this.mAudioDeviceCallback = new AudioDeviceCallback() { // from class: com.samsung.android.sdk.composer.voice.SpenAudioDeviceReceiver.initAudioDeviceCallback.1
                @Override // android.media.AudioDeviceCallback
                public void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
                    Intrinsics.checkNotNullParameter(addedDevices, "addedDevices");
                    AudioManager audioManager = SpenAudioDeviceReceiver.this.mAudioManager;
                    Intrinsics.checkNotNull(audioManager);
                    AudioDeviceInfo[] devices = audioManager.getDevices(1);
                    boolean z = SpenAudioDeviceReceiver.this.mIsA2DPDeviceConnected || SpenAudioDeviceReceiver.this.mIsSCODeviceConnected;
                    Iterator it = ArrayIteratorKt.iterator(devices);
                    boolean z2 = false;
                    while (it.hasNext()) {
                        AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) it.next();
                        SpenAudioDeviceReceiver spenAudioDeviceReceiver = SpenAudioDeviceReceiver.this;
                        Intrinsics.checkNotNull(audioDeviceInfo);
                        if (spenAudioDeviceReceiver.isWiredHeadsetDevice(audioDeviceInfo) && !SpenAudioDeviceReceiver.this.getMIsWiredHeadsetConnected()) {
                            SpenAudioDeviceReceiver.this.mIsWiredHeadsetConnected = true;
                            z2 = true;
                        }
                    }
                    boolean z3 = false;
                    boolean z4 = false;
                    for (AudioDeviceInfo audioDeviceInfo2 : addedDevices) {
                        if (SpenAudioDeviceReceiver.this.isBluetoothA2DPDevice(audioDeviceInfo2) && !SpenAudioDeviceReceiver.this.getMIsA2DPDeviceConnected()) {
                            SpenAudioDeviceReceiver.this.mIsA2DPDeviceConnected = true;
                            z4 = true;
                        }
                        if (SpenAudioDeviceReceiver.this.isBluetoothSCODevice(audioDeviceInfo2) && !SpenAudioDeviceReceiver.this.getMIsSCODeviceConnected()) {
                            SpenAudioDeviceReceiver.this.mIsSCODeviceConnected = true;
                            z3 = true;
                        }
                    }
                    if (z2 || ((z3 || z4) && !z)) {
                        SpenAudioDeviceReceiver.this.mListener.onAudioDevicesAdded(SpenAudioDeviceReceiver.this.mIsWiredHeadsetConnected);
                    }
                }

                @Override // android.media.AudioDeviceCallback
                public void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
                    Intrinsics.checkNotNullParameter(removedDevices, "removedDevices");
                    boolean z = false;
                    boolean z2 = false;
                    boolean z3 = false;
                    for (AudioDeviceInfo audioDeviceInfo : removedDevices) {
                        if (SpenAudioDeviceReceiver.this.isWiredHeadsetDevice(audioDeviceInfo)) {
                            SpenAudioDeviceReceiver.this.mIsWiredHeadsetConnected = false;
                            z3 = true;
                        }
                        if (SpenAudioDeviceReceiver.this.isBluetoothA2DPDevice(audioDeviceInfo)) {
                            SpenAudioDeviceReceiver.this.mIsA2DPDeviceConnected = false;
                            z2 = true;
                        }
                        if (SpenAudioDeviceReceiver.this.isBluetoothSCODevice(audioDeviceInfo)) {
                            SpenAudioDeviceReceiver.this.mIsSCODeviceConnected = false;
                            z = true;
                        }
                    }
                    boolean z4 = z || z2;
                    boolean zIsWiredHeadSetPlugged = SpenAudioDeviceReceiver.this.isWiredHeadSetPlugged();
                    SpenAudioDeviceReceiver.this.mIsWiredHeadsetConnected = zIsWiredHeadSetPlugged;
                    AudioManager audioManager = SpenAudioDeviceReceiver.this.mAudioManager;
                    Intrinsics.checkNotNull(audioManager);
                    Iterator it = ArrayIteratorKt.iterator(audioManager.getDevices(2));
                    boolean z5 = false;
                    boolean z6 = false;
                    while (it.hasNext()) {
                        AudioDeviceInfo audioDeviceInfo2 = (AudioDeviceInfo) it.next();
                        SpenAudioDeviceReceiver spenAudioDeviceReceiver = SpenAudioDeviceReceiver.this;
                        Intrinsics.checkNotNull(audioDeviceInfo2);
                        if (spenAudioDeviceReceiver.isBluetoothSCODevice(audioDeviceInfo2)) {
                            SpenAudioDeviceReceiver.this.mIsSCODeviceConnected = true;
                            z5 = true;
                        }
                        if (SpenAudioDeviceReceiver.this.isBluetoothA2DPDevice(audioDeviceInfo2)) {
                            SpenAudioDeviceReceiver.this.mIsA2DPDeviceConnected = true;
                            z6 = true;
                        }
                    }
                    boolean z7 = z5 || z6;
                    if ((zIsWiredHeadSetPlugged || !z3) && (z7 || !z4)) {
                        return;
                    }
                    SpenAudioDeviceReceiver.this.mListener.onAudioDevicesRemoved(SpenAudioDeviceReceiver.this.mIsWiredHeadsetConnected);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBluetoothA2DPDevice(AudioDeviceInfo device) {
        return device.getType() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBluetoothSCODevice(AudioDeviceInfo device) {
        return device.getType() == 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWiredHeadSetPlugged() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return false;
        }
        Iterator it = ArrayIteratorKt.iterator(audioManager.getDevices(1));
        while (it.hasNext()) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) it.next();
            Intrinsics.checkNotNull(audioDeviceInfo);
            if (isWiredHeadsetDevice(audioDeviceInfo)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWiredHeadsetDevice(AudioDeviceInfo device) {
        return (device.getType() == 3 && device.isSource()) || device.getType() == 11 || device.getType() == 12 || device.getType() == 22;
    }

    private final void registerAudioDeviceCallback() {
        initAudioDeviceCallback();
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            try {
                Log.i(TAG, "registerAudioDeviceCallback");
                audioManager.registerAudioDeviceCallback(this.mAudioDeviceCallback, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void unregisterAudioDeviceCallback() {
        AudioManager audioManager;
        if (this.mAudioDeviceCallback == null || (audioManager = this.mAudioManager) == null) {
            return;
        }
        try {
            Log.i(TAG, "unregisterAudioDeviceCallback");
            audioManager.unregisterAudioDeviceCallback(this.mAudioDeviceCallback);
            this.mAudioDeviceCallback = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void close() {
        unregisterAudioDeviceCallback();
        this.mAudioManager = null;
    }

    /* JADX INFO: renamed from: isA2DPDeviceConnected, reason: from getter */
    public final boolean getMIsA2DPDeviceConnected() {
        return this.mIsA2DPDeviceConnected;
    }

    /* JADX INFO: renamed from: isSCODeviceConnected, reason: from getter */
    public final boolean getMIsSCODeviceConnected() {
        return this.mIsSCODeviceConnected;
    }

    /* JADX INFO: renamed from: isWiredHeadsetConnected, reason: from getter */
    public final boolean getMIsWiredHeadsetConnected() {
        return this.mIsWiredHeadsetConnected;
    }
}
