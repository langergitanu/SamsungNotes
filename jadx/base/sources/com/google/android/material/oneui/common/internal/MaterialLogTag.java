package com.google.android.material.oneui.common.internal;

import androidx.core.oneui.common.internal.log.LogTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "Landroidx/core/oneui/common/internal/log/LogTag;", "isDebugTouch", "", "()Z", "isDebugVersion", "prefix", "", "getPrefix", "()Ljava/lang/String;", "version", "getVersion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface MaterialLogTag extends LogTag {
    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    default String getPrefix() {
        return "";
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    default String getVersion() {
        return "[sesl8-material:2.0.73]";
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    default boolean isDebugTouch() {
        return false;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    default boolean isDebugVersion() {
        return true;
    }
}
