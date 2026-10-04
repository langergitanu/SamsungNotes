package com.samsung.android.sdk.composer.voice;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001IB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u0018\u001a\u00020\u0014H\u0007J\b\u0010\u0019\u001a\u00020\u0014H\u0007J\b\u0010\u001a\u001a\u00020\u0014H\u0003J\b\u0010\u001b\u001a\u00020\u0014H\u0003J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0003J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0014H\u0003J\u0006\u0010\u001f\u001a\u00020\u0014J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0014H\u0003J(\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%J\u0018\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020%H\u0002J\u0012\u0010*\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\tH\u0002J\b\u00103\u001a\u00020\u0014H\u0007J \u00104\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0003J\b\u00107\u001a\u00020\u0014H\u0003J\b\u00108\u001a\u00020\u0014H\u0003J\b\u00109\u001a\u00020\u0016H\u0003J\b\u0010:\u001a\u00020\u0016H\u0003J\b\u0010;\u001a\u00020\u0016H\u0003J\u0012\u0010B\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\t2\u0006\u0010D\u001a\u00020%H\u0002J\u0011\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020%H\u0082 J\u0011\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020%H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AudioFocus;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mContext", "Landroid/content/Context;", "mAudioManager", "Landroid/media/AudioManager;", "mAudioDeviceReceiver", "Lcom/samsung/android/sdk/composer/voice/SpenAudioDeviceReceiver;", "mBluetoothHeadset", "Landroid/bluetooth/BluetoothHeadset;", "mBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mPhoneListener", "Lcom/samsung/android/sdk/composer/voice/AudioFocus$AudioPhoneStateListener;", "mPhoneStateLock", "mIsRecordingViaBluetoothEnabled", "", "setContext", "", "context", "isCalling", "isRinging", "isBluetoothSCOAvaiable", "isBluetoothSCOReadyForStart", "setRecordingViaBluetooth", "enable", "enableRecordingViaBluetooth", "isRecordingViaBluetoothEnabled", "enableSystemSound", "mute", "setSystemSoundVolume", "audioManager", "systemSoundType", "", "volume", "checkVolume", "getSystemSoundVolume", "prevVolume", "isSystemSoundDisabled", "CONTENT", "AUTHORITY", "RESTRICTIONPOLICY1", "RESTRICTIONPOLICY2", "RESTRICTION1_URI", "RESTRICTION2_URI", "RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD", "RESTRICTIONPOLICY_MICROPHONEASUSER_METHOD", "isAudioDisabled", "isRestrictedByPolicy", "uriString", "policyString", "checkEarphonePlugged", "requestAudioFocus", "abandonAudioFocus", "startListenPhoneState", "endListenPhoneState", "mOnAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mProfileListener", "Landroid/bluetooth/BluetoothProfile$ServiceListener;", "mAudioDeviceCallbackListener", "Lcom/samsung/android/sdk/composer/voice/SpenAudioDeviceCallbackListener;", "getRingerModeInternal", "isZenModeEnable", "ringerModeInternal", "Native_AudioFocus_OnCallStateChanged", "state", "Native_AudioFocus_OnAudioFocusChange", "focusChange", "AudioPhoneStateListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class AudioFocus {

    @NotNull
    private static final String AUTHORITY = "com.sec.knox.provider";

    @NotNull
    private static final String CONTENT = "content://";

    @NotNull
    private static final String RESTRICTION1_URI = "content://com.sec.knox.provider/RestrictionPolicy1";

    @NotNull
    private static final String RESTRICTION2_URI = "content://com.sec.knox.provider/RestrictionPolicy2";

    @NotNull
    private static final String RESTRICTIONPOLICY1 = "RestrictionPolicy1";

    @NotNull
    private static final String RESTRICTIONPOLICY2 = "RestrictionPolicy2";

    @NotNull
    private static final String RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD = "isAudioRecordAllowed";

    @NotNull
    private static final String RESTRICTIONPOLICY_MICROPHONEASUSER_METHOD = "isMicrophoneEnabled";

    @NotNull
    private static final String TAG = "AudioFocus";

    @Nullable
    private static SpenAudioDeviceReceiver mAudioDeviceReceiver;

    @Nullable
    private static AudioManager mAudioManager;

    @Nullable
    private static BluetoothDevice mBluetoothDevice;

    @Nullable
    private static BluetoothHeadset mBluetoothHeadset;

    @Nullable
    private static Context mContext;
    private static boolean mIsRecordingViaBluetoothEnabled;

    @Nullable
    private static AudioPhoneStateListener mPhoneListener;

    @NotNull
    public static final AudioFocus INSTANCE = new AudioFocus();

    @NotNull
    private static final Object mPhoneStateLock = new Object();

    @NotNull
    private static final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.samsung.android.sdk.composer.voice.AudioFocus$mOnAudioFocusChangeListener$1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            AbstractC2322a.m1631u(focusChange, "mOnAudioFocusChangeListener: focusChange: ", "AudioFocus");
            AudioFocus.INSTANCE.Native_AudioFocus_OnAudioFocusChange(focusChange);
        }
    };

    @Nullable
    private static final BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() { // from class: com.samsung.android.sdk.composer.voice.AudioFocus$mProfileListener$1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == 1) {
                Log.d("AudioFocus", "onServiceConnected");
                AudioFocus audioFocus = AudioFocus.INSTANCE;
                AudioFocus.mBluetoothHeadset = (BluetoothHeadset) proxy;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
            if (profile == 1) {
                Log.d("AudioFocus", "onServiceDisconnected");
                AudioFocus.mBluetoothHeadset = null;
            }
        }
    };

    @NotNull
    private static final SpenAudioDeviceCallbackListener mAudioDeviceCallbackListener = new SpenAudioDeviceCallbackListener() { // from class: com.samsung.android.sdk.composer.voice.AudioFocus$mAudioDeviceCallbackListener$1
        @Override // com.samsung.android.sdk.composer.voice.SpenAudioDeviceCallbackListener
        public void onAudioDevicesAdded(boolean isWiredHeadsetDevice) {
            AbstractC4539a.m3208r("onAudioDevicesAdded isWiredHeadsetDevice = ", "AudioFocus", isWiredHeadsetDevice);
            if (!isWiredHeadsetDevice && BluetoothAdapter.getDefaultAdapter() != null) {
                BluetoothAdapter.getDefaultAdapter().getProfileProxy(AudioFocus.mContext, AudioFocus.mProfileListener, 1);
            }
            SpenNoteVoiceManager.INSTANCE.onAudioDevicesConnected(isWiredHeadsetDevice);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenAudioDeviceCallbackListener
        public void onAudioDevicesRemoved(boolean isWiredHeadsetDevice) {
            AbstractC4539a.m3208r("onAudioDevicesRemoved isWiredHeadsetDevice = ", "AudioFocus", isWiredHeadsetDevice);
            if (!isWiredHeadsetDevice && AudioFocus.mProfileListener != null && BluetoothAdapter.getDefaultAdapter() != null) {
                BluetoothAdapter.getDefaultAdapter().closeProfileProxy(1, AudioFocus.mBluetoothHeadset);
            }
            SpenNoteVoiceManager.INSTANCE.onAudioDevicesDisconnected(isWiredHeadsetDevice);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AudioFocus$AudioPhoneStateListener;", "Landroid/telephony/PhoneStateListener;", "<init>", "()V", "onCallStateChanged", "", "state", "", "incomingNumber", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AudioPhoneStateListener extends PhoneStateListener {
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, @Nullable String incomingNumber) {
            AudioFocus.INSTANCE.Native_AudioFocus_OnCallStateChanged(state);
        }
    }

    private AudioFocus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void Native_AudioFocus_OnAudioFocusChange(int focusChange);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void Native_AudioFocus_OnCallStateChanged(int state);

    @JvmStatic
    private static final void abandonAudioFocus() {
        Log.d(TAG, "abandonAudioFocus");
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
        mAudioManager = null;
    }

    @JvmStatic
    private static final boolean checkEarphonePlugged() {
        SpenAudioDeviceReceiver spenAudioDeviceReceiver;
        return (mContext == null || (spenAudioDeviceReceiver = mAudioDeviceReceiver) == null || !spenAudioDeviceReceiver.getMIsWiredHeadsetConnected()) ? false : true;
    }

    @JvmStatic
    private static final void enableRecordingViaBluetooth(boolean enable) {
        AbstractC6670b.m4759t("enableRecordingViaBluetooth() enable : ", TAG, enable);
        mIsRecordingViaBluetoothEnabled = enable;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void enableSystemSound(boolean mute) {
        AbstractC6670b.m4759t("enableSystemSound() mute? ", TAG, mute);
        Context context = mContext;
        if (context != null) {
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (mute) {
                audioManager.adjustStreamVolume(1, -100, 0);
                if (SpenComposerUtil.isWifiOnlyModel(context)) {
                    AudioFocus audioFocus = INSTANCE;
                    if (!audioFocus.isZenModeEnable(audioManager, audioFocus.getRingerModeInternal(audioManager))) {
                        audioManager.adjustStreamVolume(5, -100, 0);
                    }
                }
                if (audioManager.getRingerMode() == 2) {
                    audioManager.adjustStreamVolume(2, -100, 0);
                    return;
                }
                return;
            }
            if (SpenComposerUtil.isWifiOnlyModel(context)) {
                AudioFocus audioFocus2 = INSTANCE;
                if (!audioFocus2.isZenModeEnable(audioManager, audioFocus2.getRingerModeInternal(audioManager))) {
                    audioManager.adjustStreamVolume(5, 100, 0);
                }
            }
            audioManager.adjustStreamVolume(1, 100, 0);
            if (audioManager.getRingerMode() == 2) {
                audioManager.adjustStreamVolume(2, 100, 0);
            }
        }
    }

    @JvmStatic
    private static final void endListenPhoneState() {
        Context context = mContext;
        if (context != null) {
            try {
                synchronized (mPhoneStateLock) {
                    try {
                        if (mPhoneListener != null) {
                            Object systemService = context.getSystemService("phone");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                            ((TelephonyManager) systemService).listen(mPhoneListener, 0);
                            mPhoneListener = null;
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            } catch (Exception e) {
                Log.e("eLPS] Exception", " " + e);
            }
        }
    }

    private final int getRingerModeInternal(AudioManager audioManager) {
        try {
            Object objInvoke = AudioManager.class.getDeclaredMethod("getRingerModeInternal", null).invoke(audioManager, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return -1;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    private final int getSystemSoundVolume(int systemSoundType, int prevVolume) {
        Context context = mContext;
        if (context != null) {
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            int streamVolume = ((AudioManager) systemService).getStreamVolume(systemSoundType);
            if (streamVolume > 0 && streamVolume != prevVolume) {
                return streamVolume;
            }
        }
        return prevVolume;
    }

    @JvmStatic
    public static final boolean isAudioDisabled() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        AudioFocus audioFocus = INSTANCE;
        return audioFocus.isRestrictedByPolicy(context, RESTRICTION2_URI, RESTRICTIONPOLICY_MICROPHONEASUSER_METHOD) | audioFocus.isRestrictedByPolicy(context, RESTRICTION1_URI, RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD);
    }

    @JvmStatic
    private static final boolean isBluetoothSCOAvaiable() {
        SpenAudioDeviceReceiver spenAudioDeviceReceiver;
        return mIsRecordingViaBluetoothEnabled && (spenAudioDeviceReceiver = mAudioDeviceReceiver) != null && spenAudioDeviceReceiver.getMIsSCODeviceConnected();
    }

    @JvmStatic
    private static final boolean isBluetoothSCOReadyForStart() {
        if (!mIsRecordingViaBluetoothEnabled) {
            Log.d(TAG, "isBluetoothSCOReadyForStart() disable recording via bluetooth");
            return false;
        }
        boolean zIsBluetoothSCOAvaiable = isBluetoothSCOAvaiable();
        AbstractC6670b.m4759t("isBluetoothSCOReadyForStart() isBluetoothSCOAvaiable: ", TAG, zIsBluetoothSCOAvaiable);
        BluetoothHeadset bluetoothHeadset = mBluetoothHeadset;
        if (bluetoothHeadset == null || !zIsBluetoothSCOAvaiable) {
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        Intrinsics.checkNotNullExpressionValue(connectedDevices, "getConnectedDevices(...)");
        int size = connectedDevices.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            BluetoothDevice bluetoothDevice = connectedDevices.get(i);
            if (bluetoothDevice != null) {
                if (bluetoothHeadset.isAudioConnected(bluetoothDevice)) {
                    break;
                }
                if (i == connectedDevices.size() - 1) {
                    mBluetoothDevice = bluetoothDevice;
                    z = true;
                }
            }
        }
        return z;
    }

    @JvmStatic
    public static final boolean isCalling() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        int mode = ((AudioManager) systemService).getMode();
        if (mode == 0) {
            return false;
        }
        AbstractC0541b.m755A(mode, "isCalling] AudioMode: ", TAG);
        return true;
    }

    @SuppressLint({"Range"})
    private final boolean isRestrictedByPolicy(Context context, String uriString, String policyString) {
        Log.d(TAG, "isRestrictedByPolicy] uri string: " + uriString + ", policyString :" + policyString);
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(uriString), null, policyString, new String[]{"true"}, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(policyString));
                    Log.d(TAG, "uri string: " + uriString + ", policyString :" + policyString + SQLKeyword.COMMA + string);
                    if (Intrinsics.areEqual(string, "false")) {
                        return true;
                    }
                    cursorQuery.close();
                } finally {
                    cursorQuery.close();
                }
            }
            return false;
        } catch (SecurityException unused) {
            Log.e(TAG, "isRestrictedByPolicy] Security Exception");
            return false;
        } catch (Exception unused2) {
            Log.e(TAG, "isRestrictedByPolicy] Exception");
            return false;
        }
    }

    @JvmStatic
    public static final boolean isRinging() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) systemService).getMode() != 1) {
            return false;
        }
        Log.d(TAG, "isRinging");
        return true;
    }

    private final boolean isSystemSoundDisabled(AudioManager audioManager) {
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(1);
            int streamVolume2 = audioManager.getStreamVolume(5);
            if (streamVolume == 0 && streamVolume2 == 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean isZenModeEnable(AudioManager audioManager, int ringerModeInternal) {
        if (audioManager.getRingerMode() != 0 || ringerModeInternal == 0) {
            return audioManager.getRingerMode() != 0 && ringerModeInternal == 0;
        }
        return true;
    }

    @JvmStatic
    private static final boolean requestAudioFocus() {
        Context context = mContext;
        if (context != null) {
            AbstractC0541b.m755A(context.hashCode(), "requestAudioFocus] context: ", TAG);
            AudioManager audioManager = mAudioManager;
            if (audioManager != null) {
                Log.d(TAG, "requestAudioFocus] additional release audiofocus");
                audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
                mAudioManager = null;
                SystemClock.sleep(100L);
            }
            AudioManager audioManager2 = (AudioManager) context.getSystemService("audio");
            mAudioManager = audioManager2;
            if (audioManager2 != null && audioManager2.requestAudioFocus(mOnAudioFocusChangeListener, 3, 1) == 1) {
                Log.d(TAG, "requestAudioFocus: Granted");
                return true;
            }
        }
        Log.d(TAG, "requestAudioFocus: Failed");
        return false;
    }

    @JvmStatic
    public static final void setContext(@Nullable Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
            if (BluetoothAdapter.getDefaultAdapter() != null) {
                BluetoothAdapter.getDefaultAdapter().getProfileProxy(mContext, mProfileListener, 1);
            }
            SpenAudioDeviceCallbackListener spenAudioDeviceCallbackListener = mAudioDeviceCallbackListener;
            Context context2 = mContext;
            Intrinsics.checkNotNull(context2);
            mAudioDeviceReceiver = new SpenAudioDeviceReceiver(spenAudioDeviceCallbackListener, context2);
            return;
        }
        mContext = null;
        if (BluetoothAdapter.getDefaultAdapter() != null && mProfileListener != null) {
            BluetoothAdapter.getDefaultAdapter().closeProfileProxy(1, mBluetoothHeadset);
        }
        SpenAudioDeviceReceiver spenAudioDeviceReceiver = mAudioDeviceReceiver;
        if (spenAudioDeviceReceiver != null) {
            spenAudioDeviceReceiver.close();
        }
        mAudioDeviceReceiver = null;
    }

    @JvmStatic
    private static final boolean setRecordingViaBluetooth(boolean enable) {
        BluetoothHeadset bluetoothHeadset;
        if (!mIsRecordingViaBluetoothEnabled) {
            return false;
        }
        AbstractC6670b.m4759t("setRecordingViaBluetooth() enable: ", TAG, enable);
        if (mContext == null || mBluetoothDevice == null || (bluetoothHeadset = mBluetoothHeadset) == null) {
            return false;
        }
        if (enable) {
            SpenNoteVoiceManager.INSTANCE.registerBluetoothScoReceiver();
            Log.d(TAG, "setRecordingViaBluetooth() bluetooth start");
            return bluetoothHeadset.startVoiceRecognition(mBluetoothDevice);
        }
        Log.d(TAG, "setRecordingViaBluetooth() bluetooth stop");
        boolean zStopVoiceRecognition = bluetoothHeadset.stopVoiceRecognition(mBluetoothDevice);
        mBluetoothDevice = null;
        SpenNoteVoiceManager.INSTANCE.unregisterScoBluetoothReceiver();
        return zStopVoiceRecognition;
    }

    @JvmStatic
    private static final void startListenPhoneState() {
        Context context = mContext;
        if (context != null) {
            try {
                synchronized (mPhoneStateLock) {
                    try {
                        if (mPhoneListener == null) {
                            Object systemService = context.getSystemService("phone");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                            AudioPhoneStateListener audioPhoneStateListener = new AudioPhoneStateListener();
                            mPhoneListener = audioPhoneStateListener;
                            ((TelephonyManager) systemService).listen(audioPhoneStateListener, 32);
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            } catch (Exception e) {
                Log.e("sLPS] Exception", " " + e);
            }
        }
    }

    public final boolean isRecordingViaBluetoothEnabled() {
        return mIsRecordingViaBluetoothEnabled;
    }

    public final void setSystemSoundVolume(@Nullable AudioManager audioManager, int systemSoundType, int volume, int checkVolume) {
        int streamVolume;
        if (audioManager == null || (streamVolume = audioManager.getStreamVolume(systemSoundType)) == volume) {
            return;
        }
        if (streamVolume < 0 || streamVolume == checkVolume) {
            audioManager.setStreamVolume(systemSoundType, volume, 0);
        }
    }
}
