package sistematurnos

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserRoleGroup implements Serializable {

	private static final long serialVersionUID = 1

	User user
	RoleGroup roleGroup

	@Override
	boolean equals(other) {
		if (other instanceof UserRoleGroup) {
			other.userId == user?.id && other.roleGroupId == roleGroup?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (user) {
            hashCode = HashCodeHelper.updateHash(hashCode, user.id)
		}
		if (roleGroup) {
		    hashCode = HashCodeHelper.updateHash(hashCode, roleGroup.id)
		}
		hashCode
	}

	static UserRoleGroup get(long userId, long roleGroupId) {
		criteriaFor(userId, roleGroupId).get()
	}

	static boolean exists(long userId, long roleGroupId) {
		criteriaFor(userId, roleGroupId).count()
	}

	private static DetachedCriteria criteriaFor(long userId, long roleGroupId) {
		UserRoleGroup.where {
			user == User.load(userId) &&
			roleGroup == RoleGroup.load(roleGroupId)
		}
	}

	static UserRoleGroup create(User user, RoleGroup roleGroup, boolean flush = false) {
		def instance = new UserRoleGroup(user: user, roleGroup: roleGroup)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(User u, RoleGroup r) {
		if (u != null && r != null) {
			UserRoleGroup.where { user == u && roleGroup == r }.deleteAll()
		}
	}

	static int removeAll(User u) {
		u == null ? 0 : UserRoleGroup.where { user == u }.deleteAll() as int
	}

	static int removeAll(RoleGroup r) {
		r == null ? 0 : UserRoleGroup.where { roleGroup == r }.deleteAll() as int
	}

	static constraints = {
	    user nullable: false
		roleGroup nullable: false, validator: { RoleGroup r, UserRoleGroup ur ->
			if (ur.user?.id) {
				if (UserRoleGroup.exists(ur.user.id, r.id)) {
				    return ['userRole.exists']
				}
			}
		}
	}

	static mapping = {
		id composite: ['user', 'roleGroup']
		version false
	}
}
