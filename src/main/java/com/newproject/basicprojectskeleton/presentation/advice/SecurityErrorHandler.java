package com.newproject.basicprojectskeleton.presentation.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityErrorHandler implements MethodAuthorizationDeniedHandler {
    // Solo acepta String como return
    @Override
    public Object handleDeniedInvocation(MethodInvocation methodInvocation, AuthorizationResult authorizationResult) {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode jsonNode = mapper.createObjectNode();
        jsonNode.put("message", "Not Authorized");
        jsonNode.put("status", 401);

        try {
            return mapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            throw new RuntimeException("Error al serializar el mensaje de error");
        }
    }
}
