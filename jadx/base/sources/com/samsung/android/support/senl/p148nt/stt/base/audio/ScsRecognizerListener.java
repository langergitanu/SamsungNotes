package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.compose.p109ui.graphics.layer.C2061c;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J,\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizerListener;", "Lcom/samsung/android/sdk/scs/ai/asr/SpeechRecognitionListener;", "mSession", "", "<init>", "(Ljava/lang/String;)V", "mHandler", "Landroid/os/Handler;", "onError", "", "error", "", "message", "extra", "Landroid/os/Bundle;", "onResults", "result", "onPartialResults", "onProgressUpdate", "value", "onLocaleChanged", "locale", "Ljava/util/Locale;", "createMessageForLocale", "Landroid/os/Message;", "createMessageForHandler", "msgWhat", "errorCode", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScsRecognizerListener implements SpeechRecognitionListener {

    @NotNull
    private static final String ERROR_CODE = "error_code";

    @NotNull
    private static final String EXTRA_RESULT = "extra_result";

    @NotNull
    protected static final String KEY_RESULT_LOCALE = "result_locale";
    private static final int MSG_ON_ERROR = 1;
    private static final int MSG_ON_FINAL_RESULT = 2;
    private static final int MSG_ON_LOCALE_CHANGED = 5;
    private static final int MSG_ON_PARTIAL_RESULT = 3;
    private static final int MSG_ON_PROGRESS_UPDATE = 4;

    @NotNull
    private static final String TAG = "ScsRecognizerListener";

    @NotNull
    private static final String TEXT_RESULT = "text_result";

    @NotNull
    private final Handler mHandler;

    @NotNull
    private final String mSession;

    public ScsRecognizerListener(@NotNull String mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
        this.mHandler = new Handler(new C2061c(this, 3));
    }

    private final Message createMessageForHandler(int msgWhat, int errorCode, String result, Bundle extra) {
        Message message = new Message();
        message.what = msgWhat;
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", errorCode);
        bundle.putString(TEXT_RESULT, result);
        bundle.putBundle(EXTRA_RESULT, extra);
        message.setData(bundle);
        return message;
    }

    private final Message createMessageForLocale(Locale locale, Bundle extra) {
        Message message = new Message();
        message.what = 5;
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", -1);
        bundle.putSerializable(KEY_RESULT_LOCALE, locale);
        bundle.putBundle(EXTRA_RESULT, extra);
        message.setData(bundle);
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler$lambda$0(ScsRecognizerListener scsRecognizerListener, Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Bundle data = msg.getData();
        String string = data.getString(TEXT_RESULT);
        Bundle bundle = data.getBundle(EXTRA_RESULT);
        int i = data.getInt("error_code");
        int i2 = msg.what;
        if (i2 == 1) {
            Logger.m12711e(TAG, "MSG_ON_ERROR ");
            ScsRecognizer companion = ScsRecognizer.INSTANCE.getInstance(scsRecognizerListener.mSession);
            Intrinsics.checkNotNull(string);
            companion.handleServerError(i, string);
            return false;
        }
        if (i2 == 2) {
            Logger.m12713i(TAG, "MSG_ON_FINAL_RESULT");
            ScsRecognizer.INSTANCE.getInstance(scsRecognizerListener.mSession).handleFinalResult(string, bundle);
            return false;
        }
        if (i2 == 3) {
            Logger.m12713i(TAG, "MSG_ON_PARTIAL_RESULT");
            return false;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                return false;
            }
            ScsRecognizer.INSTANCE.getInstance(scsRecognizerListener.mSession).handleLocaleChanged(Build.VERSION.SDK_INT >= 33 ? (Locale) data.getSerializable(KEY_RESULT_LOCALE) : null);
            return false;
        }
        Logger.m12713i(TAG, "MSG_ON_PROGRESS_UPDATE");
        ScsRecognizer companion2 = ScsRecognizer.INSTANCE.getInstance(scsRecognizerListener.mSession);
        Intrinsics.checkNotNull(string);
        companion2.handleProgressUpdate(string);
        return false;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
    public void onError(int error, @Nullable String message, @Nullable Bundle extra) {
        Logger.m12713i(TAG, "Error Code : " + error + ", extra : " + message);
        this.mHandler.sendMessage(createMessageForHandler(1, error, message, extra));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
    public void onLocaleChanged(@NotNull Locale locale, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.mHandler.sendMessage(createMessageForLocale(locale, extra));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
    public void onPartialResults(@NotNull String result, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.m12713i(TAG, "--------------Partial Result------------");
        this.mHandler.sendMessage(createMessageForHandler(3, -1, result, extra));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
    public void onProgressUpdate(int value, @Nullable Bundle extra) {
        this.mHandler.sendMessage(createMessageForHandler(4, -1, String.valueOf(value), extra));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
    public void onResults(@NotNull String result, @Nullable Bundle extra) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(result, "result");
        Logger.m12713i(TAG, "--------------Final Result------------");
        AbstractC11014a.m12327l(result.length(), "Result : ", TAG);
        if (extra != null && (intArray = extra.getIntArray("timing_info")) != null) {
            StringBuilder sb = new StringBuilder();
            for (int i : intArray) {
                sb.append(" ");
                sb.append(i);
            }
            Logger.m12713i(TAG, "Result : " + intArray.length + " " + ((Object) sb));
        }
        this.mHandler.sendMessage(createMessageForHandler(2, -1, result, extra));
    }
}
