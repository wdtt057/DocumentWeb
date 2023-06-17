package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<String> createDocument(@RequestBody Document document) {
        Integer id = documentService.createDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body("Document created with ID: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Integer id) {
        Document document = documentService.getDocument(id);
        if (document == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(document);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocument(@PathVariable Integer id, @RequestBody Document document) {
        boolean updated = documentService.updateDocument(id, document);
        if (updated) {
            return ResponseEntity.ok("Document updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Integer id) {
        boolean deleted = documentService.deleteDocument(id);
        if (deleted) {
            return ResponseEntity.ok("Document deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
    }
}
