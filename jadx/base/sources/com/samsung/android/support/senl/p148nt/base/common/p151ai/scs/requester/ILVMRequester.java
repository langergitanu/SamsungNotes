package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\rJ$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILVMRequester;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/IRequesterBase;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "requestImage", "", TextConst.KEY_PARAM_REQUEST_TYPE, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "content", "Landroid/graphics/Bitmap;", "requestInfo", "Landroid/os/Bundle;", "close", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILVMRequester extends IRequesterBase, AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String DRAWING_INFO_KEY_SCRIBBLE_WEIGHT = "scribble_weight";

    @NotNull
    public static final String DRAWING_INFO_KEY_STYLE_IMAGE = "style";

    @NotNull
    public static final String DRAWING_INFO_KEY_TEXT_INFO = "textInfo";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILVMRequester$Companion;", "", "<init>", "()V", "DRAWING_INFO_KEY_STYLE_IMAGE", "", "DRAWING_INFO_KEY_SCRIBBLE_WEIGHT", "DRAWING_INFO_KEY_TEXT_INFO", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String DRAWING_INFO_KEY_SCRIBBLE_WEIGHT = "scribble_weight";

        @NotNull
        public static final String DRAWING_INFO_KEY_STYLE_IMAGE = "style";

        @NotNull
        public static final String DRAWING_INFO_KEY_TEXT_INFO = "textInfo";

        private Companion() {
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    void requestImage(@Nullable SCSRequesterType requestType, @Nullable Bitmap content, @NotNull Bundle requestInfo);
}
