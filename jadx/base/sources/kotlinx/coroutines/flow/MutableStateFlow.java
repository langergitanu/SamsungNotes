package kotlinx.coroutines.flow;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlinx.coroutines.ExperimentalForInheritanceCoroutinesApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\rR\u0018\u0010\u0004\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m13886d2 = {"Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "compareAndSet", "", "expect", Constants.ARG_UPDATE, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SubclassOptInRequired(markerClass = ExperimentalForInheritanceCoroutinesApi.class)
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    boolean compareAndSet(T expect, T update);

    @Override // kotlinx.coroutines.flow.StateFlow
    T getValue();

    void setValue(T t);
}
