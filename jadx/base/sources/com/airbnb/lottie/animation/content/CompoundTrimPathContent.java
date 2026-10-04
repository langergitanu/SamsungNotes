package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CompoundTrimPathContent {
    private final List<TrimPathContent> contents = new ArrayList();

    public void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, this.contents.get(size));
        }
    }
}
