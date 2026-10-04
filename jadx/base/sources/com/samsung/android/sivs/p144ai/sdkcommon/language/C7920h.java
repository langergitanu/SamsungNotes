package com.samsung.android.sivs.p144ai.sdkcommon.language;

import android.os.Parcel;
import com.samsung.android.sivs.p144ai.sdkcommon.language.IWritingComposerService;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: com.samsung.android.sivs.ai.sdkcommon.language.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7920h implements BiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5423a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Parcel f5424b;

    public /* synthetic */ C7920h(Parcel parcel, int i) {
        this.f5423a = i;
        this.f5424b = parcel;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f5423a) {
            case 0:
                IWritingComposerService.Stub.Proxy.lambda$compose$0(this.f5424b, str, str2);
                break;
            case 1:
                IWritingComposerService.Stub.Proxy.lambda$compose$1(this.f5424b, str, str2);
                break;
            case 2:
                IWritingComposerService.Stub.Proxy.lambda$compose2$4(this.f5424b, str, str2);
                break;
            default:
                IWritingComposerService.Stub.Proxy.lambda$compose2$5(this.f5424b, str, str2);
                break;
        }
    }
}
