package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.fold;

import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/fold/FoldModel;", "", "foldListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/fold/IFoldModel;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/fold/IFoldModel;)V", "mFoldListener", "mFoldStateListener", "Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FoldStateChangeListener;", "release", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FoldModel {

    @NotNull
    private static final String TAG = SOLogger.createTag("FoldModel");

    @Nullable
    private IFoldModel mFoldListener;

    @Nullable
    private FoldStateCompat.FoldStateChangeListener mFoldStateListener;

    public FoldModel(@NotNull IFoldModel foldListener) {
        Intrinsics.checkNotNullParameter(foldListener, "foldListener");
        SOLogger.INSTANCE.SOLoggerD(TAG, "FoldModel#");
        FoldStateCompat.Companion companion = FoldStateCompat.INSTANCE;
        if (companion.getInstance().getFoldType() == 1) {
            this.mFoldListener = foldListener;
            this.mFoldStateListener = new FoldStateCompat.FoldStateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.model.fold.FoldModel.1
                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FoldStateChangeListener
                public void onChanged(boolean isFolded) {
                    IFoldModel iFoldModel;
                    AbstractC8014b.m7211m("onFoldStateChanged# ", isFolded, SOLogger.INSTANCE, FoldModel.TAG);
                    if (!isFolded || (iFoldModel = FoldModel.this.mFoldListener) == null) {
                        return;
                    }
                    iFoldModel.onFolded();
                }
            };
            companion.getInstance().registerFoldStateListener(this.mFoldStateListener);
        }
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        FoldStateCompat.Companion companion = FoldStateCompat.INSTANCE;
        if (companion.getInstance().getFoldType() != 1 || this.mFoldStateListener == null) {
            return;
        }
        companion.getInstance().unregisterFoldStateListener(this.mFoldStateListener);
        this.mFoldStateListener = null;
    }
}
