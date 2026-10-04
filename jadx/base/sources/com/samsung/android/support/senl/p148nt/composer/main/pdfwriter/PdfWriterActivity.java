package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter;

import android.app.assist.AssistContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.IPwInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.PwFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/pdfwriter/PdfWriterActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/BaseComposerActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/pdfwriter/lifecycle/IPwInfo;", "<init>", "()V", "createFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "onProvideAssistContent", "", "outContent", "Landroid/app/assist/AssistContent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PdfWriterActivity extends BaseComposerActivity implements IPwInfo {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.BaseComposerActivity
    @NotNull
    public BaseComposerFragment createFragment() {
        return new PwFragment();
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(@NotNull AssistContent outContent) {
        Intrinsics.checkNotNullParameter(outContent, "outContent");
        super.onProvideAssistContent(outContent);
        BaseComposerFragment baseComposerFragment = getBaseComposerFragment();
        if (baseComposerFragment != null) {
            baseComposerFragment.onProvideAssistContent(this, outContent);
        }
    }
}
