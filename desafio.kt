enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nomeUsuario: String, val nivel: Nivel)

data class ConteudoEducacional(var nomeConteudo: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    

    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {

    val usuario1 = Usuario("Felipe Silva", Nivel.INTERMEDIARIO)
    val usuario2 = Usuario("Joana Costa", Nivel.AVANCADO)
    

    val formacao1 = Formacao("FORMAÇÃO 1", listOf(
        ConteudoEducacional("LÓGICA DE PROGRAMAÇÃO ", 100),
        ConteudoEducacional("FUNDAMENTOS DA LINGUAGUEM KOTLIN", 80),
        ConteudoEducacional("CRIAÇÃO DE API REST EM KOTLIN", 40)
    ))
     val formacao2 = Formacao("FORMAÇÃO 2", listOf(
        ConteudoEducacional("ESTRUTURA ANDROID ", 50),
        ConteudoEducacional("CRIAÇÃO DE LAYOUTS DE APLICATIVOS ", 40),
        ConteudoEducacional("ESPECIALIZAÇÃO ANDROID", 60)
    ))

    
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)

    println("Usuário matriculados na formação 1:")
    formacao1.inscritos.forEach { print("Nome do usuario: " + it.nomeUsuario );
                                  println(", respectivo nivel: " + it.nivel)
                                  println("Materias: "+ formacao1)
                                  println()}
    
    println("Usuário matriculados na formação 2:")
    formacao2.inscritos.forEach { print("Nome do usuario: " + it.nomeUsuario );
                                  println(", respectivo nivel: " + it.nivel)
                                  println("Materias: "+ formacao2)}
}