package com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.DialogInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.IRecognitionListener;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ISpeechRecognizer;
import com.samsung.android.sdk.scs.p142ai.asr.ASRLog;
import com.samsung.android.sdk.scs.p142ai.asr.p143io.NullOutputStream;
import com.samsung.android.sdk.scs.p142ai.asr.tasks.C7709a;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.RecognitionConfig;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.SpeechRecognitionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SttRecognitionTask extends RecognitionTask<String> {
    private static final SpeechRecognitionListener ignoreResult = new SpeechRecognitionListener() { // from class: com.samsung.android.sdk.scs.ai.asr_6_0.tasks.SttRecognitionTask.1
        @Override // com.samsung.android.sdk.scs.p142ai.asr_6_0.SpeechRecognitionListener
        public void onPartialResults(String str, Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr_6_0.SpeechRecognitionListener
        public void onResults(String str, Bundle bundle) {
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr_6_0.SpeechRecognitionListener
        public void onError(int i, String str, Bundle bundle) {
        }
    };
    private final String TAG;
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

        @Override // com.samsung.android.scs.p140ai.sdkcommon.asr.IRecognitionListener
        public void onError(Bundle bundle) {
            String string = bundle.getString("error_message");
            int i = bundle.getInt("error_code");
            ASRLog.secure(this.TAG, "onError", this.root, bundle);
            this.root.onError(i, string, new Bundle());
            this.complete.accept(string);
        }

        @Override // com.samsung.android.scs.p140ai.sdkcommon.asr.IRecognitionListener
        public void onPartialResults(Bundle bundle) {
            bundle.setClassLoader(DialogInfo.class.getClassLoader());
            ASRLog.secure(this.TAG, "onPartialResults", this.root, bundle);
            this.root.onPartialResults(bundle.getString("result"), bundle);
        }

        @Override // com.samsung.android.scs.p140ai.sdkcommon.asr.IRecognitionListener
        public void onResults(Bundle bundle) {
            bundle.setClassLoader(DialogInfo.class.getClassLoader());
            String string = bundle.getString("result");
            ASRLog.secure(this.TAG, "onResults", this.root, bundle);
            this.root.onResults(string, bundle);
            this.complete.accept("done:" + Optional.ofNullable(string).map(new C7709a(2)).orElse(0));
        }

        public void release() {
            ASRLog.m6139i(this.TAG, "release listener", this.root);
            this.root = SttRecognitionTask.ignoreResult;
        }
    }

    public SttRecognitionTask(RecognitionConfig recognitionConfig, InputStream inputStream, SpeechRecognitionListener speechRecognitionListener) {
        String str = "SttTask6.0@" + hashCode();
        this.TAG = str;
        this.dest = new AtomicReference<>(new NullOutputStream());
        Log.e(str, "create task");
        this.config = recognitionConfig;
        this.inputStream = inputStream;
        this.listener = new ListenerWrapper(str, speechRecognitionListener, new C4191n(this, 4));
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

    private Bundle parseError(int i, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("error_code", i);
        bundle2.putString("error_message", str);
        return bundle2;
    }

    private boolean prepare() {
        try {
            if (this.listener == null) {
                Log.e(this.TAG, "listener is not valid");
                return false;
            }
            this.mRecognizer = this.mService.create(new Bundle());
            Bundle bundle = new Bundle();
            bundle.putSerializable("locale", this.config.getLocale());
            bundle.putInt("connection_type", this.config.getConnectionType().getTypeInt());
            bundle.putBoolean("enabled_partial", this.config.enabledPartialResult());
            bundle.putBoolean("enabled_audio_compression", this.config.isEnabledAudioCompression());
            bundle.putBoolean("enabled_censor", this.config.isCensored());
            bundle.putInt("server_type", this.config.getServerType());
            bundle.putParcelable("app_server_type", this.config.getServerInfo());
            bundle.putBoolean("enable_speaker_diarisation", this.config.isSpeakerDiarisation());
            bundle.putIntegerArrayList("dict_type", new ArrayList<>((Collection) this.config.getDictationTypes().stream().map(new C7722a()).collect(Collectors.toList())));
            Log.i(this.TAG, "prepared started");
            boolean zPrepare = this.mRecognizer.prepare(bundle);
            Log.i(this.TAG, "prepared : " + zPrepare);
            return zPrepare;
        } catch (RemoteException e) {
            handleInternalError(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void taskCompleted(String str) {
        Optional optionalOfNullable;
        C7723b c7723b;
        if (isComplete()) {
            Log.w(this.TAG, "task already completed");
            return;
        }
        try {
            try {
                Log.e(this.TAG, "taskCompleted : " + str);
                complete(str);
                ISpeechRecognizer iSpeechRecognizer = this.mRecognizer;
                if (iSpeechRecognizer != null) {
                    iSpeechRecognizer.release();
                }
                this.mRecognizer = null;
                optionalOfNullable = Optional.ofNullable(this.listener);
                c7723b = new C7723b();
            } catch (Exception e) {
                handleInternalError(e);
                this.mRecognizer = null;
                optionalOfNullable = Optional.ofNullable(this.listener);
                c7723b = new C7723b();
            }
            optionalOfNullable.ifPresent(c7723b);
            this.listener = null;
        } catch (Throwable th) {
            this.mRecognizer = null;
            Optional.ofNullable(this.listener).ifPresent(new C7723b());
            this.listener = null;
            throw th;
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
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    byte[] bArr = new byte[320];
                    this.dest.set(autoCloseOutputStream);
                    loop0: while (true) {
                        long j2 = j;
                        while (!isCancelled() && (i = inputStream.read(bArr)) != -1) {
                            if (i == 0) {
                                Thread.sleep(10L);
                            } else {
                                autoCloseOutputStream.write(bArr, 0, i);
                                j += (long) i;
                                if (j - j2 > 10000) {
                                    break;
                                }
                            }
                        }
                        Log.i(this.TAG, "writeToPipe written " + j);
                    }
                    autoCloseOutputStream.close();
                    Log.i(this.TAG, "writeToPipe done " + j);
                    atomicReference = this.dest;
                    nullOutputStream = new NullOutputStream();
                } catch (Throwable th) {
                    try {
                        autoCloseOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Log.i(this.TAG, "writeToPipe done 0");
                this.dest.set(new NullOutputStream());
                throw th3;
            }
        } catch (IOException | InterruptedException e) {
            handleInternalError(e);
            Log.i(this.TAG, "writeToPipe done 0");
            atomicReference = this.dest;
            nullOutputStream = new NullOutputStream();
        }
        atomicReference.set(nullOutputStream);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks.RecognitionTask
    public void cancel() {
        Log.e(this.TAG, "cancel");
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
                Log.i(this.TAG, "input stream closed");
            }
        }
        try {
            try {
                this.dest.get().close();
            } catch (Exception e3) {
                Log.w(this.TAG, "close dest stream has error but ignored. " + e3.getMessage());
            }
        } finally {
            Log.i(this.TAG, "dest stream closed");
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
            Log.e(this.TAG, "execute");
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

    private Bundle parseError(int i, String str) {
        return parseError(i, str, new Bundle());
    }
}
