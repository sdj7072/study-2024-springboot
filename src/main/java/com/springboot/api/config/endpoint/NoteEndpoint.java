package com.springboot.api.config.endpoint;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id = "note")
public class NoteEndpoint {

    protected Map<String, Object> noteContent = new HashMap<>();

    @ReadOperation
    public Map<String, Object> getNote() {
        return noteContent;
    }

    /*
    @WriteOperation
    public void writeNote(String key, Object value) {
        noteContent.put(key, value);
    }

    @DeleteOperation
    public void deleteNote(String key) {
        noteContent.remove(key);
    }
    */
}
