package com.samsung.android.sdk.scs.p142ai.asr.tasks;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.BuildConfig;
import com.samsung.android.sdk.scs.p142ai.asr.ASRLog;
import com.samsung.android.sdk.scs.p142ai.asr.RecognitionConfig;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.sdk.scs.p142ai.asr.p143io.NullOutputStream;
import com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.DialogInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.IRecognitionListener;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ISpeechRecognizer;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SttRecognitionTask extends RecognitionTask<String> {
    private static final long TIMEOUT_WRITE = TimeUnit.SECONDS.toMillis(30);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final SpeechRecognitionListener ignoreResult = new SpeechRecognitionListener() { // from class: com.samsung.android.sdk.scs.ai.asr.tasks.SttRecognitionTask.1
        @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
        public void onPartialResults(String str, Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
        public void onResults(String str, Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
        public void onError(int i, String str, Bundle bundle) {
        }
    };
    private final String callerPackage;
    private final RecognitionConfig config;
    private final AtomicReference<OutputStream> dest;

    @Nullable
    private InputStream inputStream;
    private ListenerWrapper listener;
    private ISpeechRecognizer mRecognizer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerWrapper extends IRecognitionListener.Stub {
        private final String TAG;
        private final Consumer<String> complete;
        private SpeechRecognitionListener root;

        public ListenerWrapper(String str, SpeechRecognitionListener speechRecognitionListener, Consumer<String> consumer) {
            this.TAG = str;
            this.root = speechRecognitionListener;
            this.complete = consumer;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @SuppressLint({WarningType.NewApi})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Bundle checkFileUriResult(Bundle bundle) throws Throwable {
            final Bundle bundle2;
            Exception e;
            Throwable th;
            loadClassesBeforeAccess(bundle);
            if (!bundle.containsKey(SpeechRecognitionConst.Key.LARGE_RESULT_PFD)) {
                return bundle;
            }
            try {
                try {
                    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable(SpeechRecognitionConst.Key.LARGE_RESULT_PFD, ParcelFileDescriptor.class);
                    try {
                        try {
                            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                            try {
                                int iAvailable = autoCloseInputStream.available();
                                ASRLog.m6139i(this.TAG, "checkFileUriResult", Integer.valueOf(iAvailable));
                                byte[] bArr = new byte[iAvailable];
                                autoCloseInputStream.read(bArr, 0, iAvailable);
                                Parcel parcelObtain = Parcel.obtain();
                                parcelObtain.unmarshall(bArr, 0, iAvailable);
                                parcelObtain.setDataPosition(0);
                                bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain);
                                try {
                                    loadClassesBeforeAccess(bundle2);
                                    parcelObtain.recycle();
                                    if (ASRLog.isDevelop) {
                                        bundle2.keySet().forEach(new Consumer() { // from class: com.samsung.android.sdk.scs.ai.asr.tasks.d
                                            @Override // java.util.function.Consumer
                                            public final void accept(Object obj) {
                                                this.f5163a.lambda$checkFileUriResult$0(bundle2, (String) obj);
                                            }
                                        });
                                    }
                                    autoCloseInputStream.close();
                                    if (parcelFileDescriptor == null) {
                                        return bundle2;
                                    }
                                    parcelFileDescriptor.close();
                                    return bundle2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        autoCloseInputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                bundle2 = bundle;
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            bundle2 = bundle;
                            th = th5;
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (Throwable th6) {
                                    th.addSuppressed(th6);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        if (parcelFileDescriptor != null) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    ASRLog.m6138e(this.TAG, "failed to check FileUriResult", e.getMessage());
                    if (ASRLog.isDevelop) {
                        e.printStackTrace();
                    }
                    return bundle2;
                }
            } catch (Exception e3) {
                bundle2 = bundle;
                e = e3;
                ASRLog.m6138e(this.TAG, "failed to check FileUriResult", e.getMessage());
                if (ASRLog.isDevelop) {
                }
                return bundle2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$checkFileUriResult$0(Bundle bundle, String str) {
            ASRLog.m6139i(this.TAG, "FileUriResult", str, bundle.get(str));
        }

        private void loadClassesBeforeAccess(Bundle bundle) {
            bundle.setClassLoader(DialogInfo.class.getClassLoader());
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.IRecognitionListener
        public void onError(Bundle bundle) {
            String string = bundle.getString("error_message");
            int i = bundle.getInt("error_code");
            ASRLog.secure(this.TAG, "onError", this.root, bundle);
            this.root.onError(i, string, new Bundle());
            this.complete.accept(string);
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.IRecognitionListener
        public void onPartialResults(Bundle bundle) throws Throwable {
            loadClassesBeforeAccess(bundle);
            Bundle bundleCheckFileUriResult = checkFileUriResult(bundle);
            if (bundleCheckFileUriResult.containsKey(SpeechRecognitionConst.Key.RET_PROGRESS)) {
                int i = bundleCheckFileUriResult.getInt(SpeechRecognitionConst.Key.RET_PROGRESS);
                Bundle bundle2 = bundleCheckFileUriResult.getBundle(SpeechRecognitionConst.Key.RET_PROGRESS_EXTRA);
                ASRLog.secure(this.TAG, "onProgressUpdate", this.root, bundleCheckFileUriResult);
                this.root.onProgressUpdate(i, bundle2);
                return;
            }
            Bundle bundle3 = bundleCheckFileUriResult.getBundle("extra");
            if (bundle3 != null && bundle3.containsKey(SpeechRecognitionConst.Key.RET_LOCALE_CHANGED)) {
                Locale locale = Build.VERSION.SDK_INT >= 33 ? (Locale) bundle3.getSerializable(SpeechRecognitionConst.Key.RET_LOCALE_CHANGED, Locale.class) : (Locale) bundle3.getSerializable(SpeechRecognitionConst.Key.RET_LOCALE_CHANGED);
                ASRLog.secure(this.TAG, "onLocaleChanged", this.root, bundleCheckFileUriResult);
                this.root.onLocaleChanged(locale, bundle3);
                return;
            }
            try {
                ASRLog.secure(this.TAG, "onPartialResults", this.root, bundleCheckFileUriResult);
                this.root.onPartialResults(bundleCheckFileUriResult.getString("result"), bundleCheckFileUriResult);
            } catch (Exception e) {
                ASRLog.m6138e(this.TAG, "Failed to handle result", e.getMessage());
                if (ASRLog.isDevelop) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.samsung.android.sivs.p144ai.sdkcommon.asr.IRecognitionListener
        public void onResults(Bundle bundle) throws Throwable {
            loadClassesBeforeAccess(bundle);
            Bundle bundleCheckFileUriResult = checkFileUriResult(bundle);
            String string = bundleCheckFileUriResult.getString("result");
            try {
                ASRLog.secure(this.TAG, "onResults", this.root, bundleCheckFileUriResult);
                this.root.onResults(string, bundleCheckFileUriResult);
                this.complete.accept("done:" + Optional.ofNullable(string).map(new C7709a(2)).orElse(0));
            } catch (Exception e) {
                ASRLog.m6138e(this.TAG, "Failed to handle result", e.getMessage());
                e.printStackTrace();
            }
        }

        public void release() {
            ASRLog.m6139i(this.TAG, "release listener!!", this.root);
            this.root = SttRecognitionTask.ignoreResult;
        }
    }

    public SttRecognitionTask(RecognitionConfig recognitionConfig, InputStream inputStream, String str, SpeechRecognitionListener speechRecognitionListener) {
        super("SttTask");
        this.dest = new AtomicReference<>(new NullOutputStream());
        this.config = recognitionConfig;
        this.callerPackage = str;
        this.inputStream = inputStream;
        this.listener = new ListenerWrapper(this.TAG, speechRecognitionListener, new C4191n(this, 3));
        Log.m6489i(this.TAG, "create task");
    }

    @NonNull
    private Bundle configToBundle(RecognitionConfig recognitionConfig) {
        Bundle bundle = new Bundle();
        if (recognitionConfig.hasExtras()) {
            bundle.putAll(recognitionConfig.getExtras());
        }
        bundle.putSerializable("locale", recognitionConfig.getLocale());
        bundle.putInt("connection_type", recognitionConfig.getConnectionType().getTypeInt());
        bundle.putBoolean("enabled_partial", recognitionConfig.enabledPartialResult());
        bundle.putBoolean("enabled_audio_compression", recognitionConfig.isEnabledAudioCompression());
        bundle.putBoolean("enabled_censor", recognitionConfig.isCensored());
        bundle.putBoolean(SpeechRecognitionConst.Key.ENABLE_PROGRESS, recognitionConfig.needProgress());
        bundle.putInt("server_type", recognitionConfig.getServerType());
        bundle.putParcelable("app_server_type", recognitionConfig.getServerInfo());
        bundle.putBoolean("enable_speaker_diarisation", recognitionConfig.isSpeakerDiarisation());
        bundle.putInt(SpeechRecognitionConst.Key.SD_NOTIFY_INTERVAL_TIME, recognitionConfig.getSdNotifyIntervalTime());
        bundle.putInt(SpeechRecognitionConst.Key.SD_RECORDING_TYPE, recognitionConfig.getSdRecordingType().getTypeInt());
        bundle.putIntegerArrayList("dict_type", new ArrayList<>((Collection) recognitionConfig.getDictationTypes().stream().map(new C7709a(0)).collect(Collectors.toList())));
        bundle.putSerializable(SpeechRecognitionConst.Key.TARGET_LOCALE, recognitionConfig.getTargetLocale());
        bundle.putLong(SpeechRecognitionConst.Key.VOICE_FILTER_ID, recognitionConfig.getVoiceFilterId());
        bundle.putBoolean(SpeechRecognitionConst.Key.ENABLED_DETAILED_SEGMENT, recognitionConfig.isEnabledDetailedSegment());
        ASRLog.secure(this.TAG, "configToBundle", bundle);
        return bundle;
    }

    private void handleInternalError(Exception exc) {
        ListenerWrapper listenerWrapper;
        boolean zIsCancelled = isCancelled();
        ASRLog.m6138e(this.TAG, "handleInternalError :: " + exc, Boolean.valueOf(zIsCancelled));
        setError(exc);
        if (zIsCancelled || (listenerWrapper = this.listener) == null) {
            return;
        }
        listenerWrapper.onError(parseError(4, exc.getMessage()));
    }

    private void internalRelease() {
        Optional optionalOfNullable;
        C7710b c7710b;
        try {
            try {
                ISpeechRecognizer iSpeechRecognizer = this.mRecognizer;
                if (iSpeechRecognizer != null) {
                    iSpeechRecognizer.release();
                    Log.m6489i(this.TAG, "release completed");
                }
                this.mRecognizer = null;
                optionalOfNullable = Optional.ofNullable(this.listener);
                c7710b = new C7710b();
            } catch (Exception e) {
                ASRLog.m6140w(this.TAG, "some error on internalRelease", e.getMessage());
                this.mRecognizer = null;
                optionalOfNullable = Optional.ofNullable(this.listener);
                c7710b = new C7710b();
            }
            optionalOfNullable.ifPresent(c7710b);
            this.listener = null;
        } catch (Throwable th) {
            this.mRecognizer = null;
            Optional.ofNullable(this.listener).ifPresent(new C7710b());
            this.listener = null;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeToPipe$0(OutputStream outputStream) {
        if (!ASRLog.isDevelop) {
            ASRLog.m6140w(this.TAG, "watch dog occurs but ignored. ", Long.valueOf(TIMEOUT_WRITE));
            return;
        }
        ASRLog.m6138e(this.TAG, "close pipe by watchDog ", Long.valueOf(TIMEOUT_WRITE));
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    private Bundle parseError(int i, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("error_code", i);
        bundle2.putString("error_message", str);
        return bundle2;
    }

    private boolean prepare() {
        try {
            if (this.listener == null) {
                Log.m6490w(this.TAG, "listener is not valid");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(SpeechRecognitionConst.Key.INFO_SDK_VERSION, BuildConfig.VERSION_NAME);
            bundle.putString(SpeechRecognitionConst.Key.INFO_SDK_TYPE, "release");
            bundle.putString("caller_package", this.callerPackage);
            bundle.putString(SpeechRecognitionConst.Key.INFO_CREATE_CALL_TIMESTRING, LocalDateTime.now().format(formatter));
            bundle.putLong(SpeechRecognitionConst.Key.INFO_CREATE_CALL_TIMESTAMP, System.currentTimeMillis());
            bundle.putInt("api_version", SpeechRecognitionConst.VERSION.intValue());
            this.mRecognizer = this.mService.create(bundle);
            Log.m6489i(this.TAG, "prepared started");
            boolean zPrepare = this.mRecognizer.prepare(configToBundle(this.config));
            Log.m6489i(this.TAG, "prepared : " + zPrepare);
            return zPrepare;
        } catch (Exception e) {
            handleInternalError(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void taskCompleted(String str) {
        try {
            if (isComplete()) {
                Log.m6490w(this.TAG, "task already completed");
            } else {
                try {
                    Log.m6489i(this.TAG, "taskCompleted : " + str);
                    complete(str);
                } catch (Exception e) {
                    handleInternalError(e);
                }
            }
        } finally {
            internalRelease();
        }
    }

    private void writeToPipe(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
        AtomicReference<OutputStream> atomicReference;
        NullOutputStream nullOutputStream;
        int i;
        ASRLog.m6139i(this.TAG, "writeToPipe started ", Optional.ofNullable(inputStream).map(new C7709a(1)).orElse(-1));
        long j = 0;
        try {
            try {
                final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    WatchDog watchDogCreate = WatchDog.create();
                    try {
                        byte[] bArr = new byte[320];
                        this.dest.set(autoCloseOutputStream);
                        loop0: while (true) {
                            long j2 = j;
                            while (!isCancelled() && (i = inputStream.read(bArr)) != -1) {
                                if (i == 0) {
                                    Thread.sleep(10L);
                                } else {
                                    Closeable closeableWrapBlocking = watchDogCreate.wrapBlocking(new Runnable() { // from class: com.samsung.android.sdk.scs.ai.asr.tasks.c
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f5161a.lambda$writeToPipe$0(autoCloseOutputStream);
                                        }
                                    }, TIMEOUT_WRITE);
                                    try {
                                        autoCloseOutputStream.write(bArr, 0, i);
                                        if (closeableWrapBlocking != null) {
                                            closeableWrapBlocking.close();
                                        }
                                        j += (long) i;
                                        if (j - j2 > 10000) {
                                            break;
                                        }
                                    } finally {
                                    }
                                }
                            }
                            Log.m6489i(this.TAG, "writeToPipe written " + j);
                        }
                        this.mRecognizer.prepare(configToBundle(this.config));
                        Thread.sleep(200L);
                        if (watchDogCreate != null) {
                            watchDogCreate.close();
                        }
                        autoCloseOutputStream.close();
                        Log.m6489i(this.TAG, "writeToPipe done " + j);
                        atomicReference = this.dest;
                        nullOutputStream = new NullOutputStream();
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        autoCloseOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Log.m6489i(this.TAG, "writeToPipe done 0");
                this.dest.set(new NullOutputStream());
                throw th3;
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            e = e2;
            handleInternalError(e);
            Log.m6489i(this.TAG, "writeToPipe done 0");
            atomicReference = this.dest;
            nullOutputStream = new NullOutputStream();
        } catch (InterruptedException e3) {
            e = e3;
            handleInternalError(e);
            Log.m6489i(this.TAG, "writeToPipe done 0");
            atomicReference = this.dest;
            nullOutputStream = new NullOutputStream();
        }
        atomicReference.set(nullOutputStream);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.tasks.RecognitionTask
    public void cancel() {
        Log.m6489i(this.TAG, "cancel");
        super.cancel();
        ISpeechRecognizer iSpeechRecognizer = this.mRecognizer;
        if (iSpeechRecognizer != null) {
            try {
                iSpeechRecognizer.cancel();
            } catch (RemoteException e) {
                handleInternalError(e);
            }
        }
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    handleInternalError(e2);
                }
            } finally {
                Log.m6489i(this.TAG, "input stream closed");
            }
        }
        try {
            try {
                this.dest.get().close();
            } catch (Exception e3) {
                Log.m6490w(this.TAG, "close dest stream has error but ignored. " + e3.getMessage());
            }
            release();
        } finally {
            Log.m6489i(this.TAG, "dest stream closed");
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            if (!prepare()) {
                setError(new Exception("Prepare Failed!!"));
                ListenerWrapper listenerWrapper = this.listener;
                if (listenerWrapper != null) {
                    listenerWrapper.onError(new Bundle());
                }
                return;
            }
            Log.m6489i(this.TAG, "execute");
            ParcelFileDescriptor[] parcelFileDescriptorArrCreateReliablePipe = ParcelFileDescriptor.createReliablePipe();
            ISpeechRecognizer iSpeechRecognizer = this.mRecognizer;
            if (iSpeechRecognizer == null) {
                throw new Exception("Recognizer is not ready.");
            }
            if (!iSpeechRecognizer.write(parcelFileDescriptorArrCreateReliablePipe[0], this.listener)) {
                parcelFileDescriptorArrCreateReliablePipe[1].closeWithError("Start Error");
            }
            writeToPipe(parcelFileDescriptorArrCreateReliablePipe[1], this.inputStream);
        } catch (Exception e) {
            handleInternalError(e);
        } finally {
            this.inputStream = null;
        }
    }

    public void release() {
        taskCompleted("release");
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.tasks.RecognitionTask
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{caller='");
        return AbstractC0622a.m1170p(this.callerPackage, "'}", sb);
    }

    private Bundle parseError(int i, String str) {
        return parseError(i, str, new Bundle());
    }
}
