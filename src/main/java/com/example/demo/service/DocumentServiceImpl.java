package com.example.demo.service;

import com.example.demo.entity.Document;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService{
    private final Map<Integer, Document> documentMap;
    private final AtomicInteger idCounter;

    public DocumentServiceImpl() {
        this.documentMap = new HashMap<>();
        this.idCounter = new AtomicInteger(0);
    }

    @Override
    public Integer createDocument(Document document) {
        int id = idCounter.incrementAndGet();
        document.setId(id);
        documentMap.put(id, document);
        return id;
    }

    @Override
    public Document getDocument(Integer id) {
        return documentMap.get(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean updateDocument(Integer id, Document updatedDocument) {
        Document document = documentMap.get(id);
        if (document == null) {
            return false;
        }
        updatedDocument.setId(id);
        documentMap.put(id, updatedDocument);
        return true;
    }

    @Override
    public boolean deleteDocument(Integer id) {
        return documentMap.remove(id) != null;
    }
}
