package org.apache.poi.p226sl.usermodel;

import java.util.List;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ShapeContainer<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Iterable<S> {
    void addShape(S s);

    AutoShape<S, P> createAutoShape();

    ConnectorShape<S, P> createConnector();

    FreeformShape<S, P> createFreeform();

    GroupShape<S, P> createGroup();

    PictureShape<S, P> createPicture(PictureData pictureData);

    TableShape<S, P> createTable(int i, int i2);

    TextBox<S, P> createTextBox();

    List<S> getShapes();

    boolean removeShape(S s);
}
