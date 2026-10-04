package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.common.SpenOptionMenu;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteOptionMenu;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000 02\u00020\u0001:\u000201B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0018J\u001a\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl;", "", "context", "Landroid/content/Context;", "popupLayout", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;)V", "mOptionMenu", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteOptionMenu;", "mAddButton", "Landroid/view/View;", "mDeleteButton", "mMoreButton", "mPopupLayout", "mContext", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl$OnButtonClickListener;", "mTitleButtonClickListener", "Landroid/view/View$OnClickListener;", "close", "", "initButton", "supportOptionMenu", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isSupportMoreMenuButton", "()Z", "setMenuEnable", "deleteEnabled", "addEnabled", "showOptionMenu", "hideOptionMenu", "needAnimation", "popupWidth", "", "getPopupWidth", "()I", "popupHeight", "getPopupHeight", "setButtonState", MarketingConstants.BUTTON, "enable", "notifyAddButtonClicked", "notifyDeleteButtonClicked", "notifyMoreButtonClicked", "getValue", "dimenValue", "Companion", "OnButtonClickListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenFavoriteTitleOptionControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFavoriteTitleOptionControl.kt\ncom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
public final class SpenFavoriteTitleOptionControl {

    @NotNull
    private static final String TAG = "SpenFavoriteTitleOptionControl";

    @Nullable
    private View mAddButton;

    @Nullable
    private OnButtonClickListener mButtonClickListener;

    @NotNull
    private Context mContext;

    @Nullable
    private View mDeleteButton;

    @Nullable
    private View mMoreButton;

    @Nullable
    private SpenFavoriteOptionMenu mOptionMenu;

    @NotNull
    private SpenPopupLayout mPopupLayout;

    @NotNull
    private final View.OnClickListener mTitleButtonClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoriteTitleOptionControl$OnButtonClickListener;", "", "onAddButtonClick", "", "onDeleteButtonClick", "onMoreButtonClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnButtonClickListener {
        void onAddButtonClick();

        void onDeleteButtonClick();

        void onMoreButtonClick();
    }

    public SpenFavoriteTitleOptionControl(@NotNull Context context, @NotNull SpenPopupLayout popupLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(popupLayout, "popupLayout");
        this.mTitleButtonClickListener = new ViewOnClickListenerC0157a(this, 18);
        this.mContext = context;
        this.mPopupLayout = popupLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPopupHeight() {
        return this.mPopupLayout.getMOrientation() == 2 ? getValue(C7932R.dimen.setting_favorite_content_edit_landscape_height) : getValue(C7932R.dimen.setting_favorite_content_edit_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPopupWidth() {
        return this.mPopupLayout.getMOrientation() == 2 ? getValue(C7932R.dimen.setting_common_popup_landscape_width) : getValue(C7932R.dimen.setting_common_popup_width_v60);
    }

    private final int getValue(int dimenValue) {
        return this.mContext.getResources().getDimensionPixelOffset(dimenValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTitleButtonClickListener$lambda$0(SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl, View view) {
        if (Intrinsics.areEqual(view, spenFavoriteTitleOptionControl.mMoreButton)) {
            spenFavoriteTitleOptionControl.notifyMoreButtonClicked();
        } else if (Intrinsics.areEqual(view, spenFavoriteTitleOptionControl.mAddButton)) {
            spenFavoriteTitleOptionControl.notifyAddButtonClicked();
        } else if (Intrinsics.areEqual(view, spenFavoriteTitleOptionControl.mDeleteButton)) {
            spenFavoriteTitleOptionControl.notifyDeleteButtonClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAddButtonClicked() {
        OnButtonClickListener onButtonClickListener = this.mButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onAddButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDeleteButtonClicked() {
        OnButtonClickListener onButtonClickListener = this.mButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onDeleteButtonClick();
        }
    }

    private final void notifyMoreButtonClicked() {
        OnButtonClickListener onButtonClickListener = this.mButtonClickListener;
        if (onButtonClickListener != null) {
            onButtonClickListener.onMoreButtonClick();
        }
    }

    private final void setButtonState(View button, boolean enable) {
        if (button != null) {
            button.setClickable(enable);
            button.setEnabled(enable);
            Object parent = button.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setVisibility(enable ? 0 : 8);
        }
    }

    public final void close() {
        SpenFavoriteOptionMenu spenFavoriteOptionMenu = this.mOptionMenu;
        if (spenFavoriteOptionMenu != null) {
            spenFavoriteOptionMenu.close();
        }
        this.mOptionMenu = null;
        this.mPopupLayout.setOrientationChangedListener(null);
        this.mAddButton = null;
        this.mDeleteButton = null;
        this.mMoreButton = null;
    }

    public final void hideOptionMenu(boolean needAnimation) {
        SpenFavoriteOptionMenu spenFavoriteOptionMenu = this.mOptionMenu;
        if (spenFavoriteOptionMenu == null || !spenFavoriteOptionMenu.isShowing()) {
            return;
        }
        spenFavoriteOptionMenu.hide(needAnimation);
    }

    public final void initButton(boolean supportOptionMenu, @Nullable OnButtonClickListener listener) {
        this.mButtonClickListener = listener;
        if (!supportOptionMenu) {
            this.mDeleteButton = this.mPopupLayout.addButtonInTitle(C7932R.drawable.note_setting_ic_delete, C7932R.string.pen_string_delete_preset, this.mTitleButtonClickListener, true);
            this.mAddButton = this.mPopupLayout.addButtonInTitle(C7932R.drawable.note_setting_ic_add, C7932R.string.pen_string_add_favorite_pen, this.mTitleButtonClickListener, true);
        } else {
            this.mDeleteButton = this.mPopupLayout.addButtonInTitle(C7932R.drawable.note_setting_ic_delete, C7932R.string.pen_string_delete_preset, this.mTitleButtonClickListener, false);
            this.mMoreButton = this.mPopupLayout.addButtonInTitle(C7932R.drawable.favorite_more, C7932R.string.pen_string_favorite_more_options, this.mTitleButtonClickListener, false);
            this.mAddButton = this.mPopupLayout.addButtonInTitle(C7932R.drawable.note_setting_ic_add, C7932R.string.pen_string_add_favorite_pen, this.mTitleButtonClickListener, true);
            this.mPopupLayout.setOrientationChangedListener(new SpenPopupLayout.OrientationChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl.initButton.1
                @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.OrientationChangedListener
                public void onOrientationChanged(int orientation) {
                    SpenFavoriteOptionMenu spenFavoriteOptionMenu = SpenFavoriteTitleOptionControl.this.mOptionMenu;
                    if (spenFavoriteOptionMenu != null) {
                        SpenFavoriteTitleOptionControl spenFavoriteTitleOptionControl = SpenFavoriteTitleOptionControl.this;
                        ViewGroup.LayoutParams layoutParams = spenFavoriteOptionMenu.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.width = spenFavoriteTitleOptionControl.getPopupWidth();
                        layoutParams2.height = spenFavoriteTitleOptionControl.getPopupHeight();
                        spenFavoriteOptionMenu.setLayoutParams(layoutParams2);
                    }
                }
            });
        }
    }

    public final boolean isSupportMoreMenuButton() {
        return this.mMoreButton != null;
    }

    public final void setMenuEnable(boolean deleteEnabled, boolean addEnabled) {
        if (this.mMoreButton == null) {
            setButtonState(this.mDeleteButton, deleteEnabled);
            setButtonState(this.mAddButton, addEnabled);
            return;
        }
        boolean z = false;
        boolean z2 = deleteEnabled && addEnabled;
        setButtonState(this.mDeleteButton, !z2 && deleteEnabled);
        setButtonState(this.mMoreButton, z2);
        View view = this.mAddButton;
        if (!z2 && addEnabled) {
            z = true;
        }
        setButtonState(view, z);
    }

    public final void showOptionMenu() {
        SpenFavoriteOptionMenu spenFavoriteOptionMenu = this.mOptionMenu;
        if (spenFavoriteOptionMenu == null) {
            this.mOptionMenu = new SpenFavoriteOptionMenu(this.mContext);
            this.mPopupLayout.addViewInTop(this.mOptionMenu, new RelativeLayout.LayoutParams(getPopupWidth(), getPopupHeight()));
            SpenFavoriteOptionMenu spenFavoriteOptionMenu2 = this.mOptionMenu;
            if (spenFavoriteOptionMenu2 != null) {
                spenFavoriteOptionMenu2.setOnMenuItemClickListener(new SpenOptionMenu.OnMenuItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl.showOptionMenu.1
                    @Override // com.samsung.android.sdk.pen.setting.common.SpenOptionMenu.OnMenuItemClickListener
                    public void onMenuItemClicked(int itemID) {
                        if (SpenFavoriteTitleOptionControl.this.mButtonClickListener == null) {
                            return;
                        }
                        if (itemID == 1) {
                            SpenFavoriteTitleOptionControl.this.notifyAddButtonClicked();
                            SpenFavoriteTitleOptionControl.this.hideOptionMenu(false);
                        } else {
                            if (itemID != 2) {
                                return;
                            }
                            SpenFavoriteTitleOptionControl.this.notifyDeleteButtonClicked();
                            SpenFavoriteTitleOptionControl.this.hideOptionMenu(false);
                        }
                    }
                });
            }
        } else {
            spenFavoriteOptionMenu.bringToFront();
        }
        SpenFavoriteOptionMenu spenFavoriteOptionMenu3 = this.mOptionMenu;
        if (spenFavoriteOptionMenu3 != null) {
            spenFavoriteOptionMenu3.show(true);
        }
    }
}
