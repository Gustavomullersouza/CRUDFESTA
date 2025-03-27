val expressaoRegular = Regex("[0-5]")

//Variavel Global
//Instancia de um lista mutavel vazia
var listaConvidados : MutableList<Convidado> = mutableListOf<Convidado>()
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
                    "5- BUSCA\n" +
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
               5 ->{
                   println("Sair...")
                   busca()
               }

               0 -> println("Saindo...")
               else -> println("Opção inválida. Tente novamente.")
           }
       }else{
            println("\n\n\nOpção inválida")

        }
    } while (opcao != 0)
}

//Questão 1 -  Valida para que o usuario comente digite LETRAS
//para escrever o nome
private fun cadastrar() {
    //Instância
    val convidado = Convidado()

    println("Qual é o seu nome?")
    //val nome = readln()
    convidado.nome = readln()//Questão 1

    println("Qual vai ser o presente?")
    //val presente = readln()
    convidado.presente = readln()

    println("Qual é sua retrição alimentar?")
    //val alimento = readln()
    convidado.alimento = readln()

    listaConvidados.add(convidado)
}

private fun listar(): String {
    var i = 0
    if (validar()) {
        listaConvidados.forEach { convidado ->

            println(
                "Posição: ${i++} " +
                        "Nome: ${convidado.nome}\n" +
                        "Presente: ${convidado.presente}\n" +
                        "Restrição: ${convidado.alimento}\n" +
                        "Vai ir na festa: ${convidado.presenca}"

            )// FIM DO PRINT
        } // FIM DO FOREACH
    }//FIM DO IF
    return "Listagem foi um sucesso"// esse é o meu retorna da função
}//FIM DA FUNÇÃO LISTAR
/* QUESTÃO 2 - Validar para que a variavel posição seja sempre numérica
 e a variavel seja*/
private fun editar(): Boolean{
    if (validar()){
        listar()

        println("Digite a posição a ser editada")
        val posicao = readln().toInt()

        println("O convidado vai? S/N")
        val resposta = readln()
        when (resposta) {
            "S" -> listaConvidados[posicao].presenca = true
            "N" -> listaConvidados[posicao].presenca = false
        }// FIM DO WHEN
    }// FIM DO IF
    return true
}// FIM DO PRIVATE
/* questão 3 - validAR PARA QUE A VARIAVEL POSIÇÃO SEJA SEMPRE NUMÉRICA*/
private fun excluir(): Boolean{
    if (listaConvidados.isEmpty()){
        listar()

        println("Qual posição você deseja remover: ")
        val posicao = readln().toInt()
        listaConvidados.removeAt(posicao)

        print("Convidado exluido")

    }//FIM DO IF
    return true
}// FIM DO EXCLUIR

/* QUESTÃO 4 - VALIDAR PARA QUE A VARIAVEL BUSCA SEJA SEMPRE
* alfabetica, ignora letras maiusculas e minusculas */
private fun busca(){
    var i = 0 // indice da lista
    println("Digite o nome da pessoa que você busca: ")
    val busca = readln()
    listaConvidados.forEach{ convidado ->
        // O contains busca por uma string dentro de um outra string
        if (convidado.nome.contains(busca)){
            println("posição: $i, nome: ${convidado.nome}")
        }
        i++
    }
}

private fun validar() : Boolean{
    if (listaConvidados.isEmpty()){
        println("Lista vazia! Finalizando...")
        return false
    }
    return true
}