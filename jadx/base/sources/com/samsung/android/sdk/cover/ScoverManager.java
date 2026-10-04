package com.samsung.android.sdk.cover;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.cover.CoverState;
import com.samsung.android.cover.ICoverManager;
import com.samsung.android.cover.ICoverManagerCallback;
import com.samsung.android.cover.ICoverStateListenerCallback;
import com.samsung.android.cover.INfcLedCoverTouchListenerCallback;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ScoverManager {
    public static final int COVER_MODE_HIDE_SVIEW_ONCE = 2;
    public static final int COVER_MODE_NONE = 0;
    public static final int COVER_MODE_SVIEW = 1;
    private static final String FEATURE_COVER_CLEAR = "com.sec.feature.cover.clearcover";
    private static final String FEATURE_COVER_CLEAR_CAMERA_VIEW = "com.sec.feature.cover.clearcameraviewcover";
    private static final String FEATURE_COVER_CLEAR_SIDE_VIEW = "com.sec.feature.cover.clearsideviewcover";
    private static final String FEATURE_COVER_FLIP = "com.sec.feature.cover.flip";
    private static final String FEATURE_COVER_LED_BACK = "com.sec.feature.cover.ledbackcover";
    private static final String FEATURE_COVER_MINI_SVIEW_WALLET = "com.sec.feature.cover.minisviewwalletcover";
    private static final String FEATURE_COVER_NEON = "com.sec.feature.cover.neoncover";
    private static final String FEATURE_COVER_NFCLED = "com.sec.feature.cover.nfcledcover";
    private static final String FEATURE_COVER_SVIEW = "com.sec.feature.cover.sview";
    static final int SDK_VERSION = 16842752;
    private static final String TAG = "ScoverManager";
    private static boolean sIsClearCameraViewCoverSystemFeatureEnabled = false;
    private static boolean sIsClearCoverSystemFeatureEnabled = false;
    private static boolean sIsClearSideViewCoverSystemFeatureEnabled = false;
    private static boolean sIsFilpCoverSystemFeatureEnabled = false;
    private static boolean sIsLEDBackCoverSystemFeatureEnabled = false;
    private static boolean sIsMiniSviewWalletCoverSysltemFeatureEnabled = false;
    private static boolean sIsNeonCoverSystemFeatureEnabled = false;
    private static boolean sIsNfcLedCoverSystemFeatureEnabled = false;
    private static boolean sIsSViewCoverSystemFeatureEnabled = false;
    private static boolean sIsSystemFeatureQueried = false;
    private static int sServiceVersion = 16777216;
    private Context mContext;
    private ICoverManager mService;
    private final CopyOnWriteArrayList<CoverListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<CoverStateListenerDelegate> mCoverStateListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<NfcLedCoverTouchListenerDelegate> mNfcLedCoverTouchListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<LedSystemEventListenerDelegate> mLedSystemEventListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<CoverPowerKeyListenerDelegate> mCoverPowerKeyListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<LegacyLedSystemEventListenerDelegate> mLegacyLedSystemEventListenerDelegates = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<CoverListenerDelegate> mLcdOffDisableDelegates = new CopyOnWriteArrayList<>();
    private IBinder mToken = new Binder();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoverPowerKeyListener {
        private static final int EVENT_TYPE_POWER_KEY = 10;

        public void onPowerKeyPress() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoverStateListener {
        public void onCoverAttachStateChanged(boolean z) {
        }

        public void onCoverSwitchStateChanged(boolean z) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LedSystemEventListener {
        private static final int EVENT_TYPE_SYSTEM = 4;

        public void onSystemCoverEvent(int i, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NfcLedCoverTouchListener {
        public static final int EVENT_TYPE_ALARM = 1;
        public static final int EVENT_TYPE_BIXBY = 9;
        public static final int EVENT_TYPE_CALL = 0;
        public static final int EVENT_TYPE_FACTORY = 5;
        public static final int EVENT_TYPE_REMINDER = 6;
        public static final int EVENT_TYPE_SCHEDULE = 3;
        public static final int EVENT_TYPE_TIMER = 2;
        public static final int EVENT_TYPE_VOICE_RECORDER = 7;
        public static final int EVENT_TYPE_VOLUME_CONTROLLER = 8;

        public void onCoverTapLeft() {
        }

        public void onCoverTapMid() {
        }

        public void onCoverTapRight() {
        }

        public void onCoverTouchAccept() {
        }

        public void onCoverTouchReject() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface ScoverStateListener {
        void onCoverStateChanged(ScoverState scoverState);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StateListener {
        public void onCoverStateChanged(ScoverState scoverState) {
        }
    }

    public ScoverManager(Context context) {
        this.mContext = context;
        initSystemFeature();
    }

    private synchronized ICoverManager getService() {
        try {
            if (this.mService == null) {
                ICoverManager iCoverManagerAsInterface = ICoverManager.Stub.asInterface(ServiceManager.getService(Constants.MAIN_THUMBNAIL_FILE_NAME_COVER));
                this.mService = iCoverManagerAsInterface;
                if (iCoverManagerAsInterface == null) {
                    Slog.w(TAG, "warning: no COVER_MANAGER_SERVICE");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mService;
    }

    private void initSystemFeature() {
        if (sIsSystemFeatureQueried) {
            return;
        }
        sIsFilpCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_FLIP);
        sIsSViewCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_SVIEW);
        sIsNfcLedCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_NFCLED);
        sIsClearCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_CLEAR);
        sIsNeonCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_NEON);
        sIsClearSideViewCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_CLEAR_SIDE_VIEW);
        sIsLEDBackCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_LED_BACK);
        sIsMiniSviewWalletCoverSysltemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_MINI_SVIEW_WALLET);
        sIsClearCameraViewCoverSystemFeatureEnabled = this.mContext.getPackageManager().hasSystemFeature(FEATURE_COVER_CLEAR_CAMERA_VIEW);
        sIsSystemFeatureQueried = true;
        sServiceVersion = getCoverManagerVersion();
    }

    public static boolean isSupportableVersion(int i) {
        int i2 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = i & 65535;
        int i6 = sServiceVersion;
        return ((i6 >> 24) & 255) >= i2 && ((i6 >> 16) & 255) >= i4 && (65535 & i6) >= i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.LegacyLedSystemEventListenerDelegate, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.samsung.android.sdk.cover.LegacyLedSystemEventListenerDelegate] */
    private void registerLegacyLedSystemListener(LedSystemEventListener ledSystemEventListener) {
        LegacyLedSystemEventListenerDelegate legacyLedSystemEventListenerDelegate;
        if (ledSystemEventListener == null) {
            Log.w(TAG, "registerLegacyLedSystemListener : listener is null");
            return;
        }
        Iterator<LegacyLedSystemEventListenerDelegate> it = this.mLegacyLedSystemEventListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                legacyLedSystemEventListenerDelegate = 0;
                break;
            } else {
                legacyLedSystemEventListenerDelegate = it.next();
                if (legacyLedSystemEventListenerDelegate.getListener().equals(ledSystemEventListener)) {
                    break;
                }
            }
        }
        if (legacyLedSystemEventListenerDelegate == 0) {
            legacyLedSystemEventListenerDelegate = new LegacyLedSystemEventListenerDelegate(ledSystemEventListener, null, this.mContext);
            this.mLegacyLedSystemEventListenerDelegates.add((LegacyLedSystemEventListenerDelegate) legacyLedSystemEventListenerDelegate);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerNfcTouchListenerCallback(4, (IBinder) legacyLedSystemEventListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerLegacyLedSystemListener: ", e);
        }
    }

    private static boolean supportNewLedSystemEventListener() {
        return isSupportableVersion(R.dimen.app_icon_size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.LegacyLedSystemEventListenerDelegate] */
    private void unregisterLegacyLedSystemEventListener(LedSystemEventListener ledSystemEventListener) {
        LegacyLedSystemEventListenerDelegate next;
        Log.d(TAG, "unregisterLegacyLedSystemEventListener");
        if (ledSystemEventListener == null) {
            Log.w(TAG, "unregisterLegacyLedSystemEventListener : listener is null");
            return;
        }
        Iterator<LegacyLedSystemEventListenerDelegate> it = this.mLegacyLedSystemEventListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(ledSystemEventListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterNfcTouchListenerCallback((IBinder) next)) {
                return;
            }
            this.mLegacyLedSystemEventListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterLegacyLedSystemEventListener: ", e);
        }
    }

    public void addLedNotification(Bundle bundle) throws SsdkUnsupportedException {
        if (!isSupportCover()) {
            Log.w(TAG, "addLedNotification : This device does not support cover");
            return;
        }
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "addLedNotification : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.string.cancel)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.4.0", 2);
        }
        if (bundle == null) {
            Log.e(TAG, "addLedNotification : Null notification data!");
            return;
        }
        ICoverManager service = getService();
        if (service != null) {
            try {
                service.addLedNotification(bundle);
            } catch (RemoteException e) {
                Log.e(TAG, "addLedNotification in sendData to NFC : ", e);
            }
        }
    }

    public boolean checkValidPacakge(String str) {
        if (!isSupportCover()) {
            Log.w(TAG, "checkValidPacakge : This device is not supported cover");
            return false;
        }
        if (str == null) {
            Log.w(TAG, "checkValidPacakge : pkg is null");
            return false;
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                CoverState coverState = service.getCoverState();
                if (coverState == null || !coverState.attached) {
                    Log.e(TAG, "checkValidPacakge : coverState is null or cover is detached");
                } else {
                    String smartCoverAppUri = coverState.getSmartCoverAppUri();
                    if (!TextUtils.isEmpty(smartCoverAppUri) && str.equals(smartCoverAppUri.substring(1, smartCoverAppUri.length()))) {
                        return true;
                    }
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in checkCoverAppUri: ", e);
        }
        return false;
    }

    public void disableCoverManager(boolean z) {
        if (!isSupportCover()) {
            Log.w(TAG, "disableCoverManager : This device is not supported cover");
            return;
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.disableCoverManager(z, this.mToken, this.mContext.getPackageName());
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in disalbeCoverManager : ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.samsung.android.sdk.cover.CoverListenerDelegate] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.samsung.android.sdk.cover.CoverListenerDelegate] */
    public boolean disableLcdOffByCover(StateListener stateListener) throws SsdkUnsupportedException {
        CoverListenerDelegate coverListenerDelegate;
        if (!isSupportCover()) {
            Log.w(TAG, "disableLcdOffByCover : This device does not support cover");
            return false;
        }
        if (!isSupportableVersion(R.dimen.app_icon_size)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.5.0", 2);
        }
        if (stateListener == null) {
            Log.w(TAG, "disableLcdOffByCover : listener cannot be null");
            return false;
        }
        Log.d(TAG, "disableLcdOffByCover");
        Iterator<CoverListenerDelegate> it = this.mLcdOffDisableDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                coverListenerDelegate = 0;
                break;
            }
            coverListenerDelegate = it.next();
            if (coverListenerDelegate.getListener().equals(stateListener)) {
                break;
            }
        }
        if (coverListenerDelegate == 0) {
            coverListenerDelegate = new CoverListenerDelegate(stateListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null && service.disableLcdOffByCover((IBinder) coverListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()))) {
                this.mLcdOffDisableDelegates.add((CoverListenerDelegate) coverListenerDelegate);
                return true;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in disableLcdOffByCover: ", e);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.samsung.android.sdk.cover.CoverListenerDelegate] */
    public boolean enableLcdOffByCover(StateListener stateListener) throws SsdkUnsupportedException {
        CoverListenerDelegate next;
        if (!isSupportCover()) {
            Log.w(TAG, "enableLcdOffByCover : This device does not support cover");
            return false;
        }
        if (!isSupportableVersion(R.dimen.app_icon_size)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.5.0", 2);
        }
        if (stateListener == null) {
            Log.w(TAG, "enableLcdOffByCover : listener cannot be null");
            return false;
        }
        Log.d(TAG, "enableLcdOffByCover");
        Iterator<CoverListenerDelegate> it = this.mLcdOffDisableDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            }
            next = it.next();
            if (next.getListener().equals(stateListener)) {
                break;
            }
        }
        if (next == 0) {
            Log.e(TAG, "enableLcdOffByCover: Matching listener not found, cannot enable");
            return false;
        }
        try {
            ICoverManager service = getService();
            if (service != null && service.enableLcdOffByCover((IBinder) next, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()))) {
                this.mLcdOffDisableDelegates.remove((Object) next);
                return true;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterNfcTouchListener: ", e);
        }
        return false;
    }

    public int getCoverManagerVersion() {
        int iIntValue;
        if (isSupportCover()) {
            try {
                iIntValue = ((Integer) ICoverManager.class.getMethod("getVersion", null).invoke(getService(), null)).intValue();
            } catch (Exception e) {
                Log.w(TAG, "getVersion failed : " + e);
                iIntValue = 16777216;
            }
        } else {
            iIntValue = 16777216;
        }
        AbstractC0541b.m755A(iIntValue, "serviceVersion : ", TAG);
        return iIntValue;
    }

    public ScoverState getCoverState() {
        if (!isSupportCover()) {
            Log.w(TAG, "getCoverState : This device is not supported cover");
            return null;
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                CoverState coverState = service.getCoverState();
                if (coverState != null) {
                    if (coverState.type == 255 && !coverState.switchState) {
                        Log.e(TAG, "getCoverState : type of cover is nfc smart cover and cover is closed");
                        return null;
                    }
                    ScoverState scoverState = isSupportableVersion(R.animator.fade_in) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached, coverState.model, coverState.fakeCover, coverState.fotaMode) : isSupportableVersion(R.array.emailAddressTypes) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached, coverState.model, coverState.fakeCover) : isSupportableVersion(R.id.background) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached, coverState.model) : isSupportableVersion(16842752) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached) : new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel);
                    if (isSupportableVersion(R.interpolator.accelerate_quad)) {
                        scoverState.setVisibleRect(coverState.getVisibleRect());
                    }
                    return scoverState;
                }
                Log.e(TAG, "getCoverState : coverState is null");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getCoverState: ", e);
        }
        return null;
    }

    public String getServiceVersionName() {
        int i = sServiceVersion;
        return String.format("%d.%d.%d", Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf(i & 65535));
    }

    public boolean isCoverManagerDisabled() {
        if (!isSupportCover()) {
            Log.w(TAG, "isCoverManagerDisabled : This device is not supported cover");
            return false;
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                return service.isCoverManagerDisabled();
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in isCoverManagerDisabled : ", e);
            return false;
        }
    }

    public boolean isSmartCover() {
        ScoverState coverState = getCoverState();
        return coverState != null && coverState.type == 255;
    }

    public boolean isSupportClearCameraViewCover() {
        return sIsClearCameraViewCoverSystemFeatureEnabled;
    }

    public boolean isSupportClearCover() {
        return sIsClearCoverSystemFeatureEnabled;
    }

    public boolean isSupportClearSideViewCover() {
        return sIsClearSideViewCoverSystemFeatureEnabled;
    }

    public boolean isSupportCover() {
        return sIsFilpCoverSystemFeatureEnabled || sIsSViewCoverSystemFeatureEnabled || sIsClearCoverSystemFeatureEnabled || sIsNeonCoverSystemFeatureEnabled || sIsClearSideViewCoverSystemFeatureEnabled || sIsNfcLedCoverSystemFeatureEnabled || sIsLEDBackCoverSystemFeatureEnabled || sIsMiniSviewWalletCoverSysltemFeatureEnabled || sIsClearCameraViewCoverSystemFeatureEnabled;
    }

    public boolean isSupportFlipCover() {
        return sIsFilpCoverSystemFeatureEnabled;
    }

    public boolean isSupportLEDBackCover() {
        return sIsLEDBackCoverSystemFeatureEnabled;
    }

    public boolean isSupportNeonCover() {
        return sIsNeonCoverSystemFeatureEnabled;
    }

    public boolean isSupportNfcLedCover() {
        return sIsNfcLedCoverSystemFeatureEnabled;
    }

    public boolean isSupportSViewCover() {
        return sIsSViewCoverSystemFeatureEnabled;
    }

    public boolean isSupportTypeOfCover(int i) {
        if (i == 0) {
            return sIsFilpCoverSystemFeatureEnabled;
        }
        if (i == 1 || i == 3) {
            return sIsSViewCoverSystemFeatureEnabled;
        }
        if (i == 11) {
            return sIsNeonCoverSystemFeatureEnabled;
        }
        if (i == 17) {
            return sIsClearCameraViewCoverSystemFeatureEnabled;
        }
        if (i == 7) {
            return sIsNfcLedCoverSystemFeatureEnabled;
        }
        if (i == 8) {
            return sIsClearCoverSystemFeatureEnabled;
        }
        if (i == 14) {
            return sIsLEDBackCoverSystemFeatureEnabled;
        }
        if (i != 15) {
            return false;
        }
        return sIsClearSideViewCoverSystemFeatureEnabled;
    }

    public void registerCoverPowerKeyListener(CoverPowerKeyListener coverPowerKeyListener) throws SsdkUnsupportedException {
        boolean z;
        INfcLedCoverTouchListenerCallback.Stub coverPowerKeyListenerDelegate;
        if (!isSupportCover()) {
            Log.w(TAG, "registerCoverPowerKeyListener : This device does not support cover");
            return;
        }
        Log.d(TAG, "registerCoverPowerKeyListener");
        if (!isSupportFlipCover() && !isSupportNeonCover()) {
            Log.w(TAG, "registerLedSystemListener : This device does not support Flip cover or Neon Cover");
            return;
        }
        if (!isSupportableVersion(R.anim.fade_in)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.10.0 for Flip Cover and Neon cover", 2);
        }
        if (coverPowerKeyListener == null) {
            Log.w(TAG, "registerCoverPowerKeyListener : listener is null");
            return;
        }
        Iterator<CoverPowerKeyListenerDelegate> it = this.mCoverPowerKeyListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                coverPowerKeyListenerDelegate = null;
                break;
            } else {
                CoverPowerKeyListenerDelegate next = it.next();
                if (next.getListener().equals(coverPowerKeyListener)) {
                    z = true;
                    coverPowerKeyListenerDelegate = next;
                    break;
                }
            }
        }
        if (coverPowerKeyListenerDelegate == null) {
            coverPowerKeyListenerDelegate = new CoverPowerKeyListenerDelegate(coverPowerKeyListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerNfcTouchListenerCallback(10, coverPowerKeyListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
                if (z) {
                    return;
                }
                this.mCoverPowerKeyListenerDelegates.add((CoverPowerKeyListenerDelegate) coverPowerKeyListenerDelegate);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerCoverPowerKeyListener: ", e);
        }
    }

    public void registerLedSystemListener(LedSystemEventListener ledSystemEventListener) throws SsdkUnsupportedException {
        boolean z;
        INfcLedCoverTouchListenerCallback.Stub ledSystemEventListenerDelegate;
        if (!isSupportCover()) {
            Log.w(TAG, "registerLedSystemListener : This device does not support cover");
            return;
        }
        Log.d(TAG, "registerLedSystemListener");
        if (!isSupportNfcLedCover() && !isSupportNeonCover()) {
            Log.w(TAG, "registerLedSystemListener : This device does not support NFC Led cover or Neon Cover");
            return;
        }
        if ((!isSupportNfcLedCover() || !isSupportableVersion(R.style.Animation)) && (!isSupportNeonCover() || !isSupportableVersion(R.drawable.alert_dark_frame))) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.3.0 for NFC LED Cover and v1.8.0 for Neon cover", 2);
        }
        if (ledSystemEventListener == null) {
            Log.w(TAG, "registerLedSystemListener : listener is null");
            return;
        }
        if (!supportNewLedSystemEventListener()) {
            registerLegacyLedSystemListener(ledSystemEventListener);
            return;
        }
        Iterator<LedSystemEventListenerDelegate> it = this.mLedSystemEventListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                ledSystemEventListenerDelegate = null;
                break;
            } else {
                LedSystemEventListenerDelegate next = it.next();
                if (next.getListener().equals(ledSystemEventListener)) {
                    z = true;
                    ledSystemEventListenerDelegate = next;
                    break;
                }
            }
        }
        if (ledSystemEventListenerDelegate == null) {
            ledSystemEventListenerDelegate = new LedSystemEventListenerDelegate(ledSystemEventListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerNfcTouchListenerCallback(4, ledSystemEventListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
                if (z) {
                    return;
                }
                this.mLedSystemEventListenerDelegates.add((LedSystemEventListenerDelegate) ledSystemEventListenerDelegate);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerLedSystemListener: ", e);
        }
    }

    @Deprecated
    public void registerListener(ScoverStateListener scoverStateListener) {
        Log.d(TAG, "registerListener : Use deprecated API!! Change ScoverStateListener to StateListener");
    }

    public void registerNfcTouchListener(int i, NfcLedCoverTouchListener nfcLedCoverTouchListener) throws SsdkUnsupportedException {
        boolean z;
        INfcLedCoverTouchListenerCallback.Stub nfcLedCoverTouchListenerDelegate;
        if (!isSupportCover()) {
            Log.w(TAG, "registerNfcTouchListener : This device does not support cover");
            return;
        }
        Log.d(TAG, "registerNfcTouchListener");
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "registerNfcTouchListener : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.style.Animation)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.3.0", 2);
        }
        if (nfcLedCoverTouchListener == null) {
            Log.w(TAG, "registerNfcTouchListener : listener is null");
            return;
        }
        Iterator<NfcLedCoverTouchListenerDelegate> it = this.mNfcLedCoverTouchListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                nfcLedCoverTouchListenerDelegate = null;
                break;
            } else {
                NfcLedCoverTouchListenerDelegate next = it.next();
                if (next.getListener().equals(nfcLedCoverTouchListener)) {
                    z = true;
                    nfcLedCoverTouchListenerDelegate = next;
                    break;
                }
            }
        }
        if (nfcLedCoverTouchListenerDelegate == null) {
            nfcLedCoverTouchListenerDelegate = new NfcLedCoverTouchListenerDelegate(nfcLedCoverTouchListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerNfcTouchListenerCallback(i, nfcLedCoverTouchListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
                if (z) {
                    return;
                }
                this.mNfcLedCoverTouchListenerDelegates.add((NfcLedCoverTouchListenerDelegate) nfcLedCoverTouchListenerDelegate);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerNfcTouchListener: ", e);
        }
    }

    public void removeLedNotification(Bundle bundle) throws SsdkUnsupportedException {
        if (!isSupportCover()) {
            Log.w(TAG, "removeLedNotification : This device does not support cover");
            return;
        }
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "removeLedNotification : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.string.cancel)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.4.0", 2);
        }
        if (bundle == null) {
            Log.e(TAG, "removeLedNotification : Null notification data!");
            return;
        }
        ICoverManager service = getService();
        if (service != null) {
            try {
                service.removeLedNotification(bundle);
            } catch (RemoteException e) {
                Log.e(TAG, "removeLedNotification in sendData to NFC : ", e);
            }
        }
    }

    public void sendDataToCover(int i, byte[] bArr) throws SsdkUnsupportedException {
        if (!isSupportCover()) {
            Log.w(TAG, "sendDataToCover : This device is not supported cover");
            return;
        }
        if (isSmartCover()) {
            Log.w(TAG, "sendDataToCover : If cover is smart cover, it does not need to send the data to cover");
            return;
        }
        if (!isSupportableVersion(R.id.background)) {
            throw new SsdkUnsupportedException("This device is not supported this function. Device is must higher then v1.2.0", 2);
        }
        ICoverManager service = getService();
        if (service != null) {
            try {
                service.sendDataToCover(i, bArr);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in sendData : ", e);
            }
        }
    }

    public void sendDataToNfcLedCover(int i, byte[] bArr) throws SsdkUnsupportedException {
        if (!isSupportCover()) {
            Log.w(TAG, "sendDataToNfcLedCover : This device does not support cover");
            return;
        }
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "sendDataToNfcLedCover : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.style.Animation)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.3.0", 2);
        }
        ICoverManager service = getService();
        if (service != null) {
            try {
                service.sendDataToNfcLedCover(i, bArr);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in sendData to NFC : ", e);
            }
        }
    }

    public void sendSystemEvent(Bundle bundle) throws SsdkUnsupportedException {
        if (!isSupportCover()) {
            Log.w(TAG, "sendSystemEvent : This device does not support cover");
            return;
        }
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "sendSystemEvent : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.color.darker_gray)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.6.0", 2);
        }
        if (bundle == null) {
            Log.e(TAG, "sendSystemEvent : Null system event data!");
            return;
        }
        ICoverManager service = getService();
        if (service != null) {
            try {
                service.sendSystemEvent(bundle);
            } catch (RemoteException e) {
                Log.e(TAG, "sendSystemEvent in sendData to NFC : ", e);
            }
        }
    }

    public WindowManager.LayoutParams setCoverMode(WindowManager.LayoutParams layoutParams, int i) {
        if (!isSupportSViewCover()) {
            Log.w(TAG, "setSViewCoverModeToWindow : This device is not supported s view cover");
            return layoutParams;
        }
        if (layoutParams != null) {
            AbstractC0541b.m755A(i, "setCoverMode : ", TAG);
            layoutParams.coverMode = i;
        }
        return layoutParams;
    }

    public void setCoverModeToWindow(Window window, int i) {
        if (!isSupportSViewCover()) {
            Log.w(TAG, "setSViewCoverModeToWindow : This device is not supported s view cover");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.coverMode = i;
            window.setAttributes(attributes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.CoverPowerKeyListenerDelegate] */
    public void unregisterCoverPowerKeyListener(CoverPowerKeyListener coverPowerKeyListener) throws SsdkUnsupportedException {
        CoverPowerKeyListenerDelegate next;
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterCoverPowerKeyListener : This device does not support cover");
            return;
        }
        Log.d(TAG, "unregisterCoverPowerKeyListener");
        if (!isSupportFlipCover() && !isSupportNeonCover()) {
            Log.w(TAG, "unregisterCoverPowerKeyListener : This device does not support Flip cover or Neon Cover");
            return;
        }
        if (!isSupportableVersion(R.anim.fade_in)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.1.0 for Flip Cover Neon cover", 2);
        }
        if (coverPowerKeyListener == null) {
            Log.w(TAG, "unregisterCoverPowerKeyListener : listener is null");
            return;
        }
        Iterator<CoverPowerKeyListenerDelegate> it = this.mCoverPowerKeyListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(coverPowerKeyListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterNfcTouchListenerCallback((IBinder) next)) {
                return;
            }
            this.mCoverPowerKeyListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterCoverPowerKeyListener: ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.samsung.android.sdk.cover.LedSystemEventListenerDelegate] */
    public void unregisterLedSystemEventListener(LedSystemEventListener ledSystemEventListener) throws SsdkUnsupportedException {
        LedSystemEventListenerDelegate next;
        Log.d(TAG, "unregisterLedSystemEventListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterLedSystemEventListener : This device does not support cover");
            return;
        }
        Log.d(TAG, "unregisterLedSystemEventListener");
        if (!isSupportNfcLedCover() && !isSupportNeonCover()) {
            Log.w(TAG, "unregisterLedSystemEventListener : This device does not support NFC Led cover or Neon Cover");
            return;
        }
        if ((!isSupportNfcLedCover() || !isSupportableVersion(R.style.Animation)) && (!isSupportNeonCover() || !isSupportableVersion(R.drawable.alert_dark_frame))) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.3.0 for NFC LED Cover and v1.8.0 for Neon cover", 2);
        }
        if (ledSystemEventListener == null) {
            Log.w(TAG, "unregisterLedSystemEventListener : listener is null");
            return;
        }
        if (!supportNewLedSystemEventListener()) {
            unregisterLegacyLedSystemEventListener(ledSystemEventListener);
            return;
        }
        Iterator<LedSystemEventListenerDelegate> it = this.mLedSystemEventListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(ledSystemEventListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterNfcTouchListenerCallback((IBinder) next)) {
                return;
            }
            this.mLedSystemEventListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterLedSystemEventListener: ", e);
        }
    }

    @Deprecated
    public void unregisterListener(ScoverStateListener scoverStateListener) {
        Log.d(TAG, "unregisterListener : Use deprecated API!! Change ScoverStateListener to StateListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.NfcLedCoverTouchListenerDelegate] */
    public void unregisterNfcTouchListener(NfcLedCoverTouchListener nfcLedCoverTouchListener) throws SsdkUnsupportedException {
        NfcLedCoverTouchListenerDelegate next;
        Log.d(TAG, "unregisterNfcTouchListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterNfcTouchListener : This device does not support cover");
            return;
        }
        if (!isSupportNfcLedCover()) {
            Log.w(TAG, "unregisterNfcTouchListener : This device does not support NFC Led cover");
            return;
        }
        if (!isSupportableVersion(R.style.Animation)) {
            throw new SsdkUnsupportedException("This device does not support this function. Device is must higher then v1.3.0", 2);
        }
        if (nfcLedCoverTouchListener == null) {
            Log.w(TAG, "unregisterNfcTouchListener : listener is null");
            return;
        }
        Iterator<NfcLedCoverTouchListenerDelegate> it = this.mNfcLedCoverTouchListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(nfcLedCoverTouchListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterNfcTouchListenerCallback((IBinder) next)) {
                return;
            }
            this.mNfcLedCoverTouchListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterNfcTouchListener: ", e);
        }
    }

    public void registerListener(StateListener stateListener) {
        boolean z;
        ICoverManagerCallback.Stub coverListenerDelegate;
        Log.d(TAG, "registerListener");
        if (!isSupportCover()) {
            Log.w(TAG, "registerListener : This device is not supported cover");
            return;
        }
        if (isSmartCover()) {
            Log.w(TAG, "registerListener : If cover is smart cover, it does not need to register listener of intenal App");
            return;
        }
        if (stateListener == null) {
            Log.w(TAG, "registerListener : listener is null");
            return;
        }
        Iterator<CoverListenerDelegate> it = this.mListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                coverListenerDelegate = null;
                break;
            } else {
                CoverListenerDelegate next = it.next();
                if (next.getListener().equals(stateListener)) {
                    z = true;
                    coverListenerDelegate = next;
                    break;
                }
            }
        }
        if (coverListenerDelegate == null) {
            coverListenerDelegate = new CoverListenerDelegate(stateListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerCallback(coverListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()));
                if (z) {
                    return;
                }
                this.mListenerDelegates.add((CoverListenerDelegate) coverListenerDelegate);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerListener: ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.CoverListenerDelegate] */
    public void unregisterListener(StateListener stateListener) {
        CoverListenerDelegate next;
        Log.d(TAG, "unregisterListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterListener : This device is not supported cover");
            return;
        }
        if (isSmartCover()) {
            Log.w(TAG, "unregisterListener : If cover is smart cover, it does not need to unregister listener of intenal App");
            return;
        }
        if (stateListener == null) {
            Log.w(TAG, "unregisterListener : listener is null");
            return;
        }
        Iterator<CoverListenerDelegate> it = this.mListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(stateListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterCallback((IBinder) next)) {
                return;
            }
            this.mListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterListener: ", e);
        }
    }

    public void setCoverModeToWindow(WindowManager.LayoutParams layoutParams, int i) {
        if (!isSupportSViewCover()) {
            Log.w(TAG, "setSViewCoverModeToWindow : This device is not supported s view cover");
        } else if (layoutParams != null) {
            layoutParams.coverMode = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.sdk.cover.CoverStateListenerDelegate] */
    public void unregisterListener(CoverStateListener coverStateListener) throws SsdkUnsupportedException {
        CoverStateListenerDelegate next;
        Log.d(TAG, "unregisterListener");
        if (!isSupportCover()) {
            Log.w(TAG, "unregisterListener : This device is not supported cover");
            return;
        }
        if (isSmartCover()) {
            Log.w(TAG, "unregisterListener : If cover is smart cover, it does not need to unregister listener of intenal App");
            return;
        }
        if (!isSupportableVersion(16842752)) {
            throw new SsdkUnsupportedException("This device is not supported this function. Device is must higher then v1.1.0", 2);
        }
        if (coverStateListener == null) {
            Log.w(TAG, "unregisterListener : listener is null");
            return;
        }
        Iterator<CoverStateListenerDelegate> it = this.mCoverStateListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = 0;
                break;
            } else {
                next = it.next();
                if (next.getListener().equals(coverStateListener)) {
                    break;
                }
            }
        }
        if (next == 0) {
            return;
        }
        try {
            ICoverManager service = getService();
            if (service == null || !service.unregisterCallback((IBinder) next)) {
                return;
            }
            this.mCoverStateListenerDelegates.remove((Object) next);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in unregisterListener: ", e);
        }
    }

    public void registerListener(CoverStateListener coverStateListener) throws SsdkUnsupportedException {
        boolean z;
        ICoverStateListenerCallback.Stub coverStateListenerDelegate;
        Log.d(TAG, "registerListener");
        if (!isSupportCover()) {
            Log.w(TAG, "registerListener : This device is not supported cover");
            return;
        }
        if (isSmartCover()) {
            Log.w(TAG, "registerListener : If cover is smart cover, it does not need to register listener of intenal App");
            return;
        }
        if (!isSupportableVersion(16842752)) {
            throw new SsdkUnsupportedException("This device is not supported this function. Device is must higher then v1.1.0", 2);
        }
        if (coverStateListener == null) {
            Log.w(TAG, "registerListener : listener is null");
            return;
        }
        Iterator<CoverStateListenerDelegate> it = this.mCoverStateListenerDelegates.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                coverStateListenerDelegate = null;
                break;
            } else {
                CoverStateListenerDelegate next = it.next();
                if (next.getListener().equals(coverStateListener)) {
                    z = true;
                    coverStateListenerDelegate = next;
                    break;
                }
            }
        }
        if (coverStateListenerDelegate == null) {
            coverStateListenerDelegate = new CoverStateListenerDelegate(coverStateListener, null, this.mContext);
        }
        try {
            ICoverManager service = getService();
            if (service != null) {
                service.registerListenerCallback(coverStateListenerDelegate, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()), 2);
                if (z) {
                    return;
                }
                this.mCoverStateListenerDelegates.add((CoverStateListenerDelegate) coverStateListenerDelegate);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in registerListener: ", e);
        }
    }
}
