package com.hgun.sti.controller;

import com.hgun.sti.components.ExportPDF;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class ExportPDFController {

    @GetMapping("/export/{id}")
    public void exportToPDF(@PathVariable Long id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Ocorrência_" + id +".pdf";
        response.setHeader(headerKey, headerValue);

        var exporter = new ExportPDF();

        exporter.export(response);
    }
}
