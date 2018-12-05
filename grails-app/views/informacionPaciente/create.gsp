<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'informacionPaciente.label', default: 'InformacionPaciente')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-informacionPaciente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-informacionPaciente" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.informacionPaciente}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.informacionPaciente}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form class="form-control" resource="${this.informacionPaciente}"  method="POST" action="save">
                <div class="form-row">
                  <div class="col">
                    <label for="nombreUsuario">Nombre de Usuario</label>
                    <g:textField name="nombreUsuario" class="form-control" value="" required="true"/>
                  </div>
                  <div class="col">
                    <label for="contrasena">Contraseña</label>
                    <g:textField name="contrasena" class="form-control" value="" required="true" />
                  </div>
                </div>
                <fieldset>
                    <f:all bean="informacionPaciente"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
