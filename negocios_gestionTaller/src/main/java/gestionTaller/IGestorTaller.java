package gestionTaller;

import Excepciones.DatosFaltantesEnOrdenException;
import Excepciones.FechaInvalidaException;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.OrdenDTO;
import dto.PresupuestoDTO;
import dto.RefaccionDTO;
import dto.ServicioDTO;
import dto.TareaDTO;
import dto.VehiculoDTO;
import dto.VentaDTO;
import dto.VentaRefaccionDTO;
import excepciones.EntidadDuplicadaNegocioException;
import excepciones.EntidadNoEncontradaNegocioException;
import excepciones.NegocioException;
import java.util.List;


    public interface IGestorTaller {

        // Órdenes
        public OrdenDTO crearOrden(OrdenDTO orden) throws DatosFaltantesEnOrdenException, FechaInvalidaException, NegocioException;
        public List<OrdenDTO> buscarOrdenesPorCliente(ClienteDTO cliente) throws NegocioException;

        // Autenticación general
        public Boolean autenticarUsuario(String usuario, String contrasena);

        // Clientes
        public List<ClienteDTO> buscarTodosLosClientesActivos() throws NegocioException;

        // Vehículos
        public List<VehiculoDTO> obtenerVehiculosPorCliente(String idCliente);

        // Empleados
        public Boolean autenticarEmpleado(String usuario, String contrasena);
        public EmpleadoDTO obtenerEmpleadoPorUsuario(String usuario);
        public EmpleadoDTO actualizarEstadoEmpleado(String idEmpleado, Boolean activo);
        public EmpleadoDTO buscarPorId(String idEmpleado);
        public List<EmpleadoDTO> obtenerMecanicosParaTabla() throws NegocioException;
        public EmpleadoDTO obtenerDatosUsuario(String usuario);

        // Presupuestos
        public List<PresupuestoDTO> buscarPresupuestosPendientes() throws NegocioException;
        public PresupuestoDTO buscarPresupuestoPorOrden(String idOrden) throws NegocioException;

        // Tareas
        public List<TareaDTO> obtenerTareasDeMecanico(String usuario) throws NegocioException;
        public void completarTareaMecanico(String idTarea) throws NegocioException;
        public List<TareaDTO> obtenerTareasParaTabla() throws NegocioException;
        public boolean asignarTareaAMecanico(String idTarea, String idMecanico) throws NegocioException;
        List<TareaDTO> obtenerTareasSinAsignar() throws NegocioException;
        List<TareaDTO> obtenerTareasCompletadasPorMecanico(String idMecanico) throws NegocioException;

        //Servicios
        public ServicioDTO crearServicio(ServicioDTO dto) throws NegocioException;
        public ServicioDTO actualizarServicio(ServicioDTO dto) throws NegocioException;
        public ServicioDTO eliminarServicio(String id) throws NegocioException;
        public List<ServicioDTO> obtenerTodos() throws NegocioException;
        
        //refacciones
        public RefaccionDTO crearRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadDuplicadaNegocioException;
        public RefaccionDTO actualizarRefaccion(RefaccionDTO refaccionDTO) throws NegocioException, EntidadNoEncontradaNegocioException;
        public List<RefaccionDTO> buscarTodasLasRefacciones() throws NegocioException,EntidadDuplicadaNegocioException;
        public RefaccionDTO buscarRefaccionPorId(String id) throws NegocioException,  EntidadNoEncontradaNegocioException;

        //ventas
        VentaDTO crearVenta(List<VentaRefaccionDTO> detalles) throws NegocioException;
        VentaDTO buscarVentaPorId(Long id) throws NegocioException;
        List<VentaDTO> buscarTodasLasVentas() throws NegocioException;
        
        //venta refaccion
        public VentaRefaccionDTO crearVentaRefaccion(VentaRefaccionDTO dto) throws EntidadDuplicadaNegocioException, NegocioException;
        public VentaRefaccionDTO actualizarVentaRefaccion(VentaRefaccionDTO dto) throws EntidadNoEncontradaNegocioException, NegocioException;
        public VentaRefaccionDTO buscarVentaRefaccionPorId(String id) throws EntidadNoEncontradaNegocioException, NegocioException;
        public List<VentaRefaccionDTO> buscarPorIdVenta(String idVenta) throws NegocioException;
}
