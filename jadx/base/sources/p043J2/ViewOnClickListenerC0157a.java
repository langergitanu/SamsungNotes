package p043J2;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingBgShapeView;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorAdapter;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingBgShapeView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceBgShapeView;
import com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView;
import com.samsung.android.app.notes.widget.setting.view.WidgetSettingView;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.ToggleCapsuleLayout;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.ToggleCapsule;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LanguageSelectFragment;
import com.samsung.android.sdk.pen.setting.SpenChangeStyleImpl;
import com.samsung.android.sdk.pen.setting.SpenFavoriteTitleOptionControl;
import com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenMiniLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingSelectionLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingStraightenLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2;
import com.samsung.android.support.senl.docscan.rectify.adapter.RectifiedImageThumbnailAdapter;
import com.samsung.android.support.senl.p148nt.app.ftu.signin.SignInFTUActivity;
import com.samsung.android.support.senl.p148nt.app.settings.common.widget.SwitchPreferenceLayout;

/* JADX INFO: renamed from: J2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class ViewOnClickListenerC0157a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f480a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f481b;

    public /* synthetic */ ViewOnClickListenerC0157a(Object obj, int i) {
        this.f480a = i;
        this.f481b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f480a) {
            case 0:
                RectifiedImageThumbnailAdapter.decorate$lambda$1$lambda$0((RectifiedImageThumbnailAdapter) this.f481b, view);
                break;
            case 1:
                SignInFTUActivity.initLayout$lambda$0((SignInFTUActivity) this.f481b, view);
                break;
            case 2:
                SwitchPreferenceLayout.init$lambda$2((SwitchPreferenceLayout) this.f481b, view);
                break;
            case 3:
                ((MaterialDatePicker) this.f481b).lambda$initHeaderToggle$0(view);
                break;
            case 4:
                WidgetListGlanceSettingBgShapeView._init_$lambda$0((WidgetListGlanceSettingBgShapeView) this.f481b, view);
                break;
            case 5:
                WidgetCreatorAdapter.onBindViewHolder$lambda$1((WidgetCreatorAdapter.WidgetCreatorListViewHolder) this.f481b, view);
                break;
            case 6:
                ((WidgetCreatorRecycleViewActivity) this.f481b).finish();
                break;
            case 7:
                WidgetCreatorSettingBgShapeView._init_$lambda$0((WidgetCreatorSettingBgShapeView) this.f481b, view);
                break;
            case 8:
                WidgetSingleGlanceBgShapeView._init_$lambda$0((WidgetSingleGlanceBgShapeView) this.f481b, view);
                break;
            case 9:
                ((Button) this.f481b).performClick();
                break;
            case 10:
                WidgetListSettingView.initSettingList$lambda$0((WidgetListSettingView) this.f481b, view);
                break;
            case 11:
                WidgetSettingView.initChange$lambda$1((WidgetSettingView) this.f481b, view);
                break;
            case 12:
                CapsuleHelperImpl.drawToggleCapsule$lambda$8$lambda$7((ToggleCapsule) this.f481b, view);
                break;
            case 13:
                CapsuleHelperImpl.drawSimpleCapsule$lambda$5$lambda$4((SimpleCapsule) this.f481b, view);
                break;
            case 14:
                ToggleCapsuleLayout.initViews$lambda$2$lambda$1((ToggleCapsuleLayout) this.f481b, view);
                break;
            case 15:
                LanguageSelectFragment.addAddLanguageButton$lambda$6$lambda$5((LinearLayout) this.f481b, view);
                break;
            case 16:
                LanguageSelectFragment.addCancelAndActionButtons$lambda$8$lambda$7((LanguageSelectFragment) this.f481b, view);
                break;
            case 17:
                SpenChangeStyleImpl.initView$lambda$0((SpenChangeStyleImpl) this.f481b, view);
                break;
            case 18:
                SpenFavoriteTitleOptionControl.mTitleButtonClickListener$lambda$0((SpenFavoriteTitleOptionControl) this.f481b, view);
                break;
            case 19:
                SpenSettingChangeStyleLayout.initView$lambda$0((SpenSettingChangeStyleLayout) this.f481b, view);
                break;
            case 20:
                SpenSettingFavoritePenLayout.initTitle$lambda$0((SpenSettingFavoritePenLayout) this.f481b, view);
                break;
            case 21:
                ((SpenSettingFavoritePenMiniLayout) this.f481b).notifyButtonClick(2);
                break;
            case 22:
                SpenSettingLaserPenLayout.initView$lambda$0((SpenSettingLaserPenLayout) this.f481b, view);
                break;
            case 23:
                SpenSettingPenLayout.initView$lambda$4((SpenSettingPenLayout) this.f481b, view);
                break;
            case 24:
                SpenSettingRemoverLayout.setListener$lambda$1((SpenSettingRemoverLayout) this.f481b, view);
                break;
            case 25:
                SpenSettingSelectionLayout.initView$lambda$0((SpenSettingSelectionLayout) this.f481b, view);
                break;
            case 26:
                ((SpenSettingStraightenLayout) this.f481b).hideAnimation(null);
                break;
            case 27:
                SpenColorSettingLayout.initView$lambda$0((SpenColorSettingLayout) this.f481b, view);
                break;
            default:
                SpenColorSettingLayoutV2.mBtnClickListener$lambda$0((SpenColorSettingLayoutV2) this.f481b, view);
                break;
        }
    }
}
