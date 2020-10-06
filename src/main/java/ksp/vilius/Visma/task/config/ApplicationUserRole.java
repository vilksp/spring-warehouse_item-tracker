package ksp.vilius.Visma.task.config;

import java.util.Set;

import com.google.common.collect.Sets;

import static ksp.vilius.Visma.task.config.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    WAREHOUSE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, WAREHOUSE_READ, WAREHOUSE_WRITE)),
    MANAGER(Sets.newHashSet(WAREHOUSE_READ, WAREHOUSE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
