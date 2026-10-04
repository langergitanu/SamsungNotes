package com.samsung.android.app.notes.widget.glance.setting.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.glance.setting.presenter.WidgetCreatorSettingPresenter;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6958k;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6960m;
import com.samsung.android.app.notes.widget.glance.setting.model.WidgetCreatorSettingModel;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010.\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020)H\u0003J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000101H\u0002J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\u0018\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0002J\b\u0010>\u001a\u00020)H\u0016J\b\u0010?\u001a\u00020)H\u0002J\u0010\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u000bH\u0016J\b\u0010B\u001a\u00020)H\u0016J\b\u0010C\u001a\u00020)H\u0016J\b\u0010D\u001a\u00020)H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u001bj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00180&j\b\u0012\u0004\u0012\u00020\u0018`'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingContract;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPresenter", "Lcom/samsung/android/app/notes/glance/setting/presenter/WidgetCreatorSettingPresenter;", "mSelectedItems", "", "", "mWidgetCreatorSettingPreview", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingPreview;", "<set-?>", "", "requestTime", "getRequestTime", "()J", "setRequestTime", "(J)V", "requestTime$delegate", "Landroidx/compose/runtime/MutableState;", "mPreviewBgShapeView", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingBgShapeView;", "mOldPreviewBgShapeView", "mPreviewBgShapeList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mBackgroundOnOff", "Landroidx/appcompat/widget/SwitchCompat;", "mBackgroundOnOffTextView", "Landroid/widget/TextView;", "mBackgroundOnOffSubTitle", "mSettingBgShapeContainer", "mBackgroundSwitchLayout", "mBackgroundShapeText", "mShapeViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "init", "", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "setPresenter", "initBackgroundOnOff", "getContentDescriptionSwitchString", "", "isChecked", "", "label", "initShortcutComponent", "initSettingBackgroundShape", "updateOldBackgroundShape", "oldResId", "resId", "getResFromShapeId", VMetaDataKey.META_KEY_SHAPE, "getShapeIdFromRes", "resourceId", "updateItemPreview", "initWidgetPreviewContainer", "updateWidgetPreviewAlpha", "alpha", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorSettingView.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingView\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n81#2:284\n107#2,2:285\n1869#3,2:287\n1#4:289\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorSettingView.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorSettingView\n*L\n33#1:284\n33#1:285,2\n179#1:287,2\n*E\n"})
public final class WidgetCreatorSettingView extends BaseWidgetSettingView implements WidgetCreatorSettingContract {

    @NotNull
    private static final String COMMA_WITH_SPACE = ", ";

    @NotNull
    private static final String TAG = "WidgetCreatorSettingView";

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
    private WidgetCreatorSettingBgShapeView mOldPreviewBgShapeView;

    @Nullable
    private WidgetCreatorSettingPresenter mPresenter;

    @NotNull
    private final HashMap<Integer, WidgetCreatorSettingBgShapeView> mPreviewBgShapeList;

    @Nullable
    private WidgetCreatorSettingBgShapeView mPreviewBgShapeView;

    @NotNull
    private List<Integer> mSelectedItems;

    @Nullable
    private View mSettingBgShapeContainer;

    @NotNull
    private ArrayList<WidgetCreatorSettingBgShapeView> mShapeViews;

    @Nullable
    private WidgetCreatorSettingPreview mWidgetCreatorSettingPreview;

    /* JADX INFO: renamed from: requestTime$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState requestTime;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreatorSettingView(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
        this.mSelectedItems = CollectionsKt.emptyList();
        this.requestTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(System.currentTimeMillis()), null, 2, null);
        this.mPreviewBgShapeList = new HashMap<>();
        this.mShapeViews = new ArrayList<>();
    }

    private final String getContentDescriptionSwitchString(boolean isChecked, String label) {
        Context context;
        int i;
        if (isChecked) {
            context = getMParent().getContext();
            i = C6635R.string.string_on;
        } else {
            context = getMParent().getContext();
            i = C6635R.string.string_off;
        }
        return AbstractC2821a.m2221l(context.getString(i), ", ", label, getMParent().getContext().getString(C6635R.string.string_switch));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final long getRequestTime() {
        return ((Number) this.requestTime.getValue()).longValue();
    }

    private final int getResFromShapeId(int shape) {
        return shape != 0 ? shape != 1 ? shape != 2 ? shape != 3 ? shape != 4 ? C6635R.drawable.widget_setting_preview_bg_shape_00 : C6635R.drawable.widget_setting_preview_bg_shape_04 : C6635R.drawable.widget_setting_preview_bg_shape_03 : C6635R.drawable.widget_setting_preview_bg_shape_02 : C6635R.drawable.widget_setting_preview_bg_shape_01 : C6635R.drawable.widget_setting_preview_bg_shape_00;
    }

    private final int getShapeIdFromRes(int resourceId) {
        if (resourceId == C6635R.drawable.widget_setting_preview_bg_shape_01) {
            return 1;
        }
        if (resourceId == C6635R.drawable.widget_setting_preview_bg_shape_02) {
            return 2;
        }
        if (resourceId == C6635R.drawable.widget_setting_preview_bg_shape_03) {
            return 3;
        }
        return resourceId == C6635R.drawable.widget_setting_preview_bg_shape_04 ? 4 : 0;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initBackgroundOnOff() {
        WidgetCreatorSettingModel mModel;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C6635R.layout.widget_glance_setting_background, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        setMBackgroundOnOffFrameView(getMParent().findViewById(C6635R.id.widget_glance_setting_background_frame_view));
        setMBackgroundOnOffContainerView(getMParent().findViewById(C6635R.id.widget_glance_setting_background_container));
        setMBackgroundOnOffCornerView((RoundCornerOverlayView) getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off_round_corner));
        setMBackgroundOnOffItemView(getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off_item));
        this.mBackgroundOnOffTextView = (TextView) getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off_title);
        View viewFindViewById2 = getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off_switch);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        this.mBackgroundOnOff = (SwitchCompat) viewFindViewById2;
        this.mBackgroundOnOffSubTitle = (TextView) getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off_sub_title);
        SwitchCompat switchCompat = this.mBackgroundOnOff;
        if (switchCompat != null) {
            WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
            Boolean boolValueOf = (widgetCreatorSettingPresenter == null || (mModel = widgetCreatorSettingPresenter.getMModel()) == null) ? null : Boolean.valueOf(mModel.getBackgroundOnOff());
            Intrinsics.checkNotNull(boolValueOf);
            switchCompat.setChecked(boolValueOf.booleanValue());
        }
        this.mBackgroundSwitchLayout = getMParent().findViewById(C6635R.id.widget_glance_setting_background_on_off);
        TextView textView = this.mBackgroundOnOffTextView;
        String str = ((Object) (textView != null ? textView.getText() : null)) + ", ";
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
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter2 = this.mPresenter;
        if ((widgetCreatorSettingPresenter2 != null ? widgetCreatorSettingPresenter2.getOneUiWidgetSource() : null) != null) {
            WidgetCreatorSettingPresenter widgetCreatorSettingPresenter3 = this.mPresenter;
            if (Intrinsics.areEqual(widgetCreatorSettingPresenter3 != null ? widgetCreatorSettingPresenter3.getOneUiWidgetSource() : null, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
                SwitchCompat switchCompat3 = this.mBackgroundOnOff;
                if (switchCompat3 != null) {
                    switchCompat3.setAlpha(0.4f);
                }
                View view3 = this.mBackgroundSwitchLayout;
                if (view3 != null) {
                    view3.setEnabled(false);
                }
                SwitchCompat switchCompat4 = this.mBackgroundOnOff;
                if (switchCompat4 != null) {
                    switchCompat4.setEnabled(false);
                }
                TextView textView2 = this.mBackgroundOnOffSubTitle;
                if (textView2 != null) {
                    textView2.setText(getMParent().getResources().getString(C11391R.string.widget_setting_background_on_off_spage_sub_title));
                }
                TextView textView3 = this.mBackgroundOnOffSubTitle;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            }
        }
        SwitchCompat switchCompat5 = this.mBackgroundOnOff;
        if (switchCompat5 != null) {
            switchCompat5.setOnCheckedChangeListener(new C6958k(this, str, 1));
        }
        SwitchCompat switchCompat6 = this.mBackgroundOnOff;
        Boolean boolValueOf3 = switchCompat6 != null ? Boolean.valueOf(switchCompat6.isChecked()) : null;
        Intrinsics.checkNotNull(boolValueOf3);
        onBackgroundToggled(boolValueOf3.booleanValue());
        View view4 = this.mBackgroundSwitchLayout;
        if (view4 != null) {
            view4.setOnClickListener(new ViewOnClickListenerC6976c(this, 0));
        }
        View view5 = this.mBackgroundSwitchLayout;
        if (view5 != null) {
            view5.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 3));
        }
        initOpacityViewOneUi7x();
        initBackgroundColorOneUI7x();
        updateRoundCornerViewHeight(getMBackgroundOnOffContainerView(), getMBackgroundOnOffFrameView(), getMBackgroundOnOffCornerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$0(WidgetCreatorSettingView widgetCreatorSettingView, String str, CompoundButton compoundButton, boolean z) {
        WidgetCreatorSettingModel mModel;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6135", z ? "1. On" : "2. Off");
        SwitchCompat switchCompat = widgetCreatorSettingView.mBackgroundOnOff;
        if (switchCompat != null) {
            switchCompat.setChecked(z);
        }
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = widgetCreatorSettingView.mPresenter;
        if (widgetCreatorSettingPresenter != null && (mModel = widgetCreatorSettingPresenter.getMModel()) != null) {
            mModel.setBackgroundOnOff(z);
        }
        widgetCreatorSettingView.onBackgroundToggled(z);
        View view = widgetCreatorSettingView.mBackgroundSwitchLayout;
        if (view != null) {
            SwitchCompat switchCompat2 = widgetCreatorSettingView.mBackgroundOnOff;
            Boolean boolValueOf = switchCompat2 != null ? Boolean.valueOf(switchCompat2.isChecked()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            view.setContentDescription(widgetCreatorSettingView.getContentDescriptionSwitchString(boolValueOf.booleanValue(), str));
        }
        widgetCreatorSettingView.updateRoundCornerViewHeight(widgetCreatorSettingView.getMBackgroundOnOffContainerView(), widgetCreatorSettingView.getMBackgroundOnOffFrameView(), widgetCreatorSettingView.getMBackgroundOnOffCornerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$1(WidgetCreatorSettingView widgetCreatorSettingView, View view) {
        SwitchCompat switchCompat = widgetCreatorSettingView.mBackgroundOnOff;
        if (switchCompat != null) {
            switchCompat.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initBackgroundOnOff$lambda$2(WidgetCreatorSettingView widgetCreatorSettingView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            TextView textView = widgetCreatorSettingView.mBackgroundOnOffTextView;
            if (textView != null) {
                textView.setPressed(true);
            }
            SwitchCompat switchCompat = widgetCreatorSettingView.mBackgroundOnOff;
            if (switchCompat != null) {
                switchCompat.setPressed(true);
            }
        } else if (action == 1 || action == 3) {
            TextView textView2 = widgetCreatorSettingView.mBackgroundOnOffTextView;
            if (textView2 != null) {
                textView2.setPressed(false);
            }
            SwitchCompat switchCompat2 = widgetCreatorSettingView.mBackgroundOnOff;
            if (switchCompat2 != null) {
                switchCompat2.setPressed(false);
            }
        }
        return false;
    }

    private final void initSettingBackgroundShape() {
        WidgetCreatorSettingModel mModel;
        WidgetCreatorSettingModel mModel2;
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetCreatorSettingPresenter == null || (mModel2 = widgetCreatorSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel2.getColumn());
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= 2) {
            Object systemService = getMParent().getContext().getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_control_menu_container);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
            ((LinearLayout) viewFindViewById).addView(((LayoutInflater) systemService).inflate(C6635R.layout.widget_creator_glance_setting_control_background_shape, (ViewGroup) null), 0);
            setMBackgroundShapeView(getMParent().findViewById(C6635R.id.widget_creator_glance_setting_control_background_shape));
            this.mBackgroundShapeText = (TextView) getMParent().findViewById(C6635R.id.widget_creator_setting_bg_shape_title);
            View viewFindViewById2 = getMParent().findViewById(C6635R.id.widget_setting_control_background_shape_container);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.mSettingBgShapeContainer = (LinearLayout) viewFindViewById2;
            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C6635R.drawable.widget_setting_preview_bg_shape_00), Integer.valueOf(C6635R.drawable.widget_setting_preview_bg_shape_01), Integer.valueOf(C6635R.drawable.widget_setting_preview_bg_shape_02), Integer.valueOf(C6635R.drawable.widget_setting_preview_bg_shape_03), Integer.valueOf(C6635R.drawable.widget_setting_preview_bg_shape_04)}).iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Context context = getMParent().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView = new WidgetCreatorSettingBgShapeView(context, null, 0, 6, null);
                SwitchCompat switchCompat = this.mBackgroundOnOff;
                widgetCreatorSettingBgShapeView.setSelectable(switchCompat != null ? switchCompat.isChecked() : true);
                widgetCreatorSettingBgShapeView.setImageBg(iIntValue);
                widgetCreatorSettingBgShapeView.setOnSelectListener(new C6960m(this, iIntValue, 1));
                this.mShapeViews.add(widgetCreatorSettingBgShapeView);
                WidgetCreatorSettingPresenter widgetCreatorSettingPresenter2 = this.mPresenter;
                Integer numValueOf2 = (widgetCreatorSettingPresenter2 == null || (mModel = widgetCreatorSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel.getBackgroundShape());
                Intrinsics.checkNotNull(numValueOf2);
                if (getResFromShapeId(numValueOf2.intValue()) == iIntValue) {
                    widgetCreatorSettingBgShapeView.updateState(true);
                    this.mOldPreviewBgShapeView = widgetCreatorSettingBgShapeView;
                    this.mPreviewBgShapeView = widgetCreatorSettingBgShapeView;
                }
                this.mPreviewBgShapeList.put(Integer.valueOf(iIntValue), widgetCreatorSettingBgShapeView);
                View view = this.mSettingBgShapeContainer;
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
                ((LinearLayout) view).addView(widgetCreatorSettingBgShapeView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSettingBackgroundShape$lambda$7$lambda$6$lambda$5(WidgetCreatorSettingView widgetCreatorSettingView, int i, WidgetCreatorSettingBgShapeView selectedView) {
        Intrinsics.checkNotNullParameter(selectedView, "selectedView");
        SwitchCompat switchCompat = widgetCreatorSettingView.mBackgroundOnOff;
        if (switchCompat == null || switchCompat.isChecked()) {
            WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView = widgetCreatorSettingView.mPreviewBgShapeView;
            if (widgetCreatorSettingBgShapeView != null) {
                widgetCreatorSettingBgShapeView.updateState(false);
            }
            selectedView.updateState(true);
            WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView2 = widgetCreatorSettingView.mPreviewBgShapeView;
            int shapeResource = widgetCreatorSettingBgShapeView2 != null ? widgetCreatorSettingBgShapeView2.getMResourceId() : C6635R.drawable.widget_setting_preview_bg_shape_00;
            widgetCreatorSettingView.mPreviewBgShapeView = selectedView;
            widgetCreatorSettingView.updateWidgetBackgroundColor();
            widgetCreatorSettingView.updateOldBackgroundShape(shapeResource, i);
        }
        return Unit.INSTANCE;
    }

    private final void initShortcutComponent() {
        WidgetCreatorSettingModel mModel;
        List<Integer> selectedItems;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        Integer numValueOf = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(C6635R.layout.widget_setting_control_change_component, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        View viewFindViewById2 = viewInflate.findViewById(C6635R.id.widget_setting_change_component_title_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextView) viewFindViewById2).setText(C6635R.string.widget_creator_shortcuts);
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        if (widgetCreatorSettingPresenter != null && (mModel = widgetCreatorSettingPresenter.getMModel()) != null && (selectedItems = mModel.getSelectedItems()) != null) {
            numValueOf = Integer.valueOf(selectedItems.size());
        }
        View viewFindViewById3 = viewInflate.findViewById(C6635R.id.widget_setting_change_component_sub_title_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        Resources resources = getMParent().getResources();
        int i = C6635R.plurals.plurals_total_note_shortcut_component;
        Intrinsics.checkNotNull(numValueOf);
        ((TextView) viewFindViewById3).setText(resources.getQuantityString(i, numValueOf.intValue(), numValueOf));
        View viewFindViewById4 = viewInflate.findViewById(C6635R.id.widget_creator_setting_change_component);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C6635R.id.widget_creator_round_corner_change_component);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        linearLayout.post(new RunnableC4199v(linearLayout, (RoundCornerOverlayView) viewFindViewById5, 6));
        viewInflate.setOnClickListener(new ViewOnClickListenerC6976c(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initShortcutComponent$lambda$3(LinearLayout linearLayout, RoundCornerOverlayView roundCornerOverlayView) {
        int height = linearLayout.getHeight();
        if (height < linearLayout.getResources().getDimensionPixelSize(C6635R.dimen.widget_creator_setting_change_component_round_corner_height) || roundCornerOverlayView.getHeight() == height) {
            return;
        }
        roundCornerOverlayView.setLayoutParams(new RelativeLayout.LayoutParams(-1, height));
        roundCornerOverlayView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initShortcutComponent$lambda$4(WidgetCreatorSettingView widgetCreatorSettingView, View view) {
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = widgetCreatorSettingView.mPresenter;
        if (widgetCreatorSettingPresenter != null) {
            widgetCreatorSettingPresenter.onChangeShortcutClicked();
        }
    }

    private final void initWidgetPreviewContainer() {
        WidgetCreatorSettingModel mModel;
        WidgetCreatorSettingModel mModel2;
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetCreatorSettingPresenter == null || (mModel2 = widgetCreatorSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel2.getWidth());
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter2 = this.mPresenter;
        companion.insertLog("616", "6140", numValueOf + " x " + ((widgetCreatorSettingPresenter2 == null || (mModel = widgetCreatorSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel.getHeight())));
        View viewFindViewById = getMParent().findViewById(C6635R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter3 = this.mPresenter;
        if ((widgetCreatorSettingPresenter3 != null ? widgetCreatorSettingPresenter3.getOneUiWidgetSource() : null) != null) {
            WidgetCreatorSettingPresenter widgetCreatorSettingPresenter4 = this.mPresenter;
            if (StringsKt.m14169y(widgetCreatorSettingPresenter4 != null ? widgetCreatorSettingPresenter4.getOneUiWidgetSource() : null, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getMParent().getContext(), C6635R.color.widget_setting_preview_background));
            }
        }
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter5 = this.mPresenter;
        this.mWidgetCreatorSettingPreview = widgetCreatorSettingPresenter5 != null ? new WidgetCreatorSettingPreview(getMParent(), widgetCreatorSettingPresenter5) : null;
        Context context = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(350249709, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView$initWidgetPreviewContainer$previewCompose$1$1
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
                    ComposerKt.traceEventStart(350249709, i, -1, "com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView.initWidgetPreviewContainer.<anonymous>.<anonymous> (WidgetCreatorSettingView.kt:255)");
                }
                WidgetCreatorSettingPreview widgetCreatorSettingPreview = this.this$0.mWidgetCreatorSettingPreview;
                if (widgetCreatorSettingPreview != null) {
                    widgetCreatorSettingPreview.setContent(this.this$0.getRequestTime(), composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        relativeLayout.addView(composeView);
    }

    private final void setRequestTime(long j) {
        this.requestTime.setValue(Long.valueOf(j));
    }

    private final void updateOldBackgroundShape(int oldResId, int resId) {
        WidgetCreatorSettingModel mModel;
        WidgetCreatorSettingBgShapeView widgetCreatorSettingBgShapeView = this.mPreviewBgShapeList.get(Integer.valueOf(oldResId));
        if (widgetCreatorSettingBgShapeView != null) {
            widgetCreatorSettingBgShapeView.updateState(resId == oldResId);
        }
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        if (widgetCreatorSettingPresenter == null || (mModel = widgetCreatorSettingPresenter.getMModel()) == null) {
            return;
        }
        mModel.setBackgroundShape(getShapeIdFromRes(resId));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetCreatorSettingPresenter);
        return widgetCreatorSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        WidgetCreatorSettingModel mModel;
        super.init();
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        List<Integer> selectedItems = (widgetCreatorSettingPresenter == null || (mModel = widgetCreatorSettingPresenter.getMModel()) == null) ? null : mModel.getSelectedItems();
        Intrinsics.checkNotNull(selectedItems);
        this.mSelectedItems = selectedItems;
        initWidgetPreviewContainer();
        initSettingBackgroundShape();
        initBackgroundOnOff();
        initShortcutComponent();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.glance.setting.presenter.WidgetCreatorSettingPresenter");
        this.mPresenter = (WidgetCreatorSettingPresenter) presenter;
    }

    @Override // com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingContract
    public void updateItemPreview() {
        WidgetCreatorSettingModel mModel;
        WidgetCreatorSettingPresenter widgetCreatorSettingPresenter = this.mPresenter;
        List<Integer> selectedItems = (widgetCreatorSettingPresenter == null || (mModel = widgetCreatorSettingPresenter.getMModel()) == null) ? null : mModel.getSelectedItems();
        Intrinsics.checkNotNull(selectedItems);
        this.mSelectedItems = selectedItems;
        setRequestTime(System.currentTimeMillis());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        setRequestTime(System.currentTimeMillis());
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
        updateWidgetBackgroundColor();
    }
}
