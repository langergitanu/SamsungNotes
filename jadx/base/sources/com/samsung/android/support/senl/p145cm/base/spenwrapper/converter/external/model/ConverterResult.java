package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IConverterResult;", "path", "", "<init>", "(Ljava/lang/String;)V", "pathList", "", "uuidList", "", "(Ljava/util/List;Ljava/util/List;)V", "mPathList", "value", "getUuidList", "()Ljava/util/List;", "getPathList", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConverterResult implements IConverterResult {

    @Nullable
    private final List<String> mPathList;

    @Nullable
    private List<String> uuidList;

    public ConverterResult(@Nullable String str) {
        ArrayList arrayList = new ArrayList(1);
        this.mPathList = arrayList;
        arrayList.add(String.valueOf(str));
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IConverterResult
    @Nullable
    public List<String> getPathList() {
        return this.mPathList;
    }

    @Nullable
    public final List<String> getUuidList() {
        return this.uuidList;
    }

    public ConverterResult(@Nullable List<String> list, @Nullable List<String> list2) {
        this.mPathList = list;
        this.uuidList = list2;
    }
}
