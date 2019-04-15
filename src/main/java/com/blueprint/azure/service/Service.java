package com.blueprint.azure.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import com.blueprint.azure.api.Read;
import com.blueprint.azure.api.Write;
import com.blueprint.azure.database.Database;
import com.blueprint.azure.database.DatabaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Service {

    @Autowired
    private Database database;

    @GetMapping(path = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(
        path = "/api/read",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Read read() {
        log.info("read()");
        Optional<List<DatabaseEntity>> read = database.findByLimit();
        if (!read.isPresent()) {
            log.warn("read() no read present.");
            return new Read();
        }
        return new Read()
            .setValues(read
                .get()
                .stream()
                .map(DatabaseEntity::getValue)
                .collect(Collectors.toList()));
    }

    @PostMapping(
        path = "/api/write",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Write write(@RequestBody Write write) {
        log.info("write() {}", write);
        return new Write()
            .setValue(database
                .save(new DatabaseEntity().setValue(write.getValue())).getValue());
    }

}
