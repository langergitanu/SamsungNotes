package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation;

import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.SmartTipPopup;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ*\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/STTGuideTip;", "", "<init>", "()V", "mGuideTipPopupRef", "Ljava/lang/ref/WeakReference;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/util/SmartTipPopup;", "guideTipPopup", "getGuideTipPopup", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/util/SmartTipPopup;", "disableShowCondition", "", "release", "showGuideTip", "targetView", "Landroid/view/View;", "stateBadgeView", "text", "", "locations", "", "hasNotUsedSTT", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTGuideTip {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String TAG;

    @Nullable
    private static STTGuideTip mInstance;

    @Nullable
    private WeakReference<SmartTipPopup> mGuideTipPopupRef;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u001e\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/STTGuideTip$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "mInstance", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/STTGuideTip;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/STTGuideTip;", "hasInstance", "", Constants.ARG_UPDATE, "", "dismiss", Constants.IntentExtraValue.SHOW, "view", "Landroid/view/View;", "stateBadgeView", "locations", "", "hasShowCondition", "canShow", "targetView", "showDelayedAfterLaidOut", "isShowing", "()Z", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canShow(View targetView) {
            if (targetView != null) {
                return hasShowCondition() && targetView.isShown();
            }
            Logger.m11000e(getTAG(), "canShow# targetView is null");
            return false;
        }

        private final synchronized STTGuideTip getInstance() {
            try {
                if (STTGuideTip.mInstance == null) {
                    STTGuideTip.mInstance = new STTGuideTip();
                }
            } catch (Throwable th) {
                throw th;
            }
            return STTGuideTip.mInstance;
        }

        private final boolean hasInstance() {
            return STTGuideTip.mInstance != null;
        }

        private final void showDelayedAfterLaidOut(View targetView, View stateBadgeView, int[] locations) {
            Logger.m11003i(getTAG(), "showDelayedAfterLaidOut +");
            if (canShow(targetView)) {
                STTGuideTip companion = getInstance();
                SmartTipPopup guideTipPopup = companion != null ? companion.getGuideTipPopup() : null;
                if (guideTipPopup == null || !guideTipPopup.isShowing()) {
                    Logger.m11003i(getTAG(), "showDelayedAfterLaidOut -");
                    String string = targetView.getResources().getString(C9086R.string.composer_voice_recorder_toolbar_smart_tip);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    STTGuideTip companion2 = getInstance();
                    if (companion2 != null) {
                        companion2.showGuideTip(targetView, stateBadgeView, string, locations);
                    }
                }
            }
            targetView.invalidate();
        }

        public final void dismiss() {
            STTGuideTip companion;
            SmartTipPopup guideTipPopup;
            if (!hasInstance() || (companion = getInstance()) == null || (guideTipPopup = companion.getGuideTipPopup()) == null) {
                return;
            }
            guideTipPopup.dismiss();
        }

        @NotNull
        public final String getTAG() {
            return STTGuideTip.TAG;
        }

        public final boolean hasShowCondition() {
            if (FeatureInfo.isSupportSTTFunction()) {
                return SharedPreferencesCompat.INSTANCE.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_VOICE_RECORD_SMART_TIP_SHOWN, true);
            }
            return false;
        }

        public final boolean isShowing() {
            STTGuideTip companion = getInstance();
            SmartTipPopup guideTipPopup = companion != null ? companion.getGuideTipPopup() : null;
            if (guideTipPopup != null) {
                return guideTipPopup.isShowing();
            }
            return false;
        }

        public final void setTAG(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            STTGuideTip.TAG = str;
        }

        public final void show(@NotNull View view, @NotNull View stateBadgeView, @NotNull int[] locations) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(stateBadgeView, "stateBadgeView");
            Intrinsics.checkNotNullParameter(locations, "locations");
            Logger.m10999d(getTAG(), Constants.IntentExtraValue.SHOW);
            if (canShow(view)) {
                showDelayedAfterLaidOut(view, stateBadgeView, locations);
            }
        }

        public final void update() {
            STTGuideTip companion;
            SmartTipPopup guideTipPopup;
            Logger.m10999d(getTAG(), com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE);
            if (!hasInstance() || (companion = getInstance()) == null || (guideTipPopup = companion.getGuideTipPopup()) == null) {
                return;
            }
            guideTipPopup.update();
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("STTGuideTip");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    private final void disableShowCondition() {
        Logger.m11003i(TAG, "disableShowCondition");
        SharedPreferencesCompat.INSTANCE.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_VOICE_RECORD_SMART_TIP_SHOWN, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SmartTipPopup getGuideTipPopup() {
        WeakReference<SmartTipPopup> weakReference = this.mGuideTipPopupRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final boolean hasNotUsedSTT() {
        if (FeatureInfo.isSupportSTTFunction()) {
            return SharedPreferencesCompat.INSTANCE.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_STT_USED_SMART_TIP_SHOWN, true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGuideTip(View targetView, View stateBadgeView, String text, int[] locations) {
        try {
            SmartTipPopup smartTipPopup = new SmartTipPopup(targetView, text);
            smartTipPopup.setOnDismissListener(new C0287e(this, stateBadgeView, 18));
            smartTipPopup.setTargetPosition(locations[0], locations[1]);
            if (!smartTipPopup.show()) {
                release();
            } else {
                disableShowCondition();
                this.mGuideTipPopupRef = new WeakReference<>(smartTipPopup);
            }
        } catch (InstantiationException e) {
            AbstractC8014b.m7198D("showGuideTip ", e.getMessage(), TAG);
            disableShowCondition();
            release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuideTip$lambda$0(STTGuideTip sTTGuideTip, View view) {
        Logger.m10999d(TAG, "onDismissed");
        sTTGuideTip.release();
        if (view == null || !sTTGuideTip.hasNotUsedSTT()) {
            return;
        }
        view.setVisibility(0);
    }

    public final void release() {
        Logger.m11003i(TAG, "release");
        this.mGuideTipPopupRef = null;
        mInstance = null;
    }
}
