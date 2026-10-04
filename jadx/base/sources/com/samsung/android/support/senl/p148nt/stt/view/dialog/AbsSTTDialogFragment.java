package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputLayout;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.pen.setting.colorpicker.C7544f;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.util.EmoticonUtils;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTDialogFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnKeyListenerC0175b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 B2\u00020\u0001:\u0002ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0017J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0004J\b\u0010'\u001a\u00020\"H\u0004J\b\u0010(\u001a\u00020\"H\u0004J\b\u0010)\u001a\u00020\"H\u0004J\b\u0010,\u001a\u00020\"H\u0016J\u0012\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u00102\u001a\u00020\"2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001aH\u0004J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208H\u0004J#\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0007¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u0007H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mDialogDestroyListener", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogDestroyListener;", "mTotalLength", "", "getMTotalLength", "()I", "setMTotalLength", "(I)V", "mInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getMInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "setMInputLayout", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "mErrorType", "mReceiveTime", "", "getMReceiveTime", "()J", "setMReceiveTime", "(J)V", "mIsKeyboardVisible", "", "getMIsKeyboardVisible", "()Z", "setMIsKeyboardVisible", "(Z)V", "mKeyboardIntentFilter", "Landroid/content/IntentFilter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setIsKeyboardVisible", "showHideSIP", "unregisterKeyBoardReceiver", "registerKeyBoardReceiver", "mKeyboardReceiver", "Landroid/content/BroadcastReceiver;", "onDestroy", "mOnKeyListener", "Landroid/content/DialogInterface$OnKeyListener;", "setDialogResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogResultListener;", "setPrivateImeOptions", "inputView", "Landroid/widget/EditText;", "isRecording", "checkInvalidChars", "source", "", "getNameFilter", "", "Landroid/text/InputFilter;", "isIncludeCount", "fixedMaxLength", "(ZI)[Landroid/text/InputFilter;", "setInputErrorMessage", "type", "InputErrorType", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsSTTDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsSTTDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,282:1\n37#2:283\n36#2,3:284\n*S KotlinDebug\n*F\n+ 1 AbsSTTDialogFragment.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment\n*L\n118#1:283\n118#1:284,3\n*E\n"})
public class AbsSTTDialogFragment extends DialogFragment {

    @NotNull
    private static final String DISABLE_EMOTICON_FLAG = "disableEmoticonInput=true";

    @NotNull
    private static final String DISABLE_GIF_FLAG = "disableGifKeyboard=true";

    @NotNull
    private static final String DISABLE_LIVE_MESSAGE = "disableLiveMessage=true";

    @NotNull
    private static final String DISABLE_PREDICTION_FLAG = "inputType=PredictionOff";

    @NotNull
    private static final String DISABLE_STICKER_FLAG = "disableSticker=true";

    @NotNull
    private static final String DISABLE_SYMBLE_FLAG = "inputType=filename";

    @NotNull
    private static final String NO_MICROPHONE_KEY = "noMicrophoneKey";

    @NotNull
    private static final String TAG = "AbsSTTDialogFragment";

    @NotNull
    private static final String VOICEINPUT_OFF = "disableVoiceInput=true";

    @Nullable
    private STTDialogFactory.DialogDestroyListener mDialogDestroyListener;

    @Nullable
    private TextInputLayout mInputLayout;

    @Nullable
    private IntentFilter mKeyboardIntentFilter;
    private long mReceiveTime;
    private int mTotalLength;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String BUNDLE_ERROR_TYPE = "error_type";
    private static final int MAX_LENGTH = 50;
    private static final int NONE_ERROR_TYPE = -1;
    private int mErrorType = NONE_ERROR_TYPE;
    private boolean mIsKeyboardVisible = true;

    @Nullable
    private BroadcastReceiver mKeyboardReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.AbsSTTDialogFragment$mKeyboardReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.this$0.setMReceiveTime(System.currentTimeMillis());
            this.this$0.setMIsKeyboardVisible(intent.getBooleanExtra("AxT9IME.isVisibleWindow", true));
        }
    };

    @NotNull
    private final DialogInterface.OnKeyListener mOnKeyListener = new DialogInterfaceOnKeyListenerC0175b(3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u00058\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00138\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DISABLE_PREDICTION_FLAG", "DISABLE_EMOTICON_FLAG", "DISABLE_STICKER_FLAG", "DISABLE_GIF_FLAG", "DISABLE_LIVE_MESSAGE", "DISABLE_SYMBLE_FLAG", "VOICEINPUT_OFF", "NO_MICROPHONE_KEY", "BUNDLE_ERROR_TYPE", "getBUNDLE_ERROR_TYPE$annotations", "getBUNDLE_ERROR_TYPE", "()Ljava/lang/String;", "MAX_LENGTH", "", "getMAX_LENGTH$annotations", "getMAX_LENGTH", "()I", "NONE_ERROR_TYPE", "getNONE_ERROR_TYPE$annotations", "getNONE_ERROR_TYPE", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getBUNDLE_ERROR_TYPE() {
            return AbsSTTDialogFragment.BUNDLE_ERROR_TYPE;
        }

        public final int getMAX_LENGTH() {
            return AbsSTTDialogFragment.MAX_LENGTH;
        }

        public final int getNONE_ERROR_TYPE() {
            return AbsSTTDialogFragment.NONE_ERROR_TYPE;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getBUNDLE_ERROR_TYPE$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getMAX_LENGTH$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getNONE_ERROR_TYPE$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÄ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment$InputErrorType;", "", "<init>", "()V", "MAX_CHAR_REACHED_MSG", "", "INVALID_CHARACTER", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class InputErrorType {

        @NotNull
        public static final InputErrorType INSTANCE = new InputErrorType();
        public static final int INVALID_CHARACTER = 1;
        public static final int MAX_CHAR_REACHED_MSG = 0;

        private InputErrorType() {
        }
    }

    @NotNull
    public static final String getBUNDLE_ERROR_TYPE() {
        return INSTANCE.getBUNDLE_ERROR_TYPE();
    }

    public static final int getMAX_LENGTH() {
        return INSTANCE.getMAX_LENGTH();
    }

    public static final int getNONE_ERROR_TYPE() {
        return INSTANCE.getNONE_ERROR_TYPE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getNameFilter$lambda$2(AbsSTTDialogFragment absSTTDialogFragment, CharSequence source, int i, int i2, Spanned dest, int i4, int i5) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i6 = i2 - i;
        int i7 = MAX_LENGTH;
        if (i6 > i7) {
            i2 = i + i7;
        }
        String string = source.subSequence(i, i2).toString();
        String string2 = dest.subSequence(i4, i5).toString();
        if (!absSTTDialogFragment.checkInvalidChars(string) && !EmoticonUtils.INSTANCE.hasEmoticon(string)) {
            return null;
        }
        absSTTDialogFragment.setInputErrorMessage(1);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnKeyListener$lambda$1(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return keyEvent.getKeyCode() == 84;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHideSIP$lambda$0(AbsSTTDialogFragment absSTTDialogFragment, EditText editText) {
        if (absSTTDialogFragment.getContext() == null) {
            return;
        }
        Object systemService = absSTTDialogFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }

    public final boolean checkInvalidChars(@NotNull String source) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(source, "source");
        String[] strArr = {"\\", "/", ":", "*", MsalUtils.QUERY_STRING_SYMBOL, "\"", "<", ">", "|"};
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            String str = strArr[i];
            if (StringsKt.m14162r(source, str) || ((cCharAt = str.charAt(0)) >= '!' && cCharAt < '~' && cCharAt != '?' && StringsKt.m14128B(source, (char) (cCharAt + 65248), 0, 6) >= 0)) {
                z = true;
            }
        }
        return z;
    }

    @Nullable
    public final TextInputLayout getMInputLayout() {
        return this.mInputLayout;
    }

    public final boolean getMIsKeyboardVisible() {
        return this.mIsKeyboardVisible;
    }

    public final long getMReceiveTime() {
        return this.mReceiveTime;
    }

    public final int getMTotalLength() {
        return this.mTotalLength;
    }

    @NotNull
    public final InputFilter[] getNameFilter(boolean isIncludeCount, int fixedMaxLength) {
        Ref.IntRef intRef = new Ref.IntRef();
        int i = MAX_LENGTH;
        intRef.element = i;
        C7544f c7544f = new C7544f(this, 1);
        if (isIncludeCount && i < fixedMaxLength) {
            intRef.element = fixedMaxLength;
        }
        return new InputFilter[]{c7544f, new InputFilter.LengthFilter(intRef, this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.AbsSTTDialogFragment.getNameFilter.2
            final /* synthetic */ AbsSTTDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(intRef.element);
                this.this$0 = this;
            }

            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(dest, "dest");
                super.filter(source, start, end, dest, dstart, dend);
                int max_length = AbsSTTDialogFragment.getMAX_LENGTH() - (dest.length() - (dend - dstart));
                if (max_length <= 0) {
                    this.this$0.setInputErrorMessage(0);
                    return "";
                }
                if (max_length >= end - start) {
                    return null;
                }
                int i2 = max_length + start;
                char cCharAt = source.charAt(i2 - 1);
                if ((Character.isHighSurrogate(cCharAt) || cCharAt == 9770 || cCharAt == 9642) && i2 - 1 == start) {
                    this.this$0.setInputErrorMessage(0);
                    return "";
                }
                this.this$0.setInputErrorMessage(0);
                return source.subSequence(start, i2);
            }
        }};
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @SuppressLint({"HandlerLeak"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mErrorType = savedInstanceState.getInt(BUNDLE_ERROR_TYPE, NONE_ERROR_TYPE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            dialog.setOnKeyListener(null);
        }
        STTDialogFactory.DialogDestroyListener dialogDestroyListener = this.mDialogDestroyListener;
        if (dialogDestroyListener != null) {
            Intrinsics.checkNotNull(dialogDestroyListener);
            dialogDestroyListener.onDialogDestroy(getFragmentManager());
            Object[] array = STTDialogFactory.INSTANCE.getDIALOG_STACK$ntStt_release().toArray(new Object[0]);
            FragmentManager fragmentManager = getFragmentManager();
            for (Object obj : array) {
                Intrinsics.checkNotNull(fragmentManager);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag((String) obj);
                if (fragmentFindFragmentByTag == null || fragmentFindFragmentByTag.isRemoving()) {
                    STTDialogFactory.INSTANCE.getDIALOG_STACK$ntStt_release().remove(obj);
                }
            }
        }
        if (this.mKeyboardIntentFilter != null) {
            this.mKeyboardIntentFilter = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            dialog.setOnKeyListener(this.mOnKeyListener);
            setInputErrorMessage(this.mErrorType);
        }
    }

    public final void registerKeyBoardReceiver() {
        if (this.mKeyboardIntentFilter == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.mKeyboardIntentFilter = intentFilter;
            Intrinsics.checkNotNull(intentFilter);
            intentFilter.addAction("ResponseAxT9Info");
        }
        if (this.mKeyboardReceiver == null || getContext() == null) {
            return;
        }
        requireContext().getApplicationContext().registerReceiver(this.mKeyboardReceiver, this.mKeyboardIntentFilter, 2);
    }

    public void setInputErrorMessage(int type) {
        TextInputLayout textInputLayout = this.mInputLayout;
        if (textInputLayout != null) {
            if (type == 0) {
                Intrinsics.checkNotNull(textInputLayout);
                if (textInputLayout.isErrorEnabled()) {
                    TextInputLayout textInputLayout2 = this.mInputLayout;
                    Intrinsics.checkNotNull(textInputLayout2);
                    if (textInputLayout2.getError() == null) {
                        return;
                    }
                    TextInputLayout textInputLayout3 = this.mInputLayout;
                    Intrinsics.checkNotNull(textInputLayout3);
                    if (Intrinsics.areEqual(textInputLayout3.getError(), requireContext().getString(C11493R.string.maximum_number_of_characters_reached))) {
                        return;
                    }
                }
                TextInputLayout textInputLayout4 = this.mInputLayout;
                Intrinsics.checkNotNull(textInputLayout4);
                textInputLayout4.setError(requireContext().getString(C11493R.string.maximum_number_of_characters_reached));
                return;
            }
            if (type != 1) {
                return;
            }
            Intrinsics.checkNotNull(textInputLayout);
            if (textInputLayout.isErrorEnabled()) {
                TextInputLayout textInputLayout5 = this.mInputLayout;
                Intrinsics.checkNotNull(textInputLayout5);
                if (textInputLayout5.getError() == null) {
                    return;
                }
                TextInputLayout textInputLayout6 = this.mInputLayout;
                Intrinsics.checkNotNull(textInputLayout6);
                if (Intrinsics.areEqual(textInputLayout6.getError(), requireContext().getString(C11493R.string.string_invalid_character))) {
                    return;
                }
            }
            TextInputLayout textInputLayout7 = this.mInputLayout;
            Intrinsics.checkNotNull(textInputLayout7);
            textInputLayout7.setError(requireContext().getString(C11493R.string.string_invalid_character));
        }
    }

    public final void setIsKeyboardVisible() {
        if (System.currentTimeMillis() - this.mReceiveTime < 150) {
            this.mIsKeyboardVisible = true;
        }
    }

    public final void setMInputLayout(@Nullable TextInputLayout textInputLayout) {
        this.mInputLayout = textInputLayout;
    }

    public final void setMIsKeyboardVisible(boolean z) {
        this.mIsKeyboardVisible = z;
    }

    public final void setMReceiveTime(long j) {
        this.mReceiveTime = j;
    }

    public final void setMTotalLength(int i) {
        this.mTotalLength = i;
    }

    public final void setPrivateImeOptions(@NotNull EditText inputView, boolean isRecording) {
        Intrinsics.checkNotNullParameter(inputView, "inputView");
        StringBuilder sb = new StringBuilder("inputType=PredictionOff;disableEmoticonInput=true;inputType=filename;disableGifKeyboard=true;disableLiveMessage=true;disableSticker=true");
        if (isRecording) {
            sb.append(";disableVoiceInput=true;noMicrophoneKey");
        }
        inputView.setPrivateImeOptions(sb.toString());
    }

    public final void showHideSIP() {
        if (!getShowsDialog() || getDialog() == null) {
            return;
        }
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        final EditText editText = (EditText) dialog.findViewById(C11493R.id.rename_input);
        if (editText == null) {
            return;
        }
        if (this.mIsKeyboardVisible) {
            editText.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.a
                @Override // java.lang.Runnable
                public final void run() {
                    AbsSTTDialogFragment.showHideSIP$lambda$0(this.f7924a, editText);
                }
            }, 250L);
            editText.requestFocus();
        }
        registerKeyBoardReceiver();
    }

    public final void unregisterKeyBoardReceiver() {
        if (this.mKeyboardReceiver == null || getContext() == null) {
            return;
        }
        try {
            requireContext().getApplicationContext().unregisterReceiver(this.mKeyboardReceiver);
        } catch (IllegalArgumentException unused) {
            Logger.m12714w(TAG, "onPause() - IllegalArgumentException");
        }
    }

    public void setDialogResultListener(@Nullable STTDialogFactory.DialogResultListener listener) {
    }
}
