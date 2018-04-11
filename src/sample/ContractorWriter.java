package sample;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ContractorWriter {
    private String company;
    private String name;
    private String city;
    private String adress;
    private String phone;


    ContractorWriter(String company, String name, String city, String adress, String phone) {
        this.company = company;
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.phone = phone;
    }

    public void createContractorParagraph(XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run = paragraph.createRun();

        run.setText(company);
        run.addBreak();
        run.setText(name);
        run.addBreak();
        run.setText(city);
        run.addBreak();
        run.setText(adress);
        run.addBreak();
        run.setText(phone);
        run.addBreak();
    }
}
