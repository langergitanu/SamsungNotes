package com.samsung.android.sdk.pen.text;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0013J<\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J@\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenTextFilter;", "Landroid/text/InputFilter;", "mContext", "Landroid/content/Context;", "limitLength", "", "mView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;ILandroid/view/View;)V", "getLimitLength", "()I", "setLimitLength", "(I)V", "mTextLimitListener", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "mIsTextInputBlock", "", "setTextLimitListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTextInputBlock", "setBlock", "close", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filterLength", "maxLength", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextFilter implements InputFilter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenTextFilter";
    private int limitLength;

    @Nullable
    private Context mContext;
    private boolean mIsTextInputBlock;

    @Nullable
    private SpenTextLimitListener mTextLimitListener;

    @Nullable
    private final View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenTextFilter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "native_getFilterLength", "", "str", "maxLength", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getFilterLength(String str, int maxLength) {
            return SpenTextFilter.native_getFilterLength(str, maxLength);
        }

        private Companion() {
        }
    }

    public SpenTextFilter(@Nullable Context context, int i, @Nullable View view) {
        this.mContext = context;
        this.limitLength = i;
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getFilterLength(String str, int i);

    public final void close() {
        this.mContext = null;
    }

    @Override // android.text.InputFilter
    @Nullable
    public CharSequence filter(@Nullable CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (this.mContext == null || source == null) {
            return null;
        }
        int i = this.limitLength;
        if (i == -1) {
            return source.subSequence(start, end);
        }
        CharSequence charSequenceFilterLength = filterLength(i, source, start, end, dest, dstart, dend);
        if (charSequenceFilterLength != null) {
            if (charSequenceFilterLength.length() == 0 && this.mView != null) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                Object systemService = context.getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).restartInput(this.mView);
            }
            SpenTextLimitListener spenTextLimitListener = this.mTextLimitListener;
            if (spenTextLimitListener != null) {
                spenTextLimitListener.onExceedTextLimit(this.limitLength);
            }
        }
        if (!this.mIsTextInputBlock) {
            return charSequenceFilterLength;
        }
        Log.i(TAG, "filter() - text input blocked.");
        return dest.subSequence(dstart, dend);
    }

    @Nullable
    public final CharSequence filterLength(int maxLength, @NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (dest.length() <= maxLength && start == end) {
            return null;
        }
        int length = maxLength - (dest.length() - (dend - dstart));
        if (length <= 0) {
            return "";
        }
        if (length >= end - start) {
            return null;
        }
        return source.subSequence(start, INSTANCE.native_getFilterLength(source.subSequence(start, end).toString(), length) + start);
    }

    public final int getLimitLength() {
        return this.limitLength;
    }

    public final void setLimitLength(int i) {
        this.limitLength = i;
    }

    public final void setTextInputBlock(boolean setBlock) {
        this.mIsTextInputBlock = setBlock;
    }

    public final void setTextLimitListener(@Nullable SpenTextLimitListener listener) {
        this.mTextLimitListener = listener;
    }
}
