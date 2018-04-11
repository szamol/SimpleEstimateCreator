package sample;

import javafx.collections.ObservableList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;

public class DocumentManger {
    private static XWPFDocument document = new XWPFDocument();;

    public static void addContractorToDocument(String company ,String name, String city, String adress, String phone) {
        Contractor contractor = new Contractor(company, name, city, adress, phone);
        contractor.createContractorParagraph(document);
    }

    public static void addClientToDocument(String name) {
        Client client = new Client(name);
        client.createClientParagraph(document);
    }

    public static void addServicesToDocument(ObservableList<Service> serviceList) {
        ServicesWriter servicesWriter = new ServicesWriter(serviceList);
        servicesWriter.createServicesParagraph(document);
    }

    public static void saveDocument() {
        try {
            FileOutputStream output = new FileOutputStream("firstDoc.docx");
            document.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
