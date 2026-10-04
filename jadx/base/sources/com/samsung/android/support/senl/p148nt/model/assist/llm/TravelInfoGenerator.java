package com.samsung.android.support.senl.p148nt.model.assist.llm;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/llm/TravelInfoGenerator;", "Lcom/samsung/android/support/senl/nt/model/assist/llm/Operator;", "content", "", "type", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;)V", "getType", "()Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "operate", "", "getRequestType", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TravelInfoGenerator extends Operator {

    @Nullable
    private final SCSRequesterType type;

    public /* synthetic */ TravelInfoGenerator(String str, SCSRequesterType sCSRequesterType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : sCSRequesterType);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    @NotNull
    public SCSRequesterType getRequestType() {
        SCSRequesterType sCSRequesterType = this.type;
        return sCSRequesterType == null ? SCSRequesterType.TravelSchedule : sCSRequesterType;
    }

    @Nullable
    public final SCSRequesterType getType() {
        return this.type;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.assist.llm.Operator
    public void operate(@Nullable String content) {
        this.mImpl.requestText(getRequestType(), new HashMap(), content);
    }

    public TravelInfoGenerator(@Nullable String str, @Nullable SCSRequesterType sCSRequesterType) {
        super(str);
        this.type = sCSRequesterType;
    }
}
