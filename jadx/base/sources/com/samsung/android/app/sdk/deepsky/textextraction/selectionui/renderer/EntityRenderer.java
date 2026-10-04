package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.UnderlineDrawInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.TextExtractionMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ&\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/EntityRenderer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isUnderlineVisible", "", "()Z", "setUnderlineVisible", "(Z)V", "underlineDrawInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/UnderlineDrawInfo;", "underlinePaint", "Landroid/graphics/Paint;", "drawEntities", "", "canvas", "Landroid/graphics/Canvas;", "textExtractionMode", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/util/TextExtractionMode;", "drawUnderlines", "updateEntityDrawInfo", "result", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ratio", "", "centerOffset", "Landroid/graphics/Point;", "updateUnderlineDrawInfoList", "entityInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$EntityInfo;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityRenderer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/EntityRenderer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1855#2,2:74\n*S KotlinDebug\n*F\n+ 1 EntityRenderer.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/renderer/EntityRenderer\n*L\n38#1:74,2\n*E\n"})
public final class EntityRenderer {

    @NotNull
    private static final List<EntityType> ENTITY_TYPE_ALLOWLIST = CollectionsKt.listOf((Object[]) new EntityType[]{EntityType.PHONE, EntityType.EMAIL, EntityType.URL, EntityType.UNIT});

    @NotNull
    private static final String TAG = "EntityRenderer";

    @NotNull
    private final Context context;
    private boolean isUnderlineVisible;

    @NotNull
    private final List<UnderlineDrawInfo> underlineDrawInfoList;

    @NotNull
    private final Paint underlinePaint;

    public EntityRenderer(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.underlineDrawInfoList = new ArrayList();
        this.isUnderlineVisible = true;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setColor(context.getColor(C7039R.color.textextraction_entity_underline_color));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(C7039R.dimen.textextraction_entity_underline_width));
        this.underlinePaint = paint;
    }

    private final void drawUnderlines(Canvas canvas) {
        Iterator<T> it = this.underlineDrawInfoList.iterator();
        while (it.hasNext()) {
            ((UnderlineDrawInfo) it.next()).draw(canvas, this.underlinePaint);
        }
    }

    private final void updateUnderlineDrawInfoList(List<OcrResult.EntityInfo> entityInfoList, float ratio, Point centerOffset) {
        this.underlineDrawInfoList.clear();
        for (OcrResult.EntityInfo entityInfo : entityInfoList) {
            if (ENTITY_TYPE_ALLOWLIST.contains(EntityType.INSTANCE.toEntityType(entityInfo.getType()))) {
                for (OcrResult.UnderlineInfo underlineInfo : entityInfo.getUnderlines()) {
                    UnderlineDrawInfo underlineDrawInfo = new UnderlineDrawInfo(entityInfo.getType(), underlineInfo);
                    underlineDrawInfo.getStart().x = (underlineDrawInfo.getStart().x * ratio) + centerOffset.x + 0.5f;
                    underlineDrawInfo.getStart().y = (underlineDrawInfo.getStart().y * ratio) + centerOffset.y + 0.5f;
                    underlineDrawInfo.getStop().x = (underlineDrawInfo.getStop().x * ratio) + centerOffset.x + 0.5f;
                    underlineDrawInfo.getStop().y = (underlineDrawInfo.getStop().y * ratio) + centerOffset.y + 0.5f;
                    this.underlineDrawInfoList.add(underlineDrawInfo);
                }
            }
        }
    }

    public final void drawEntities(@NotNull Canvas canvas, @NotNull TextExtractionMode textExtractionMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textExtractionMode, "textExtractionMode");
        if (this.isUnderlineVisible && textExtractionMode == TextExtractionMode.T_BUTTON_PRESS) {
            drawUnderlines(canvas);
        }
    }

    /* JADX INFO: renamed from: isUnderlineVisible, reason: from getter */
    public final boolean getIsUnderlineVisible() {
        return this.isUnderlineVisible;
    }

    public final void setUnderlineVisible(boolean z) {
        this.isUnderlineVisible = z;
    }

    public final void updateEntityDrawInfo(@NotNull OcrResult result, float ratio, @NotNull Point centerOffset) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(centerOffset, "centerOffset");
        updateUnderlineDrawInfoList(result.getEntityInfoList(), ratio, centerOffset);
    }
}
