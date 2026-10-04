package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.AppCompatImageView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "extendedDirection", "", "<init>", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mButtonType", "Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton$Type;", "mExtendedDirection", "mIsRTL", "", "buttonType", "getButtonType", "()Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton$Type;", "setButtonType", "", "needAnimation", "setType", "type", "setButton", "getDrawableId", "isUpDownDirection", "getAnimateDrawableId", "getHoverText", "", "setAttributes", "Companion", PackageRelationship.TYPE_ATTRIBUTE_NAME, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniCloseButton extends AppCompatImageView {
    public static final int EXT_DIR_LEFT_RIGHT = 0;
    public static final int EXT_DIR_UP_DOWN = 1;

    @NotNull
    private static final String TAG = "SpenMiniCloseButton";

    @Nullable
    private Type mButtonType;
    private int mExtendedDirection;
    private final boolean mIsRTL;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton$Type;", "", "<init>", "(Ljava/lang/String;I)V", CoeditGrpcMethod.Caller.CLOSE, "BACK", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type CLOSE = new Type(CoeditGrpcMethod.Caller.CLOSE, 0);
        public static final Type BACK = new Type("BACK", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CLOSE, BACK};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenMiniCloseButton(@NotNull Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getAnimateDrawableId(Type type) {
        return type == Type.BACK ? isUpDownDirection() ? C7932R.drawable.animated_close_to_back : this.mIsRTL ? C7932R.drawable.animated_close_to_right : C7932R.drawable.animated_close_to_left : isUpDownDirection() ? C7932R.drawable.animated_back_to_close : this.mIsRTL ? C7932R.drawable.animated_right_to_close : C7932R.drawable.animated_left_to_close;
    }

    private final int getDrawableId(Type type) {
        return type == Type.BACK ? isUpDownDirection() ? C7932R.drawable.setting_mini_top : this.mIsRTL ? C7932R.drawable.setting_mini_right : C7932R.drawable.setting_mini_left : C7932R.drawable.setting_mini_close;
    }

    private final String getHoverText(Type buttonType) {
        Resources resources = getContext().getResources();
        int i = WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()];
        if (i == 1) {
            String string = resources.getString(C7932R.string.pen_string_close_any, resources.getString(C7932R.string.pen_string_close_pen_settings));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        String string2 = resources.getString(C7932R.string.pen_string_collapse);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final boolean isUpDownDirection() {
        return this.mExtendedDirection == 1;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            this.mExtendedDirection = 1;
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C7932R.styleable.SpenMiniCloseButton);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mExtendedDirection = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenMiniCloseButton_extendedDirection, 1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void setButton(Type type, boolean needAnimation) {
        Drawable drawable = SpenSettingUtilDrawable.getDrawable(getContext(), needAnimation ? getAnimateDrawableId(type) : getDrawableId(type));
        setImageDrawable(drawable);
        if (needAnimation) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            Intrinsics.checkNotNull(animatedVectorDrawable);
            animatedVectorDrawable.start();
        }
    }

    private final void setType(Type type) {
        this.mButtonType = type;
        String hoverText = getHoverText(type);
        setContentDescription(hoverText);
        SpenSettingUtilHover.setHoverText(this, hoverText);
    }

    @Nullable
    /* JADX INFO: renamed from: getButtonType, reason: from getter */
    public final Type getMButtonType() {
        return this.mButtonType;
    }

    public final void setButtonType(@NotNull Type buttonType, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Type type = this.mButtonType;
        StringBuilder sb = new StringBuilder("setButtonType() from:");
        sb.append(type);
        sb.append(" to:");
        sb.append(buttonType);
        sb.append(" animation=");
        AbstractC0000a.m27x(sb, needAnimation, TAG);
        Type type2 = this.mButtonType;
        if (type2 == null || type2 != buttonType) {
            setButton(buttonType, needAnimation);
            setType(buttonType);
        }
    }

    public /* synthetic */ SpenMiniCloseButton(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 1 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenMiniCloseButton(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsRTL = AbstractC0541b.m759a(context) == 1;
        this.mExtendedDirection = i;
        setButtonType(Type.CLOSE, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMiniCloseButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsRTL = AbstractC0541b.m759a(context) == 1;
        setAttributes(context, attributeSet);
        setButtonType(Type.CLOSE, false);
    }
}
