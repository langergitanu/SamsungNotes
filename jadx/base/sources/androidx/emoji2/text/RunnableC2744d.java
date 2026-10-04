package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

/* JADX INFO: renamed from: androidx.emoji2.text.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2744d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1496a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f1497b;

    public /* synthetic */ RunnableC2744d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader, int i) {
        this.f1496a = i;
        this.f1497b = fontRequestMetadataLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1496a) {
            case 0:
                this.f1497b.createMetadata();
                break;
            default:
                this.f1497b.loadInternal();
                break;
        }
    }
}
