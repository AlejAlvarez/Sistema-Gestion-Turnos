

/* LINKS DOCUMENTACION:
        documentacion Spring Security Core: https://grails-plugins.github.io/grails-spring-security-core/3.2.x/index.html#requestMappings
        documentacion Spring Security UI: https://grails-plugins.github.io/grails-spring-security-ui/latest/#application-groovy-attributes
         */


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'sistematurnos.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'sistematurnos.UserRole'
grails.plugin.springsecurity.authority.className = 'sistematurnos.Role'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/ingresoSeguro/index'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = '/'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               					access: ['permitAll']],
	[pattern: '/error',          					access: ['permitAll']],
	[pattern: '/index',          					access: ['permitAll']],
	[pattern: '/ingresoSeguro/index',   			access: ['permitAll']],
	[pattern: '/indexControllers',      			access: ['permitAll']],
	[pattern: '/shutdown',       					access: ['permitAll']],
	[pattern: '/dbconsole/**',       		        access: ['ROLE_ADMIN']],
	[pattern: '/user/**',        					access: ['ROLE_ADMIN']],
	[pattern: '/turno/**',       					access: ['ROLE_ADMIN', 'ROLE_PACIENTE']],
	[pattern: '/sobreturno/**',    					access: ['ROLE_ADMIN', 'ROLE_PACIENTE']],
	[pattern: '/turnoCancelado/**',					access: ['ROLE_ADMIN', 'ROLE_PACIENTE']],
	[pattern: '/obraSocial/**',    					access: ['ROLE_ADMIN', 'ROLE_PACIENTE']],
	[pattern: '/informacionUsuario/**',       		access: ['ROLE_ADMIN']],
	[pattern: '/informacionAdministrador/**',       access: ['ROLE_ADMIN']],
	[pattern: '/informacionRecepcionista/**',       access: ['ROLE_ADMIN','ROLE_RECEPCIONISTA']],
	[pattern: '/informacionMedico/**',       		access: ['ROLE_ADMIN', 'ROLE_MEDICO']],
	[pattern: '/especialidad/**',       			access: ['ROLE_ADMIN', 'ROLE_MEDICO']],
	[pattern: '/informacionPaciente/**',			access: ['ROLE_ADMIN', 'ROLE_PACIENTE', 'ROLE_RECEPCIONISTA']],
	[pattern: '/horarioLaboral/**',					access: ['ROLE_ADMIN', 'ROLE_MEDICO']],
	[pattern: '/assets/**',      					access: ['permitAll']],
	[pattern: '/**/js/**',       					access: ['permitAll']],
	[pattern: '/**/css/**',      					access: ['permitAll']],
	[pattern: '/**/images/**',   					access: ['permitAll']],
	[pattern: '/**/favicon.ico', 					access: ['permitAll']],
	[pattern: '/indexControllers/**',				access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

