package com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.UiThread;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissLayout;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 +2\u00020\u0001:\u0005*+,-.B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\rJ\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\rJ\b\u0010'\u001a\u00020\u0018H\u0002J+\u0010(\u001a\u00020\u00182#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mAnimationTime", "mCallbacks", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout$Callback;", "mCancelInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "mCompleteDismissGestureInterpolator", "mDismissInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "mDispatchEventListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "actionId", "", "mOnDismissedListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnDismissedListener;", "mOnPreSwipeListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnPreSwipeListener;", "mOnSwipeProgressListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnSwipeProgressChangedListener;", "mStarted", "", "addCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "removeCallback", "resetTranslationAndAlpha", "setDispatchTouchEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Callback", "Companion", "MyOnDismissedListener", "MyOnPreSwipeListener", "MyOnSwipeProgressChangedListener", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@UiThread
@SourceDebugExtension({"SMAP\nSwipeDismissFrameLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SwipeDismissFrameLayout.kt\ncom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
public final class SwipeDismissFrameLayout extends SwipeDismissLayout {
    private static final float DEFAULT_INTERPOLATION_FACTOR = 1.5f;

    @NotNull
    private static final String TAG = "SSS:SwipeDismissFrameLayout";
    private static final float TRANSLATION_MIN_ALPHA = 1.0f;
    private final int mAnimationTime;

    @NotNull
    private final ArrayList<Callback> mCallbacks;

    @NotNull
    private final DecelerateInterpolator mCancelInterpolator;

    @NotNull
    private final DecelerateInterpolator mCompleteDismissGestureInterpolator;

    @NotNull
    private final AccelerateInterpolator mDismissInterpolator;

    @Nullable
    private Function1<? super Integer, Unit> mDispatchEventListener;

    @NotNull
    private final SwipeDismissLayout.OnDismissedListener mOnDismissedListener;

    @NotNull
    private final SwipeDismissLayout.OnPreSwipeListener mOnPreSwipeListener;

    @NotNull
    private final SwipeDismissLayout.OnSwipeProgressChangedListener mOnSwipeProgressListener;
    private boolean mStarted;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout$Callback;", "", "()V", "onDismissed", "", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout;", "onPreSwipeStart", "", "xDown", "", "yDown", "onSwipeCanceled", "onSwipeStarted", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @UiThread
    public static class Callback {
        public void onDismissed(@Nullable SwipeDismissFrameLayout layout) {
        }

        public final boolean onPreSwipeStart(@Nullable SwipeDismissFrameLayout layout, float xDown, float yDown) {
            return true;
        }

        public final void onSwipeCanceled(@Nullable SwipeDismissFrameLayout layout) {
        }

        public final void onSwipeStarted(@Nullable SwipeDismissFrameLayout layout) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout$MyOnDismissedListener;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnDismissedListener;", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout;)V", "onDismissed", "", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public final class MyOnDismissedListener implements SwipeDismissLayout.OnDismissedListener {
        public MyOnDismissedListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDismissed$lambda$0(SwipeDismissFrameLayout this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int size = this$0.mCallbacks.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    Object obj = this$0.mCallbacks.get(size);
                    Intrinsics.checkNotNullExpressionValue(obj, "mCallbacks[i]");
                    ((Callback) obj).onDismissed(this$0);
                    if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            this$0.resetTranslationAndAlpha();
        }

        @Override // com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissLayout.OnDismissedListener
        public void onDismissed(@Nullable SwipeDismissLayout layout) {
            if (Log.isLoggable(SwipeDismissFrameLayout.TAG, 3)) {
                Log.d(SwipeDismissFrameLayout.TAG, "onDismissed()");
            }
            SwipeDismissFrameLayout.this.animate().translationX(SwipeDismissFrameLayout.this.getWidth()).alpha(0.0f).setDuration(SwipeDismissFrameLayout.this.mAnimationTime).setInterpolator(SwipeDismissFrameLayout.this.mStarted ? SwipeDismissFrameLayout.this.mCompleteDismissGestureInterpolator : SwipeDismissFrameLayout.this.mDismissInterpolator).withEndAction(new RunnableC7020a(SwipeDismissFrameLayout.this, 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout$MyOnPreSwipeListener;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnPreSwipeListener;", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout;)V", "onPreSwipe", "", "swipeDismissLayout", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "xDown", "", "yDown", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public final class MyOnPreSwipeListener implements SwipeDismissLayout.OnPreSwipeListener {
        public MyOnPreSwipeListener() {
        }

        @Override // com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissLayout.OnPreSwipeListener
        public boolean onPreSwipe(@Nullable SwipeDismissLayout swipeDismissLayout, float xDown, float yDown) {
            Iterator it = SwipeDismissFrameLayout.this.mCallbacks.iterator();
            while (it.hasNext()) {
                if (!((Callback) it.next()).onPreSwipeStart(SwipeDismissFrameLayout.this, xDown, yDown)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout$MyOnSwipeProgressChangedListener;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnSwipeProgressChangedListener;", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissFrameLayout;)V", "onSwipeCanceled", "", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "onSwipeProgressChanged", "progress", "", "translate", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public final class MyOnSwipeProgressChangedListener implements SwipeDismissLayout.OnSwipeProgressChangedListener {
        public MyOnSwipeProgressChangedListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSwipeCanceled$lambda$0(SwipeDismissFrameLayout this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int size = this$0.mCallbacks.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    Object obj = this$0.mCallbacks.get(size);
                    Intrinsics.checkNotNullExpressionValue(obj, "mCallbacks[i]");
                    ((Callback) obj).onSwipeCanceled(this$0);
                    if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            this$0.resetTranslationAndAlpha();
        }

        @Override // com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissLayout.OnSwipeProgressChangedListener
        public void onSwipeCanceled(@Nullable SwipeDismissLayout layout) {
            if (Log.isLoggable(SwipeDismissFrameLayout.TAG, 3)) {
                Log.d(SwipeDismissFrameLayout.TAG, "onSwipeCanceled() run swipe cancel animation");
            }
            SwipeDismissFrameLayout.this.mStarted = false;
            SwipeDismissFrameLayout.this.animate().translationX(0.0f).alpha(1.0f).setDuration(SwipeDismissFrameLayout.this.mAnimationTime).setInterpolator(SwipeDismissFrameLayout.this.mCancelInterpolator).withEndAction(new RunnableC7020a(SwipeDismissFrameLayout.this, 1));
        }

        @Override // com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissLayout.OnSwipeProgressChangedListener
        public void onSwipeProgressChanged(@Nullable SwipeDismissLayout layout, float progress, float translate) {
            if (Log.isLoggable(SwipeDismissFrameLayout.TAG, 3)) {
                Log.d(SwipeDismissFrameLayout.TAG, "onSwipeProgressChanged() - " + translate);
            }
            SwipeDismissFrameLayout.this.setTranslationX(translate);
            SwipeDismissFrameLayout.this.setAlpha(1 - (progress * 1.0f));
            if (SwipeDismissFrameLayout.this.mStarted) {
                return;
            }
            int size = SwipeDismissFrameLayout.this.mCallbacks.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    Object obj = SwipeDismissFrameLayout.this.mCallbacks.get(size);
                    Intrinsics.checkNotNullExpressionValue(obj, "mCallbacks[i]");
                    ((Callback) obj).onSwipeStarted(SwipeDismissFrameLayout.this);
                    if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            SwipeDismissFrameLayout.this.mStarted = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissFrameLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetTranslationAndAlpha() {
        animate().cancel();
        setTranslationX(0.0f);
        setAlpha(1.0f);
        this.mStarted = false;
    }

    public final void addCallback(@Nullable Callback callback) {
        if (callback == null) {
            throw new NullPointerException("addCallback called with null callback");
        }
        this.mCallbacks.add(callback);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        Function1<? super Integer, Unit> function1;
        if (ev != null && (function1 = this.mDispatchEventListener) != null) {
            function1.invoke(Integer.valueOf(ev.getAction()));
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void removeCallback(@Nullable Callback callback) {
        if (callback == null) {
            throw new NullPointerException("removeCallback called with null callback");
        }
        if (!this.mCallbacks.remove(callback)) {
            throw new IllegalStateException("removeCallback called with nonexistent callback");
        }
    }

    public final void setDispatchTouchEventListener(@Nullable Function1<? super Integer, Unit> listener) {
        this.mDispatchEventListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SwipeDismissFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        MyOnPreSwipeListener myOnPreSwipeListener = new MyOnPreSwipeListener();
        this.mOnPreSwipeListener = myOnPreSwipeListener;
        MyOnDismissedListener myOnDismissedListener = new MyOnDismissedListener();
        this.mOnDismissedListener = myOnDismissedListener;
        MyOnSwipeProgressChangedListener myOnSwipeProgressChangedListener = new MyOnSwipeProgressChangedListener();
        this.mOnSwipeProgressListener = myOnSwipeProgressChangedListener;
        this.mCallbacks = new ArrayList<>();
        setOnPreSwipeListener(myOnPreSwipeListener);
        setOnDismissedListener(myOnDismissedListener);
        setOnSwipeProgressChangedListener(myOnSwipeProgressChangedListener);
        this.mAnimationTime = getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.mCancelInterpolator = new DecelerateInterpolator(1.5f);
        this.mDismissInterpolator = new AccelerateInterpolator(1.5f);
        this.mCompleteDismissGestureInterpolator = new DecelerateInterpolator(1.5f);
    }
}
