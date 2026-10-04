package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw;

import android.graphics.Point;
import android.graphics.Rect;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawInfo;", "", "selectedChar", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "isLeftToRight", "", "touchPoint", "Landroid/graphics/Point;", "boundingRect", "Landroid/graphics/Rect;", "charForAnimation", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;ZLandroid/graphics/Point;Landroid/graphics/Rect;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;)V", "getBoundingRect", "()Landroid/graphics/Rect;", "getCharForAnimation", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "()Z", "getSelectedChar", "getTouchPoint", "()Landroid/graphics/Point;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class HandleDrawInfo {

    @NotNull
    private final Rect boundingRect;

    @Nullable
    private final SelectableCharacter charForAnimation;
    private final boolean isLeftToRight;

    @NotNull
    private final SelectableCharacter selectedChar;

    @NotNull
    private final Point touchPoint;

    public HandleDrawInfo(@NotNull SelectableCharacter selectedChar, boolean z, @NotNull Point touchPoint, @NotNull Rect boundingRect, @Nullable SelectableCharacter selectableCharacter) {
        Intrinsics.checkNotNullParameter(selectedChar, "selectedChar");
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
        Intrinsics.checkNotNullParameter(boundingRect, "boundingRect");
        this.selectedChar = selectedChar;
        this.isLeftToRight = z;
        this.touchPoint = touchPoint;
        this.boundingRect = boundingRect;
        this.charForAnimation = selectableCharacter;
    }

    public static /* synthetic */ HandleDrawInfo copy$default(HandleDrawInfo handleDrawInfo, SelectableCharacter selectableCharacter, boolean z, Point point, Rect rect, SelectableCharacter selectableCharacter2, int i, Object obj) {
        if ((i & 1) != 0) {
            selectableCharacter = handleDrawInfo.selectedChar;
        }
        if ((i & 2) != 0) {
            z = handleDrawInfo.isLeftToRight;
        }
        if ((i & 4) != 0) {
            point = handleDrawInfo.touchPoint;
        }
        if ((i & 8) != 0) {
            rect = handleDrawInfo.boundingRect;
        }
        if ((i & 16) != 0) {
            selectableCharacter2 = handleDrawInfo.charForAnimation;
        }
        SelectableCharacter selectableCharacter3 = selectableCharacter2;
        Point point2 = point;
        return handleDrawInfo.copy(selectableCharacter, z, point2, rect, selectableCharacter3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SelectableCharacter getSelectedChar() {
        return this.selectedChar;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLeftToRight() {
        return this.isLeftToRight;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Point getTouchPoint() {
        return this.touchPoint;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Rect getBoundingRect() {
        return this.boundingRect;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SelectableCharacter getCharForAnimation() {
        return this.charForAnimation;
    }

    @NotNull
    public final HandleDrawInfo copy(@NotNull SelectableCharacter selectedChar, boolean isLeftToRight, @NotNull Point touchPoint, @NotNull Rect boundingRect, @Nullable SelectableCharacter charForAnimation) {
        Intrinsics.checkNotNullParameter(selectedChar, "selectedChar");
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
        Intrinsics.checkNotNullParameter(boundingRect, "boundingRect");
        return new HandleDrawInfo(selectedChar, isLeftToRight, touchPoint, boundingRect, charForAnimation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HandleDrawInfo)) {
            return false;
        }
        HandleDrawInfo handleDrawInfo = (HandleDrawInfo) other;
        return Intrinsics.areEqual(this.selectedChar, handleDrawInfo.selectedChar) && this.isLeftToRight == handleDrawInfo.isLeftToRight && Intrinsics.areEqual(this.touchPoint, handleDrawInfo.touchPoint) && Intrinsics.areEqual(this.boundingRect, handleDrawInfo.boundingRect) && Intrinsics.areEqual(this.charForAnimation, handleDrawInfo.charForAnimation);
    }

    @NotNull
    public final Rect getBoundingRect() {
        return this.boundingRect;
    }

    @Nullable
    public final SelectableCharacter getCharForAnimation() {
        return this.charForAnimation;
    }

    @NotNull
    public final SelectableCharacter getSelectedChar() {
        return this.selectedChar;
    }

    @NotNull
    public final Point getTouchPoint() {
        return this.touchPoint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    public int hashCode() {
        int iHashCode = this.selectedChar.hashCode() * 31;
        boolean z = this.isLeftToRight;
        ?? r12 = z;
        if (z) {
            r12 = 1;
        }
        int iHashCode2 = (this.boundingRect.hashCode() + ((this.touchPoint.hashCode() + ((iHashCode + r12) * 31)) * 31)) * 31;
        SelectableCharacter selectableCharacter = this.charForAnimation;
        return iHashCode2 + (selectableCharacter == null ? 0 : selectableCharacter.hashCode());
    }

    public final boolean isLeftToRight() {
        return this.isLeftToRight;
    }

    @NotNull
    public String toString() {
        return "HandleDrawInfo(selectedChar=" + this.selectedChar + ", isLeftToRight=" + this.isLeftToRight + ", touchPoint=" + this.touchPoint + ", boundingRect=" + this.boundingRect + ", charForAnimation=" + this.charForAnimation + ")";
    }

    public /* synthetic */ HandleDrawInfo(SelectableCharacter selectableCharacter, boolean z, Point point, Rect rect, SelectableCharacter selectableCharacter2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(selectableCharacter, z, point, rect, (i & 16) != 0 ? null : selectableCharacter2);
    }
}
