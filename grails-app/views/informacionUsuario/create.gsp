<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'informacionUsuario.label', default: 'InformacionUsuario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:javascript src="jquery-3.3.1.min.js" />
    <style>
    .hidden{
        display:none;
    }
    </style>
    </head>
    <body>
        <a href="#create-informacionUsuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-informacionUsuario" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.informacionUsuario}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.informacionUsuario}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.informacionUsuario}" method="POST">
                <fieldset class="form">

                    <f:all bean="informacionUsuario" />
                </fieldset>
                <!-- submitButton del form de información usuario -->
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    <div class="form-group">
        <label for="options">Seleccionar Rol</label>
        <select class="form-control" id="options">
            <option value="" selected disabled hidden>Rol</option>
            <option value="paciente">Paciente</option>
            <option value="medico">Médico</option>
        </select>
    </div>
    <div id="content1-paciente" class="content1 hidden">Formulario de Paciente</div>
    <div id="content1-medico" class="content1 hidden">Formulario de Médico</div>
    <script>
        $(document).ready(function(){
            $("#options").change(function(){
                $(".content1").addClass("hidden");
                $("#content1-"+$(this).val()).removeClass("hidden");
            });
        });
    </script>
    </body>
</html>
