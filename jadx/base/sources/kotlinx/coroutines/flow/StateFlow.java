package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlinx.coroutines.ExperimentalForInheritanceCoroutinesApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lkotlinx/coroutines/flow/StateFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "value", "getValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SubclassOptInRequired(markerClass = ExperimentalForInheritanceCoroutinesApi.class)
public interface StateFlow<T> extends SharedFlow<T> {
    T getValue();
}
