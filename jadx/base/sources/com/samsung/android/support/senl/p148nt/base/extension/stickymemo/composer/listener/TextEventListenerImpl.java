package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/TextEventListenerImpl;", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$TextEventListener;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;)V", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "onExceedTextLimit", "", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "length", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextEventListenerImpl extends SpenTextLimitListener implements SpenWNote.TextEventListener {

    @NotNull
    private final SmTextManager textManager;

    public TextEventListenerImpl(@NotNull SmTextManager textManager) {
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        this.textManager = textManager;
    }

    @NotNull
    public final SmTextManager getTextManager() {
        return this.textManager;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.TextEventListener
    public void onExceedTextLimit(@Nullable SpenWPage page, @Nullable SpenObjectShape obj, int length) {
        onExceedTextLimit(length);
    }

    @Override // com.samsung.android.sdk.pen.text.SpenTextLimitListener
    public void onExceedTextLimit(int length) {
        this.textManager.showExceedToast();
    }
}
