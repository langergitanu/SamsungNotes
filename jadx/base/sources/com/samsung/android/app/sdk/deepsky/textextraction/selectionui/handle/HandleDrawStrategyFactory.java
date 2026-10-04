package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle;

import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.Handle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.EndHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.HandleDrawStrategy;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.MovingEndHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.MovingRtlEndHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.MovingRtlStartHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.MovingStartHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.RtlEndHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.RtlStartHandle;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.handle.draw.StartHandle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/HandleDrawStrategyFactory;", "", "()V", "createDrawStrategy", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/draw/HandleDrawStrategy;", "handleType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$HandleType;", "movingState", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/handle/Handle$MovingState;", "isMovingHandleEnabled", "", "isLeftToRight", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HandleDrawStrategyFactory {

    @NotNull
    public static final HandleDrawStrategyFactory INSTANCE = new HandleDrawStrategyFactory();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.HandleType.values().length];
            try {
                iArr[Handle.HandleType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.HandleType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HandleDrawStrategyFactory() {
    }

    @NotNull
    public final HandleDrawStrategy createDrawStrategy(@NotNull Handle.HandleType handleType, @NotNull Handle.MovingState movingState, boolean isMovingHandleEnabled, boolean isLeftToRight) {
        Intrinsics.checkNotNullParameter(handleType, "handleType");
        Intrinsics.checkNotNullParameter(movingState, "movingState");
        if (isMovingHandleEnabled && movingState == Handle.MovingState.MOVING) {
            if (isLeftToRight) {
                int i = WhenMappings.$EnumSwitchMapping$0[handleType.ordinal()];
                if (i == 1) {
                    return new MovingStartHandle();
                }
                if (i == 2) {
                    return new MovingEndHandle();
                }
                throw new NoWhenBranchMatchedException();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[handleType.ordinal()];
            if (i2 == 1) {
                return new MovingRtlStartHandle();
            }
            if (i2 == 2) {
                return new MovingRtlEndHandle();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (isLeftToRight) {
            int i4 = WhenMappings.$EnumSwitchMapping$0[handleType.ordinal()];
            if (i4 == 1) {
                return new StartHandle();
            }
            if (i4 == 2) {
                return new EndHandle();
            }
            throw new NoWhenBranchMatchedException();
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[handleType.ordinal()];
        if (i5 == 1) {
            return new RtlStartHandle();
        }
        if (i5 == 2) {
            return new RtlEndHandle();
        }
        throw new NoWhenBranchMatchedException();
    }
}
