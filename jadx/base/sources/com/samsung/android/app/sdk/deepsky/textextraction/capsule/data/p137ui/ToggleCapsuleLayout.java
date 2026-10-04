package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.util.RoleDescriptionAccessibilityDelegate;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020!2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/ToggleCapsuleLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "iconUri", "Landroid/net/Uri;", "title", "", "isChecked", "", "capsuleColor", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleColor;", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;ZLcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleColor;)V", "imageView", "Landroid/widget/ImageView;", "()Z", "setChecked", "(Z)V", DBSchema.DocumentThumbnail.LAYOUT, "offListener", "Landroid/view/View$OnClickListener;", "getOffListener", "()Landroid/view/View$OnClickListener;", "setOffListener", "(Landroid/view/View$OnClickListener;)V", "onListener", "getOnListener", "setOnListener", "textView", "Landroid/widget/TextView;", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "initViews", "", "onClick", "view", "Landroid/view/View;", "updateCapsule", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nToggleCapsuleLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToggleCapsuleLayout.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/ToggleCapsuleLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
public final class ToggleCapsuleLayout extends LinearLayout {

    @NotNull
    private static final String TAG = "ToggleCapsuleLayout";

    @NotNull
    private CapsuleColor capsuleColor;

    @NotNull
    private final Uri iconUri;
    private ImageView imageView;
    private boolean isChecked;
    private LinearLayout layout;

    @Nullable
    private View.OnClickListener offListener;

    @Nullable
    private View.OnClickListener onListener;
    private TextView textView;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleCapsuleLayout(@Nullable Context context, @NotNull Uri iconUri, @NotNull String title, boolean z, @NotNull CapsuleColor capsuleColor) {
        super(context);
        Intrinsics.checkNotNullParameter(iconUri, "iconUri");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleColor, "capsuleColor");
        this.iconUri = iconUri;
        this.title = title;
        this.isChecked = z;
        this.capsuleColor = capsuleColor;
        initViews();
    }

    private final void initViews() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(C7039R.dimen.capsule_extract_text_action_view_height), getContext().getResources().getDimensionPixelSize(C7039R.dimen.capsule_extract_text_action_view_height));
        layoutParams.setMarginEnd(getContext().getResources().getDimensionPixelSize(C7039R.dimen.capsule_spacing));
        setLayoutParams(layoutParams);
        View viewInflate = View.inflate(getContext(), C7039R.layout.capsule_view, null);
        View viewFindViewById = viewInflate.findViewById(C7039R.id.capture_ai_bottom_action);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "this.findViewById(R.id.capture_ai_bottom_action)");
        this.layout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C7039R.id.capture_ai_bottom_action_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "this.findViewById(R.id.c…re_ai_bottom_action_text)");
        this.textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C7039R.id.capture_ai_bottom_action_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "this.findViewById(R.id.c…re_ai_bottom_action_icon)");
        this.imageView = (ImageView) viewFindViewById3;
        viewInflate.setOnClickListener(new ViewOnClickListenerC0157a(this, 14));
        addView(viewInflate);
        updateCapsule(this.isChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$lambda$1(ToggleCapsuleLayout this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onClick(it);
    }

    private final void onClick(View view) {
        LinearLayout linearLayout = null;
        if (this.isChecked) {
            View.OnClickListener onClickListener = this.offListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            LinearLayout linearLayout2 = this.layout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
                linearLayout2 = null;
            }
            linearLayout2.getBackground().setTint(this.capsuleColor.getBackgroundColor());
            TextView textView = this.textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView = null;
            }
            textView.setTextColor(this.capsuleColor.getTextColor());
            ImageView imageView = this.imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView = null;
            }
            imageView.setImageTintList(ColorStateList.valueOf(this.capsuleColor.getTextColor()));
            LinearLayout linearLayout3 = this.layout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setStateDescription(getContext().getResources().getString(C7039R.string.capsule_toggle_off));
        } else {
            View.OnClickListener onClickListener2 = this.onListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
            LinearLayout linearLayout4 = this.layout;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
                linearLayout4 = null;
            }
            linearLayout4.getBackground().setTint(this.capsuleColor.getPressedBackgroundColor());
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView2 = null;
            }
            textView2.setTextColor(this.capsuleColor.getPressedTextColor());
            ImageView imageView2 = this.imageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView2 = null;
            }
            imageView2.setImageTintList(ColorStateList.valueOf(this.capsuleColor.getPressedTextColor()));
            LinearLayout linearLayout5 = this.layout;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            } else {
                linearLayout = linearLayout5;
            }
            linearLayout.setStateDescription(getContext().getResources().getString(C7039R.string.capsule_toggle_on));
        }
        announceForAccessibility(this.title);
        this.isChecked = !this.isChecked;
    }

    @Nullable
    public final View.OnClickListener getOffListener() {
        return this.offListener;
    }

    @Nullable
    public final View.OnClickListener getOnListener() {
        return this.onListener;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setOffListener(@Nullable View.OnClickListener onClickListener) {
        this.offListener = onClickListener;
    }

    public final void setOnListener(@Nullable View.OnClickListener onClickListener) {
        this.onListener = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateCapsule(boolean isChecked) {
        Drawable drawableMutate;
        ImageView imageView = null;
        if (isChecked) {
            Drawable drawable = AppCompatResources.getDrawable(getContext(), C7039R.drawable.capsule_toggle_on_background);
            if (drawable == null || (drawableMutate = drawable.mutate()) == null) {
                drawableMutate = null;
            } else {
                drawableMutate.setTint(this.capsuleColor.getPressedBackgroundColor());
            }
        } else {
            Drawable drawable2 = AppCompatResources.getDrawable(getContext(), C7039R.drawable.capsule_icon_background);
            if (drawable2 != null && (drawableMutate = drawable2.mutate()) != null) {
                drawableMutate.setTint(this.capsuleColor.getBackgroundColor());
            }
        }
        Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
        RippleDrawable rippleDrawable = (RippleDrawable) drawableMutate;
        rippleDrawable.setColor(ColorStateList.valueOf(this.capsuleColor.getRippleColor()));
        LinearLayout linearLayout = this.layout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            linearLayout = null;
        }
        linearLayout.setBackground(rippleDrawable);
        LinearLayout linearLayout2 = this.layout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            linearLayout2 = null;
        }
        linearLayout2.setTooltipText(this.title);
        LinearLayout linearLayout3 = this.layout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            linearLayout3 = null;
        }
        linearLayout3.setContentDescription(this.title);
        LinearLayout linearLayout4 = this.layout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DBSchema.DocumentThumbnail.LAYOUT);
            linearLayout4 = null;
        }
        String string = getContext().getResources().getString(C7039R.string.capsule_role_button);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.capsule_role_button)");
        ViewCompat.setAccessibilityDelegate(linearLayout4, new RoleDescriptionAccessibilityDelegate(string));
        int pressedTextColor = isChecked ? this.capsuleColor.getPressedTextColor() : this.capsuleColor.getTextColor();
        TextView textView = this.textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setText(this.title);
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView2 = null;
        }
        textView2.setTextColor(pressedTextColor);
        ImageView imageView2 = this.imageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView2 = null;
        }
        imageView2.setImageURI(this.iconUri);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView = imageView3;
        }
        imageView.setImageTintList(ColorStateList.valueOf(pressedTextColor));
    }
}
