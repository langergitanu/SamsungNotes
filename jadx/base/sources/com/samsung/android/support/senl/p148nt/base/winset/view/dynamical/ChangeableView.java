package com.samsung.android.support.senl.p148nt.base.winset.view.dynamical;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.scsp.common.Header;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000bH&J\b\u0010#\u001a\u00020$H&R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/dynamical/ChangeableView;", "Landroid/view/View;", "Lcom/samsung/android/support/senl/nt/base/winset/view/dynamical/IChangeable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "", "isShowing", "()Z", Constants.IntentExtraValue.SHOW, "size", "hide", "", "changeSize", "to", Header.LOCATION, "Landroid/graphics/Rect;", "getLocation", "()Landroid/graphics/Rect;", "slideAnimator", "Landroid/animation/ValueAnimator;", "getSlideAnimator", "()Landroid/animation/ValueAnimator;", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "view", "getTag", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ChangeableView extends View implements IChangeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int SLIDE_DURATION = 200;
    private static final boolean isSupportAnimation = false;
    private boolean isShowing;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\u0006\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/dynamical/ChangeableView$Companion;", "", "<init>", "()V", "SLIDE_DURATION", "", "isSupportAnimation", "", "isSupportAnimation$annotations", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isSupportAnimation$annotations() {
        }

        public final boolean isSupportAnimation() {
            return ChangeableView.isSupportAnimation;
        }

        private Companion() {
        }
    }

    public ChangeableView(@Nullable Context context) {
        super(context);
    }

    public static final boolean isSupportAnimation() {
        return INSTANCE.isSupportAnimation();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable
    public void changeSize(int to) {
        update(this, to);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable
    @NotNull
    public Rect getLocation() {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = getWidth() + i;
        rect.bottom = getHeight() + rect.top;
        return rect;
    }

    @NotNull
    public final ValueAnimator getSlideAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(200L);
        valueAnimator.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.4f, 1.0f));
        return valueAnimator;
    }

    @Override // android.view.View
    @NotNull
    public abstract String getTag();

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable
    public void hide() {
        if (this.isShowing) {
            AbstractC4539a.m3188B("hide : ", Integer.toHexString(hashCode()), getTag());
            this.isShowing = false;
            changeSize(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable
    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable
    public boolean show(int size) {
        if (this.isShowing) {
            return false;
        }
        AbstractC4539a.m3188B("show : ", Integer.toHexString(hashCode()), getTag());
        this.isShowing = true;
        changeSize(size);
        return true;
    }

    public abstract void update(@NotNull View view, int value);

    public ChangeableView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeableView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ChangeableView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
