package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import android.app.RemoteAction;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u000fHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityItem;", "", "type", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "text", "", "rectList", "", "Landroid/graphics/Rect;", "polyList", "", "Landroid/graphics/Point;", "underlines", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/Underline;", "score", "", "actions", "Landroid/app/RemoteAction;", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;FLjava/util/List;)V", "getActions", "()Ljava/util/List;", "getPolyList", "getRectList", "getScore", "()F", "getText", "()Ljava/lang/String;", "getType", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "getUnderlines", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class EntityItem {

    @NotNull
    private final List<RemoteAction> actions;

    @NotNull
    private final List<Point[]> polyList;

    @NotNull
    private final List<Rect> rectList;
    private final float score;

    @NotNull
    private final String text;

    @NotNull
    private final EntityType type;

    @NotNull
    private final List<Underline> underlines;

    public EntityItem(@NotNull EntityType type, @NotNull String text, @NotNull List<Rect> rectList, @NotNull List<Point[]> polyList, @NotNull List<Underline> underlines, float f, @NotNull List<RemoteAction> actions) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rectList, "rectList");
        Intrinsics.checkNotNullParameter(polyList, "polyList");
        Intrinsics.checkNotNullParameter(underlines, "underlines");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.type = type;
        this.text = text;
        this.rectList = rectList;
        this.polyList = polyList;
        this.underlines = underlines;
        this.score = f;
        this.actions = actions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityItem copy$default(EntityItem entityItem, EntityType entityType, String str, List list, List list2, List list3, float f, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            entityType = entityItem.type;
        }
        if ((i & 2) != 0) {
            str = entityItem.text;
        }
        if ((i & 4) != 0) {
            list = entityItem.rectList;
        }
        if ((i & 8) != 0) {
            list2 = entityItem.polyList;
        }
        if ((i & 16) != 0) {
            list3 = entityItem.underlines;
        }
        if ((i & 32) != 0) {
            f = entityItem.score;
        }
        if ((i & 64) != 0) {
            list4 = entityItem.actions;
        }
        float f4 = f;
        List list5 = list4;
        List list6 = list3;
        List list7 = list;
        return entityItem.copy(entityType, str, list7, list2, list6, f4, list5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EntityType getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<Rect> component3() {
        return this.rectList;
    }

    @NotNull
    public final List<Point[]> component4() {
        return this.polyList;
    }

    @NotNull
    public final List<Underline> component5() {
        return this.underlines;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    @NotNull
    public final List<RemoteAction> component7() {
        return this.actions;
    }

    @NotNull
    public final EntityItem copy(@NotNull EntityType type, @NotNull String text, @NotNull List<Rect> rectList, @NotNull List<Point[]> polyList, @NotNull List<Underline> underlines, float score, @NotNull List<RemoteAction> actions) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rectList, "rectList");
        Intrinsics.checkNotNullParameter(polyList, "polyList");
        Intrinsics.checkNotNullParameter(underlines, "underlines");
        Intrinsics.checkNotNullParameter(actions, "actions");
        return new EntityItem(type, text, rectList, polyList, underlines, score, actions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityItem)) {
            return false;
        }
        EntityItem entityItem = (EntityItem) other;
        return this.type == entityItem.type && Intrinsics.areEqual(this.text, entityItem.text) && Intrinsics.areEqual(this.rectList, entityItem.rectList) && Intrinsics.areEqual(this.polyList, entityItem.polyList) && Intrinsics.areEqual(this.underlines, entityItem.underlines) && Float.compare(this.score, entityItem.score) == 0 && Intrinsics.areEqual(this.actions, entityItem.actions);
    }

    @NotNull
    public final List<RemoteAction> getActions() {
        return this.actions;
    }

    @NotNull
    public final List<Point[]> getPolyList() {
        return this.polyList;
    }

    @NotNull
    public final List<Rect> getRectList() {
        return this.rectList;
    }

    public final float getScore() {
        return this.score;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final EntityType getType() {
        return this.type;
    }

    @NotNull
    public final List<Underline> getUnderlines() {
        return this.underlines;
    }

    public int hashCode() {
        return this.actions.hashCode() + AbstractC0622a.m1156b(this.score, AbstractC0622a.m1159e(this.underlines, AbstractC0622a.m1159e(this.polyList, AbstractC0622a.m1159e(this.rectList, AbstractC1038a.m1202c(this.type.hashCode() * 31, 31, this.text), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        EntityType entityType = this.type;
        String str = this.text;
        List<Rect> list = this.rectList;
        List<Point[]> list2 = this.polyList;
        List<Underline> list3 = this.underlines;
        float f = this.score;
        List<RemoteAction> list4 = this.actions;
        StringBuilder sb = new StringBuilder("EntityItem(type=");
        sb.append(entityType);
        sb.append(", text=");
        sb.append(str);
        sb.append(", rectList=");
        sb.append(list);
        sb.append(", polyList=");
        sb.append(list2);
        sb.append(", underlines=");
        sb.append(list3);
        sb.append(", score=");
        sb.append(f);
        sb.append(", actions=");
        return AbstractC0541b.m777s(sb, list4, ")");
    }

    public /* synthetic */ EntityItem(EntityType entityType, String str, List list, List list2, List list3, float f, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(entityType, str, list, list2, list3, (i & 32) != 0 ? 1.0f : f, list4);
    }
}
