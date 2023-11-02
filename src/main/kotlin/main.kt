fun main() {
    val lotto = Lotto()


    var user : List<Int>
    when((1..3).random()){
        1 -> {
            user = lotto.AutoLotto() //자동
        }


        2 -> {
            user = lotto.manualLotto() //수동
        }


        3 -> {
            //반자동만들기
        }

    }

    val result = lotto.prizeNumber()


}