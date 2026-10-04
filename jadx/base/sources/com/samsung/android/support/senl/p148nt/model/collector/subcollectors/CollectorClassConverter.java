package com.samsung.android.support.senl.p148nt.model.collector.subcollectors;

import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectorClassConverter {
    public static Class<?> convertToClass(int i) {
        return i == ICollectParam.LinkWith.TEXT_SEARCH.getValue() ? TextSearchCollector.class : i == ICollectParam.LinkWith.TEMPLATE_SEARCH.getValue() ? TemplateSearchCollector.class : i == ICollectParam.LinkWith.OBJECT_RECOGNITION.getValue() ? ObjectRecognitionCollector.class : i == ICollectParam.LinkWith.PDF_SEARCH.getValue() ? PdfSearchCollector.class : i == ICollectParam.LinkWith.STICKY.getValue() ? StickySearchCollector.class : i == ICollectParam.LinkWith.CODE_BLOCK.getValue() ? CodeBlockSearchCollector.class : i == ICollectParam.LinkWith.MEDIA.getValue() ? MediaCollector.class : DummyCollector.class;
    }
}
