package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataNotNullValueFactory;

/* JADX INFO: renamed from: com.vladsch.flexmark.parser.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11829a implements DataNotNullValueFactory {
    @Override // com.vladsch.flexmark.util.data.DataNotNullValueFactory, com.vladsch.flexmark.util.data.DataValueFactory
    public final Object apply(DataHolder dataHolder) {
        return new ReferenceRepository(dataHolder);
    }
}
