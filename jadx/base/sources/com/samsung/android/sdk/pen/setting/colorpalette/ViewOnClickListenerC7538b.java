package com.samsung.android.sdk.pen.setting.colorpalette;

import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayout;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.sdk.pen.setting.common.SPenSeekBarView;
import com.samsung.android.sdk.pen.setting.common.SpenCommonTitleLayout;
import com.samsung.android.sdk.pen.setting.common.SpenOptionMenu;
import com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter;
import com.samsung.android.sdk.pen.setting.handwriting.SpenLineSizeView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenListView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthMiniLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTColorPickerViewCore;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPatternLayout;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore;
import com.samsung.android.support.senl.addons.brush.view.popup.BrushSettingPopup;
import com.samsung.android.support.senl.addons.brush.view.popup.EraserSettingPopupView;
import com.samsung.android.support.senl.p148nt.app.inapp.view.InAppView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyFingerprintView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyFingerprintViewUnderP;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyIrisView;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyIrisViewUnderQ;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyPasswordView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FiltersSearchView;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpalette.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7538b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5009a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5010b;

    public /* synthetic */ ViewOnClickListenerC7538b(Object obj, int i) {
        this.f5009a = i;
        this.f5010b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5009a) {
            case 0:
                SpenPalette.mChildClickListener$lambda$1((SpenPalette) this.f5010b, view);
                break;
            case 1:
                SpenColorPickerLayout.mCloseButtonClickListener$lambda$0((SpenColorPickerLayout) this.f5010b, view);
                break;
            case 2:
                SpenColorSpoidLayout.mCloseButtonClickListener$lambda$1((SpenColorSpoidLayout) this.f5010b, view);
                break;
            case 3:
                SPenSeekBarView.mButtonClickListener$lambda$2((SPenSeekBarView) this.f5010b, view);
                break;
            case 4:
                SpenCommonTitleLayout.mCloseClickListener$lambda$0((SpenCommonTitleLayout) this.f5010b, view);
                break;
            case 5:
                SpenOptionMenu.mClickListener$lambda$0((SpenOptionMenu) this.f5010b, view);
                break;
            case 6:
                SpenRadioListLayout.mRippleLayoutClickListener$lambda$2((SpenRadioListLayout) this.f5010b, view);
                break;
            case 7:
                ((SpenSwitchView) this.f5010b).toggle();
                break;
            case 8:
                ((SpenTabGroup) this.f5010b).select(view, true);
                break;
            case 9:
                SpenBrushPenTypeLayout.initView$lambda$3((SpenBrushPenTypeLayout) this.f5010b, view);
                break;
            case 10:
                SpenBrushPensView.mPenClickListener$lambda$1((SpenBrushPensView) this.f5010b, view);
                break;
            case 11:
                SpenFavoritePenMiniAdapter.access$onAddItemEvent((SpenFavoritePenMiniAdapter) this.f5010b);
                break;
            case 12:
                SpenLineSizeView.mSizeClickListenter$lambda$1((SpenLineSizeView) this.f5010b, view);
                break;
            case 13:
                SpenPenListView.mPenClickListener$lambda$1((SpenPenListView) this.f5010b, view);
                break;
            case 14:
                SpenPenWidthLayout.mClickListener$lambda$0((SpenPenWidthLayout) this.f5010b, view);
                break;
            case 15:
                SpenPenWidthMiniLayout.initView$lambda$0((SpenPenWidthMiniLayout) this.f5010b, view);
                break;
            case 16:
                SpenQTColorPickerViewCore.initColorView$lambda$1((SpenQTColorPickerViewCore) this.f5010b, view);
                break;
            case 17:
                SpenSettingQTColorDialLayout.mFixedItemClickListener$lambda$0((SpenSettingQTColorDialLayout) this.f5010b, view);
                break;
            case 18:
                SpenSettingQTPatternLayout.mPatternClickListener$lambda$0((SpenSettingQTPatternLayout) this.f5010b, view);
                break;
            case 19:
                SpenRemoverViewCore.initClearAll$lambda$3((SpenRemoverViewCore) this.f5010b, view);
                break;
            case 20:
                BrushSettingPopup.setChangeListener$lambda$0((BrushSettingPopup) this.f5010b, view);
                break;
            case 21:
                EraserSettingPopupView._init_$lambda$0((EraserSettingPopupView) this.f5010b, view);
                break;
            case 22:
                ((InAppView) this.f5010b).onClickClose();
                break;
            case 23:
                ((VerifyFingerprintView) this.f5010b).lambda$createDexView$0(view);
                break;
            case 24:
                ((VerifyFingerprintViewUnderP) this.f5010b).lambda$createDefaultView$0(view);
                break;
            case 25:
                ((VerifyIrisView) this.f5010b).lambda$createDexView$0(view);
                break;
            case 26:
                ((VerifyIrisViewUnderQ) this.f5010b).lambda$onCreateView$0(view);
                break;
            case 27:
                ((VerifyPasswordView) this.f5010b).lambda$onCreateView$0(view);
                break;
            case 28:
                ((SOMRecognizedCardHolder) this.f5010b).toggleSOMRecognizedCardExpandCollapseState();
                break;
            default:
                ((FiltersSearchView) this.f5010b).lambda$initLayout$0(view);
                break;
        }
    }
}
