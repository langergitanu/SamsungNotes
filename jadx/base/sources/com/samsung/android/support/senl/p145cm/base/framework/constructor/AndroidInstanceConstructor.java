package com.samsung.android.support.senl.p145cm.base.framework.constructor;

import android.animation.AnimatorSet;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/constructor/AndroidInstanceConstructor;", "", "<init>", "()V", "makeBundle", "Landroid/os/Bundle;", "makeBitmapFactoryOptions", "Landroid/graphics/BitmapFactory$Options;", "makeDisplayMetrics", "Landroid/util/DisplayMetrics;", "makeRectF", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "makeAnimatorSet", "Landroid/animation/AnimatorSet;", "makeJsonObject", "Lorg/json/JSONObject;", "json", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AndroidInstanceConstructor {

    @NotNull
    public static final AndroidInstanceConstructor INSTANCE = new AndroidInstanceConstructor();

    private AndroidInstanceConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final AnimatorSet makeAnimatorSet() {
        return new AnimatorSet();
    }

    @JvmStatic
    @NotNull
    public static final BitmapFactory.Options makeBitmapFactoryOptions() {
        return new BitmapFactory.Options();
    }

    @JvmStatic
    @NotNull
    public static final Bundle makeBundle() {
        return new Bundle();
    }

    @JvmStatic
    @NotNull
    public static final DisplayMetrics makeDisplayMetrics() {
        return new DisplayMetrics();
    }

    @JvmStatic
    @NotNull
    public static final JSONObject makeJsonObject(@Nullable String json) {
        if (TextUtils.isEmpty(json)) {
            return new JSONObject();
        }
        Intrinsics.checkNotNull(json);
        return new JSONObject(json);
    }

    @JvmStatic
    @NotNull
    public static final RectF makeRectF(float left, float top, float right, float bottom) {
        return new RectF(left, top, right, bottom);
    }
}
