package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectFindUtil {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Finder {
        boolean find(@NonNull String str, SpenObjectBase spenObjectBase);
    }

    public static SpenObjectBase getObject(SpenWNote spenWNote, int i, int i2, @NonNull String str, Finder finder) {
        SpenObjectBase objectFromObjectList = getObjectFromObjectList(spenWNote, i, str, finder);
        return objectFromObjectList != null ? objectFromObjectList : getObjectFromObjectSpan(spenWNote, i2, str, finder);
    }

    private static SpenObjectBase getObjectFromObjectList(@NonNull SpenWNote spenWNote, int i, @NonNull String str, Finder finder) {
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        if (pageList.isEmpty()) {
            return null;
        }
        Iterator<SpenWPage> it = pageList.iterator();
        while (it.hasNext()) {
            SpenObjectBase objectFromObjectList = getObjectFromObjectList(it.next(), i, str, finder);
            if (objectFromObjectList != null) {
                return objectFromObjectList;
            }
        }
        return null;
    }

    private static SpenObjectBase getObjectFromObjectSpan(SpenWNote spenWNote, int i, @NonNull String str, Finder finder) {
        ArrayList<SpenObjectSpan> objectSpan;
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        if (bodyText == null || (objectSpan = bodyText.getObjectSpan()) == null) {
            return null;
        }
        Iterator<SpenObjectSpan> it = objectSpan.iterator();
        while (it.hasNext()) {
            SpenObjectBase object = it.next().getObject();
            if (object.getType() == i && finder.find(str, object)) {
                return object;
            }
        }
        return null;
    }

    public static SpenObjectBase getObjectFromObjectList(@NonNull SpenWPage spenWPage, int i, @NonNull String str, Finder finder) {
        for (SpenObjectBase spenObjectBase : spenWPage.getObjectList(i)) {
            if (finder.find(str, spenObjectBase)) {
                return spenObjectBase;
            }
        }
        return null;
    }
}
