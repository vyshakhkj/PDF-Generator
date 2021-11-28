import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFVisitor implements IDocumentVisitor {

    private String fileName = null;
    private PdfWriter writer = null;
    private Document document = null;
    private FileOutputStream fos = null;
    private PdfPTable tableTemp = null;
    private TDocumentTableRow rows = null;
    private int columnCount;

    public PDFVisitor(String fileName) throws FileNotFoundException, DocumentException {
        fileName = fileName;
        fos = new FileOutputStream(fileName);
        document = new Document(PageSize.A4, 25, 25, 30, 30);
        writer = PdfWriter.getInstance(document, fos);
    }

    @Override
    public void visit(TDocument doc) throws DocumentException, IOException {
        document.addAuthor("Vyshakh K J");
        document.addCreator("IText PDF Library");
        document.addKeywords("Design Patterns");
        document.addSubject("PDF Parser");
        document.open();
        columnCount = doc.getColumnCount();
        document.addTitle(doc.getTitle());

        for (int i = 0; i < doc.getDocumentElements().size(); i++) {
            try {
                doc.getDocumentElements().get(i).accept(this);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        document.add(this.tableTemp);
        document.close();
        fos.close();
    }

    @Override
    public void visit(TDocumentTable table) {
        this.tableTemp = new PdfPTable(columnCount);
        PdfPCell cell = new PdfPCell(new Phrase("Header spanning 3 columns"));
        cell.setColspan(columnCount);
        cell.setHorizontalAlignment(1);
        tableTemp.addCell(cell);

        for(int i = 0; i < table.getRowCount(); i++) {
            try {
                table.getDocumentElements().get(i).accept(this);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }

    @Override
    public void visit(TDocumentTableRow row) throws DocumentException, IOException {
        for(int i = 0; i < row.getDocumentElements().size(); i++) {
            row.getDocumentElements().get(i).accept(this);
        }
    }

    @Override
    public void visit(TDocumentTableCell cell) throws DocumentException, IOException {
        for(int i = 0; i < cell.getDocumentElements().size(); i++) {
            cell.getDocumentElements().get(i).accept(this);
        }
    }

    @Override
    public void visit(TDocumentText text) {
        tableTemp.addCell(text.text);
    }
}
