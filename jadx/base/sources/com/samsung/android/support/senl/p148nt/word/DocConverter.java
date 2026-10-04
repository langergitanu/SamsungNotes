package com.samsung.android.support.senl.p148nt.word;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper;
import com.samsung.android.support.senl.p148nt.word.powerpoint.PowerPointController;
import com.samsung.android.support.senl.p148nt.word.word.WordController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J0\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/DocConverter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/share/DocConverterHelper;", "<init>", "()V", "mPowerPointController", "Lcom/samsung/android/support/senl/nt/word/powerpoint/PowerPointController;", "mWordController", "Lcom/samsung/android/support/senl/nt/word/word/WordController;", "setPowerPointController", "", "powerPointController", "setWordController", "wordController", "isActivated", "", "wdocToWord", "", "context", "Landroid/content/Context;", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "notePath", "fileName", "shareDir", "wdocToPPT", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocConverter extends DocConverterHelper {

    @Nullable
    private PowerPointController mPowerPointController;

    @Nullable
    private WordController mWordController;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper
    public boolean isActivated() {
        return true;
    }

    public final void setPowerPointController(@Nullable PowerPointController powerPointController) {
        this.mPowerPointController = powerPointController;
    }

    public final void setWordController(@Nullable WordController wordController) {
        this.mWordController = wordController;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper
    @NotNull
    public String wdocToPPT(@NotNull Context context, @NotNull SpenWNote spenWNote, @NotNull String notePath, @NotNull String fileName, @NotNull String shareDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(notePath, "notePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(shareDir, "shareDir");
        PowerPointController powerPointController = this.mPowerPointController;
        if (powerPointController == null) {
            return "";
        }
        Intrinsics.checkNotNull(powerPointController);
        return powerPointController.wdocToOffice(context, spenWNote, notePath, fileName, shareDir);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper
    @NotNull
    public String wdocToWord(@NotNull Context context, @NotNull SpenWNote spenWNote, @NotNull String notePath, @NotNull String fileName, @NotNull String shareDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(notePath, "notePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(shareDir, "shareDir");
        WordController wordController = this.mWordController;
        if (wordController == null) {
            return "";
        }
        Intrinsics.checkNotNull(wordController);
        return wordController.wdocToOffice(context, spenWNote, notePath, fileName, shareDir);
    }
}
