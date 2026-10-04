package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ButtonBackgroundUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isShowButtonShapeEnabled", "", "context", "Landroid/content/Context;", "setBackground", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "buttonShapeEnabledResId", "", "normalBgDrawble", "Landroid/graphics/drawable/Drawable;", "buttonShapeEnabledDrawable", "normalBgResId", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "updateMenuItemTextColor", "menuItem", "Landroid/view/MenuItem;", "color", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ButtonBackgroundUtils {

    @NotNull
    public static final ButtonBackgroundUtils INSTANCE = new ButtonBackgroundUtils();

    @NotNull
    private static final String TAG = "ButtonBackgroundUtils";

    private ButtonBackgroundUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isShowButtonShapeEnabled(@Nullable Context context) {
        Configuration configuration;
        Field field;
        Field field2;
        Integer numValueOf = null;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                configuration = resources != null ? resources.getConfiguration() : null;
            } catch (IllegalAccessException unused) {
                return SettingsCompat.INSTANCE.getInstance().isShowButtonBackground(context);
            } catch (IllegalArgumentException unused2) {
                return SettingsCompat.INSTANCE.getInstance().isShowButtonBackground(context);
            } catch (NoSuchFieldException unused3) {
                return SettingsCompat.INSTANCE.getInstance().isShowButtonBackground(context);
            }
        }
        Class<?> cls = configuration != null ? configuration.getClass() : null;
        Integer numValueOf2 = (cls == null || (field2 = cls.getField("SEM_BUTTON_SHAPE_ENABLED")) == null) ? null : Integer.valueOf(field2.getInt(cls));
        if (cls != null && (field = cls.getField("semButtonShapeEnabled")) != null) {
            numValueOf = Integer.valueOf(field.getInt(configuration));
        }
        return Intrinsics.areEqual(numValueOf2, numValueOf);
    }

    @JvmStatic
    public static final void updateMenuItemTextColor(@NotNull MenuItem menuItem, int color) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        SpannableString spannableString = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 0);
        menuItem.setTitle(spannableString);
    }

    public final void setBackground(@NotNull Context context, @NotNull View v, int buttonShapeEnabledResId, @Nullable Drawable normalBgDrawble) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v, "v");
        if (isShowButtonShapeEnabled(context)) {
            v.setBackgroundResource(buttonShapeEnabledResId);
        } else {
            v.setBackground(normalBgDrawble);
        }
    }

    public final void setBackground(@NotNull Context context, @NotNull View v, @Nullable Drawable buttonShapeEnabledDrawable, @Nullable Drawable normalBgDrawble) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v, "v");
        if (isShowButtonShapeEnabled(context)) {
            v.setBackground(buttonShapeEnabledDrawable);
        } else {
            v.setBackground(normalBgDrawble);
        }
    }

    public final void setBackground(@NotNull Context context, @NotNull View v, @Nullable Drawable buttonShapeEnabledDrawable, int normalBgResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v, "v");
        if (isShowButtonShapeEnabled(context)) {
            v.setBackground(buttonShapeEnabledDrawable);
        } else {
            v.setBackgroundResource(normalBgResId);
        }
    }

    public final void setBackground(@NotNull Context context, @NotNull View v, int buttonShapeEnabledResId, int normalBgResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v, "v");
        if (isShowButtonShapeEnabled(context)) {
            v.setBackgroundResource(buttonShapeEnabledResId);
        } else {
            v.setBackgroundResource(normalBgResId);
        }
    }

    public final void setBackground(@NotNull Context context, @NotNull AlertDialog alertDialog) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(alertDialog, "alertDialog");
        Button button = alertDialog.getButton(-1);
        Button button2 = alertDialog.getButton(-2);
        Button button3 = alertDialog.getButton(-3);
        Logger.m8697d(TAG, "onShow, , " + button + SQLKeyword.COMMA + button2 + SQLKeyword.COMMA + button3);
        if (isShowButtonShapeEnabled(context)) {
            button.setBackgroundResource(C8875R.drawable.dialog_btn_border_material);
            button2.setBackgroundResource(C8875R.drawable.dialog_btn_border_material);
            button3.setBackgroundResource(C8875R.drawable.dialog_btn_border_material);
        } else {
            button.setBackgroundResource(C8875R.drawable.dialog_btn_borderless_material);
            button2.setBackgroundResource(C8875R.drawable.dialog_btn_borderless_material);
            button3.setBackgroundResource(C8875R.drawable.dialog_btn_borderless_material);
        }
    }
}
