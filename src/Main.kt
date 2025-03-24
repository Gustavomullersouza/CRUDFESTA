val expressaoRegular = Regex("[0-4]")

//Variavel Global
var convidado: Convidado = Convidado()
//Instancia de um lista mutavel vazia
var listaConvidados : MutableList<Convidado> = mutableListOf()
fun main() {
    menu()
}

private fun menu() {
    var opcao: Int
    do {
        println(
            "--- MENU ---\n" +
                    "1- CADASTRAR\n" +
                    "2- LISTAR\n" +
                    "3- EDITAR\n" +
                    "4- EXCLUIR\n" +
                    "0- SAIR"
        )

        opcao = readln().toInt()

       if (expressaoRegular.matches(opcao.toString())) {
           when (opcao.toInt()) {
               1 -> {
                   println("Cadastrando...")
                   cadastrar()
               }


               2 -> {
                   println("Listando...")
                   listar()
               }

               3 -> {
                   println("Editar...")
                   editar()
               }

               4 -> {
                   println("Excluindo...")
                   excluir()
               }

               0 -> println("Saindo...")
               else -> println("Opção inválida. Tente novamente.")
           }
       }else{
            println("\n\n\nOpção inválida")

        }
    } while (opcao != 0)
}


private fun cadastrar() {
    //Instância
    val convidado = Convidado()

    println("Qual é o seu nome?")
    //val nome = readln()
    convidado.nome = readln()

    println("Qual vai ser o presente?")
    //val presente = readln()
    convidado.presente = readln()

    println("Qual é sua retrição alimentar?")
    //val alimento = readln()
    convidado.alimento = readln()

    listaConvidados.add(convidado)
}

private fun listar() {
    var i = 0
    if (listaConvidados.isEmpty()) {
        println("Não há convidados")
    }else {
        listaConvidados.forEach { convidado ->
            println(
                "Posição: ${i++} " +
                        "Nome: ${convidado.nome}\n" +
                        "Presente: ${convidado.presente}\n" +
                        "Restrição: ${convidado.alimento}\n" +
                        "Vai ir na festa: ${convidado.presenca}"

            )
        }
    }
}

private fun editar(): Boolean{
    if (listaConvidados.isEmpty()){
        println("A lista está vazia")
        return false
    }
    listar()

    println("Digite a posição a ser editada")
    val posicao = readln().toInt()

    println("O convidado vai? S/N")
    val resposta = readln()
    when (resposta) {
        "S"->  listaConvidados[posicao].presenca = true
        "N"->  listaConvidados[posicao].presenca = false

    }
    return true
}

private fun excluir(): Boolean{
    if (listaConvidados.isEmpty()){
        println("A lista está vazia")
        return false
    }
    listar()

    println("Qual posição você deseja remover: ")
    val posicao = readln().toInt()
    listaConvidados.removeAt(posicao)

    print("Convidado exluido")
    return true
}