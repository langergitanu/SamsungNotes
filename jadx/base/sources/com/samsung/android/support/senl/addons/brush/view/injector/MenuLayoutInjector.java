package com.samsung.android.support.senl.addons.brush.view.injector;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/injector/MenuLayoutInjector;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "radius", "", "getRadius", "()I", "setRadius", "(I)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "strokeSize", "getStrokeSize", "setStrokeSize", "strokeColor", "getStrokeColor", "setStrokeColor", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuLayoutInjector {
    private int backgroundColor;
    private int radius;
    private int strokeColor;
    private int strokeSize;

    public MenuLayoutInjector(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (TabletUtil.isTabletUi()) {
            this.radius = resources.getDimensionPixelSize(C7944R.dimen.brush_menu_radius_tablet);
            this.backgroundColor = resources.getColor(C7944R.color.brush_menu_bg_color_tablet, null);
            this.strokeSize = resources.getDimensionPixelSize(C7944R.dimen.brush_menu_stroke_size);
            this.strokeColor = resources.getColor(C7944R.color.brush_menu_stroke_color, null);
            return;
        }
        this.radius = resources.getDimensionPixelSize(C7944R.dimen.brush_menu_radius);
        this.backgroundColor = resources.getColor(C7944R.color.brush_menu_bg_color, null);
        this.strokeSize = resources.getDimensionPixelSize(C7944R.dimen.brush_menu_stroke_size);
        this.strokeColor = resources.getColor(C7944R.color.brush_menu_stroke_color, null);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeSize() {
        return this.strokeSize;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setRadius(int i) {
        this.radius = i;
    }

    public final void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public final void setStrokeSize(int i) {
        this.strokeSize = i;
    }
}
