package com.samsung.android.sdk.bixby2.labs.data;

import android.graphics.Rect;
import androidx.annotation.Keep;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0017\b\u0001\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\u0002\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001e¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;", "", "checkable", "", "checked", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "", "clickable", "contentDescription", "boundsInScreen", "Landroid/graphics/Rect;", "enabled", "focusable", "focused", "hintText", "longClickable", "selected", "text", "visibility", "", "childCount", "children", "", "(ZZLjava/lang/String;ZLjava/lang/String;Landroid/graphics/Rect;ZZZLjava/lang/String;ZZLjava/lang/String;IILjava/util/List;)V", "getBoundsInScreen", "()Landroid/graphics/Rect;", "getCheckable", "()Z", "getChecked", "getChildCount", "()I", "getChildren", "()Ljava/util/List;", "getClassName", "()Ljava/lang/String;", "getClickable", "getContentDescription", "getEnabled", "getFocusable", "getFocused", "getHintText", "getLongClickable", "getSelected", "getText", "getVisibility", "bixbyappsdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ViewNodeInfo {

    @NotNull
    private final Rect boundsInScreen;
    private final boolean checkable;
    private final boolean checked;
    private final int childCount;

    @NotNull
    private final List<ViewNodeInfo> children;

    @NotNull
    private final String className;
    private final boolean clickable;

    @Nullable
    private final String contentDescription;
    private final boolean enabled;
    private final boolean focusable;
    private final boolean focused;

    @Nullable
    private final String hintText;
    private final boolean longClickable;
    private final boolean selected;

    @Nullable
    private final String text;
    private final int visibility;

    public ViewNodeInfo(boolean z, boolean z2, @NotNull String className, boolean z3, @Nullable String str, @NotNull Rect boundsInScreen, boolean z4, boolean z5, boolean z6, @Nullable String str2, boolean z7, boolean z8, @Nullable String str3, int i, int i2, @NotNull List<ViewNodeInfo> children) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(boundsInScreen, "boundsInScreen");
        Intrinsics.checkNotNullParameter(children, "children");
        this.checkable = z;
        this.checked = z2;
        this.className = className;
        this.clickable = z3;
        this.contentDescription = str;
        this.boundsInScreen = boundsInScreen;
        this.enabled = z4;
        this.focusable = z5;
        this.focused = z6;
        this.hintText = str2;
        this.longClickable = z7;
        this.selected = z8;
        this.text = str3;
        this.visibility = i;
        this.childCount = i2;
        this.children = children;
    }

    @NotNull
    public final Rect getBoundsInScreen() {
        return this.boundsInScreen;
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final int getChildCount() {
        return this.childCount;
    }

    @NotNull
    public final List<ViewNodeInfo> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getFocusable() {
        return this.focusable;
    }

    public final boolean getFocused() {
        return this.focused;
    }

    @Nullable
    public final String getHintText() {
        return this.hintText;
    }

    public final boolean getLongClickable() {
        return this.longClickable;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final int getVisibility() {
        return this.visibility;
    }
}
