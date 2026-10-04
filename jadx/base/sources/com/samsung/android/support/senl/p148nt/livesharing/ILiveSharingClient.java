package com.samsung.android.support.senl.p148nt.livesharing;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public interface ILiveSharingClient {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback<R> {
        public static final String ERR_NO_RESULT = "no result";

        void onFailure(@NonNull Throwable th);

        void onSuccess(R r);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ErrorState {
        NONE,
        ALREADY_CONNECTED,
        NOT_CONNECTED,
        ALREADY_CO_DOING,
        NOT_CO_DOING,
        OVER_SIZE_DATA
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StateChangeListener {
        void onStateChanged(LiveSharingData liveSharingData);
    }
}
