package com.hgun.sti.components;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExportPDF {
    private static final float semIdentacao = 0;
    private static final float identacao1 = 25;
    private static final float identacao2 = 50;

    private static final int fontSizeMin = 10;

    public ExportPDF() {

    }

    private String formataNumeroNotificacao(Long id){
        String result = null;

        if(id < 10){
            result = "000"+id;
        }else if(id < 100){
            result = "00"+id;
        }else if(id < 1000){
            result = "0"+id;
        }else {
            result = id.toString();
        }

        return result;
    }

    private Paragraph getParagrafoNovo(
            String texto,
            float identacao,
            boolean centralizado,
            boolean fontBold,
            boolean alinhadoDireita
    ){
        Font font;

        if(fontBold){
            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        }else {
            font = FontFactory.getFont(FontFactory.HELVETICA);
        }

        font.setSize(fontSizeMin);

        var result = new Paragraph(texto , font);

        if(identacao != 0){
            result.setIndentationLeft(identacao);
        }

        if(centralizado){
            result.setAlignment(Paragraph.ALIGN_CENTER);
        }

        if(alinhadoDireita){
            result.setAlignment(Paragraph.ALIGN_RIGHT);
        }

        return result;
    }

    private String getDataFormatada(){

        var pattern = "EEEEE dd MMMMM yyyy";
        var simpleDateFormat = new SimpleDateFormat(pattern, new Locale("pt","BR"));
        var date = simpleDateFormat.format(new Date());

        return "NATAL, " + date.toString();
    }

    private Image getImagemNova(String caminhoImagem) throws IOException {
        Image image = Image.getInstance(caminhoImagem);
        image.setAlignment(Image.ALIGN_CENTER);

        return image;
    }

    public Document headerDocument(Document document) throws IOException {

        document.add(getImagemNova("src/main/resources/static/img/brasao-da-republica-do-brasil.com.png"));

        document.add(getParagrafoNovo("MINISTERIO DA DEFESA", semIdentacao, true, true, false));

        document.add(getParagrafoNovo("EXERCITO BRASILEIRO", semIdentacao, true, true, false));

        document.add(getParagrafoNovo("HOSPITAL DE GUARNI????O DE NATAL", semIdentacao, true, true, false));


        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));

        return document;
    }

    public Document footerDocument(Document document){

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));

        document.add(getParagrafoNovo("Chefe DA SE????O", semIdentacao, true, true, false));
        document.add(getParagrafoNovo("Assinatura / Carimbo", semIdentacao, true, true, false));

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", semIdentacao, true, true, false));

        document.add(getParagrafoNovo(getDataFormatada(), semIdentacao, true, false, false));

        return document;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        document = headerDocument(document);

        document = footerDocument(document);

        document.close();
    }
}
