import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface IDocumentVisitor {

    void visit(TDocument document) throws DocumentException, IOException;
    void visit(TDocumentTable table);
    void visit(TDocumentTableRow row) throws DocumentException, IOException;
    void visit(TDocumentTableCell cell) throws DocumentException, IOException;
    void visit(TDocumentText text);

}
