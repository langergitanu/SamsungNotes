package com.samsung.android.support.senl.p148nt.stt.base.model;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\tJ\b\u0010\u000e\u001a\u00020\u0005H\u0016R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiSpeakerData;", "", "nameMap", "", "", "", "<init>", "(Ljava/util/Map;)V", "clone", "(Lcom/samsung/android/support/senl/nt/stt/base/model/AiSpeakerData;)V", "mSpeakerNameMap", "getMSpeakerNameMap", "()Ljava/util/Map;", "setMSpeakerNameMap", "toString", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiSpeakerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiSpeakerData.kt\ncom/samsung/android/support/senl/nt/stt/base/model/AiSpeakerData\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,30:1\n216#2,2:31\n*S KotlinDebug\n*F\n+ 1 AiSpeakerData.kt\ncom/samsung/android/support/senl/nt/stt/base/model/AiSpeakerData\n*L\n22#1:31,2\n*E\n"})
public final class AiSpeakerData {

    @Nullable
    private Map<Integer, String> mSpeakerNameMap;

    public AiSpeakerData(@Nullable Map<Integer, String> map) {
        this.mSpeakerNameMap = map;
    }

    @Nullable
    public final Map<Integer, String> getMSpeakerNameMap() {
        return this.mSpeakerNameMap;
    }

    public final void setMSpeakerNameMap(@Nullable Map<Integer, String> map) {
        this.mSpeakerNameMap = map;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AISpeakerData{speakerNameMap=");
        Map<Integer, String> map = this.mSpeakerNameMap;
        Intrinsics.checkNotNull(map);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            String value = entry.getValue();
            sb.append("");
            sb.append(Integer.valueOf(iIntValue));
            sb.append(" ");
            sb.append(value);
            sb.append(SQLKeyword.COMMA);
        }
        return AbstractC0541b.m766h('}', "toString(...)", sb);
    }

    public AiSpeakerData(@NotNull AiSpeakerData clone) {
        Intrinsics.checkNotNullParameter(clone, "clone");
        if (clone.mSpeakerNameMap != null) {
            this.mSpeakerNameMap = new HashMap(clone.mSpeakerNameMap);
        }
    }
}
