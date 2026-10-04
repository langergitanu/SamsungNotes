package com.samsung.android.sdk.pen.setting.colorpalette;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bB\u001b\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0002\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0002\u0010\u0013J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b&\u0010\u0016R\u0011\u0010'\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b'\u0010\u0016¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo;", "", "<init>", "()V", "color", "", "colorName", "", "([FLjava/lang/String;)V", "resId", "", "hoverDescription", "", "(ILjava/lang/CharSequence;)V", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;)V", "resInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "value", "getColorInfo", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "getResInfo", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "setColorInfo", "", "setResInfo", "res", "type", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo$ButtonType;", "getType", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo$ButtonType;", "isColorButton", "isResButton", "ButtonType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenChildButtonInfo {

    @Nullable
    private SpenPaletteColorInfo colorInfo;
    private boolean isSelected;

    @Nullable
    private SpenPaletteResInfo resInfo;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "COLOR", "RES", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType NONE = new ButtonType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final ButtonType COLOR = new ButtonType("COLOR", 1);
        public static final ButtonType RES = new ButtonType("RES", 2);

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{NONE, COLOR, RES};
        }

        static {
            ButtonType[] buttonTypeArr$values = $values();
            $VALUES = buttonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonTypeArr$values);
        }

        private ButtonType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ButtonType> getEntries() {
            return $ENTRIES;
        }

        public static ButtonType valueOf(String str) {
            return (ButtonType) Enum.valueOf(ButtonType.class, str);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }
    }

    public SpenChildButtonInfo() {
    }

    @Nullable
    public final SpenPaletteColorInfo getColorInfo() {
        return this.colorInfo;
    }

    @Nullable
    public final SpenPaletteResInfo getResInfo() {
        return this.resInfo;
    }

    @NotNull
    public final ButtonType getType() {
        return this.colorInfo != null ? ButtonType.COLOR : this.resInfo != null ? ButtonType.RES : ButtonType.NONE;
    }

    @Deprecated(message = "")
    public final boolean isColorButton() {
        return this.colorInfo != null;
    }

    @Deprecated(message = "")
    public final boolean isResButton() {
        return this.resInfo != null;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setColorInfo(@NotNull SpenPaletteColorInfo color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.resInfo = null;
        SpenPaletteColorInfo spenPaletteColorInfo = this.colorInfo;
        if (spenPaletteColorInfo == null) {
            this.colorInfo = new SpenPaletteColorInfo(color);
        } else if (spenPaletteColorInfo != null) {
            spenPaletteColorInfo.setColor(color.getColor(), color.getOpacity(), color.getColorName());
        }
    }

    public final void setResInfo(@NotNull SpenPaletteResInfo res) {
        Intrinsics.checkNotNullParameter(res, "res");
        this.colorInfo = null;
        SpenPaletteResInfo spenPaletteResInfo = this.resInfo;
        if (spenPaletteResInfo == null) {
            this.resInfo = new SpenPaletteResInfo(res);
        } else if (spenPaletteResInfo != null) {
            SpenPaletteResInfo.setRes$default(spenPaletteResInfo, res.getResourceId(), res.getHoverDescription(), 0, 4, null);
        }
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @Deprecated(message = "")
    public SpenChildButtonInfo(@Nullable float[] fArr, @Nullable String str) {
        this();
        SpenPaletteColorInfo spenPaletteColorInfo = new SpenPaletteColorInfo();
        this.colorInfo = spenPaletteColorInfo;
        if (fArr != null) {
            spenPaletteColorInfo.setColor(fArr, 255, str);
        }
    }

    @Deprecated(message = "")
    public SpenChildButtonInfo(int i, @Nullable CharSequence charSequence) {
        this();
        SpenPaletteResInfo spenPaletteResInfo = new SpenPaletteResInfo();
        this.resInfo = spenPaletteResInfo;
        SpenPaletteResInfo.setRes$default(spenPaletteResInfo, i, charSequence, 0, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenChildButtonInfo(@NotNull SpenPaletteColorInfo colorInfo) {
        this();
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        setColorInfo(colorInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenChildButtonInfo(@NotNull SpenPaletteResInfo resInfo) {
        this();
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        setResInfo(resInfo);
    }
}
