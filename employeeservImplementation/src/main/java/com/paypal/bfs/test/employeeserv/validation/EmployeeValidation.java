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

@Component
public class EmployeeValidation {
	
	public boolean isValid(Employee emp) throws IOException, ProcessingException {
		File file = new File(getClass().getResource("/v1/schema/employee.json").getFile());
		final JsonNode fstabSchema = JsonLoader.fromFile(file);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.convertValue(emp, JsonNode.class);
		final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
		final JsonSchema schema = factory.getJsonSchema(fstabSchema);

		ProcessingReport report = schema.validate(node);
		System.out.println(report.toString());
		return report.isSuccess();
	}

}

