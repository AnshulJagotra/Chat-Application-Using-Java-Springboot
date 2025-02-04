package com.example.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String sender;
    private LocalDateTime timestamp;
    private MessageType type;

    @ElementCollection
    private Map<String, String> structuredData;

    public enum MessageType {
        CHAT, JOIN, LEAVE, TYPING, STRUCTURED
    }

    // Existing getters and setters...

    public Map<String, String> getStructuredData() {
        return structuredData;
    }

    public void setStructuredData(Map<String, String> structuredData) {
        this.structuredData = structuredData;
    }
}

