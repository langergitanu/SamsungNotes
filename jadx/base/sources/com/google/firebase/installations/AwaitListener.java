package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class AwaitListener implements OnCompleteListener<Void> {
    private final CountDownLatch latch = new CountDownLatch(1);

    public boolean await(long j, TimeUnit timeUnit) {
        return this.latch.await(j, timeUnit);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(@NonNull Task<Void> task) {
        this.latch.countDown();
    }

    public void onSuccess() {
        this.latch.countDown();
    }
}
