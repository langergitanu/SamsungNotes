package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/ResourceGetter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContextRef", "Ljava/lang/ref/WeakReference;", "getColor", "", "resId", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "hWSelectableTextSize", "", "", "getHWSelectableTextSize", "()[Ljava/lang/String;", "defaultTextSizeDeltaByDevice", "", "getDefaultTextSizeDeltaByDevice", "()F", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResourceGetter implements IResourceGetter {

    @NotNull
    private final WeakReference<Context> mContextRef;

    public ResourceGetter(@Nullable Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter
    public int getColor(int resId) {
        Resources resources;
        Context context = this.mContextRef.get();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getColor(resId);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter
    public float getDefaultTextSizeDeltaByDevice() {
        if (this.mContextRef.get() != null) {
            return SpenNoteTextManager.INSTANCE.getDefaultTextSizeDeltaByDevice(r0);
        }
        return 0.0f;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter
    @Nullable
    public DisplayMetrics getDisplayMetrics() {
        Context context;
        Resources resources;
        if (this.mContextRef.get() == null || (context = this.mContextRef.get()) == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getDisplayMetrics();
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter
    @Nullable
    public String[] getHWSelectableTextSize() {
        Resources resources;
        Context context = this.mContextRef.get();
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getStringArray(C7968R.array.rich_text_hw_font_size);
    }
}
