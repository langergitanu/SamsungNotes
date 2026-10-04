package androidx.appsearch.app;

import android.util.Log;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class AppSearchResult<ValueType> {

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_RESULT_ALREADY_EXISTS)
    public static final int RESULT_ALREADY_EXISTS = 12;

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_RESULT_DENIED_AND_RESULT_RATE_LIMITED)
    public static final int RESULT_DENIED = 9;
    public static final int RESULT_INTERNAL_ERROR = 2;
    public static final int RESULT_INVALID_ARGUMENT = 3;
    public static final int RESULT_INVALID_SCHEMA = 7;
    public static final int RESULT_IO_ERROR = 4;
    public static final int RESULT_NOT_FOUND = 6;
    public static final int RESULT_OK = 0;
    public static final int RESULT_OUT_OF_SPACE = 5;

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_RESULT_DENIED_AND_RESULT_RATE_LIMITED)
    public static final int RESULT_RATE_LIMITED = 10;
    public static final int RESULT_SECURITY_ERROR = 8;

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_APP_FUNCTIONS)
    public static final int RESULT_TIMED_OUT = 11;
    public static final int RESULT_UNKNOWN_ERROR = 1;
    private static final String TAG = "AppSearchResult";
    private final String mErrorMessage;
    private final int mResultCode;
    private final ValueType mResultValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ResultCode {
    }

    private AppSearchResult(int i, ValueType valuetype, String str) {
        this.mResultCode = i;
        this.mResultValue = valuetype;
        this.mErrorMessage = str;
    }

    public static <ValueType> AppSearchResult<ValueType> newFailedResult(int i, String str) {
        return new AppSearchResult<>(i, null, str);
    }

    public static <ValueType> AppSearchResult<ValueType> newSuccessfulResult(ValueType valuetype) {
        return new AppSearchResult<>(0, valuetype, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <ValueType> AppSearchResult<ValueType> throwableToFailedResult(Throwable th) {
        boolean z = th instanceof AppSearchException;
        if (!z || ((AppSearchException) th).getResultCode() != 6) {
            Log.w(TAG, "Converting throwable to failed result.", th);
        }
        if (z) {
            return ((AppSearchException) th).toAppSearchResult();
        }
        String simpleName = th.getClass().getSimpleName();
        int i = ((th instanceof IllegalStateException) || (th instanceof NullPointerException)) ? 2 : th instanceof IllegalArgumentException ? 3 : th instanceof IOException ? 4 : th instanceof SecurityException ? 8 : 1;
        StringBuilder sbM781w = AbstractC0541b.m781w(simpleName, ": ");
        sbM781w.append(th.getMessage());
        return newFailedResult(i, sbM781w.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSearchResult)) {
            return false;
        }
        AppSearchResult appSearchResult = (AppSearchResult) obj;
        return this.mResultCode == appSearchResult.mResultCode && ObjectsCompat.equals(this.mResultValue, appSearchResult.mResultValue) && ObjectsCompat.equals(this.mErrorMessage, appSearchResult.mErrorMessage);
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public ValueType getResultValue() {
        if (isSuccess()) {
            return this.mResultValue;
        }
        throw new IllegalStateException("AppSearchResult is a failure: " + this);
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mResultCode), this.mResultValue, this.mErrorMessage);
    }

    public boolean isSuccess() {
        return getResultCode() == 0;
    }

    public String toString() {
        if (isSuccess()) {
            return "[SUCCESS]: " + this.mResultValue;
        }
        return "[FAILURE(" + this.mResultCode + ")]: " + this.mErrorMessage;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <ValueType> AppSearchResult<ValueType> newFailedResult(AppSearchResult<?> appSearchResult) {
        Preconditions.checkState(!appSearchResult.isSuccess(), "Cannot convert a success result to a failed result");
        return newFailedResult(appSearchResult.getResultCode(), appSearchResult.getErrorMessage());
    }
}
