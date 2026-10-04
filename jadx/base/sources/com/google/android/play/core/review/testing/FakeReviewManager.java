package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* JADX INFO: loaded from: classes5.dex */
public class FakeReviewManager implements ReviewManager {

    /* JADX INFO: renamed from: a */
    private final Context f3024a;

    /* JADX INFO: renamed from: b */
    private ReviewInfo f3025b;

    public FakeReviewManager(Context context) {
        this.f3024a = context;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public Task<Void> launchReviewFlow(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        return reviewInfo != this.f3025b ? Tasks.m4184a((Exception) new C5255a()) : Tasks.m4185a((Object) null);
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo reviewInfoM4049a = ReviewInfo.m4049a(PendingIntent.getBroadcast(this.f3024a, 0, new Intent(), 0));
        this.f3025b = reviewInfoM4049a;
        return Tasks.m4185a(reviewInfoM4049a);
    }
}
