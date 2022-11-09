package test;

import com.iudigital.crud.controller.FuncionarioController;
import com.iudigital.crud.dominio.Funcionario;
import java.sql.SQLException;
import java.util.*;

public class TestPostgresqlJDBC {
    
    public static void obtenerFuncionarioss(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getIdFuncionario());
                    System.out.println("Nombre: " + funcionario.getNombre());
                    System.out.println("Apellido: " + funcionario.getApellido());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    //System.out.println("Id: " + funcionario.getIdentificacionId());
                    System.out.println("Tipo identificación: " + funcionario.getIdentificacion());
                    System.out.println("Estado civil: " + funcionario.getEstadoCivil());
                    System.out.println("Dirección: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("FechaNacimeinto: " + funcionario.getFechaNacimiento());
                    
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void crearFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el nombre");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: = " + nombre);
            System.out.println("------------------------");
            System.out.println("Digite el apellido");
            String apellido = sc.nextLine();
            System.out.println("El apellido es: = " + apellido);
            System.out.println("------------------------");
            System.out.println("Digite el sexo");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: = " + sexo);
            System.out.println("------------------------");
            
            System.out.println("Digite el id del tipo: ");
            String idTipo = sc.nextLine();
            System.out.println(" id identificacion: " + idTipo);
            System.out.println("-------------------------- ");
            
            System.out.println("Digite el id del estado: ");
            String idEstado = sc.nextLine();
            System.out.println(" id genero: " + idEstado);
            System.out.println("-------------------------- ");
            
            System.out.println("Digite la dirección");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: = " + direccion);
            System.out.println("------------------------");
            System.out.println("Digite el telefono");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: = " + telefono);
            System.out.println("------------------------");
            System.out.println("Digite la fecha de nacimeinto");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: = " + fechaNacimiento);
            System.out.println("------------------------");
            
            Funcionario funcionario = new Funcionario();
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionario.setIdentificacionId(Integer.parseInt(idTipo));
            funcionario.setEstadoCivilId(Integer.parseInt(idEstado));
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado con exito");
            obtenerFuncionarioss(funcionarioController);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static void editarFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el ID del Funcionario");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("El id es = " + id);
            Funcionario funcionarioExist = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExist == null) {
                System.out.println(" No existe el Funcionario");
                return;
            }
            System.out.println("------------------------");
            System.out.println("Digite el nombre");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: = " + nombre);
            System.out.println("------------------------");
            System.out.println("Digite el apellido");
            String apellido = sc.nextLine();
            System.out.println("El apellido es: = " + apellido);
            System.out.println("------------------------");
            System.out.println("Digite el sexo");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: = " + sexo);
            System.out.println("------------------------");
            System.out.println("Digite el id identificación");
            String identificacion = sc.nextLine();
            System.out.println("El id de identificación es: = " + identificacion);
            System.out.println("------------------------");
            System.out.println("Digite el id estado");
            String estado = sc.nextLine();
            System.out.println("El id del estado es: = " + estado);
            System.out.println("------------------------");
            
            System.out.println("Digite la dirección");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: = " + direccion);
            System.out.println("------------------------");
            System.out.println("Digite el telefono");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: = " + telefono);
            System.out.println("------------------------");
            System.out.println("Digite la fecha de nacimeinto");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: = " + fechaNacimiento);
            System.out.println("------------------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setSexo(sexo);
            funcionario.setIdentificacionId(Integer.parseInt(identificacion));
            funcionario.setEstadoCivilId(Integer.parseInt(estado));
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
//            funcionario.setIdFuncionario(id);
            funcionarioController.actualizarFuncionario(id, funcionario);
            funcionarioController.obtenerFuncionarios();
            System.out.println("Funcionario actualizado con exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void eliminarFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el id del Funcionario");
            int id = sc.nextInt();
            System.out.println("El id es = " + id);
            Funcionario funcionarioExist = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExist == null) {
                System.out.println(" No existe el Funcionario");
                return;
            }
            funcionarioController.eliminarFuncionario(id);
            System.out.println("Funcionario eliminado con exito");
            obtenerFuncionarioss(funcionarioController);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void obtenerFuncionarioId(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite el id del Funcionario");
            int id = sc.nextInt();
            System.out.println("El id es = " + id);
            Funcionario funcionarioExist = funcionarioController.obtenerFuncionario(id);
            if (funcionarioExist == null) {
                System.out.println(" No existe el Funcionario");
                return;
            }
            System.out.println(funcionarioExist.toString());
            System.out.println("Funcionario listado con exito");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
//        obtenerFuncionarioss(funcionarioController);
//        obtenerFuncionarioId(funcionarioController);
//        crearFuncionario(funcionarioController);
        editarFuncionario(funcionarioController);
//        eliminarFuncionario(funcionarioController);

    }
}
