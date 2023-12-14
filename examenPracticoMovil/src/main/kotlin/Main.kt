//CREAR LA CLASE LIBRO
class Libro(val titulo: String, val autor: String, val anioPublicacion: Int) {
    var disponible: Boolean = true
}
//CREAR LA CLASE USUARIO
class Usuario(val nombre: String, val edad: Int) {
    val librosPrestados: MutableList<Libro> = mutableListOf()
}
//CREAR LA CLASE BIBLIOTRCA
class Biblioteca {
    val librosDisponibles: MutableList<Libro> = mutableListOf()
    val usuariosRegistrados: MutableList<Usuario> = mutableListOf()



    fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
    }

    fun agregarLibro(libro: Libro) {
        librosDisponibles.add(libro)
    }

    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.disponible) {
            libro.disponible = false
            usuario.librosPrestados.add(libro)
            println("${usuario.nombre} ha tomado prestado el libro '${libro.titulo}'.")
        } else {
            println("El libro '${libro.titulo}' no está disponible para préstamo.")
        }
    }

    fun mostrarLibrosDisponibles() {
        println("Libros disponibles en la biblioteca:")
        librosDisponibles.forEach {
            println("Título: ${it.titulo}, Autor: ${it.autor}, Año de Publicación: ${it.anioPublicacion}")
        }
    }

    fun mostrarUsuariosRegistrados() {
        println("Usuarios registrados en la biblioteca:")
        usuariosRegistrados.forEach {
            println("Nombre: ${it.nombre}, Edad: ${it.edad}")
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Registrar usuarios ecuatorianos
    val usuario1 = Usuario("Juan Pablo", 30)
    val usuario2 = Usuario("María Alejandra", 25)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    // Agregar libros locales al inventario
    val libro1 = Libro("Huasipungo", "Jorge Icaza", 1934)
    val libro2 = Libro("La Fiesta del Chivo", "Mario Vargas Llosa", 2000)
    val libro3 = Libro("Los Sangurimas", "José de la Cuadra", 1934)
    val libro4 = Libro("Danzantes de Levanto", "Demetrio Aguilera Malta", 1960)
    val libro5 = Libro("La Vorágine", "José Eustasio Rivera", 1924)

    biblioteca.agregarLibro(libro1)
    biblioteca.agregarLibro(libro2)
    biblioteca.agregarLibro(libro3)
    biblioteca.agregarLibro(libro4)
    biblioteca.agregarLibro(libro5)

    // Prestar libros a diferentes usuarios ecuatorianos
    biblioteca.prestarLibro(libro1, usuario1)
    biblioteca.prestarLibro(libro3, usuario2)

    // Mostrar información
    biblioteca.mostrarLibrosDisponibles()
    biblioteca.mostrarUsuariosRegistrados()
}

