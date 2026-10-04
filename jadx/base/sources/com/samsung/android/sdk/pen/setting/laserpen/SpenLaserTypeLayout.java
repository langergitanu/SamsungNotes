package com.samsung.android.sdk.pen.setting.laserpen;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mType", "", "mFillInside", "", "mLaserPointerUIType", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout$LaserPointerUIType;", "mTabGroup", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "mLaserTypeChangedListener", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout$OnLaserTypeChangedListener;", "close", "", "setType", "type", "fillInside", "setLaserTypeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "construct", "initView", "layoutId", "getUITypeFromValue", "getViewIdFromUIType", "pointerUIType", "getUITypeFromId", "id", "changeUIType", "Companion", "LaserPointerUIType", "OnLaserTypeChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenLaserTypeLayout extends FrameLayout {
    public static final int LASER_TYPE_LINE = 1;
    public static final int LASER_TYPE_POINT = 0;

    @NotNull
    private static final String TAG = "SpenLaserTypeLayout";
    private boolean mFillInside;

    @NotNull
    private LaserPointerUIType mLaserPointerUIType;

    @Nullable
    private OnLaserTypeChangedListener mLaserTypeChangedListener;
    private SpenTabGroup mTabGroup;
    private int mType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout$LaserPointerUIType;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID_STROKE", "OUTLINED_STROKE", "DOT", CoverStickerConstants.Category.NONE.NAME, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class LaserPointerUIType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LaserPointerUIType[] $VALUES;
        public static final LaserPointerUIType SOLID_STROKE = new LaserPointerUIType("SOLID_STROKE", 0);
        public static final LaserPointerUIType OUTLINED_STROKE = new LaserPointerUIType("OUTLINED_STROKE", 1);
        public static final LaserPointerUIType DOT = new LaserPointerUIType("DOT", 2);
        public static final LaserPointerUIType NONE = new LaserPointerUIType(CoverStickerConstants.Category.NONE.NAME, 3);

        private static final /* synthetic */ LaserPointerUIType[] $values() {
            return new LaserPointerUIType[]{SOLID_STROKE, OUTLINED_STROKE, DOT, NONE};
        }

        static {
            LaserPointerUIType[] laserPointerUITypeArr$values = $values();
            $VALUES = laserPointerUITypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(laserPointerUITypeArr$values);
        }

        private LaserPointerUIType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<LaserPointerUIType> getEntries() {
            return $ENTRIES;
        }

        public static LaserPointerUIType valueOf(String str) {
            return (LaserPointerUIType) Enum.valueOf(LaserPointerUIType.class, str);
        }

        public static LaserPointerUIType[] values() {
            return (LaserPointerUIType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout$OnLaserTypeChangedListener;", "", "onLaserTypeChanged", "", "uiType", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout$LaserPointerUIType;", "type", "", "fillInside", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnLaserTypeChangedListener {
        void onLaserTypeChanged(@NotNull LaserPointerUIType uiType, int type, boolean fillInside);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LaserPointerUIType.values().length];
            try {
                iArr[LaserPointerUIType.DOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LaserPointerUIType.SOLID_STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LaserPointerUIType.OUTLINED_STROKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenLaserTypeLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLaserPointerUIType = LaserPointerUIType.NONE;
        construct(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeUIType(LaserPointerUIType type) {
        Log.i(TAG, "changeUIType() : type=" + type + " ");
        if (type == this.mLaserPointerUIType) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.mType = 0;
        } else if (i == 2) {
            this.mType = 1;
            this.mFillInside = true;
        } else {
            if (i != 3) {
                Log.i(TAG, "changeUIType() : invalid type(" + type + ")");
                return;
            }
            this.mType = 1;
            this.mFillInside = false;
        }
        this.mLaserPointerUIType = type;
        OnLaserTypeChangedListener onLaserTypeChangedListener = this.mLaserTypeChangedListener;
        if (onLaserTypeChangedListener != null) {
            onLaserTypeChangedListener.onLaserTypeChanged(type, this.mType, this.mFillInside);
        }
    }

    private final void construct(Context context) {
        initView(context, C7932R.layout.setting_laser_pen_type_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaserPointerUIType getUITypeFromId(int id) {
        return id == C7932R.id.laser_dot_view ? LaserPointerUIType.DOT : id == C7932R.id.laser_solid_stroke_view ? LaserPointerUIType.SOLID_STROKE : id == C7932R.id.laser_outlined_stroke_view ? LaserPointerUIType.OUTLINED_STROKE : LaserPointerUIType.NONE;
    }

    private final LaserPointerUIType getUITypeFromValue(int type, boolean fillInside) {
        return type != 0 ? type != 1 ? LaserPointerUIType.NONE : fillInside ? LaserPointerUIType.SOLID_STROKE : LaserPointerUIType.OUTLINED_STROKE : LaserPointerUIType.DOT;
    }

    private final int getViewIdFromUIType(LaserPointerUIType pointerUIType) {
        int i = WhenMappings.$EnumSwitchMapping$0[pointerUIType.ordinal()];
        if (i == 1) {
            return C7932R.id.laser_dot_view;
        }
        if (i == 2) {
            return C7932R.id.laser_solid_stroke_view;
        }
        if (i != 3) {
            return -1;
        }
        return C7932R.id.laser_outlined_stroke_view;
    }

    private final void initView(Context context, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        int color = SpenSettingUtil.getColor(context, C7932R.color.component_common);
        View viewFindViewById = findViewById(C7932R.id.laser_solid_stroke_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        imageView.setColorFilter(color);
        SpenSettingUtilHover.setHoverText(imageView, context.getResources().getString(C7932R.string.pen_string_laser_type_solid_stroke));
        View viewFindViewById2 = findViewById(C7932R.id.laser_outlined_stroke_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById2;
        imageView2.setColorFilter(color);
        SpenSettingUtilHover.setHoverText(imageView2, context.getResources().getString(C7932R.string.pen_string_laser_type_outlined_stroke));
        View viewFindViewById3 = findViewById(C7932R.id.laser_dot_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById3;
        imageView3.setColorFilter(color);
        SpenSettingUtilHover.setHoverText(imageView3, context.getResources().getString(C7932R.string.pen_string_laser_type_dot));
        SpenTabGroup spenTabGroup = new SpenTabGroup();
        this.mTabGroup = spenTabGroup;
        spenTabGroup.addTab(imageView);
        SpenTabGroup spenTabGroup2 = this.mTabGroup;
        SpenTabGroup spenTabGroup3 = null;
        if (spenTabGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabGroup");
            spenTabGroup2 = null;
        }
        spenTabGroup2.addTab(imageView2);
        SpenTabGroup spenTabGroup4 = this.mTabGroup;
        if (spenTabGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabGroup");
            spenTabGroup4 = null;
        }
        spenTabGroup4.addTab(imageView3);
        SpenTabGroup spenTabGroup5 = this.mTabGroup;
        if (spenTabGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabGroup");
        } else {
            spenTabGroup3 = spenTabGroup5;
        }
        spenTabGroup3.setOnTabSelectedListener(new SpenTabGroup.OnTabSelectedListener() { // from class: com.samsung.android.sdk.pen.setting.laserpen.SpenLaserTypeLayout.initView.1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabSelected(View tab) {
                Log.i(SpenLaserTypeLayout.TAG, "onTabSelected()");
                if (tab != null) {
                    int id = tab.getId();
                    SpenLaserTypeLayout spenLaserTypeLayout = SpenLaserTypeLayout.this;
                    LaserPointerUIType uITypeFromId = spenLaserTypeLayout.getUITypeFromId(id);
                    if (uITypeFromId == spenLaserTypeLayout.mLaserPointerUIType) {
                        return;
                    }
                    spenLaserTypeLayout.changeUIType(uITypeFromId);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabReselected(View tab) {
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabUnselected(View tab) {
            }
        });
    }

    public final void close() {
        SpenTabGroup spenTabGroup = null;
        this.mLaserTypeChangedListener = null;
        SpenTabGroup spenTabGroup2 = this.mTabGroup;
        if (spenTabGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabGroup");
        } else {
            spenTabGroup = spenTabGroup2;
        }
        spenTabGroup.close();
    }

    public final void setLaserTypeChangedListener(@Nullable OnLaserTypeChangedListener listener) {
        this.mLaserTypeChangedListener = listener;
    }

    public final void setType(int type, boolean fillInside) {
        AbstractC6670b.m4754o("setType() type=", type, " fillInside=", fillInside, TAG);
        LaserPointerUIType uITypeFromValue = getUITypeFromValue(type, fillInside);
        this.mType = type;
        this.mFillInside = fillInside;
        if (this.mLaserPointerUIType == uITypeFromValue) {
            return;
        }
        this.mLaserPointerUIType = uITypeFromValue;
        SpenTabGroup spenTabGroup = this.mTabGroup;
        if (spenTabGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabGroup");
            spenTabGroup = null;
        }
        spenTabGroup.select(getViewIdFromUIType(uITypeFromValue));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenLaserTypeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLaserPointerUIType = LaserPointerUIType.NONE;
        construct(context);
    }
}
