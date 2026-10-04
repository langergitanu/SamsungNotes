package com.vladsch.flexmark.ext.gfm.tasklist;

import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterFactory;
import com.vladsch.flexmark.util.data.DataHolder;

/* JADX INFO: renamed from: com.vladsch.flexmark.ext.gfm.tasklist.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11786a implements NodeFormatterFactory {
    @Override // com.vladsch.flexmark.formatter.NodeFormatterFactory
    public final NodeFormatter create(DataHolder dataHolder) {
        return new TaskListNodeFormatter(dataHolder);
    }
}
