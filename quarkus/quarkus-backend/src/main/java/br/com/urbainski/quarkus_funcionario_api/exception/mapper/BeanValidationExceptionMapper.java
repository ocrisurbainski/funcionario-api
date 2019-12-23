package br.com.urbainski.quarkus_funcionario_api.exception.mapper;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	
	private static final Logger LOGGER = Logger.getLogger(BeanValidationExceptionMapper.class.getName());

	private static final String RESOURCE_BUNDLE_NAME = "messages";
	
	private ResourceBundle resourceBundle;
	
	public BeanValidationExceptionMapper() {
		Locale locale = Locale.getDefault();
		LOGGER.log(Level.INFO, locale.toString());
		resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
	}
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Map<String, String[]> errors = new HashMap<>();
		exception.getConstraintViolations().forEach(v -> {
			String propertyPath = getPropertyPath(v.getPropertyPath().iterator());
			String propertyFriendlyName = resolvePropertyToFriendlyName(propertyPath);

			String message = v.getMessage();
			message = MessageFormat.format(message, propertyFriendlyName);

			String[] arrMessages = errors.get(propertyPath);
			if (errors.containsKey(propertyPath)) {
				String[] oldArrMessages = errors.get(propertyPath);
				arrMessages = new String[oldArrMessages.length + 1];
				System.arraycopy(oldArrMessages, 0, arrMessages, 0, oldArrMessages.length);
			} else {
				arrMessages = new String[1];
			}
			
			arrMessages[arrMessages.length - 1] = message;
			errors.put(propertyPath, arrMessages);
		});
		return Response.status(Status.BAD_REQUEST.getStatusCode()).entity(errors).build();
	}

	private String getPropertyPath(Iterator<Node> it) {

		String pathCompeted = "";
		while (it.hasNext()) {
			pathCompeted += it.next().getName() + ".";
		}

		pathCompeted = pathCompeted.substring(0, pathCompeted.length() - 1);

		String[] valuesPath = pathCompeted.split("\\.");

		return valuesPath[valuesPath.length - 2] + "." + valuesPath[valuesPath.length - 1];
	}

	private String resolvePropertyToFriendlyName(String propertyPath) {
		return this.resourceBundle.getString(propertyPath);
	}
	
}