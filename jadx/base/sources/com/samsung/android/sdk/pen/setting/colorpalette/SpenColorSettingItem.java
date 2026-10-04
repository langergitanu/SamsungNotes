package com.samsung.android.sdk.pen.setting.colorpalette;

import com.samsung.android.sdk.mobileservice.profile.Privacy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R$\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086.¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingItem;", "", "index", "", "values", "", Privacy.KEY_NAMES, "", "", "visibleColor", "<init>", "(I[I[Ljava/lang/String;[I)V", "getIndex", "()I", "isUsed", "", "()Z", "setUsed", "(Z)V", "colors", "getColors", "()[I", "visibleColors", "getVisibleColors", "getNames", "()[Ljava/lang/String;", "setNames", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "toggle", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSettingItem {

    @NotNull
    private final int[] colors;
    private final int index;
    private boolean isUsed;
    public String[] names;

    @NotNull
    private final int[] visibleColors;

    public SpenColorSettingItem(int i, @NotNull int[] values, @Nullable String[] strArr, @NotNull int[] visibleColor) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(visibleColor, "visibleColor");
        this.index = i;
        int[] iArr = new int[values.length];
        this.colors = iArr;
        int[] iArr2 = new int[values.length];
        this.visibleColors = iArr2;
        System.arraycopy(values, 0, iArr, 0, values.length);
        if (strArr != null) {
            setNames(new String[strArr.length]);
            System.arraycopy(strArr, 0, getNames(), 0, strArr.length);
        }
        System.arraycopy(visibleColor, 0, iArr2, 0, visibleColor.length);
        this.isUsed = false;
    }

    @NotNull
    public final int[] getColors() {
        return this.colors;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String[] getNames() {
        String[] strArr = this.names;
        if (strArr != null) {
            return strArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Privacy.KEY_NAMES);
        return null;
    }

    @NotNull
    public final int[] getVisibleColors() {
        return this.visibleColors;
    }

    /* JADX INFO: renamed from: isUsed, reason: from getter */
    public final boolean getIsUsed() {
        return this.isUsed;
    }

    public final void setNames(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.names = strArr;
    }

    public final void setUsed(boolean z) {
        this.isUsed = z;
    }

    public final boolean toggle() {
        boolean z = !this.isUsed;
        this.isUsed = z;
        return z;
    }
}
