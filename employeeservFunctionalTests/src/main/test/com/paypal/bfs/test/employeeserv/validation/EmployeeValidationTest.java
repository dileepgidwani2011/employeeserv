package com.paypal.bfs.test.employeeserv.validation;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeValidationTest {
	
	@Test
	public boolean isValid() {
	}

}

