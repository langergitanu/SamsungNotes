package com.samsung.android.support.senl.addons.executor;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/BrushExecuteIntentBuilder;", "Lcom/samsung/android/support/senl/addons/executor/AbsExecuteIntentBuilder;", "Lcom/samsung/android/support/senl/addons/executor/IBrushExecuteIntentBuilder;", "<init>", "()V", "mInputThumbnailPath", "", "mInputPaintingDocPath", "mOutputThumbnailPath", "mOutputPaintingDocPath", "mInternalPath", "mCloseRequested", "", "mCloseAfterSaveRequested", "setInputThumbnailPath", "inputThumbnailPath", "setInputPaintingDocPath", "inputPaintingDocPath", "setInternalPath", "path", "setOutputThumbnailPath", "outputThumbnailPath", "setOutputPaintingDocPath", "outputPaintingDocPath", "setCloseCommand", "save", "build", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "setExternalIntent", MarketingConstants.LINK_TYPE_INTENT, "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushExecuteIntentBuilder extends AbsExecuteIntentBuilder implements IBrushExecuteIntentBuilder {

    @NotNull
    private static final String EXTERNAL_PACKAGE = "com.samsung.android.app.notes.addons";

    @NotNull
    private static final String STRING_BRUSH_CLASS = "com.samsung.android.app.notes.tools.BrushActivity";
    private boolean mCloseAfterSaveRequested;
    private boolean mCloseRequested;

    @Nullable
    private String mInputPaintingDocPath;

    @Nullable
    private String mInputThumbnailPath;

    @Nullable
    private String mInternalPath;

    @Nullable
    private String mOutputPaintingDocPath;

    @Nullable
    private String mOutputThumbnailPath;

    @NotNull
    private static final String TAG = Logger.createTag("BrushExecuteIntentBuilder");

    private final Intent setExternalIntent(Context context, Intent intent) {
        String str = TAG;
        Logger.m7100d(str, "setExternalIntent");
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        if (!companion.getInstance().isPackageInstalled(context, "com.samsung.android.app.notes.addons")) {
            Logger.m7105w(str, "setExternalIntent, external addon is not installed!");
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.samsung.android.app.notes.addons"));
        }
        if (companion.getInstance().isPackageEnabled(context, "com.samsung.android.app.notes.addons")) {
            intent.setComponent(new ComponentName("com.samsung.android.app.notes.addons", STRING_BRUSH_CLASS));
            return intent;
        }
        Logger.m7105w(str, "setExternalIntent, external addon is not enabled!");
        return new Intent();
    }

    @Override // com.samsung.android.support.senl.addons.executor.AbsExecuteIntentBuilder, com.samsung.android.support.senl.addons.executor.IExecuteIntentBuilder
    @NotNull
    public Intent build(@Nullable Context context) {
        Intent intentBuild = super.build(context);
        intentBuild.putExtra("brush_input_thumbnail_path", this.mInputThumbnailPath);
        intentBuild.putExtra("brush_input_painting_doc_path", this.mInputPaintingDocPath);
        intentBuild.putExtra("brush_output_thumbnail_path", this.mOutputThumbnailPath);
        intentBuild.putExtra("brush_output_painting_doc_path", this.mOutputPaintingDocPath);
        intentBuild.putExtra("internal_path", this.mInternalPath);
        intentBuild.putExtra("tool_force_finish", this.mCloseRequested);
        intentBuild.putExtra("tool_force_finish_with_save", this.mCloseAfterSaveRequested);
        if (context != null) {
            intentBuild.setComponent(new ComponentName(context.getPackageName(), STRING_BRUSH_CLASS));
        }
        Logger.m7100d(TAG, "build " + intentBuild);
        return intentBuild;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setCloseCommand(boolean save) {
        this.mCloseRequested = true;
        this.mCloseAfterSaveRequested = save;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setInputPaintingDocPath(@Nullable String inputPaintingDocPath) {
        this.mInputPaintingDocPath = inputPaintingDocPath;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setInputThumbnailPath(@Nullable String inputThumbnailPath) {
        this.mInputThumbnailPath = inputThumbnailPath;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setInternalPath(@Nullable String path) {
        this.mInternalPath = path;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setOutputPaintingDocPath(@Nullable String outputPaintingDocPath) {
        this.mOutputPaintingDocPath = outputPaintingDocPath;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IBrushExecuteIntentBuilder
    @NotNull
    public IBrushExecuteIntentBuilder setOutputThumbnailPath(@Nullable String outputThumbnailPath) {
        this.mOutputThumbnailPath = outputThumbnailPath;
        return this;
    }
}
