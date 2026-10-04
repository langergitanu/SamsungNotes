package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.mode;

import com.samsung.android.sdk.composer.SpenTextWritingView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/mode/SmMode;", "", "mode", "", "editMode", "<init>", "(Ljava/lang/String;III)V", "getMode", "()I", "getEditMode", "MODE_TEXT", "MODE_HW", "MODE_READONLY", "setMode", "", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmMode[] $VALUES;
    private final int editMode;
    private final int mode;
    public static final SmMode MODE_TEXT = new SmMode("MODE_TEXT", 0, 1, 1);
    public static final SmMode MODE_HW = new SmMode("MODE_HW", 1, 1, 2);
    public static final SmMode MODE_READONLY = new SmMode("MODE_READONLY", 2, 3, 0, 2, null);

    private static final /* synthetic */ SmMode[] $values() {
        return new SmMode[]{MODE_TEXT, MODE_HW, MODE_READONLY};
    }

    static {
        SmMode[] smModeArr$values = $values();
        $VALUES = smModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(smModeArr$values);
    }

    private SmMode(String str, int i, int i2, int i4) {
        this.mode = i2;
        this.editMode = i4;
    }

    @NotNull
    public static EnumEntries<SmMode> getEntries() {
        return $ENTRIES;
    }

    public static SmMode valueOf(String str) {
        return (SmMode) Enum.valueOf(SmMode.class, str);
    }

    public static SmMode[] values() {
        return (SmMode[]) $VALUES.clone();
    }

    public final int getEditMode() {
        return this.editMode;
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(@NotNull SpenTextWritingView spenView) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        spenView.setMode(this.mode);
        if (this.mode != 3) {
            spenView.setEditMode(this.editMode);
        }
    }

    public /* synthetic */ SmMode(String str, int i, int i2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i5 & 2) != 0 ? 0 : i4);
    }
}
