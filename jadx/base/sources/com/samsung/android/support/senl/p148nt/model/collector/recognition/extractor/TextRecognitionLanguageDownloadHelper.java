package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.sdk.handwriting.resources.HwrLanguageManager;
import com.samsung.android.sdk.handwriting.resources.HwrLanguagePack;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextRecognitionLanguageDownloadHelper {
    private static final long DOWNLOAD_TIME_OUT = 120;
    public static final int REQUEST_FAILED = 1;
    private static final String TAG = CollectLogger.createTag("TextRecognitionLanguageDownloadHelper");
    private static final CopyOnWriteArrayList<DownloadRequest> sDownloadRequestList = new CopyOnWriteArrayList<>();
    private static Boolean sIsDefaultLanguageSupported = null;
    private final Context mContext;
    private HwrLanguageManager mLangManager = null;
    private String[] mAvailableLanguages = null;
    private InitFinishedListener mInitFinishedListener = null;
    private DownloadRequest mCurrentDownload = null;
    private int mCurrentDownloadTime = 0;
    private boolean mCloseRequested = false;
    private final Handler mDownloadMonitor = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.1
        private static final String TAG = CollectLogger.createTag("TextRecognitionLanguageDownloadHelper$DownloadMonitor");

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int size = TextRecognitionLanguageDownloadHelper.sDownloadRequestList.size();
            DataLogger.m12302d(TAG, "handleMessage, downloadSize: " + size);
            if (size == 0) {
                removeMessages(0);
                return;
            }
            TextRecognitionLanguageDownloadHelper.this.downloadInternal((DownloadRequest) TextRecognitionLanguageDownloadHelper.sDownloadRequestList.get(0));
            if (TextRecognitionLanguageDownloadHelper.sDownloadRequestList.isEmpty()) {
                removeMessages(0);
                return;
            }
            if (((DownloadRequest) TextRecognitionLanguageDownloadHelper.sDownloadRequestList.get(0)).equals(TextRecognitionLanguageDownloadHelper.this.mCurrentDownload)) {
                TextRecognitionLanguageDownloadHelper.this.mCurrentDownloadTime++;
            } else {
                TextRecognitionLanguageDownloadHelper.this.mCurrentDownloadTime = 0;
            }
            if (TextRecognitionLanguageDownloadHelper.this.mCurrentDownloadTime > TextRecognitionLanguageDownloadHelper.DOWNLOAD_TIME_OUT) {
                TextRecognitionLanguageDownloadHelper.this.mCurrentDownloadTime = 0;
                TextRecognitionLanguageDownloadHelper.this.cancelDownload(((DownloadRequest) TextRecognitionLanguageDownloadHelper.sDownloadRequestList.get(0)).getLocale());
            }
            removeMessages(0);
            sendEmptyMessageDelayed(0, 2000L);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DeleteListener {
        void onComplete(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DownloadListener {
        void onComplete(int i);

        void onProgress(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadRequest {
        private DownloadListener mDownloadListener;
        private String mLocale;

        public DownloadRequest(String str, DownloadListener downloadListener) {
            this.mLocale = str;
            this.mDownloadListener = downloadListener;
        }

        public DownloadListener getDownloadListener() {
            return this.mDownloadListener;
        }

        public String getLocale() {
            return this.mLocale;
        }

        public void setLocale(String str) {
            this.mLocale = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InitFinishedListener {
        void onInitFinished();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LanguageDownloadListener {
        void onComplete(String str, int i);

        void onProgress(String str, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LanguageInfo {
        private final boolean isCancelInProgress;
        private final boolean isDownloadInProgress;
        private final boolean isDownloaded;
        private final boolean isInstallable;
        private final boolean isPreloaded;
        private final boolean isUpdateAvailable;
        private final String locale;

        public LanguageInfo(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.isDownloaded = z;
            this.isUpdateAvailable = z2;
            this.isPreloaded = z3;
            this.isInstallable = z4;
            this.isDownloadInProgress = z5;
            this.isCancelInProgress = z6;
            this.locale = str;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof LanguageInfo) {
                return this.locale.equals(((LanguageInfo) obj).getLocale());
            }
            return false;
        }

        public String getLocale() {
            return this.locale;
        }

        public boolean isCancelInProgress() {
            return this.isCancelInProgress;
        }

        public boolean isDownloadInProgress() {
            return this.isDownloadInProgress;
        }

        public boolean isDownloaded() {
            return this.isDownloaded;
        }

        public boolean isInstallable() {
            return this.isInstallable;
        }

        public boolean isPreloaded() {
            return this.isPreloaded;
        }

        public boolean isUpdateAvailable() {
            return this.isUpdateAvailable;
        }
    }

    public TextRecognitionLanguageDownloadHelper(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadInternal(final DownloadRequest downloadRequest) {
        String str = TAG;
        DataLogger.m12302d(str, "downloadInternal start " + downloadRequest.getLocale());
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(downloadRequest.getLocale());
        if (hwrLanguagePack == null) {
            return;
        }
        if (hwrLanguagePack.isDownloadInProgress()) {
            DataLogger.m12302d(str, "downloadInternal inProgress " + downloadRequest.getLocale());
            return;
        }
        if (hwrLanguagePack.isInstallable() || hwrLanguagePack.isUpdateAvailable()) {
            DataLogger.m12302d(str, "downloadInternal downloadLanguage " + downloadRequest.getLocale());
            this.mCurrentDownload = downloadRequest;
            hwrLanguagePack.downloadLanguage(new HwrLanguagePack.OnDownloadListener() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.3
                @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
                public void onComplete(final int i) {
                    DataLogger.m12302d(TextRecognitionLanguageDownloadHelper.TAG, "downloadInternal onComplete " + downloadRequest.getLocale());
                    TextRecognitionLanguageDownloadHelper.this.mLangManager.update(new HwrLanguageManager.OnUpdateListener() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.3.1
                        @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
                        public void onComplete(int i2) {
                            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = TextRecognitionLanguageDownloadHelper.this;
                            textRecognitionLanguageDownloadHelper.mAvailableLanguages = textRecognitionLanguageDownloadHelper.mLangManager.getAvailableLanguage();
                            if (downloadRequest.getDownloadListener() == null || TextRecognitionLanguageDownloadHelper.this.mCloseRequested) {
                                EventManager.getEventBus().publish(new LanguageDownloadCompleteEvent(downloadRequest.getLocale(), i));
                            } else {
                                downloadRequest.getDownloadListener().onComplete(i);
                            }
                            TextRecognitionLanguageDownloadHelper.this.mCurrentDownload = null;
                            TextRecognitionLanguageDownloadHelper.sDownloadRequestList.remove(downloadRequest);
                            if (downloadRequest.getLocale() != null) {
                                C114233 c114233 = C114233.this;
                                TextRecognitionLanguageDownloadHelper.sIsDefaultLanguageSupported = Boolean.valueOf(TextRecognitionLanguageDownloadHelper.this.isExistOnDevice(downloadRequest.getLocale()));
                            }
                            TextRecognitionLanguageDownloadHelper.this.requestNextDownload();
                        }
                    }, true);
                }

                @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDownloadListener
                public void onProgress(int i, int i2) {
                    if (downloadRequest.getDownloadListener() == null || TextRecognitionLanguageDownloadHelper.this.mCloseRequested) {
                        EventManager.getEventBus().publish(new LanguageDownloadProgressEvent(downloadRequest.getLocale(), i, i2));
                    } else {
                        downloadRequest.getDownloadListener().onProgress(i, i2);
                    }
                }
            });
            return;
        }
        DataLogger.m12302d(str, "downloadInternal error " + downloadRequest.getLocale());
        if (downloadRequest.getDownloadListener() != null && !this.mCloseRequested) {
            downloadRequest.getDownloadListener().onComplete(1);
        }
        this.mCurrentDownload = null;
        sDownloadRequestList.remove(downloadRequest);
        requestNextDownload();
    }

    public static boolean getDefaultLanguageSupported(Context context) {
        Boolean bool = sIsDefaultLanguageSupported;
        if (bool != null) {
            return bool.booleanValue();
        }
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(context);
        textRecognitionLanguageDownloadHelper.init(false);
        boolean zIsExistedOnDeviceByDefaultLanguage = textRecognitionLanguageDownloadHelper.isExistedOnDeviceByDefaultLanguage();
        sIsDefaultLanguageSupported = Boolean.valueOf(zIsExistedOnDeviceByDefaultLanguage);
        return zIsExistedOnDeviceByDefaultLanguage;
    }

    public static boolean isHWREnabledChanged() {
        return SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_CHANGED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestNextDownload() {
        String str = TAG;
        DataLogger.m12302d(str, "requestNextDownload");
        CopyOnWriteArrayList<DownloadRequest> copyOnWriteArrayList = sDownloadRequestList;
        if (copyOnWriteArrayList.isEmpty()) {
            DataLogger.m12302d(str, "requestNextDownload end");
        } else if (copyOnWriteArrayList.get(0) != null) {
            this.mDownloadMonitor.removeMessages(0);
            this.mDownloadMonitor.sendEmptyMessage(0);
        }
    }

    public static void setHWREnabledChanged(boolean z) {
        SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_CHANGED, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConvertToTextLanguageAvailable() {
        TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(this.mContext);
        textRecognitionLanguage.initTextRecognitionLanguage(false);
        List<String> languageListForTextRecognition = textRecognitionLanguage.getLanguageListForTextRecognition();
        if (languageListForTextRecognition == null || languageListForTextRecognition.isEmpty()) {
            DataLogger.m12302d(TAG, "isCurrentConvertToTextLanguageAvailable(). language list is null!!");
            return;
        }
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, null);
        if (TextUtils.isEmpty(string) || !languageListForTextRecognition.contains(string)) {
            String str = languageListForTextRecognition.get(0);
            DataLogger.m12302d(TAG, "isCurrentConvertToTextLanguageAvailable(). update current langugage : " + str);
            SharedPreferencesCompat.getInstance("Settings").putString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, str);
        }
    }

    public boolean canDownloadLanguage() {
        return canDownloadLanguage(false);
    }

    public void cancelDownload(String str) {
        AbstractC11014a.m12334s("cancelDownload , locale = ", str, TAG);
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        if (hwrLanguagePack == null) {
            return;
        }
        if (hwrLanguagePack.isDownloadInProgress() && !hwrLanguagePack.isCancelInProgress()) {
            hwrLanguagePack.cancel();
        }
        DownloadRequest downloadRequest = null;
        for (DownloadRequest downloadRequest2 : sDownloadRequestList) {
            if (downloadRequest2.getLocale().equals(str)) {
                downloadRequest = downloadRequest2;
            }
        }
        if (downloadRequest != null) {
            sDownloadRequestList.remove(downloadRequest);
        }
    }

    public void close() {
        this.mInitFinishedListener = null;
        this.mCloseRequested = true;
        DownloadRequest downloadRequest = this.mCurrentDownload;
        if (downloadRequest != null) {
            downloadRequest.mDownloadListener = null;
        }
        Iterator<DownloadRequest> it = sDownloadRequestList.iterator();
        while (it.hasNext()) {
            it.next().mDownloadListener = null;
        }
    }

    @VisibleForTesting
    public HwrLanguageManager createLanguageManager() {
        return new HwrLanguageManager(this.mContext);
    }

    public void deleteLanguage(String str, final DeleteListener deleteListener) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        if (hwrLanguagePack == null || !hwrLanguagePack.isDownloaded() || hwrLanguagePack.isPreloaded()) {
            return;
        }
        hwrLanguagePack.delete(new HwrLanguagePack.OnDeleteListener() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.4
            @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguagePack.OnDeleteListener
            public void onComplete(final int i) {
                TextRecognitionLanguageDownloadHelper.this.mLangManager.update(new HwrLanguageManager.OnUpdateListener() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.4.1
                    @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
                    public void onComplete(int i2) {
                        DataLogger.m12302d(TextRecognitionLanguageDownloadHelper.TAG, "mLangManager.update");
                        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = TextRecognitionLanguageDownloadHelper.this;
                        textRecognitionLanguageDownloadHelper.mAvailableLanguages = textRecognitionLanguageDownloadHelper.mLangManager.getAvailableLanguage();
                        TextRecognitionLanguageDownloadHelper.this.updateCurrentConvertToTextLanguageAvailable();
                        DeleteListener deleteListener2 = deleteListener;
                        if (deleteListener2 != null) {
                            deleteListener2.onComplete(i);
                        }
                    }
                }, true);
            }
        });
    }

    public void download(String str, DownloadListener downloadListener) {
        CopyOnWriteArrayList<DownloadRequest> copyOnWriteArrayList = sDownloadRequestList;
        if (!copyOnWriteArrayList.isEmpty()) {
            copyOnWriteArrayList.add(new DownloadRequest(str, downloadListener));
        } else {
            copyOnWriteArrayList.add(new DownloadRequest(str, downloadListener));
            requestNextDownload();
        }
    }

    @Nullable
    public String findDefaultLanguage() {
        Locale locale = Locale.getDefault();
        List<LanguageInfo> languageInfoList = getLanguageInfoList();
        if (languageInfoList == null) {
            return null;
        }
        Iterator<LanguageInfo> it = languageInfoList.iterator();
        while (it.hasNext()) {
            String str = it.next().locale;
            if (str.contains(locale.getLanguage()) && str.contains(locale.getCountry())) {
                return str;
            }
        }
        return null;
    }

    public List<LanguageInfo> getLanguageInfoList() {
        return getLanguageInfoList(false);
    }

    public List<LanguageInfo> getLanguageInfoListForAiLanguage() {
        return getLanguageInfoList(true);
    }

    public List<String> getLocaleListInQueue() {
        ArrayList arrayList = new ArrayList();
        Iterator<DownloadRequest> it = sDownloadRequestList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLocale());
        }
        return arrayList;
    }

    public void init(boolean z) {
        HwrLanguageManager hwrLanguageManagerCreateLanguageManager = createLanguageManager();
        this.mLangManager = hwrLanguageManagerCreateLanguageManager;
        hwrLanguageManagerCreateLanguageManager.update(new HwrLanguageManager.OnUpdateListener() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.2
            @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
            public void onComplete(int i) {
                TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = TextRecognitionLanguageDownloadHelper.this;
                textRecognitionLanguageDownloadHelper.mAvailableLanguages = textRecognitionLanguageDownloadHelper.mLangManager.getAvailableLanguage();
                TextRecognitionLanguageDownloadHelper.this.updateCurrentConvertToTextLanguageAvailable();
                if (TextRecognitionLanguageDownloadHelper.this.mInitFinishedListener != null) {
                    TextRecognitionLanguageDownloadHelper.this.mInitFinishedListener.onInitFinished();
                }
            }
        }, z);
    }

    public boolean isDownloadInProgress(String str) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        return hwrLanguagePack != null && hwrLanguagePack.isDownloadInProgress();
    }

    public boolean isDownloaded(String str) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        return hwrLanguagePack != null && hwrLanguagePack.isDownloaded();
    }

    public boolean isExistOnDevice(String str) {
        return isPreloaded(str) || isDownloaded(str) || isUpdateAvailable(str);
    }

    public boolean isExistedOnDeviceByDefaultLanguage() {
        if (isHWREnabledChanged()) {
            return true;
        }
        String strFindDefaultLanguage = findDefaultLanguage();
        if (strFindDefaultLanguage != null) {
            return isExistOnDevice(strFindDefaultLanguage);
        }
        return false;
    }

    public void isInitFinished(InitFinishedListener initFinishedListener) {
        this.mInitFinishedListener = initFinishedListener;
        if (this.mAvailableLanguages == null || initFinishedListener == null) {
            return;
        }
        initFinishedListener.onInitFinished();
    }

    public boolean isInstallable(String str) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        return hwrLanguagePack != null && hwrLanguagePack.isInstallable();
    }

    public boolean isPreloaded(String str) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        return (hwrLanguagePack != null && hwrLanguagePack.isPreloaded()) || this.mLangManager.isPreloadedLanguage(str);
    }

    public boolean isUpdateAvailable(String str) {
        HwrLanguagePack hwrLanguagePack = this.mLangManager.get(str);
        return hwrLanguagePack != null && hwrLanguagePack.isUpdateAvailable();
    }

    public boolean canDownloadLanguage(boolean z) {
        String[] strArr = this.mAvailableLanguages;
        if (strArr == null) {
            return false;
        }
        if (z) {
            List<String> availableLanguages = SpenRecognizerAILanguages.getAvailableLanguages();
            for (String str : this.mAvailableLanguages) {
                if (availableLanguages.contains(str) && !isExistOnDevice(str)) {
                    return true;
                }
            }
        } else {
            for (String str2 : strArr) {
                if (!isExistOnDevice(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<LanguageInfo> getLanguageInfoList(boolean z) {
        HwrLanguagePack hwrLanguagePack;
        ArrayList arrayList = new ArrayList();
        if (this.mAvailableLanguages != null) {
            List<String> availableLanguages = z ? SpenRecognizerAILanguages.getAvailableLanguages() : null;
            for (String str : this.mAvailableLanguages) {
                if ((availableLanguages == null || availableLanguages.contains(str)) && (hwrLanguagePack = this.mLangManager.get(str)) != null) {
                    arrayList.add(new LanguageInfo(str, hwrLanguagePack.isDownloaded(), hwrLanguagePack.isUpdateAvailable(), hwrLanguagePack.isPreloaded(), hwrLanguagePack.isInstallable(), hwrLanguagePack.isDownloadInProgress(), hwrLanguagePack.isCancelInProgress()));
                }
            }
        }
        return arrayList;
    }
}
