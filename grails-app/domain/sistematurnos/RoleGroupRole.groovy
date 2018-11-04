package sistematurnos

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class RoleGroupRole implements Serializable {

	private static final long serialVersionUID = 1

	RoleGroup roleGroup
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof RoleGroupRole) {
			other.roleGroupId == roleGroup?.id && other.roleId == role?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (roleGroup) {
            hashCode = HashCodeHelper.updateHash(hashCode, roleGroup.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static RoleGroupRole get(long roleGroupId, long roleId) {
		criteriaFor(roleGroupId, roleId).get()
	}

	static boolean exists(long roleGroupId, long roleId) {
		criteriaFor(roleGroupId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long roleGroupId, long roleId) {
		RoleGroupRole.where {
			roleGroup == RoleGroup.load(roleGroupId) &&
			role == Role.load(roleId)
		}
	}

	static RoleGroupRole create(RoleGroup roleGroup, Role role, boolean flush = false) {
		def instance = new RoleGroupRole(roleGroup: roleGroup, role: role)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(RoleGroup u, Role r) {
		if (u != null && r != null) {
			RoleGroupRole.where { roleGroup == u && role == r }.deleteAll()
		}
	}

	static int removeAll(RoleGroup u) {
		u == null ? 0 : RoleGroupRole.where { roleGroup == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : RoleGroupRole.where { role == r }.deleteAll() as int
	}

	static constraints = {
	    roleGroup nullable: false
		role nullable: false, validator: { Role r, RoleGroupRole ur ->
			if (ur.roleGroup?.id) {
				if (RoleGroupRole.exists(ur.roleGroup.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['roleGroup', 'role']
		version false
	}
}
