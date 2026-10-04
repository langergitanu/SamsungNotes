package org.apache.poi.xssf.model;

import com.microsoft.schemas.vml.CTShape;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class CommentsTable extends POIXMLDocumentPart {
    public static final String DEFAULT_AUTHOR = "";
    public static final int DEFAULT_AUTHOR_ID = 0;
    private Map<CellAddress, CTComment> commentRefs;
    private CTComments comments;

    public CommentsTable() {
        CTComments cTCommentsNewInstance = CTComments.Factory.newInstance();
        this.comments = cTCommentsNewInstance;
        cTCommentsNewInstance.addNewCommentList();
        this.comments.addNewAuthors().addAuthor("");
    }

    private int addNewAuthor(String str) {
        int iSizeOfAuthorArray = this.comments.getAuthors().sizeOfAuthorArray();
        this.comments.getAuthors().insertAuthor(iSizeOfAuthorArray, str);
        return iSizeOfAuthorArray;
    }

    private void prepareCTCommentCache() {
        if (this.commentRefs == null) {
            this.commentRefs = new HashMap();
            for (CTComment cTComment : this.comments.getCommentList().getCommentArray()) {
                this.commentRefs.put(new CellAddress(cTComment.getRef()), cTComment);
            }
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public int findAuthor(String str) {
        String[] authorArray = this.comments.getAuthors().getAuthorArray();
        for (int i = 0; i < authorArray.length; i++) {
            if (authorArray[i].equals(str)) {
                return i;
            }
        }
        return addNewAuthor(str);
    }

    public XSSFComment findCellComment(CellAddress cellAddress) {
        CTComment cTComment = getCTComment(cellAddress);
        if (cTComment == null) {
            return null;
        }
        return new XSSFComment(this, cTComment, (CTShape) null);
    }

    public String getAuthor(long j) {
        return this.comments.getAuthors().getAuthorArray((int) j);
    }

    @Internal
    public CTComment getCTComment(CellAddress cellAddress) {
        prepareCTCommentCache();
        return this.commentRefs.get(cellAddress);
    }

    @Internal
    public CTComments getCTComments() {
        return this.comments;
    }

    public Map<CellAddress, XSSFComment> getCellComments() {
        prepareCTCommentCache();
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<CellAddress, CTComment> entry : this.commentRefs.entrySet()) {
            treeMap.put(entry.getKey(), new XSSFComment(this, entry.getValue(), (CTShape) null));
        }
        return treeMap;
    }

    public int getNumberOfAuthors() {
        return this.comments.getAuthors().sizeOfAuthorArray();
    }

    public int getNumberOfComments() {
        return this.comments.getCommentList().sizeOfCommentArray();
    }

    @Internal
    public CTComment newComment(CellAddress cellAddress) {
        CTComment cTCommentAddNewComment = this.comments.getCommentList().addNewComment();
        cTCommentAddNewComment.setRef(cellAddress.formatAsString());
        cTCommentAddNewComment.setAuthorId(0L);
        Map<CellAddress, CTComment> map = this.commentRefs;
        if (map != null) {
            map.put(cellAddress, cTCommentAddNewComment);
        }
        return cTCommentAddNewComment;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.comments = CommentsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getComments();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void referenceUpdated(CellAddress cellAddress, CTComment cTComment) {
        Map<CellAddress, CTComment> map = this.commentRefs;
        if (map != null) {
            map.remove(cellAddress);
            this.commentRefs.put(new CellAddress(cTComment.getRef()), cTComment);
        }
    }

    public boolean removeComment(CellAddress cellAddress) {
        String asString = cellAddress.formatAsString();
        CTCommentList commentList = this.comments.getCommentList();
        if (commentList != null) {
            CTComment[] commentArray = commentList.getCommentArray();
            for (int i = 0; i < commentArray.length; i++) {
                if (asString.equals(commentArray[i].getRef())) {
                    commentList.removeComment(i);
                    Map<CellAddress, CTComment> map = this.commentRefs;
                    if (map == null) {
                        return true;
                    }
                    map.remove(cellAddress);
                    return true;
                }
            }
        }
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        CommentsDocument commentsDocumentNewInstance = CommentsDocument.Factory.newInstance();
        commentsDocumentNewInstance.setComments(this.comments);
        commentsDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public CommentsTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}
