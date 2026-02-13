import java.util.Scanner;

public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int opcion;

        do {
            System.out.println("\n MENU ");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio por ID");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    altaAlumno();
                    break;
                case 2:
                    buscarAlumno();
                    break;
                case 3:
                    actualizarPromedio();
                    break;
                case 4:
                    bajaLogica();
                    break;
                case 5:
                    listarActivos();
                    break;
                case 6:
                    reportes();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }


    static void altaAlumno() {

        int id;
        String nombre;
        double promedio;

        System.out.print("ID (>0): ");
        id = sc.nextInt();

        if (id <= 0) {
            System.out.println("ID inválido");
            return;
        }

        if (buscarPorIdGeneral(id) != -1) {
            System.out.println("ID repetido");
            return;
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("Nombre vacío");
            return;
        }

        System.out.print("Promedio (0-10): ");
        promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio inválido");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno registrado");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    static int buscarPorIdGeneral(int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    static void buscarAlumno() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        int pos = buscarPorIdGeneral(id);

        if (pos != -1 && alumnos[pos].activo) {
            System.out.println("ID: " + alumnos[pos].id);
            System.out.println("Nombre: " + alumnos[pos].nombre);
            System.out.println("Promedio: " + alumnos[pos].promedio);
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    static void actualizarPromedio() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscarPorIdGeneral(id);

        if (pos != -1 && alumnos[pos].activo) {
            System.out.print("Nuevo promedio (0-10): ");
            double nuevo = sc.nextDouble();

            if (nuevo >= 0 && nuevo <= 10) {
                alumnos[pos].promedio = nuevo;
                System.out.println("Promedio actualizado");
            } else {
                System.out.println("Promedio inválido");
            }
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    static void bajaLogica() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscarPorIdGeneral(id);

        if (pos != -1 && alumnos[pos].activo) {
            alumnos[pos].activo = false;
            System.out.println("Alumno dado de baja");
        } else {
            System.out.println("Alumno no encontrado o ya inactivo");
        }
    }

    static void listarActivos() {
        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                System.out.println("ID: " + a.id +
                        " | Nombre: " + a.nombre +
                        " | Promedio: " + a.promedio);
            }
        }
    }

    static void reportes() {

        double suma = 0;
        int contador = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int mayores8 = 0;

        for (Alumno a : alumnos) {
            if (a != null && a.activo) {

                suma += a.promedio;
                contador++;

                if (mayor == null || a.promedio > mayor.promedio) {
                    mayor = a;
                }

                if (menor == null || a.promedio < menor.promedio) {
                    menor = a;
                }

                if (a.promedio >= 8.0) {
                    mayores8++;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        System.out.println("Promedio general: " + (suma / contador));

        System.out.println("Mayor promedio:");
        System.out.println("ID: " + mayor.id +
                " Nombre: " + mayor.nombre +
                " Promedio: " + mayor.promedio);

        System.out.println("Menor promedio:");
        System.out.println("ID: " + menor.id +
                " Nombre: " + menor.nombre +
                " Promedio: " + menor.promedio);

        System.out.println("Alumnos con promedio >= 8: " + mayores8);
    }
}
