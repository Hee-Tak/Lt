fun main() {
    val lotto = Lotto()


    var user : List<Int>
    when((1..3).random()){
        1 -> {
            println("<자동>")
            user = lotto.AutoLotto() //자동
            lotto.printLotto(user)
        }


        2 -> {
            println("<수동>")
            user = lotto.manualLotto() //수동
            lotto.printLotto(user)
        }


        3 -> {
            println("<반자동>")
            //반자동만들기
        }

    }

    val result = lotto.prizeNumber()


}