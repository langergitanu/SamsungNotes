package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/ResourceGetter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IResourceGetter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContextRef", "Ljava/lang/ref/WeakReference;", "mScreen", "Landroid/graphics/Rect;", "getColor", "", "resId", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "screenWidth", "", "getScreenWidth", "()F", "screenSize", "getScreenSize", "()Landroid/graphics/Rect;", "screenMinSize", "getScreenMinSize", "cacheDir", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResourceGetter implements IResourceGetter {

    @NotNull
    private final WeakReference<Context> mContextRef;

    @NotNull
    private final Rect mScreen = getScreenSize();

    public ResourceGetter(@Nullable Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    @Nullable
    public File getCacheDir() {
        Context context = this.mContextRef.get();
        if (context != null) {
            return context.getCacheDir();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    public int getColor(int resId) {
        Resources resources;
        Context context = this.mContextRef.get();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getColor(resId);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    @Nullable
    public DisplayMetrics getDisplayMetrics() {
        Resources resources;
        Context context = this.mContextRef.get();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getDisplayMetrics();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    public float getScreenMinSize() {
        Context context = this.mContextRef.get();
        if (context == null) {
            return 0.0f;
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRectSize(this.mScreen);
        return (float) Math.min(this.mScreen.width(), this.mScreen.height());
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    @NotNull
    public Rect getScreenSize() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter
    public float getScreenWidth() {
        return (float) Math.min(this.mScreen.width(), this.mScreen.height());
    }
}
