package com.google.android.play.core.internal;

import androidx.annotation.Nullable;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ag */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractRunnableC5158ag implements Runnable {

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C5345i<?> f2934a;

    public AbstractRunnableC5158ag() {
        this.f2934a = null;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3595a();

    @Nullable
    /* JADX INFO: renamed from: b */
    public final C5345i<?> m3880b() {
        return this.f2934a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            mo3595a();
        } catch (Exception e) {
            C5345i<?> c5345i = this.f2934a;
            if (c5345i != null) {
                c5345i.m4200b(e);
            }
        }
    }

    public AbstractRunnableC5158ag(@Nullable C5345i<?> c5345i) {
        this.f2934a = c5345i;
    }
}
