package org.apache.poi.p226sl.usermodel;

import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Slide<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Sheet<S, P> {
    boolean getDisplayPlaceholder(Placeholder placeholder);

    boolean getFollowMasterBackground();

    boolean getFollowMasterColourScheme();

    boolean getFollowMasterObjects();

    Notes<S, P> getNotes();

    int getSlideNumber();

    String getTitle();

    void setFollowMasterBackground(boolean z);

    void setFollowMasterColourScheme(boolean z);

    void setFollowMasterObjects(boolean z);

    void setNotes(Notes<S, P> notes);
}
