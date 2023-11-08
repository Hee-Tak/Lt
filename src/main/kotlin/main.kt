fun main() {
    val lotto = Lotto()

    while(true){

    }
    val result = lotto.prizeNumber()


}

public fun oneSheet() : MutableList<Int> {
    val lotto = Lotto()
    var user : MutableList<Int>
    var choose : Int


    while(true){
        println("1:자동 \t 2:수동 \t 3:반자동")
        print("=> ")
        val temp_choose = readLine().toString().trim()
        try {
            choose = temp_choose.toInt()
            break
        } catch (e: NumberFormatException) {
            println("올바른 형식으로 숫자 하나를 입력하세요. (1, 2, 3)")
        }
    }

    while(true){
        when(choose){
            1 -> {
                println("<자동>")
                user = lotto.AutoLotto() //자동
                lotto.printLotto(user)
                break
            }


            2 -> {
                println("<수동>")
                user = lotto.manualLotto() //수동
                lotto.printLotto(user)
                break
            }


            3 -> {
                println("<반자동>")
                //반자동만들기
                break
            }

            else -> {
                choose = (1..3).random()
            }

        }
    }

    return user

}