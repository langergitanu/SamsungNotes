package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import com.google.android.gms.common.data.AbstractC4539a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J8\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u001a\u0010\u001c\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u000b¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "", "name", "", "stringId", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getStringId", "()I", "mBodyId", "mUnselectedColorMaskId", "mSelectedColorMaskId", "mEffectId", "mHoverBodyId", "mHasAnimatedResource", "", "setResourceId", "", "body", "unSelectedColorMask", "selectedColorMask", "effect", "hoverBody", "context", "Landroid/content/Context;", "isAnimatedVectorDrawable", "resId", "setColorMaskAnimation", "animatedResource", "bodyId", "getBodyId", "getColorMaskId", "selected", "effectId", "getEffectId", "hasColorMaskAnimation", "hoverBodyId", "getHoverBodyId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingPenResource {

    @NotNull
    private static final String TAG = "SpenSettingPenResource";
    private int mBodyId;
    private int mEffectId;
    private boolean mHasAnimatedResource;
    private int mHoverBodyId;
    private int mSelectedColorMaskId;
    private int mUnselectedColorMaskId;

    @NotNull
    private final String name;
    private final int stringId;

    public SpenSettingPenResource(@NotNull String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.stringId = i;
        setResourceId(0, 0, 0, 0);
    }

    private final boolean isAnimatedVectorDrawable(Context context, int resId) {
        if (resId == 0 || context == null) {
            return false;
        }
        return context.getDrawable(resId) instanceof AnimatedVectorDrawable;
    }

    /* JADX INFO: renamed from: getBodyId, reason: from getter */
    public final int getMBodyId() {
        return this.mBodyId;
    }

    public final int getColorMaskId(boolean selected) {
        return selected ? this.mSelectedColorMaskId : this.mUnselectedColorMaskId;
    }

    /* JADX INFO: renamed from: getEffectId, reason: from getter */
    public final int getMEffectId() {
        return this.mEffectId;
    }

    /* JADX INFO: renamed from: getHoverBodyId, reason: from getter */
    public final int getMHoverBodyId() {
        return this.mHoverBodyId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getStringId() {
        return this.stringId;
    }

    /* JADX INFO: renamed from: hasColorMaskAnimation, reason: from getter */
    public final boolean getMHasAnimatedResource() {
        return this.mHasAnimatedResource;
    }

    public final void setColorMaskAnimation(boolean animatedResource) {
        AbstractC4539a.m3208r("setColorMaskAnimation() animatedResource=", TAG, animatedResource);
        this.mHasAnimatedResource = animatedResource;
    }

    public final void setResourceId(int body, int unSelectedColorMask, int selectedColorMask, int effect) {
        setResourceId(body, unSelectedColorMask, selectedColorMask, effect, 0);
    }

    private final void setResourceId(int body, int unSelectedColorMask, int selectedColorMask, int effect, int hoverBody) {
        this.mBodyId = body;
        this.mUnselectedColorMaskId = unSelectedColorMask;
        this.mSelectedColorMaskId = selectedColorMask;
        this.mEffectId = effect;
        this.mHasAnimatedResource = false;
        this.mHoverBodyId = hoverBody;
    }

    public final void setResourceId(@Nullable Context context, int body, int unSelectedColorMask, int selectedColorMask, int effect, int hoverBody) {
        setResourceId(body, unSelectedColorMask, selectedColorMask, effect, hoverBody);
        this.mHasAnimatedResource = isAnimatedVectorDrawable(context, unSelectedColorMask) && isAnimatedVectorDrawable(context, selectedColorMask);
    }
}
