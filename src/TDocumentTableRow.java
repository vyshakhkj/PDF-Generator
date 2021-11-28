import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class TDocumentTableRow extends TDocumentElement {

    public TDocumentTableRow() {
    }

    @Override
    public void accept(IDocumentVisitor documentVisitor) throws DocumentException, IOException {
        documentVisitor.visit(this);
    }
}
