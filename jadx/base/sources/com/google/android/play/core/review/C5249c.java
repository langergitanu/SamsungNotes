package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;

/* JADX INFO: renamed from: com.google.android.play.core.review.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C5249c implements ReviewManager {

    /* JADX INFO: renamed from: a */
    private final C5254h f3013a;

    /* JADX INFO: renamed from: b */
    private final Handler f3014b = new Handler(Looper.getMainLooper());

    public C5249c(C5254h c5254h) {
        this.f3013a = c5254h;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public final Task<Void> launchReviewFlow(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo4050a());
        C5345i c5345i = new C5345i();
        intent.putExtra("result_receiver", new ResultReceiverC5248b(this.f3014b, c5345i));
        activity.startActivity(intent);
        return c5345i.m4197a();
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f3013a.m4053a();
    }
}
