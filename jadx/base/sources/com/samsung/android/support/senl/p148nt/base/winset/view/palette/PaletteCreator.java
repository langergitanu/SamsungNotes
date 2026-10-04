package com.samsung.android.support.senl.p148nt.base.winset.view.palette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator;", "", "mContext", "Landroid/content/Context;", "mItemActionListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator$OnItemActionListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator$OnItemActionListener;)V", "mPaletteContainerViewList", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView;", "mColorPaletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "mColorResourceIDs", "", "mColorResourceNames", "getDefaultColor", "", "context", "getColor", "paletteId", "colorIndex", "paletteContainerViewList", "", "getPaletteContainerViewList", "()Ljava/util/List;", "colorPaletteData", "getColorPaletteData", "create", "", "width", "height", WiggleAnimationConfig.KEY_SCALE, "", "isBackgroundColorInverted", "", "setDefaultColorInPalette", "updateDefaultColorLayout", "isAdjustInDarkMode", "OnItemActionListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaletteCreator {
    public static final int DEFAULT_SWIPE_ITEM_COUNT = 6;

    @NotNull
    private List<SpenColorPaletteData> mColorPaletteData;

    @NotNull
    private final int[] mColorResourceIDs;

    @NotNull
    private final int[] mColorResourceNames;

    @NotNull
    private final Context mContext;

    @NotNull
    private final OnItemActionListener mItemActionListener;

    @NotNull
    private List<PaletteContainerView> mPaletteContainerViewList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator$OnItemActionListener;", "", "onPaletteClicked", "", "paletteId", "", "colorIndex", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnItemActionListener {
        void onPaletteClicked(int paletteId, int colorIndex);
    }

    public PaletteCreator(@NotNull Context mContext, @NotNull OnItemActionListener mItemActionListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mItemActionListener, "mItemActionListener");
        this.mContext = mContext;
        this.mItemActionListener = mItemActionListener;
        this.mPaletteContainerViewList = new ArrayList();
        this.mColorPaletteData = new ArrayList();
        this.mColorResourceIDs = new int[]{C8875R.array.background_color_setting1, C8875R.array.background_color_setting2, C8875R.array.background_color_setting3};
        this.mColorResourceNames = new int[]{C8875R.array.background_color_setting_name1, C8875R.array.background_color_setting_name2, C8875R.array.background_color_setting_name3};
    }

    private final void setDefaultColorInPalette(boolean isBackgroundColorInverted) {
        this.mColorPaletteData.clear();
        int length = this.mColorResourceIDs.length;
        for (int i = 0; i < length; i++) {
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = i;
            spenColorPaletteData.valueId = this.mColorResourceIDs[i];
            spenColorPaletteData.nameId = this.mColorResourceNames[i];
            int[] intArray = this.mContext.getResources().getIntArray(spenColorPaletteData.valueId);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            spenColorPaletteData.values = intArray;
            String[] stringArray = this.mContext.getResources().getStringArray(spenColorPaletteData.nameId);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            spenColorPaletteData.names = stringArray;
            int length2 = spenColorPaletteData.values.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (i == 0 && i2 == 0) {
                    updateDefaultColorLayout(isBackgroundColorInverted);
                } else {
                    PaletteContainerView paletteContainerView = this.mPaletteContainerViewList.get(i);
                    int i4 = spenColorPaletteData.values[i2];
                    String str = spenColorPaletteData.names[i2];
                    Intrinsics.checkNotNull(str);
                    paletteContainerView.setColor(i2, i4, str);
                }
            }
            this.mColorPaletteData.add(spenColorPaletteData);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void create(int width, int height, float scale, boolean isBackgroundColorInverted) {
        this.mPaletteContainerViewList.clear();
        int length = this.mColorResourceIDs.length;
        for (final int i = 0; i < length; i++) {
            View viewInflate = LayoutInflater.from(this.mContext).inflate(C8875R.layout.background_color_palette_container, (ViewGroup) null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteContainerView");
            PaletteContainerView paletteContainerView = (PaletteContainerView) viewInflate;
            paletteContainerView.setPaletteItemInfo(6, width, height, scale);
            paletteContainerView.setPaletteViewContract(new PaletteContainerView.PaletteViewContract() { // from class: com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteCreator.create.1
                @Override // com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteContainerView.PaletteViewContract
                public void onPaletteClicked(int index) {
                    PaletteCreator.this.mItemActionListener.onPaletteClicked(i, index);
                }
            });
            this.mPaletteContainerViewList.add(paletteContainerView);
        }
        setDefaultColorInPalette(isBackgroundColorInverted);
    }

    public final int getColor(@NotNull Context context, int paletteId, int colorIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getIntArray(this.mColorResourceIDs[paletteId])[colorIndex];
    }

    @NotNull
    public final List<SpenColorPaletteData> getColorPaletteData() {
        return this.mColorPaletteData;
    }

    public final int getDefaultColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getColor(context, 0, 0);
    }

    @NotNull
    public final List<PaletteContainerView> getPaletteContainerViewList() {
        return this.mPaletteContainerViewList;
    }

    public final void updateDefaultColorLayout(boolean isAdjustInDarkMode) {
        if (this.mPaletteContainerViewList.isEmpty()) {
            return;
        }
        boolean z = ContextUtils.isNightMode(this.mContext) && isAdjustInDarkMode;
        PaletteContainerView paletteContainerView = this.mPaletteContainerViewList.get(0);
        int i = z ? C8875R.drawable.palette_default_bg_color_patten_dark : C8875R.drawable.palette_default_bg_color_patten;
        String str = this.mContext.getResources().getStringArray(this.mColorResourceNames[0])[0];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        paletteContainerView.setResource(0, i, str);
        this.mPaletteContainerViewList.get(0).updateSelector(0, z);
    }
}
