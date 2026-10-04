package com.samsung.android.sdk.composer.listener;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\t2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/listener/SpenObjectSelectListener;", "", "<init>", "()V", "onObjectSelected", "", "pageList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "Lkotlin/collections/ArrayList;", "objectList", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "selected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenObjectSelectListener {
    public void onObjectSelected(@Nullable ArrayList<SpenWPage> pageList, @Nullable ArrayList<SpenObjectBase> objectList, boolean selected) {
    }
}
