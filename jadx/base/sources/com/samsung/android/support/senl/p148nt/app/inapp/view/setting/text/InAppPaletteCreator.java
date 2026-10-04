package com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.view.winset.palette.RoundedPaletteContainerView;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000 02\u00020\u0001:\u0002/0B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018H\u0004J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0004J\u0018\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H&J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0018H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@DX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u00188\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00188\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0016¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator;", "", "mContext", "Landroid/content/Context;", "mPickerSelector", "Landroid/view/View;", "mTitleColorBar", "Landroid/widget/ImageView;", "mItemActionListener", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/widget/ImageView;Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;)V", "getMPickerSelector", "()Landroid/view/View;", "getMItemActionListener", "()Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;", "mPaletteContainerViewList", "", "Lcom/samsung/android/support/senl/nt/app/inapp/view/winset/palette/RoundedPaletteContainerView;", "colorPaletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "getColorPaletteData", "()Ljava/util/List;", "value", "", "currentColor", "getCurrentColor", "()Ljava/lang/Integer;", "setCurrentColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mCurrentPaletteId", "mCurrentColorIndex", "paletteContainerViewList", "", "getPaletteContainerViewList", "initPaletteContainerViewList", "", "paletteCount", "updatePickerSelection", "isSelected", "", "setSelectedColor", "paletteId", "colorIndex", "updateColor", "color", "OnItemActionListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class InAppPaletteCreator {
    public static final int COLOR_PICKER_INDEX = -1;
    public static final int DEFAULT_PALETTE_ITEM_COUNT = 8;

    @NotNull
    private final List<SpenColorPaletteData> colorPaletteData;

    @Nullable
    private Integer currentColor;

    @JvmField
    @NotNull
    protected final Context mContext;

    @JvmField
    protected int mCurrentColorIndex;

    @JvmField
    protected int mCurrentPaletteId;

    @NotNull
    private final OnItemActionListener mItemActionListener;

    @JvmField
    @NotNull
    protected final List<RoundedPaletteContainerView> mPaletteContainerViewList;

    @NotNull
    private final View mPickerSelector;

    @JvmField
    @NotNull
    protected final ImageView mTitleColorBar;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;", "", "onPaletteClicked", "", "paletteId", "", "colorIndex", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnItemActionListener {
        void onPaletteClicked(int paletteId, int colorIndex);
    }

    public InAppPaletteCreator(@NotNull Context mContext, @NotNull View mPickerSelector, @NotNull ImageView mTitleColorBar, @NotNull OnItemActionListener mItemActionListener) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mPickerSelector, "mPickerSelector");
        Intrinsics.checkNotNullParameter(mTitleColorBar, "mTitleColorBar");
        Intrinsics.checkNotNullParameter(mItemActionListener, "mItemActionListener");
        this.mContext = mContext;
        this.mPickerSelector = mPickerSelector;
        this.mTitleColorBar = mTitleColorBar;
        this.mItemActionListener = mItemActionListener;
        this.mPaletteContainerViewList = new ArrayList();
        this.colorPaletteData = new ArrayList();
    }

    @NotNull
    public final List<SpenColorPaletteData> getColorPaletteData() {
        return this.colorPaletteData;
    }

    @Nullable
    public final Integer getCurrentColor() {
        return this.currentColor;
    }

    @NotNull
    public final OnItemActionListener getMItemActionListener() {
        return this.mItemActionListener;
    }

    @NotNull
    public final View getMPickerSelector() {
        return this.mPickerSelector;
    }

    @NotNull
    public final List<RoundedPaletteContainerView> getPaletteContainerViewList() {
        return this.mPaletteContainerViewList;
    }

    public final void initPaletteContainerViewList(int paletteCount) {
        this.mPaletteContainerViewList.clear();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C8003R.dimen.in_app_text_mode_palette_item_size);
        for (final int i = 0; i < paletteCount; i++) {
            View viewInflate = LayoutInflater.from(this.mContext).inflate(C8003R.layout.inapp_text_color_palette_container, (ViewGroup) null);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.winset.palette.RoundedPaletteContainerView");
            RoundedPaletteContainerView roundedPaletteContainerView = (RoundedPaletteContainerView) viewInflate;
            roundedPaletteContainerView.setPaletteItemInfo(8, dimensionPixelSize, dimensionPixelSize, 1.13f);
            roundedPaletteContainerView.setPaletteViewContract(new PaletteContainerView.PaletteViewContract() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.text.InAppPaletteCreator.initPaletteContainerViewList.1
                @Override // com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteContainerView.PaletteViewContract
                public void onPaletteClicked(int index) {
                    InAppPaletteCreator.this.getMItemActionListener().onPaletteClicked(i, index);
                }
            });
            this.mPaletteContainerViewList.add(roundedPaletteContainerView);
        }
    }

    public final void setCurrentColor(@Nullable Integer num) {
        this.currentColor = num;
    }

    public abstract void setSelectedColor(int paletteId, int colorIndex);

    public abstract void updateColor(int color);

    public final void updatePickerSelection(boolean isSelected) {
        float f = isSelected ? 1.0f : 0.0f;
        this.mPickerSelector.animate().scaleX(f).scaleY(f).start();
    }
}
