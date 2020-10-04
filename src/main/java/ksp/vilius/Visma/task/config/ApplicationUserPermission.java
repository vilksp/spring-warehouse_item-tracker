package ksp.vilius.Visma.task.config;

public enum ApplicationUserPermission {
    WAREHOUSE_READ("warehouse:read"),
    WAREHOUSE_WRITE("warehouse:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
