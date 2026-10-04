package com.samsung.android.support.senl.addons.base.utils;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/InstanceCloseDebugger;", "", "tag", "", NotesConstants.KEY_CALLER, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", SearchConstants.TargetContents.TAG, "mIsClosedForDebug", "", "close", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InstanceCloseDebugger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static HashMap<String, Integer> mCounters = new HashMap<>();
    private static boolean sDebug;
    private String TAG;
    private boolean mIsClosedForDebug;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/InstanceCloseDebugger$Companion;", "", "<init>", "()V", "sDebug", "", "mCounters", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "canRun", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean canRun() {
            return InstanceCloseDebugger.sDebug;
        }

        private Companion() {
        }
    }

    public InstanceCloseDebugger(@NotNull String tag, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(caller, "caller");
        if (INSTANCE.canRun()) {
            this.TAG = tag;
            HashMap<String, Integer> map = mCounters;
            String str = null;
            if (tag == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
                tag = null;
            }
            if (!map.containsKey(tag)) {
                HashMap<String, Integer> map2 = mCounters;
                String str2 = this.TAG;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
                    str2 = null;
                }
                map2.put(str2, 0);
            }
            HashMap<String, Integer> map3 = mCounters;
            String str3 = this.TAG;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
                str3 = null;
            }
            Integer num = map3.get(str3);
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue() + 1;
            HashMap<String, Integer> map4 = mCounters;
            String str4 = this.TAG;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
                str4 = null;
            }
            map4.put(str4, Integer.valueOf(iIntValue));
            String str5 = this.TAG;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
            } else {
                str = str5;
            }
            StringBuilder sbM780v = AbstractC0541b.m780v("construct ", iIntValue, Integer.toHexString(hashCode()), " / ", " / ");
            sbM780v.append(caller);
            Logger.m7100d(str, sbM780v.toString());
        }
    }

    @JvmStatic
    public static final boolean canRun() {
        return INSTANCE.canRun();
    }

    public final void close(@NotNull String caller) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        if (!INSTANCE.canRun() || this.mIsClosedForDebug) {
            return;
        }
        HashMap<String, Integer> map = mCounters;
        String str = this.TAG;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
            str = null;
        }
        Integer num = map.get(str);
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue() - 1;
        HashMap<String, Integer> map2 = mCounters;
        String str3 = this.TAG;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
            str3 = null;
        }
        map2.put(str3, Integer.valueOf(iIntValue));
        String str4 = this.TAG;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SearchConstants.TargetContents.TAG);
        } else {
            str2 = str4;
        }
        StringBuilder sbM780v = AbstractC0541b.m780v("close ", iIntValue, Integer.toHexString(hashCode()), " / ", " / ");
        sbM780v.append(caller);
        Logger.m7100d(str2, sbM780v.toString());
        this.mIsClosedForDebug = true;
    }
}
