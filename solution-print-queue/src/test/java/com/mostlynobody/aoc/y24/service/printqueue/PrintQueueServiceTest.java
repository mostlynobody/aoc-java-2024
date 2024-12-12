package com.mostlynobody.aoc.y24.service.printqueue;

import com.mostlynobody.aoc.y24.shared.records.SolutionJson;
import com.mostlynobody.aoc.y24.shared.utils.TestUtils;
import io.micronaut.json.JsonMapper;
import io.micronaut.serde.annotation.SerdeImport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SerdeImport(SolutionJson.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PrintQueueServiceTest {

    private PrintQueueService printQueueService;
    private JsonMapper jsonMapper;

    @BeforeEach
    void setup() {
        printQueueService = new PrintQueueService();
        jsonMapper = JsonMapper.createDefault();
    }

    @Test
    void testSolve() throws IOException {
        String input = TestUtils.readResourceFile("input");
        String solutionFile = TestUtils.readResourceFile("solution.json");
        SolutionJson solutionJson = jsonMapper.readValue(solutionFile, SolutionJson.class);

        SolutionJson result = printQueueService.solve(input);

        assertEquals(solutionJson.silver(), result.silver());
        assertEquals(solutionJson.gold(), result.gold());
    }

}
