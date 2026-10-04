package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.adjust;

import android.content.res.Resources;
import android.graphics.Paint;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class ResourceInjector implements IResourceInjector {
    private int mBorderThickness;
    private Paint mInsideBorderPaint;
    private Paint mTrimAreaPaint;
    private Paint mTrimAreaPaintInMoving;

    public ResourceInjector(Resources resources) {
        int color = resources.getColor(C9086R.color.notes_primary_color, null);
        int color2 = resources.getColor(C9086R.color.template_editor_trim_area_transparency_70, null);
        int color3 = resources.getColor(C9086R.color.template_editor_trim_area_transparency_40, null);
        this.mBorderThickness = (int) Math.max(1.0f, resources.getDimension(C9086R.dimen.template_editor_border_thickness));
        this.mInsideBorderPaint = createBorderPaint(color);
        this.mTrimAreaPaint = createTrimAreaPaint(color2);
        this.mTrimAreaPaintInMoving = createTrimAreaPaint(color3);
    }

    private Paint createBorderPaint(int i) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mBorderThickness);
        paint.setColor(i);
        return paint;
    }

    public static Paint createTrimAreaPaint(int i) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        return paint;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector
    public int getBorderThickness() {
        return this.mBorderThickness;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector
    public Paint getInsideBorderPaint() {
        return this.mInsideBorderPaint;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector
    public Paint getTrimAreaPaint() {
        return this.mTrimAreaPaint;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector
    public Paint getTrimAreaPaintInMoving() {
        return this.mTrimAreaPaintInMoving;
    }
}
