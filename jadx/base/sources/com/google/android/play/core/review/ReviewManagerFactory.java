package com.google.android.play.core.review;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.splitcompat.C5271p;

/* JADX INFO: loaded from: classes5.dex */
public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    @NonNull
    public static ReviewManager create(@NonNull Context context) {
        PlayCoreDialogWrapperActivity.m3854a(context);
        return new C5249c(new C5254h(C5271p.m4096a(context)));
    }
}
