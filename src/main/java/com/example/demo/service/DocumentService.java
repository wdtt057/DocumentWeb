package com.example.demo.service;

import com.example.demo.entity.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {
    Integer createDocument(Document document);

    Document getDocument(Integer id);

    List<Document> getAllDocuments();

    boolean updateDocument(Integer id, Document document);

    boolean deleteDocument(Integer id);
}