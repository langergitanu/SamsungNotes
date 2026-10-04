package com.samsung.android.app.sdk.deepsky.suggestion.view;

import java.util.concurrent.Flow;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.suggestion.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC7038a {
    /* JADX INFO: renamed from: A */
    public static /* bridge */ /* synthetic */ boolean m5394A(Publisher publisher) {
        return publisher instanceof Flow.Publisher;
    }

    /* JADX INFO: renamed from: B */
    public static /* bridge */ /* synthetic */ boolean m5395B(Subscriber subscriber) {
        return subscriber instanceof Flow.Subscriber;
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ Flow.Processor m5404g(Processor processor) {
        return (Flow.Processor) processor;
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ Flow.Publisher m5405h(Publisher publisher) {
        return (Flow.Publisher) publisher;
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ Flow.Subscriber m5406i(Subscriber subscriber) {
        return (Flow.Subscriber) subscriber;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ void m5407j() {
    }

    /* JADX INFO: renamed from: z */
    public static /* bridge */ /* synthetic */ boolean m5423z(Processor processor) {
        return processor instanceof Flow.Processor;
    }
}
