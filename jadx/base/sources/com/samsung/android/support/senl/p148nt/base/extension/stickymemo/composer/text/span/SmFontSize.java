package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span;

import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/span/SmFontSize;", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontSize;", "prefName", "", "prefKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "setSizeDelta", "", "delta", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmFontSize extends FontSize {
    public SmFontSize(@Nullable String str, @Nullable String str2) {
        super(str, str2, 0);
    }

    public final void setSizeDelta(int delta) {
        this.deltaSize = delta;
    }
}
