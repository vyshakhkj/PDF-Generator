import java.util.Objects;

public class TDocumentText extends TDocumentElement {

    public String text;
    public boolean bold;
    public boolean italic;
    public boolean underline;
    public boolean center;
    public boolean preformatted;
    public String color;
    public boolean font;

    public TDocumentText() {
    }

    @Override
    public void accept(IDocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }

    public TDocumentText(String text) {
        if(Objects.nonNull(text)) {
            this.text = text;
        }
    }
}
