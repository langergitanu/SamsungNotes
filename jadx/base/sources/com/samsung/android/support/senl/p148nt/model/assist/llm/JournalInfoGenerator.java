package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/llm/JournalInfoGenerator;", "Lcom/samsung/android/support/senl/nt/model/assist/llm/Operator;", "content", "", "<init>", "(Ljava/lang/String;)V", "operate", "", "getRequestType", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class JournalInfoGenerator extends Operator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JournalInfoGenerator(@NotNull String content) {
        super(content);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    @NotNull
    public SCSRequesterType getRequestType() {
        return SCSRequesterType.JournalInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(@Nullable String content) {
        this.mImpl.requestText(getRequestType(), new HashMap(), content);
    }
}
