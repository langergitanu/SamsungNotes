package com.samsung.android.support.senl.p148nt.model.statusmonitor;

import com.samsung.android.support.senl.p148nt.model.statusmonitor.StatusManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/IStatusObserver;", "", "onChanged", "", "type", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Types;", "value", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Value;", "getRequestedTypes", "", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IStatusObserver {
    @NotNull
    List<StatusManager.Types> getRequestedTypes();

    void onChanged(@NotNull StatusManager.Types type, @NotNull StatusManager.Value value);
}
