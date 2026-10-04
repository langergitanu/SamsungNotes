package com.samsung.android.app.notes.widget.glance.single.setting.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.p109ui.platform.ComposeView;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6958k;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6960m;
import com.samsung.android.app.notes.widget.glance.single.setting.model.WidgetSingleGlanceSettingModel;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingContract;
import com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0003J\b\u00102\u001a\u00020/H\u0002J\u0018\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u00020/H\u0003J\u001a\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010$H\u0002J\u001a\u0010?\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020BH\u0002J\u001a\u0010C\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020=H\u0002J\u0012\u0010I\u001a\u00020/2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010J\u001a\u00020/2\b\u0010K\u001a\u0004\u0018\u00010$H\u0016J\b\u0010L\u001a\u00020/H\u0016J\u0010\u0010M\u001a\u00020/2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010N\u001a\u00020/2\u0006\u0010<\u001a\u00020=2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010O\u001a\u00020/H\u0002J\b\u0010P\u001a\u00020/H\u0016J\u0010\u0010Q\u001a\u00020/2\u0006\u0010A\u001a\u00020\u0010H\u0016J\b\u0010R\u001a\u00020/H\u0016J\b\u0010S\u001a\u00020/H\u0016J\b\u0010T\u001a\u00020/H\u0016J\u0010\u0010U\u001a\u00020/2\u0006\u0010D\u001a\u00020=H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010%\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020$8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010#\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingContract;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPresenter", "Lcom/samsung/android/app/notes/widget/glance/single/setting/presenter/WidgetSingleGlanceSettingPresenter;", "mNoteTitleView", "Landroid/widget/TextView;", "mPreviewBgShapeView", "Lcom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceBgShapeView;", "mOldPreviewBgShapeView", "mPreviewBgShapeList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mWidgetSingleGlanceSettingPreview", "Lcom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingPreview;", "mBackgroundOnOff", "Landroidx/appcompat/widget/SwitchCompat;", "mBackgroundOnOffTextView", "mBackgroundOnOffSubTitle", "mSettingBgShapeContainer", "mBackgroundSwitchLayout", "mBackgroundShapeText", "<set-?>", "", "requestTime", "getRequestTime", "()J", "setRequestTime", "(J)V", "requestTime$delegate", "Landroidx/compose/runtime/MutableState;", "", "typeWidgetView", "getTypeWidgetView", "()Ljava/lang/String;", "setTypeWidgetView", "(Ljava/lang/String;)V", "typeWidgetView$delegate", "mShapeViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "init", "", "initPreview", "initChange", "initSettingBackgroundShape", "updateOldBackgroundShape", "oldResId", "resId", "getResFromShapeId", VMetaDataKey.META_KEY_SHAPE, "getShapeIdFromRes", "resourceId", "initBackgroundOnOff", "getContentDescriptionSwitchString", "isChecked", "", "label", "setViewAlpha", "view", "alpha", "", "setViewEnabled", "isEnable", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "setPresenter", "updateNoteTitleView", "title", "updateBgSettingMenu", "onBackgroundToggled", "onBackgroundColorToggled", "updateWidgetPreview", "updatePreview", "updateWidgetPreviewAlpha", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "updateBackgroundOnOff", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetSingleGlanceSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetSingleGlanceSettingView.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingView\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,377:1\n81#2:378\n107#2,2:379\n81#2:381\n107#2,2:382\n1#3:384\n1869#4,2:385\n*S KotlinDebug\n*F\n+ 1 WidgetSingleGlanceSettingView.kt\ncom/samsung/android/app/notes/widget/glance/single/setting/view/WidgetSingleGlanceSettingView\n*L\n50#1:378\n50#1:379,2\n51#1:381\n51#1:382,2\n142#1:385,2\n*E\n"})
public final class WidgetSingleGlanceSettingView extends BaseWidgetSettingView implements WidgetSingleGlanceSettingContract {

    @NotNull
    private static final String COMMA_WITH_SPACE = ", ";

    @NotNull
    private static final String TAG = "WidgetSingleGlanceSettingView";

    @Nullable
    private SwitchCompat mBackgroundOnOff;

    @Nullable
    private TextView mBackgroundOnOffSubTitle;

    @Nullable
    private TextView mBackgroundOnOffTextView;

    @Nullable
    private TextView mBackgroundShapeText;

    @Nullable
    private View mBackgroundSwitchLayout;

    @Nullable
    private TextView mNoteTitleView;

    @Nullable
    private WidgetSingleGlanceBgShapeView mOldPreviewBgShapeView;

    @Nullable
    private WidgetSingleGlanceSettingPresenter mPresenter;

    @NotNull
    private final HashMap<Integer, WidgetSingleGlanceBgShapeView> mPreviewBgShapeList;

    @Nullable
    private WidgetSingleGlanceBgShapeView mPreviewBgShapeView;

    @Nullable
    private View mSettingBgShapeContainer;

    @NotNull
    private ArrayList<WidgetSingleGlanceBgShapeView> mShapeViews;

    @Nullable
    private WidgetSingleGlanceSettingPreview mWidgetSingleGlanceSettingPreview;

    /* JADX INFO: renamed from: requestTime$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState requestTime;

    /* JADX INFO: renamed from: typeWidgetView$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState typeWidgetView;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSingleGlanceSettingView(@Nullable View view) {
        String typeWidgetView;
        super(view);
        Intrinsics.checkNotNull(view);
        this.mPreviewBgShapeList = new HashMap<>();
        this.requestTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(System.currentTimeMillis()), null, 2, null);
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        this.typeWidgetView = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((widgetSingleGlanceSettingPresenter == null || (typeWidgetView = widgetSingleGlanceSettingPresenter.getTypeWidgetView()) == null) ? WidgetConstant.EMPTY_VIEW : typeWidgetView, null, 2, null);
        this.mShapeViews = new ArrayList<>();
    }

    private final String getContentDescriptionSwitchString(boolean isChecked, String label) {
        Context context;
        int i;
        if (isChecked) {
            context = getMParent().getContext();
            i = C11391R.string.string_on;
        } else {
            context = getMParent().getContext();
            i = C11391R.string.string_off;
        }
        return AbstractC2821a.m2221l(context.getString(i), ", ", label, getMParent().getContext().getString(C11391R.string.string_switch));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final long getRequestTime() {
        return ((Number) this.requestTime.getValue()).longValue();
    }

    private final int getResFromShapeId(int shape) {
        return shape != 0 ? shape != 1 ? shape != 2 ? shape != 3 ? shape != 4 ? C11391R.drawable.widget_setting_preview_bg_shape_00 : C11391R.drawable.widget_setting_preview_bg_shape_04 : C11391R.drawable.widget_setting_preview_bg_shape_03 : C11391R.drawable.widget_setting_preview_bg_shape_02 : C11391R.drawable.widget_setting_preview_bg_shape_01 : C11391R.drawable.widget_setting_preview_bg_shape_00;
    }

    private final int getShapeIdFromRes(int resourceId) {
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_01) {
            return 1;
        }
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_02) {
            return 2;
        }
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_03) {
            return 3;
        }
        return resourceId == C11391R.drawable.widget_setting_preview_bg_shape_04 ? 4 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String getTypeWidgetView() {
        return (String) this.typeWidgetView.getValue();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initBackgroundOnOff() {
        WidgetSingleGlanceSettingModel mModel;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_glance_setting_background, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 1);
        setMBackgroundOnOffFrameView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_frame_view));
        setMBackgroundOnOffContainerView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_container));
        setMBackgroundOnOffCornerView((RoundCornerOverlayView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_round_corner));
        setMBackgroundOnOffItemView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_item));
        this.mBackgroundOnOffTextView = (TextView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_title);
        this.mBackgroundOnOffSubTitle = (TextView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_sub_title);
        SwitchCompat switchCompat = (SwitchCompat) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_switch);
        this.mBackgroundOnOff = switchCompat;
        if (switchCompat != null) {
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
            Boolean boolValueOf = (widgetSingleGlanceSettingPresenter == null || (mModel = widgetSingleGlanceSettingPresenter.getMModel()) == null) ? null : Boolean.valueOf(mModel.getBackgroundOnOff());
            Intrinsics.checkNotNull(boolValueOf);
            switchCompat.setChecked(boolValueOf.booleanValue());
        }
        TextView textView = this.mBackgroundOnOffSubTitle;
        if (textView != null) {
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter2 = this.mPresenter;
            textView.setText((widgetSingleGlanceSettingPresenter2 == null || !widgetSingleGlanceSettingPresenter2.getIsSmartPage()) ? getMParent().getResources().getString(C11391R.string.widget_setting_background_on_off_blank_sub_title) : getMParent().getResources().getString(C11391R.string.widget_setting_background_on_off_spage_sub_title));
        }
        this.mBackgroundSwitchLayout = getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off);
        TextView textView2 = this.mBackgroundOnOffTextView;
        String str = ((Object) (textView2 != null ? textView2.getText() : null)) + ", ";
        SwitchCompat switchCompat2 = this.mBackgroundOnOff;
        Boolean boolValueOf2 = switchCompat2 != null ? Boolean.valueOf(switchCompat2.isChecked()) : null;
        Intrinsics.checkNotNull(boolValueOf2);
        String contentDescriptionSwitchString = getContentDescriptionSwitchString(boolValueOf2.booleanValue(), str);
        View view = this.mBackgroundSwitchLayout;
        if (view != null) {
            view.setFocusable(1);
        }
        View view2 = this.mBackgroundSwitchLayout;
        if (view2 != null) {
            view2.setContentDescription(contentDescriptionSwitchString);
        }
        SwitchCompat switchCompat3 = this.mBackgroundOnOff;
        if (switchCompat3 != null) {
            switchCompat3.setOnTouchListener(new ViewOnTouchListenerC7005f(0));
        }
        SwitchCompat switchCompat4 = this.mBackgroundOnOff;
        if (switchCompat4 != null) {
            switchCompat4.setOnCheckedChangeListener(new C6958k(this, str, 2));
        }
        SwitchCompat switchCompat5 = this.mBackgroundOnOff;
        Boolean boolValueOf3 = switchCompat5 != null ? Boolean.valueOf(switchCompat5.isChecked()) : null;
        Intrinsics.checkNotNull(boolValueOf3);
        onBackgroundToggled(boolValueOf3.booleanValue());
        View view3 = this.mBackgroundSwitchLayout;
        if (view3 != null) {
            view3.setOnClickListener(new ViewOnClickListenerC7003d(this, 1));
        }
        View view4 = this.mBackgroundSwitchLayout;
        if (view4 != null) {
            view4.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 4));
        }
        initOpacityViewOneUi7x();
        initBackgroundColorOneUI7x();
        updateRoundCornerViewHeight(getMBackgroundOnOffContainerView(), getMBackgroundOnOffFrameView(), getMBackgroundOnOffCornerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$10(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, View view) {
        SwitchCompat switchCompat;
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = widgetSingleGlanceSettingView.mPresenter;
        if (widgetSingleGlanceSettingPresenter == null || !widgetSingleGlanceSettingPresenter.isEnableBackgroundOnOff() || (switchCompat = widgetSingleGlanceSettingView.mBackgroundOnOff) == null) {
            return;
        }
        switchCompat.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initBackgroundOnOff$lambda$11(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            TextView textView = widgetSingleGlanceSettingView.mBackgroundOnOffTextView;
            if (textView != null) {
                textView.setPressed(true);
            }
            SwitchCompat switchCompat = widgetSingleGlanceSettingView.mBackgroundOnOff;
            if (switchCompat != null) {
                switchCompat.setPressed(true);
            }
        } else if (action == 1 || action == 3) {
            TextView textView2 = widgetSingleGlanceSettingView.mBackgroundOnOffTextView;
            if (textView2 != null) {
                textView2.setPressed(false);
            }
            SwitchCompat switchCompat2 = widgetSingleGlanceSettingView.mBackgroundOnOff;
            if (switchCompat2 != null) {
                switchCompat2.setPressed(false);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initBackgroundOnOff$lambda$8(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$9(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, String str, CompoundButton compoundButton, boolean z) {
        WidgetSingleGlanceSettingModel mModel;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        NotesSamsungAnalytics.INSTANCE.insertLog("613", "6142", z ? "1. On" : "2. Off");
        SwitchCompat switchCompat = widgetSingleGlanceSettingView.mBackgroundOnOff;
        if (switchCompat != null) {
            switchCompat.setChecked(z);
        }
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = widgetSingleGlanceSettingView.mPresenter;
        if (widgetSingleGlanceSettingPresenter != null && (mModel = widgetSingleGlanceSettingPresenter.getMModel()) != null) {
            mModel.setBackgroundOnOff(z);
        }
        widgetSingleGlanceSettingView.onBackgroundToggled(z);
        View view = widgetSingleGlanceSettingView.mBackgroundSwitchLayout;
        if (view != null) {
            SwitchCompat switchCompat2 = widgetSingleGlanceSettingView.mBackgroundOnOff;
            Boolean boolValueOf = switchCompat2 != null ? Boolean.valueOf(switchCompat2.isChecked()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            view.setContentDescription(widgetSingleGlanceSettingView.getContentDescriptionSwitchString(boolValueOf.booleanValue(), str));
        }
        widgetSingleGlanceSettingView.updateRoundCornerViewHeight(widgetSingleGlanceSettingView.getMBackgroundOnOffContainerView(), widgetSingleGlanceSettingView.getMBackgroundOnOffFrameView(), widgetSingleGlanceSettingView.getMBackgroundOnOffCornerView());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initChange() {
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_setting_control_change_note, (ViewGroup) null);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        this.mNoteTitleView = (TextView) viewInflate.findViewById(C11391R.id.widget_setting_change_title_text);
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        updateNoteTitleView(widgetSingleGlanceSettingPresenter != null ? widgetSingleGlanceSettingPresenter.getRecommendTitle() : null);
        View viewFindViewById2 = viewInflate.findViewById(C11391R.id.widget_setting_change_btn);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) viewFindViewById2;
        button.setOnClickListener(new ViewOnClickListenerC7003d(this, 0));
        CharUtils.applyTextSizeUntilLargeSize(getMParent().getContext(), button, 18.0f);
        RelativeLayout relativeLayout = (RelativeLayout) getMParent().findViewById(C11391R.id.widget_setting_change_container);
        relativeLayout.setOnClickListener(new ViewOnClickListenerC0157a(button, 9));
        relativeLayout.setOnTouchListener(new ViewOnTouchListenerC7004e(button, this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initChange$lambda$2(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, View view) {
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = widgetSingleGlanceSettingView.mPresenter;
        if (widgetSingleGlanceSettingPresenter != null) {
            widgetSingleGlanceSettingPresenter.onChangeClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initChange$lambda$4(Button button, WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, View view, MotionEvent motionEvent) {
        WidgetLogger.m5154d("WidgetSingleGlanceSettingView", "acton: " + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action == 0) {
            button.setPressed(true);
            TextView textView = widgetSingleGlanceSettingView.mNoteTitleView;
            if (textView != null) {
                textView.setPressed(true);
            }
        } else if (action == 1 || action == 3) {
            TextView textView2 = widgetSingleGlanceSettingView.mNoteTitleView;
            if (textView2 != null) {
                textView2.setPressed(false);
            }
            button.setPressed(false);
        }
        return false;
    }

    private final void initPreview() {
        WidgetSingleGlanceSettingModel mModel;
        WidgetSingleGlanceSettingModel mModel2;
        WidgetSingleGlanceSettingModel mModel3;
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetSingleGlanceSettingPresenter == null || (mModel3 = widgetSingleGlanceSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel3.getMinWidth());
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter2 = this.mPresenter;
        companion.insertLog("613", "6138", numValueOf + " x " + ((widgetSingleGlanceSettingPresenter2 == null || (mModel2 = widgetSingleGlanceSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel2.getMinHeight())));
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter3 = this.mPresenter;
        if ((widgetSingleGlanceSettingPresenter3 != null ? widgetSingleGlanceSettingPresenter3.getOneUiWidgetSource() : null) != null) {
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter4 = this.mPresenter;
            if (Intrinsics.areEqual(widgetSingleGlanceSettingPresenter4 != null ? widgetSingleGlanceSettingPresenter4.getOneUiWidgetSource() : null, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_setting_preview_background));
            }
        }
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter5 = this.mPresenter;
        Integer numValueOf2 = (widgetSingleGlanceSettingPresenter5 == null || (mModel = widgetSingleGlanceSettingPresenter5.getMModel()) == null) ? null : Integer.valueOf(mModel.getRow());
        Intrinsics.checkNotNull(numValueOf2);
        if (numValueOf2.intValue() > 2 && getMParent().getResources().getConfiguration().orientation == 1) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = getMParent().getResources().getDimensionPixelSize(C11391R.dimen.widget_setting_preview_container_size_max_height);
            relativeLayout.setLayoutParams(layoutParams);
        }
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter6 = this.mPresenter;
        this.mWidgetSingleGlanceSettingPreview = widgetSingleGlanceSettingPresenter6 != null ? new WidgetSingleGlanceSettingPreview(getMParent(), widgetSingleGlanceSettingPresenter6) : null;
        Context context = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1594219012, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView$initPreview$previewCompose$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1594219012, i, -1, "com.samsung.android.app.notes.widget.glance.single.setting.view.WidgetSingleGlanceSettingView.initPreview.<anonymous>.<anonymous> (WidgetSingleGlanceSettingView.kt:83)");
                }
                WidgetSingleGlanceSettingPreview widgetSingleGlanceSettingPreview = this.this$0.mWidgetSingleGlanceSettingPreview;
                if (widgetSingleGlanceSettingPreview != null) {
                    widgetSingleGlanceSettingPreview.setContent(this.this$0.getRequestTime(), this.this$0.getTypeWidgetView(), composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        relativeLayout.addView(composeView);
    }

    private final void initSettingBackgroundShape() {
        WidgetSingleGlanceSettingModel mModel;
        WidgetSingleGlanceSettingModel mModel2;
        WidgetSingleGlanceSettingModel mModel3;
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetSingleGlanceSettingPresenter == null || (mModel3 = widgetSingleGlanceSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel3.getRow());
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() == 2) {
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter2 = this.mPresenter;
            Integer numValueOf2 = (widgetSingleGlanceSettingPresenter2 == null || (mModel2 = widgetSingleGlanceSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel2.getColumn());
            Intrinsics.checkNotNull(numValueOf2);
            if (numValueOf2.intValue() == 2) {
                Object systemService = getMParent().getContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
                ((LinearLayout) viewFindViewById).addView(((LayoutInflater) systemService).inflate(C11391R.layout.widget_list_glance_setting_control_background_shape, (ViewGroup) null), 0);
                setMBackgroundShapeView(getMParent().findViewById(C11391R.id.widget_list_glance_setting_control_background_shape));
                this.mBackgroundShapeText = (TextView) getMParent().findViewById(C11391R.id.widget_list_setting_bg_shape_title);
                View viewFindViewById2 = getMParent().findViewById(C11391R.id.widget_list_setting_control_background_shape_container);
                Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
                this.mSettingBgShapeContainer = (LinearLayout) viewFindViewById2;
                Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_00), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_01), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_02), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_03), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_04)}).iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    Context context = getMParent().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    WidgetSingleGlanceBgShapeView widgetSingleGlanceBgShapeView = new WidgetSingleGlanceBgShapeView(context, null, 0, 6, null);
                    SwitchCompat switchCompat = this.mBackgroundOnOff;
                    widgetSingleGlanceBgShapeView.setSelectable(switchCompat != null ? switchCompat.isChecked() : true);
                    widgetSingleGlanceBgShapeView.setImageBg(iIntValue);
                    widgetSingleGlanceBgShapeView.setOnSelectListener(new C6960m(this, iIntValue, 2));
                    this.mShapeViews.add(widgetSingleGlanceBgShapeView);
                    WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter3 = this.mPresenter;
                    Integer numValueOf3 = (widgetSingleGlanceSettingPresenter3 == null || (mModel = widgetSingleGlanceSettingPresenter3.getMModel()) == null) ? null : Integer.valueOf(mModel.getBackgroundShape());
                    Intrinsics.checkNotNull(numValueOf3);
                    if (getResFromShapeId(numValueOf3.intValue()) == iIntValue) {
                        widgetSingleGlanceBgShapeView.updateState(true);
                        this.mOldPreviewBgShapeView = widgetSingleGlanceBgShapeView;
                        this.mPreviewBgShapeView = widgetSingleGlanceBgShapeView;
                    }
                    this.mPreviewBgShapeList.put(Integer.valueOf(iIntValue), widgetSingleGlanceBgShapeView);
                    View view = this.mSettingBgShapeContainer;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
                    ((LinearLayout) view).addView(widgetSingleGlanceBgShapeView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSettingBackgroundShape$lambda$7$lambda$6$lambda$5(WidgetSingleGlanceSettingView widgetSingleGlanceSettingView, int i, WidgetSingleGlanceBgShapeView selectedView) {
        Intrinsics.checkNotNullParameter(selectedView, "selectedView");
        SwitchCompat switchCompat = widgetSingleGlanceSettingView.mBackgroundOnOff;
        if (switchCompat == null || switchCompat.isChecked()) {
            WidgetSingleGlanceBgShapeView widgetSingleGlanceBgShapeView = widgetSingleGlanceSettingView.mPreviewBgShapeView;
            if (widgetSingleGlanceBgShapeView != null) {
                widgetSingleGlanceBgShapeView.updateState(false);
            }
            selectedView.updateState(true);
            WidgetSingleGlanceBgShapeView widgetSingleGlanceBgShapeView2 = widgetSingleGlanceSettingView.mPreviewBgShapeView;
            int shapeResource = widgetSingleGlanceBgShapeView2 != null ? widgetSingleGlanceBgShapeView2.getMResourceId() : C11391R.drawable.widget_setting_preview_bg_shape_00;
            widgetSingleGlanceSettingView.mPreviewBgShapeView = selectedView;
            widgetSingleGlanceSettingView.updateWidgetBackgroundColor();
            widgetSingleGlanceSettingView.updateOldBackgroundShape(shapeResource, i);
        }
        return Unit.INSTANCE;
    }

    private final void onBackgroundColorToggled(boolean isChecked, float alpha) {
        setViewAlpha(getMBackgroundColorsView(), alpha);
        setViewEnabled(getMBackgroundColorsView(), isChecked);
    }

    private final void setRequestTime(long j) {
        this.requestTime.setValue(Long.valueOf(j));
    }

    private final void setTypeWidgetView(String str) {
        this.typeWidgetView.setValue(str);
    }

    private final void setViewAlpha(View view, float alpha) {
        if (view != null) {
            view.setAlpha(alpha);
        }
    }

    private final void setViewEnabled(View view, boolean isEnable) {
        if (view != null) {
            view.setEnabled(isEnable);
        }
    }

    private final void updateOldBackgroundShape(int oldResId, int resId) {
        WidgetSingleGlanceSettingModel mModel;
        WidgetSingleGlanceBgShapeView widgetSingleGlanceBgShapeView = this.mPreviewBgShapeList.get(Integer.valueOf(oldResId));
        if (widgetSingleGlanceBgShapeView != null) {
            widgetSingleGlanceBgShapeView.updateState(resId == oldResId);
        }
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        if (widgetSingleGlanceSettingPresenter == null || (mModel = widgetSingleGlanceSettingPresenter.getMModel()) == null) {
            return;
        }
        mModel.setBackgroundShape(getShapeIdFromRes(resId));
    }

    private final void updateWidgetPreview() {
        String typeWidgetView;
        setRequestTime(System.currentTimeMillis());
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        if (widgetSingleGlanceSettingPresenter == null || (typeWidgetView = widgetSingleGlanceSettingPresenter.getTypeWidgetView()) == null) {
            typeWidgetView = WidgetConstant.EMPTY_VIEW;
        }
        setTypeWidgetView(typeWidgetView);
        WidgetLogger.m5154d("WidgetSingleGlanceSettingView", "updateWidgetPreview# time: " + getRequestTime());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetSingleGlanceSettingPresenter);
        return widgetSingleGlanceSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        super.init();
        initSettingBackgroundShape();
        initPreview();
        initChange();
        initBackgroundOnOff();
        updateWidgetSettingDarkMode();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBackgroundToggled(boolean isChecked) {
        int i = isChecked ? 0 : 8;
        View mBackgroundShapeView = getMBackgroundShapeView();
        if (mBackgroundShapeView != null) {
            mBackgroundShapeView.setVisibility(i);
        }
        View mBackgroundOnOffItemView = getMBackgroundOnOffItemView();
        if (mBackgroundOnOffItemView != null) {
            mBackgroundOnOffItemView.setVisibility(i);
        }
        if (isChecked && Intrinsics.areEqual(getTypeWidgetView(), WidgetConstant.NORMAL_VIEW)) {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = getMParent().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
            Integer numValueOf = widgetSingleGlanceSettingPresenter != null ? Integer.valueOf(widgetSingleGlanceSettingPresenter.getPageColor()) : null;
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter2 = this.mPresenter;
            Boolean boolValueOf = widgetSingleGlanceSettingPresenter2 != null ? Boolean.valueOf(widgetSingleGlanceSettingPresenter2.getIsBackgroundImage()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (!companion.isWidgetBgDarkThemeColor(context, iIntValue, boolValueOf.booleanValue(), true)) {
                onBackgroundColorToggled(false, 0.4f);
                View mBackgroundColorsView = getMBackgroundColorsView();
                if (mBackgroundColorsView != null) {
                    mBackgroundColorsView.setVisibility(0);
                }
            }
        } else {
            onBackgroundColorToggled(true, 1.0f);
            View mBackgroundColorsView2 = getMBackgroundColorsView();
            if (mBackgroundColorsView2 != null) {
                mBackgroundColorsView2.setVisibility(i);
            }
        }
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingPresenter");
        this.mPresenter = (WidgetSingleGlanceSettingPresenter) presenter;
    }

    @Override // com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingContract
    public void updateBackgroundOnOff(boolean isEnable) {
        SwitchCompat switchCompat;
        float f = isEnable ? 1.0f : 0.4f;
        SwitchCompat switchCompat2 = this.mBackgroundOnOff;
        if (switchCompat2 != null && !switchCompat2.isChecked() && !isEnable && (switchCompat = this.mBackgroundOnOff) != null) {
            switchCompat.setChecked(true);
        }
        setViewAlpha(this.mBackgroundOnOff, f);
        setViewEnabled(this.mBackgroundSwitchLayout, isEnable);
        setViewEnabled(this.mBackgroundOnOff, isEnable);
        TextView textView = this.mBackgroundOnOffSubTitle;
        if (textView != null) {
            textView.setVisibility(isEnable ? 8 : 0);
        }
        updateRoundCornerViewHeight(getMBackgroundOnOffContainerView(), getMBackgroundOnOffFrameView(), getMBackgroundOnOffCornerView());
    }

    @Override // com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingContract
    public void updateBgSettingMenu() {
        SwitchCompat switchCompat = this.mBackgroundOnOff;
        if (switchCompat != null && switchCompat.isChecked() && Intrinsics.areEqual(getTypeWidgetView(), WidgetConstant.NORMAL_VIEW)) {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = getMParent().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter = this.mPresenter;
            Integer numValueOf = widgetSingleGlanceSettingPresenter != null ? Integer.valueOf(widgetSingleGlanceSettingPresenter.getPageColor()) : null;
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter2 = this.mPresenter;
            Boolean boolValueOf = widgetSingleGlanceSettingPresenter2 != null ? Boolean.valueOf(widgetSingleGlanceSettingPresenter2.getIsBackgroundImage()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (!companion.isWidgetBgDarkThemeColor(context, iIntValue, boolValueOf.booleanValue(), true)) {
                onBackgroundColorToggled(false, 0.4f);
                View mBackgroundColorsView = getMBackgroundColorsView();
                if (mBackgroundColorsView != null) {
                    mBackgroundColorsView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        onBackgroundColorToggled(true, 1.0f);
        View mBackgroundColorsView2 = getMBackgroundColorsView();
        if (mBackgroundColorsView2 != null) {
            SwitchCompat switchCompat2 = this.mBackgroundOnOff;
            mBackgroundColorsView2.setVisibility((switchCompat2 == null || !switchCompat2.isChecked()) ? 8 : 0);
        }
        if (getPresenter().getMatchSetting()) {
            selectCheckmarkBackgroundColor(getMMatchWithSettingCheckmark());
            return;
        }
        WidgetSingleGlanceSettingPresenter widgetSingleGlanceSettingPresenter3 = this.mPresenter;
        if (widgetSingleGlanceSettingPresenter3 == null || widgetSingleGlanceSettingPresenter3.getBackgroundColor() != 1) {
            selectCheckmarkBackgroundColor(getMBlackCheckmark());
        } else {
            selectCheckmarkBackgroundColor(getMWhiteCheckmark());
        }
    }

    @Override // com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingContract
    public void updateNoteTitleView(@Nullable String title) {
        Resources resources;
        if (TextUtils.isEmpty(title)) {
            TextView textView = this.mNoteTitleView;
            if (textView != null) {
                textView.setText((textView == null || (resources = textView.getResources()) == null) ? null : resources.getString(C11391R.string.base_string_no_title));
                return;
            }
            return;
        }
        TextView textView2 = this.mNoteTitleView;
        if (textView2 != null) {
            textView2.setText(title);
        }
    }

    @Override // com.samsung.android.app.notes.widget.glance.single.setting.presenter.WidgetSingleGlanceSettingContract
    public void updatePreview() {
        updateWidgetSettingDarkMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        updateWidgetPreview();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewAlpha(int alpha) {
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewTheme() {
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetSettingDarkMode() {
        menuEnableUpdate();
        updateWidgetBackgroundColor();
    }
}
