package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.google.android.material.oneui.floatingdock.FloatingPane;
import com.google.android.material.oneui.floatingdock.FloatingPaneLayout;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AiResultLayout;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0013\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout;", "Lcom/google/android/material/oneui/floatingdock/FloatingPaneLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mFloatingPaneCallback", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout$FloatingPaneCallback;", "isKeepSelectedPaneMode", "", "()Z", "setKeepSelectedPaneMode", "(Z)V", "mResultPaneCallback", "com/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout$mResultPaneCallback$1", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout$mResultPaneCallback$1;", "addCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "removeCallback", "FloatingPaneCallback", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AiResultLayout extends FloatingPaneLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MODE_ALL;
    private static final int MODE_BOTTOM;
    private static final int MODE_FLOATING;
    private static final int MODE_NONE;
    private static final int MODE_SIDE;
    private static final int STATE_IDLE;
    private static final int STATE_MOVE;
    private static final int STATE_RESIZE;

    @NotNull
    public static final String TAG = "AiResultLayout";
    private boolean isKeepSelectedPaneMode;

    @Nullable
    private FloatingPaneCallback mFloatingPaneCallback;

    @NotNull
    private final AiResultLayout$mResultPaneCallback$1 mResultPaneCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0015\u0010\u0006\u001a\u00020\u00078G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\bR\u0015\u0010\n\u001a\u00020\u00078G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u000b\u001a\u00020\u00078G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0015\u0010\f\u001a\u00020\u00078G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u0015\u0010\r\u001a\u00020\u00078G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\u0015\u0010\u000e\u001a\u00020\u000f8G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0015\u0010\u0010\u001a\u00020\u000f8G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0010\u0010\bR\u0015\u0010\u0011\u001a\u00020\u000f8G¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MODE_NONE", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "()I", "I", "MODE_BOTTOM", "MODE_SIDE", "MODE_FLOATING", "MODE_ALL", "STATE_IDLE", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "STATE_MOVE", "STATE_RESIZE", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmName(name = "MODE_ALL")
        public final int MODE_ALL() {
            return AiResultLayout.MODE_ALL;
        }

        @JvmName(name = "MODE_BOTTOM")
        public final int MODE_BOTTOM() {
            return AiResultLayout.MODE_BOTTOM;
        }

        @JvmName(name = "MODE_FLOATING")
        public final int MODE_FLOATING() {
            return AiResultLayout.MODE_FLOATING;
        }

        @JvmName(name = "MODE_NONE")
        public final int MODE_NONE() {
            return AiResultLayout.MODE_NONE;
        }

        @JvmName(name = "MODE_SIDE")
        public final int MODE_SIDE() {
            return AiResultLayout.MODE_SIDE;
        }

        @JvmName(name = "STATE_IDLE")
        public final int STATE_IDLE() {
            return AiResultLayout.STATE_IDLE;
        }

        @JvmName(name = "STATE_MOVE")
        public final int STATE_MOVE() {
            return AiResultLayout.STATE_MOVE;
        }

        @JvmName(name = "STATE_RESIZE")
        public final int STATE_RESIZE() {
            return AiResultLayout.STATE_RESIZE;
        }

        private Companion() {
        }
    }

    static {
        FloatingPane.FloatingPaneMode.Companion companion = FloatingPane.FloatingPaneMode.INSTANCE;
        MODE_NONE = companion.MODE_NONE();
        MODE_BOTTOM = companion.MODE_BOTTOM();
        MODE_SIDE = companion.MODE_SIDE();
        MODE_FLOATING = companion.MODE_FLOATING();
        MODE_ALL = companion.MODE_ALL();
        FloatingPane.FloatingPaneState.Companion companion2 = FloatingPane.FloatingPaneState.INSTANCE;
        STATE_IDLE = companion2.STATE_IDLE();
        STATE_MOVE = companion2.STATE_MOVE();
        STATE_RESIZE = companion2.STATE_RESIZE();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AiResultLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void addCallback(@NotNull FloatingPaneCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mFloatingPaneCallback = callback;
        addCallback(this.mResultPaneCallback);
    }

    /* JADX INFO: renamed from: isKeepSelectedPaneMode, reason: from getter */
    public final boolean getIsKeepSelectedPaneMode() {
        return this.isKeepSelectedPaneMode;
    }

    public final void removeCallback() {
        removeCallback(this.mResultPaneCallback);
    }

    public final void setKeepSelectedPaneMode(boolean z) {
        this.isKeepSelectedPaneMode = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AiResultLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AiResultLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AiResultLayout(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout$mResultPaneCallback$1] */
    @JvmOverloads
    public AiResultLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mResultPaneCallback = new IFloatingPaneCallback() { // from class: com.samsung.android.support.senl.cm.base.framework.sem.view.AiResultLayout$mResultPaneCallback$1
            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            public void onFloatingMoved(int left, int top) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onFloatingMoved(left, top);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            public void onInsert(Rect rect) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onInsert(rect);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            /* JADX INFO: renamed from: onModeChanged-J5JjPLc, reason: not valid java name and merged with bridge method [inline-methods] */
            public void onModeChanged(int newMode) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onModeChanged(newMode);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            public void onPreInsert(Rect rect) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onPreInsert(rect);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            public void onResizeAnimate(Rect from, Rect to, long duration) {
                Intrinsics.checkNotNullParameter(from, "from");
                Intrinsics.checkNotNullParameter(to, "to");
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onResizeAnimate(from, to, duration);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            /* JADX INFO: renamed from: onStateChanged-IywsXb8, reason: not valid java name and merged with bridge method [inline-methods] */
            public void onStateChanged(int state) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onStateChanged(state);
                }
            }

            @Override // com.google.android.material.oneui.floatingdock.IFloatingPaneCallback
            public void onVisibilityChanged(int visibility) {
                AiResultLayout.FloatingPaneCallback floatingPaneCallback = this.this$0.mFloatingPaneCallback;
                if (floatingPaneCallback != null) {
                    floatingPaneCallback.onVisibilityChanged(visibility);
                }
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u000bJ \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AiResultLayout$FloatingPaneCallback;", "", "<init>", "()V", "onInsert", "", "rect", "Landroid/graphics/Rect;", "onModeChanged", "newMode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "(I)V", "onPreInsert", "onFloatingMoved", "left", "", "top", "onVisibilityChanged", "visibility", "onStateChanged", "state", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneState;", "onResizeAnimate", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class FloatingPaneCallback {
        public void onResizeAnimate(@NotNull Rect from, @NotNull Rect to, long duration) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
        }

        public void onInsert(@Nullable Rect rect) {
        }

        @JvmName(name = "onModeChanged")
        public void onModeChanged(int newMode) {
        }

        public void onPreInsert(@Nullable Rect rect) {
        }

        @JvmName(name = "onStateChanged")
        public void onStateChanged(int state) {
        }

        public void onVisibilityChanged(int visibility) {
        }

        public void onFloatingMoved(int left, int top) {
        }
    }
}
