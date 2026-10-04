package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularRoundLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0003\u001b\u001e,\u0018\u0000 P2\u00020\u0001:\u0007PQRSTUVB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020!J\u0017\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0017H\u0000¢\u0006\u0002\b'J\u0016\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0017J\u0014\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u0014\u00102\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020300J\u0018\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u0014J\u000e\u0010:\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0007J&\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017J\u0016\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AJ\u0012\u0010C\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J \u0010F\u001a\u00020!2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0002J \u0010G\u001a\u00020!2\u0006\u00105\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0017H\u0002J,\u0010I\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010MH\u0002J \u0010N\u001a\u00020!2\u0006\u0010D\u001a\u00020E2\u0006\u0010O\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ActionListener;", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$OnAnimationListener;", "mFixedItems", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "mCircularViewAdapter", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter;", "mCircularRecyclerView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRecyclerView;", "mCircularRoundLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRoundLayout;", "mSelectedDialItemIdx", "", "mDialItemCount", "mIsShowAnimation", "", "mFixedItemClickListener", "Landroid/view/View$OnClickListener;", "onItemClickListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$onItemClickListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$onItemClickListener$1;", "mAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1;", "close", "", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener$SDK_fullRelease", "showAnimation", "isShown", "showAnimation$SDK_fullRelease", "setVisibility", "visibility", "animation", "mInnerAnimationListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mInnerAnimationListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$mInnerAnimationListener$1;", "setDialItems", "items", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "setFixedItems", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$FixedItem;", "addFixedItem", "index", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getFixedSelectorDrawable", "Landroid/graphics/drawable/Drawable;", "setActionListener", "setSelected", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ButtonType;", "selected", "isScrollAt", "rawX", "", "rawY", "findFixedItemIndex", "view", "Landroid/view/View;", "setFixedItemSelected", "setDialItemSelected", "updateColorDialItem", "startFixedItemAnimation", "startDelay", "", "isShow", "Landroid/animation/Animator$AnimatorListener;", "startDialItemAnimation", "startOffset", "Companion", "ButtonType", "DialItemType", "ColorDialItem", "FixedItem", "ActionListener", "OnAnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSettingQTColorDialLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingQTColorDialLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,361:1\n1#2:362\n172#3,2:363\n*S KotlinDebug\n*F\n+ 1 SpenSettingQTColorDialLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout\n*L\n227#1:363,2\n*E\n"})
public final class SpenSettingQTColorDialLayout extends RelativeLayout {
    private static final float BACKGROUND_END_ANGLE = 90.0f;
    private static final float BACKGROUND_START_ANGLE = 360.0f;
    private static final int DIAL_ITEM_START_DELAY = 16;
    private static final long HIDE_DIAL_ITEM_START_DURATION = 350;
    private static final int MAX_DIALED_ITEM_SIZE_VISIBLE = 10;
    private static final int MAX_FIXED_ITEM_SIZE = 2;
    private static final float SCALE_GONE = 0.0f;
    private static final float SCALE_VISIBLE = 1.0f;
    private static final long SHOW_DIAL_ITEM_START_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenSettingQTColorDialLayout";

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private OnAnimationListener mAnimationListener;

    @NotNull
    private final SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1 mAnimatorListenerAdapter;

    @NotNull
    private final SpenCircularRecyclerView mCircularRecyclerView;

    @NotNull
    private final SpenCircularRoundLayout mCircularRoundLayout;

    @NotNull
    private final SpenCircularViewAdapter mCircularViewAdapter;
    private int mDialItemCount;

    @NotNull
    private final View.OnClickListener mFixedItemClickListener;

    @Nullable
    private List<SpenChipView> mFixedItems;

    @NotNull
    private final SpenSettingQTColorDialLayout$mInnerAnimationListener$1 mInnerAnimationListener;
    private boolean mIsShowAnimation;
    private int mSelectedDialItemIdx;

    @NotNull
    private final SpenSettingQTColorDialLayout$onItemClickListener$1 onItemClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ActionListener;", "", "onFixedButtonClick", "", "index", "", "isSelected", "", "onDialButtonClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onDialButtonClick(int index, boolean isSelected);

        void onFixedButtonClick(int index, boolean isSelected);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED", "DIALED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType FIXED = new ButtonType("FIXED", 0);
        public static final ButtonType DIALED = new ButtonType("DIALED", 1);

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{FIXED, DIALED};
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "", "<init>", "(Ljava/lang/String;I)V", "COLOR", "EMPTY", "DIVIDER", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DialItemType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DialItemType[] $VALUES;
        public static final DialItemType COLOR = new DialItemType("COLOR", 0);
        public static final DialItemType EMPTY = new DialItemType("EMPTY", 1);
        public static final DialItemType DIVIDER = new DialItemType("DIVIDER", 2);

        private static final /* synthetic */ DialItemType[] $values() {
            return new DialItemType[]{COLOR, EMPTY, DIVIDER};
        }

        static {
            DialItemType[] dialItemTypeArr$values = $values();
            $VALUES = dialItemTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dialItemTypeArr$values);
        }

        private DialItemType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<DialItemType> getEntries() {
            return $ENTRIES;
        }

        public static DialItemType valueOf(String str) {
            return (DialItemType) Enum.valueOf(DialItemType.class, str);
        }

        public static DialItemType[] values() {
            return (DialItemType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$OnAnimationListener;", "", "onAnimationStart", "", "onAnimationEnd", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);

        void onAnimationStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonType.values().length];
            try {
                iArr[ButtonType.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonType.DIALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter$OnItemClickListener, com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$onItemClickListener$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mInnerAnimationListener$1] */
    public SpenSettingQTColorDialLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFixedItemClickListener = new ViewOnClickListenerC7538b(this, 17);
        ?? r02 = new SpenCircularViewAdapter.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$onItemClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter.OnItemClickListener
            public void onItemClick(View view, int position) {
                Intrinsics.checkNotNullParameter(view, "view");
                SpenSettingQTColorDialLayout.ActionListener actionListener = this.this$0.mActionListener;
                if (actionListener != null) {
                    actionListener.onDialButtonClick(position, true);
                }
            }
        };
        this.onItemClickListener = r02;
        this.mAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                SpenSettingQTColorDialLayout.OnAnimationListener onAnimationListener = this.this$0.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationEnd(this.this$0.mIsShowAnimation);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                SpenSettingQTColorDialLayout.OnAnimationListener onAnimationListener = this.this$0.mAnimationListener;
                if (onAnimationListener != null) {
                    onAnimationListener.onAnimationStart();
                }
            }
        };
        LayoutInflater.from(context).inflate(C7932R.layout.setting_qt_dial_layout, (ViewGroup) this, true);
        SpenCircularRoundLayout spenCircularRoundLayout = (SpenCircularRoundLayout) findViewById(C7932R.id.circular_mask_layout);
        this.mCircularRoundLayout = spenCircularRoundLayout;
        spenCircularRoundLayout.setAngle(360.0f, BACKGROUND_END_ANGLE);
        spenCircularRoundLayout.setAnimationFillType(SpenCircularRoundLayout.AnimationFillType.START_TO_END);
        SpenCircularViewAdapter spenCircularViewAdapter = new SpenCircularViewAdapter();
        this.mCircularViewAdapter = spenCircularViewAdapter;
        spenCircularViewAdapter.setOnItemClickListener(r02);
        SpenCircularRecyclerView spenCircularRecyclerView = (SpenCircularRecyclerView) findViewById(C7932R.id.circular_recycle_view);
        this.mCircularRecyclerView = spenCircularRecyclerView;
        spenCircularRecyclerView.setAdapter(spenCircularViewAdapter);
        this.mInnerAnimationListener = new OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$mInnerAnimationListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                if (isShowAnimation) {
                    return;
                }
                this.this$0.setVisibility(8);
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout.OnAnimationListener
            public void onAnimationStart() {
            }
        };
    }

    private final SpenChipView addFixedItem(int index, ConstraintLayout parent) {
        List<SpenChipView> list = this.mFixedItems;
        Intrinsics.checkNotNull(list);
        SpenQTAnglePosition spenQTAnglePosition = new SpenQTAnglePosition();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_size) / 2;
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_radius);
        spenQTAnglePosition.setCenterPosition(dimensionPixelSize, dimensionPixelSize);
        spenQTAnglePosition.setRadius(dimensionPixelSize2);
        int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_fixed_item_size);
        int dimensionPixelSize4 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_fixed_item_padding);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenChipView spenChipView = new SpenChipView(context);
        spenChipView.setBackgroundResource(C7932R.drawable.spen_round_ripple);
        spenChipView.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        spenChipView.setPadding(dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4);
        spenChipView.setOnClickListener(this.mFixedItemClickListener);
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3);
        PointF viewPosition = spenQTAnglePosition.getViewPosition(dimensionPixelSize3, dimensionPixelSize3, new Integer[]{60, 30}[index].intValue());
        parent.addView(spenChipView, layoutParams);
        spenChipView.setX(viewPosition.x);
        spenChipView.setY(viewPosition.y);
        list.add(spenChipView);
        return spenChipView;
    }

    private final int findFixedItemIndex(View view) {
        List<SpenChipView> list = this.mFixedItems;
        if (list == null || view == null) {
            return -1;
        }
        Intrinsics.checkNotNull(list);
        return CollectionsKt.indexOf((List<? extends View>) list, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFixedItemClickListener$lambda$0(SpenSettingQTColorDialLayout spenSettingQTColorDialLayout, View view) {
        ActionListener actionListener;
        int iFindFixedItemIndex = spenSettingQTColorDialLayout.findFixedItemIndex(view);
        if (iFindFixedItemIndex <= -1 || (actionListener = spenSettingQTColorDialLayout.mActionListener) == null) {
            return;
        }
        actionListener.onFixedButtonClick(iFindFixedItemIndex, view.isSelected());
    }

    private final void setDialItemSelected(int index, boolean selected, boolean animation) {
        AbstractC6670b.m4754o("setDialItemSelected index=", index, " selected=", selected, TAG);
        if (selected) {
            this.mCircularRecyclerView.setSelectedColor(index);
            if (index >= 0) {
                this.mSelectedDialItemIdx = index;
            }
        }
    }

    private final void setFixedItemSelected(int index, boolean selected, boolean animation) {
        List<SpenChipView> list = this.mFixedItems;
        SpenChipView spenChipView = list != null ? list.get(index) : null;
        if (spenChipView != null) {
            spenChipView.setSelected(selected, animation);
        }
    }

    private final void startDialItemAnimation(View view, long startOffset, boolean isShow) {
        ScaleAnimation scaleAnimation;
        if (isShow) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, view.getWidth() / 2, view.getHeight() / 2);
            scaleAnimation.setDuration(400L);
        } else {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, view.getWidth() / 2, view.getHeight() / 2);
            scaleAnimation2.setDuration(350L);
            scaleAnimation = scaleAnimation2;
        }
        scaleAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        scaleAnimation.setStartOffset(startOffset);
        view.startAnimation(scaleAnimation);
    }

    private final void startFixedItemAnimation(View view, long startDelay, boolean isShow, Animator.AnimatorListener listener) {
        view.animate().cancel();
        this.mIsShowAnimation = isShow;
        if (!isShow) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).setListener(listener).start();
        } else {
            view.setVisibility(8);
            view.setScaleX(0.0f);
            view.setScaleY(0.0f);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).withStartAction(new RunnableC4587a(view, 6)).setListener(listener).start();
        }
    }

    public static /* synthetic */ void startFixedItemAnimation$default(SpenSettingQTColorDialLayout spenSettingQTColorDialLayout, View view, long j, boolean z, Animator.AnimatorListener animatorListener, int i, Object obj) {
        if ((i & 8) != 0) {
            animatorListener = null;
        }
        spenSettingQTColorDialLayout.startFixedItemAnimation(view, j, z, animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorDialItem(boolean isShown) {
        AbstractC4539a.m3208r("updateColorDialItem isShown=", TAG, isShown);
        int i = 0;
        if (!isShown) {
            int i2 = this.mDialItemCount;
            for (int i4 = 0; i4 < i2; i4++) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.mCircularRecyclerView.findViewHolderForLayoutPosition(i4);
                if (viewHolderFindViewHolderForLayoutPosition != null) {
                    View itemView = viewHolderFindViewHolderForLayoutPosition.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    startDialItemAnimation(itemView, 0L, false);
                }
            }
            List<SpenChipView> list = this.mFixedItems;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int i5 = i + 1;
                    startFixedItemAnimation((SpenChipView) it.next(), 0L, false, i == 1 ? this.mAnimatorListenerAdapter : null);
                    i = i5;
                }
                return;
            }
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 10; i7++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition2 = this.mCircularRecyclerView.findViewHolderForLayoutPosition((this.mSelectedDialItemIdx + i7) % this.mDialItemCount);
            if (viewHolderFindViewHolderForLayoutPosition2 != null) {
                View itemView2 = viewHolderFindViewHolderForLayoutPosition2.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                startDialItemAnimation(itemView2, ((long) i6) * 16, true);
                i6++;
            }
        }
        List<SpenChipView> list2 = this.mFixedItems;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            int i8 = i6;
            while (it2.hasNext()) {
                int i9 = i + 1;
                startFixedItemAnimation((SpenChipView) it2.next(), ((long) i8) * 16, true, i == 1 ? this.mAnimatorListenerAdapter : null);
                i8++;
                i = i9;
            }
        }
    }

    public final void close() {
        List<SpenChipView> list = this.mFixedItems;
        if (list != null) {
            list.clear();
        }
        this.mFixedItems = null;
        this.mActionListener = null;
        this.mAnimationListener = null;
        this.mCircularViewAdapter.close();
        this.mCircularRecyclerView.close();
    }

    @Nullable
    public final Drawable getFixedSelectorDrawable(int index) {
        List<SpenChipView> list = this.mFixedItems;
        SpenChipView spenChipView = list != null ? list.get(index) : null;
        if (spenChipView != null) {
            return spenChipView.getSelectorDrawable();
        }
        return null;
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        return this.mCircularRoundLayout.isRawPointInPath(rawX, rawY);
    }

    public final void setActionListener(@NotNull ActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mActionListener = listener;
    }

    public final void setAnimationListener$SDK_fullRelease(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setDialItems(@NotNull List<ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int i = 0;
        for (ColorDialItem colorDialItem : items) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strM1624n = AbstractC2322a.m1624n("#%X", new Object[]{Integer.valueOf(colorDialItem.getColor())}, 1, "format(format, *args)");
            StringBuilder sb = new StringBuilder("[");
            sb.append(i);
            sb.append("] type=");
            sb.append(colorDialItem);
            sb.append(".type, color=");
            AbstractC11014a.m12338w(sb, strM1624n, TAG);
            i++;
        }
        this.mDialItemCount = items.size();
        this.mCircularViewAdapter.updateDialItems(items);
        this.mCircularRecyclerView.setDialItems(items);
    }

    public final void setFixedItems(@NotNull List<FixedItem> items) {
        SpenChipView spenChipViewAddFixedItem;
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.size() > 2) {
            throw new IllegalArgumentException("fixed item size must be less than or equal to 2");
        }
        if (this.mFixedItems == null) {
            this.mFixedItems = new ArrayList();
        }
        List<SpenChipView> list = this.mFixedItems;
        Intrinsics.checkNotNull(list);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C7932R.id.dial_main);
        int i = 0;
        for (FixedItem fixedItem : items) {
            int i2 = i + 1;
            if (i < list.size()) {
                spenChipViewAddFixedItem = list.get(i);
            } else {
                Intrinsics.checkNotNull(constraintLayout);
                spenChipViewAddFixedItem = addFixedItem(i, constraintLayout);
            }
            spenChipViewAddFixedItem.setColorRes(fixedItem.getResourceId());
            spenChipViewAddFixedItem.setSelectorRes(fixedItem.getSelectorResId());
            spenChipViewAddFixedItem.setContentDescription(fixedItem.getDescription());
            spenChipViewAddFixedItem.setTooltipText(fixedItem.getDescription());
            i = i2;
        }
        while (list.size() > items.size()) {
            SpenChipView spenChipView = list.get(CollectionsKt.getLastIndex(list));
            spenChipView.setOnClickListener(null);
            spenChipView.setAccessibilityDelegate(null);
            constraintLayout.removeView(spenChipView);
            list.remove(spenChipView);
            AbstractC2322a.m1631u(list.size(), "fixedItemCount=", TAG);
        }
    }

    public final void setSelected(@NotNull ButtonType type, int index, boolean selected, boolean animation) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            setFixedItemSelected(index, selected, animation);
            setDialItemSelected(-1, selected, animation);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setDialItemSelected(index, selected, animation);
        }
    }

    public final void setVisibility(int visibility, boolean animation) {
        boolean z = animation && (visibility == 0 || getVisibility() == 0);
        AbstractC0000a.m27x(AbstractC2821a.m2226q("setVisibility(", visibility, SQLKeyword.COMMA, animation, ") isAnimation="), z, TAG);
        if (!z || visibility == 4) {
            setVisibility(visibility);
            return;
        }
        if (visibility == 0) {
            setVisibility(0);
        }
        setAnimationListener$SDK_fullRelease(this.mInnerAnimationListener);
        showAnimation$SDK_fullRelease(visibility == 0);
    }

    public final void showAnimation$SDK_fullRelease(boolean isShown) {
        AbstractC4539a.m3208r("startAnimation isShown=", TAG, isShown);
        this.mCircularRoundLayout.startAnimation(isShown);
        if (!isShown) {
            updateColorDialItem(false);
        } else if (getWidth() == 0 || getHeight() == 0) {
            this.mCircularRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout$showAnimation$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    this.this$0.mCircularRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    this.this$0.updateColorDialItem(true);
                }
            });
        } else {
            updateColorDialItem(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "color", "", "description", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;ILjava/lang/CharSequence;)V", "getType", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;", "setType", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$DialItemType;)V", "getColor", "()I", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class ColorDialItem {
        private final int color;

        @Nullable
        private CharSequence description;

        @NotNull
        private DialItemType type;

        public ColorDialItem(@NotNull DialItemType type, int i, @Nullable CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.color = i;
            this.description = charSequence;
        }

        public static /* synthetic */ ColorDialItem copy$default(ColorDialItem colorDialItem, DialItemType dialItemType, int i, CharSequence charSequence, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                dialItemType = colorDialItem.type;
            }
            if ((i2 & 2) != 0) {
                i = colorDialItem.color;
            }
            if ((i2 & 4) != 0) {
                charSequence = colorDialItem.description;
            }
            return colorDialItem.copy(dialItemType, i, charSequence);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DialItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        @NotNull
        public final ColorDialItem copy(@NotNull DialItemType type, int color, @Nullable CharSequence description) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ColorDialItem(type, color, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorDialItem)) {
                return false;
            }
            ColorDialItem colorDialItem = (ColorDialItem) other;
            return this.type == colorDialItem.type && this.color == colorDialItem.color && Intrinsics.areEqual(this.description, colorDialItem.description);
        }

        public final int getColor() {
            return this.color;
        }

        @Nullable
        public final CharSequence getDescription() {
            return this.description;
        }

        @NotNull
        public final DialItemType getType() {
            return this.type;
        }

        public int hashCode() {
            int iM1157c = AbstractC0622a.m1157c(this.color, this.type.hashCode() * 31, 31);
            CharSequence charSequence = this.description;
            return iM1157c + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public final void setDescription(@Nullable CharSequence charSequence) {
            this.description = charSequence;
        }

        public final void setType(@NotNull DialItemType dialItemType) {
            Intrinsics.checkNotNullParameter(dialItemType, "<set-?>");
            this.type = dialItemType;
        }

        @NotNull
        public String toString() {
            return "ColorDialItem(type=" + this.type + ", color=" + this.color + ", description=" + ((Object) this.description) + ")";
        }

        public /* synthetic */ ColorDialItem(DialItemType dialItemType, int i, CharSequence charSequence, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(dialItemType, i, (i2 & 4) != 0 ? null : charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$FixedItem;", "", "resourceId", "", "selectorResId", "description", "", "<init>", "(IILjava/lang/CharSequence;)V", "getResourceId", "()I", "getSelectorResId", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class FixedItem {

        @Nullable
        private CharSequence description;
        private final int resourceId;
        private final int selectorResId;

        public FixedItem(int i, int i2, @Nullable CharSequence charSequence) {
            this.resourceId = i;
            this.selectorResId = i2;
            this.description = charSequence;
        }

        public static /* synthetic */ FixedItem copy$default(FixedItem fixedItem, int i, int i2, CharSequence charSequence, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = fixedItem.resourceId;
            }
            if ((i4 & 2) != 0) {
                i2 = fixedItem.selectorResId;
            }
            if ((i4 & 4) != 0) {
                charSequence = fixedItem.description;
            }
            return fixedItem.copy(i, i2, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSelectorResId() {
            return this.selectorResId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        @NotNull
        public final FixedItem copy(int resourceId, int selectorResId, @Nullable CharSequence description) {
            return new FixedItem(resourceId, selectorResId, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FixedItem)) {
                return false;
            }
            FixedItem fixedItem = (FixedItem) other;
            return this.resourceId == fixedItem.resourceId && this.selectorResId == fixedItem.selectorResId && Intrinsics.areEqual(this.description, fixedItem.description);
        }

        @Nullable
        public final CharSequence getDescription() {
            return this.description;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public final int getSelectorResId() {
            return this.selectorResId;
        }

        public int hashCode() {
            int iM1157c = AbstractC0622a.m1157c(this.selectorResId, Integer.hashCode(this.resourceId) * 31, 31);
            CharSequence charSequence = this.description;
            return iM1157c + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public final void setDescription(@Nullable CharSequence charSequence) {
            this.description = charSequence;
        }

        @NotNull
        public String toString() {
            int i = this.resourceId;
            int i2 = this.selectorResId;
            CharSequence charSequence = this.description;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "FixedItem(resourceId=", ", selectorResId=", ", description=");
            sbM1173s.append((Object) charSequence);
            sbM1173s.append(")");
            return sbM1173s.toString();
        }

        public /* synthetic */ FixedItem(int i, int i2, CharSequence charSequence, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? null : charSequence);
        }
    }
}
