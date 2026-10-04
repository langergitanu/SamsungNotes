package com.samsung.android.sdk.scs.p142ai.translation;

import androidx.annotation.RestrictTo;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class LanguageDirectionStateMapper {
    public static Map<LanguageDirection, LanguageDirectionState> from(Map<LanguageDirection, Integer> map) {
        final HashMap map2 = new HashMap();
        map.entrySet().forEach(new Consumer() { // from class: com.samsung.android.sdk.scs.ai.translation.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                LanguageDirectionStateMapper.lambda$from$0(map2, (Map.Entry) obj);
            }
        });
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$from$0(Map map, Map.Entry entry) {
        map.put((LanguageDirection) entry.getKey(), LanguageDirectionState.from(((Integer) entry.getValue()).intValue()));
    }
}
