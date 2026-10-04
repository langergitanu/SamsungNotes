package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/StaticalModelInitializer;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "initialize", "", "context", "Landroid/content/Context;", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StaticalModelInitializer {

    @NotNull
    public static final StaticalModelInitializer INSTANCE = new StaticalModelInitializer();

    @NotNull
    private static final String TAG = SOLogger.createTag("StaticalModelInitializer");

    private StaticalModelInitializer() {
    }

    public final void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SOLogger.INSTANCE.SOLoggerD(TAG, "initialize#");
        NotifyExecutionModel notifyExecutionModel = NotifyExecutionModel.INSTANCE;
        if (!notifyExecutionModel.isPreInitialized()) {
            notifyExecutionModel.init();
        }
        ConfigurationModel configurationModel = ConfigurationModel.INSTANCE;
        if (!configurationModel.isPreInitialized()) {
            configurationModel.init(context);
        }
        PenPairedColorModel penPairedColorModel = PenPairedColorModel.INSTANCE;
        if (!penPairedColorModel.isPreInitialized()) {
            penPairedColorModel.init(context);
        }
        PenConvertingColorModel penConvertingColorModel = PenConvertingColorModel.INSTANCE;
        if (!penConvertingColorModel.isPreInitialized()) {
            penConvertingColorModel.init();
        }
        PenColorPaletteModel penColorPaletteModel = PenColorPaletteModel.INSTANCE;
        if (!penColorPaletteModel.isPreInitialized()) {
            penColorPaletteModel.init(context);
        }
        PenInfoModel penInfoModel = PenInfoModel.INSTANCE;
        if (!penInfoModel.isPreInitialized()) {
            penInfoModel.init(context);
        }
        LottieAnimationModel lottieAnimationModel = LottieAnimationModel.INSTANCE;
        if (lottieAnimationModel.isPreInitialized()) {
            return;
        }
        lottieAnimationModel.init(context);
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        NotifyExecutionModel.INSTANCE.release();
        ConfigurationModel.INSTANCE.release();
        PenPairedColorModel.INSTANCE.release();
        PenConvertingColorModel.INSTANCE.release();
        PenColorPaletteModel.INSTANCE.release();
        PenInfoModel.INSTANCE.release();
        LottieAnimationModel.INSTANCE.release();
    }
}
