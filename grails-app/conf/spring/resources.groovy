import sistematurnos.UserPasswordEncoderListener
import sistematurnos.RoleGroupPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    roleGroupPasswordEncoderListener(RoleGroupPasswordEncoderListener)
}
