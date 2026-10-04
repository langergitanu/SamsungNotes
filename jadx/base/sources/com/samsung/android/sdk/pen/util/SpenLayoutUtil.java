package com.samsung.android.sdk.pen.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenLayoutUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSdkResources", "Landroid/content/res/Resources;", "mInflater", "Landroid/view/LayoutInflater;", "getLayout", "Landroid/view/View;", "layoutName", "", "getLayoutID", "", "getDimension", "", "dimensionName", "getDimensionPixelSize", "getInteger", "integerName", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenLayoutUtil {

    @NotNull
    private static final String TAG = "SpenUtilLayout";

    @NotNull
    private final LayoutInflater mInflater;

    @NotNull
    private final Resources mSdkResources;

    public SpenLayoutUtil(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.mSdkResources = resources;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.mInflater = (LayoutInflater) systemService;
    }

    public final float getDimension(@Nullable String dimensionName) {
        try {
            return this.mSdkResources.getDimension(this.mSdkResources.getIdentifier(dimensionName, AbsExecuteBinding.TYPE_DIMEN, Spen.INSTANCE.getSpenPackageName()));
        } catch (Exception e) {
            Log.e(TAG, "getDimension() - Exception is occurred with dimension value = " + dimensionName);
            e.printStackTrace();
            return 0.0f;
        }
    }

    public final int getDimensionPixelSize(@Nullable String dimensionName) {
        try {
            return this.mSdkResources.getDimensionPixelSize(this.mSdkResources.getIdentifier(dimensionName, AbsExecuteBinding.TYPE_DIMEN, Spen.INSTANCE.getSpenPackageName()));
        } catch (Exception e) {
            Log.e(TAG, "getDimensionPixelSize() - Exception is occurred with dimension value = " + dimensionName);
            e.printStackTrace();
            return 0;
        }
    }

    public final int getInteger(@Nullable String integerName) {
        try {
            return this.mSdkResources.getInteger(this.mSdkResources.getIdentifier(integerName, "integer", Spen.INSTANCE.getSpenPackageName()));
        } catch (Exception e) {
            Log.e(TAG, "getInteger() - Exception is occurred with integer value = " + integerName);
            e.printStackTrace();
            return 0;
        }
    }

    @Nullable
    public final View getLayout(@Nullable String layoutName) {
        int identifier = this.mSdkResources.getIdentifier(layoutName, DBSchema.DocumentThumbnail.LAYOUT, Spen.INSTANCE.getSpenPackageName());
        Log.d(TAG, "getLayout : layoutName = " + layoutName + " : resID = " + identifier);
        return this.mInflater.inflate(this.mSdkResources.getLayout(identifier), (ViewGroup) null);
    }

    public final int getLayoutID(@Nullable String layoutName) {
        AbstractC2322a.m1609C("getLayoutID : layoutName = ", layoutName, TAG);
        return this.mSdkResources.getIdentifier(layoutName, DBSchema.DocumentThumbnail.LAYOUT, Spen.INSTANCE.getSpenPackageName());
    }
}
